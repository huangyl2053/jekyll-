package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 13:47:35 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSeikatsuhogoRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSeikatsuhogoRireki_Row extends DataRow {

    private Button btnModifyRow;
    private Button btnDeleteRow;
    private TextBoxCode txtJukyushaNo;
    private TextBoxDate txtKaishiYM;
    private TextBoxDate txtHaishiYM;
    private RString txtHokenryoDairiNofuKubun;
    private TextBoxDate txtHokenryoDairiNofuYM;
    private RString txtKyugoshisetsuNyutaishoKubun;
    private TextBoxDate txtKyugoshisetsuNyushoDate;
    private TextBoxDate txtKyugoshisetsuTaishoDate;
    private RString txtFujoShurui;

    public dgSeikatsuhogoRireki_Row() {
        super();
        this.btnModifyRow = new Button();
        this.btnDeleteRow = new Button();
        this.txtJukyushaNo = new TextBoxCode();
        this.txtKaishiYM = new TextBoxDate();
        this.txtHaishiYM = new TextBoxDate();
        this.txtHokenryoDairiNofuKubun = RString.EMPTY;
        this.txtHokenryoDairiNofuYM = new TextBoxDate();
        this.txtKyugoshisetsuNyutaishoKubun = RString.EMPTY;
        this.txtKyugoshisetsuNyushoDate = new TextBoxDate();
        this.txtKyugoshisetsuTaishoDate = new TextBoxDate();
        this.txtFujoShurui = RString.EMPTY;
    }

    public dgSeikatsuhogoRireki_Row(Button btnModifyRow, Button btnDeleteRow, TextBoxCode txtJukyushaNo, TextBoxDate txtKaishiYM, TextBoxDate txtHaishiYM, RString txtHokenryoDairiNofuKubun, TextBoxDate txtHokenryoDairiNofuYM, RString txtKyugoshisetsuNyutaishoKubun, TextBoxDate txtKyugoshisetsuNyushoDate, TextBoxDate txtKyugoshisetsuTaishoDate, RString txtFujoShurui) {
        super();
        this.setOriginalData("btnModifyRow", btnModifyRow);
        this.setOriginalData("btnDeleteRow", btnDeleteRow);
        this.setOriginalData("txtJukyushaNo", txtJukyushaNo);
        this.setOriginalData("txtKaishiYM", txtKaishiYM);
        this.setOriginalData("txtHaishiYM", txtHaishiYM);
        this.setOriginalData("txtHokenryoDairiNofuKubun", txtHokenryoDairiNofuKubun);
        this.setOriginalData("txtHokenryoDairiNofuYM", txtHokenryoDairiNofuYM);
        this.setOriginalData("txtKyugoshisetsuNyutaishoKubun", txtKyugoshisetsuNyutaishoKubun);
        this.setOriginalData("txtKyugoshisetsuNyushoDate", txtKyugoshisetsuNyushoDate);
        this.setOriginalData("txtKyugoshisetsuTaishoDate", txtKyugoshisetsuTaishoDate);
        this.setOriginalData("txtFujoShurui", txtFujoShurui);
        this.btnModifyRow = btnModifyRow;
        this.btnDeleteRow = btnDeleteRow;
        this.txtJukyushaNo = txtJukyushaNo;
        this.txtKaishiYM = txtKaishiYM;
        this.txtHaishiYM = txtHaishiYM;
        this.txtHokenryoDairiNofuKubun = txtHokenryoDairiNofuKubun;
        this.txtHokenryoDairiNofuYM = txtHokenryoDairiNofuYM;
        this.txtKyugoshisetsuNyutaishoKubun = txtKyugoshisetsuNyutaishoKubun;
        this.txtKyugoshisetsuNyushoDate = txtKyugoshisetsuNyushoDate;
        this.txtKyugoshisetsuTaishoDate = txtKyugoshisetsuTaishoDate;
        this.txtFujoShurui = txtFujoShurui;
    }

    public Button getBtnModifyRow() {
        return btnModifyRow;
    }

    public Button getBtnDeleteRow() {
        return btnDeleteRow;
    }

    public TextBoxCode getTxtJukyushaNo() {
        return txtJukyushaNo;
    }

    public TextBoxDate getTxtKaishiYM() {
        return txtKaishiYM;
    }

    public TextBoxDate getTxtHaishiYM() {
        return txtHaishiYM;
    }

    public RString getTxtHokenryoDairiNofuKubun() {
        return txtHokenryoDairiNofuKubun;
    }

    public TextBoxDate getTxtHokenryoDairiNofuYM() {
        return txtHokenryoDairiNofuYM;
    }

    public RString getTxtKyugoshisetsuNyutaishoKubun() {
        return txtKyugoshisetsuNyutaishoKubun;
    }

    public TextBoxDate getTxtKyugoshisetsuNyushoDate() {
        return txtKyugoshisetsuNyushoDate;
    }

    public TextBoxDate getTxtKyugoshisetsuTaishoDate() {
        return txtKyugoshisetsuTaishoDate;
    }

    public RString getTxtFujoShurui() {
        return txtFujoShurui;
    }

    public void setBtnModifyRow(Button btnModifyRow) {
        this.setOriginalData("btnModifyRow", btnModifyRow);
        this.btnModifyRow = btnModifyRow;
    }

    public void setBtnDeleteRow(Button btnDeleteRow) {
        this.setOriginalData("btnDeleteRow", btnDeleteRow);
        this.btnDeleteRow = btnDeleteRow;
    }

    public void setTxtJukyushaNo(TextBoxCode txtJukyushaNo) {
        this.setOriginalData("txtJukyushaNo", txtJukyushaNo);
        this.txtJukyushaNo = txtJukyushaNo;
    }

    public void setTxtKaishiYM(TextBoxDate txtKaishiYM) {
        this.setOriginalData("txtKaishiYM", txtKaishiYM);
        this.txtKaishiYM = txtKaishiYM;
    }

    public void setTxtHaishiYM(TextBoxDate txtHaishiYM) {
        this.setOriginalData("txtHaishiYM", txtHaishiYM);
        this.txtHaishiYM = txtHaishiYM;
    }

    public void setTxtHokenryoDairiNofuKubun(RString txtHokenryoDairiNofuKubun) {
        this.setOriginalData("txtHokenryoDairiNofuKubun", txtHokenryoDairiNofuKubun);
        this.txtHokenryoDairiNofuKubun = txtHokenryoDairiNofuKubun;
    }

    public void setTxtHokenryoDairiNofuYM(TextBoxDate txtHokenryoDairiNofuYM) {
        this.setOriginalData("txtHokenryoDairiNofuYM", txtHokenryoDairiNofuYM);
        this.txtHokenryoDairiNofuYM = txtHokenryoDairiNofuYM;
    }

    public void setTxtKyugoshisetsuNyutaishoKubun(RString txtKyugoshisetsuNyutaishoKubun) {
        this.setOriginalData("txtKyugoshisetsuNyutaishoKubun", txtKyugoshisetsuNyutaishoKubun);
        this.txtKyugoshisetsuNyutaishoKubun = txtKyugoshisetsuNyutaishoKubun;
    }

    public void setTxtKyugoshisetsuNyushoDate(TextBoxDate txtKyugoshisetsuNyushoDate) {
        this.setOriginalData("txtKyugoshisetsuNyushoDate", txtKyugoshisetsuNyushoDate);
        this.txtKyugoshisetsuNyushoDate = txtKyugoshisetsuNyushoDate;
    }

    public void setTxtKyugoshisetsuTaishoDate(TextBoxDate txtKyugoshisetsuTaishoDate) {
        this.setOriginalData("txtKyugoshisetsuTaishoDate", txtKyugoshisetsuTaishoDate);
        this.txtKyugoshisetsuTaishoDate = txtKyugoshisetsuTaishoDate;
    }

    public void setTxtFujoShurui(RString txtFujoShurui) {
        this.setOriginalData("txtFujoShurui", txtFujoShurui);
        this.txtFujoShurui = txtFujoShurui;
    }

}