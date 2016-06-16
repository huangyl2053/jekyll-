/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.helper;

import jp.co.ndensan.reams.db.dbc.business.core.JuryoininJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.KeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.Todokedesha;
import jp.co.ndensan.reams.db.dbc.definition.core.eigyokeitai.EigyoKeitai;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakuno.KeiyakuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.hojin.IHojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.hojin.IHojinMeisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.hojin._Hojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.hojin._HojinMeisho;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.HojinKeitaiFuyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.HojinKeitai;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.NinkaChienDantaiTorokuShikakuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic._ShikibetsuTaishoEntityHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
                //                new FlexibleDate("20110203"),
                //                create届出者(),
                //                new FlexibleDate("20110208"),
                create契約事業者()
        //                JutakuKaishuKeiyakuKubun.契約有り,
        //                TokuteiFukushiYoguHanbaiKeiyakuKubun.契約無し,
        //                ShokanbaraiKyufuKeiyakuKubun.契約無し,
        //                KogakuKyufuKeiyakuKubun.契約無し,
        //                ToriatsukaiKakuyakushoKubun.確約書有り
        );
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
//TODO n8233 朴 HojinKeitaiはDBから取得する必要がある（valueobject.code）
//      IHojinMeisho 法人名称 = new _HojinMeisho(new AtenaMeisho("電算"), new AtenaKanaMeisho("デンサン"), HojinKeitai.株式会社, HojinKeitaiFuyoKubun.前に付与);
        IHojinMeisho 法人名称 = new _HojinMeisho(new AtenaMeisho("電算"), new AtenaKanaMeisho("デンサン"), new HojinKeitai(RString.EMPTY), HojinKeitaiFuyoKubun.前に付与);
        AtenaMeisho 法人代表者氏名 = new AtenaMeisho(new RString("法人代表者氏名"));
        NinkaChienDantaiTorokuShikakuKubun 認可地縁団体 = null;
        FlexibleDate 認可地縁団体認可年月日 = new FlexibleDate("20131109");

//TODO  n8223 _Hojinのパッケージ変更によって引数が違うことで確認必要ある。
//      return new _Hojin(識別対象, HojinKeitai.有限会社,
//      HojinKeitaiFuyoKubun.付与しない, HojinKeitaiRyakushoKubun.正式名称,
//      法人名称, 法人代表者氏名, 認可地縁団体, 認可地縁団体認可年月日);
        _ShikibetsuTaishoEntityHolder entity = new _ShikibetsuTaishoEntityHolder();

        //TODO UaFt200FindShikibetsuTaishoEntityのsetterがパッケージプライベートになったため、他のTODO対応の際に対応する
        //また、_Hojinの引数が変わったため、コメントアウトとした。
//        entity.setSeibetsuCode(識別対象.get識別コード().value());
//        entity.setJuminShubetsuCode(識別対象.get住民種別().getCode());
//        entity.setShikibetsuCode(new ShikibetsuCode(new RString("0000000001")));
        return new _Hojin(entity);

    }

    private static IShikibetsuTaisho createShikibetsuTaisho() {
        UaFt200FindShikibetsuTaishoEntity entity = new UaFt200FindShikibetsuTaishoEntity();
        //TODO UaFt200FindShikibetsuTaishoEntityのsetterがパッケージプライベートになったため、他のTODO対応の際に対応する
//        entity.setShikibetsuCode(new ShikibetsuCode(new RString("0000000001")));
//住民種別コード コード:1 日本人, コード:2 外国人  コード:3 住登外日本人 コード:4 住登外外国人 コード:5 法人 コード:6共有者
//        entity.setJuminShubetsuCode(new RString("5"));
        return ShikibetsuTaishoFactory.createShikibetsuTaisho(entity);
//TODO  n8223 _ShikibetsuTaishoのパッケージ変更によって引数が違うことで確認必要ある。
//        return _ShikibetsuTaisho(
//                new ShikibetsuCode(new RString("0000000001")),
//                null, 1, true, null, null, null, null, null, null, null,
//                null, null, null, null, 1);
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
//    private static KinyuKikan create金融機関() {
//        //ビジネスクラスが変更となったため、暫定で対応
//        return new KinyuKikan(new UrT0131KinyuKikanEntity(), null);
//        return new _KinyuKikan(new KinyuKikanCode(new RString("0123")), new RString("金融機関名称"), new RString("金融機関カナ名称"),
//                new Range(new RDate("2014/01/10"), new RDate("2014/01/20")), 1);
//    }
//    private static KinyuKikanShiten create金融機関支店() {
//        //ビジネスクラスが変更となったため、暫定で対応
//        return new KinyuKikanShiten(new UrT0132KinyuKikanShitenEntity());
//        return new KinyuKikanShiten(new RString("0123"), new RString("支店コード"), new RString("支店名称"), new RString("金融機関カナ名称"),
//                new Range(new RDate("2014/01/10"), new RDate("2014/01/20")), 1);
//    }
}
