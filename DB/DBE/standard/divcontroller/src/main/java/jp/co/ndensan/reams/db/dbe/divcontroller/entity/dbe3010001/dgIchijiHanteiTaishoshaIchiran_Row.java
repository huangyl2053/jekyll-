package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe3010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 30 17:27:58 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgIchijiHanteiTaishoshaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIchijiHanteiTaishoshaIchiran_Row extends DataRow {

    private RString hokensha;
    private RString hihokenNo;
    private RString hihokenshaName;
    private RString hihokenshaKana;
    private TextBoxFlexibleDate shinseibi;
    private RString shinseiKbnShin;
    private TextBoxFlexibleDate ichijiHanteiKanryobi;
    private TextBoxFlexibleDate ichijiHanteibi;
    private RString ichijiHanteiKekka;
    private RString keikokuCode;
    private TextBoxFlexibleDate chosaJissibi;
    private TextBoxFlexibleDate ikenshoJuryobi;
    private RString index;

    public dgIchijiHanteiTaishoshaIchiran_Row() {
        super();
        this.hokensha = RString.EMPTY;
        this.hihokenNo = RString.EMPTY;
        this.hihokenshaName = RString.EMPTY;
        this.hihokenshaKana = RString.EMPTY;
        this.shinseibi = new TextBoxFlexibleDate();
        this.shinseiKbnShin = RString.EMPTY;
        this.ichijiHanteiKanryobi = new TextBoxFlexibleDate();
        this.ichijiHanteibi = new TextBoxFlexibleDate();
        this.ichijiHanteiKekka = RString.EMPTY;
        this.keikokuCode = RString.EMPTY;
        this.chosaJissibi = new TextBoxFlexibleDate();
        this.ikenshoJuryobi = new TextBoxFlexibleDate();
        this.index = RString.EMPTY;
    }

    public dgIchijiHanteiTaishoshaIchiran_Row(RString hokensha, RString hihokenNo, RString hihokenshaName, RString hihokenshaKana, TextBoxFlexibleDate shinseibi, RString shinseiKbnShin, TextBoxFlexibleDate ichijiHanteiKanryobi, TextBoxFlexibleDate ichijiHanteibi, RString ichijiHanteiKekka, RString keikokuCode, TextBoxFlexibleDate chosaJissibi, TextBoxFlexibleDate ikenshoJuryobi, RString index) {
        super();
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenNo", hihokenNo);
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.setOriginalData("hihokenshaKana", hihokenshaKana);
        this.setOriginalData("shinseibi", shinseibi);
        this.setOriginalData("shinseiKbnShin", shinseiKbnShin);
        this.setOriginalData("ichijiHanteiKanryobi", ichijiHanteiKanryobi);
        this.setOriginalData("ichijiHanteibi", ichijiHanteibi);
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.setOriginalData("keikokuCode", keikokuCode);
        this.setOriginalData("chosaJissibi", chosaJissibi);
        this.setOriginalData("ikenshoJuryobi", ikenshoJuryobi);
        this.setOriginalData("index", index);
        this.hokensha = hokensha;
        this.hihokenNo = hihokenNo;
        this.hihokenshaName = hihokenshaName;
        this.hihokenshaKana = hihokenshaKana;
        this.shinseibi = shinseibi;
        this.shinseiKbnShin = shinseiKbnShin;
        this.ichijiHanteiKanryobi = ichijiHanteiKanryobi;
        this.ichijiHanteibi = ichijiHanteibi;
        this.ichijiHanteiKekka = ichijiHanteiKekka;
        this.keikokuCode = keikokuCode;
        this.chosaJissibi = chosaJissibi;
        this.ikenshoJuryobi = ikenshoJuryobi;
        this.index = index;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getHihokenNo() {
        return hihokenNo;
    }

    public RString getHihokenshaName() {
        return hihokenshaName;
    }

    public RString getHihokenshaKana() {
        return hihokenshaKana;
    }

    public TextBoxFlexibleDate getShinseibi() {
        return shinseibi;
    }

    public RString getShinseiKbnShin() {
        return shinseiKbnShin;
    }

    public TextBoxFlexibleDate getIchijiHanteiKanryobi() {
        return ichijiHanteiKanryobi;
    }

    public TextBoxFlexibleDate getIchijiHanteibi() {
        return ichijiHanteibi;
    }

    public RString getIchijiHanteiKekka() {
        return ichijiHanteiKekka;
    }

    public RString getKeikokuCode() {
        return keikokuCode;
    }

    public TextBoxFlexibleDate getChosaJissibi() {
        return chosaJissibi;
    }

    public TextBoxFlexibleDate getIkenshoJuryobi() {
        return ikenshoJuryobi;
    }

    public RString getIndex() {
        return index;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setHihokenNo(RString hihokenNo) {
        this.setOriginalData("hihokenNo", hihokenNo);
        this.hihokenNo = hihokenNo;
    }

    public void setHihokenshaName(RString hihokenshaName) {
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.hihokenshaName = hihokenshaName;
    }

    public void setHihokenshaKana(RString hihokenshaKana) {
        this.setOriginalData("hihokenshaKana", hihokenshaKana);
        this.hihokenshaKana = hihokenshaKana;
    }

    public void setShinseibi(TextBoxFlexibleDate shinseibi) {
        this.setOriginalData("shinseibi", shinseibi);
        this.shinseibi = shinseibi;
    }

    public void setShinseiKbnShin(RString shinseiKbnShin) {
        this.setOriginalData("shinseiKbnShin", shinseiKbnShin);
        this.shinseiKbnShin = shinseiKbnShin;
    }

    public void setIchijiHanteiKanryobi(TextBoxFlexibleDate ichijiHanteiKanryobi) {
        this.setOriginalData("ichijiHanteiKanryobi", ichijiHanteiKanryobi);
        this.ichijiHanteiKanryobi = ichijiHanteiKanryobi;
    }

    public void setIchijiHanteibi(TextBoxFlexibleDate ichijiHanteibi) {
        this.setOriginalData("ichijiHanteibi", ichijiHanteibi);
        this.ichijiHanteibi = ichijiHanteibi;
    }

    public void setIchijiHanteiKekka(RString ichijiHanteiKekka) {
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.ichijiHanteiKekka = ichijiHanteiKekka;
    }

    public void setKeikokuCode(RString keikokuCode) {
        this.setOriginalData("keikokuCode", keikokuCode);
        this.keikokuCode = keikokuCode;
    }

    public void setChosaJissibi(TextBoxFlexibleDate chosaJissibi) {
        this.setOriginalData("chosaJissibi", chosaJissibi);
        this.chosaJissibi = chosaJissibi;
    }

    public void setIkenshoJuryobi(TextBoxFlexibleDate ikenshoJuryobi) {
        this.setOriginalData("ikenshoJuryobi", ikenshoJuryobi);
        this.ikenshoJuryobi = ikenshoJuryobi;
    }

    public void setIndex(RString index) {
        this.setOriginalData("index", index);
        this.index = index;
    }

}