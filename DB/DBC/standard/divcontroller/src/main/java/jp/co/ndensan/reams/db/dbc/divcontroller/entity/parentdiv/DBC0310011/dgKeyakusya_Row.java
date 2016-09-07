package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Aug 04 10:01:56 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgKeyakusya_Row のクラスファイル
 *
 * @reamsid_L DBC-2130-010 cuilin
 */
public class dgKeyakusya_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtKeiyakuNo;
    private RString txtServiceShurui;
    private RString txtHihoNo;
    private RString txtShimei;
    private TextBoxDate txtKeiyakuShenseibi;
    private TextBoxDate txtKeiyakuKeteibi;
    private RString txtKeiyakuJigyoshaNo;
    private RString txtKeiyakuJigyoshamei;
    private RString txtShikibetsuCode;

    public dgKeyakusya_Row() {
        super();
        this.txtKeiyakuNo = RString.EMPTY;
        this.txtServiceShurui = RString.EMPTY;
        this.txtHihoNo = RString.EMPTY;
        this.txtShimei = RString.EMPTY;
        this.txtKeiyakuShenseibi = new TextBoxDate();
        this.txtKeiyakuKeteibi = new TextBoxDate();
        this.txtKeiyakuJigyoshaNo = RString.EMPTY;
        this.txtKeiyakuJigyoshamei = RString.EMPTY;
        this.txtShikibetsuCode = RString.EMPTY;
        this.setOriginalData("txtKeiyakuNo", txtKeiyakuNo);
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtKeiyakuShenseibi", txtKeiyakuShenseibi);
        this.setOriginalData("txtKeiyakuKeteibi", txtKeiyakuKeteibi);
        this.setOriginalData("txtKeiyakuJigyoshaNo", txtKeiyakuJigyoshaNo);
        this.setOriginalData("txtKeiyakuJigyoshamei", txtKeiyakuJigyoshamei);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
    }

    public dgKeyakusya_Row(RString txtKeiyakuNo, RString txtServiceShurui, RString txtHihoNo, RString txtShimei, TextBoxDate txtKeiyakuShenseibi, TextBoxDate txtKeiyakuKeteibi, RString txtKeiyakuJigyoshaNo, RString txtKeiyakuJigyoshamei, RString txtShikibetsuCode) {
        super();
        this.setOriginalData("txtKeiyakuNo", txtKeiyakuNo);
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtKeiyakuShenseibi", txtKeiyakuShenseibi);
        this.setOriginalData("txtKeiyakuKeteibi", txtKeiyakuKeteibi);
        this.setOriginalData("txtKeiyakuJigyoshaNo", txtKeiyakuJigyoshaNo);
        this.setOriginalData("txtKeiyakuJigyoshamei", txtKeiyakuJigyoshamei);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.txtKeiyakuNo = txtKeiyakuNo;
        this.txtServiceShurui = txtServiceShurui;
        this.txtHihoNo = txtHihoNo;
        this.txtShimei = txtShimei;
        this.txtKeiyakuShenseibi = txtKeiyakuShenseibi;
        this.txtKeiyakuKeteibi = txtKeiyakuKeteibi;
        this.txtKeiyakuJigyoshaNo = txtKeiyakuJigyoshaNo;
        this.txtKeiyakuJigyoshamei = txtKeiyakuJigyoshamei;
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    public RString getTxtKeiyakuNo() {
        return txtKeiyakuNo;
    }

    public RString getTxtServiceShurui() {
        return txtServiceShurui;
    }

    public RString getTxtHihoNo() {
        return txtHihoNo;
    }

    public RString getTxtShimei() {
        return txtShimei;
    }

    public TextBoxDate getTxtKeiyakuShenseibi() {
        return txtKeiyakuShenseibi;
    }

    public TextBoxDate getTxtKeiyakuKeteibi() {
        return txtKeiyakuKeteibi;
    }

    public RString getTxtKeiyakuJigyoshaNo() {
        return txtKeiyakuJigyoshaNo;
    }

    public RString getTxtKeiyakuJigyoshamei() {
        return txtKeiyakuJigyoshamei;
    }

    public RString getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    public void setTxtKeiyakuNo(RString txtKeiyakuNo) {
        this.setOriginalData("txtKeiyakuNo", txtKeiyakuNo);
        this.txtKeiyakuNo = txtKeiyakuNo;
    }

    public void setTxtServiceShurui(RString txtServiceShurui) {
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.txtServiceShurui = txtServiceShurui;
    }

    public void setTxtHihoNo(RString txtHihoNo) {
        this.setOriginalData("txtHihoNo", txtHihoNo);
        this.txtHihoNo = txtHihoNo;
    }

    public void setTxtShimei(RString txtShimei) {
        this.setOriginalData("txtShimei", txtShimei);
        this.txtShimei = txtShimei;
    }

    public void setTxtKeiyakuShenseibi(TextBoxDate txtKeiyakuShenseibi) {
        this.setOriginalData("txtKeiyakuShenseibi", txtKeiyakuShenseibi);
        this.txtKeiyakuShenseibi = txtKeiyakuShenseibi;
    }

    public void setTxtKeiyakuKeteibi(TextBoxDate txtKeiyakuKeteibi) {
        this.setOriginalData("txtKeiyakuKeteibi", txtKeiyakuKeteibi);
        this.txtKeiyakuKeteibi = txtKeiyakuKeteibi;
    }

    public void setTxtKeiyakuJigyoshaNo(RString txtKeiyakuJigyoshaNo) {
        this.setOriginalData("txtKeiyakuJigyoshaNo", txtKeiyakuJigyoshaNo);
        this.txtKeiyakuJigyoshaNo = txtKeiyakuJigyoshaNo;
    }

    public void setTxtKeiyakuJigyoshamei(RString txtKeiyakuJigyoshamei) {
        this.setOriginalData("txtKeiyakuJigyoshamei", txtKeiyakuJigyoshamei);
        this.txtKeiyakuJigyoshamei = txtKeiyakuJigyoshamei;
    }

    public void setTxtShikibetsuCode(RString txtShikibetsuCode) {
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    // </editor-fold>
}
