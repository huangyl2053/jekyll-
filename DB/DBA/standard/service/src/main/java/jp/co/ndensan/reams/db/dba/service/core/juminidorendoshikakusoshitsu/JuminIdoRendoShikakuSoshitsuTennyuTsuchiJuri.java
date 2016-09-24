/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakusoshitsu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.NaiBushoRyouParamter;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.StoreConfigParamter;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.TemParamter;
import jp.co.ndensan.reams.db.dba.definition.core.juminrendo.JuminRendoFuseigo;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendoshikakutoroku.JuminIdoRendoShikakuTorokuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBAMN00000_住民異動連動資格登録（転出・死亡・転入通知受理）のビジネスクラスです。
 *
 * @reamsid_L DBA-1410-013 houtianpeng
 */
public class JuminIdoRendoShikakuSoshitsuTennyuTsuchiJuri {

    private final DbT1001HihokenshaDaichoDac dbT1001Dac;
    private final RString 直近 = new RString("1");
    private final RString 転出 = new RString("2");
    private final RString 不整合コード_9999 = new RString("9999");
    private final RString flag_OFF = new RString("0");
    private final RString flag_ON = new RString("1");
    private final RString ptn_1 = new RString("転出させる");
    private final RString ptn_2 = new RString("転出データ論理削除済");
    private final RString ptn_3 = new RString("目的の転出");

    /**
     * コンストラクタです。
     */
    public JuminIdoRendoShikakuSoshitsuTennyuTsuchiJuri() {
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param DbT1001HihokenshaDaichoDac dbT1001Dac
     */
    JuminIdoRendoShikakuSoshitsuTennyuTsuchiJuri(
            DbT1001HihokenshaDaichoDac dbT1001Dac) {
        this.dbT1001Dac = dbT1001Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoTennyuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoShikakuSoshitsuTennyuTsuchiJuri}のインスタンス
     */
    public static JuminIdoRendoShikakuSoshitsuTennyuTsuchiJuri createInstance() {
        return InstanceProvider.create(JuminIdoRendoShikakuSoshitsuTennyuTsuchiJuri.class);
    }

    /**
     * 被保台帳の転出処理を行う。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void tenshutsuHihodaicho(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter, JuminIdoRendoShikakuTorokuEntity entity) {

        NaiBushoRyouParamter paramter = new NaiBushoRyouParamter();
        被保台帳転出処理_到達日転出予定日翌日の算出(住民異動情報, storeConfigParamter, paramter);
        searchHihodaicho(entity, 直近);
        if (!被保台帳転出処理_被保険者処理要否判定(entity, paramter, storeConfigParamter)) {
            return;
        }
        被保台帳転出処理_被保台帳処理の振分け(entity, 住民異動情報, paramter, storeConfigParamter);
    }

    /**
     * 被保台帳なし転出処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param naiBushoRyouParamter NaiBushoRyouParamter
     */
    public void tenshutsuHihodaichoNashi(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            NaiBushoRyouParamter naiBushoRyouParamter) {
        TemParamter temparamter = new TemParamter();
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().getMaxKaijoYmd(entity, 住民異動情報, temparamter);
        if (!temparamter.get登録届出日().isEmpty()
                && nullToMin(住民異動情報.getTorokuIdoYMD()).isBeforeOrEquals(nullToMin(temparamter.get登録異動日()))) {
            住民異動情報.setTorokuIdoYMD(temparamter.get登録異動日());
            住民異動情報.setTorokuTodokedeYMD(temparamter.get登録届出日());
        }
        if (被保台帳なし転出処理_被保台帳生成用の項目編集(naiBushoRyouParamter, 住民異動情報, entity, temparamter)) {
            return;
        }
        if (被保台帳なし転出処理_不整合チェック(naiBushoRyouParamter, entity, temparamter)) {
            return;
        }
        DbT1001HihokenshaDaichoEntity hihokenshaDaicho被保台帳生成
                = 被保台帳なし転出処理_被保台帳生成(entity, 住民異動情報, temparamter, storeConfigParamter);
        hihokenshaDaicho被保台帳生成.setState(EntityDataState.Added);
        dbT1001Dac.save(hihokenshaDaicho被保台帳生成);
        DbT1001HihokenshaDaichoEntity hihokenshaDaicho喪失更新
                = 被保台帳なし転出処理_被保険者台帳の喪失更新(entity, 住民異動情報, naiBushoRyouParamter, temparamter, storeConfigParamter);
        hihokenshaDaicho喪失更新.setState(EntityDataState.Added);
        dbT1001Dac.save(hihokenshaDaicho喪失更新);
        戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳なし転出処理_被保険者台帳の喪失更新(
            JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            NaiBushoRyouParamter naiBushoRyouParamter,
            TemParamter temparamter,
            StoreConfigParamter storeConfigParamter) {
        HihokenshaNo hihokenshaNo = HihokenshanotsukibanFinder.createInstance().getHihokenshanotsukiban(住民異動情報.getShikibetsuCode());
        RString 枝番 = getHihokensyadaichoEdaNo(entity, 住民異動情報.getShikibetsuCode(), naiBushoRyouParamter.get転出予定日翌日());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(hihokenshaNo,
                naiBushoRyouParamter.get転出予定日翌日(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(ShikakuSoshitsuJiyu.転出.getコード());
        builder.set市町村コード(住民異動情報.getGenLasdecCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(temparamter.getTmp取得事由());
        builder.set資格取得年月日(temparamter.getTmp日付());
        builder.set資格取得届出年月日(住民異動情報.getTorokuTodokedeYMD());
        builder.set第1号資格取得年月日(temparamter.getTmp日付());
        builder.set被保険者区分コード(HihokenshaKubunCode.第１号被保険者.getコード());
        builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.転出.getコード());
        builder.set資格喪失年月日(naiBushoRyouParamter.get転出予定日翌日());
        builder.set資格喪失届出年月日(住民異動情報.getShojoTodokedeYMD());
        builder.set資格変更事由コード(RString.EMPTY);
        builder.set資格変更年月日(FlexibleDate.EMPTY);
        builder.set資格変更届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(flag_OFF);
        builder.set広住特措置元市町村コード(LasdecCode.EMPTY);
        if (!new RString("0").equals(storeConfigParamter.get合併区分())) {
            builder.set旧市町村コード(住民異動情報.getKyuLasdecCode());
        }
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳なし転出処理_被保台帳生成(
            JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            TemParamter temparamter,
            StoreConfigParamter storeConfigParamter) {
        HihokenshaNo hihokenshaNo = HihokenshanotsukibanFinder.createInstance().getHihokenshanotsukiban(住民異動情報.getShikibetsuCode());
        RString 枝番 = getHihokensyadaichoEdaNo(entity, 住民異動情報.getShikibetsuCode(), temparamter.getTmp日付());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(hihokenshaNo,
                temparamter.getTmp日付(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(temparamter.getTmp取得事由());
        builder.set市町村コード(住民異動情報.getGenLasdecCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(temparamter.getTmp取得事由());
        builder.set資格取得年月日(temparamter.getTmp日付());
        builder.set資格取得届出年月日(住民異動情報.getTorokuTodokedeYMD());
        builder.set第1号資格取得年月日(temparamter.getTmp日付());
        builder.set被保険者区分コード(HihokenshaKubunCode.第１号被保険者.getコード());
        builder.set資格喪失事由コード(RString.EMPTY);
        builder.set資格喪失年月日(FlexibleDate.EMPTY);
        builder.set資格喪失事由コード(RString.EMPTY);
        builder.set資格変更事由コード(RString.EMPTY);
        builder.set資格喪失年月日(FlexibleDate.EMPTY);
        builder.set資格喪失届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(flag_OFF);
        builder.set広住特措置元市町村コード(LasdecCode.EMPTY);
        if (!new RString("0").equals(storeConfigParamter.get合併区分())) {
            builder.set旧市町村コード(住民異動情報.getKyuLasdecCode());
        }
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private boolean 被保台帳なし転出処理_不整合チェック(NaiBushoRyouParamter naiBushoRyouParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter) {
        if (naiBushoRyouParamter.get転出予定日翌日().isBefore(temparamter.get登録異動日())) {
            戻り値の編集(entity, JuminRendoFuseigo.転出_喪失不能_資格取得日_資格喪失日_不整合.getコード(), RString.EMPTY);
            return true;
        }
        return false;
    }

    private boolean 被保台帳なし転出処理_被保台帳生成用の項目編集(NaiBushoRyouParamter naiBushoRyouParamter,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter) {
        if (nullToMin(naiBushoRyouParamter.get補正後転出予定日翌日()).
                isBeforeOrEquals(nullToMin(temparamter.get登録異動日()))) {
            if (nullToMin(住民異動情報.getTorokuIdoYMD()).
                    isBeforeOrEquals(nullToMin(naiBushoRyouParamter.get補正後転出予定日翌日()))) {
                temparamter.setTmp取得事由(ShikakuShutokuJiyu.その他.getコード());
                temparamter.setTmp日付(住民異動情報.getTorokuIdoYMD());
            }
            if (naiBushoRyouParamter.get補正後転出予定日翌日().isBefore(temparamter.get登録異動日())) {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
                return true;
            }
        }
        if (temparamter.get登録異動日().isBefore(naiBushoRyouParamter.get補正後65歳到達日())) {
            if (nullToMin(住民異動情報.getTorokuIdoYMD()).isBeforeOrEquals(nullToMin(naiBushoRyouParamter.get補正後転出予定日翌日()))) {
                temparamter.setTmp取得事由(ShikakuShutokuJiyu.年齢到達.getコード());
                temparamter.setTmp日付(naiBushoRyouParamter.get到達日_65歳());
                住民異動情報.setTorokuTodokedeYMD(naiBushoRyouParamter.get補正後65歳到達日());
            } else {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
                return true;
            }
        }
        return false;
    }

    private void 被保台帳転出処理_到達日転出予定日翌日の算出(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            NaiBushoRyouParamter paramter) {

        FlexibleDate 到達日_65 = JuminIdoRendoShikakuSoshitsuShiboKyoTu.
                createInstance().getNenreiTotatsuYmd(住民異動情報, storeConfigParamter);
        FlexibleDate 介護保険法施行日 = storeConfigParamter.get介護保険法施行日();
        if (到達日_65.isBefore(介護保険法施行日)) {
            到達日_65 = 介護保険法施行日;
        }
        paramter.set到達日_65歳(到達日_65);
        FlexibleDate 転出予定日の翌日 = nullToMin(住民異動情報.getTenshutsuYoteiIdoYMD()).plusDay(1);
        if (転出予定日の翌日.isBefore(介護保険法施行日)) {
            転出予定日の翌日 = 介護保険法施行日;
        }
        paramter.set転出予定日翌日(転出予定日の翌日);
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().nenreiCalc(住民異動情報, paramter);
    }

    private boolean 被保台帳転出処理_被保険者処理要否判定(
            JuminIdoRendoShikakuTorokuEntity entity,
            NaiBushoRyouParamter paramter,
            StoreConfigParamter storeConfigParamter) {

        List<DbT1001HihokenshaDaichoEntity> dbT1001List = entity.get被保険者台帳EntityList();
        RString 喪失事由 = RString.EMPTY;
        RString 第２号被保険者基準年齢 = storeConfigParamter.get第２号被保険者基準年齢();
        if (dbT1001List != null && !dbT1001List.isEmpty()) {

            喪失事由 = dbT1001List.get(0).getShikakuSoshitsuJiyuCode();
        }
        if ((dbT1001List == null || dbT1001List.isEmpty() || !RString.isNullOrEmpty(喪失事由))
                && Integer.valueOf(paramter.get年齢().toString()) < Integer.valueOf(第２号被保険者基準年齢.toString())) {

            戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
            return false;
        }
        return true;
    }

    private void 被保台帳転出処理_被保台帳処理の振分け(
            JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            NaiBushoRyouParamter paramter,
            StoreConfigParamter storeConfigParamter) {

        List<DbT1001HihokenshaDaichoEntity> dbT1001List = entity.get被保険者台帳EntityList();

        if (dbT1001List == null || dbT1001List.isEmpty()) {
            JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance()
                    .shiboHihodaichoNashi(entity, 住民異動情報, paramter, storeConfigParamter);
        }
        RString 喪失事由 = RString.EMPTY;
        if (dbT1001List != null && !dbT1001List.isEmpty()) {

            喪失事由 = dbT1001List.get(0).getShikakuSoshitsuJiyuCode();
        }
        if (!RString.isNullOrEmpty(喪失事由)) {

            JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().shiboHihodaichoSoshitsuChu(paramter, entity, 住民異動情報);
            return;
        }
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().shiboHihodaichoShutokuChu(paramter, entity, 住民異動情報);
    }

    /**
     * 被保台帳（喪失中）転出処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param naiBushoRyouParamter NaiBushoRyouParamter
     */
    public void tenshutsuHihodaichoSoshitsuChu(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            NaiBushoRyouParamter naiBushoRyouParamter) {
        TemParamter temparamter = new TemParamter();
        searchHihodaicho(entity, 直近);
        DbT1001HihokenshaDaichoEntity dbT1001Entity = new DbT1001HihokenshaDaichoEntity();
        if (entity.get被保険者台帳EntityList() != null) {
            dbT1001Entity = entity.get被保険者台帳EntityList().get(0);
            if (ShikakuSoshitsuJiyu.転出.getコード().equals(dbT1001Entity.getShikakuSoshitsuJiyuCode())
                    && nullToMin(dbT1001Entity.getShikakuSoshitsuYMD()).equals(naiBushoRyouParamter.get転出予定日翌日())
                    && nullToEmpty(住民異動情報.getAimaiShojobiMongon()).equals(nullToEmpty(dbT1001Entity.getShikakuSoshitsuTodokedeYMD()))) {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
                return;
            }
        }
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().getMaxKaijoYmd(entity, 住民異動情報, temparamter);
        if (!temparamter.get登録届出日().isEmpty()
                && nullToMin(住民異動情報.getTorokuIdoYMD()).isBeforeOrEquals(nullToMin(temparamter.get登録異動日()))) {
            住民異動情報.setTorokuIdoYMD(temparamter.get登録異動日());
            住民異動情報.setTorokuTodokedeYMD(temparamter.get登録届出日());
        }
        if (naiBushoRyouParamter.get補正後転出予定日翌日().isBeforeOrEquals(temparamter.get登録異動日())) {
            if (nullToMin(住民異動情報.getTorokuIdoYMD()).isBeforeOrEquals(nullToMin(naiBushoRyouParamter.get補正後転出予定日翌日()))) {
                temparamter.setTmp取得事由(ShikakuShutokuJiyu.その他.getコード());
                temparamter.setTmp日付(住民異動情報.getTorokuIdoYMD());
            }
            if (naiBushoRyouParamter.get補正後転出予定日翌日().isBefore(temparamter.get登録異動日())) {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
                return;
            }
        }
        if (temparamter.get登録異動日().isBefore(naiBushoRyouParamter.get補正後65歳到達日())) {
            if (nullToMin(住民異動情報.getTorokuIdoYMD()).isBeforeOrEquals(nullToMin(naiBushoRyouParamter.get補正後転出予定日翌日()))) {
                temparamter.setTmp取得事由(ShikakuShutokuJiyu.年齢到達.getコード());
                temparamter.setTmp日付(naiBushoRyouParamter.get到達日_65歳());
                住民異動情報.setTorokuTodokedeYMD(naiBushoRyouParamter.get補正後65歳到達日());
            } else {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
                return;
            }
        }
        if (被保台帳喪失中転出処理_不整合チェック(naiBushoRyouParamter, dbT1001Entity, entity, temparamter)) {
            return;
        }
        DbT1001HihokenshaDaichoEntity hihokenshaDaicho転出被保喪失中
                = 被保台帳喪失中転出処理_被保険者台帳_取得_転出被保喪失中(dbT1001Entity, 住民異動情報, entity, temparamter);
        hihokenshaDaicho転出被保喪失中.setState(EntityDataState.Added);
        dbT1001Dac.save(hihokenshaDaicho転出被保喪失中);
        DbT1001HihokenshaDaichoEntity hihokenshaDaicho喪失更新
                = 被保台帳喪失中転出処理_被保険者台帳の喪失更新(dbT1001Entity, 住民異動情報, entity, naiBushoRyouParamter, temparamter);
        hihokenshaDaicho喪失更新.setState(EntityDataState.Added);
        dbT1001Dac.save(hihokenshaDaicho喪失更新);
        戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 被保台帳（取得中）転出処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param naiBushoRyouParamter NaiBushoRyouParamter
     */
    public void tenshutsuHihodaichoShutokuChu(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            NaiBushoRyouParamter naiBushoRyouParamter) {
        TemParamter temparamter = new TemParamter();
        searchHihodaicho(entity, 直近);
        DbT1001HihokenshaDaichoEntity dbT1001Entity直近 = entity.get被保険者台帳EntityList().get(0);
        searchHihodaicho(entity, 転出);
        DbT1001HihokenshaDaichoEntity dbT1001Entity転出 = entity.get被保険者台帳EntityList().get(0);
        if (dbT1001Entity転出 != null
                && nullToMin(dbT1001Entity転出.getShikakuSoshitsuYMD()).equals(naiBushoRyouParamter.get転出予定日翌日())
                && nullToMin(dbT1001Entity転出.getShikakuSoshitsuTodokedeYMD()).equals(住民異動情報.getShojoTodokedeYMD())
                && flag_ON.equals(dbT1001Entity直近.getKoikinaiJushochiTokureiFlag())) {
            戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
        }
        if (被保台帳取得中転出処理_不整合チェック(dbT1001Entity直近, entity)) {
            return;
        }
        if (被保台帳取得中転出処理_65歳未到達者(dbT1001Entity直近, naiBushoRyouParamter, entity)) {
            return;
        }
        被保台帳取得中転出処理_2号資格者の年齢到達被保台帳作成(dbT1001Entity直近, naiBushoRyouParamter, 住民異動情報, entity);
        if (HihokenshaKubunCode.第２号被保険者.getコード().equals(dbT1001Entity直近.getHihokennshaKubunCode())) {
            temparamter.setTmp1号資格取得日(naiBushoRyouParamter.get到達日_65歳());
            temparamter.setTmp被保険者区分(HihokenshaKubunCode.第１号被保険者.getコード());
        } else {
            temparamter.setTmp1号資格取得日(dbT1001Entity直近.getIchigoShikakuShutokuYMD());
            temparamter.setTmp被保険者区分(dbT1001Entity直近.getHihokennshaKubunCode());
        }
        被保台帳取得中転出処理_被保台帳生成(dbT1001Entity直近, naiBushoRyouParamter, 住民異動情報, entity,
                temparamter);
    }

    private boolean 被保台帳取得中転出処理_被保台帳生成(
            DbT1001HihokenshaDaichoEntity dbT1001Entity直近,
            NaiBushoRyouParamter naiBushoRyouParamter,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter) {
        DbT1001HihokenshaDaichoEntity hihokenshaDaicho
                = 被保台帳取得中転出処理_被保険者台帳_喪失_転出被保取得中(dbT1001Entity直近, naiBushoRyouParamter, 住民異動情報, entity,
                        temparamter);
        if (flag_ON.equals(hihokenshaDaicho.getJushochiTokureiFlag())) {
            戻り値の編集(entity, JuminRendoFuseigo.住特_喪失不能_転出日不整合.getコード(), RString.EMPTY);
            return true;
        }
        if (nullToMin(hihokenshaDaicho.getShikakuSoshitsuYMD()).isBefore(nullToMin(hihokenshaDaicho.getShikakuShutokuYMD()))) {
            戻り値の編集(entity, JuminRendoFuseigo.転出_喪失不能_資格取得日_資格喪失日_不整合.getコード(), RString.EMPTY);
            return true;
        }
        hihokenshaDaicho.setState(EntityDataState.Added);
        dbT1001Dac.save(hihokenshaDaicho);
        return false;
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳取得中転出処理_被保険者台帳_喪失_転出被保取得中(
            DbT1001HihokenshaDaichoEntity dbT1001Entity直近,
            NaiBushoRyouParamter naiBushoRyouParamter,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter) {
        RString 枝番 = getHihokensyadaichoEdaNo(entity,
                dbT1001Entity直近.getShikibetsuCode(), naiBushoRyouParamter.get転出予定日翌日());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(new HihokenshaNo(dbT1001Entity直近.getShikibetsuCode().value()),
                naiBushoRyouParamter.get転出予定日翌日(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(ShikakuSoshitsuJiyu.転出.getコード());
        builder.set市町村コード(dbT1001Entity直近.getShichosonCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(dbT1001Entity直近.getShikakuShutokuJiyuCode());
        builder.set資格取得年月日(dbT1001Entity直近.getShikakuShutokuYMD());
        builder.set資格取得届出年月日(dbT1001Entity直近.getShikakuShutokuTodokedeYMD());
        builder.set第1号資格取得年月日(temparamter.getTmp1号資格取得日());
        builder.set被保険者区分コード(temparamter.getTmp被保険者区分());
        builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.転出.getコード());
        builder.set資格喪失年月日(naiBushoRyouParamter.get転出予定日翌日());
        builder.set資格喪失届出年月日(住民異動情報.getShojoTodokedeYMD());
        builder.set資格変更事由コード(RString.EMPTY);
        builder.set資格変更年月日(FlexibleDate.EMPTY);
        builder.set資格変更届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(dbT1001Entity直近.getKoikinaiJushochiTokureiFlag());
        builder.set広住特措置元市町村コード(dbT1001Entity直近.getKoikinaiTokureiSochimotoShichosonCode());
        builder.set旧市町村コード(dbT1001Entity直近.getKyuShichosonCode());
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private void 被保台帳取得中転出処理_2号資格者の年齢到達被保台帳作成(
            DbT1001HihokenshaDaichoEntity dbT1001Entity直近,
            NaiBushoRyouParamter naiBushoRyouParamter,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity) {
        if (HihokenshaKubunCode.第２号被保険者.getコード().equals(dbT1001Entity直近.getHihokennshaKubunCode())
                && naiBushoRyouParamter.get補正後65歳到達日().isBeforeOrEquals(naiBushoRyouParamter.get補正後消除異動日翌日())) {
            DbT1001HihokenshaDaichoEntity hihokenshaDaicho
                    = 被保台帳取得中転出処理_被保険者台帳_年齢到達_転出被保取得中(dbT1001Entity直近, naiBushoRyouParamter, 住民異動情報, entity);
            hihokenshaDaicho.setState(EntityDataState.Added);
            dbT1001Dac.save(hihokenshaDaicho);
        }
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳取得中転出処理_被保険者台帳_年齢到達_転出被保取得中(
            DbT1001HihokenshaDaichoEntity dbT1001Entity直近,
            NaiBushoRyouParamter naiBushoRyouParamter,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity) {
        RString 枝番 = getHihokensyadaichoEdaNo(entity, dbT1001Entity直近.getShikibetsuCode(), naiBushoRyouParamter.get到達日_65歳());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(new HihokenshaNo(dbT1001Entity直近.getShikibetsuCode().value()),
                naiBushoRyouParamter.get到達日_65歳(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(ShikakuHenkoJiyu._１号到達.getコード());
        builder.set市町村コード(dbT1001Entity直近.getShichosonCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(dbT1001Entity直近.getShikakuShutokuJiyuCode());
        builder.set資格取得年月日(dbT1001Entity直近.getShikakuShutokuYMD());
        builder.set資格取得届出年月日(dbT1001Entity直近.getShikakuShutokuTodokedeYMD());
        builder.set第1号資格取得年月日(naiBushoRyouParamter.get到達日_65歳());
        builder.set被保険者区分コード(HihokenshaKubunCode.第１号被保険者.getコード());
        builder.set資格喪失事由コード(RString.EMPTY);
        builder.set資格喪失年月日(FlexibleDate.EMPTY);
        builder.set資格喪失届出年月日(FlexibleDate.EMPTY);
        builder.set資格変更事由コード(ShikakuHenkoJiyu._１号到達.getコード());
        builder.set資格変更年月日(naiBushoRyouParamter.get到達日_65歳());
        builder.set資格変更届出年月日(住民異動情報.getTorokuTodokedeYMD());
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(dbT1001Entity直近.getKoikinaiJushochiTokureiFlag());
        builder.set広住特措置元市町村コード(dbT1001Entity直近.getKoikinaiTokureiSochimotoShichosonCode());
        builder.set旧市町村コード(dbT1001Entity直近.getKyuShichosonCode());
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private boolean 被保台帳取得中転出処理_65歳未到達者(
            DbT1001HihokenshaDaichoEntity dbT1001Entity直近,
            NaiBushoRyouParamter naiBushoRyouParamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        if (ShikakuKubun._１号.getコード().equals(dbT1001Entity直近.getHihokennshaKubunCode())
                && ShikakuShutokuJiyu.年齢到達.getコード().equals(dbT1001Entity直近.getShikakuShutokuJiyuCode())
                && naiBushoRyouParamter.get補正後消除異動日翌日().isBefore(naiBushoRyouParamter.get補正後65歳到達日())) {
            DbT1001HihokenshaDaichoEntity hihokenshaDaicho = 被保台帳取得中転出処理_被保険者台帳_削除_転出被保取得中(dbT1001Entity直近);
            hihokenshaDaicho.setState(EntityDataState.Modified);
            dbT1001Dac.save(hihokenshaDaicho);
            searchHihodaicho(entity, 直近);
            DbT1001HihokenshaDaichoEntity dbT1001Entity = entity.get被保険者台帳EntityList().get(0);
            if (RString.isNullOrEmpty(dbT1001Entity.getShikakuSoshitsuJiyuCode())) {
                戻り値の編集(entity, JuminRendoFuseigo.被保険者台帳_転出登録不能_資格取得日_資格喪失日_不整合.getコード(), RString.EMPTY);
                return true;
            }
            戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
            return true;
        }
        return false;
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳取得中転出処理_被保険者台帳_削除_転出被保取得中(
            DbT1001HihokenshaDaichoEntity dbT1001Entity直近) {
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(dbT1001Entity直近.getHihokenshaNo(),
                dbT1001Entity直近.getIdoYMD(),
                dbT1001Entity直近.getEdaNo());
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set論理削除フラグ(true);
        return builder.build().toEntity();
    }

    private boolean 被保台帳取得中転出処理_不整合チェック(
            DbT1001HihokenshaDaichoEntity dbT1001Entity直近,
            JuminIdoRendoShikakuTorokuEntity entity) {
        if (flag_ON.equals(dbT1001Entity直近.getKoikinaiJushochiTokureiFlag())) {
            戻り値の編集(entity, JuminRendoFuseigo.被保険者台帳_更新不能_前後関係不整合.getコード(), RString.EMPTY);
            return true;
        }
        return false;
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳喪失中転出処理_被保険者台帳の喪失更新(
            DbT1001HihokenshaDaichoEntity dbT1001Entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity,
            NaiBushoRyouParamter naiBushoRyouParamter,
            TemParamter temparamter) {
        RString 枝番 = getHihokensyadaichoEdaNo(entity, dbT1001Entity.getShikibetsuCode(), naiBushoRyouParamter.get転出予定日翌日());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(new HihokenshaNo(dbT1001Entity.getShikibetsuCode().value()),
                naiBushoRyouParamter.get転出予定日翌日(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(ShikakuSoshitsuJiyu.転出.getコード());
        builder.set市町村コード(dbT1001Entity.getShichosonCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(temparamter.getTmp取得事由());
        builder.set資格取得年月日(temparamter.getTmp日付());
        builder.set資格取得届出年月日(住民異動情報.getTorokuTodokedeYMD());
        builder.set第1号資格取得年月日(dbT1001Entity.getIchigoShikakuShutokuYMD());
        builder.set被保険者区分コード(HihokenshaKubunCode.第１号被保険者.getコード());
        builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.転出.getコード());
        builder.set資格喪失年月日(naiBushoRyouParamter.get転出予定日翌日());
        builder.set資格喪失届出年月日(住民異動情報.getShojoTodokedeYMD());
        builder.set資格変更事由コード(RString.EMPTY);
        builder.set資格変更年月日(FlexibleDate.EMPTY);
        builder.set資格変更届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(flag_OFF);
        builder.set広住特措置元市町村コード(LasdecCode.EMPTY);
        builder.set旧市町村コード(dbT1001Entity.getKyuShichosonCode());
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳喪失中転出処理_被保険者台帳_取得_転出被保喪失中(
            DbT1001HihokenshaDaichoEntity dbT1001Entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter) {
        RString 枝番 = getHihokensyadaichoEdaNo(entity, dbT1001Entity.getShikibetsuCode(), temparamter.getTmp日付());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(new HihokenshaNo(dbT1001Entity.getShikibetsuCode().value()),
                temparamter.getTmp日付(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(temparamter.getTmp取得事由());
        builder.set市町村コード(dbT1001Entity.getShichosonCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(temparamter.getTmp取得事由());
        builder.set資格取得年月日(temparamter.getTmp日付());
        builder.set資格取得届出年月日(住民異動情報.getTorokuTodokedeYMD());
        builder.set第1号資格取得年月日(dbT1001Entity.getIchigoShikakuShutokuYMD());
        builder.set被保険者区分コード(HihokenshaKubunCode.第１号被保険者.getコード());
        builder.set資格喪失事由コード(RString.EMPTY);
        builder.set資格喪失年月日(FlexibleDate.EMPTY);
        builder.set資格喪失届出年月日(FlexibleDate.EMPTY);
        builder.set資格変更事由コード(RString.EMPTY);
        builder.set資格変更年月日(FlexibleDate.EMPTY);
        builder.set資格変更届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例適用事由コード(RString.EMPTY);
        builder.set適用年月日(FlexibleDate.EMPTY);
        builder.set適用届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例解除事由コード(RString.EMPTY);
        builder.set解除年月日(FlexibleDate.EMPTY);
        builder.set解除届出年月日(FlexibleDate.EMPTY);
        builder.set住所地特例フラグ(flag_OFF);
        builder.set広域内住所地特例フラグ(flag_OFF);
        builder.set広住特措置元市町村コード(LasdecCode.EMPTY);
        builder.set旧市町村コード(dbT1001Entity.getKyuShichosonCode());
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private boolean 被保台帳喪失中転出処理_不整合チェック(
            NaiBushoRyouParamter naiBushoRyouParamter,
            DbT1001HihokenshaDaichoEntity dbT1001Entity,
            JuminIdoRendoShikakuTorokuEntity entity,
            TemParamter temparamter) {
        if (naiBushoRyouParamter.get転出予定日翌日().isBefore(temparamter.get登録異動日())) {
            戻り値の編集(entity, JuminRendoFuseigo.転出_喪失不能_資格取得日_資格喪失日_不整合.getコード(), RString.EMPTY);
            return true;
        }
        if (ShikakuSoshitsuJiyu.死亡.getコード().equals(dbT1001Entity.getShikakuSoshitsuJiyuCode())) {
            戻り値の編集(entity, JuminRendoFuseigo.転入_取得不能_死亡者.getコード(), RString.EMPTY);
            return true;
        }
        if (temparamter.getTmp日付().isBefore(dbT1001Entity.getShikakuSoshitsuYMD())) {
            戻り値の編集(entity, JuminRendoFuseigo.転入_取得不能_資格取得日_資格喪失日_不整合.getコード(), RString.EMPTY);
            return true;
        }
        return false;
    }

    /**
     * 宛名連動転入通知受理処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @return JuminIdoRendoShikakuTorokuEntity
     */
    public JuminIdoRendoShikakuTorokuEntity tennyuTsuchiJuri(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            DbV1001HihokenshaDaichoEntity 被保険者台帳) {
        requireNonNull(住民異動情報, UrSystemErrorMessages.値がnull.getReplacedMessage("住民異動情報"));
        requireNonNull(被保険者台帳, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳"));
        StoreConfigParamter storeConfigParamter = JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().getStoreConfigParam();
        JuminIdoRendoShikakuTorokuEntity entity = new JuminIdoRendoShikakuTorokuEntity();
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().get関連テーブル(住民異動情報, 被保険者台帳, entity);
        if (宛名連動転入通知受理処理_適用除外者喪失処理(住民異動情報, storeConfigParamter, entity)) {
            return entity;
        }
        if (宛名連動転入通知受理処理_他特例者喪失処理(住民異動情報, storeConfigParamter, entity)) {
            return entity;
        }
        JuminIdoRendoShikakuTorokuEntity entityEntity = 宛名連動転入通知受理処理_被保険者死亡処理(住民異動情報, storeConfigParamter, entity);
        return entityEntity;
    }

    private JuminIdoRendoShikakuTorokuEntity 宛名連動転入通知受理処理_被保険者死亡処理(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        JuminIdoRendoShikakuTorokuEntity entityEntity = tennyuTsuchiJuriHihodaicho(住民異動情報, storeConfigParamter, entity);
        return entityEntity;
    }

    /**
     * 被保台帳の転入通知受理処理を行うです。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @return JuminIdoRendoShikakuTorokuEntity
     */
    public JuminIdoRendoShikakuTorokuEntity tennyuTsuchiJuriHihodaicho(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        NaiBushoRyouParamter naiBushoRyouParamter = 被保台帳転入通知受理処理_内部処理用パラメータの編集(住民異動情報, storeConfigParamter);
        searchHihodaicho(entity, 直近);
        DbT1001HihokenshaDaichoEntity dbT1001EntityCyokkin = null;
        if (entity.get被保険者台帳EntityList() != null) {
            dbT1001EntityCyokkin = entity.get被保険者台帳EntityList().get(0);
        }
        searchHihodaicho(entity, 転出);
        DbT1001HihokenshaDaichoEntity dbT1001EntityTensyutsu = null;
        if (entity.get被保険者台帳EntityList() != null) {
            dbT1001EntityTensyutsu = entity.get被保険者台帳EntityList().get(0);
        }
        RString tmp処理要否 = 被保台帳転入通知受理処理_被保険者処理要否判定(dbT1001EntityCyokkin, dbT1001EntityTensyutsu, naiBushoRyouParamter,
                住民異動情報);
        JuminIdoRendoShikakuTorokuEntity entityEntity = 被保台帳転入通知受理処理_被保台帳処理の振分け(tmp処理要否, entity,
                dbT1001EntityTensyutsu, 住民異動情報, storeConfigParamter);
        return entityEntity;
    }

    private JuminIdoRendoShikakuTorokuEntity 被保台帳転入通知受理処理_被保台帳処理の振分け(
            RString tmp処理要否,
            JuminIdoRendoShikakuTorokuEntity entity,
            DbT1001HihokenshaDaichoEntity dbT1001EntityTensyutsu,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter) {
        if (tmp処理要否.equals(ptn_1)) {
            JuminIdoRendoShikakuTorokuEntity entityEntity = tennyuTsuchiJuriHihodaichoTenshutsu(住民異動情報, storeConfigParamter, entity);
            return entityEntity;
        } else if (tmp処理要否.equals(ptn_2)) {
            戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
            return entity;
        } else if (tmp処理要否.equals(ptn_3)) {
            if (nullToMin(dbT1001EntityTensyutsu.getShikakuSoshitsuYMD())
                    .equals(nullToMin(住民異動情報.getTenshutsuKakuteiIdoYMD()))) {
                戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
                return entity;
            }
            JuminIdoRendoShikakuTorokuEntity entityEntity = tennyuTsuchiJuriHihodaichoTennyuJyuri(住民異動情報, entity);
            return entityEntity;
        }
        戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
        return entity;
    }

    /**
     * 被保台帳の転入通知受理処理を行うです。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @return JuminIdoRendoShikakuTorokuEntity
     */
    public JuminIdoRendoShikakuTorokuEntity tennyuTsuchiJuriHihodaichoTennyuJyuri(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity) {
        searchHihodaicho(entity, 転出);
        DbT1001HihokenshaDaichoEntity dbT1001Entity = entity.get被保険者台帳EntityList().get(0);
        List<DbT1001HihokenshaDaichoEntity> listEntity = searchHihodaicho2(entity, dbT1001Entity, 住民異動情報);
        for (DbT1001HihokenshaDaichoEntity entity被保台帳 : listEntity) {
            if (!entity被保台帳.getIdoJiyuCode().equals(ShikakuSoshitsuJiyu.転出.getコード())
                    && entity被保台帳.getIdoYMD().isBefore(住民異動情報.getTenshutsuKakuteiIdoYMD())) {
                戻り値の編集(entity, JuminRendoFuseigo.被保険者台帳_更新不能_前後関係不整合.getコード(), RString.EMPTY);
                entity.set被保険者台帳EntityList(listEntity);
                return entity;
            }
            DbT1001HihokenshaDaichoEntity hihokenshaDaicho = 被保台帳転入通知受理通知受理処理_被保険者台帳_削除_転入受理(entity被保台帳);
            hihokenshaDaicho.setState(EntityDataState.Deleted);
            dbT1001Dac.save(hihokenshaDaicho);
            if (entity被保台帳.getIdoJiyuCode().equals(ShikakuSoshitsuJiyu.転出.getコード())) {
                DbT1001HihokenshaDaichoEntity 転出_転入受理
                        = 被保台帳転入通知受理通知受理処理_被保険者台帳_転出_転入受理(entity被保台帳, 住民異動情報, entity);
                hihokenshaDaicho.setState(EntityDataState.Added);
                dbT1001Dac.save(転出_転入受理);
            } else {
                DbT1001HihokenshaDaichoEntity 転出以外_転入受理
                        = 被保台帳転入通知受理通知受理処理_被保険者台帳_転出以外_転入受理(entity被保台帳, 住民異動情報, entity);
                hihokenshaDaicho.setState(EntityDataState.Added);
                dbT1001Dac.save(転出以外_転入受理);
            }
        }
        戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
        entity.set被保険者台帳EntityList(listEntity);
        return entity;
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳転入通知受理通知受理処理_被保険者台帳_転出以外_転入受理(
            DbT1001HihokenshaDaichoEntity entity被保台帳,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity) {
        RString 枝番 = getHihokensyadaichoEdaNo(entity, entity被保台帳.getShikibetsuCode(), entity被保台帳.getIdoYMD());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(entity被保台帳.getHihokenshaNo(),
                entity被保台帳.getIdoYMD(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(entity被保台帳.getIdoJiyuCode());
        builder.set市町村コード(entity被保台帳.getShichosonCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(entity被保台帳.getShikakuShutokuJiyuCode());
        builder.set資格取得年月日(entity被保台帳.getShikakuShutokuYMD());
        builder.set資格取得届出年月日(entity被保台帳.getShikakuShutokuTodokedeYMD());
        builder.set第1号資格取得年月日(entity被保台帳.getIchigoShikakuShutokuYMD());
        builder.set被保険者区分コード(entity被保台帳.getHihokennshaKubunCode());
        builder.set資格喪失事由コード(entity被保台帳.getShikakuSoshitsuJiyuCode());
        builder.set資格喪失年月日(entity被保台帳.getShikakuSoshitsuYMD());
        builder.set資格喪失届出年月日(entity被保台帳.getShikakuSoshitsuTodokedeYMD());
        builder.set資格変更事由コード(entity被保台帳.getShikakuHenkoJiyuCode());
        builder.set資格変更年月日(entity被保台帳.getShikakuHenkoYMD());
        builder.set資格変更届出年月日(entity被保台帳.getShikakuHenkoTodokedeYMD());
        builder.set住所地特例適用事由コード(entity被保台帳.getJushochitokureiTekiyoJiyuCode());
        builder.set適用年月日(entity被保台帳.getJushochitokureiTekiyoYMD());
        builder.set適用届出年月日(entity被保台帳.getJushochitokureiTekiyoTodokedeYMD());
        builder.set住所地特例解除事由コード(entity被保台帳.getJushochitokureiKaijoJiyuCode());
        builder.set解除年月日(entity被保台帳.getJushochitokureiKaijoYMD());
        builder.set解除届出年月日(entity被保台帳.getJushochitokureiKaijoTodokedeYMD());
        builder.set住所地特例フラグ(entity被保台帳.getJushochiTokureiFlag());
        builder.set広域内住所地特例フラグ(entity被保台帳.getKoikinaiJushochiTokureiFlag());
        builder.set広住特措置元市町村コード(entity被保台帳.getKoikinaiTokureiSochimotoShichosonCode());
        builder.set旧市町村コード(entity被保台帳.getKyuShichosonCode());
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳転入通知受理通知受理処理_被保険者台帳_転出_転入受理(
            DbT1001HihokenshaDaichoEntity entity被保台帳,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity) {
        RString 枝番 = getHihokensyadaichoEdaNo(entity, entity被保台帳.getShikibetsuCode(), 住民異動情報.getTenshutsuKakuteiIdoYMD());
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(entity被保台帳.getHihokenshaNo(),
                住民異動情報.getTenshutsuKakuteiIdoYMD(),
                枝番);
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set異動事由コード(ShikakuSoshitsuJiyu.転出.getコード());
        builder.set市町村コード(entity被保台帳.getShichosonCode());
        builder.set識別コード(住民異動情報.getShikibetsuCode());
        builder.set資格取得事由コード(entity被保台帳.getShikakuShutokuJiyuCode());
        builder.set資格取得年月日(entity被保台帳.getShikakuShutokuYMD());
        builder.set資格取得届出年月日(entity被保台帳.getShikakuShutokuTodokedeYMD());
        builder.set第1号資格取得年月日(entity被保台帳.getIchigoShikakuShutokuYMD());
        builder.set被保険者区分コード(entity被保台帳.getHihokennshaKubunCode());
        builder.set資格喪失事由コード(ShikakuSoshitsuJiyu.転出.getコード());
        builder.set資格喪失年月日(住民異動情報.getTenshutsuKakuteiIdoYMD());
        builder.set資格喪失届出年月日(entity被保台帳.getShikakuSoshitsuTodokedeYMD());
        builder.set資格変更事由コード(entity被保台帳.getShikakuHenkoJiyuCode());
        builder.set資格変更年月日(entity被保台帳.getShikakuHenkoYMD());
        builder.set資格変更届出年月日(entity被保台帳.getShikakuHenkoTodokedeYMD());
        builder.set住所地特例適用事由コード(entity被保台帳.getJushochitokureiTekiyoJiyuCode());
        builder.set適用年月日(entity被保台帳.getJushochitokureiTekiyoYMD());
        builder.set適用届出年月日(entity被保台帳.getJushochitokureiTekiyoTodokedeYMD());
        builder.set住所地特例解除事由コード(entity被保台帳.getJushochitokureiKaijoJiyuCode());
        builder.set解除年月日(entity被保台帳.getJushochitokureiKaijoYMD());
        builder.set解除届出年月日(entity被保台帳.getIchigoShikakuShutokuYMD());
        builder.set住所地特例フラグ(entity被保台帳.getJushochiTokureiFlag());
        builder.set広域内住所地特例フラグ(entity被保台帳.getKoikinaiJushochiTokureiFlag());
        builder.set広住特措置元市町村コード(entity被保台帳.getKoikinaiTokureiSochimotoShichosonCode());
        builder.set旧市町村コード(entity被保台帳.getKyuShichosonCode());
        builder.set論理削除フラグ(false);
        return builder.build().toEntity();
    }

    private DbT1001HihokenshaDaichoEntity 被保台帳転入通知受理通知受理処理_被保険者台帳_削除_転入受理(
            DbT1001HihokenshaDaichoEntity entity被保台帳) {
        HihokenshaDaicho hihokenshaDaicho = new HihokenshaDaicho(entity被保台帳.getHihokenshaNo(),
                entity被保台帳.getIdoYMD(),
                entity被保台帳.getEdaNo());
        HihokenshaDaichoBuilder builder = hihokenshaDaicho.createBuilderForEdit();
        builder.set論理削除フラグ(true);
        return builder.build().toEntity();
    }

    private List<DbT1001HihokenshaDaichoEntity> searchHihodaicho2(
            JuminIdoRendoShikakuTorokuEntity entity,
            DbT1001HihokenshaDaichoEntity dbT1001Entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        List<DbT1001HihokenshaDaichoEntity> listEntity = new ArrayList<>();
        List<DbT1001HihokenshaDaichoEntity> list被保険者台帳管理Entity = entity.get被保険者台帳EntityList();
        for (DbT1001HihokenshaDaichoEntity 被保険者台帳管理Entity : list被保険者台帳管理Entity) {
            if (被保険者台帳管理Entity.getIdoYMD().equals(dbT1001Entity.getIdoYMD())
                    && Integer.valueOf(被保険者台帳管理Entity.getEdaNo().toString()) >= Integer.valueOf(dbT1001Entity.getEdaNo().toString())
                    && !被保険者台帳管理Entity.getLogicalDeletedFlag()) {
                listEntity.add(被保険者台帳管理Entity);
            }
            if (dbT1001Entity.getIdoYMD().isBefore(被保険者台帳管理Entity.getIdoYMD())
                    && 被保険者台帳管理Entity.getIdoYMD().isBeforeOrEquals(住民異動情報.getTenshutsuKakuteiIdoYMD())
                    && !被保険者台帳管理Entity.getLogicalDeletedFlag()) {
                listEntity.add(被保険者台帳管理Entity);
            }
        }
        Collections.sort(listEntity, new JuminIdoRendoShikakuSoshitsuTennyuTsuchiJuri.ComparatorsHihokenshaNo());
        Collections.sort(listEntity, new JuminIdoRendoShikakuSoshitsuTennyuTsuchiJuri.ComparatorsIdoYMDAndEdaNo());
        return listEntity;
    }

    /**
     * 被保台帳転入通知受理（転出処理）処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @return entity
     */
    public JuminIdoRendoShikakuTorokuEntity tennyuTsuchiJuriHihodaichoTenshutsu(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        住民異動情報.setShojoIdoYMD(住民異動情報.getTenshutsuKakuteiIdoYMD());
        住民異動情報.setTenshutsuYoteiIdoYMD(nullToMin(住民異動情報.getTenshutsuKakuteiIdoYMD()).minusDay(1));
        tenshutsuHihodaicho(住民異動情報, storeConfigParamter, entity);
        return entity;
    }

    private RString 被保台帳転入通知受理処理_被保険者処理要否判定(
            DbT1001HihokenshaDaichoEntity dbT1001EntityCyokkin,
            DbT1001HihokenshaDaichoEntity dbT1001EntityTensyutsu,
            NaiBushoRyouParamter naiBushoRyouParamter,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        RString tmp処理要否;
        if (dbT1001EntityTensyutsu == null) {
            tmp処理要否 = 被保台帳転入通知受理処理_被保険者処理要否判定_被保台帳転出なし(dbT1001EntityCyokkin);
        } else {
            tmp処理要否 = 被保台帳転入通知受理処理_被保険者処理要否判定_被保台帳転出あり(dbT1001EntityTensyutsu, 住民異動情報, naiBushoRyouParamter,
                    dbT1001EntityCyokkin);
        }
        return tmp処理要否;
    }

    private RString 被保台帳転入通知受理処理_被保険者処理要否判定_被保台帳転出あり(
            DbT1001HihokenshaDaichoEntity dbT1001EntityTensyutsu,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            NaiBushoRyouParamter naiBushoRyouParamter,
            DbT1001HihokenshaDaichoEntity dbT1001EntityCyokkin) {
        RString tmp処理要否;
        if (!nullToMin(dbT1001EntityTensyutsu.getShikakuSoshitsuTodokedeYMD()).equals(住民異動情報.getShojoTodokedeYMD())
                || !nullToMin(dbT1001EntityTensyutsu.getShikakuSoshitsuYMD()).equals(naiBushoRyouParamter.get転出予定日翌日())) {
            if (flag_ON.endsWith(dbT1001EntityCyokkin.getKoikinaiJushochiTokureiFlag())) {
                tmp処理要否 = ptn_2;
            } else {
                tmp処理要否 = ptn_1;
            }
        } else {
            tmp処理要否 = ptn_3;
        }
        return tmp処理要否;
    }

    private RString 被保台帳転入通知受理処理_被保険者処理要否判定_被保台帳転出なし(
            DbT1001HihokenshaDaichoEntity dbT1001EntityCyokkin) {
        RString tmp処理要否 = RString.EMPTY;
        if (dbT1001EntityCyokkin == null) {
            tmp処理要否 = ptn_1;
        } else {
            if (RString.isNullOrEmpty(dbT1001EntityCyokkin.getShikakuSoshitsuJiyuCode())) {
                if (flag_ON.equals(dbT1001EntityCyokkin.getJushochiTokureiFlag())) {
                    tmp処理要否 = ptn_2;
                } else {
                    tmp処理要否 = ptn_1;
                }
            }
        }
        return tmp処理要否;
    }

    private NaiBushoRyouParamter 被保台帳転入通知受理処理_内部処理用パラメータの編集(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter) {
        FlexibleDate 補正後65歳到達日;
        FlexibleDate 補正後転出予定日翌日;
        NaiBushoRyouParamter naiBushoRyouParamter = new NaiBushoRyouParamter();
        FlexibleDate 到達日_65 = JuminIdoRendoShikakuSoshitsuShiboKyoTu
                .createInstance().getNenreiTotatsuYmd(住民異動情報, storeConfigParamter);
        if (到達日_65.isBefore(storeConfigParamter.get介護保険法施行日())) {
            補正後65歳到達日 = storeConfigParamter.get介護保険法施行日();
        } else {
            補正後65歳到達日 = 到達日_65;
        }
        FlexibleDate 転出予定日翌日 = 住民異動情報.getTenshutsuYoteiIdoYMD();
        if (nullToMin(転出予定日翌日).isBefore(nullToMin(storeConfigParamter.get介護保険法施行日()))) {
            補正後転出予定日翌日 = storeConfigParamter.get介護保険法施行日();
        } else {
            補正後転出予定日翌日 = 転出予定日翌日;
        }
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().nenreiCalc(住民異動情報, naiBushoRyouParamter);
        naiBushoRyouParamter.set到達日_65歳(到達日_65);
        naiBushoRyouParamter.set補正後65歳到達日(補正後65歳到達日);
        naiBushoRyouParamter.set転出予定日翌日(転出予定日翌日);
        naiBushoRyouParamter.set補正後転出予定日翌日(補正後転出予定日翌日);
        return naiBushoRyouParamter;
    }

    private boolean 宛名連動転入通知受理処理_他特例者喪失処理(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance()
                .shikakuSousituTatoku(住民異動情報, storeConfigParamter, ShikakuSoshitsuJiyu.その他.getコード(), entity);
        if ((!RString.isNullOrEmpty(entity.get不整合コード()) || RString.isNullOrEmpty(entity.get転出保留作成事由コード()))
                && 不整合コード_9999.equals(entity.get不整合コード())) {
            entity.set不整合コード(RString.EMPTY);
            return true;
        }
        return false;
    }

    private boolean 宛名連動転入通知受理処理_適用除外者喪失処理(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance()
                .shiKakuSousituJogai(住民異動情報, storeConfigParamter, ShikakuSoshitsuJiyu.その他.getコード(), entity);
        if ((!RString.isNullOrEmpty(entity.get不整合コード()) || RString.isNullOrEmpty(entity.get転出保留作成事由コード()))
                && 不整合コード_9999.equals(entity.get不整合コード())) {
            entity.set不整合コード(RString.EMPTY);
            return true;
        }
        return false;
    }

    /**
     * 取得した被保険者台帳データから、異動日、枝番が最大のデータを取得する。
     *
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param データ抽出ＰＴＮ RString
     */
    public void searchHihodaicho(JuminIdoRendoShikakuTorokuEntity entity, RString データ抽出ＰＴＮ) {

        List<DbT1001HihokenshaDaichoEntity> dbT1001List = entity.get被保険者台帳EntityList();
        List<DbT1001HihokenshaDaichoEntity> list = new ArrayList<>();
        HihokenshaNo 被保険者 = HihokenshaNo.EMPTY;

        if (直近.equals(データ抽出ＰＴＮ)) {
            for (DbT1001HihokenshaDaichoEntity dbT1001Entity : dbT1001List) {
                if (!被保険者.equals(dbT1001Entity.getHihokenshaNo())) {
                    list.add(dbT1001Entity);
                    被保険者 = dbT1001Entity.getHihokenshaNo();
                }
            }
        }
        if (転出.equals(データ抽出ＰＴＮ)) {
            for (DbT1001HihokenshaDaichoEntity dbT1001Entity : dbT1001List) {
                if (!ShikakuSoshitsuJiyu.転出.getコード().equals(dbT1001Entity.getIdoJiyuCode())
                        && !被保険者.equals(dbT1001Entity.getHihokenshaNo())) {
                    list.add(dbT1001Entity);
                    被保険者 = dbT1001Entity.getHihokenshaNo();
                }
            }
        }
        entity.set被保険者台帳EntityList(list);
    }

    private void 戻り値の編集(
            JuminIdoRendoShikakuTorokuEntity entity,
            RString 不整合コード, RString 転出保留作成事由コード) {
        entity.set不整合コード(不整合コード);
        entity.set転出保留作成事由コード(転出保留作成事由コード);
    }

    /**
     * 処理対象の識別コードを保有する被保険者台帳のデータを取得する。
     *
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 識別コード ShikibetsuCode
     * @param 異動日 FlexibleDate
     * @return 枝番
     */
    public RString getHihokensyadaichoEdaNo(JuminIdoRendoShikakuTorokuEntity entity,
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日) {
        RString 枝番;
        List<DbT1001HihokenshaDaichoEntity> 被保険者台帳管理EntityList = entity.get被保険者台帳EntityList();
        List<DbT1001HihokenshaDaichoEntity> listEntity = new ArrayList<>();
        for (DbT1001HihokenshaDaichoEntity entity被保険者台帳管理 : 被保険者台帳管理EntityList) {
            if (識別コード.equals(entity被保険者台帳管理.getShikibetsuCode())
                    && 異動日.equals(entity被保険者台帳管理.getIdoYMD())) {
                listEntity.add(entity被保険者台帳管理);
            }
        }
        if (listEntity.isEmpty()) {
            枝番 = new RString("1");
        } else {
            Collections.sort(listEntity, new JuminIdoRendoShikakuSoshitsuTennyuTsuchiJuri.ComparatorsEdaNo());
            int edaBan = Integer.parseInt(listEntity.get(0).getEdaNo().toString());
            edaBan = edaBan + 1;
            枝番 = new RString(String.valueOf(edaBan));
        }
        return 枝番;
    }

    private FlexibleDate nullToMin(FlexibleDate date) {

        if (date == null || date.isEmpty()) {

            return FlexibleDate.MIN;
        }
        return date;
    }

    private RString nullToEmpty(FlexibleDate date) {

        if (date == null || date.isEmpty()) {

            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    private RString nullToEmpty(RString date) {

        if (date == null || date.isEmpty()) {

            return RString.EMPTY;
        }
        return date;
    }

    private static class ComparatorsHihokenshaNo implements Comparator<DbT1001HihokenshaDaichoEntity>, Serializable {

        @Override
        public int compare(DbT1001HihokenshaDaichoEntity o1, DbT1001HihokenshaDaichoEntity o2) {
            return o2.getHihokenshaNo().compareTo(o1.getHihokenshaNo());
        }
    }

    private static class ComparatorsIdoYMDAndEdaNo implements Comparator<DbT1001HihokenshaDaichoEntity>, Serializable {

        @Override
        public int compare(DbT1001HihokenshaDaichoEntity o1, DbT1001HihokenshaDaichoEntity o2) {
            if (o2.getHihokenshaNo().compareTo(o1.getHihokenshaNo()) == 0) {
                RString idoYMDEdaNoO1 = new RString(o1.getIdoYMD().toString() + o1.getEdaNo().toString());
                RString idoYMDEdaNoO2 = new RString(o2.getIdoYMD().toString() + o2.getEdaNo().toString());
                return idoYMDEdaNoO1.compareTo(idoYMDEdaNoO2);
            }
            return 1;
        }
    }

    private static class ComparatorsEdaNo implements Comparator<DbT1001HihokenshaDaichoEntity>, Serializable {

        @Override
        public int compare(DbT1001HihokenshaDaichoEntity o1, DbT1001HihokenshaDaichoEntity o2) {
            return o2.getEdaNo().compareTo(o1.getEdaNo());
        }
    }
}
