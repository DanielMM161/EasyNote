<h1 align="center" >
Easy-Note
</h1>

<p align="center">
Easy-Note it's a modern Android development with Hilt, Coroutines, Jetpack (ViewModel), based on MVVM architecture.
</p>
</br>

<p align="center">
<img src="/previews/easyNoteGroup.png"/>
</p>
<p align="center">
<img src="/previews/easyNoteGiff.gif"/>
</p>

## 🛠 Tech stack & Open-source libraries
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/), [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- Jetpack
  - Lifecycle - Observe Android lifecycles and handle UI states upon the lifecycle changes.
  - ViewModel - Designed to store and manage UI-related data in a lifecycle conscious way. Allows data to survive configuration changes such as screen rotations.
  - Room Persistence - Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - Repository Pattern
- [Hilt](https://github.com/googlecodelabs/android-hilt) - Dependency Injection

## 🏛️ Architecture
Easy-Note is based on the MVVM architecture and the Repository pattern, which follows the [Google's official architecture guidance](https://developer.android.com/topic/architecture).
![architecture](https://developer.android.com/static/topic/libraries/architecture/images/mad-arch-overview.png)
The overall architecture of **Weather-Compose** is composed in 3 layers: The Presentation layer (UI), domain layer and data later. They have each different responsibilities.

### Architecture Overview

- The data layer is designed to work independently from other layers and must be pure, which means it doesn't have any dependencies on the other layers.

### Presentation Layer (UI)
The role of the UI layer (or presentation layer) is to display the application data on the screen. Whenever the data changes, either due to user interaction (such as pressing a button) or external input (such as a network response), the UI should update to reflect the changes.

The UI layer is made up of two things:
  - UI elements that render the data on the screen. You build these elements using Views or Jetpack Compose functions.
  - State holders (such as ViewModel classes) that hold data, expose it to the UI, and handle logic.

![architecture](https://developer.android.com/static/topic/libraries/architecture/images/mad-arch-overview-ui.png)


### Domain Layer
The domain layer is an optional layer that sits between the UI and data layers.

The domain layer is responsible for encapsulating complex business logic, or simple business logic that is reused by multiple ViewModels.
This layer is optional because not all apps will have these requirements. You should use it only when needed—for example, to handle complexity or favor reusability.

![architecture](https://developer.android.com/static/topic/libraries/architecture/images/mad-arch-overview-domain.png)

### Data Layer
The data layer of an app contains the business logic. The business logic is what gives value to your app—it's made of rules that determine how your app creates, stores, and changes data.

The data layer is made of repositories that each can contain zero to many data sources. You should create a repository class for each different type of data you handle in your app.
For example, you might create a MoviesRepository class for data related to movies, or a PaymentsRepository class for data related to payments.

![architecture](https://developer.android.com/static/topic/libraries/architecture/images/mad-arch-overview-data.png)

Repository classes are responsible for the following tasks:

  - Exposing data to the rest of the app.
  - Centralizing changes to the data.
  - Resolving conflicts between multiple data sources.
  - Abstracting sources of data from the rest of the app.
  - Containing business logic.

Each data source class should have the responsibility of working with only one source of data, which can be a file, a network source, or a local database.
Data source classes are the bridge between the application and the system for data operations.



