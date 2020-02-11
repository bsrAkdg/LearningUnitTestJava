package com.bsrakdg.introductionunittest.stepThreeAssertions;

import androidx.annotation.Nullable;

public class DummyOverrideEquals {
    private int id;

    public DummyOverrideEquals(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return this.id == ((DummyOverrideEquals) obj).getId();
    }

    public int getId() {
        return id;
    }
}
