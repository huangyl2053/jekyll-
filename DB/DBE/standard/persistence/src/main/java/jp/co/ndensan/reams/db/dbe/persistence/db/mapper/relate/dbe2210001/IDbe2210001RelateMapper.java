/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe2210001;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.dbe2210001.NinteiChosaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.ninnteichousakekkatouroku1.TempDataEntity;

/**
 * 認定調査結果登録1のマッパーインタフェースです。
 */
public interface IDbe2210001RelateMapper {

    /**
     * 認定調査情報を取得します。
     *
     * @param parameter 検索条件
     * @return NinteiChosaTokusokujoRelateEntity 検索結果の{@link NinteiChosaJohoEntity}
     */
    TempDataEntity get認定調査情報(NinteiChosaJohoMybatisParameter parameter);

}
