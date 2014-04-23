package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 23 14:40:00 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * SetaiShokaiGrid_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class SetaiShokaiGrid_Row extends DataRow {

    private RString hihokenshaNo;
    private RString shimei;
    private RString gender;
    private RString dateOfBirth;
    private RString zokugara;
    private RString juminShubetsu;
    private RString shikibetsuCode;

    public SetaiShokaiGrid_Row() {
        super();
    }

    public SetaiShokaiGrid_Row(RString hihokenshaNo, RString shimei, RString gender, RString dateOfBirth, RString zokugara, RString juminShubetsu, RString shikibetsuCode) {
        super();
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("gender", gender);
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.setOriginalData("zokugara", zokugara);
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.hihokenshaNo = hihokenshaNo;
        this.shimei = shimei;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.zokugara = zokugara;
        this.juminShubetsu = juminShubetsu;
        this.shikibetsuCode = shikibetsuCode;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getGender() {
        return gender;
    }

    public RString getDateOfBirth() {
        return dateOfBirth;
    }

    public RString getZokugara() {
        return zokugara;
    }

    public RString getJuminShubetsu() {
        return juminShubetsu;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setGender(RString gender) {
        this.setOriginalData("gender", gender);
        this.gender = gender;
    }

    public void setDateOfBirth(RString dateOfBirth) {
        this.setOriginalData("dateOfBirth", dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    public void setZokugara(RString zokugara) {
        this.setOriginalData("zokugara", zokugara);
        this.zokugara = zokugara;
    }

    public void setJuminShubetsu(RString juminShubetsu) {
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.juminShubetsu = juminShubetsu;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

}