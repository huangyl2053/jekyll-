/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.keikakutodokedejokyoichiran;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 計画届出状況リストデータを抽出用パラメータクラスです。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeikakuTodokedeJokyoIchiranParameter extends UaFt200FindShikibetsuTaishoParam
        implements IMyBatisParameter {

    private final FlexibleDate 基準日;
    private final FlexibleYearMonth 基準日_年月;
    private final RString orderBy;

    /**
     * コンストラクタです。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 基準日 FlexibleDate
     * @param 基準日_年月 FlexibleYearMonth
     * @param orderBy orderBy
     */
    public KeikakuTodokedeJokyoIchiranParameter(IShikibetsuTaishoPSMSearchKey searchKey, FlexibleDate 基準日, FlexibleYearMonth 基準日_年月, RString orderBy) {
        super(searchKey);
        this.基準日 = 基準日;
        this.基準日_年月 = 基準日_年月;
        this.orderBy = orderBy;
    }

    /**
     * コンストラクタです
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 基準日 FlexibleDate
     * @param 基準日_年月 FlexibleYearMonth
     * @param orderBy orderBy
     * @return 計画届出状況リストデータを抽出用パラメータ
     */
    public static KeikakuTodokedeJokyoIchiranParameter toMybatisParamter(IShikibetsuTaishoPSMSearchKey searchKey,
            FlexibleDate 基準日, FlexibleYearMonth 基準日_年月, RString orderBy) {

        return new KeikakuTodokedeJokyoIchiranParameter(searchKey, 基準日, 基準日_年月, orderBy);
    }

}
