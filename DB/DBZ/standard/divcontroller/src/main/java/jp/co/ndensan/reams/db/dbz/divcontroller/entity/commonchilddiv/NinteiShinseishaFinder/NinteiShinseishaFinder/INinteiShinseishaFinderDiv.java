package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;

import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public interface INinteiShinseishaFinderDiv extends ICommonChildDivBaseProperties {

    /**
     * 初期化処理です。
     */
    void initialize();

    /**
     * 検索条件DIVを取得します。被保険者氏名のonBlurイベントは反映済みとして返却します。
     *
     * @return NinteiShinseishaFinderDiv
     */
    NinteiShinseishaFinderDiv getNinteiShinseishaFinderDiv();

    /**
     * バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    ValidationMessageControlPairs validate();
}
