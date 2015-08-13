/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7027KakushuCodeHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KakushuCodeHenkanBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KakushuCodeHenkanBuilderTest extends DbzTestBase {

    private static DbT7027KakushuCodeHenkanEntity KakushuCodeHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString コード区分;
    private static RString 外部コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード;
        コード区分 = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_コード区分;
        外部コード = DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KakushuCodeHenkanBuilder sut;
        private static KakushuCodeHenkan business;

        @Before
        public void setUp() {
            KakushuCodeHenkanEntity = new DbT7027KakushuCodeHenkanEntity();
            KakushuCodeHenkanEntity.setShichosonCode(市町村コード);
            KakushuCodeHenkanEntity.setCodeKubun(コード区分);
            KakushuCodeHenkanEntity.setGaibuCode(外部コード);

            business = new KakushuCodeHenkan(KakushuCodeHenkanEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値のコード区分は_設定した値と同じコード区分を返す() {
            business = sut.setコード区分(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_コード区分).build();
            assertThat(business.getコード区分(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_コード区分));
        }

        @Test
        public void 戻り値の内部コードは_設定した値と同じ内部コードを返す() {
            business = sut.set内部コード(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_内部コード).build();
            assertThat(business.get内部コード(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_内部コード));
        }

        @Test
        public void 戻り値の内部番号は_設定した値と同じ内部番号を返す() {
            business = sut.set内部番号(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_内部番号).build();
            assertThat(business.get内部番号(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_内部番号));
        }

        @Test
        public void 戻り値の外部コードは_設定した値と同じ外部コードを返す() {
            business = sut.set外部コード(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード).build();
            assertThat(business.get外部コード(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード));
        }

        @Test
        public void 戻り値の市町村コード２は_設定した値と同じ市町村コード２を返す() {
            business = sut.set市町村コード２(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード２).build();
            assertThat(business.get市町村コード２(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_市町村コード２));
        }

        @Test
        public void 戻り値の外部コード２は_設定した値と同じ外部コード２を返す() {
            business = sut.set外部コード２(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード２).build();
            assertThat(business.get外部コード２(), is(DbT7027KakushuCodeHenkanEntityGenerator.DEFAULT_外部コード２));
        }

    }
}
