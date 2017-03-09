package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJikoInput.TokkiJikoInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Mar 08 20:33:17 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgTokkiJikoJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTokkiJikoJoho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_06-32-36">

    private RString beforeRowState;
    private RString dbTokkiJikoNo;
    private TextBox txtNinteiChosaItemNo;
    private TextBoxNum txtRemban;
    private TextBox txtNinteiChosaItemName;
    private TextBox txtTokkiJiko;

    public dgTokkiJikoJoho_Row() {
        super();
        this.beforeRowState = RString.EMPTY;
        this.dbTokkiJikoNo = RString.EMPTY;
        this.txtNinteiChosaItemNo = new TextBox();
        this.txtRemban = new TextBoxNum();
        this.txtNinteiChosaItemName = new TextBox();
        this.txtTokkiJiko = new TextBox();
        this.setOriginalData("beforeRowState", beforeRowState);
        this.setOriginalData("dbTokkiJikoNo", dbTokkiJikoNo);
        this.setOriginalData("txtNinteiChosaItemNo", txtNinteiChosaItemNo);
        this.setOriginalData("txtRemban", txtRemban);
        this.setOriginalData("txtNinteiChosaItemName", txtNinteiChosaItemName);
        this.setOriginalData("txtTokkiJiko", txtTokkiJiko);
    }

    public dgTokkiJikoJoho_Row(RString beforeRowState, RString dbTokkiJikoNo, TextBox txtNinteiChosaItemNo, TextBoxNum txtRemban, TextBox txtNinteiChosaItemName, TextBox txtTokkiJiko) {
        super();
        this.setOriginalData("beforeRowState", beforeRowState);
        this.setOriginalData("dbTokkiJikoNo", dbTokkiJikoNo);
        this.setOriginalData("txtNinteiChosaItemNo", txtNinteiChosaItemNo);
        this.setOriginalData("txtRemban", txtRemban);
        this.setOriginalData("txtNinteiChosaItemName", txtNinteiChosaItemName);
        this.setOriginalData("txtTokkiJiko", txtTokkiJiko);
        this.beforeRowState = beforeRowState;
        this.dbTokkiJikoNo = dbTokkiJikoNo;
        this.txtNinteiChosaItemNo = txtNinteiChosaItemNo;
        this.txtRemban = txtRemban;
        this.txtNinteiChosaItemName = txtNinteiChosaItemName;
        this.txtTokkiJiko = txtTokkiJiko;
    }

    public RString getBeforeRowState() {
        return beforeRowState;
    }

    public RString getDbTokkiJikoNo() {
        return dbTokkiJikoNo;
    }

    public TextBox getTxtNinteiChosaItemNo() {
        return txtNinteiChosaItemNo;
    }

    public TextBoxNum getTxtRemban() {
        return txtRemban;
    }

    public TextBox getTxtNinteiChosaItemName() {
        return txtNinteiChosaItemName;
    }

    public TextBox getTxtTokkiJiko() {
        return txtTokkiJiko;
    }

    public void setBeforeRowState(RString beforeRowState) {
        this.setOriginalData("beforeRowState", beforeRowState);
        this.beforeRowState = beforeRowState;
    }

    public void setDbTokkiJikoNo(RString dbTokkiJikoNo) {
        this.setOriginalData("dbTokkiJikoNo", dbTokkiJikoNo);
        this.dbTokkiJikoNo = dbTokkiJikoNo;
    }

    public void setTxtNinteiChosaItemNo(TextBox txtNinteiChosaItemNo) {
        this.setOriginalData("txtNinteiChosaItemNo", txtNinteiChosaItemNo);
        this.txtNinteiChosaItemNo = txtNinteiChosaItemNo;
    }

    public void setTxtRemban(TextBoxNum txtRemban) {
        this.setOriginalData("txtRemban", txtRemban);
        this.txtRemban = txtRemban;
    }

    public void setTxtNinteiChosaItemName(TextBox txtNinteiChosaItemName) {
        this.setOriginalData("txtNinteiChosaItemName", txtNinteiChosaItemName);
        this.txtNinteiChosaItemName = txtNinteiChosaItemName;
    }

    public void setTxtTokkiJiko(TextBox txtTokkiJiko) {
        this.setOriginalData("txtTokkiJiko", txtTokkiJiko);
        this.txtTokkiJiko = txtTokkiJiko;
    }

    // </editor-fold>
}
