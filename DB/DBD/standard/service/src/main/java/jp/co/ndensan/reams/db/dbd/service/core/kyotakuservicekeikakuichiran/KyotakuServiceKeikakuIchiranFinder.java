/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.kyotakuservicekeikakuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.JikoSakuseiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.KeikakuIraiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.KyotakuServiceKeikakuIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.KyotakuServiceMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.ServiceShuruiCodeEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.ShuruiGendoKakuEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyotakuservicekeikakuichiran.IKyotakuServiceKeikakuIchiranMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 共有子Div「居宅計画」のデータ検索クラスです。
 *
 * @reamsid_L DBD-3560-080 huangh
 */
public class KyotakuServiceKeikakuIchiranFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KyotakuServiceKeikakuIchiranFinder() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 居宅計画のビジネスを生成します。
     *
     * @return 居宅計画のビジネス
     */
    public static KyotakuServiceKeikakuIchiranFinder createInstance() {
        return InstanceProvider.create(KyotakuServiceKeikakuIchiranFinder.class);
    }

    /**
     * 居宅計画の初期データを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<KyotakuServiceKeikakuIchiranEntity>
     */
    @Transaction
    public List<KyotakuServiceKeikakuIchiranEntity> 居宅サービス計画情報の取得(HihokenshaNo 被保険者番号) {

        IKyotakuServiceKeikakuIchiranMapper mapper = mapperProvider.create(IKyotakuServiceKeikakuIchiranMapper.class);
        List<KyotakuServiceKeikakuIchiranEntity> 居宅サービス一覧情報List = mapper.get居宅サービス計画情報For初期化(被保険者番号);

        return 居宅サービス一覧情報List;
    }

    /**
     * 計画依頼受付情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<KeikakuIraiJohoEntity>
     */
    @Transaction
    public List<KeikakuIraiJohoEntity> 計画依頼受付情報の取得(HihokenshaNo 被保険者番号) {

        IKyotakuServiceKeikakuIchiranMapper mapper = mapperProvider.create(IKyotakuServiceKeikakuIchiranMapper.class);
        List<KeikakuIraiJohoEntity> 計画依頼受付情報List = mapper.get計画依頼受付情報(被保険者番号);

        return 計画依頼受付情報List;
    }

    /**
     * 認定申請中状況を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<KeikakuIraiJohoEntity>
     */
    public List<DbT4001JukyushaDaichoEntity> 認定申請中状況の取得(HihokenshaNo 被保険者番号) {

        DbT4001JukyushaDaichoDac dbT4001Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        List<DbT4001JukyushaDaichoEntity> 認定申請中状況 = dbT4001Dac.select受給者台帳情報By被保険者番号And履歴番号(被保険者番号);

        return 認定申請中状況;
    }

    /**
     * 計画依頼受付情報のサービス種類を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<ServiceShuruiCodeEntity>
     */
    @Transaction
    public List<ServiceShuruiCodeEntity> 計画依頼受付情報のサービス種類取得(HihokenshaNo 被保険者番号) {

        IKyotakuServiceKeikakuIchiranMapper mapper = mapperProvider.create(IKyotakuServiceKeikakuIchiranMapper.class);
        List<ServiceShuruiCodeEntity> サービス種類List = mapper.getサービス種類For計画依頼受付情報(被保険者番号);

        return サービス種類List;
    }

    /**
     * 計画依頼受付情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<JikoSakuseiKeikakuJohoEntity>
     */
    @Transaction
    public List<JikoSakuseiKeikakuJohoEntity> 自己作成計画情報の取得(HihokenshaNo 被保険者番号) {

        IKyotakuServiceKeikakuIchiranMapper mapper = mapperProvider.create(IKyotakuServiceKeikakuIchiranMapper.class);
        List<JikoSakuseiKeikakuJohoEntity> 自己作成計画情報List = mapper.get自己作成計画情報(被保険者番号);

        return 自己作成計画情報List;
    }

    /**
     * 認定情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbV4001JukyushaDaichoEntity>
     */
    public List<DbV4001JukyushaDaichoEntity> 認定情報の取得(HihokenshaNo 被保険者番号) {

        DbV4001JukyushaDaichoAliveDac dbV4001Dac = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
        List<DbV4001JukyushaDaichoEntity> 認定情報 = dbV4001Dac.selectBy被保険者番号For自己作成計画情報(被保険者番号);

        return 認定情報;
    }

    /**
     * 認定申請中状況を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity>
     */
    public List<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity> 居宅サービス明細情報の短期入所利用日数取得(HihokenshaNo 被保険者番号) {

        DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuDac dbt3010Dac
                = InstanceProvider.create(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuDac.class);
        List<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity> 短期入所利用日数情報
                = dbt3010Dac.selectBy被保険者番号(被保険者番号);

        return 短期入所利用日数情報;
    }

    /**
     * 宅サービス明細情報を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 FlexibleDate
     * @param 履歴番号 int
     * @return List<KyotakuServiceMeisaiEntity>
     */
    public List<KyotakuServiceMeisaiEntity> 居宅サービス明細情報の取得(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号) {

        IKyotakuServiceKeikakuIchiranMapper mapper = mapperProvider.create(IKyotakuServiceKeikakuIchiranMapper.class);
        List<KyotakuServiceMeisaiEntity> 居宅サービス明細情報List = mapper.get居宅サービス明細情報(
                被保険者番号,
                対象年月,
                履歴番号);

        return 居宅サービス明細情報List;
    }

    /**
     * 種類限度額一覧を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 HihokenshaNo
     * @param 履歴番号 int
     * @return List<ShuruiGendoKakuEntity>
     */
    @Transaction
    public List<ShuruiGendoKakuEntity> 種類限度額一覧の取得(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号) {

        IKyotakuServiceKeikakuIchiranMapper mapper = mapperProvider.create(IKyotakuServiceKeikakuIchiranMapper.class);
        List<ShuruiGendoKakuEntity> 種類限度額一覧List = mapper.get種類限度額一覧(
                被保険者番号,
                対象年月,
                履歴番号);

        return 種類限度額一覧List;
    }
}
