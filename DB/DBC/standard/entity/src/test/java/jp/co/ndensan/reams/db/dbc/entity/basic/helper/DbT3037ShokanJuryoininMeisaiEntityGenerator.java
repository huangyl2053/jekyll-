/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3037ShokanJuryoininMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給受領委任払明細エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3037ShokanJuryoininMeisaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_契約番号 = new RString("Data");
    public static final Decimal DEFAULT_支払金額 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3037ShokanJuryoininMeisaiEntityGenerator() {
    }

    public static DbT3037ShokanJuryoininMeisaiEntity createDbT3037ShokanJuryoininMeisaiEntity() {
        DbT3037ShokanJuryoininMeisaiEntity entity = new DbT3037ShokanJuryoininMeisaiEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKeiyakuNo(DEFAULT_契約番号);
        entity.setShiharaiKingaku(DEFAULT_支払金額);
        return entity;
    }
}
