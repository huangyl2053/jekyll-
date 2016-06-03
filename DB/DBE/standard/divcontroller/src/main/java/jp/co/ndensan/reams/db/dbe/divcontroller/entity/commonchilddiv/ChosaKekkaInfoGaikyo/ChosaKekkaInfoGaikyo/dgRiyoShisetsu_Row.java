package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo.ChosaKekkaInfoGaikyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue May 31 20:05:49 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgRiyoShisetsu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRiyoShisetsu_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private Boolean shisetsuRiyoFlag;
    private RString shisetsuRiyoFlagName;

    public dgRiyoShisetsu_Row() {
        super();
        this.shisetsuRiyoFlag = false;
        this.shisetsuRiyoFlagName = RString.EMPTY;
        this.setOriginalData("shisetsuRiyoFlag", shisetsuRiyoFlag);
        this.setOriginalData("shisetsuRiyoFlagName", shisetsuRiyoFlagName);
    }

    public dgRiyoShisetsu_Row(Boolean shisetsuRiyoFlag, RString shisetsuRiyoFlagName) {
        super();
        this.setOriginalData("shisetsuRiyoFlag", shisetsuRiyoFlag);
        this.setOriginalData("shisetsuRiyoFlagName", shisetsuRiyoFlagName);
        this.shisetsuRiyoFlag = shisetsuRiyoFlag;
        this.shisetsuRiyoFlagName = shisetsuRiyoFlagName;
    }

    public Boolean getShisetsuRiyoFlag() {
        return shisetsuRiyoFlag;
    }

    public RString getShisetsuRiyoFlagName() {
        return shisetsuRiyoFlagName;
    }

    public void setShisetsuRiyoFlag(Boolean shisetsuRiyoFlag) {
        this.setOriginalData("shisetsuRiyoFlag", shisetsuRiyoFlag);
        this.shisetsuRiyoFlag = shisetsuRiyoFlag;
    }

    public void setShisetsuRiyoFlagName(RString shisetsuRiyoFlagName) {
        this.setOriginalData("shisetsuRiyoFlagName", shisetsuRiyoFlagName);
        this.shisetsuRiyoFlagName = shisetsuRiyoFlagName;
    }

    // </editor-fold>
}
