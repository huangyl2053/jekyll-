/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給判定結果エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3036ShokanHanteiKekkaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth("199001");
    public static final RString DEFAULT_整理番号 = new RString("Data");
    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("1");
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_支給_不支給決定区分 = new RString("Data");
    public static final Decimal DEFAULT_支払金額 = new Decimal(0);
    public static final Decimal DEFAULT_支払金額内訳_利用者分 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_決定一覧取込年月 = new FlexibleYearMonth("199001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3036ShokanHanteiKekkaEntityGenerator() {
    }

    public static DbT3036ShokanHanteiKekkaEntity createDbT3036ShokanHanteiKekkaEntity() {
        DbT3036ShokanHanteiKekkaEntity entity = new DbT3036ShokanHanteiKekkaEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setShikyuHushikyuKetteiKubun(DEFAULT_支給_不支給決定区分);
        entity.setShiharaiKingaku(DEFAULT_支払金額);
        entity.setShiharaiKingakuUchiwakeRiyoshabun(DEFAULT_支払金額内訳_利用者分);
        entity.setKetteiIchiranTorikomiYM(DEFAULT_決定一覧取込年月);
        return entity;
    }
}
