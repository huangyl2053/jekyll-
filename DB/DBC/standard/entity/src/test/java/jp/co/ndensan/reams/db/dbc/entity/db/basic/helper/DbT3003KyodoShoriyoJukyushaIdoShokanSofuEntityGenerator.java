/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
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
 * 共同処理用受給者異動償還送付エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator {

    public static final FlexibleDate DEFAULT_異動年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_異動区分コード = new RString("Data");
    public static final RString DEFAULT_受給者異動事由 = new RString("Data");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo();
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final FlexibleDate DEFAULT_保険給付支払一時差止開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_保険給付支払一時差止終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_保険給付支払一時差止区分コード = new RString("Data");
    public static final Decimal DEFAULT_保険給付支払一時差止金額 = new Decimal(0);
    public static final boolean DEFAULT_訂正連絡票フラグ = false;
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYear("1990");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntityGenerator() {
    }

    public static DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity createDbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity() {
        DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity = new DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity();
        entity.setIdoYMD(DEFAULT_異動年月日);
        entity.setIdoKubunCode(DEFAULT_異動区分コード);
        entity.setJukyushaIdoJiyu(DEFAULT_受給者異動事由);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setHokenKyufuIchijiSashitomeKaishiYMD(DEFAULT_保険給付支払一時差止開始年月日);
        entity.setHokenKyufuIchijiSashitomeShuryoYMD(DEFAULT_保険給付支払一時差止終了年月日);
        entity.setHokenkyufuIchijiSashitomeKubunCode(DEFAULT_保険給付支払一時差止区分コード);
        entity.setHokenkyufuIchijiSashitomeKingaku(DEFAULT_保険給付支払一時差止金額);
        entity.setTeiseiRenrakuhyoFlag(DEFAULT_訂正連絡票フラグ);
        entity.setSofuYM(DEFAULT_送付年月);
        return entity;
    }
}
