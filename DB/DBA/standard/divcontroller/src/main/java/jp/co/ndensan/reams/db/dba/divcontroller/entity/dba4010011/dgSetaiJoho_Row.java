package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Aug 14 13:32:24 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgSetaiJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSetaiJoho_Row extends DataRow {

    private RString hihokenshaNo;
    private RString shimei;
    private TextBoxFlexibleDate dateOfBirth;
    private RString age;
    private RString gender;
    private RString tsuzukigara;
    private RString hihokenshaKubun;
    private RString juminJotai;
    private RString shikibetsuCode;
    private RString kojinNo;

    public dgSetaiJoho_Row() {
        super();
        this.hihokenshaNo = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.dateOfBirth = new TextBoxFlexibleDate();
        this.age = RString.EMPTY;
        this.gender = RString.EMPTY;
        this.tsuzukigara = RString.EMPTY;
        this.hihokenshaKubun = RString.EMPTY;
        this.juminJotai = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
        this.kojinNo = RString.EMPTY;
    }

    public dgSetaiJoho_Row(RString hihokenshaNo, RString shimei, TextBoxFlexibleDate dateOfBirth, RString age, RString gender, RString tsuzukigara, RString hihokenshaKubun, RString juminJotai, RString shikibetsuCode, RString kojinNo) {
        super();
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.setOriginalData("age", age);
        this.setOriginalData("gender", gender);
        this.setOriginalData("tsuzukigara", tsuzukigara);
        this.setOriginalData("hihokenshaKubun", hihokenshaKubun);
        this.setOriginalData("juminJotai", juminJotai);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("kojinNo", kojinNo);
        this.hihokenshaNo = hihokenshaNo;
        this.shimei = shimei;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.tsuzukigara = tsuzukigara;
        this.hihokenshaKubun = hihokenshaKubun;
        this.juminJotai = juminJotai;
        this.shikibetsuCode = shikibetsuCode;
        this.kojinNo = kojinNo;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public TextBoxFlexibleDate getDateOfBirth() {
        return dateOfBirth;
    }

    public RString getAge() {
        return age;
    }

    public RString getGender() {
        return gender;
    }

    public RString getTsuzukigara() {
        return tsuzukigara;
    }

    public RString getHihokenshaKubun() {
        return hihokenshaKubun;
    }

    public RString getJuminJotai() {
        return juminJotai;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getKojinNo() {
        return kojinNo;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setDateOfBirth(TextBoxFlexibleDate dateOfBirth) {
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    public void setAge(RString age) {
        this.setOriginalData("age", age);
        this.age = age;
    }

    public void setGender(RString gender) {
        this.setOriginalData("gender", gender);
        this.gender = gender;
    }

    public void setTsuzukigara(RString tsuzukigara) {
        this.setOriginalData("tsuzukigara", tsuzukigara);
        this.tsuzukigara = tsuzukigara;
    }

    public void setHihokenshaKubun(RString hihokenshaKubun) {
        this.setOriginalData("hihokenshaKubun", hihokenshaKubun);
        this.hihokenshaKubun = hihokenshaKubun;
    }

    public void setJuminJotai(RString juminJotai) {
        this.setOriginalData("juminJotai", juminJotai);
        this.juminJotai = juminJotai;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setKojinNo(RString kojinNo) {
        this.setOriginalData("kojinNo", kojinNo);
        this.kojinNo = kojinNo;
    }

}