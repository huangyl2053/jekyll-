/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
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
 * {@link KyufujissekiKinkyuShisetsuRyoyoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyufujissekiKinkyuShisetsuRyoyoBuilderTest extends DbcTestBase {

    private static DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity KyufujissekiKinkyuShisetsuRyoyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
    private static RString 緊急時施設療養情報レコード順次番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        交換情報識別番号 = DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_交換情報識別番号;
        入力識別番号 = DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_入力識別番号;
        レコード種別コード = DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_レコード種別コード;
        証記載保険者番号 = DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_証記載保険者番号;
        被保険者番号 = DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号;
        サービス提供年月 = DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月;
        事業所番号 = DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_事業所番号;
        通し番号 = DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通し番号;
        緊急時施設療養情報レコード順次番号 = DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時施設療養情報レコード順次番号;
    }

    public static class getterSetterTest extends DbcTestBase {

        private static KyufujissekiKinkyuShisetsuRyoyoBuilder sut;
        private static KyufujissekiKinkyuShisetsuRyoyo business;

        @Before
        public void setUp() {
            KyufujissekiKinkyuShisetsuRyoyoEntity = new DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity();
            KyufujissekiKinkyuShisetsuRyoyoEntity.setKokanJohoShikibetsuNo(交換情報識別番号);
            KyufujissekiKinkyuShisetsuRyoyoEntity.setInputShikibetsuNo(入力識別番号);
            KyufujissekiKinkyuShisetsuRyoyoEntity.setRecodeShubetsuCode(レコード種別コード);
            KyufujissekiKinkyuShisetsuRyoyoEntity.setShokisaiHokenshaNo(証記載保険者番号);
            KyufujissekiKinkyuShisetsuRyoyoEntity.setHiHokenshaNo(被保険者番号);
            KyufujissekiKinkyuShisetsuRyoyoEntity.setServiceTeikyoYM(サービス提供年月);
            KyufujissekiKinkyuShisetsuRyoyoEntity.setJigyoshoNo(事業所番号);
            KyufujissekiKinkyuShisetsuRyoyoEntity.setToshiNo(通し番号);
            KyufujissekiKinkyuShisetsuRyoyoEntity.setRecodeJunjiNo(緊急時施設療養情報レコード順次番号);

            business = new KyufujissekiKinkyuShisetsuRyoyo(KyufujissekiKinkyuShisetsuRyoyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の交換情報識別番号は_設定した値と同じ交換情報識別番号を返す() {
            business = sut.set交換情報識別番号(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_交換情報識別番号).build();
            assertThat(business.get交換情報識別番号(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_交換情報識別番号));
        }

        @Test
        public void 戻り値の入力識別番号は_設定した値と同じ入力識別番号を返す() {
            business = sut.set入力識別番号(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_入力識別番号).build();
            assertThat(business.get入力識別番号(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_入力識別番号));
        }

        @Test
        public void 戻り値のレコード種別コードは_設定した値と同じレコード種別コードを返す() {
            business = sut.setレコード種別コード(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_レコード種別コード).build();
            assertThat(business.getレコード種別コード(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_レコード種別コード));
        }

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値のサービス提供年月は_設定した値と同じサービス提供年月を返す() {
            business = sut.setサービス提供年月(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月).build();
            assertThat(business.getサービス提供年月(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_サービス提供年月));
        }

        @Test
        public void 戻り値の事業所番号は_設定した値と同じ事業所番号を返す() {
            business = sut.set事業所番号(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_事業所番号).build();
            assertThat(business.get事業所番号(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_事業所番号));
        }

        @Test
        public void 戻り値の通し番号は_設定した値と同じ通し番号を返す() {
            business = sut.set通し番号(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通し番号).build();
            assertThat(business.get通し番号(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通し番号));
        }

        @Test
        public void 戻り値の緊急時施設療養情報レコード順次番号は_設定した値と同じ緊急時施設療養情報レコード順次番号を返す() {
            business = sut.set緊急時施設療養情報レコード順次番号(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時施設療養情報レコード順次番号).build();
            assertThat(business.get緊急時施設療養情報レコード順次番号(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時施設療養情報レコード順次番号));
        }

        @Test
        public void 戻り値の緊急時傷病名１は_設定した値と同じ緊急時傷病名１を返す() {
            business = sut.set緊急時傷病名１(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名１).build();
            assertThat(business.get緊急時傷病名１(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名１));
        }

        @Test
        public void 戻り値の緊急時傷病名２は_設定した値と同じ緊急時傷病名２を返す() {
            business = sut.set緊急時傷病名２(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名２).build();
            assertThat(business.get緊急時傷病名２(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名２));
        }

        @Test
        public void 戻り値の緊急時傷病名３は_設定した値と同じ緊急時傷病名３を返す() {
            business = sut.set緊急時傷病名３(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名３).build();
            assertThat(business.get緊急時傷病名３(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時傷病名３));
        }

        @Test
        public void 戻り値の緊急時治療開始年月日１は_設定した値と同じ緊急時治療開始年月日１を返す() {
            business = sut.set緊急時治療開始年月日１(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日１).build();
            assertThat(business.get緊急時治療開始年月日１(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日１));
        }

        @Test
        public void 戻り値の緊急時治療開始年月日２は_設定した値と同じ緊急時治療開始年月日２を返す() {
            business = sut.set緊急時治療開始年月日２(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日２).build();
            assertThat(business.get緊急時治療開始年月日２(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日２));
        }

        @Test
        public void 戻り値の緊急時治療開始年月日３は_設定した値と同じ緊急時治療開始年月日３を返す() {
            business = sut.set緊急時治療開始年月日３(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日３).build();
            assertThat(business.get緊急時治療開始年月日３(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療開始年月日３));
        }

        @Test
        public void 戻り値の往診日数は_設定した値と同じ往診日数を返す() {
            business = sut.set往診日数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診日数).build();
            assertThat(business.get往診日数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診日数));
        }

        @Test
        public void 戻り値の往診医療機関名は_設定した値と同じ往診医療機関名を返す() {
            business = sut.set往診医療機関名(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診医療機関名).build();
            assertThat(business.get往診医療機関名(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_往診医療機関名));
        }

        @Test
        public void 戻り値の通院日数は_設定した値と同じ通院日数を返す() {
            business = sut.set通院日数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院日数).build();
            assertThat(business.get通院日数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院日数));
        }

        @Test
        public void 戻り値の通院医療機関名は_設定した値と同じ通院医療機関名を返す() {
            business = sut.set通院医療機関名(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院医療機関名).build();
            assertThat(business.get通院医療機関名(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_通院医療機関名));
        }

        @Test
        public void 戻り値の緊急時治療管理単位数は_設定した値と同じ緊急時治療管理単位数を返す() {
            business = sut.set緊急時治療管理単位数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理単位数).build();
            assertThat(business.get緊急時治療管理単位数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理単位数));
        }

        @Test
        public void 戻り値の緊急時治療管理日数は_設定した値と同じ緊急時治療管理日数を返す() {
            business = sut.set緊急時治療管理日数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理日数).build();
            assertThat(business.get緊急時治療管理日数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理日数));
        }

        @Test
        public void 戻り値の緊急時治療管理小計は_設定した値と同じ緊急時治療管理小計を返す() {
            business = sut.set緊急時治療管理小計(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理小計).build();
            assertThat(business.get緊急時治療管理小計(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時治療管理小計));
        }

        @Test
        public void 戻り値のリハビリテーション点数は_設定した値と同じリハビリテーション点数を返す() {
            business = sut.setリハビリテーション点数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_リハビリテーション点数).build();
            assertThat(business.getリハビリテーション点数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_リハビリテーション点数));
        }

        @Test
        public void 戻り値の処置点数は_設定した値と同じ処置点数を返す() {
            business = sut.set処置点数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_処置点数).build();
            assertThat(business.get処置点数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_処置点数));
        }

        @Test
        public void 戻り値の手術点数は_設定した値と同じ手術点数を返す() {
            business = sut.set手術点数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_手術点数).build();
            assertThat(business.get手術点数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_手術点数));
        }

        @Test
        public void 戻り値の麻酔点数は_設定した値と同じ麻酔点数を返す() {
            business = sut.set麻酔点数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_麻酔点数).build();
            assertThat(business.get麻酔点数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_麻酔点数));
        }

        @Test
        public void 戻り値の放射線治療点数は_設定した値と同じ放射線治療点数を返す() {
            business = sut.set放射線治療点数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_放射線治療点数).build();
            assertThat(business.get放射線治療点数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_放射線治療点数));
        }

        @Test
        public void 戻り値の摘要１は_設定した値と同じ摘要１を返す() {
            business = sut.set摘要１(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１).build();
            assertThat(business.get摘要１(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１));
        }

        @Test
        public void 戻り値の摘要２は_設定した値と同じ摘要２を返す() {
            business = sut.set摘要２(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２).build();
            assertThat(business.get摘要２(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２));
        }

        @Test
        public void 戻り値の摘要３は_設定した値と同じ摘要３を返す() {
            business = sut.set摘要３(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要３).build();
            assertThat(business.get摘要３(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要３));
        }

        @Test
        public void 戻り値の摘要４は_設定した値と同じ摘要４を返す() {
            business = sut.set摘要４(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要４).build();
            assertThat(business.get摘要４(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要４));
        }

        @Test
        public void 戻り値の摘要５は_設定した値と同じ摘要５を返す() {
            business = sut.set摘要５(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要５).build();
            assertThat(business.get摘要５(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要５));
        }

        @Test
        public void 戻り値の摘要６は_設定した値と同じ摘要６を返す() {
            business = sut.set摘要６(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要６).build();
            assertThat(business.get摘要６(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要６));
        }

        @Test
        public void 戻り値の摘要７は_設定した値と同じ摘要７を返す() {
            business = sut.set摘要７(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要７).build();
            assertThat(business.get摘要７(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要７));
        }

        @Test
        public void 戻り値の摘要８は_設定した値と同じ摘要８を返す() {
            business = sut.set摘要８(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要８).build();
            assertThat(business.get摘要８(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要８));
        }

        @Test
        public void 戻り値の摘要９は_設定した値と同じ摘要９を返す() {
            business = sut.set摘要９(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要９).build();
            assertThat(business.get摘要９(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要９));
        }

        @Test
        public void 戻り値の摘要１０は_設定した値と同じ摘要１０を返す() {
            business = sut.set摘要１０(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１０).build();
            assertThat(business.get摘要１０(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１０));
        }

        @Test
        public void 戻り値の摘要１１は_設定した値と同じ摘要１１を返す() {
            business = sut.set摘要１１(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１１).build();
            assertThat(business.get摘要１１(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１１));
        }

        @Test
        public void 戻り値の摘要１２は_設定した値と同じ摘要１２を返す() {
            business = sut.set摘要１２(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１２).build();
            assertThat(business.get摘要１２(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１２));
        }

        @Test
        public void 戻り値の摘要１３は_設定した値と同じ摘要１３を返す() {
            business = sut.set摘要１３(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１３).build();
            assertThat(business.get摘要１３(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１３));
        }

        @Test
        public void 戻り値の摘要１４は_設定した値と同じ摘要１４を返す() {
            business = sut.set摘要１４(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１４).build();
            assertThat(business.get摘要１４(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１４));
        }

        @Test
        public void 戻り値の摘要１５は_設定した値と同じ摘要１５を返す() {
            business = sut.set摘要１５(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１５).build();
            assertThat(business.get摘要１５(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１５));
        }

        @Test
        public void 戻り値の摘要１６は_設定した値と同じ摘要１６を返す() {
            business = sut.set摘要１６(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１６).build();
            assertThat(business.get摘要１６(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１６));
        }

        @Test
        public void 戻り値の摘要１７は_設定した値と同じ摘要１７を返す() {
            business = sut.set摘要１７(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１７).build();
            assertThat(business.get摘要１７(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１７));
        }

        @Test
        public void 戻り値の摘要１８は_設定した値と同じ摘要１８を返す() {
            business = sut.set摘要１８(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１８).build();
            assertThat(business.get摘要１８(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１８));
        }

        @Test
        public void 戻り値の摘要１９は_設定した値と同じ摘要１９を返す() {
            business = sut.set摘要１９(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１９).build();
            assertThat(business.get摘要１９(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要１９));
        }

        @Test
        public void 戻り値の摘要２０は_設定した値と同じ摘要２０を返す() {
            business = sut.set摘要２０(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２０).build();
            assertThat(business.get摘要２０(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_摘要２０));
        }

        @Test
        public void 戻り値の緊急時施設療養費合計点数は_設定した値と同じ緊急時施設療養費合計点数を返す() {
            business = sut.set緊急時施設療養費合計点数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時施設療養費合計点数).build();
            assertThat(business.get緊急時施設療養費合計点数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_緊急時施設療養費合計点数));
        }

        @Test
        public void 戻り値の後_往診日数は_設定した値と同じ後_往診日数を返す() {
            business = sut.set後_往診日数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_往診日数).build();
            assertThat(business.get後_往診日数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_往診日数));
        }

        @Test
        public void 戻り値の後_通院日数は_設定した値と同じ後_通院日数を返す() {
            business = sut.set後_通院日数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_通院日数).build();
            assertThat(business.get後_通院日数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_通院日数));
        }

        @Test
        public void 戻り値の後_緊急時治療管理単位数は_設定した値と同じ後_緊急時治療管理単位数を返す() {
            business = sut.set後_緊急時治療管理単位数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_緊急時治療管理単位数).build();
            assertThat(business.get後_緊急時治療管理単位数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_緊急時治療管理単位数
            )
            );
        }

        @Test
        public void 戻り値の後_緊急時治療管理日数は_設定した値と同じ後_緊急時治療管理日数を返す() {
            business = sut.set後_緊急時治療管理日数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_緊急時治療管理日数
            ).build();
            assertThat(business.get後_緊急時治療管理日数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_緊急時治療管理日数
            )
            );
        }

        @Test
        public void 戻り値の後_リハビリテーション点数は_設定した値と同じ後_リハビリテーション点数を返す() {
            business = sut.set後_リハビリテーション点数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_リハビリテーション点数
            ).build();
            assertThat(business.get後_リハビリテーション点数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_リハビリテーション点数
            )
            );
        }

        @Test
        public void 戻り値の後_処置点数は_設定した値と同じ後_処置点数を返す() {
            business = sut.set後_処置点数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_処置点数
            ).build();
            assertThat(business.get後_処置点数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_処置点数
            )
            );
        }

        @Test
        public void 戻り値の後_手術点数は_設定した値と同じ後_手術点数を返す() {
            business = sut.set後_手術点数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_手術点数
            ).build();
            assertThat(business.get後_手術点数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_手術点数
            )
            );
        }

        @Test
        public void 戻り値の後_麻酔点数は_設定した値と同じ後_麻酔点数を返す() {
            business = sut.set後_麻酔点数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_麻酔点数
            ).build();
            assertThat(business.get後_麻酔点数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_麻酔点数
            )
            );
        }

        @Test
        public void 戻り値の後_放射線治療点数は_設定した値と同じ後_放射線治療点数を返す() {
            business = sut.set後_放射線治療点数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_放射線治療点数
            ).build();
            assertThat(business.get後_放射線治療点数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_後_放射線治療点数
            )
            );
        }

        @Test
        public void 戻り値の再審査回数は_設定した値と同じ再審査回数を返す() {
            business = sut.set再審査回数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_再審査回数).build();
            assertThat(business.get再審査回数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_再審査回数));
        }

        @Test
        public void 戻り値の過誤回数は_設定した値と同じ過誤回数を返す() {
            business = sut.set過誤回数(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_過誤回数).build();
            assertThat(business.get過誤回数(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_過誤回数));
        }

        @Test
        public void 戻り値の審査年月は_設定した値と同じ審査年月を返す() {
            business = sut.set審査年月(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_審査年月).build();
            assertThat(business.get審査年月(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_審査年月));
        }

        @Test
        public void 戻り値の整理番号は_設定した値と同じ整理番号を返す() {
            business = sut.set整理番号(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_整理番号).build();
            assertThat(business.get整理番号(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_整理番号));
        }

        @Test
        public void 戻り値の取込年月は_設定した値と同じ取込年月を返す() {
            business = sut.set取込年月(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_取込年月).build();
            assertThat(business.get取込年月(), is(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntityGenerator.DEFAULT_取込年月));
        }

    }
}
