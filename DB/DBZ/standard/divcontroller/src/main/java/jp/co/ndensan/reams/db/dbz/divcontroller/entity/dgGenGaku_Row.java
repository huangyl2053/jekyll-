package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Dec 05 18:20:01 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgGenGaku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgGenGaku_Row extends DataRow {

    private TextBoxDate txtChoteiNendo;
    private TextBoxNum txtChoteiGaku;
    private TextBoxNum txtShunyuGaku;
    private TextBoxNum txtJikoMinoGaku;

    public dgGenGaku_Row() {
        super();
        this.txtChoteiNendo = new TextBoxDate();
        this.txtChoteiGaku = new TextBoxNum();
        this.txtShunyuGaku = new TextBoxNum();
        this.txtJikoMinoGaku = new TextBoxNum();
    }

    public dgGenGaku_Row(TextBoxDate txtChoteiNendo, TextBoxNum txtChoteiGaku, TextBoxNum txtShunyuGaku, TextBoxNum txtJikoMinoGaku) {
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

    public TextBoxDate getTxtChoteiNendo() {
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

    public void setTxtChoteiNendo(TextBoxDate txtChoteiNendo) {
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

}