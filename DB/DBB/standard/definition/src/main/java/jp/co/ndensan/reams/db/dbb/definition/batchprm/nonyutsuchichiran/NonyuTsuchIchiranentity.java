/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力帳票entityクラスです。
 *
 * @reamsid_L DBB-0780-120 yangchenbing
 */
public class NonyuTsuchIchiranentity {

    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private RString 帳票名;
    private RString 出力順ID;

    /**
     * 帳票分類IDのgetメソッドです。
     *
     * @return 帳票分類ID
     */
    public ReportId get帳票分類ID() {
        return 帳票分類ID;

    }

    /**
     * 帳票分類IDのsetメソッドです。
     *
     * @param 帳票分類ID 帳票分類ID
     */
    public void set帳票分類ID(ReportId 帳票分類ID) {
        this.帳票分類ID = 帳票分類ID;
    }

    /**
     * 帳票分類IDのgetメソッドです。
     *
     * @return 帳票名
     */
    public RString get帳票名() {
        return 帳票名;

    }

    /**
     * 帳票名のsetメソッドです。
     *
     * @param 帳票名 帳票名
     */
    public void set帳票名(RString 帳票名) {
        this.帳票名 = 帳票名;
    }

    /**
     * 出力順IDのgetメソッドです。
     *
     * @return 出力順ID
     */
    public RString get出力順ID() {
        return 出力順ID;

    }

    /**
     * 出力順IDのsetメソッドです。
     *
     * @param 出力順ID 出力順ID
     */
    public void set出力順ID(RString 出力順ID) {
        this.出力順ID = 出力順ID;
    }

    /**
     * 帳票IDのgetメソッドです。
     *
     * @return 帳票ID
     */
    public ReportId get帳票ID() {
        return 帳票ID;

    }

    /**
     * 帳票IDのsetメソッドです。
     *
     * @param 帳票ID 帳票ID
     */
    public void set帳票ID(ReportId 帳票ID) {
        this.帳票ID = 帳票ID;
    }
}
