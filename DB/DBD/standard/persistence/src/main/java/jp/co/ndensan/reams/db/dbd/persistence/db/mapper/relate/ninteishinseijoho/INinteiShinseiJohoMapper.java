/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5190001.NinteiShinseiJohoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.NinteiShinseiJohoEntity;

/**
 * 要介護認定申請情報のinterface
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
public interface INinteiShinseiJohoMapper {

    /**
     * 要介護認定申請情報を取得します。
     *
     * @param parameter NinteiShinseiJohoParameter
     * @return List<NinteiShinseiJohoEntity>
     */
    List<NinteiShinseiJohoEntity> get要介護認定申請情報(NinteiShinseiJohoParameter parameter);
}
