package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecoderiyojokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicecoderiyojokyo.KyufuJissekiMeisaiGetMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.ChohyouShutsuryokuyouTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470ToukeihyoMeisaichukanTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470chohyouShutsuryokuyouTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470shoriKekkaListTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.HihokenshaShikibetsuTaishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.KyufuJissekiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.TaniSuNissuKaisuEntity;

/**
 * サービスコード別利用状況作成Mapperクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
public interface IServicecodeRiyojokyoMapper {

    /**
     * 給付実績明細情報の取得
     *
     * @param parameter KyufuJissekiMeisaiGetMybatisParameter
     * @return KyufuJissekiMeisaiEntity
     */
    List<KyufuJissekiMeisaiEntity> get給付実績明細情報(KyufuJissekiMeisaiGetMybatisParameter parameter);

    /**
     * 給付実績サービス計画費情報の取得
     *
     * @param parameter KyufuJissekiMeisaiGetMybatisParameter
     * @return KyufuJissekiMeisaiEntity
     */
    List<KyufuJissekiMeisaiEntity> get給付実績サービス計画費情報(KyufuJissekiMeisaiGetMybatisParameter parameter);

    /**
     * 給付実績特定入所者介護サービス費用情報
     *
     * @param parameter KyufuJissekiMeisaiGetMybatisParameter
     * @return KyufuJissekiMeisaiEntity
     */
    List<KyufuJissekiMeisaiEntity> get給付実績特定入所者介護サービス費用情報(KyufuJissekiMeisaiGetMybatisParameter parameter);

    /**
     * 被保険者・宛名情報の取得
     *
     * @return HihokenshaShikibetsuTaishoEntity
     */
    List<HihokenshaShikibetsuTaishoEntity> get被保険者宛名情報();

    /**
     * 宛名情報抽出処理
     *
     * @param parameter KyufuJissekiMeisaiGetMybatisParameter
     * @return DbWT3470ToukeihyoMeisaichukanTempEntity
     */
    List<DbWT3470ToukeihyoMeisaichukanTempEntity> get宛名情報抽出処理(KyufuJissekiMeisaiGetMybatisParameter parameter);

    /**
     * 集計キーごとに、要介護別集計を、日数・回数、単位数を取得する
     *
     * @param parameter KyufuJissekiMeisaiGetMybatisParameter
     * @return TaniSuNissuKaisuEntity
     */
    List<TaniSuNissuKaisuEntity> get回数単位数(KyufuJissekiMeisaiGetMybatisParameter parameter);

    /**
     * 帳票出力用一時TBLの更新処理
     *
     * @return ChohyouShutsuryokuyouTempEntity
     */
    List<ChohyouShutsuryokuyouTempEntity> update帳票出力用一時TBL();

    /**
     * 帳票出力用一時TBLの取得出力順
     *
     * @param parameter KyufuJissekiMeisaiGetMybatisParameter
     * @return DbWT3470chohyouShutsuryokuyouTempEntity
     */
    List<DbWT3470chohyouShutsuryokuyouTempEntity> get帳票出力用一時TBL出力順(KyufuJissekiMeisaiGetMybatisParameter parameter);

    /**
     * 処理結果リストの取得
     *
     * @param parameter KyufuJissekiMeisaiGetMybatisParameter
     * @return DbWT3470shoriKekkaListTempEntity
     */
    List<DbWT3470shoriKekkaListTempEntity> get処理結果リスト(KyufuJissekiMeisaiGetMybatisParameter parameter);

}
