/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金強制返還エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("0212315"));
    public static final RString DEFAULT_貸付管理番号 = new RString("123");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_返還金区分 = new RString("1");
    public static final Decimal DEFAULT_返還金額 = new Decimal(10000);
    public static final FlexibleDate DEFAULT_返還期限 = new FlexibleDate("20140402");
    public static final RString DEFAULT_返還理由 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityGenerator() {
    }

    public static DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity createDbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity() {
        DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity = new DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKashitsukeKanriNo(DEFAULT_貸付管理番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setHenkanKinKubun(DEFAULT_返還金区分);
        entity.setHenkanKingaku(DEFAULT_返還金額);
        entity.setHenkanKigenYMD(DEFAULT_返還期限);
        entity.setHenkanRiyu(DEFAULT_返還理由);
        return entity;
    }
}
