package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed May 14 16:13:06 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgJushochiTokureiTaishoGaitosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJushochiTokureiTaishoGaitosha_Row extends DataRow {

    private RString hihokenshaNo;
    private RString shimei;
    private TextBoxFlexibleDate dateOfBirth;
    private RString age;
    private RString gender;
    private RString jusho;

    public dgJushochiTokureiTaishoGaitosha_Row() {
        super();
    }

    public dgJushochiTokureiTaishoGaitosha_Row(RString hihokenshaNo, RString shimei, TextBoxFlexibleDate dateOfBirth, RString age, RString gender, RString jusho) {
        super();
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.setOriginalData("age", age);
        this.setOriginalData("gender", gender);
        this.setOriginalData("jusho", jusho);
        this.hihokenshaNo = hihokenshaNo;
        this.shimei = shimei;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.jusho = jusho;
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

    public RString getJusho() {
        return jusho;
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

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

}