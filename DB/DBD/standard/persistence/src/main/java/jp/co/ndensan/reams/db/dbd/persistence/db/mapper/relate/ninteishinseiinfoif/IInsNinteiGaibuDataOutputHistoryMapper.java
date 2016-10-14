/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseiinfoif;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001.InsNinteiGaibuDataOutputHistoryMybitsParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity;

/**
 * 要介護認定外部データ出力履歴をインサート。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
public interface IInsNinteiGaibuDataOutputHistoryMapper {

    /**
     * 出力履歴をを取得します。
     *
     * @param parameter InsNinteiGaibuDataOutputHistoryMybitsParameter
     * @return DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity
     */
    DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity select出力履歴(InsNinteiGaibuDataOutputHistoryMybitsParameter parameter);

    /**
     * 要介護認定外部データ出力履歴をインサート。
     *
     * @param parameter InsNinteiGaibuDataOutputHistoryMybitsParameter
     */
    void updateその他情報登録(InsNinteiGaibuDataOutputHistoryMybitsParameter parameter);
}
