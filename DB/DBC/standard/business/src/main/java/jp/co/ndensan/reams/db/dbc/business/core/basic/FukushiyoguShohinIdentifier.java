/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 福祉用具商品名入力ガイドの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class FukushiyoguShohinIdentifier implements Serializable {

    private static final long serialVersionUID = -5921387384337740106L;
    private final RString 商品番号;
    private final FlexibleDate 管理開始年月日;

    /**
     * コンストラクタです。
     *
     * @param 商品番号 商品番号
     * @param 管理開始年月日 管理開始年月日
     */
    public FukushiyoguShohinIdentifier(RString 商品番号,
            FlexibleDate 管理開始年月日) {
        this.商品番号 = 商品番号;
        this.管理開始年月日 = 管理開始年月日;
    }

}
