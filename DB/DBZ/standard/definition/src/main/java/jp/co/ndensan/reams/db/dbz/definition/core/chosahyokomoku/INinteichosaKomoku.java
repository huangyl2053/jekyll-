/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査の項目であることを表します。
 */
public interface INinteichosaKomoku {

    /**
     * 調査項目の名称を返します。
     *
     * @return 調査項目の名称
     */
    RString get名称();

    /**
     * 特記事項番号を返します。
     *
     * @return 特記事項番号
     */
    RString get特記事項番号();

}
