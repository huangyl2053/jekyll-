package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Jan 30 16:38:43 CST 2016 
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    private RString ninteiChosaitakusaki;
    private RString ninteiChosaItakusakiMeisho;
    private RString ninteiChosainNo;
    private RString ninteiChosainShimei;
    private TextBoxNum shinseishaNinzu;

    public dgNinteiChosaIraiTaishoIchiran_Row() {
        super();
        this.ninteiChosaitakusaki = RString.EMPTY;
        this.ninteiChosaItakusakiMeisho = RString.EMPTY;
        this.ninteiChosainNo = RString.EMPTY;
        this.ninteiChosainShimei = RString.EMPTY;
        this.shinseishaNinzu = new TextBoxNum();
        this.setOriginalData("ninteiChosaitakusaki", ninteiChosaitakusaki);
        this.setOriginalData("ninteiChosaItakusakiMeisho", ninteiChosaItakusakiMeisho);
        this.setOriginalData("ninteiChosainNo", ninteiChosainNo);
        this.setOriginalData("ninteiChosainShimei", ninteiChosainShimei);
        this.setOriginalData("shinseishaNinzu", shinseishaNinzu);
    }

    public dgNinteiChosaIraiTaishoIchiran_Row(RString ninteiChosaitakusaki, RString ninteiChosaItakusakiMeisho, RString ninteiChosainNo, RString ninteiChosainShimei, TextBoxNum shinseishaNinzu) {
        super();
        this.setOriginalData("ninteiChosaitakusaki", ninteiChosaitakusaki);
        this.setOriginalData("ninteiChosaItakusakiMeisho", ninteiChosaItakusakiMeisho);
        this.setOriginalData("ninteiChosainNo", ninteiChosainNo);
        this.setOriginalData("ninteiChosainShimei", ninteiChosainShimei);
        this.setOriginalData("shinseishaNinzu", shinseishaNinzu);
        this.ninteiChosaitakusaki = ninteiChosaitakusaki;
        this.ninteiChosaItakusakiMeisho = ninteiChosaItakusakiMeisho;
        this.ninteiChosainNo = ninteiChosainNo;
        this.ninteiChosainShimei = ninteiChosainShimei;
        this.shinseishaNinzu = shinseishaNinzu;
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

    // </editor-fold>
}
