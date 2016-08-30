/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanshikyushinseitoroku;

import java.util.Map;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 高額合算支給申請書登録のmapperです。
 *
 * @reamsid_L DBC-2040-040 huzongcheng
 */
public interface IKogakuGassanShikyuShinseiTorokuMapper {

    /**
     * 被保険者番号を取得する。
     *
     * @param parameter Map
     * @return HihokenshaNo
     */
    HihokenshaNo select被保険者番号(Map<String, Object> parameter);
}
