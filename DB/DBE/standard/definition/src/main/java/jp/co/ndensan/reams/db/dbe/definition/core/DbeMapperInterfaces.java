/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * SQLのステートメントIDです。
 *
 * 
 */
public enum DbeMapperInterfaces {

    /**
     * 要介護認定調査督促状データの抽出
     */
    要介護認定調査督促状データの抽出("IDbe223001RelateMapper.select要介護認定調査督促状ByKey"),
    /**
     * 認定調査督促対象者一覧表データの抽出
     */
    認定調査督促対象者一覧表データの抽出("IDbe223001RelateMapper.select認定調査督促対象者一覧表ByKey");
    
    private final RString fullPath;

    private DbeMapperInterfaces(String interfaceName) {
        this.fullPath = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe223001." + interfaceName);
    }

    /**
     * マッパーIDのフルパスを取得します。
     *
     * @return マッパーIDのフルパス
     */
    public RString getFullPath() {
        return fullPath;
    }
}
