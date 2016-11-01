package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1320011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 27 13:08:27 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * grdTuuchiJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class grdTuuchiJoho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtFileName;
    private RString txtHokenshaName;
    private RString txtServiceNengetsu;

    public grdTuuchiJoho_Row() {
        super();
        this.txtFileName = RString.EMPTY;
        this.txtHokenshaName = RString.EMPTY;
        this.txtServiceNengetsu = RString.EMPTY;
        this.setOriginalData("txtFileName", txtFileName);
        this.setOriginalData("txtHokenshaName", txtHokenshaName);
        this.setOriginalData("txtServiceNengetsu", txtServiceNengetsu);
    }

    public grdTuuchiJoho_Row(RString txtFileName, RString txtHokenshaName, RString txtServiceNengetsu) {
        super();
        this.setOriginalData("txtFileName", txtFileName);
        this.setOriginalData("txtHokenshaName", txtHokenshaName);
        this.setOriginalData("txtServiceNengetsu", txtServiceNengetsu);
        this.txtFileName = txtFileName;
        this.txtHokenshaName = txtHokenshaName;
        this.txtServiceNengetsu = txtServiceNengetsu;
    }

    public RString getTxtFileName() {
        return txtFileName;
    }

    public RString getTxtHokenshaName() {
        return txtHokenshaName;
    }

    public RString getTxtServiceNengetsu() {
        return txtServiceNengetsu;
    }

    public void setTxtFileName(RString txtFileName) {
        this.setOriginalData("txtFileName", txtFileName);
        this.txtFileName = txtFileName;
    }

    public void setTxtHokenshaName(RString txtHokenshaName) {
        this.setOriginalData("txtHokenshaName", txtHokenshaName);
        this.txtHokenshaName = txtHokenshaName;
    }

    public void setTxtServiceNengetsu(RString txtServiceNengetsu) {
        this.setOriginalData("txtServiceNengetsu", txtServiceNengetsu);
        this.txtServiceNengetsu = txtServiceNengetsu;
    }

    // </editor-fold>
}
