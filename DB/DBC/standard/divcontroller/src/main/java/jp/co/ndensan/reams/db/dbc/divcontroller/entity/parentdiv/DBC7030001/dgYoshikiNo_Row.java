package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri May 13 09:32:45 CST 2016
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

    private RString yoshikiName;
    private RString yoshikiNo;
    private RString kyufuBunruiKubun;

    public dgYoshikiNo_Row() {
        super();
        this.yoshikiName = RString.EMPTY;
        this.yoshikiNo = RString.EMPTY;
        this.kyufuBunruiKubun = RString.EMPTY;
        this.setOriginalData("yoshikiName", yoshikiName);
        this.setOriginalData("yoshikiNo", yoshikiNo);
        this.setOriginalData("kyufuBunruiKubun", kyufuBunruiKubun);
    }

    public dgYoshikiNo_Row(RString yoshikiName, RString yoshikiNo, RString kyufuBunruiKubun) {
        super();
        this.setOriginalData("yoshikiName", yoshikiName);
        this.setOriginalData("yoshikiNo", yoshikiNo);
        this.setOriginalData("kyufuBunruiKubun", kyufuBunruiKubun);
        this.yoshikiName = yoshikiName;
        this.yoshikiNo = yoshikiNo;
        this.kyufuBunruiKubun = kyufuBunruiKubun;
    }

    public RString getYoshikiName() {
        return yoshikiName;
    }

    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    public RString getKyufuBunruiKubun() {
        return kyufuBunruiKubun;
    }

    public void setYoshikiName(RString yoshikiName) {
        this.setOriginalData("yoshikiName", yoshikiName);
        this.yoshikiName = yoshikiName;
    }

    public void setYoshikiNo(RString yoshikiNo) {
        this.setOriginalData("yoshikiNo", yoshikiNo);
        this.yoshikiNo = yoshikiNo;
    }

    public void setKyufuBunruiKubun(RString kyufuBunruiKubun) {
        this.setOriginalData("kyufuBunruiKubun", kyufuBunruiKubun);
        this.kyufuBunruiKubun = kyufuBunruiKubun;
    }

    // </editor-fold>
}
