/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice.helper;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import static org.mockito.Mockito.spy;

/**
 * JutogaiYusenCurrentEntityのMockです。
 *
 * @author N2901 夘之原 和慶
 */
public class UaFt200FindShikibetsuTaishoEntityMock {

    private UaFt200FindShikibetsuTaishoEntityMock() {
    }

    public static UaFt200FindShikibetsuTaishoEntity getInstance() {
        UaFt200FindShikibetsuTaishoEntity entity = new UaFt200FindShikibetsuTaishoEntity();
        //TODO n3304 岡澤 政幸 UA:Ver0.2.1リリースにより発生したエラーの対応方法が決定するまで一時的にコメントアウト。期限:2015/7末まで。
//        entity.setShikibetsuCode(new ShikibetsuCode(new RString("1234567890")));
//        entity.setRirekiNo(1);
//        entity.setCurrentFlag(true);
//        entity.setKannaiKangaiKubun(KannaiKangaiKubunType.管内.code());
//        entity.setZenkokuJushoCode(new ZenkokuJushoCode(new RString("20900178901")));
//        entity.setChoikiCode(new ChoikiCode("30"));
//        entity.setJusho(new AtenaJusho("住所"));
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
//        entity.setBanchiCode4(new BanchiCode("44"));
//        entity.setBanchi(new AtenaBanchi("番地"));
//        entity.setKatagaki(new Katagaki("方書"));
//        entity.setGenLasdecCode(new LasdecCode("789456"));
//        entity.setKyuLasdecCode(new LasdecCode("456123"));
//        entity.setKyuLasdecCodeRenban(19);
//        entity.setJuminJotaiCode(JuminJotai.転出者.コード());
//        entity.setSetaiCode(new SetaiCode("6"));
//        entity.setSeinengappiYMD(new FlexibleDate("20140101"));
//        entity.setSeibetsuCode(Gender.MALE.getCode());
//        entity.setTsuzukigaraCode(new TsuzukigaraCode(Tsuzukigara.世帯主.code()));
//        entity.setKanjiShimei(new AtenaMeisho("漢字氏名"));
//        entity.setKanaShimei(new AtenaKanaMeisho("カナ氏名"));
//        entity.setGaikokujinShimei(new AtenaMeisho("外国人氏名"));
//        entity.setGaikokujinHeikimei(new AtenaMeisho("外国人併記名"));
//        entity.setGaikokujinKanaShimei(new AtenaKanaMeisho("外国人カナ氏名"));
//        entity.setTsushomei(new AtenaMeisho("通称名"));
//        entity.setKanaTsushomei(new AtenaKanaMeisho("カナ通称名"));
//        entity.setSeinengappiFushoKubun(new RString("生年月日不詳区分"));
//        entity.setKokusekiChiikiCode(new Code("22"));
//        entity.setZairyuShikakuCode(new Code("23"));
//        entity.setZairyuKikanCode(new RString("24"));
//        entity.setZairyuKikantoManryoYMD(new FlexibleDate("20140302"));
//        entity.setDai30Jono45niKiteisuruKubun(StatusOfMidToLongTermResidence.中長期在留者.code());
//        entity.setKojinHojinKBN(new RString("1"));
//        entity.setKyoyushaMeisho(new AtenaMeisho(RString.EMPTY));
//        entity.setKyoyushaKanaMeisho(new AtenaKanaMeisho(RString.EMPTY));
//        entity.setHojinKeitaiCode(Code.EMPTY);
//        entity.setHojinMeishoHenshuKubun(RString.EMPTY);
//        entity.setHojinKeitaiRyakushoKubun(RString.EMPTY);
//        entity.setHojinMeisho(new AtenaMeisho(RString.EMPTY));
//        entity.setHojinKanaMeisho(new AtenaKanaMeisho(RString.EMPTY));
//        entity.setDaihyoshaShimei(new AtenaMeisho(RString.EMPTY));
//        entity.setNinkachiendantaiTorokuShikakuKubun(Code.EMPTY);
//        entity.setNinkachiendantaiNinkaYMD(new FlexibleDate(RString.EMPTY));
//        entity.setShimeiRiyoKubun(RString.EMPTY);
//        entity.setGyomuCode(GyomuCode.UA宛名管理);
        return (entity);
    }

    public static UaFt200FindShikibetsuTaishoEntity getSpiedInstance() {
        return spy(getInstance());
    }
}
