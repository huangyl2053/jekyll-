package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiAtenaInfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.kaigoninteiatenainfo.KaigoNinteiAtenaInfoBusiness;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBZ-1300-050 lizhuoxuan
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

    /**
     * 介護認定宛名情報Div。
     *
     * @param business KaigoNinteiAtenaInfoBusiness
     */
    void set介護認定宛名情報(KaigoNinteiAtenaInfoBusiness business);

    /**
     * 介護認定宛名情報画面Div。
     *
     * @return 介護認定宛名情報
     */
    RDate get生年月日();

    RString get年齢();

    RString get性別();

    RString get被保険者氏名();

    YubinNo get郵便番号();

    RString get住所();

    RString get電話番号();

    RString get識別コード();

}
