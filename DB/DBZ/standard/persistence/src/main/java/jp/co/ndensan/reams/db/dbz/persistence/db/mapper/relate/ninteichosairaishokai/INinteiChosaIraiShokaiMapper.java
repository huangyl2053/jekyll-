/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteichosairaishokai;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteichosairaishokai.NinteiChosaIraiShokaiParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteichosairaishokai.NinteiChosaIraiShokaiRelateEntity;

/**
 *
 * 認定調査情報を取得するのマッパーインタフェースです。
 *
 * @reamsid_L DBE-0200-020 zhangguopeng
 */
public interface INinteiChosaIraiShokaiMapper {

    /**
     * 認定調査の情報取得処理します。
     *
     * @param parameter 認定調査情報を取得するのParameterクラス
     * @return List<NinteiChosaIraiShokaiRelateEntity>
     */
    List<NinteiChosaIraiShokaiRelateEntity> get認定調査情報(NinteiChosaIraiShokaiParameter parameter);

    /**
     * 認定調査情報の件数取得処理します。
     *
     * @param parameter 認定調査情報を取得するのParameterクラス
     * @return int
     */
    int get認定調査情報件数(NinteiChosaIraiShokaiParameter parameter);
}
