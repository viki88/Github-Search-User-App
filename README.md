# GitHub User Search App

This Android application allows users to search for GitHub profiles by username and view detailed information about each user.

## Features

- **User Search**: Find GitHub users by entering their username.
- **Profile Details**: View comprehensive information about users, including their repositories, followers, and more.

## Tech Stack

- **Programming Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **API**: GitHub REST API
- **Networking**: Retrofit
- **UI Components**: Jetpack Compose
- **Dependency Injection**: Hilt
- **Reactive Programming**: Flow
- **Image Loading**: Glide

## Installation

1. **Clone the Repository**: Download the project to your local machine using:
   ```bash
   git clone https://github.com/viki88/Github-Search-User-App.git
   ```
2. **Open in Android Studio**: Launch Android Studio and select 'Open an existing project'. Navigate to the cloned repository's folder to open it.
3. **Build the Project**: Allow Android Studio to build the project and download any necessary dependencies.
4. **Run the App**: Connect an Android device or start an emulator, then click 'Run' to install and launch the app.

## Usage

1. **Search for a User**: Enter the GitHub username into the search bar.
2. **View Details**: Select a user from the search results to view their profile information, including repositories and followers.

## Contributing

Contributions are welcome! To contribute:

1. **Fork the Repository**: Click the 'Fork' button at the top right of the repository page.
2. **Create a New Branch**: Use `git checkout -b your-feature-branch` to create a branch for your feature or bug fix.
3. **Make Changes**: Implement your changes and commit them with clear messages.
4. **Push to GitHub**: Use `git push origin your-feature-branch` to upload your changes.
5. **Submit a Pull Request**: Navigate to the original repository and click 'New Pull Request' to submit your changes for review.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

Special thanks to the GitHub API team for providing the resources necessary to fetch user data.

---

*Note: This app utilizes the GitHub API to retrieve user information. Be mindful of the API rate limits when making requests.*
