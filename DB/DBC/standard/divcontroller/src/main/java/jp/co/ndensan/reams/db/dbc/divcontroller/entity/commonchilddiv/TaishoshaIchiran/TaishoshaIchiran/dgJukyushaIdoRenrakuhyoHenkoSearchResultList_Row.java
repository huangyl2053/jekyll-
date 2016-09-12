package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.TaishoshaIchiran.TaishoshaIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jul 06 20:56:28 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row のクラスファイル
 *
 * @reamsid_L DBC-4471-010 xupeng
 */
public class dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private TextBoxDate txtResultIdoDate;
    private TextBoxDate txtTaishoNengetsu;
    private TextBoxCode txtResultHihoNo;
    private TextBox txtResultHihoName;
    private RString txtRirekiNo;
    private RString txtDeleteFlag;

    public dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row() {
        super();
        this.txtResultIdoDate = new TextBoxDate();
        this.txtTaishoNengetsu = new TextBoxDate();
        this.txtResultHihoNo = new TextBoxCode();
        this.txtResultHihoName = new TextBox();
        this.txtRirekiNo = RString.EMPTY;
        this.txtDeleteFlag = RString.EMPTY;
        this.setOriginalData("txtResultIdoDate", txtResultIdoDate);
        this.setOriginalData("txtTaishoNengetsu", txtTaishoNengetsu);
        this.setOriginalData("txtResultHihoNo", txtResultHihoNo);
        this.setOriginalData("txtResultHihoName", txtResultHihoName);
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.setOriginalData("txtDeleteFlag", txtDeleteFlag);
    }

    public dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row(TextBoxDate txtResultIdoDate, TextBoxDate txtTaishoNengetsu, TextBoxCode txtResultHihoNo, TextBox txtResultHihoName, RString txtRirekiNo, RString txtDeleteFlag) {
        super();
        this.setOriginalData("txtResultIdoDate", txtResultIdoDate);
        this.setOriginalData("txtTaishoNengetsu", txtTaishoNengetsu);
        this.setOriginalData("txtResultHihoNo", txtResultHihoNo);
        this.setOriginalData("txtResultHihoName", txtResultHihoName);
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.setOriginalData("txtDeleteFlag", txtDeleteFlag);
        this.txtResultIdoDate = txtResultIdoDate;
        this.txtTaishoNengetsu = txtTaishoNengetsu;
        this.txtResultHihoNo = txtResultHihoNo;
        this.txtResultHihoName = txtResultHihoName;
        this.txtRirekiNo = txtRirekiNo;
        this.txtDeleteFlag = txtDeleteFlag;
    }

    public TextBoxDate getTxtResultIdoDate() {
        return txtResultIdoDate;
    }

    public TextBoxDate getTxtTaishoNengetsu() {
        return txtTaishoNengetsu;
    }

    public TextBoxCode getTxtResultHihoNo() {
        return txtResultHihoNo;
    }

    public TextBox getTxtResultHihoName() {
        return txtResultHihoName;
    }

    public RString getTxtRirekiNo() {
        return txtRirekiNo;
    }

    public RString getTxtDeleteFlag() {
        return txtDeleteFlag;
    }

    public void setTxtResultIdoDate(TextBoxDate txtResultIdoDate) {
        this.setOriginalData("txtResultIdoDate", txtResultIdoDate);
        this.txtResultIdoDate = txtResultIdoDate;
    }

    public void setTxtTaishoNengetsu(TextBoxDate txtTaishoNengetsu) {
        this.setOriginalData("txtTaishoNengetsu", txtTaishoNengetsu);
        this.txtTaishoNengetsu = txtTaishoNengetsu;
    }

    public void setTxtResultHihoNo(TextBoxCode txtResultHihoNo) {
        this.setOriginalData("txtResultHihoNo", txtResultHihoNo);
        this.txtResultHihoNo = txtResultHihoNo;
    }

    public void setTxtResultHihoName(TextBox txtResultHihoName) {
        this.setOriginalData("txtResultHihoName", txtResultHihoName);
        this.txtResultHihoName = txtResultHihoName;
    }

    public void setTxtRirekiNo(RString txtRirekiNo) {
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.txtRirekiNo = txtRirekiNo;
    }

    public void setTxtDeleteFlag(RString txtDeleteFlag) {
        this.setOriginalData("txtDeleteFlag", txtDeleteFlag);
        this.txtDeleteFlag = txtDeleteFlag;
    }

    // </editor-fold>
}
