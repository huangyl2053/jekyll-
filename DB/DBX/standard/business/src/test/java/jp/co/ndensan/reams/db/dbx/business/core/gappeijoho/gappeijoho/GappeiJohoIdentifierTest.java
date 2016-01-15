/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeijoho;

import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.GappeiJohoIdentifier;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7055GappeiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GappeiJohoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiJohoIdentifierTest extends DbxTestBase {

    private static FlexibleDate 合併年月日;
    private static RString 地域番号;

    @BeforeClass
    public static void setUpClass() {

        合併年月日 = DbT7055GappeiJohoEntityGenerator.DEFAULT_合併年月日;
        地域番号 = DbT7055GappeiJohoEntityGenerator.DEFAULT_地域番号;
    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            GappeiJohoIdentifier sut = new GappeiJohoIdentifier(合併年月日, 地域番号);
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }
}
