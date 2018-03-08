# SYSC4806
# Members [MeeseksSQUAD]:
  - Sheikh Faisal Anwar
  - Muhammad Siddiqui
  - Himanish Kaushal

# Project:
**Learning Outcomes Management System**
Represent the structure of a Department, and be able to track, edit and update the Learning Outcomes (objectives) of the programs being offered. Learning Outcomes are arranged in Categories and are offered by one or many courses in a given year, where a course belongs to one or many programs. A user can view all the details, but only an Administrator can make changes.

# Product Backlog:

> Stories are arranged according to Priority.
> Sizing technique used: Planning Poker with 
> Arbitrary size: T-shirt sizes (S, M, L, XL, XXL)
> Sizing done by Team while backlog grooming during Sprint weekly meetings
> NOTE: Stories are not concrete, and open to re-prioritization and re-sizing based on the chance that the needs and efforts are overlooked
---

| Story | [As a user, I should be able to login to the app, so that I can display different lists of information related to the department ](https://github.com/sheikhfaisalanwar/SYSC4806/projects/2#card-7842757) |
| ------ | ------ |
| Story Number | 1 |
| Size Estimate | L |
| Details | Have a login page for people to view the department and information about the department. The department will only display the top level for the time being. User should be able to register and view information, a user type would be Admin who can make changes in the future implementation of the program. |
|Acceptance Criteria | Setup travis, heroku. Add class and entity relations for users and user roles. Have login page (needed for admin vs user), ability to register. View top level of department after logging in |
| Assigned to | Sheikh Faisal Anwar |
| Start Date | (Sunday) 4th March, 2018 |
| End Date | - |

| Story | [As a user, I should be able to view all the programs that are available, so that I can see the students registered in them ](https://github.com/sheikhfaisalanwar/SYSC4806/projects/2#card-7950431) |
| ------ | ------ |
| Story Number | 2 |
| Size Estimate | M |
| Details | Have a programs domain page to be accessed and lists all program for the time being. Will be changed later to establish all relationships. |
|Acceptance Criteria | Have controller, domain page, tests set up completed. Also be able to add programs for the time being. Will change later when lists viewed are modified and user login completed |
| Assigned to | Himanish Kaushal |
| Start Date | (Wednesday) 7th March, 2018 |
| End Date | - |

| Story | [As a user, I should be able to list all learning outcomes, so that I can see all that are required ](https://github.com/sheikhfaisalanwar/SYSC4806/projects/2#card-7950442) |
| ------ | ------ |
| Story Number | 3 |
| Size Estimate | M |
| Details | Have a learning outcome domain page to be accessed and lists all learning outcomes |
|Acceptance Criteria | Have controller, domain page, tests set up completed. Also be able to add learning outcomes for the time being. Will change later when lists viewed are modified and user login completed  |
| Assigned to | Muhammad Kashif Siddiqui |
| Start Date | (Tuesday) 6th March, 2018 |
| End Date | (Wednesday) 7th March, 2018 |

| Story | [As a user, I should be able to View all the courses, so that I can navigate to the learning outcomes for a specific one ](https://github.com/sheikhfaisalanwar/SYSC4806/projects/1#card-7841273) |
| ------ | ------ |
| Story Number | 4 |
| Size Estimate | - |
| Details | - |
|Acceptance Criteria | - |
| Assigned to | - |
| Start Date | - |
| End Date | - |

| Story | [As a user, I should be able to list all categories, so that I can see them in the page ](https://github.com/sheikhfaisalanwar/SYSC4806/projects/1#card-7841145) |
| ------ | ------ |
| Story Number | 5 |
| Size Estimate | - |
| Details | - |
|Acceptance Criteria | - |
| Assigned to | - |
| Start Date | - |
| End Date | - |

| Story | [As a user, I should be able to list learning outcomes for a specific program, so that I can see the outcomes required by the program ](https://github.com/sheikhfaisalanwar/SYSC4806/projects/1#card-7840901) |
| ------ | ------ |
| Story Number | 6 |
| Size Estimate | - |
| Details | - |
|Acceptance Criteria | - |
| Assigned to | - |
| Start Date | - |
| End Date | - |

| Story | [As a user, I should be able to list learning outcomes for a specific year, so that I can see if I have completed them for the given year ](https://github.com/sheikhfaisalanwar/SYSC4806/projects/1#card-7840874) |
| ------ | ------ |
| Story Number | 7 |
| Size Estimate | - |
| Details | - |
|Acceptance Criteria | - |
| Assigned to | - |
| Start Date | - |
| End Date | - |

| Story | [As a user, I should be able to export the created list as a result in a CSV file, so that it is easy to read the results ](https://github.com/sheikhfaisalanwar/SYSC4806/projects/1#card-7841371) |
| ------ | ------ |
| Story Number | 8 |
| Size Estimate | - |
| Details | - |
|Acceptance Criteria | - |
| Assigned to | - |
| Start Date | - |
| End Date | - |

| Story | [As an administrator, I should be able to edits the lists, so that the lists are always up to date ](https://github.com/sheikhfaisalanwar/SYSC4806/projects/1#card-7949973) |
| ------ | ------ |
| Story Number | 9 |
| Size Estimate | - |
| Details | - |
|Acceptance Criteria | - |
| Assigned to | - |
| Start Date | - |
| End Date | - |

# Sprint 1

## Goal: Display list of Learning Outcomes
Aim was to have the initial setup of the project completed; which included proper version control repo, integrated with Travis CI, and the app should be up and running in production on Heroku. Along with having the first feature of having the ability to work with the backend and display information to the user after logging in, which includes the list of programs and learning outcomes for the time being. Already populated with a very small list of learning outcomes.

---
# Sprint 2

## Plans:
Have integration tests in place, complete Program domain model and establish relationships between courses, programs, years, categories, and learning outcomes. Hopefully also implement Administrator privileges to edit the list, and have a user only be able to view all the information. The specific lists the user is able to view need to be established as well, after the relationships and the domain models are set up.
The relationships to establish are:
  - Multiple programs in the department
  - Each course has a Set of learning objectives in a given year
  - Each learning objective belongs to a category
  - Each course belongs to one or many programs, and a program has many courses in a given year
  - Course is taught in a given year
  
  
---
## Setup instructions

1. git clone https://github.com/sheikhfaisalanwar/SYSC4806.git
2. Import pom.xml
3. Run Application as main
 
