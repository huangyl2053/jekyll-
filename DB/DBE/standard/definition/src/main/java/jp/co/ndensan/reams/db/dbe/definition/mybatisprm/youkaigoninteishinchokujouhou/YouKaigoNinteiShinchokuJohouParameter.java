/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.youkaigoninteishinchokujouhou;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定進捗情報データ出力のパラーメタです。
 *
 * @reamsid_L DBE-1500-010 wanghui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class YouKaigoNinteiShinchokuJohouParameter {

    private final boolean 証記載保険者番号フラグ;
    private final boolean 被保険者番号フラグ;
    private final RString 抽出期間開始日;
    private final RString 抽出期間終了日;
    private final RString 証記載保険者番号;
    private final RString 被保険者番号;
    private final Decimal saidaiHyojiKensu;
    private final boolean usesSaidaiHyojiKensu;

    private YouKaigoNinteiShinchokuJohouParameter(RString 抽出期間開始日,
            RString 抽出期間終了日,
            RString 証記載保険者番号,
            RString 被保険者番号,
            Decimal saidaiHyojiKensu,
            boolean 証記載保険者番号フラグ,
            boolean 被保険者番号フラグ,
            boolean usesSaidaiHyojiKensu
    ) {
        this.抽出期間開始日 = 抽出期間開始日;
        this.抽出期間終了日 = 抽出期間終了日;
        this.被保険者番号 = 被保険者番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.証記載保険者番号フラグ = 証記載保険者番号フラグ;
        this.被保険者番号フラグ = 被保険者番号フラグ;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
    }

    /**
     * コンストラクタ作成
     *
     * @param 抽出期間開始日 RString
     * @param 証記載保険者番号 RString
     * @param 被保険者番号 RString
     * @param 抽出期間終了日 RString
     * @param saidaiHyojiKensu Decimal
     * @return YouKaigoNinteiShinchokuJohouParameter
     */
    public static YouKaigoNinteiShinchokuJohouParameter createParam(RString 抽出期間開始日,
            RString 抽出期間終了日,
            RString 証記載保険者番号,
            RString 被保険者番号,
            Decimal saidaiHyojiKensu) {
        boolean 証記載保険者番号フラグ = false;
        boolean 被保険者番号フラグ = false;
        boolean usesSaidaiHyojiKensu = false;
        if (!RString.isNullOrEmpty(証記載保険者番号)) {
            証記載保険者番号フラグ = true;
        }
        if (!RString.isNullOrEmpty(被保険者番号)) {
            被保険者番号フラグ = true;
        }
        if (saidaiHyojiKensu != null) {
            usesSaidaiHyojiKensu = true;
        }
        return new YouKaigoNinteiShinchokuJohouParameter(抽出期間開始日,
                抽出期間終了日,
                証記載保険者番号,
                被保険者番号,
                saidaiHyojiKensu,
                証記載保険者番号フラグ,
                被保険者番号フラグ,
                usesSaidaiHyojiKensu);
    }
}
