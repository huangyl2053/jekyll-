/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;

/**
 * {@link DbT7202KaigoNinteiHokaiseiKanriEntity}のマッパーIFです。
 *
 */
public interface IDbT7202KaigoNinteiHokaiseiKanriMapper {

    /**
     * {@link DbT7202KaigoNinteiHokaiseiKanriEntity}を取得します。
     *
     * @return {@link DbT7202KaigoNinteiHokaiseiKanriEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7202KaigoNinteiHokaiseiKanriEntity getEntity();

    /**
     * 介護認定法改正管理を検索で１件取得します。
     *
     * @return DbT7202KaigoNinteiHokaiseiKanriEntity
     */
    DbT7202KaigoNinteiHokaiseiKanriEntity get最古法改正施行年月日();
}
