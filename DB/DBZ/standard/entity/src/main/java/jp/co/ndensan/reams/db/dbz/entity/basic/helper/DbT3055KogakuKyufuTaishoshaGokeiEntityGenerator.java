/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費給付対象者合計エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator {

    /**
     * 被保険者番号のデフォルト値です。
     */
    public static final HihokenshaNo DEFAULT_被保険者番号;
    /**
     * サービス提供年月のデフォルト値です。
     */
    public static final FlexibleYearMonth DEFAULT_サービス提供年月;
    /**
     * 履歴番号のデフォルト値です。
     */
    public static final Decimal DEFAULT_履歴番号;
    /**
     * サービス費用合計額合計のデフォルト値です。
     */
    public static final Decimal DEFAULT_サービス費用合計額合計;
    /**
     * 利用者負担額合計のデフォルト値です。
     */
    public static final Decimal DEFAULT_利用者負担額合計;
    /**
     * 算定基準額のデフォルト値です。
     */
    public static final Decimal DEFAULT_算定基準額;
    /**
     * 支払済金額合計のデフォルト値です。
     */
    public static final Decimal DEFAULT_支払済金額合計;
    /**
     * 高額支給額のデフォルト値です。
     */
    public static final Decimal DEFAULT_高額支給額;
    /**
     * 対象者受取年月のデフォルト値です。
     */
    public static final FlexibleYearMonth DEFAULT_対象者受取年月;
    /**
     * 対象者判定審査年月のデフォルト値です。
     */
    public static final FlexibleYearMonth DEFAULT_対象者判定審査年月;
    /**
     * 世帯集約番号のデフォルト値です。
     */
    public static final RString DEFAULT_世帯集約番号;
    /**
     * 境界層対象者フラグのデフォルト値です。
     */
    public static final boolean DEFAULT_境界層対象者フラグ;
    /**
     * 社会福祉法人軽減対象フラグのデフォルト値です。
     */
    public static final boolean DEFAULT_社会福祉法人軽減対象フラグ;
    /**
     * 高額対象外フラグのデフォルト値です。
     */
    public static final boolean DEFAULT_高額対象外フラグ;
    /**
     * 自動償還対象フラグのデフォルト値です。
     */
    public static final boolean DEFAULT_自動償還対象フラグ;

    static {
        DEFAULT_被保険者番号 = new HihokenshaNo("0000000273");
        DEFAULT_サービス提供年月 = new FlexibleYearMonth("201103");
        DEFAULT_履歴番号 = new Decimal(0);
        DEFAULT_サービス費用合計額合計 = new Decimal(0);
        DEFAULT_利用者負担額合計 = new Decimal(0);
        DEFAULT_算定基準額 = new Decimal(0);
        DEFAULT_支払済金額合計 = new Decimal(0);
        DEFAULT_高額支給額 = new Decimal(0);
        DEFAULT_対象者受取年月 = new FlexibleYearMonth("199001");
        DEFAULT_対象者判定審査年月 = new FlexibleYearMonth("199001");
        DEFAULT_世帯集約番号 = new RString("Data");
        DEFAULT_境界層対象者フラグ = false;
        DEFAULT_社会福祉法人軽減対象フラグ = false;
        DEFAULT_高額対象外フラグ = false;
        DEFAULT_自動償還対象フラグ = false;
    }

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3055KogakuKyufuTaishoshaGokeiEntityGenerator() {
    }

    /**
     * テスト用の{@link DbT3055KogakuKyufuTaishoshaGokeiEntity}を生成します。
     *
     * @return テスト用の{@link DbT3055KogakuKyufuTaishoshaGokeiEntity}
     */
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
