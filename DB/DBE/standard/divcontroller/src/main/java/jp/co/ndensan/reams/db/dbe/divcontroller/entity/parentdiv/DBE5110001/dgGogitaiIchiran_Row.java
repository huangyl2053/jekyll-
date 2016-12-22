package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 22 12:51:39 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;


/**
 * dgGogitaiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgGogitaiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">

    private RString jyotai;
    private TextBoxNum gogitaiNumber;
    private RString gogitaiName;
    private TextBoxDate yukoKaishiYMD;
    private TextBoxDate yukoShuryoYMD;
    private TextBoxTime gogitaiKaishiYoteiTime;
    private TextBoxTime gogitaiShuryoYoteiTime;
    private RString kaisaiBashoCode;
    private RString kaisaiBasho;
    private Boolean seishinkaiSonzai;
    private Boolean gogitaiDummyFlag;
    private TextBoxNum yoteiTeiin;
    private TextBoxNum jidoWariateTeiin;
    private TextBoxNum iinTeiin;

    public dgGogitaiIchiran_Row() {
        super();
        this.jyotai = RString.EMPTY;
        this.gogitaiNumber = new TextBoxNum();
        this.gogitaiName = RString.EMPTY;
        this.yukoKaishiYMD = new TextBoxDate();
        this.yukoShuryoYMD = new TextBoxDate();
        this.gogitaiKaishiYoteiTime = new TextBoxTime();
        this.gogitaiShuryoYoteiTime = new TextBoxTime();
        this.kaisaiBashoCode = RString.EMPTY;
        this.kaisaiBasho = RString.EMPTY;
        this.seishinkaiSonzai = false;
        this.gogitaiDummyFlag = false;
        this.yoteiTeiin = new TextBoxNum();
        this.jidoWariateTeiin = new TextBoxNum();
        this.iinTeiin = new TextBoxNum();
        this.setOriginalData("jyotai", jyotai);
        this.setOriginalData("gogitaiNumber", gogitaiNumber);
        this.setOriginalData("gogitaiName", gogitaiName);
        this.setOriginalData("yukoKaishiYMD", yukoKaishiYMD);
        this.setOriginalData("yukoShuryoYMD", yukoShuryoYMD);
        this.setOriginalData("gogitaiKaishiYoteiTime", gogitaiKaishiYoteiTime);
        this.setOriginalData("gogitaiShuryoYoteiTime", gogitaiShuryoYoteiTime);
        this.setOriginalData("kaisaiBashoCode", kaisaiBashoCode);
        this.setOriginalData("kaisaiBasho", kaisaiBasho);
        this.setOriginalData("seishinkaiSonzai", seishinkaiSonzai);
        this.setOriginalData("gogitaiDummyFlag", gogitaiDummyFlag);
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.setOriginalData("jidoWariateTeiin", jidoWariateTeiin);
        this.setOriginalData("iinTeiin", iinTeiin);
    }

    public dgGogitaiIchiran_Row(RString jyotai, TextBoxNum gogitaiNumber, RString gogitaiName, TextBoxDate yukoKaishiYMD, TextBoxDate yukoShuryoYMD, TextBoxTime gogitaiKaishiYoteiTime, TextBoxTime gogitaiShuryoYoteiTime, RString kaisaiBashoCode, RString kaisaiBasho, Boolean seishinkaiSonzai, Boolean gogitaiDummyFlag, TextBoxNum yoteiTeiin, TextBoxNum jidoWariateTeiin, TextBoxNum iinTeiin) {
        super();
        this.setOriginalData("jyotai", jyotai);
        this.setOriginalData("gogitaiNumber", gogitaiNumber);
        this.setOriginalData("gogitaiName", gogitaiName);
        this.setOriginalData("yukoKaishiYMD", yukoKaishiYMD);
        this.setOriginalData("yukoShuryoYMD", yukoShuryoYMD);
        this.setOriginalData("gogitaiKaishiYoteiTime", gogitaiKaishiYoteiTime);
        this.setOriginalData("gogitaiShuryoYoteiTime", gogitaiShuryoYoteiTime);
        this.setOriginalData("kaisaiBashoCode", kaisaiBashoCode);
        this.setOriginalData("kaisaiBasho", kaisaiBasho);
        this.setOriginalData("seishinkaiSonzai", seishinkaiSonzai);
        this.setOriginalData("gogitaiDummyFlag", gogitaiDummyFlag);
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.setOriginalData("jidoWariateTeiin", jidoWariateTeiin);
        this.setOriginalData("iinTeiin", iinTeiin);
        this.jyotai = jyotai;
        this.gogitaiNumber = gogitaiNumber;
        this.gogitaiName = gogitaiName;
        this.yukoKaishiYMD = yukoKaishiYMD;
        this.yukoShuryoYMD = yukoShuryoYMD;
        this.gogitaiKaishiYoteiTime = gogitaiKaishiYoteiTime;
        this.gogitaiShuryoYoteiTime = gogitaiShuryoYoteiTime;
        this.kaisaiBashoCode = kaisaiBashoCode;
        this.kaisaiBasho = kaisaiBasho;
        this.seishinkaiSonzai = seishinkaiSonzai;
        this.gogitaiDummyFlag = gogitaiDummyFlag;
        this.yoteiTeiin = yoteiTeiin;
        this.jidoWariateTeiin = jidoWariateTeiin;
        this.iinTeiin = iinTeiin;
    }

    public RString getJyotai() {
        return jyotai;
    }

    public TextBoxNum getGogitaiNumber() {
        return gogitaiNumber;
    }

    public RString getGogitaiName() {
        return gogitaiName;
    }

    public TextBoxDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    public TextBoxDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    public TextBoxTime getGogitaiKaishiYoteiTime() {
        return gogitaiKaishiYoteiTime;
    }

    public TextBoxTime getGogitaiShuryoYoteiTime() {
        return gogitaiShuryoYoteiTime;
    }

    public RString getKaisaiBashoCode() {
        return kaisaiBashoCode;
    }

    public RString getKaisaiBasho() {
        return kaisaiBasho;
    }

    public Boolean getSeishinkaiSonzai() {
        return seishinkaiSonzai;
    }

    public Boolean getGogitaiDummyFlag() {
        return gogitaiDummyFlag;
    }

    public TextBoxNum getYoteiTeiin() {
        return yoteiTeiin;
    }

    public TextBoxNum getJidoWariateTeiin() {
        return jidoWariateTeiin;
    }

    public TextBoxNum getIinTeiin() {
        return iinTeiin;
    }

    public void setJyotai(RString jyotai) {
        this.setOriginalData("jyotai", jyotai);
        this.jyotai = jyotai;
    }

    public void setGogitaiNumber(TextBoxNum gogitaiNumber) {
        this.setOriginalData("gogitaiNumber", gogitaiNumber);
        this.gogitaiNumber = gogitaiNumber;
    }

    public void setGogitaiName(RString gogitaiName) {
        this.setOriginalData("gogitaiName", gogitaiName);
        this.gogitaiName = gogitaiName;
    }

    public void setYukoKaishiYMD(TextBoxDate yukoKaishiYMD) {
        this.setOriginalData("yukoKaishiYMD", yukoKaishiYMD);
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    public void setYukoShuryoYMD(TextBoxDate yukoShuryoYMD) {
        this.setOriginalData("yukoShuryoYMD", yukoShuryoYMD);
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    public void setGogitaiKaishiYoteiTime(TextBoxTime gogitaiKaishiYoteiTime) {
        this.setOriginalData("gogitaiKaishiYoteiTime", gogitaiKaishiYoteiTime);
        this.gogitaiKaishiYoteiTime = gogitaiKaishiYoteiTime;
    }

    public void setGogitaiShuryoYoteiTime(TextBoxTime gogitaiShuryoYoteiTime) {
        this.setOriginalData("gogitaiShuryoYoteiTime", gogitaiShuryoYoteiTime);
        this.gogitaiShuryoYoteiTime = gogitaiShuryoYoteiTime;
    }

    public void setKaisaiBashoCode(RString kaisaiBashoCode) {
        this.setOriginalData("kaisaiBashoCode", kaisaiBashoCode);
        this.kaisaiBashoCode = kaisaiBashoCode;
    }

    public void setKaisaiBasho(RString kaisaiBasho) {
        this.setOriginalData("kaisaiBasho", kaisaiBasho);
        this.kaisaiBasho = kaisaiBasho;
    }

    public void setSeishinkaiSonzai(Boolean seishinkaiSonzai) {
        this.setOriginalData("seishinkaiSonzai", seishinkaiSonzai);
        this.seishinkaiSonzai = seishinkaiSonzai;
    }

    public void setGogitaiDummyFlag(Boolean gogitaiDummyFlag) {
        this.setOriginalData("gogitaiDummyFlag", gogitaiDummyFlag);
        this.gogitaiDummyFlag = gogitaiDummyFlag;
    }

    public void setYoteiTeiin(TextBoxNum yoteiTeiin) {
        this.setOriginalData("yoteiTeiin", yoteiTeiin);
        this.yoteiTeiin = yoteiTeiin;
    }

    public void setJidoWariateTeiin(TextBoxNum jidoWariateTeiin) {
        this.setOriginalData("jidoWariateTeiin", jidoWariateTeiin);
        this.jidoWariateTeiin = jidoWariateTeiin;
    }

    public void setIinTeiin(TextBoxNum iinTeiin) {
        this.setOriginalData("iinTeiin", iinTeiin);
        this.iinTeiin = iinTeiin;
    }

    // </editor-fold>
}
