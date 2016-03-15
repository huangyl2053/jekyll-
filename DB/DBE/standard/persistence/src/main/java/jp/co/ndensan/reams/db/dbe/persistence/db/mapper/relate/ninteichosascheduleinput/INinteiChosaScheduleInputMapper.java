/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosascheduleinput;

import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosascheduleinput.NinteiChosaScheduleInputParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosascheduleinput.NinteiChosaScheduleRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5221NinteichosaScheduleEntity;

/**
 *
 * 調査員情報取得のMapperクラスです。
 */
public interface INinteiChosaScheduleInputMapper {

    /**
     * 画面表示調査員情報の取得です。
     *
     * @param parameter 調査員情報取得のParameterクラスです。
     * @return NinteiChosaScheduleRelateEntity
     */
    NinteiChosaScheduleRelateEntity get調査員情報取得(NinteiChosaScheduleInputParameter parameter);

    /**
     * すべで調査員情報の取得です。
     *
     * @param parameter 調査員情報取得のParameterクラスです。
     * @return DbT5221NinteichosaScheduleEntity
     */
    DbT5221NinteichosaScheduleEntity get調査員情報(NinteiChosaScheduleInputParameter parameter);

}
