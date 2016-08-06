/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishoshakensaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * @author quxiaodong
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoshaKensakuParameter {

    private final FlexibleDate 異動日From;
    private final FlexibleDate 異動日To;
    private final HihokenshaNo 被保険者番号;
    private final boolean 削除データ検索;

    /**
     * コンストラクタです
     *
     * @param 異動日From FlexibleDate
     * @param 異動日To FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     * @param 削除データ検索 boolean
     */
    public TaishoshaKensakuParameter(
            FlexibleDate 異動日From,
            FlexibleDate 異動日To,
            HihokenshaNo 被保険者番号,
            boolean 削除データ検索) {
        this.異動日From = 異動日From;
        this.異動日To = 異動日To;
        this.被保険者番号 = 被保険者番号;
        this.削除データ検索 = 削除データ検索;
    }
}
