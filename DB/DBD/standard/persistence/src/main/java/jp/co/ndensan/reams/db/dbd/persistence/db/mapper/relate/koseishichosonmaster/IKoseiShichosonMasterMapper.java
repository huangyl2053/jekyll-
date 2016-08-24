/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.koseishichosonmaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.KoseiShichosonMasterEntity;

/**
 * 構成市町村マスタのMapperです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
public interface IKoseiShichosonMasterMapper {

    /**
     * 市町村識別IDを取得します。
     *
     * @return List<ShoriDateKanriEntity>
     */
    List<KoseiShichosonMasterEntity> get市町村識別ID();

}
