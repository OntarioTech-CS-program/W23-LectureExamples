let canvas, context; 
let hero;
let heroSpritesheet = new Image();
heroSpritesheet.src = "images/heroSpritesheet.png";   //provide the path to the image

window.onload = function() {
    canvas = document.getElementById("myCanvas");
    context = canvas.getContext("2d");
	
	
	//TODO: create the hero GameObject 
	hero = new GameObject(heroSpritesheet,  //the spritesheet image
                              0,            //x position of hero
                              0,            //y position of hero
                              1536,         //total width of spritesheet image in pixels
                              256,          //total height of spritesheet image in pixels
                              90,           //time(in ms) duration between each frame change (experiment with it to get faster or slower animation)
                              6);           //number of sprites in the spritesheet

	// call the game loop
	loop();
}

//The Game Loop
function loop() {
    update();
    draw();
	//https://developer.mozilla.org/en-US/docs/Web/API/window/requestAnimationFrame
    requestAnimationFrame(loop);
}

//update function to update all the GameObjects
function update() {
	hero.update();
}

//draw method for drawing everything on canvas
function draw() {
	context.clearRect(0,0,canvas.width, canvas.height);
	hero.draw(context);
}


function GameObject(spritesheet, x, y, width, height, timePerFrame, numberOfFrames) {
    this.spritesheet = spritesheet;             //the spritesheet image
    this.x = x;                                 //the x coordinate of the object
    this.y = y;                                 //the y coordinate of the object
    this.width = width;                         //width of spritesheet
    this.height = height;                       //height of spritesheet
    this.timePerFrame = timePerFrame;           //time in(ms) given to each frame
    this.numberOfFrames = numberOfFrames || 1;  //number of frames(sprites) in the spritesheet, default 1

    //current frame index pointer
    this.frameIndex = 0;

    //time the frame index was last updated
    this.lastUpdate = Date.now();

    //to update
    this.update = function() {
       // TODO: update the frameIndex after the it has elapsed more time than the timePerFrame
	   if (Date.now() - this.lastUpdate >= this.timePerFrame){
		   this.frameIndex++;
		   if(this.frameIndex >= this.numberOfFrames){
			   this.frameIndex = 0;
		   }
		   this.lastUpdate = Date.now();
	   }
	   
	   
    }

    //to draw on the canvas, parameter is the context of the canvas to be drawn on
    this.draw = function(context) {
		//https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/drawImage
        context.drawImage(this.spritesheet,                               //The image to be drawn
                          this.frameIndex*this.width/this.numberOfFrames, //The x coordinate where to start clipping
                          0,                                              //The y coordinate where to start clipping
                          this.width/this.numberOfFrames,                 //The width of image to be draw(clipping)
                          this.height,                                    //The height of image to be draw(clipping)
                          x,                                              //The x coordinate on the canvas where the image to be drawn
                          y,                                              //The y coordinate on the canvas where the image to be drawn
                          this.width/this.numberOfFrames,                 //The width of the image(resizing it)
                          this.height);                                   //The height of the image(resizing it)
    }
}

//Credit to https://mr-easy.github.io/2017-06-26-creating-spritesheet-animation-in-html5-canvas-using-javascript/