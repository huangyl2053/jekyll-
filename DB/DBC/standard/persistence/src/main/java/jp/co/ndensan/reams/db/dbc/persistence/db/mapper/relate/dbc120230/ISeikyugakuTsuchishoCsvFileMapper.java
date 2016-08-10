/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120230;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込） DB操作です。
 *
 * @reamsid_L DBC-2480-013 sunqingzhu
 */
public interface ISeikyugakuTsuchishoCsvFileMapper {

    /**
     * 請求額通知書一時TBLを作成する。
     */
    void create請求額通知書一時TBL();

    /**
     * 処理結果リスト一時TBLを作成する。
     */
    void create処理結果リスト一時TBL();

    /**
     * 請求額通知書一時TBLに登録する。
     *
     * @param entity DbWT1511SeikyugakuTsuchishoTempEntity
     */
    void 請求額通知書一時TBLに登録(DbWT1511SeikyugakuTsuchishoTempEntity entity);

    /**
     * 処理結果リスト一時TBLに登録する。
     *
     * @param entity DbWT0002KokuhorenTorikomiErrorTempEntity
     */
    void 処理結果リスト一時TBLに登録(DbWT0002KokuhorenTorikomiErrorTempEntity entity);
}
