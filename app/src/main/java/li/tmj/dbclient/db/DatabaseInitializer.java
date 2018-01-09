package li.tmj.dbclient.db;

import li.tmj.dbclient.db.model.Person;

public class DatabaseInitializer {
    private final DatabaseWorker worker;
    //private Map<String,Long> breeders=new HashMap<>();

    public DatabaseInitializer(DatabaseWorker worker) {
        this.worker = worker;
       // initBreeders();
        initPersons();
    }

//    private void initBreeders(){
//        initBreeder("Tom, Dick & Harry");
//        initBreeder("Evan Longer");
//        initBreeder("Adam & Eve");
//    }

//    private void initBreeder(String name){
//        breeders.put(name,worker.insertBreeder(name));
//    }

    private void initPersons(){
        Person p=new Person();
        p.setNameFamily("Dickson");
        p.setNameIndividual("Dick");
        p.setSex("männlich");
        p.setBirthDay(12);
        p.setBirthMonth(7);
        p.setBirthYear(1973);
        worker.insertPerson(p);

        p.setNameFamily("Tomson");
        p.setNameIndividual("Tom");
        p.setSex("männlich");
        p.setBirthDay(17);
        p.setBirthMonth(10);
       // p.setBirthYear(1993);
        worker.insertPerson(p);

        p.setNameFamily("Harrison");
        p.setNameIndividual("Harrietta");
        p.setSex("weiblich");
//        p.setBirthDay(12);
//        p.setBirthMonth(7);
//        p.setBirthYear(1973);
        worker.insertPerson(p);

    }
}
