/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseitorokuuketsuke;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5120001.NinteiShinseiTorokuUketsukeParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5120001.NinteiShinseiTorokuUketsukeEntity;

/**
 *
 * 要介護認定申請受付 Mapper
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public interface INinteiShinseiTorokuUketsukeMapper {

    /**
     * 初期化情報を取得します。
     *
     * @param param NinteiShinseiTorokuUketsukeParameter
     * @return NinteiShinseiTorokuUketsukeEntity
     */
    NinteiShinseiTorokuUketsukeEntity get初期化情報(NinteiShinseiTorokuUketsukeParameter param);

}
