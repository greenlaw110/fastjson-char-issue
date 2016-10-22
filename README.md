# FastJSON issue with parsing JSON for model with char array

## The Model

```java
public class ModelWithCharArray {

    private char[] v;

    public char[] getV() {
        return v;
    }

    public void setV(char[] v) {
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelWithCharArray that = (ModelWithCharArray) o;

        return Arrays.equals(v, that.v);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(v);
    }

    @Override
    public String toString() {
        return Arrays.toString(v);
    }
}
```

## The demo code

```java
public class FastJsonCharIssue {

    public void fastJson() {
        System.out.println("\nFastJSON");
        System.out.println("----------------------------------------------------------");
        String input = "{\"v\":[\" \", \"a\", \"b\", \"c\"]}";
        System.out.printf("input: %s\n", input);
        ModelWithCharArray model = JSON.parseObject(input, ModelWithCharArray.class);
        System.out.printf("model: %s\n", model);
    }

    public void jackson() throws Exception {
        System.out.println("\nJackson");
        System.out.println("----------------------------------------------------------");
        ObjectMapper mapper = new ObjectMapper();
        String input = "{\"v\":[\" \", \"a\", \"b\", \"c\"]}";
        System.out.printf("input: %s\n", input);
        ModelWithCharArray model = mapper.readValue(input, ModelWithCharArray.class);
        System.out.printf("model: %s\n", model);
    }

    public static void main(String[] args) throws Exception {
        new FastJsonCharIssue().jackson();
        new FastJsonCharIssue().fastJson();
    }

}
```

## The result

```
Jackson
----------------------------------------------------------
input: {"v":[" ", "a", "b", "c"]}
model: [ , a, b, c]

FastJSON
----------------------------------------------------------
input: {"v":[" ", "a", "b", "c"]}
model: [[, ",  , ", ,, ", a, ", ,, ", b, ", ,, ", c, ", ]]
```

## Expected result

We expect FastJSON parsing works in a Jackson way:

```
Jackson
----------------------------------------------------------
input: {"v":[" ", "a", "b", "c"]}
model: [ , a, b, c]

FastJSON
----------------------------------------------------------
input: {"v":[" ", "a", "b", "c"]}
model: [ , a, b, c]
````
