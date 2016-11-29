/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060013;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiDataModel;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ServiceShikibetsuCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060013.KagoMoshitateHouPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060013.dgServive_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 画面設計_DBC0060013_訪問通所サービスの給付管理照会のハンドラクラスです。
 *
 * @reamsid_L DBC-2960-040 lizhuoxuan
 */
public class KagoMoshitateHouPanelHandler {

    private final KagoMoshitateHouPanelDiv div;

    /**
     * 画面設計_DBC0060013_訪問通所サービスの給付管理照会のコンストラクタです。
     *
     * @param div KagoMoshitateHouPanelDiv
     */
    public KagoMoshitateHouPanelHandler(KagoMoshitateHouPanelDiv div) {
        this.div = div;
    }

    /**
     * 訪問通所サービスの給付管理照会初期処理する。
     *
     * @param shokaiBusiness 対象者一覧
     * @param kksbsList 給付管理表示用明細一覧
     */
    public void initialize(KyufuKanrihyoShokaiDataModel shokaiBusiness, List<KyufuKanrihyoShokaiDataModel> kksbsList) {
        // サービス基本情報エリア
        if (shokaiBusiness.get給付管理票作成年月日() != null) {
            div.getService().getTxt1().setValue(shokaiBusiness.get給付管理票作成年月日().wareki().toDateString());
        }
        if (shokaiBusiness.get給付管理票情報作成区分コード() != null) {
            div.getService().getTxt2().setValue(KyufukanrihyoSakuseiKubun.toValue(shokaiBusiness.get給付管理票情報作成区分コード()).get名称());
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
        div.getService().getTxt7().setValue(new RString(shokaiBusiness.get限度額管理期間における前月までの給付計画日数()));
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
        div.getService().getTxt12().setValue(DecimalFormatter.toコンマ区切りRString(new Decimal(shokaiBusiness.get指定サービス分小計()), 0));
        div.getService().getTxt15().setValue(DecimalFormatter.toコンマ区切りRString(new Decimal(shokaiBusiness.get基準該当サービス分小計()), 0));
        div.getService().getTxt18().setValue(DecimalFormatter.toコンマ区切りRString(new Decimal(shokaiBusiness.get給付計画合計単位数_日数()), 0));
    }

    /**
     * 一覧エリア検索処理する。
     *
     * @param kksbsList 給付管理明細一覧
     * @param tanflg 訪問通所サービスフラグ
     */
    public void setShohinSourcre(List<KyufuKanrihyoShokaiDataModel> kksbsList, boolean tanflg) {
        if (tanflg && kksbsList == null) {
            div.getService().getDgServive().setDataSource(new ArrayList());
            return;
        }
        List<dgServive_Row> serviceRowList = new ArrayList();
        for (KyufuKanrihyoShokaiDataModel jigyoshaInput : kksbsList) {
            if (KyotakuServiceKubun.訪問通所.getコード().equals(jigyoshaInput.get給付管理票種別区分コード())) {
                dgServive_Row servive_Row = new dgServive_Row();
                servive_Row.setDefaultDataName0(jigyoshaInput.get給付管理票明細行番号());
                if (jigyoshaInput.getサービス事業所番号() != null) {
                    servive_Row.setDefaultDataName1(jigyoshaInput.getサービス事業所番号().value());
                }
                servive_Row.setDefaultDataName2(jigyoshaInput.getサービス事業者名());
                if (jigyoshaInput.get指定_基準該当_地域密着型サービス識別コード() != null && !jigyoshaInput.get指定_基準該当_地域密着型サービス識別コード().isEmpty()) {
                    servive_Row.setDefaultDataName3(ServiceShikibetsuCode.toValue(jigyoshaInput.get指定_基準該当_地域密着型サービス識別コード()).get名称());
                }
                if (jigyoshaInput.getサービス種類コード() != null && (!jigyoshaInput.getサービス種類コード().isEmpty())) {
                    servive_Row.setDefaultDataName4(ServiceCategoryShurui.toValue(jigyoshaInput.getサービス種類コード().value()).get名称());
                }
                servive_Row.setDefaultDataName5(DecimalFormatter.toコンマ区切りRString(new Decimal(jigyoshaInput.get給付計画単位数_日数()), 0));
                serviceRowList.add(servive_Row);
            }
        }
        div.getDgServive().setDataSource(serviceRowList);
    }
}
