/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosadatatorikomi;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadatatorikomi.NinteiChosaDataTorikomiMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadatatorikomi.NinteiChosaDataTorikomiRelateEntity;

/**
 * 認定調査データ取込（モバイル）のMapperインターフェースです。
 *
 * @author N3212 竹内 和紀
 */
public interface INinteiChosaDataTorikomiMapper {

    /**
     * 条件い該当する認定調査情報を取得します。
     *
     * @param parameter INinteiChosaDataTorikomiMapperParameter
     * @return NinteiChosaDataTorikomiRelateEntity
     */
    NinteiChosaDataTorikomiRelateEntity select認定調査情報(NinteiChosaDataTorikomiMapperParameter parameter);
}
