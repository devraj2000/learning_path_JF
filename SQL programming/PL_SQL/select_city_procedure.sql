create procedure select_city
(
user_id IN number,
city_details OUT varchar
)
as
BEGIN
select 'User is from' ||
case
when city IN('Bangalore','Chennai')
then city
else 'other cities'
end
into city_details
from contact
where id=user_id;
end;
/
