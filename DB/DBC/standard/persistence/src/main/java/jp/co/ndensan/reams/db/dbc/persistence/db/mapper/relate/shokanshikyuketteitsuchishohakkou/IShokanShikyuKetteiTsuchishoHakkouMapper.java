/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanshikyuketteitsuchishohakkou;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteitsuchishohakkou.ShokanShikyuKetteiTsuchishoHakkouEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * get償還払支給判定結果。
 *
 * @reamsid_L DBC-5310-010 liuyl
 */
public interface IShokanShikyuKetteiTsuchishoHakkouMapper {

    /**
     * 償還払支給判定結果を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<ShokanShikyuKetteiTsuchishoHakkouEntity>
     */
    List<ShokanShikyuKetteiTsuchishoHakkouEntity> get償還払支給判定結果(HihokenshaNo 被保険者番号);
}
