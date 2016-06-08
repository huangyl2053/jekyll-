/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeishichoson;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7056GappeiShichosonEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {@link GappeiShichosonIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiShichosonIdentifierTest extends DbxTestBase {

    private static FlexibleDate 合併年月日;
    private static RString 地域番号;
    private static LasdecCode 旧市町村コード;

    @BeforeClass
    public static void setUpClass() {

        合併年月日 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_合併年月日;
        地域番号 = DbT7056GappeiShichosonEntityGenerator.DEFAULT_地域番号;
        旧市町村コード = DbT7056GappeiShichosonEntityGenerator.DEFAULT_旧市町村コード;
    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            GappeiShichosonIdentifier sut = new GappeiShichosonIdentifier(合併年月日, 地域番号, 旧市町村コード);
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }
}
