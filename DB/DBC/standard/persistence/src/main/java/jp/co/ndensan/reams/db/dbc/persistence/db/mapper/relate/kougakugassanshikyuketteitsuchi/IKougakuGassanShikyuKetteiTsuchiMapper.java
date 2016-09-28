/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kougakugassanshikyuketteitsuchi;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakugassanshikyuketteitsuchi.KougakuGassanShikyuKetteiTsuchiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakugassanshikyuketteitsuchi.KogakuGassanEntity;

/**
 * ビジネス設計_DBCMN63003_高額合算支給決定通知書（単）のビジネス。
 *
 * @reamsid_L DBC-2310-030 chenyadong
 */
public interface IKougakuGassanShikyuKetteiTsuchiMapper {

    /**
     * 高額合算情報取得です。
     *
     * @param param KougakuGassanShikyuKetteiTsuchiParameter
     * @return {@link KogakuGassanEntity}
     */
    KogakuGassanEntity select高額合算(KougakuGassanShikyuKetteiTsuchiParameter param);

}
