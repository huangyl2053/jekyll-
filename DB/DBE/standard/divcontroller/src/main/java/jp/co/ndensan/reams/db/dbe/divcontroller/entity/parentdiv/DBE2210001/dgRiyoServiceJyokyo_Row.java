package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Feb 06 11:35:14 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgRiyoServiceJyokyo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRiyoServiceJyokyo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-19_22-43-59">

    private TextBox serviceMeisho;
    private TextBoxNum serviceJokyo;
    private RString tani;
    private TextBoxNum remban;

    public dgRiyoServiceJyokyo_Row() {
        super();
        this.serviceMeisho = new TextBox();
        this.serviceJokyo = new TextBoxNum();
        this.tani = RString.EMPTY;
        this.remban = new TextBoxNum();
        this.setOriginalData("serviceMeisho", serviceMeisho);
        this.setOriginalData("serviceJokyo", serviceJokyo);
        this.setOriginalData("tani", tani);
        this.setOriginalData("remban", remban);
    }

    public dgRiyoServiceJyokyo_Row(TextBox serviceMeisho, TextBoxNum serviceJokyo, RString tani, TextBoxNum remban) {
        super();
        this.setOriginalData("serviceMeisho", serviceMeisho);
        this.setOriginalData("serviceJokyo", serviceJokyo);
        this.setOriginalData("tani", tani);
        this.setOriginalData("remban", remban);
        this.serviceMeisho = serviceMeisho;
        this.serviceJokyo = serviceJokyo;
        this.tani = tani;
        this.remban = remban;
    }

    public TextBox getServiceMeisho() {
        return serviceMeisho;
    }

    public TextBoxNum getServiceJokyo() {
        return serviceJokyo;
    }

    public RString getTani() {
        return tani;
    }

    public TextBoxNum getRemban() {
        return remban;
    }

    public void setServiceMeisho(TextBox serviceMeisho) {
        this.setOriginalData("serviceMeisho", serviceMeisho);
        this.serviceMeisho = serviceMeisho;
    }

    public void setServiceJokyo(TextBoxNum serviceJokyo) {
        this.setOriginalData("serviceJokyo", serviceJokyo);
        this.serviceJokyo = serviceJokyo;
    }

    public void setTani(RString tani) {
        this.setOriginalData("tani", tani);
        this.tani = tani;
    }

    public void setRemban(TextBoxNum remban) {
        this.setOriginalData("remban", remban);
        this.remban = remban;
    }

    // </editor-fold>
}
