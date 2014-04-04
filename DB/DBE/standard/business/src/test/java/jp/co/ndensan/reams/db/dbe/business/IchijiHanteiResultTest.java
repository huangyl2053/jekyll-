/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiKeikokuShubetsu;
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
public class IchijiHanteiResultTest {

    private static IchijiHanteiResult sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        private ShinseishoKanriNo 申請書管理番号;
        private KoroshoIFKubun 厚労省IF区分;
        private KariIchijiHanteiKubun 仮一次判定区分;
        private FlexibleDate 一次判定年月日;
        private IchijiHanteiKekkaKomoku 一次判定結果;
        private IchijiHanteiKekkaKomoku 認知症加算一次判定結果;
        private YokaigoNinteiToKijunTime 要介護認定等基準時間;
        private YokaigoNinteiChukanHyokaKomokuTokuten 中間評価項目得点;
        private IchijiHanteiKeikokuList 一次判定警告List;
        private KaigoNinteiJotaiAnteiseiKubun 認定状態安定性;
        private Decimal 認知症自立度2以上蓋然性;
        private SuiteiKyuhuKubun 推定給付区分;
        private NoryokuMiteikaNinchishoKoreishaShihyoKomoku 運動能力未低下認知症高齢者指標;
        private NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ;
        private NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku 認知症高齢者日常生活自立度蓋然性評価;
        private int 認知症高齢者日常生活自立度蓋然性評価率;
        private RString 一次判定結果送付区分;
        private FlexibleDate 一次判定結果送付年月日;

        @Before
        public void setUp() {
            申請書管理番号 = new ShinseishoKanriNo(new RString("001"));
            厚労省IF区分 = KoroshoIFKubun.V02A;
            仮一次判定区分 = KariIchijiHanteiKubun.仮判定;
            一次判定年月日 = new FlexibleDate("19990101");
            一次判定結果 = new IchijiHanteiKekkaKomoku(new Code(new RString("001")), new RString("名称"), new RString("略称"));
            認知症加算一次判定結果 = new IchijiHanteiKekkaKomoku(new Code(new RString("001")), new RString("名称"), new RString("略称"));
            要介護認定等基準時間 = new YokaigoNinteiToKijunTime(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
            中間評価項目得点 = new YokaigoNinteiChukanHyokaKomokuTokuten(0, 0, 0, 0, 0, 0, 0);
            一次判定警告List = new IchijiHanteiKeikokuList(RString.EMPTY,
                    IchijiHanteiKeikokuShubetsu.介護保険制度2006年度版, Collections.EMPTY_LIST);
            認定状態安定性 = new KaigoNinteiJotaiAnteiseiKubun(new Code(new RString("001")), new RString("名称"), new RString("略称"));
            認知症自立度2以上蓋然性 = new Decimal(123);
            推定給付区分 = new SuiteiKyuhuKubun(new Code(new RString("001")), new RString("名称"), new RString("略称"));
            運動能力未低下認知症高齢者指標 = new NoryokuMiteikaNinchishoKoreishaShihyoKomoku(new Code(new RString("001")),
                    new RString("名称"), new RString("略称"));
            日常生活自立度組み合わせ = new NichijoSeikatsuJiritsudoKumiawase(0, 0, 0, 0, 0, 0, 0);
            認知症高齢者日常生活自立度蓋然性評価 = new NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku(new Code(new RString("001")),
                    new RString("名称"), new RString("略称"));
            認知症高齢者日常生活自立度蓋然性評価率 = 100;
            一次判定結果送付区分 = new RString("A01");
            一次判定結果送付年月日 = new FlexibleDate("19991231");
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(null, 厚労省IF区分, 仮一次判定区分, 一次判定年月日, 一次判定結果, 認知症加算一次判定結果, 要介護認定等基準時間,
                    中間評価項目得点, 一次判定警告List, 認定状態安定性, 認知症自立度2以上蓋然性, 推定給付区分,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 厚労省IF区分にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(申請書管理番号, null, 仮一次判定区分, 一次判定年月日, 一次判定結果, 認知症加算一次判定結果, 要介護認定等基準時間,
                    中間評価項目得点, 一次判定警告List, 認定状態安定性, 認知症自立度2以上蓋然性, 推定給付区分,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 仮一次判定区分にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(申請書管理番号, 厚労省IF区分, null, 一次判定年月日, 一次判定結果, 認知症加算一次判定結果, 要介護認定等基準時間,
                    中間評価項目得点, 一次判定警告List, 認定状態安定性, 認知症自立度2以上蓋然性, 推定給付区分,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 一次判定年月日にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(申請書管理番号, 厚労省IF区分, 仮一次判定区分, null, 一次判定結果, 認知症加算一次判定結果, 要介護認定等基準時間,
                    中間評価項目得点, 一次判定警告List, 認定状態安定性, 認知症自立度2以上蓋然性, 推定給付区分,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 一次判定結果にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(申請書管理番号, 厚労省IF区分, 仮一次判定区分, 一次判定年月日, null, 認知症加算一次判定結果, 要介護認定等基準時間,
                    中間評価項目得点, 一次判定警告List, 認定状態安定性, 認知症自立度2以上蓋然性, 推定給付区分,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 認知症加算一次判定結果にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(申請書管理番号, 厚労省IF区分, 仮一次判定区分, 一次判定年月日, 一次判定結果, null, 要介護認定等基準時間,
                    中間評価項目得点, 一次判定警告List, 認定状態安定性, 認知症自立度2以上蓋然性, 推定給付区分,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護認定等基準時間にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(申請書管理番号, 厚労省IF区分, 仮一次判定区分, 一次判定年月日, 一次判定結果, 認知症加算一次判定結果, null,
                    中間評価項目得点, 一次判定警告List, 認定状態安定性, 認知症自立度2以上蓋然性, 推定給付区分,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 中間評価項目得点にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(申請書管理番号, 厚労省IF区分, 仮一次判定区分, 一次判定年月日, 一次判定結果, 認知症加算一次判定結果, 要介護認定等基準時間,
                    null, 一次判定警告List, 認定状態安定性, 認知症自立度2以上蓋然性, 推定給付区分,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 一次判定警告Listにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(申請書管理番号, 厚労省IF区分, 仮一次判定区分, 一次判定年月日, 一次判定結果, 認知症加算一次判定結果, 要介護認定等基準時間,
                    中間評価項目得点, null, 認定状態安定性, 認知症自立度2以上蓋然性, 推定給付区分,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 認定状態安定性にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(申請書管理番号, 厚労省IF区分, 仮一次判定区分, 一次判定年月日, 一次判定結果, 認知症加算一次判定結果, 要介護認定等基準時間,
                    中間評価項目得点, 一次判定警告List, null, 認知症自立度2以上蓋然性, 推定給付区分,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 認知症自立度2以上蓋然性にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(申請書管理番号, 厚労省IF区分, 仮一次判定区分, 一次判定年月日, 一次判定結果, 認知症加算一次判定結果, 要介護認定等基準時間,
                    中間評価項目得点, 一次判定警告List, 認定状態安定性, null, 推定給付区分,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 推定給付区分にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new IchijiHanteiResult(申請書管理番号, 厚労省IF区分, 仮一次判定区分, 一次判定年月日, 一次判定結果, 認知症加算一次判定結果, 要介護認定等基準時間,
                    中間評価項目得点, 一次判定警告List, 認定状態安定性, 認知症自立度2以上蓋然性, null,
                    運動能力未低下認知症高齢者指標, 日常生活自立度組み合わせ, 認知症高齢者日常生活自立度蓋然性評価,
                    認知症高齢者日常生活自立度蓋然性評価率, 一次判定結果送付区分, 一次判定結果送付年月日);
        }

        @Test
        public void 必要項目に値が入っているとき_インスタンスが生成される() {
            sut = new IchijiHanteiResult(申請書管理番号, 厚労省IF区分, 仮一次判定区分, 一次判定年月日, 一次判定結果, 認知症加算一次判定結果, 要介護認定等基準時間,
                    中間評価項目得点, 一次判定警告List, 認定状態安定性, 認知症自立度2以上蓋然性, 推定給付区分,
                    null, null, null, 0, null, null);
            assertThat(sut, is(instanceOf(IchijiHanteiResult.class)));
        }
    }
}
