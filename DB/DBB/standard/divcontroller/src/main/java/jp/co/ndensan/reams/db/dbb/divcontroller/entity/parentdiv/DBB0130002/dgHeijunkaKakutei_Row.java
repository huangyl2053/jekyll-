package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0130002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jul 12 19:58:08 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgHeijunkaKakutei_Row のクラスファイル
 *
 * @reamsid_L DBB-0830-010 wangkanglei
 */
public class dgHeijunkaKakutei_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtHokenryoDankai;
    private TextBoxNum txtSagaku;
    private RString txtHeijunkaKensu;
    private RString txtKakuteiKensu;
    private RString txtTaishogaiKensu;
    private RString txtDankaiKubun;

    public dgHeijunkaKakutei_Row() {
        super();
        this.txtHokenryoDankai = RString.EMPTY;
        this.txtSagaku = new TextBoxNum();
        this.txtHeijunkaKensu = RString.EMPTY;
        this.txtKakuteiKensu = RString.EMPTY;
        this.txtTaishogaiKensu = RString.EMPTY;
        this.txtDankaiKubun = RString.EMPTY;
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.setOriginalData("txtSagaku", txtSagaku);
        this.setOriginalData("txtHeijunkaKensu", txtHeijunkaKensu);
        this.setOriginalData("txtKakuteiKensu", txtKakuteiKensu);
        this.setOriginalData("txtTaishogaiKensu", txtTaishogaiKensu);
        this.setOriginalData("txtDankaiKubun", txtDankaiKubun);
    }

    public dgHeijunkaKakutei_Row(RString txtHokenryoDankai, TextBoxNum txtSagaku, RString txtHeijunkaKensu, RString txtKakuteiKensu, RString txtTaishogaiKensu, RString txtDankaiKubun) {
        super();
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.setOriginalData("txtSagaku", txtSagaku);
        this.setOriginalData("txtHeijunkaKensu", txtHeijunkaKensu);
        this.setOriginalData("txtKakuteiKensu", txtKakuteiKensu);
        this.setOriginalData("txtTaishogaiKensu", txtTaishogaiKensu);
        this.setOriginalData("txtDankaiKubun", txtDankaiKubun);
        this.txtHokenryoDankai = txtHokenryoDankai;
        this.txtSagaku = txtSagaku;
        this.txtHeijunkaKensu = txtHeijunkaKensu;
        this.txtKakuteiKensu = txtKakuteiKensu;
        this.txtTaishogaiKensu = txtTaishogaiKensu;
        this.txtDankaiKubun = txtDankaiKubun;
    }

    public RString getTxtHokenryoDankai() {
        return txtHokenryoDankai;
    }

    public TextBoxNum getTxtSagaku() {
        return txtSagaku;
    }

    public RString getTxtHeijunkaKensu() {
        return txtHeijunkaKensu;
    }

    public RString getTxtKakuteiKensu() {
        return txtKakuteiKensu;
    }

    public RString getTxtTaishogaiKensu() {
        return txtTaishogaiKensu;
    }

    public RString getTxtDankaiKubun() {
        return txtDankaiKubun;
    }

    public void setTxtHokenryoDankai(RString txtHokenryoDankai) {
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.txtHokenryoDankai = txtHokenryoDankai;
    }

    public void setTxtSagaku(TextBoxNum txtSagaku) {
        this.setOriginalData("txtSagaku", txtSagaku);
        this.txtSagaku = txtSagaku;
    }

    public void setTxtHeijunkaKensu(RString txtHeijunkaKensu) {
        this.setOriginalData("txtHeijunkaKensu", txtHeijunkaKensu);
        this.txtHeijunkaKensu = txtHeijunkaKensu;
    }

    public void setTxtKakuteiKensu(RString txtKakuteiKensu) {
        this.setOriginalData("txtKakuteiKensu", txtKakuteiKensu);
        this.txtKakuteiKensu = txtKakuteiKensu;
    }

    public void setTxtTaishogaiKensu(RString txtTaishogaiKensu) {
        this.setOriginalData("txtTaishogaiKensu", txtTaishogaiKensu);
        this.txtTaishogaiKensu = txtTaishogaiKensu;
    }

    public void setTxtDankaiKubun(RString txtDankaiKubun) {
        this.setOriginalData("txtDankaiKubun", txtDankaiKubun);
        this.txtDankaiKubun = txtDankaiKubun;
    }

    // </editor-fold>
}
