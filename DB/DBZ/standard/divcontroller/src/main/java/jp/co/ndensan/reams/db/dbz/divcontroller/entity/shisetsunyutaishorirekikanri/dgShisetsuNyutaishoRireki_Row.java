package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 06 21:05:10 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShisetsuNyutaishoRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShisetsuNyutaishoRireki_Row extends DataRow {

    private TextBoxFlexibleDate nyushoDate;
    private TextBoxFlexibleDate taishoDate;
    private RString shisetsuCode;
    private RString shisetsuMeisho;
    private RString shisetsu;
    private RString taishoJohoKey;
    private RString taishoJoho;
    private RString shisetsuShuruiKey;
    private RString shisetsuShurui;

    public dgShisetsuNyutaishoRireki_Row() {
        super();
    }

    public dgShisetsuNyutaishoRireki_Row(TextBoxFlexibleDate nyushoDate, TextBoxFlexibleDate taishoDate, RString shisetsuCode, RString shisetsuMeisho, RString shisetsu, RString taishoJohoKey, RString taishoJoho, RString shisetsuShuruiKey, RString shisetsuShurui) {
        super();
        this.setOriginalData("nyushoDate", nyushoDate);
        this.setOriginalData("taishoDate", taishoDate);
        this.setOriginalData("shisetsuCode", shisetsuCode);
        this.setOriginalData("shisetsuMeisho", shisetsuMeisho);
        this.setOriginalData("shisetsu", shisetsu);
        this.setOriginalData("taishoJohoKey", taishoJohoKey);
        this.setOriginalData("taishoJoho", taishoJoho);
        this.setOriginalData("shisetsuShuruiKey", shisetsuShuruiKey);
        this.setOriginalData("shisetsuShurui", shisetsuShurui);
        this.nyushoDate = nyushoDate;
        this.taishoDate = taishoDate;
        this.shisetsuCode = shisetsuCode;
        this.shisetsuMeisho = shisetsuMeisho;
        this.shisetsu = shisetsu;
        this.taishoJohoKey = taishoJohoKey;
        this.taishoJoho = taishoJoho;
        this.shisetsuShuruiKey = shisetsuShuruiKey;
        this.shisetsuShurui = shisetsuShurui;
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

    public RString getTaishoJohoKey() {
        return taishoJohoKey;
    }

    public RString getTaishoJoho() {
        return taishoJoho;
    }

    public RString getShisetsuShuruiKey() {
        return shisetsuShuruiKey;
    }

    public RString getShisetsuShurui() {
        return shisetsuShurui;
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

    public void setTaishoJohoKey(RString taishoJohoKey) {
        this.setOriginalData("taishoJohoKey", taishoJohoKey);
        this.taishoJohoKey = taishoJohoKey;
    }

    public void setTaishoJoho(RString taishoJoho) {
        this.setOriginalData("taishoJoho", taishoJoho);
        this.taishoJoho = taishoJoho;
    }

    public void setShisetsuShuruiKey(RString shisetsuShuruiKey) {
        this.setOriginalData("shisetsuShuruiKey", shisetsuShuruiKey);
        this.shisetsuShuruiKey = shisetsuShuruiKey;
    }

    public void setShisetsuShurui(RString shisetsuShurui) {
        this.setOriginalData("shisetsuShurui", shisetsuShurui);
        this.shisetsuShurui = shisetsuShurui;
    }

}