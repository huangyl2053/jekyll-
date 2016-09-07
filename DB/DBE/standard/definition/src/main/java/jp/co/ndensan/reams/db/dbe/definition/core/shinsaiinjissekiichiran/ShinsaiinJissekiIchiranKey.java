/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬集計表のキー情報クラスです
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaiinJissekiIchiranKey {

    private RString shinsakaiIinCode;
    private RString shinsakaiIinHoshuKubun;
    private RString shinsakaiKaisaiYMD;
    private int remban;
}
