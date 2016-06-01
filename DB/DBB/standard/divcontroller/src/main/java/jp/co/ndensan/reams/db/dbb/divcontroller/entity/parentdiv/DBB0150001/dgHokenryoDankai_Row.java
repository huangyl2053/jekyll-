package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 31 19:33:51 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgHokenryoDankai_Row のクラスファイル
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class dgHokenryoDankai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private RString hokenryoDankai;
    private RString hokenryoRitsu;

    public dgHokenryoDankai_Row() {
        super();
        this.hokenryoDankai = RString.EMPTY;
        this.hokenryoRitsu = RString.EMPTY;
        this.setOriginalData("hokenryoDankai", hokenryoDankai);
        this.setOriginalData("hokenryoRitsu", hokenryoRitsu);
    }

    public dgHokenryoDankai_Row(RString hokenryoDankai, RString hokenryoRitsu) {
        super();
        this.setOriginalData("hokenryoDankai", hokenryoDankai);
        this.setOriginalData("hokenryoRitsu", hokenryoRitsu);
        this.hokenryoDankai = hokenryoDankai;
        this.hokenryoRitsu = hokenryoRitsu;
    }

    public RString getHokenryoDankai() {
        return hokenryoDankai;
    }

    public RString getHokenryoRitsu() {
        return hokenryoRitsu;
    }

    public void setHokenryoDankai(RString hokenryoDankai) {
        this.setOriginalData("hokenryoDankai", hokenryoDankai);
        this.hokenryoDankai = hokenryoDankai;
    }

    public void setHokenryoRitsu(RString hokenryoRitsu) {
        this.setOriginalData("hokenryoRitsu", hokenryoRitsu);
        this.hokenryoRitsu = hokenryoRitsu;
    }

    // </editor-fold>
}
