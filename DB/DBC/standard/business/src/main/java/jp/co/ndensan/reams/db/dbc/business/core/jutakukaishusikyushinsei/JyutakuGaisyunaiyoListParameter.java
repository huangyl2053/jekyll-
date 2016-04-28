/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 「住宅改修内容一覧」共有子DIVパラメータクラスです。
 *
 * @reamsid_L DBC-0992-150 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JyutakuGaisyunaiyoListParameter {

    private final RString 状態;
    private final RString 対象住宅住所;
    private final FlexibleDate 着工年月日;

    /**
     * コンストラクタです。
     *
     */
    private JyutakuGaisyunaiyoListParameter(RString 状態,
            RString 対象住宅住所,
            FlexibleDate 着工年月日) {
        this.状態 = 状態;
        this.対象住宅住所 = 対象住宅住所;
        this.着工年月日 = 着工年月日;
    }

    /**
     * コンストラクタです。
     *
     * @param 状態 RowState
     * @param 対象住宅住所 RString
     * @param 着工年月日 FlexibleDate
     * @return 住宅改修内容一覧
     */
    public static JyutakuGaisyunaiyoListParameter createSelectByKeyParam(RString 状態,
            RString 対象住宅住所,
            FlexibleDate 着工年月日) {
        return new JyutakuGaisyunaiyoListParameter(状態, 対象住宅住所, 着工年月日);
    }
}
