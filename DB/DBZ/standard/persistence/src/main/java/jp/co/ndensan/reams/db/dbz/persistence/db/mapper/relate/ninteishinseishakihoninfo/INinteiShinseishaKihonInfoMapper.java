/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteishinseishakihoninfo;

import jp.co.ndensan.reams.db.dbz.definition.param.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shisetsunyushoinfo.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoRelateEntity;

/**
 * 認定申請者基本情報を取得するのマッパーインタフェースです。
 *
 */
public interface INinteiShinseishaKihonInfoMapper {

    /**
     * 認定申請者基本情報を取得します。
     *
     * @param params NinteiShinseishaKihonInfoParameter
     * @return NinteiShinseishaKihonInfoRelateEntity
     */
    NinteiShinseishaKihonInfoRelateEntity getSelect(NinteiShinseishaKihonInfoParameter params);
}
