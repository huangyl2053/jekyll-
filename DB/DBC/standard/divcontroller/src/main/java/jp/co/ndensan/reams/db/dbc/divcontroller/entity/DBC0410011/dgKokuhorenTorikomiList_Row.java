package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jan 28 13:41:56 JST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgKokuhorenTorikomiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKokuhorenTorikomiList_Row extends DataRow {

    private RString torikomiFlag;
    private RString txtTorikomiJoho;
    private RString txtZenZengetsu;
    private RString txtZengetsu;
    private RString txtTogetsuJotai;
    private RString txtShoriNichiji;
    private RString saishoriFlag;
    private RString batchID;
    private TextBoxNum ichiranHyojijun;
    private TextBoxDate shoriYM;
    private RString kokanShikibetsuNo;

    public dgKokuhorenTorikomiList_Row() {
        super();
        this.torikomiFlag = RString.EMPTY;
        this.txtTorikomiJoho = RString.EMPTY;
        this.txtZenZengetsu = RString.EMPTY;
        this.txtZengetsu = RString.EMPTY;
        this.txtTogetsuJotai = RString.EMPTY;
        this.txtShoriNichiji = RString.EMPTY;
        this.saishoriFlag = RString.EMPTY;
        this.batchID = RString.EMPTY;
        this.ichiranHyojijun = new TextBoxNum();
        this.shoriYM = new TextBoxDate();
        this.kokanShikibetsuNo = RString.EMPTY;
    }

    public dgKokuhorenTorikomiList_Row(RString torikomiFlag, RString txtTorikomiJoho, RString txtZenZengetsu, RString txtZengetsu, RString txtTogetsuJotai, RString txtShoriNichiji, RString saishoriFlag, RString batchID, TextBoxNum ichiranHyojijun, TextBoxDate shoriYM, RString kokanShikibetsuNo) {
        super();
        this.setOriginalData("torikomiFlag", torikomiFlag);
        this.setOriginalData("txtTorikomiJoho", txtTorikomiJoho);
        this.setOriginalData("txtZenZengetsu", txtZenZengetsu);
        this.setOriginalData("txtZengetsu", txtZengetsu);
        this.setOriginalData("txtTogetsuJotai", txtTogetsuJotai);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.setOriginalData("saishoriFlag", saishoriFlag);
        this.setOriginalData("batchID", batchID);
        this.setOriginalData("ichiranHyojijun", ichiranHyojijun);
        this.setOriginalData("shoriYM", shoriYM);
        this.setOriginalData("kokanShikibetsuNo", kokanShikibetsuNo);
        this.torikomiFlag = torikomiFlag;
        this.txtTorikomiJoho = txtTorikomiJoho;
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

    public RString getTorikomiFlag() {
        return torikomiFlag;
    }

    public RString getTxtTorikomiJoho() {
        return txtTorikomiJoho;
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

    public void setTorikomiFlag(RString torikomiFlag) {
        this.setOriginalData("torikomiFlag", torikomiFlag);
        this.torikomiFlag = torikomiFlag;
    }

    public void setTxtTorikomiJoho(RString txtTorikomiJoho) {
        this.setOriginalData("txtTorikomiJoho", txtTorikomiJoho);
        this.txtTorikomiJoho = txtTorikomiJoho;
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

}