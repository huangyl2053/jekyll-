/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0220011;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;

/**
 * 画面設計_DBCMN81002_受給者訂正連絡票登録（対象者検索）
 *
 * @reamsid_L DBC-2101-010 quxiaodong
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JukyushaIdoRenrakuhyoHenkoParameter implements Serializable {

    private final FlexibleDate 異動日From;
    private final FlexibleDate 異動日To;
    private final HihokenshaNo 被保番号;
    private final boolean 削除データ検索;

    /**
     * コンストラクタです。
     *
     * @param 異動日From FlexibleDate
     * @param 異動日To FlexibleDate
     * @param 被保番号 HihokenshaNo
     * @param 削除データ検索 RString
     */
    public JukyushaIdoRenrakuhyoHenkoParameter(FlexibleDate 異動日From, FlexibleDate 異動日To,
            HihokenshaNo 被保番号, boolean 削除データ検索) {
        this.異動日From = 異動日From;
        this.異動日To = 異動日To;
        this.被保番号 = 被保番号;
        this.削除データ検索 = 削除データ検索;
    }
}
