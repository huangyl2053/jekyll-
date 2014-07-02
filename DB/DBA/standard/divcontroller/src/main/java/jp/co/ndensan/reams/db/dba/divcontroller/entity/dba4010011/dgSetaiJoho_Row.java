package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 30 18:39:07 JST 2014 
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

    private RString shimei;
    private TextBoxFlexibleDate dateOfBirth;
    private RString age;
    private RString gender;
    private RString tsuzukigara;
    private RString juminJotai;
    private TextBoxFlexibleDate notJuminDate;
    private RString shikibetsuCode;
    private RString kojinNo;

    public dgSetaiJoho_Row() {
        super();
        this.shimei = RString.EMPTY;
        this.dateOfBirth = new TextBoxFlexibleDate();
        this.age = RString.EMPTY;
        this.gender = RString.EMPTY;
        this.tsuzukigara = RString.EMPTY;
        this.juminJotai = RString.EMPTY;
        this.notJuminDate = new TextBoxFlexibleDate();
        this.shikibetsuCode = RString.EMPTY;
        this.kojinNo = RString.EMPTY;
    }

    public dgSetaiJoho_Row(RString shimei, TextBoxFlexibleDate dateOfBirth, RString age, RString gender, RString tsuzukigara, RString juminJotai, TextBoxFlexibleDate notJuminDate, RString shikibetsuCode, RString kojinNo) {
        super();
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.setOriginalData("age", age);
        this.setOriginalData("gender", gender);
        this.setOriginalData("tsuzukigara", tsuzukigara);
        this.setOriginalData("juminJotai", juminJotai);
        this.setOriginalData("notJuminDate", notJuminDate);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("kojinNo", kojinNo);
        this.shimei = shimei;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.tsuzukigara = tsuzukigara;
        this.juminJotai = juminJotai;
        this.notJuminDate = notJuminDate;
        this.shikibetsuCode = shikibetsuCode;
        this.kojinNo = kojinNo;
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

    public RString getJuminJotai() {
        return juminJotai;
    }

    public TextBoxFlexibleDate getNotJuminDate() {
        return notJuminDate;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getKojinNo() {
        return kojinNo;
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

    public void setJuminJotai(RString juminJotai) {
        this.setOriginalData("juminJotai", juminJotai);
        this.juminJotai = juminJotai;
    }

    public void setNotJuminDate(TextBoxFlexibleDate notJuminDate) {
        this.setOriginalData("notJuminDate", notJuminDate);
        this.notJuminDate = notJuminDate;
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
