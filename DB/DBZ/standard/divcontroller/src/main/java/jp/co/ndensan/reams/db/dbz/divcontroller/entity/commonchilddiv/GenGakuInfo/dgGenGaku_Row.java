package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.GenGakuInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Oct 21 17:43:29 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgGenGaku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgGenGaku_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">

    private TextBoxFlexibleDate txtChoteiNendo;
    private TextBoxNum txtChoteiGaku;
    private TextBoxNum txtShunyuGaku;
    private TextBoxNum txtJikoMinoGaku;

    public dgGenGaku_Row() {
        super();
        this.txtChoteiNendo = new TextBoxFlexibleDate();
        this.txtChoteiGaku = new TextBoxNum();
        this.txtShunyuGaku = new TextBoxNum();
        this.txtJikoMinoGaku = new TextBoxNum();
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.setOriginalData("txtChoteiGaku", txtChoteiGaku);
        this.setOriginalData("txtShunyuGaku", txtShunyuGaku);
        this.setOriginalData("txtJikoMinoGaku", txtJikoMinoGaku);
    }

    public dgGenGaku_Row(TextBoxFlexibleDate txtChoteiNendo, TextBoxNum txtChoteiGaku, TextBoxNum txtShunyuGaku, TextBoxNum txtJikoMinoGaku) {
        super();
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.setOriginalData("txtChoteiGaku", txtChoteiGaku);
        this.setOriginalData("txtShunyuGaku", txtShunyuGaku);
        this.setOriginalData("txtJikoMinoGaku", txtJikoMinoGaku);
        this.txtChoteiNendo = txtChoteiNendo;
        this.txtChoteiGaku = txtChoteiGaku;
        this.txtShunyuGaku = txtShunyuGaku;
        this.txtJikoMinoGaku = txtJikoMinoGaku;
    }

    public TextBoxFlexibleDate getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    public TextBoxNum getTxtChoteiGaku() {
        return txtChoteiGaku;
    }

    public TextBoxNum getTxtShunyuGaku() {
        return txtShunyuGaku;
    }

    public TextBoxNum getTxtJikoMinoGaku() {
        return txtJikoMinoGaku;
    }

    public void setTxtChoteiNendo(TextBoxFlexibleDate txtChoteiNendo) {
        this.setOriginalData("txtChoteiNendo", txtChoteiNendo);
        this.txtChoteiNendo = txtChoteiNendo;
    }

    public void setTxtChoteiGaku(TextBoxNum txtChoteiGaku) {
        this.setOriginalData("txtChoteiGaku", txtChoteiGaku);
        this.txtChoteiGaku = txtChoteiGaku;
    }

    public void setTxtShunyuGaku(TextBoxNum txtShunyuGaku) {
        this.setOriginalData("txtShunyuGaku", txtShunyuGaku);
        this.txtShunyuGaku = txtShunyuGaku;
    }

    public void setTxtJikoMinoGaku(TextBoxNum txtJikoMinoGaku) {
        this.setOriginalData("txtJikoMinoGaku", txtJikoMinoGaku);
        this.txtJikoMinoGaku = txtJikoMinoGaku;
    }

    // </editor-fold>
}
