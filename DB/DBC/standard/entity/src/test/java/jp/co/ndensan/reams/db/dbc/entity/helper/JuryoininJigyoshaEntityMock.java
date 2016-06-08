/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.definition.core.valueobject.keiyakuno.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
        entity.setKeiyakuJigyoshaNo(契約番号.value());
        entity.setKaishiYMD(new FlexibleDate("20110303"));
        entity.setShuryoYMD(new FlexibleDate("20130303"));
        entity.setKeiyakuShurui(new RString("01"));
        entity.setKeiyakuJigyoshaName(new AtenaMeisho("契約事業者名称"));
        entity.setKeiyakuJigyoshaKanaName(new AtenaKanaMeisho("契約事業者カナ名称"));
        entity.setKeiyakuJigyoshaYubinNo(new YubinNo("123456"));
        entity.setKeiyakuJigyoshaJusho(new AtenaJusho("契約事業者住所"));
        entity.setKeiyakuJigyoshaTelNo(new TelNo("08011112222"));
        entity.setKeiyakuJigyoshaFaxNo(new TelNo("08011112222"));
        entity.setSofusakiYubinNo(new YubinNo("123456"));
        entity.setSofusakiJusho(new AtenaJusho("送付先住所"));
        entity.setSofusakiBusho(new RString("送付先部署"));
        entity.setSofusakiJigyoshaName(new AtenaMeisho("送付先事業者名称"));
        entity.setSofusakiJigyoshaKanaName(new AtenaKanaMeisho("送付先事業者カナ名称"));
        entity.setKinyuKikanCode(new KinyuKikanCode("0001"));
        entity.setShitenCode(new KinyuKikanShitenCode("001"));
        entity.setKozaShubetsu(new RString("01"));
        entity.setKozaNo(new RString("00000001"));
        entity.setKozaMeiginin(new AtenaMeisho("口座名義人"));
        entity.setKozaMeigininKana(new AtenaKanaMeisho("口座名義人カナ"));
        return entity;
    }
}
