/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0440011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist.KogakuKyuufuTaishouListEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishikyuushinnseitouroku.KougakuSabisuhiShikyuuShinnseiTourokuEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishikyuushinnseitouroku.KougakuSabisuhiShikyuuShinnseiTourokuResult;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0440011.KogakuSabisuhiShikyuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0440011.KogakuKyufuTaishoListParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0440011.KogakuServicehiDetailParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kougakusabisuhishikyuushinnseitouroku.KougakuSabisuhiShikyuuShinnseiTouroku;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 画面設計_DBCMN42001_高額サービス費支給申請登録
 *
 * @reamsid_L DBC-2020-040 quxiaodong
 */
public class KogakuSabisuhiShikyuShinseiPanelHandler {

    private final KogakuSabisuhiShikyuShinseiPanelDiv div;
    private static final RString 追加モード = new RString("追加モード");
    private static final RString 修正モード = new RString("修正モード");
    private static final RString 削除モード = new RString("削除モード");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 定値_レコード種別コード = new RString("01");
    private static final RString 定値_通し番号 = new RString("01");
    private static final RString THREE = new RString("3");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final NyuryokuShikibetsuNo 定値_識別番号 = new NyuryokuShikibetsuNo("3411");
    private static final KokanShikibetsuNo 定値_交換情報識別番号 = new KokanShikibetsuNo("1131");
    private static final int NUM_0 = 0;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_5 = 5;

    /**
     * 初期化
     *
     * @param div KogakuSabisuhiShikyuShinseiPanel
     */
    public KogakuSabisuhiShikyuShinseiPanelHandler(KogakuSabisuhiShikyuShinseiPanelDiv div) {
        this.div = div;
    }

    /**
     * 申請情報検索画面初期化です。
     *
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param 導入形態コード RString
     */
    public void initialize申請情報検索(RString メニューID, HihokenshaNo 被保険者番号, RString 導入形態コード) {
        div.getCcdKogakuShinseiList().initialize(メニューID, 被保険者番号, 導入形態コード);
    }

    /**
     * 高額詳細内容画面初期化です。
     *
     * @param 画面モード RString
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 証記載保険者番号 HokenshaNo
     * @param 履歴番号 int
     * @param 識別コード ShikibetsuCode
     */
    public void initialize高額詳細内容(RString 画面モード, RString メニューID, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, HokenshaNo 証記載保険者番号, int 履歴番号, ShikibetsuCode 識別コード) {
        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                initialize(画面モード, メニューID, 被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, 識別コード);
    }

    /**
     * 高額介護サービス給付対象明細初期化です。
     *
     * @param メニューID RString
     * @param 画面モード RString
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 履歴番号 int
     */
    public void initialize高額介護サービス給付対象明細(RString メニューID, RString 画面モード,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, int 履歴番号) {
        div.getCcdKogakuKyufuTaishoList().initialize(メニューID, 画面モード, 被保険者番号, サービス提供年月, 履歴番号);
    }

    /**
     * 申請情報保存です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 証記載保険者番号 HokenshaNo
     * @param 画面モード RString
     * @param メニューID RString
     * @param 履歴番号 int
     * @param result KougakuSabisuhiShikyuuShinnseiTourokuEntity
     */
    public void save申請情報(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            HokenshaNo 証記載保険者番号, RString メニューID, RString 画面モード,
            int 履歴番号, KougakuSabisuhiShousaiNaiyouResult result) {
        if (追加モード.equals(画面モード)) {
            履歴番号 = Integer.parseInt(Saiban.get(SubGyomuCode.DBB介護賦課,
                    被保険者番号.value(), サービス年月.getNendo()).nextString().toString());
        }
        KogakuShikyuShinsei 高額支給申請entity = get高額支給申請entity(被保険者番号, サービス年月, 証記載保険者番号,
                履歴番号, result.get高額介護サービス費支給申請Entity());
        KogakuShikyuHanteiKekka 高額支給判定結果entity = get高額支給判定結果entity(
                被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, result.get高額介護サービス費支給判定結果Entity());
        RString 修正前支給区分 = null;
        if (追加モード.equals(画面モード)) {
            高額支給申請entity = 高額支給申請entity.added();
            高額支給判定結果entity = 高額支給判定結果entity.added();
        } else if (修正モード.equals(画面モード)) {
            高額支給申請entity = 高額支給申請entity.modified();
            高額支給判定結果entity = 高額支給判定結果entity.modified();
            if (result.get高額介護サービス費支給審査決定Entity() != null) {
                修正前支給区分 = result.get高額介護サービス費支給審査決定Entity().get支給区分コード();
            }
        } else if (削除モード.equals(画面モード)) {
            高額支給申請entity = 高額支給申請entity.deleted();
            高額支給判定結果entity = 高額支給判定結果entity.deleted();
        }
        KyufujissekiKogakuKaigoServicehi 給付実績編集用entity
                = get給付実績編集用entity(被保険者番号, サービス年月, 証記載保険者番号);
        給付実績編集用entity = 給付実績編集用entity.added();
        KougakuSabisuhiShikyuuShinnseiTourokuEntity entity = new KougakuSabisuhiShikyuuShinnseiTourokuEntity();
        entity.set高額介護サービス費支給申請Entity(高額支給申請entity);
        entity.set高額介護サービス費支給判定結果Entity(高額支給判定結果entity);
        KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().is更新処理(entity, メニューID);
        KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().dealKyufujisseki(
                result, 修正前支給区分, 画面モード, 被保険者番号,
                サービス年月, 証記載保険者番号, 履歴番号, 給付実績編集用entity);
    }

    /**
     * 対象者情報保存です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param メニューID RString
     * @param 高額給付対象一覧list List<KogakuKyuufuTaishouListEntityResult>
     */
    public void save対象者情報(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString メニューID,
            List<KogakuKyuufuTaishouListEntityResult> 高額給付対象一覧list) {
        List<KougakuSabisuhiShikyuuShinnseiTourokuResult> entityList = new ArrayList<>();
        List<dgTaishoshaIchiran_Row> rowList = div.getCcdKogakuKyufuTaishoList().get給付対象一覧();
        Map<RString, KogakuKyuufuTaishouListEntityResult> mapList = new HashMap<>();
        KougakuSabisuhiShikyuuShinnseiTourokuResult result = new KougakuSabisuhiShikyuuShinnseiTourokuResult();
        for (KogakuKyuufuTaishouListEntityResult shokanMeisaiResult : 高額給付対象一覧list) {
            mapList.put(shokanMeisaiResult.get明細合計区分(), shokanMeisaiResult);
        }
        for (dgTaishoshaIchiran_Row row : rowList) {
            KogakuKyuufuTaishouListEntityResult entity = mapList.get(row.getData10());
            if (row.getData10().equals(ONE)) {
                KogakuKyufuTaishoshaMeisai 給付対象者明細entity = entity.get給付対象者明細entity();
                給付対象者明細entity = buid給付対象者明細entity(給付対象者明細entity, row, 被保険者番号, サービス提供年月);
                result.set高額介護サービス費給付対象者明細Entity(給付対象者明細entity);
                entityList.add(result);
            } else if (row.getData10().equals(TWO)) {
                KogakuKyufuTaishoshaGokei 給付対象者合計entity = entity.get給付対象者合計entity();
                給付対象者合計entity = buid給付対象者合計entity(給付対象者合計entity, row, 被保険者番号, サービス提供年月);
                result.set高額介護サービス費支給対象者合計Entity(給付対象者合計entity);
                entityList.add(result);
            }
        }
        KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().isTaisyoshaJohoShori(entityList, メニューID);

    }

    private KogakuKyufuTaishoshaMeisai buid給付対象者明細entity(
            KogakuKyufuTaishoshaMeisai entity, dgTaishoshaIchiran_Row row, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) {
        entity = cleanKogakuKyufuTaishoshaMeisai(entity);
        if (追加.equals(row.getData0())) {
            int 履歴番号 = Integer.parseInt(Saiban.get(SubGyomuCode.DBB介護賦課,
                    被保険者番号.value(), サービス提供年月.getNendo()).nextString().toString());
            entity = new KogakuKyufuTaishoshaMeisai(被保険者番号, サービス提供年月,
                    new JigyoshaNo(row.getData1()), new ServiceShuruiCode(row.getData1()), 履歴番号);
        }
        entity = entity.createBuilderForEdit().setサービス費用合計額(row.getData4().getValue()).build();
        entity = entity.createBuilderForEdit().set利用者負担額(row.getData5().getValue()).build();
        entity = entity.createBuilderForEdit().set高額給付根拠(row.getData9()).build();
        if (削除.equals(row.getData0())) {
            entity = entity.deleted();
        } else if (追加.equals(row.getData0())) {
            entity = entity.added();
        } else if (修正.equals(row.getData0())) {
            entity = entity.modified();
        }
        return entity;
    }

    private KogakuKyufuTaishoshaGokei buid給付対象者合計entity(
            KogakuKyufuTaishoshaGokei entity, dgTaishoshaIchiran_Row row, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) {
        entity = cleanKogakuKyufuTaishoshaGokei(entity);
        if (追加.equals(row.getData0())) {
            int 履歴番号 = Integer.parseInt(Saiban.get(SubGyomuCode.DBB介護賦課,
                    被保険者番号.value(), サービス提供年月.getNendo()).nextString().toString());
            entity = new KogakuKyufuTaishoshaGokei(被保険者番号, サービス提供年月, new Decimal(履歴番号));
        }
        entity = entity.createBuilderForEdit().setサービス費用合計額合計(row.getData4().getValue()).build();
        entity = entity.createBuilderForEdit().set利用者負担額合計(row.getData5().getValue()).build();
        entity = entity.createBuilderForEdit().set算定基準額(row.getData6().getValue()).build();
        entity = entity.createBuilderForEdit().set支払済金額合計(row.getData7().getValue()).build();
        entity = entity.createBuilderForEdit().set高額支給額(row.getData8().getValue()).build();
        if (削除.equals(row.getData0())) {
            entity = entity.deleted();
        } else if (追加.equals(row.getData0())) {
            entity = entity.added();
        } else if (修正.equals(row.getData0())) {
            entity = entity.modified();
        }
        return entity;
    }

    private KogakuKyufuTaishoshaMeisai cleanKogakuKyufuTaishoshaMeisai(KogakuKyufuTaishoshaMeisai entity) {
        entity = entity.createBuilderForEdit().setサービス費用合計額(null).build();
        entity = entity.createBuilderForEdit().set利用者負担額(null).build();
        entity = entity.createBuilderForEdit().set高額給付根拠(null).build();
        return entity;
    }

    private KogakuKyufuTaishoshaGokei cleanKogakuKyufuTaishoshaGokei(KogakuKyufuTaishoshaGokei entity) {
        entity = entity.createBuilderForEdit().setサービス費用合計額合計(null).build();
        entity = entity.createBuilderForEdit().set利用者負担額合計(null).build();
        entity = entity.createBuilderForEdit().set算定基準額(null).build();
        entity = entity.createBuilderForEdit().set支払済金額合計(null).build();
        entity = entity.createBuilderForEdit().set高額支給額(null).build();
        return entity;
    }

    private KogakuShikyuShinsei get高額支給申請entity(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月, HokenshaNo 証記載保険者番号,
            int 履歴番号, KogakuShikyuShinsei entity) {
        if (entity == null) {
            entity = new KogakuShikyuShinsei(被保険者番号, サービス年月,
                    証記載保険者番号, new Decimal(履歴番号)).createBuilderForEdit().build();
        }
        entity = clearKogakuShikyuShinsei(entity);
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get受付日() != null) {
            entity = entity.createBuilderForEdit().set受付年月日(
                    new FlexibleDate(div.getShinseiTorokuPanel().
                            getCcdKogakuServicehiDetail().get受付日().toString())).build();
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get申請日() != null) {
            entity = entity.createBuilderForEdit().set申請年月日(
                    new FlexibleDate(div.getShinseiTorokuPanel().
                            getCcdKogakuServicehiDetail().get申請日().toString())).build();
        }
        entity = entity.createBuilderForEdit().set申請理由(div.getShinseiTorokuPanel().
                getCcdKogakuServicehiDetail().get申請理由()).build();
        entity = entity.createBuilderForEdit().set申請者区分(div.getShinseiTorokuPanel().
                getCcdKogakuServicehiDetail().get申請者区分()).build();
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get氏名_漢字() != null
                && !div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get氏名_漢字().isEmpty()) {
            entity = entity.createBuilderForEdit().set申請者氏名(new AtenaMeisho(div.getShinseiTorokuPanel().
                    getCcdKogakuServicehiDetail().get氏名_漢字())).build();
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get氏名_カナ() != null
                && !div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get氏名_カナ().isEmpty()) {
            entity = entity.createBuilderForEdit().set申請者氏名カナ(new AtenaKanaMeisho(div.getShinseiTorokuPanel().
                    getCcdKogakuServicehiDetail().get氏名_カナ())).build();
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get電話番号() != null
                && !div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get電話番号().isEmpty()) {
            entity = entity.createBuilderForEdit().set申請者電話番号(new TelNo((div.getShinseiTorokuPanel().
                    getCcdKogakuServicehiDetail().get電話番号()))).build();
        }
        entity = entity.createBuilderForEdit().set支払方法区分コード(div.getShinseiTorokuPanel().
                getCcdKogakuServicehiDetail().getCcdShiharaiHohoJyoho().getShiharaiHohoRad()).build();
        entity = entity.createBuilderForEdit().set支払場所(div.getShinseiTorokuPanel().
                getCcdKogakuServicehiDetail().getCcdShiharaiHohoJyoho().getShiharaiBasho()).build();
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getStartYMD() != null) {
            entity = entity.createBuilderForEdit().set支払期間開始年月日(new FlexibleDate(div.getShinseiTorokuPanel().
                    getCcdKogakuServicehiDetail().getCcdShiharaiHohoJyoho().getStartYMD().toString())).build();
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getEndYMD() != null) {
            entity = entity.createBuilderForEdit().set支払期間終了年月日(new FlexibleDate(div.getShinseiTorokuPanel().
                    getCcdKogakuServicehiDetail().getCcdShiharaiHohoJyoho().getEndYMD().toString())).build();
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getStartHHMM() != null) {
            RString 時間 = new RString(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                    getCcdShiharaiHohoJyoho().getStartHHMM().toString());
            entity = entity.createBuilderForEdit().set支払窓口開始時間(
                    時間.substring(NUM_0, NUM_2).concat(時間.substring(NUM_3, NUM_5))).build();
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getEndHHMM() != null) {
            RString 時間 = new RString(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                    getCcdShiharaiHohoJyoho().getEndHHMM().toString());
            entity = entity.createBuilderForEdit().set支払窓口終了時間(
                    時間.substring(NUM_0, NUM_2).concat(時間.substring(NUM_3, NUM_5))).build();
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getKozaNo() != null
                && !div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getKozaNo().isEmpty()) {
            entity = entity.createBuilderForEdit().set口座ID(
                    Long.parseLong(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                            getCcdShiharaiHohoJyoho().getKozaNo().toString())).build();
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getKeiyakuNo() != null) {
            entity = entity.createBuilderForEdit().set受領委任契約番号(
                    div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                    getCcdShiharaiHohoJyoho().getKeiyakuNo()).build();
        }
        return entity;
    }

    private KogakuShikyuHanteiKekka get高額支給判定結果entity(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            HokenshaNo 証記載保険者番号, int 履歴番号, KogakuShikyuHanteiKekka entity) {
        if (entity == null) {
            entity = new KogakuShikyuHanteiKekka(被保険者番号,
                    サービス年月, 証記載保険者番号, 履歴番号).createBuilderForEdit().build();
        }
        entity = clearKogakuShikyuHanteiKekka(entity);
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get決定日() != null) {
            entity = entity.createBuilderForEdit().set決定年月日(new FlexibleDate(
                    div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get決定日().toString())).build();
        }
        entity = entity.createBuilderForEdit().set本人支払額(
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get本人支払額()).build();
        entity = entity.createBuilderForEdit().set支給区分コード(
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給区分()).build();
        entity = entity.createBuilderForEdit().set支給金額(
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給金額()).build();
        entity = entity.createBuilderForEdit().set不支給理由(
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給しない理由()).build();
        entity = entity.createBuilderForEdit().set審査方法区分(
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get審査方法区分()).build();
        entity = entity.createBuilderForEdit().set再送付フラグ(
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().is国保連再送()).build();
        return entity;
    }

    private KyufujissekiKogakuKaigoServicehi get給付実績編集用entity(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            HokenshaNo 証記載保険者番号) {
        KyufujissekiKogakuKaigoServicehi entity = new KyufujissekiKogakuKaigoServicehi(
                定値_交換情報識別番号, 定値_識別番号, 定値_レコード種別コード, 証記載保険者番号,
                被保険者番号, サービス年月, 定値_通し番号, ONE, THREE);
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get受付日() != null) {
            entity = entity.createBuilderForEdit().set受付年月日(
                    new FlexibleDate(div.getShinseiTorokuPanel().
                            getCcdKogakuServicehiDetail().get受付日().toString())).build();
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get決定日() != null) {
            entity = entity.createBuilderForEdit().set決定年月日(new FlexibleDate(
                    div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get決定日().toString())).build();
            entity = entity.createBuilderForEdit().set審査年月(new FlexibleYearMonth(
                    div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                    get決定日().getYearMonth().toString())).build();
        }
        entity = entity.createBuilderForEdit().set利用者負担額(
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支払金額合計().intValue()).build();
        entity = entity.createBuilderForEdit().set支給額(
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給金額().intValue()).build();
        entity = entity.createBuilderForEdit().set管理番号(追加モード).build();
        return entity;
    }

    private KogakuShikyuShinsei clearKogakuShikyuShinsei(KogakuShikyuShinsei entity) {
        entity = entity.createBuilderForEdit()
                .set受付年月日(null)
                .set申請年月日(null)
                .set申請理由(null)
                .set申請者区分(null)
                .set申請者氏名(null)
                .set申請者氏名カナ(null)
                .set申請者電話番号(null)
                .set支払方法区分コード(null)
                .set支払場所(null)
                .set支払期間開始年月日(null)
                .set支払期間終了年月日(null)
                .set支払窓口開始時間(null)
                .set支払窓口終了時間(null)
                .set受領委任契約番号(null).build();
        return entity;
    }

    private KogakuShikyuHanteiKekka clearKogakuShikyuHanteiKekka(KogakuShikyuHanteiKekka entity) {
        entity = entity.createBuilderForEdit()
                .set決定年月日(null)
                .set本人支払額(null)
                .set支給区分コード(null)
                .set支給金額(null)
                .set不支給理由(null)
                .set審査方法区分(null)
                .set再送付フラグ(false).build();
        return entity;
    }

    /**
     * 前排他を設定のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return Boolean
     */
    public Boolean is前排他キーのセット(HihokenshaNo 被保険者番号) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        LockingKey 排他キー = new LockingKey(controlData.getMenuID());
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 申請情報登録内容変更状態
     *
     * @param parameter YoguKonyuhiShikyuShinseiPnlTotalParameter
     * @return is申請情報登録内容変更状態
     */
    public boolean is申請情報登録内容変更状態(KogakuServicehiDetailParameter parameter) {
        return is申請情報登録(parameter);
    }

    /**
     * is内容変更状態
     *
     *
     * @return true
     */
    public boolean is対象者情報登録内容変更状態() {
        for (dgTaishoshaIchiran_Row ddgList : div.getCcdKogakuKyufuTaishoList().get給付対象一覧()) {
            if (RowState.Modified.equals(ddgList.getRowState())
                    || RowState.Added.equals(ddgList.getRowState())
                    || RowState.Deleted.equals(ddgList.getRowState())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 保存、取消時状態で判定する
     *
     * @return KogakuServicehiDetailParameter
     */
    public KogakuServicehiDetailParameter set申請情報登録画面データ() {
        KogakuServicehiDetailParameter parameter = new KogakuServicehiDetailParameter();
        parameter.set申請日(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get申請日());
        parameter.set申請者区分(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get申請者区分());
        parameter.set証記載保険者番号(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get証記載保険者番号());
        parameter.set証記載保険者番号(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get証記載保険者番号());
        parameter.set国保連再送(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().is国保連再送());
        parameter.set氏名_漢字(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get氏名_漢字());
        parameter.set氏名_カナ(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get氏名_カナ());
        parameter.set電話番号(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get電話番号());
        parameter.set申請理由(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get申請理由());
        parameter.set支払金額合計(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支払金額合計());
        parameter.set窓口払い_支払場所(div.getShinseiTorokuPanel().
                getCcdKogakuServicehiDetail().getCcdShiharaiHohoJyoho().getShiharaiBasho());
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getStartYMD() != null) {
            parameter.set窓口払い_開始日(new RString(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                    getCcdShiharaiHohoJyoho().getStartYMD().toString()));
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getEndYMD() != null) {
            parameter.set窓口払い_終了日(new RString(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                    getCcdShiharaiHohoJyoho().getEndYMD().toString()));
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getStartHHMM() != null) {
            parameter.set窓口払い_開始時間(new RString(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                    getCcdShiharaiHohoJyoho().getStartHHMM().toString()));
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getEndHHMM() != null) {
            parameter.set窓口払い_終了時間(new RString(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                    getCcdShiharaiHohoJyoho().getEndHHMM().toString()));
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getKozaNo() != null) {
            parameter.set口座払い_口座ＩＤ(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                    getCcdShiharaiHohoJyoho().getKozaNo());
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getKeiyakuNo() != null) {
            parameter.set受領委任払い_契約番号(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                    getCcdShiharaiHohoJyoho().getKeiyakuNo());
        }
        parameter.set受付日(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get受付日());
        parameter.set本人支払額(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get本人支払額());
        parameter.set決定日(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get決定日());
        parameter.set支給区分(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給区分());
        parameter.set審査方法区分(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get審査方法区分());
        parameter.set世帯集約番号(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get世帯集約番号());
        parameter.set支給金額(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給金額());
        parameter.set高額自動償還(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get高額自動償還());
        parameter.set支給しない理由(div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給しない理由());
        return parameter;
    }

    /**
     * 支給申請登録に戻る時状態で判定する
     *
     * @return KogakuKyufuTaishoListParameter
     */
    public KogakuKyufuTaishoListParameter set対象者情報登録画面データ() {
        KogakuKyufuTaishoListParameter parameter = new KogakuKyufuTaishoListParameter();
        parameter.set明細合計区分(div.getCcdKogakuKyufuTaishoList().get明細合計区分());
        parameter.set事業者コード(div.getCcdKogakuKyufuTaishoList().get事業者コード());
        parameter.set事業者名称(div.getCcdKogakuKyufuTaishoList().get事業者名称());
        parameter.setサービス種類(div.getCcdKogakuKyufuTaishoList().getサービス種類());
        parameter.setサービス種類名称(div.getCcdKogakuKyufuTaishoList().getサービス種類名称());
        parameter.setサービス費用合計(div.getCcdKogakuKyufuTaishoList().getサービス費用合計());
        parameter.set利用者負担合計(div.getCcdKogakuKyufuTaishoList().get利用者負担合計());
        parameter.set算定基準額(div.getCcdKogakuKyufuTaishoList().get算定基準額());
        parameter.set支払済額(div.getCcdKogakuKyufuTaishoList().get支払済額());
        parameter.set月遅れ区分(div.getCcdKogakuKyufuTaishoList().get月遅れ区分());
        parameter.set世帯所得区分(div.getCcdKogakuKyufuTaishoList().get世帯所得区分());
        parameter.set本人所得区分(div.getCcdKogakuKyufuTaishoList().get本人所得区分());
        parameter.set合算区分(div.getCcdKogakuKyufuTaishoList().get合算区分());
        parameter.set利用者負担第２段階(div.getCcdKogakuKyufuTaishoList().get利用者負担第２段階());
        parameter.set激変緩和区分(div.getCcdKogakuKyufuTaishoList().get激変緩和区分());
        return parameter;
    }
    //    /**
//     * 申請情報登録内容変更状態
//     *
//     * @param parameter YoguKonyuhiShikyuShinseiPnlTotalParameter
//     * @return is申請情報登録内容変更状態
//     */
//    public boolean is対象者情報登録内容変更状態(KogakuKyufuTaishoListParameter parameter) {
//        return is対象者情報登録(parameter);
//    }

//    private boolean is対象者情報登録(KogakuKyufuTaishoListParameter parameter) {
//        return is比較変更(parameter.get明細合計区分(), div.getCcdKogakuKyufuTaishoList().get明細合計区分())
//                || is比較変更(parameter.get事業者コード(), div.getCcdKogakuKyufuTaishoList().get事業者コード())
//                || is比較変更(parameter.get事業者名称(), div.getCcdKogakuKyufuTaishoList().get事業者名称())
//                || is比較変更(parameter.getサービス種類(), div.getCcdKogakuKyufuTaishoList().getサービス種類())
//                || is比較変更(parameter.getサービス種類名称(), div.getCcdKogakuKyufuTaishoList().getサービス種類名称())
//                || is比較変更数字(parameter.getサービス費用合計(), div.getCcdKogakuKyufuTaishoList().getサービス費用合計())
//                || is比較変更数字(parameter.get利用者負担合計(), div.getCcdKogakuKyufuTaishoList().get利用者負担合計())
//                || is比較変更数字(parameter.get算定基準額(), div.getCcdKogakuKyufuTaishoList().get算定基準額())
//                || is比較変更数字(parameter.get支払済額(), div.getCcdKogakuKyufuTaishoList().get支払済額())
//                || is比較変更(parameter.get月遅れ区分(), div.getCcdKogakuKyufuTaishoList().get月遅れ区分())
//                || is比較変更(parameter.get世帯所得区分(), div.getCcdKogakuKyufuTaishoList().get世帯所得区分())
//                || is比較変更(parameter.get本人所得区分(), div.getCcdKogakuKyufuTaishoList().get本人所得区分())
//                || is比較変更(parameter.get合算区分(), div.getCcdKogakuKyufuTaishoList().get合算区分())
//                || is比較変更(parameter.get老齢福祉年金(), div.getCcdKogakuKyufuTaishoList().get老齢福祉年金())
//                || is比較変更(parameter.get利用者負担第２段階(), div.getCcdKogakuKyufuTaishoList().get利用者負担第２段階())
//                || is比較変更(parameter.get激変緩和区分(), div.getCcdKogakuKyufuTaishoList().get激変緩和区分());
//    }
    private boolean is申請情報登録(KogakuServicehiDetailParameter parameter) {
        return is比較変更年月日(parameter.get申請日(),
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get申請日())
                || is比較変更(parameter.get申請者区分(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get申請者区分())
                || is比較変更(parameter.get証記載保険者番号(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get証記載保険者番号())
                || parameter.is国保連再送() != div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().is国保連再送()
                || is比較変更(parameter.get氏名_漢字(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get氏名_漢字())
                || is比較変更(parameter.get氏名_カナ(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get氏名_カナ())
                || is比較変更(parameter.get電話番号(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get電話番号())
                || is比較変更(parameter.get申請理由(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get申請理由())
                || is比較変更数字(parameter.get支払金額合計(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支払金額合計())
                || is口座情報タブ(parameter)
                || is比較変更年月日(parameter.get受付日(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get受付日())
                || is比較変更数字(parameter.get本人支払額(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get本人支払額())
                || is比較変更年月日(parameter.get決定日(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get決定日())
                || is比較変更(parameter.get支給区分(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給区分())
                || is比較変更(parameter.get審査方法区分(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get審査方法区分())
                || is比較変更(parameter.get世帯集約番号(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get世帯集約番号())
                || is比較変更数字(parameter.get支給金額(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給金額())
                || is比較変更(parameter.get高額自動償還(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get高額自動償還())
                || is比較変更(parameter.get支給しない理由(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給しない理由());
    }

    private boolean is口座情報タブ(KogakuServicehiDetailParameter parameter) {
        return is比較変更(parameter.get窓口払い_支払場所(),
                div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                getCcdShiharaiHohoJyoho().getShiharaiBasho())
                || is比較変更日(parameter.get窓口払い_開始日(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                        getCcdShiharaiHohoJyoho().getStartYMD())
                || is比較変更時間(parameter.get窓口払い_開始時間(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                        getCcdShiharaiHohoJyoho().getStartHHMM())
                || is比較変更時間(parameter.get窓口払い_終了時間(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                        getCcdShiharaiHohoJyoho().getEndHHMM())
                || is比較変更(parameter.get口座払い_口座ＩＤ(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                        getCcdShiharaiHohoJyoho().getKozaNo())
                || is比較変更(parameter.get受領委任払い_契約番号(),
                        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().
                        getCcdShiharaiHohoJyoho().getKeiyakuNo());
    }

    private boolean is比較変更(RString s1, RString s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更年月日(RDate s1, RDate s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更日(RString s1, RDate s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(new RString(s2.toString()));
        }
    }

    private boolean is比較変更時間(RString s1, RTime s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(new RString(s2.toString()));
        }
    }

    private boolean is比較変更数字(Decimal s1, Decimal s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }
}
