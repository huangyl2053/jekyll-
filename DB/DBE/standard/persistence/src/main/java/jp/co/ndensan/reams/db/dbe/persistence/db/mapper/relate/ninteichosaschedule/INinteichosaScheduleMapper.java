/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosaschedule;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosaschedule.NinteichosaScheduleMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaschedule.NinteichosaScheduleEntity;

/**
 * 認定調査スケジュール情報のマッパーインタフェースです。
 */
public interface INinteichosaScheduleMapper {

    /**
     * 認定調査スケジュール情報情報をキー検索で１件取得します。
     *
     * @param 認定調査スケジュール情報検索条件 認定調査スケジュール情報検索条件
     * @return NinteichosaScheduleEntity
     */
    NinteichosaScheduleEntity getNinteichosaScheduleRelateEntity(NinteichosaScheduleMapperParameter 認定調査スケジュール情報検索条件);

}
