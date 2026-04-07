package main.git.Objects;
package git.domain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ObjectType<T extends GitObject> {
    // allowed objects: blob, tree, commit
    // GitObject<T> objects
    // GitObj<Blob>, GitObject<Tree>, GitObject<Commit>
    private static final byte[] SPACE_BYTES={' '};
    private static final byte[] NULL_BYTES={0};
    public static final ObjectType<Blob>BLOB=new ObjectType<>("blob", Blob.class, new BlobSerializer());
    public static final ObjectType<Tree>TREE=new ObjectType<>("tree", Tree.class, new TreeSerializer());
    public static final ObjectType<Commit>COMMIT=new ObjectType<>("commit", Commit.class, new CommitSerializer());
    public static final Collection<ObjectType> TYPES=List.of(Blob, Tree, Commit);
    public  final String name;
    public final Class<?>objectClass;
        //Commit.class --> runtime identification 
    // actuall obj ko bytes ko kaise convert karna hain ?? 
    public final ObjectContentSerializer<T>serializer;
    public byte[] serialize(T object) throws IOException{
        final var content =serializeContent(object);
        final var lengthBytes=String.valueOf(content.length).getBytes();
        try(
            final var outputStream=new ByteArrayInputStream(outputStream);
            final var dataOutputStream=new DataOutputStream(outputStream);


        ){
            outputStream.write(name.getBytes());
			outputStream.write(name.getBytes());
			outputStream.write(SPACE_BYTES);
			outputStream.write(lengthBytes);
			outputStream.write(NULL_BYTES);
			outputStream.write(content);

			return outputStream.toByteArray();

        }

    }
    public byte[] seriallizeContent(T object)throws IOException{
        try(
            final var outputStream=new ByteArrayOutputStream();
            final var dataOutputStream=new DataOutputStream(outputStream);

        ){
            serializer.serialize(object, dataOutputStream);
            return outputStream.toByteArray();
        }
    }
    public T deserialize() throws IOException{
        return serializer.deserialize(DataInputStream);

    }
public T derserialize(byte[]bytes)throws IOException{
    try(
        final byteInputStream=new ByteArrayInputStream(bytes);
        final var dataInputStreams=new DataInputStream(byteInputStream);
    ){
        final var obj=deserialize(dataInputStreams);
        if(byteInputStream.read()!=-1){
            throw new new IllegalStateStateException("buffer not fully read");
        }
        return obj;
    }
}
public static ObjectType byName(String name){
    for(final var type: TYPES){
        if(type.getName().equalsIgnoreCase(name)){
            return type;
        }
    }
    throw new IllegalArgumentException(
        "unknown object type: " + name
    );
}
public static ObjectType byClass(Class<? extends GitObject>){
    for (final var type : TYPES) {
        if (type.getObjectClass().equals(clazz)) {
            return type;
        }
    }

    throw new IllegalArgumentException("unknown object type: " + clazz);
}
    
}
