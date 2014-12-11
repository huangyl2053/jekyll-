/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金延滞利息計算エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final RString DEFAULT_貸付管理番号 = new RString("123");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_貸付金延滞日数 = new RString("123");
    public static final Decimal DEFAULT_貸付金延滞利息金額 = new Decimal(10000);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator() {
    }

    public static DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity() {
        DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity = new DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKashitsukeKanriNo(DEFAULT_貸付管理番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setEntaiNissu(DEFAULT_貸付金延滞日数);
        entity.setEntaiRisokuKingaku(DEFAULT_貸付金延滞利息金額);
        return entity;
    }
}
