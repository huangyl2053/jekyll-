/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 一次判定結果の、詳細な情報を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiResult {

    private final ShinseishoKanriNo 申請書管理番号;
    private final KoroshoIFKubun 厚労省IF区分;
    private final KariIchijiHanteiKubun 仮一次判定区分;
    private final FlexibleDate 一次判定年月日;
    private final IchijiHanteiKekkaKomoku 一次判定結果;
    private final IchijiHanteiKekkaKomoku 認知症加算一次判定結果;
    private final YokaigoNinteiToKijunTime 要介護認定等基準時間;
    private final YokaigoNinteiChukanHyokaKomokuTokuten 中間評価項目得点;
    private final IchijiHanteiKeikokuList 一次判定警告List;
    private final KaigoNinteiJotaiAnteiseiKubun 認定状態安定性;
    private final Decimal 認知症自立度2以上蓋然性;
    private final SuiteiKyuhuKubun 推定給付区分;
    private final NoryokuMiteikaNinchishoKoreishaShihyoKomoku 運動能力未低下認知症高齢者指標;
    private final NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ;
    private final NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku 認知症高齢者日常生活自立度蓋然性評価;
    private final int 認知症高齢者日常生活自立度蓋然性評価率;
    private final RString 一次判定結果送付区分;
    private final FlexibleDate 一次判定結果送付年月日;

    /**
     * 引数から一次判定結果の詳細な情報を受け取り、インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 厚労省IF区分 厚労省IF区分
     * @param 仮一次判定区分 仮一次判定区分
     * @param 一次判定年月日 一次判定年月日
     * @param 一次判定結果 一次判定結果
     * @param 認知症加算一次判定結果 認知症加算一次判定結果
     * @param 要介護認定等基準時間 要介護認定等基準時間
     * @param 中間評価項目得点 中間評価項目得点
     * @param 一次判定警告List 一次判定警告List
     * @param 認定状態安定性 認定状態安定性
     * @param 認知症自立度2以上蓋然性 認知症自立度2以上蓋然性
     * @param 推定給付区分 推定給付区分
     * @param 運動能力未低下認知症高齢者指標 運動能力未低下認知症高齢者指標
     * @param 日常生活自立度組み合わせ 日常生活自立度組み合わせ
     * @param 認知症高齢者日常生活自立度蓋然性評価 認知症高齢者日常生活自立度蓋然性評価
     * @param 認知症高齢者日常生活自立度蓋然性評価率 認知症高齢者日常生活自立度蓋然性評価率
     * @param 一次判定結果送付区分 一次判定結果送付区分
     * @param 一次判定結果送付年月日 一次判定結果送付年月日
     * @throws NullPointerException
     * 申請書管理番号、一次判定年月日、一次判定結果、認知症加算一次判定結果、要介護認定等基準時間、中間評価項目得点、一次判定警告List、
     * 認定状態安定性、認知症自立度2以上蓋然性、推定給付区分のいずれかにnullが渡されたとき
     */
    public IchijiHanteiResult(ShinseishoKanriNo 申請書管理番号, KoroshoIFKubun 厚労省IF区分, KariIchijiHanteiKubun 仮一次判定区分,
            FlexibleDate 一次判定年月日, IchijiHanteiKekkaKomoku 一次判定結果, IchijiHanteiKekkaKomoku 認知症加算一次判定結果,
            YokaigoNinteiToKijunTime 要介護認定等基準時間, YokaigoNinteiChukanHyokaKomokuTokuten 中間評価項目得点,
            IchijiHanteiKeikokuList 一次判定警告List, KaigoNinteiJotaiAnteiseiKubun 認定状態安定性, Decimal 認知症自立度2以上蓋然性,
            SuiteiKyuhuKubun 推定給付区分, NoryokuMiteikaNinchishoKoreishaShihyoKomoku 運動能力未低下認知症高齢者指標,
            NichijoSeikatsuJiritsudoKumiawase 日常生活自立度組み合わせ,
            NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku 認知症高齢者日常生活自立度蓋然性評価, int 認知症高齢者日常生活自立度蓋然性評価率,
            RString 一次判定結果送付区分, FlexibleDate 一次判定結果送付年月日) throws NullPointerException {
        requireNonNull(申請書管理番号, Messages.E00003.replace("申請書管理番号", getClass().getName()).getMessage());
        requireNonNull(厚労省IF区分, Messages.E00003.replace("厚労省IF区分", getClass().getName()).getMessage());
        requireNonNull(仮一次判定区分, Messages.E00003.replace("仮一次判定区分", getClass().getName()).getMessage());
        requireNonNull(一次判定年月日, Messages.E00003.replace("一次判定年月日", getClass().getName()).getMessage());
        requireNonNull(一次判定結果, Messages.E00003.replace("一次判定結果", getClass().getName()).getMessage());
        requireNonNull(認知症加算一次判定結果, Messages.E00003.replace("認知症加算一次判定結果", getClass().getName()).getMessage());
        requireNonNull(要介護認定等基準時間, Messages.E00003.replace("要介護認定等基準時間", getClass().getName()).getMessage());
        requireNonNull(中間評価項目得点, Messages.E00003.replace("中間評価項目得点", getClass().getName()).getMessage());
        requireNonNull(一次判定警告List, Messages.E00003.replace("一次判定警告List", getClass().getName()).getMessage());
        requireNonNull(認定状態安定性, Messages.E00003.replace("認定状態安定性", getClass().getName()).getMessage());
        requireNonNull(認知症自立度2以上蓋然性, Messages.E00003.replace("認知症自立度2以上蓋然性", getClass().getName()).getMessage());
        requireNonNull(推定給付区分, Messages.E00003.replace("推定給付区分", getClass().getName()).getMessage());

        this.申請書管理番号 = 申請書管理番号;
        this.厚労省IF区分 = 厚労省IF区分;
        this.仮一次判定区分 = 仮一次判定区分;
        this.一次判定年月日 = 一次判定年月日;
        this.一次判定結果 = 一次判定結果;
        this.認知症加算一次判定結果 = 認知症加算一次判定結果;
        this.要介護認定等基準時間 = 要介護認定等基準時間;
        this.中間評価項目得点 = 中間評価項目得点;
        this.一次判定警告List = 一次判定警告List;
        this.認定状態安定性 = 認定状態安定性;
        this.認知症自立度2以上蓋然性 = 認知症自立度2以上蓋然性;
        this.推定給付区分 = 推定給付区分;
        this.運動能力未低下認知症高齢者指標 = 運動能力未低下認知症高齢者指標;
        this.日常生活自立度組み合わせ = 日常生活自立度組み合わせ;
        this.認知症高齢者日常生活自立度蓋然性評価 = 認知症高齢者日常生活自立度蓋然性評価;
        this.認知症高齢者日常生活自立度蓋然性評価率 = 認知症高齢者日常生活自立度蓋然性評価率;
        this.一次判定結果送付区分 = 一次判定結果送付区分;
        this.一次判定結果送付年月日 = 一次判定結果送付年月日;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
    }

    /**
     * 厚労省IF区分を返します。
     *
     * @return 厚労省IF区分
     */
    public KoroshoIFKubun get厚労省IF区分() {
        return 厚労省IF区分;
    }

    /**
     * 仮一次判定区分を返します
     *
     * @return 仮一次判定区分
     */
    public KariIchijiHanteiKubun get仮一次判定区分() {
        return 仮一次判定区分;
    }

    /**
     * 一次判定年月日を返します。
     *
     * @return 一次判定年月日
     */
    public FlexibleDate get一次判定年月日() {
        return 一次判定年月日;
    }

    /**
     * 一次判定結果を返します。
     *
     * @return 一次判定結果
     */
    public IchijiHanteiKekkaKomoku get一次判定結果() {
        return 一次判定結果;
    }

    /**
     * 認知症加算一次判定結果を返します。
     *
     * @return 認知症加算一次判定結果
     */
    public IchijiHanteiKekkaKomoku get認知症加算一次判定結果() {
        return 認知症加算一次判定結果;
    }

    /**
     * 要介護認定等基準時間を返します。
     *
     * @return 要介護認定等基準時間
     */
    public YokaigoNinteiToKijunTime get要介護認定等基準時間() {
        return 要介護認定等基準時間;
    }

    /**
     * 中間評価項目得点を返します。
     *
     * @return 中間評価項目得点
     */
    public YokaigoNinteiChukanHyokaKomokuTokuten get中間評価項目得点() {
        return 中間評価項目得点;
    }

    /**
     * 一次判定警告リストを返します。
     *
     * @return 一次判定警告リスト
     */
    public IchijiHanteiKeikokuList get一次判定警告List() {
        return 一次判定警告List;
    }

    /**
     * 認定状態安定性を返します。
     *
     * @return 認定状態安定性
     */
    public KaigoNinteiJotaiAnteiseiKubun get認定状態安定性() {
        return 認定状態安定性;
    }

    /**
     * 認知症自立度2以上蓋然性を返します。
     *
     * @return 認知症自立度2以上蓋然性
     */
    public Decimal get認知症自立度2以上蓋然性() {
        return 認知症自立度2以上蓋然性;
    }

    /**
     * 推定給付区分を返します。
     *
     * @return 推定給付区分
     */
    public SuiteiKyuhuKubun get推定給付区分() {
        return 推定給付区分;
    }

    /**
     * 運動能力未低下認知症高齢者指標を返します。
     *
     * @return 運動能力未低下認知症高齢者指標
     */
    public NoryokuMiteikaNinchishoKoreishaShihyoKomoku get運動能力未低下認知症高齢者指標() {
        return 運動能力未低下認知症高齢者指標;
    }

    /**
     * 日常生活自立度組み合わせを返します。
     *
     * @return 日常生活自立度組み合わせ
     */
    public NichijoSeikatsuJiritsudoKumiawase get日常生活自立度組み合わせ() {
        return 日常生活自立度組み合わせ;
    }

    /**
     * 認知症高齢者日常生活自立度蓋然性評価を返します。
     *
     * @return 認知症高齢者日常生活自立度蓋然性評価
     */
    public NinchishoKoreishaJiritsudoGaizenseiHyokaKomoku get認知症高齢者日常生活自立度蓋然性評価() {
        return 認知症高齢者日常生活自立度蓋然性評価;
    }

    /**
     * 認知症高齢者日常生活自立度蓋然性評価率を返します。
     *
     * @return 認知症高齢者日常生活自立度蓋然性評価率
     */
    public int get認知症高齢者日常生活自立度蓋然性評価率() {
        return 認知症高齢者日常生活自立度蓋然性評価率;
    }

    /**
     * 一次判定結果送付区分を返します。
     *
     * @return 一次判定結果送付区分
     */
    public RString get一次判定結果送付区分() {
        return 一次判定結果送付区分;
    }

    /**
     * 一次判定結果送付年月日を返します。
     *
     * @return 一次判定結果送付年月日
     */
    public FlexibleDate get一次判定結果送付年月日() {
        return 一次判定結果送付年月日;
    }
}
