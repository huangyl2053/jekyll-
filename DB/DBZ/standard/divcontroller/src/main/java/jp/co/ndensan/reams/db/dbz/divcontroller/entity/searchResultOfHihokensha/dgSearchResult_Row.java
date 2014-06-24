package jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha;

/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 13 15:37:47 JST 2014
 */
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgSearchResult_Row のクラスファイル
 *
 * @author 自動生成
 */
public class dgSearchResult_Row extends DataRow {

    private Button btnToDecide;
    private RString hihokenshaNo;
    private RString shikibetsuCode;
    private RString hihokenshaKubun;
    private RString shimei;
    private RString kanaShimsei;
    private RString shimeiAndKanaShimsei;
    private RString gender;
    private TextBoxDate birthDay;
    private RString yubinNo;
    private RString jusho;
    private RString kojinNo;
    private RString juminShubetsu;
    private RString setaiCode;

    public dgSearchResult_Row() {
        super();
        this.btnToDecide = new Button();
        this.hihokenshaNo = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
        this.hihokenshaKubun = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.kanaShimsei = RString.EMPTY;
        this.shimeiAndKanaShimsei = RString.EMPTY;
        this.gender = RString.EMPTY;
        this.birthDay = new TextBoxDate();
        this.yubinNo = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.kojinNo = RString.EMPTY;
        this.juminShubetsu = RString.EMPTY;
        this.setaiCode = RString.EMPTY;
    }

    public dgSearchResult_Row(Button btnToDecide, RString hihokenshaNo, RString shikibetsuCode, RString hihokenshaKubun, RString shimei, RString kanaShimsei, RString shimeiAndKanaShimsei, RString gender, TextBoxDate birthDay, RString yubinNo, RString jusho, RString kojinNo, RString juminShubetsu, RString setaiCode) {
        super();
        this.setOriginalData("btnToDecide", btnToDecide);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("hihokenshaKubun", hihokenshaKubun);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimsei", kanaShimsei);
        this.setOriginalData("shimeiAndKanaShimsei", shimeiAndKanaShimsei);
        this.setOriginalData("gender", gender);
        this.setOriginalData("birthDay", birthDay);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("kojinNo", kojinNo);
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.setOriginalData("setaiCode", setaiCode);
        this.btnToDecide = btnToDecide;
        this.hihokenshaNo = hihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
        this.hihokenshaKubun = hihokenshaKubun;
        this.shimei = shimei;
        this.kanaShimsei = kanaShimsei;
        this.shimeiAndKanaShimsei = shimeiAndKanaShimsei;
        this.gender = gender;
        this.birthDay = birthDay;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.kojinNo = kojinNo;
        this.juminShubetsu = juminShubetsu;
        this.setaiCode = setaiCode;
    }

    public Button getBtnToDecide() {
        return btnToDecide;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getHihokenshaKubun() {
        return hihokenshaKubun;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getKanaShimsei() {
        return kanaShimsei;
    }

    public RString getShimeiAndKanaShimsei() {
        return shimeiAndKanaShimsei;
    }

    public RString getGender() {
        return gender;
    }

    public TextBoxDate getBirthDay() {
        return birthDay;
    }

    public RString getYubinNo() {
        return yubinNo;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getKojinNo() {
        return kojinNo;
    }

    public RString getJuminShubetsu() {
        return juminShubetsu;
    }

    public RString getSetaiCode() {
        return setaiCode;
    }

    public void setBtnToDecide(Button btnToDecide) {
        this.setOriginalData("btnToDecide", btnToDecide);
        this.btnToDecide = btnToDecide;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setHihokenshaKubun(RString hihokenshaKubun) {
        this.setOriginalData("hihokenshaKubun", hihokenshaKubun);
        this.hihokenshaKubun = hihokenshaKubun;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setKanaShimsei(RString kanaShimsei) {
        this.setOriginalData("kanaShimsei", kanaShimsei);
        this.kanaShimsei = kanaShimsei;
    }

    public void setShimeiAndKanaShimsei(RString shimeiAndKanaShimsei) {
        this.setOriginalData("shimeiAndKanaShimsei", shimeiAndKanaShimsei);
        this.shimeiAndKanaShimsei = shimeiAndKanaShimsei;
    }

    public void setGender(RString gender) {
        this.setOriginalData("gender", gender);
        this.gender = gender;
    }

    public void setBirthDay(TextBoxDate birthDay) {
        this.setOriginalData("birthDay", birthDay);
        this.birthDay = birthDay;
    }

    public void setYubinNo(RString yubinNo) {
        this.setOriginalData("yubinNo", yubinNo);
        this.yubinNo = yubinNo;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setKojinNo(RString kojinNo) {
        this.setOriginalData("kojinNo", kojinNo);
        this.kojinNo = kojinNo;
    }

    public void setJuminShubetsu(RString juminShubetsu) {
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.juminShubetsu = juminShubetsu;
    }

    public void setSetaiCode(RString setaiCode) {
        this.setOriginalData("setaiCode", setaiCode);
        this.setaiCode = setaiCode;
    }

}
