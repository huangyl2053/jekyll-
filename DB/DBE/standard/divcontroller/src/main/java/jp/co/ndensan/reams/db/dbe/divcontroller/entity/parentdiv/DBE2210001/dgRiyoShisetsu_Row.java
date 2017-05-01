package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 01 09:26:49 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgRiyoShisetsu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRiyoShisetsu_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">

    private Boolean shisetsuRiyoUmu;
    private RString shisetsuRiyoName;
    private TextBoxNum remban;

    public dgRiyoShisetsu_Row() {
        super();
        this.shisetsuRiyoUmu = false;
        this.shisetsuRiyoName = RString.EMPTY;
        this.remban = new TextBoxNum();
        this.setOriginalData("shisetsuRiyoUmu", shisetsuRiyoUmu);
        this.setOriginalData("shisetsuRiyoName", shisetsuRiyoName);
        this.setOriginalData("remban", remban);
    }

    public dgRiyoShisetsu_Row(Boolean shisetsuRiyoUmu, RString shisetsuRiyoName, TextBoxNum remban) {
        super();
        this.setOriginalData("shisetsuRiyoUmu", shisetsuRiyoUmu);
        this.setOriginalData("shisetsuRiyoName", shisetsuRiyoName);
        this.setOriginalData("remban", remban);
        this.shisetsuRiyoUmu = shisetsuRiyoUmu;
        this.shisetsuRiyoName = shisetsuRiyoName;
        this.remban = remban;
    }

    public Boolean getShisetsuRiyoUmu() {
        return shisetsuRiyoUmu;
    }

    public RString getShisetsuRiyoName() {
        return shisetsuRiyoName;
    }

    public TextBoxNum getRemban() {
        return remban;
    }

    public void setShisetsuRiyoUmu(Boolean shisetsuRiyoUmu) {
        this.setOriginalData("shisetsuRiyoUmu", shisetsuRiyoUmu);
        this.shisetsuRiyoUmu = shisetsuRiyoUmu;
    }

    public void setShisetsuRiyoName(RString shisetsuRiyoName) {
        this.setOriginalData("shisetsuRiyoName", shisetsuRiyoName);
        this.shisetsuRiyoName = shisetsuRiyoName;
    }

    public void setRemban(TextBoxNum remban) {
        this.setOriginalData("remban", remban);
        this.remban = remban;
    }

    // </editor-fold>
}
