TV-Tracker-Model
================

Database configuration
-------------------------------------
To get the database set up, you need to follow a few steps:
1. Change the JDBC URL to something that fits your platform
2. Run DerbyDatabase.java as a "Java Application" (this creates a new database)
3. That's about it.

Model classes for the TV-Tracker project

### Classes

__Account__ - Object through which a user's account is interfaced with.

__Login__ - class added for the LoginView.

__Media__ - The base class for all Media objects, ie. TV Shows.

__MediaList__ - A list of Media objects, ie. a user's queue

__Progress__ - The base class for tracking a user's progress in any given show.

__MediaProgress__ - Binds a Progress instance and Media instance together.

__MediaListProgress__ - The same as __MediaProgress__, but for __MediaList__ rather than __Media__


