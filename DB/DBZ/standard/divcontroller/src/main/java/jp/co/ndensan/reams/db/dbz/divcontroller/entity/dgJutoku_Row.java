package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 11:47:51 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgJutoku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJutoku_Row extends DataRow {

    private RString state;
    private TextBoxFlexibleDate tekiyoDate;
    private TextBoxFlexibleDate tekiyoTodokedeDate;
    private RString tekiyoJiyu;
    private RString tekiyoJiyuKey;
    private TextBoxFlexibleDate kaijoDate;
    private TextBoxFlexibleDate kaijoTodokedeDate;
    private RString kaijoJiyu;
    private RString kaijoJiyuKey;
    private RString shozaiHokensha;
    private RString sochimotoHokensha;
    private RString kyuHokensha;
    private TextBoxFlexibleDate shoriDate;

    public dgJutoku_Row() {
        super();
        this.state = RString.EMPTY;
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.tekiyoTodokedeDate = new TextBoxFlexibleDate();
        this.tekiyoJiyu = RString.EMPTY;
        this.tekiyoJiyuKey = RString.EMPTY;
        this.kaijoDate = new TextBoxFlexibleDate();
        this.kaijoTodokedeDate = new TextBoxFlexibleDate();
        this.kaijoJiyu = RString.EMPTY;
        this.kaijoJiyuKey = RString.EMPTY;
        this.shozaiHokensha = RString.EMPTY;
        this.sochimotoHokensha = RString.EMPTY;
        this.kyuHokensha = RString.EMPTY;
        this.shoriDate = new TextBoxFlexibleDate();
    }

    public dgJutoku_Row(RString state, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate tekiyoTodokedeDate, RString tekiyoJiyu, RString tekiyoJiyuKey, TextBoxFlexibleDate kaijoDate, TextBoxFlexibleDate kaijoTodokedeDate, RString kaijoJiyu, RString kaijoJiyuKey, RString shozaiHokensha, RString sochimotoHokensha, RString kyuHokensha, TextBoxFlexibleDate shoriDate) {
        super();
        this.setOriginalData("state", state);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("tekiyoTodokedeDate", tekiyoTodokedeDate);
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.setOriginalData("tekiyoJiyuKey", tekiyoJiyuKey);
        this.setOriginalData("kaijoDate", kaijoDate);
        this.setOriginalData("kaijoTodokedeDate", kaijoTodokedeDate);
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.setOriginalData("kaijoJiyuKey", kaijoJiyuKey);
        this.setOriginalData("shozaiHokensha", shozaiHokensha);
        this.setOriginalData("sochimotoHokensha", sochimotoHokensha);
        this.setOriginalData("kyuHokensha", kyuHokensha);
        this.setOriginalData("shoriDate", shoriDate);
        this.state = state;
        this.tekiyoDate = tekiyoDate;
        this.tekiyoTodokedeDate = tekiyoTodokedeDate;
        this.tekiyoJiyu = tekiyoJiyu;
        this.tekiyoJiyuKey = tekiyoJiyuKey;
        this.kaijoDate = kaijoDate;
        this.kaijoTodokedeDate = kaijoTodokedeDate;
        this.kaijoJiyu = kaijoJiyu;
        this.kaijoJiyuKey = kaijoJiyuKey;
        this.shozaiHokensha = shozaiHokensha;
        this.sochimotoHokensha = sochimotoHokensha;
        this.kyuHokensha = kyuHokensha;
        this.shoriDate = shoriDate;
    }

    public RString getState() {
        return state;
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

}