# spring-zoo-api

# Task

fix existed code and create a zoo API. <br>
98% of the project code was composed and performed by Artem Ivanov.<br>
I was not sure if I need to upload it to my GitHub but I spent about 3-4 days doing this project.<br>
Therefore, I think it deserves to be on my profile. <br>

---

# Step 0 (Documentation)

Please open this readme on GitHub or in any markdown previewer (i.e. https://markdownlivepreview.com/). So, you can see dropdowns and highlights.



## **Tigers**
<details>
<summary> Tiger API </summary>

**GET** `/animals/tigers` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** none <br>

Returns a list with all the tigers.<br>
`zoo_id= -1` indicates that these tigers are not assigned to any zoo.<br>

**Example request:** `GET /animals/tigers` <br>

**Example Response**:
```json
[
	{
		"id": 1,
		"name": "Init Tiger",
		"zoo_id": -1
	},
	{
		"id": 2,
		"name": "Mister Jokin",
		"zoo_id": -1
	}
]
```

**GET** `/animals/search-tiger` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `id` parameter <br>

Return a tiger by a specific id.<br>

**Example request:** `GET /animals/search-tiger?id=1` <br>


**Example Response**:
```json
{
	"id": 2,
	"name": "Mister Jokin",
	"zoo_id": -1
}
```


**POST** `/animals/create-tiger` <br>
--
**Expected code:** 201<br>
**Required parameters or body:** `TigerRequest` <br>

Creates a new tiger.

**Example request:** `POST /animals/search-tiger?id=1` <br>

```json
{
	"id": "3",
	"name": "Maestro Tiger"
}
```

**Example Response**:
```json 
Tiger was successfully created
```

**DELETE** `/animals/delete-tiger` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `id` parameter <br>

Delete a tiger by a specific id.<br>

**Example request:** `DELETE /animals/delete-tiger?id=1` <br>

**Example Response**:
```json
Tiger was successfully deleted
```


**PUT** `/animals/update-tiger` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `TigerRequest`  <br>

Uodate tiger innformation with new TigerRequest<br>

**Example request:** `PUT /animals/update-tiger?id=1` <br>

```json
{
	"id": "3",
	"name": "Mario Tigrio"
}
```

**Example Response**:
```json 
Tiger was successfully updated
```
</details>





## **Elephants**
<details>
<summary>Elephant api</summary>

**POST** `/animals/create-elephant` <br>
--
**Expected code:** 201<br>
**Required parameters or body:** `ElephantRequest` <br>

Creates a new elephant.<br>

**Example request:** `POST /animals/create-elephant` <br>

```json
{
	"id": "1",
	"name": "Dumbo Last", 
	"elephantAge": "2"
}
```


**Example Response**:
```json
Elephant was successfully created
```

**GET** `/animals/elephants` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** none<br>

Returns a list of all elephants<br>

**Example request:** `POST /animals/elephants` <br>


**Example Response**:
```json
[
	{
		"id": 1,
		"elephantName": "Dumbo",
		"elephantSurname": "Last",
		"name": "Dumbo Last",
		"elephantAge": 2.0,
		"zoo_id": -1
	},
	{
		"id": 2,
		"elephantName": "Gumbo",
		"elephantSurname": "Jumbo",
		"name": "Gumbo Jumbo",
		"elephantAge": 6.0,
		"zoo_id": -1
	}
]
```


**GET** `/animals/search-elephant` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `name` parameter<br>

Returns a list of all elephants with the same `name` parameter<br>
We can have multiple elephants because we didn't assigned a name being unique.<br>

**Example request:** `GET /animals/search-elephant?name=Gumbo Jumbo` <br>


**Example Response**:
```json
[
	{
		"id": 2,
		"elephantName": "Gumbo",
		"elephantSurname": "Jumbo",
		"name": "Gumbo Jumbo",
		"elephantAge": 6.0,
		"zoo_id": -1
	},
	{
		"id": 3,
		"elephantName": "Gumbo",
		"elephantSurname": "Jumbo",
		"name": "Gumbo Jumbo",
		"elephantAge": 3.0,
		"zoo_id": -1
	}
]
```

**GET** `/animals/get-elephant` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `id` parameter<br>

Search for a precise elephant by id.

**Example request:** `GET /animals/get-elephant?id=1` <br>


**Example Response**:
```json
{
	"id": 1,
	"elephantName": "Dumbo",
	"elephantSurname": "Last",
	"name": "Dumbo Last",
	"elephantAge": 2.0,
	"zoo_id": -1
}
```

**GET** `/animals/get-elephant-age-h` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `id` parameter<br>

Get elephant age in hours.

**Example request:** `GET /animals/get-elephant-age-h?id=1` <br>


**Example Response**:
```json
Elephant with id: 1 is alive for 17532.0 hours
```


**DELETE** `/animals/delete-elephant` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `id` parameter<br>

Delete an elephant by id.

**Example request:** `DELETE /animals/delete-elephant?id=3` <br>


**Example Response**:
```json
Elephant was successfully deleted
```

**PUT** `/animals/update-elephant` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `ElephantRequest` request<br>

Update an elephant by ElephantRequest.

**Example request:** `PUT /animals/update-elephant?id=2` <br>
```json
{
	"id": "2",
	"name": "Gumbo Loon", 
	"elephantAge": "2"
}
```


**Example Response**:
```json
Elephant was successfully updated
```
</details>





## **Giraffes**
<details>
<summary>Giraffe api</summary>

**POST** `/animals/create-giraffe` <br>
--
**Expected code:** 201<br>
**Required parameters or body:** `GiraffeRequest` <br>

Creates a new giraffe.<br>

**Example request:** `POST /animals/create-giraffe` <br>

```json
{
    "id": "1",
    "name": "Gira Mool",
	"secret": "All giraffes can hold a secrete"
}
```

**Example Response**:
```json
Giraffe was successfully created
```


**GET** `/animals/get-giraffe` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `id` parameter <br>

Get a precise giraffe by an id.<br>
Secrete will be encrypted.<br>

**Example request:** `GET /animals/get-giraffe?id=1` <br>

**Example Response**:
```json
{
	"id": 1,
	"name": "Gira Mool",
	"secret": "@kkfhq`eedrb`mgnkc`rdbqdsd",
	"zoo_id": -1
}
```

**GET** `/animals/giraffe-secret` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `id` parameter, `passcode` parameter <br>

Get a giraffe with decrypted secrete by providing id and passcode.<br>

**Example request:** `GET /animals/giraffe-secret?id=1&passcode=qwerty123` <br>

**Example Response**:
```json
{
	"id": 1,
	"name": "Gira Mool",
	"secret": "All giraffes can hold a secrete",
	"zoo_id": -1
}
```


**GET** `/animals/search-giraffe` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `name` parameter<br>

Returns a list of all giraffes with the same `name` parameter<br>
We can have multiple giraffes because we didn't assigned a name being unique.<br>

**Example request:** `GET /animals/search-giraffe?name=Gira Mool` <br>


**Example Response**:
```json
[
	{
		"id": 1,
		"name": "Gira Mool",
		"secret": "@kkfhq`eedrb`mgnkc`rdbqdsd",
		"zoo_id": -1
	}
]
```

**DELETE** `/animals/delete-giraffe` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `id` parameter<br>

Delete giraffe by id.

**Example request:** `DELETE /animals/delete-giraffe?id=1` <br>


**Example Response**:
```json
Giraffe was successfully deleted
```

**PUT** `/animals/update-giraffe` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `passcode` parameter, `GiraffeRequest`<br>

Update giraffe with new information.<br>
Since, we have an encripted field, it's good to also request passcode.<br>


**Example request:** `PUT /animals/update-giraffe?passcode=qwerty123` <br>

```json
{
    "id": "2",
    "name": "Gira Mool",
	"secret": "All giraffes can hold a secrete"
}
```

**Example Response**:
```json
{
	"id": 2,
	"name": "Gira Mool",
	"secret": "@kkfhq`eedrb`mgnkc`rdbqdsd",
	"zoo_id": -1
}
```

</details>

## **Zoo**
<details>
<summary>Zoo api</summary>

**POST** `/zoo/create-zoo` <br>
--
**Expected code:** 201<br>
**Required parameters or body:** `ZooRequest` <br>

Creates a new zoo.<br>

**Example request:** `POST /zoo/create-zoo` <br>

```json
{
	"id": "1",
    "name": "Brussels Zoo"
}
```

**Example Response**:
```json
Zoo was successfully created.
```


**GET** `/zoo/search-zoo` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `name` parameter <br>

Returns a list of all zoo with the same `name` parameter<br>
We can have multiple zoo because we didn't assigned a name being unique.<br>

**Example request:** `GET /zoo/search-zoo` <br>

**Example Response**:
```json
[
	{
		"id": 1,
		"name": "Brussels Zoo",
		"numberOfAnimals": 0,
		"elephants": "[]",
		"giraffes": "[]",
		"tigers": "[]"
	}
]
```

**GET** `/zoo/get-zoo` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `id` parameter <br>

Returns a zoo by an id<br>

**Example request:** `GET /zoo/get-zoo?id=1` <br>

**Example Response**:
```json
{
	"id": 1,
	"name": "Brussels Zoo",
	"numberOfAnimals": 0,
	"elephants": "[]",
	"giraffes": "[]",
	"tigers": "[]"
}
```


**PUT** `/zoo/update-zoo` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `ZooRequest` <br>

Updates a zoo by ZooRequest<br>

**Example request:** `PUR /zoo/update-zoo` <br>
```json
{
    "id": "1",
    "name": "Paris Zoo"
}
```


**Example Response**:
```json
Zoo was successfully updated
```


**PUT** `/zoo/place-tiger` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `zid` parameter, `tid` parameter <br>

`zid` - zoo id. <br>
`tid` - tiger id. <br>

Put a tiger to the zoo.<br>
I'll place all the tigers to the zoo for better response at the end.<br>

**Example request:** `PUT /zoo/place-tiger?zid=1&tid=1` <br>

**Example Response**:
```json
Tiger was successfully placed to zoo
```

**PUT** `/zoo/place-elephant` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `zid` parameter, `eid` parameter <br>

`zid` - zoo id. <br>
`eid` - elephant id. <br>

Put an elephant to the zoo.<br>
I'll place all the elephants to the zoo for better response at the end.<br>

**Example request:** `PUT /zoo/place-elephant?zid=1&eid=1` <br>

**Example Response**:
```json
Elephant was successfully placed to zoo
```

**PUT** `/zoo/place-giraffe` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `zid` parameter, `gid` parameter <br>

`zid` - zoo id. <br>
`gid` - giraffe id. <br>

Put a giraffe to the zoo.<br>
I will add an extra giraffe for better response.<br>

**Example request:** `PUT /zoo/place-giraffe?zid=1&gid=2` <br>

**Example Response**:
```json
Giraffe was successfully place to zoo
```

<details>
<summary>Our current zoo</summary>

```json
{
	"id": 1,
	"name": "Paris Zoo",
	"numberOfAnimals": 7,
	"elephants": "[Dumbo Last, Gumbo Loon]",
	"giraffes": "[Mr Giro, Gira Mool]",
	"tigers": "[Init Tiger, Mister Jokin, Mario Tigrio]"
}
```
</details>


**PUT** `/zoo/free-tiger` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `zid` parameter, `tid` parameter <br>

`zid` - zoo id. <br>
`tid` - giraffe id. <br>

Free the tiger from the zoo.<br>
tigers' zoo id will become -1. <br>


**Example request:** `PUT /zoo/free-tiger?zid=1&tid=1` <br>

**Example Response**:
```json
Tiger was successfully removed from the zoo
```

**PUT** `/zoo/free-elephant` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `zid` parameter, `eid` parameter <br>

`zid` - zoo id. <br>
`eid` - elephant id. <br>

Free the elephant from the zoo.<br>
elephants' zoo id will become -1. <br>


**Example request:** `PUT /zoo/free-elephant?zid=1&eid=1` <br>

**Example Response**:
```json
Elephant was successfully removed from the zoo
```

**PUT** `/zoo/free-giraffe` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `zid` parameter, `gid` parameter <br>

`zid` - zoo id. <br>
`gid` - giraffe id. <br>

Free the giraffe from the zoo.<br>
giraffes' zoo id will become -1. <br>


**Example request:** `PUT /zoo/free-giraffe?zid=1&gid=1` <br>

**Example Response**:
```json
Giraffe was successfully removed from the zoo
```

**GET** `/zoo/zoo-last-tiger` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `zid` parameter <br>

Returns the TigerResponse of the last added tiger in the zoo.<br>

**Example request:** `GET /zoo/zoo-last-tiger?zid=1` <br>

**Example Response**:
```json
{
	"id": 3,
	"name": "Mario Tigrio",
	"zoo_id": 1
}
```

**GET** `/zoo/zoo-last-elephant` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `zid` parameter <br>

Returns the ElephantResponse of the last added elephant in the zoo.<br>

**Example request:** `GET /zoo/zoo-last-elephant?zid=1` <br>

**Example Response**:
```json
{
    "id": "2",
    "name": "Gumbo Loon", 
    "elephantAge": "2",
    "zoo_id": 1
}
```


**GET** `/zoo/zoo-last-giraffe` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `zid` parameter <br>

Returns the GiraffeResponse of the last added giraffe in the zoo.<br>

**Example request:** `GET /zoo/zoo-last-giraffe?zid=1` <br>

**Example Response**:
```json
{
	"id": 2,
	"name": "Gira Mool",
	"secret": "@kkfhq`eedrb`mgnkc`rdbqdsd",
	"zoo_id": 1
}
```

<details>
<summary>Our current zoo</summary>

```json
{
	"id": 1,
	"name": "Paris Zoo",
	"numberOfAnimals": 4,
	"elephants": "[Gumbo Loon]",
	"giraffes": "[Gira Mool]",
	"tigers": "[Mister Jokin, Mario Tigrio]"
}
```
</details>

**GET** `/zoo/animal-count` <br>
--
**Expected code:** 200<br>
**Required parameters or body:** `zid` parameter <br>

Amount of the animals at the zoo.<br>

**Example request:** `GET /zoo/animal-count?zid=1` <br>

**Example Response**:
```json
There are 4 animals in zoo with id: 1
```
</details>



# Step 1 (Analyze)

Current application is has a monolith architecture. 

3 services:

    1. AnimalService
    2. CryptoService (Not a service but utill)
    3. InitService (Not a service but utill)

4 models:

    1. Zoo
    2. Elephant
    3. Giraffe
    4. Tiger

4 Repositories:

    1. ElephantRepo
    2. GiraffeRepo
        a. GiraffeExtendedRepo
        b. GiraffeExtendedRepoImpl
    3. TigerRepo


From the first point of view, I would also add a 'data transfer object' package for better communication.

1-st bad thing I see here is that controllers are implemented inside the service class. We should break an Animalservice class into two classes like AnimalController and AnimalService.
Controller classes should not have any logic. All the logic is supposed to be inside the Service classes.

Another big thing is the absence of encapsulation. Fields inside the models should be encapsulated and accessed only via getters and setters. I would also implement @Builder annotation or @Getter, and @Setter to avoid boilerplate code unless we want to specify them. Nevertheless, we need @AllArgsConstructor and @NoArgsConstructor. 

Probably, a good idea to put CryptoService in the util package.

Tests are empty. So, I will implement my own to test API functionality.

spring.jpa.hibernate.ddl-auto=create-drop should be changed in production to none.
Also, I'd set a server port to 0, so our application would pick any free port but it's only the case if port is not required to be specified.

I figured out that we are trying to achieve abstraction via an Animal interface.

(quick catch) PASSCODE is hardcoded inside the service class. It's a bad practice and insecure. Instead, we could place an actual passcode inside the properties file and then just take it from there.

All the endpoints in AnimalService don't have specified access modifiers which leads to package-private by default. It's not a good practice. If we'd like to secure the endpoints we should be using either our default security configuration or Spring Security or both instead.


# Step 2 (Reorganizing files)

1. Creating 4 packages (model, controller, service, repository, dto, utils).
2. Moving AnimalService to a service package, delete the code package.
3. Moving Elephant, Giraffe, Tiger, and Zoo into the model package.
4. Moving Elephant, Giraffe(+ ext, + ext imp), Tiger repositories into the repository package.
5. Creating an AnimalCotroller inside the controller package.
6. Moving the crypt package to the utils package.
7. Moving the init package to the utils package.
8. Creating an interfaces package inside the util package and moving there Animal interface.
9. Deleting empty folders.

# Step 3 (Fix the Elephant model and functionality)

(NOTE) I would add a strategy of Generation type as an identity for our id fields. However, since I see custom ids inside the json files but then we will need to check that the id is free to use. I would personally use a strategy instead.
(NOTE) We don't need a repository annotation in the repository class.
(NOTE) Searching for an elephant by its name is a bad idea. What if two different elephants have the same name? If we assume that elephants' name is a unique identity why wouldn't we make it a primary key? And otherwise, to find an exact elephant we need its id since it is our pk.

0. First since we are applying an Animal interface we need to find common fields within the models. Common fields are id, name, and zoo. So, our interface will be consisted of getters and setters of these fields.
1. Changing all the fields to private to achieve encapsulation.
2. Adding Lombok dependency to reduce boilerplate code, getters, and setters for common fields, and constructors. 
3. Adding a name field which is a combination of elephant firstname and lastname, and I assumed that while setting the name input string will contain the format [firstname lastname] which is the best I can figure out. However, if the Elephant name will contain more than two words this strategy might work incorrectly.
4. In original AnimalService class elephant creation was via @GetMapping("/create-elephant") its not correct. It should creation should be done through the POST request. 
5. Creating an AnimalController. I performed a constructor injection to inject AnimalService inside the controller, for this purpose we also need a Lombok @RequiredArgsConstructor annotation to reduce boilerplate code.
6. I have implemented three mappings: two GET (elephats, search-elephant) and one POST (create-elephant). For fully CRUD we would also need to UPDATE and DELETE. For create-elephant, I performed @RequestParam annotation for the name since I find it more commonly used and more readable than @PathVariable.
7. Creating two dto classes to manage our responses and requests. ElephantResponse for our GET requests and ElephantRequest for our POST requests.
8. Changing CrudRepository to JpaResitory inside ElephantRepo. JpaRepository is a sub-interface of CrudRepository with additional functionality which I find better in our case. Since we are working with basic DB functionality there will be no need in extending the repository and there will be no additional hardcoded SQL implementation.
9. Creating an additional method to map the Elephant object to the ElephantResponse object. Making this in a List manner.
10. Inside the elephant model implement our custom methods from the interface.
11. I also implemented @ResponseStatus annotation to confirm a successful status. 
12. Adding service and endpoint that shows elephants' lifetime in hours (change 24 hours to 8766 hours).
13. Implementing UPDATE and DELETE making our elephants fully CRUD :D
14. Now elephant performs the basic operations. Also, Zoo is not assigned yet, we will fix it while working on Zoo. I checked the endpoints via Insomnia.

# Step 4 (Fix the Tigers model and functionality)

1. We are doing exactly the same steps with a Tiger that we did with Elephant.
2. I also added CRUD functionality, so our tigers could be REST as well. Not sure if this is considered additional functionality.
3. Compared with the elephants, the search-tiger will return only one result because we are searching by id.
4. I not implementing a Lombok in our model since we have only common fields.
5. Tiger endpoints now working, checking results via Insomnia.

# Step 5 (Fix the Giraffe model and functionality)

(NOTE) Here is the tricky thing. GiraffeRepo extends a CrudRepository where the UUID type is used as a primary key. This is a good practice. However, according to our Animal interface, we should stick with the Long type. I could also change the previous models to UUID but then testing will be a little bit more complicated. Let's keep a Long type ids.

(NOTE) Not sure that holding PASSCODE within the code is a good idea. Meanwhile, replacing it to the service class.

1. Trying to perform the same changes except the following:
    a. Giraffe has a secret field. The message which is encrypted on create and decrypted only by providing a passcode.
    b.
2. Deleting GiraffeExtendedRepo and GiraffeExtendedRepoImpl since we are not implementing custom SQL queries. JpaRepository contains all the operations we need to perform for now.
3. Performing all the mentioned CRUD operations. I also added get-giraffe to get a specific one by id since it's our pk and delete-giraffe by id.
4. Also, I have done an update-giraffe by making user pride a passcode, since I find it a better security practice.

# Step 6 (Fix InitService)

1. Change @Sevice annotation to @Component
2. We have set our animalService, so there is no need to perform logic here. Therefore,  we don't need to inject our repositories instead we can just inject our AnimalService.
3. We are going to use our dto request classes. It's a better practice because our model can contain much more information than it is now. In this case, dto objects can help us to perform requests and responses. 
4. First method of uploading a json was missing the getClassLoader() method.
5. perform AnimalService to save the data.

# Step 7 (Fix the Zoo model and functionality)
(Note) I was checking the gradle file (I am more maven) and I figured out that OSS support for Spring Boot 2.6.x is no longer available. So we are using an outdated version. I changed the version to 2.7.14.

1. Changing fields' access modifiers to private.
2. Adding Lombok annotations as previously.
3. Setting basic endpoints to manipulate the zoo. (CRUD)
4. Adding relationships between the entities. I assumed that Zoo class is our parent and all the animals are children. So, OneToMany relationship for parent and ManyToOne for children.
5. I also specified fetching as lazy since we don't want to hold all the information about the child all the time. So, whenever, we will try to manipulate a child it will upload. Better practice for the performance.
6. I also keep the children entities on removal because what if we still want to use the animal on zoo removal?
7. In terms of response I also output lists of animals in a string format. I find this information good to have in response. Therefore, getTigerStr(),getTigerStr(),getTigerStr() are just cornverting Lists of animal type to a string.
8. I fixed an animal counter because it was working in a wrong way and was not oriented on the cases where we remove animals from the zoo.
9. I fixed getLastTiger, getLastEliphant, getLastGiraffe to get List.size - 1 since the size function returns an actual size and indexing starts from 0 which would lead us to IndexOutOfBoundsException.
10. I wrote some additional endpoints and service functions which can be found in the documentation.
11. I might miss mentioning some fixes and add-ons for the zoo since I am writing this step afterward.

# Step 7 (tests)

1. I'll be honest testing is not my strongest side.
2. I tried to perform some basic unit tests but still I would need more time to perform lets say Mokito tests or implementing Testcontainers.
3. Tested all the endpoints and services manually via Insomnia.

# Step 8 (Small Refactoring)
There should be always room for some refactoring.

1. Now we have a large controller and service classes which makes the code a little hard to read. So, lets split an AnimalController to 
TigerController, ElephantController, GiraffeController, ZooController and the same for service class.

# Step 9 (Sum up)

I would like to say thank you for your time reading my notes and checking my work.
I tried to spend as much time working on this exercise as I could in terms of my current job.
I know that several things could be done better by applying several Disign Patterns, better Testing practices, and probably something more.
I might to miss several fixes in my notes since sometimes I had to work fast.
Nevertheless, I honestly did my best and appreciate the opportunity to have this journey.
 


