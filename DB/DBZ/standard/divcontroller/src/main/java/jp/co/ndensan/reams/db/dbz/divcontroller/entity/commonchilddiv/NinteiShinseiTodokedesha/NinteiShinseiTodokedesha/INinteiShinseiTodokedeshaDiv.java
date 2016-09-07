package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha;

import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaNaiyo;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.IZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
public interface INinteiShinseiTodokedeshaDiv extends ICommonChildDivBaseProperties {

    /**
     * 共通子DIVの初期化処理です。
     *
     * @param model NinteiShinseiTodokedeshaDataPassModel
     */
    public void initialize(NinteiShinseiTodokedeshaDataPassModel model);

    /**
     * 状態の設定すます。
     *
     * @param mode mode
     */
    public void set状態(RString mode);

    /**
     * 画面一覧内容を取得。
     *
     * @return NinteiShinseiTodokedeshaNaiyo NinteiShinseiTodokedeshaNaiyo
     */
    public NinteiShinseiTodokedeshaNaiyo get一覧内容();

    /**
     * 届出代行区分を取得。
     *
     * @return DropDownList
     */
    public DropDownList getDdlTodokledeDaikoKubun();

    /**
     * 届出代行区分を設定。
     *
     * @param ddlTodokledeDaikoKubun DropDownList
     */
    public void setDdlTodokledeDaikoKubun(DropDownList ddlTodokledeDaikoKubun);

    /**
     * 事業者を設定。
     *
     * @param txtJigyoshaCode TextBox
     */
    public void setTxtJigyoshaCode(TextBox txtJigyoshaCode);

    /**
     * 申請関係者を取得。
     *
     * @return DropDownList
     */
    public DropDownList getDdlShinseiKankeisha();

    /**
     * 申請関係者を設定。
     *
     * @param ddlShinseiKankeisha DropDownList
     */
    public void setDdlShinseiKankeisha(DropDownList ddlShinseiKankeisha);

    /**
     * 氏名を設定。
     *
     * @param txtShimei TextBox
     */
    public void setTxtShimei(TextBox txtShimei);

    /**
     * カナ氏名を設定。
     *
     * @param txtKanaShimei TextBox
     */
    public void setTxtKanaShimei(TextBox txtKanaShimei);

    /**
     * 本人との関係性を設定。
     *
     * @param txtHonninKankeisei TextBox
     */
    public void setTxtHonninKankeisei(TextBox txtHonninKankeisei);

    /**
     * 管内管外区分を取得。
     *
     * @return RadioButton
     */
    public RadioButton getRadKannaiKangai();

    /**
     * 電話番号を設定。
     *
     * @param txtTelNo TextBoxTelNo
     */
    public void setTxtTelNo(TextBoxTelNo txtTelNo);

    /**
     * 郵便番号を設定。
     *
     * @param txtYubinNo TextBoxYubinNo
     */
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo);

    /**
     * IChoikiInputDivを取得。
     *
     * @return IChoikiInputDiv
     */
    public IChoikiInputDiv getCcdChoikiInput();

    /**
     * IZenkokuJushoInputDivを取得。
     *
     * @return IZenkokuJushoInputDiv
     */
    public IZenkokuJushoInputDiv getCcdZenkokuJushoInput();

}
