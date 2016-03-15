/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteishinseishakihoninfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoManager;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 認定申請者基本情報のダイアログのDivControllerです
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
     * @param 申請書管理番号 ShinseishoKanriNo
     */
    public void initialize(ShinseishoKanriNo 申請書管理番号) {
        if (NinteiShinseishaKihonInfoManager.createInstance().onLoad(申請書管理番号) != null) {
            NinteiShinseishaKihonInfoBusiness business = new NinteiShinseishaKihonInfoBusiness(
                    NinteiShinseishaKihonInfoManager.createInstance().onLoad(申請書管理番号));

            div.getTxtHokenshaNo().setValue(new Decimal(business.get証記載保険者番号().toString()));
            div.getTxtHokenshaName().setValue(new RString(business.get市町村名称().toString()));
            div.getTxtHihokenshaNo().setValue(new RString(business.get被保険者番号().toString()));
            div.getTxtHihokenshaKubun().setValue(new RString(HihokenshaKubunCode.toValue(business.get被保険者区分コード()).name()));
            div.getTxtHihokenshaName().setValue(new RString(business.get被保険者氏名().toString()));
            div.getTxtHihokenshaKana().setValue(new RString(business.get被保険者氏名カナ().toString()));
            div.getTxtSeibetsu().setValue(new RString(Seibetsu.toValue(business.get性別().getKey()).name()));
            div.getTxtSeinenYmd().setValue(new RDate(business.get生年月日().toString()));
            div.getTxtNenrei().setValue(new Decimal(business.get年齢()));
            div.getTxtYubibNo().setValue(business.get郵便番号());
            div.getTxtjusho().setValue(new RString(business.get住所().toString()));
            div.getTxtTelNo().setValue(new RString(business.get電話番号().toString()));
        }

    }
}
