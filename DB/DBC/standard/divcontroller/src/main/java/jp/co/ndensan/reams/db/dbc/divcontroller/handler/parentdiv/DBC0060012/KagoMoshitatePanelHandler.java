/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiDataModel;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ServiceShikibetsuCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060012.KyotakuServiceKagoMoshitatePanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060012.dgServive_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居宅サービスの給付管理照会のHandlerです。
 *
 * @reamsid_L DBC-2960-030 chenxiangyu
 */
public class KagoMoshitatePanelHandler {

    private final KyotakuServiceKagoMoshitatePanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link KyotakuServiceKagoMoshitatePanelDiv}
     */
    public KagoMoshitatePanelHandler(KyotakuServiceKagoMoshitatePanelDiv div) {
        this.div = div;
    }

    /**
     * 給付管理明細一覧を設置します。
     *
     * @param 居宅サービスフラグ 居宅サービスフラグ
     * @param 給付管理明細一覧 給付管理明細一覧
     */
    public void set給付管理明細一覧(boolean 居宅サービスフラグ, List<KyufuKanrihyoShokaiDataModel> 給付管理明細一覧) {
        if (居宅サービスフラグ && 給付管理明細一覧 == null) {
            div.getService().getDgServive().setDataSource(new ArrayList());
            return;
        }
        List<dgServive_Row> rowList = new ArrayList<>();
        for (KyufuKanrihyoShokaiDataModel 給付管理明細 : 給付管理明細一覧) {
            if (KyotakuServiceKubun.居宅サービス.getコード().equals(給付管理明細.get給付管理票種別区分コード())) {
                dgServive_Row servive_Row = new dgServive_Row();
                servive_Row.setDefaultDataName0(給付管理明細.get給付管理票明細行番号());
                if (給付管理明細.getサービス事業所番号() != null) {
                    servive_Row.setDefaultDataName1(給付管理明細.getサービス事業所番号().value());
                }
                servive_Row.setDefaultDataName2(給付管理明細.getサービス事業者名());
                if (給付管理明細.get指定_基準該当_地域密着型サービス識別コード() != null
                        && (!給付管理明細.get指定_基準該当_地域密着型サービス識別コード().isEmpty())) {
                    servive_Row.setDefaultDataName3(
                            ServiceShikibetsuCode.toValue(給付管理明細.get指定_基準該当_地域密着型サービス識別コード()).get名称());
                }
                if (給付管理明細.getサービス種類コード() != null && (!給付管理明細.getサービス種類コード().isEmpty())) {
                    servive_Row.setDefaultDataName4(
                            ServiceCategoryShurui.toValue(給付管理明細.getサービス種類コード().value()).get名称());
                }
                servive_Row.getDefaultDataName5().setValue(Decimal.valueOf(給付管理明細.get給付計画合計単位数_日数()));
                rowList.add(servive_Row);
            }
        }
        div.getService().getDgServive().setDataSource(rowList);
    }

    /**
     * 居宅サービスの給付管理照会を初期処理します。
     *
     * @param 給付管理票 給付管理票
     */
    public void onLoad(KyufuKanrihyoShokaiDataModel 給付管理票) {
        if (給付管理票.get給付管理票作成年月日() != null) {
            div.getService().getTxt1().setValue(給付管理票.get給付管理票作成年月日());
        }
        if (給付管理票.get給付管理票情報作成区分コード() != null) {
            div.getService().getTxt2().setValue(KyufukanrihyoSakuseiKubun.toValue(給付管理票.get給付管理票情報作成区分コード()).get名称());
        }
        if (給付管理票.get居宅サービス計画作成区分コード() != null) {
            div.getService().getTxt4().setValue(JukyushaIF_KeikakuSakuseiKubunCode.
                    toValue(給付管理票.get居宅サービス計画作成区分コード()).get名称());
        }
        if (給付管理票.get居宅支援事業所番号() != null) {
            div.getService().getTxt5().setValue(給付管理票.get居宅支援事業所番号().value());
        }
        div.getService().getTxt8().setValue(Decimal.valueOf(給付管理票.get居宅_介護予防支給限度額()));
        if (給付管理票.get限度額適用開始年月() != null) {
            div.getService().getTxt9().setFromValue(new RDate(給付管理票.get限度額適用開始年月().toString()));
        }
        if (給付管理票.get限度額適用開始年月() != null) {
            div.getService().getTxt9().setToValue(new RDate(給付管理票.get限度額適用終了年月().toString()));
        }
        div.getService().getTxt11().setValue(給付管理票.get担当介護支援専門員番号());
        if (給付管理票.get委託先の居宅介護支援事業所番号() != null) {
            div.getService().getTxt13().setValue(給付管理票.get委託先の居宅介護支援事業所番号().value());
        }
        div.getService().getTxt17().setValue(給付管理票.get委託先の担当介護支援専門員番号());
        div.getService().getTxt12().setValue(Decimal.valueOf(給付管理票.get指定サービス分小計()));
        div.getService().getTxt15().setValue(Decimal.valueOf(給付管理票.get基準該当サービス分小計()));
        div.getService().getTxt18().setValue(Decimal.valueOf(給付管理票.get給付計画合計単位数_日数()));
    }
}
