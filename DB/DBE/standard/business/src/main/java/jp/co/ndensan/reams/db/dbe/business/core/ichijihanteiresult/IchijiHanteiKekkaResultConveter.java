/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijihanteiresult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiShoriKekka;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 一次判定DLLから受け取った文字列を、一次判定クラスに変換します。
 *
 * @author n8178
 */
public class IchijiHanteiKekkaResultConveter {

    /**
     * 一次判定DLLから戻ってきた結果を分解した場合、８つのデータを持つ。
     */
    private static final int RESULT_NUM = 8;
    private static final int DIVISION_NUM = 10;

    /**
     * 一次判定DLLから戻ってきた値を、個別のデータに切り分けるために使用する文字です。
     */
    private enum SplitString {

        /**
         * 複数の対象者を一括で一次判定した場合に、区切りとして使用される文字列
         */
        ARGMENT_SPLIT("\\|"),
        /**
         * 一次判定データの区切りとして使用される文字列
         */
        DATA_SPLIT("\\,"),
        /**
         * 一次判定データのうち、基準時間など複数の情報を持つデータを区切る為に使用される文字列
         */
        DATA_DETAIL_SPLIT("\\-");

        private final String value;

        private SplitString(String str) {
            this.value = str;
        }

        public String value() {
            return value;
        }
    }

    /**
     * 一次判定処理結果のどこに何の値が設定されているかを示す数値です。
     */
    private enum IchijiHanteiPoint {

        /**
         * 一次判定結果区分コードの位置を示します。
         */
        一次判定結果(0),
        /**
         * 一次判定結果区分コード（認知症加算）の位置を示します。
         */
        一次判定結果_認知症加算(1),
        /**
         * 基準時間の位置を示します。
         */
        基準時間(2),
        /**
         * 中間評価項目得点の位置を示します。
         */
        中間評価項目(3),
        /**
         * 一次判定結果警告コードの位置を示します。
         */
        警告コード(4),
        /**
         * 認知症自立度Ⅱ以上の蓋然性の位置を示します。
         */
        蓋然性(5),
        /**
         * 要介護認定状態の安定性コードの位置を示します。
         */
        安定性(6),
        /**
         * 認知機能及び状態安定性から推定される給付区分コードの位置を示します。
         */
        類推給付区分(7);

        private final int value;

        private IchijiHanteiPoint(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

    /**
     * 一次判定DLLから戻ってきた値の中で、特に基準時間の詳細な場所を示すものを定義します。
     */
    private enum KijunJikanPoint {

        /**
         * 要介護認定等基準時間（合計）の位置を示します。
         */
        合計(0),
        /**
         * 要介護認定等基準時間（食事）の位置を示します。
         */
        食事(1),
        /**
         * 要介護認定等基準時間（排泄）の位置を示します。
         */
        排泄(2),
        /**
         * 要介護認定等基準時間（移動）の位置を示します。
         */
        移動(3),
        /**
         * 要介護認定等基準時間（清潔保持）の位置を示します。
         */
        清潔保持(4),
        /**
         * 要介護認定等基準時間（間接ケア）の位置を示します。
         */
        間接ケア(5),
        /**
         * 要介護認定等基準時間（BPSD関連）の位置を示します。
         */
        BPSD関連(6),
        /**
         * 要介護認定等基準時間（機能訓練）の位置を示します。
         */
        機能訓練(7),
        /**
         * 要介護認定等基準時間（医療関連）の位置を示します。
         */
        医療関連(8),
        /**
         * 要介護認定等基準時間（認知症加算）の位置を示します。
         */
        認知症加算(9);

        private final int value;

        private KijunJikanPoint(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

    /**
     * 一次判定DLLから戻ってきた値の中で、特に中間評価項目の詳細な場所を示すものを定義します。
     */
    private enum ChukanHyokaKomokuPoint {

        /**
         * 中間評価項目得点第1群の位置を示します。
         */
        第1群(0),
        /**
         * 中間評価項目得点第2群の位置を示します。
         */
        第2群_食事(1),
        /**
         * 中間評価項目得点第3群の位置を示します。
         */
        第3群_排泄(2),
        /**
         * 中間評価項目得点第4群の位置を示します。
         */
        第4群_移動(3),
        /**
         * 中間評価項目得点第5群の位置を示します。
         */
        第5群_清潔保持(4);

        private final int value;

        private ChukanHyokaKomokuPoint(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

    private final RString ichijiHanteiKekka;
    private final List<ShinseishoKanriNo> shinseishoKanriNoList;

    /**
     * 複数の申請情報に対して一次判定処理を行った場合に使用するコンストラクタです。
     *
     * @param shinseishoKanriNoList 処理対象の申請書管理番号List
     * @param ichijiHanteiKekka 一次判定の結果
     */
    public IchijiHanteiKekkaResultConveter(List<ShinseishoKanriNo> shinseishoKanriNoList, RString ichijiHanteiKekka) {
        Objects.requireNonNull(shinseishoKanriNoList);
        Objects.requireNonNull(ichijiHanteiKekka);

        this.ichijiHanteiKekka = ichijiHanteiKekka;
        this.shinseishoKanriNoList = shinseishoKanriNoList;
    }

    /**
     * １つの申請情報に対して一次判定処理を行った場合に使用するコンストラクタです。
     *
     * @param shinseishoKanriNo 処理対象の申請書管理番号
     * @param ichijiHanteiKekka 一次判定の結果
     */
    public IchijiHanteiKekkaResultConveter(ShinseishoKanriNo shinseishoKanriNo, RString ichijiHanteiKekka) {
        Objects.requireNonNull(shinseishoKanriNo);
        Objects.requireNonNull(ichijiHanteiKekka);

        this.ichijiHanteiKekka = ichijiHanteiKekka;
        this.shinseishoKanriNoList = new ArrayList<>();
        this.shinseishoKanriNoList.add(shinseishoKanriNo);
    }

    /**
     * 判定結果が１つでもエラーしている場合にtrueを返します。
     */
    public boolean isHanteiKekkaError() {
        if (RString.isNullOrEmpty(ichijiHanteiKekka)) {
            return true;
        }
        List<IchijiHanteiKekkaJoho> retList = new ArrayList<>();
        List<RString> ichijiHanteiKekkaArgSplit = ichijiHanteiKekka.split(SplitString.ARGMENT_SPLIT.value());

        for (RString ichijiHanteiKekkaArg : ichijiHanteiKekkaArgSplit) {

            List<RString> resultList = ichijiHanteiKekkaArg.split(SplitString.DATA_SPLIT.value());
            if (resultList.size() != RESULT_NUM) {
                return true;
            }
        }

        return false;
    }

    /**
     * 一次判定結果をクラス化して返します。判定結果が
     *
     * @return 一次判定結果をクラス化したものをまとめたList
     */
    public List<IchijiHanteiShoriKekka> convert() {
        if (RString.isNullOrEmpty(ichijiHanteiKekka)) {
            return Collections.emptyList();
        }
        List<IchijiHanteiShoriKekka> retList = new ArrayList<>();
        List<RString> ichijiHanteiKekkaArgSplit = ichijiHanteiKekka.split(SplitString.ARGMENT_SPLIT.value());

        for (int i = 0; i < shinseishoKanriNoList.size(); i++) {
            ShinseishoKanriNo shinseishoKanriNo = shinseishoKanriNoList.get(i);
            RString ichijiHanteiKekkaArg = ichijiHanteiKekkaArgSplit.get(i);

            List<RString> resultList = ichijiHanteiKekkaArg.split(SplitString.DATA_SPLIT.value());
            IchijiHanteiKekkaJoho hanteiKekka = new IchijiHanteiKekkaJoho(shinseishoKanriNo);

            if (resultList.size() != RESULT_NUM) {
                IchijiHanteiShoriKekka kekka = new IchijiHanteiShoriKekka(shinseishoKanriNo, hanteiKekka, true);
                retList.add(kekka);
                continue;
            }

            IchijiHanteiKekkaJohoBuilder builder = hanteiKekka.createBuilderForEdit();

            RString ichijiHanteiKekkaCode = resultList.get(IchijiHanteiPoint.一次判定結果.value());
            RString tumitashiKekkaCode = resultList.get(IchijiHanteiPoint.一次判定結果_認知症加算.value());

            builder.set要介護認定一次判定年月日(FlexibleDate.getNowDate());
            builder.set要介護認定一次判定結果コード(new Code(ichijiHanteiKekkaCode));
            builder.set要介護認定一次判定結果コード_認知症加算(new Code(tumitashiKekkaCode));

            RString kijunJikan = resultList.get(IchijiHanteiPoint.基準時間.value());
            List<RString> kijunJikanSplit = kijunJikan.split(SplitString.DATA_DETAIL_SPLIT.value());
            builder.set要介護認定等基準時間(rStringToIntAndDivide10(kijunJikanSplit.get(KijunJikanPoint.合計.value())));
            builder.set要介護認定等基準時間_食事(rStringToIntAndDivide10(kijunJikanSplit.get(KijunJikanPoint.食事.value())));
            builder.set要介護認定等基準時間_排泄(rStringToIntAndDivide10(kijunJikanSplit.get(KijunJikanPoint.排泄.value())));
            builder.set要介護認定等基準時間_移動(rStringToIntAndDivide10(kijunJikanSplit.get(KijunJikanPoint.移動.value())));
            builder.set要介護認定等基準時間_清潔保持(rStringToIntAndDivide10(kijunJikanSplit.get(KijunJikanPoint.清潔保持.value())));
            builder.set要介護認定等基準時間_間接ケア(rStringToIntAndDivide10(kijunJikanSplit.get(KijunJikanPoint.間接ケア.value())));
            builder.set要介護認定等基準時間_BPSD関連(rStringToIntAndDivide10(kijunJikanSplit.get(KijunJikanPoint.BPSD関連.value())));
            builder.set要介護認定等基準時間_機能訓練(rStringToIntAndDivide10(kijunJikanSplit.get(KijunJikanPoint.機能訓練.value())));
            builder.set要介護認定等基準時間_医療関連(rStringToIntAndDivide10(kijunJikanSplit.get(KijunJikanPoint.医療関連.value())));
            builder.set要介護認定等基準時間_認知症加算(rStringToIntAndDivide10(kijunJikanSplit.get(KijunJikanPoint.認知症加算.value())));

            RString hyokaJikan = resultList.get(IchijiHanteiPoint.中間評価項目.value());
            List<RString> hyokaJikanSplit = hyokaJikan.split("-");
            builder.set中間評価項目得点第1群(rStringToIntAndDivide10(hyokaJikanSplit.get(ChukanHyokaKomokuPoint.第1群.value())));
            builder.set中間評価項目得点第2群(rStringToIntAndDivide10(hyokaJikanSplit.get(ChukanHyokaKomokuPoint.第2群_食事.value())));
            builder.set中間評価項目得点第3群(rStringToIntAndDivide10(hyokaJikanSplit.get(ChukanHyokaKomokuPoint.第3群_排泄.value())));
            builder.set中間評価項目得点第4群(rStringToIntAndDivide10(hyokaJikanSplit.get(ChukanHyokaKomokuPoint.第4群_移動.value())));
            builder.set中間評価項目得点第5群(rStringToIntAndDivide10(hyokaJikanSplit.get(ChukanHyokaKomokuPoint.第5群_清潔保持.value())));
            builder.set中間評価項目得点第6群(0);
            builder.set中間評価項目得点第7群(0);

            RString keikokuCode = resultList.get(IchijiHanteiPoint.警告コード.value());
            builder.set要介護認定一次判定警告コード(keikokuCode);

            RString gaizenseiP = resultList.get(IchijiHanteiPoint.蓋然性.value());
            builder.set認知症自立度Ⅱ以上の蓋然性(rStringToDecimalAndDivide10(gaizenseiP));

            RString anteisei = resultList.get(IchijiHanteiPoint.安定性.value());
            builder.set要介護認定状態の安定性コード(new Code(anteisei));

            RString kyufuKubun = resultList.get(IchijiHanteiPoint.類推給付区分.value());
            builder.set認知機能及び状態安定性から推定される給付区分コード(new Code(kyufuKubun));

            IchijiHanteiShoriKekka kekka = new IchijiHanteiShoriKekka(shinseishoKanriNo, builder.build(), false);
            retList.add(kekka);
        }
        return retList;
    }

    private int rStringToIntAndDivide10(RString str) {
        int i = Integer.parseInt(str.toString());
        return i / DIVISION_NUM;
    }

    private Decimal rStringToDecimalAndDivide10(RString str) {
        Decimal d = new Decimal(str.toString());
        if (d.equals(new Decimal(-1))) {
            return d;
        }
        return d.divide(DIVISION_NUM);
    }
}
