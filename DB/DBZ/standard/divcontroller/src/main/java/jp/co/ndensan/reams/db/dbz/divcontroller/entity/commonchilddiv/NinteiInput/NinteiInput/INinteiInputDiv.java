package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput;

import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBE-1300-080 yaodongsheng
 */
public interface INinteiInputDiv extends ICommonChildDivBaseProperties {

    /**
     * 共通子DIVの初期化処理です。
     *
     * @param model NinteiInputDataPassModel
     */
    public void initialize(NinteiInputDataPassModel model);

    /**
     * 状態の設定すます。
     *
     * @param mode mode
     */
    public void set状態(RString mode);

    /**
     * 開始終了日前後順checkです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 開始終了日前後順check();
}
