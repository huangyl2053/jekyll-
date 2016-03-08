/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.ninteichosainjikan;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosainjikan.NinteiChosainJikanMasterParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.ninteichosainjikan.NinteiChosainEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;

/**
 * 認定調査スケジュール登録6のマッパーインタフェースです。
 */
public interface INinteiChosainJikanMasterMapper {

    /**
     * 認定調査スケジュール情報を取得します。
     *
     * @param parameter parameter
     * @return List<NinteiChosainEntity> 認定調査スケジュール情報リスト
     */
    List<NinteiChosainEntity> selectNinteichosa(NinteiChosainJikanMasterParameter parameter);

    /**
     * 認定調査スケジュール情報を取得します。
     *
     * @param parameter parameter
     * @return NinteiChosainEntity 認定調査スケジュール情報
     */
    NinteiChosainEntity selectByKy(NinteiChosainJikanMasterParameter parameter);

    /**
     * 認定調査スケジュール情報を取得します。
     *
     * @param parameter parameter
     * @return List<DbT5221NinteichosaScheduleEntity> 認定調査スケジュール情報リスト
     */
    List<DbT5221NinteichosaScheduleEntity> selectNintei(NinteiChosainJikanMasterParameter parameter);
}
