package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoKihon;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jul 19 20:29:38 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKihonChosa_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKihonChosa_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private Button btnTokkiJiko;
    private RString kihonResearchItemCode;
    private RString kihonResearchItemName;
    private RString kaitou;

    public dgKihonChosa_Row() {
        super();
        this.btnTokkiJiko = new Button();
        this.kihonResearchItemCode = RString.EMPTY;
        this.kihonResearchItemName = RString.EMPTY;
        this.kaitou = RString.EMPTY;
        this.setOriginalData("btnTokkiJiko", btnTokkiJiko);
        this.setOriginalData("kihonResearchItemCode", kihonResearchItemCode);
        this.setOriginalData("kihonResearchItemName", kihonResearchItemName);
        this.setOriginalData("kaitou", kaitou);
    }

    public dgKihonChosa_Row(Button btnTokkiJiko, RString kihonResearchItemCode, RString kihonResearchItemName, RString kaitou) {
        super();
        this.setOriginalData("btnTokkiJiko", btnTokkiJiko);
        this.setOriginalData("kihonResearchItemCode", kihonResearchItemCode);
        this.setOriginalData("kihonResearchItemName", kihonResearchItemName);
        this.setOriginalData("kaitou", kaitou);
        this.btnTokkiJiko = btnTokkiJiko;
        this.kihonResearchItemCode = kihonResearchItemCode;
        this.kihonResearchItemName = kihonResearchItemName;
        this.kaitou = kaitou;
    }

    public Button getBtnTokkiJiko() {
        return btnTokkiJiko;
    }

    public RString getKihonResearchItemCode() {
        return kihonResearchItemCode;
    }

    public RString getKihonResearchItemName() {
        return kihonResearchItemName;
    }

    public RString getKaitou() {
        return kaitou;
    }

    public void setBtnTokkiJiko(Button btnTokkiJiko) {
        this.setOriginalData("btnTokkiJiko", btnTokkiJiko);
        this.btnTokkiJiko = btnTokkiJiko;
    }

    public void setKihonResearchItemCode(RString kihonResearchItemCode) {
        this.setOriginalData("kihonResearchItemCode", kihonResearchItemCode);
        this.kihonResearchItemCode = kihonResearchItemCode;
    }

    public void setKihonResearchItemName(RString kihonResearchItemName) {
        this.setOriginalData("kihonResearchItemName", kihonResearchItemName);
        this.kihonResearchItemName = kihonResearchItemName;
    }

    public void setKaitou(RString kaitou) {
        this.setOriginalData("kaitou", kaitou);
        this.kaitou = kaitou;
    }

    // </editor-fold>
}
