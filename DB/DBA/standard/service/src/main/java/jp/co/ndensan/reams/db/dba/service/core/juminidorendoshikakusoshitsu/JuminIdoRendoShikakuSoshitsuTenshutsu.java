/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakusoshitsu;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.NaiBushoRyouParamter;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.StoreConfigParamter;
import jp.co.ndensan.reams.db.dba.definition.core.juminrendo.JuminRendoFuseigo;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendoshikakutoroku.JuminIdoRendoShikakuTorokuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBAMN00000_住民異動連動資格登録（転出・死亡・転入通知受理）のビジネスクラスです。
 *
 * @reamsid_L DBA-1410-013 houtianpeng
 */
public class JuminIdoRendoShikakuSoshitsuTenshutsu {

    private final DbT4001JukyushaDaichoDac dbT4001Dac;
    private final RString 非受給者 = new RString("0");
    private final RString 受給者 = new RString("1");
    private final RString 直近 = new RString("1");
    private final RString 転出 = new RString("2");
    private final RString 不整合コード_9999 = new RString("9999");

    /**
     * コンストラクタです。
     */
    public JuminIdoRendoShikakuSoshitsuTenshutsu() {
        this.dbT4001Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param DbT4001JukyushaDaichoDac dbT4001Dac
     */
    JuminIdoRendoShikakuSoshitsuTenshutsu(
            DbT4001JukyushaDaichoDac dbT4001Dac) {
        this.dbT4001Dac = dbT4001Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoTennyuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoShikakuSoshitsuTenshutsu}のインスタンス
     */
    public static JuminIdoRendoShikakuSoshitsuTenshutsu createInstance() {
        return InstanceProvider.create(JuminIdoRendoShikakuSoshitsuTenshutsu.class);
    }

    /**
     * 宛名連動転出処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @return JuminIdoRendoShikakuTorokuEntity
     */
    public JuminIdoRendoShikakuTorokuEntity tenshutsu(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳) {
        requireNonNull(住民異動情報, UrSystemErrorMessages.値がnull.getReplacedMessage("住民異動情報"));
        requireNonNull(被保険者台帳, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳"));

        StoreConfigParamter storeConfigParamter = JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().getStoreConfigParam();
        JuminIdoRendoShikakuTorokuEntity entity = new JuminIdoRendoShikakuTorokuEntity();
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().get関連テーブル(住民異動情報, 被保険者台帳, entity);
        getCheckJukyushaDaicho(住民異動情報, 被保険者台帳, entity);
        if (受給者.equals(entity.get結果区分())) {

            戻り値の編集(entity, RString.EMPTY, JuminRendoFuseigo.転出_受給者.getコード());
            return entity;
        }
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance()
                .shiKakuSousituJogai(住民異動情報, storeConfigParamter, ShikakuSoshitsuJiyu.転出.getコード(), entity);
        if (!RString.isNullOrEmpty(entity.get不整合コード())
                || !RString.isNullOrEmpty(entity.get転出保留作成事由コード())) {

            if (不整合コード_9999.equals(entity.get不整合コード())) {

                entity.set不整合コード(RString.EMPTY);
            }
            return entity;
        }
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().shikakuSousituTatoku(住民異動情報,
                storeConfigParamter, ShikakuSoshitsuJiyu.転出.getコード(), entity);
        if (!entity.get不整合コード().isEmpty() || !entity.get転出保留作成事由コード().isEmpty()) {
            if (不整合コード_9999.equals(entity.get不整合コード())) {

                entity.set不整合コード(RString.EMPTY);
            }
            return entity;
        }
        tenshutsuHihodaicho(住民異動情報, storeConfigParamter, entity);
        return entity;
    }

    private void tenshutsuHihodaicho(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter, JuminIdoRendoShikakuTorokuEntity entity) {

        NaiBushoRyouParamter paramter = new NaiBushoRyouParamter();
        被保台帳転出処理_到達日転出予定日翌日の算出(住民異動情報, storeConfigParamter, paramter);
        searchHihodaicho(entity, 直近);
        if (!被保台帳転出処理_被保険者処理要否判定(entity, paramter, storeConfigParamter)) {
            return;
        }
        被保台帳転出処理_被保台帳処理の振分け(entity, 住民異動情報, paramter, storeConfigParamter);
    }

    private void 被保台帳転出処理_被保台帳処理の振分け(JuminIdoRendoShikakuTorokuEntity entity,
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

    private FlexibleDate nullToMin(FlexibleDate date) {

        if (date == null || date.isEmpty()) {

            return FlexibleDate.MIN;
        }
        return date;
    }

    private boolean 被保台帳転出処理_被保険者処理要否判定(JuminIdoRendoShikakuTorokuEntity entity,
            NaiBushoRyouParamter paramter, StoreConfigParamter storeConfigParamter) {

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

    private void searchHihodaicho(JuminIdoRendoShikakuTorokuEntity entity, RString データ抽出ＰＴＮ) {

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

    private void getCheckJukyushaDaicho(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            JuminIdoRendoShikakuTorokuEntity entity) {

        if (被保険者台帳.getHihokenshaNo() == null || 被保険者台帳.getHihokenshaNo().value().isEmpty()) {
            entity.set結果区分(非受給者);
            return;
        }
        List<DbT4001JukyushaDaichoEntity> dbT4001List = dbT4001Dac.
                get受給者台帳(被保険者台帳.getHihokenshaNo(), 住民異動情報.getTenshutsuYoteiIdoYMD());
        if (dbT4001List != null && !dbT4001List.isEmpty()) {
            entity.set結果区分(非受給者);
        } else {
            entity.set結果区分(受給者);
        }
    }

    private void 戻り値の編集(
            JuminIdoRendoShikakuTorokuEntity entity,
            RString 不整合コード, RString 転出保留作成事由コード) {
        entity.set不整合コード(不整合コード);
        entity.set転出保留作成事由コード(転出保留作成事由コード);
    }

    private void 被保台帳転出処理_到達日転出予定日翌日の算出(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter, NaiBushoRyouParamter paramter) {

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
}
