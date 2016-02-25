/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.NinteiChosaIraiMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.NinteiChosaIraiRelateEntity;

/**
 * 認定調査依頼発行一覧表のマッパーインタフェースです。
 */
public interface INinteiChosaIraiMapper {

    /**
     * 認定調査依頼発行一覧表を取得します。
     *
     * @param param 認定調査依頼発行一覧表のパラメータ
     * @return List<NinteiChosaIraiRelateEntity>
     */
    List<NinteiChosaIraiRelateEntity> get認定調査依頼発行一覧(NinteiChosaIraiMybitisParamter param);
}
