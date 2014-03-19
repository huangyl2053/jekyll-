/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice.helper;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.EigyoKeitai;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 *
 * @author N3317 塚田 萌
 */
public class DbT3077JuryoininKeiyakuJigyoshaEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3077JuryoininKeiyakuJigyoshaEntityMock() {

    }

    public static DbT3077JuryoininKeiyakuJigyoshaEntity getSpiedInstance() {

        DbT3077JuryoininKeiyakuJigyoshaEntity entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
        entity.setJigyoshaKeiyakuNo(new RString("1234567890"));
        entity.setKaishiYMD(new FlexibleDate("20110303"));
        entity.setShoriTimestamp(RDateTime.of(2014, 1, 10, 11, 12));
        entity.setShuryoYMD(new FlexibleDate("20130303"));
        entity.setTodokedeYMD(new FlexibleDate("20110203"));
        entity.setTodokedeAddress(new RString("長野市高田"));
        entity.setTodokedeJigyoshaName(new RString("ひまわり"));
        entity.setTodokedeDaihyoshaName(new RString("田中良夫"));
        entity.setShikibetsuCode(new ShikibetsuCode(new RString("0000000001")));
        entity.setJigyoshaFaxNo(new TelNo(new RString("0262222222")));
        entity.setKeiyakuTorokuYMD(new FlexibleDate("20110208"));
        entity.setSofusakiBusho(new RString("担当課"));
        entity.setEigyoKeitai(EigyoKeitai.法人.getCode());
        entity.setJutakuKaishuKeiyakuUmu(true);
        entity.setTokuteiFukushiYoguHanbaiKeiyakuUmu(true);
        entity.setShokanbaraiKyufuKeiyakuUmu(true);
        entity.setKogakuKyufuKeiyakuUmu(true);
        entity.setKeiyakuJigyoshaNo(new JigyoshaNo(new RString("1234567890")));
        entity.setToriatsukaiKakuyakushoUmu(true);

        return spy(entity);
    }
}
