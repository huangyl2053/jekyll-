/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村特別給付サービス事業者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator {

    public static final JigyoshaNo DEFAULT_市町村特別給付用事業者番号 = new JigyoshaNo("1");
    public static final ServiceCode DEFAULT_市町村特別給付用サービスコード = new ServiceCode("1");
    public static final int DEFAULT_履歴番号 = 0;
    public static final RString DEFAULT_介護国保連ＩＦ異動区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_介護国保連ＩＦ異動年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_介護国保連ＩＦ訂正区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_介護国保連ＩＦ訂正年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_介護国保連ＩＦ法人種別 = new RString("Data");
    public static final RString DEFAULT_申請者氏名_漢字 = new RString("Data");
    public static final RString DEFAULT_申請者氏名_カナ = new RString("Data");
    public static final YubinNo DEFAULT_申請者郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_申請者住所 = new RString("Data");
    public static final RString DEFAULT_申請者住所_カナ = new RString("Data");
    public static final RString DEFAULT_申請者電話番号 = new RString("Data");
    public static final RString DEFAULT_申請者FAX番号 = new RString("Data");
    public static final RString DEFAULT_事業所代表者役職 = new RString("Data");
    public static final RString DEFAULT_事業所代表者氏名 = new RString("Data");
    public static final RString DEFAULT_事業所代表者氏名カナ = new RString("Data");
    public static final YubinNo DEFAULT_事業所代表者郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_事業所代表者住所 = new RString("Data");
    public static final RString DEFAULT_事業所代表者住所カナ = new RString("Data");
    public static final RString DEFAULT_事業所管理者氏名 = new RString("Data");
    public static final RString DEFAULT_事業所管理者氏名カナ = new RString("Data");
    public static final YubinNo DEFAULT_事業所管理者郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_事業所管理者住所 = new RString("Data");
    public static final RString DEFAULT_事業所管理者住所カナ = new RString("Data");
    public static final RString DEFAULT_サービス事業所名 = new RString("Data");
    public static final RString DEFAULT_サービス事業所名カナ = new RString("Data");
    public static final YubinNo DEFAULT_サービス事業所郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_サービス事業所住所 = new RString("Data");
    public static final RString DEFAULT_サービス事業所住所カナ = new RString("Data");
    public static final RString DEFAULT_サービス事業所電話番号 = new RString("Data");
    public static final RString DEFAULT_サービス事業所FAX番号 = new RString("Data");
    public static final FlexibleDate DEFAULT_サービス事業所事業開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_サービス事業所事業休止年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_サービス事業所事業廃止年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_サービス事業所事業再開年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_受領委任区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_市町村特別給付登録開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_市町村特別給付登録終了年月日 = new FlexibleDate("19900101");
    public static final boolean DEFAULT_生活保護法による指定の有 = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3065ShichosonTokubetsuKyufuJigyoshaEntityGenerator() {
    }

    public static DbT3065ShichosonTokubetsuKyufuJigyoshaEntity createDbT3065ShichosonTokubetsuKyufuJigyoshaEntity() {
        DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity = new DbT3065ShichosonTokubetsuKyufuJigyoshaEntity();
        entity.setJigyoshaNo(DEFAULT_市町村特別給付用事業者番号);
        entity.setServiceCode(DEFAULT_市町村特別給付用サービスコード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setIdoKubun(DEFAULT_介護国保連ＩＦ異動区分);
        entity.setIdoYMD(DEFAULT_介護国保連ＩＦ異動年月日);
        entity.setHojinShubetsu(DEFAULT_介護国保連ＩＦ法人種別);
        entity.setShinseishaNameKanji(DEFAULT_申請者氏名_漢字);
        entity.setShinseishaNameKana(DEFAULT_申請者氏名_カナ);
        entity.setShinseishaYubinNo(DEFAULT_申請者郵便番号);
        entity.setShinseishaAddressKanji(DEFAULT_申請者住所);
        entity.setShinseishaAddressKana(DEFAULT_申請者住所_カナ);
        entity.setShinseishaTelNo(DEFAULT_申請者電話番号);
        entity.setShinseishaFaxNo(DEFAULT_申請者FAX番号);
        entity.setJigyoshoDaihyoshaYakushoku(DEFAULT_事業所代表者役職);
        entity.setJigyoshoDaihyoshaNameKanji(DEFAULT_事業所代表者氏名);
        entity.setJigyoshoDaihyoshaNameKana(DEFAULT_事業所代表者氏名カナ);
        entity.setJigyoshoDaihyoshaYubinNo(DEFAULT_事業所代表者郵便番号);
        entity.setJigyoshoDaihyoshaAddressKanji(DEFAULT_事業所代表者住所);
        entity.setJigyoshoDaihyoshaAddressKana(DEFAULT_事業所代表者住所カナ);
        entity.setJigyoshoKanrishaNameKanji(DEFAULT_事業所管理者氏名);
        entity.setJigyoshoKanrishaNameKana(DEFAULT_事業所管理者氏名カナ);
        entity.setJigyoshoKanrishaYubinNo(DEFAULT_事業所管理者郵便番号);
        entity.setJigyoshoKanrishaAddressKanji(DEFAULT_事業所管理者住所);
        entity.setJigyoshoKanrishaAddressKana(DEFAULT_事業所管理者住所カナ);
        entity.setServiceJigyoshoNameKanji(DEFAULT_サービス事業所名);
        entity.setServiceJigyoshoNameKana(DEFAULT_サービス事業所名カナ);
        entity.setServiceJigyoshoYubinNo(DEFAULT_サービス事業所郵便番号);
        entity.setServiceJigyoshoAddressKanji(DEFAULT_サービス事業所住所);
        entity.setServiceJigyoshoAddressKana(DEFAULT_サービス事業所住所カナ);
        entity.setServiceJigyoshoTelNo(DEFAULT_サービス事業所電話番号);
        entity.setServiceJigyoshoFaxNo(DEFAULT_サービス事業所FAX番号);
        entity.setServiceJigyoshoJigyoKaisiYMD(DEFAULT_サービス事業所事業開始年月日);
        entity.setServiceJigyoshoJigyoKyushiYMD(DEFAULT_サービス事業所事業休止年月日);
        entity.setServiceJigyoshoJigyoHaishiYMD(DEFAULT_サービス事業所事業廃止年月日);
        entity.setServiceJigyoshoJigyoSaikaiYMD(DEFAULT_サービス事業所事業再開年月日);
        entity.setJuryoIninKubu(DEFAULT_受領委任区分);
        entity.setTorokuKaishiYMD(DEFAULT_市町村特別給付登録開始年月日);
        entity.setTorokuShuryoYMD(DEFAULT_市町村特別給付登録終了年月日);
        entity.setSeikatsuhogoShiteiFlag(DEFAULT_生活保護法による指定の有);
        return entity;
    }
}
