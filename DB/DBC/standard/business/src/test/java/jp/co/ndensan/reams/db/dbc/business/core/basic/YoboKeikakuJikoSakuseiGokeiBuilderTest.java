/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link YoboKeikakuJikoSakuseiGokeiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class YoboKeikakuJikoSakuseiGokeiBuilderTest extends DbcTestBase {

    private static DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity YoboKeikakuJikoSakuseiGokeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static Decimal 主キー名3;
    private static RString 主キー名4;
    private static JigyoshaNo 主キー名5;
    private static ServiceShuruiCode 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static YoboKeikakuJikoSakuseiGokeiBuilder sut;
        private static YoboKeikakuJikoSakuseiGokei business;

        @Before
        public void setUp() {
            YoboKeikakuJikoSakuseiGokeiEntity = new DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity();
            YoboKeikakuJikoSakuseiGokeiEntity.setHihokenshaNo(主キー名1);
            YoboKeikakuJikoSakuseiGokeiEntity.setTaishoYM(主キー名2);

            business = new YoboKeikakuJikoSakuseiGokei(YoboKeikakuJikoSakuseiGokeiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            business = sut.set対象年月(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月).build();
            assertThat(business.get対象年月(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の居宅サービス区分は_設定した値と同じ居宅サービス区分を返す() {
            business = sut.set居宅サービス区分(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分).build();
            assertThat(business.get居宅サービス区分(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_居宅サービス区分));
        }

        @Test
        public void 戻り値のサービス提供事業者番号は_設定した値と同じサービス提供事業者番号を返す() {
            business = sut.setサービス提供事業者番号(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号).build();
            assertThat(business.getサービス提供事業者番号(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス提供事業者番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の給付計画単位数は_設定した値と同じ給付計画単位数を返す() {
            business = sut.set給付計画単位数(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_給付計画単位数).build();
            assertThat(business.get給付計画単位数(), is(DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_給付計画単位数));
        }

    }
}
