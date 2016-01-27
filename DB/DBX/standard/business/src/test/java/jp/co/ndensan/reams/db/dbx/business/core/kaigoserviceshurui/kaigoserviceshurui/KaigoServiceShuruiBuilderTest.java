/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui;

import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7131KaigoServiceNaiyouEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigoserviceshurui.KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
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
 * {@link KaigoServiceShuruiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiBuilderTest extends DbxTestBase {

    private static DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity;

    private static KaigoServiceShuruiCode サービス種類コード;
    private static FlexibleYearMonth 提供開始年月;
    private static RString サービス項目コード;
    private static Decimal 履歴番号;

    @BeforeClass
    public static void setUpClass() {
        サービス種類コード = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
        提供開始年月 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
        サービス項目コード = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_サービス項目コード;
        履歴番号 = DbT7131KaigoServiceNaiyouEntityGenerator.DEFAULT_履歴番号;
    }

    public static class SeishinTechoNiniテスト extends DbxTestBase {

        private static KaigoServiceShuruiBuilder sut;
        private static KaigoServiceShurui business;
        private static KaigoServiceNaiyou kaigoServiceNaiyou;

        @Before
        public void setUp() {
            kaigoServiceShuruiEntity = DbT7130KaigoServiceShuruiEntityGenerator.createDbT7130KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.setServiceShuruiCd(サービス種類コード);
            kaigoServiceShuruiEntity.setTeikyoKaishiYM(提供開始年月);

            KaigoServiceShuruiEntity entity = new KaigoServiceShuruiEntity();
            entity.set介護サービス種類Entity(kaigoServiceShuruiEntity);
            business = new KaigoServiceShurui(entity);
            kaigoServiceNaiyou = new KaigoServiceNaiyou(サービス種類コード, サービス項目コード, 提供開始年月, 履歴番号);
            sut = business.createBuilderForEdit();
        }

        @Test
        public void 介護サービス種類に紐づくことが可能な子テーブル情報をsetSeishinTechoNiniで設定した場合_設定済みの子テーブル情報が返る() {
            business = sut.setKaigoServiceNaiyou(kaigoServiceNaiyou).build();
            assertThat(business.getKaigoServiceNaiyouList().size(), is(1));
        }
    }

    public static class getterSetterTest extends DbxTestBase {

        private static KaigoServiceShuruiBuilder sut;
        private static KaigoServiceShurui business;

        @Before
        public void setUp() {
            kaigoServiceShuruiEntity = new DbT7130KaigoServiceShuruiEntity();
            kaigoServiceShuruiEntity.setServiceShuruiCd(サービス種類コード);
            kaigoServiceShuruiEntity.setTeikyoKaishiYM(提供開始年月);

            KaigoServiceShuruiEntity entity = new KaigoServiceShuruiEntity();
            entity.set介護サービス種類Entity(kaigoServiceShuruiEntity);
            business = new KaigoServiceShurui(entity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の提供終了年月は_設定した値と同じ提供終了年月を返す() {
            business = sut.set提供終了年月(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供終了年月).build();
            assertThat(business.get提供終了年月(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供終了年月));
        }

        @Test
        public void 戻り値のサービス種類名称は_設定した値と同じサービス種類名称を返す() {
            business = sut.setサービス種類名称(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類名称).build();
            assertThat(business.getサービス種類名称(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類名称));
        }

        @Test
        public void 戻り値のサービス種類略称は_設定した値と同じサービス種類略称を返す() {
            business = sut.setサービス種類略称(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類略称).build();
            assertThat(business.getサービス種類略称(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類略称));
        }

        @Test
        public void 戻り値のサービス分類コードは_設定した値と同じサービス分類コードを返す() {
            business = sut.setサービス分類コード(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス分類コード).build();
            assertThat(business.getサービス分類コード(), is(DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス分類コード));
        }

    }
}
