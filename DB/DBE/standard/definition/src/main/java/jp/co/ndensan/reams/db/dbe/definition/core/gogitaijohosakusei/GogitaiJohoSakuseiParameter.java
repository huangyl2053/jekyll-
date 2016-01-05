/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.gogitaijohosakusei;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 合議体情報作成のパラメータクラス
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GogitaiJohoSakuseiParameter {

    private final FlexibleDate nowDate;
    private final boolean is現在有効な合議体のみ;
    private final int 合議体番号;
    private final FlexibleDate 合議体有効期間開始年月日;

    /**
     * コンストラクタです。
     *
     * @param nowDate 現在日時
     * @param is現在有効な合議体のみ 現在有効な合議体のみ
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     */
    private GogitaiJohoSakuseiParameter(
            FlexibleDate nowDate,
            boolean is現在有効な合議体のみ,
            int 合議体番号,
            FlexibleDate 合議体有効期間開始年月日) {
        this.nowDate = nowDate;
        this.is現在有効な合議体のみ = is現在有効な合議体のみ;
        this.合議体番号 = 合議体番号;
        this.合議体有効期間開始年月日 = 合議体有効期間開始年月日;
    }

    /**
     * 合議体情報作成パラメータークラス作成
     *
     * @param nowDate 現在日時
     * @param is現在有効な合議体のみ 現在有効な合議体のみ
     * @param 合議体番号 合議体番号
     * @param 合議体有効期間開始年月日 合議体有効期間開始年月日
     * @return 合議体情報作成パラメータークラス
     */
    public static GogitaiJohoSakuseiParameter createGogitaiJohoSakuseiParameter(
            FlexibleDate nowDate,
            boolean is現在有効な合議体のみ,
            int 合議体番号,
            FlexibleDate 合議体有効期間開始年月日) {

        return new GogitaiJohoSakuseiParameter(nowDate, is現在有効な合議体のみ, 合議体番号, 合議体有効期間開始年月日);
    }

}
