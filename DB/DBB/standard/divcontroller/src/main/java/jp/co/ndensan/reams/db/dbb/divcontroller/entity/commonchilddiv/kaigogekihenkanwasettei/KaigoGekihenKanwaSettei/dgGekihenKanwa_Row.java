package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigogekihenkanwasettei.KaigoGekihenKanwaSettei;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Nov 11 16:15:18 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgGekihenKanwa_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgGekihenKanwa_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">

    private TextBox txtKaiseiMaeDankai;
    private TextBox txtKaiseiAtoDankai;
    private TextBoxNum txtHokenryoRitsu;

    public dgGekihenKanwa_Row() {
        super();
        this.txtKaiseiMaeDankai = new TextBox();
        this.txtKaiseiAtoDankai = new TextBox();
        this.txtHokenryoRitsu = new TextBoxNum();
        this.setOriginalData("txtKaiseiMaeDankai", txtKaiseiMaeDankai);
        this.setOriginalData("txtKaiseiAtoDankai", txtKaiseiAtoDankai);
        this.setOriginalData("txtHokenryoRitsu", txtHokenryoRitsu);
    }

    public dgGekihenKanwa_Row(TextBox txtKaiseiMaeDankai, TextBox txtKaiseiAtoDankai, TextBoxNum txtHokenryoRitsu) {
        super();
        this.setOriginalData("txtKaiseiMaeDankai", txtKaiseiMaeDankai);
        this.setOriginalData("txtKaiseiAtoDankai", txtKaiseiAtoDankai);
        this.setOriginalData("txtHokenryoRitsu", txtHokenryoRitsu);
        this.txtKaiseiMaeDankai = txtKaiseiMaeDankai;
        this.txtKaiseiAtoDankai = txtKaiseiAtoDankai;
        this.txtHokenryoRitsu = txtHokenryoRitsu;
    }

    public TextBox getTxtKaiseiMaeDankai() {
        return txtKaiseiMaeDankai;
    }

    public TextBox getTxtKaiseiAtoDankai() {
        return txtKaiseiAtoDankai;
    }

    public TextBoxNum getTxtHokenryoRitsu() {
        return txtHokenryoRitsu;
    }

    public void setTxtKaiseiMaeDankai(TextBox txtKaiseiMaeDankai) {
        this.setOriginalData("txtKaiseiMaeDankai", txtKaiseiMaeDankai);
        this.txtKaiseiMaeDankai = txtKaiseiMaeDankai;
    }

    public void setTxtKaiseiAtoDankai(TextBox txtKaiseiAtoDankai) {
        this.setOriginalData("txtKaiseiAtoDankai", txtKaiseiAtoDankai);
        this.txtKaiseiAtoDankai = txtKaiseiAtoDankai;
    }

    public void setTxtHokenryoRitsu(TextBoxNum txtHokenryoRitsu) {
        this.setOriginalData("txtHokenryoRitsu", txtHokenryoRitsu);
        this.txtHokenryoRitsu = txtHokenryoRitsu;
    }

    // </editor-fold>
}
