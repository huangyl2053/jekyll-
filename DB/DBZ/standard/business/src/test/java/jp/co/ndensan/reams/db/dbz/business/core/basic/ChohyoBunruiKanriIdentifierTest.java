/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChohyoBunruiKanriIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChohyoBunruiKanriIdentifierTest extends DbzTestBase {

    private static SubGyomuCode サブ業務コード;
    private static ReportId 帳票ID;

    @BeforeClass
    public static void setUpClass() {
        サブ業務コード = jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_サブ業務コード;
        帳票ID = jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_帳票ID;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            ChohyoBunruiKanriIdentifier sut = new ChohyoBunruiKanriIdentifier(サブ業務コード, 帳票ID);
            assertThat(sut, is(serializable()));
        }
    }
}
