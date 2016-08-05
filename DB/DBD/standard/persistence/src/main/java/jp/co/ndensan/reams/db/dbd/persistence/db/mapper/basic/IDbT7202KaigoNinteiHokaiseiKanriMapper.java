/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link DbT7202KaigoNinteiHokaiseiKanriEntity}のマッパーIFです。
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
public interface IDbT7202KaigoNinteiHokaiseiKanriMapper {

    /**
     * {@link DbT7202KaigoNinteiHokaiseiKanriEntity}を取得します。
     *
     * @param parameter FlexibleDate
     * @return {@link DbT7202KaigoNinteiHokaiseiKanriEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT7202KaigoNinteiHokaiseiKanriEntity get厚労省IF識別コード(FlexibleDate parameter);
}
