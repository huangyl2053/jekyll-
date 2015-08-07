/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity;
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
 * 給付費貸付金強制返還エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final RString DEFAULT_貸付管理番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_返還金区分 = new RString("Data");
    public static final Decimal DEFAULT_返還金額 = new Decimal(0);
    public static final FlexibleDate DEFAULT_返還期限 = new FlexibleDate("19900101");
    public static final RString DEFAULT_返還理由 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator() {
    }

    public static DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity createDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity() {
        DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity = new DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKashitsukeKanriNo(DEFAULT_貸付管理番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setHenkanKinKubun(DEFAULT_返還金区分);
        entity.setHenkanKingaku(DEFAULT_返還金額);
        entity.setHenkanKigenYMD(DEFAULT_返還期限);
        entity.setHenkanRiyu(DEFAULT_返還理由);
        return entity;
    }
}
