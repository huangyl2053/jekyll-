package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jun 25 14:10:19 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgChosahyoTorikomiKekka_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosahyoTorikomiKekka_Row extends DataRow {

    private Button btnSelect;
    private RString no;
    private RString okOrNg;
    private RString hokensha;
    private RString hihokenshaNo;
    private TextBoxFlexibleDate txtShinseiDate;
    private RString shinseiKubun;
    private TextBoxFlexibleDate chosaJisshiDate;
    private TextBoxFlexibleDate chosahyoJuryoDate;

    public dgChosahyoTorikomiKekka_Row() {
        super();
        this.btnSelect = new Button();
        this.no = RString.EMPTY;
        this.okOrNg = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.txtShinseiDate = new TextBoxFlexibleDate();
        this.shinseiKubun = RString.EMPTY;
        this.chosaJisshiDate = new TextBoxFlexibleDate();
        this.chosahyoJuryoDate = new TextBoxFlexibleDate();
    }

    public dgChosahyoTorikomiKekka_Row(Button btnSelect, RString no, RString okOrNg, RString hokensha, RString hihokenshaNo, TextBoxFlexibleDate txtShinseiDate, RString shinseiKubun, TextBoxFlexibleDate chosaJisshiDate, TextBoxFlexibleDate chosahyoJuryoDate) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("no", no);
        this.setOriginalData("okOrNg", okOrNg);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("txtShinseiDate", txtShinseiDate);
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.setOriginalData("chosaJisshiDate", chosaJisshiDate);
        this.setOriginalData("chosahyoJuryoDate", chosahyoJuryoDate);
        this.btnSelect = btnSelect;
        this.no = no;
        this.okOrNg = okOrNg;
        this.hokensha = hokensha;
        this.hihokenshaNo = hihokenshaNo;
        this.txtShinseiDate = txtShinseiDate;
        this.shinseiKubun = shinseiKubun;
        this.chosaJisshiDate = chosaJisshiDate;
        this.chosahyoJuryoDate = chosahyoJuryoDate;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public RString getNo() {
        return no;
    }

    public RString getOkOrNg() {
        return okOrNg;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    public RString getShinseiKubun() {
        return shinseiKubun;
    }

    public TextBoxFlexibleDate getChosaJisshiDate() {
        return chosaJisshiDate;
    }

    public TextBoxFlexibleDate getChosahyoJuryoDate() {
        return chosahyoJuryoDate;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setNo(RString no) {
        this.setOriginalData("no", no);
        this.no = no;
    }

    public void setOkOrNg(RString okOrNg) {
        this.setOriginalData("okOrNg", okOrNg);
        this.okOrNg = okOrNg;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.setOriginalData("txtShinseiDate", txtShinseiDate);
        this.txtShinseiDate = txtShinseiDate;
    }

    public void setShinseiKubun(RString shinseiKubun) {
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.shinseiKubun = shinseiKubun;
    }

    public void setChosaJisshiDate(TextBoxFlexibleDate chosaJisshiDate) {
        this.setOriginalData("chosaJisshiDate", chosaJisshiDate);
        this.chosaJisshiDate = chosaJisshiDate;
    }

    public void setChosahyoJuryoDate(TextBoxFlexibleDate chosahyoJuryoDate) {
        this.setOriginalData("chosahyoJuryoDate", chosahyoJuryoDate);
        this.chosahyoJuryoDate = chosahyoJuryoDate;
    }

}