package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.koseishichosonselector.KoseiShiChosonSelector;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jan 29 19:56:50 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKoseiShichosonList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKoseiShichosonList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString shichosonname;
    private RString shicosoncode;
    private RString shokisaihokenshano;

    public dgKoseiShichosonList_Row() {
        super();
        this.shichosonname = RString.EMPTY;
        this.shicosoncode = RString.EMPTY;
        this.shokisaihokenshano = RString.EMPTY;
        this.setOriginalData("shichosonname", shichosonname);
        this.setOriginalData("shicosoncode", shicosoncode);
        this.setOriginalData("shokisaihokenshano", shokisaihokenshano);
    }

    public dgKoseiShichosonList_Row(RString shichosonname, RString shicosoncode, RString shokisaihokenshano) {
        super();
        this.setOriginalData("shichosonname", shichosonname);
        this.setOriginalData("shicosoncode", shicosoncode);
        this.setOriginalData("shokisaihokenshano", shokisaihokenshano);
        this.shichosonname = shichosonname;
        this.shicosoncode = shicosoncode;
        this.shokisaihokenshano = shokisaihokenshano;
    }

    public RString getShichosonname() {
        return shichosonname;
    }

    public RString getShicosoncode() {
        return shicosoncode;
    }

    public RString getShokisaihokenshano() {
        return shokisaihokenshano;
    }

    public void setShichosonname(RString shichosonname) {
        this.setOriginalData("shichosonname", shichosonname);
        this.shichosonname = shichosonname;
    }

    public void setShicosoncode(RString shicosoncode) {
        this.setOriginalData("shicosoncode", shicosoncode);
        this.shicosoncode = shicosoncode;
    }

    public void setShokisaihokenshano(RString shokisaihokenshano) {
        this.setOriginalData("shokisaihokenshano", shokisaihokenshano);
        this.shokisaihokenshano = shokisaihokenshano;
    }

    // </editor-fold>
}
