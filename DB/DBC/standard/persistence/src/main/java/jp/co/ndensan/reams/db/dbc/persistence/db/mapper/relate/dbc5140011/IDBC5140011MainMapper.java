/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc5140011;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;

/**
 * サービスコード単位明細リストのMapperです。
 *
 * @reamsid_L DBC-3330-010 lihang
 */
public interface IDBC5140011MainMapper {

    /**
     * get介護サービス種類データ。
     *
     * @return List<DbT7130KaigoServiceShuruiEntity>
     */
    List<DbT7130KaigoServiceShuruiEntity> get介護サービス種類データ();
}
