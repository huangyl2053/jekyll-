package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeCommonChildDiv.ServiceTypeCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Nov 12 21:27:23 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgServiceType_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceType_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">

    private RString txtServiceShuruiCode;
    private RString txtServiceShuruiName;
    private RString txtServiceRyakusho;

    public dgServiceType_Row() {
        super();
        this.txtServiceShuruiCode = RString.EMPTY;
        this.txtServiceShuruiName = RString.EMPTY;
        this.txtServiceRyakusho = RString.EMPTY;
        this.setOriginalData("txtServiceShuruiCode", txtServiceShuruiCode);
        this.setOriginalData("txtServiceShuruiName", txtServiceShuruiName);
        this.setOriginalData("txtServiceRyakusho", txtServiceRyakusho);
    }

    public dgServiceType_Row(RString txtServiceShuruiCode, RString txtServiceShuruiName, RString txtServiceRyakusho) {
        super();
        this.setOriginalData("txtServiceShuruiCode", txtServiceShuruiCode);
        this.setOriginalData("txtServiceShuruiName", txtServiceShuruiName);
        this.setOriginalData("txtServiceRyakusho", txtServiceRyakusho);
        this.txtServiceShuruiCode = txtServiceShuruiCode;
        this.txtServiceShuruiName = txtServiceShuruiName;
        this.txtServiceRyakusho = txtServiceRyakusho;
    }

    public RString getTxtServiceShuruiCode() {
        return txtServiceShuruiCode;
    }

    public RString getTxtServiceShuruiName() {
        return txtServiceShuruiName;
    }

    public RString getTxtServiceRyakusho() {
        return txtServiceRyakusho;
    }

    public void setTxtServiceShuruiCode(RString txtServiceShuruiCode) {
        this.setOriginalData("txtServiceShuruiCode", txtServiceShuruiCode);
        this.txtServiceShuruiCode = txtServiceShuruiCode;
    }

    public void setTxtServiceShuruiName(RString txtServiceShuruiName) {
        this.setOriginalData("txtServiceShuruiName", txtServiceShuruiName);
        this.txtServiceShuruiName = txtServiceShuruiName;
    }

    public void setTxtServiceRyakusho(RString txtServiceRyakusho) {
        this.setOriginalData("txtServiceRyakusho", txtServiceRyakusho);
        this.txtServiceRyakusho = txtServiceRyakusho;
    }

    // </editor-fold>
}
