# Write your MySQL query statement below
# Write your MySQL query statement below
select class from Courses
group by class
having count(Student)>=5;