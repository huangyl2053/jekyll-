package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Oct 06 21:40:20 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgJutoku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJutoku_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-06_01-12-04">

    private RString state;
    private RString shichosonCode;
    private RString hihokenshaNo;
    private RString shoriTimestamp;
    private TextBoxFlexibleDate tekiyoDate;
    private TextBoxFlexibleDate tekiyoTodokedeDate;
    private RString tekiyoJiyu;
    private RString tekiyoJiyuKey;
    private TextBoxFlexibleDate kaijoDate;
    private TextBoxFlexibleDate kaijoTodokedeDate;
    private RString kaijoJiyu;
    private RString kaijoJiyuKey;
    private RString sochimotoHokensha;
    private RString kyuHokensha;
    private TextBoxDate shoriDate;
    private TextBoxFlexibleDate idoYMD;
    private RString edaNo;
    private TextBoxFlexibleDate kaijoIdoYMD;
    private RString kaijoEdaNo;

    public dgJutoku_Row() {
        super();
        this.state = RString.EMPTY;
        this.shichosonCode = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.shoriTimestamp = RString.EMPTY;
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.tekiyoTodokedeDate = new TextBoxFlexibleDate();
        this.tekiyoJiyu = RString.EMPTY;
        this.tekiyoJiyuKey = RString.EMPTY;
        this.kaijoDate = new TextBoxFlexibleDate();
        this.kaijoTodokedeDate = new TextBoxFlexibleDate();
        this.kaijoJiyu = RString.EMPTY;
        this.kaijoJiyuKey = RString.EMPTY;
        this.sochimotoHokensha = RString.EMPTY;
        this.kyuHokensha = RString.EMPTY;
        this.shoriDate = new TextBoxDate();
        this.idoYMD = new TextBoxFlexibleDate();
        this.edaNo = RString.EMPTY;
        this.kaijoIdoYMD = new TextBoxFlexibleDate();
        this.kaijoEdaNo = RString.EMPTY;
        this.setOriginalData("state", state);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shoriTimestamp", shoriTimestamp);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("tekiyoTodokedeDate", tekiyoTodokedeDate);
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.setOriginalData("tekiyoJiyuKey", tekiyoJiyuKey);
        this.setOriginalData("kaijoDate", kaijoDate);
        this.setOriginalData("kaijoTodokedeDate", kaijoTodokedeDate);
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.setOriginalData("kaijoJiyuKey", kaijoJiyuKey);
        this.setOriginalData("sochimotoHokensha", sochimotoHokensha);
        this.setOriginalData("kyuHokensha", kyuHokensha);
        this.setOriginalData("shoriDate", shoriDate);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("edaNo", edaNo);
        this.setOriginalData("kaijoIdoYMD", kaijoIdoYMD);
        this.setOriginalData("kaijoEdaNo", kaijoEdaNo);
    }

    public dgJutoku_Row(RString state, RString shichosonCode, RString hihokenshaNo, RString shoriTimestamp, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate tekiyoTodokedeDate, RString tekiyoJiyu, RString tekiyoJiyuKey, TextBoxFlexibleDate kaijoDate, TextBoxFlexibleDate kaijoTodokedeDate, RString kaijoJiyu, RString kaijoJiyuKey, RString sochimotoHokensha, RString kyuHokensha, TextBoxDate shoriDate, TextBoxFlexibleDate idoYMD, RString edaNo, TextBoxFlexibleDate kaijoIdoYMD, RString kaijoEdaNo) {
        super();
        this.setOriginalData("state", state);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shoriTimestamp", shoriTimestamp);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("tekiyoTodokedeDate", tekiyoTodokedeDate);
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.setOriginalData("tekiyoJiyuKey", tekiyoJiyuKey);
        this.setOriginalData("kaijoDate", kaijoDate);
        this.setOriginalData("kaijoTodokedeDate", kaijoTodokedeDate);
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.setOriginalData("kaijoJiyuKey", kaijoJiyuKey);
        this.setOriginalData("sochimotoHokensha", sochimotoHokensha);
        this.setOriginalData("kyuHokensha", kyuHokensha);
        this.setOriginalData("shoriDate", shoriDate);
        this.setOriginalData("idoYMD", idoYMD);
        this.setOriginalData("edaNo", edaNo);
        this.setOriginalData("kaijoIdoYMD", kaijoIdoYMD);
        this.setOriginalData("kaijoEdaNo", kaijoEdaNo);
        this.state = state;
        this.shichosonCode = shichosonCode;
        this.hihokenshaNo = hihokenshaNo;
        this.shoriTimestamp = shoriTimestamp;
        this.tekiyoDate = tekiyoDate;
        this.tekiyoTodokedeDate = tekiyoTodokedeDate;
        this.tekiyoJiyu = tekiyoJiyu;
        this.tekiyoJiyuKey = tekiyoJiyuKey;
        this.kaijoDate = kaijoDate;
        this.kaijoTodokedeDate = kaijoTodokedeDate;
        this.kaijoJiyu = kaijoJiyu;
        this.kaijoJiyuKey = kaijoJiyuKey;
        this.sochimotoHokensha = sochimotoHokensha;
        this.kyuHokensha = kyuHokensha;
        this.shoriDate = shoriDate;
        this.idoYMD = idoYMD;
        this.edaNo = edaNo;
        this.kaijoIdoYMD = kaijoIdoYMD;
        this.kaijoEdaNo = kaijoEdaNo;
    }

    public RString getState() {
        return state;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShoriTimestamp() {
        return shoriTimestamp;
    }

    public TextBoxFlexibleDate getTekiyoDate() {
        return tekiyoDate;
    }

    public TextBoxFlexibleDate getTekiyoTodokedeDate() {
        return tekiyoTodokedeDate;
    }

    public RString getTekiyoJiyu() {
        return tekiyoJiyu;
    }

    public RString getTekiyoJiyuKey() {
        return tekiyoJiyuKey;
    }

    public TextBoxFlexibleDate getKaijoDate() {
        return kaijoDate;
    }

    public TextBoxFlexibleDate getKaijoTodokedeDate() {
        return kaijoTodokedeDate;
    }

    public RString getKaijoJiyu() {
        return kaijoJiyu;
    }

    public RString getKaijoJiyuKey() {
        return kaijoJiyuKey;
    }

    public RString getSochimotoHokensha() {
        return sochimotoHokensha;
    }

    public RString getKyuHokensha() {
        return kyuHokensha;
    }

    public TextBoxDate getShoriDate() {
        return shoriDate;
    }

    public TextBoxFlexibleDate getIdoYMD() {
        return idoYMD;
    }

    public RString getEdaNo() {
        return edaNo;
    }

    public TextBoxFlexibleDate getKaijoIdoYMD() {
        return kaijoIdoYMD;
    }

    public RString getKaijoEdaNo() {
        return kaijoEdaNo;
    }

    public void setState(RString state) {
        this.setOriginalData("state", state);
        this.state = state;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShoriTimestamp(RString shoriTimestamp) {
        this.setOriginalData("shoriTimestamp", shoriTimestamp);
        this.shoriTimestamp = shoriTimestamp;
    }

    public void setTekiyoDate(TextBoxFlexibleDate tekiyoDate) {
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.tekiyoDate = tekiyoDate;
    }

    public void setTekiyoTodokedeDate(TextBoxFlexibleDate tekiyoTodokedeDate) {
        this.setOriginalData("tekiyoTodokedeDate", tekiyoTodokedeDate);
        this.tekiyoTodokedeDate = tekiyoTodokedeDate;
    }

    public void setTekiyoJiyu(RString tekiyoJiyu) {
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.tekiyoJiyu = tekiyoJiyu;
    }

    public void setTekiyoJiyuKey(RString tekiyoJiyuKey) {
        this.setOriginalData("tekiyoJiyuKey", tekiyoJiyuKey);
        this.tekiyoJiyuKey = tekiyoJiyuKey;
    }

    public void setKaijoDate(TextBoxFlexibleDate kaijoDate) {
        this.setOriginalData("kaijoDate", kaijoDate);
        this.kaijoDate = kaijoDate;
    }

    public void setKaijoTodokedeDate(TextBoxFlexibleDate kaijoTodokedeDate) {
        this.setOriginalData("kaijoTodokedeDate", kaijoTodokedeDate);
        this.kaijoTodokedeDate = kaijoTodokedeDate;
    }

    public void setKaijoJiyu(RString kaijoJiyu) {
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.kaijoJiyu = kaijoJiyu;
    }

    public void setKaijoJiyuKey(RString kaijoJiyuKey) {
        this.setOriginalData("kaijoJiyuKey", kaijoJiyuKey);
        this.kaijoJiyuKey = kaijoJiyuKey;
    }

    public void setSochimotoHokensha(RString sochimotoHokensha) {
        this.setOriginalData("sochimotoHokensha", sochimotoHokensha);
        this.sochimotoHokensha = sochimotoHokensha;
    }

    public void setKyuHokensha(RString kyuHokensha) {
        this.setOriginalData("kyuHokensha", kyuHokensha);
        this.kyuHokensha = kyuHokensha;
    }

    public void setShoriDate(TextBoxDate shoriDate) {
        this.setOriginalData("shoriDate", shoriDate);
        this.shoriDate = shoriDate;
    }

    public void setIdoYMD(TextBoxFlexibleDate idoYMD) {
        this.setOriginalData("idoYMD", idoYMD);
        this.idoYMD = idoYMD;
    }

    public void setEdaNo(RString edaNo) {
        this.setOriginalData("edaNo", edaNo);
        this.edaNo = edaNo;
    }

    public void setKaijoIdoYMD(TextBoxFlexibleDate kaijoIdoYMD) {
        this.setOriginalData("kaijoIdoYMD", kaijoIdoYMD);
        this.kaijoIdoYMD = kaijoIdoYMD;
    }

    public void setKaijoEdaNo(RString kaijoEdaNo) {
        this.setOriginalData("kaijoEdaNo", kaijoEdaNo);
        this.kaijoEdaNo = kaijoEdaNo;
    }

    // </editor-fold>
}
