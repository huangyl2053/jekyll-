package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2040011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 27 20:47:42 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgJushochiTokureiRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJushochiTokureiRireki_Row extends DataRow {

    private RString tekiyoJiyu;
    private TextBoxFlexibleDate tekiyoDate;
    private TextBoxFlexibleDate tekiyoTodokedeDate;
    private RString kaijoJiyu;
    private TextBoxFlexibleDate kaijoDate;
    private TextBoxFlexibleDate kaijoTodokedeDate;
    private RString sochiHokenshaNo;
    private RString sochiHokenshaMeisho;
    private RString sochiHihokenshaNo;
    private TextBoxFlexibleDate nyushoDate;
    private TextBoxFlexibleDate taishoDate;
    private RString shisetsuShurui;
    private RString nyushoShisetsu;
    private RString shisetsuCode;
    private RString shisetsuMeisho;
    private TextBoxFlexibleDate renrakuhyoHakkoDate;
    private TextBoxFlexibleDate shisetuTaishoTuchiHakkoDate;
    private TextBoxFlexibleDate shisetsuHenkoTuchiHakkoDate;

    public dgJushochiTokureiRireki_Row() {
        super();
        this.tekiyoJiyu = RString.EMPTY;
        this.tekiyoDate = new TextBoxFlexibleDate();
        this.tekiyoTodokedeDate = new TextBoxFlexibleDate();
        this.kaijoJiyu = RString.EMPTY;
        this.kaijoDate = new TextBoxFlexibleDate();
        this.kaijoTodokedeDate = new TextBoxFlexibleDate();
        this.sochiHokenshaNo = RString.EMPTY;
        this.sochiHokenshaMeisho = RString.EMPTY;
        this.sochiHihokenshaNo = RString.EMPTY;
        this.nyushoDate = new TextBoxFlexibleDate();
        this.taishoDate = new TextBoxFlexibleDate();
        this.shisetsuShurui = RString.EMPTY;
        this.nyushoShisetsu = RString.EMPTY;
        this.shisetsuCode = RString.EMPTY;
        this.shisetsuMeisho = RString.EMPTY;
        this.renrakuhyoHakkoDate = new TextBoxFlexibleDate();
        this.shisetuTaishoTuchiHakkoDate = new TextBoxFlexibleDate();
        this.shisetsuHenkoTuchiHakkoDate = new TextBoxFlexibleDate();
    }

    public dgJushochiTokureiRireki_Row(RString tekiyoJiyu, TextBoxFlexibleDate tekiyoDate, TextBoxFlexibleDate tekiyoTodokedeDate, RString kaijoJiyu, TextBoxFlexibleDate kaijoDate, TextBoxFlexibleDate kaijoTodokedeDate, RString sochiHokenshaNo, RString sochiHokenshaMeisho, RString sochiHihokenshaNo, TextBoxFlexibleDate nyushoDate, TextBoxFlexibleDate taishoDate, RString shisetsuShurui, RString nyushoShisetsu, RString shisetsuCode, RString shisetsuMeisho, TextBoxFlexibleDate renrakuhyoHakkoDate, TextBoxFlexibleDate shisetuTaishoTuchiHakkoDate, TextBoxFlexibleDate shisetsuHenkoTuchiHakkoDate) {
        super();
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("tekiyoTodokedeDate", tekiyoTodokedeDate);
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.setOriginalData("kaijoDate", kaijoDate);
        this.setOriginalData("kaijoTodokedeDate", kaijoTodokedeDate);
        this.setOriginalData("sochiHokenshaNo", sochiHokenshaNo);
        this.setOriginalData("sochiHokenshaMeisho", sochiHokenshaMeisho);
        this.setOriginalData("sochiHihokenshaNo", sochiHihokenshaNo);
        this.setOriginalData("nyushoDate", nyushoDate);
        this.setOriginalData("taishoDate", taishoDate);
        this.setOriginalData("shisetsuShurui", shisetsuShurui);
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.setOriginalData("shisetsuCode", shisetsuCode);
        this.setOriginalData("shisetsuMeisho", shisetsuMeisho);
        this.setOriginalData("renrakuhyoHakkoDate", renrakuhyoHakkoDate);
        this.setOriginalData("shisetuTaishoTuchiHakkoDate", shisetuTaishoTuchiHakkoDate);
        this.setOriginalData("shisetsuHenkoTuchiHakkoDate", shisetsuHenkoTuchiHakkoDate);
        this.tekiyoJiyu = tekiyoJiyu;
        this.tekiyoDate = tekiyoDate;
        this.tekiyoTodokedeDate = tekiyoTodokedeDate;
        this.kaijoJiyu = kaijoJiyu;
        this.kaijoDate = kaijoDate;
        this.kaijoTodokedeDate = kaijoTodokedeDate;
        this.sochiHokenshaNo = sochiHokenshaNo;
        this.sochiHokenshaMeisho = sochiHokenshaMeisho;
        this.sochiHihokenshaNo = sochiHihokenshaNo;
        this.nyushoDate = nyushoDate;
        this.taishoDate = taishoDate;
        this.shisetsuShurui = shisetsuShurui;
        this.nyushoShisetsu = nyushoShisetsu;
        this.shisetsuCode = shisetsuCode;
        this.shisetsuMeisho = shisetsuMeisho;
        this.renrakuhyoHakkoDate = renrakuhyoHakkoDate;
        this.shisetuTaishoTuchiHakkoDate = shisetuTaishoTuchiHakkoDate;
        this.shisetsuHenkoTuchiHakkoDate = shisetsuHenkoTuchiHakkoDate;
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

    public RString getKaijoJiyu() {
        return kaijoJiyu;
    }

    public TextBoxFlexibleDate getKaijoDate() {
        return kaijoDate;
    }

    public TextBoxFlexibleDate getKaijoTodokedeDate() {
        return kaijoTodokedeDate;
    }

    public RString getSochiHokenshaNo() {
        return sochiHokenshaNo;
    }

    public RString getSochiHokenshaMeisho() {
        return sochiHokenshaMeisho;
    }

    public RString getSochiHihokenshaNo() {
        return sochiHihokenshaNo;
    }

    public TextBoxFlexibleDate getNyushoDate() {
        return nyushoDate;
    }

    public TextBoxFlexibleDate getTaishoDate() {
        return taishoDate;
    }

    public RString getShisetsuShurui() {
        return shisetsuShurui;
    }

    public RString getNyushoShisetsu() {
        return nyushoShisetsu;
    }

    public RString getShisetsuCode() {
        return shisetsuCode;
    }

    public RString getShisetsuMeisho() {
        return shisetsuMeisho;
    }

    public TextBoxFlexibleDate getRenrakuhyoHakkoDate() {
        return renrakuhyoHakkoDate;
    }

    public TextBoxFlexibleDate getShisetuTaishoTuchiHakkoDate() {
        return shisetuTaishoTuchiHakkoDate;
    }

    public TextBoxFlexibleDate getShisetsuHenkoTuchiHakkoDate() {
        return shisetsuHenkoTuchiHakkoDate;
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

    public void setSochiHokenshaNo(RString sochiHokenshaNo) {
        this.setOriginalData("sochiHokenshaNo", sochiHokenshaNo);
        this.sochiHokenshaNo = sochiHokenshaNo;
    }

    public void setSochiHokenshaMeisho(RString sochiHokenshaMeisho) {
        this.setOriginalData("sochiHokenshaMeisho", sochiHokenshaMeisho);
        this.sochiHokenshaMeisho = sochiHokenshaMeisho;
    }

    public void setSochiHihokenshaNo(RString sochiHihokenshaNo) {
        this.setOriginalData("sochiHihokenshaNo", sochiHihokenshaNo);
        this.sochiHihokenshaNo = sochiHihokenshaNo;
    }

    public void setNyushoDate(TextBoxFlexibleDate nyushoDate) {
        this.setOriginalData("nyushoDate", nyushoDate);
        this.nyushoDate = nyushoDate;
    }

    public void setTaishoDate(TextBoxFlexibleDate taishoDate) {
        this.setOriginalData("taishoDate", taishoDate);
        this.taishoDate = taishoDate;
    }

    public void setShisetsuShurui(RString shisetsuShurui) {
        this.setOriginalData("shisetsuShurui", shisetsuShurui);
        this.shisetsuShurui = shisetsuShurui;
    }

    public void setNyushoShisetsu(RString nyushoShisetsu) {
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.nyushoShisetsu = nyushoShisetsu;
    }

    public void setShisetsuCode(RString shisetsuCode) {
        this.setOriginalData("shisetsuCode", shisetsuCode);
        this.shisetsuCode = shisetsuCode;
    }

    public void setShisetsuMeisho(RString shisetsuMeisho) {
        this.setOriginalData("shisetsuMeisho", shisetsuMeisho);
        this.shisetsuMeisho = shisetsuMeisho;
    }

    public void setRenrakuhyoHakkoDate(TextBoxFlexibleDate renrakuhyoHakkoDate) {
        this.setOriginalData("renrakuhyoHakkoDate", renrakuhyoHakkoDate);
        this.renrakuhyoHakkoDate = renrakuhyoHakkoDate;
    }

    public void setShisetuTaishoTuchiHakkoDate(TextBoxFlexibleDate shisetuTaishoTuchiHakkoDate) {
        this.setOriginalData("shisetuTaishoTuchiHakkoDate", shisetuTaishoTuchiHakkoDate);
        this.shisetuTaishoTuchiHakkoDate = shisetuTaishoTuchiHakkoDate;
    }

    public void setShisetsuHenkoTuchiHakkoDate(TextBoxFlexibleDate shisetsuHenkoTuchiHakkoDate) {
        this.setOriginalData("shisetsuHenkoTuchiHakkoDate", shisetsuHenkoTuchiHakkoDate);
        this.shisetsuHenkoTuchiHakkoDate = shisetsuHenkoTuchiHakkoDate;
    }

}