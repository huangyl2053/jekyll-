/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufukanrihyoout.KyufukanrihyoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyufukanrihyoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.ShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.YoboKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票作成のMapper
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public interface IKyufukanrihyoOutMapper {

    /**
     * get居宅給付計画自己作成情報
     *
     * @param parameter KyufukanrihyoOutMybatisParameter
     * @return KyotakuKeikakuJikosakuseiEntity KyotakuKeikakuJikosakuseiEntity
     */
    List<KyotakuKeikakuJikosakuseiEntity> get居宅給付計画自己作成情報の取得(KyufukanrihyoOutMybatisParameter parameter);

    /**
     * get予防給付計画自己作成情報の取得
     *
     * @param parameter KyufukanrihyoOutMybatisParameter
     * @return YoboKeikakuJikoSakuseiEntity YoboKeikakuJikoSakuseiEntity
     */
    List<YoboKeikakuJikoSakuseiEntity> get予防給付計画自己作成情報の取得(KyufukanrihyoOutMybatisParameter parameter);

    /**
     * get支給限度額登録1
     *
     * @return ShikyuGendoGakuEntity
     */
    List<ShikyuGendoGakuEntity> get支給限度額登録1();

    /**
     * get支給限度額登録2
     *
     * @return ShikyuGendoGakuEntity
     */
    List<ShikyuGendoGakuEntity> get支給限度額登録2();

    /**
     * get支給限度額登録3
     *
     * @param parameter KyufukanrihyoOutMybatisParameter
     * @return ShikyuGendoGakuEntity
     */
    List<ShikyuGendoGakuEntity> get支給限度額登録3(KyufukanrihyoOutMybatisParameter parameter);

    /**
     * get支給限度額登録4
     *
     * @return ShikyuGendoGakuEntity
     */
    List<ShikyuGendoGakuEntity> get支給限度額登録4();

    /**
     * get支給限度額情報の取得チェック
     *
     * @return hihokenshaNo hihokenshaNo
     */
    List<RString> get支給限度額情報の取得チェック();

    /**
     * get保険者番号登録
     *
     * @return KyufukanrihyoOutDoBillOutEntity
     */
    List<KyufukanrihyoOutDoBillOutEntity> get保険者番号登録();

    /**
     * get帳票出力対象データ
     *
     * @param parameter KyufukanrihyoOutMybatisParameter
     * @return KyufukanrihyoOutDoBillOutEntity
     */
    KyufukanrihyoOutDoBillOutEntity get帳票出力対象データ(KyufukanrihyoOutMybatisParameter parameter);

    /**
     * select介護事業者名称
     *
     * @return ShikyuGendoGakuEntity
     */
    List<ShikyuGendoGakuEntity> select介護事業者名称();

    /**
     * select事業者名称
     *
     * @return ShikyuGendoGakuEntity
     */
    List<ShikyuGendoGakuEntity> select事業者名称();

    /**
     * doエラー登録
     *
     * @return KyotakuKeikakuJikosakuseiKanriTempEntity
     */
    List<KyotakuKeikakuJikosakuseiKanriTempEntity> doエラー登録();

    /**
     * update居宅給付日数
     *
     * @return List<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity>
     */
    List<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity> update居宅給付日数();

    /**
     * update予防給付日数
     *
     * @return List<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity>
     */
    List<DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity> update予防給付日数();
}
