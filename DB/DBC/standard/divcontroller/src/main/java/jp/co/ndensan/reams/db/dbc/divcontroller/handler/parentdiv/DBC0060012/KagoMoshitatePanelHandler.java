/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060012;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiDataModel;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ServiceShikibetsuCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060012.KagoMoshitatePanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060012.dgServive_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービスの給付管理照会のHandlerです。
 *
 * @reamsid_L DBC-2960-030 chenxiangyu
 */
public class KagoMoshitatePanelHandler {

    private final KagoMoshitatePanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link KagoMoshitatePanelDiv}
     */
    public KagoMoshitatePanelHandler(KagoMoshitatePanelDiv div) {
        this.div = div;
    }

    /**
     * 給付管理明細一覧を設置します。
     *
     * @param 給付管理明細一覧 給付管理明細一覧
     */
    public void set給付管理明細一覧(List<KyufuKanrihyoShokaiDataModel> 給付管理明細一覧) {
        for (KyufuKanrihyoShokaiDataModel 給付管理明細 : 給付管理明細一覧) {
            if (給付管理明細.get給付管理票種別区分コード().equals(KyotakuServiceKubun.居宅サービス.getコード())) {
                dgServive_Row servive_Row = new dgServive_Row();
                servive_Row.setDefaultDataName0(給付管理明細.get給付管理票明細行番号());
                if (給付管理明細.getサービス事業所番号() != null) {
                    servive_Row.setDefaultDataName1(給付管理明細.getサービス事業所番号().value());
                } else {
                    servive_Row.setDefaultDataName1(RString.EMPTY);
                }
                servive_Row.setDefaultDataName2(給付管理明細.getサービス事業者名());
                if (給付管理明細.get指定_基準該当_地域密着型サービス識別コード() != null
                        && (!給付管理明細.get指定_基準該当_地域密着型サービス識別コード().isEmpty())) {
                    servive_Row.setDefaultDataName3(
                            ServiceShikibetsuCode.toValue(給付管理明細.get指定_基準該当_地域密着型サービス識別コード()).get名称());
                } else {
                    servive_Row.setDefaultDataName3(RString.EMPTY);
                }
                if (給付管理明細.getサービス種類コード() != null && (!給付管理明細.getサービス種類コード().isEmpty())) {
                    servive_Row.setDefaultDataName4(
                            ServiceCategoryShurui.toValue(給付管理明細.getサービス種類コード().value()).get名称());
                } else {
                    servive_Row.setDefaultDataName4(RString.EMPTY);
                }
                servive_Row.setDefaultDataName5(new RString(給付管理明細.get給付計画合計単位数_日数()));
                div.getService().getDgServive().getDataSource().add(servive_Row);
            }
        }
    }

    /**
     * 居宅サービスの給付管理照会を初期処理します。
     *
     * @param 給付管理票 給付管理票
     */
    public void onLoad(KyufuKanrihyoShokaiDataModel 給付管理票) {
        if (給付管理票.get給付管理票作成年月日() != null) {
            div.getService().getTxt1().setValue(new RString(給付管理票.get給付管理票作成年月日().toString()));
        } else {
            div.getService().getTxt1().setValue(RString.EMPTY);
        }
        div.getService().getTxt2().setValue(給付管理票.get給付管理票情報作成区分コード());
        if (給付管理票.get居宅サービス計画作成区分コード() != null) {
            div.getService().getTxt4().setValue(JukyushaIF_KeikakuSakuseiKubunCode.
                    valueOf(給付管理票.get居宅サービス計画作成区分コード().toString()).get名称());
        } else {
            div.getService().getTxt4().setValue(RString.EMPTY);
        }
        if (給付管理票.get居宅支援事業所番号() != null) {
            div.getService().getTxt5().setValue(給付管理票.get居宅支援事業所番号().value());
        } else {
            div.getService().getTxt5().setValue(RString.EMPTY);
        }
        div.getService().getTxt8().setValue(new RString(給付管理票.get居宅_介護予防支給限度額()));
        if (給付管理票.get限度額適用開始年月() != null) {
            div.getService().getTxt9().setFromValue(new RDate(給付管理票.get限度額適用開始年月().toString()));
        } else {
            div.getService().getTxt9().setFromValue(RDate.MIN);
        }
        if (給付管理票.get限度額適用開始年月() != null) {
            div.getService().getTxt9().setToValue(new RDate(給付管理票.get限度額適用終了年月().toString()));
        } else {
            div.getService().getTxt9().setToValue(RDate.MAX);
        }
        div.getService().getTxt11().setValue(給付管理票.get担当介護支援専門員番号());
        if (給付管理票.get委託先の居宅介護支援事業所番号() != null) {
            div.getService().getTxt13().setValue(給付管理票.get委託先の居宅介護支援事業所番号().value());
        } else {
            div.getService().getTxt13().setValue(RString.EMPTY);
        }
        div.getService().getTxt17().setValue(給付管理票.get委託先の担当介護支援専門員番号());
        div.getService().getTxt12().setValue(new RString(給付管理票.get指定サービス分小計()));
        div.getService().getTxt15().setValue(new RString(給付管理票.get基準該当サービス分小計()));
        div.getService().getTxt18().setValue(new RString(給付管理票.get給付計画合計単位数_日数()));
    }
}
