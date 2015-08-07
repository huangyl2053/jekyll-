/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7068ChohyoBunruiKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
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

    private static DbT7068ChohyoBunruiKanriEntity ChohyoBunruiKanriEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7068ChohyoBunruiKanriEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static ChohyoBunruiKanriBuilder sut;
        private static ChohyoBunruiKanri business;

        @Before
        public void setUp() {
            ChohyoBunruiKanriEntity = new DbT7068ChohyoBunruiKanriEntity();
            ChohyoBunruiKanriEntity.setXXX(主キー名1);
            ChohyoBunruiKanriEntity.setXXX(主キー名2);

            business = new ChohyoBunruiKanri(ChohyoBunruiKanriEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

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
