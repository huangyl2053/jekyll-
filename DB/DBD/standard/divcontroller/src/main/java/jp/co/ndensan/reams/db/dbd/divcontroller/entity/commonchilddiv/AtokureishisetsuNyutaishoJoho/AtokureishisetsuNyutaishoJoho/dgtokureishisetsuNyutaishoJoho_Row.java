package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.AtokureishisetsuNyutaishoJoho.AtokureishisetsuNyutaishoJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Apr 28 10:48:19 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgtokureishisetsuNyutaishoJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgtokureishisetsuNyutaishoJoho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private TextBoxFlexibleDate nyushoDate;
    private TextBoxFlexibleDate taishoDate;
    private RString nyushoShisetsuName;
    private RString nyushoShisetsuCode;
    private RString tenshutsusakiHokenshaNo;

    public dgtokureishisetsuNyutaishoJoho_Row() {
        super();
        this.nyushoDate = new TextBoxFlexibleDate();
        this.taishoDate = new TextBoxFlexibleDate();
        this.nyushoShisetsuName = RString.EMPTY;
        this.nyushoShisetsuCode = RString.EMPTY;
        this.tenshutsusakiHokenshaNo = RString.EMPTY;
        this.setOriginalData("nyushoDate", nyushoDate);
        this.setOriginalData("taishoDate", taishoDate);
        this.setOriginalData("nyushoShisetsuName", nyushoShisetsuName);
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.setOriginalData("tenshutsusakiHokenshaNo", tenshutsusakiHokenshaNo);
    }

    public dgtokureishisetsuNyutaishoJoho_Row(TextBoxFlexibleDate nyushoDate, TextBoxFlexibleDate taishoDate, RString nyushoShisetsuName, RString nyushoShisetsuCode, RString tenshutsusakiHokenshaNo) {
        super();
        this.setOriginalData("nyushoDate", nyushoDate);
        this.setOriginalData("taishoDate", taishoDate);
        this.setOriginalData("nyushoShisetsuName", nyushoShisetsuName);
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.setOriginalData("tenshutsusakiHokenshaNo", tenshutsusakiHokenshaNo);
        this.nyushoDate = nyushoDate;
        this.taishoDate = taishoDate;
        this.nyushoShisetsuName = nyushoShisetsuName;
        this.nyushoShisetsuCode = nyushoShisetsuCode;
        this.tenshutsusakiHokenshaNo = tenshutsusakiHokenshaNo;
    }

    public TextBoxFlexibleDate getNyushoDate() {
        return nyushoDate;
    }

    public TextBoxFlexibleDate getTaishoDate() {
        return taishoDate;
    }

    public RString getNyushoShisetsuName() {
        return nyushoShisetsuName;
    }

    public RString getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    public RString getTenshutsusakiHokenshaNo() {
        return tenshutsusakiHokenshaNo;
    }

    public void setNyushoDate(TextBoxFlexibleDate nyushoDate) {
        this.setOriginalData("nyushoDate", nyushoDate);
        this.nyushoDate = nyushoDate;
    }

    public void setTaishoDate(TextBoxFlexibleDate taishoDate) {
        this.setOriginalData("taishoDate", taishoDate);
        this.taishoDate = taishoDate;
    }

    public void setNyushoShisetsuName(RString nyushoShisetsuName) {
        this.setOriginalData("nyushoShisetsuName", nyushoShisetsuName);
        this.nyushoShisetsuName = nyushoShisetsuName;
    }

    public void setNyushoShisetsuCode(RString nyushoShisetsuCode) {
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    public void setTenshutsusakiHokenshaNo(RString tenshutsusakiHokenshaNo) {
        this.setOriginalData("tenshutsusakiHokenshaNo", tenshutsusakiHokenshaNo);
        this.tenshutsusakiHokenshaNo = tenshutsusakiHokenshaNo;
    }

    // </editor-fold>
}
