/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村連絡事項のダイアログパラメータクラスです。
 *
 * @reamsid_L DBZ-1300-090 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiCodeModel implements Serializable {

    private static final long serialVersionUID = 7323078136744691791L;

    /**
     * 表示モード
     */
    public enum HyojiMode {

        /**
         * 入力モード
         */
        InputMode,
        /**
         * 照会モード
         */
        ShokaiMode;
    }

    private RString 連絡事項;
    private HyojiMode 表示モード;
    private RString メニューID;

}
