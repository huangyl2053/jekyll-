/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiDataModel;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060011.KyufuJissekiGaitoshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060011.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 給付管理票照会のHandlerです。
 *
 * @reamsid_L DBC-2960-010 chenxiangyu
 */
public class KyufuJissekiGaitoshaHandler {

    private final KyufuJissekiGaitoshaDiv div;
    private static final int SIX = 6;

    /**
     * コンストラクタです。
     *
     * @param div {@link KyufuJissekiGaitoshaDiv}
     */
    public KyufuJissekiGaitoshaHandler(KyufuJissekiGaitoshaDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化メソッドです。
     */
    public void onLoad() {
        div.setHdn支給限度額一本化年月(DbBusinessConfig.get(
                ConfigNameDBU.制度改正施行日_支給限度額一本化,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substring(0, SIX));
    }

    /**
     * 「検索する」ボタンを押すの場合。
     *
     * @param 給付管理票一覧 給付管理票一覧
     */
    public void onClick_btnSearch(List<KyufuKanrihyoShokaiBusiness> 給付管理票一覧) {
        if (給付管理票一覧 != null) {
            List<dgHihokenshaSearchGaitosha_Row> rowList = new ArrayList<>();
            for (KyufuKanrihyoShokaiBusiness 給付管理票 : 給付管理票一覧) {
                RString 給付管理票情報作成区分 = RString.EMPTY;
                if (給付管理票.get給付管理票情報作成区分コード() != null) {
                    給付管理票情報作成区分 = KyufukanrihyoSakuseiKubun.toValue(給付管理票.get給付管理票情報作成区分コード()).get名称();
                }
                RString 被保険者番号 = RString.EMPTY;
                if (給付管理票.get被保険者番号() != null) {
                    被保険者番号 = 給付管理票.get被保険者番号().value();
                }
                RString サービス事業所番号 = RString.EMPTY;
                if (給付管理票.getサービス事業所番号() != null) {
                    サービス事業所番号 = 給付管理票.getサービス事業所番号().value();
                }
                rowList.add(new dgHihokenshaSearchGaitosha_Row(
                        給付管理票.getサービス提供年月().wareki().firstYear(FirstYear.ICHI_NEN).toDateString(),
                        給付管理票.get審査年月().wareki().firstYear(FirstYear.ICHI_NEN).toDateString(),
                        給付管理票情報作成区分,
                        被保険者番号,
                        サービス事業所番号,
                        給付管理票.get氏名(),
                        DataPassingConverter.serialize(KyufuKanrihyoShokaiDataModel.createDataModel(給付管理票))));
            }
            div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().setDataSource(rowList);
        }
    }

    /**
     * 画面から「給付管理票200604Entity」を取得します。
     *
     * @return 給付管理票200604Entity
     */
    public KyufuKanrihyoShokaiDataModel getKyufuKanrihyo200604() {
        return DataPassingConverter.deserialize(
                div.getDgHihokenshaSearchGaitosha().getSelectedItems().get(0).getTxtKyufuKanrihyo200604(),
                KyufuKanrihyoShokaiDataModel.class);
    }
}
