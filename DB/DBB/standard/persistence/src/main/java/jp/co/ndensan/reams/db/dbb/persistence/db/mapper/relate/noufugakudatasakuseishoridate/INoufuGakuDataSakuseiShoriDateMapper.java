/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.noufugakudatasakuseishoridate;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.noufugakudatasakuseishoridate.NoufuGakuDataSakuseiShoriDateParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 前回の処理日付取得クラスです。
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
public interface INoufuGakuDataSakuseiShoriDateMapper {

    /**
     * 前回の処理日付取得を取得する。
     *
     * @param parameter parameter
     * @return DealKyufujissekiEntity
     */
    List<DbT7022ShoriDateKanriEntity> get前回の処理日付取得(NoufuGakuDataSakuseiShoriDateParameter parameter);
}
