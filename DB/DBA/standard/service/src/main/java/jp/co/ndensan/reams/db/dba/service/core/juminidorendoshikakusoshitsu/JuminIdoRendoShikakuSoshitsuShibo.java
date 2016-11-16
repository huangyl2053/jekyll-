/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakusoshitsu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.NaiBushoRyouParamter;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.StoreConfigParamter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendoshikakutoroku.JuminIdoRendoShikakuTorokuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
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
public class JuminIdoRendoShikakuSoshitsuShibo {

    private final RString 直近 = new RString("1");
    private final RString 不整合コード_9999 = new RString("9999");

    /**
     * コンストラクタです。
     */
    public JuminIdoRendoShikakuSoshitsuShibo() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoTennyuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoShikakuSoshitsuShibo}のインスタンス
     */
    public static JuminIdoRendoShikakuSoshitsuShibo createInstance() {
        return InstanceProvider.create(JuminIdoRendoShikakuSoshitsuShibo.class);
    }

    /**
     * 宛名連動死亡処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @return JuminIdoRendoShikakuTorokuEntity
     */
    public JuminIdoRendoShikakuTorokuEntity shiBo(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳) {
        requireNonNull(住民異動情報, UrSystemErrorMessages.値がnull.getReplacedMessage("住民異動情報"));
        requireNonNull(被保険者台帳, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳"));

        StoreConfigParamter storeConfigParamter = JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().getStoreConfigParam();
        JuminIdoRendoShikakuTorokuEntity entity = new JuminIdoRendoShikakuTorokuEntity();
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().get関連テーブル(住民異動情報, 被保険者台帳, entity);
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance()
                .shiKakuSousituJogai(住民異動情報, storeConfigParamter, ShikakuSoshitsuJiyu.死亡.getコード(), entity);
        if ((!RString.isNullOrEmpty(entity.get不整合コード())
                || !RString.isNullOrEmpty(entity.get転出保留作成事由コード()))
                && 不整合コード_9999.equals(entity.get不整合コード())) {
            entity.set不整合コード(RString.EMPTY);
            return entity;
        }
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().
                shikakuSousituTatoku(住民異動情報, storeConfigParamter, ShikakuSoshitsuJiyu.死亡.getコード(), entity);
        if ((!RString.isNullOrEmpty(entity.get不整合コード())
                || !RString.isNullOrEmpty(entity.get転出保留作成事由コード()))
                && 不整合コード_9999.equals(entity.get不整合コード())) {
            entity.set不整合コード(RString.EMPTY);
            return entity;
        }
        shiboHihodaicho(住民異動情報, storeConfigParamter, entity);
        return entity;
    }

    /**
     * 被保険者死亡処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void shiboHihodaicho(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        FlexibleDate 到達日_65 = FlexibleDate.EMPTY;
        FlexibleDate 補正後65歳到達日 = FlexibleDate.EMPTY;
        FlexibleDate 介護保険法施行日 = FlexibleDate.EMPTY;
        FlexibleDate 消除異動日翌日 = nullToMin(住民異動情報.getShojoIdoYMD()).plusDay(1);
        FlexibleDate 補正後消除異動日翌日 = FlexibleDate.EMPTY;
        RString 年齢 = RString.EMPTY;
        NaiBushoRyouParamter naiBushoRyouParamter = 被保険者死亡処理_内部処理用パラメータの編集(住民異動情報, storeConfigParamter, 到達日_65,
                介護保険法施行日, 消除異動日翌日, 補正後65歳到達日, 補正後消除異動日翌日);
        JuminIdoRendoShikakuSoshitsu.createInstance().getSearchHihodaicho(entity, 直近);
        if (被保険者死亡処理_被保険者処理要否判定(entity, storeConfigParamter, 年齢)) {
            return;
        }
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance()
                .shiboHihodaichoNashi(entity, 住民異動情報, naiBushoRyouParamter, storeConfigParamter);
        if (!RString.isNullOrEmpty(entity.get被保険者台帳EntityList().get(0).getShikakuSoshitsuJiyuCode())) {
            JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().shiboHihodaichoSoshitsuChu(naiBushoRyouParamter, entity, 住民異動情報);
        } else {
            JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().shiboHihodaichoShutokuChu(naiBushoRyouParamter, entity, 住民異動情報);
        }
        戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
    }

    private boolean 被保険者死亡処理_被保険者処理要否判定(JuminIdoRendoShikakuTorokuEntity entity,
            StoreConfigParamter storeConfigParamter,
            RString 年齢) {
        if ((entity.get被保険者台帳EntityList() == null
                || RString.isNullOrEmpty(entity.get被保険者台帳EntityList().get(0).getShikakuSoshitsuJiyuCode()))
                && 年齢.compareTo(storeConfigParamter.get第２号被保険者基準年齢()) < 0) {
            戻り値の編集(entity, RString.EMPTY, RString.EMPTY);
            return true;
        }
        return false;
    }

    private void 戻り値の編集(
            JuminIdoRendoShikakuTorokuEntity entity,
            RString 不整合コード, RString 転出保留作成事由コード) {
        entity.set不整合コード(不整合コード);
        entity.set転出保留作成事由コード(転出保留作成事由コード);
    }

    private NaiBushoRyouParamter 被保険者死亡処理_内部処理用パラメータの編集(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            FlexibleDate 到達日_65,
            FlexibleDate 介護保険法施行日,
            FlexibleDate 消除異動日翌日,
            FlexibleDate 補正後65歳到達日,
            FlexibleDate 補正後消除異動日翌日) {
        NaiBushoRyouParamter naiBushoRyouParamter = new NaiBushoRyouParamter();
        到達日_65 = JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().getNenreiTotatsuYmd(住民異動情報, storeConfigParamter);
        naiBushoRyouParamter.set到達日_65歳(到達日_65);
        介護保険法施行日 = storeConfigParamter.get介護保険法施行日();
        if (到達日_65.isBefore(介護保険法施行日)) {
            補正後65歳到達日 = 介護保険法施行日;
            naiBushoRyouParamter.set補正後65歳到達日(補正後65歳到達日);
        } else {
            naiBushoRyouParamter.set補正後65歳到達日(到達日_65);
        }
        naiBushoRyouParamter.set消除異動日翌日(消除異動日翌日);
        if (消除異動日翌日.isBefore(storeConfigParamter.get介護保険法施行日())) {
            補正後消除異動日翌日 = 介護保険法施行日;
            naiBushoRyouParamter.set補正後消除異動日翌日(補正後消除異動日翌日);
        } else {
            naiBushoRyouParamter.set補正後消除異動日翌日(消除異動日翌日);
        }
        JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance().nenreiCalc(住民異動情報, naiBushoRyouParamter);
        return naiBushoRyouParamter;
    }

    private FlexibleDate nullToMin(FlexibleDate date) {

        if (date == null || date.isEmpty()) {

            return FlexibleDate.MIN;
        }
        return date;
    }
}
