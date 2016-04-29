package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeCommonChildDiv.ServiceTypeCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Mar 30 16:41:54 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgServiceType_Row のクラスファイル
 *
 * @reamsid_L DBA-0070-010 chengsanyuan
 */
public class dgServiceType_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString txtServiceShuruiCode;
    private RString txtServiceShuruiName;

    public dgServiceType_Row() {
        super();
        this.txtServiceShuruiCode = RString.EMPTY;
        this.txtServiceShuruiName = RString.EMPTY;
        this.setOriginalData("txtServiceShuruiCode", txtServiceShuruiCode);
        this.setOriginalData("txtServiceShuruiName", txtServiceShuruiName);
    }

    public dgServiceType_Row(RString txtServiceShuruiCode, RString txtServiceShuruiName) {
        super();
        this.setOriginalData("txtServiceShuruiCode", txtServiceShuruiCode);
        this.setOriginalData("txtServiceShuruiName", txtServiceShuruiName);
        this.txtServiceShuruiCode = txtServiceShuruiCode;
        this.txtServiceShuruiName = txtServiceShuruiName;
    }

    public RString getTxtServiceShuruiCode() {
        return txtServiceShuruiCode;
    }

    public RString getTxtServiceShuruiName() {
        return txtServiceShuruiName;
    }

    public void setTxtServiceShuruiCode(RString txtServiceShuruiCode) {
        this.setOriginalData("txtServiceShuruiCode", txtServiceShuruiCode);
        this.txtServiceShuruiCode = txtServiceShuruiCode;
    }

    public void setTxtServiceShuruiName(RString txtServiceShuruiName) {
        this.setOriginalData("txtServiceShuruiName", txtServiceShuruiName);
        this.txtServiceShuruiName = txtServiceShuruiName;
    }

    // </editor-fold>
}
