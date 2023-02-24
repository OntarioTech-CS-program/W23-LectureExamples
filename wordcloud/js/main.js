// let words = {"wordlist":[['foo', 120], ['bar', 60]]};
// WordCloud(document.getElementById('canvas'), { list: words["wordlist"] } );


function requestData(callURL){
  fetch(callURL, {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
    },
  })
    .then(response => response.json())
    .then(response => processDataToList(response))
    .catch(error => {
      console.log(error)
    });;
}


function processDataToList(data){
// function will convert the json dictionary obj into a list
  let dataList = []
  Object.keys(data).forEach(function(key) {
    if (data[key]>2 && data[key]<250){
      let elem = [key, data[key]]
      dataList.push(elem);
    }
  });
// the wordcloud library expects a list, not json or dictionary
  let canvas = document.getElementById('canvas');
  WordCloud(canvas, { list: dataList, weightFactor: 4} );

}

(function () {
  let apiCallURL = "http://localhost:8080/ParsingFiles-1.0-SNAPSHOT/api/read/book";
  requestData(apiCallURL);


})();

function postData(url, data){
  fetch(url, {
    mode: 'no-cors', //not recommended in "real" life
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'text/plain'
    },
    body:data
  })
    .then(response => console.log(response))
    .catch(error => {
      console.log(error)
    });
}

function saveFile(){
  let postURL = "http://localhost:8080/ParsingFiles-1.0-SNAPSHOT/api/read/save";
  let content = document.getElementById('data');
  let title = document.getElementById('name');
  let myData = {"title": title.value, "content": content.value};
  // posting to the server
  postData(postURL, JSON.stringify(myData));
}
