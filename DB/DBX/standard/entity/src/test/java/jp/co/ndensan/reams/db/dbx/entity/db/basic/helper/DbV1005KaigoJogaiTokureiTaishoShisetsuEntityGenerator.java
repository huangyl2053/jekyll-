/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
 * 他市町村住所地特例者台帳管理Aliveエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator {

    public static final RString DEFAULT_事業者種別 = new RString("Data");
    public static final RString DEFAULT_事業者番号 = new RString("Data");
    public static final FlexibleDate DEFAULT_有効開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_有効終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_管内管外区分 = new RString("Data");
    public static final AtenaMeisho DEFAULT_事業者名称 = new AtenaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_事業者名称カナ = new AtenaKanaMeisho("");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_事業者住所 = new RString("Data");
    public static final RString DEFAULT_事業者住所カナ = new RString("Data");
    public static final TelNo DEFAULT_電話番号 = new TelNo("08011112222");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("08011112222");
    public static final RString DEFAULT_異動事由 = new RString("Data");
    public static final FlexibleDate DEFAULT_異動年月日 = new FlexibleDate("19900101");
    public static final AtenaMeisho DEFAULT_代表者名称 = new AtenaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_代表者名称カナ = new AtenaKanaMeisho("");
    public static final RString DEFAULT_役職 = new RString("Data");
    public static final RString DEFAULT_備考 = new RString("Data");
    public static final FlexibleDate DEFAULT_事業開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_事業休止年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_事業廃止年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_事業再開年月日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbV1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator() {
    }

    public static DbV1005KaigoJogaiTokureiTaishoShisetsuEntity createDbV1005KaigoJogaiTokureiTaishoShisetsuEntity() {
        DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity = new DbV1005KaigoJogaiTokureiTaishoShisetsuEntity();
        entity.setJigyoshaShubetsu(DEFAULT_事業者種別);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYukoKaishiYMD(DEFAULT_有効開始年月日);
        entity.setYukoShuryoYMD(DEFAULT_有効終了年月日);
        entity.setKannaiKangaiKubun(DEFAULT_管内管外区分);
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
