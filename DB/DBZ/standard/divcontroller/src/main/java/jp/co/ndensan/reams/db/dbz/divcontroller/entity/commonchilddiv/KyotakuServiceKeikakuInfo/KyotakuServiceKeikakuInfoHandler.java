/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuInfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.kyotakuservicekeikakuinfo.KyotakuServiceKeikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikakuinfo.KyotakuServiceKeikakuInfoRelateParameter;
import jp.co.ndensan.reams.db.dbz.service.core.kyotakuservicekeikakuinfo.KyotakuServiceKeikakuInfoFinder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 *
 * 居宅サービス計画情報Handlerクラスです。
 */
public class KyotakuServiceKeikakuInfoHandler {

    private final KyotakuServiceKeikakuInfoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiShinseiShichosonRenrakuJikoDiv
     */
    public KyotakuServiceKeikakuInfoHandler(KyotakuServiceKeikakuInfoDiv div) {
        this.div = div;
    }

    /**
     * 居宅サービス計画情報に初期化を設定する。
     *
     * @param hihokenshano 被保険者番号
     */
    public void initialize(HihokenshaNo hihokenshano) {
        KyotakuServiceKeikakuInfoFinder keikakuInfoFinder = KyotakuServiceKeikakuInfoFinder.createInstance();
        FlexibleYearMonth taishoYM = FlexibleDate.getNowDate().getYearMonth();
        KyotakuServiceKeikakuInfoRelateParameter parameter = KyotakuServiceKeikakuInfoRelateParameter.createParam(hihokenshano, taishoYM);
        List<KyotakuServiceKeikaku> keikakuentityList
                = keikakuInfoFinder.getKyotakuServiceKeikaku(parameter).records();
        if (keikakuentityList != null && !keikakuentityList.isEmpty()) {
            div.getTxtKyotakujigyoCode().setValue(keikakuentityList.get(0).get委託先事業者番号() == null
                    ? keikakuentityList.get(0).get計画事業者番号().getColumnValue() : keikakuentityList.get(0).get委託先事業者番号().getColumnValue());
            div.getTxtKyotakuJigyoName().setValue(keikakuentityList.get(0).get事業者名称());
            div.getTxtSakuseiKubun().setValue(keikakuentityList.get(0).get作成区分コード());
            div.getTxtTekiyokaishiDay().setValue(keikakuentityList.get(0).get適用開始年月日());
            div.getTxtTekiyoshuryoDay().setValue(keikakuentityList.get(0).get適用終了年月日());
        }
    }
}
