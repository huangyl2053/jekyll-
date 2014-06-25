package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 19 11:37:03 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgTokuchoIdoJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTokuchoIdoJoho_Row extends DataRow {

    private Boolean chkTaisho;
    private RString txtTsuki;
    private RString txtShoriNichiji;
    private RString txtShikakuSoshutsu;
    private RString txtJutoku;
    private RString txtKarichoshuGakuShusei;
    private RString txtTsuikaIrai;

    public dgTokuchoIdoJoho_Row() {
        super();
        this.chkTaisho = false;
        this.txtTsuki = RString.EMPTY;
        this.txtShoriNichiji = RString.EMPTY;
        this.txtShikakuSoshutsu = RString.EMPTY;
        this.txtJutoku = RString.EMPTY;
        this.txtKarichoshuGakuShusei = RString.EMPTY;
        this.txtTsuikaIrai = RString.EMPTY;
    }

    public dgTokuchoIdoJoho_Row(Boolean chkTaisho, RString txtTsuki, RString txtShoriNichiji, RString txtShikakuSoshutsu, RString txtJutoku, RString txtKarichoshuGakuShusei, RString txtTsuikaIrai) {
        super();
        this.setOriginalData("chkTaisho", chkTaisho);
        this.setOriginalData("txtTsuki", txtTsuki);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.setOriginalData("txtShikakuSoshutsu", txtShikakuSoshutsu);
        this.setOriginalData("txtJutoku", txtJutoku);
        this.setOriginalData("txtKarichoshuGakuShusei", txtKarichoshuGakuShusei);
        this.setOriginalData("txtTsuikaIrai", txtTsuikaIrai);
        this.chkTaisho = chkTaisho;
        this.txtTsuki = txtTsuki;
        this.txtShoriNichiji = txtShoriNichiji;
        this.txtShikakuSoshutsu = txtShikakuSoshutsu;
        this.txtJutoku = txtJutoku;
        this.txtKarichoshuGakuShusei = txtKarichoshuGakuShusei;
        this.txtTsuikaIrai = txtTsuikaIrai;
    }

    public Boolean getChkTaisho() {
        return chkTaisho;
    }

    public RString getTxtTsuki() {
        return txtTsuki;
    }

    public RString getTxtShoriNichiji() {
        return txtShoriNichiji;
    }

    public RString getTxtShikakuSoshutsu() {
        return txtShikakuSoshutsu;
    }

    public RString getTxtJutoku() {
        return txtJutoku;
    }

    public RString getTxtKarichoshuGakuShusei() {
        return txtKarichoshuGakuShusei;
    }

    public RString getTxtTsuikaIrai() {
        return txtTsuikaIrai;
    }

    public void setChkTaisho(Boolean chkTaisho) {
        this.setOriginalData("chkTaisho", chkTaisho);
        this.chkTaisho = chkTaisho;
    }

    public void setTxtTsuki(RString txtTsuki) {
        this.setOriginalData("txtTsuki", txtTsuki);
        this.txtTsuki = txtTsuki;
    }

    public void setTxtShoriNichiji(RString txtShoriNichiji) {
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.txtShoriNichiji = txtShoriNichiji;
    }

    public void setTxtShikakuSoshutsu(RString txtShikakuSoshutsu) {
        this.setOriginalData("txtShikakuSoshutsu", txtShikakuSoshutsu);
        this.txtShikakuSoshutsu = txtShikakuSoshutsu;
    }

    public void setTxtJutoku(RString txtJutoku) {
        this.setOriginalData("txtJutoku", txtJutoku);
        this.txtJutoku = txtJutoku;
    }

    public void setTxtKarichoshuGakuShusei(RString txtKarichoshuGakuShusei) {
        this.setOriginalData("txtKarichoshuGakuShusei", txtKarichoshuGakuShusei);
        this.txtKarichoshuGakuShusei = txtKarichoshuGakuShusei;
    }

    public void setTxtTsuikaIrai(RString txtTsuikaIrai) {
        this.setOriginalData("txtTsuikaIrai", txtTsuikaIrai);
        this.txtTsuikaIrai = txtTsuikaIrai;
    }

}