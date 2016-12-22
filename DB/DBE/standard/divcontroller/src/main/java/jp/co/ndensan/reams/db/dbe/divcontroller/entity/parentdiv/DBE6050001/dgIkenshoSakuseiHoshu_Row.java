package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Dec 21 19:27:53 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgIkenshoSakuseiHoshu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIkenshoSakuseiHoshu_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">

    private RString no;
    private RString iryoKikanCode;
    private RString iryoKikanMei;
    private RString code;
    private RString shujiiShimei;
    private TextBoxDate iraibi;
    private TextBoxDate kinyubi;
    private TextBoxDate nyushubi;
    private RString ikenshoIraiKubun;
    private RString hokenshaBango;
    private RString hihokenshaBango;
    private RString shinseishaShimei;
    private RString zaitakuShin;
    private RString zaitakuKe;
    private RString shisetsuShin;
    private RString shisetsuKe;
    private TextBoxNum sakuseiryo;
    private TextBoxNum shinryohito;
    private TextBoxNum gokei;
    private RString shinseishoKanriNo;
    private RString ikenshoIraiRirekiNo;

    public dgIkenshoSakuseiHoshu_Row() {
        super();
        this.no = RString.EMPTY;
        this.iryoKikanCode = RString.EMPTY;
        this.iryoKikanMei = RString.EMPTY;
        this.code = RString.EMPTY;
        this.shujiiShimei = RString.EMPTY;
        this.iraibi = new TextBoxDate();
        this.kinyubi = new TextBoxDate();
        this.nyushubi = new TextBoxDate();
        this.ikenshoIraiKubun = RString.EMPTY;
        this.hokenshaBango = RString.EMPTY;
        this.hihokenshaBango = RString.EMPTY;
        this.shinseishaShimei = RString.EMPTY;
        this.zaitakuShin = RString.EMPTY;
        this.zaitakuKe = RString.EMPTY;
        this.shisetsuShin = RString.EMPTY;
        this.shisetsuKe = RString.EMPTY;
        this.sakuseiryo = new TextBoxNum();
        this.shinryohito = new TextBoxNum();
        this.gokei = new TextBoxNum();
        this.shinseishoKanriNo = RString.EMPTY;
        this.ikenshoIraiRirekiNo = RString.EMPTY;
        this.setOriginalData("no", no);
        this.setOriginalData("iryoKikanCode", iryoKikanCode);
        this.setOriginalData("iryoKikanMei", iryoKikanMei);
        this.setOriginalData("code", code);
        this.setOriginalData("shujiiShimei", shujiiShimei);
        this.setOriginalData("iraibi", iraibi);
        this.setOriginalData("kinyubi", kinyubi);
        this.setOriginalData("nyushubi", nyushubi);
        this.setOriginalData("ikenshoIraiKubun", ikenshoIraiKubun);
        this.setOriginalData("hokenshaBango", hokenshaBango);
        this.setOriginalData("hihokenshaBango", hihokenshaBango);
        this.setOriginalData("shinseishaShimei", shinseishaShimei);
        this.setOriginalData("zaitakuShin", zaitakuShin);
        this.setOriginalData("zaitakuKe", zaitakuKe);
        this.setOriginalData("shisetsuShin", shisetsuShin);
        this.setOriginalData("shisetsuKe", shisetsuKe);
        this.setOriginalData("sakuseiryo", sakuseiryo);
        this.setOriginalData("shinryohito", shinryohito);
        this.setOriginalData("gokei", gokei);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ikenshoIraiRirekiNo", ikenshoIraiRirekiNo);
    }

    public dgIkenshoSakuseiHoshu_Row(RString no, RString iryoKikanCode, RString iryoKikanMei, RString code, RString shujiiShimei, TextBoxDate iraibi, TextBoxDate kinyubi, TextBoxDate nyushubi, RString ikenshoIraiKubun, RString hokenshaBango, RString hihokenshaBango, RString shinseishaShimei, RString zaitakuShin, RString zaitakuKe, RString shisetsuShin, RString shisetsuKe, TextBoxNum sakuseiryo, TextBoxNum shinryohito, TextBoxNum gokei, RString shinseishoKanriNo, RString ikenshoIraiRirekiNo) {
        super();
        this.setOriginalData("no", no);
        this.setOriginalData("iryoKikanCode", iryoKikanCode);
        this.setOriginalData("iryoKikanMei", iryoKikanMei);
        this.setOriginalData("code", code);
        this.setOriginalData("shujiiShimei", shujiiShimei);
        this.setOriginalData("iraibi", iraibi);
        this.setOriginalData("kinyubi", kinyubi);
        this.setOriginalData("nyushubi", nyushubi);
        this.setOriginalData("ikenshoIraiKubun", ikenshoIraiKubun);
        this.setOriginalData("hokenshaBango", hokenshaBango);
        this.setOriginalData("hihokenshaBango", hihokenshaBango);
        this.setOriginalData("shinseishaShimei", shinseishaShimei);
        this.setOriginalData("zaitakuShin", zaitakuShin);
        this.setOriginalData("zaitakuKe", zaitakuKe);
        this.setOriginalData("shisetsuShin", shisetsuShin);
        this.setOriginalData("shisetsuKe", shisetsuKe);
        this.setOriginalData("sakuseiryo", sakuseiryo);
        this.setOriginalData("shinryohito", shinryohito);
        this.setOriginalData("gokei", gokei);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ikenshoIraiRirekiNo", ikenshoIraiRirekiNo);
        this.no = no;
        this.iryoKikanCode = iryoKikanCode;
        this.iryoKikanMei = iryoKikanMei;
        this.code = code;
        this.shujiiShimei = shujiiShimei;
        this.iraibi = iraibi;
        this.kinyubi = kinyubi;
        this.nyushubi = nyushubi;
        this.ikenshoIraiKubun = ikenshoIraiKubun;
        this.hokenshaBango = hokenshaBango;
        this.hihokenshaBango = hihokenshaBango;
        this.shinseishaShimei = shinseishaShimei;
        this.zaitakuShin = zaitakuShin;
        this.zaitakuKe = zaitakuKe;
        this.shisetsuShin = shisetsuShin;
        this.shisetsuKe = shisetsuKe;
        this.sakuseiryo = sakuseiryo;
        this.shinryohito = shinryohito;
        this.gokei = gokei;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    public RString getNo() {
        return no;
    }

    public RString getIryoKikanCode() {
        return iryoKikanCode;
    }

    public RString getIryoKikanMei() {
        return iryoKikanMei;
    }

    public RString getCode() {
        return code;
    }

    public RString getShujiiShimei() {
        return shujiiShimei;
    }

    public TextBoxDate getIraibi() {
        return iraibi;
    }

    public TextBoxDate getKinyubi() {
        return kinyubi;
    }

    public TextBoxDate getNyushubi() {
        return nyushubi;
    }

    public RString getIkenshoIraiKubun() {
        return ikenshoIraiKubun;
    }

    public RString getHokenshaBango() {
        return hokenshaBango;
    }

    public RString getHihokenshaBango() {
        return hihokenshaBango;
    }

    public RString getShinseishaShimei() {
        return shinseishaShimei;
    }

    public RString getZaitakuShin() {
        return zaitakuShin;
    }

    public RString getZaitakuKe() {
        return zaitakuKe;
    }

    public RString getShisetsuShin() {
        return shisetsuShin;
    }

    public RString getShisetsuKe() {
        return shisetsuKe;
    }

    public TextBoxNum getSakuseiryo() {
        return sakuseiryo;
    }

    public TextBoxNum getShinryohito() {
        return shinryohito;
    }

    public TextBoxNum getGokei() {
        return gokei;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public RString getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    public void setNo(RString no) {
        this.setOriginalData("no", no);
        this.no = no;
    }

    public void setIryoKikanCode(RString iryoKikanCode) {
        this.setOriginalData("iryoKikanCode", iryoKikanCode);
        this.iryoKikanCode = iryoKikanCode;
    }

    public void setIryoKikanMei(RString iryoKikanMei) {
        this.setOriginalData("iryoKikanMei", iryoKikanMei);
        this.iryoKikanMei = iryoKikanMei;
    }

    public void setCode(RString code) {
        this.setOriginalData("code", code);
        this.code = code;
    }

    public void setShujiiShimei(RString shujiiShimei) {
        this.setOriginalData("shujiiShimei", shujiiShimei);
        this.shujiiShimei = shujiiShimei;
    }

    public void setIraibi(TextBoxDate iraibi) {
        this.setOriginalData("iraibi", iraibi);
        this.iraibi = iraibi;
    }

    public void setKinyubi(TextBoxDate kinyubi) {
        this.setOriginalData("kinyubi", kinyubi);
        this.kinyubi = kinyubi;
    }

    public void setNyushubi(TextBoxDate nyushubi) {
        this.setOriginalData("nyushubi", nyushubi);
        this.nyushubi = nyushubi;
    }

    public void setIkenshoIraiKubun(RString ikenshoIraiKubun) {
        this.setOriginalData("ikenshoIraiKubun", ikenshoIraiKubun);
        this.ikenshoIraiKubun = ikenshoIraiKubun;
    }

    public void setHokenshaBango(RString hokenshaBango) {
        this.setOriginalData("hokenshaBango", hokenshaBango);
        this.hokenshaBango = hokenshaBango;
    }

    public void setHihokenshaBango(RString hihokenshaBango) {
        this.setOriginalData("hihokenshaBango", hihokenshaBango);
        this.hihokenshaBango = hihokenshaBango;
    }

    public void setShinseishaShimei(RString shinseishaShimei) {
        this.setOriginalData("shinseishaShimei", shinseishaShimei);
        this.shinseishaShimei = shinseishaShimei;
    }

    public void setZaitakuShin(RString zaitakuShin) {
        this.setOriginalData("zaitakuShin", zaitakuShin);
        this.zaitakuShin = zaitakuShin;
    }

    public void setZaitakuKe(RString zaitakuKe) {
        this.setOriginalData("zaitakuKe", zaitakuKe);
        this.zaitakuKe = zaitakuKe;
    }

    public void setShisetsuShin(RString shisetsuShin) {
        this.setOriginalData("shisetsuShin", shisetsuShin);
        this.shisetsuShin = shisetsuShin;
    }

    public void setShisetsuKe(RString shisetsuKe) {
        this.setOriginalData("shisetsuKe", shisetsuKe);
        this.shisetsuKe = shisetsuKe;
    }

    public void setSakuseiryo(TextBoxNum sakuseiryo) {
        this.setOriginalData("sakuseiryo", sakuseiryo);
        this.sakuseiryo = sakuseiryo;
    }

    public void setShinryohito(TextBoxNum shinryohito) {
        this.setOriginalData("shinryohito", shinryohito);
        this.shinryohito = shinryohito;
    }

    public void setGokei(TextBoxNum gokei) {
        this.setOriginalData("gokei", gokei);
        this.gokei = gokei;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setIkenshoIraiRirekiNo(RString ikenshoIraiRirekiNo) {
        this.setOriginalData("ikenshoIraiRirekiNo", ikenshoIraiRirekiNo);
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    // </editor-fold>
}
