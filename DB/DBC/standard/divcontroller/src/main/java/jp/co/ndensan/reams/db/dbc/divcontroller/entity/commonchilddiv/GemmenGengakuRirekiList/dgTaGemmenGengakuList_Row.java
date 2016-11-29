package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.GemmenGengakuRirekiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Nov 23 18:01:29 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;


/**
 * dgTaGemmenGengakuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTaGemmenGengakuList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">

    private RString gemmenGengakuShurui;
    private TextBoxFlexibleDate tekiyoKaishiYMD;
    private TextBoxFlexibleDate tekiyoShuryoYMD;
    private TextBox kyufuritsuKeigenritsuFutangaku;

    public dgTaGemmenGengakuList_Row() {
        super();
        this.gemmenGengakuShurui = RString.EMPTY;
        this.tekiyoKaishiYMD = new TextBoxFlexibleDate();
        this.tekiyoShuryoYMD = new TextBoxFlexibleDate();
        this.kyufuritsuKeigenritsuFutangaku = new TextBox();
        this.setOriginalData("gemmenGengakuShurui", gemmenGengakuShurui);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("kyufuritsuKeigenritsuFutangaku", kyufuritsuKeigenritsuFutangaku);
    }

    public dgTaGemmenGengakuList_Row(RString gemmenGengakuShurui, TextBoxFlexibleDate tekiyoKaishiYMD, TextBoxFlexibleDate tekiyoShuryoYMD, TextBox kyufuritsuKeigenritsuFutangaku) {
        super();
        this.setOriginalData("gemmenGengakuShurui", gemmenGengakuShurui);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("kyufuritsuKeigenritsuFutangaku", kyufuritsuKeigenritsuFutangaku);
        this.gemmenGengakuShurui = gemmenGengakuShurui;
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
        this.kyufuritsuKeigenritsuFutangaku = kyufuritsuKeigenritsuFutangaku;
    }

    public RString getGemmenGengakuShurui() {
        return gemmenGengakuShurui;
    }

    public TextBoxFlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    public TextBoxFlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    public TextBox getKyufuritsuKeigenritsuFutangaku() {
        return kyufuritsuKeigenritsuFutangaku;
    }

    public void setGemmenGengakuShurui(RString gemmenGengakuShurui) {
        this.setOriginalData("gemmenGengakuShurui", gemmenGengakuShurui);
        this.gemmenGengakuShurui = gemmenGengakuShurui;
    }

    public void setTekiyoKaishiYMD(TextBoxFlexibleDate tekiyoKaishiYMD) {
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    public void setTekiyoShuryoYMD(TextBoxFlexibleDate tekiyoShuryoYMD) {
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    public void setKyufuritsuKeigenritsuFutangaku(TextBox kyufuritsuKeigenritsuFutangaku) {
        this.setOriginalData("kyufuritsuKeigenritsuFutangaku", kyufuritsuKeigenritsuFutangaku);
        this.kyufuritsuKeigenritsuFutangaku = kyufuritsuKeigenritsuFutangaku;
    }

    // </editor-fold>
}
