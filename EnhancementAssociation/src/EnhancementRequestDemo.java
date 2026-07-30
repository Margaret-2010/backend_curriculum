import java.lang.reflect.Method;

public class EnhancementRequestDemo {

    @EnhancementRequest(
            id = 101,
            synopsis = "Add products to products page",
            engineer = "backend",
            date = "30-07-2026"
    )
    public void addProduct(){

    }

    @EnhancementRequest(
            id = 102,
            synopsis = "Improve API response time"
    )
    public void improvePerformance(){

    }

    static void main(String[] args) throws NoSuchMethodException{
        Method method1 = EnhancementRequestDemo.class.getMethod("addProduct");
        EnhancementRequest request1 = method1.getAnnotation(EnhancementRequest.class);
        printRequest(request1);

        System.out.println();

        Method method2 = EnhancementRequestDemo.class.getMethod("improvePerformance");
        EnhancementRequest request2 = method2.getAnnotation(EnhancementRequest.class);
        printRequest(request2);

    }

    private static void printRequest(EnhancementRequest request){
        System.out.println("ID: " + request.id());
        System.out.println("Synopsis: " + request.synopsis());
        System.out.println("Engineer: " + request.engineer());
        System.out.println("Date: " + request.date());
    }
}