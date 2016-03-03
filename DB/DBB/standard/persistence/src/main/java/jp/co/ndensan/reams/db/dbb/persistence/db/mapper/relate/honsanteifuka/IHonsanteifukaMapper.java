/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteifuka;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2014TsuchishoUchiwakeJokenEntity;

/**
 * 通知書打ち分け条件の取得処理
 */
public interface IHonsanteifukaMapper {

    /**
     * 打分け方法情報の取得処理１
     *
     * @return List<DbT2014TsuchishoUchiwakeJokenEntity>
     */
    List<DbT2014TsuchishoUchiwakeJokenEntity> get通知書打ち分け条件();

    /**
     * 打分け方法情報の取得処理２
     *
     * @param parameter parameter
     * @return List<DbT2014TsuchishoUchiwakeJokenEntity>
     */
    List<DbT2014TsuchishoUchiwakeJokenEntity> get打分け方法情報一覧(Map<String, Object> parameter);
}
