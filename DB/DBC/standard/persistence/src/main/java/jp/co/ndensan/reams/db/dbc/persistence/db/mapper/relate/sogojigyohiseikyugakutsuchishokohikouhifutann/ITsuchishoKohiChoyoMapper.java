/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohiseikyugakutsuchishokohikouhifutann;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;

/**
 * 請求額通知書情報（公費）取込の帳票出力対象データ取得
 *
 * @reamsid_L DBC-4700-030 qinzhen
 */
public interface ITsuchishoKohiChoyoMapper {

    /**
     * 帳票出力対象データを取得する。
     *
     * @return List
     */
    List<DbWT1511SeikyugakuTsuchishoTempEntity> get帳票出力対象データ();
}
