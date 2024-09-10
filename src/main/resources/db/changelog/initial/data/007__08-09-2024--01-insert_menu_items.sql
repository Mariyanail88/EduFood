-- Insert sample data into the menu_items table

-- Menu items for The Gourmet Kitchen
INSERT INTO menu_items (restaurant_id, name, description, price)
VALUES (1, 'Truffle Risotto', 'Creamy risotto with truffle oil and parmesan cheese', 25.50),
       (1, 'Foie Gras', 'Pan-seared foie gras with a balsamic reduction', 30.75),
       (1, 'Lobster Bisque', 'Rich and creamy lobster bisque with a hint of sherry', 18.25),
       (1, 'Beef Wellington', 'Tender beef wrapped in puff pastry with mushroom duxelles', 35.00),
       (1, 'Duck Confit', 'Slow-cooked duck leg with crispy skin and a side of potatoes', 28.40),
       (1, 'Coq au Vin', 'Chicken braised in red wine with mushrooms and onions', 22.10),
       (1, 'Bouillabaisse', 'Traditional French seafood stew with saffron broth', 32.60),
       (1, 'Ratatouille', 'Provencal vegetable medley with herbs de Provence', 20.00),
       (1, 'Creme Brulee', 'Classic French dessert with a caramelized sugar crust', 10.50),
       (1, 'Tarte Tatin', 'Upside-down caramelized apple tart', 12.30);

-- Menu items for Pasta Palace
INSERT INTO menu_items (restaurant_id, name, description, price)
VALUES (2, 'Spaghetti Carbonara', 'Classic Italian pasta with pancetta, egg, and parmesan', 15.20),
       (2, 'Fettuccine Alfredo', 'Creamy Alfredo sauce with fettuccine pasta', 14.50),
       (2, 'Lasagna Bolognese', 'Layers of pasta, meat sauce, and bechamel', 18.75),
       (2, 'Penne Arrabbiata', 'Spicy tomato sauce with penne pasta', 13.40),
       (2, 'Ravioli di Ricotta', 'Ricotta-filled ravioli with marinara sauce', 16.10),
       (2, 'Gnocchi al Pesto', 'Potato gnocchi with basil pesto sauce', 15.60),
       (2, 'Tagliatelle al Ragu', 'Tagliatelle pasta with a rich meat ragu', 17.80),
       (2, 'Tortellini in Brodo', 'Cheese-filled tortellini in a light broth', 14.25),
       (2, 'Pasta Primavera', 'Pasta with fresh seasonal vegetables', 13.90),
       (2, 'Tiramisu', 'Classic Italian dessert with coffee-soaked ladyfingers and mascarpone', 8.50);

-- Menu items for Sushi World
INSERT INTO menu_items (restaurant_id, name, description, price)
VALUES (3, 'California Roll', 'Crab, avocado, and cucumber roll', 8.20),
       (3, 'Spicy Tuna Roll', 'Spicy tuna with cucumber and avocado', 10.50),
       (3, 'Salmon Nigiri', 'Fresh salmon over sushi rice', 12.75),
       (3, 'Dragon Roll', 'Eel, cucumber, and avocado roll topped with avocado and eel sauce', 14.30),
       (3, 'Tempura Shrimp Roll', 'Shrimp tempura with avocado and cucumber', 11.40),
       (3, 'Rainbow Roll', 'Crab and avocado roll topped with assorted sashimi', 15.60),
       (3, 'Miso Soup', 'Traditional Japanese soup with tofu and seaweed', 4.50),
       (3, 'Edamame', 'Steamed soybeans with sea salt', 5.20),
       (3, 'Sashimi Platter', 'Assorted fresh sashimi', 20.80),
       (3, 'Green Tea Ice Cream', 'Creamy green tea flavored ice cream', 6.10);

-- Menu items for Burger Haven
INSERT INTO menu_items (restaurant_id, name, description, price)
VALUES (4, 'Classic Cheeseburger', 'Beef patty with cheddar cheese, lettuce, tomato, and onion', 10.50),
       (4, 'Bacon Burger', 'Beef patty with bacon, cheddar cheese, and BBQ sauce', 12.75),
       (4, 'Mushroom Swiss Burger', 'Beef patty with Swiss cheese and sautéed mushrooms', 11.40),
       (4, 'Veggie Burger', 'Plant-based patty with lettuce, tomato, and avocado', 9.20),
       (4, 'BBQ Pulled Pork Burger', 'Pulled pork with coleslaw and BBQ sauce', 13.60),
       (4, 'Spicy Jalapeno Burger', 'Beef patty with jalapenos, pepper jack cheese, and spicy mayo', 11.80),
       (4, 'Blue Cheese Burger', 'Beef patty with blue cheese and caramelized onions', 12.40),
       (4, 'Chicken Burger', 'Grilled chicken breast with lettuce, tomato, and mayo', 10.30),
       (4, 'Double Cheeseburger', 'Two beef patties with double cheddar cheese', 14.50),
       (4, 'Onion Rings', 'Crispy fried onion rings', 5.20);

-- Menu items for Taco Fiesta
INSERT INTO menu_items (restaurant_id, name, description, price)
VALUES (5, 'Carne Asada Taco', 'Grilled steak with cilantro, onions, and salsa', 3.50),
       (5, 'Chicken Tinga Taco', 'Shredded chicken with chipotle sauce and avocado', 3.75),
       (5, 'Fish Taco', 'Battered fish with cabbage slaw and lime crema', 4.20),
       (5, 'Carnitas Taco', 'Slow-cooked pork with pickled onions and salsa verde', 3.90),
       (5, 'Veggie Taco', 'Grilled vegetables with black beans and avocado', 3.40),
       (5, 'Shrimp Taco', 'Grilled shrimp with mango salsa and cilantro', 4.75),
       (5, 'Al Pastor Taco', 'Marinated pork with pineapple and cilantro', 3.80),
       (5, 'Chorizo Taco', 'Spicy chorizo with potatoes and salsa roja', 3.60),
       (5, 'Guacamole and Chips', 'Fresh guacamole with tortilla chips', 6.50),
       (5, 'Churros', 'Fried dough pastry with cinnamon sugar', 5.20);

-- Menu items for Pizza Paradise
INSERT INTO menu_items (restaurant_id, name, description, price)
VALUES (6, 'Margherita Pizza', 'Tomato sauce, mozzarella, and fresh basil', 12.50),
       (6, 'Pepperoni Pizza', 'Tomato sauce, mozzarella, and pepperoni', 14.75),
       (6, 'BBQ Chicken Pizza', 'BBQ sauce, chicken, red onions, and cilantro', 15.60),
       (6, 'Veggie Pizza', 'Tomato sauce, mozzarella, and assorted vegetables', 13.40),
       (6, 'Hawaiian Pizza', 'Tomato sauce, mozzarella, ham, and pineapple', 14.20),
       (6, 'Meat Lovers Pizza', 'Tomato sauce, mozzarella, pepperoni, sausage, and bacon', 16.80),
       (6, 'Four Cheese Pizza', 'Tomato sauce, mozzarella, parmesan, gorgonzola, and ricotta', 15.50),
       (6, 'Buffalo Chicken Pizza', 'Buffalo sauce, chicken, and blue cheese', 15.30),
       (6, 'White Pizza', 'Ricotta, mozzarella, garlic, and spinach', 14.60),
       (6, 'Tiramisu', 'Classic Italian dessert with coffee-soaked ladyfingers and mascarpone', 8.50);

-- Menu items for Steakhouse Supreme
INSERT INTO menu_items (restaurant_id, name, description, price)
VALUES (7, 'Filet Mignon', 'Tender filet mignon with a red wine reduction', 35.75),
       (7, 'Ribeye Steak', 'Juicy ribeye steak with garlic butter', 32.50),
       (7, 'New York Strip', 'Classic New York strip steak with peppercorn sauce', 30.40),
       (7, 'Porterhouse Steak', 'Large porterhouse steak with herb butter', 40.80),
       (7, 'Grilled Asparagus', 'Grilled asparagus with lemon and parmesan', 8.20),
       (7, 'Mashed Potatoes', 'Creamy mashed potatoes with chives', 7.50),
       (7, 'Caesar Salad', 'Crisp romaine lettuce with Caesar dressing and croutons', 10.30),
       (7, 'Lobster Tail', 'Grilled lobster tail with drawn butter', 25.60),
       (7, 'Chocolate Lava Cake', 'Warm chocolate cake with a molten center', 10.50),
       (7, 'Cheesecake', 'Classic New York-style cheesecake', 9.20);

-- Menu items for Vegan Delights
INSERT INTO menu_items (restaurant_id, name, description, price)
VALUES (8, 'Vegan Burger', 'Plant-based patty with lettuce, tomato, and avocado', 10.40),
       (8, 'Quinoa Salad', 'Quinoa with mixed greens, cherry tomatoes, and lemon vinaigrette', 9.20),
       (8, 'Stuffed Peppers', 'Bell peppers stuffed with rice, beans, and vegetables', 11.50),
       (8, 'Vegan Tacos', 'Soft tacos with grilled vegetables and avocado', 8.30),
       (8, 'Lentil Soup', 'Hearty lentil soup with vegetables and spices', 7.40),
       (8, 'Vegan Pizza', 'Pizza with tomato sauce, vegan cheese, and vegetables', 12.60),
       (8, 'Falafel Wrap', 'Falafel with hummus, lettuce, and tomato in a wrap', 9.50),
       (8, 'Vegan Mac and Cheese', 'Macaroni with creamy vegan cheese sauce', 10.80),
       (8, 'Chocolate Avocado Mousse', 'Rich chocolate mousse made with avocado', 8.20),
       (8, 'Fruit Salad', 'Fresh fruit salad with a mint garnish', 6.50);

-- Menu items for Seafood Shack
INSERT INTO menu_items (restaurant_id, name, description, price)
VALUES (9, 'Grilled Salmon', 'Grilled salmon with lemon butter sauce', 20.75),
       (9, 'Fish and Chips', 'Battered fish with fries and tartar sauce', 15.40),
       (9, 'Shrimp Scampi', 'Shrimp in a garlic butter sauce with pasta', 18.60),
       (9, 'Clam Chowder', 'Creamy clam chowder with potatoes and bacon', 10.30),
       (9, 'Lobster Roll', 'Lobster salad in a toasted bun', 22.50),
       (9, 'Crab Cakes', 'Pan-seared crab cakes with remoulade sauce', 16.40),
       (9, 'Oysters on the Half Shell', 'Fresh oysters with mignonette sauce', 18.80),
       (9, 'Seafood Paella', 'Spanish rice dish with assorted seafood', 25.60),
       (9, 'Key Lime Pie', 'Tart and creamy key lime pie', 8.20),
       (9, 'Coconut Shrimp', 'Crispy coconut shrimp with sweet chili sauce', 14.50);

-- Menu items for Dessert Dreams
INSERT INTO menu_items (restaurant_id, name, description, price)
VALUES (10, 'Chocolate Cake', 'Rich chocolate cake with chocolate frosting', 6.50),
       (10, 'Cheesecake', 'Classic New York-style cheesecake', 7.20),
       (10, 'Apple Pie', 'Traditional apple pie with a flaky crust', 5.40),
       (10, 'Brownies', 'Fudgy brownies with a crackly top', 4.30),
       (10, 'Ice Cream Sundae', 'Vanilla ice cream with chocolate sauce, nuts, and a cherry', 6.80),
       (10, 'Lemon Bars', 'Tangy lemon bars with a shortbread crust', 5.60),
       (10, 'Pecan Pie', 'Sweet pecan pie with a buttery crust', 7.50),
       (10, 'Tiramisu', 'Classic Italian dessert with coffee-soaked ladyfingers and mascarpone', 8.40),
       (10, 'Creme Brulee', 'Classic French dessert with a caramelized sugar crust', 9.30),
       (10, 'Macarons', 'Assorted French macarons', 10.20);