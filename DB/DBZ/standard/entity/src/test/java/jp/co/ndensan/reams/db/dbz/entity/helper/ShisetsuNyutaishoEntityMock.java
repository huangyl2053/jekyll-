/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.helper;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設入退所Entityの共通Mockです。
 *
 * @author N3317 塚田 萌
 */
public class ShisetsuNyutaishoEntityMock {

    public static DbT1004ShisetsuNyutaishoEntity create施設入退所Entity() {

        DbT1004ShisetsuNyutaishoEntity entity = new DbT1004ShisetsuNyutaishoEntity();
        entity.setShichosonCode(new LasdecCode(new RString("123456")));
        entity.setShikibetsuCode(new ShikibetsuCode(new RString("1111111111")));
//        entity.setShoriTimestamp(RDateTime.of(2014, 1, 10, 11, 12));
        entity.setDaichoShubetsu(DaichoType.被保険者.getCode());
        entity.setNyushoShisetsuShurui(ShisetsuType.介護保険施設.getCode());
        entity.setNyushoShisetsuCode(new RString("1234567890"));
        entity.setNyushoShoriYMD(new FlexibleDate("20110703"));
        entity.setNyushoYMD(new FlexibleDate("20110703"));
        entity.setTaishoShoriYMD(new FlexibleDate("20130331"));
        entity.setTaishoYMD(new FlexibleDate("20130331"));

        return entity;
    }
}
