/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator;
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
 * {@link ShinKyuTaTokureiShisetsuNoHenkanBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinKyuTaTokureiShisetsuNoHenkanBuilderTest extends DbzTestBase {

    private static DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity ShinKyuTaTokureiShisetsuNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static ShinKyuTaTokureiShisetsuNoHenkanBuilder sut;
        private static ShinKyuTaTokureiShisetsuNoHenkan business;

        @Before
        public void setUp() {
            ShinKyuTaTokureiShisetsuNoHenkanEntity = new DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity();
            ShinKyuTaTokureiShisetsuNoHenkanEntity.setXXX(主キー名1);
            ShinKyuTaTokureiShisetsuNoHenkanEntity.setXXX(主キー名2);

            business = new ShinKyuTaTokureiShisetsuNoHenkan(ShinKyuTaTokureiShisetsuNoHenkanEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の新他特例施設番号は_設定した値と同じ新他特例施設番号を返す() {
            business = sut.set新他特例施設番号(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_新他特例施設番号).build();
            assertThat(business.get新他特例施設番号(), is(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_新他特例施設番号));
        }

        @Test
        public void 戻り値の旧他特例施設番号は_設定した値と同じ旧他特例施設番号を返す() {
            business = sut.set旧他特例施設番号(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_旧他特例施設番号).build();
            assertThat(business.get旧他特例施設番号(), is(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_旧他特例施設番号));
        }

        @Test
        public void 戻り値の市町村コード２は_設定した値と同じ市町村コード２を返す() {
            business = sut.set市町村コード２(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード２).build();
            assertThat(business.get市町村コード２(), is(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_市町村コード２));
        }

        @Test
        public void 戻り値の旧他特例施設番号２は_設定した値と同じ旧他特例施設番号２を返す() {
            business = sut.set旧他特例施設番号２(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_旧他特例施設番号２).build();
            assertThat(business.get旧他特例施設番号２(), is(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator.DEFAULT_旧他特例施設番号２));
        }

    }
}
