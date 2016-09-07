package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jul 22 11:55:52 JST 2015
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row のクラスファイル
 *
 * @reamsid_L DBC-2101-010 quxiaodong
 */
public class dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">

    private TextBoxDate txtResultIdoDate;
    private RString txtTaishoNengetsu;
    private TextBoxCode txtResultHihoNo;
    private TextBox txtResultHihoName;

    public dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row() {
        super();
        this.txtResultIdoDate = new TextBoxDate();
        this.txtTaishoNengetsu = RString.EMPTY;
        this.txtResultHihoNo = new TextBoxCode();
        this.txtResultHihoName = new TextBox();
    }

    public dgJukyushaIdoRenrakuhyoHenkoSearchResult_Row(TextBoxDate txtResultIdoDate, RString txtTaishoNengetsu, TextBoxCode txtResultHihoNo, TextBox txtResultHihoName) {
        super();
        this.setOriginalData("txtResultIdoDate", txtResultIdoDate);
        this.setOriginalData("txtTaishoNengetsu", txtTaishoNengetsu);
        this.setOriginalData("txtResultHihoNo", txtResultHihoNo);
        this.setOriginalData("txtResultHihoName", txtResultHihoName);
        this.txtResultIdoDate = txtResultIdoDate;
        this.txtTaishoNengetsu = txtTaishoNengetsu;
        this.txtResultHihoNo = txtResultHihoNo;
        this.txtResultHihoName = txtResultHihoName;
    }

    public TextBoxDate getTxtResultIdoDate() {
        return txtResultIdoDate;
    }

    public RString getTxtTaishoNengetsu() {
        return txtTaishoNengetsu;
    }

    public TextBoxCode getTxtResultHihoNo() {
        return txtResultHihoNo;
    }

    public TextBox getTxtResultHihoName() {
        return txtResultHihoName;
    }

    public void setTxtResultIdoDate(TextBoxDate txtResultIdoDate) {
        this.setOriginalData("txtResultIdoDate", txtResultIdoDate);
        this.txtResultIdoDate = txtResultIdoDate;
    }

    public void setTxtTaishoNengetsu(RString txtTaishoNengetsu) {
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

    // </editor-fold>
}
