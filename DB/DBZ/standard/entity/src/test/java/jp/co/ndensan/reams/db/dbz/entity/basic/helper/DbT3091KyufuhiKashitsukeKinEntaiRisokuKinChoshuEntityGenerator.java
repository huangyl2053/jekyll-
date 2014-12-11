/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金延滞利息金徴収エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final RString DEFAULT_貸付管理番号 = new RString("123");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_延滞利息金徴収年月日 = new FlexibleDate("20140402");
    public static final Decimal DEFAULT_延滞利息徴収金額 = new Decimal(10000);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntityGenerator() {
    }

    public static DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity createDbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity() {
        DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity entity = new DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKashitsukeKanriNo(DEFAULT_貸付管理番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setEntaiRisokuKinChoshuYMD(DEFAULT_延滞利息金徴収年月日);
        entity.setEntaiRisokuChoshuKingaku(DEFAULT_延滞利息徴収金額);
        return entity;
    }
}
