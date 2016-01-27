/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1;

import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査結果登録1検索用クラスです
 */
public class NinnteiChousaKekkaTouroku1Finder {

    private final MapperProvider mapperProvider;

    public NinnteiChousaKekkaTouroku1Finder() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    public static NinnteiChousaKekkaTouroku1Finder createInstance() {
        return InstanceProvider.create(NinnteiChousaKekkaTouroku1Finder.class);

    }
}
