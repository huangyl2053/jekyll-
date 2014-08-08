/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.EigyoKeitai;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任事業者Entityのテストヘルパーです。
 *
 * @author N3317 塚田 萌
 */
public class JuryoininJigyoshaEntityMock {

    public static DbT3077JuryoininKeiyakuJigyoshaEntity create受領委任事業者Entity(
            KeiyakuNo 契約番号, RString 送付先部署) {
        DbT3077JuryoininKeiyakuJigyoshaEntity entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
        entity.setJigyoshaKeiyakuNo(契約番号.value());
        entity.setKaishiYMD(new FlexibleDate("20110303"));
        entity.setShoriTimestamp(new YMDHMS("20140110111213"));
        entity.setShuryoYMD(new FlexibleDate("20130303"));
        entity.setTodokedeYMD(new FlexibleDate("20110203"));
        entity.setTodokedeAddress(new RString("長野市高田"));
        entity.setTodokedeJigyoshaName(new RString("ひまわり"));
        entity.setTodokedeDaihyoshaName(new RString("田中良夫"));
        entity.setShikibetsuCode(new ShikibetsuCode(new RString("0000000001")));
        entity.setJigyoshaFaxNo(new TelNo(new RString("0262222222")));
        entity.setKeiyakuTorokuYMD(new FlexibleDate("20110208"));
        entity.setSofusakiBusho(送付先部署);
        entity.setEigyoKeitai(EigyoKeitai.法人.getCode());
        entity.setJutakuKaishuKeiyakuUmu(true);
        entity.setTokuteiFukushiYoguHanbaiKeiyakuUmu(true);
        entity.setShokanbaraiKyufuKeiyakuUmu(true);
        entity.setKogakuKyufuKeiyakuUmu(true);
        entity.setKeiyakuJigyoshaNo(new JigyoshaNo(new RString("1234567890")));
        entity.setToriatsukaiKakuyakushoUmu(true);

        return entity;
    }
}
