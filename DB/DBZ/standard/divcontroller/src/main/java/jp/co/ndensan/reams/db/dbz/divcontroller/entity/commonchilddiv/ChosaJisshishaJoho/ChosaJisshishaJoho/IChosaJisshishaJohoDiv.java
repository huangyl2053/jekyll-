package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho;

import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/*
 * このコードはツールによって生成されました。
 */
public interface IChosaJisshishaJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * 調査実施者(記入者)Divの初期化します。
     *
     * @param key 親画面から受け取ったパラメータ
     */
    public void intialize(ChosaJisshishaJohoModel key);

    /**
     * 画面モードの設定します。
     *
     * @param value モード
     */
    public void setMode_State(ChosaJisshishaJohoDiv.State value);

    /*
     * gettxtChosaJisshiDate
     * @return txtChosaJisshiDate
     */
    public TextBoxDate getTxtChosaJisshiDate();

    /*
     * settxtChosaJisshiDate
     * @param txtChosaJisshiDate txtChosaJisshiDate
     */
    public void setTxtChosaJisshiDate(TextBoxDate txtChosaJisshiDate);

    /*
     * getddlChosaJisshiBasho
     * @return ddlChosaJisshiBasho
     */
    public DropDownList getDdlChosaJisshiBasho();

    /*
     * setddlChosaJisshiBasho
     * @param ddlChosaJisshiBasho ddlChosaJisshiBasho
     */
    public void setDdlChosaJisshiBasho(DropDownList ddlChosaJisshiBasho);

    /*
     * gettxtJisshiBashoMeisho
     * @return txtJisshiBashoMeisho
     */
    public TextBox getTxtJisshiBashoMeisho();

    /*
     * settxtJisshiBashoMeisho
     * @param txtJisshiBashoMeisho txtJisshiBashoMeisho
     */
    public void setTxtJisshiBashoMeisho(TextBox txtJisshiBashoMeisho);

    /*
     * getddlShozokuKikan
     * @return ddlShozokuKikan
     */
    public DropDownList getDdlShozokuKikan();

    /*
     * setddlShozokuKikan
     * @param ddlShozokuKikan ddlShozokuKikan
     */
    public void setDdlShozokuKikan(DropDownList ddlShozokuKikan);

    /*
     * getddlKinyusha
     * @return ddlKinyusha
     */
    public DropDownList getDdlKinyusha();

    /*
     * setddlKinyusha
     * @param ddlKinyusha ddlKinyusha
     */
    public void setDdlKinyusha(DropDownList ddlKinyusha);

    /*
     * gettxtChosaKubun
     * @return txtChosaKubun
     */
    public TextBox getTxtChosaKubun();

    /*
     * settxtChosaKubun
     * @param txtChosaKubun txtChosaKubun
     */
    public void setTxtChosaKubun(TextBox txtChosaKubun);

}
