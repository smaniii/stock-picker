package di

import com.google.gson.{Gson, GsonBuilder}
import com.google.inject.{AbstractModule, Provides}


class JsonModule extends AbstractModule {

  @Provides def jsonTransformer: Gson = {
    new GsonBuilder().setPrettyPrinting().create()
  }

}
