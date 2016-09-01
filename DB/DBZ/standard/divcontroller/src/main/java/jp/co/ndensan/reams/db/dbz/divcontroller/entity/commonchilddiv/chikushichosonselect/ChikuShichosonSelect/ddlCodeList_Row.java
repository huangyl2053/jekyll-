package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chikushichosonselect.ChikuShichosonSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Aug 31 10:28:57 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * ddlCodeList_Row のクラスファイルです。
 *
 * @reamsid_L DBB-5720-010 xuxin
 */
public class ddlCodeList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

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
