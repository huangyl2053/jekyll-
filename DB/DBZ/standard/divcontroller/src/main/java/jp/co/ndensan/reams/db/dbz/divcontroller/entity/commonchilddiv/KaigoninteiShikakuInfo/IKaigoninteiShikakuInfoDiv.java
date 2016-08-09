package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoninteiShikakuInfo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBZ-1300-060 lizhuoxuan
 */
public interface IKaigoninteiShikakuInfoDiv extends ICommonChildDivBaseProperties {

    /**
     * 初期化。
     *
     * @param hdnShinchsonCode
     * @param hdnHihokenShaNo
     */
    void initialize(RString hdnShinchsonCode, RString hdnHihokenShaNo);

    TextBox getTxtYokaigodo();

    TextBoxDate getTxtNinteiKaishiYmd();

    TextBoxDate getTxtNinteiShuryoYmd();

    TextBox getTxtHihokenshaNo();

    RString getHookenshaCode();
}
