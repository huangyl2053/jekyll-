/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninnteichousakekkatouroku1;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousakekkatouroku1.NinteiChosaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousakekkatouroku1.TempDataEntity;

/**
 * 認定調査結果登録1のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public interface INinnteiChousaKekkaTouroku1RelateMapper {

    /**
     * 認定調査情報を取得します。
     *
     * @param parameter 検索条件
     * @return NinteiChosaTokusokujoRelateEntity 検索結果の{@link NinteiChosaJohoEntity}
     */
    List<TempDataEntity> get認定調査情報(NinteiChosaJohoMybatisParameter parameter);

    /**
     * 既存概況調査情報を取得します。
     *
     * @param parameter 検索条件
     * @return NinteiChosaTokusokujoRelateEntity 検索結果の{@link NinteiChosaJohoEntity}
     */
    TempDataEntity get既存概況調査情報(NinteiChosaJohoMybatisParameter parameter);

}
