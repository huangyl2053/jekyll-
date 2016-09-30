/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shikakushogohyoin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyoin.ShikakuShogohyoInEntity;

/**
 * 介護給付費資格照合表情報取込帳票出力対象データ取得
 *
 * @reamsid_L DBC-2890-010 wangxingpeng
 */
public interface IShikakuShogohyoInMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @return List<ShikakuShogohyoInEntity>
     */
    List<ShikakuShogohyoInEntity> getCSVData();

}
