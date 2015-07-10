/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護除外住所地特例対象施設エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator {

    public static final RString DEFAULT_事業者種別 = new RString("1");
    public static final RString DEFAULT_事業者番号 = new RString("1");
    public static final FlexibleDate DEFAULT_有効開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_有効終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_管内_管外区分 = new RString("1");
    public static final AtenaMeisho DEFAULT_事業者名称 = new AtenaMeisho("電算太郎");
    public static final AtenaKanaMeisho DEFAULT_事業者名称カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo(new RString("123-1234"));
    public static final RString DEFAULT_事業者住所 = new RString("1");
    public static final RString DEFAULT_事業者住所カナ = new RString("1");
    public static final TelNo DEFAULT_電話番号 = new TelNo("012-345-6789");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("012-345-6789");
    public static final RString DEFAULT_異動事由 = new RString("1");
    public static final FlexibleDate DEFAULT_異動年月日 = new FlexibleDate("20140402");
    public static final AtenaMeisho DEFAULT_代表者名称 = new AtenaMeisho("電算太郎");
    public static final AtenaKanaMeisho DEFAULT_代表者名称カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final RString DEFAULT_役職 = new RString("1");
    public static final RString DEFAULT_備考 = new RString("1");
    public static final FlexibleDate DEFAULT_事業開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_事業休止年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_事業廃止年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_事業再開年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator() {
    }

    public static DbT1005KaigoJogaiTokureiTaishoShisetsuEntity createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity() {
        DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = new DbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
        entity.setJigyoshaShubetsu(DEFAULT_事業者種別);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYukoKaishiYMD(DEFAULT_有効開始年月日);
        entity.setYukoShuryoYMD(DEFAULT_有効終了年月日);
        entity.setKannaiKangaiKubun(DEFAULT_管内_管外区分);
        entity.setJigyoshaMeisho(DEFAULT_事業者名称);
        entity.setJigyoshaKanaMeisho(DEFAULT_事業者名称カナ);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJigyoshaJusho(DEFAULT_事業者住所);
        entity.setJigyoshaKanaJusho(DEFAULT_事業者住所カナ);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        entity.setIdoJiyuCode(DEFAULT_異動事由);
        entity.setIdoYMD(DEFAULT_異動年月日);
        entity.setDaihyoshaMeisho(DEFAULT_代表者名称);
        entity.setDaihyoshaKanaMeisho(DEFAULT_代表者名称カナ);
        entity.setYakushoku(DEFAULT_役職);
        entity.setBiko(DEFAULT_備考);
        entity.setJigyoKaishiYMD(DEFAULT_事業開始年月日);
        entity.setJigyoKyushiYMD(DEFAULT_事業休止年月日);
        entity.setJigyoHaishiYMD(DEFAULT_事業廃止年月日);
        entity.setJigyoSaikaiYMD(DEFAULT_事業再開年月日);
        return entity;
    }
}
