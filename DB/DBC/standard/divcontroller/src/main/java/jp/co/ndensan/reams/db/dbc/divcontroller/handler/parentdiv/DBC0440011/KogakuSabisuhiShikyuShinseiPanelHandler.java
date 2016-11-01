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
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuKyufuTaishoshaMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist.JigyouKogakuKyuufuTaishouResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist.KogakuKyuufuTaishouListEntityResult;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishikyuushinnseitouroku.KougakuSabisuhiShikyuuShinnseiTourokuEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishikyuushinnseitouroku.KougakuSabisuhiShikyuuShinnseiTourokuResult;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0440011.KogakuSabisuhiShikyuShinseiPanelDiv;
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
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
    private static final RString アンダーライン = new RString("_");
    private static final Decimal NUMBER_0 = new Decimal(0);
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
        KogakuShikyuShinsei 支給申請entity = null;
        KogakuShikyuHanteiKekka 支給判定結果entity = null;
        if (result != null && !追加モード.equals(画面モード)) {
            支給申請entity = result.get高額介護サービス費支給申請Entity();
            支給判定結果entity = result.get高額介護サービス費支給判定結果Entity();
        }
        KogakuShikyuShinsei 高額支給申請entity = get高額支給申請entity(被保険者番号, サービス年月, 証記載保険者番号,
                支給申請entity);
        KogakuShikyuHanteiKekka 高額支給判定結果entity = get高額支給判定結果entity(
                被保険者番号, サービス年月, 証記載保険者番号, 支給判定結果entity);
        RString 修正前支給区分 = null;
        if (追加モード.equals(画面モード)) {
            高額支給申請entity = 高額支給申請entity.added();
            高額支給判定結果entity = 高額支給判定結果entity.added();
        } else if (修正モード.equals(画面モード)) {
            高額支給申請entity = 高額支給申請entity.modified();
            高額支給判定結果entity = 高額支給判定結果entity.modified();
            if (result != null && result.get高額介護サービス費支給審査決定Entity() != null) {
                修正前支給区分 = result.get高額介護サービス費支給審査決定Entity().get支給区分コード();
            }
        } else if (削除モード.equals(画面モード)) {
            高額支給申請entity = 高額支給申請entity.deleted();
            高額支給判定結果entity = 高額支給判定結果entity.deleted();
        }
        KyufujissekiKogakuKaigoServicehi 給付実績編集用entity
                = get給付実績編集用entity(被保険者番号, サービス年月, 証記載保険者番号, 履歴番号);
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
     * 事業高額申請情報保存です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 証記載保険者番号 HokenshaNo
     * @param 画面モード RString
     * @param メニューID RString
     * @param 履歴番号 int
     * @param result JigyouKogakuKyuufuTaishouResult
     */
    public void save事業高額申請情報(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            HokenshaNo 証記載保険者番号, RString メニューID, RString 画面モード,
            int 履歴番号, KougakuSabisuhiShousaiNaiyouResult result) {
        JigyoKogakuShikyuShinsei 支給申請entity = null;
        JigyoKogakuShikyuHanteiKekka 支給判定結果entity = null;
        if (result != null && !追加モード.equals(画面モード)) {
            支給申請entity = result.get事業高額介護サービス費支給申請Entity();
            支給判定結果entity = result.get事業高額介護サービス費支給判定結果Entity();
        }
        JigyoKogakuShikyuShinsei 高額支給申請entity = get事業高額支給申請entity(被保険者番号, サービス年月, 証記載保険者番号,
                支給申請entity);
        JigyoKogakuShikyuHanteiKekka 高額支給判定結果entity = get事業高額支給判定結果entity(
                被保険者番号, サービス年月, 証記載保険者番号, 支給判定結果entity);
        RString 修正前支給区分 = null;
        if (追加モード.equals(画面モード)) {
            高額支給申請entity = 高額支給申請entity.added();
            高額支給判定結果entity = 高額支給判定結果entity.added();
        } else if (修正モード.equals(画面モード)) {
            高額支給申請entity = 高額支給申請entity.modified();
            高額支給判定結果entity = 高額支給判定結果entity.modified();
            if (result != null && result.get高額介護サービス費支給審査決定Entity() != null) {
                修正前支給区分 = result.get高額介護サービス費支給審査決定Entity().get支給区分コード();
            }
        } else if (削除モード.equals(画面モード)) {
            高額支給申請entity = 高額支給申請entity.deleted();
            高額支給判定結果entity = 高額支給判定結果entity.deleted();
        }
        KyufujissekiKogakuKaigoServicehi 給付実績編集用entity
                = get給付実績編集用entity(被保険者番号, サービス年月, 証記載保険者番号, 履歴番号);
        給付実績編集用entity = 給付実績編集用entity.added();
        KougakuSabisuhiShikyuuShinnseiTourokuEntity entity = new KougakuSabisuhiShikyuuShinnseiTourokuEntity();
        entity.set事業高額介護サービス費支給申請Entity(高額支給申請entity);
        entity.set事業高額介護サービス費支給判定結果Entity(高額支給判定結果entity);
        KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().is更新処理(entity, メニューID);
        KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().dealKyufujisseki(
                result, 修正前支給区分, 画面モード, 被保険者番号,
                サービス年月, 証記載保険者番号, 履歴番号, 給付実績編集用entity);
    }

    /**
     * clear申請情報
     */
    public void clear申請情報() {
        div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().clear画面内容();
    }

    /**
     * clear申請情報
     */
    public void clear対象者情報() {
        div.getCcdKogakuKyufuTaishoList().clear画面内容();
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
        Map<RString, KogakuKyufuTaishoshaMeisai> 明細map = new HashMap<>();
        Map<RString, KogakuKyufuTaishoshaGokei> 合計map = new HashMap<>();
        for (KogakuKyuufuTaishouListEntityResult result : 高額給付対象一覧list) {
            if (result.get明細合計区分().equals(ONE)) {
                RStringBuilder builder = new RStringBuilder();
                builder.append(result.get給付対象者明細entity().get被保険者番号().value());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者明細entity().getサービス提供年月().toDateString());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者明細entity().get事業者番号().value());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者明細entity().getサービス種類コード().value());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者明細entity().get履歴番号());
                明細map.put(builder.toRString(), result.get給付対象者明細entity());
            }
            if (result.get明細合計区分().equals(TWO)) {
                RStringBuilder builder = new RStringBuilder();
                builder.append(result.get給付対象者合計entity().get被保険者番号().value());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者合計entity().getサービス提供年月().toDateString());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者合計entity().get履歴番号().intValue());
                合計map.put(builder.toRString(), result.get給付対象者合計entity());
            }
        }
        List<KougakuSabisuhiShikyuuShinnseiTourokuResult> entityList = new ArrayList<>();
        List<dgTaishoshaIchiran_Row> rowList = div.getCcdKogakuKyufuTaishoList().get給付対象一覧();
        for (dgTaishoshaIchiran_Row row : rowList) {
            if (row.getData0() == null || row.getData0().isEmpty()) {
                continue;
            }
            if (追加.equals(row.getData0())) {
                if (row.getData10().equals(ONE)) {
                    KougakuSabisuhiShikyuuShinnseiTourokuResult result
                            = new KougakuSabisuhiShikyuuShinnseiTourokuResult();
                    int 履歴番号 = KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().
                            get高額介護給付対象者明細履歴番号(被保険者番号, サービス提供年月);
                    KogakuKyufuTaishoshaMeisai 給付対象者明細entity = new KogakuKyufuTaishoshaMeisai(
                            被保険者番号, サービス提供年月,
                            new JigyoshaNo(row.getData1()), new ServiceShuruiCode(row.getData11()), 履歴番号);
                    給付対象者明細entity = buid給付対象者明細entity(
                            給付対象者明細entity, row);
                    result.set高額介護サービス費給付対象者明細Entity(給付対象者明細entity);
                    entityList.add(result);
                } else if (row.getData10().equals(TWO)) {
                    KougakuSabisuhiShikyuuShinnseiTourokuResult result
                            = new KougakuSabisuhiShikyuuShinnseiTourokuResult();
                    int 履歴番号 = KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().
                            get高額介護給付対象者合計履歴番号(被保険者番号, サービス提供年月);
                    KogakuKyufuTaishoshaGokei 給付対象者合計entity = new KogakuKyufuTaishoshaGokei(
                            被保険者番号, サービス提供年月, new Decimal(履歴番号));
                    給付対象者合計entity = buid給付対象者合計entity(
                            給付対象者合計entity, row);
                    result.set高額介護サービス費支給対象者合計Entity(給付対象者合計entity);
                    entityList.add(result);
                }
            } else {
                if (row.getData10().equals(ONE)) {
                    KougakuSabisuhiShikyuuShinnseiTourokuResult result
                            = new KougakuSabisuhiShikyuuShinnseiTourokuResult();
                    RStringBuilder builder = new RStringBuilder();
                    builder.append(row.getData12().getValue());
                    builder.append(アンダーライン);
                    builder.append(row.getData13().getValue());
                    builder.append(アンダーライン);
                    builder.append(row.getData1());
                    builder.append(アンダーライン);
                    builder.append(row.getData11());
                    builder.append(アンダーライン);
                    builder.append(row.getData14().getValue().intValue());
                    KogakuKyufuTaishoshaMeisai 給付対象者明細entity
                            = buid給付対象者明細entity(明細map.get(builder.toRString()), row);
                    result.set高額介護サービス費給付対象者明細Entity(給付対象者明細entity);
                    entityList.add(result);
                } else if (row.getData10().equals(TWO)) {
                    KougakuSabisuhiShikyuuShinnseiTourokuResult result
                            = new KougakuSabisuhiShikyuuShinnseiTourokuResult();
                    RStringBuilder builder = new RStringBuilder();
                    builder.append(row.getData12().getValue());
                    builder.append(アンダーライン);
                    builder.append(row.getData13().getValue());
                    builder.append(アンダーライン);
                    builder.append(row.getData14().getValue().intValue());
                    KogakuKyufuTaishoshaGokei 給付対象者合計entity
                            = buid給付対象者合計entity(合計map.get(builder.toRString()), row);
                    result.set高額介護サービス費支給対象者合計Entity(給付対象者合計entity);
                    entityList.add(result);
                }
            }
        }
        KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().isTaisyoshaJohoShori(entityList, メニューID);
    }

    /**
     * 事業高額対象者情報保存です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param メニューID RString
     * @param 高額給付対象一覧list List<JigyouKogakuKyuufuTaishouResult>
     */
    public void save事業高額対象者情報(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString メニューID,
            List<JigyouKogakuKyuufuTaishouResult> 高額給付対象一覧list) {
        Map<RString, JigyoKogakuKyufuTaishoshaMeisai> 明細map = new HashMap<>();
        Map<RString, JigyoKogakuKyufuTaishoshaGokei> 合計map = new HashMap<>();
        for (JigyouKogakuKyuufuTaishouResult result : 高額給付対象一覧list) {
            if (result.get明細合計区分().equals(ONE)) {
                RStringBuilder builder = new RStringBuilder();
                builder.append(result.get給付対象者明細entity().get被保険者番号().value());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者明細entity().getサービス提供年月().toDateString());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者明細entity().get事業者番号().value());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者明細entity().getサービス種類コード().value());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者明細entity().get履歴番号());
                明細map.put(builder.toRString(), result.get給付対象者明細entity());
            }
            if (result.get明細合計区分().equals(TWO)) {
                RStringBuilder builder = new RStringBuilder();
                builder.append(result.get給付対象者合計entity().get被保険者番号().value());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者合計entity().getサービス提供年月().toDateString());
                builder.append(アンダーライン);
                builder.append(result.get給付対象者合計entity().get履歴番号().intValue());
                合計map.put(builder.toRString(), result.get給付対象者合計entity());
            }
        }
        List<KougakuSabisuhiShikyuuShinnseiTourokuResult> entityList = new ArrayList<>();
        List<dgTaishoshaIchiran_Row> rowList = div.getCcdKogakuKyufuTaishoList().get給付対象一覧();
        for (dgTaishoshaIchiran_Row row : rowList) {
            if (row.getData0() == null || row.getData0().isEmpty()) {
                continue;
            }
            if (追加.equals(row.getData0())) {
                if (row.getData10().equals(ONE)) {
                    KougakuSabisuhiShikyuuShinnseiTourokuResult result
                            = new KougakuSabisuhiShikyuuShinnseiTourokuResult();
                    int 履歴番号 = KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().
                            get事業高額介護給付対象者明細履歴番号(被保険者番号, サービス提供年月);
                    JigyoKogakuKyufuTaishoshaMeisai 給付対象者明細entity = new JigyoKogakuKyufuTaishoshaMeisai(
                            被保険者番号, サービス提供年月,
                            new JigyoshaNo(row.getData1()), new ServiceShuruiCode(row.getData11()), 履歴番号);
                    給付対象者明細entity = buid事業高額給付対象者明細entity(
                            給付対象者明細entity, row);
                    result.set事業高額介護サービス費給付対象者明細Entity(給付対象者明細entity);
                    entityList.add(result);
                } else if (row.getData10().equals(TWO)) {
                    KougakuSabisuhiShikyuuShinnseiTourokuResult result
                            = new KougakuSabisuhiShikyuuShinnseiTourokuResult();
                    int 履歴番号 = KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().
                            get事業高額介護給付対象者合計履歴番号(被保険者番号, サービス提供年月);
                    JigyoKogakuKyufuTaishoshaGokei 給付対象者合計entity = new JigyoKogakuKyufuTaishoshaGokei(
                            被保険者番号, サービス提供年月, new Decimal(履歴番号));
                    給付対象者合計entity = buid事業高額給付対象者合計entity(
                            給付対象者合計entity, row);
                    result.set事業高額介護サービス費支給対象者合計Entity(給付対象者合計entity);
                    entityList.add(result);
                }
            } else {
                if (row.getData10().equals(ONE)) {
                    KougakuSabisuhiShikyuuShinnseiTourokuResult result
                            = new KougakuSabisuhiShikyuuShinnseiTourokuResult();
                    RStringBuilder builder = new RStringBuilder();
                    builder.append(row.getData12().getValue());
                    builder.append(アンダーライン);
                    builder.append(row.getData13().getValue());
                    builder.append(アンダーライン);
                    builder.append(row.getData1());
                    builder.append(アンダーライン);
                    builder.append(row.getData11());
                    builder.append(アンダーライン);
                    builder.append(row.getData14().getValue().intValue());
                    JigyoKogakuKyufuTaishoshaMeisai 給付対象者明細entity
                            = buid事業高額給付対象者明細entity(明細map.get(builder.toRString()), row);
                    result.set事業高額介護サービス費給付対象者明細Entity(給付対象者明細entity);
                    entityList.add(result);
                } else if (row.getData10().equals(TWO)) {
                    KougakuSabisuhiShikyuuShinnseiTourokuResult result
                            = new KougakuSabisuhiShikyuuShinnseiTourokuResult();
                    RStringBuilder builder = new RStringBuilder();
                    builder.append(row.getData12().getValue());
                    builder.append(アンダーライン);
                    builder.append(row.getData13().getValue());
                    builder.append(アンダーライン);
                    builder.append(row.getData14().getValue().intValue());
                    JigyoKogakuKyufuTaishoshaGokei 給付対象者合計entity
                            = buid事業高額給付対象者合計entity(合計map.get(builder.toRString()), row);
                    result.set事業高額介護サービス費支給対象者合計Entity(給付対象者合計entity);
                    entityList.add(result);
                }
            }
        }
        KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().isTaisyoshaJohoShori(entityList, メニューID);
    }

    private KogakuKyufuTaishoshaMeisai buid給付対象者明細entity(
            KogakuKyufuTaishoshaMeisai entity, dgTaishoshaIchiran_Row row) {
        entity = cleanKogakuKyufuTaishoshaMeisai(entity);
        if (row.getData4().getValue() != null) {
            entity = entity.createBuilderForEdit().setサービス費用合計額(row.getData4().getValue()).build();
        } else {
            entity = entity.createBuilderForEdit().setサービス費用合計額(Decimal.ZERO).build();
        }
        if (row.getData5().getValue() != null) {
            entity = entity.createBuilderForEdit().set利用者負担額(row.getData5().getValue()).build();
        } else {
            entity = entity.createBuilderForEdit().set利用者負担額(Decimal.ZERO).build();
        }
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

    private JigyoKogakuKyufuTaishoshaMeisai buid事業高額給付対象者明細entity(
            JigyoKogakuKyufuTaishoshaMeisai entity, dgTaishoshaIchiran_Row row) {
        if (row.getData4().getValue() != null) {
            entity = entity.createBuilderForEdit().setサービス費用合計額(row.getData4().getValue()).build();
        } else {
            entity = entity.createBuilderForEdit().setサービス費用合計額(Decimal.ZERO).build();
        }
        if (row.getData5().getValue() != null) {
            entity = entity.createBuilderForEdit().set利用者負担額(row.getData5().getValue()).build();
        } else {
            entity = entity.createBuilderForEdit().set利用者負担額(Decimal.ZERO).build();
        }
        entity = entity.createBuilderForEdit().set事業高額給付根拠(row.getData9()).set対象者受取年月(
                FlexibleDate.getNowDate().getYearMonth()).build();
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
            KogakuKyufuTaishoshaGokei entity, dgTaishoshaIchiran_Row row) {
        entity = cleanKogakuKyufuTaishoshaGokei(entity);
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

    private JigyoKogakuKyufuTaishoshaGokei buid事業高額給付対象者合計entity(
            JigyoKogakuKyufuTaishoshaGokei entity, dgTaishoshaIchiran_Row row) {
        entity = entity.createBuilderForEdit().setサービス費用合計額合計(row.getData4().getValue()).build();
        entity = entity.createBuilderForEdit().set利用者負担額合計(row.getData5().getValue()).build();
        entity = entity.createBuilderForEdit().set算定基準額(row.getData6().getValue()).build();
        entity = entity.createBuilderForEdit().set支払済金額合計(row.getData7().getValue()).build();
        entity = entity.createBuilderForEdit().set事業高額支給額(row.getData8().getValue()).build();
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
        entity = entity.createBuilderForEdit().setサービス費用合計額(NUMBER_0).build();
        entity = entity.createBuilderForEdit().set利用者負担額(NUMBER_0).build();
        return entity;
    }

    private KogakuKyufuTaishoshaGokei cleanKogakuKyufuTaishoshaGokei(KogakuKyufuTaishoshaGokei entity) {
        entity = entity.createBuilderForEdit().setサービス費用合計額合計(NUMBER_0).build();
        entity = entity.createBuilderForEdit().set利用者負担額合計(NUMBER_0).build();
        entity = entity.createBuilderForEdit().set算定基準額(NUMBER_0).build();
        entity = entity.createBuilderForEdit().set支払済金額合計(NUMBER_0).build();
        entity = entity.createBuilderForEdit().set高額支給額(NUMBER_0).build();
        entity = entity.createBuilderForEdit().set対象者判定審査年月(FlexibleYearMonth.EMPTY).build();
        return entity;
    }

    private KogakuShikyuShinsei get高額支給申請entity(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月, HokenshaNo 証記載保険者番号,
            KogakuShikyuShinsei entity) {
        if (entity == null) {
            int 履歴番号 = KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().
                    get高額介護支給申請履歴番号(被保険者番号, サービス年月);
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

    private JigyoKogakuShikyuShinsei get事業高額支給申請entity(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月, HokenshaNo 証記載保険者番号,
            JigyoKogakuShikyuShinsei entity) {
        if (entity == null) {
            int 履歴番号 = KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().
                    get事業高額介護支給申請履歴番号(被保険者番号, サービス年月);
            entity = new JigyoKogakuShikyuShinsei(被保険者番号, サービス年月,
                    証記載保険者番号, new Decimal(履歴番号)).createBuilderForEdit().build();
        }
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
            HokenshaNo 証記載保険者番号, KogakuShikyuHanteiKekka entity) {
        if (entity == null) {
            int 履歴番号 = KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().
                    get高額介護判定結果履歴番号(被保険者番号, サービス年月);
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

    private JigyoKogakuShikyuHanteiKekka get事業高額支給判定結果entity(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            HokenshaNo 証記載保険者番号,
            JigyoKogakuShikyuHanteiKekka entity) {
        if (entity == null) {
            int 履歴番号 = KougakuSabisuhiShikyuuShinnseiTouroku.createInstance().
                    get事業高額介護判定結果履歴番号(被保険者番号, サービス年月);
            entity = new JigyoKogakuShikyuHanteiKekka(被保険者番号,
                    サービス年月, 証記載保険者番号, new Decimal(履歴番号)).createBuilderForEdit().build();
        }
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
            HokenshaNo 証記載保険者番号, int 履歴番号) {
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
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支払金額合計() != null) {
            entity = entity.createBuilderForEdit().set利用者負担額(
                    div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支払金額合計().intValue()).build();
        }
        if (div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給金額() != null) {
            entity = entity.createBuilderForEdit().set支給額(
                    div.getShinseiTorokuPanel().getCcdKogakuServicehiDetail().get支給金額().intValue()).build();
        }
        entity = entity.createBuilderForEdit().set管理番号(new RString(履歴番号)).build();
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
                .set申請者住所(RString.EMPTY)
                .set閉庁内容(RString.EMPTY)
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
                .set本人支払額(NUMBER_0)
                .set支給金額(NUMBER_0)
                .set不支給理由(null)
                .set審査方法区分(null)
                .set判定結果送付年月(FlexibleYearMonth.EMPTY)
                .set審査結果反映区分(RString.EMPTY)
                .set決定通知書作成年月日(FlexibleDate.EMPTY)
                .set振込明細書作成年月日(FlexibleDate.EMPTY)
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
            if (修正.equals(ddgList.getData0())
                    || 追加.equals(ddgList.getData0())
                    || 削除.equals(ddgList.getData0())) {
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
