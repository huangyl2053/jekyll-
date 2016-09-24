package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecodetanimeisaiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.servicecodetanimeisaiichiran.KyufuJissekiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470ServiceMeisaichukanTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470chohyouShutsuryokuTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.HihokenshaShikibetsuTaishoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.JigyoshoNameEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.ServiceMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.ServiceShuruiCdNameEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.ShoKisaiHokenshaNoNameEntity;

/**
 * サービスコード単位明細リスト作成Mapperクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public interface IServicecodeTaniMeisaiIchiranMapper {

    /**
     * 給付実績情報の取得
     *
     * @param parameter KyufuJissekiMybatisParameter
     * @return ServiceMeisaiEntity
     */
    List<ServiceMeisaiEntity> get給付実績情報(KyufuJissekiMybatisParameter parameter);

    /**
     * 給付実績明細情報の取得
     *
     * @param parameter KyufuJissekiMybatisParameter
     * @return ServiceMeisaiEntity
     */
    List<ServiceMeisaiEntity> get給付実績明細情報(KyufuJissekiMybatisParameter parameter);

    /**
     * 被保険者・宛名情報の取得
     *
     * @return HihokenshaShikibetsuTaishoMeisaiEntity
     */
    List<HihokenshaShikibetsuTaishoMeisaiEntity> get被保険者宛名情報();

    /**
     * 宛名情報抽出処理
     *
     * @param parameter KyufuJissekiMybatisParameter
     * @return DbWT3470ServiceMeisaichukanTempEntity
     */
    List<DbWT3470ServiceMeisaichukanTempEntity> get宛名情報抽出処理(KyufuJissekiMybatisParameter parameter);

    /**
     * 介護事業者情報
     *
     * @return JigyoshoNameEntity
     */
    List<JigyoshoNameEntity> get介護事業者情報();

    /**
     * 介護事業者情報
     *
     * @return JigyoshoNameEntity
     */
    List<JigyoshoNameEntity> get計画事業所名();

    /**
     * 証記載保険者名
     *
     * @return ShoKisaiHokenshaNoNameEntity
     */
    List<ShoKisaiHokenshaNoNameEntity> get証記載保険者名();

    /**
     * サービス種類一時TBL
     *
     * @param parameter KyufuJissekiMybatisParameter
     * @return ServiceShuruiCdNameEntity
     */
    List<DbWT3470ServiceMeisaichukanTempEntity> getサービス種類一時TBL(KyufuJissekiMybatisParameter parameter);

    /**
     * サービス種類名称取得
     *
     * @return ServiceShuruiCdNameEntity
     */
    List<ServiceShuruiCdNameEntity> getサービス種類名称();

    /**
     * サービス項目名称取得
     *
     * @return ServiceShuruiCdNameEntity
     */
    List<ServiceShuruiCdNameEntity> getサービス項目名称();

    /**
     * 帳票出力データ
     *
     * @param parameter KyufuJissekiMybatisParameter
     * @return DbWT3470ServiceMeisaichukanTempEntity
     */
    List<DbWT3470ServiceMeisaichukanTempEntity> get帳票出力データ(KyufuJissekiMybatisParameter parameter);

    /**
     * 帳票出力用一時TBLの取得
     *
     * @param parameter KyufuJissekiMybatisParameter
     * @return DbWT3470chohyouShutsuryokuTempEntity
     */
    List<DbWT3470chohyouShutsuryokuTempEntity> get帳票出力用一時TBL(KyufuJissekiMybatisParameter parameter);
//
//
//    /**
//     * 処理結果リストの取得
//     *
//     * @param parameter KyufuJissekiMeisaiGetMybatisParameter
//     * @return DbWT3470shoriKekkaListTempEntity
//     */
//    List<DbWT3470shoriKekkaListTempEntity> get処理結果リスト(KyufuJissekiMeisaiGetMybatisParameter parameter);
}
