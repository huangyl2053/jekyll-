package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 06 17:55:26 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;


/**
 * dgShinsakaiShinsainIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiShinsainIchiran_Row extends DataRow {

    private TextBoxNum number;
    private RString shinsainNo;
    private RString shimei;
    private RString sex;
    private RString shikaku;
    private RString shinsainKubun;
    private DropDownList gichoKubun;
    private DropDownList shukketsuKubun;
    private RString shozokuKikan;

    public dgShinsakaiShinsainIchiran_Row() {
        super();
    }

    public dgShinsakaiShinsainIchiran_Row(TextBoxNum number, RString shinsainNo, RString shimei, RString sex, RString shikaku, RString shinsainKubun, DropDownList gichoKubun, DropDownList shukketsuKubun, RString shozokuKikan) {
        super();
        this.setOriginalData("number", number);
        this.setOriginalData("shinsainNo", shinsainNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("sex", sex);
        this.setOriginalData("shikaku", shikaku);
        this.setOriginalData("shinsainKubun", shinsainKubun);
        this.setOriginalData("gichoKubun", gichoKubun);
        this.setOriginalData("shukketsuKubun", shukketsuKubun);
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.number = number;
        this.shinsainNo = shinsainNo;
        this.shimei = shimei;
        this.sex = sex;
        this.shikaku = shikaku;
        this.shinsainKubun = shinsainKubun;
        this.gichoKubun = gichoKubun;
        this.shukketsuKubun = shukketsuKubun;
        this.shozokuKikan = shozokuKikan;
    }

    public TextBoxNum getNumber() {
        return number;
    }

    public RString getShinsainNo() {
        return shinsainNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getSex() {
        return sex;
    }

    public RString getShikaku() {
        return shikaku;
    }

    public RString getShinsainKubun() {
        return shinsainKubun;
    }

    public DropDownList getGichoKubun() {
        return gichoKubun;
    }

    public DropDownList getShukketsuKubun() {
        return shukketsuKubun;
    }

    public RString getShozokuKikan() {
        return shozokuKikan;
    }

    public void setNumber(TextBoxNum number) {
        this.setOriginalData("number", number);
        this.number = number;
    }

    public void setShinsainNo(RString shinsainNo) {
        this.setOriginalData("shinsainNo", shinsainNo);
        this.shinsainNo = shinsainNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setSex(RString sex) {
        this.setOriginalData("sex", sex);
        this.sex = sex;
    }

    public void setShikaku(RString shikaku) {
        this.setOriginalData("shikaku", shikaku);
        this.shikaku = shikaku;
    }

    public void setShinsainKubun(RString shinsainKubun) {
        this.setOriginalData("shinsainKubun", shinsainKubun);
        this.shinsainKubun = shinsainKubun;
    }

    public void setGichoKubun(DropDownList gichoKubun) {
        this.setOriginalData("gichoKubun", gichoKubun);
        this.gichoKubun = gichoKubun;
    }

    public void setShukketsuKubun(DropDownList shukketsuKubun) {
        this.setOriginalData("shukketsuKubun", shukketsuKubun);
        this.shukketsuKubun = shukketsuKubun;
    }

    public void setShozokuKikan(RString shozokuKikan) {
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.shozokuKikan = shozokuKikan;
    }

}