/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目区分を扱うインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface INinteichosaItemKubun {

    /**
     * 項目の名称をRStringで返します。
     *
     * @return 項目の名称
     */
    RString toRString();
}
