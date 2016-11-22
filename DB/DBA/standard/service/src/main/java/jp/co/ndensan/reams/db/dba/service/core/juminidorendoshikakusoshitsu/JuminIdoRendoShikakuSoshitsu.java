/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakusoshitsu;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.NaiBushoRyouParamter;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.StoreConfigParamter;
import jp.co.ndensan.reams.db.dba.definition.core.juminidorendoshikakusoshitsu.TemParamter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.juminidorendoshikakutoroku.JuminIdoRendoShikakuTorokuEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBAMN00000_住民異動連動資格登録（転出・死亡・転入通知受理）のビジネスクラスです。
 *
 * @reamsid_L DBA-1410-013 houtianpeng
 */
public class JuminIdoRendoShikakuSoshitsu {

    private final JuminIdoRendoShikakuSoshitsuShibo soshitsuShibo;

    private final JuminIdoRendoShikakuSoshitsuShiboKyoTu tsuShiboKyoTu;

    private final JuminIdoRendoShikakuSoshitsuTennyuTsuchiJuri tsuchiJuri;

    private final JuminIdoRendoShikakuSoshitsuTenshutsu tenshutsu;

    /**
     * コンストラクタです。
     */
    public JuminIdoRendoShikakuSoshitsu() {
        soshitsuShibo = JuminIdoRendoShikakuSoshitsuShibo.createInstance();
        tsuShiboKyoTu = JuminIdoRendoShikakuSoshitsuShiboKyoTu.createInstance();
        tsuchiJuri = JuminIdoRendoShikakuSoshitsuTennyuTsuchiJuri.createInstance();
        tenshutsu = JuminIdoRendoShikakuSoshitsuTenshutsu.createInstance();
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoTennyuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link JuminIdoRendoShikakuSoshitsuShibo}のインスタンス
     */
    public static JuminIdoRendoShikakuSoshitsu createInstance() {
        return InstanceProvider.create(JuminIdoRendoShikakuSoshitsu.class);
    }

    /**
     * 宛名データの「異動事由コード」が"20"(転出)の場合 、 被保険者、 除外者であるか判定し、該当マスタを更新する。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @return JuminIdoRendoShikakuTorokuEntity
     */
    public JuminIdoRendoShikakuTorokuEntity getTenshutsu(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            DbV1001HihokenshaDaichoEntity 被保険者台帳) {
        return tenshutsu.tenshutsu(住民異動情報, 被保険者台帳);
    }

    /**
     * 宛名データの「異動事由コード」が"21"(死亡)の場合、被保険者、除外者であるか判定し、該当マスタを更新する。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @return JuminIdoRendoShikakuTorokuEntity
     */
    public JuminIdoRendoShikakuTorokuEntity getShiBo(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            DbV1001HihokenshaDaichoEntity 被保険者台帳) {
        return soshitsuShibo.shiBo(住民異動情報, 被保険者台帳);
    }

    /**
     * 宛名データの「異動事由コード」が"45"(転入通知受理)の場合、被保険者、除外者であるか判定し、該当マスタを更新するです。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @return JuminIdoRendoShikakuTorokuEntity
     */
    public JuminIdoRendoShikakuTorokuEntity getTennyuTsuchiJuri(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            DbV1001HihokenshaDaichoEntity 被保険者台帳) {
        return tsuchiJuri.tennyuTsuchiJuri(住民異動情報, 被保険者台帳);
    }

    /**
     * 適用除外者の転出、死亡、転入通知受理処理を行う。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param pRM StoreConfigParamter
     * @param 資格喪失事由 RString
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void getShikakuSousituJogai(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter pRM,
            RString 資格喪失事由,
            JuminIdoRendoShikakuTorokuEntity entity) {
        tsuShiboKyoTu.shiKakuSousituJogai(住民異動情報, pRM, 資格喪失事由, entity);
    }

    /**
     * 他特例者の転出、死亡、転入通知受理処理を行う。
     *
     * @param storeConfigParamter StoreConfigParamter
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 資格喪失事由 RString
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void getShikakuSousituTatoku(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter, RString 資格喪失事由, JuminIdoRendoShikakuTorokuEntity entity) {
        tsuShiboKyoTu.shikakuSousituTatoku(住民異動情報, storeConfigParamter, 資格喪失事由, entity);
    }

    /**
     * 被保台帳の転出処理を行う。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void getTenshutsuHihodaicho(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter, JuminIdoRendoShikakuTorokuEntity entity) {
        tsuchiJuri.tenshutsuHihodaicho(住民異動情報, storeConfigParamter, entity);
    }

    /**
     * 被保台帳なし転出処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param naiBushoRyouParamter NaiBushoRyouParamter
     */
    public void getTenshutsuHihodaichoNashi(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            NaiBushoRyouParamter naiBushoRyouParamter) {

        tsuchiJuri.tenshutsuHihodaichoNashi(住民異動情報, storeConfigParamter, entity, naiBushoRyouParamter);
    }

    /**
     * 被保台帳（喪失中）転出処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param naiBushoRyouParamter NaiBushoRyouParamter
     */
    public void getTenshutsuHihodaichoSoshitsuChu(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            NaiBushoRyouParamter naiBushoRyouParamter) {

        tsuchiJuri.tenshutsuHihodaichoSoshitsuChu(住民異動情報, storeConfigParamter, entity, naiBushoRyouParamter);
    }

    /**
     * 被保台帳（取得中）転出処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param naiBushoRyouParamter NaiBushoRyouParamter
     */
    public void getTenshutsuHihodaichoShutokuChu(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            NaiBushoRyouParamter naiBushoRyouParamter) {
        tsuchiJuri.tenshutsuHihodaichoShutokuChu(住民異動情報, storeConfigParamter, entity, naiBushoRyouParamter);
    }

    /**
     * 被保険者死亡処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void getShiboHihodaicho(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        soshitsuShibo.shiboHihodaicho(住民異動情報, storeConfigParamter, entity);
    }

    /**
     * 被保台帳データがない場合の被保台帳の死亡処理を行う。
     *
     * @param paramter NaiBushoRyouParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     */
    public void getShiboHihodaichoNashi(JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            NaiBushoRyouParamter paramter,
            StoreConfigParamter storeConfigParamter) {
        tsuShiboKyoTu.shiboHihodaichoNashi(entity, 住民異動情報, paramter, storeConfigParamter);
    }

    /**
     * 被保台帳データがあり、直近データが喪失中の場合の被保台帳の死亡処理を行う。
     *
     * @param naiBushoRyouParamter NaiBushoRyouParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     */
    public void getShiboHihodaichoSoshitsuChu(
            NaiBushoRyouParamter naiBushoRyouParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        tsuShiboKyoTu.shiboHihodaichoSoshitsuChu(naiBushoRyouParamter, entity, 住民異動情報);
    }

    /**
     * 被保台帳データがあり、直近データが取得中の場合の被保台帳の死亡処理を行う。
     *
     * @param naiBushoRyouParamter NaiBushoRyouParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     */
    public void getShiboHihodaichoShutokuChu(
            NaiBushoRyouParamter naiBushoRyouParamter,
            JuminIdoRendoShikakuTorokuEntity entity,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        tsuShiboKyoTu.shiboHihodaichoShutokuChu(naiBushoRyouParamter, entity, 住民異動情報);
    }

    /**
     * 被保台帳の転入通知受理処理を行うです。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @return JuminIdoRendoShikakuTorokuEntity
     */
    public JuminIdoRendoShikakuTorokuEntity getTennyuTsuchiJuriHihodaicho(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity) {

        return tsuchiJuri.tennyuTsuchiJuriHihodaicho(住民異動情報, storeConfigParamter, entity);
    }

    /**
     * 被保台帳転入通知受理（転出処理）処理です。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param storeConfigParamter StoreConfigParamter
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @return entity
     */
    public JuminIdoRendoShikakuTorokuEntity getTennyuTsuchiJuriHihodaichoTenshutsu(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter,
            JuminIdoRendoShikakuTorokuEntity entity) {
        return tsuchiJuri.tennyuTsuchiJuriHihodaichoTenshutsu(住民異動情報, storeConfigParamter, entity);
    }

    /**
     * 被保台帳の転入通知受理処理を行うです。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @return JuminIdoRendoShikakuTorokuEntity
     */
    public JuminIdoRendoShikakuTorokuEntity getTennyuTsuchiJuriHihodaichoTennyuJyuri(
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            JuminIdoRendoShikakuTorokuEntity entity) {
        return tsuchiJuri.tennyuTsuchiJuriHihodaichoTennyuJyuri(住民異動情報, entity);
    }

    /**
     * コンフィグ情報パラメータ格納。
     *
     * @return StoreConfigParamter
     */
    public StoreConfigParamter getStoreConfigParam() {
        return tsuShiboKyoTu.getStoreConfigParam();
    }

    /**
     * 受給者かどうかチェックするです。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void getCheckJukyushaDaicho(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            JuminIdoRendoShikakuTorokuEntity entity) {

        tenshutsu.getCheckJukyushaDaicho(住民異動情報, 被保険者台帳, entity);
    }

    /**
     * 処理対象の識別コードを保有する適用除外者のデータを取得する。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void getJogai(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            JuminIdoRendoShikakuTorokuEntity entity) {
        tsuShiboKyoTu.getJogai(住民異動情報, 被保険者台帳, entity);
    }

    /**
     * 同一識別コード、同一異動日のデータにおける最大枝番＋１を取得する。
     *
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 識別コード ShikibetsuCode
     * @param 異動日 FlexibleDate
     * @return 枝番
     */
    public RString getJogaiEdaNo(JuminIdoRendoShikakuTorokuEntity entity,
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日) {
        return tsuShiboKyoTu.getJogaiEdaNo(entity, 識別コード, 異動日);
    }

    /**
     * 処理対象の識別コードを保有する他特例者のデータを取得する。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void getTaTokurei(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            JuminIdoRendoShikakuTorokuEntity entity) {

        tsuShiboKyoTu.getGetTaTokurei(住民異動情報, 被保険者台帳, entity);
    }

    /**
     * 処理対象の識別コードを保有する他特例者のデータを取得する。
     *
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 識別コード ShikibetsuCode
     * @param 異動日 FlexibleDate
     * @return 枝番
     */
    public RString getTaTokureiEdaNo(
            JuminIdoRendoShikakuTorokuEntity entity,
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日) {

        return tsuShiboKyoTu.getTaTokureiEdaNo(entity, 識別コード, 異動日);
    }

    /**
     * 処理対象の識別コードを保有する施設入退所のデータを取得する。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void getGetShisetsu(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            JuminIdoRendoShikakuTorokuEntity entity) {

        tsuShiboKyoTu.getGetShisetsu(住民異動情報, 被保険者台帳, entity);
    }

    /**
     * 取得した施設入退所データから、指定の施設区分である入所日が最大のデータを取得する。
     *
     * @param listDbT1004 List<DbT1004ShisetsuNyutaishoEntity>
     * @param 台帳種別 RString
     * @return DbT1004ShisetsuNyutaishoEntity
     */
    public DbT1004ShisetsuNyutaishoEntity getSearchShisetsu(List<DbT1004ShisetsuNyutaishoEntity> listDbT1004, RString 台帳種別) {
        return tsuShiboKyoTu.searchShisetsu(listDbT1004, 台帳種別);
    }

    /**
     * 処理対象の識別コードを保有する被保険者台帳のデータを取得する。
     *
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 被保険者台帳 DbV1001HihokenshaDaichoEntity
     * @param entity JuminIdoRendoShikakuTorokuEntity
     */
    public void getHihokensyadaicho(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            JuminIdoRendoShikakuTorokuEntity entity) {
        tsuShiboKyoTu.getHihokensyadaicho(住民異動情報, 被保険者台帳, entity);
    }

    /**
     * 同一識別コード、同一異動日のデータにおける最大枝番＋１を取得する。
     *
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 識別コード ShikibetsuCode
     * @param 異動日 FlexibleDate
     * @return 枝番
     */
    public RString getHihokensyadaichoEdaNo(JuminIdoRendoShikakuTorokuEntity entity,
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日) {
        return tsuchiJuri.getHihokensyadaichoEdaNo(entity, 識別コード, 異動日);
    }

    /**
     * 取得した被保険者台帳データから、異動日、枝番が最大のデータを取得する。
     *
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param データ抽出ＰＴＮ RString
     * @return List<DbT1001HihokenshaDaichoEntity>
     */
    public List<DbT1001HihokenshaDaichoEntity> getSearchHihodaicho(JuminIdoRendoShikakuTorokuEntity entity, RString データ抽出ＰＴＮ) {

        return tsuShiboKyoTu.searchHihodaicho(entity, データ抽出ＰＴＮ);
    }

    /**
     * 65歳（第１号被保険者基準年齢）の到達日を算出する。
     *
     * @param storeConfigParamter StoreConfigParamter
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @return 到達日
     */
    public FlexibleDate getNenreiTotatsuYmd(UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            StoreConfigParamter storeConfigParamter) {

        return tsuShiboKyoTu.getNenreiTotatsuYmd(住民異動情報, storeConfigParamter);
    }

    /**
     * 基準日時点における年齢を算出する。
     *
     * @param paramter NaiBushoRyouParamter
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param 翌日 FlexibleDate
     */
    public void nenreiCalc(UaFt200FindShikibetsuTaishoEntity 住民異動情報, NaiBushoRyouParamter paramter, FlexibleDate 翌日) {

        tsuShiboKyoTu.nenreiCalc(住民異動情報, paramter, 翌日);
    }

    /**
     * 適用除外解除日、適用除外解除届出日、他特解除日、他特解除届出日 、
     * 異動年月日、異動届出年月日、資格喪失日、資格喪失届出日の中で最大の異動日、届出日を取得する。
     *
     * @param entity JuminIdoRendoShikakuTorokuEntity
     * @param 資格喪失日 資格喪失日
     * @param 資格喪失届出日 資格喪失届出日
     * @param 住民異動情報 UaFt200FindShikibetsuTaishoEntity
     * @param paramter TemParamter
     */
    public void getMaxKaijoYmd(
            JuminIdoRendoShikakuTorokuEntity entity,
            FlexibleDate 資格喪失日,
            FlexibleDate 資格喪失届出日,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報,
            TemParamter paramter) {
        tsuchiJuri.getMaxKaijoYmd(entity, 資格喪失日, 資格喪失届出日, 住民異動情報, paramter);
    }
}
