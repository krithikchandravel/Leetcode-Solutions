select b.name as Department,a.name as Employee,a.salary as Salary from
(select departmentid,name,salary,
dense_rank() over(partition by departmentid
order by salary desc) as rn from employee
) as a join department b on a.departmentid=b.id
where rn=1;
