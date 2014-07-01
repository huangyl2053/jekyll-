package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB1140001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 17 13:57:06 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSaihakko_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSaihakko_Row extends DataRow {

    private Boolean chkSentaku;
    private RString txtShoriNendo;
    private RString txtShoriNichiji;
    private RString txtHakkoKensu;
    private RString txtUser;

    public dgSaihakko_Row() {
        super();
        this.chkSentaku = false;
        this.txtShoriNendo = RString.EMPTY;
        this.txtShoriNichiji = RString.EMPTY;
        this.txtHakkoKensu = RString.EMPTY;
        this.txtUser = RString.EMPTY;
    }

    public dgSaihakko_Row(Boolean chkSentaku, RString txtShoriNendo, RString txtShoriNichiji, RString txtHakkoKensu, RString txtUser) {
        super();
        this.setOriginalData("chkSentaku", chkSentaku);
        this.setOriginalData("txtShoriNendo", txtShoriNendo);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.setOriginalData("txtHakkoKensu", txtHakkoKensu);
        this.setOriginalData("txtUser", txtUser);
        this.chkSentaku = chkSentaku;
        this.txtShoriNendo = txtShoriNendo;
        this.txtShoriNichiji = txtShoriNichiji;
        this.txtHakkoKensu = txtHakkoKensu;
        this.txtUser = txtUser;
    }

    public Boolean getChkSentaku() {
        return chkSentaku;
    }

    public RString getTxtShoriNendo() {
        return txtShoriNendo;
    }

    public RString getTxtShoriNichiji() {
        return txtShoriNichiji;
    }

    public RString getTxtHakkoKensu() {
        return txtHakkoKensu;
    }

    public RString getTxtUser() {
        return txtUser;
    }

    public void setChkSentaku(Boolean chkSentaku) {
        this.setOriginalData("chkSentaku", chkSentaku);
        this.chkSentaku = chkSentaku;
    }

    public void setTxtShoriNendo(RString txtShoriNendo) {
        this.setOriginalData("txtShoriNendo", txtShoriNendo);
        this.txtShoriNendo = txtShoriNendo;
    }

    public void setTxtShoriNichiji(RString txtShoriNichiji) {
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.txtShoriNichiji = txtShoriNichiji;
    }

    public void setTxtHakkoKensu(RString txtHakkoKensu) {
        this.setOriginalData("txtHakkoKensu", txtHakkoKensu);
        this.txtHakkoKensu = txtHakkoKensu;
    }

    public void setTxtUser(RString txtUser) {
        this.setOriginalData("txtUser", txtUser);
        this.txtUser = txtUser;
    }

}