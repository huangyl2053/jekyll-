package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.saikinshorisha.SaikinShorisha.ISaikinShorishaDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
     * 最近処理者共有子Divをリロードします。
     */
    void reloadSaikinShorisha();

    /**
     * 検索条件DIVを取得します。
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

    /**
     *
     * 最近処理者Divを取得します。
     *
     * @return
     */
    ISaikinShorishaDiv getSaikinShorishaDiv();

    /**
     * 最近処理者の情報を更新します。
     *
     * @param hihokenshaNo
     * @param hihokenshaName
     * @return
     */
    void updateSaikinShorisha(RString hihokenshaNo, RString hihokenshaName);
}
