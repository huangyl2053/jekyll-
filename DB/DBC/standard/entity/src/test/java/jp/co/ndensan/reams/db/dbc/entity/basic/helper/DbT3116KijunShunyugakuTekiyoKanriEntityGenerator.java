/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 基準収入額適用管理エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3116KijunShunyugakuTekiyoKanriEntityGenerator {

    public static final SetaiCode DEFAULT_世帯コード = new SetaiCode("012340123400001");
    public static final FlexibleYear DEFAULT_年度 = new FlexibleYear("1990");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final HokenshaNo DEFAULT_被保険者番号 = new HokenshaNo("1");
    public static final Decimal DEFAULT_公的年金収入額 = new Decimal(0);
    public static final Decimal DEFAULT_給与収入額 = new Decimal(0);
    public static final Decimal DEFAULT_その他の収入額 = new Decimal(0);
    public static final Decimal DEFAULT_算定基準額 = new Decimal(0);
    public static final FlexibleYearMonth DEFAULT_適用開始年月 = new FlexibleYearMonth("199001");
    public static final FlexibleDate DEFAULT_申請日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_決定日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_申請書作成日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_申請書作成の世帯基準日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_決定通知書発行日 = new FlexibleDate("19900101");
    public static final boolean DEFAULT_宛先印字対象者フラグ = false;
    public static final Decimal DEFAULT_年少扶養控除_16歳未満_人数 = new Decimal(0);
    public static final Decimal DEFAULT_年少扶養控除_16_18歳未満_人数 = new Decimal(0);
    public static final Decimal DEFAULT_世帯員の総収入額 = new Decimal(0);
    public static final boolean DEFAULT_世帯主フラグ = false;
    public static final Decimal DEFAULT_課税所得額 = new Decimal(0);
    public static final Decimal DEFAULT_課税所得額_控除後 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3116KijunShunyugakuTekiyoKanriEntityGenerator() {
    }

    public static DbT3116KijunShunyugakuTekiyoKanriEntity createDbT3116KijunShunyugakuTekiyoKanriEntity() {
        DbT3116KijunShunyugakuTekiyoKanriEntity entity = new DbT3116KijunShunyugakuTekiyoKanriEntity();
        entity.setSetaiCode(DEFAULT_世帯コード);
        entity.setNendo(DEFAULT_年度);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKotekiNenkinShunyugaku(DEFAULT_公的年金収入額);
        entity.setKyuyoShunyugaku(DEFAULT_給与収入額);
        entity.setSonotaShunyugaku(DEFAULT_その他の収入額);
        entity.setSanteiKijungaku(DEFAULT_算定基準額);
        entity.setTekiyoKaishiYMD(DEFAULT_適用開始年月);
        entity.setShinseiYMD(DEFAULT_申請日);
        entity.setKetteiYMD(DEFAULT_決定日);
        entity.setShinseishoSakuseiYMD(DEFAULT_申請書作成日);
        entity.setShinseishoSakuseiSetaiKijunYMD(DEFAULT_申請書作成の世帯基準日);
        entity.setKetteiTsuchishoHakkoYMD(DEFAULT_決定通知書発行日);
        entity.setAtesakiInjiTaishoshaFlag(DEFAULT_宛先印字対象者フラグ);
        entity.setNenshoFuyokojoUnder16Ninzu(DEFAULT_年少扶養控除_16歳未満_人数);
        entity.setNenshoFuyokojoOver16Ninzu(DEFAULT_年少扶養控除_16_18歳未満_人数);
        entity.setSetaiinSoShunyugaku(DEFAULT_世帯員の総収入額);
        entity.setSetainushiFlag(DEFAULT_世帯主フラグ);
        entity.setKazeiShotokugaku(DEFAULT_課税所得額);
        entity.setKazeiShotokugakuKojogo(DEFAULT_課税所得額_控除後);
        return entity;
    }
}
