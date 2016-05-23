package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha;

import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaDataPassModel;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBE-1300-110 yaodongsheng
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
}
