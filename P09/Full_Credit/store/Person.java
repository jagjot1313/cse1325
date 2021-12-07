protected void addPerson(Person person) {   this.persons.add(person);   }

    protected int numberOfPeople() {    return this.persons.size(); }

    protected String personToString(int productIndex) {  return this.products.get(productIndex).name;   }

    protected String personToString()
    {
        String result = "Welcome to " + storeName + "\n\n";
        for(int i=0; i<persons.size(); ++i) {
            result += i + ") " + persons.get(i) + "\n";
        }
        return result;
    }
