package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho;

import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBE-3000-100 dongyabin
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

    /**
     * バリデーション結果を取得します。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate();

    /*
     * gettxtShinseiDate
     * @return txtShinseiDate
     */
    public TextBoxFlexibleDate getTxtNinteiShinseiDate();

    /*
     * settxtShinseiDate
     * @param txtShinseiDate txtShinseiDate
     */
    public void setTxtNinteiShinseiDate(TextBoxFlexibleDate txtNinteiShinseiDate);

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
     * gettxtShozokuKikanCode
     * @return txtShozokuKikanCode
     */
    public TextBoxCode getTxtShozokuKikanCode();

    /*
     * settxtShozokuKikanCode
     * @param txtShozokuKikanCode txtShozokuKikanCode
     */
    public void setTxtShozokuKikanCode(TextBoxCode txtShozokuKikanCode);

    /*
     * gettxtShozokuKikanName
     * @return txtShozokuKikanName
     */
    public TextBox getTxtShozokuKikanName();

    /*
     * settxtShozokuKikanName
     * @param txtShozokuKikanName txtShozokuKikanName
     */
    public void setTxtShozokuKikanName(TextBox txtShozokuKikanName);

    /*
     * gettxtKinyushaCode
     * @return txtKinyushaCode
     */
    public TextBoxCode getTxtKinyushaCode();

    /*
     * settxtKinyushaCode
     * @param txtKinyushaCode txtKinyushaCode
     */
    public void setTxtKinyushaCode(TextBoxCode txtKinyushaCode);

    /*
     * gettxtKinyushaName
     * @return txtKinyushaName
     */
    public TextBox getTxtKinyushaName();

    /*
     * settxtKinyushaName
     * @param txtKinyushaName txtKinyushaName
     */
    public void setTxtKinyushaName(TextBox txtKinyushaName);

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
