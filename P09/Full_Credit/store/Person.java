Package Store;

protected void addPerson(Person person) 
{   
    this.persons.add(person);  
    this.persons.add(phone);
}

    protected int numberOfPeople()
    {   
        return this.persons.size();
    }

    protected String personToString(int productIndex)
    {  
        return this.products.get(productIndex).name; 
        return this.products.get(productIndex).phone;  
       
    }

    protected String personToString()
    {
        String result = "Welcome to " + storeName + "\n\n";
        for(int i=0; i<persons.size(); ++i) 
        {
            result += i + ") " + persons.get(i) + "\n";
        }
        return result;
    }
