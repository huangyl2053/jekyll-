/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.nyutaishoshakanri;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 介護保険施設入退所者管理ですためのMapper用パラメータクラスです。
 *
 * @reamsid_L DBA-0360-010 duanzhanli
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class NyutaishoshaKanriMapperParameter {

    private final FlexibleDate 入所年月日;
    private final FlexibleDate 退所年月日;

    /**
     * コンストラクタです。
     *
     * @param 入所年月日 入所年月日
     * @param 退所年月日 退所年月日
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NyutaishoshaKanriMapperParameter(
            FlexibleDate 入所年月日,
            FlexibleDate 退所年月日) {

        this.入所年月日 = 入所年月日;
        this.退所年月日 = 退所年月日;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 入所年月日 入所年月日
     * @param 退所年月日 退所年月日
     * @return 履歴期間重複チェックの検索パラメータ
     */
    public static NyutaishoshaKanriMapperParameter createSelectByKeyParam(
            FlexibleDate 入所年月日,
            FlexibleDate 退所年月日) {
        return new NyutaishoshaKanriMapperParameter(入所年月日, 退所年月日);
    }
}
