/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RendoHoryuTokuteiJushoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RendoHoryuTokuteiJushoBuilderTest extends DbzTestBase {

    private static DbT7023RendoHoryuTokuteiJushoEntity RendoHoryuTokuteiJushoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static RendoHoryuTokuteiJushoBuilder sut;
        private static RendoHoryuTokuteiJusho business;

        @Before
        public void setUp() {
            RendoHoryuTokuteiJushoEntity = new DbT7023RendoHoryuTokuteiJushoEntity();
            RendoHoryuTokuteiJushoEntity.setXXX(主キー名1);
            RendoHoryuTokuteiJushoEntity.setXXX(主キー名2);

            business = new RendoHoryuTokuteiJusho(RendoHoryuTokuteiJushoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の管理番号は_設定した値と同じ管理番号を返す() {
            business = sut.set管理番号(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号).build();
            assertThat(business.get管理番号(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_管理番号));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の住所コードは_設定した値と同じ住所コードを返す() {
            business = sut.set住所コード(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_住所コード).build();
            assertThat(business.get住所コード(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_住所コード));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            business = sut.set住所(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_住所).build();
            assertThat(business.get住所(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の番地コード１は_設定した値と同じ番地コード１を返す() {
            business = sut.set番地コード１(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード１).build();
            assertThat(business.get番地コード１(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード１));
        }

        @Test
        public void 戻り値の番地コード２は_設定した値と同じ番地コード２を返す() {
            business = sut.set番地コード２(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード２).build();
            assertThat(business.get番地コード２(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード２));
        }

        @Test
        public void 戻り値の番地コード３は_設定した値と同じ番地コード３を返す() {
            business = sut.set番地コード３(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード３).build();
            assertThat(business.get番地コード３(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地コード３));
        }

        @Test
        public void 戻り値の番地は_設定した値と同じ番地を返す() {
            business = sut.set番地(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地).build();
            assertThat(business.get番地(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_番地));
        }

        @Test
        public void 戻り値の施設種類は_設定した値と同じ施設種類を返す() {
            business = sut.set施設種類(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_施設種類).build();
            assertThat(business.get施設種類(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_施設種類));
        }

        @Test
        public void 戻り値の施設コードは_設定した値と同じ施設コードを返す() {
            business = sut.set施設コード(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_施設コード).build();
            assertThat(business.get施設コード(), is(DbT7023RendoHoryuTokuteiJushoEntityGenerator.DEFAULT_施設コード));
        }

    }
}
