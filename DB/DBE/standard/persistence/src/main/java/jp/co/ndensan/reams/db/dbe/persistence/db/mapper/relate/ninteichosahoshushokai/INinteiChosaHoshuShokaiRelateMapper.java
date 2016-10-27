/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahoshushokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601005.NinteiChosaHoshuShokaiMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai.NinteiChosaHoshuShokaiRelateEntity;

/**
 * 認定調査報酬照会のMapperです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
public interface INinteiChosaHoshuShokaiRelateMapper {

    /**
     * 認定調査報酬実績データの取得です。
     *
     * @param ninteiparam NinteiChosaHoshuShokaiMapperParameter
     * @return List<NinteiChosaHoshuShokaiRelateEntity>
     */
    List<NinteiChosaHoshuShokaiRelateEntity> get報酬実績データ情報(NinteiChosaHoshuShokaiMapperParameter ninteiparam);
}
