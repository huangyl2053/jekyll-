/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidokekka;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ出力帳票一覧のクラスです。
 *
 * @reamsid_L DBB-0850-010 zhaowei
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiIdoKekkaResult {

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
    public KarisanteiIdoKekkaResult(ReportId 帳票分類ID, RString 帳票ID, RString 出力順ID) {
        this.帳票分類ID = 帳票分類ID;
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
    }

    /**
     * コンストラクタです。
     */
    public KarisanteiIdoKekkaResult() {

    }
}
