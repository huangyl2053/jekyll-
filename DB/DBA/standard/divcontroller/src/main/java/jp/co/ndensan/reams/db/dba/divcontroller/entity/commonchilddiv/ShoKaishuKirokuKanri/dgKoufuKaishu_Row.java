package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Aug 31 14:46:06 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgKoufuKaishu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKoufuKaishu_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString status;
    private RString koufuType;
    private TextBoxDate koufuDate;
    private RString koufuJiyu;
    private TextBoxDate kaishuDate;
    private RString kaishuJiyu;
    private TextBoxDate yukoKigen;
    private RString kofuRiyu;
    private RString kaishuRiyu;
    private RString rirekiNo;
    private RString koufuTypeNo;
    private RString koufuJiyuNo;
    private RString kaishuJiyuNo;

    public dgKoufuKaishu_Row() {
        super();
        this.status = RString.EMPTY;
        this.koufuType = RString.EMPTY;
        this.koufuDate = new TextBoxDate();
        this.koufuJiyu = RString.EMPTY;
        this.kaishuDate = new TextBoxDate();
        this.kaishuJiyu = RString.EMPTY;
        this.yukoKigen = new TextBoxDate();
        this.kofuRiyu = RString.EMPTY;
        this.kaishuRiyu = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.koufuTypeNo = RString.EMPTY;
        this.koufuJiyuNo = RString.EMPTY;
        this.kaishuJiyuNo = RString.EMPTY;
        this.setOriginalData("status", status);
        this.setOriginalData("koufuType", koufuType);
        this.setOriginalData("koufuDate", koufuDate);
        this.setOriginalData("koufuJiyu", koufuJiyu);
        this.setOriginalData("kaishuDate", kaishuDate);
        this.setOriginalData("kaishuJiyu", kaishuJiyu);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("kofuRiyu", kofuRiyu);
        this.setOriginalData("kaishuRiyu", kaishuRiyu);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("koufuTypeNo", koufuTypeNo);
        this.setOriginalData("koufuJiyuNo", koufuJiyuNo);
        this.setOriginalData("kaishuJiyuNo", kaishuJiyuNo);
    }

    public dgKoufuKaishu_Row(RString status, RString koufuType, TextBoxDate koufuDate, RString koufuJiyu, TextBoxDate kaishuDate, RString kaishuJiyu, TextBoxDate yukoKigen, RString kofuRiyu, RString kaishuRiyu, RString rirekiNo, RString koufuTypeNo, RString koufuJiyuNo, RString kaishuJiyuNo) {
        super();
        this.setOriginalData("status", status);
        this.setOriginalData("koufuType", koufuType);
        this.setOriginalData("koufuDate", koufuDate);
        this.setOriginalData("koufuJiyu", koufuJiyu);
        this.setOriginalData("kaishuDate", kaishuDate);
        this.setOriginalData("kaishuJiyu", kaishuJiyu);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("kofuRiyu", kofuRiyu);
        this.setOriginalData("kaishuRiyu", kaishuRiyu);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("koufuTypeNo", koufuTypeNo);
        this.setOriginalData("koufuJiyuNo", koufuJiyuNo);
        this.setOriginalData("kaishuJiyuNo", kaishuJiyuNo);
        this.status = status;
        this.koufuType = koufuType;
        this.koufuDate = koufuDate;
        this.koufuJiyu = koufuJiyu;
        this.kaishuDate = kaishuDate;
        this.kaishuJiyu = kaishuJiyu;
        this.yukoKigen = yukoKigen;
        this.kofuRiyu = kofuRiyu;
        this.kaishuRiyu = kaishuRiyu;
        this.rirekiNo = rirekiNo;
        this.koufuTypeNo = koufuTypeNo;
        this.koufuJiyuNo = koufuJiyuNo;
        this.kaishuJiyuNo = kaishuJiyuNo;
    }

    public RString getStatus() {
        return status;
    }

    public RString getKoufuType() {
        return koufuType;
    }

    public TextBoxDate getKoufuDate() {
        return koufuDate;
    }

    public RString getKoufuJiyu() {
        return koufuJiyu;
    }

    public TextBoxDate getKaishuDate() {
        return kaishuDate;
    }

    public RString getKaishuJiyu() {
        return kaishuJiyu;
    }

    public TextBoxDate getYukoKigen() {
        return yukoKigen;
    }

    public RString getKofuRiyu() {
        return kofuRiyu;
    }

    public RString getKaishuRiyu() {
        return kaishuRiyu;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public RString getKoufuTypeNo() {
        return koufuTypeNo;
    }

    public RString getKoufuJiyuNo() {
        return koufuJiyuNo;
    }

    public RString getKaishuJiyuNo() {
        return kaishuJiyuNo;
    }

    public void setStatus(RString status) {
        this.setOriginalData("status", status);
        this.status = status;
    }

    public void setKoufuType(RString koufuType) {
        this.setOriginalData("koufuType", koufuType);
        this.koufuType = koufuType;
    }

    public void setKoufuDate(TextBoxDate koufuDate) {
        this.setOriginalData("koufuDate", koufuDate);
        this.koufuDate = koufuDate;
    }

    public void setKoufuJiyu(RString koufuJiyu) {
        this.setOriginalData("koufuJiyu", koufuJiyu);
        this.koufuJiyu = koufuJiyu;
    }

    public void setKaishuDate(TextBoxDate kaishuDate) {
        this.setOriginalData("kaishuDate", kaishuDate);
        this.kaishuDate = kaishuDate;
    }

    public void setKaishuJiyu(RString kaishuJiyu) {
        this.setOriginalData("kaishuJiyu", kaishuJiyu);
        this.kaishuJiyu = kaishuJiyu;
    }

    public void setYukoKigen(TextBoxDate yukoKigen) {
        this.setOriginalData("yukoKigen", yukoKigen);
        this.yukoKigen = yukoKigen;
    }

    public void setKofuRiyu(RString kofuRiyu) {
        this.setOriginalData("kofuRiyu", kofuRiyu);
        this.kofuRiyu = kofuRiyu;
    }

    public void setKaishuRiyu(RString kaishuRiyu) {
        this.setOriginalData("kaishuRiyu", kaishuRiyu);
        this.kaishuRiyu = kaishuRiyu;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setKoufuTypeNo(RString koufuTypeNo) {
        this.setOriginalData("koufuTypeNo", koufuTypeNo);
        this.koufuTypeNo = koufuTypeNo;
    }

    public void setKoufuJiyuNo(RString koufuJiyuNo) {
        this.setOriginalData("koufuJiyuNo", koufuJiyuNo);
        this.koufuJiyuNo = koufuJiyuNo;
    }

    public void setKaishuJiyuNo(RString kaishuJiyuNo) {
        this.setOriginalData("kaishuJiyuNo", kaishuJiyuNo);
        this.kaishuJiyuNo = kaishuJiyuNo;
    }

    // </editor-fold>
}
