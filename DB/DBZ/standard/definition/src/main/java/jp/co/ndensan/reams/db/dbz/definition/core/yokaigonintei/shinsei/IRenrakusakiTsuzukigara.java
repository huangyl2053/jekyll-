/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連絡先の続柄であることを表します。
 */
public interface IRenrakusakiTsuzukigara {

    /**
     * 介護連絡先続柄のコードを返します。
     *
     * @return 介護連絡先続柄のコード
     */
    RString getコード();

    /**
     * 介護連絡先続柄の名称を返します。
     *
     * @return 介護連絡先続柄の名称
     */
    RString get名称();

}
