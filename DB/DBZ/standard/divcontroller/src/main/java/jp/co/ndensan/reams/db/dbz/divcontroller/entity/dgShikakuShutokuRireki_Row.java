package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 13:51:29 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShikakuShutokuRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShikakuShutokuRireki_Row extends DataRow {

    private RString state;
    private Button shosai;
    private TextBoxFlexibleDate shutokuDate;
    private TextBoxFlexibleDate shutokuTodokedeDate;
    private RString shutokuJiyuKey;
    private RString shutokuJiyu;
    private RString hihokenshaKubun;
    private RString hihokenshaKubunKey;
    private TextBoxFlexibleDate soshitsuDate;
    private TextBoxFlexibleDate soshitsuTodokedeDate;
    private RString soshitsuJiyuKey;
    private RString soshitsuJiyu;
    private TextBoxFlexibleDate henkoDate;
    private RString jutokuKubun;
    private RString shozaiHokensha;
    private RString sochimotoHokensha;
    private RString kyuHokensha;
    private RString shikibetsuCode;

    public dgShikakuShutokuRireki_Row() {
        super();
        this.state = RString.EMPTY;
        this.shosai = new Button();
        this.shutokuDate = new TextBoxFlexibleDate();
        this.shutokuTodokedeDate = new TextBoxFlexibleDate();
        this.shutokuJiyuKey = RString.EMPTY;
        this.shutokuJiyu = RString.EMPTY;
        this.hihokenshaKubun = RString.EMPTY;
        this.hihokenshaKubunKey = RString.EMPTY;
        this.soshitsuDate = new TextBoxFlexibleDate();
        this.soshitsuTodokedeDate = new TextBoxFlexibleDate();
        this.soshitsuJiyuKey = RString.EMPTY;
        this.soshitsuJiyu = RString.EMPTY;
        this.henkoDate = new TextBoxFlexibleDate();
        this.jutokuKubun = RString.EMPTY;
        this.shozaiHokensha = RString.EMPTY;
        this.sochimotoHokensha = RString.EMPTY;
        this.kyuHokensha = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
    }

    public dgShikakuShutokuRireki_Row(RString state, Button shosai, TextBoxFlexibleDate shutokuDate, TextBoxFlexibleDate shutokuTodokedeDate, RString shutokuJiyuKey, RString shutokuJiyu, RString hihokenshaKubun, RString hihokenshaKubunKey, TextBoxFlexibleDate soshitsuDate, TextBoxFlexibleDate soshitsuTodokedeDate, RString soshitsuJiyuKey, RString soshitsuJiyu, TextBoxFlexibleDate henkoDate, RString jutokuKubun, RString shozaiHokensha, RString sochimotoHokensha, RString kyuHokensha, RString shikibetsuCode) {
        super();
        this.setOriginalData("state", state);
        this.setOriginalData("shosai", shosai);
        this.setOriginalData("shutokuDate", shutokuDate);
        this.setOriginalData("shutokuTodokedeDate", shutokuTodokedeDate);
        this.setOriginalData("shutokuJiyuKey", shutokuJiyuKey);
        this.setOriginalData("shutokuJiyu", shutokuJiyu);
        this.setOriginalData("hihokenshaKubun", hihokenshaKubun);
        this.setOriginalData("hihokenshaKubunKey", hihokenshaKubunKey);
        this.setOriginalData("soshitsuDate", soshitsuDate);
        this.setOriginalData("soshitsuTodokedeDate", soshitsuTodokedeDate);
        this.setOriginalData("soshitsuJiyuKey", soshitsuJiyuKey);
        this.setOriginalData("soshitsuJiyu", soshitsuJiyu);
        this.setOriginalData("henkoDate", henkoDate);
        this.setOriginalData("jutokuKubun", jutokuKubun);
        this.setOriginalData("shozaiHokensha", shozaiHokensha);
        this.setOriginalData("sochimotoHokensha", sochimotoHokensha);
        this.setOriginalData("kyuHokensha", kyuHokensha);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.state = state;
        this.shosai = shosai;
        this.shutokuDate = shutokuDate;
        this.shutokuTodokedeDate = shutokuTodokedeDate;
        this.shutokuJiyuKey = shutokuJiyuKey;
        this.shutokuJiyu = shutokuJiyu;
        this.hihokenshaKubun = hihokenshaKubun;
        this.hihokenshaKubunKey = hihokenshaKubunKey;
        this.soshitsuDate = soshitsuDate;
        this.soshitsuTodokedeDate = soshitsuTodokedeDate;
        this.soshitsuJiyuKey = soshitsuJiyuKey;
        this.soshitsuJiyu = soshitsuJiyu;
        this.henkoDate = henkoDate;
        this.jutokuKubun = jutokuKubun;
        this.shozaiHokensha = shozaiHokensha;
        this.sochimotoHokensha = sochimotoHokensha;
        this.kyuHokensha = kyuHokensha;
        this.shikibetsuCode = shikibetsuCode;
    }

    public RString getState() {
        return state;
    }

    public Button getShosai() {
        return shosai;
    }

    public TextBoxFlexibleDate getShutokuDate() {
        return shutokuDate;
    }

    public TextBoxFlexibleDate getShutokuTodokedeDate() {
        return shutokuTodokedeDate;
    }

    public RString getShutokuJiyuKey() {
        return shutokuJiyuKey;
    }

    public RString getShutokuJiyu() {
        return shutokuJiyu;
    }

    public RString getHihokenshaKubun() {
        return hihokenshaKubun;
    }

    public RString getHihokenshaKubunKey() {
        return hihokenshaKubunKey;
    }

    public TextBoxFlexibleDate getSoshitsuDate() {
        return soshitsuDate;
    }

    public TextBoxFlexibleDate getSoshitsuTodokedeDate() {
        return soshitsuTodokedeDate;
    }

    public RString getSoshitsuJiyuKey() {
        return soshitsuJiyuKey;
    }

    public RString getSoshitsuJiyu() {
        return soshitsuJiyu;
    }

    public TextBoxFlexibleDate getHenkoDate() {
        return henkoDate;
    }

    public RString getJutokuKubun() {
        return jutokuKubun;
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

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public void setState(RString state) {
        this.setOriginalData("state", state);
        this.state = state;
    }

    public void setShosai(Button shosai) {
        this.setOriginalData("shosai", shosai);
        this.shosai = shosai;
    }

    public void setShutokuDate(TextBoxFlexibleDate shutokuDate) {
        this.setOriginalData("shutokuDate", shutokuDate);
        this.shutokuDate = shutokuDate;
    }

    public void setShutokuTodokedeDate(TextBoxFlexibleDate shutokuTodokedeDate) {
        this.setOriginalData("shutokuTodokedeDate", shutokuTodokedeDate);
        this.shutokuTodokedeDate = shutokuTodokedeDate;
    }

    public void setShutokuJiyuKey(RString shutokuJiyuKey) {
        this.setOriginalData("shutokuJiyuKey", shutokuJiyuKey);
        this.shutokuJiyuKey = shutokuJiyuKey;
    }

    public void setShutokuJiyu(RString shutokuJiyu) {
        this.setOriginalData("shutokuJiyu", shutokuJiyu);
        this.shutokuJiyu = shutokuJiyu;
    }

    public void setHihokenshaKubun(RString hihokenshaKubun) {
        this.setOriginalData("hihokenshaKubun", hihokenshaKubun);
        this.hihokenshaKubun = hihokenshaKubun;
    }

    public void setHihokenshaKubunKey(RString hihokenshaKubunKey) {
        this.setOriginalData("hihokenshaKubunKey", hihokenshaKubunKey);
        this.hihokenshaKubunKey = hihokenshaKubunKey;
    }

    public void setSoshitsuDate(TextBoxFlexibleDate soshitsuDate) {
        this.setOriginalData("soshitsuDate", soshitsuDate);
        this.soshitsuDate = soshitsuDate;
    }

    public void setSoshitsuTodokedeDate(TextBoxFlexibleDate soshitsuTodokedeDate) {
        this.setOriginalData("soshitsuTodokedeDate", soshitsuTodokedeDate);
        this.soshitsuTodokedeDate = soshitsuTodokedeDate;
    }

    public void setSoshitsuJiyuKey(RString soshitsuJiyuKey) {
        this.setOriginalData("soshitsuJiyuKey", soshitsuJiyuKey);
        this.soshitsuJiyuKey = soshitsuJiyuKey;
    }

    public void setSoshitsuJiyu(RString soshitsuJiyu) {
        this.setOriginalData("soshitsuJiyu", soshitsuJiyu);
        this.soshitsuJiyu = soshitsuJiyu;
    }

    public void setHenkoDate(TextBoxFlexibleDate henkoDate) {
        this.setOriginalData("henkoDate", henkoDate);
        this.henkoDate = henkoDate;
    }

    public void setJutokuKubun(RString jutokuKubun) {
        this.setOriginalData("jutokuKubun", jutokuKubun);
        this.jutokuKubun = jutokuKubun;
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

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

}