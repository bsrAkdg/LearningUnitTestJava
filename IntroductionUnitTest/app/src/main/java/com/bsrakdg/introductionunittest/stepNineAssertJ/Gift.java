package com.bsrakdg.introductionunittest.stepNineAssertJ;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Getter // added getter methods for all fields, you can add this annotation for a certain method
// @Setter
// @ToString // return value of fields
@Data // usable a lot of methods (get-set-constructor-equals-toString)
@AllArgsConstructor // use constructor : Gift(String)
@NoArgsConstructor // use default constructor : Gift()
@Builder // apply builder design pattern
public class Gift {
    private String name;
}
