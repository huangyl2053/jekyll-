/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;

/**
 * 介護認定法改正管理のMapperです。
 *
 * @reamsid_L DBZ-1300-080 yaodongsheng
 */
public interface IDbT7202KaigoNinteiHokaiseiKanriMapper {

    /**
     * 介護認定法改正管理を検索で１件取得します。
     *
     * @return DbT7202KaigoNinteiHokaiseiKanriEntity
     */
    DbT7202KaigoNinteiHokaiseiKanriEntity get最古法改正施行年月日();
}
