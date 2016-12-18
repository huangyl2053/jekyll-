/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteishinseishakihoninfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoManager;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 認定申請者基本情報のダイアログのDivControllerです。
 *
 * @reamsid_L DBE-3000-190 hezhenzhen
 *
 */
public class NinteiShinseishaKihonInfoHandler {

    private final NinteiShinseishaKihonInfoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShisetSunyushoInfoDiv
     */
    public NinteiShinseishaKihonInfoHandler(NinteiShinseishaKihonInfoDiv div) {
        this.div = div;
    }

    /**
     * 認定申請者基本情報の初期化処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public void initialize(ShinseishoKanriNo 申請書管理番号) {
        NinteiShinseishaKihonInfoBusiness business
                = NinteiShinseishaKihonInfoManager.createInstance().initialize(申請書管理番号);

        if (business != null) {

            div.getTxtHokenshaName().setValue(business.get市町村名称() == null ? RString.EMPTY : business.get市町村名称());
            div.getTxtHihokenshaKubun().setValue(business.get被保険者区分コード() == null
                    ? RString.EMPTY : HihokenshaKubunCode.toValue(business.get被保険者区分コード()).get名称());
            div.getTxtHihokenshaName().setValue(
                    business.get被保険者氏名() == null ? RString.EMPTY : new RString(business.get被保険者氏名().toString()));
            div.getTxtHihokenshaKana().setValue(
                    business.get被保険者氏名カナ() == null ? RString.EMPTY : new RString(business.get被保険者氏名カナ().toString()));
            div.getTxtSeibetsu().setValue(
                    business.get性別() == null ? RString.EMPTY : new RString(Seibetsu.toValue(business.get性別().getKey()).name()));
            div.getTxtSeinenYmd().setValue(
                    new RDate(business.get生年月日().toString()));
            div.getTxtNenrei().setValue(
                    new Decimal(business.get年齢()));
            div.getTxtYubibNo().setValue(
                    business.get郵便番号() == null ? YubinNo.EMPTY : business.get郵便番号());
            div.getTxtjusho().setValue(
                    business.get住所() == null ? RString.EMPTY : new RString(business.get住所().toString()));
            div.getTxtTelNo().setValue(
                    business.get電話番号() == null ? RString.EMPTY : new RString(business.get電話番号().toString()));
            div.getTxtHokenshaNo().setValue(
                    business.get証記載保険者番号() == null ? Decimal.ZERO : new Decimal(business.get証記載保険者番号().toString()));
            div.getTxtHihokenshaNo().setValue(
                    business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            div.getTxtNinteiShinseibi().setValue(new RDate(business.get認定申請日().toString()));
            div.getTxtShinseiKubunShinseiji().setValue(business.get申請区分_申請時() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get申請区分_申請時().getKey()).get名称());
            div.getTxtShinseiKubunHoreiji().setValue(business.get申請区分_法令時() == null
                    ? RString.EMPTY : NinteiShinseiHoreiCode.toValue(business.get申請区分_法令時().getKey()).get名称());
        }

    }
}
