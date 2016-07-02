/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査報酬照会のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiChosaHoshuShokaiMapperParameter {

    private final RString テキストイメージ区分;
    private final FlexibleDate 調査依頼日終了;
    private final FlexibleDate 調査依頼日開始;
    private final int 最大表示件数;
    private final RString 通常区分;
    private final RString 延期区分;

    private NinteiChosaHoshuShokaiMapperParameter(RString テキストイメージ区分, FlexibleDate 調査依頼日開始,
            FlexibleDate 調査依頼日終了, int 最大表示件数, RString 通常区分, RString 延期区分) {
        this.テキストイメージ区分 = テキストイメージ区分;
        this.調査依頼日開始 = 調査依頼日開始;
        this.調査依頼日終了 = 調査依頼日終了;
        this.最大表示件数 = 最大表示件数;
        this.通常区分 = 通常区分;
        this.延期区分 = 延期区分;
    }

    /**
     * 報酬実績データ情報のパラメータを生成します。
     *
     * @param テキストイメージ区分 RString
     * @param 調査依頼日開始 FlexibleDate
     * @param 調査依頼日終了 FlexibleDate
     * @param 最大表示件数 int
     * @return NinteiChosaHoshuShokaiMapperParameter
     */
    public static NinteiChosaHoshuShokaiMapperParameter createSelectBy情報(RString テキストイメージ区分, FlexibleDate 調査依頼日開始,
            FlexibleDate 調査依頼日終了, int 最大表示件数) {
        return new NinteiChosaHoshuShokaiMapperParameter(テキストイメージ区分, 調査依頼日開始, 調査依頼日終了, 最大表示件数,
                ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード());
    }
}
