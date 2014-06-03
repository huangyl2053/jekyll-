package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 08 20:18:01 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSetaiJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSetaiJoho_Row extends DataRow {

    private RString setaiShikibetsuCode;
    private RString setaiJuminShubetsu;
    private RString setaiName;
    private RString setaiGender;
    private RString setaiBirthDay;
    private RString setaiTsuzukiGara;
    private RString setaiHihokenshaNo;

    public dgSetaiJoho_Row() {
        super();
    }

    public dgSetaiJoho_Row(RString setaiShikibetsuCode, RString setaiJuminShubetsu, RString setaiName, RString setaiGender, RString setaiBirthDay, RString setaiTsuzukiGara, RString setaiHihokenshaNo) {
        super();
        this.setOriginalData("setaiShikibetsuCode", setaiShikibetsuCode);
        this.setOriginalData("setaiJuminShubetsu", setaiJuminShubetsu);
        this.setOriginalData("setaiName", setaiName);
        this.setOriginalData("setaiGender", setaiGender);
        this.setOriginalData("setaiBirthDay", setaiBirthDay);
        this.setOriginalData("setaiTsuzukiGara", setaiTsuzukiGara);
        this.setOriginalData("setaiHihokenshaNo", setaiHihokenshaNo);
        this.setaiShikibetsuCode = setaiShikibetsuCode;
        this.setaiJuminShubetsu = setaiJuminShubetsu;
        this.setaiName = setaiName;
        this.setaiGender = setaiGender;
        this.setaiBirthDay = setaiBirthDay;
        this.setaiTsuzukiGara = setaiTsuzukiGara;
        this.setaiHihokenshaNo = setaiHihokenshaNo;
    }

    public RString getSetaiShikibetsuCode() {
        return setaiShikibetsuCode;
    }

    public RString getSetaiJuminShubetsu() {
        return setaiJuminShubetsu;
    }

    public RString getSetaiName() {
        return setaiName;
    }

    public RString getSetaiGender() {
        return setaiGender;
    }

    public RString getSetaiBirthDay() {
        return setaiBirthDay;
    }

    public RString getSetaiTsuzukiGara() {
        return setaiTsuzukiGara;
    }

    public RString getSetaiHihokenshaNo() {
        return setaiHihokenshaNo;
    }

    public void setSetaiShikibetsuCode(RString setaiShikibetsuCode) {
        this.setOriginalData("setaiShikibetsuCode", setaiShikibetsuCode);
        this.setaiShikibetsuCode = setaiShikibetsuCode;
    }

    public void setSetaiJuminShubetsu(RString setaiJuminShubetsu) {
        this.setOriginalData("setaiJuminShubetsu", setaiJuminShubetsu);
        this.setaiJuminShubetsu = setaiJuminShubetsu;
    }

    public void setSetaiName(RString setaiName) {
        this.setOriginalData("setaiName", setaiName);
        this.setaiName = setaiName;
    }

    public void setSetaiGender(RString setaiGender) {
        this.setOriginalData("setaiGender", setaiGender);
        this.setaiGender = setaiGender;
    }

    public void setSetaiBirthDay(RString setaiBirthDay) {
        this.setOriginalData("setaiBirthDay", setaiBirthDay);
        this.setaiBirthDay = setaiBirthDay;
    }

    public void setSetaiTsuzukiGara(RString setaiTsuzukiGara) {
        this.setOriginalData("setaiTsuzukiGara", setaiTsuzukiGara);
        this.setaiTsuzukiGara = setaiTsuzukiGara;
    }

    public void setSetaiHihokenshaNo(RString setaiHihokenshaNo) {
        this.setOriginalData("setaiHihokenshaNo", setaiHihokenshaNo);
        this.setaiHihokenshaNo = setaiHihokenshaNo;
    }

}