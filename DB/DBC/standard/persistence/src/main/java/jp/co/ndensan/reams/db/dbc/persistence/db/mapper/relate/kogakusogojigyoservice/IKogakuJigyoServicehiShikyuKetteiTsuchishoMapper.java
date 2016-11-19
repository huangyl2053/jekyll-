/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakusogojigyoservice;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.InsertKetteiTsuchishoInfoTempMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoReportParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.KogakukaigoKetteiTsuchishoInfoTempParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.SelectShoriDateKanriMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.DbWT0203ShoriKekkaKakuninListTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuServiceUpdateTempEntity;

/**
 * 高額総合事業サービス費支給（不支給）決定通知書作成する用マッパーインタフェースです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public interface IKogakuJigyoServicehiShikyuKetteiTsuchishoMapper {

    /**
     * 事業高額決定通知書情報取得するメソッドです。
     *
     * @param parameter KogakukaigoKetteiTsuchishoInfoTempParameter
     * @return KetteiTsuchishoInfoTempResultEntity 通知書情報エンティティ
     */
    KetteiTsuchishoInfoTempResultEntity select事業高額決定通知書情報(InsertKetteiTsuchishoInfoTempMybatisParameter parameter);

    /**
     * 事業高額サービス種類名称情報を取得する。
     *
     * @return KogakuServiceUpdateTempEntity
     */
    KogakuServiceUpdateTempEntity select事業高額のサービス種類名称情報();

    /**
     * 高額介護サービス費支給判定結果データ取得するメソッドです。
     *
     * @param parameter KogakukaigoKetteiTsuchishoInfoTempParameter
     * @return DbT3111JigyoKogakuShikyuHanteiKekkaEntity 判定結果エンティティ
     */
    DbT3111JigyoKogakuShikyuHanteiKekkaEntity get更新の判定結果データ(KogakukaigoKetteiTsuchishoInfoTempParameter parameter);

    /**
     * 処理日付管理マスタのMAX年度内連番取得するメソッドです。
     *
     * @param parameter SelectShoriDateKanriMybatisParameter
     * @return 年度内連番
     */
    int select最大年度内連番(SelectShoriDateKanriMybatisParameter parameter);

    /**
     * 事業高額決定通知書出力データを取得します。
     *
     * @param parameter JigyoKogakuKetteiTsuchishoReportParameter
     * @return KetteiTsuchishoInfoTempEntity
     */
    KetteiTsuchishoInfoTempResultEntity get事業高額決定通知書出力データ(JigyoKogakuKetteiTsuchishoReportParameter parameter);

    /**
     * 事業高額決定通知書出力データを取得します。
     *
     * @return KetteiTsuchishoInfoTempEntity
     */
    DbWT0203ShoriKekkaKakuninListTempEntity select処理結果リスト一時TBL();
    
    /**
     * 事業高額介護サービス費支給申請データ取得するメソッドです。
     *
     * @return DbT3110JigyoKogakuShikyuShinseiEntity 事業高額介護サービス費支給申請エンティティ
     */
    DbT3110JigyoKogakuShikyuShinseiEntity get事業高額介護サービス費支給申請();

}
