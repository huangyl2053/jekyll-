package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 30 11:47:52 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShinsakaiIinIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiIinIchiran_Row extends DataRow {

    private TextBoxNum number;
    private Boolean yukoMukoKubun;
    private RString shinsainNo;
    private RString shinsainShimei;
    private RString sex;
    private RString shikaku;
    private RString shozokuKikan;
    private RString shinsainKubun;

    public dgShinsakaiIinIchiran_Row() {
        super();
        this.number = new TextBoxNum();
        this.yukoMukoKubun = false;
        this.shinsainNo = RString.EMPTY;
        this.shinsainShimei = RString.EMPTY;
        this.sex = RString.EMPTY;
        this.shikaku = RString.EMPTY;
        this.shozokuKikan = RString.EMPTY;
        this.shinsainKubun = RString.EMPTY;
    }

    public dgShinsakaiIinIchiran_Row(TextBoxNum number, Boolean yukoMukoKubun, RString shinsainNo, RString shinsainShimei, RString sex, RString shikaku, RString shozokuKikan, RString shinsainKubun) {
        super();
        this.setOriginalData("number", number);
        this.setOriginalData("yukoMukoKubun", yukoMukoKubun);
        this.setOriginalData("shinsainNo", shinsainNo);
        this.setOriginalData("shinsainShimei", shinsainShimei);
        this.setOriginalData("sex", sex);
        this.setOriginalData("shikaku", shikaku);
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.setOriginalData("shinsainKubun", shinsainKubun);
        this.number = number;
        this.yukoMukoKubun = yukoMukoKubun;
        this.shinsainNo = shinsainNo;
        this.shinsainShimei = shinsainShimei;
        this.sex = sex;
        this.shikaku = shikaku;
        this.shozokuKikan = shozokuKikan;
        this.shinsainKubun = shinsainKubun;
    }

    public TextBoxNum getNumber() {
        return number;
    }

    public Boolean getYukoMukoKubun() {
        return yukoMukoKubun;
    }

    public RString getShinsainNo() {
        return shinsainNo;
    }

    public RString getShinsainShimei() {
        return shinsainShimei;
    }

    public RString getSex() {
        return sex;
    }

    public RString getShikaku() {
        return shikaku;
    }

    public RString getShozokuKikan() {
        return shozokuKikan;
    }

    public RString getShinsainKubun() {
        return shinsainKubun;
    }

    public void setNumber(TextBoxNum number) {
        this.setOriginalData("number", number);
        this.number = number;
    }

    public void setYukoMukoKubun(Boolean yukoMukoKubun) {
        this.setOriginalData("yukoMukoKubun", yukoMukoKubun);
        this.yukoMukoKubun = yukoMukoKubun;
    }

    public void setShinsainNo(RString shinsainNo) {
        this.setOriginalData("shinsainNo", shinsainNo);
        this.shinsainNo = shinsainNo;
    }

    public void setShinsainShimei(RString shinsainShimei) {
        this.setOriginalData("shinsainShimei", shinsainShimei);
        this.shinsainShimei = shinsainShimei;
    }

    public void setSex(RString sex) {
        this.setOriginalData("sex", sex);
        this.sex = sex;
    }

    public void setShikaku(RString shikaku) {
        this.setOriginalData("shikaku", shikaku);
        this.shikaku = shikaku;
    }

    public void setShozokuKikan(RString shozokuKikan) {
        this.setOriginalData("shozokuKikan", shozokuKikan);
        this.shozokuKikan = shozokuKikan;
    }

    public void setShinsainKubun(RString shinsainKubun) {
        this.setOriginalData("shinsainKubun", shinsainKubun);
        this.shinsainKubun = shinsainKubun;
    }

}