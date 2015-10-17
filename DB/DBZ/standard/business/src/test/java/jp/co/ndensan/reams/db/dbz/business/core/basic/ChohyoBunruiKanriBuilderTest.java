/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7068ChohyoBunruiKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChohyoBunruiKanriBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChohyoBunruiKanriBuilderTest extends DbzTestBase {

    private static DbT7068ChohyoBunruiKanriEntity chohyoBunruiKanriEntity;
    private static SubGyomuCode サブ業務コード;
    private static ReportId 帳票ID;

    @BeforeClass
    public static void setUpClass() {
        サブ業務コード = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_サブ業務コード;
        帳票ID = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_帳票ID;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ChohyoBunruiKanriBuilder sut;
        private static ChohyoBunruiKanri business;

        @Before
        public void setUp() {
            chohyoBunruiKanriEntity = new DbT7068ChohyoBunruiKanriEntity();
            chohyoBunruiKanriEntity.setSubGyomuCode(サブ業務コード);
            chohyoBunruiKanriEntity.setReportID(帳票ID);

            business = new ChohyoBunruiKanri(chohyoBunruiKanriEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値のサブ業務コードは_設定した値と同じサブ業務コードを返す() {
            business = sut.setサブ業務コード(DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_サブ業務コード).build();
            assertThat(business.getサブ業務コード(), is(DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_サブ業務コード));
        }

        @Test
        public void 戻り値の帳票IDは_設定した値と同じ帳票IDを返す() {
            business = sut.set帳票ID(DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_帳票ID).build();
            assertThat(business.get帳票ID(), is(DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_帳票ID));
        }

        @Test
        public void 戻り値の帳票分類IDは_設定した値と同じ帳票分類IDを返す() {
            business = sut.set帳票分類ID(DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_帳票分類ID).build();
            assertThat(business.get帳票分類ID(), is(DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_帳票分類ID));
        }

    }
}
