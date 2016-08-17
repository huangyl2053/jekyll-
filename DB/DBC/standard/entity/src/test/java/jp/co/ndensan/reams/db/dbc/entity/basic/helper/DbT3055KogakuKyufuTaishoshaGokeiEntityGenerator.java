/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費給付対象者合計エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final Decimal DEFAULT_サービス費用合計額合計 = new Decimal(0);
    public static final Decimal DEFAULT_利用者負担額合計 = new Decimal(0);
    public static final Decimal DEFAULT_算定基準額 = new Decimal(0);
    public static final Decimal DEFAULT_支払済金額合計 = new Decimal(0);
    public static final Decimal DEFAULT_高額支給額 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_対象者受取年月 = new FlexibleYearMonth("199001");
    public static final FlexibleYearMonth DEFAULT_対象者判定審査年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_世帯集約番号 = new RString("Data");
    public static final boolean DEFAULT_境界層対象者フラグ = false;
    public static final boolean DEFAULT_社会福祉法人軽減対象フラグ = false;
    public static final boolean DEFAULT_高額対象外フラグ = false;
    public static final boolean DEFAULT_自動償還対象フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator() {
    }

    public static DbT3055KogakuKyufuTaishoshaGokeiEntity createDbT3055KogakuKyufuTaishoshaGokeiEntity() {
        DbT3055KogakuKyufuTaishoshaGokeiEntity entity = new DbT3055KogakuKyufuTaishoshaGokeiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setServiceHiyoGokeiGakuGokei(DEFAULT_サービス費用合計額合計);
        entity.setRiyoshaFutanGakuGokei(DEFAULT_利用者負担額合計);
        entity.setSanteiKijunGaku(DEFAULT_算定基準額);
        entity.setShiharaiSumiKingakuGokei(DEFAULT_支払済金額合計);
        entity.setKogakuShikyuGaku(DEFAULT_高額支給額);
        entity.setTashoshaUketoriYM(DEFAULT_対象者受取年月);
        entity.setTaishoshaHanteiShinsaYM(DEFAULT_対象者判定審査年月);
        entity.setSetaiShuyakuNo(DEFAULT_世帯集約番号);
        entity.setKyokaisoTaishoshaFlag(DEFAULT_境界層対象者フラグ);
        entity.setHojinKeigenTaishoFlag(DEFAULT_社会福祉法人軽減対象フラグ);
        entity.setKogakuTaishoGaiFlag(DEFAULT_高額対象外フラグ);
        entity.setJidoShokanTaishoFlag(DEFAULT_自動償還対象フラグ);
        return entity;
    }
}
