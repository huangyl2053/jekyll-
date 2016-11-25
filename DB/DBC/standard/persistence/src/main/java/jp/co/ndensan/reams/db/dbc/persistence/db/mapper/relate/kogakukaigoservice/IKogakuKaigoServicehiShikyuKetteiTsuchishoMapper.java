/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservice;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.InsertKetteiTsuchishoInfoTempMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoReportParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.KogakukaigoKetteiTsuchishoInfoTempParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuServiceReportEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuServiceUpdateTempEntity;

/**
 * 高額サービス費支給（不支給）決定通知書作成する用マッパーインタフェースです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public interface IKogakuKaigoServicehiShikyuKetteiTsuchishoMapper {

    /**
     * 高額サービス費支給（不支給）決定通知書情報取得するメソッドです。
     *
     * @param parameter KogakukaigoKetteiTsuchishoInfoTempParameter
     * @return KetteiTsuchishoInfoTempResultEntity 通知書情報エンティティ
     */
    KetteiTsuchishoInfoTempResultEntity select高額サービス情報(InsertKetteiTsuchishoInfoTempMybatisParameter parameter);

    /**
     * サービス種類名称情報を取得する。
     *
     * @return KogakuServiceUpdateTempEntity
     */
    KogakuServiceUpdateTempEntity selectサービス種類名称情報();

    /**
     * 高額介護サービス費支給判定結果の更新処理情報取得するメソッドです。
     *
     * @param parameter KogakukaigoKetteiTsuchishoInfoTempParameter
     * @return DbT3057KogakuShikyuHanteiKekkaEntity　支給判定結果情報エンティティ
     */
    DbT3057KogakuShikyuHanteiKekkaEntity select支給判定結果(KogakukaigoKetteiTsuchishoInfoTempParameter parameter);

    /**
     * 高額サービス帳票出力データ取得するメソッドです。
     *
     * @param parameter JigyoKogakuKetteiTsuchishoReportParameter
     * @return KogakuServiceReportEntity 帳票出力情報エンティティ
     */
    KogakuServiceReportEntity get高額サービス帳票出力データ(JigyoKogakuKetteiTsuchishoReportParameter parameter);
    
    /**
     * 高額介護サービス費支給申請の更新処理情報取得するメソッドです。
     *
     * @return DbT3056KogakuShikyuShinseiEntity　高額介護サービス費支給申請情報エンティティ
     */
    DbT3056KogakuShikyuShinseiEntity get高額介護サービス費支給申請();
}
