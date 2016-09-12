package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1070011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Jul 02 14:15:35 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgTenshutsu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTenshutsu_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private DropDownList nextTask;
    private TextBoxCode shichosonCode;
    private TextBoxCode hihokenshaNo;
    private TextBoxCode shikibetsuCode;
    private RString shimei;
    private RString shimeiKana;
    private RString sex;
    private RString juminShubetsu;
    private TextBoxFlexibleDate birthYMD;
    private TextBoxFlexibleDate idoYMD;
    private RString idoJiyu;
    private RString tennyuTenshutsuYoteiJusho;
    private RString rirekiNo;
    private TextBoxFlexibleDate hihokenshaIdoYMD;
    private RString hihokenshaEdaNo;

    public dgTenshutsu_Row() {
        super();
        this.nextTask = new DropDownList();
        this.shichosonCode = new TextBoxCode();
        this.hihokenshaNo = new TextBoxCode();
        this.shikibetsuCode = new TextBoxCode();
        this.shimei = RString.EMPTY;
        this.shimeiKana = RString.EMPTY;
        this.sex = RString.EMPTY;
        this.juminShubetsu = RString.EMPTY;
        this.birthYMD = new TextBoxFlexibleDate();
        this.idoYMD = new TextBoxFlexibleDate();
        this.idoJiyu = RString.EMPTY;
        this.tennyuTenshutsuYoteiJusho = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.hihokenshaIdoYMD = new TextBoxFlexibleDate();
        this.hihokenshaEdaNo = RString.EMPTY;
        this.setOriginalData("nextTask", nextTask);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("shimeiKana", shimeiKana);
        this.setOriginalData("sex", sex);
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("idoJiyu", idoJiyu);
        this.setOriginalData("tennyuTenshutsuYoteiJusho", tennyuTenshutsuYoteiJusho);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("hihokenshaIdoYMD", hihokenshaIdoYMD);
        this.setOriginalData("hihokenshaEdaNo", hihokenshaEdaNo);
    }

    public dgTenshutsu_Row(DropDownList nextTask, TextBoxCode shichosonCode, TextBoxCode hihokenshaNo, TextBoxCode shikibetsuCode, RString shimei, RString shimeiKana, RString sex, RString juminShubetsu, TextBoxFlexibleDate birthYMD, TextBoxFlexibleDate idoYMD, RString idoJiyu, RString tennyuTenshutsuYoteiJusho, RString rirekiNo, TextBoxFlexibleDate hihokenshaIdoYMD, RString hihokenshaEdaNo) {
        super();
        this.setOriginalData("nextTask", nextTask);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("shimeiKana", shimeiKana);
        this.setOriginalData("sex", sex);
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("idoJiyu", idoJiyu);
        this.setOriginalData("tennyuTenshutsuYoteiJusho", tennyuTenshutsuYoteiJusho);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("hihokenshaIdoYMD", hihokenshaIdoYMD);
        this.setOriginalData("hihokenshaEdaNo", hihokenshaEdaNo);
        this.nextTask = nextTask;
        this.shichosonCode = shichosonCode;
        this.hihokenshaNo = hihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
        this.shimei = shimei;
        this.shimeiKana = shimeiKana;
        this.sex = sex;
        this.juminShubetsu = juminShubetsu;
        this.birthYMD = birthYMD;
        this.idoYMD = idoYMD;
        this.idoJiyu = idoJiyu;
        this.tennyuTenshutsuYoteiJusho = tennyuTenshutsuYoteiJusho;
        this.rirekiNo = rirekiNo;
        this.hihokenshaIdoYMD = hihokenshaIdoYMD;
        this.hihokenshaEdaNo = hihokenshaEdaNo;
    }

    public dgTenshutsu_Row(DataGridSetting gridSetting) {
        super();
        this.nextTask = DropDownList.createInstance(gridSetting.getColumn("nextTask").getCellDetails());
        this.shichosonCode = new TextBoxCode();
        this.hihokenshaNo = new TextBoxCode();
        this.shikibetsuCode = new TextBoxCode();
        this.shimei = RString.EMPTY;
        this.shimeiKana = RString.EMPTY;
        this.sex = RString.EMPTY;
        this.juminShubetsu = RString.EMPTY;
        this.birthYMD = new TextBoxFlexibleDate();
        this.idoYMD = new TextBoxFlexibleDate();
        this.idoJiyu = RString.EMPTY;
        this.tennyuTenshutsuYoteiJusho = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.hihokenshaIdoYMD = new TextBoxFlexibleDate();
        this.hihokenshaEdaNo = RString.EMPTY;
        this.setOriginalData("nextTask", nextTask);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("shimeiKana", shimeiKana);
        this.setOriginalData("sex", sex);
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("idoJiyu", idoJiyu);
        this.setOriginalData("tennyuTenshutsuYoteiJusho", tennyuTenshutsuYoteiJusho);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("hihokenshaIdoYMD", hihokenshaIdoYMD);
        this.setOriginalData("hihokenshaEdaNo", hihokenshaEdaNo);
    }

    public DropDownList getNextTask() {
        return nextTask;
    }

    public TextBoxCode getShichosonCode() {
        return shichosonCode;
    }

    public TextBoxCode getHihokenshaNo() {
        return hihokenshaNo;
    }

    public TextBoxCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getShimeiKana() {
        return shimeiKana;
    }

    public RString getSex() {
        return sex;
    }

    public RString getJuminShubetsu() {
        return juminShubetsu;
    }

    public TextBoxFlexibleDate getBirthYMD() {
        return birthYMD;
    }

    public TextBoxFlexibleDate getIdoYMD() {
        return idoYMD;
    }

    public RString getIdoJiyu() {
        return idoJiyu;
    }

    public RString getTennyuTenshutsuYoteiJusho() {
        return tennyuTenshutsuYoteiJusho;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public TextBoxFlexibleDate getHihokenshaIdoYMD() {
        return hihokenshaIdoYMD;
    }

    public RString getHihokenshaEdaNo() {
        return hihokenshaEdaNo;
    }

    public void setNextTask(DropDownList nextTask) {
        this.setOriginalData("nextTask", nextTask);
        this.nextTask = nextTask;
    }

    public void setShichosonCode(TextBoxCode shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    public void setHihokenshaNo(TextBoxCode hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShikibetsuCode(TextBoxCode shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setShimeiKana(RString shimeiKana) {
        this.setOriginalData("shimeiKana", shimeiKana);
        this.shimeiKana = shimeiKana;
    }

    public void setSex(RString sex) {
        this.setOriginalData("sex", sex);
        this.sex = sex;
    }

    public void setJuminShubetsu(RString juminShubetsu) {
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.juminShubetsu = juminShubetsu;
    }

    public void setBirthYMD(TextBoxFlexibleDate birthYMD) {
        this.setOriginalData("birthYMD", birthYMD);
        this.birthYMD = birthYMD;
    }

    public void setIdoYMD(TextBoxFlexibleDate idoYMD) {
        this.setOriginalData("idoYMD", idoYMD);
        this.idoYMD = idoYMD;
    }

    public void setIdoJiyu(RString idoJiyu) {
        this.setOriginalData("idoJiyu", idoJiyu);
        this.idoJiyu = idoJiyu;
    }

    public void setTennyuTenshutsuYoteiJusho(RString tennyuTenshutsuYoteiJusho) {
        this.setOriginalData("tennyuTenshutsuYoteiJusho", tennyuTenshutsuYoteiJusho);
        this.tennyuTenshutsuYoteiJusho = tennyuTenshutsuYoteiJusho;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setHihokenshaIdoYMD(TextBoxFlexibleDate hihokenshaIdoYMD) {
        this.setOriginalData("hihokenshaIdoYMD", hihokenshaIdoYMD);
        this.hihokenshaIdoYMD = hihokenshaIdoYMD;
    }

    public void setHihokenshaEdaNo(RString hihokenshaEdaNo) {
        this.setOriginalData("hihokenshaEdaNo", hihokenshaEdaNo);
        this.hihokenshaEdaNo = hihokenshaEdaNo;
    }

    // </editor-fold>
}
