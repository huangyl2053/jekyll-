package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA1070011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 19:09:45 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgTenshutsu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTenshutsu_Row extends DataRow {

    private DropDownList nextWork;
    private Button btnNext;
    private RString shichosonCode;
    private RString shichosonCodeAndshichosonMei;
    private RString hihokenshaNo;
    private RString shikibetsuCode;
    private RString hihokenshaNoAndShikibetsuCode;
    private RString shimei;
    private RString kanaShimei;
    private RString shimeiAndKanaShimei;
    private RString gender;
    private RString juminShubetsu;
    private TextBoxFlexibleDate dateOfBirth;
    private RString juminShubetsuAndDateOfBirth;
    private TextBoxFlexibleDate idoDate;
    private RString idoJiyu;
    private RString idoDateAndIdoJiyu;
    private RString tennyuTenshutsuYoteiJusho;
    private RString tennyuTenshutsuZenkokuJushoCode;

    public dgTenshutsu_Row() {
        super();
        this.nextWork = new DropDownList();
        this.btnNext = new Button();
        this.shichosonCode = RString.EMPTY;
        this.shichosonCodeAndshichosonMei = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
        this.hihokenshaNoAndShikibetsuCode = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.kanaShimei = RString.EMPTY;
        this.shimeiAndKanaShimei = RString.EMPTY;
        this.gender = RString.EMPTY;
        this.juminShubetsu = RString.EMPTY;
        this.dateOfBirth = new TextBoxFlexibleDate();
        this.juminShubetsuAndDateOfBirth = RString.EMPTY;
        this.idoDate = new TextBoxFlexibleDate();
        this.idoJiyu = RString.EMPTY;
        this.idoDateAndIdoJiyu = RString.EMPTY;
        this.tennyuTenshutsuYoteiJusho = RString.EMPTY;
        this.tennyuTenshutsuZenkokuJushoCode = RString.EMPTY;
    }

    public dgTenshutsu_Row(DropDownList nextWork, Button btnNext, RString shichosonCode, RString shichosonCodeAndshichosonMei, RString hihokenshaNo, RString shikibetsuCode, RString hihokenshaNoAndShikibetsuCode, RString shimei, RString kanaShimei, RString shimeiAndKanaShimei, RString gender, RString juminShubetsu, TextBoxFlexibleDate dateOfBirth, RString juminShubetsuAndDateOfBirth, TextBoxFlexibleDate idoDate, RString idoJiyu, RString idoDateAndIdoJiyu, RString tennyuTenshutsuYoteiJusho, RString tennyuTenshutsuZenkokuJushoCode) {
        super();
        this.setOriginalData("nextWork", nextWork);
        this.setOriginalData("btnNext", btnNext);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("shichosonCodeAndshichosonMei", shichosonCodeAndshichosonMei);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("hihokenshaNoAndShikibetsuCode", hihokenshaNoAndShikibetsuCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("shimeiAndKanaShimei", shimeiAndKanaShimei);
        this.setOriginalData("gender", gender);
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.setOriginalData("juminShubetsuAndDateOfBirth", juminShubetsuAndDateOfBirth);
        this.setOriginalData("idoDate", idoDate);
        this.setOriginalData("idoJiyu", idoJiyu);
        this.setOriginalData("idoDateAndIdoJiyu", idoDateAndIdoJiyu);
        this.setOriginalData("tennyuTenshutsuYoteiJusho", tennyuTenshutsuYoteiJusho);
        this.setOriginalData("tennyuTenshutsuZenkokuJushoCode", tennyuTenshutsuZenkokuJushoCode);
        this.nextWork = nextWork;
        this.btnNext = btnNext;
        this.shichosonCode = shichosonCode;
        this.shichosonCodeAndshichosonMei = shichosonCodeAndshichosonMei;
        this.hihokenshaNo = hihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
        this.hihokenshaNoAndShikibetsuCode = hihokenshaNoAndShikibetsuCode;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
        this.shimeiAndKanaShimei = shimeiAndKanaShimei;
        this.gender = gender;
        this.juminShubetsu = juminShubetsu;
        this.dateOfBirth = dateOfBirth;
        this.juminShubetsuAndDateOfBirth = juminShubetsuAndDateOfBirth;
        this.idoDate = idoDate;
        this.idoJiyu = idoJiyu;
        this.idoDateAndIdoJiyu = idoDateAndIdoJiyu;
        this.tennyuTenshutsuYoteiJusho = tennyuTenshutsuYoteiJusho;
        this.tennyuTenshutsuZenkokuJushoCode = tennyuTenshutsuZenkokuJushoCode;
    }

    public dgTenshutsu_Row(DataGridSetting gridSetting) {
        super();
        this.nextWork = DropDownList.createInstance(gridSetting.getColumn("nextWork").getCellDetails());
        this.setOriginalData("nextWork", nextWork);
        this.btnNext = new Button();
        this.shichosonCode = RString.EMPTY;
        this.shichosonCodeAndshichosonMei = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
        this.hihokenshaNoAndShikibetsuCode = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.kanaShimei = RString.EMPTY;
        this.shimeiAndKanaShimei = RString.EMPTY;
        this.gender = RString.EMPTY;
        this.juminShubetsu = RString.EMPTY;
        this.dateOfBirth = new TextBoxFlexibleDate();
        this.juminShubetsuAndDateOfBirth = RString.EMPTY;
        this.idoDate = new TextBoxFlexibleDate();
        this.idoJiyu = RString.EMPTY;
        this.idoDateAndIdoJiyu = RString.EMPTY;
        this.tennyuTenshutsuYoteiJusho = RString.EMPTY;
        this.tennyuTenshutsuZenkokuJushoCode = RString.EMPTY;
    }

    public DropDownList getNextWork() {
        return nextWork;
    }

    public Button getBtnNext() {
        return btnNext;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public RString getShichosonCodeAndshichosonMei() {
        return shichosonCodeAndshichosonMei;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getHihokenshaNoAndShikibetsuCode() {
        return hihokenshaNoAndShikibetsuCode;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getKanaShimei() {
        return kanaShimei;
    }

    public RString getShimeiAndKanaShimei() {
        return shimeiAndKanaShimei;
    }

    public RString getGender() {
        return gender;
    }

    public RString getJuminShubetsu() {
        return juminShubetsu;
    }

    public TextBoxFlexibleDate getDateOfBirth() {
        return dateOfBirth;
    }

    public RString getJuminShubetsuAndDateOfBirth() {
        return juminShubetsuAndDateOfBirth;
    }

    public TextBoxFlexibleDate getIdoDate() {
        return idoDate;
    }

    public RString getIdoJiyu() {
        return idoJiyu;
    }

    public RString getIdoDateAndIdoJiyu() {
        return idoDateAndIdoJiyu;
    }

    public RString getTennyuTenshutsuYoteiJusho() {
        return tennyuTenshutsuYoteiJusho;
    }

    public RString getTennyuTenshutsuZenkokuJushoCode() {
        return tennyuTenshutsuZenkokuJushoCode;
    }

    public void setNextWork(DropDownList nextWork) {
        this.setOriginalData("nextWork", nextWork);
        this.nextWork = nextWork;
    }

    public void setBtnNext(Button btnNext) {
        this.setOriginalData("btnNext", btnNext);
        this.btnNext = btnNext;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    public void setShichosonCodeAndshichosonMei(RString shichosonCodeAndshichosonMei) {
        this.setOriginalData("shichosonCodeAndshichosonMei", shichosonCodeAndshichosonMei);
        this.shichosonCodeAndshichosonMei = shichosonCodeAndshichosonMei;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setHihokenshaNoAndShikibetsuCode(RString hihokenshaNoAndShikibetsuCode) {
        this.setOriginalData("hihokenshaNoAndShikibetsuCode", hihokenshaNoAndShikibetsuCode);
        this.hihokenshaNoAndShikibetsuCode = hihokenshaNoAndShikibetsuCode;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setKanaShimei(RString kanaShimei) {
        this.setOriginalData("kanaShimei", kanaShimei);
        this.kanaShimei = kanaShimei;
    }

    public void setShimeiAndKanaShimei(RString shimeiAndKanaShimei) {
        this.setOriginalData("shimeiAndKanaShimei", shimeiAndKanaShimei);
        this.shimeiAndKanaShimei = shimeiAndKanaShimei;
    }

    public void setGender(RString gender) {
        this.setOriginalData("gender", gender);
        this.gender = gender;
    }

    public void setJuminShubetsu(RString juminShubetsu) {
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.juminShubetsu = juminShubetsu;
    }

    public void setDateOfBirth(TextBoxFlexibleDate dateOfBirth) {
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    public void setJuminShubetsuAndDateOfBirth(RString juminShubetsuAndDateOfBirth) {
        this.setOriginalData("juminShubetsuAndDateOfBirth", juminShubetsuAndDateOfBirth);
        this.juminShubetsuAndDateOfBirth = juminShubetsuAndDateOfBirth;
    }

    public void setIdoDate(TextBoxFlexibleDate idoDate) {
        this.setOriginalData("idoDate", idoDate);
        this.idoDate = idoDate;
    }

    public void setIdoJiyu(RString idoJiyu) {
        this.setOriginalData("idoJiyu", idoJiyu);
        this.idoJiyu = idoJiyu;
    }

    public void setIdoDateAndIdoJiyu(RString idoDateAndIdoJiyu) {
        this.setOriginalData("idoDateAndIdoJiyu", idoDateAndIdoJiyu);
        this.idoDateAndIdoJiyu = idoDateAndIdoJiyu;
    }

    public void setTennyuTenshutsuYoteiJusho(RString tennyuTenshutsuYoteiJusho) {
        this.setOriginalData("tennyuTenshutsuYoteiJusho", tennyuTenshutsuYoteiJusho);
        this.tennyuTenshutsuYoteiJusho = tennyuTenshutsuYoteiJusho;
    }

    public void setTennyuTenshutsuZenkokuJushoCode(RString tennyuTenshutsuZenkokuJushoCode) {
        this.setOriginalData("tennyuTenshutsuZenkokuJushoCode", tennyuTenshutsuZenkokuJushoCode);
        this.tennyuTenshutsuZenkokuJushoCode = tennyuTenshutsuZenkokuJushoCode;
    }

}