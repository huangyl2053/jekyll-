package jp.co.ndensan.reams.db.dbd.divcontroller.entity.KaigoNinteiShinseiKihonJohoInput;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/*
 * このコードはツールによって生成されました。
 */
public interface IKaigoNinteiShinseiKihonJohoInputDiv extends ICommonChildDivBaseProperties {

    /**
     * 入力された項目をクリアします。
     */
    public void clear();

    /**
     * 画面の初期化を行います。
     */
    public void initialize();

    /**
     * 申請書区分ラジオボタンを取得します。
     *
     * @return radShinseishoKubun
     */
    public RadioButton getRadShinseishoKubun();

    /**
     * 申請年月日テキストボックスを取得します。
     *
     * @return txtShinseiYMD
     */
    public TextBoxDate getTxtShinseiYMD();

    /**
     * 申請種別種別ドロップダウンを取得します。
     *
     * @return ddlShinseiShubetsu
     */
    public DropDownList getDdlShinseiShubetsu();

    /**
     * 申請区分(申請時)ドロップダウンを取得します。
     *
     * @return ddlShinseiKubunShinseiji
     */
    public DropDownList getDdlShinseiKubunShinseiji();

    /**
     * 申請区分（法令）ドロップダウンを取得します。
     *
     * @return ddlShinseiKubunHorei
     */
    public DropDownList getDdlShinseiKubunHorei();

    /**
     * 旧措置者チェックボックスを取得します。
     *
     * @return chkKyuSochisha
     */
    public CheckBoxList getChkKyuSochisha();

    /**
     * 被保険者区分ドロップダウンを取得します。
     *
     * @return ddlHihokenshaKubun
     */
    public DropDownList getDdlHihokenshaKubun();

    /**
     * 資格取得前チェックボックスを取得します。
     *
     * @return chkShikakuShutokuMae
     */
    public CheckBoxList getChkShikakuShutokuMae();

    /**
     * 特定疾病ドロップダウンを取得します。
     *
     * @return ddlTokuteiShippei
     */
    public DropDownList getDdlTokuteiShippei();

    /**
     * 申請状況テキストボックスを取得します。
     *
     * @return txtShinseiJokyo
     */
    public TextBox getTxtShinseiJokyo();

    /**
     * 認定申請理由テキストボックスを取得します。
     *
     * @return txtNinteiShinseRiyu
     */
    public TextBoxMultiLine getTxtNinteiShinseRiyu();

    /**
     * 受け取った引数を申請状況へセットします。
     *
     * @param txtShinseiJokyo 申請状況
     */
    public void setTxtShinseiJokyo(RString txtShinseiJokyo);

}
