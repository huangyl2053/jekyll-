/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiKeikokuList;
import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultDetail;
import jp.co.ndensan.reams.db.dbe.business.helper.IchijiHanteiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.IchijiHanteiTestEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
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

    public static class to一次判定結果のテスト extends DbeTestBase {

        private IchijiHanteiResultDetail result;

        @Before
        public void setUp() {
            DbT5016IchijiHanteiKekkaJohoEntity entity = IchijiHanteiTestEntityCreator.create一次判定結果EntitySpy();

            IchijiHanteiKeikokuList list = IchijiHanteiTestBusinessCreator.create一次判定警告List("000111000111000111");

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
            assertThat(result.get申請書管理番号().value(), is(new RString("01")));
        }

        @Test
        public void マッピング後に返される一次判定結果は_厚労省IF区分にを持つ() {
            assertThat(result.get厚労省IF区分(), is(KoroshoIFKubun.V02A));
        }

        @Test
        public void マッピング後に返される一次判定結果は_仮一次判定区分に本判定を持つ() {
            assertThat(result.get仮一次判定区分(), is(KariIchijiHanteiKubun.本判定));
        }

        @Test
        public void マッピング後に返される一次判定結果は_一次判定年月日に20060101を持つ() {
            assertThat(result.get一次判定年月日(), is(new FlexibleDate("20060401")));
        }

        @Test
        public void マッピング後に返される一次判定結果は_一次判定結果コードに01を持つ() {
            assertThat(result.get一次判定結果().getCode(), is(new Code("01")));
        }

        @Test
        public void マッピング後に返される一次判定結果は_認知症加算一次判定結果コードに12を持つ() {
            assertThat(result.get認知症加算一次判定結果().getCode(), is(new Code("12")));
        }

        @Test
        public void マッピング後に返される一次判定結果は_基準時間に11を持つ() {
            assertThat(result.get要介護認定等基準時間().get基準時間(), is(11));
        }

        @Test
        public void マッピング後に返される一次判定結果は_食事基準時間に12を持つ() {
            assertThat(result.get要介護認定等基準時間().get食事基準時間(), is(12));
        }

        @Test
        public void マッピング後に返される一次判定結果は_排泄食事基準時間に13を持つ() {
            assertThat(result.get要介護認定等基準時間().get排泄基準時間(), is(13));
        }

        @Test
        public void マッピング後に返される一次判定結果は_移動基準時間に14を持つ() {
            assertThat(result.get要介護認定等基準時間().get移動基準時間(), is(14));
        }

        @Test
        public void マッピング後に返される一次判定結果は_清潔保持基準時間に15を持つ() {
            assertThat(result.get要介護認定等基準時間().get清潔保持基準時間(), is(15));
        }

        @Test
        public void マッピング後に返される一次判定結果は_間接ケア基準時間に16を持つ() {
            assertThat(result.get要介護認定等基準時間().get間接ケア基準時間(), is(16));
        }

        @Test
        public void マッピング後に返される一次判定結果は_BPSD関連基準時間に17を持つ() {
            assertThat(result.get要介護認定等基準時間().getBPSD関連基準時間(), is(17));
        }

        @Test
        public void マッピング後に返される一次判定結果は_機能訓練基準時間に18を持つ() {
            assertThat(result.get要介護認定等基準時間().get機能訓練基準時間(), is(18));
        }

        @Test
        public void マッピング後に返される一次判定結果は_医療関連基準時間に19を持つ() {
            assertThat(result.get要介護認定等基準時間().get医療関連基準時間(), is(19));
        }

        @Test
        public void マッピング後に返される一次判定結果は_認知症加算基準時間に20を持つ() {
            assertThat(result.get要介護認定等基準時間().get認知症加算基準時間(), is(20));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第1群に1を持つ() {
            assertThat(result.get中間評価項目得点().get第1群(), is(1));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第2群に2を持つ() {
            assertThat(result.get中間評価項目得点().get第2群(), is(2));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第3群に3を持つ() {
            assertThat(result.get中間評価項目得点().get第3群(), is(3));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第4群に4を持つ() {
            assertThat(result.get中間評価項目得点().get第4群(), is(4));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第5群に5を持つ() {
            assertThat(result.get中間評価項目得点().get第5群(), is(5));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第6群に6を持つ() {
            assertThat(result.get中間評価項目得点().get第6群(), is(6));
        }

        @Test
        public void マッピング後に返される一次判定結果は_中間評価項目第7群に7を持つ() {
            assertThat(result.get中間評価項目得点().get第7群(), is(7));
        }

        @Test
        public void マッピング後に返される一次判定結果は_一次判定警告配列コードに000111000111000111を持つ() {
            assertThat(result.get一次判定警告List().get警告配列コード().toRString(), is(new RString("000111000111000111")));
        }

        @Test
        public void マッピング後に返される一次判定結果は_介護認定状態の安定性コードに3を持つ() {
            assertThat(result.get認定状態安定性().getCode(), is(new Code("3")));
        }

        @Test
        public void マッピング後に返される一次判定結果は_認知症自立度2以上の蓋然性に12_34を持つ() {
            assertThat(result.get認知症自立度2以上蓋然性(), is(new Decimal(12.34)));
        }

        @Test
        public void マッピング後に返される一次判定結果は_推定給付区分コードに4を持つ() {
            assertThat(result.get推定給付区分().getCode(), is(new Code("4")));
        }

        @Test
        public void マッピング後に返される一次判定結果は_運動能力未低下認知症高齢者指標コードに5を持つ() {
            assertThat(result.get運動能力未低下認知症高齢者指標().getCode(), is(new Code("5")));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_自立の項目に21を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get自立(), is(21));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要支援の項目に22を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get要支援(), is(22));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要介護1の項目に23を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get要介護1(), is(23));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要介護2の項目に24を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get要介護2(), is(24));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要介護3の項目に25を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get要介護3(), is(25));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要介護4の項目に26を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get要介護4(), is(26));
        }

        @Test
        public void マッピング後に返される一次判定結果は_日常生活自立度組み合わせの_要介護5の項目に27を持つ() {
            assertThat(result.get日常生活自立度組み合わせ().get要介護5(), is(27));
        }

        @Test
        public void マッピング後に返される一次判定結果は_認知症高齢者自立度の蓋然性評価コードに6を持つ() {
            assertThat(result.get認知症高齢者日常生活自立度蓋然性評価().getCode(), is(new Code("6")));
        }

        @Test
        public void マッピング後に返される一次判定結果は_認知症高齢者自立度の蓋然性評価率に48を持つ() {
            assertThat(result.get認知症高齢者日常生活自立度蓋然性評価率(), is(48));
        }

        @Test
        public void マッピング後に返される一次判定結果は_一次判定結果送付区分に1を持つ() {
            assertThat(result.get一次判定結果送付区分().get送付区分コード(), is(new RString("1")));
        }

        @Test
        public void マッピング後に返される一次判定結果は_一次判定結果送付年月日に20061231を持つ() {
            assertThat(result.get一次判定結果送付年月日(), is(new FlexibleDate("20061231")));
        }
    }

    public static class to一次判定結果Entityのテスト extends DbeTestBase {

        private DbT5016IchijiHanteiKekkaJohoEntity result;

        @Before
        public void setUp() {
            result = IchijiHanteiResultDetailMapper.to一次判定結果Entity(IchijiHanteiTestBusinessCreator.create一次判定結果());
        }

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            result = IchijiHanteiResultDetailMapper.to一次判定結果Entity(null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_申請書管理番号に01を持つ() {
            assertThat(result.getShinseishoKanriNo().value(), is(new RString("01")));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_厚労省IF区分にを持つ() {
            assertThat(result.getKoroshoIfShikibetsuCode(), is(KoroshoIFKubun.V02A.getCode()));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_仮一次判定区分に本判定を持つ() {
            assertThat(result.getKariIchijiHanteiKubun(), is(KariIchijiHanteiKubun.本判定.is仮判定()));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_一次判定年月日に20060101を持つ() {
            assertThat(result.getIchijiHanteiYMD(), is(new FlexibleDate("20060101")));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_一次判定結果コードに1を持つ() {
            assertThat(result.getIchijiHanteiKekkaCode(), is(new Code("1")));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_認知症加算一次判定結果コードに2を持つ() {
            assertThat(result.getIchijiHanteiKekkaNinchishoKasanCode(), is(new Code("2")));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_基準時間に11を持つ() {
            assertThat(result.getKijunJikan(), is(11));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_食事基準時間に12を持つ() {
            assertThat(result.getKijunJikanShokuji(), is(12));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_排泄食事基準時間に13を持つ() {
            assertThat(result.getKijunJikanHaisetsu(), is(13));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_移動基準時間に14を持つ() {
            assertThat(result.getKijunJikanIdo(), is(14));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_清潔保持基準時間に15を持つ() {
            assertThat(result.getKijunJikanSeiketsuHoji(), is(15));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_間接ケア基準時間に16を持つ() {
            assertThat(result.getKijunJikanKansetsuCare(), is(16));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_BPSD関連基準時間に17を持つ() {
            assertThat(result.getKijunJikanBPSDKanren(), is(17));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_機能訓練基準時間に18を持つ() {
            assertThat(result.getKijunJikanKinoKunren(), is(18));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_医療関連基準時間に19を持つ() {
            assertThat(result.getKijunJikanIryoKanren(), is(19));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_認知症加算基準時間に20を持つ() {
            assertThat(result.getKijunJikanNinchishoKasan(), is(20));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第1群に1を持つ() {
            assertThat(result.getChukanHyokaKomoku1gun(), is(1));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第2群に2を持つ() {
            assertThat(result.getChukanHyokaKomoku2gun(), is(2));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第3群に3を持つ() {
            assertThat(result.getChukanHyokaKomoku3gun(), is(3));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第4群に4を持つ() {
            assertThat(result.getChukanHyokaKomoku4gun(), is(4));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第5群に5を持つ() {
            assertThat(result.getChukanHyokaKomoku5gun(), is(5));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第6群に6を持つ() {
            assertThat(result.getChukanHyokaKomoku6gun(), is(6));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_中間評価項目第7群に7を持つ() {
            assertThat(result.getChukanHyokaKomoku7gun(), is(7));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_一次判定警告配列コードに000111000111000111を持つ() {
            assertThat(result.getIchijiHnateiKeikokuCode(), is(new RString("000111000111000111")));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_介護認定状態の安定性コードに3を持つ() {
            assertThat(result.getJotaiAnteiseiCode(), is(new Code("3")));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_認知症自立度2以上の蓋然性に12_34を持つ() {
            assertThat(result.getNinchishoJiritsudoIIijoNoGaizensei(), is(new Decimal(12.34)));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_推定給付区分コードに4を持つ() {
            assertThat(result.getSuiteiKyufuKubunCode(), is(new Code("4")));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_運動能力未低下認知症高齢者指標コードに5を持つ() {
            assertThat(result.getNinchishoKoreishaShihyoCode(), is(new Code("5")));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_自立の項目に21を持つ() {
            assertThat(result.getJiiritsudoKumiawase1(), is(21));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要支援の項目に22を持つ() {
            assertThat(result.getJiiritsudoKumiawase2(), is(22));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要介護1の項目に23を持つ() {
            assertThat(result.getJiiritsudoKumiawase3(), is(23));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要介護2の項目に24を持つ() {
            assertThat(result.getJiiritsudoKumiawase4(), is(24));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要介護3の項目に25を持つ() {
            assertThat(result.getJiiritsudoKumiawase5(), is(25));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要介護4の項目に26を持つ() {
            assertThat(result.getJiiritsudoKumiawase6(), is(26));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_日常生活自立度組み合わせの_要介護5の項目に27を持つ() {
            assertThat(result.getJiiritsudoKumiawase7(), is(27));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_認知症高齢者自立度の蓋然性評価コードに6を持つ() {
            assertThat(result.getGaizenseiHyokaCode(), is(new Code("6")));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_認知症高齢者自立度の蓋然性評価率に48を持つ() {
            assertThat(result.getGaizenseiHyokaPercent(), is(48));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_一次判定結果Entity送付区分に1を持つ() {
            assertThat(result.getIchijiHanteiSofuKubun(), is(new RString("1")));
        }

        @Test
        public void マッピング後に返される一次判定結果Entityは_一次判定結果Entity送付年月日に20061231を持つ() {
            assertThat(result.getIchijiHanteiKekkaSofuYMD(), is(new FlexibleDate("20061231")));
        }
    }
}
