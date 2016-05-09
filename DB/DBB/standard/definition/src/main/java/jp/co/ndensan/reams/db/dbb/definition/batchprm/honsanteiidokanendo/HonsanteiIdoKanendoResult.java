/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendo;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * ビジネス設計_DBBBZ45001_本算定異動（過年度）
 *
 * @reamsid_L DBB-0920-020 quxiaodong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiIdoKanendoResult {

    private ReportId 帳票分類ID;
    private RString 帳票ID;
    private RString 出力順ID;

    /**
     * コンストラクタです。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 帳票ID 帳票ID
     * @param 出力順ID 出力順ID
     */
    public HonsanteiIdoKanendoResult(ReportId 帳票分類ID, RString 帳票ID, RString 出力順ID) {
        this.帳票分類ID = 帳票分類ID;
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
    }

}
