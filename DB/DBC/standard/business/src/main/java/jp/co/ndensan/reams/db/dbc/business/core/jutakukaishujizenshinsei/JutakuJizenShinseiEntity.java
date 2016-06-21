/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修内容一覧のオブジェクトクラスです。
 *
 * @reamsid_L DBC-0990-060 panhe
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakuJizenShinseiEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private RString 状態;
    private RString 住宅改修内容;
    private RString 事業者;
    private RString 住宅住所;
    private RString 着工日;
    private RString 完成日;
    private RString 改修金額;

    /**
     * コンストラクタです。
     *
     * @param 状態 RString
     * @param 住宅改修内容 RString
     * @param 事業者 RString
     * @param 住宅住所 RString
     * @param 着工日 RString
     * @param 完成日 RString
     * @param 改修金額 RString
     */
    public JutakuJizenShinseiEntity(RString 状態,
            RString 住宅改修内容,
            RString 事業者,
            RString 住宅住所,
            RString 着工日,
            RString 完成日,
            RString 改修金額) {
        this.状態 = 状態;
        this.住宅改修内容 = 住宅改修内容;
        this.事業者 = 事業者;
        this.住宅住所 = 住宅住所;
        this.着工日 = 着工日;
        this.完成日 = 完成日;
        this.改修金額 = 改修金額;
    }
}
