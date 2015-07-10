/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.DBA10000X;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.report.parts.tsuchishoatesaki.ITsuchishoAtesakiBuilder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * {@link jp.co.ndensan.reams.db.dba.business.report.DBA10000X.HihokenshashoA4Builder}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoA4BuilderTest {

    private static HihokenshashoA4Builder sut;
    private static IHihokenshashoA4SourceBuilder hihokenshashoA4;
    private static ITsuchishoAtesakiBuilder tsuchishoSofusaki;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者証ソースビルダーにnullが渡されたとき_NullPointerExceptionが発生する() {
            hihokenshashoA4 = null;
            tsuchishoSofusaki = mock(ITsuchishoAtesakiBuilder.class);
            sut = new HihokenshashoA4Builder(hihokenshashoA4, tsuchishoSofusaki);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 引数の通知書宛先ソースビルダーにnullが渡されたとき_NullPointerExceptionが発生する() {
            hihokenshashoA4 = mock(HihokenshashoA4SourceBuilder.class);
            tsuchishoSofusaki = null;
            sut = new HihokenshashoA4Builder(hihokenshashoA4, tsuchishoSofusaki);
            fail();
        }
    }

}
