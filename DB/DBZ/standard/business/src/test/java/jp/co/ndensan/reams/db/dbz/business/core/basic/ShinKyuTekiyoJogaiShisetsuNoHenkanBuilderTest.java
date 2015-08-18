/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator;
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
 * {@link ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinKyuTekiyoJogaiShisetsuNoHenkanBuilderTest extends DbzTestBase {

    private static DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity ShinKyuTekiyoJogaiShisetsuNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString 旧適用除外施設番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード;
        旧適用除外施設番号 = DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_旧適用除外施設番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShinKyuTekiyoJogaiShisetsuNoHenkanBuilder sut;
        private static ShinKyuTekiyoJogaiShisetsuNoHenkan business;

        @Before
        public void setUp() {
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity = new DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity();
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuTekiyoJogaiShisetsuNoHenkanEntity.setKyuTekiyoJogaiShisetsuNo(旧適用除外施設番号);

            business = new ShinKyuTekiyoJogaiShisetsuNoHenkan(ShinKyuTekiyoJogaiShisetsuNoHenkanEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の新適用除外施設番号は_設定した値と同じ新適用除外施設番号を返す() {
            business = sut.set新適用除外施設番号(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_新適用除外施設番号).build();
            assertThat(business.get新適用除外施設番号(), is(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_新適用除外施設番号));
        }

        @Test
        public void 戻り値の旧適用除外施設番号は_設定した値と同じ旧適用除外施設番号を返す() {
            business = sut.set旧適用除外施設番号(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_旧適用除外施設番号).build();
            assertThat(business.get旧適用除外施設番号(), is(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_旧適用除外施設番号));
        }

        @Test
        public void 戻り値の市町村コード２は_設定した値と同じ市町村コード２を返す() {
            business = sut.set市町村コード２(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード２).build();
            assertThat(business.get市町村コード２(), is(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード２));
        }

        @Test
        public void 戻り値の旧適用除外施設番号２は_設定した値と同じ旧適用除外施設番号２を返す() {
            business = sut.set旧適用除外施設番号２(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_旧適用除外施設番号２).build();
            assertThat(business.get旧適用除外施設番号２(), is(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator.DEFAULT_旧適用除外施設番号２));
        }

    }
}
