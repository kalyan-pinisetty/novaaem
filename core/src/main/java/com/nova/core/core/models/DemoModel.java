// package com.nova.core.core.models;


//     import org.apache.sling.api.resource.Resource;
//     import org.apache.sling.api.resource.ValueMap;
//     import org.apache.sling.models.annotations.Model;
//     import org.apache.sling.models.annotations.injectorspecific.SlingObject;
//     import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//     import org.apache.sling.models.annotations.DefaultInjectionStrategy;

//     import javax.annotation.PostConstruct;
//     import java.util.Optional;

//     @Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
//     public class DemoModel- {

//         @SlingObject
//         private Resource resource;

//         @ValueMapValue
//         private String name;

//         @ValueMapValue
//         private String email;

//         @ValueMapValue
//         private String dob;

//         private String password;

//         @ValueMapValue(name = "fileReference")
//         private String image;

//         @PostConstruct
//         protected void init() {
//             ValueMap properties = resource.getValueMap();
//             // Password is a mix of name, email, and dob. Adjust the logic as needed.
//             this.password = Optional.ofNullable(name).orElse("") +
//                             Optional.ofNullable(email).orElse("") +
//                             Optional.ofNullable(dob).orElse("");
//         }

//         public String getName() {
//             return name;
//         }

//         public String getEmail() {
//             return email;
//         }

//         public String getDob() {
//             return dob;
//         }

//         public String getPassword() {
//             return password;
//         }

//         public String getImage() {
//             return image;
//         }
//     }

