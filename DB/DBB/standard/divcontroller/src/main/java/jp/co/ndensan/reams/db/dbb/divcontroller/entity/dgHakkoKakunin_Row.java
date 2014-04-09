package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 09:37:23 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgHakkoKakunin_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHakkoKakunin_Row extends DataRow {

    private RString txtSofusaki;
    private RString txtTennyuuOrTenshutsu;
    private RString txtGenJusho;
    private RString txtKakuninShotokuKubun;
    private RString txtSetaiin;

    public dgHakkoKakunin_Row() {
        super();
    }

    public dgHakkoKakunin_Row(RString txtSofusaki, RString txtTennyuuOrTenshutsu, RString txtGenJusho, RString txtKakuninShotokuKubun, RString txtSetaiin) {
        super();
        this.setOriginalData("txtSofusaki", txtSofusaki);
        this.setOriginalData("txtTennyuuOrTenshutsu", txtTennyuuOrTenshutsu);
        this.setOriginalData("txtGenJusho", txtGenJusho);
        this.setOriginalData("txtKakuninShotokuKubun", txtKakuninShotokuKubun);
        this.setOriginalData("txtSetaiin", txtSetaiin);
        this.txtSofusaki = txtSofusaki;
        this.txtTennyuuOrTenshutsu = txtTennyuuOrTenshutsu;
        this.txtGenJusho = txtGenJusho;
        this.txtKakuninShotokuKubun = txtKakuninShotokuKubun;
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

    public RString getTxtKakuninShotokuKubun() {
        return txtKakuninShotokuKubun;
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

    public void setTxtKakuninShotokuKubun(RString txtKakuninShotokuKubun) {
        this.setOriginalData("txtKakuninShotokuKubun", txtKakuninShotokuKubun);
        this.txtKakuninShotokuKubun = txtKakuninShotokuKubun;
    }

    public void setTxtSetaiin(RString txtSetaiin) {
        this.setOriginalData("txtSetaiin", txtSetaiin);
        this.txtSetaiin = txtSetaiin;
    }

}