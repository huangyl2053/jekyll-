/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 共同処理用受給者異動基本送付エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator {

    public static final FlexibleDate DEFAULT_異動年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_異動区分コード = new RString("Data");
    public static final RString DEFAULT_受給者異動事由 = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_被保険者氏名 = new RString("Data");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_住所カナ = new RString("Data");
    public static final RString DEFAULT_住所 = new RString("Data");
    public static final TelNo DEFAULT_電話番号 = new TelNo("08011112222");
    public static final RString DEFAULT_帳票出力順序コード = new RString("Data");
    public static final boolean DEFAULT_訂正連絡票フラグ = false;
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYear("1990");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator() {
    }

    public static DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity createDbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity() {
        DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity = new DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity();
        entity.setIdoYMD(DEFAULT_異動年月日);
        entity.setIdoKubunCode(DEFAULT_異動区分コード);
        entity.setJukyushaIdoJiyu(DEFAULT_受給者異動事由);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setHiHokenshaName(DEFAULT_被保険者氏名);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setDdressKana(DEFAULT_住所カナ);
        entity.setAddress(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setChohyoOutputJunjyoCode(DEFAULT_帳票出力順序コード);
        entity.setTeiseiRenrakuhyoFlag(DEFAULT_訂正連絡票フラグ);
        entity.setSofuYM(DEFAULT_送付年月);
        return entity;
    }
}
