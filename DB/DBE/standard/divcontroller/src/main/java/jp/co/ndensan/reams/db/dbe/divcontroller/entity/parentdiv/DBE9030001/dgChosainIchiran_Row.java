package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Dec 29 17:19:58 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgChosainIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosainIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString jotai;
    private RString shichoson;
    private TextBoxCode chosaItakusakiCode;
    private RString jigyoshaNo;
    private RString chosaItakusakiMeisho;
    private RString chosaItakusakiKana;
    private RString yubinNo;
    private RString jusho;
    private RString telNo;
    private RString faxNo;
    private RString kikanDaihyoshaName;
    private RString kikanDaihyoshaKanaName;
    private RString chosaItakuKubun;
    private RString tokuteiChosainDispFlag;
    private TextBoxNum waritsukeTeiin;
    private RString chiku;
    private RString autoWaritsukeFlag;
    private RString kikanKubun;
    private RString jokyoFlag;

    public dgChosainIchiran_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.shichoson = RString.EMPTY;
        this.chosaItakusakiCode = new TextBoxCode();
        this.jigyoshaNo = RString.EMPTY;
        this.chosaItakusakiMeisho = RString.EMPTY;
        this.chosaItakusakiKana = RString.EMPTY;
        this.yubinNo = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.telNo = RString.EMPTY;
        this.faxNo = RString.EMPTY;
        this.kikanDaihyoshaName = RString.EMPTY;
        this.kikanDaihyoshaKanaName = RString.EMPTY;
        this.chosaItakuKubun = RString.EMPTY;
        this.tokuteiChosainDispFlag = RString.EMPTY;
        this.waritsukeTeiin = new TextBoxNum();
        this.chiku = RString.EMPTY;
        this.autoWaritsukeFlag = RString.EMPTY;
        this.kikanKubun = RString.EMPTY;
        this.jokyoFlag = RString.EMPTY;
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("shichoson", shichoson);
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("chosaItakusakiMeisho", chosaItakusakiMeisho);
        this.setOriginalData("chosaItakusakiKana", chosaItakusakiKana);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("telNo", telNo);
        this.setOriginalData("faxNo", faxNo);
        this.setOriginalData("kikanDaihyoshaName", kikanDaihyoshaName);
        this.setOriginalData("kikanDaihyoshaKanaName", kikanDaihyoshaKanaName);
        this.setOriginalData("chosaItakuKubun", chosaItakuKubun);
        this.setOriginalData("tokuteiChosainDispFlag", tokuteiChosainDispFlag);
        this.setOriginalData("waritsukeTeiin", waritsukeTeiin);
        this.setOriginalData("chiku", chiku);
        this.setOriginalData("autoWaritsukeFlag", autoWaritsukeFlag);
        this.setOriginalData("kikanKubun", kikanKubun);
        this.setOriginalData("jokyoFlag", jokyoFlag);
    }

    public dgChosainIchiran_Row(RString jotai, RString shichoson, TextBoxCode chosaItakusakiCode, RString jigyoshaNo, RString chosaItakusakiMeisho, RString chosaItakusakiKana, RString yubinNo, RString jusho, RString telNo, RString faxNo, RString kikanDaihyoshaName, RString kikanDaihyoshaKanaName, RString chosaItakuKubun, RString tokuteiChosainDispFlag, TextBoxNum waritsukeTeiin, RString chiku, RString autoWaritsukeFlag, RString kikanKubun, RString jokyoFlag) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("shichoson", shichoson);
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("chosaItakusakiMeisho", chosaItakusakiMeisho);
        this.setOriginalData("chosaItakusakiKana", chosaItakusakiKana);
        this.setOriginalData("yubinNo", yubinNo);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("telNo", telNo);
        this.setOriginalData("faxNo", faxNo);
        this.setOriginalData("kikanDaihyoshaName", kikanDaihyoshaName);
        this.setOriginalData("kikanDaihyoshaKanaName", kikanDaihyoshaKanaName);
        this.setOriginalData("chosaItakuKubun", chosaItakuKubun);
        this.setOriginalData("tokuteiChosainDispFlag", tokuteiChosainDispFlag);
        this.setOriginalData("waritsukeTeiin", waritsukeTeiin);
        this.setOriginalData("chiku", chiku);
        this.setOriginalData("autoWaritsukeFlag", autoWaritsukeFlag);
        this.setOriginalData("kikanKubun", kikanKubun);
        this.setOriginalData("jokyoFlag", jokyoFlag);
        this.jotai = jotai;
        this.shichoson = shichoson;
        this.chosaItakusakiCode = chosaItakusakiCode;
        this.jigyoshaNo = jigyoshaNo;
        this.chosaItakusakiMeisho = chosaItakusakiMeisho;
        this.chosaItakusakiKana = chosaItakusakiKana;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.telNo = telNo;
        this.faxNo = faxNo;
        this.kikanDaihyoshaName = kikanDaihyoshaName;
        this.kikanDaihyoshaKanaName = kikanDaihyoshaKanaName;
        this.chosaItakuKubun = chosaItakuKubun;
        this.tokuteiChosainDispFlag = tokuteiChosainDispFlag;
        this.waritsukeTeiin = waritsukeTeiin;
        this.chiku = chiku;
        this.autoWaritsukeFlag = autoWaritsukeFlag;
        this.kikanKubun = kikanKubun;
        this.jokyoFlag = jokyoFlag;
    }

    public RString getJotai() {
        return jotai;
    }

    public RString getShichoson() {
        return shichoson;
    }

    public TextBoxCode getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    public RString getChosaItakusakiMeisho() {
        return chosaItakusakiMeisho;
    }

    public RString getChosaItakusakiKana() {
        return chosaItakusakiKana;
    }

    public RString getYubinNo() {
        return yubinNo;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getTelNo() {
        return telNo;
    }

    public RString getFaxNo() {
        return faxNo;
    }

    public RString getKikanDaihyoshaName() {
        return kikanDaihyoshaName;
    }

    public RString getKikanDaihyoshaKanaName() {
        return kikanDaihyoshaKanaName;
    }

    public RString getChosaItakuKubun() {
        return chosaItakuKubun;
    }

    public RString getTokuteiChosainDispFlag() {
        return tokuteiChosainDispFlag;
    }

    public TextBoxNum getWaritsukeTeiin() {
        return waritsukeTeiin;
    }

    public RString getChiku() {
        return chiku;
    }

    public RString getAutoWaritsukeFlag() {
        return autoWaritsukeFlag;
    }

    public RString getKikanKubun() {
        return kikanKubun;
    }

    public RString getJokyoFlag() {
        return jokyoFlag;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setShichoson(RString shichoson) {
        this.setOriginalData("shichoson", shichoson);
        this.shichoson = shichoson;
    }

    public void setChosaItakusakiCode(TextBoxCode chosaItakusakiCode) {
        this.setOriginalData("chosaItakusakiCode", chosaItakusakiCode);
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    public void setJigyoshaNo(RString jigyoshaNo) {
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.jigyoshaNo = jigyoshaNo;
    }

    public void setChosaItakusakiMeisho(RString chosaItakusakiMeisho) {
        this.setOriginalData("chosaItakusakiMeisho", chosaItakusakiMeisho);
        this.chosaItakusakiMeisho = chosaItakusakiMeisho;
    }

    public void setChosaItakusakiKana(RString chosaItakusakiKana) {
        this.setOriginalData("chosaItakusakiKana", chosaItakusakiKana);
        this.chosaItakusakiKana = chosaItakusakiKana;
    }

    public void setYubinNo(RString yubinNo) {
        this.setOriginalData("yubinNo", yubinNo);
        this.yubinNo = yubinNo;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setTelNo(RString telNo) {
        this.setOriginalData("telNo", telNo);
        this.telNo = telNo;
    }

    public void setFaxNo(RString faxNo) {
        this.setOriginalData("faxNo", faxNo);
        this.faxNo = faxNo;
    }

    public void setKikanDaihyoshaName(RString kikanDaihyoshaName) {
        this.setOriginalData("kikanDaihyoshaName", kikanDaihyoshaName);
        this.kikanDaihyoshaName = kikanDaihyoshaName;
    }

    public void setKikanDaihyoshaKanaName(RString kikanDaihyoshaKanaName) {
        this.setOriginalData("kikanDaihyoshaKanaName", kikanDaihyoshaKanaName);
        this.kikanDaihyoshaKanaName = kikanDaihyoshaKanaName;
    }

    public void setChosaItakuKubun(RString chosaItakuKubun) {
        this.setOriginalData("chosaItakuKubun", chosaItakuKubun);
        this.chosaItakuKubun = chosaItakuKubun;
    }

    public void setTokuteiChosainDispFlag(RString tokuteiChosainDispFlag) {
        this.setOriginalData("tokuteiChosainDispFlag", tokuteiChosainDispFlag);
        this.tokuteiChosainDispFlag = tokuteiChosainDispFlag;
    }

    public void setWaritsukeTeiin(TextBoxNum waritsukeTeiin) {
        this.setOriginalData("waritsukeTeiin", waritsukeTeiin);
        this.waritsukeTeiin = waritsukeTeiin;
    }

    public void setChiku(RString chiku) {
        this.setOriginalData("chiku", chiku);
        this.chiku = chiku;
    }

    public void setAutoWaritsukeFlag(RString autoWaritsukeFlag) {
        this.setOriginalData("autoWaritsukeFlag", autoWaritsukeFlag);
        this.autoWaritsukeFlag = autoWaritsukeFlag;
    }

    public void setKikanKubun(RString kikanKubun) {
        this.setOriginalData("kikanKubun", kikanKubun);
        this.kikanKubun = kikanKubun;
    }

    public void setJokyoFlag(RString jokyoFlag) {
        this.setOriginalData("jokyoFlag", jokyoFlag);
        this.jokyoFlag = jokyoFlag;
    }

    // </editor-fold>
}
