/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.helper;

import jp.co.ndensan.reams.db.dbc.business.JuryoininJigyosha;
import jp.co.ndensan.reams.db.dbc.business.KeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.Todokedesha;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.EigyoKeitai;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.JutakuKaishuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KogakuKyufuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ShokanbaraiKyufuKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.TokuteiFukushiYoguHanbaiKeiyakuKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ToriatsukaiKakuyakushoKubun;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.business.IKinyuKikan;
import jp.co.ndensan.reams.ur.urz.business.IKinyuKikanBranch;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business._KinyuKikan;
import jp.co.ndensan.reams.ur.urz.business._KinyuKikanBranch;
import jp.co.ndensan.reams.ur.urz.business._Koza;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Hojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.YokinShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.NinkaChienDantai;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.mockito.Mockito.mock;

/**
 * 受領委任事業者のテストヘルパーです。
 *
 * @author N3317 塚田 萌
 */
public class JuryoininJigyoshaMock {

    public static DbT3077JuryoininKeiyakuJigyoshaEntity create受領委任事業者Entity(
            KeiyakuNo 契約番号, RString 送付先部署) {

        DbT3077JuryoininKeiyakuJigyoshaEntity entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
        entity.setJigyoshaKeiyakuNo(契約番号.value());
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

    public static JuryoininJigyosha create受領委任事業者() {
        return new JuryoininJigyosha(
                new KeiyakuNo(new RString("1234567890")),
                new Range(new FlexibleDate("20110303"), new FlexibleDate("20130303")),
                RDateTime.of(2014, 1, 10, 11, 12),
                new FlexibleDate("20110203"),
                mock(Todokedesha.class),
                new FlexibleDate("20110208"),
                create契約事業者(),
                JutakuKaishuKeiyakuKubun.契約有り,
                TokuteiFukushiYoguHanbaiKeiyakuKubun.契約無し,
                ShokanbaraiKyufuKeiyakuKubun.契約無し,
                KogakuKyufuKeiyakuKubun.契約無し,
                ToriatsukaiKakuyakushoKubun.確約書有り);
    }

    private static KeiyakuJigyosha create契約事業者() {
        return new KeiyakuJigyosha(
                new JigyoshaNo(new RString("1234567890")),
                createHojin(),
                new TelNo(new RString("0262222222")),
                EigyoKeitai.法人,
                new RString("担当課"),
                createKoza());
    }

    public static IHojin createHojin() {
        IShikibetsuTaisho 識別対象 = createShikibetsuTaisho();
        RString 法人形態 = new RString("有限会社");
        IKojin 法人代表者 = null;
        NinkaChienDantai 認可地縁団体 = null;
        FlexibleDate 認可地縁団体認可年月日 = new FlexibleDate("20131109");

        return new _Hojin(識別対象, 法人形態, 法人代表者, 認可地縁団体, 認可地縁団体認可年月日);
    }

    private static IShikibetsuTaisho createShikibetsuTaisho() {
        return new _ShikibetsuTaisho(
                new ShikibetsuCode(new RString("0000000001")),
                null, 1, null, null, null, null, null, null, null, null,
                null, null, null, null, 1);
    }

    public static IKoza createKoza() {
        return new _Koza(new GyomuCode(new RString("URZ")),
                new KamokuCode(new RString("01")),
                new KinyuKikanShitenCode(new RString("101")),
                new KinyuKikanCode(new RString("100")),
                new RString("123456789"),
                true,
                new AtenaKanaMeisho(new RString("メイギニンタロウ")),
                new AtenaMeisho(new RString("名義人太郎")),
                true,
                new AtenaKanaMeisho(new RString("検索次郎")),
                new ShikibetsuCode(new RString("0001")),
                new RString("種別"),
                new RString("234567890"),
                new RString("ABC"),
                new Code(new RString("用途区分")),
                YokinShubetsu.普通預金,
                new FlexibleDate("20170101"),
                new FlexibleDate("20140102"),
                true,
                true,
                create金融機関(),
                create金融機関支店());
    }

    private static IKinyuKikan create金融機関() {
        return new _KinyuKikan(new KinyuKikanCode(new RString("0123")), new RString("金融機関名称"), new RString("金融機関カナ名称"),
                new Range(new RDate("2014/01/10"), new RDate("2014/01/20")), 1);
    }

    private static IKinyuKikanBranch create金融機関支店() {
        return new _KinyuKikanBranch(new RString("0123"), new RString("支店コード"), new RString("支店名称"), new RString("金融機関カナ名称"),
                new Range(new RDate("2014/01/10"), new RDate("2014/01/20")), 1);
    }
}
