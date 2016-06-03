/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuchokarisanteifuka;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定賦課出力帳票entity
 *
 * @reamsid_L DBB-0710-020 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuchoKariSanteiEntity {

    private ReportId 帳票分類ID;
    private RString 改頁出力順ID;
    private RString 帳票名;

    /**
     * コンストラクタです。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 改頁出力順ID 改頁出力順ID
     * @param 帳票名 帳票名
     */
    public FuchoKariSanteiEntity(ReportId 帳票分類ID,
            RString 改頁出力順ID,
            RString 帳票名) {
        this.帳票分類ID = 帳票分類ID;
        this.改頁出力順ID = 改頁出力順ID;
        this.帳票名 = 帳票名;
    }
}
