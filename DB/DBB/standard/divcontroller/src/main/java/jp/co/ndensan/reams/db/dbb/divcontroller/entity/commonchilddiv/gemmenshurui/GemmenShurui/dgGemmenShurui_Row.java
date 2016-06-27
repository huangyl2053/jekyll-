package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.gemmenshurui.GemmenShurui;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 07 20:48:24 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgGemmenShurui_Row のクラスファイル
 *
 * @reamsid_L DBB-1660-030 xupeng
 */
public class dgGemmenShurui_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtNaiyo;
    private RString txtHyojiMongon;
    private RString txtCode;

    public dgGemmenShurui_Row() {
        super();
        this.txtNaiyo = RString.EMPTY;
        this.txtHyojiMongon = RString.EMPTY;
        this.txtCode = RString.EMPTY;
        this.setOriginalData("txtNaiyo", txtNaiyo);
        this.setOriginalData("txtHyojiMongon", txtHyojiMongon);
        this.setOriginalData("txtCode", txtCode);
    }

    public dgGemmenShurui_Row(RString txtNaiyo, RString txtHyojiMongon, RString txtCode) {
        super();
        this.setOriginalData("txtNaiyo", txtNaiyo);
        this.setOriginalData("txtHyojiMongon", txtHyojiMongon);
        this.setOriginalData("txtCode", txtCode);
        this.txtNaiyo = txtNaiyo;
        this.txtHyojiMongon = txtHyojiMongon;
        this.txtCode = txtCode;
    }

    public RString getTxtNaiyo() {
        return txtNaiyo;
    }

    public RString getTxtHyojiMongon() {
        return txtHyojiMongon;
    }

    public RString getTxtCode() {
        return txtCode;
    }

    public void setTxtNaiyo(RString txtNaiyo) {
        this.setOriginalData("txtNaiyo", txtNaiyo);
        this.txtNaiyo = txtNaiyo;
    }

    public void setTxtHyojiMongon(RString txtHyojiMongon) {
        this.setOriginalData("txtHyojiMongon", txtHyojiMongon);
        this.txtHyojiMongon = txtHyojiMongon;
    }

    public void setTxtCode(RString txtCode) {
        this.setOriginalData("txtCode", txtCode);
        this.txtCode = txtCode;
    }

    // </editor-fold>
}
