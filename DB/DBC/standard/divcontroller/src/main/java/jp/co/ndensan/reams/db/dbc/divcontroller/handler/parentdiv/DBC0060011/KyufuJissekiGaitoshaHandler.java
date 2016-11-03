/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0060011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuJissekiGaitoshaCollect;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai.KyufuKanrihyoShokaiDataModel;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060011.KyufuJissekiGaitoshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0060011.dgHihokenshaSearchGaitosha_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
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
        div.getCcdJigyoshaSentaku().initialize();
        div.setHdn支給限度額一本化年月(DbBusinessConfig.get(
                ConfigNameDBU.制度改正施行日_支給限度額一本化,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substring(0, SIX));
        set保険者リスト();
    }

    /**
     * 「検索する」ボタンを押すの場合。
     *
     * @param 給付管理票一覧 給付管理票一覧
     */
    public void onClick_btnSearch(List<KyufuKanrihyoShokaiBusiness> 給付管理票一覧) {
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
            KyufuKanrihyoShokaiDataModel dataModel = new KyufuKanrihyoShokaiDataModel();
            rowList.add(new dgHihokenshaSearchGaitosha_Row(
                    給付管理票.getサービス提供年月().wareki().firstYear(FirstYear.ICHI_NEN).toDateString(),
                    給付管理票.get審査年月().wareki().firstYear(FirstYear.ICHI_NEN).toDateString(),
                    給付管理票情報作成区分,
                    被保険者番号,
                    サービス事業所番号,
                    給付管理票.get氏名(),
                    DataPassingConverter.serialize(dataModel.createDataModel(給付管理票))));
        }
        div.getKyufuJissekiGaitoshaListPanel().getDgHihokenshaSearchGaitosha().setDataSource(rowList);
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

    private void set保険者リスト() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho
                .getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null) {
            if (DonyuKeitaiCode.事務広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().value())) {
                div.getCcdHokenshaList().loadHokenshaList();
                div.getCcdHokenshaList().setDisplayNone(false);
            } else {
                div.getCcdHokenshaList().setDisplayNone(true);
            }
        }
    }

    /**
     * 画面データで画面に復元します
     *
     * @param 画面データ 画面データ
     */
    public void 復元画面データ(KyufuJissekiGaitoshaCollect 画面データ) {
        div.getCcdJigyoshaSentaku().setNyuryokuShisetsuKodo(画面データ.get事業所番号());
        div.getCcdJigyoshaSentaku().setShisetsuMeisho(画面データ.get事業者名称());
        div.getTxtHihoNo().setValue(画面データ.get被保険者番号());
        div.getTxtHihoName().setValue(画面データ.get被保険者名称());
        div.getCcdHokenshaList().setSelectedShoKisaiHokenshaNoIfExist(new ShoKisaiHokenshaNo(画面データ.get保険者番号()));
        if (!RString.isNullOrEmpty(画面データ.get給付対象年月開始())) {
            div.getTxtTeikyoYMRange().setFromValue(new RDate(画面データ.get給付対象年月開始().toString()));
        }
        if (!RString.isNullOrEmpty(画面データ.get給付対象年月終了())) {
            div.getTxtTeikyoYMRange().setToValue(new RDate(画面データ.get給付対象年月終了().toString()));
        }
        div.setHdn支給限度額一本化年月(画面データ.get支給限度額一本化年月());
        div.getDgHihokenshaSearchGaitosha().setDataSource(
                DataPassingConverter.deserialize(画面データ.get給付管理票一覧序列(), List.class));
    }

    /**
     * 画面データを取得します。
     *
     * @return 画面データ
     */
    public KyufuJissekiGaitoshaCollect get画面データ() {
        KyufuJissekiGaitoshaCollect 画面データ = new KyufuJissekiGaitoshaCollect();
        画面データ.set事業所番号(div.getCcdJigyoshaSentaku().getNyuryokuShisetsuKodo());
        画面データ.set事業者名称(div.getCcdJigyoshaSentaku().getNyuryokuShisetsuMeisho());
        画面データ.set被保険者番号(div.getTxtHihoNo().getValue());
        画面データ.set被保険者名称(div.getTxtHihoName().getValue());
        画面データ.set支給限度額一本化年月(div.getHdn支給限度額一本化年月());
        if (div.getCcdHokenshaList().getSelectedItem() != null) {
            画面データ.set保険者番号(div.getCcdHokenshaList().getSelectedItem().get証記載保険者番号().value());
        }
        if (div.getTxtTeikyoYMRange().getFromValue() != null) {
            画面データ.set給付対象年月開始(div.getTxtTeikyoYMRange().getFromValue().toDateString());
        }
        if (div.getTxtTeikyoYMRange().getToValue() != null) {
            画面データ.set給付対象年月終了(div.getTxtTeikyoYMRange().getToValue().toDateString());
        }
        画面データ.set給付管理票一覧序列(DataPassingConverter.serialize(
                (ArrayList<dgHihokenshaSearchGaitosha_Row>) div.getDgHihokenshaSearchGaitosha().getDataSource()));
        return 画面データ;
    }

}
