/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.IchijiHanteiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiSohuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
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
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 一次判定結果詳細のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiResultDetailTest {

    private static IchijiHanteiResultDetail sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        private ShinseishoKanriNo 申請書管理番号;
        private KoroshoIFKubun 厚労省IF区分;
        private KariIchijiHanteiKubun 仮一次判定区分;
        private FlexibleDate 一次判定年月日;
        private IchijiHanteiResultKomoku 一次判定結果;
        private IchijiHanteiResultKomoku 認知症加算一次判定結果;
        private YokaigoNinteiKijunTime 要介護認定等基準時間;
        private YokaigoNinteiChukanHyokaKomokuTokuten 中間評価項目得点;
        private IchijiHanteiKeikokuList 一次判定警告List;
        private JotaiAnteiseiKubun 認定状態安定性;
        private Decimal 認知症自立度2以上蓋然性;
        private SuiteiKyuhuKubun 推定給付区分;
        private NoryokuMiteikaNinchishoKoreishaShihyoKomoku 運動能力未低下認知症高齢者指標;
        private NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ;
        private NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku 認知症高齢者日常生活自立度蓋然性評価;
        private int 認知症高齢者日常生活自立度蓋然性評価率;
        private IchijiHanteiSohuKubun 一次判定結果送付区分;
        private FlexibleDate 一次判定結果送付年月日;

        @Before
        public void setUp() {
            申請書管理番号 = new ShinseishoKanriNo(new RString("001"));
            厚労省IF区分 = KoroshoIFKubun.V02A;
            仮一次判定区分 = KariIchijiHanteiKubun.仮判定;
            一次判定年月日 = new FlexibleDate("19990101");
            一次判定結果 = new IchijiHanteiResultKomoku(new Code(new RString("001")), new RString("名称"), new RString("略称"));
            認知症加算一次判定結果 = new IchijiHanteiResultKomoku(new Code(new RString("001")), new RString("名称"), new RString("略称"));
            要介護認定等基準時間 = IchijiHanteiTestBusinessCreator.create要介護認定等基準時間(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            中間評価項目得点 = IchijiHanteiTestBusinessCreator.create中間評価項目得点(0, 0, 0, 0, 0, 0, 0);
            一次判定警告List = IchijiHanteiTestBusinessCreator.create一次判定警告List("000111000111000111");
            認定状態安定性 = new JotaiAnteiseiKubun(new Code(new RString("001")), new RString("名称"), new RString("略称"));
            認知症自立度2以上蓋然性 = new Decimal(123);
            推定給付区分 = new SuiteiKyuhuKubun(new Code(new RString("001")), new RString("名称"), new RString("略称"));
            運動能力未低下認知症高齢者指標 = new NoryokuMiteikaNinchishoKoreishaShihyoKomoku(new Code(new RString("001")),
                    new RString("名称"), new RString("略称"));
            日常生活自立度組み合わせ = IchijiHanteiTestBusinessCreator.create日常生活自立度組み合わせ(0, 0, 0, 0, 0, 0, 0);
            認知症高齢者日常生活自立度蓋然性評価 = new NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku(new Code(new RString("001")),
                    new RString("名称"), new RString("略称"));
            認知症高齢者日常生活自立度蓋然性評価率 = 100;
            一次判定結果送付区分 = IchijiHanteiSohuKubun.送付済み;
            一次判定結果送付年月日 = new FlexibleDate("19991231");
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(null).set厚労省IF区分(厚労省IF区分).
                    set厚労省IF区分(仮一次判定区分).set一次判定年月日(一次判定年月日).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(一次判定警告List).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test(expected = NullPointerException.class)
        public void 厚労省IF区分にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(null).
                    set厚労省IF区分(仮一次判定区分).set一次判定年月日(一次判定年月日).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(一次判定警告List).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test(expected = NullPointerException.class)
        public void 仮一次判定区分にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(厚労省IF区分).
                    set厚労省IF区分(null).set一次判定年月日(一次判定年月日).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(一次判定警告List).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test(expected = NullPointerException.class)
        public void 一次判定年月日にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(厚労省IF区分)
                    .set厚労省IF区分(仮一次判定区分).set一次判定年月日(null).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(一次判定警告List).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test(expected = NullPointerException.class)
        public void 一次判定結果にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(厚労省IF区分).
                    set厚労省IF区分(仮一次判定区分).set一次判定年月日(一次判定年月日).set一次判定結果(null).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(一次判定警告List).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test(expected = NullPointerException.class)
        public void 認知症加算一次判定結果にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(厚労省IF区分).
                    set厚労省IF区分(仮一次判定区分).set一次判定年月日(一次判定年月日).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(null).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(一次判定警告List).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test(expected = NullPointerException.class)
        public void 要介護認定等基準時間にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(厚労省IF区分).
                    set厚労省IF区分(仮一次判定区分).set一次判定年月日(一次判定年月日).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(null).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(一次判定警告List).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test(expected = NullPointerException.class)
        public void 中間評価項目得点にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(厚労省IF区分).
                    set厚労省IF区分(仮一次判定区分).set一次判定年月日(一次判定年月日).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(null).set一次判定警告List(一次判定警告List).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test(expected = NullPointerException.class)
        public void 一次判定警告Listにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(厚労省IF区分).
                    set厚労省IF区分(仮一次判定区分).set一次判定年月日(一次判定年月日).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(null).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test(expected = NullPointerException.class)
        public void 認定状態安定性にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(厚労省IF区分).
                    set厚労省IF区分(仮一次判定区分).set一次判定年月日(一次判定年月日).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(一次判定警告List).set状態安定性(null)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test(expected = NullPointerException.class)
        public void 認知症自立度2以上蓋然性にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(厚労省IF区分).
                    set厚労省IF区分(仮一次判定区分).set一次判定年月日(一次判定年月日).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(一次判定警告List).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(null).set推定給付区分(推定給付区分)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test(expected = NullPointerException.class)
        public void 推定給付区分にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(厚労省IF区分).
                    set厚労省IF区分(仮一次判定区分).set一次判定年月日(一次判定年月日).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(一次判定警告List).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(null)
                    .set運動能力未低下認知症高齢者指標(運動能力未低下認知症高齢者指標).set日常生活自立度組み合わせ(日常生活自立度組み合わせ)
                    .set認知症高齢者日常生活自立度蓋然性評価(認知症高齢者日常生活自立度蓋然性評価)
                    .set認知症高齢者日常生活自立度蓋然性評価率(認知症高齢者日常生活自立度蓋然性評価率)
                    .set一次判定結果送付区分(一次判定結果送付区分).set一次判定結果送付年月日(一次判定結果送付年月日).build();
        }

        @Test
        public void 必要項目に値が入っているとき_インスタンスが生成される() {
            sut = IchijiHanteiResultDetail.builder().set申請書管理番号(申請書管理番号).set厚労省IF区分(厚労省IF区分).
                    set厚労省IF区分(仮一次判定区分).set一次判定年月日(一次判定年月日).set一次判定結果(一次判定結果).
                    set認知症加算一次判定結果(認知症加算一次判定結果).set要介護認定等基準時間(要介護認定等基準時間).
                    set中間評価項目得点(中間評価項目得点).set一次判定警告List(一次判定警告List).set状態安定性(認定状態安定性)
                    .set認知症自立度2以上蓋然性(認知症自立度2以上蓋然性).set推定給付区分(推定給付区分).build();
            assertThat(sut, is(instanceOf(IchijiHanteiResultDetail.class)));
        }
    }
}
