/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteischedule.ninteichosaschedule;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteischedule.ninteichosaschedule.NinteichosaScheduleMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosaschedule.NinteichosaScheduleEntity;

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
    NinteichosaScheduleEntity select認定調査スケジュール情報ByKey(NinteichosaScheduleMapperParameter 認定調査スケジュール情報検索条件);

    /**
     * 主キー1に合致する認定調査スケジュール情報のリストを取得します。
     *
     * @param 認定調査スケジュール情報検索条件 認定調査スケジュール情報検索条件
     * @return NinteichosaScheduleEntityの{@code list}
     */
    List<NinteichosaScheduleEntity> select認定調査スケジュール情報リストBy主キー1(NinteichosaScheduleMapperParameter 認定調査スケジュール情報検索条件);
}
