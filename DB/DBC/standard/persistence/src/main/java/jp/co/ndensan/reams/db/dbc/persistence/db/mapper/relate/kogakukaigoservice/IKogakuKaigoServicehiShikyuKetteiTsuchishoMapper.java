/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservice;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.InsertKetteiTsuchishoInfoTempMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.JigyoKogakuKetteiTsuchishoReportParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.KogakukaigoKetteiTsuchishoInfoTempParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;

/**
 * 高額サービス費支給（不支給）決定通知書作成する用マッパーインタフェースです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public interface IKogakuKaigoServicehiShikyuKetteiTsuchishoMapper {

    /**
     * 高額サービス費支給（不支給）決定通知書情報取得するメソッドです。
     *
     * @param parameter InsertKetteiTsuchishoInfoTempMybatisParameter
     * @return KetteiTsuchishoInfoTempResultEntity 通知書情報エンティティ
     */
    KetteiTsuchishoInfoTempResultEntity select高額サービス情報(InsertKetteiTsuchishoInfoTempMybatisParameter parameter);

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
     * @return KetteiTsuchishoInfoTempResultEntity 通知書情報エンティティ
     */
    KetteiTsuchishoInfoTempResultEntity get高額サービス帳票出力データ(JigyoKogakuKetteiTsuchishoReportParameter parameter);
}
