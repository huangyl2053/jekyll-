/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujissekiout;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0002KokuhorenTorikomiErrorTempEntity;

/**
 * 国保連情報取込処理共通のMapperです
 *
 * @reamsid_L DBC-2460-011 jiangwenkai
 */
public interface IHokenshaKyufujissekiOutMapper {

    /**
     * 処理結果リスト一時TBLを取得する。
     *
     * @return 処理結果リスト一時TBLのエンティティ
     */
    List<DbWT0002KokuhorenTorikomiErrorTempEntity> select処理結果リスト一時TBL();

}
