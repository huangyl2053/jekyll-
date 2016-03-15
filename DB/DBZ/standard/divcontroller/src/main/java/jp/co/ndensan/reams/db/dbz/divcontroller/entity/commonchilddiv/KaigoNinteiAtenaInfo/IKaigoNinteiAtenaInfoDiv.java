package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IKaigoNinteiAtenaInfoDiv extends ICommonChildDivBaseProperties {

    /**
     * 介護導入形態の値を設定します。(隠し項目)
     *
     * @param hdnKaigoDonyuKeitai 介護導入形態の値
     */
    void setKaigoDonyuKeitai(RString hdnKaigoDonyuKeitai);

    /**
     * 処理タイプの値を設定します。 (隠し項目)
     *
     * @param hdnShoriType 処理タイプの値
     */
    void setShoriType(RString hdnShoriType);

    /**
     * 初期化。
     */
    void initialize();

    /**
     * 介護認定宛名情報Div。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param shikibetsuCode ShikibetsuCode
     */
    void setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo shinseishoKanriNo, ShikibetsuCode shikibetsuCode);
}
