package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Jan 09 16:15:21 CST 2016 
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    private RString state;
    private TextBoxFlexibleDate henkoDate;
    private TextBoxFlexibleDate henkoTodokedeDate;
    private RString henkoJiyu;
    private RString henkoJiyuKey;
    private RString shozaiHokensha;
    private RString sochimotoHokensha;
    private RString kyuHokensha;
    private TextBoxFlexibleDate shoriDate;

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
        this.setOriginalData("state", state);
        this.setOriginalData("henkoDate", henkoDate);
        this.setOriginalData("henkoTodokedeDate", henkoTodokedeDate);
        this.setOriginalData("henkoJiyu", henkoJiyu);
        this.setOriginalData("henkoJiyuKey", henkoJiyuKey);
        this.setOriginalData("shozaiHokensha", shozaiHokensha);
        this.setOriginalData("sochimotoHokensha", sochimotoHokensha);
        this.setOriginalData("kyuHokensha", kyuHokensha);
        this.setOriginalData("shoriDate", shoriDate);
    }

    public dgHenko_Row(RString state, TextBoxFlexibleDate henkoDate, TextBoxFlexibleDate henkoTodokedeDate, RString henkoJiyu, RString henkoJiyuKey, RString shozaiHokensha, RString sochimotoHokensha, RString kyuHokensha, TextBoxFlexibleDate shoriDate) {
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
        this.state = state;
        this.henkoDate = henkoDate;
        this.henkoTodokedeDate = henkoTodokedeDate;
        this.henkoJiyu = henkoJiyu;
        this.henkoJiyuKey = henkoJiyuKey;
        this.shozaiHokensha = shozaiHokensha;
        this.sochimotoHokensha = sochimotoHokensha;
        this.kyuHokensha = kyuHokensha;
        this.shoriDate = shoriDate;
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

    // </editor-fold>
}
