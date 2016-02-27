/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力帳票entityクラスです。
 *
 */
public class ShuturyokuChohuoEntity {

    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private RString 帳票名;
    private RString 改頁出力順ID;

    /**
     * 帳票分類IDのgetメソッドです。
     *
     * @return
     */
    public ReportId get帳票分類ID() {
        return 帳票分類ID;

    }

    /**
     * 帳票分類IDのsetメソッドです。
     *
     * @param 帳票分類ID
     */
    public void set帳票分類ID(ReportId 帳票分類ID) {
        this.帳票分類ID = 帳票分類ID;
    }

    /**
     * 帳票分類IDのgetメソッドです。
     *
     * @return
     */
    public RString get帳票名() {
        return 帳票名;

    }

    /**
     * 帳票名のsetメソッドです。
     *
     * @param 帳票名
     */
    public void set帳票名(RString 帳票名) {
        this.帳票名 = 帳票名;
    }

    /**
     * 改頁出力順IDのgetメソッドです。
     *
     * @return
     */
    public RString get改頁出力順ID() {
        return 改頁出力順ID;

    }

    /**
     * 改頁出力順IDのsetメソッドです。
     *
     * @param 改頁出力順ID
     */
    public void set改頁出力順ID(RString 改頁出力順ID) {
        this.改頁出力順ID = 改頁出力順ID;
    }

    /**
     * 帳票IDのgetメソッドです。
     *
     * @return
     */
    public ReportId get帳票ID() {
        return 帳票ID;

    }

    /**
     * 帳票IDのsetメソッドです。
     *
     * @param 帳票ID
     */
    public void set帳票ID(ReportId 帳票ID) {
        this.帳票ID = 帳票ID;
    }

}
