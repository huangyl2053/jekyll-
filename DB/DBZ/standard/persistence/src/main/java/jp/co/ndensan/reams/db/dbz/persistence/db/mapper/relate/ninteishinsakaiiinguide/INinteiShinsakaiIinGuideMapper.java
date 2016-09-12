/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteishinsakaiiinguide;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideEntity;

/**
 * 審査会委員一覧情報を取得するのマッパーインタフェースです。
 * 
 * @reamsid_L DBE-3000-030  lijia
 * 
 */
public interface INinteiShinsakaiIinGuideMapper {

    /**
     * 審査会委員一覧情報を取得処理します。
     *
     * @param parameter 認定調査情報を取得するのParameterクラス
     * @return List<NinteiChosaIraiShokaiRelateEntity>
     */
    List<NinteiShinsakaiIinGuideEntity> get審査会委員一覧情報(NinteiShinsakaiIinGuideMapperParameter parameter);
}
