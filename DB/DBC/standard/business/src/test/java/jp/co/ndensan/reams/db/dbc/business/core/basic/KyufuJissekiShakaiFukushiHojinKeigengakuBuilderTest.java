/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyufuJissekiShakaiFukushiHojinKeigengakuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufuJissekiShakaiFukushiHojinKeigengakuBuilderTest extends DbcTestBase {

    private static DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity KyufuJissekiShakaiFukushiHojinKeigengakuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 主キー名1;
    private static NyuryokuShikibetsuNo 主キー名2;
    private static RString 主キー名3;
    private static HokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static FlexibleYearMonth 主キー名6;
    private static JigyoshaNo 主キー名7;
    private static RString 主キー名8;
    private static ServiceShuruiCode 主キー名9;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_交換情報識別番号;
        主キー名2 = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_入力識別番号;
        主キー名3 = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_レコード種別コード;
        主キー名4 = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス提供年月;
        主キー名7 = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_事業所番号;
        主キー名8 = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_通し番号;
        主キー名9 = DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス種類コード;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufuJissekiShakaiFukushiHojinKeigengakuBuilder sut;
        private static KyufuJissekiShakaiFukushiHojinKeigengaku business;

        @Before
        public void setUp() {
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity = new DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufuJissekiShakaiFukushiHojinKeigengakuEntity.setInputShikibetsuNo(主キー名2);

            business = new KyufuJissekiShakaiFukushiHojinKeigengaku(KyufuJissekiShakaiFukushiHojinKeigengakuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の軽減率は_設定した値と同じ軽減率を返す() {
            business = sut.set軽減率(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減率).build();
            assertThat(business.get軽減率(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減率));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値の受領すべき利用者負担の総額は_設定した値と同じ受領すべき利用者負担の総額を返す() {
            business = sut.set受領すべき利用者負担の総額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_受領すべき利用者負担の総額).build();
            assertThat(business.get受領すべき利用者負担の総額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_受領すべき利用者負担の総額));
        }

        @Test
        public void 戻り値の軽減額は_設定した値と同じ軽減額を返す() {
            business = sut.set軽減額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減額).build();
            assertThat(business.get軽減額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減額));
        }

        @Test
        public void 戻り値の軽減後利用者負担額は_設定した値と同じ軽減後利用者負担額を返す() {
            business = sut.set軽減後利用者負担額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減後利用者負担額).build();
            assertThat(business.get軽減後利用者負担額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_軽減後利用者負担額));
        }

        @Test
        public void 戻り値の備考は_設定した値と同じ備考を返す() {
            business = sut.set備考(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_備考).build();
            assertThat(business.get備考(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_備考));
        }

        @Test
        public void 戻り値の後_受領すべき利用者負担の総額は_設定した値と同じ後_受領すべき利用者負担の総額を返す() {
            business = sut.set後_受領すべき利用者負担の総額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_受領すべき利用者負担の総額).build();
            assertThat(business.get後_受領すべき利用者負担の総額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_受領すべき利用者負担の総額));
        }

        @Test
        public void 戻り値の後_軽減額は_設定した値と同じ後_軽減額を返す() {
            business = sut.set後_軽減額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_軽減額).build();
            assertThat(business.get後_軽減額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_軽減額));
        }

        @Test
        public void 戻り値の後_軽減後利用者負担額は_設定した値と同じ後_軽減後利用者負担額を返す() {
            business = sut.set後_軽減後利用者負担額(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_軽減後利用者負担額).build();
            assertThat(business.get後_軽減後利用者負担額(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_後_軽減後利用者負担額));
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            business = sut.set再審査回数(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_再審査回数).build();
            assertThat(business.get再審査回数(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            business = sut.set過誤回数(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_過誤回数).build();
            assertThat(business.get過誤回数(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityGenerator.DEFAULT_取込年月));
        }

    }
}
