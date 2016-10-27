/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120050;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績更新結果情報取込・再処理準備のDBパラメターです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiInMybatisParameter {

    private RString 表名;
    private FlexibleYearMonth 処理年月;

    /**
     * コンストラクタです。
     *
     * @param 表名 RString
     * @param 処理年月 FlexibleYearMonth
     */
    public KyufuJissekiInMybatisParameter(RString 表名, FlexibleYearMonth 処理年月) {
        this.表名 = 表名;
        this.処理年月 = 処理年月;
    }

    /**
     * コンストラクタです。
     *
     */
    public KyufuJissekiInMybatisParameter() {
    }

}
