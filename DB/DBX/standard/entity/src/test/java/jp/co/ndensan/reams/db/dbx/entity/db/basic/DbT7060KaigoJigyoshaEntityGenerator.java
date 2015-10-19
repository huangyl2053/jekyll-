/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護事業者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7060KaigoJigyoshaEntityGenerator {

    public static final KaigoJigyoshaNo DEFAULT_事業者番号 = new KaigoJigyoshaNo("0001");
    public static final FlexibleDate DEFAULT_有効開始日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_有効終了日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_異動日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_異動事由 = new RString("Data");
    public static final FlexibleDate DEFAULT_事業開始日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_事業休止日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_事業再開日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_事業廃止日 = new FlexibleDate("19900101");
    public static final AtenaMeisho DEFAULT_事業者名称 = new AtenaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_事業者名称カナ = new AtenaKanaMeisho("");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("0010001");
    public static final AtenaJusho DEFAULT_事業者住所 = new AtenaJusho("");
    public static final RString DEFAULT_事業者住所カナ = new RString("Data");
    public static final TelNo DEFAULT_電話番号 = new TelNo("08011112222");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("08011112222");
    public static final RString DEFAULT_宛先部署 = new RString("Data");
    public static final AtenaMeisho DEFAULT_宛先人名 = new AtenaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_宛先人名カナ = new AtenaKanaMeisho("");
    public static final Code DEFAULT_指定_基準該当等事業所区分 = new Code();
    public static final RString DEFAULT_所在市町村 = new RString("Data");
    public static final RString DEFAULT_サービス実施地域 = new RString("Data");
    public static final Code DEFAULT_法人等種別 = new Code();
    public static final Decimal DEFAULT_ベッド数 = new Decimal(0);
    public static final Decimal DEFAULT_所属人数 = new Decimal(1);
    public static final Decimal DEFAULT_利用者数 = new Decimal(1);
    public static final RString DEFAULT_備考 = new RString("Data");

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
        entity.setShiteiKijungaitoJigyoshaKubun(DEFAULT_指定_基準該当等事業所区分);
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
