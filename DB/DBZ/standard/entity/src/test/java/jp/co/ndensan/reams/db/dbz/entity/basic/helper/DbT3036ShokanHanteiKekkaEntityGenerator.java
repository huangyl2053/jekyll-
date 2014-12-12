/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給判定結果エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3036ShokanHanteiKekkaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_支給_不支給決定区分 = new RString("1");
    public static final Decimal DEFAULT_支払金額 = new Decimal(1);
    public static final Decimal DEFAULT_支払金額内訳_利用者分 = new Decimal(1);
    public static final RString DEFAULT_支払方法区分 = new RString("1");
    public static final RString DEFAULT_支払場所 = new RString("1");
    public static final FlexibleDate DEFAULT_支払期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_支払期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_閉庁内容 = new RString("1");
    public static final RTime DEFAULT_支払窓口開始時間 = RTime.of(10, 10, 001);
    public static final RTime DEFAULT_支払窓口終了時間 = RTime.of(10, 10, 051);
    public static final FlexibleYearMonth DEFAULT_決定一覧取込年月 = new FlexibleYearMonth(new RString("201406"));

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
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setShikyuHushikyuKetteiKubun(DEFAULT_支給_不支給決定区分);
        entity.setShiharaiKingaku(DEFAULT_支払金額);
        entity.setShiharaiKingakuUchiwakeRiyoshabun(DEFAULT_支払金額内訳_利用者分);
        entity.setShiharaiHohoKubun(DEFAULT_支払方法区分);
        entity.setShiharaiBasho(DEFAULT_支払場所);
        entity.setShiharaiKikanKaishiYMD(DEFAULT_支払期間開始年月日);
        entity.setShiharaiKikanShuryoYMD(DEFAULT_支払期間終了年月日);
        entity.setKaichoNaiyo(DEFAULT_閉庁内容);
        entity.setShiharaiMadoguchiKaishiTime(DEFAULT_支払窓口開始時間);
        entity.setShiharaiMadoguchiShuryoTime(DEFAULT_支払窓口終了時間);
        entity.setKetteiIchiranTorikomiYM(DEFAULT_決定一覧取込年月);
        return entity;
    }
}
