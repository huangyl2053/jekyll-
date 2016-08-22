package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Aug 17 09:09:43 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgHokenshaSofuList_Row のクラスファイル
 *
 * @reamsid_L DBC-3300-010 wangxingpeng
 */
public class dgHokenshaSofuList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtSofuJoho;
    private RString txtZenZengetsu;
    private RString txtZengetsu;
    private RString txtTogetsuJotai;
    private RString txtShoriNichiji;
    private RString saishoriFlag;
    private RString batchID;
    private TextBoxNum ichiranHyojijun;
    private TextBoxDate shoriYM;
    private RString kokanShikibetsuNo;

    public dgHokenshaSofuList_Row() {
        super();
        this.txtSofuJoho = RString.EMPTY;
        this.txtZenZengetsu = RString.EMPTY;
        this.txtZengetsu = RString.EMPTY;
        this.txtTogetsuJotai = RString.EMPTY;
        this.txtShoriNichiji = RString.EMPTY;
        this.saishoriFlag = RString.EMPTY;
        this.batchID = RString.EMPTY;
        this.ichiranHyojijun = new TextBoxNum();
        this.shoriYM = new TextBoxDate();
        this.kokanShikibetsuNo = RString.EMPTY;
        this.setOriginalData("txtSofuJoho", txtSofuJoho);
        this.setOriginalData("txtZenZengetsu", txtZenZengetsu);
        this.setOriginalData("txtZengetsu", txtZengetsu);
        this.setOriginalData("txtTogetsuJotai", txtTogetsuJotai);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.setOriginalData("saishoriFlag", saishoriFlag);
        this.setOriginalData("batchID", batchID);
        this.setOriginalData("ichiranHyojijun", ichiranHyojijun);
        this.setOriginalData("shoriYM", shoriYM);
        this.setOriginalData("kokanShikibetsuNo", kokanShikibetsuNo);
    }

    public dgHokenshaSofuList_Row(RString txtSofuJoho, RString txtZenZengetsu, RString txtZengetsu, RString txtTogetsuJotai, RString txtShoriNichiji, RString saishoriFlag, RString batchID, TextBoxNum ichiranHyojijun, TextBoxDate shoriYM, RString kokanShikibetsuNo) {
        super();
        this.setOriginalData("txtSofuJoho", txtSofuJoho);
        this.setOriginalData("txtZenZengetsu", txtZenZengetsu);
        this.setOriginalData("txtZengetsu", txtZengetsu);
        this.setOriginalData("txtTogetsuJotai", txtTogetsuJotai);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.setOriginalData("saishoriFlag", saishoriFlag);
        this.setOriginalData("batchID", batchID);
        this.setOriginalData("ichiranHyojijun", ichiranHyojijun);
        this.setOriginalData("shoriYM", shoriYM);
        this.setOriginalData("kokanShikibetsuNo", kokanShikibetsuNo);
        this.txtSofuJoho = txtSofuJoho;
        this.txtZenZengetsu = txtZenZengetsu;
        this.txtZengetsu = txtZengetsu;
        this.txtTogetsuJotai = txtTogetsuJotai;
        this.txtShoriNichiji = txtShoriNichiji;
        this.saishoriFlag = saishoriFlag;
        this.batchID = batchID;
        this.ichiranHyojijun = ichiranHyojijun;
        this.shoriYM = shoriYM;
        this.kokanShikibetsuNo = kokanShikibetsuNo;
    }

    public RString getTxtSofuJoho() {
        return txtSofuJoho;
    }

    public RString getTxtZenZengetsu() {
        return txtZenZengetsu;
    }

    public RString getTxtZengetsu() {
        return txtZengetsu;
    }

    public RString getTxtTogetsuJotai() {
        return txtTogetsuJotai;
    }

    public RString getTxtShoriNichiji() {
        return txtShoriNichiji;
    }

    public RString getSaishoriFlag() {
        return saishoriFlag;
    }

    public RString getBatchID() {
        return batchID;
    }

    public TextBoxNum getIchiranHyojijun() {
        return ichiranHyojijun;
    }

    public TextBoxDate getShoriYM() {
        return shoriYM;
    }

    public RString getKokanShikibetsuNo() {
        return kokanShikibetsuNo;
    }

    public void setTxtSofuJoho(RString txtSofuJoho) {
        this.setOriginalData("txtSofuJoho", txtSofuJoho);
        this.txtSofuJoho = txtSofuJoho;
    }

    public void setTxtZenZengetsu(RString txtZenZengetsu) {
        this.setOriginalData("txtZenZengetsu", txtZenZengetsu);
        this.txtZenZengetsu = txtZenZengetsu;
    }

    public void setTxtZengetsu(RString txtZengetsu) {
        this.setOriginalData("txtZengetsu", txtZengetsu);
        this.txtZengetsu = txtZengetsu;
    }

    public void setTxtTogetsuJotai(RString txtTogetsuJotai) {
        this.setOriginalData("txtTogetsuJotai", txtTogetsuJotai);
        this.txtTogetsuJotai = txtTogetsuJotai;
    }

    public void setTxtShoriNichiji(RString txtShoriNichiji) {
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.txtShoriNichiji = txtShoriNichiji;
    }

    public void setSaishoriFlag(RString saishoriFlag) {
        this.setOriginalData("saishoriFlag", saishoriFlag);
        this.saishoriFlag = saishoriFlag;
    }

    public void setBatchID(RString batchID) {
        this.setOriginalData("batchID", batchID);
        this.batchID = batchID;
    }

    public void setIchiranHyojijun(TextBoxNum ichiranHyojijun) {
        this.setOriginalData("ichiranHyojijun", ichiranHyojijun);
        this.ichiranHyojijun = ichiranHyojijun;
    }

    public void setShoriYM(TextBoxDate shoriYM) {
        this.setOriginalData("shoriYM", shoriYM);
        this.shoriYM = shoriYM;
    }

    public void setKokanShikibetsuNo(RString kokanShikibetsuNo) {
        this.setOriginalData("kokanShikibetsuNo", kokanShikibetsuNo);
        this.kokanShikibetsuNo = kokanShikibetsuNo;
    }

    // </editor-fold>
}
