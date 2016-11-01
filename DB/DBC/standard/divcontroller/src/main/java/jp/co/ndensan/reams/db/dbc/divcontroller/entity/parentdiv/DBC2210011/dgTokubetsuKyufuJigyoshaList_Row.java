package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Oct 22 17:51:42 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgTokubetsuKyufuJigyoshaList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTokubetsuKyufuJigyoshaList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">

    private RString txtIdoKubun;
    private TextBoxDate txtIdoYMD;
    private RString txtJigyoshaCode;
    private RString txtShinseishaShimei;
    private RString txtShinseishaJusho;
    private RString txtServiceName;

    public dgTokubetsuKyufuJigyoshaList_Row() {
        super();
        this.txtIdoKubun = RString.EMPTY;
        this.txtIdoYMD = new TextBoxDate();
        this.txtJigyoshaCode = RString.EMPTY;
        this.txtShinseishaShimei = RString.EMPTY;
        this.txtShinseishaJusho = RString.EMPTY;
        this.txtServiceName = RString.EMPTY;
        this.setOriginalData("txtIdoKubun", txtIdoKubun);
        this.setOriginalData("txtIdoYMD", txtIdoYMD);
        this.setOriginalData("txtJigyoshaCode", txtJigyoshaCode);
        this.setOriginalData("txtShinseishaShimei", txtShinseishaShimei);
        this.setOriginalData("txtShinseishaJusho", txtShinseishaJusho);
        this.setOriginalData("txtServiceName", txtServiceName);
    }

    public dgTokubetsuKyufuJigyoshaList_Row(RString txtIdoKubun, TextBoxDate txtIdoYMD, RString txtJigyoshaCode, RString txtShinseishaShimei, RString txtShinseishaJusho, RString txtServiceName) {
        super();
        this.setOriginalData("txtIdoKubun", txtIdoKubun);
        this.setOriginalData("txtIdoYMD", txtIdoYMD);
        this.setOriginalData("txtJigyoshaCode", txtJigyoshaCode);
        this.setOriginalData("txtShinseishaShimei", txtShinseishaShimei);
        this.setOriginalData("txtShinseishaJusho", txtShinseishaJusho);
        this.setOriginalData("txtServiceName", txtServiceName);
        this.txtIdoKubun = txtIdoKubun;
        this.txtIdoYMD = txtIdoYMD;
        this.txtJigyoshaCode = txtJigyoshaCode;
        this.txtShinseishaShimei = txtShinseishaShimei;
        this.txtShinseishaJusho = txtShinseishaJusho;
        this.txtServiceName = txtServiceName;
    }

    public RString getTxtIdoKubun() {
        return txtIdoKubun;
    }

    public TextBoxDate getTxtIdoYMD() {
        return txtIdoYMD;
    }

    public RString getTxtJigyoshaCode() {
        return txtJigyoshaCode;
    }

    public RString getTxtShinseishaShimei() {
        return txtShinseishaShimei;
    }

    public RString getTxtShinseishaJusho() {
        return txtShinseishaJusho;
    }

    public RString getTxtServiceName() {
        return txtServiceName;
    }

    public void setTxtIdoKubun(RString txtIdoKubun) {
        this.setOriginalData("txtIdoKubun", txtIdoKubun);
        this.txtIdoKubun = txtIdoKubun;
    }

    public void setTxtIdoYMD(TextBoxDate txtIdoYMD) {
        this.setOriginalData("txtIdoYMD", txtIdoYMD);
        this.txtIdoYMD = txtIdoYMD;
    }

    public void setTxtJigyoshaCode(RString txtJigyoshaCode) {
        this.setOriginalData("txtJigyoshaCode", txtJigyoshaCode);
        this.txtJigyoshaCode = txtJigyoshaCode;
    }

    public void setTxtShinseishaShimei(RString txtShinseishaShimei) {
        this.setOriginalData("txtShinseishaShimei", txtShinseishaShimei);
        this.txtShinseishaShimei = txtShinseishaShimei;
    }

    public void setTxtShinseishaJusho(RString txtShinseishaJusho) {
        this.setOriginalData("txtShinseishaJusho", txtShinseishaJusho);
        this.txtShinseishaJusho = txtShinseishaJusho;
    }

    public void setTxtServiceName(RString txtServiceName) {
        this.setOriginalData("txtServiceName", txtServiceName);
        this.txtServiceName = txtServiceName;
    }

    // </editor-fold>
}
