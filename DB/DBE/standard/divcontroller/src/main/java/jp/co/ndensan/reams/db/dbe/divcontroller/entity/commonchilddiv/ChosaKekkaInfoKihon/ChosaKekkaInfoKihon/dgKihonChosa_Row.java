package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoKihon.ChosaKekkaInfoKihon;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 26 13:58:07 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKihonChosa_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKihonChosa_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString kihonResearchItemCode;
    private RString kihonResearchItemName;
    private RString kaitou;

    public dgKihonChosa_Row() {
        super();
        this.kihonResearchItemCode = RString.EMPTY;
        this.kihonResearchItemName = RString.EMPTY;
        this.kaitou = RString.EMPTY;
        this.setOriginalData("kihonResearchItemCode", kihonResearchItemCode);
        this.setOriginalData("kihonResearchItemName", kihonResearchItemName);
        this.setOriginalData("kaitou", kaitou);
    }

    public dgKihonChosa_Row(RString kihonResearchItemCode, RString kihonResearchItemName, RString kaitou) {
        super();
        this.setOriginalData("kihonResearchItemCode", kihonResearchItemCode);
        this.setOriginalData("kihonResearchItemName", kihonResearchItemName);
        this.setOriginalData("kaitou", kaitou);
        this.kihonResearchItemCode = kihonResearchItemCode;
        this.kihonResearchItemName = kihonResearchItemName;
        this.kaitou = kaitou;
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
