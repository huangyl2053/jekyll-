package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 22 11:18:26 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgChosaItakusakiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosaItakusakiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">

    private TextBoxCode chosaItakusakiCode;
    private RString chosaItakusakiMeisho;
    private RString chosaChiku;
    private TextBoxNum waritsukeTeiin;
    private TextBoxNum waritsukeZumi;
    private RString chosaItakusakiJusho;
    private RString chosaItakusakiTelNo;
    private RString chosaItakusakiKubun;
    private RString hokenshaCode;
    private RString hokenshaName;

    public dgChosaItakusakiIchiran_Row() {
        super();
        this.chosaItakusakiCode = new TextBoxCode();
        this.chosaItakusakiMeisho = RString.EMPTY;
        this.chosaChiku = RString.EMPTY;
        this.waritsukeTeiin = new TextBoxNum();
        this.waritsukeZumi = new TextBoxNum();
        this.chosaItakusakiJusho = RString.EMPTY;
        this.chosaItakusakiTelNo = RString.EMPTY;
        this.chosaItakusakiKubun = RString.EMPTY;
        this.hokenshaCode = RString.EMPTY;
        this.hokenshaName = RString.EMPTY;
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.setOriginalData("chosaItakusakiMeisho", chosaItakusakiMeisho);
        this.setOriginalData("chosaChiku", chosaChiku);
        this.setOriginalData("waritsukeTeiin", waritsukeTeiin);
        this.setOriginalData("waritsukeZumi", waritsukeZumi);
        this.setOriginalData("chosaItakusakiJusho", chosaItakusakiJusho);
        this.setOriginalData("chosaItakusakiTelNo", chosaItakusakiTelNo);
        this.setOriginalData("chosaItakusakiKubun", chosaItakusakiKubun);
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.setOriginalData("hokenshaName", hokenshaName);
    }

    public dgChosaItakusakiIchiran_Row(TextBoxCode chosaItakusakiCode, RString chosaItakusakiMeisho, RString chosaChiku, TextBoxNum waritsukeTeiin, TextBoxNum waritsukeZumi, RString chosaItakusakiJusho, RString chosaItakusakiTelNo, RString chosaItakusakiKubun, RString hokenshaCode, RString hokenshaName) {
        super();
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.setOriginalData("chosaItakusakiMeisho", chosaItakusakiMeisho);
        this.setOriginalData("chosaChiku", chosaChiku);
        this.setOriginalData("waritsukeTeiin", waritsukeTeiin);
        this.setOriginalData("waritsukeZumi", waritsukeZumi);
        this.setOriginalData("chosaItakusakiJusho", chosaItakusakiJusho);
        this.setOriginalData("chosaItakusakiTelNo", chosaItakusakiTelNo);
        this.setOriginalData("chosaItakusakiKubun", chosaItakusakiKubun);
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.chosaItakusakiCode = chosaItakusakiCode;
        this.chosaItakusakiMeisho = chosaItakusakiMeisho;
        this.chosaChiku = chosaChiku;
        this.waritsukeTeiin = waritsukeTeiin;
        this.waritsukeZumi = waritsukeZumi;
        this.chosaItakusakiJusho = chosaItakusakiJusho;
        this.chosaItakusakiTelNo = chosaItakusakiTelNo;
        this.chosaItakusakiKubun = chosaItakusakiKubun;
        this.hokenshaCode = hokenshaCode;
        this.hokenshaName = hokenshaName;
    }

    public TextBoxCode getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    public RString getChosaItakusakiMeisho() {
        return chosaItakusakiMeisho;
    }

    public RString getChosaChiku() {
        return chosaChiku;
    }

    public TextBoxNum getWaritsukeTeiin() {
        return waritsukeTeiin;
    }

    public TextBoxNum getWaritsukeZumi() {
        return waritsukeZumi;
    }

    public RString getChosaItakusakiJusho() {
        return chosaItakusakiJusho;
    }

    public RString getChosaItakusakiTelNo() {
        return chosaItakusakiTelNo;
    }

    public RString getChosaItakusakiKubun() {
        return chosaItakusakiKubun;
    }

    public RString getHokenshaCode() {
        return hokenshaCode;
    }

    public RString getHokenshaName() {
        return hokenshaName;
    }

    public void setChosaItakusakiCode(TextBoxCode chosaItakusakiCode) {
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    public void setChosaItakusakiMeisho(RString chosaItakusakiMeisho) {
        this.setOriginalData("chosaItakusakiMeisho", chosaItakusakiMeisho);
        this.chosaItakusakiMeisho = chosaItakusakiMeisho;
    }

    public void setChosaChiku(RString chosaChiku) {
        this.setOriginalData("chosaChiku", chosaChiku);
        this.chosaChiku = chosaChiku;
    }

    public void setWaritsukeTeiin(TextBoxNum waritsukeTeiin) {
        this.setOriginalData("waritsukeTeiin", waritsukeTeiin);
        this.waritsukeTeiin = waritsukeTeiin;
    }

    public void setWaritsukeZumi(TextBoxNum waritsukeZumi) {
        this.setOriginalData("waritsukeZumi", waritsukeZumi);
        this.waritsukeZumi = waritsukeZumi;
    }

    public void setChosaItakusakiJusho(RString chosaItakusakiJusho) {
        this.setOriginalData("chosaItakusakiJusho", chosaItakusakiJusho);
        this.chosaItakusakiJusho = chosaItakusakiJusho;
    }

    public void setChosaItakusakiTelNo(RString chosaItakusakiTelNo) {
        this.setOriginalData("chosaItakusakiTelNo", chosaItakusakiTelNo);
        this.chosaItakusakiTelNo = chosaItakusakiTelNo;
    }

    public void setChosaItakusakiKubun(RString chosaItakusakiKubun) {
        this.setOriginalData("chosaItakusakiKubun", chosaItakusakiKubun);
        this.chosaItakusakiKubun = chosaItakusakiKubun;
    }

    public void setHokenshaCode(RString hokenshaCode) {
        this.setOriginalData("hokenshaCode", hokenshaCode);
        this.hokenshaCode = hokenshaCode;
    }

    public void setHokenshaName(RString hokenshaName) {
        this.setOriginalData("hokenshaName", hokenshaName);
        this.hokenshaName = hokenshaName;
    }

    // </editor-fold>
}
