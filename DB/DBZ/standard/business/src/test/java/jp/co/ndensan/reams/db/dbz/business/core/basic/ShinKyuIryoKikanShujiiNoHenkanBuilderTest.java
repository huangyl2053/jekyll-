/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator;
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
 * {@link ShinKyuIryoKikanShujiiNoHenkanBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinKyuIryoKikanShujiiNoHenkanBuilderTest extends DbzTestBase {

    private static DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity ShinKyuIryoKikanShujiiNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString 旧医療機関番号;
    private static RString 旧主治医番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード;
        旧医療機関番号 = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧医療機関番号;
        旧主治医番号 = DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧主治医番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShinKyuIryoKikanShujiiNoHenkanBuilder sut;
        private static ShinKyuIryoKikanShujiiNoHenkan business;

        @Before
        public void setUp() {
            ShinKyuIryoKikanShujiiNoHenkanEntity = new DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
            ShinKyuIryoKikanShujiiNoHenkanEntity.setShichosonCode(市町村コード);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuIryoKikanNo(旧医療機関番号);
            ShinKyuIryoKikanShujiiNoHenkanEntity.setKyuShujiiNo(旧主治医番号);

            business = new ShinKyuIryoKikanShujiiNoHenkan(ShinKyuIryoKikanShujiiNoHenkanEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の新医療機関番号は_設定した値と同じ新医療機関番号を返す() {
            business = sut.set新医療機関番号(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_新医療機関番号).build();
            assertThat(business.get新医療機関番号(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_新医療機関番号));
        }

        @Test
        public void 戻り値の新主治医番号は_設定した値と同じ新主治医番号を返す() {
            business = sut.set新主治医番号(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_新主治医番号).build();
            assertThat(business.get新主治医番号(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_新主治医番号));
        }

        @Test
        public void 戻り値の旧医療機関番号は_設定した値と同じ旧医療機関番号を返す() {
            business = sut.set旧医療機関番号(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧医療機関番号).build();
            assertThat(business.get旧医療機関番号(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧医療機関番号));
        }

        @Test
        public void 戻り値の旧主治医番号は_設定した値と同じ旧主治医番号を返す() {
            business = sut.set旧主治医番号(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧主治医番号).build();
            assertThat(business.get旧主治医番号(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧主治医番号));
        }

        @Test
        public void 戻り値の市町村コード２は_設定した値と同じ市町村コード２を返す() {
            business = sut.set市町村コード２(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード２).build();
            assertThat(business.get市町村コード２(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_市町村コード２));
        }

        @Test
        public void 戻り値の旧医療機関番号２は_設定した値と同じ旧医療機関番号２を返す() {
            business = sut.set旧医療機関番号２(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧医療機関番号２).build();
            assertThat(business.get旧医療機関番号２(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧医療機関番号２));
        }

        @Test
        public void 戻り値の旧主治医番号２は_設定した値と同じ旧主治医番号２を返す() {
            business = sut.set旧主治医番号２(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧主治医番号２).build();
            assertThat(business.get旧主治医番号２(), is(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator.DEFAULT_旧主治医番号２));
        }

    }
}
