# 🧮 Calculator App — Android (Kotlin)

<div align="center">

![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![XML](https://img.shields.io/badge/XML-FF6600?style=for-the-badge&logo=xml&logoColor=white)
![SQLite](https://img.shields.io/badge/SQLite-003B57?style=for-the-badge&logo=sqlite&logoColor=white)
![RecyclerView](https://img.shields.io/badge/RecyclerView-4285F4?style=for-the-badge&logo=android&logoColor=white)
![Material Design](https://img.shields.io/badge/Material%20Design-757575?style=for-the-badge&logo=material-design&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Dark Theme](https://img.shields.io/badge/Dark%20Theme-000000?style=for-the-badge&logo=android&logoColor=white)
![Min SDK](https://img.shields.io/badge/Min%20SDK-21-brightgreen?style=for-the-badge&logo=android&logoColor=white)
![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)


A modern, fully functional calculator Android app built with Kotlin featuring a clean dark UI, rounded buttons, and full arithmetic support with BODMAS/PEMDAS precedence.

</div>
 
---

## 📸 App Preview
 
> Dark themed calculator with color-coded buttons — number buttons in dark gray, operators in orange, delete in red, and a large display area showing both the expression and result.
 
---

<p align="center">
<img src="Screenshots/HomePage.jpeg" width="250"/>
</p>

<p align="center">
<img src="Screenshots/HistoryPage.jpeg" width="250"/>
</p>

---

## ✨ Features
 
- ➕ Basic arithmetic — Addition, Subtraction, Multiplication, Division
- 📐 BODMAS/PEMDAS operator precedence
- 💯 Percentage calculation
- ➕ Database support where user can watch recent operations
- 🛠️ Recycler viewer is created to show the history
- ➖ Toggle positive/negative sign
- ⌫ Backspace — delete last character
- 🔄 AC — clear everything instantly
- 🔢 Decimal number support
- ⚠️ Division by zero error handling
- 🌙 Always-on dark theme
- 🎨 Attractive UI with rounded, color-coded buttons
---
 
## 🛠️ Technologies Used
 
| Technology | Purpose |
|---|---|
| **Kotlin** | Primary programming language |
| **Android SDK** | Android app development framework |
| **AndroidX AppCompat** | Backward compatible UI components |
| **Material Design 3** | App theming (Dark theme base) |
| **XML Layouts** | UI design and structure |
| **Gradle (Kotlin DSL)** | Build system |
 
---
## 📚 Android Concepts Covered
 
| Concept | Description |
|---|---|
| **Activity & Lifecycle** | `AppCompatActivity`, `onCreate()` |
| **findViewById** | Connecting Kotlin code to XML views |
| **setOnClickListener** | Handling button tap events |
| **LinearLayoutCompat** | Arranging views vertically and horizontally |
| **layout_weight** | Distributing equal space among buttons |
| **AppCompatButton** | Flexible, theme-safe buttons |
| **Custom Drawables** | Rounded button backgrounds via XML shapes |
| **Styles & Themes** | Reusable button styles, dark app theme |
| **State Management** | Tracking input and result state with variables |
| **Exception Handling** | try-catch for division by zero and parse errors |
| **String Manipulation** | Building and parsing math expressions |
| **BODMAS Logic** | Manual implementation of operator precedence |
 
---

## 📁 Project Structure
 
```
CalculatorApp/
│
├── app/
│   ├── manifests/
│   │   └── AndroidManifest.xml          # App config, entry point
│   │
│   ├── kotlin+java/
│   │   └── com.example.calculator/
│   │       └── MainActivity.kt          # All calculator logic
│   │
│   └── res/
│       ├── drawable/
│       │   ├── btn_rounded_number.xml   # Dark gray rounded button background
│       │   ├── btn_rounded_operator.xml # Orange rounded button background
│       │   ├── btn_rounded_action.xml   # Medium gray rounded button background
│       │   ├── btn_rounded_equal.xml    # Orange equal button background
│       │   └── btn_rounded_delete.xml  # Red delete button background
│       │
│       ├── layout/
│       │   └── activity_main.xml        # Calculator UI layout
│       │
│       └── values/
│           ├── colors.xml               # All color definitions
│           ├── styles.xml               # Reusable button styles
│           └── themes.xml               # Dark app theme
│
├── build.gradle.kts                     # App level build config
└── gradle.properties                    # Gradle settings
```
 
---

 ## 🎨 UI Design
 
 ### Color Palette
 
| Element | Color | Hex |
|---|---|---|
| Background | Deep Dark | `#1C1C1E` |
| Number Buttons | Dark Gray | `#2C2C2E` |
| Operator Buttons | Orange | `#FF9F0A` |
| Action Buttons | Medium Gray | `#3A3A3C` |
| Delete Button | Red | `#FF453A` |
| Display Text | White | `#FFFFFF` |
| Expression Text | Gray | `#8E8E93` |

---
 ### Button Layout
```
┌─────────────────────────────┐
│  Expression (small, gray)   │
│  Result    (large, white)   │
├──────┬──────┬──────┬────────┤
│  AC  │  ⌫  │  %   │   ÷   │
├──────┼──────┼──────┼────────┤
│  7   │  8   │  9   │   ×   │
├──────┼──────┼──────┼────────┤
│  4   │  5   │  6   │   −   │
├──────┼──────┼──────┼────────┤
│  1   │  2   │  3   │   +   │
├──────┼──────┼──────┼────────┤
│ +/-  │  0   │  .   │   =   │
└──────┴──────┴──────┴────────┘
```
 
---

 
## ⚙️ Requirements
 
| Requirement | Version |
|---|---|
| **Android Studio** | Hedgehog or later |
| **Minimum SDK** | API 24 (Android 7.0 Nougat) |
| **Target SDK** | API 36 |
| **Kotlin** | 1.9+ |
| **Gradle** | 8.0+ |
| **Java** | JDK 17 |
 
---
 
## 🚀 Getting Started
 
### 1. Clone the Repository
 
```bash
git clone https://github.com/ashish-modak-22/Android_Calculator_App.git
```

---

### 2. Open in Android Studio
- Open **Android Studio**
- Click **File → Open**
- Navigate to the cloned folder and select it
- Wait for Gradle sync to complete
### 3. Run the App
- Connect an Android device or start an emulator
- Click the ▶️ **Run** button
- Select your device and click **OK**
---

## 🔮 Future Improvements
 
- [ ] Add bracket support
- [ ] Scientific calculator mode
- [ ] Haptic feedback on button press
- [ ] Screen rotation support with `ViewModel`
- [ ] Copy result to clipboard on long press
---

> Built with ❤️ as a learning project to explore Android development with Kotlin.

---
