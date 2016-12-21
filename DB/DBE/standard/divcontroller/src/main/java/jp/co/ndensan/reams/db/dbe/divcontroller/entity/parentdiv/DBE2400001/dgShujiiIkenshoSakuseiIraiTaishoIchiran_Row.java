package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Dec 21 17:40:07 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">

    private RString shujiiIryoKikanCode;
    private RString shujiiIryoKikanMeisho;
    private RString ishiNo;
    private RString ishiShimei;
    private TextBoxNum shinseishaNinzu;
    private RString shoKisaiHokenshaNo;

    public dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row() {
        super();
        this.shujiiIryoKikanCode = RString.EMPTY;
        this.shujiiIryoKikanMeisho = RString.EMPTY;
        this.ishiNo = RString.EMPTY;
        this.ishiShimei = RString.EMPTY;
        this.shinseishaNinzu = new TextBoxNum();
        this.shoKisaiHokenshaNo = RString.EMPTY;
        this.setOriginalData("shujiiIryoKikanCode", shujiiIryoKikanCode);
        this.setOriginalData("shujiiIryoKikanMeisho", shujiiIryoKikanMeisho);
        this.setOriginalData("ishiNo", ishiNo);
        this.setOriginalData("ishiShimei", ishiShimei);
        this.setOriginalData("shinseishaNinzu", shinseishaNinzu);
        this.setOriginalData("shoKisaiHokenshaNo", shoKisaiHokenshaNo);
    }

    public dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row(RString shujiiIryoKikanCode, RString shujiiIryoKikanMeisho, RString ishiNo, RString ishiShimei, TextBoxNum shinseishaNinzu, RString shoKisaiHokenshaNo) {
        super();
        this.setOriginalData("shujiiIryoKikanCode", shujiiIryoKikanCode);
        this.setOriginalData("shujiiIryoKikanMeisho", shujiiIryoKikanMeisho);
        this.setOriginalData("ishiNo", ishiNo);
        this.setOriginalData("ishiShimei", ishiShimei);
        this.setOriginalData("shinseishaNinzu", shinseishaNinzu);
        this.setOriginalData("shoKisaiHokenshaNo", shoKisaiHokenshaNo);
        this.shujiiIryoKikanCode = shujiiIryoKikanCode;
        this.shujiiIryoKikanMeisho = shujiiIryoKikanMeisho;
        this.ishiNo = ishiNo;
        this.ishiShimei = ishiShimei;
        this.shinseishaNinzu = shinseishaNinzu;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    public RString getShujiiIryoKikanCode() {
        return shujiiIryoKikanCode;
    }

    public RString getShujiiIryoKikanMeisho() {
        return shujiiIryoKikanMeisho;
    }

    public RString getIshiNo() {
        return ishiNo;
    }

    public RString getIshiShimei() {
        return ishiShimei;
    }

    public TextBoxNum getShinseishaNinzu() {
        return shinseishaNinzu;
    }

    public RString getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    public void setShujiiIryoKikanCode(RString shujiiIryoKikanCode) {
        this.setOriginalData("shujiiIryoKikanCode", shujiiIryoKikanCode);
        this.shujiiIryoKikanCode = shujiiIryoKikanCode;
    }

    public void setShujiiIryoKikanMeisho(RString shujiiIryoKikanMeisho) {
        this.setOriginalData("shujiiIryoKikanMeisho", shujiiIryoKikanMeisho);
        this.shujiiIryoKikanMeisho = shujiiIryoKikanMeisho;
    }

    public void setIshiNo(RString ishiNo) {
        this.setOriginalData("ishiNo", ishiNo);
        this.ishiNo = ishiNo;
    }

    public void setIshiShimei(RString ishiShimei) {
        this.setOriginalData("ishiShimei", ishiShimei);
        this.ishiShimei = ishiShimei;
    }

    public void setShinseishaNinzu(TextBoxNum shinseishaNinzu) {
        this.setOriginalData("shinseishaNinzu", shinseishaNinzu);
        this.shinseishaNinzu = shinseishaNinzu;
    }

    public void setShoKisaiHokenshaNo(RString shoKisaiHokenshaNo) {
        this.setOriginalData("shoKisaiHokenshaNo", shoKisaiHokenshaNo);
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    // </editor-fold>
}
