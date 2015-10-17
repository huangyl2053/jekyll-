/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.basic;

import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.basic.helper.DbT7021JigyoHokokuTokeiDataEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * {@link JigyoHokokuTokeiDataBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JigyoHokokuTokeiDataBuilderTest extends DbuTestBase {

    private static DbT7021JigyoHokokuTokeiDataEntity JigyoHokokuTokeiDataEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 主キー名1;
    private static RString 主キー名2;
    private static FlexibleYear 主キー名3;
    private static RString 主キー名4;
    private static RString 主キー5;
    private static LasdecCode 主キー6;
    private static Code 主キー7;
    private static Code 主キー8;
    private static Code 主キー9;
    private static Decimal 主キー10;
    private static Decimal 主キー11;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年;
        主キー名2 = DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月;
    }

    public static class getterSetterTest extends DbuTestBase {

        private static JigyoHokokuTokeiDataBuilder sut;
        private static JigyoHokokuTokeiData business;

        @Before
        public void setUp() {
            JigyoHokokuTokeiDataEntity = new DbT7021JigyoHokokuTokeiDataEntity();
            JigyoHokokuTokeiDataEntity.setHokokuYSeireki(主キー名1);
            JigyoHokokuTokeiDataEntity.setHokokuM(主キー名2);

            business = new JigyoHokokuTokeiData(JigyoHokokuTokeiDataEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の報告年は_設定した値と同じ報告年を返す() {
            business = sut.set報告年(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年).build();
            assertThat(business.get報告年(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告年));
        }

        @Test
        public void 戻り値の報告月は_設定した値と同じ報告月を返す() {
            business = sut.set報告月(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月).build();
            assertThat(business.get報告月(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_報告月));
        }

        @Test
        public void 戻り値の集計対象年は_設定した値と同じ集計対象年を返す() {
            business = sut.set集計対象年(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年).build();
            assertThat(business.get集計対象年(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象年));
        }

        @Test
        public void 戻り値の集計対象月は_設定した値と同じ集計対象月を返す() {
            business = sut.set集計対象月(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月).build();
            assertThat(business.get集計対象月(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計対象月));
        }

        @Test
        public void 戻り値の統計対象区分は_設定した値と同じ統計対象区分を返す() {
            business = sut.set統計対象区分(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分).build();
            assertThat(business.get統計対象区分(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_統計対象区分));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の表番号は_設定した値と同じ表番号を返す() {
            business = sut.set表番号(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号).build();
            assertThat(business.get表番号(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_表番号));
        }

        @Test
        public void 戻り値の集計番号は_設定した値と同じ集計番号を返す() {
            business = sut.set集計番号(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号).build();
            assertThat(business.get集計番号(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計番号));
        }

        @Test
        public void 戻り値の集計単位は_設定した値と同じ集計単位を返す() {
            business = sut.set集計単位(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位).build();
            assertThat(business.get集計単位(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計単位));
        }

        @Test
        public void 戻り値の縦番号は_設定した値と同じ縦番号を返す() {
            business = sut.set縦番号(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号).build();
            assertThat(business.get縦番号(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦番号));
        }

        @Test
        public void 戻り値の横番号は_設定した値と同じ横番号を返す() {
            business = sut.set横番号(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号).build();
            assertThat(business.get横番号(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横番号));
        }

        @Test
        public void 戻り値の集計結果値は_設定した値と同じ集計結果値を返す() {
            business = sut.set集計結果値(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計結果値).build();
            assertThat(business.get集計結果値(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計結果値));
        }

        @Test
        public void 戻り値の集計項目名称は_設定した値と同じ集計項目名称を返す() {
            business = sut.set集計項目名称(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計項目名称).build();
            assertThat(business.get集計項目名称(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_集計項目名称));
        }

        @Test
        public void 戻り値の縦項目コードは_設定した値と同じ縦項目コードを返す() {
            business = sut.set縦項目コード(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦項目コード).build();
            assertThat(business.get縦項目コード(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_縦項目コード));
        }

        @Test
        public void 戻り値の横項目コードは_設定した値と同じ横項目コードを返す() {
            business = sut.set横項目コード(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横項目コード).build();
            assertThat(business.get横項目コード(), is(DbT7021JigyoHokokuTokeiDataEntityGenerator.DEFAULT_横項目コード));
        }

    }
}
