package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 20 17:40:51 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;


/**
 * dgJushochiTokureiRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJushochiTokureiRireki_Row extends DataRow {

    private TextBoxDate tekiyoDate;
    private TextBoxDate tekiyoTodokedeDate;
    private RString tekiyoJiyu;
    private TextBoxDate kaijoDate;
    private TextBoxDate kaijoTodokedeDate;
    private RString kaijoJiyu;
    private RString sochiHokenshaMeisho;
    private TextBoxCode sochiHihokenshaNo;
    private TextBoxDate nyushoDate;
    private TextBoxDate taishoDate;
    private RString shisetsuShurui;
    private RString nyushoShisetsu;

    public dgJushochiTokureiRireki_Row() {
        super();
        this.tekiyoDate = new TextBoxDate();
        this.tekiyoTodokedeDate = new TextBoxDate();
        this.tekiyoJiyu = RString.EMPTY;
        this.kaijoDate = new TextBoxDate();
        this.kaijoTodokedeDate = new TextBoxDate();
        this.kaijoJiyu = RString.EMPTY;
        this.sochiHokenshaMeisho = RString.EMPTY;
        this.sochiHihokenshaNo = new TextBoxCode();
        this.nyushoDate = new TextBoxDate();
        this.taishoDate = new TextBoxDate();
        this.shisetsuShurui = RString.EMPTY;
        this.nyushoShisetsu = RString.EMPTY;
    }

    public dgJushochiTokureiRireki_Row(TextBoxDate tekiyoDate, TextBoxDate tekiyoTodokedeDate, RString tekiyoJiyu, TextBoxDate kaijoDate, TextBoxDate kaijoTodokedeDate, RString kaijoJiyu, RString sochiHokenshaMeisho, TextBoxCode sochiHihokenshaNo, TextBoxDate nyushoDate, TextBoxDate taishoDate, RString shisetsuShurui, RString nyushoShisetsu) {
        super();
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.setOriginalData("tekiyoTodokedeDate", tekiyoTodokedeDate);
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.setOriginalData("kaijoDate", kaijoDate);
        this.setOriginalData("kaijoTodokedeDate", kaijoTodokedeDate);
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.setOriginalData("sochiHokenshaMeisho", sochiHokenshaMeisho);
        this.setOriginalData("sochiHihokenshaNo", sochiHihokenshaNo);
        this.setOriginalData("nyushoDate", nyushoDate);
        this.setOriginalData("taishoDate", taishoDate);
        this.setOriginalData("shisetsuShurui", shisetsuShurui);
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.tekiyoDate = tekiyoDate;
        this.tekiyoTodokedeDate = tekiyoTodokedeDate;
        this.tekiyoJiyu = tekiyoJiyu;
        this.kaijoDate = kaijoDate;
        this.kaijoTodokedeDate = kaijoTodokedeDate;
        this.kaijoJiyu = kaijoJiyu;
        this.sochiHokenshaMeisho = sochiHokenshaMeisho;
        this.sochiHihokenshaNo = sochiHihokenshaNo;
        this.nyushoDate = nyushoDate;
        this.taishoDate = taishoDate;
        this.shisetsuShurui = shisetsuShurui;
        this.nyushoShisetsu = nyushoShisetsu;
    }

    public TextBoxDate getTekiyoDate() {
        return tekiyoDate;
    }

    public TextBoxDate getTekiyoTodokedeDate() {
        return tekiyoTodokedeDate;
    }

    public RString getTekiyoJiyu() {
        return tekiyoJiyu;
    }

    public TextBoxDate getKaijoDate() {
        return kaijoDate;
    }

    public TextBoxDate getKaijoTodokedeDate() {
        return kaijoTodokedeDate;
    }

    public RString getKaijoJiyu() {
        return kaijoJiyu;
    }

    public RString getSochiHokenshaMeisho() {
        return sochiHokenshaMeisho;
    }

    public TextBoxCode getSochiHihokenshaNo() {
        return sochiHihokenshaNo;
    }

    public TextBoxDate getNyushoDate() {
        return nyushoDate;
    }

    public TextBoxDate getTaishoDate() {
        return taishoDate;
    }

    public RString getShisetsuShurui() {
        return shisetsuShurui;
    }

    public RString getNyushoShisetsu() {
        return nyushoShisetsu;
    }

    public void setTekiyoDate(TextBoxDate tekiyoDate) {
        this.setOriginalData("tekiyoDate", tekiyoDate);
        this.tekiyoDate = tekiyoDate;
    }

    public void setTekiyoTodokedeDate(TextBoxDate tekiyoTodokedeDate) {
        this.setOriginalData("tekiyoTodokedeDate", tekiyoTodokedeDate);
        this.tekiyoTodokedeDate = tekiyoTodokedeDate;
    }

    public void setTekiyoJiyu(RString tekiyoJiyu) {
        this.setOriginalData("tekiyoJiyu", tekiyoJiyu);
        this.tekiyoJiyu = tekiyoJiyu;
    }

    public void setKaijoDate(TextBoxDate kaijoDate) {
        this.setOriginalData("kaijoDate", kaijoDate);
        this.kaijoDate = kaijoDate;
    }

    public void setKaijoTodokedeDate(TextBoxDate kaijoTodokedeDate) {
        this.setOriginalData("kaijoTodokedeDate", kaijoTodokedeDate);
        this.kaijoTodokedeDate = kaijoTodokedeDate;
    }

    public void setKaijoJiyu(RString kaijoJiyu) {
        this.setOriginalData("kaijoJiyu", kaijoJiyu);
        this.kaijoJiyu = kaijoJiyu;
    }

    public void setSochiHokenshaMeisho(RString sochiHokenshaMeisho) {
        this.setOriginalData("sochiHokenshaMeisho", sochiHokenshaMeisho);
        this.sochiHokenshaMeisho = sochiHokenshaMeisho;
    }

    public void setSochiHihokenshaNo(TextBoxCode sochiHihokenshaNo) {
        this.setOriginalData("sochiHihokenshaNo", sochiHihokenshaNo);
        this.sochiHihokenshaNo = sochiHihokenshaNo;
    }

    public void setNyushoDate(TextBoxDate nyushoDate) {
        this.setOriginalData("nyushoDate", nyushoDate);
        this.nyushoDate = nyushoDate;
    }

    public void setTaishoDate(TextBoxDate taishoDate) {
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

}