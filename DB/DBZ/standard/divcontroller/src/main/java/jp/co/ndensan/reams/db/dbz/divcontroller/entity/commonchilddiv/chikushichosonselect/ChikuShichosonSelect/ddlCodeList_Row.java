package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Dec 22 13:09:13 JST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * ddlCodeList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class ddlCodeList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString code;
    private RString name;

    public ddlCodeList_Row() {
        super();
        this.code = RString.EMPTY;
        this.name = RString.EMPTY;
        this.setOriginalData("code", code);
        this.setOriginalData("name", name);
    }

    public ddlCodeList_Row(RString code, RString name) {
        super();
        this.setOriginalData("code", code);
        this.setOriginalData("name", name);
        this.code = code;
        this.name = name;
    }

    public RString getCode() {
        return code;
    }

    public RString getName() {
        return name;
    }

    public void setCode(RString code) {
        this.setOriginalData("code", code);
        this.code = code;
    }

    public void setName(RString name) {
        this.setOriginalData("name", name);
        this.name = name;
    }

    // </editor-fold>
}
