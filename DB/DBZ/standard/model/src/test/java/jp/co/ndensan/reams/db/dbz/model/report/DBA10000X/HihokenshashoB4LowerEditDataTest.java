/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.report.DBA10000X;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dba.model.report.DBA10000X.HihokenshashoB4LowerEditData}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoB4LowerEditDataTest {

    private static HihokenshashoB4LowerEditData sut;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void hihokenshashoにnullが渡された場合_NullPointerExceptionが発生する() {
            sut = new HihokenshashoB4LowerEditData(null);
            fail();
        }
    }

}
