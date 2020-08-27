# Spring MVC

## Contributing
For more information, please refer to the [meta repo](https://gitlab.com/revature_training/training).

## Prerequisites & Learning Objectives
* Java 8
* Tomcat 8+
* Maven
* [Spring Core](../../modules/a-framework)
* [Spring MVC](../../modules/b-mvc) 
* [Phase 1](../phase-1)
* [Phase 2](../phase-2)

Be sure to also follow your IDE's standard for setting up web application deployment
or configure the maven application to deploy to a running Tomcat instance using [tomcat7-plugin](https://tomcat.apache.org/maven-plugin-trunk/tomcat7-maven-plugin/usage.html).

After completing all modules, associates should be able to:
* [Create a Controller Class](#config-controller)
* [Create Request Mappings](#config-request-mappings)
* [Exercises](#exercises)


### <a name="config-controller"></a>Create a Controller Class
A Controller class (a Spring bean annotated with @Controller or @RestController) is a bean
that will receive request routing from the DispatchServlet (the FrontController).

#### Create the Controller Class (src/main/java/com/ex/web/GreetingsController)
```java
// package and imports
@Controller // mark this been as a controller bean. it will receive requests from the DispatchServlet
public class GreetingsController {
}
```
In Spring MVC @Controller methods will return data that will be mapped to a templated view
(jsp, groovy, velocity, etc...). @Controller methods should either return a view name (like "index")
or a ModelAndView which is an encapsulation of the the view name and view data. @Controllers and
@Controller methods can be annotated with @ResponseBody which will allow the method to return data directly
to the HttpServletResponse body rather than being mapped to a view.

In lieu of using @Controller, a Spring MVC controller can be annotated with @RestController. @RestController
is an extension of the @Controller annotation with the @ResponseBody. @RestController is expected to return
data in any format directly to the HttpServletResponse body.

### <a name="config-request-mappings"></a>Create Request Mappings
Request mappings in a Spring MVC controller annotate methods that will respond to
HTTP request. Request methods can be annotated with @RequestMapping which has
associated values for:
* path
* method
* consumes
* produces
* params
* headers

Request mappings can also be mapped using the semantic annotations for specific HTTP methods
which also have similar associated values. Annotating with semantic annotations is the best practice.
* @GetMapping
* @PostMapping
* @PutMapping
* @DeleteMapping

These annotations are extensions of the @RequestMapping annotation with its method
value set to the appropriate HTTP method.

#### GreetingsController Request mappings
```java
@Controller // mark this been as a controller bean. it will receive requests from the DispatchServlet
@RequestMapping(path="/greetings") // this controller will be reached by request to /api/greetings/*
public class GreetingsController {
  private final List<String> motds = new ArrayList<>();
  private final Random randomGen = new Random();

  @PostConstruct
  protected void initializeMotds() {
    // impl
  }

  @GetMapping(produces= MediaType.TEXT_PLAIN_VALUE)  // Get request to /api/greetings/
  @ResponseBody
  public ResponseEntity<String> getMotd() {
    // impl
  }

  @PostMapping(consumes=MediaType.TEXT_PLAIN_VALUE) // Post request to /api/greetings/
                                                    // with a string in the body
  @ResponseBody
  public ResponseEntity<String> addMotd(@RequestBody String motdObject) throws URISyntaxException {
    // impl
  }

  @GetMapping(path="{id}", produces=MediaType.TEXT_PLAIN_VALUE) // Get request to /api/greetings/x
                                                                // where x is some int
  @ResponseBody
  public ResponseEntity<String> getMotdById(@PathVariable int id) {
    // impl
  }
}
```

The project is now complete. You can build and deploy to a Tomcat server, but the
easiest way to test functionality is through unit testing run ```mvn test``` and also
explore the unit test files.

#### <a name="exercises"></a>Exercises
Now that the demo is complete encourage your associates to expand the example.
They can:
* Add PUT and DELETE handlers
* Add a handler(s) for addressing a user directly (ex. /greetings/{name} or /greetings/{name}/{id})

Also encourage them to use unit testing to confirm their results rather than
manual deployment testing. MockMvc isn't difficult, but does take some getting
used to.
