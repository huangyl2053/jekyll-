/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kougakusabisuhishikyuushinnseitouroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishikyuushinnseitouroku.KougakuSabisuhiShikyuuShinnseiTourokuEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishikyuushinnseitouroku.KougakuSabisuhiShikyuuShinnseiTourokuResult;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3055KogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3056KogakuShikyuShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3057KogakuShikyuHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3110JigyoKogakuShikyuShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBCMN42001_高額サービス費支給申請登録（画面）
 *
 * @reamsid_L DBC-2020-070 quxiaodong
 */
public class KougakuSabisuhiShikyuuShinnseiTouroku {

    private static final RString 高額サービス費支給申請書登録 = new RString("DBCMN42001");
    private static final RString 総合事業高額サービス費支給申請書登録 = new RString("DBCMN42002");
    private static final RString 最新番号 = new RString("最新番号");
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString 追加モード = new RString("追加モード");
    private static final RString 修正モード = new RString("修正モード");
    private static final RString 削除モード = new RString("削除モード");
    private static final RString 不支給 = new RString("不支給");
    private static final RString 支給 = new RString("支給");
    private static final KokanShikibetsuNo 定値_交換情報識別番号1 = new KokanShikibetsuNo("1131");
    private static final KokanShikibetsuNo 定値_交換情報識別番号2 = new KokanShikibetsuNo("1132");
    private static final KokanShikibetsuNo 定値_交換情報識別番号3 = new KokanShikibetsuNo("1133");
    private static final KokanShikibetsuNo 定値_交換情報識別番号4 = new KokanShikibetsuNo("1134");
    private static final KokanShikibetsuNo 定値_交換情報識別番号5 = new KokanShikibetsuNo("1135");
    private static final KokanShikibetsuNo 定値_交換情報識別番号6 = new KokanShikibetsuNo("1136");
    private static final KokanShikibetsuNo 定値_交換情報識別番号7 = new KokanShikibetsuNo("1137");
    private static final KokanShikibetsuNo 定値_交換情報識別番号8 = new KokanShikibetsuNo("1138");
    private static final FlexibleYearMonth 平成15年3月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成15年4月 = new FlexibleYearMonth("200304");
    private static final FlexibleYearMonth 平成17年10月 = new FlexibleYearMonth("200510");
    private static final FlexibleYearMonth 平成18年4月 = new FlexibleYearMonth("200604");
    private static final FlexibleYearMonth 平成20年4月 = new FlexibleYearMonth("200804");
    private static final FlexibleYearMonth 平成21年4月 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth 平成24年4月 = new FlexibleYearMonth("201204");
    private static final FlexibleYearMonth 平成27年4月 = new FlexibleYearMonth("201504");
    private final DbT3054KogakuKyufuTaishoshaMeisaiDac 高額介護サービス費給付対象者明細Dac;
    private final DbT3055KogakuKyufuTaishoshaGokeiDac 高額介護サービス費給付対象者合計Dac;
    private final DbT3056KogakuShikyuShinseiDac 高額サービス費支給申請Dac;
    private final DbT3057KogakuShikyuHanteiKekkaDac 高額介護サービス費支給判定結果Dac;
    private final DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac 事業高額介護サービス費給付対象者明細Dac;
    private final DbT3109JigyoKogakuKyufuTaishoshaGokeiDac 事業高額介護サービス費給付対象者合計Dac;
    private final DbT3110JigyoKogakuShikyuShinseiDac 事業高額サービス費支給申請Dac;
    private final DbT3111JigyoKogakuShikyuHanteiKekkaDac 事業高額介護サービス費支給判定結果Dac;
    private final DbT3028KyufujissekiKogakuKaigoServicehiDac 給付実績高額介護サービス費Dac;

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KougakuSabisuhiShikyuuShinnseiTouroku}のインスタンス
     */
    public static KougakuSabisuhiShikyuuShinnseiTouroku createInstance() {
        return InstanceProvider.create(KougakuSabisuhiShikyuuShinnseiTouroku.class);
    }

    /**
     * コンストラクタです。
     */
    public KougakuSabisuhiShikyuuShinnseiTouroku() {
        this.高額介護サービス費給付対象者明細Dac = InstanceProvider.create(DbT3054KogakuKyufuTaishoshaMeisaiDac.class);
        this.高額介護サービス費給付対象者合計Dac = InstanceProvider.create(DbT3055KogakuKyufuTaishoshaGokeiDac.class);
        this.高額サービス費支給申請Dac = InstanceProvider.create(DbT3056KogakuShikyuShinseiDac.class);
        this.高額介護サービス費支給判定結果Dac = InstanceProvider.create(DbT3057KogakuShikyuHanteiKekkaDac.class);
        this.事業高額介護サービス費給付対象者明細Dac
                = InstanceProvider.create(DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac.class);
        this.事業高額介護サービス費給付対象者合計Dac
                = InstanceProvider.create(DbT3109JigyoKogakuKyufuTaishoshaGokeiDac.class);
        this.事業高額サービス費支給申請Dac
                = InstanceProvider.create(DbT3110JigyoKogakuShikyuShinseiDac.class);
        this.事業高額介護サービス費支給判定結果Dac
                = InstanceProvider.create(DbT3111JigyoKogakuShikyuHanteiKekkaDac.class);
        this.給付実績高額介護サービス費Dac
                = InstanceProvider.create(DbT3028KyufujissekiKogakuKaigoServicehiDac.class);
    }

    /**
     * 画面のデータをＤＢに追加,更新,削除する。
     *
     * @param 画面DIV KougakuSabisuhiShikyuuShinnseiTourokuEntity
     * @param メニューID RString
     * @return true
     */
    @Transaction
    public boolean is更新処理(KougakuSabisuhiShikyuuShinnseiTourokuEntity 画面DIV, RString メニューID) {
        if (高額サービス費支給申請書登録.equals(メニューID)) {
            if (画面DIV.get高額介護サービス費支給申請Entity() != null
                    && EntityDataState.Deleted.equals(
                            画面DIV.get高額介護サービス費支給申請Entity().toEntity().getState())) {
                upd高額介護支給申請(画面DIV.get高額介護サービス費支給申請Entity());
            } else if (画面DIV.get高額介護サービス費支給申請Entity() != null
                    && 画面DIV.get高額介護サービス費支給申請Entity().get申請年月日() != null
                    && !画面DIV.get高額介護サービス費支給申請Entity().get申請年月日().isEmpty()) {
                upd高額介護支給申請(画面DIV.get高額介護サービス費支給申請Entity());
            }
            if (画面DIV.get高額介護サービス費支給判定結果Entity() != null
                    && EntityDataState.Deleted.equals(
                            画面DIV.get高額介護サービス費支給判定結果Entity().toEntity().getState())) {
                upd高額介護支給判定結果(画面DIV.get高額介護サービス費支給判定結果Entity());
            } else if (画面DIV.get高額介護サービス費支給判定結果Entity() != null
                    && 画面DIV.get高額介護サービス費支給判定結果Entity().get決定年月日() != null
                    && !画面DIV.get高額介護サービス費支給判定結果Entity().get決定年月日().isEmpty()) {
                upd高額介護支給判定結果(画面DIV.get高額介護サービス費支給判定結果Entity());
            }
        } else if (総合事業高額サービス費支給申請書登録.equals(メニューID)) {
            upd事業高額支給申請書登録(画面DIV);
        }
        return true;
    }

    private void upd事業高額支給申請書登録(KougakuSabisuhiShikyuuShinnseiTourokuEntity 画面DIV) {
        if (画面DIV.get事業高額介護サービス費支給申請Entity() != null
                && EntityDataState.Deleted.equals(
                        画面DIV.get事業高額介護サービス費支給申請Entity().toEntity().getState())) {
            upd事業高額介護支給申請(画面DIV.get事業高額介護サービス費支給申請Entity());
        } else if (画面DIV.get事業高額介護サービス費支給申請Entity() != null
                && 画面DIV.get事業高額介護サービス費支給申請Entity().get申請年月日() != null
                && !画面DIV.get事業高額介護サービス費支給申請Entity().get申請年月日().isEmpty()) {
            upd事業高額介護支給申請(画面DIV.get事業高額介護サービス費支給申請Entity());
        }
        if (画面DIV.get事業高額介護サービス費支給申請Entity() != null
                && EntityDataState.Deleted.equals(
                        画面DIV.get事業高額介護サービス費支給申請Entity().toEntity().getState())) {
            upd事業高額介護支給申請(画面DIV.get事業高額介護サービス費支給申請Entity());
        } else if (画面DIV.get事業高額介護サービス費支給判定結果Entity() != null
                && 画面DIV.get事業高額介護サービス費支給判定結果Entity().get決定年月日() != null
                && !画面DIV.get事業高額介護サービス費支給判定結果Entity().get決定年月日().isEmpty()) {
            upd事業高額介護支給判定結果(画面DIV.get事業高額介護サービス費支給判定結果Entity());
        }
    }

    /**
     * 対象者情報の登録、更新、削除処理を行う。
     *
     * @param 対象者情報list List<KougakuSabisuhiShikyuuShinnseiTourokuResult>
     * @param メニューID RString
     * @return true
     */
    @Transaction
    public boolean isTaisyoshaJohoShori(List<KougakuSabisuhiShikyuuShinnseiTourokuResult> 対象者情報list,
            RString メニューID) {
        if (高額サービス費支給申請書登録.equals(メニューID)
                && 対象者情報list != null && !対象者情報list.isEmpty()) {
            upd高額対象者情報処理(対象者情報list);
        } else if (総合事業高額サービス費支給申請書登録.equals(メニューID)
                && 対象者情報list != null && !対象者情報list.isEmpty()) {
            upd事業高額対象者情報処理(対象者情報list);
        }
        return true;
    }

    /**
     * 給付実績情報の登録、更新処理を行う。
     *
     * @param 高額サービス費詳細内容Entity KougakuSabisuhiShousaiNaiyouResult
     * @param 修正前支給区分 RString
     * @param 処理モード RString
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 証記載保険者番号 HokenshaNo
     * @param 履歴番号 int
     * @param 給付実績編集用entity KyufujissekiKogakuKaigoServicehi
     */
    public void dealKyufujisseki(KougakuSabisuhiShousaiNaiyouResult 高額サービス費詳細内容Entity,
            RString 修正前支給区分, RString 処理モード, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, HokenshaNo 証記載保険者番号,
            int 履歴番号, KyufujissekiKogakuKaigoServicehi 給付実績編集用entity) {
        RString 受託区分 = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (ONE.equals(受託区分)) {
            if (追加モード.equals(処理モード) && ((高額サービス費詳細内容Entity != null && 高額サービス費詳細内容Entity.
                    get高額介護サービス費支給審査決定Entity() != null
                    && ShikyuFushikyuKubun.支給.getコード().equals(高額サービス費詳細内容Entity.
                            get高額介護サービス費支給審査決定Entity().get支給区分コード())))) {
                dealKyufutsuika(被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, ONE, 給付実績編集用entity);
            } else if (修正モード.equals(処理モード)) {
                set受託なしと修正モードの給付実績情報(高額サービス費詳細内容Entity, 修正前支給区分,
                        被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, 給付実績編集用entity);
            } else if (削除モード.equals(処理モード)) {
                set受託なしと削除モードの給付実績情報(高額サービス費詳細内容Entity, 被保険者番号, サービス年月,
                        証記載保険者番号, 履歴番号);
            }
        } else if (ZERO.equals(受託区分)) {
            if (修正モード.equals(処理モード)) {
                set受託ありと修正モードの給付実績情報(被保険者番号, サービス年月, 証記載保険者番号, 履歴番号);
            } else if (削除モード.equals(処理モード)) {
                set受託ありと削除モードの給付実績情報(被保険者番号, サービス年月, 証記載保険者番号, 履歴番号);
            }
        }
    }

    /**
     * 給付実績高額介護サービス費テーブルにデータの追加処理を行う。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 証記載保険者番号 HokenshaNo
     * @param 履歴番号 int
     * @param 給付実績情報作成区分コード RString
     * @param 給付実績編集用entity DealKyufujissekiDataShutokuEntity
     */
    @Transaction
    public void dealKyufutsuika(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号, int 履歴番号, RString 給付実績情報作成区分コード,
            KyufujissekiKogakuKaigoServicehi 給付実績編集用entity) {
        RString 通し番号 = Saiban.get(SubGyomuCode.DBC介護給付,
                SaibanHanyokeyName.実績管理番号.get名称(), FlexibleDate.getNowDate().getNendo()).nextString();
        if (通し番号 == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace(最新番号.toString()));
        } else {
            給付実績編集用entity = 給付実績編集用entity.createBuilderForEdit().set通し番号(通し番号).build();
        }
        if (サービス提供年月.isBeforeOrEquals(平成15年3月)) {
            給付実績編集用entity = 給付実績編集用entity.createBuilderForEdit().
                    set交換情報識別番号(定値_交換情報識別番号1).build();
        } else if (平成15年4月.isBeforeOrEquals(サービス提供年月) && サービス提供年月.isBefore(平成17年10月)) {
            給付実績編集用entity = 給付実績編集用entity.createBuilderForEdit().
                    set交換情報識別番号(定値_交換情報識別番号2).build();
        } else if (平成17年10月.isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(平成18年4月)) {
            給付実績編集用entity = 給付実績編集用entity.createBuilderForEdit().
                    set交換情報識別番号(定値_交換情報識別番号3).build();
        } else if (平成18年4月.isBeforeOrEquals(サービス提供年月) && サービス提供年月.isBefore(平成20年4月)) {
            給付実績編集用entity = 給付実績編集用entity.createBuilderForEdit().
                    set交換情報識別番号(定値_交換情報識別番号4).build();
        } else if (平成20年4月.isBeforeOrEquals(サービス提供年月) && サービス提供年月.isBefore(平成21年4月)) {
            給付実績編集用entity = 給付実績編集用entity.createBuilderForEdit().
                    set交換情報識別番号(定値_交換情報識別番号5).build();
        } else if (平成21年4月.isBeforeOrEquals(サービス提供年月) && サービス提供年月.isBefore(平成24年4月)) {
            給付実績編集用entity = 給付実績編集用entity.createBuilderForEdit().
                    set交換情報識別番号(定値_交換情報識別番号6).build();
        } else if (平成24年4月.isBeforeOrEquals(サービス提供年月) && サービス提供年月.isBefore(平成27年4月)) {
            給付実績編集用entity = 給付実績編集用entity.createBuilderForEdit().
                    set交換情報識別番号(定値_交換情報識別番号7).build();
        } else if (平成27年4月.isBeforeOrEquals(サービス提供年月)) {
            給付実績編集用entity = 給付実績編集用entity.createBuilderForEdit().
                    set交換情報識別番号(定値_交換情報識別番号8).build();
        }
        if (!EntityDataState.Unchanged.equals(給付実績編集用entity.toEntity().getState())) {
            給付実績高額介護サービス費Dac.save(給付実績編集用entity.toEntity());
        }
    }

    /**
     * 給付実績データ取得処理を行う。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 証記載保険者番号 HokenshaNo
     * @return DealKyufujissekiDataShutokuEntity
     */
    @Transaction
    public KyufujissekiKogakuKaigoServicehi dealKyufujissekiDataShutoku(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号) {
        KyufujissekiKogakuKaigoServicehi 給付実績entity = null;
        DbT3028KyufujissekiKogakuKaigoServicehiEntity entity
                = 給付実績高額介護サービス費Dac.selectAllByKey(被保険者番号, サービス提供年月, 証記載保険者番号);
        if (entity != null) {
            給付実績entity = new KyufujissekiKogakuKaigoServicehi(entity);
        }
        return 給付実績entity;
    }

    /**
     * 高額介護支給申請履歴番号取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return int
     */
    public int get高額介護支給申請履歴番号(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        int 履歴番号 = 0;
        List<DbT3056KogakuShikyuShinseiEntity> 支給申請list
                = 高額サービス費支給申請Dac.selectAllByKey(被保険者番号, サービス提供年月);
        if (支給申請list != null && 支給申請list.isEmpty()) {
            for (DbT3056KogakuShikyuShinseiEntity entity : 支給申請list) {
                if (履歴番号 < entity.getRirekiNo().intValue()) {
                    履歴番号 = entity.getRirekiNo().intValue();
                }
            }
        }
        return 履歴番号 + 1;
    }

    /**
     * 高額介護判定結果履歴番号取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return int
     */
    public int get高額介護判定結果履歴番号(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        int 履歴番号 = 0;
        List<DbT3057KogakuShikyuHanteiKekkaEntity> 支給申請list
                = 高額介護サービス費支給判定結果Dac.selectAllByKey(被保険者番号, サービス提供年月);
        if (支給申請list != null && 支給申請list.isEmpty()) {
            for (DbT3057KogakuShikyuHanteiKekkaEntity entity : 支給申請list) {
                if (履歴番号 < entity.getRirekiNo()) {
                    履歴番号 = entity.getRirekiNo();
                }
            }
        }
        return 履歴番号 + 1;
    }

    /**
     * 高額介護給付対象者明細履歴番号取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return int
     */
    public int get高額介護給付対象者明細履歴番号(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        int 履歴番号 = 0;
        List<DbT3054KogakuKyufuTaishoshaMeisaiEntity> 支給申請list
                = 高額介護サービス費給付対象者明細Dac.selectAllByKey(被保険者番号, サービス提供年月);
        if (支給申請list != null && 支給申請list.isEmpty()) {
            for (DbT3054KogakuKyufuTaishoshaMeisaiEntity entity : 支給申請list) {
                if (履歴番号 < entity.getRirekiNo()) {
                    履歴番号 = entity.getRirekiNo();
                }
            }
        }
        return 履歴番号 + 1;
    }

    /**
     * 高額介護給付対象者合計履歴番号取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return int
     */
    public int get高額介護給付対象者合計履歴番号(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        int 履歴番号 = 0;
        List<DbT3055KogakuKyufuTaishoshaGokeiEntity> 支給申請list
                = 高額介護サービス費給付対象者合計Dac.selectAllByKey(被保険者番号, サービス提供年月);
        if (支給申請list != null && 支給申請list.isEmpty()) {
            for (DbT3055KogakuKyufuTaishoshaGokeiEntity entity : 支給申請list) {
                if (履歴番号 < entity.getRirekiNo().intValue()) {
                    履歴番号 = entity.getRirekiNo().intValue();
                }
            }
        }
        return 履歴番号 + 1;
    }

    /**
     * 事業高額高額介護支給申請履歴番号取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return int
     */
    public int get事業高額高額介護支給申請履歴番号(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        int 履歴番号 = 0;
        List<DbT3110JigyoKogakuShikyuShinseiEntity> 支給申請list
                = 事業高額サービス費支給申請Dac.selectAllByKey(被保険者番号, サービス提供年月);
        if (支給申請list != null && 支給申請list.isEmpty()) {
            for (DbT3110JigyoKogakuShikyuShinseiEntity entity : 支給申請list) {
                if (履歴番号 < entity.getRirekiNo().intValue()) {
                    履歴番号 = entity.getRirekiNo().intValue();
                }
            }
        }
        return 履歴番号 + 1;
    }

    /**
     * 事業高額介護判定結果履歴番号取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return int
     */
    public int get事業高額介護判定結果履歴番号(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        int 履歴番号 = 0;
        List<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> 支給申請list
                = 事業高額介護サービス費支給判定結果Dac.selectAllByKey(被保険者番号, サービス提供年月);
        if (支給申請list != null && 支給申請list.isEmpty()) {
            for (DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity : 支給申請list) {
                if (履歴番号 < entity.getRirekiNo().intValue()) {
                    履歴番号 = entity.getRirekiNo().intValue();
                }
            }
        }
        return 履歴番号 + 1;
    }

    /**
     * 事業高額介護給付対象者明細履歴番号取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return int
     */
    public int get事業高額介護給付対象者明細履歴番号(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        int 履歴番号 = 0;
        List<DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity> 支給申請list
                = 事業高額介護サービス費給付対象者明細Dac.selectAllByKey(被保険者番号, サービス提供年月);
        if (支給申請list != null && 支給申請list.isEmpty()) {
            for (DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity : 支給申請list) {
                if (履歴番号 < entity.getRirekiNo()) {
                    履歴番号 = entity.getRirekiNo();
                }
            }
        }
        return 履歴番号 + 1;
    }

    /**
     * 事業高額介護給付対象者合計履歴番号取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return int
     */
    public int get事業高額介護給付対象者合計履歴番号(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        int 履歴番号 = 0;
        List<DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity> 支給申請list
                = 事業高額介護サービス費給付対象者合計Dac.selectAllByKey(被保険者番号, サービス提供年月);
        if (支給申請list != null && 支給申請list.isEmpty()) {
            for (DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity entity : 支給申請list) {
                if (履歴番号 < entity.getRirekiNo().intValue()) {
                    履歴番号 = entity.getRirekiNo().intValue();
                }
            }
        }
        return 履歴番号 + 1;
    }

    private void upd高額介護支給申請(KogakuShikyuShinsei entity) {
        if (EntityDataState.Deleted.equals(entity.toEntity().getState())) {
            高額サービス費支給申請Dac.delete(entity.toEntity());
        } else if (!EntityDataState.Unchanged.equals(entity.toEntity().getState())) {
            高額サービス費支給申請Dac.save(entity.toEntity());
        }
    }

    private void upd高額介護支給判定結果(KogakuShikyuHanteiKekka entity) {
        if (EntityDataState.Deleted.equals(entity.toEntity().getState())) {
            高額介護サービス費支給判定結果Dac.delete(entity.toEntity());
        } else if (!EntityDataState.Unchanged.equals(entity.toEntity().getState())) {
            高額介護サービス費支給判定結果Dac.save(entity.toEntity());
        }
    }

    private void upd事業高額介護支給申請(JigyoKogakuShikyuShinsei entity) {
        if (EntityDataState.Deleted.equals(entity.toEntity().getState())) {
            事業高額サービス費支給申請Dac.delete(entity.toEntity());
        } else if (!EntityDataState.Unchanged.equals(entity.toEntity().getState())) {
            事業高額サービス費支給申請Dac.save(entity.toEntity());
        }
    }

    private void upd事業高額介護支給判定結果(JigyoKogakuShikyuHanteiKekka entity) {
        if (EntityDataState.Deleted.equals(entity.toEntity().getState())) {
            事業高額介護サービス費支給判定結果Dac.delete(entity.toEntity());
        } else if (!EntityDataState.Unchanged.equals(entity.toEntity().getState())) {
            事業高額介護サービス費支給判定結果Dac.save(entity.toEntity());
        }
    }

    private void upd高額対象者情報処理(List<KougakuSabisuhiShikyuuShinnseiTourokuResult> 対象者情報list) {
        for (KougakuSabisuhiShikyuuShinnseiTourokuResult entity : 対象者情報list) {
            if (entity.get高額介護サービス費給付対象者明細Entity() != null) {
                if (EntityDataState.Deleted.equals(entity.
                        get高額介護サービス費給付対象者明細Entity().toEntity().getState())) {
                    高額介護サービス費給付対象者明細Dac.delete(entity.
                            get高額介護サービス費給付対象者明細Entity().toEntity());
                } else if (!EntityDataState.Unchanged.equals(entity.
                        get高額介護サービス費給付対象者明細Entity().toEntity().getState())) {
                    高額介護サービス費給付対象者明細Dac.save(entity.
                            get高額介護サービス費給付対象者明細Entity().toEntity());
                }
            }
            if (entity.get高額介護サービス費支給対象者合計Entity() != null) {
                if (EntityDataState.Deleted.equals(entity.
                        get高額介護サービス費支給対象者合計Entity().toEntity().getState())) {
                    高額介護サービス費給付対象者合計Dac.delete(entity.
                            get高額介護サービス費支給対象者合計Entity().toEntity());
                } else if (!EntityDataState.Unchanged.equals(entity.
                        get高額介護サービス費支給対象者合計Entity().toEntity().getState())) {
                    高額介護サービス費給付対象者合計Dac.save(entity.
                            get高額介護サービス費支給対象者合計Entity().toEntity());
                }
            }
        }
    }

    private void upd事業高額対象者情報処理(List<KougakuSabisuhiShikyuuShinnseiTourokuResult> 対象者情報list) {
        for (KougakuSabisuhiShikyuuShinnseiTourokuResult entity : 対象者情報list) {
            if (entity.get事業高額介護サービス費給付対象者明細Entity() != null) {
                if (EntityDataState.Deleted.equals(entity.
                        get事業高額介護サービス費給付対象者明細Entity().toEntity().getState())) {
                    事業高額介護サービス費給付対象者明細Dac.delete(entity.
                            get事業高額介護サービス費給付対象者明細Entity().toEntity());
                } else if (!EntityDataState.Unchanged.equals(entity.
                        get事業高額介護サービス費給付対象者明細Entity().toEntity().getState())) {
                    事業高額介護サービス費給付対象者明細Dac.save(entity.
                            get事業高額介護サービス費給付対象者明細Entity().toEntity());
                }
            }
            if (entity.get事業高額介護サービス費支給対象者合計Entity() != null) {
                if (EntityDataState.Deleted.equals(entity.
                        get事業高額介護サービス費支給対象者合計Entity().toEntity().getState())) {
                    事業高額介護サービス費給付対象者合計Dac.delete(entity.
                            get事業高額介護サービス費支給対象者合計Entity().toEntity());
                } else if (!EntityDataState.Unchanged.equals(entity.
                        get事業高額介護サービス費支給対象者合計Entity().toEntity().getState())) {
                    事業高額介護サービス費給付対象者合計Dac.save(entity.
                            get事業高額介護サービス費支給対象者合計Entity().toEntity());
                }
            }
        }
    }

    private void set受託なしと修正モードの給付実績情報(KougakuSabisuhiShousaiNaiyouResult 高額サービス費詳細内容Entity,
            RString 修正前支給区分, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, HokenshaNo 証記載保険者番号,
            int 履歴番号, KyufujissekiKogakuKaigoServicehi 給付実績編集用entity) {
        if (不支給.equals(修正前支給区分)
                && (高額サービス費詳細内容Entity != null && 高額サービス費詳細内容Entity.
                get高額介護サービス費支給審査決定Entity() != null
                && ONE.equals(高額サービス費詳細内容Entity.
                        get高額介護サービス費支給審査決定Entity().get支給区分コード()))) {
            dealKyufutsuika(被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, ONE, 給付実績編集用entity);
        } else if (支給.equals(修正前支給区分)
                && (高額サービス費詳細内容Entity != null && 高額サービス費詳細内容Entity.
                get高額介護サービス費支給審査決定Entity() != null
                && ONE.equals(高額サービス費詳細内容Entity.
                        get高額介護サービス費支給審査決定Entity().get支給区分コード()))) {
            KyufujissekiKogakuKaigoServicehi 給付実績entity
                    = dealKyufujissekiDataShutoku(被保険者番号, サービス年月, 証記載保険者番号);
            if (給付実績entity != null) {
                dealKyufutsuika(被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, TWO, 給付実績entity);
            }
        } else if (支給.equals(修正前支給区分)
                && (高額サービス費詳細内容Entity != null && 高額サービス費詳細内容Entity.
                get高額介護サービス費支給審査決定Entity() != null
                && ZERO.equals(高額サービス費詳細内容Entity.
                        get高額介護サービス費支給審査決定Entity().get支給区分コード()))) {
            KyufujissekiKogakuKaigoServicehi 給付実績entity
                    = dealKyufujissekiDataShutoku(被保険者番号, サービス年月, 証記載保険者番号);
            if (給付実績entity != null) {
                dealKyufutsuika(被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, THREE, 給付実績entity);
            }
        }
    }

    private void set受託なしと削除モードの給付実績情報(KougakuSabisuhiShousaiNaiyouResult 高額サービス費詳細内容Entity,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月, HokenshaNo 証記載保険者番号, int 履歴番号) {
        if ((高額サービス費詳細内容Entity != null && 高額サービス費詳細内容Entity.
                get高額介護サービス費支給審査決定Entity() != null
                && ShikyuFushikyuKubun.支給.getコード().equals(高額サービス費詳細内容Entity.
                        get高額介護サービス費支給審査決定Entity().get支給区分コード()))) {
            KyufujissekiKogakuKaigoServicehi 給付実績entity
                    = dealKyufujissekiDataShutoku(被保険者番号, サービス年月, 証記載保険者番号);
            if (給付実績entity != null) {
                dealKyufutsuika(被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, THREE, 給付実績entity);
            }
        }
    }

    private void set受託ありと修正モードの給付実績情報(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            HokenshaNo 証記載保険者番号, int 履歴番号) {
        KyufujissekiKogakuKaigoServicehi 給付実績entity
                = dealKyufujissekiDataShutoku(被保険者番号, サービス年月, 証記載保険者番号);
        if (給付実績entity != null) {
            dealKyufutsuika(被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, TWO, 給付実績entity);
        }
    }

    private void set受託ありと削除モードの給付実績情報(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月,
            HokenshaNo 証記載保険者番号, int 履歴番号) {
        KyufujissekiKogakuKaigoServicehi 給付実績entity
                = dealKyufujissekiDataShutoku(被保険者番号, サービス年月, 証記載保険者番号);
        if (給付実績entity != null) {
            dealKyufutsuika(被保険者番号, サービス年月, 証記載保険者番号, 履歴番号, THREE, 給付実績entity);
        }
    }
}
