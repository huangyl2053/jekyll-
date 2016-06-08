package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 24 10:41:41 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSeikatsuhogoRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSeikatsuhogoRireki_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private ButtonDialog btnSelectRow;
    private ButtonDialog btnModifyRow;
    private ButtonDialog btnDeleteRow;
    private TextBoxCode txtJukyushaNo;
    private TextBoxDate txtKaishiYM;
    private TextBoxDate txtHaishiYM;
    private RString txtHokenryoDairiNofuKubun;
    private TextBoxDate txtHokenryoDairiNofuYM;
    private RString txtKyugoshisetsuNyutaishoKubun;
    private TextBoxDate txtKyugoshisetsuNyushoDate;
    private TextBoxDate txtKyugoshisetsuTaishoDate;
    private RString txtFujoShurui;
    private RString txtFujoShuruiCode;
    private RString txtJukyuTeishi;

    public dgSeikatsuhogoRireki_Row() {
        super();
        this.btnSelectRow = new ButtonDialog();
        this.btnModifyRow = new ButtonDialog();
        this.btnDeleteRow = new ButtonDialog();
        this.txtJukyushaNo = new TextBoxCode();
        this.txtKaishiYM = new TextBoxDate();
        this.txtHaishiYM = new TextBoxDate();
        this.txtHokenryoDairiNofuKubun = RString.EMPTY;
        this.txtHokenryoDairiNofuYM = new TextBoxDate();
        this.txtKyugoshisetsuNyutaishoKubun = RString.EMPTY;
        this.txtKyugoshisetsuNyushoDate = new TextBoxDate();
        this.txtKyugoshisetsuTaishoDate = new TextBoxDate();
        this.txtFujoShurui = RString.EMPTY;
        this.txtFujoShuruiCode = RString.EMPTY;
        this.txtJukyuTeishi = RString.EMPTY;
        this.setOriginalData("btnSelectRow", btnSelectRow);
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
        this.setOriginalData("txtFujoShuruiCode", txtFujoShuruiCode);
        this.setOriginalData("txtJukyuTeishi", txtJukyuTeishi);
    }

    public dgSeikatsuhogoRireki_Row(ButtonDialog btnSelectRow, ButtonDialog btnModifyRow, ButtonDialog btnDeleteRow, TextBoxCode txtJukyushaNo, TextBoxDate txtKaishiYM, TextBoxDate txtHaishiYM, RString txtHokenryoDairiNofuKubun, TextBoxDate txtHokenryoDairiNofuYM, RString txtKyugoshisetsuNyutaishoKubun, TextBoxDate txtKyugoshisetsuNyushoDate, TextBoxDate txtKyugoshisetsuTaishoDate, RString txtFujoShurui, RString txtFujoShuruiCode, RString txtJukyuTeishi) {
        super();
        this.setOriginalData("btnSelectRow", btnSelectRow);
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
        this.setOriginalData("txtFujoShuruiCode", txtFujoShuruiCode);
        this.setOriginalData("txtJukyuTeishi", txtJukyuTeishi);
        this.btnSelectRow = btnSelectRow;
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
        this.txtFujoShuruiCode = txtFujoShuruiCode;
        this.txtJukyuTeishi = txtJukyuTeishi;
    }

    public ButtonDialog getBtnSelectRow() {
        return btnSelectRow;
    }

    public ButtonDialog getBtnModifyRow() {
        return btnModifyRow;
    }

    public ButtonDialog getBtnDeleteRow() {
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

    public RString getTxtFujoShuruiCode() {
        return txtFujoShuruiCode;
    }

    public RString getTxtJukyuTeishi() {
        return txtJukyuTeishi;
    }

    public void setBtnSelectRow(ButtonDialog btnSelectRow) {
        this.setOriginalData("btnSelectRow", btnSelectRow);
        this.btnSelectRow = btnSelectRow;
    }

    public void setBtnModifyRow(ButtonDialog btnModifyRow) {
        this.setOriginalData("btnModifyRow", btnModifyRow);
        this.btnModifyRow = btnModifyRow;
    }

    public void setBtnDeleteRow(ButtonDialog btnDeleteRow) {
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

    public void setTxtFujoShuruiCode(RString txtFujoShuruiCode) {
        this.setOriginalData("txtFujoShuruiCode", txtFujoShuruiCode);
        this.txtFujoShuruiCode = txtFujoShuruiCode;
    }

    public void setTxtJukyuTeishi(RString txtJukyuTeishi) {
        this.setOriginalData("txtJukyuTeishi", txtJukyuTeishi);
        this.txtJukyuTeishi = txtJukyuTeishi;
    }

    // </editor-fold>
}
