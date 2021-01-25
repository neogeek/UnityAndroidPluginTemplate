# Unity Android Plugin Template

## Setup

1. Rename `app/androidplugin` directory to the name of your choosing.
1. Update `settings.gradle` with the new path (keep the custom path separators `:`) and display name.

    ```
    include ':app:androidplugin'
    rootProject.name = "Unity Android Plugin"
    ```

1. Update package name in `app/androidplugin/src/main/AndroidManifest.xml` and `app/androidplugin/src/main/java/com/unity/androidplugin/AndroidPlugin.java`.
1. Build with `make build`.

## Usage in Unity

1. Create a new folder in Unity's assets panel `Plugins/Android`.
1. Import the generated `.aar` file from `dist/` into `Plugins/Android`.
1. Create an assembly definition in `Plugins/Android`, and select only `Android` and `Editor` under **Platforms**.
1. Create a script in `Plugins/Android` for accessing the plugin:

    ```csharp
    using UnityEngine;

    public static class AndroidPlugin
    {

        private static AndroidJavaObject _androidPlugin;

        private static AndroidJavaObject androidPlugin
        {
            get
            {
                if (_androidPlugin != null)
                {
                    return _androidPlugin;
                }

                var javaUnityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer");

                var currentActivity = javaUnityPlayer.GetStatic<AndroidJavaObject>("currentActivity");

                _androidPlugin =
                    new AndroidJavaObject("com.unity.androidplugin.AndroidPlugin", currentActivity);

                return _androidPlugin;
            }
        }

        public static void Toast(string message)
        {
            androidPlugin.Call("ToastMakeText", message);
        }

    }
    ```

1. Then call the plugin via `AndroidPlugin.Toast("Hello, world!");`
