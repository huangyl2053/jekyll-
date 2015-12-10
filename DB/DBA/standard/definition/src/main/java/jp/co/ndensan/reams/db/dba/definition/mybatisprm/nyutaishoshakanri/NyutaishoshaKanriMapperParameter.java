/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.nyutaishoshakanri;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 履歴期間重複チェックするためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public final class NyutaishoshaKanriMapperParameter {

    private final FlexibleDate 入所年月日;
    private final FlexibleDate 退所年月日;
    private final RString 入所施設種類;

    /**
     * コンストラクタです。
     *
     * @param 入所年月日 入所年月日
     * @param 退所年月日 退所年月日
     * @param 入所施設種類 入所施設種類
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NyutaishoshaKanriMapperParameter(
            FlexibleDate 入所年月日,
            FlexibleDate 退所年月日,
            RString 入所施設種類) {

        this.入所年月日 = 入所年月日;
        this.退所年月日 = 退所年月日;
        this.入所施設種類 = 入所施設種類;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 入所年月日 入所年月日
     * @param 退所年月日 退所年月日
     * @param 入所施設種類 入所施設種類
     * @return 履歴期間重複チェックの検索パラメータ
     */
    public static NyutaishoshaKanriMapperParameter createSelectByKeyParam(
            FlexibleDate 入所年月日,
            FlexibleDate 退所年月日,
            RString 入所施設種類) {
        return new NyutaishoshaKanriMapperParameter(入所年月日, 退所年月日, 入所施設種類);
    }
}
