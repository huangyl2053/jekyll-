/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase.ServiceTaniEditorB4Base;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoB4;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoB4UpperEditData;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoB4CommonEditData;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.ServiceTaniEditorB4Base}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ServiceTaniEditorB4BaseTest {

    private static IHihokenshashoB4CommonEditData target;
    private static ServiceTaniEditorB4Base sut;
    private static HihokenshashoModel model;

    public static class set1月当たり extends DbzTestBase {

        private final RString oneMonthAtari = new RString("1月当たり");

        @Before
        public void setUp() {
            sut = new ServiceTaniEditorB4Base();
            target = createTarget();
        }

        @Test
        public void Servicetani1に_1月当たりが設定される() {
            sut.set1月当たり(target);
            assertThat(target.getServicetani1(), is(oneMonthAtari));
        }
    }

    private static IHihokenshashoB4CommonEditData createTarget() {
        HihokenshashoB4 b4 = new HihokenshashoB4();
        return new HihokenshashoB4UpperEditData(b4);
    }

}
