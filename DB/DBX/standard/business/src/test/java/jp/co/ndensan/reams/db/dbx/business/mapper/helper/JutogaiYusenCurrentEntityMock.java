package jp.co.ndensan.reams.db.dbx.business.mapper.helper;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import static org.mockito.Mockito.spy;

/**
 * JutogaiYusenCurrentEntityのMockです。
 *
 * @author N2901 夘之原 和慶
 */
public class JutogaiYusenCurrentEntityMock {

    private JutogaiYusenCurrentEntityMock() {
    }

    public static UaFt200FindShikibetsuTaishoEntity getSpiedInstance() {
        UaFt200FindShikibetsuTaishoEntity entity = new UaFt200FindShikibetsuTaishoEntity();
        //TODO n3304 岡澤 政幸 UA:Ver0.2.1リリースにより発生したエラーの対応方法が決定するまで一時的にコメントアウト。期限:2015/7末まで。
//        entity.setShikibetsuCode(new ShikibetsuCode(new RString("1234567890")));
//        entity.setRegistrationTimestamp(RDateTime.of(2014, 01, 20, 0, 1, 2, 3));
//        entity.setRirekiNo(1);
//        entity.setCurrentFlag(true);
//         entity.setKengenShubetsu(RString.EMPTY);
//        entity.setKannaiKangaiKubun(KannaiKangaiKubunType.管内.code());
//        entity.setZenkokuJushoCode(new ZenkokuJushoCode(new RString("00000209001")));
//        entity.setChoikiCode(new ChoikiCode("30"));
//        entity.setJusho(new RString("住所"));
//        entity.setIdoJiyuCode(JukiIdoJiyu.転出.get異動事由コード());
//        entity.setIdoYMD(new FlexibleDate("20140202"));
//        entity.setIdoRiyuCode(Code.EMPTY);
//        entity.setTodokedeYMD(new FlexibleDate("20140203"));
//        entity.setJuminShubetsuCode(JuminShubetsu.住登外個人_日本人.getCode());
//        entity.setGyoseikuCode(new GyoseikuCode("35"));
//        entity.setChikuCode1(new ChikuCode("36"));
//        entity.setChikuCode2(new ChikuCode("37"));
//        entity.setChikuCode3(new ChikuCode("38"));
//        entity.setYubinNo(new YubinNo("123-4567"));
//        entity.setBanchiCode1(new BanchiCode("31"));
//        entity.setBanchiCode2(new BanchiCode("32"));
//        entity.setBanchiCode3(new BanchiCode("33"));
//        entity.setBanchi(new AtenaBanchi("番地"));
//        entity.setKatagaki(new Katagaki("方書"));
//        entity.setGenLasdecCode(new LasdecCode("789456"));
//        entity.setKyuLasdecCode(new LasdecCode("456123"));
//        entity.setKyuLasdecCodeRenban(19);
//        entity.setJuminJotaiCode(JuminJotai.転出者.コード());
//        entity.setSetaiCode(new SetaiCode("6"));
//        entity.setSeinengappiYMD(new FlexibleDate("20140101"));
//        entity.setSeibetsuCode(Gender.MALE.getCode());
//        entity.setTsuzukigaraCode(new TsuzukigaraCode("0234"));
//        entity.setJijitsujonoTsuzukigaraCode(new TsuzukigaraCode("2345"));
//        entity.setKanjiShimei(new AtenaMeisho("漢字氏名"));
//        entity.setKanaShimei(new AtenaKanaMeisho("カナ氏名"));
//        entity.setGaikokujinShimei(new AtenaMeisho("外国人氏名"));
//        entity.setGaikokujinHeikimei(new AtenaMeisho("外国人併記名"));
//        entity.setGaikokujinKanaShimei(new AtenaKanaMeisho("外国人カナ氏名"));
//        entity.setTsushomei(new AtenaMeisho("通称名"));
//        entity.setKanaTsushomei(new AtenaKanaMeisho("カナ通称名"));
//        entity.setSeinengappiFushoKubun(new RString("生年月日不詳区分"));
//        entity.setGaikokujinTorokuJiyuCode(JukiIdoJiyu.帰化.get異動事由コード());
//        entity.setGaikokujinTorokuIdoYMD(new FlexibleDate("20140306"));
//        entity.setGaikokujinTorokuTodokedeYMD(new FlexibleDate("20140307"));
//        entity.setKokusekiChiikiCode(new Code("22"));
//        entity.setZairyuShikakuCode(new Code("23"));
//        entity.setZairyuKikanCode(new RString("24"));
//        entity.setZairyuKikanto(new RString("25"));
//        entity.setZairyuKikantoManryoYMD(new FlexibleDate("20140302"));
//        entity.setZairyuCardtoNo(new RString("26"));
//        entity.setZairyuCardtoYukoYMD(new FlexibleDate("20140303"));
//        entity.setDai30Jono45niKiteisuruKubun(StatusOfMidToLongTermResidence.中長期在留者.コード());
//        entity.setKojinHojinKBN(new RString("1"));
//        entity.setKyoyushaMeisho(new AtenaMeisho(RString.EMPTY));
//        entity.setKyoyushaKanaMeisho(new AtenaKanaMeisho(RString.EMPTY));
//        entity.setHojinKeitaiCode(Code.EMPTY);
//        entity.setHojinMeiHenshuKubun(RString.EMPTY);
//        entity.setHojinKeitaiRyakushoKubun(RString.EMPTY);
//        entity.setHojinMeisho(new AtenaMeisho(RString.EMPTY));
//        entity.setHojinKanaMeisho(new AtenaKanaMeisho(RString.EMPTY));
//        entity.setDaihyoshaShimei(new AtenaMeisho(RString.EMPTY));
//        entity.setNinkachiendantaiTorokuShikakuKubun(Code.EMPTY);
//        entity.setNinkachiendantaiNinkaYMD(new FlexibleDate(RString.EMPTY));
//        entity.setJutonaiJutogaiKubun(new RString("2"));
//        entity.setGyomuCode(GyomuCode.UR業務共通);
//        entity.setShimeiRiyoKubun(RString.EMPTY);

        return spy(entity);
    }
}
