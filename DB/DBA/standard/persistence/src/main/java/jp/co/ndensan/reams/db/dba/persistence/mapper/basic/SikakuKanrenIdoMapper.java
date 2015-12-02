/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.sikakuKanrenIdo.SikakuKanrenIdoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.SikakuKanrenIdoEntity;

/**
 *
 * @author soft863
 */
public interface SikakuKanrenIdoMapper {

    List<SikakuKanrenIdoEntity> getSikakuKanrenIdo(SikakuKanrenIdoParameter params);
}
