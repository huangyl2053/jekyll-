/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3020KyufujissekiTokuteiSinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3020KyufujissekiTokuteiSinryohiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Ignore;

/**
 * {@link KyufujissekiTokuteiSinryohi}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufujissekiTokuteiSinryohiTest extends DbcTestBase {

    private static DbT3020KyufujissekiTokuteiSinryohiEntity KyufujissekiTokuteiSinryohiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
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
    private static RString 主キー名9;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_交換情報識別番号;
        主キー名2 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_入力識別番号;
        主キー名3 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_レコード種別コード;
        主キー名4 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名7 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_事業所番号;
        主キー名8 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_通し番号;
        主キー名9 = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.DEFAULT_特定診療情報レコード順次番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryohi sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryohiEntity = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.createDbT3020KyufujissekiTokuteiSinryohiEntity();
            KyufujissekiTokuteiSinryohiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiTokuteiSinryohiEntity.setInputShikibetsuNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiTokuteiSinryohi(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KyufujissekiTokuteiSinryohi(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9);
        }

        @Test
        public void 指定したキーが保持するDbT3020KyufujissekiTokuteiSinryohiEntityにセットされている() {
            sut = new KyufujissekiTokuteiSinryohi(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9);
            assertThat(sut.get交換情報識別番号(), is(主キー名1));
            assertThat(sut.get入力識別番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKyufujissekiTokuteiSinryohiIdentifierにセットされている() {
            sut = new KyufujissekiTokuteiSinryohi(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7, 主キー名8, 主キー名9);
            assertThat(sut.identifier().get交換情報識別番号(), is(主キー名1));
            assertThat(sut.identifier().get入力識別番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryohi sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryohiEntity = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.createDbT3020KyufujissekiTokuteiSinryohiEntity();
            KyufujissekiTokuteiSinryohiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiTokuteiSinryohiEntity.setInputShikibetsuNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KyufujissekiTokuteiSinryohi(null);
        }

        @Test
        public void 指定したDbT3020KyufujissekiTokuteiSinryohiEntityのキー情報を識別子が持つ() {

            sut = new KyufujissekiTokuteiSinryohi(KyufujissekiTokuteiSinryohiEntity);

            assertThat(sut.identifier().get交換情報識別番号(), is(主キー名1));
            assertThat(sut.identifier().get入力識別番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryohi sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryohiEntity = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.createDbT3020KyufujissekiTokuteiSinryohiEntity();
            KyufujissekiTokuteiSinryohiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiTokuteiSinryohiEntity.setInputShikibetsuNo(主キー名2);

            sut = new KyufujissekiTokuteiSinryohi(KyufujissekiTokuteiSinryohiEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KyufujissekiTokuteiSinryohiEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get入力識別番号は_entityが持つ入力識別番号を返す() {
            assertThat(sut.get入力識別番号(), is(KyufujissekiTokuteiSinryohiEntity.getInputShikibetsuNo()));
        }

        @Test
        public void getレコード種別コードは_entityが持つレコード種別コードを返す() {
            assertThat(sut.getレコード種別コード(), is(KyufujissekiTokuteiSinryohiEntity.getRecodeShubetsuCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KyufujissekiTokuteiSinryohiEntity.getShokisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KyufujissekiTokuteiSinryohiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(KyufujissekiTokuteiSinryohiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get事業所番号は_entityが持つ事業所番号を返す() {
            assertThat(sut.get事業所番号(), is(KyufujissekiTokuteiSinryohiEntity.getJigyoshoNo()));
        }

        @Test
        public void get通し番号は_entityが持つ通し番号を返す() {
            assertThat(sut.get通し番号(), is(KyufujissekiTokuteiSinryohiEntity.getToshiNo()));
        }

        @Test
        public void get特定診療情報レコード順次番号は_entityが持つ特定診療情報レコード順次番号を返す() {
            assertThat(sut.get特定診療情報レコード順次番号(), is(KyufujissekiTokuteiSinryohiEntity.getRecodeJunjiNo()));
        }

        @Test
        public void get傷病名は_entityが持つ傷病名を返す() {
            assertThat(sut.get傷病名(), is(KyufujissekiTokuteiSinryohiEntity.getShobyoName()));
        }

        @Test
        public void get保険_指導管理料等は_entityが持つ保険_指導管理料等を返す() {
            assertThat(sut.get保険_指導管理料等(), is(KyufujissekiTokuteiSinryohiEntity.getHokenShidoKanriryo()));
        }

        @Test
        public void get保険_単純エックス線は_entityが持つ保険_単純エックス線を返す() {
            assertThat(sut.get保険_単純エックス線(), is(KyufujissekiTokuteiSinryohiEntity.getHokenTanjunXsen()));
        }

        @Test
        public void get保険_リハビリテーションは_entityが持つ保険_リハビリテーションを返す() {
            assertThat(sut.get保険_リハビリテーション(), is(KyufujissekiTokuteiSinryohiEntity.getHokenRehabilitation()));
        }

        @Test
        public void get保険_精神科専門療法は_entityが持つ保険_精神科専門療法を返す() {
            assertThat(sut.get保険_精神科専門療法(), is(KyufujissekiTokuteiSinryohiEntity.getHokenSeishinkaSemmonRyoho()));
        }

        @Test
        public void get保険_合計単位数は_entityが持つ保険_合計単位数を返す() {
            assertThat(sut.get保険_合計単位数(), is(KyufujissekiTokuteiSinryohiEntity.getHokenTotalTanisu()));
        }

        @Test
        public void get公費１_指導管理料等は_entityが持つ公費１_指導管理料等を返す() {
            assertThat(sut.get公費１_指導管理料等(), is(KyufujissekiTokuteiSinryohiEntity.getKohi1ShidoKanriryo()));
        }

        @Test
        public void get公費１_単純エックス線は_entityが持つ公費１_単純エックス線を返す() {
            assertThat(sut.get公費１_単純エックス線(), is(KyufujissekiTokuteiSinryohiEntity.getKohi1TanjunXsen()));
        }

        @Test
        public void get公費１_リハビリテーションは_entityが持つ公費１_リハビリテーションを返す() {
            assertThat(sut.get公費１_リハビリテーション(), is(KyufujissekiTokuteiSinryohiEntity.getKohi1Rehabilitation()));
        }

        @Test
        public void get公費１_精神科専門療法は_entityが持つ公費１_精神科専門療法を返す() {
            assertThat(sut.get公費１_精神科専門療法(), is(KyufujissekiTokuteiSinryohiEntity.getKohi1SeishinkaSemmonRyoho()));
        }

        @Test
        public void get公費１_合計単位数は_entityが持つ公費１_合計単位数を返す() {
            assertThat(sut.get公費１_合計単位数(), is(KyufujissekiTokuteiSinryohiEntity.getKohi1TotalTanisu()));
        }

        @Test
        public void get公費２_指導管理料等は_entityが持つ公費２_指導管理料等を返す() {
            assertThat(sut.get公費２_指導管理料等(), is(KyufujissekiTokuteiSinryohiEntity.getKohi2ShidoKanriryo()));
        }

        @Test
        public void get公費２_単純エックス線は_entityが持つ公費２_単純エックス線を返す() {
            assertThat(sut.get公費２_単純エックス線(), is(KyufujissekiTokuteiSinryohiEntity.getKohi2TanjunXsen()));
        }

        @Test
        public void get公費２_リハビリテーションは_entityが持つ公費２_リハビリテーションを返す() {
            assertThat(sut.get公費２_リハビリテーション(), is(KyufujissekiTokuteiSinryohiEntity.getKohi2Rehabilitation()));
        }

        @Test
        public void get公費２_精神科専門療法は_entityが持つ公費２_精神科専門療法を返す() {
            assertThat(sut.get公費２_精神科専門療法(), is(KyufujissekiTokuteiSinryohiEntity.getKohi2SeishinkaSemmonRyoho()));
        }

        @Test
        public void get公費２_合計単位数は_entityが持つ公費２_合計単位数を返す() {
            assertThat(sut.get公費２_合計単位数(), is(KyufujissekiTokuteiSinryohiEntity.getKohi2TotalTanisu()));
        }

        @Test
        public void get公費３_指導管理料等は_entityが持つ公費３_指導管理料等を返す() {
            assertThat(sut.get公費３_指導管理料等(), is(KyufujissekiTokuteiSinryohiEntity.getKohi3ShidoKanriryo()));
        }

        @Test
        public void get公費３_単純エックス線は_entityが持つ公費３_単純エックス線を返す() {
            assertThat(sut.get公費３_単純エックス線(), is(KyufujissekiTokuteiSinryohiEntity.getKohi3TanjunXsen()));
        }

        @Test
        public void get公費３_リハビリテーションは_entityが持つ公費３_リハビリテーションを返す() {
            assertThat(sut.get公費３_リハビリテーション(), is(KyufujissekiTokuteiSinryohiEntity.getKohi3Rehabilitation()));
        }

        @Test
        public void get公費３_精神科専門療法は_entityが持つ公費３_精神科専門療法を返す() {
            assertThat(sut.get公費３_精神科専門療法(), is(KyufujissekiTokuteiSinryohiEntity.getKohi3SeishinkaSemmonRyoho()));
        }

        @Test
        public void get公費３_合計単位数は_entityが持つ公費３_合計単位数を返す() {
            assertThat(sut.get公費３_合計単位数(), is(KyufujissekiTokuteiSinryohiEntity.getKohi3TotalTanisu()));
        }

        @Test
        public void get摘要１は_entityが持つ摘要１を返す() {
            assertThat(sut.get摘要１(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo1()));
        }

        @Test
        public void get摘要２は_entityが持つ摘要２を返す() {
            assertThat(sut.get摘要２(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo2()));
        }

        @Test
        public void get摘要３は_entityが持つ摘要３を返す() {
            assertThat(sut.get摘要３(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo3()));
        }

        @Test
        public void get摘要４は_entityが持つ摘要４を返す() {
            assertThat(sut.get摘要４(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo4()));
        }

        @Test
        public void get摘要５は_entityが持つ摘要５を返す() {
            assertThat(sut.get摘要５(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo5()));
        }

        @Test
        public void get摘要６は_entityが持つ摘要６を返す() {
            assertThat(sut.get摘要６(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo6()));
        }

        @Test
        public void get摘要７は_entityが持つ摘要７を返す() {
            assertThat(sut.get摘要７(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo7()));
        }

        @Test
        public void get摘要８は_entityが持つ摘要８を返す() {
            assertThat(sut.get摘要８(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo8()));
        }

        @Test
        public void get摘要９は_entityが持つ摘要９を返す() {
            assertThat(sut.get摘要９(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo9()));
        }

        @Test
        public void get摘要１０は_entityが持つ摘要１０を返す() {
            assertThat(sut.get摘要１０(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo10()));
        }

        @Test
        public void get摘要１１は_entityが持つ摘要１１を返す() {
            assertThat(sut.get摘要１１(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo11()));
        }

        @Test
        public void get摘要１２は_entityが持つ摘要１２を返す() {
            assertThat(sut.get摘要１２(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo12()));
        }

        @Test
        public void get摘要１３は_entityが持つ摘要１３を返す() {
            assertThat(sut.get摘要１３(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo13()));
        }

        @Test
        public void get摘要１４は_entityが持つ摘要１４を返す() {
            assertThat(sut.get摘要１４(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo14()));
        }

        @Test
        public void get摘要１５は_entityが持つ摘要１５を返す() {
            assertThat(sut.get摘要１５(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo15()));
        }

        @Test
        public void get摘要１６は_entityが持つ摘要１６を返す() {
            assertThat(sut.get摘要１６(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo16()));
        }

        @Test
        public void get摘要１７は_entityが持つ摘要１７を返す() {
            assertThat(sut.get摘要１７(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo17()));
        }

        @Test
        public void get摘要１８は_entityが持つ摘要１８を返す() {
            assertThat(sut.get摘要１８(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo18()));
        }

        @Test
        public void get摘要１９は_entityが持つ摘要１９を返す() {
            assertThat(sut.get摘要１９(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo19()));
        }

        @Test
        public void get摘要２０は_entityが持つ摘要２０を返す() {
            assertThat(sut.get摘要２０(), is(KyufujissekiTokuteiSinryohiEntity.getTekiyo20()));
        }

        @Test
        public void get後_保険_指導管理料等は_entityが持つ後_保険_指導管理料等を返す() {
            assertThat(sut.get後_保険_指導管理料等(), is(KyufujissekiTokuteiSinryohiEntity.getAtoHokenShidoKanriryo()));
        }

        @Test
        public void get後_保険_単純エックス線は_entityが持つ後_保険_単純エックス線を返す() {
            assertThat(sut.get後_保険_単純エックス線(), is(KyufujissekiTokuteiSinryohiEntity.getAtoHokenTanjunXsen()));
        }

        @Test
        public void get後_保険_リハビリテーションは_entityが持つ後_保険_リハビリテーションを返す() {
            assertThat(sut.get後_保険_リハビリテーション(), is(KyufujissekiTokuteiSinryohiEntity.getAtoHokenRehabilitation()));
        }

        @Test
        public void get後_保険_精神科専門療法は_entityが持つ後_保険_精神科専門療法を返す() {
            assertThat(sut.get後_保険_精神科専門療法(), is(KyufujissekiTokuteiSinryohiEntity.getAtoHokenSeishinkaSemmonRyoho()));
        }

        @Test
        public void get後_公費１_指導管理料等は_entityが持つ後_公費１_指導管理料等を返す() {
            assertThat(sut.get後_公費１_指導管理料等(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi1ShidoKanriryo()));
        }

        @Test
        public void get後_公費１_単純エックス線は_entityが持つ後_公費１_単純エックス線を返す() {
            assertThat(sut.get後_公費１_単純エックス線(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi1TanjunXsen()));
        }

        @Test
        public void get後_公費１_リハビリテーションは_entityが持つ後_公費１_リハビリテーションを返す() {
            assertThat(sut.get後_公費１_リハビリテーション(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi1Rehabilitation()));
        }

        @Test
        public void get後_公費１_精神科専門療法は_entityが持つ後_公費１_精神科専門療法を返す() {
            assertThat(sut.get後_公費１_精神科専門療法(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi1SeishinkaSemmonRyoho()));
        }

        @Test
        public void get後_公費２_指導管理料等は_entityが持つ後_公費２_指導管理料等を返す() {
            assertThat(sut.get後_公費２_指導管理料等(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi2ShidoKanriryo()));
        }

        @Test
        public void get後_公費２_単純エックス線は_entityが持つ後_公費２_単純エックス線を返す() {
            assertThat(sut.get後_公費２_単純エックス線(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi2TanjunXsen()));
        }

        @Test
        public void get後_公費２_リハビリテーションは_entityが持つ後_公費２_リハビリテーションを返す() {
            assertThat(sut.get後_公費２_リハビリテーション(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi2Rehabilitation()));
        }

        @Test
        public void get後_公費２_精神科専門療法は_entityが持つ後_公費２_精神科専門療法を返す() {
            assertThat(sut.get後_公費２_精神科専門療法(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi2SeishinkaSemmonRyoho()));
        }

        @Test
        public void get後_公費３_指導管理料等は_entityが持つ後_公費３_指導管理料等を返す() {
            assertThat(sut.get後_公費３_指導管理料等(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi3ShidoKanriryo()));
        }

        @Test
        public void get後_公費３_単純エックス線は_entityが持つ後_公費３_単純エックス線を返す() {
            assertThat(sut.get後_公費３_単純エックス線(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi3TanjunXsen()));
        }

        @Test
        public void get後_公費３_リハビリテーションは_entityが持つ後_公費３_リハビリテーションを返す() {
            assertThat(sut.get後_公費３_リハビリテーション(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi3Rehabilitation()));
        }

        @Test
        public void get後_公費３_精神科専門療法は_entityが持つ後_公費３_精神科専門療法を返す() {
            assertThat(sut.get後_公費３_精神科専門療法(), is(KyufujissekiTokuteiSinryohiEntity.getAtoKohi3SeishinkaSemmonRyoho()));
        }

        @Test
        public void get再審査回数は_entityが持つ再審査回数を返す() {
            assertThat(sut.get再審査回数(), is(KyufujissekiTokuteiSinryohiEntity.getSaishinsaKaisu()));
        }

        @Test
        public void get過誤回数は_entityが持つ過誤回数を返す() {
            assertThat(sut.get過誤回数(), is(KyufujissekiTokuteiSinryohiEntity.getKagoKaisu()));
        }

        @Test
        public void get審査年月は_entityが持つ審査年月を返す() {
            assertThat(sut.get審査年月(), is(KyufujissekiTokuteiSinryohiEntity.getShinsaYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KyufujissekiTokuteiSinryohiEntity.getSeiriNo()));
        }

        @Test
        public void get取込年月は_entityが持つ取込年月を返す() {
            assertThat(sut.get取込年月(), is(KyufujissekiTokuteiSinryohiEntity.getTorikomiYM()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryohi sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryohiEntity = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.createDbT3020KyufujissekiTokuteiSinryohiEntity();
            KyufujissekiTokuteiSinryohiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiTokuteiSinryohiEntity.setInputShikibetsuNo(主キー名2);

            sut = new KyufujissekiTokuteiSinryohi(KyufujissekiTokuteiSinryohiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KyufujissekiTokuteiSinryohiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryohi sut;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryohiEntity = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.createDbT3020KyufujissekiTokuteiSinryohiEntity();
            KyufujissekiTokuteiSinryohiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiTokuteiSinryohiEntity.setInputShikibetsuNo(主キー名2);

            sut = new KyufujissekiTokuteiSinryohi(KyufujissekiTokuteiSinryohiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KyufujissekiTokuteiSinryohi sut;
        private static KyufujissekiTokuteiSinryohi result;

        @Before
        public void setUp() {
            KyufujissekiTokuteiSinryohiEntity = DbT3020KyufujissekiTokuteiSinryohiEntityGenerator.createDbT3020KyufujissekiTokuteiSinryohiEntity();
            KyufujissekiTokuteiSinryohiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KyufujissekiTokuteiSinryohiEntity.setInputShikibetsuNo(主キー名2);

        }

        @Test
        public void KyufujissekiTokuteiSinryohiが保持するDbT3020KyufujissekiTokuteiSinryohiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKyufujissekiTokuteiSinryohiが保持するDbT3020KyufujissekiTokuteiSinryohiEntityのEntityDataStateがDeletedに指定されたKyufujissekiTokuteiSinryohiが返る() {
            sut = TestSupport.setStateKyufujissekiTokuteiSinryohi(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiTokuteiSinryohiが保持するDbT3020KyufujissekiTokuteiSinryohiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKyufujissekiTokuteiSinryohiが保持するDbT3020KyufujissekiTokuteiSinryohiEntityのEntityDataStateがDeletedに指定されたKyufujissekiTokuteiSinryohiが返る() {
            sut = TestSupport.setStateKyufujissekiTokuteiSinryohi(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KyufujissekiTokuteiSinryohiが保持するDbT3020KyufujissekiTokuteiSinryohiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKyufujissekiTokuteiSinryohiが保持するDbT3020KyufujissekiTokuteiSinryohiEntityのEntityDataStateがDeletedに指定されたKyufujissekiTokuteiSinryohiが返る() {
            sut = TestSupport.setStateKyufujissekiTokuteiSinryohi(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KyufujissekiTokuteiSinryohiが保持するDbT3020KyufujissekiTokuteiSinryohiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKyufujissekiTokuteiSinryohi(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KyufujissekiTokuteiSinryohi setStateKyufujissekiTokuteiSinryohi(EntityDataState parentState) {
            KyufujissekiTokuteiSinryohiEntity.setState(parentState);
            return new KyufujissekiTokuteiSinryohi(KyufujissekiTokuteiSinryohiEntity);
        }
    }
}
