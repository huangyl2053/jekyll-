/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 定型文情報Entityの共通Mockです。
 *
 * @author N9606 漢那 憲作
 */
public class TeikeibunJohoEntityMock {

    public static DbT7103TeikeibunJohoEntity create定型文情報Entity() {

        DbT7103TeikeibunJohoEntity entity = new DbT7103TeikeibunJohoEntity();
        entity.setTeikeiKubun(new RString("1"));
        entity.setShubetsu(new RString("100"));
        entity.setTeikeibunCd(new RString("0001"));
        entity.setTeikeibunNaiyo(new RString("定型文理由てすと"));

        return entity;
    }
}
