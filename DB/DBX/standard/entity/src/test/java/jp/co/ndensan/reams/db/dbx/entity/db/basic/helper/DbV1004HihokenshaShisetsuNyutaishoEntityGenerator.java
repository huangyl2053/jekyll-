/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
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
 * 被保険者施設入退所Aliveエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbV1004HihokenshaShisetsuNyutaishoEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("209007");
    public static final RString DEFAULT_台帳種別 = new RString("Data");
    public static final RString DEFAULT_入所施設種類 = new RString("Data");
    public static final KaigoJigyoshaNo DEFAULT_入所施設コード = new KaigoJigyoshaNo("0123400001");
    public static final FlexibleDate DEFAULT_入所年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_退所年月日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbV1004HihokenshaShisetsuNyutaishoEntityGenerator() {
    }

    public static DbV1004HihokenshaShisetsuNyutaishoEntity createDbV1004HihokenshaShisetsuNyutaishoEntity() {
        DbV1004HihokenshaShisetsuNyutaishoEntity entity = new DbV1004HihokenshaShisetsuNyutaishoEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setDaichoShubetsu(DEFAULT_台帳種別);
        entity.setNyushoShisetsuShurui(DEFAULT_入所施設種類);
        entity.setNyushoShisetsuCode(DEFAULT_入所施設コード);
        entity.setNyushoYMD(DEFAULT_入所年月日);
        entity.setTaishoYMD(DEFAULT_退所年月日);
        return entity;
    }
}
