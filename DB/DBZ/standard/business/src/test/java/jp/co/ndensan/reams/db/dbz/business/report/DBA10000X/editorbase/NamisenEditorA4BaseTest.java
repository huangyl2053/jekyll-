/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.HihokenshashoA4EditData;
import jp.co.ndensan.reams.db.dbz.model.report.DBA10000X.IHihokenshashoA4CommonEditData;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase.NamisenEditorA4Base}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NamisenEditorA4BaseTest {

    private static IHihokenshashoA4CommonEditData target;
    private static NamisenEditorA4Base sut;
    private static HihokenshashoModel model;

    public static class set波線 extends DbzTestBase {

        private final RString namisen = new RString("～");

        @Before
        public void setUp() {
            sut = new NamisenEditorA4Base();
            target = createTarget();
        }

        @Test
        public void Yukokikannamisenに_波線が設定される() {
            sut.set波線(target);
            assertThat(target.getYukokikannamisen(), is(namisen));
        }

        @Test
        public void Homonkikannamisenに_波線が設定される() {
            sut.set波線(target);
            assertThat(target.getHomonkikannamisen(), is(namisen));
        }
    }

    private static IHihokenshashoA4CommonEditData createTarget() {
        HihokenshashoA4 a4 = new HihokenshashoA4();
        return new HihokenshashoA4EditData(a4);
    }

}
