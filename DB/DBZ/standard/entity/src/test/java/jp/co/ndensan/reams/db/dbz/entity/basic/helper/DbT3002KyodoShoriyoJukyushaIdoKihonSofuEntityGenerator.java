/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者異動基本送付エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntityGenerator {

    public static final FlexibleDate DEFAULT_異動年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_異動区分コード = new RString("1");
    public static final RString DEFAULT_受給者異動事由 = new RString("1");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_被保険者氏名 = new RString("1");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo(new RString("123-1234"));
    public static final RString DEFAULT_住所カナ = new RString("1");
    public static final RString DEFAULT_住所 = new RString("1");
    public static final TelNo DEFAULT_電話番号 = new TelNo("012-345-6789");
    public static final RString DEFAULT_帳票出力順序コード = new RString("1");
    public static final boolean DEFAULT_訂正連絡票フラグ = false;
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYearMonth(new RString("201406"));

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
        entity.setShoriTimestamp(DEFAULT_処理日時);
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
