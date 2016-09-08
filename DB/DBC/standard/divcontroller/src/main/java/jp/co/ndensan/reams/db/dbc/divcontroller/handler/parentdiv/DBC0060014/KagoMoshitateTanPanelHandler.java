/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiDataModel;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ServiceShikibetsuCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060014.KagoMoshitateTanPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060014.dgServive_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBC0060014_短期入所サービスの給付管理照会のハンドラクラスです。
 *
 * @reamsid_L DBC-2960-050 lizhuoxuan
 */
public class KagoMoshitateTanPanelHandler {

    private final KagoMoshitateTanPanelDiv div;

    /**
     * 画面設計_DBC0060014_短期入所サービスの給付管理照会のコンストラクタです。
     *
     * @param div KagoMoshitateTanPanelDiv
     */
    public KagoMoshitateTanPanelHandler(KagoMoshitateTanPanelDiv div) {
        this.div = div;
    }

    /**
     * 短期入所サービスの給付管理照会初期処理する。
     *
     * @param shokaiBusiness 対象者一覧
     * @param kksbsList 給付管理表示用明細一覧
     */
    public void initialize(KyufuKanrihyoShokaiDataModel shokaiBusiness, List<KyufuKanrihyoShokaiDataModel> kksbsList) {
        // サービス基本情報エリア
        if (shokaiBusiness.get給付管理票作成年月日() != null) {
            div.getService().getTxt1().setValue(new RString(shokaiBusiness.get給付管理票作成年月日().toString()));
        }
        if (shokaiBusiness.get給付管理票情報作成区分コード() != null) {
            div.getService().getTxt2().setValue(shokaiBusiness.get給付管理票情報作成区分コード());
        }
        div.getService().getTxt4().setValue(JukyushaIF_KeikakuSakuseiKubunCode.
                toValue(shokaiBusiness.get居宅サービス計画作成区分コード()).get名称());
        if (shokaiBusiness.get居宅支援事業所番号() != null) {
            div.getService().getTxt5().setValue(shokaiBusiness.get居宅支援事業所番号().value());
        }
        div.getService().getTxt8().setValue(new RString(shokaiBusiness.get居宅_介護予防支給限度額()));
        if (shokaiBusiness.get限度額適用開始年月() != null) {
            div.getService().getTxt9().setFromValue(new RDate(shokaiBusiness.get限度額適用開始年月().toString()));
        }
        if (shokaiBusiness.get限度額適用終了年月() != null) {
            div.getService().getTxt9().setToValue(new RDate(shokaiBusiness.get限度額適用終了年月().toString()));
        }
        // 一覧下部エリア
        if (shokaiBusiness.get担当介護支援専門員番号() != null) {
            div.getService().getTxt11().setValue(shokaiBusiness.get担当介護支援専門員番号());
        }
        if (shokaiBusiness.get委託先の居宅介護支援事業所番号() != null) {
            div.getService().getTxt13().setValue(shokaiBusiness.get委託先の居宅介護支援事業所番号().value());
        }
        if (shokaiBusiness.get委託先の担当介護支援専門員番号() != null) {
            div.getService().getTxt17().setValue(shokaiBusiness.get委託先の担当介護支援専門員番号());
        }
        div.getService().getTxt12().setValue(new RString(shokaiBusiness.get指定サービス分小計()));
        div.getService().getTxt15().setValue(new RString(shokaiBusiness.get基準該当サービス分小計()));
        div.getService().getTxt18().setValue(new RString(shokaiBusiness.get給付計画合計単位数_日数()));
    }

    /**
     * 一覧エリア検索処理する。
     *
     * @param kksbsList 給付管理明細一覧
     * @param tanflg 訪問通所サービスフラグ
     */
    public void setShohinSourcre(List<KyufuKanrihyoShokaiDataModel> kksbsList, boolean tanflg) {
        List<dgServive_Row> serviceRowList = new ArrayList();
        if (tanflg && kksbsList != null) {
            for (KyufuKanrihyoShokaiDataModel jigyoshaInput : kksbsList) {
                if (KyotakuServiceKubun.短期入所.getコード().equals(jigyoshaInput.get給付管理票種別区分コード())) {
                    dgServive_Row servive_Row = new dgServive_Row();
                    servive_Row.setDefaultDataName0(jigyoshaInput.get給付管理票明細行番号());
                    if (jigyoshaInput.getサービス事業所番号() != null) {
                        servive_Row.setDefaultDataName1(jigyoshaInput.getサービス事業所番号().value());
                    }
                    servive_Row.setDefaultDataName2(jigyoshaInput.getサービス事業者名());
                    servive_Row.setDefaultDataName3(ServiceShikibetsuCode.toValue(jigyoshaInput.get指定_基準該当_地域密着型サービス識別コード()).get名称());
                    if (jigyoshaInput.getサービス種類コード() != null && (!jigyoshaInput.getサービス種類コード().isEmpty())) {
                        servive_Row.setDefaultDataName4(ServiceCategoryShurui.toValue(jigyoshaInput.getサービス種類コード().value()).get名称());
                    }
                    servive_Row.setDefaultDataName5(new RString(jigyoshaInput.get給付計画合計単位数_日数()));
                    serviceRowList.add(servive_Row);
                }
            }
        }
        div.getDgServive().setDataSource(serviceRowList);
    }
}
