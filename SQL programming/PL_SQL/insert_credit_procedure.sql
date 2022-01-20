CREATE PROCEDURE insert_credit
(
credit_id IN number,
credit_card_number IN varchar,
credit_card_expire IN varchar,
holder_name IN varchar,
card_type IN varchar
)
AS
BEGIN

insert INTO credit_card(id, card_number, card_expire, name ,cc_type)
VALUES(credit_id, credit_card_number , credit_card_expire , holder_name ,card_type);

COMMIT;

END;
/
