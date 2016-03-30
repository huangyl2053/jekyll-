package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DAB2000600;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Mar 30 21:13:17 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgHakkoKakunin_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHakkoKakunin_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString txtSofusaki;
    private RString txtTennyuuOrTenshutsu;
    private RString txtGenJusho;
    private RString txtSetaiin;

    public dgHakkoKakunin_Row() {
        super();
        this.txtSofusaki = RString.EMPTY;
        this.txtTennyuuOrTenshutsu = RString.EMPTY;
        this.txtGenJusho = RString.EMPTY;
        this.txtSetaiin = RString.EMPTY;
        this.setOriginalData("txtSofusaki", txtSofusaki);
        this.setOriginalData("txtTennyuuOrTenshutsu", txtTennyuuOrTenshutsu);
        this.setOriginalData("txtGenJusho", txtGenJusho);
        this.setOriginalData("txtSetaiin", txtSetaiin);
    }

    public dgHakkoKakunin_Row(RString txtSofusaki, RString txtTennyuuOrTenshutsu, RString txtGenJusho, RString txtSetaiin) {
        super();
        this.setOriginalData("txtSofusaki", txtSofusaki);
        this.setOriginalData("txtTennyuuOrTenshutsu", txtTennyuuOrTenshutsu);
        this.setOriginalData("txtGenJusho", txtGenJusho);
        this.setOriginalData("txtSetaiin", txtSetaiin);
        this.txtSofusaki = txtSofusaki;
        this.txtTennyuuOrTenshutsu = txtTennyuuOrTenshutsu;
        this.txtGenJusho = txtGenJusho;
        this.txtSetaiin = txtSetaiin;
    }

    public RString getTxtSofusaki() {
        return txtSofusaki;
    }

    public RString getTxtTennyuuOrTenshutsu() {
        return txtTennyuuOrTenshutsu;
    }

    public RString getTxtGenJusho() {
        return txtGenJusho;
    }

    public RString getTxtSetaiin() {
        return txtSetaiin;
    }

    public void setTxtSofusaki(RString txtSofusaki) {
        this.setOriginalData("txtSofusaki", txtSofusaki);
        this.txtSofusaki = txtSofusaki;
    }

    public void setTxtTennyuuOrTenshutsu(RString txtTennyuuOrTenshutsu) {
        this.setOriginalData("txtTennyuuOrTenshutsu", txtTennyuuOrTenshutsu);
        this.txtTennyuuOrTenshutsu = txtTennyuuOrTenshutsu;
    }

    public void setTxtGenJusho(RString txtGenJusho) {
        this.setOriginalData("txtGenJusho", txtGenJusho);
        this.txtGenJusho = txtGenJusho;
    }

    public void setTxtSetaiin(RString txtSetaiin) {
        this.setOriginalData("txtSetaiin", txtSetaiin);
        this.txtSetaiin = txtSetaiin;
    }

    // </editor-fold>
}
