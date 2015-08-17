/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.HojinsShubetsu;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.ShiteiKijunGaitoJigyoshoKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護事業者エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n3317 塚田萌
 */
public final class DbT7060KaigoJigyoshaEntityGenerator {

    public static final KaigoJigyoshaNo DEFAULT_事業者番号 = new KaigoJigyoshaNo("1234567890");
    public static final FlexibleDate DEFAULT_有効開始日 = new FlexibleDate("20140401");
    public static final FlexibleDate DEFAULT_有効終了日 = new FlexibleDate("20150331");
    public static final FlexibleDate DEFAULT_異動日 = new FlexibleDate("20140401");
    public static final RString DEFAULT_異動事由 = new RString("01");
    public static final FlexibleDate DEFAULT_事業開始日 = new FlexibleDate("20140401");
    public static final FlexibleDate DEFAULT_事業休止日 = new FlexibleDate("20140501");
    public static final FlexibleDate DEFAULT_事業再開日 = new FlexibleDate("20140601");
    public static final FlexibleDate DEFAULT_事業廃止日 = new FlexibleDate("20140701");
    public static final AtenaMeisho DEFAULT_事業者名称 = new AtenaMeisho("リームス");
    public static final AtenaKanaMeisho DEFAULT_事業者名称カナ = new AtenaKanaMeisho("リームス");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("1820088");
    public static final AtenaJusho DEFAULT_事業者住所 = new AtenaJusho("七瀬中町");
    public static final RString DEFAULT_事業者住所カナ = new RString("ナナセナカマチ");
    public static final TelNo DEFAULT_電話番号 = new TelNo("0332188955");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("0332188955");
    public static final RString DEFAULT_宛先部署 = new RString("総務課");
    public static final AtenaMeisho DEFAULT_宛先人名 = new AtenaMeisho("田中　智");
    public static final AtenaKanaMeisho DEFAULT_宛先人名カナ = new AtenaKanaMeisho("タナカ　サトシ");
    public static final KinyuKikanCode DEFAULT_銀行コード = new KinyuKikanCode("1188");
    public static final KinyuKikanShitenCode DEFAULT_支店コード = new KinyuKikanShitenCode("198");
    public static final RString DEFAULT_口座種別 = new RString("01");
    public static final RString DEFAULT_口座番号 = new RString("1234567");
    public static final AtenaMeisho DEFAULT_口座名義人 = new AtenaMeisho("田中　智");
    public static final AtenaKanaMeisho DEFAULT_口座名義人カナ = new AtenaKanaMeisho("タナカ　サトシ");
    public static final Code DEFAULT_指定基準該当等事業所区分 = new Code(new RString("1"));
    public static final RString DEFAULT_所在市町村 = new RString("電算");
    public static final RString DEFAULT_サービス実施地域 = new RString("三島");
    public static final Code DEFAULT_法人等種別 = new Code(new RString("01"));
    public static final int DEFAULT_ベッド数 = 10;
    public static final int DEFAULT_所属人数 = 10;
    public static final int DEFAULT_利用者数 = 10;
    public static final RString DEFAULT_備考 = new RString("注意事項");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7060KaigoJigyoshaEntityGenerator() {
    }

    public static DbT7060KaigoJigyoshaEntity createDbT7060KaigoJigyoshaEntity() {
        DbT7060KaigoJigyoshaEntity entity = new DbT7060KaigoJigyoshaEntity();
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYukoKaishiYMD(DEFAULT_有効開始日);
        entity.setYukoShuryoYMD(DEFAULT_有効終了日);
        entity.setIdoYMD(DEFAULT_異動日);
        entity.setIdoJiyuCode(DEFAULT_異動事由);
        entity.setJigyoKaishiYMD(DEFAULT_事業開始日);
        entity.setJigyoKyushiYMD(DEFAULT_事業休止日);
        entity.setJigyoSaikaiYMD(DEFAULT_事業再開日);
        entity.setJigyoHaishiYMD(DEFAULT_事業廃止日);
        entity.setJigyoshaName(DEFAULT_事業者名称);
        entity.setJigyoshaNameKana(DEFAULT_事業者名称カナ);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJigyoshaAddress(DEFAULT_事業者住所);
        entity.setJigyoshaKanaAddress(DEFAULT_事業者住所カナ);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        entity.setAtesakiBusho(DEFAULT_宛先部署);
        entity.setAtesakininName(DEFAULT_宛先人名);
        entity.setAtesakininNamekana(DEFAULT_宛先人名カナ);
//        entity.setGinkoCode(DEFAULT_銀行コード);
//        entity.setShitenCode(DEFAULT_支店コード);
//        entity.setKozaShubetsu(DEFAULT_口座種別);
//        entity.setKozaNo(DEFAULT_口座番号);
//        entity.setKozaMeiginin(DEFAULT_口座名義人);
//        entity.setKozaMeigininKana(DEFAULT_口座名義人カナ);
        entity.setShiteiKijungaitoJigyoshaKubun(DEFAULT_指定基準該当等事業所区分);
        entity.setShozaiShichoson(DEFAULT_所在市町村);
        entity.setServiceJisshiChiiki(DEFAULT_サービス実施地域);
        entity.setHojinShubetsu(DEFAULT_法人等種別);
        entity.setBedSu(DEFAULT_ベッド数);
        entity.setShozokuNinzu(DEFAULT_所属人数);
        entity.setRiyoshaSu(DEFAULT_利用者数);
        entity.setBiko(DEFAULT_備考);
        return entity;
    }
}
