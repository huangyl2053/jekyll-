package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Dec 21 15:09:20 JST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKoufuKaishu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKoufuKaishu_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString status;
    private RString koufuType;
    private RString koufuDate;
    private RString koufuJiyu;
    private RString kaishuDate;
    private RString kaishuJiyu;
    private RString yukoKigen;

    public dgKoufuKaishu_Row() {
        super();
        this.status = RString.EMPTY;
        this.koufuType = RString.EMPTY;
        this.koufuDate = RString.EMPTY;
        this.koufuJiyu = RString.EMPTY;
        this.kaishuDate = RString.EMPTY;
        this.kaishuJiyu = RString.EMPTY;
        this.yukoKigen = RString.EMPTY;
        this.setOriginalData("status", status);
        this.setOriginalData("koufuType", koufuType);
        this.setOriginalData("koufuDate", koufuDate);
        this.setOriginalData("koufuJiyu", koufuJiyu);
        this.setOriginalData("kaishuDate", kaishuDate);
        this.setOriginalData("kaishuJiyu", kaishuJiyu);
        this.setOriginalData("yukoKigen", yukoKigen);
    }

    public dgKoufuKaishu_Row(RString status, RString koufuType, RString koufuDate, RString koufuJiyu, RString kaishuDate, RString kaishuJiyu, RString yukoKigen) {
        super();
        this.setOriginalData("status", status);
        this.setOriginalData("koufuType", koufuType);
        this.setOriginalData("koufuDate", koufuDate);
        this.setOriginalData("koufuJiyu", koufuJiyu);
        this.setOriginalData("kaishuDate", kaishuDate);
        this.setOriginalData("kaishuJiyu", kaishuJiyu);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.status = status;
        this.koufuType = koufuType;
        this.koufuDate = koufuDate;
        this.koufuJiyu = koufuJiyu;
        this.kaishuDate = kaishuDate;
        this.kaishuJiyu = kaishuJiyu;
        this.yukoKigen = yukoKigen;
    }

    public RString getStatus() {
        return status;
    }

    public RString getKoufuType() {
        return koufuType;
    }

    public RString getKoufuDate() {
        return koufuDate;
    }

    public RString getKoufuJiyu() {
        return koufuJiyu;
    }

    public RString getKaishuDate() {
        return kaishuDate;
    }

    public RString getKaishuJiyu() {
        return kaishuJiyu;
    }

    public RString getYukoKigen() {
        return yukoKigen;
    }

    public void setStatus(RString status) {
        this.setOriginalData("status", status);
        this.status = status;
    }

    public void setKoufuType(RString koufuType) {
        this.setOriginalData("koufuType", koufuType);
        this.koufuType = koufuType;
    }

    public void setKoufuDate(RString koufuDate) {
        this.setOriginalData("koufuDate", koufuDate);
        this.koufuDate = koufuDate;
    }

    public void setKoufuJiyu(RString koufuJiyu) {
        this.setOriginalData("koufuJiyu", koufuJiyu);
        this.koufuJiyu = koufuJiyu;
    }

    public void setKaishuDate(RString kaishuDate) {
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

    // </editor-fold>
}
