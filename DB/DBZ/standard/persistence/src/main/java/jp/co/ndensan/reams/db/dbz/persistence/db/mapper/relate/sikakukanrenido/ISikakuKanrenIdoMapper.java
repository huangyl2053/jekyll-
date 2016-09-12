/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.sikakukanrenido;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.sikakukanrenido.SikakuKanrenIdoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.SikakuKanrenIdoEntity;

/**
 *
 * 資格関連異動のMapperクラスです。
 *
 * @reamsid_L DBA-0120-010 wanghui
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
