# MemCachier and Spring Boot on Heroku tutorial

This is an example Spring Boot 2 (Spring Framework 5) task list app that uses
the [MemCachier add-on](https://addons.heroku.com/memcachier) on
[Heroku](http://www.heroku.com/). A running version of this app can be
found [here](http://memcachier-examples-spring.herokuapp.com).

Detailed instructions for developing this app are available
[here](https://devcenter.heroku.com/articles/spring-boot-memcache).

## Deploy to Heroku

You can deploy this app yourself to Heroku to play with.

[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

## Running Locally

Run the following commands to get started running this app locally:

```sh
$ git clone https://github.com/memcachier/examples-spring-boot.git
$ cd examples-spring-boot
$ mvn spring-boot:run
```

Then visit `http://localhost:8080` to play with the app.

>Note: You will need to have the `SPRING_DATASOURCE_URL`, `MEMCACHIER_USERNAME`,
>`MEMCACHIER_PASSWORD`, and `MEMCACHIER_SERVERS` environment variable in your
>path for the app to start up properly. To get the `MEMCACHIER_*` variables you
>can easily create a free cache on [MemCachier](https://www.memcachier.com/).

## Deploying to Heroku

Run the following commands to deploy the app to Heroku:

```sh
$ git clone https://github.com/memcachier/examples-spring-boot.git
$ cd examples-spring-boot
$ heroku create
Creating app... done, ⬢ rocky-chamber-17110
https://rocky-chamber-17110.herokuapp.com/ | https://git.heroku.com/rocky-chamber-17110.git
$ heroku addons:create memcachier:dev
$ heroku addons:create heroku-postgresql:hobby-dev
$ git push heroku master
$ heroku open
```

## Get involved!

We are happy to receive bug reports, fixes, documentation enhancements,
and other improvements.

Please report bugs via the
[github issue tracker](http://github.com/memcachier/examples-spring-boot/issues).

Master [git repository](http://github.com/memcachier/examples-spring-boot):

* `git clone git://github.com/memcachier/examples-spring-boot.git`

## Licensing

This example is open-sourced software licensed under the
[MIT license](https://opensource.org/licenses/MIT).
