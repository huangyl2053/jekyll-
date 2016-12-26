package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Dec 26 16:57:39 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;


/**
 * dgShozokuKikanIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShozokuKikanIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">

    private Button deleteButton;
    private RString shokisaiHokenshaNo;
    private RString hokenshaName;
    private TextBoxCode ninteiItakusakiCode;
    private ButtonDialog ninteiChosaItakusakiGuide;
    private RString ninteiChosainCode;
    private TextBox ninteiChosaItakusakiName;
    private TextBoxCode shujiiIryoKikanCode;
    private ButtonDialog shujiiIryoKikanGuide;
    private RString shujiiCode;
    private TextBox shujiiIryoKikanName;
    private TextBoxCode sonotaKikanCode;
    private ButtonDialog sonotaKikanGuide;
    private TextBox sonotaKikanName;
    private RString shichosonCode;
    private RString hdnColumn;

    public dgShozokuKikanIchiran_Row() {
        super();
        this.deleteButton = new Button();
        this.shokisaiHokenshaNo = RString.EMPTY;
        this.hokenshaName = RString.EMPTY;
        this.ninteiItakusakiCode = new TextBoxCode();
        this.ninteiChosaItakusakiGuide = new ButtonDialog();
        this.ninteiChosainCode = RString.EMPTY;
        this.ninteiChosaItakusakiName = new TextBox();
        this.shujiiIryoKikanCode = new TextBoxCode();
        this.shujiiIryoKikanGuide = new ButtonDialog();
        this.shujiiCode = RString.EMPTY;
        this.shujiiIryoKikanName = new TextBox();
        this.sonotaKikanCode = new TextBoxCode();
        this.sonotaKikanGuide = new ButtonDialog();
        this.sonotaKikanName = new TextBox();
        this.shichosonCode = RString.EMPTY;
        this.hdnColumn = RString.EMPTY;
        this.setOriginalData("deleteButton", deleteButton);
        this.setOriginalData("shokisaiHokenshaNo", shokisaiHokenshaNo);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.setOriginalData("ninteiItakusakiCode", ninteiItakusakiCode);
        this.setOriginalData("ninteiChosaItakusakiGuide", ninteiChosaItakusakiGuide);
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.setOriginalData("ninteiChosaItakusakiName", ninteiChosaItakusakiName);
        this.setOriginalData("shujiiIryoKikanCode", shujiiIryoKikanCode);
        this.setOriginalData("shujiiIryoKikanGuide", shujiiIryoKikanGuide);
        this.setOriginalData("shujiiCode", shujiiCode);
        this.setOriginalData("shujiiIryoKikanName", shujiiIryoKikanName);
        this.setOriginalData("sonotaKikanCode", sonotaKikanCode);
        this.setOriginalData("sonotaKikanGuide", sonotaKikanGuide);
        this.setOriginalData("sonotaKikanName", sonotaKikanName);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("hdnColumn", hdnColumn);
    }

    public dgShozokuKikanIchiran_Row(Button deleteButton, RString shokisaiHokenshaNo, RString hokenshaName, TextBoxCode ninteiItakusakiCode, ButtonDialog ninteiChosaItakusakiGuide, RString ninteiChosainCode, TextBox ninteiChosaItakusakiName, TextBoxCode shujiiIryoKikanCode, ButtonDialog shujiiIryoKikanGuide, RString shujiiCode, TextBox shujiiIryoKikanName, TextBoxCode sonotaKikanCode, ButtonDialog sonotaKikanGuide, TextBox sonotaKikanName, RString shichosonCode, RString hdnColumn) {
        super();
        this.setOriginalData("deleteButton", deleteButton);
        this.setOriginalData("shokisaiHokenshaNo", shokisaiHokenshaNo);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.setOriginalData("ninteiItakusakiCode", ninteiItakusakiCode);
        this.setOriginalData("ninteiChosaItakusakiGuide", ninteiChosaItakusakiGuide);
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.setOriginalData("ninteiChosaItakusakiName", ninteiChosaItakusakiName);
        this.setOriginalData("shujiiIryoKikanCode", shujiiIryoKikanCode);
        this.setOriginalData("shujiiIryoKikanGuide", shujiiIryoKikanGuide);
        this.setOriginalData("shujiiCode", shujiiCode);
        this.setOriginalData("shujiiIryoKikanName", shujiiIryoKikanName);
        this.setOriginalData("sonotaKikanCode", sonotaKikanCode);
        this.setOriginalData("sonotaKikanGuide", sonotaKikanGuide);
        this.setOriginalData("sonotaKikanName", sonotaKikanName);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("hdnColumn", hdnColumn);
        this.deleteButton = deleteButton;
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
        this.hokenshaName = hokenshaName;
        this.ninteiItakusakiCode = ninteiItakusakiCode;
        this.ninteiChosaItakusakiGuide = ninteiChosaItakusakiGuide;
        this.ninteiChosainCode = ninteiChosainCode;
        this.ninteiChosaItakusakiName = ninteiChosaItakusakiName;
        this.shujiiIryoKikanCode = shujiiIryoKikanCode;
        this.shujiiIryoKikanGuide = shujiiIryoKikanGuide;
        this.shujiiCode = shujiiCode;
        this.shujiiIryoKikanName = shujiiIryoKikanName;
        this.sonotaKikanCode = sonotaKikanCode;
        this.sonotaKikanGuide = sonotaKikanGuide;
        this.sonotaKikanName = sonotaKikanName;
        this.shichosonCode = shichosonCode;
        this.hdnColumn = hdnColumn;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public RString getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    public RString getHokenshaName() {
        return hokenshaName;
    }

    public TextBoxCode getNinteiItakusakiCode() {
        return ninteiItakusakiCode;
    }

    public ButtonDialog getNinteiChosaItakusakiGuide() {
        return ninteiChosaItakusakiGuide;
    }

    public RString getNinteiChosainCode() {
        return ninteiChosainCode;
    }

    public TextBox getNinteiChosaItakusakiName() {
        return ninteiChosaItakusakiName;
    }

    public TextBoxCode getShujiiIryoKikanCode() {
        return shujiiIryoKikanCode;
    }

    public ButtonDialog getShujiiIryoKikanGuide() {
        return shujiiIryoKikanGuide;
    }

    public RString getShujiiCode() {
        return shujiiCode;
    }

    public TextBox getShujiiIryoKikanName() {
        return shujiiIryoKikanName;
    }

    public TextBoxCode getSonotaKikanCode() {
        return sonotaKikanCode;
    }

    public ButtonDialog getSonotaKikanGuide() {
        return sonotaKikanGuide;
    }

    public TextBox getSonotaKikanName() {
        return sonotaKikanName;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public RString getHdnColumn() {
        return hdnColumn;
    }

    public void setDeleteButton(Button deleteButton) {
        this.setOriginalData("deleteButton", deleteButton);
        this.deleteButton = deleteButton;
    }

    public void setShokisaiHokenshaNo(RString shokisaiHokenshaNo) {
        this.setOriginalData("shokisaiHokenshaNo", shokisaiHokenshaNo);
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    public void setHokenshaName(RString hokenshaName) {
        this.setOriginalData("hokenshaName", hokenshaName);
        this.hokenshaName = hokenshaName;
    }

    public void setNinteiItakusakiCode(TextBoxCode ninteiItakusakiCode) {
        this.setOriginalData("ninteiItakusakiCode", ninteiItakusakiCode);
        this.ninteiItakusakiCode = ninteiItakusakiCode;
    }

    public void setNinteiChosaItakusakiGuide(ButtonDialog ninteiChosaItakusakiGuide) {
        this.setOriginalData("ninteiChosaItakusakiGuide", ninteiChosaItakusakiGuide);
        this.ninteiChosaItakusakiGuide = ninteiChosaItakusakiGuide;
    }

    public void setNinteiChosainCode(RString ninteiChosainCode) {
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.ninteiChosainCode = ninteiChosainCode;
    }

    public void setNinteiChosaItakusakiName(TextBox ninteiChosaItakusakiName) {
        this.setOriginalData("ninteiChosaItakusakiName", ninteiChosaItakusakiName);
        this.ninteiChosaItakusakiName = ninteiChosaItakusakiName;
    }

    public void setShujiiIryoKikanCode(TextBoxCode shujiiIryoKikanCode) {
        this.setOriginalData("shujiiIryoKikanCode", shujiiIryoKikanCode);
        this.shujiiIryoKikanCode = shujiiIryoKikanCode;
    }

    public void setShujiiIryoKikanGuide(ButtonDialog shujiiIryoKikanGuide) {
        this.setOriginalData("shujiiIryoKikanGuide", shujiiIryoKikanGuide);
        this.shujiiIryoKikanGuide = shujiiIryoKikanGuide;
    }

    public void setShujiiCode(RString shujiiCode) {
        this.setOriginalData("shujiiCode", shujiiCode);
        this.shujiiCode = shujiiCode;
    }

    public void setShujiiIryoKikanName(TextBox shujiiIryoKikanName) {
        this.setOriginalData("shujiiIryoKikanName", shujiiIryoKikanName);
        this.shujiiIryoKikanName = shujiiIryoKikanName;
    }

    public void setSonotaKikanCode(TextBoxCode sonotaKikanCode) {
        this.setOriginalData("sonotaKikanCode", sonotaKikanCode);
        this.sonotaKikanCode = sonotaKikanCode;
    }

    public void setSonotaKikanGuide(ButtonDialog sonotaKikanGuide) {
        this.setOriginalData("sonotaKikanGuide", sonotaKikanGuide);
        this.sonotaKikanGuide = sonotaKikanGuide;
    }

    public void setSonotaKikanName(TextBox sonotaKikanName) {
        this.setOriginalData("sonotaKikanName", sonotaKikanName);
        this.sonotaKikanName = sonotaKikanName;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    public void setHdnColumn(RString hdnColumn) {
        this.setOriginalData("hdnColumn", hdnColumn);
        this.hdnColumn = hdnColumn;
    }

    // </editor-fold>
}
