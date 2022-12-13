package com.example.unittestingexample

import org.junit.Test
import org.junit.Assert.*

class RegistrationUtilTest {

    @Test
    fun `empty data return false`(){
        val restult = RegistrationUtil.checkValidity(
            "piyush",
        "meher"
        )

        assert(restult)
    }

}