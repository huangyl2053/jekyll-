/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.seikyugakutsuchishokohiin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;

/**
 * バッチ設計_DBCMNF2002-631_介護給付費等請求額通知書情報（公費）取込のIMapper
 *
 * @reamsid_L DBC-2790-010 surun
 */
public interface ISeikyugakuTsuchishoKohiInMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @return List<DbWT1511SeikyugakuTsuchishoTempEntity>
     */
    List<DbWT1511SeikyugakuTsuchishoTempEntity> get帳票出力対象データ();

}
