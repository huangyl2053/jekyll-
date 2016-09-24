/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110050;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc110050.ShokanRenrakuhyoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.DbWT2111ShokanShinseiTempEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;

/**
 * 償還連絡票情報作成バッチのDB操作です。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public interface IShokanRenrakuhyoOutMapper {

    /**
     * 償還払支給申請情報を取得する。
     *
     * @param parameter ShokanRenrakuhyoOutMybatisParameter
     * @return DbT3034ShokanShinseiEntity
     */
    DbT3034ShokanShinseiEntity get償還払支給申請データ(ShokanRenrakuhyoOutMybatisParameter parameter);

    /**
     * 被保険者がないのデータを取得する。
     *
     * @return DbWT2111ShokanShinseiTempEntity
     */
    DbWT2111ShokanShinseiTempEntity get被保険者がないのデータ();
}
