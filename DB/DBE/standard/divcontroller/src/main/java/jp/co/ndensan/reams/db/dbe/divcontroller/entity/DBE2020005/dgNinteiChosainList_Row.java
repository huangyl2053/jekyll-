package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020005;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 30 14:17:40 JST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgNinteiChosainList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteiChosainList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">

    private RString yusenNo;
    private RString ninteiChosaItakusakiCode;
    private RString ninteiChosaItakusakiName;
    private RString ninteiChosainCode;
    private RString ninteiChosainName;
    private RString biko;

    public dgNinteiChosainList_Row() {
        super();
        this.yusenNo = RString.EMPTY;
        this.ninteiChosaItakusakiCode = RString.EMPTY;
        this.ninteiChosaItakusakiName = RString.EMPTY;
        this.ninteiChosainCode = RString.EMPTY;
        this.ninteiChosainName = RString.EMPTY;
        this.biko = RString.EMPTY;
    }

    public dgNinteiChosainList_Row(RString yusenNo, RString ninteiChosaItakusakiCode, RString ninteiChosaItakusakiName, RString ninteiChosainCode, RString ninteiChosainName, RString biko) {
        super();
        this.setOriginalData("yusenNo", yusenNo);
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.setOriginalData("ninteiChosaItakusakiName", ninteiChosaItakusakiName);
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.setOriginalData("ninteiChosainName", ninteiChosainName);
        this.setOriginalData("biko", biko);
        this.yusenNo = yusenNo;
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
        this.ninteiChosaItakusakiName = ninteiChosaItakusakiName;
        this.ninteiChosainCode = ninteiChosainCode;
        this.ninteiChosainName = ninteiChosainName;
        this.biko = biko;
    }

    public RString getYusenNo() {
        return yusenNo;
    }

    public RString getNinteiChosaItakusakiCode() {
        return ninteiChosaItakusakiCode;
    }

    public RString getNinteiChosaItakusakiName() {
        return ninteiChosaItakusakiName;
    }

    public RString getNinteiChosainCode() {
        return ninteiChosainCode;
    }

    public RString getNinteiChosainName() {
        return ninteiChosainName;
    }

    public RString getBiko() {
        return biko;
    }

    public void setYusenNo(RString yusenNo) {
        this.setOriginalData("yusenNo", yusenNo);
        this.yusenNo = yusenNo;
    }

    public void setNinteiChosaItakusakiCode(RString ninteiChosaItakusakiCode) {
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
    }

    public void setNinteiChosaItakusakiName(RString ninteiChosaItakusakiName) {
        this.setOriginalData("ninteiChosaItakusakiName", ninteiChosaItakusakiName);
        this.ninteiChosaItakusakiName = ninteiChosaItakusakiName;
    }

    public void setNinteiChosainCode(RString ninteiChosainCode) {
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.ninteiChosainCode = ninteiChosainCode;
    }

    public void setNinteiChosainName(RString ninteiChosainName) {
        this.setOriginalData("ninteiChosainName", ninteiChosainName);
        this.ninteiChosainName = ninteiChosainName;
    }

    public void setBiko(RString biko) {
        this.setOriginalData("biko", biko);
        this.biko = biko;
    }

    // </editor-fold>
}