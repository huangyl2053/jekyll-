package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.ServiceCodeCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 03 15:56:29 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgCodeIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgCodeIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString txtServiceCode;
    private RString txtServiceName;

    public dgCodeIchiran_Row() {
        super();
        this.txtServiceCode = RString.EMPTY;
        this.txtServiceName = RString.EMPTY;
        this.setOriginalData("txtServiceCode", txtServiceCode);
        this.setOriginalData("txtServiceName", txtServiceName);
    }

    public dgCodeIchiran_Row(RString txtServiceCode, RString txtServiceName) {
        super();
        this.setOriginalData("txtServiceCode", txtServiceCode);
        this.setOriginalData("txtServiceName", txtServiceName);
        this.txtServiceCode = txtServiceCode;
        this.txtServiceName = txtServiceName;
    }

    public RString getTxtServiceCode() {
        return txtServiceCode;
    }

    public RString getTxtServiceName() {
        return txtServiceName;
    }

    public void setTxtServiceCode(RString txtServiceCode) {
        this.setOriginalData("txtServiceCode", txtServiceCode);
        this.txtServiceCode = txtServiceCode;
    }

    public void setTxtServiceName(RString txtServiceName) {
        this.setOriginalData("txtServiceName", txtServiceName);
        this.txtServiceName = txtServiceName;
    }

    // </editor-fold>
}
