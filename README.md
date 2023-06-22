# tawagh
Java based API - tested with postman tests methods as follow:
```diff
+ 1. Post requests

* Metoda: POST
* Adres zasobu: "http://127.0.0.1:8080/api/studies"
* Nagłówki: Content-Type: application/json

a) {
    "Nazwa": "Metodologie obiektowe",
    "ECTS": 2,
    "Sala": 216,
    "Egzamin": "tak"
}

b) {
    "Nazwa": "Testowanie oprogramowania",
    "ECTS": 1,
    "Sala": 216,
    "Egzamin": "nie"
}

c) {
    "Nazwa": "Technologie i aplikacje webowe",
    "ECTS": 3,
    "Sala": 208,
    "Egzamin": "nie"
}

d) {
    "Nazwa": "Zarządzanie projektem informatycznym",
    "ECTS": 2,
    "Sala": 216,
    "Egzamin": "nie"
}

e) {
    "Nazwa": "Zaawansowane technologie bazodanowe",
    "ECTS": 3,
    "Sala": 208,
    "Egzamin": "nie"
}

f) {
    "Nazwa": "Technologie komponentowe i sieciowe",
    "ECTS": 2,
    "Sala": 208,
    "Egzamin": "tak"
}

! Each method tested with following requirements:

pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});
```
```diff
+ 2. Get_all

* Metoda: GET
* Adres zasobu: "http://127.0.0.1:8080/api/studies"
* Nagłówki: Content-Type: application/json

response

[
    {
        "id": 1,
        "Nazwa": "Metodologie obiektowe",
        "ECTS": 2,
        "Sala": 216,
        "Egzamin": "tak"
    },
    {
        "id": 2,
        "Nazwa": "Testowanie oprogramowania",
        "ECTS": 1,
        "Sala": 216,
        "Egzamin": "nie"
    },
    {
        "id": 3,
        "Nazwa": "Technologie i aplikacje webowe",
        "ECTS": 3,
        "Sala": 208,
        "Egzamin": "nie"
    },
    {
        "id": 4,
        "Nazwa": "Zarządzanie projektem informatycznym",
        "ECTS": 2,
        "Sala": 216,
        "Egzamin": "nie"
    },
    {
        "id": 5,
        "Nazwa": "Zaawansowane technologie bazodanowe",
        "ECTS": 3,
        "Sala": 208,
        "Egzamin": "nie"
    },
    {
        "id": 6,
        "Nazwa": "Technologie komponentowe i sieciowe",
        "ECTS": 2,
        "Sala": 208,
        "Egzamin": "tak"
    }
]

! Method tested with following requirements:

pm.test("Status code is 200", () => {
  pm.expect(pm.response.code).to.eql(200);
});
    const responseJson = pm.response.json();
pm.test("The response has all/correct properties", () => {
    pm.expect(responseJson).to.be.an("array")
    for (i = 0; i < responseJson.count(); i++)
    {
        pm.expect(responseJson[i].id).to.be.a("number");
        pm.expect(responseJson[i].Nazwa).to.be.a("string");
        pm.expect(responseJson[i].ECTS).to.be.a("number");
        pm.expect(responseJson[i].Sala).to.be.a("number");
        pm.expect(responseJson[i].Egzamin).to.be.a("string")
    }
});
```
```diff
+ 3. Get_All_With_Exam

* Metoda: GET
* Adres zasobu: "http://127.0.0.1:8080/api/studies?exam=tak
* Nagłówki: Content-Type: application/json

response

[
    {
        "id": 1,
        "Nazwa": "Metodologie obiektowe",
        "ECTS": 2,
        "Sala": 216,
        "Egzamin": "tak"
    },
    {
        "id": 6,
        "Nazwa": "Technologie komponentowe i sieciowe",
        "ECTS": 2,
        "Sala": 208,
        "Egzamin": "tak"
    }
]

! Method tested with following requirements:

pm.test("Status code is 200", () => {
  pm.expect(pm.response.code).to.eql(200);
});
    const responseJson = pm.response.json();
pm.test("The response has all/correct properties", () => {
    pm.expect(responseJson).to.be.an("array")
    for (i = 0; i < responseJson.count(); i++)
    {
        pm.expect(responseJson[i].id).to.be.a("number");
        pm.expect(responseJson[i].Nazwa).to.be.a("string");
        pm.expect(responseJson[i].ECTS).to.be.a("number");
        pm.expect(responseJson[i].Sala).to.be.a("number");
        pm.expect(responseJson[i].Egzamin).to.eql("tak");
    }
});
```
```diff
+ 4. Get_All_With_Class_216

* Metoda: GET
* Adres zasobu: "http://127.0.0.1:8080/api/studies?class=216
* Nagłówki: Content-Type: application/json

response

[
    {
        "id": 1,
        "Nazwa": "Metodologie obiektowe",
        "ECTS": 2,
        "Sala": 216,
        "Egzamin": "tak"
    },
    {
        "id": 2,
        "Nazwa": "Testowanie oprogramowania",
        "ECTS": 1,
        "Sala": 216,
        "Egzamin": "nie"
    },
    {
        "id": 4,
        "Nazwa": "Zarządzanie projektem informatycznym",
        "ECTS": 2,
        "Sala": 216,
        "Egzamin": "nie"
    }
]

! Method tested with following requirements:

pm.test("Status code is 200", () => {
  pm.expect(pm.response.code).to.eql(200);
});
    const responseJson = pm.response.json();
pm.test("The response has all/correct properties", () => {
    pm.expect(responseJson).to.be.an("array")
    for (i = 0; i < responseJson.count(); i++)
    {
        pm.expect(responseJson[i].id).to.be.a("number");
        pm.expect(responseJson[i].Nazwa).to.be.a("string");
        pm.expect(responseJson[i].ECTS).to.be.a("number");
        pm.expect(responseJson[i].Sala).to.eql(216);
        pm.expect(responseJson[i].Egzamin).to.be.a("string");
    }
});
```
```diff
+ 5. Get_All_With_Class208_NoExam

* Metoda: GET
* Adres zasobu: "http://127.0.0.1:8080/api/studies?class=208&exam=nie
* Nagłówki: Content-Type: application/json

response

[
    {
        "id": 3,
        "Nazwa": "Technologie i aplikacje webowe",
        "ECTS": 3,
        "Sala": 208,
        "Egzamin": "nie"
    },
    {
        "id": 5,
        "Nazwa": "Zaawansowane technologie bazodanowe",
        "ECTS": 3,
        "Sala": 208,
        "Egzamin": "nie"
    }
]

! Method tested with following requirements:

pm.test("Status code is 200", () => {
  pm.expect(pm.response.code).to.eql(200);
});
    const responseJson = pm.response.json();
pm.test("The response has all/correct properties", () => {
    pm.expect(responseJson).to.be.an("array")
    for (i = 0; i < responseJson.count(); i++)
    {
        pm.expect(responseJson[i].id).to.be.a("number");
        pm.expect(responseJson[i].Nazwa).to.be.a("string");
        pm.expect(responseJson[i].ECTS).to.be.a("number");
        pm.expect(responseJson[i].Sala).to.eql(208);
        pm.expect(responseJson[i].Egzamin).to.eql("nie");
    }
});
```
```diff
+ 6. Get_Id_3

* Metoda: GET
* Adres zasobu: "http://127.0.0.1:8080/api/studies/3
* Nagłówki: Content-Type: application/json

response

{
    "id": 3,
    "Nazwa": "Technologie i aplikacje webowe",
    "ECTS": 3,
    "Sala": 208,
    "Egzamin": "nie"
}

! Method tested with following requirements:

pm.test("Status code is 200", () => {
  pm.expect(pm.response.code).to.eql(200);
});
pm.test("The response has all/correct properties", () => {
    const responseJson = pm.response.json();
    pm.expect(responseJson).to.be.an("object")
    pm.expect(responseJson.id).to.eql(3);
    pm.expect(responseJson.Nazwa).to.be.a("string");
    pm.expect(responseJson.ECTS).to.be.a("number");
    pm.expect(responseJson.Sala).to.be.a("number");
    pm.expect(responseJson.Egzamin).to.be.a("string");

});
```
```diff
+ 7. Get_Id_15

* Metoda: GET
* Adres zasobu: "http://127.0.0.1:8080/api/studies/15
* Nagłówki: Content-Type: application/json

empty response

! Method tested with following requirements:

pm.test("Status code is 404", () => {
  pm.expect(pm.response.code).to.eql(404);
});
```
```diff
+ 8. Delete_Id_2

* Metoda: DELETE
* Adres zasobu: "http://127.0.0.1:8080/api/studies/2
* Nagłówki: Content-Type: application/json

no response

! Method tested with following requirements:

pm.test("Status code is 204", () => {
  pm.expect(pm.response.code).to.eql(204);
});
```
```diff
+ 9. Get_All

* Metoda: GET
* Adres zasobu: "http://127.0.0.1:8080/api/studies
* Nagłówki: Content-Type: application/json

response

[
    {
        "id": 1,
        "Nazwa": "Metodologie obiektowe",
        "ECTS": 2,
        "Sala": 216,
        "Egzamin": "tak"
    },
    {
        "id": 3,
        "Nazwa": "Technologie i aplikacje webowe",
        "ECTS": 3,
        "Sala": 208,
        "Egzamin": "nie"
    },
    {
        "id": 4,
        "Nazwa": "Zarządzanie projektem informatycznym",
        "ECTS": 2,
        "Sala": 216,
        "Egzamin": "nie"
    },
    {
        "id": 5,
        "Nazwa": "Zaawansowane technologie bazodanowe",
        "ECTS": 3,
        "Sala": 208,
        "Egzamin": "nie"
    },
    {
        "id": 6,
        "Nazwa": "Technologie komponentowe i sieciowe",
        "ECTS": 2,
        "Sala": 208,
        "Egzamin": "tak"
    }
]

! Method tested with following requirements:

pm.test("Status code is 200", () => {
  pm.expect(pm.response.code).to.eql(200);
});
    const responseJson = pm.response.json();
pm.test("The response has all/correct properties", () => {
    pm.expect(responseJson).to.be.an("array")
    for (i = 0; i < responseJson.count(); i++)
    {
        pm.expect(responseJson[i].id).to.be.a("number");
        pm.expect(responseJson[i].Nazwa).to.be.a("string");
        pm.expect(responseJson[i].ECTS).to.be.a("number");
        pm.expect(responseJson[i].Sala).to.be.a("number");
        pm.expect(responseJson[i].Egzamin).to.be.a("string")
    }
});
```
```diff
+ 10. Delete_All

* Metoda: DELETE
* Adres zasobu: "http://127.0.0.1:8080/api/studies
* Nagłówki: Content-Type: application/json

no response

! Method tested with following requirements:

pm.test("Status code is 200", () => {
  pm.expect(pm.response.code).to.eql(200);
});
```
```diff
+ 11. Get_All

* Metoda: GET
* Adres zasobu: "http://127.0.0.1:8080/api/studies
* Nagłówki: Content-Type: application/json

response

[]

! Method tested with following requirements:

pm.test("Status code is 200", () => {
  pm.expect(pm.response.code).to.eql(200);
});
    const responseJson = pm.response.json();
pm.test("The response has all/correct properties", () => {
    pm.expect(responseJson).to.be.empty
});
```


Test results:

<img width="729" alt="Zrzut ekranu 2023-06-22 o 20 34 32" src="https://github.com/TKtjpk/tawagh/assets/80661109/dafe9b68-7017-4c46-8703-1399bf005b99">

Test report:
```
{
	"id": "421f9a9c-9923-49b9-b6c4-0c3ebee362fa",
	"name": "Post_Requests",
	"timestamp": "2023-06-22T18:22:32.147Z",
	"collection_id": "27652533-703e5dbe-a1a8-4068-af20-cd58ec1f7c6d",
	"folder_id": 0,
	"environment_id": "0",
	"totalPass": 23,
	"delay": 0,
	"persist": true,
	"status": "finished",
	"startedAt": "2023-06-22T18:22:30.413Z",
	"totalFail": 0,
	"results": [
		{
			"id": "1974b533-1e31-41f5-91d2-5ef3fec38287",
			"name": "Post_Request_1",
			"url": "http://127.0.0.1:8080/api/studies",
			"time": 161,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				161
			],
			"allTests": [
				{
					"Status code is 200": true
				}
			]
		},
		{
			"id": "56c369aa-eeb2-432b-b0fc-f070d327ecf0",
			"name": "Post_Request_2",
			"url": "http://127.0.0.1:8080/api/studies",
			"time": 5,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				5
			],
			"allTests": [
				{
					"Status code is 200": true
				}
			]
		},
		{
			"id": "0e005615-830d-4679-bfeb-48cbc2dbd6e6",
			"name": "Post_Request_3",
			"url": "http://127.0.0.1:8080/api/studies",
			"time": 4,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				4
			],
			"allTests": [
				{
					"Status code is 200": true
				}
			]
		},
		{
			"id": "1755ce82-8200-401c-af00-8db26dfdd24e",
			"name": "Post_Request_4",
			"url": "http://127.0.0.1:8080/api/studies",
			"time": 4,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				4
			],
			"allTests": [
				{
					"Status code is 200": true
				}
			]
		},
		{
			"id": "ffb69156-d27c-4e7a-85a1-57dc528d490c",
			"name": "Post_Request_5",
			"url": "http://127.0.0.1:8080/api/studies",
			"time": 4,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				4
			],
			"allTests": [
				{
					"Status code is 200": true
				}
			]
		},
		{
			"id": "ac38fb56-250b-44d4-a26c-5db3baf80c0b",
			"name": "Post_Request_6",
			"url": "http://127.0.0.1:8080/api/studies",
			"time": 4,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				4
			],
			"allTests": [
				{
					"Status code is 200": true
				}
			]
		},
		{
			"id": "6dd35eaa-7fab-4bd0-a23c-e796d34fd231",
			"name": "Get_All",
			"url": "http://127.0.0.1:8080/api/studies",
			"time": 20,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true,
				"The response has all/correct properties": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				},
				"The response has all/correct properties": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				20
			],
			"allTests": [
				{
					"Status code is 200": true,
					"The response has all/correct properties": true
				}
			]
		},
		{
			"id": "4ebf4d91-7aa3-4490-ada9-b0e4b8478bef",
			"name": "Get_All_With_Exam",
			"url": "http://127.0.0.1:8080/api/studies?exam=tak",
			"time": 4,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true,
				"The response has all/correct properties": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				},
				"The response has all/correct properties": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				4
			],
			"allTests": [
				{
					"Status code is 200": true,
					"The response has all/correct properties": true
				}
			]
		},
		{
			"id": "e959b8bb-31b5-4cb7-b7dc-646b802e4179",
			"name": "Get_All_With_Class_216",
			"url": "http://127.0.0.1:8080/api/studies?class=216",
			"time": 5,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true,
				"The response has all/correct properties": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				},
				"The response has all/correct properties": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				5
			],
			"allTests": [
				{
					"Status code is 200": true,
					"The response has all/correct properties": true
				}
			]
		},
		{
			"id": "4cb9820f-8121-400b-a5c0-b23a9ba67089",
			"name": "Get_All_With_Class_208_NoExam",
			"url": "http://127.0.0.1:8080/api/studies?class=216",
			"time": 4,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true,
				"The response has all/correct properties": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				},
				"The response has all/correct properties": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				4
			],
			"allTests": [
				{
					"Status code is 200": true,
					"The response has all/correct properties": true
				}
			]
		},
		{
			"id": "66652bf9-3dfa-40b2-b617-866596d755eb",
			"name": "Get_Id_3",
			"url": "http://127.0.0.1:8080/api/studies/3",
			"time": 6,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true,
				"The response has all/correct properties": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				},
				"The response has all/correct properties": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				6
			],
			"allTests": [
				{
					"Status code is 200": true,
					"The response has all/correct properties": true
				}
			]
		},
		{
			"id": "167fbb87-de61-4555-a9cf-72c200903a15",
			"name": "Get_Id_15",
			"url": "http://127.0.0.1:8080/api/studies/15",
			"time": 4,
			"responseCode": {
				"code": 404,
				"name": "Not Found"
			},
			"tests": {
				"Status code is 404": true
			},
			"testPassFailCounts": {
				"Status code is 404": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				4
			],
			"allTests": [
				{
					"Status code is 404": true
				}
			]
		},
		{
			"id": "c2f8373a-f110-4608-aadf-4e21690818a9",
			"name": "Delete_Id_2",
			"url": "http://127.0.0.1:8080/api/studies/2",
			"time": 4,
			"responseCode": {
				"code": 204,
				"name": "No Content"
			},
			"tests": {
				"Status code is 204": true
			},
			"testPassFailCounts": {
				"Status code is 204": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				4
			],
			"allTests": [
				{
					"Status code is 204": true
				}
			]
		},
		{
			"id": "ec116ee2-0cfd-4cad-9d87-8504d3606631",
			"name": "Get_All Copy",
			"url": "http://127.0.0.1:8080/api/studies",
			"time": 4,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true,
				"The response has all/correct properties": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				},
				"The response has all/correct properties": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				4
			],
			"allTests": [
				{
					"Status code is 200": true,
					"The response has all/correct properties": true
				}
			]
		},
		{
			"id": "8889a521-16d6-42fb-87d0-aedcbcb3c87b",
			"name": "Delete_All",
			"url": "http://127.0.0.1:8080/api/studies",
			"time": 3,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				3
			],
			"allTests": [
				{
					"Status code is 200": true
				}
			]
		},
		{
			"id": "ae4e78b3-0b1b-44a8-9dfa-af8a5d95428c",
			"name": "Get_All Copy 2",
			"url": "http://127.0.0.1:8080/api/studies",
			"time": 5,
			"responseCode": {
				"code": 200,
				"name": "OK"
			},
			"tests": {
				"Status code is 200": true,
				"The response has all/correct properties": true
			},
			"testPassFailCounts": {
				"Status code is 200": {
					"pass": 1,
					"fail": 0
				},
				"The response has all/correct properties": {
					"pass": 1,
					"fail": 0
				}
			},
			"times": [
				5
			],
			"allTests": [
				{
					"Status code is 200": true,
					"The response has all/correct properties": true
				}
			]
		}
	],
	"count": 1,
	"totalTime": 241,
	"collection": {
		"requests": [
			{
				"id": "1974b533-1e31-41f5-91d2-5ef3fec38287",
				"method": "POST"
			},
			{
				"id": "56c369aa-eeb2-432b-b0fc-f070d327ecf0",
				"method": "POST"
			},
			{
				"id": "0e005615-830d-4679-bfeb-48cbc2dbd6e6",
				"method": "POST"
			},
			{
				"id": "1755ce82-8200-401c-af00-8db26dfdd24e",
				"method": "POST"
			},
			{
				"id": "ffb69156-d27c-4e7a-85a1-57dc528d490c",
				"method": "POST"
			},
			{
				"id": "ac38fb56-250b-44d4-a26c-5db3baf80c0b",
				"method": "POST"
			},
			{
				"id": "6dd35eaa-7fab-4bd0-a23c-e796d34fd231",
				"method": "GET"
			},
			{
				"id": "4ebf4d91-7aa3-4490-ada9-b0e4b8478bef",
				"method": "GET"
			},
			{
				"id": "e959b8bb-31b5-4cb7-b7dc-646b802e4179",
				"method": "GET"
			},
			{
				"id": "4cb9820f-8121-400b-a5c0-b23a9ba67089",
				"method": "GET"
			},
			{
				"id": "66652bf9-3dfa-40b2-b617-866596d755eb",
				"method": "GET"
			},
			{
				"id": "167fbb87-de61-4555-a9cf-72c200903a15",
				"method": "GET"
			},
			{
				"id": "c2f8373a-f110-4608-aadf-4e21690818a9",
				"method": "DELETE"
			},
			{
				"id": "ec116ee2-0cfd-4cad-9d87-8504d3606631",
				"method": "GET"
			},
			{
				"id": "8889a521-16d6-42fb-87d0-aedcbcb3c87b",
				"method": "DELETE"
			},
			{
				"id": "ae4e78b3-0b1b-44a8-9dfa-af8a5d95428c",
				"method": "GET"
			}
		]
	}
}
```
