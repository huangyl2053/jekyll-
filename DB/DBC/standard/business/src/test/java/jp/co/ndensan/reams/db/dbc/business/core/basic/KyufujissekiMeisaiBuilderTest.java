/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3018KyufujissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3018KyufujissekiMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
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
 * {@link KyufujissekiMeisaiBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiMeisaiBuilderTest extends DbcTestBase {

    private static DbT3018KyufujissekiMeisaiEntity KyufujissekiMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 交換情報識別番号;
    private static NyuryokuShikibetsuNo 入力識別番号;
    private static RString レコード種別コード;
    private static HokenshaNo 証記載保険者番号;
    private static HihokenshaNo 被保険者番号;
    private static FlexibleYearMonth サービス提供年月;
    private static JigyoshaNo 事業所番号;
    private static RString 通し番号;
    private static ServiceShuruiCode サービス種類コード;
    private static ServiceKomokuCode サービス項目コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_通し番号;
        サービス種類コード = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス種類コード;
        サービス項目コード = DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス項目コード;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufujissekiMeisaiBuilder sut;
        private static KyufujissekiMeisai business;

        @Before
        public void setUp() {
            KyufujissekiMeisaiEntity = new DbT3018KyufujissekiMeisaiEntity();
            KyufujissekiMeisaiEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiMeisaiEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiMeisaiEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiMeisaiEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiMeisaiEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiMeisaiEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiMeisaiEntity.setJigyoshoNo(事業所番号);
            KyufujissekiMeisaiEntity.setToshiNo(通し番号);
            KyufujissekiMeisaiEntity.setServiceShuruiCode(サービス種類コード);
            KyufujissekiMeisaiEntity.setServiceKomokuCode(サービス項目コード);

            business = new KyufujissekiMeisai(KyufujissekiMeisaiEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値のサービス種類コードは_設定した値と同じサービス種類コードを返す() {
            business = sut.setサービス種類コード(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス種類コード).build();
            assertThat(business.getサービス種類コード(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス種類コード));
        }

        @Test
        public void 戻り値のサービス項目コードは_設定した値と同じサービス項目コードを返す() {
            business = sut.setサービス項目コード(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス項目コード).build();
            assertThat(business.getサービス項目コード(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス項目コード));
        }

        @Test
        public void 戻り値の単位数は_設定した値と同じ単位数を返す() {
            business = sut.set単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_単位数).build();
            assertThat(business.get単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_単位数));
        }

        @Test
        public void 戻り値の日数_回数は_設定した値と同じ日数_回数を返す() {
            business = sut.set日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_日数_回数
            ).build();
            assertThat(business.get日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_日数_回数
            )
            );
        }

        @Test
        public void 戻り値の公費１対象日数_回数は_設定した値と同じ公費１対象日数_回数を返す() {
            business = sut.set公費１対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費１対象日数_回数
            ).build();
            assertThat(business.get公費１対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費１対象日数_回数
            )
            );
        }

        @Test
        public void 戻り値の公費２対象日数_回数は_設定した値と同じ公費２対象日数_回数を返す() {
            business = sut.set公費２対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費２対象日数_回数
            ).build();
            assertThat(business.get公費２対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費２対象日数_回数
            )
            );
        }

        @Test
        public void 戻り値の公費３対象日数_回数は_設定した値と同じ公費３対象日数_回数を返す() {
            business = sut.set公費３対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費３対象日数_回数
            ).build();
            assertThat(business.get公費３対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費３対象日数_回数
            )
            );
        }

        @Test
        public void 戻り値のサービス単位数は_設定した値と同じサービス単位数を返す() {
            business = sut.setサービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス単位数).build();
            assertThat(business.getサービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_サービス単位数));
        }

        @Test
        public void 戻り値の公費１対象サービス単位数は_設定した値と同じ公費１対象サービス単位数を返す() {
            business = sut.set公費１対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費１対象サービス単位数).build();
            assertThat(business.get公費１対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費１対象サービス単位数));
        }

        @Test
        public void 戻り値の公費２対象サービス単位数は_設定した値と同じ公費２対象サービス単位数を返す() {
            business = sut.set公費２対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費２対象サービス単位数).build();
            assertThat(business.get公費２対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費２対象サービス単位数));
        }

        @Test
        public void 戻り値の公費３対象サービス単位数は_設定した値と同じ公費３対象サービス単位数を返す() {
            business = sut.set公費３対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費３対象サービス単位数).build();
            assertThat(business.get公費３対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_公費３対象サービス単位数));
        }

        @Test
        public void 戻り値の摘要は_設定した値と同じ摘要を返す() {
            business = sut.set摘要(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_摘要).build();
            assertThat(business.get摘要(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_摘要));
        }

        @Test
        public void 戻り値の後_単位数は_設定した値と同じ後_単位数を返す() {
            business = sut.set後_単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_単位数
            ).build();
            assertThat(business.get後_単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_単位数
            )
            );
        }

        @Test
        public void 戻り値の後_日数_回数は_設定した値と同じ後_日数_回数を返す() {
            business = sut.set後_日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_日数_回数
            ).build();
            assertThat(business.get後_日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_日数_回数
            )
            );
        }

        @Test
        public void 戻り値の後_公費１対象日数_回数は_設定した値と同じ後_公費１対象日数_回数を返す() {
            business = sut.set後_公費１対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費１対象日数_回数
            ).build();
            assertThat(business.get後_公費１対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費１対象日数_回数
            )
            );
        }

        @Test
        public void 戻り値の後_公費２対象日数_回数は_設定した値と同じ後_公費２対象日数_回数を返す() {
            business = sut.set後_公費２対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費２対象日数_回数
            ).build();
            assertThat(business.get後_公費２対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費２対象日数_回数
            )
            );
        }

        @Test
        public void 戻り値の後_公費３対象日数_回数は_設定した値と同じ後_公費３対象日数_回数を返す() {
            business = sut.set後_公費３対象日数_回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費３対象日数_回数
            ).build();
            assertThat(business.get後_公費３対象日数_回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費３対象日数_回数
            )
            );
        }

        @Test
        public void 戻り値の後_サービス単位数は_設定した値と同じ後_サービス単位数を返す() {
            business = sut.set後_サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_サービス単位数
            ).build();
            assertThat(business.get後_サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_サービス単位数
            )
            );
        }

        @Test
        public void 戻り値の後_公費１対象サービス単位数は_設定した値と同じ後_公費１対象サービス単位数を返す() {
            business = sut.set後_公費１対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費１対象サービス単位数
            ).build();
            assertThat(business.get後_公費１対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費１対象サービス単位数
            )
            );
        }

        @Test
        public void 戻り値の後_公費２対象サービス単位数は_設定した値と同じ後_公費２対象サービス単位数を返す() {
            business = sut.set後_公費２対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費２対象サービス単位数
            ).build();
            assertThat(business.get後_公費２対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費２対象サービス単位数
            )
            );
        }

        @Test
        public void 戻り値の後_公費３対象サービス単位数は_設定した値と同じ後_公費３対象サービス単位数を返す() {
            business = sut.set後_公費３対象サービス単位数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費３対象サービス単位数
            ).build();
            assertThat(business.get後_公費３対象サービス単位数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_後_公費３対象サービス単位数
            )
            );
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            business = sut.set再審査回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_再審査回数).build();
            assertThat(business.get再審査回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            business = sut.set過誤回数(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_過誤回数).build();
            assertThat(business.get過誤回数(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3018KyufujissekiMeisaiEntityGenerator.DEFAULT_取込年月));
        }

    }
}
