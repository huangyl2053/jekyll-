package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Apr 22 11:46:15 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgYoshikiNo_Row のクラスファイル
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class dgYoshikiNo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private RString yoshikiNo;
    private RString yoshikiName;

    public dgYoshikiNo_Row() {
        super();
        this.yoshikiNo = RString.EMPTY;
        this.yoshikiName = RString.EMPTY;
        this.setOriginalData("yoshikiNo", yoshikiNo);
        this.setOriginalData("yoshikiName", yoshikiName);
    }

    public dgYoshikiNo_Row(RString yoshikiNo, RString yoshikiName) {
        super();
        this.setOriginalData("yoshikiNo", yoshikiNo);
        this.setOriginalData("yoshikiName", yoshikiName);
        this.yoshikiNo = yoshikiNo;
        this.yoshikiName = yoshikiName;
    }

    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    public RString getYoshikiName() {
        return yoshikiName;
    }

    public void setYoshikiNo(RString yoshikiNo) {
        this.setOriginalData("yoshikiNo", yoshikiNo);
        this.yoshikiNo = yoshikiNo;
    }

    public void setYoshikiName(RString yoshikiName) {
        this.setOriginalData("yoshikiName", yoshikiName);
        this.yoshikiName = yoshikiName;
    }

    // </editor-fold>
}
