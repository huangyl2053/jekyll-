/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogai_TokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護除外・住所地特例対象施設entityを作成する共通Mockです。
 *
 * @author N3317 塚田 萌
 */
public class JogaiTokureiShisetsuEntityMock {

    public static DbT1005KaigoJogai_TokureiTaishoShisetsuEntity create除外_特例施設Entity(
            ShisetsuCode 施設コード, RString 施設略称) {

        DbT1005KaigoJogai_TokureiTaishoShisetsuEntity entity = new DbT1005KaigoJogai_TokureiTaishoShisetsuEntity();
        entity.setNyushoShisetsuShurui(new RString("11"));
        entity.setNyushoShisetsuCode(施設コード.value());
        entity.setShoriTimestamp(RDateTime.of(2014, 1, 10, 11, 12));
        entity.setYukoKaishiYMD(new FlexibleDate("20110203"));
        entity.setYukoShuryoYMD(new FlexibleDate("20120203"));
        entity.setShikibetsuCode(new ShikibetsuCode(new RString("0000000001")));
        entity.setShisetsuRyakusho(施設略称);
        entity.setShisetsuKanaRyakusho(new RString("ヒマワリ"));
        entity.setShisetsuKanaJusho(new RString("オミムラ"));
        entity.setIdoJiyuCode(new RString("11"));
        entity.setIdoYMD(new FlexibleDate("20110703"));
        entity.setHojinShubetsuCode(new RString("01"));
        entity.setShisetsuKaishiYMD(new FlexibleDate("20110703"));
        entity.setShisetsuKyushiYMD(new FlexibleDate("20110703"));
        entity.setShisetsuHaishiYMD(new FlexibleDate("20110703"));
        entity.setShisetsuSaikaiYMD(new FlexibleDate("20110703"));

        return entity;
    }
}
