/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosainjikan;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosainjikan.NinteiChosainJikanMasterParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosainjikan.NinteiChosainEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;

/**
 * 認定調査スケジュール登録6のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0022-010 linghuhang
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
