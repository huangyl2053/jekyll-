/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7501NinteiSaikinShorishaEntity;

/**
 * 認定最近処理者用のMapperです。
 */
public interface IDbT7501NinteiSaikinShorishaMapper {

    /**
     * 最近処理者情報を保存します。<br/>
     * ここではPSM「rgdb.DbFt7501SaikinShorishaSave」を呼び出します。<br/>
     * 最近処理者の保存最大件数の考慮は、PSM内で行われます。
     *
     * @param entity
     */
    int save(DbT7501NinteiSaikinShorishaEntity entity);
}
