# Blue & Off-White Color Scheme Update

I have updated the application's visual theme. The previous hardcoded purple backgrounds and colors have been replaced with a professional-looking palette consisting of dark blue, primary blue, light blue, and dirty white.

## Changes Made

### [Resources]

- **[colors.xml](file:///C:/Users/Rain/Downloads/Application,%20Development%20and%20Emerging%20Technology/MACToDoList/app/mactodolist/src/main/res/values/colors.xml)**: Defined the new color palette.
- **[themes.xml](file:///C:/Users/Rain/Downloads/Application,%20Development%20and%20Emerging%20Technology/MACToDoList/app/mactodolist/src/main/res/values/themes.xml)**: Updated the base theme to use `dark_blue` as the primary color and `dirty_white` for the window background.

### [UI Layouts]

- **[activity_main.xml](file:///C:/Users/Rain/Downloads/Application,%20Development%20and%20Emerging%20Technology/MACToDoList/app/mactodolist/src/main/res/layout/activity_main.xml)**:
    - Background updated to `dirty_white`.
    - Title text and "+ Add Task" button set to `dark_blue`.
- **[activity_add_edit_task.xml](file:///C:/Users/Rain/Downloads/Application,%20Development%20and%20Emerging%20Technology/MACToDoList/app/mactodolist/src/main/res/layout/activity_add_edit_task.xml)**:
    - Background updated to `dirty_white`.
    - Labels and "Save Task" button set to `dark_blue`.
    - "Cancel" button set to `primary_blue`.
- **[item_task.xml](file:///C:/Users/Rain/Downloads/Application,%20Development%20and%20Emerging%20Technology/MACToDoList/app/mactodolist/src/main/res/layout/item_task.xml)**:
    - Task card background updated to `light_blue`.
    - Title and buttons set to `dark_blue`.

## Verification Results

### Automated Tests
- Ran `:app:mactodolist:assembleDebug` - **SUCCESS**

## Visual Summary

The new palette provides better contrast and a more modern appearance:
- **Backgrounds**: Dirty White (#F5F5F5)
- **Primary Actions**: Dark Blue (#004586)
- **Secondary Actions**: Primary Blue (#1976D2)
- **Task Items**: Light Blue (#BBDEFB)
