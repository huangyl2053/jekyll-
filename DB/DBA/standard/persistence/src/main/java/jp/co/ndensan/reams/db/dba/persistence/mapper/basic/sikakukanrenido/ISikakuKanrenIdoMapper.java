/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.basic.sikakukanrenido;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.param.sikakukanrenido.SikakuKanrenIdoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.SikakuKanrenIdoEntity;

/**
 *
 * 資格関連異動のMapperクラスです。
 */
public interface ISikakuKanrenIdoMapper {

    /**
     * 資格関連異動を取得します。
     *
     * @param params params
     * @return SikakuKanrenIdoEntity
     */
    List<SikakuKanrenIdoEntity> getSikakuKanrenIdo(SikakuKanrenIdoParameter params);
}
