package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.koseishichosonselector.KoseiShiChosonSelector;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 01 11:33:37 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKoseiShichosonList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKoseiShichosonList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString shichosonname;
    private RString shicosoncode;

    public dgKoseiShichosonList_Row() {
        super();
        this.shichosonname = RString.EMPTY;
        this.shicosoncode = RString.EMPTY;
        this.setOriginalData("shichosonname", shichosonname);
        this.setOriginalData("shicosoncode", shicosoncode);
    }

    public dgKoseiShichosonList_Row(RString shichosonname, RString shicosoncode) {
        super();
        this.setOriginalData("shichosonname", shichosonname);
        this.setOriginalData("shicosoncode", shicosoncode);
        this.shichosonname = shichosonname;
        this.shicosoncode = shicosoncode;
    }

    public RString getShichosonname() {
        return shichosonname;
    }

    public RString getShicosoncode() {
        return shicosoncode;
    }

    public void setShichosonname(RString shichosonname) {
        this.setOriginalData("shichosonname", shichosonname);
        this.shichosonname = shichosonname;
    }

    public void setShicosoncode(RString shicosoncode) {
        this.setOriginalData("shicosoncode", shicosoncode);
        this.shicosoncode = shicosoncode;
    }

    // </editor-fold>
}
