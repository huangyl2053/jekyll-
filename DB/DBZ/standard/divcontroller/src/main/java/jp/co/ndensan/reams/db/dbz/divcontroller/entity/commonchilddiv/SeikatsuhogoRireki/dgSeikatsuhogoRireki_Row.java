package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Aug 08 17:22:02 CST 2016 
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private ButtonDialog btnSelectRow;
    private ButtonDialog btnModifyRow;
    private ButtonDialog btnDeleteRow;
    private TextBoxCode txtJukyushaNo;
    private TextBoxDate txtKaishiYMD;
    private TextBoxDate txtHaishiYMD;
    private RString txtHokenryoDairiNofuKubun;
    private TextBoxDate txtHokenryoDairiNofuYM;
    private RString txtKyugoshisetsuNyutaishoKubun;
    private TextBoxDate txtKyugoshisetsuNyutaishoYMD;
    private RString txtJukyuTeishiKikan;
    private RString txtFujoShuruiCode;
    private RString txtFujoShurui;

    public dgSeikatsuhogoRireki_Row() {
        super();
        this.btnSelectRow = new ButtonDialog();
        this.btnModifyRow = new ButtonDialog();
        this.btnDeleteRow = new ButtonDialog();
        this.txtJukyushaNo = new TextBoxCode();
        this.txtKaishiYMD = new TextBoxDate();
        this.txtHaishiYMD = new TextBoxDate();
        this.txtHokenryoDairiNofuKubun = RString.EMPTY;
        this.txtHokenryoDairiNofuYM = new TextBoxDate();
        this.txtKyugoshisetsuNyutaishoKubun = RString.EMPTY;
        this.txtKyugoshisetsuNyutaishoYMD = new TextBoxDate();
        this.txtJukyuTeishiKikan = RString.EMPTY;
        this.txtFujoShuruiCode = RString.EMPTY;
        this.txtFujoShurui = RString.EMPTY;
        this.setOriginalData("btnSelectRow", btnSelectRow);
        this.setOriginalData("btnModifyRow", btnModifyRow);
        this.setOriginalData("btnDeleteRow", btnDeleteRow);
        this.setOriginalData("txtJukyushaNo", txtJukyushaNo);
        this.setOriginalData("txtKaishiYMD", txtKaishiYMD);
        this.setOriginalData("txtHaishiYMD", txtHaishiYMD);
        this.setOriginalData("txtHokenryoDairiNofuKubun", txtHokenryoDairiNofuKubun);
        this.setOriginalData("txtHokenryoDairiNofuYM", txtHokenryoDairiNofuYM);
        this.setOriginalData("txtKyugoshisetsuNyutaishoKubun", txtKyugoshisetsuNyutaishoKubun);
        this.setOriginalData("txtKyugoshisetsuNyutaishoYMD", txtKyugoshisetsuNyutaishoYMD);
        this.setOriginalData("txtJukyuTeishiKikan", txtJukyuTeishiKikan);
        this.setOriginalData("txtFujoShuruiCode", txtFujoShuruiCode);
        this.setOriginalData("txtFujoShurui", txtFujoShurui);
    }

    public dgSeikatsuhogoRireki_Row(ButtonDialog btnSelectRow, ButtonDialog btnModifyRow, ButtonDialog btnDeleteRow, TextBoxCode txtJukyushaNo, TextBoxDate txtKaishiYMD, TextBoxDate txtHaishiYMD, RString txtHokenryoDairiNofuKubun, TextBoxDate txtHokenryoDairiNofuYM, RString txtKyugoshisetsuNyutaishoKubun, TextBoxDate txtKyugoshisetsuNyutaishoYMD, RString txtJukyuTeishiKikan, RString txtFujoShuruiCode, RString txtFujoShurui) {
        super();
        this.setOriginalData("btnSelectRow", btnSelectRow);
        this.setOriginalData("btnModifyRow", btnModifyRow);
        this.setOriginalData("btnDeleteRow", btnDeleteRow);
        this.setOriginalData("txtJukyushaNo", txtJukyushaNo);
        this.setOriginalData("txtKaishiYMD", txtKaishiYMD);
        this.setOriginalData("txtHaishiYMD", txtHaishiYMD);
        this.setOriginalData("txtHokenryoDairiNofuKubun", txtHokenryoDairiNofuKubun);
        this.setOriginalData("txtHokenryoDairiNofuYM", txtHokenryoDairiNofuYM);
        this.setOriginalData("txtKyugoshisetsuNyutaishoKubun", txtKyugoshisetsuNyutaishoKubun);
        this.setOriginalData("txtKyugoshisetsuNyutaishoYMD", txtKyugoshisetsuNyutaishoYMD);
        this.setOriginalData("txtJukyuTeishiKikan", txtJukyuTeishiKikan);
        this.setOriginalData("txtFujoShuruiCode", txtFujoShuruiCode);
        this.setOriginalData("txtFujoShurui", txtFujoShurui);
        this.btnSelectRow = btnSelectRow;
        this.btnModifyRow = btnModifyRow;
        this.btnDeleteRow = btnDeleteRow;
        this.txtJukyushaNo = txtJukyushaNo;
        this.txtKaishiYMD = txtKaishiYMD;
        this.txtHaishiYMD = txtHaishiYMD;
        this.txtHokenryoDairiNofuKubun = txtHokenryoDairiNofuKubun;
        this.txtHokenryoDairiNofuYM = txtHokenryoDairiNofuYM;
        this.txtKyugoshisetsuNyutaishoKubun = txtKyugoshisetsuNyutaishoKubun;
        this.txtKyugoshisetsuNyutaishoYMD = txtKyugoshisetsuNyutaishoYMD;
        this.txtJukyuTeishiKikan = txtJukyuTeishiKikan;
        this.txtFujoShuruiCode = txtFujoShuruiCode;
        this.txtFujoShurui = txtFujoShurui;
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

    public TextBoxDate getTxtKaishiYMD() {
        return txtKaishiYMD;
    }

    public TextBoxDate getTxtHaishiYMD() {
        return txtHaishiYMD;
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

    public TextBoxDate getTxtKyugoshisetsuNyutaishoYMD() {
        return txtKyugoshisetsuNyutaishoYMD;
    }

    public RString getTxtJukyuTeishiKikan() {
        return txtJukyuTeishiKikan;
    }

    public RString getTxtFujoShuruiCode() {
        return txtFujoShuruiCode;
    }

    public RString getTxtFujoShurui() {
        return txtFujoShurui;
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

    public void setTxtKaishiYMD(TextBoxDate txtKaishiYMD) {
        this.setOriginalData("txtKaishiYMD", txtKaishiYMD);
        this.txtKaishiYMD = txtKaishiYMD;
    }

    public void setTxtHaishiYMD(TextBoxDate txtHaishiYMD) {
        this.setOriginalData("txtHaishiYMD", txtHaishiYMD);
        this.txtHaishiYMD = txtHaishiYMD;
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

    public void setTxtKyugoshisetsuNyutaishoYMD(TextBoxDate txtKyugoshisetsuNyutaishoYMD) {
        this.setOriginalData("txtKyugoshisetsuNyutaishoYMD", txtKyugoshisetsuNyutaishoYMD);
        this.txtKyugoshisetsuNyutaishoYMD = txtKyugoshisetsuNyutaishoYMD;
    }

    public void setTxtJukyuTeishiKikan(RString txtJukyuTeishiKikan) {
        this.setOriginalData("txtJukyuTeishiKikan", txtJukyuTeishiKikan);
        this.txtJukyuTeishiKikan = txtJukyuTeishiKikan;
    }

    public void setTxtFujoShuruiCode(RString txtFujoShuruiCode) {
        this.setOriginalData("txtFujoShuruiCode", txtFujoShuruiCode);
        this.txtFujoShuruiCode = txtFujoShuruiCode;
    }

    public void setTxtFujoShurui(RString txtFujoShurui) {
        this.setOriginalData("txtFujoShurui", txtFujoShurui);
        this.txtFujoShurui = txtFujoShurui;
    }

    // </editor-fold>
}
