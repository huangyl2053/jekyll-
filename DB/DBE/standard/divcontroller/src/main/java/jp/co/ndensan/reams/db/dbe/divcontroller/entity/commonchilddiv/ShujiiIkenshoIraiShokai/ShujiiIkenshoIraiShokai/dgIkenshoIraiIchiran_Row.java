package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShujiiIkenshoIraiShokai.ShujiiIkenshoIraiShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jan 04 20:05:28 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgIkenshoIraiIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIkenshoIraiIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-19_22-43-59">

    private RString number;
    private TextBoxDate ninyeiShonseibi;
    private RString shinseiKubunShinseiji;
    private TextBoxDate niteiTorisageDay;
    private TextBoxDate ninteibi;
    private RString yokaigodo;
    private RString yukoKikan;
    private RString iryoKikanNumber;
    private RString iryoKikanMeisho;
    private RString shujiiCode;
    private RString shujiiMeisho;
    private TextBoxDate ikenshoJuryoDay;
    private TextBoxDate ikenshoKinyuDay;
    private RString iraiKubun;

    public dgIkenshoIraiIchiran_Row() {
        super();
        this.number = RString.EMPTY;
        this.ninyeiShonseibi = new TextBoxDate();
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.niteiTorisageDay = new TextBoxDate();
        this.ninteibi = new TextBoxDate();
        this.yokaigodo = RString.EMPTY;
        this.yukoKikan = RString.EMPTY;
        this.iryoKikanNumber = RString.EMPTY;
        this.iryoKikanMeisho = RString.EMPTY;
        this.shujiiCode = RString.EMPTY;
        this.shujiiMeisho = RString.EMPTY;
        this.ikenshoJuryoDay = new TextBoxDate();
        this.ikenshoKinyuDay = new TextBoxDate();
        this.iraiKubun = RString.EMPTY;
        this.setOriginalData("number", number);
        this.setOriginalData("ninyeiShonseibi", ninyeiShonseibi);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("niteiTorisageDay", niteiTorisageDay);
        this.setOriginalData("ninteibi", ninteibi);
        this.setOriginalData("yokaigodo", yokaigodo);
        this.setOriginalData("yukoKikan", yukoKikan);
        this.setOriginalData("iryoKikanNumber", iryoKikanNumber);
        this.setOriginalData("iryoKikanMeisho", iryoKikanMeisho);
        this.setOriginalData("shujiiCode", shujiiCode);
        this.setOriginalData("shujiiMeisho", shujiiMeisho);
        this.setOriginalData("ikenshoJuryoDay", ikenshoJuryoDay);
        this.setOriginalData("ikenshoKinyuDay", ikenshoKinyuDay);
        this.setOriginalData("iraiKubun", iraiKubun);
    }

    public dgIkenshoIraiIchiran_Row(RString number, TextBoxDate ninyeiShonseibi, RString shinseiKubunShinseiji, TextBoxDate niteiTorisageDay, TextBoxDate ninteibi, RString yokaigodo, RString yukoKikan, RString iryoKikanNumber, RString iryoKikanMeisho, RString shujiiCode, RString shujiiMeisho, TextBoxDate ikenshoJuryoDay, TextBoxDate ikenshoKinyuDay, RString iraiKubun) {
        super();
        this.setOriginalData("number", number);
        this.setOriginalData("ninyeiShonseibi", ninyeiShonseibi);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("niteiTorisageDay", niteiTorisageDay);
        this.setOriginalData("ninteibi", ninteibi);
        this.setOriginalData("yokaigodo", yokaigodo);
        this.setOriginalData("yukoKikan", yukoKikan);
        this.setOriginalData("iryoKikanNumber", iryoKikanNumber);
        this.setOriginalData("iryoKikanMeisho", iryoKikanMeisho);
        this.setOriginalData("shujiiCode", shujiiCode);
        this.setOriginalData("shujiiMeisho", shujiiMeisho);
        this.setOriginalData("ikenshoJuryoDay", ikenshoJuryoDay);
        this.setOriginalData("ikenshoKinyuDay", ikenshoKinyuDay);
        this.setOriginalData("iraiKubun", iraiKubun);
        this.number = number;
        this.ninyeiShonseibi = ninyeiShonseibi;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
        this.niteiTorisageDay = niteiTorisageDay;
        this.ninteibi = ninteibi;
        this.yokaigodo = yokaigodo;
        this.yukoKikan = yukoKikan;
        this.iryoKikanNumber = iryoKikanNumber;
        this.iryoKikanMeisho = iryoKikanMeisho;
        this.shujiiCode = shujiiCode;
        this.shujiiMeisho = shujiiMeisho;
        this.ikenshoJuryoDay = ikenshoJuryoDay;
        this.ikenshoKinyuDay = ikenshoKinyuDay;
        this.iraiKubun = iraiKubun;
    }

    public RString getNumber() {
        return number;
    }

    public TextBoxDate getNinyeiShonseibi() {
        return ninyeiShonseibi;
    }

    public RString getShinseiKubunShinseiji() {
        return shinseiKubunShinseiji;
    }

    public TextBoxDate getNiteiTorisageDay() {
        return niteiTorisageDay;
    }

    public TextBoxDate getNinteibi() {
        return ninteibi;
    }

    public RString getYokaigodo() {
        return yokaigodo;
    }

    public RString getYukoKikan() {
        return yukoKikan;
    }

    public RString getIryoKikanNumber() {
        return iryoKikanNumber;
    }

    public RString getIryoKikanMeisho() {
        return iryoKikanMeisho;
    }

    public RString getShujiiCode() {
        return shujiiCode;
    }

    public RString getShujiiMeisho() {
        return shujiiMeisho;
    }

    public TextBoxDate getIkenshoJuryoDay() {
        return ikenshoJuryoDay;
    }

    public TextBoxDate getIkenshoKinyuDay() {
        return ikenshoKinyuDay;
    }

    public RString getIraiKubun() {
        return iraiKubun;
    }

    public void setNumber(RString number) {
        this.setOriginalData("number", number);
        this.number = number;
    }

    public void setNinyeiShonseibi(TextBoxDate ninyeiShonseibi) {
        this.setOriginalData("ninyeiShonseibi", ninyeiShonseibi);
        this.ninyeiShonseibi = ninyeiShonseibi;
    }

    public void setShinseiKubunShinseiji(RString shinseiKubunShinseiji) {
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    public void setNiteiTorisageDay(TextBoxDate niteiTorisageDay) {
        this.setOriginalData("niteiTorisageDay", niteiTorisageDay);
        this.niteiTorisageDay = niteiTorisageDay;
    }

    public void setNinteibi(TextBoxDate ninteibi) {
        this.setOriginalData("ninteibi", ninteibi);
        this.ninteibi = ninteibi;
    }

    public void setYokaigodo(RString yokaigodo) {
        this.setOriginalData("yokaigodo", yokaigodo);
        this.yokaigodo = yokaigodo;
    }

    public void setYukoKikan(RString yukoKikan) {
        this.setOriginalData("yukoKikan", yukoKikan);
        this.yukoKikan = yukoKikan;
    }

    public void setIryoKikanNumber(RString iryoKikanNumber) {
        this.setOriginalData("iryoKikanNumber", iryoKikanNumber);
        this.iryoKikanNumber = iryoKikanNumber;
    }

    public void setIryoKikanMeisho(RString iryoKikanMeisho) {
        this.setOriginalData("iryoKikanMeisho", iryoKikanMeisho);
        this.iryoKikanMeisho = iryoKikanMeisho;
    }

    public void setShujiiCode(RString shujiiCode) {
        this.setOriginalData("shujiiCode", shujiiCode);
        this.shujiiCode = shujiiCode;
    }

    public void setShujiiMeisho(RString shujiiMeisho) {
        this.setOriginalData("shujiiMeisho", shujiiMeisho);
        this.shujiiMeisho = shujiiMeisho;
    }

    public void setIkenshoJuryoDay(TextBoxDate ikenshoJuryoDay) {
        this.setOriginalData("ikenshoJuryoDay", ikenshoJuryoDay);
        this.ikenshoJuryoDay = ikenshoJuryoDay;
    }

    public void setIkenshoKinyuDay(TextBoxDate ikenshoKinyuDay) {
        this.setOriginalData("ikenshoKinyuDay", ikenshoKinyuDay);
        this.ikenshoKinyuDay = ikenshoKinyuDay;
    }

    public void setIraiKubun(RString iraiKubun) {
        this.setOriginalData("iraiKubun", iraiKubun);
        this.iraiKubun = iraiKubun;
    }

    // </editor-fold>
}
