/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3084DaisanshaKoiTodokedeEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護第三者行為届出エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3084DaisanshaKoiTodokedeEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final RString DEFAULT_第三者行為届出管理番号 = new RString("123");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_届出年月日 = new FlexibleDate("20140402");
    public static final YubinNo DEFAULT_届出人郵便番号 = new YubinNo(new RString("0102315"));
    public static final RString DEFAULT_届出人住所 = new RString("123");
    public static final AtenaKanaMeisho DEFAULT_届出人氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final AtenaMeisho DEFAULT_届出人氏名 = new AtenaMeisho("電算太郎");
    public static final TelNo DEFAULT_届出人電話番号 = new TelNo("012-345-6789");
    public static final RString DEFAULT_届出人との続柄 = new RString("123");
    public static final Code DEFAULT_要介護状態区分 = new Code("1");
    public static final FlexibleDate DEFAULT_認定有効期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_認定有効期間終了年月日 = new FlexibleDate("20140402");
    public static final YubinNo DEFAULT_加害者郵便番号 = new YubinNo(new RString("0100203"));
    public static final RString DEFAULT_加害者住所 = new RString("123");
    public static final AtenaKanaMeisho DEFAULT_加害者氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final AtenaMeisho DEFAULT_加害者氏名 = new AtenaMeisho("電算太郎");
    public static final FlexibleDate DEFAULT_加害者生年月日 = new FlexibleDate("20140402");
    public static final TelNo DEFAULT_加害者電話番号 = new TelNo("012-345-6789");
    public static final RString DEFAULT_加害者職業 = new RString("123");
    public static final YubinNo DEFAULT_使用者郵便番号 = new YubinNo(new RString("0106541"));
    public static final RString DEFAULT_使用者住所 = new RString("123");
    public static final AtenaKanaMeisho DEFAULT_使用者氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final AtenaMeisho DEFAULT_使用者氏名 = new AtenaMeisho("電算太郎");
    public static final FlexibleDate DEFAULT_使用者生年月日 = new FlexibleDate("20140402");
    public static final TelNo DEFAULT_使用者電話番号 = new TelNo("012-345-6789");
    public static final RString DEFAULT_使用者職業 = new RString("123");
    public static final FlexibleDate DEFAULT_負傷年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_負傷時間 = new RString("2014");
    public static final RString DEFAULT_負傷時の場所 = new RString("場所");
    public static final RString DEFAULT_発病原因_負傷時状況 = new RString("123");
    public static final AtenaMeisho DEFAULT_自賠責保険契約会社名 = new AtenaMeisho("電算太郎");
    public static final RString DEFAULT_自賠責保険証明書番号 = new RString("123");
    public static final RString DEFAULT_自賠責保険契約者住所 = new RString("123");
    public static final RString DEFAULT_所有者住所 = new RString("住所");
    public static final AtenaMeisho DEFAULT_所有者氏名 = new AtenaMeisho("電算太郎");
    public static final RString DEFAULT_登録番号 = new RString("123");
    public static final RString DEFAULT_車台番号 = new RString("123");
    public static final RString DEFAULT_任意保険対人保障有無 = new RString("1");
    public static final AtenaMeisho DEFAULT_任意保険対人保障保険契約会社名 = new AtenaMeisho("電算太郎");
    public static final TelNo DEFAULT_任意保険対人保障保険契約会社連絡先 = new TelNo("012-345-6789");
    public static final AtenaMeisho DEFAULT_任意保険対人保障保険契約会社担当者 = new AtenaMeisho("電算太郎");
    public static final RString DEFAULT_示談成立有無 = new RString("1");
    public static final FlexibleDate DEFAULT_示談成立年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_損害賠償交渉経過 = new RString("1");
    public static final RString DEFAULT_事故発生状況報告書有無 = new RString("0");
    public static final RString DEFAULT_念書兼同意書有無 = new RString("1");
    public static final RString DEFAULT_誓約書有無 = new RString("1");
    public static final RString DEFAULT_交通事故証明書有無 = new RString("1");
    public static final RString DEFAULT_人身事故証明書入手不能理由書有無 = new RString("2");
    public static final RString DEFAULT_示談書写し有無 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3084DaisanshaKoiTodokedeEntityGenerator() {
    }

    public static DbT3084DaisanshaKoiTodokedeEntity createDbT3084DaisanshaKoiTodokedeEntity() {
        DbT3084DaisanshaKoiTodokedeEntity entity = new DbT3084DaisanshaKoiTodokedeEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTodokedeKanriNo(DEFAULT_第三者行為届出管理番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTodokedeYMD(DEFAULT_届出年月日);
        entity.setTodokedenin_YubinNo(DEFAULT_届出人郵便番号);
        entity.setTodokedenin_Jusho(DEFAULT_届出人住所);
        entity.setTodokedenin_ShimeiKana(DEFAULT_届出人氏名カナ);
        entity.setTodokedenin_Shimei(DEFAULT_届出人氏名);
        entity.setTodokedenin_TelNo(DEFAULT_届出人電話番号);
        entity.setTodokedenin_Zokugara(DEFAULT_届出人との続柄);
        entity.setYokaigoJotaiKubun(DEFAULT_要介護状態区分);
        entity.setNinteiYukoKaishiYMD(DEFAULT_認定有効期間開始年月日);
        entity.setNinteiYukoShuryoYMD(DEFAULT_認定有効期間終了年月日);
        entity.setKagaisha_YubinNo(DEFAULT_加害者郵便番号);
        entity.setKagaisha_Jusho(DEFAULT_加害者住所);
        entity.setKagaisha_ShimeiKana(DEFAULT_加害者氏名カナ);
        entity.setKagansha_Shimei(DEFAULT_加害者氏名);
        entity.setKagaisha_UmareYMD(DEFAULT_加害者生年月日);
        entity.setKagaisha_TelNo(DEFAULT_加害者電話番号);
        entity.setKagaisha_Shokugyo(DEFAULT_加害者職業);
        entity.setShiyosha_YubinNo(DEFAULT_使用者郵便番号);
        entity.setShiyosha_Jusho(DEFAULT_使用者住所);
        entity.setShiyosha_ShimeiKana(DEFAULT_使用者氏名カナ);
        entity.setShiyosha_Shimei(DEFAULT_使用者氏名);
        entity.setShiyosha_UmareYMD(DEFAULT_使用者生年月日);
        entity.setShiyosha_TelNo(DEFAULT_使用者電話番号);
        entity.setShiyosha_Shokugyo(DEFAULT_使用者職業);
        entity.setFushoYMD(DEFAULT_負傷年月日);
        entity.setFushoTime(DEFAULT_負傷時間);
        entity.setFushoJi_Basho(DEFAULT_負傷時の場所);
        entity.setHasshoGeiin_FushoJiJokyo(DEFAULT_発病原因_負傷時状況);
        entity.setJibaisekiHoken_KeiyakuKaishaMei(DEFAULT_自賠責保険契約会社名);
        entity.setJibaisekiHoken_ShomeishoNo(DEFAULT_自賠責保険証明書番号);
        entity.setJibaisekiHoken_KeiyakushaJusho(DEFAULT_自賠責保険契約者住所);
        entity.setShoyushaJusho(DEFAULT_所有者住所);
        entity.setShoyushaShimei(DEFAULT_所有者氏名);
        entity.setTorokuNo(DEFAULT_登録番号);
        entity.setShadaiNo(DEFAULT_車台番号);
        entity.setNiniHoken_TaijinHoshoUmu(DEFAULT_任意保険対人保障有無);
        entity.setNiniHoken_TaijinHoshoKaishaMei(DEFAULT_任意保険対人保障保険契約会社名);
        entity.setNiniHoken_TaijinHoshoKaishaTelNo(DEFAULT_任意保険対人保障保険契約会社連絡先);
        entity.setNiniHoken_TaijinHoshoKaishaTantosha(DEFAULT_任意保険対人保障保険契約会社担当者);
        entity.setJidan_SeiritsuUmu(DEFAULT_示談成立有無);
        entity.setJidan_SeiritsuYMD(DEFAULT_示談成立年月日);
        entity.setSongaiBaishoKoshoKeika(DEFAULT_損害賠償交渉経過);
        entity.setJikoHasseiJokyoHokokushoUmu(DEFAULT_事故発生状況報告書有無);
        entity.setNensho_DoishoUmu(DEFAULT_念書兼同意書有無);
        entity.setSeiyakushoUmu(DEFAULT_誓約書有無);
        entity.setKotsuJikoShomeishoUmu(DEFAULT_交通事故証明書有無);
        entity.setJinshinJikoShomeisho_NyushuFunoRiyushoUmu(DEFAULT_人身事故証明書入手不能理由書有無);
        entity.setJidanshoUtsushiUmu(DEFAULT_示談書写し有無);
        return entity;
    }
}
