/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuList;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultDetail;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultKomoku;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultSofu;
import jp.co.ndensan.reams.db.dbe.business.JotaiAnteiseiKubun;
import jp.co.ndensan.reams.db.dbe.business.NichijoSeikatsuJiritsudoKumiawase;
import jp.co.ndensan.reams.db.dbe.business.NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.business.NoryokuMiteikaNinchishoKoreishaShihyoKomoku;
import jp.co.ndensan.reams.db.dbe.business.SuiteiKyuhuKubun;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiChukanHyokaKomokuTokuten;
import jp.co.ndensan.reams.db.dbe.business.YokaigoNinteiKijunTime;
import jp.co.ndensan.reams.db.dbe.business.helper.IchijiHanteiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChukanHyokaKomokuTokutenItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiResultSofuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NichijoSeikatsuJiritsudoKumiawaseItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.YokaigoNinteiKijunTimeItemGroup;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.IchijiHanteiTestEntityCreator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 一次判定結果詳細情報マッパーのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiResultDetailMapperTest {

    private static ShinseishoKanriNo 申請書管理番号_01;
    private static KoroshoIFKubun IF区分_V02A;
    private static KariIchijiHanteiKubun 仮判定区分_本判定;
    private static FlexibleDate 一次判定年月日_20060401;
    private static Code 一次判定結果コード_01;
    private static Code 認知症加算一次判定結果コード_12;
    private static YokaigoNinteiKijunTime 要介護認定等基準時間;
    private static YokaigoNinteiChukanHyokaKomokuTokuten 中間評価項目;
    private static RString 警告配列コード;
    private static Code 状態安定性コード_3;
    private static Decimal 認知症高齢者自立度2以上蓋然性_12_34;
    private static Code 給付区分コード_4;
    private static Code 運動能力未低下認知症高齢者の指標コード_3;
    private static NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ;
    private static Code 蓋然性評価コード_6;
    private static int 蓋然性評価率_48;
    private static IchijiHanteiResultSofuKubun 結果送付区分_1;
    private static FlexibleDate 結果送付年月_20061231;

    @BeforeClass
    public static void setUpBeforeClass() {
        申請書管理番号_01 = new ShinseishoKanriNo(new RString("01"));
        IF区分_V02A = KoroshoIFKubun.V02A;
        仮判定区分_本判定 = KariIchijiHanteiKubun.本判定;
        一次判定年月日_20060401 = new FlexibleDate("20060401");
        一次判定結果コード_01 = new Code("01");
        認知症加算一次判定結果コード_12 = new Code("12");
        要介護認定等基準時間 = IchijiHanteiTestBusinessCreator.create要介護認定等基準時間(11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        中間評価項目 = IchijiHanteiTestBusinessCreator.create中間評価項目得点(1, 2, 3, 4, 5, 6, 7);
        警告配列コード = new RString("000111000111000111");
        状態安定性コード_3 = new Code("3");
        認知症高齢者自立度2以上蓋然性_12_34 = new Decimal(12.34);
        給付区分コード_4 = new Code("4");
        運動能力未低下認知症高齢者の指標コード_3 = new Code("5");
        日常生活自立度組み合わせ = IchijiHanteiTestBusinessCreator.create日常生活自立度組み合わせ(21, 22, 23, 24, 25, 26, 27);
        蓋然性評価コード_6 = new Code("6");
        蓋然性評価率_48 = 48;
        結果送付区分_1 = IchijiHanteiResultSofuKubun.toValue(new RString("1"));
        結果送付年月_20061231 = new FlexibleDate("20061231");
    }

    public static class to一次判定結果のテスト extends DbeTestBase {

        private IchijiHanteiResultDetail result;

        @Before
        public void setUp() {
            DbT5016IchijiHanteiKekkaJohoEntity entity = IchijiHanteiTestEntityCreator.create一次判定結果EntitySpy(申請書管理番号_01,
                    IF区分_V02A, 仮判定区分_本判定, 一次判定年月日_20060401, 一次判定結果コード_01, 認知症加算一次判定結果コード_12, 要介護認定等基準時間,
                    中間評価項目, 警告配列コード, 状態安定性コード_3, 認知症高齢者自立度2以上蓋然性_12_34, 給付区分コード_4,
                    運動能力未低下認知症高齢者の指標コード_3, 日常生活自立度組み合わせ, 蓋然性評価コード_6, 蓋然性評価率_48, 結果送付区分_1, 結果送付年月_20061231);

            IchijiHanteiKeikokuList list = IchijiHanteiTestBusinessCreator.create一次判定警告List(警告配列コード.toString());

            result = IchijiHanteiResultDetailMapper.to一次判定結果(entity, list);
        }

        @Test
        public void 一次判定結果Entityにnullが渡されたとき_nullが返る() {
            IchijiHanteiKeikokuList list = mock(IchijiHanteiKeikokuList.class);
            result = IchijiHanteiResultDetailMapper.to一次判定結果(null, list);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 一次判定警告Listにnullが渡されたとき_nullが返る() {
            DbT5016IchijiHanteiKekkaJohoEntity entity = new DbT5016IchijiHanteiKekkaJohoEntity();
            result = IchijiHanteiResultDetailMapper.to一次判定結果(entity, null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void マッピング後に返される一次判定結果は_申請書管理番号に01を持つ() {
            assertThat(result.get申請書管理番号(), is(申請書管理番号_01));
        }

        @Test
        public void マッピング後に返される一次判定結果は_厚労省IF区分にを持つ() {
            assertThat(result.get厚労省IF区分(), is(IF区分_V02A));
        }

        @Test
        public void マッピング後に返される一次判定結果は_仮一次判定区分に本判定を持つ() {
            assertThat(result.get仮一次判定区分(), is(仮判定区分_本判定));
        }

        @Test
        public void マッピング後に返される一次判定結果は_一次判定年月日に20060101を持つ() {
            assertThat(result.get一次判定年月日(), is(一次判定年月日_20060401));
        }

        @Test
        public void マッピング後に返される一次判定結果は_一次判定結果コードに01を持つ() {
            assertThat(result.get一次判定結果().getCode(), is(一次判定結果コード_01));
        }

        @Test
        public void マッピング後に返される一次判定結果は_認知症加算一次判定結果コードに12を持つ() {
            assertThat(result.get認知症加算一次判定結果().getCode(), is(認知症加算一次判定結果コード_12));
        }

        @Test
        public void マッピング後に返される一次判定結果は_基準時間に11を持つ() {
            assertThat(result.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.合計),
                    is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.合計)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_食事基準時間に12を持つ() {
            assertThat(result.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.食事),
                    is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.食事)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_排泄食事基準時間に13を持つ() {
            assertThat(result.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.排泄),
                    is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.排泄)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_移動基準時間に14を持つ() {
            assertThat(result.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.移動),
                    is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.移動)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_清潔保持基準時間に15を持つ() {
            assertThat(result.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.清潔保持),
                    is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.清潔保持)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_間接ケア基準時間に16を持つ() {
            assertThat(result.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.間接ケア),
                    is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.間接ケア)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_BPSD関連基準時間に17を持つ() {
            assertThat(result.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.BPSD関連),
                    is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.BPSD関連)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_機能訓練基準時間に18を持つ() {
            assertThat(result.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.機能訓練),
                    is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.機能訓練)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_医療関連基準時間に19を持つ() {
            assertThat(result.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.医療関連),
                    is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.医療関連)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_認知症加算基準時間に20を持つ() {
            assertThat(result.get要介護認定等基準時間().get基準時間(YokaigoNinteiKijunTimeItemGroup.認知症加算),
                    is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.認知症加算)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第1群に1を持つ() {
            assertThat(result.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第1群),
                    is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第1群)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第2群に2を持つ() {
            assertThat(result.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第2群),
                    is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第2群)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第3群に3を持つ() {
            assertThat(result.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第3群),
                    is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第3群)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第4群に4を持つ() {
            assertThat(result.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第4群),
                    is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第4群)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第5群に5を持つ() {
            assertThat(result.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第5群),
                    is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第5群)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第6群に6を持つ() {
            assertThat(result.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第6群),
                    is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第6群)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第7群に7を持つ() {
            assertThat(result.get中間評価項目得点().get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第7群),
                    is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第7群)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_一次判定警告配列コードに000111000111000111を持つ() {
            assertThat(result.get一次判定警告List().get警告配列コード().toRString(), is(警告配列コード));
        }

        @Test
        public void マッピング後に返される一次判定結果は_介護認定状態の安定性コードに3を持つ() {
            assertThat(result.get認定状態安定性().getCode(), is(状態安定性コード_3));
        }

        @Test
        public void マッピング後に返される一次判定結果は_認知症自立度2以上の蓋然性に12_34を持つ() {
            assertThat(result.get認知症自立度2以上蓋然性(), is(認知症高齢者自立度2以上蓋然性_12_34));
        }

        @Test
        public void マッピング後に返される一次判定結果は_推定給付区分コードに4を持つ() {
            assertThat(result.get推定給付区分().getCode(), is(給付区分コード_4));
        }

        @Test
        public void マッピング後に返される一次判定結果は_運動能力未低下認知症高齢者指標コードに5を持つ() {
            assertThat(result.get運動能力未低下認知症高齢者指標().getCode(), is(運動能力未低下認知症高齢者の指標コード_3));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_自立の項目に21を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.自立),
                    is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.自立)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要支援の項目に22を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要支援),
                    is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要支援)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要介護1の項目に23を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護1),
                    is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護1)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要介護2の項目に24を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護2),
                    is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護2)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要介護3の項目に25を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護3),
                    is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護3)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要介護4の項目に26を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護4),
                    is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護4)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要介護5の項目に27を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護5),
                    is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護5)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_認知症高齢者自立度の蓋然性評価コードに6を持つ() {
            assertThat(result.get認知症高齢者日常生活自立度蓋然性評価().getCode(), is(蓋然性評価コード_6));
        }

        @Test
        public void マッピング後に返される一次判定結果は_認知症高齢者自立度の蓋然性評価率に48を持つ() {
            assertThat(result.get認知症高齢者日常生活自立度蓋然性評価率(), is(蓋然性評価率_48));
        }

        @Test
        public void マッピング後に返される一次判定結果は_一次判定結果送付区分に1を持つ() {
            assertThat(result.get一次判定結果送付状況().get一次判定結果送付区分().get送付区分コード(), is(結果送付区分_1.get送付区分コード()));
        }

        @Test
        public void マッピング後に返される一次判定結果は_一次判定結果送付年月日に20061231を持つ() {
            assertThat(result.get一次判定結果送付状況().get一次判定結果送付年月日(), is(結果送付年月_20061231));
        }
    }

    public static class to一次判定結果Entityのテスト extends DbeTestBase {

        private DbT5016IchijiHanteiKekkaJohoEntity result;
        private IchijiHanteiResultKomoku 一次判定結果;
        private IchijiHanteiResultKomoku 認知症加算一次判定結果;
        private IchijiHanteiKeikokuList list;
        private JotaiAnteiseiKubun 状態安定性;
        private SuiteiKyuhuKubun 推定給付区分;
        private NoryokuMiteikaNinchishoKoreishaShihyoKomoku 運動能力未低下認知症高齢者の指標;
        private NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku 蓋然性評価;

        @Before
        public void setUp() {
            一次判定結果 = new IchijiHanteiResultKomoku(一次判定結果コード_01, new RString("meisho"), new RString("ryakusho"));
            認知症加算一次判定結果 = new IchijiHanteiResultKomoku(認知症加算一次判定結果コード_12, new RString("meisho"), new RString("ryakusho"));
            list = IchijiHanteiTestBusinessCreator.create一次判定警告List(警告配列コード.toString());
            状態安定性 = new JotaiAnteiseiKubun(状態安定性コード_3, new RString("meisho"), new RString("ryakusho"));
            推定給付区分 = new SuiteiKyuhuKubun(給付区分コード_4, new RString("meisho"), new RString("ryakusho"));
            運動能力未低下認知症高齢者の指標 = new NoryokuMiteikaNinchishoKoreishaShihyoKomoku(運動能力未低下認知症高齢者の指標コード_3,
                    new RString("meisho"), new RString("ryakusho"));
            蓋然性評価 = new NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku(蓋然性評価コード_6, new RString("meisho"), new RString("ryakusho"));

            IchijiHanteiResultDetail 一次判定結果詳細 = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号_01)
                    .set厚労省IF区分(IF区分_V02A).set厚労省IF区分(仮判定区分_本判定).set一次判定年月日(一次判定年月日_20060401)
                    .set一次判定結果(一次判定結果).set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間)
                    .set中間評価項目得点(中間評価項目).set一次判定警告List(list).set状態安定性(状態安定性)
                    .set認知症自立度2以上蓋然性(認知症高齢者自立度2以上蓋然性_12_34).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者の指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(蓋然性評価).set認知症高齢者日常生活自立度蓋然性評価率(蓋然性評価率_48)
                    .set一次判定結果送付状況(new IchijiHanteiResultSofu(結果送付区分_1, 結果送付年月_20061231)).build();
            result = IchijiHanteiResultDetailMapper.to一次判定結果Entity(一次判定結果詳細);
        }

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            result = IchijiHanteiResultDetailMapper.to一次判定結果Entity(null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_申請書管理番号に01を持つ() {
            assertThat(result.getShinseishoKanriNo(), is(申請書管理番号_01));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_厚労省IF区分にを持つ() {
            assertThat(result.getKoroshoIfShikibetsuCode(), is(IF区分_V02A.getCode()));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_仮一次判定区分に本判定を持つ() {
            assertThat(result.getKariIchijiHanteiKubun(), is(仮判定区分_本判定.is仮判定()));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_一次判定年月日に20060401を持つ() {
            assertThat(result.getIchijiHanteiYMD(), is(一次判定年月日_20060401));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_一次判定結果コードに1を持つ() {
            assertThat(result.getIchijiHanteiKekkaCode(), is(一次判定結果コード_01));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_認知症加算一次判定結果コードに12を持つ() {
            assertThat(result.getIchijiHanteiKekkaNinchishoKasanCode(), is(認知症加算一次判定結果コード_12));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_基準時間に11を持つ() {
            assertThat(result.getKijunJikan(), is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.合計)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_食事基準時間に12を持つ() {
            assertThat(result.getKijunJikanShokuji(), is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.食事)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_排泄食事基準時間に13を持つ() {
            assertThat(result.getKijunJikanHaisetsu(), is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.排泄)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_移動基準時間に14を持つ() {
            assertThat(result.getKijunJikanIdo(), is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.移動)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_清潔保持基準時間に15を持つ() {
            assertThat(result.getKijunJikanSeiketsuHoji(), is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.清潔保持)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_間接ケア基準時間に16を持つ() {
            assertThat(result.getKijunJikanKansetsuCare(), is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.間接ケア)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_BPSD関連基準時間に17を持つ() {
            assertThat(result.getKijunJikanBPSDKanren(), is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.BPSD関連)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_機能訓練基準時間に18を持つ() {
            assertThat(result.getKijunJikanKinoKunren(), is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.機能訓練)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_医療関連基準時間に19を持つ() {
            assertThat(result.getKijunJikanIryoKanren(), is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.医療関連)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_認知症加算基準時間に20を持つ() {
            assertThat(result.getKijunJikanNinchishoKasan(), is(要介護認定等基準時間.get基準時間(YokaigoNinteiKijunTimeItemGroup.認知症加算)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第1群に1を持つ() {
            assertThat(result.getChukanHyokaKomoku1gun(), is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第1群)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第2群に2を持つ() {
            assertThat(result.getChukanHyokaKomoku2gun(), is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第2群)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第3群に3を持つ() {
            assertThat(result.getChukanHyokaKomoku3gun(), is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第3群)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第4群に4を持つ() {
            assertThat(result.getChukanHyokaKomoku4gun(), is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第4群)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第5群に5を持つ() {
            assertThat(result.getChukanHyokaKomoku5gun(), is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第5群)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第6群に6を持つ() {
            assertThat(result.getChukanHyokaKomoku6gun(), is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第6群)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第7群に7を持つ() {
            assertThat(result.getChukanHyokaKomoku7gun(), is(中間評価項目.get中間評価項目得点(ChukanHyokaKomokuTokutenItemGroup.第7群)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_一次判定警告配列コードに000111000111000111を持つ() {
            assertThat(result.getIchijiHanteiKeikokuCode(), is(警告配列コード));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_介護認定状態の安定性コードに3を持つ() {
            assertThat(result.getJotaiAnteiseiCode(), is(状態安定性コード_3));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_認知症自立度2以上の蓋然性に12_34を持つ() {
            assertThat(result.getNinchishoJiritsudoIIijoNoGaizensei(), is(認知症高齢者自立度2以上蓋然性_12_34));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_推定給付区分コードに4を持つ() {
            assertThat(result.getSuiteiKyufuKubunCode(), is(給付区分コード_4));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_運動能力未低下認知症高齢者指標コードに5を持つ() {
            assertThat(result.getNinchishoKoreishaShihyoCode(), is(運動能力未低下認知症高齢者の指標コード_3));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_自立の項目に21を持つ() {
            assertThat(result.getJiritsudoKumiawase1(), is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.自立)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要支援の項目に22を持つ() {
            assertThat(result.getJiritsudoKumiawase2(), is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要支援)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要介護1の項目に23を持つ() {
            assertThat(result.getJiritsudoKumiawase3(), is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護1)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要介護2の項目に24を持つ() {
            assertThat(result.getJiritsudoKumiawase4(), is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護2)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要介護3の項目に25を持つ() {
            assertThat(result.getJiritsudoKumiawase5(), is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護3)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要介護4の項目に26を持つ() {
            assertThat(result.getJiritsudoKumiawase6(), is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護4)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要介護5の項目に27を持つ() {
            assertThat(result.getJiritsudoKumiawase7(), is(日常生活自立度組み合わせ.get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup.要介護5)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_認知症高齢者自立度の蓋然性評価コードに6を持つ() {
            assertThat(result.getGaizenseiHyokaCode(), is(蓋然性評価コード_6));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_認知症高齢者自立度の蓋然性評価率に48を持つ() {
            assertThat(result.getGaizenseiHyokaPercent(), is(蓋然性評価率_48));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_一次判定結果Entity送付区分に1を持つ() {
            assertThat(result.getIchijiHanteiSofuKubun(), is(結果送付区分_1.get送付区分コード()));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_一次判定結果Entity送付年月日に20061231を持つ() {
            assertThat(result.getIchijiHanteiKekkaSofuYMD(), is(結果送付年月_20061231));
        }
    }
}
