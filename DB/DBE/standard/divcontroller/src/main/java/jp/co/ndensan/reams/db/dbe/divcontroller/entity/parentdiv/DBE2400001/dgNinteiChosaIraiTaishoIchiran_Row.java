package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Dec 21 13:11:21 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgNinteiChosaIraiTaishoIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteiChosaIraiTaishoIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">

    private RString ninteiChosaitakusaki;
    private RString ninteiChosaItakusakiMeisho;
    private RString ninteiChosainNo;
    private RString ninteiChosainShimei;
    private TextBoxNum shinseishaNinzu;
    private RString shoKisaiHokenshaNo;

    public dgNinteiChosaIraiTaishoIchiran_Row() {
        super();
        this.ninteiChosaitakusaki = RString.EMPTY;
        this.ninteiChosaItakusakiMeisho = RString.EMPTY;
        this.ninteiChosainNo = RString.EMPTY;
        this.ninteiChosainShimei = RString.EMPTY;
        this.shinseishaNinzu = new TextBoxNum();
        this.shoKisaiHokenshaNo = RString.EMPTY;
        this.setOriginalData("ninteiChosaitakusaki", ninteiChosaitakusaki);
        this.setOriginalData("ninteiChosaItakusakiMeisho", ninteiChosaItakusakiMeisho);
        this.setOriginalData("ninteiChosainNo", ninteiChosainNo);
        this.setOriginalData("ninteiChosainShimei", ninteiChosainShimei);
        this.setOriginalData("shinseishaNinzu", shinseishaNinzu);
        this.setOriginalData("shoKisaiHokenshaNo", shoKisaiHokenshaNo);
    }

    public dgNinteiChosaIraiTaishoIchiran_Row(RString ninteiChosaitakusaki, RString ninteiChosaItakusakiMeisho, RString ninteiChosainNo, RString ninteiChosainShimei, TextBoxNum shinseishaNinzu, RString shoKisaiHokenshaNo) {
        super();
        this.setOriginalData("ninteiChosaitakusaki", ninteiChosaitakusaki);
        this.setOriginalData("ninteiChosaItakusakiMeisho", ninteiChosaItakusakiMeisho);
        this.setOriginalData("ninteiChosainNo", ninteiChosainNo);
        this.setOriginalData("ninteiChosainShimei", ninteiChosainShimei);
        this.setOriginalData("shinseishaNinzu", shinseishaNinzu);
        this.setOriginalData("shoKisaiHokenshaNo", shoKisaiHokenshaNo);
        this.ninteiChosaitakusaki = ninteiChosaitakusaki;
        this.ninteiChosaItakusakiMeisho = ninteiChosaItakusakiMeisho;
        this.ninteiChosainNo = ninteiChosainNo;
        this.ninteiChosainShimei = ninteiChosainShimei;
        this.shinseishaNinzu = shinseishaNinzu;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    public RString getNinteiChosaitakusaki() {
        return ninteiChosaitakusaki;
    }

    public RString getNinteiChosaItakusakiMeisho() {
        return ninteiChosaItakusakiMeisho;
    }

    public RString getNinteiChosainNo() {
        return ninteiChosainNo;
    }

    public RString getNinteiChosainShimei() {
        return ninteiChosainShimei;
    }

    public TextBoxNum getShinseishaNinzu() {
        return shinseishaNinzu;
    }

    public RString getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    public void setNinteiChosaitakusaki(RString ninteiChosaitakusaki) {
        this.setOriginalData("ninteiChosaitakusaki", ninteiChosaitakusaki);
        this.ninteiChosaitakusaki = ninteiChosaitakusaki;
    }

    public void setNinteiChosaItakusakiMeisho(RString ninteiChosaItakusakiMeisho) {
        this.setOriginalData("ninteiChosaItakusakiMeisho", ninteiChosaItakusakiMeisho);
        this.ninteiChosaItakusakiMeisho = ninteiChosaItakusakiMeisho;
    }

    public void setNinteiChosainNo(RString ninteiChosainNo) {
        this.setOriginalData("ninteiChosainNo", ninteiChosainNo);
        this.ninteiChosainNo = ninteiChosainNo;
    }

    public void setNinteiChosainShimei(RString ninteiChosainShimei) {
        this.setOriginalData("ninteiChosainShimei", ninteiChosainShimei);
        this.ninteiChosainShimei = ninteiChosainShimei;
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
