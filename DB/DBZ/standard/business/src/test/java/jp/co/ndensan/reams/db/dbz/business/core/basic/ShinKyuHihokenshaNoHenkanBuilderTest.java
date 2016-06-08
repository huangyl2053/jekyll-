/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator;
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
 * {@link ShinKyuHihokenshaNoHenkanBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinKyuHihokenshaNoHenkanBuilderTest extends DbzTestBase {

    private static DbT7026ShinKyuHihokenshaNoHenkanEntity ShinKyuHihokenshaNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString 旧番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード;
        旧番号 = DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShinKyuHihokenshaNoHenkanBuilder sut;
        private static ShinKyuHihokenshaNoHenkan business;

        @Before
        public void setUp() {
            ShinKyuHihokenshaNoHenkanEntity = new DbT7026ShinKyuHihokenshaNoHenkanEntity();
            ShinKyuHihokenshaNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuHihokenshaNoHenkanEntity.setKyuNo(旧番号);

            business = new ShinKyuHihokenshaNoHenkan(ShinKyuHihokenshaNoHenkanEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の新番号は_設定した値と同じ新番号を返す() {
            business = sut.set新番号(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_新番号).build();
            assertThat(business.get新番号(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_新番号));
        }

        @Test
        public void 戻り値の旧番号は_設定した値と同じ旧番号を返す() {
            business = sut.set旧番号(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号).build();
            assertThat(business.get旧番号(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号));
        }

        @Test
        public void 戻り値の旧市町村コード２は_設定した値と同じ旧市町村コード２を返す() {
            business = sut.set旧市町村コード２(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧市町村コード２).build();
            assertThat(business.get旧市町村コード２(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧市町村コード２));
        }

        @Test
        public void 戻り値の旧番号２は_設定した値と同じ旧番号２を返す() {
            business = sut.set旧番号２(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号２).build();
            assertThat(business.get旧番号２(), is(DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator.DEFAULT_旧番号２));
        }

    }
}
