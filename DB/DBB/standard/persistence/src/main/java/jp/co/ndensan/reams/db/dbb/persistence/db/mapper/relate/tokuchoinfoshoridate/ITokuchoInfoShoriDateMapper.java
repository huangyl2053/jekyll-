/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoinfoshoridate;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoinfoshoridate.TokuchoInfoShoriDateParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 広域職員の処理日付取得クラスです。
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public interface ITokuchoInfoShoriDateMapper {

    /**
     * 前回の処理日付取得を取得する。
     *
     * @param parameter parameter
     * @return DealKyufujissekiEntity
     */
    List<DbT7022ShoriDateKanriEntity> get広域職員の処理日付取得(TokuchoInfoShoriDateParameter parameter);

    /**
     * 広域月処理日付取得を取得する。
     *
     * @param parameter parameter
     * @return DealKyufujissekiEntity
     */
    List<DbT7022ShoriDateKanriEntity> get広域月処理日付(TokuchoInfoShoriDateParameter parameter);

    /**
     * 広域5月と9月処理日付取得を取得する。
     *
     * @param parameter parameter
     * @return DealKyufujissekiEntity
     */
    List<DbT7022ShoriDateKanriEntity> get広域5月と9月処理日付(TokuchoInfoShoriDateParameter parameter);

}
