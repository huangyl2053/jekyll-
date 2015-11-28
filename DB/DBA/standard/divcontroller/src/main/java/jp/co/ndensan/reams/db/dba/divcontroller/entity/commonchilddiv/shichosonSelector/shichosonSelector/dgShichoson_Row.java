package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shichosonSelector.ShichosonSelector;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Nov 28 19:39:49 CST 2015
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgShichoson_Row のクラスファイル
 *
 * @author 自動生成
 */
public class dgShichoson_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString txtShichosonCode;
    private RString txtShichosonName;

    public dgShichoson_Row() {
        super();
        this.txtShichosonCode = RString.EMPTY;
        this.txtShichosonName = RString.EMPTY;
        this.setOriginalData("txtShichosonCode", txtShichosonCode);
        this.setOriginalData("txtShichosonName", txtShichosonName);
    }

    public dgShichoson_Row(RString txtShichosonCode, RString txtShichosonName) {
        super();
        this.setOriginalData("txtShichosonCode", txtShichosonCode);
        this.setOriginalData("txtShichosonName", txtShichosonName);
        this.txtShichosonCode = txtShichosonCode;
        this.txtShichosonName = txtShichosonName;
    }

    public RString getTxtShichosonCode() {
        return txtShichosonCode;
    }

    public RString getTxtShichosonName() {
        return txtShichosonName;
    }

    public void setTxtShichosonCode(RString txtShichosonCode) {
        this.setOriginalData("txtShichosonCode", txtShichosonCode);
        this.txtShichosonCode = txtShichosonCode;
    }

    public void setTxtShichosonName(RString txtShichosonName) {
        this.setOriginalData("txtShichosonName", txtShichosonName);
        this.txtShichosonName = txtShichosonName;
    }

    // </editor-fold>
}
