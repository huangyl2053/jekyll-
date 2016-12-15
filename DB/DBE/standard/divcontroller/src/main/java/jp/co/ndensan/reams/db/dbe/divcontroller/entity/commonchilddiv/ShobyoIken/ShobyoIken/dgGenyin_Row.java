package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 15 19:26:39 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgGenyin_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgGenyin_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">

    private RString jotai;
    private TextBoxCode geninShikkanCode;
    private RString meiSho;
    private Boolean isShutaruGeninShikkan;
    private TextBoxNum renBan;

    public dgGenyin_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.geninShikkanCode = new TextBoxCode();
        this.meiSho = RString.EMPTY;
        this.isShutaruGeninShikkan = false;
        this.renBan = new TextBoxNum();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("geninShikkanCode", geninShikkanCode);
        this.setOriginalData("meiSho", meiSho);
        this.setOriginalData("isShutaruGeninShikkan", isShutaruGeninShikkan);
        this.setOriginalData("renBan", renBan);
    }

    public dgGenyin_Row(RString jotai, TextBoxCode geninShikkanCode, RString meiSho, Boolean isShutaruGeninShikkan, TextBoxNum renBan) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("geninShikkanCode", geninShikkanCode);
        this.setOriginalData("meiSho", meiSho);
        this.setOriginalData("isShutaruGeninShikkan", isShutaruGeninShikkan);
        this.setOriginalData("renBan", renBan);
        this.jotai = jotai;
        this.geninShikkanCode = geninShikkanCode;
        this.meiSho = meiSho;
        this.isShutaruGeninShikkan = isShutaruGeninShikkan;
        this.renBan = renBan;
    }

    public RString getJotai() {
        return jotai;
    }

    public TextBoxCode getGeninShikkanCode() {
        return geninShikkanCode;
    }

    public RString getMeiSho() {
        return meiSho;
    }

    public Boolean getIsShutaruGeninShikkan() {
        return isShutaruGeninShikkan;
    }

    public TextBoxNum getRenBan() {
        return renBan;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setGeninShikkanCode(TextBoxCode geninShikkanCode) {
        this.setOriginalData("geninShikkanCode", geninShikkanCode);
        this.geninShikkanCode = geninShikkanCode;
    }

    public void setMeiSho(RString meiSho) {
        this.setOriginalData("meiSho", meiSho);
        this.meiSho = meiSho;
    }

    public void setIsShutaruGeninShikkan(Boolean isShutaruGeninShikkan) {
        this.setOriginalData("isShutaruGeninShikkan", isShutaruGeninShikkan);
        this.isShutaruGeninShikkan = isShutaruGeninShikkan;
    }

    public void setRenBan(TextBoxNum renBan) {
        this.setOriginalData("renBan", renBan);
        this.renBan = renBan;
    }

    // </editor-fold>
}
