package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Sep 28 09:55:40 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgNinteiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString jotai;
    private RString hihoNo;
    private RString shikibetsuCode;
    private RString shimei;
    private TextBoxFlexibleDate txtSeinengappiYMD;
    private RString nenrei;
    private RString ketteiKubun;
    private TextBoxFlexibleDate txtKetteiYMD;
    private TextBoxFlexibleDate txtTekiyoYMD;
    private TextBoxFlexibleDate txtYukoKigenYMD;
    private RString futanDankai;
    private Boolean setaiKazei;

    public dgNinteiIchiran_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.hihoNo = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.txtSeinengappiYMD = new TextBoxFlexibleDate();
        this.nenrei = RString.EMPTY;
        this.ketteiKubun = RString.EMPTY;
        this.txtKetteiYMD = new TextBoxFlexibleDate();
        this.txtTekiyoYMD = new TextBoxFlexibleDate();
        this.txtYukoKigenYMD = new TextBoxFlexibleDate();
        this.futanDankai = RString.EMPTY;
        this.setaiKazei = false;
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("hihoNo", hihoNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("txtSeinengappiYMD", txtSeinengappiYMD);
        this.setOriginalData("nenrei", nenrei);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.setOriginalData("txtYukoKigenYMD", txtYukoKigenYMD);
        this.setOriginalData("futanDankai", futanDankai);
        this.setOriginalData("setaiKazei", setaiKazei);
    }

    public dgNinteiIchiran_Row(RString jotai, RString hihoNo, RString shikibetsuCode, RString shimei, TextBoxFlexibleDate txtSeinengappiYMD, RString nenrei, RString ketteiKubun, TextBoxFlexibleDate txtKetteiYMD, TextBoxFlexibleDate txtTekiyoYMD, TextBoxFlexibleDate txtYukoKigenYMD, RString futanDankai, Boolean setaiKazei) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("hihoNo", hihoNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("txtSeinengappiYMD", txtSeinengappiYMD);
        this.setOriginalData("nenrei", nenrei);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.setOriginalData("txtYukoKigenYMD", txtYukoKigenYMD);
        this.setOriginalData("futanDankai", futanDankai);
        this.setOriginalData("setaiKazei", setaiKazei);
        this.jotai = jotai;
        this.hihoNo = hihoNo;
        this.shikibetsuCode = shikibetsuCode;
        this.shimei = shimei;
        this.txtSeinengappiYMD = txtSeinengappiYMD;
        this.nenrei = nenrei;
        this.ketteiKubun = ketteiKubun;
        this.txtKetteiYMD = txtKetteiYMD;
        this.txtTekiyoYMD = txtTekiyoYMD;
        this.txtYukoKigenYMD = txtYukoKigenYMD;
        this.futanDankai = futanDankai;
        this.setaiKazei = setaiKazei;
    }

    public RString getJotai() {
        return jotai;
    }

    public RString getHihoNo() {
        return hihoNo;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getShimei() {
        return shimei;
    }

    public TextBoxFlexibleDate getTxtSeinengappiYMD() {
        return txtSeinengappiYMD;
    }

    public RString getNenrei() {
        return nenrei;
    }

    public RString getKetteiKubun() {
        return ketteiKubun;
    }

    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return txtTekiyoYMD;
    }

    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return txtYukoKigenYMD;
    }

    public RString getFutanDankai() {
        return futanDankai;
    }

    public Boolean getSetaiKazei() {
        return setaiKazei;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setHihoNo(RString hihoNo) {
        this.setOriginalData("hihoNo", hihoNo);
        this.hihoNo = hihoNo;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setTxtSeinengappiYMD(TextBoxFlexibleDate txtSeinengappiYMD) {
        this.setOriginalData("txtSeinengappiYMD", txtSeinengappiYMD);
        this.txtSeinengappiYMD = txtSeinengappiYMD;
    }

    public void setNenrei(RString nenrei) {
        this.setOriginalData("nenrei", nenrei);
        this.nenrei = nenrei;
    }

    public void setKetteiKubun(RString ketteiKubun) {
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.ketteiKubun = ketteiKubun;
    }

    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.txtKetteiYMD = txtKetteiYMD;
    }

    public void setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.txtTekiyoYMD = txtTekiyoYMD;
    }

    public void setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.setOriginalData("txtYukoKigenYMD", txtYukoKigenYMD);
        this.txtYukoKigenYMD = txtYukoKigenYMD;
    }

    public void setFutanDankai(RString futanDankai) {
        this.setOriginalData("futanDankai", futanDankai);
        this.futanDankai = futanDankai;
    }

    public void setSetaiKazei(Boolean setaiKazei) {
        this.setOriginalData("setaiKazei", setaiKazei);
        this.setaiKazei = setaiKazei;
    }

    // </editor-fold>
}
