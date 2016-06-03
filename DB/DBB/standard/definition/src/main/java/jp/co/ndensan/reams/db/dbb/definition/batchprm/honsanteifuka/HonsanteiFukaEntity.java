/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力帳票entityのクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
public class HonsanteiFukaEntity {

    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private RString 出力順ID;

    /**
     * 帳票分類IDのgetメソッドです。
     *
     * @return ReportId
     */
    public ReportId get帳票分類ID() {
        return 帳票分類ID;
    }

    /**
     * 帳票分類IDのsetメソッドです
     *
     * @param 帳票分類ID ReportId
     */
    public void set帳票分類ID(ReportId 帳票分類ID) {
        this.帳票分類ID = 帳票分類ID;
    }

    /**
     * 出力順IDのgetメソッドです。
     *
     * @return RString
     */
    public RString get出力順ID() {
        return 出力順ID;
    }

    /**
     * 出力順IDのsetメソッドです
     *
     * @param 出力順ID RString
     */
    public void set出力順ID(RString 出力順ID) {
        this.出力順ID = 出力順ID;
    }

    /**
     * 帳票IDのgetメソッドです。
     *
     * @return ReportId
     */
    public ReportId get帳票ID() {
        return 帳票ID;
    }

    /**
     * 帳票IDのsetメソッドです。
     *
     * @param 帳票ID ReportId
     */
    public void set帳票ID(ReportId 帳票ID) {
        this.帳票ID = 帳票ID;
    }
}
