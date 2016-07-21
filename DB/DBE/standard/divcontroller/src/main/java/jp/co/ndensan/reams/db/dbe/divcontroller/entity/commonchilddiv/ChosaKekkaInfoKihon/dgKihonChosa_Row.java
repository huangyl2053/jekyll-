package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoKihon;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jul 21 19:03:02 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKihonChosa_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKihonChosa_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private ButtonDialog btnTokkiJiko;
    private RString kihonResearchItemCode;
    private RString kihonResearchItemName;
    private RString kaitou;
    private RString ninteichosaTokkijikoNo;

    public dgKihonChosa_Row() {
        super();
        this.btnTokkiJiko = new ButtonDialog();
        this.kihonResearchItemCode = RString.EMPTY;
        this.kihonResearchItemName = RString.EMPTY;
        this.kaitou = RString.EMPTY;
        this.ninteichosaTokkijikoNo = RString.EMPTY;
        this.setOriginalData("btnTokkiJiko", btnTokkiJiko);
        this.setOriginalData("kihonResearchItemCode", kihonResearchItemCode);
        this.setOriginalData("kihonResearchItemName", kihonResearchItemName);
        this.setOriginalData("kaitou", kaitou);
        this.setOriginalData("ninteichosaTokkijikoNo", ninteichosaTokkijikoNo);
    }

    public dgKihonChosa_Row(ButtonDialog btnTokkiJiko, RString kihonResearchItemCode, RString kihonResearchItemName, RString kaitou, RString ninteichosaTokkijikoNo) {
        super();
        this.setOriginalData("btnTokkiJiko", btnTokkiJiko);
        this.setOriginalData("kihonResearchItemCode", kihonResearchItemCode);
        this.setOriginalData("kihonResearchItemName", kihonResearchItemName);
        this.setOriginalData("kaitou", kaitou);
        this.setOriginalData("ninteichosaTokkijikoNo", ninteichosaTokkijikoNo);
        this.btnTokkiJiko = btnTokkiJiko;
        this.kihonResearchItemCode = kihonResearchItemCode;
        this.kihonResearchItemName = kihonResearchItemName;
        this.kaitou = kaitou;
        this.ninteichosaTokkijikoNo = ninteichosaTokkijikoNo;
    }

    public ButtonDialog getBtnTokkiJiko() {
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

    public RString getNinteichosaTokkijikoNo() {
        return ninteichosaTokkijikoNo;
    }

    public void setBtnTokkiJiko(ButtonDialog btnTokkiJiko) {
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

    public void setNinteichosaTokkijikoNo(RString ninteichosaTokkijikoNo) {
        this.setOriginalData("ninteichosaTokkijikoNo", ninteichosaTokkijikoNo);
        this.ninteichosaTokkijikoNo = ninteichosaTokkijikoNo;
    }

    // </editor-fold>
}
