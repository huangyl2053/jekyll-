
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120230;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込） DB操作です。
 *
 * @reamsid_L DBC-2480-013 sunqingzhu
 */
public interface ISeikyugakuTsuchishoCsvFileMapper {

    /**
     * select請求額通知書一時TBL件数。
     *
     * @param entity DbWT1511SeikyugakuTsuchishoTempEntity
     * @return 請求額通知書一時TBL件数
     */
    int select請求額通知書一時TBL件数(DbWT1511SeikyugakuTsuchishoTempEntity entity);
}
