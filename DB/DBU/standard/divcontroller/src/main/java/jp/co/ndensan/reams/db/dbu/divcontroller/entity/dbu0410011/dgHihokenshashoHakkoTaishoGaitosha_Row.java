package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 10 15:29:35 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgHihokenshashoHakkoTaishoGaitosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHihokenshashoHakkoTaishoGaitosha_Row extends DataRow {

    private Button select;
    private RString hihokenshaNo;
    private RString shimei;
    private RString dateOfBirth;
    private RString age;
    private RString gender;
    private RString jusho;

    public dgHihokenshashoHakkoTaishoGaitosha_Row() {
        super();
    }

    public dgHihokenshashoHakkoTaishoGaitosha_Row(Button select, RString hihokenshaNo, RString shimei, RString dateOfBirth, RString age, RString gender, RString jusho) {
        super();
        this.setOriginalData("select", select);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.setOriginalData("age", age);
        this.setOriginalData("gender", gender);
        this.setOriginalData("jusho", jusho);
        this.select = select;
        this.hihokenshaNo = hihokenshaNo;
        this.shimei = shimei;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.gender = gender;
        this.jusho = jusho;
    }

    public Button getSelect() {
        return select;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getDateOfBirth() {
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

    public void setSelect(Button select) {
        this.setOriginalData("select", select);
        this.select = select;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setDateOfBirth(RString dateOfBirth) {
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