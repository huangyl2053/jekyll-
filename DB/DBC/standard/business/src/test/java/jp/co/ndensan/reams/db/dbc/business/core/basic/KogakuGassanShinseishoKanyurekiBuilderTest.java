/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

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
 * {@link KogakuGassanShinseishoKanyurekiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanShinseishoKanyurekiBuilderTest extends DbcTestBase {

    private static DbT3069KogakuGassanShinseishoKanyurekiEntity KogakuGassanShinseishoKanyurekiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KogakuGassanShinseishoKanyurekiBuilder sut;
        private static KogakuGassanShinseishoKanyureki business;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = new DbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setXXX(主キー名2);

            business = new KogakuGassanShinseishoKanyureki(KogakuGassanShinseishoKanyurekiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年度は_設定した値と同じ対象年度を返す() {
            business = sut.set対象年度(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_対象年度).build();
            assertThat(business.get対象年度(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_対象年度));
        }

        @Test
        public void 戻り値の保険者番号は_設定した値と同じ保険者番号を返す() {
            business = sut.set保険者番号(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_保険者番号).build();
            assertThat(business.get保険者番号(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_保険者番号));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の加入歴番号は_設定した値と同じ加入歴番号を返す() {
            business = sut.set加入歴番号(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入歴番号).build();
            assertThat(business.get加入歴番号(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入歴番号));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の保険者名は_設定した値と同じ保険者名を返す() {
            business = sut.set保険者名(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_保険者名).build();
            assertThat(business.get保険者名(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_保険者名));
        }

        @Test
        public void 戻り値の加入期間開始年月日は_設定した値と同じ加入期間開始年月日を返す() {
            business = sut.set加入期間開始年月日(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入期間開始年月日).build();
            assertThat(business.get加入期間開始年月日(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入期間開始年月日));
        }

        @Test
        public void 戻り値の加入期間終了年月日は_設定した値と同じ加入期間終了年月日を返す() {
            business = sut.set加入期間終了年月日(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入期間終了年月日).build();
            assertThat(business.get加入期間終了年月日(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入期間終了年月日));
        }

        @Test
        public void 戻り値の自己負担額証明書整理番号は_設定した値と同じ自己負担額証明書整理番号を返す() {
            business = sut.set自己負担額証明書整理番号(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_自己負担額証明書整理番号).build();
            assertThat(business.get自己負担額証明書整理番号(), is(DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_自己負担額証明書整理番号));
        }

    }
}
