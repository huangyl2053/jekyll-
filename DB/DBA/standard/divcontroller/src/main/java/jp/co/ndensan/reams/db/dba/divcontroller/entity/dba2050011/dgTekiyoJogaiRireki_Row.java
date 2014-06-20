package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 20 10:26:40 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgTekiyoJogaiRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTekiyoJogaiRireki_Row extends DataRow {

    private RString tekiyoJiyuKey;
    private RString tekiyoJiyu;
    private TextBoxFlexibleDate tekiyoDate;
    private TextBoxFlexibleDate tekiyoTodokedeDate;
    private RString kaijoJiyuKey;
    private RString kaijoJiyu;
    private TextBoxFlexibleDate kaijoDate;
    private TextBoxFlexibleDate kaijoTodokedeDate;
    private TextBoxFlexibleDate nyushoDate;
    private TextBoxFlexibleDate taishoDate;
    private RString shisetsuCode;
    private RString shisetsuMeisho;
    private RString shisetsu;
    private TextBoxFlexibleDate nyushoTsuchiHakkoDate;
    private TextBoxFlexibleDate taishoTsuchiHakkoDate;
    private TextBoxFlexibleDate henkoTsuchiHakkoDate;

    public dgTekiyoJogaiRireki_Row() {
        super();
        this.tekiyoJiyuKey = RString.EMPTY;
        this.tekiyoJiyu = RString.EMPTY;
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.tekiyoTodokedeDate = new TextBoxFlexibleDate();
        this.kaijoJiyuKey = RString.EMPTY;
        this.kaijoJiyu = RString.EMPTY;
        this.kaijoDate = new TextBoxFlexibleDate();
        this.kaijoTodokedeDate = new TextBoxFlexibleDate();
        this.nyushoDate = new TextBoxFlexibleDate();
        this.taishoDate = new TextBoxFlexibleDate();
        this.shisetsuCode = RString.EMPTY;
        this.shisetsuMeisho = RString.EMPTY;
        this.shisetsu = RString.EMPTY;
        this.nyushoTsuchiHakkoDate = new TextBoxFlexibleDate();
        this.taishoTsuchiHakkoDate = new TextBoxFlexibleDate();
        this.henkoTsuchiHakkoDate = new TextBoxFlexibleDate();
    }

    public dgTekiyoJogaiRireki_Row(RString tekiyoJiyuKey, RString tekiyoJiyu, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate tekiyoTodokedeDate, RString kaijoJiyuKey, RString kaijoJiyu, TextBoxFlexibleDate kaijoDate, TextBoxFlexibleDate kaijoTodokedeDate, TextBoxFlexibleDate nyushoDate, TextBoxFlexibleDate taishoDate, RString shisetsuCode, RString shisetsuMeisho, RString shisetsu, TextBoxFlexibleDate nyushoTsuchiHakkoDate, TextBoxFlexibleDate taishoTsuchiHakkoDate, TextBoxFlexibleDate henkoTsuchiHakkoDate) {
        super();
        this.setOriginalData("tekiyoJiyuKey", tekiyoJiyuKey);
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("tekiyoTodokedeDate", tekiyoTodokedeDate);
        this.setOriginalData("kaijoJiyuKey", kaijoJiyuKey);
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.setOriginalData("kaijoDate", kaijoDate);
        this.setOriginalData("kaijoTodokedeDate", kaijoTodokedeDate);
        this.setOriginalData("nyushoDate", nyushoDate);
        this.setOriginalData("taishoDate", taishoDate);
        this.setOriginalData("shisetsuCode", shisetsuCode);
        this.setOriginalData("shisetsuMeisho", shisetsuMeisho);
        this.setOriginalData("shisetsu", shisetsu);
        this.setOriginalData("nyushoTsuchiHakkoDate", nyushoTsuchiHakkoDate);
        this.setOriginalData("taishoTsuchiHakkoDate", taishoTsuchiHakkoDate);
        this.setOriginalData("henkoTsuchiHakkoDate", henkoTsuchiHakkoDate);
        this.tekiyoJiyuKey = tekiyoJiyuKey;
        this.tekiyoJiyu = tekiyoJiyu;
        this.tekiyoDate = tekiyoDate;
        this.tekiyoTodokedeDate = tekiyoTodokedeDate;
        this.kaijoJiyuKey = kaijoJiyuKey;
        this.kaijoJiyu = kaijoJiyu;
        this.kaijoDate = kaijoDate;
        this.kaijoTodokedeDate = kaijoTodokedeDate;
        this.nyushoDate = nyushoDate;
        this.taishoDate = taishoDate;
        this.shisetsuCode = shisetsuCode;
        this.shisetsuMeisho = shisetsuMeisho;
        this.shisetsu = shisetsu;
        this.nyushoTsuchiHakkoDate = nyushoTsuchiHakkoDate;
        this.taishoTsuchiHakkoDate = taishoTsuchiHakkoDate;
        this.henkoTsuchiHakkoDate = henkoTsuchiHakkoDate;
    }

    public RString getTekiyoJiyuKey() {
        return tekiyoJiyuKey;
    }

    public RString getTekiyoJiyu() {
        return tekiyoJiyu;
    }

    public TextBoxFlexibleDate getTekiyoDate() {
        return tekiyoDate;
    }

    public TextBoxFlexibleDate getTekiyoTodokedeDate() {
        return tekiyoTodokedeDate;
    }

    public RString getKaijoJiyuKey() {
        return kaijoJiyuKey;
    }

    public RString getKaijoJiyu() {
        return kaijoJiyu;
    }

    public TextBoxFlexibleDate getKaijoDate() {
        return kaijoDate;
    }

    public TextBoxFlexibleDate getKaijoTodokedeDate() {
        return kaijoTodokedeDate;
    }

    public TextBoxFlexibleDate getNyushoDate() {
        return nyushoDate;
    }

    public TextBoxFlexibleDate getTaishoDate() {
        return taishoDate;
    }

    public RString getShisetsuCode() {
        return shisetsuCode;
    }

    public RString getShisetsuMeisho() {
        return shisetsuMeisho;
    }

    public RString getShisetsu() {
        return shisetsu;
    }

    public TextBoxFlexibleDate getNyushoTsuchiHakkoDate() {
        return nyushoTsuchiHakkoDate;
    }

    public TextBoxFlexibleDate getTaishoTsuchiHakkoDate() {
        return taishoTsuchiHakkoDate;
    }

    public TextBoxFlexibleDate getHenkoTsuchiHakkoDate() {
        return henkoTsuchiHakkoDate;
    }

    public void setTekiyoJiyuKey(RString tekiyoJiyuKey) {
        this.setOriginalData("tekiyoJiyuKey", tekiyoJiyuKey);
        this.tekiyoJiyuKey = tekiyoJiyuKey;
    }

    public void setTekiyoJiyu(RString tekiyoJiyu) {
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.tekiyoJiyu = tekiyoJiyu;
    }

    public void setTekiyoDate(TextBoxFlexibleDate tekiyoDate) {
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.tekiyoDate = tekiyoDate;
    }

    public void setTekiyoTodokedeDate(TextBoxFlexibleDate tekiyoTodokedeDate) {
        this.setOriginalData("tekiyoTodokedeDate", tekiyoTodokedeDate);
        this.tekiyoTodokedeDate = tekiyoTodokedeDate;
    }

    public void setKaijoJiyuKey(RString kaijoJiyuKey) {
        this.setOriginalData("kaijoJiyuKey", kaijoJiyuKey);
        this.kaijoJiyuKey = kaijoJiyuKey;
    }

    public void setKaijoJiyu(RString kaijoJiyu) {
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.kaijoJiyu = kaijoJiyu;
    }

    public void setKaijoDate(TextBoxFlexibleDate kaijoDate) {
        this.setOriginalData("kaijoDate", kaijoDate);
        this.kaijoDate = kaijoDate;
    }

    public void setKaijoTodokedeDate(TextBoxFlexibleDate kaijoTodokedeDate) {
        this.setOriginalData("kaijoTodokedeDate", kaijoTodokedeDate);
        this.kaijoTodokedeDate = kaijoTodokedeDate;
    }

    public void setNyushoDate(TextBoxFlexibleDate nyushoDate) {
        this.setOriginalData("nyushoDate", nyushoDate);
        this.nyushoDate = nyushoDate;
    }

    public void setTaishoDate(TextBoxFlexibleDate taishoDate) {
        this.setOriginalData("taishoDate", taishoDate);
        this.taishoDate = taishoDate;
    }

    public void setShisetsuCode(RString shisetsuCode) {
        this.setOriginalData("shisetsuCode", shisetsuCode);
        this.shisetsuCode = shisetsuCode;
    }

    public void setShisetsuMeisho(RString shisetsuMeisho) {
        this.setOriginalData("shisetsuMeisho", shisetsuMeisho);
        this.shisetsuMeisho = shisetsuMeisho;
    }

    public void setShisetsu(RString shisetsu) {
        this.setOriginalData("shisetsu", shisetsu);
        this.shisetsu = shisetsu;
    }

    public void setNyushoTsuchiHakkoDate(TextBoxFlexibleDate nyushoTsuchiHakkoDate) {
        this.setOriginalData("nyushoTsuchiHakkoDate", nyushoTsuchiHakkoDate);
        this.nyushoTsuchiHakkoDate = nyushoTsuchiHakkoDate;
    }

    public void setTaishoTsuchiHakkoDate(TextBoxFlexibleDate taishoTsuchiHakkoDate) {
        this.setOriginalData("taishoTsuchiHakkoDate", taishoTsuchiHakkoDate);
        this.taishoTsuchiHakkoDate = taishoTsuchiHakkoDate;
    }

    public void setHenkoTsuchiHakkoDate(TextBoxFlexibleDate henkoTsuchiHakkoDate) {
        this.setOriginalData("henkoTsuchiHakkoDate", henkoTsuchiHakkoDate);
        this.henkoTsuchiHakkoDate = henkoTsuchiHakkoDate;
    }

}