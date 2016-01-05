/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

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
 * 受領委任契約事業者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3077JuryoininKeiyakuJigyoshaEntityGenerator {

    public static final RString DEFAULT_契約事業者番号 = new RString("Data");
    public static final FlexibleDate DEFAULT_開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_契約種類 = new RString("Data");
    public static final AtenaMeisho DEFAULT_契約事業者名称 = new AtenaMeisho("Data");
    public static final AtenaKanaMeisho DEFAULT_契約事業者カナ名称 = new AtenaKanaMeisho("Data");
    public static final YubinNo DEFAULT_契約事業者郵便番号 = new YubinNo("123456");
    public static final AtenaJusho DEFAULT_契約事業者住所 = new AtenaJusho("Data");
    public static final AtenaMeisho DEFAULT_契約代表者氏名 = new AtenaMeisho("Data");
    public static final TelNo DEFAULT_契約事業者電話番号 = new TelNo("08011112222");
    public static final TelNo DEFAULT_契約事業者FAX番号 = new TelNo("08011112222");
    public static final YubinNo DEFAULT_送付先郵便番号 = new YubinNo("123456");
    public static final AtenaJusho DEFAULT_送付先住所 = new AtenaJusho("Data");
    public static final RString DEFAULT_送付先部署 = new RString("Data");
    public static final AtenaMeisho DEFAULT_送付先事業者名称 = new AtenaMeisho("Data");
    public static final AtenaKanaMeisho DEFAULT_送付先事業者カナ名称 = new AtenaKanaMeisho("Data");
    public static final KinyuKikanCode DEFAULT_金融機関コード = new KinyuKikanCode("0001");
    public static final KinyuKikanShitenCode DEFAULT_支店コード = new KinyuKikanShitenCode("001");
    public static final RString DEFAULT_口座種別 = new RString("Data");
    public static final RString DEFAULT_口座番号 = new RString("Data");
    public static final AtenaMeisho DEFAULT_口座名義人 = new AtenaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_口座名義人カナ = new AtenaKanaMeisho("");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3077JuryoininKeiyakuJigyoshaEntityGenerator() {
    }

    public static DbT3077JuryoininKeiyakuJigyoshaEntity createDbT3077JuryoininKeiyakuJigyoshaEntity() {
        DbT3077JuryoininKeiyakuJigyoshaEntity entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
        entity.setKeiyakuJigyoshaNo(DEFAULT_契約事業者番号);
        entity.setKaishiYMD(DEFAULT_開始年月日);
        entity.setShuryoYMD(DEFAULT_終了年月日);
        entity.setKeiyakuShurui(DEFAULT_契約種類);
        entity.setKeiyakuJigyoshaName(DEFAULT_契約事業者名称);
        entity.setKeiyakuJigyoshaKanaName(DEFAULT_契約事業者カナ名称);
        entity.setKeiyakuJigyoshaYubinNo(DEFAULT_契約事業者郵便番号);
        entity.setKeiyakuJigyoshaJusho(DEFAULT_契約事業者住所);
        entity.setKeiyakuJigyoshaTelNo(DEFAULT_契約事業者電話番号);
        entity.setKeiyakuJigyoshaFaxNo(DEFAULT_契約事業者FAX番号);
        entity.setSofusakiYubinNo(DEFAULT_送付先郵便番号);
        entity.setSofusakiJusho(DEFAULT_送付先住所);
        entity.setSofusakiBusho(DEFAULT_送付先部署);
        entity.setSofusakiJigyoshaName(DEFAULT_送付先事業者名称);
        entity.setSofusakiJigyoshaKanaName(DEFAULT_送付先事業者カナ名称);
        entity.setKinyuKikanCode(DEFAULT_金融機関コード);
        entity.setShitenCode(DEFAULT_支店コード);
        entity.setKozaShubetsu(DEFAULT_口座種別);
        entity.setKozaNo(DEFAULT_口座番号);
        entity.setKozaMeiginin(DEFAULT_口座名義人);
        entity.setKozaMeigininKana(DEFAULT_口座名義人カナ);
        return entity;
    }
}
