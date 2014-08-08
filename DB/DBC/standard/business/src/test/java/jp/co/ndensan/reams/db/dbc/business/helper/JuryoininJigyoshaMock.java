/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.helper;

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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.business.IKinyuKikan;
import jp.co.ndensan.reams.ur.urz.business.IKinyuKikanShiten;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business._KinyuKikan;
import jp.co.ndensan.reams.ur.urz.business._KinyuKikanShiten;
import jp.co.ndensan.reams.ur.urz.business._Koza;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojinMeisho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Hojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._HojinMeisho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.YokinShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.HojinKeitai;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.HojinKeitaiFuyoKubun;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.HojinKeitaiRyakushoKubun;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.NinkaChienDantai;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.mockito.Mockito.mock;

/**
 * 受領委任事業者のテストヘルパーです。
 *
 * @author N3317 塚田 萌
 */
public class JuryoininJigyoshaMock {

    public static JuryoininJigyosha create受領委任事業者() {
        return new JuryoininJigyosha(
                new KeiyakuNo(new RString("1234567890")),
                new Range(new FlexibleDate("20110303"), new FlexibleDate("20130303")),
                new YMDHMS("20140110111213"),
                new FlexibleDate("20110203"),
                create届出者(),
                new FlexibleDate("20110208"),
                create契約事業者(),
                JutakuKaishuKeiyakuKubun.契約有り,
                TokuteiFukushiYoguHanbaiKeiyakuKubun.契約無し,
                ShokanbaraiKyufuKeiyakuKubun.契約無し,
                KogakuKyufuKeiyakuKubun.契約無し,
                ToriatsukaiKakuyakushoKubun.確約書有り);
    }

    private static Todokedesha create届出者() {
        return new Todokedesha(
                new RString("住所"),
                new RString("事業者名称"),
                new RString("代表者氏名"));
    }

    private static KeiyakuJigyosha create契約事業者() {
        return new KeiyakuJigyosha(
                new JigyoshaNo(new RString("1234567890")),
                createHojin(),
                new TelNo(new RString("0262222222")),
                EigyoKeitai.法人,
                new RString("担当課"),
                //                createKoza());
                mock(IKoza.class));
    }

    public static IHojin createHojin() {
        IShikibetsuTaisho 識別対象 = createShikibetsuTaisho();
        IHojinMeisho 法人名称 = new _HojinMeisho(new AtenaMeisho("電算"), new AtenaKanaMeisho("デンサン"), HojinKeitai.株式会社, HojinKeitaiFuyoKubun.前に付与);
        AtenaMeisho 法人代表者氏名 = new AtenaMeisho(new RString("法人代表者氏名"));
        NinkaChienDantai 認可地縁団体 = null;
        FlexibleDate 認可地縁団体認可年月日 = new FlexibleDate("20131109");

        return new _Hojin(識別対象, HojinKeitai.有限会社,
                HojinKeitaiFuyoKubun.付与しない, HojinKeitaiRyakushoKubun.正式名称,
                法人名称, 法人代表者氏名, 認可地縁団体, 認可地縁団体認可年月日);
    }

    private static IShikibetsuTaisho createShikibetsuTaisho() {
        return new _ShikibetsuTaisho(
                new ShikibetsuCode(new RString("0000000001")),
                null, 1, true, null, null, null, null, null, null, null,
                null, null, null, null, 1);
    }

//    public static IKoza createKoza() {
//        return new _Koza(new GyomuCode(new RString("DBC")),
//                new KamokuCode(new RString("01")),
//                new KinyuKikanShitenCode(new RString("101")),
//                new KinyuKikanCode(new RString("100")),
//                new RString("123456789"),
//                true,
//                new AtenaKanaMeisho(new RString("メイギニンタロウ")),
//                new AtenaMeisho(new RString("名義人太郎")),
//                true,
//                new AtenaKanaMeisho(new RString("検索次郎")),
//                new ShikibetsuCode(new RString("0001")),
//                new RString("種別"),
//                new RString("234567890"),
//                new RString("ABC"),
//                new Code(new RString("用途区分")),
//                YokinShubetsu.普通預金,
//                new FlexibleDate("20170101"),
//                new FlexibleDate("20140102"),
//                true,
//                true,
//                create金融機関(),
//                create金融機関支店());
//    }
    private static IKinyuKikan create金融機関() {
        return new _KinyuKikan(new KinyuKikanCode(new RString("0123")), new RString("金融機関名称"), new RString("金融機関カナ名称"),
                new Range(new RDate("2014/01/10"), new RDate("2014/01/20")), 1);
    }

    private static IKinyuKikanShiten create金融機関支店() {
        return new _KinyuKikanShiten(new RString("0123"), new RString("支店コード"), new RString("支店名称"), new RString("金融機関カナ名称"),
                new Range(new RDate("2014/01/10"), new RDate("2014/01/20")), 1);
    }
}
