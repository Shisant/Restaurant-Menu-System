package com.Menu;


public class mClass{
        private String DishName;
        private int DishNum;
        private int Price;
        private String Categories;
        private String Calories;

        public mClass(){
            DishName= new String();
            DishNum = 0;
            Price = 0;
            Categories = new String();
            Calories = new String();
        }

        public String getDishName() {
            return DishName;
        }

        public void setDishName(String DishName) {
            this.DishName = DishName;
        }

        public int getDishNum() {
            return DishNum;
        }



        public void setDishNum(int DishNum) {
            this.DishNum = DishNum;
        }

        public int  getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }

        public String getCategories() {
            return Categories;
        }

        public void setCategories(String Categories) {
            this.Categories = Categories;
        }

        public String getCalories() {
            return Calories;
        }

        public void setCalories(String Calories) {
            this.Calories = Calories;
        }

    public static void main(String[] args)
    {
        new mClass();
    }


    }



