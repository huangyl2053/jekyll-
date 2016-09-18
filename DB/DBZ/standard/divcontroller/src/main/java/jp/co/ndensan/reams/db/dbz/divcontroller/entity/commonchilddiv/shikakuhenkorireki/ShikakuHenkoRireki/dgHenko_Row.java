package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Sep 08 17:34:04 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgHenko_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHenko_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">

    private RString state;
    private TextBoxFlexibleDate henkoDate;
    private TextBoxFlexibleDate henkoTodokedeDate;
    private RString henkoJiyu;
    private RString henkoJiyuKey;
    private RString shozaiHokensha;
    private RString sochimotoHokensha;
    private RString kyuHokensha;
    private TextBoxFlexibleDate shoriDate;
    private RString hihokenshaNo;
    private RString shikibetsuCode;
    private RString shichosonCode;
    private TextBoxFlexibleDate idoYMD;
    private RString edaNo;

    public dgHenko_Row() {
        super();
        this.state = RString.EMPTY;
        this.henkoDate = new TextBoxFlexibleDate();
        this.henkoTodokedeDate = new TextBoxFlexibleDate();
        this.henkoJiyu = RString.EMPTY;
        this.henkoJiyuKey = RString.EMPTY;
        this.shozaiHokensha = RString.EMPTY;
        this.sochimotoHokensha = RString.EMPTY;
        this.kyuHokensha = RString.EMPTY;
        this.shoriDate = new TextBoxFlexibleDate();
        this.hihokenshaNo = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
        this.shichosonCode = RString.EMPTY;
        this.idoYMD = new TextBoxFlexibleDate();
        this.edaNo = RString.EMPTY;
        this.setOriginalData("state", state);
        this.setOriginalData("henkoDate", henkoDate);
        this.setOriginalData("henkoTodokedeDate", henkoTodokedeDate);
        this.setOriginalData("henkoJiyu", henkoJiyu);
        this.setOriginalData("henkoJiyuKey", henkoJiyuKey);
        this.setOriginalData("shozaiHokensha", shozaiHokensha);
        this.setOriginalData("sochimotoHokensha", sochimotoHokensha);
        this.setOriginalData("kyuHokensha", kyuHokensha);
        this.setOriginalData("shoriDate", shoriDate);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("edaNo", edaNo);
    }

    public dgHenko_Row(RString state, TextBoxFlexibleDate henkoDate, TextBoxFlexibleDate henkoTodokedeDate, RString henkoJiyu, RString henkoJiyuKey, RString shozaiHokensha, RString sochimotoHokensha, RString kyuHokensha, TextBoxFlexibleDate shoriDate, RString hihokenshaNo, RString shikibetsuCode, RString shichosonCode, TextBoxFlexibleDate idoYMD, RString edaNo) {
        super();
        this.setOriginalData("state", state);
        this.setOriginalData("henkoDate", henkoDate);
        this.setOriginalData("henkoTodokedeDate", henkoTodokedeDate);
        this.setOriginalData("henkoJiyu", henkoJiyu);
        this.setOriginalData("henkoJiyuKey", henkoJiyuKey);
        this.setOriginalData("shozaiHokensha", shozaiHokensha);
        this.setOriginalData("sochimotoHokensha", sochimotoHokensha);
        this.setOriginalData("kyuHokensha", kyuHokensha);
        this.setOriginalData("shoriDate", shoriDate);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("edaNo", edaNo);
        this.state = state;
        this.henkoDate = henkoDate;
        this.henkoTodokedeDate = henkoTodokedeDate;
        this.henkoJiyu = henkoJiyu;
        this.henkoJiyuKey = henkoJiyuKey;
        this.shozaiHokensha = shozaiHokensha;
        this.sochimotoHokensha = sochimotoHokensha;
        this.kyuHokensha = kyuHokensha;
        this.shoriDate = shoriDate;
        this.hihokenshaNo = hihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
        this.shichosonCode = shichosonCode;
        this.idoYMD = idoYMD;
        this.edaNo = edaNo;
    }

    public RString getState() {
        return state;
    }

    public TextBoxFlexibleDate getHenkoDate() {
        return henkoDate;
    }

    public TextBoxFlexibleDate getHenkoTodokedeDate() {
        return henkoTodokedeDate;
    }

    public RString getHenkoJiyu() {
        return henkoJiyu;
    }

    public RString getHenkoJiyuKey() {
        return henkoJiyuKey;
    }

    public RString getShozaiHokensha() {
        return shozaiHokensha;
    }

    public RString getSochimotoHokensha() {
        return sochimotoHokensha;
    }

    public RString getKyuHokensha() {
        return kyuHokensha;
    }

    public TextBoxFlexibleDate getShoriDate() {
        return shoriDate;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public TextBoxFlexibleDate getIdoYMD() {
        return idoYMD;
    }

    public RString getEdaNo() {
        return edaNo;
    }

    public void setState(RString state) {
        this.setOriginalData("state", state);
        this.state = state;
    }

    public void setHenkoDate(TextBoxFlexibleDate henkoDate) {
        this.setOriginalData("henkoDate", henkoDate);
        this.henkoDate = henkoDate;
    }

    public void setHenkoTodokedeDate(TextBoxFlexibleDate henkoTodokedeDate) {
        this.setOriginalData("henkoTodokedeDate", henkoTodokedeDate);
        this.henkoTodokedeDate = henkoTodokedeDate;
    }

    public void setHenkoJiyu(RString henkoJiyu) {
        this.setOriginalData("henkoJiyu", henkoJiyu);
        this.henkoJiyu = henkoJiyu;
    }

    public void setHenkoJiyuKey(RString henkoJiyuKey) {
        this.setOriginalData("henkoJiyuKey", henkoJiyuKey);
        this.henkoJiyuKey = henkoJiyuKey;
    }

    public void setShozaiHokensha(RString shozaiHokensha) {
        this.setOriginalData("shozaiHokensha", shozaiHokensha);
        this.shozaiHokensha = shozaiHokensha;
    }

    public void setSochimotoHokensha(RString sochimotoHokensha) {
        this.setOriginalData("sochimotoHokensha", sochimotoHokensha);
        this.sochimotoHokensha = sochimotoHokensha;
    }

    public void setKyuHokensha(RString kyuHokensha) {
        this.setOriginalData("kyuHokensha", kyuHokensha);
        this.kyuHokensha = kyuHokensha;
    }

    public void setShoriDate(TextBoxFlexibleDate shoriDate) {
        this.setOriginalData("shoriDate", shoriDate);
        this.shoriDate = shoriDate;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    public void setIdoYMD(TextBoxFlexibleDate idoYMD) {
        this.setOriginalData("idoYMD", idoYMD);
        this.idoYMD = idoYMD;
    }

    public void setEdaNo(RString edaNo) {
        this.setOriginalData("edaNo", edaNo);
        this.edaNo = edaNo;
    }

    // </editor-fold>
}
