/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準収入額決定通知一覧表のPageBreakenum
 *
 * @reamsid_L DBC-4610-050 xuhao
 */
public enum KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号("0001", "郵便番号", "yubinNo"),
    /**
     * 町域コード
     */
    町域コード("0002", "町域コード", "choikiCode"),
    /**
     * 行政区コード
     */
    行政区コード("0004", "行政区コード", "gyoseikuCode"),
    /**
     * 世帯コード
     */
    世帯コード("0008", "世帯コード", "setaiCode"),
    /**
     * 市町村コード
     */
    市町村コード("0016", "市町村コード", "shichosonCode");

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KijunShunyugakuTekiyoKetteiTsuchiIchiranOutPutOrder(String 項目ID, String フォームフィールド名, String myBatis項目名) {
        this.項目ID = new RString(項目ID);
        this.フォームフィールド名 = new RString(フォームフィールド名);
        this.myBatis項目名 = new RString(myBatis項目名);
    }

    @Override
    public RString get項目ID() {
        return this.項目ID;
    }

    @Override
    public RString getフォームフィールド名() {
        return this.フォームフィールド名;
    }

    @Override
    public RString getMyBatis項目名() {
        return this.myBatis項目名;
    }

}
