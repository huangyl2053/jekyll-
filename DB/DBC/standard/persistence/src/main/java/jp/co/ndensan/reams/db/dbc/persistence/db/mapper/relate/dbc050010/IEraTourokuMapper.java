/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.EraTourokuEntity;

/**
 * エラー登録のバッチのDB操作です。
 *
 * @reamsid_L DBC-2180-030 donghj
 */
public interface IEraTourokuMapper {

    /**
     * エラー登録する。
     *
     * @return {@link List<EraTourokuEntity>}
     */
    List<EraTourokuEntity> エラー登録();

}
