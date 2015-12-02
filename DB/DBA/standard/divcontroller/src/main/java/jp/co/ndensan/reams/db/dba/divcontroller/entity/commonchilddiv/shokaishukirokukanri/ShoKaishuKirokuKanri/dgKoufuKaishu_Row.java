package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shokaishukirokukanri.ShoKaishuKirokuKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Dec 01 11:00:52 CST 2015 
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString status;
    private RString koufuType;
    private TextBoxDate koufuDate;
    private RString koufuJiyu;
    private TextBoxDate kaishuDate;
    private RString kaishuJiyu;
    private RString yukoKigen;
    private RString kofuRiyu;
    private RString kaishuRiyu;

    public dgKoufuKaishu_Row() {
        super();
        this.status = RString.EMPTY;
        this.koufuType = RString.EMPTY;
        this.koufuDate = new TextBoxDate();
        this.koufuJiyu = RString.EMPTY;
        this.kaishuDate = new TextBoxDate();
        this.kaishuJiyu = RString.EMPTY;
        this.yukoKigen = RString.EMPTY;
        this.kofuRiyu = RString.EMPTY;
        this.kaishuRiyu = RString.EMPTY;
        this.setOriginalData("status", status);
        this.setOriginalData("koufuType", koufuType);
        this.setOriginalData("koufuDate", koufuDate);
        this.setOriginalData("koufuJiyu", koufuJiyu);
        this.setOriginalData("kaishuDate", kaishuDate);
        this.setOriginalData("kaishuJiyu", kaishuJiyu);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.setOriginalData("kofuRiyu", kofuRiyu);
        this.setOriginalData("kaishuRiyu", kaishuRiyu);
    }

    public dgKoufuKaishu_Row(RString status, RString koufuType, TextBoxDate koufuDate, RString koufuJiyu, TextBoxDate kaishuDate, RString kaishuJiyu, RString yukoKigen, RString kofuRiyu, RString kaishuRiyu) {
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
        this.status = status;
        this.koufuType = koufuType;
        this.koufuDate = koufuDate;
        this.koufuJiyu = koufuJiyu;
        this.kaishuDate = kaishuDate;
        this.kaishuJiyu = kaishuJiyu;
        this.yukoKigen = yukoKigen;
        this.kofuRiyu = kofuRiyu;
        this.kaishuRiyu = kaishuRiyu;
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

    public RString getYukoKigen() {
        return yukoKigen;
    }

    public RString getKofuRiyu() {
        return kofuRiyu;
    }

    public RString getKaishuRiyu() {
        return kaishuRiyu;
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

    public void setYukoKigen(RString yukoKigen) {
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

    // </editor-fold>
}
