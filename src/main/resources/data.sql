delete from Pizza_Order_Pizzas;
delete from Pizza_Ingredients;
delete from Pizza;
delete from Pizza_Order;

delete from Ingredient;
insert into Ingredient (id, name, type)
                values ('NEO', 'Neopolitan', 'DOUGH');
insert into Ingredient (id, name, type)
                values ('NYS', 'New York', 'DOUGH');
insert into Ingredient (id, name, type)
                values ('PEP', 'pepperoni', 'PROTEIN');
insert into Ingredient (id, name, type)
                values ('MAR', 'marshmallow', 'PROTEIN');
insert into Ingredient (id, name, type)
                values ('TOM', 'tomatoes', 'VEGGIES');
insert into Ingredient (id, name, type)
                values ('LET', 'letuce', 'VEGGIES');
insert into Ingredient (id, name, type)
                values ('MOZ', 'mozarella', 'CHEESE');
insert into Ingredient (id, name, type)
                values ('CHE', 'cheddar', 'CHEESE');
insert into Ingredient (id, name, type)
                values ('SLS', 'spicy tomato sauce', 'SAUCE');
insert into Ingredient (id, name, type)
                values ('GAR', 'garlic sauce', 'SAUCE');