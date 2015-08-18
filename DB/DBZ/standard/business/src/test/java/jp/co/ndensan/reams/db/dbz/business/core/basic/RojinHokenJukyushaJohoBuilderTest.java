/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7005RojinHokenJukyushaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RojinHokenJukyushaJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RojinHokenJukyushaJohoBuilderTest extends DbzTestBase {

    private static DbT7005RojinHokenJukyushaJohoEntity RojinHokenJukyushaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_識別コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static RojinHokenJukyushaJohoBuilder sut;
        private static RojinHokenJukyushaJoho business;

        @Before
        public void setUp() {
            RojinHokenJukyushaJohoEntity = new DbT7005RojinHokenJukyushaJohoEntity();
            RojinHokenJukyushaJohoEntity.setShikibetsuCode(識別コード);

            business = new RojinHokenJukyushaJoho(RojinHokenJukyushaJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の老人保健市町村コードは_設定した値と同じ老人保健市町村コードを返す() {
            business = sut.set老人保健市町村コード(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_老人保健市町村コード).build();
            assertThat(business.get老人保健市町村コード(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_老人保健市町村コード));
        }

        @Test
        public void 戻り値の老人保健受給者番号は_設定した値と同じ老人保健受給者番号を返す() {
            business = sut.set老人保健受給者番号(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_老人保健受給者番号).build();
            assertThat(business.get老人保健受給者番号(), is(DbT7005RojinHokenJukyushaJohoEntityGenerator.DEFAULT_老人保健受給者番号));
        }

    }
}
