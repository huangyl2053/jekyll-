/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金延滞利息計算エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final RString DEFAULT_貸付管理番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_貸付金延滞日数 = new RString("Data");
    public static final Decimal DEFAULT_貸付金延滞利息金額 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityGenerator() {
    }

    public static DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity createDbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity() {
        DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity = new DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKashitsukeKanriNo(DEFAULT_貸付管理番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setEntaiNissu(DEFAULT_貸付金延滞日数);
        entity.setEntaiRisokuKingaku(DEFAULT_貸付金延滞利息金額);
        return entity;
    }
}
