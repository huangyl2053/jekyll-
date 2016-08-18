/*
 * To change this license header; choose License Headers in Project Properties.
 * To change this template file; choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定申請届出者のHandlerクラスです。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiTodokedeshaDataPassModel implements Serializable {

    private RString 申請届出代行区分コード;
    private RString 事業者区分;
    private RString 申請届出代行事業者番号;
    private RString 申請書管理番号;
    private RString 識別コード;
    private RString 氏名;
    private RString カナ氏名;
    private RString 続柄;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;
}
