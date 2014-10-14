package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Aug 26 20:57:57 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShikakuShutokuRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShikakuShutokuRireki_Row extends DataRow {

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
    private TextBoxFlexibleDate jutokuTekiyoDate;
    private TextBoxFlexibleDate jutokuTekiyoTodokedeDate;
    private RString jutokuTekiyoJiyuKey;
    private RString jutokuTekiyoJiyu;
    private TextBoxFlexibleDate jutokuKaijoDate;
    private TextBoxFlexibleDate jutokuKaijoTodokedeDate;
    private RString jutokuKaijoJiyuKey;
    private RString jutokuKaijoJiyu;
    private TextBoxFlexibleDate henkoDate;
    private TextBoxFlexibleDate henkoTodokedeDate;
    private RString henkoJiyuKey;
    private RString henkoJiyu;
    private TextBoxFlexibleDate nenreiTotatsuDate;
    private RString jutokuKubun;
    private RString shozaiHokensha;
    private RString sochimotoHokensha;
    private RString kyuHokensha;
    private RString shikibetsuCode;

    public dgShikakuShutokuRireki_Row() {
        super();
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
        this.jutokuTekiyoDate = new TextBoxFlexibleDate();
        this.jutokuTekiyoTodokedeDate = new TextBoxFlexibleDate();
        this.jutokuTekiyoJiyuKey = RString.EMPTY;
        this.jutokuTekiyoJiyu = RString.EMPTY;
        this.jutokuKaijoDate = new TextBoxFlexibleDate();
        this.jutokuKaijoTodokedeDate = new TextBoxFlexibleDate();
        this.jutokuKaijoJiyuKey = RString.EMPTY;
        this.jutokuKaijoJiyu = RString.EMPTY;
        this.henkoDate = new TextBoxFlexibleDate();
        this.henkoTodokedeDate = new TextBoxFlexibleDate();
        this.henkoJiyuKey = RString.EMPTY;
        this.henkoJiyu = RString.EMPTY;
        this.nenreiTotatsuDate = new TextBoxFlexibleDate();
        this.jutokuKubun = RString.EMPTY;
        this.shozaiHokensha = RString.EMPTY;
        this.sochimotoHokensha = RString.EMPTY;
        this.kyuHokensha = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
    }

    public dgShikakuShutokuRireki_Row(Button shosai, TextBoxFlexibleDate shutokuDate, TextBoxFlexibleDate shutokuTodokedeDate, RString shutokuJiyuKey, RString shutokuJiyu, RString hihokenshaKubun, RString hihokenshaKubunKey, TextBoxFlexibleDate soshitsuDate, TextBoxFlexibleDate soshitsuTodokedeDate, RString soshitsuJiyuKey, RString soshitsuJiyu, TextBoxFlexibleDate jutokuTekiyoDate, TextBoxFlexibleDate jutokuTekiyoTodokedeDate, RString jutokuTekiyoJiyuKey, RString jutokuTekiyoJiyu, TextBoxFlexibleDate jutokuKaijoDate, TextBoxFlexibleDate jutokuKaijoTodokedeDate, RString jutokuKaijoJiyuKey, RString jutokuKaijoJiyu, TextBoxFlexibleDate henkoDate, TextBoxFlexibleDate henkoTodokedeDate, RString henkoJiyuKey, RString henkoJiyu, TextBoxFlexibleDate nenreiTotatsuDate, RString jutokuKubun, RString shozaiHokensha, RString sochimotoHokensha, RString kyuHokensha, RString shikibetsuCode) {
        super();
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
        this.setOriginalData("jutokuTekiyoDate", jutokuTekiyoDate);
        this.setOriginalData("jutokuTekiyoTodokedeDate", jutokuTekiyoTodokedeDate);
        this.setOriginalData("jutokuTekiyoJiyuKey", jutokuTekiyoJiyuKey);
        this.setOriginalData("jutokuTekiyoJiyu", jutokuTekiyoJiyu);
        this.setOriginalData("jutokuKaijoDate", jutokuKaijoDate);
        this.setOriginalData("jutokuKaijoTodokedeDate", jutokuKaijoTodokedeDate);
        this.setOriginalData("jutokuKaijoJiyuKey", jutokuKaijoJiyuKey);
        this.setOriginalData("jutokuKaijoJiyu", jutokuKaijoJiyu);
        this.setOriginalData("henkoDate", henkoDate);
        this.setOriginalData("henkoTodokedeDate", henkoTodokedeDate);
        this.setOriginalData("henkoJiyuKey", henkoJiyuKey);
        this.setOriginalData("henkoJiyu", henkoJiyu);
        this.setOriginalData("nenreiTotatsuDate", nenreiTotatsuDate);
        this.setOriginalData("jutokuKubun", jutokuKubun);
        this.setOriginalData("shozaiHokensha", shozaiHokensha);
        this.setOriginalData("sochimotoHokensha", sochimotoHokensha);
        this.setOriginalData("kyuHokensha", kyuHokensha);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
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
        this.jutokuTekiyoDate = jutokuTekiyoDate;
        this.jutokuTekiyoTodokedeDate = jutokuTekiyoTodokedeDate;
        this.jutokuTekiyoJiyuKey = jutokuTekiyoJiyuKey;
        this.jutokuTekiyoJiyu = jutokuTekiyoJiyu;
        this.jutokuKaijoDate = jutokuKaijoDate;
        this.jutokuKaijoTodokedeDate = jutokuKaijoTodokedeDate;
        this.jutokuKaijoJiyuKey = jutokuKaijoJiyuKey;
        this.jutokuKaijoJiyu = jutokuKaijoJiyu;
        this.henkoDate = henkoDate;
        this.henkoTodokedeDate = henkoTodokedeDate;
        this.henkoJiyuKey = henkoJiyuKey;
        this.henkoJiyu = henkoJiyu;
        this.nenreiTotatsuDate = nenreiTotatsuDate;
        this.jutokuKubun = jutokuKubun;
        this.shozaiHokensha = shozaiHokensha;
        this.sochimotoHokensha = sochimotoHokensha;
        this.kyuHokensha = kyuHokensha;
        this.shikibetsuCode = shikibetsuCode;
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

    public TextBoxFlexibleDate getJutokuTekiyoDate() {
        return jutokuTekiyoDate;
    }

    public TextBoxFlexibleDate getJutokuTekiyoTodokedeDate() {
        return jutokuTekiyoTodokedeDate;
    }

    public RString getJutokuTekiyoJiyuKey() {
        return jutokuTekiyoJiyuKey;
    }

    public RString getJutokuTekiyoJiyu() {
        return jutokuTekiyoJiyu;
    }

    public TextBoxFlexibleDate getJutokuKaijoDate() {
        return jutokuKaijoDate;
    }

    public TextBoxFlexibleDate getJutokuKaijoTodokedeDate() {
        return jutokuKaijoTodokedeDate;
    }

    public RString getJutokuKaijoJiyuKey() {
        return jutokuKaijoJiyuKey;
    }

    public RString getJutokuKaijoJiyu() {
        return jutokuKaijoJiyu;
    }

    public TextBoxFlexibleDate getHenkoDate() {
        return henkoDate;
    }

    public TextBoxFlexibleDate getHenkoTodokedeDate() {
        return henkoTodokedeDate;
    }

    public RString getHenkoJiyuKey() {
        return henkoJiyuKey;
    }

    public RString getHenkoJiyu() {
        return henkoJiyu;
    }

    public TextBoxFlexibleDate getNenreiTotatsuDate() {
        return nenreiTotatsuDate;
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

    public void setJutokuTekiyoDate(TextBoxFlexibleDate jutokuTekiyoDate) {
        this.setOriginalData("jutokuTekiyoDate", jutokuTekiyoDate);
        this.jutokuTekiyoDate = jutokuTekiyoDate;
    }

    public void setJutokuTekiyoTodokedeDate(TextBoxFlexibleDate jutokuTekiyoTodokedeDate) {
        this.setOriginalData("jutokuTekiyoTodokedeDate", jutokuTekiyoTodokedeDate);
        this.jutokuTekiyoTodokedeDate = jutokuTekiyoTodokedeDate;
    }

    public void setJutokuTekiyoJiyuKey(RString jutokuTekiyoJiyuKey) {
        this.setOriginalData("jutokuTekiyoJiyuKey", jutokuTekiyoJiyuKey);
        this.jutokuTekiyoJiyuKey = jutokuTekiyoJiyuKey;
    }

    public void setJutokuTekiyoJiyu(RString jutokuTekiyoJiyu) {
        this.setOriginalData("jutokuTekiyoJiyu", jutokuTekiyoJiyu);
        this.jutokuTekiyoJiyu = jutokuTekiyoJiyu;
    }

    public void setJutokuKaijoDate(TextBoxFlexibleDate jutokuKaijoDate) {
        this.setOriginalData("jutokuKaijoDate", jutokuKaijoDate);
        this.jutokuKaijoDate = jutokuKaijoDate;
    }

    public void setJutokuKaijoTodokedeDate(TextBoxFlexibleDate jutokuKaijoTodokedeDate) {
        this.setOriginalData("jutokuKaijoTodokedeDate", jutokuKaijoTodokedeDate);
        this.jutokuKaijoTodokedeDate = jutokuKaijoTodokedeDate;
    }

    public void setJutokuKaijoJiyuKey(RString jutokuKaijoJiyuKey) {
        this.setOriginalData("jutokuKaijoJiyuKey", jutokuKaijoJiyuKey);
        this.jutokuKaijoJiyuKey = jutokuKaijoJiyuKey;
    }

    public void setJutokuKaijoJiyu(RString jutokuKaijoJiyu) {
        this.setOriginalData("jutokuKaijoJiyu", jutokuKaijoJiyu);
        this.jutokuKaijoJiyu = jutokuKaijoJiyu;
    }

    public void setHenkoDate(TextBoxFlexibleDate henkoDate) {
        this.setOriginalData("henkoDate", henkoDate);
        this.henkoDate = henkoDate;
    }

    public void setHenkoTodokedeDate(TextBoxFlexibleDate henkoTodokedeDate) {
        this.setOriginalData("henkoTodokedeDate", henkoTodokedeDate);
        this.henkoTodokedeDate = henkoTodokedeDate;
    }

    public void setHenkoJiyuKey(RString henkoJiyuKey) {
        this.setOriginalData("henkoJiyuKey", henkoJiyuKey);
        this.henkoJiyuKey = henkoJiyuKey;
    }

    public void setHenkoJiyu(RString henkoJiyu) {
        this.setOriginalData("henkoJiyu", henkoJiyu);
        this.henkoJiyu = henkoJiyu;
    }

    public void setNenreiTotatsuDate(TextBoxFlexibleDate nenreiTotatsuDate) {
        this.setOriginalData("nenreiTotatsuDate", nenreiTotatsuDate);
        this.nenreiTotatsuDate = nenreiTotatsuDate;
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