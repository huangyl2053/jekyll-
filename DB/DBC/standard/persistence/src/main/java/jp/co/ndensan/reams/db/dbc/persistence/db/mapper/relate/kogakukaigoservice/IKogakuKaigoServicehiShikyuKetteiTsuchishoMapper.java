/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservice;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho.KogakukaigoKetteiTsuchishoInfoTempParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KetteiTsuchishoInfoTempResultEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

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
    KetteiTsuchishoInfoTempResultEntity select高額サービス情報(KogakukaigoKetteiTsuchishoInfoTempParameter parameter);

    /**
     * 高額サービス費支給（不支給）決定通知書情報取得するメソッドです。
     *
     * @return DbT7022ShoriDateKanriEntity 通知書情報エンティティ
     */
    DbT7022ShoriDateKanriEntity select処理日付管理マスタMAX();
}
