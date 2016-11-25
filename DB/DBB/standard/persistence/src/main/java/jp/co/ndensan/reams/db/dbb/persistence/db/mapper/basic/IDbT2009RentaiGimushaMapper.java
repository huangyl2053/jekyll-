/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * {@link jp.co.ndensan.reams.db.dbb.persistence.db.mapper.basic.IDbT2009RentaiGimushaMapper}のマッパーIFです。
 */
public interface IDbT2009RentaiGimushaMapper {

    /**
     * {@link DbT2009RentaiGimushaEntity}を取得します。
     *
     * @return {@link DbT2009RentaiGimushaEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT2009RentaiGimushaEntity getEntity();

    /**
     * {@link DbT2009RentaiGimushaEntity}を取得します。
     *
     * @param hihokenshaNo HihokenshaNo
     * @return {@link DbT2009RentaiGimushaEntity}
     * @deprecated マッピング検証用のメソッドであるため、テストコード以外から使用しないで下さい。
     */
    DbT2009RentaiGimushaEntity selectBy連帯納付義務者_履歴番号(HihokenshaNo hihokenshaNo);
}
