/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyosokatsuhyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyosokatsuhyo.KyufuKanrihyoSokatsuhyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufukanrihyosokatsuhyo.KyufuKanrihyoSokatsuhyoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付管理票総括票のEditorです。
 *
 * @reamsid_L DBC-2840-042 kanghongsong
 */
public class KyufuKanrihyoSokatsuhyoEditor implements IKyufuKanrihyoSokatsuhyoEditor {

    private static final RString 給付管理票タイトル1 = new RString("居宅サービス給付管理票");
    private static final RString 給付管理票タイトル2 = new RString("居宅サービス・介護予防サービス・総合事業区分給付管理票");
    private static final RString 枚数_件数 = new RString("0");
    private static final int 桁数 = 6;
    
    private final KyufuKanrihyoSokatsuhyoEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KyufuKanrihyoSokatsuhyoEntity item}
     */
    protected KyufuKanrihyoSokatsuhyoEditor(KyufuKanrihyoSokatsuhyoEntity item) {
        this.item = item;
    }

    @Override
    public KyufuKanrihyoSokatsuhyoReportSource edit(KyufuKanrihyoSokatsuhyoReportSource source) {
        return editSource(source);
    }

    private KyufuKanrihyoSokatsuhyoReportSource editSource(KyufuKanrihyoSokatsuhyoReportSource source) {
        source.teishutsuYM = パターン56(item.get処理年月());
        
        source.hokenshaNo = item.get保険者番号();
        FlexibleYearMonth 制度改正施行年月 = new FlexibleYearMonth(DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_支給限度額一本化,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substring(0, 桁数));
        FlexibleYearMonth 制度改正施行管理年月 = new FlexibleYearMonth(DbBusinessConfig.get(ConfigNameDBU.制度改正施行管理_新総合事業_適用開始日,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substring(0, 桁数));
        if (item.get処理年月().isBefore(制度改正施行年月)) {
            source.kyufuKanrihyoTitle = new RString("");
        } else if (item.get処理年月().isBefore(制度改正施行管理年月)) {
            source.kyufuKanrihyoTitle = 給付管理票タイトル1;
        } else {
            source.kyufuKanrihyoTitle = 給付管理票タイトル2;
        }
        source.takenHomonShinkiMaisu = 枚数_件数;
        source.takenHomonShinkiKensu = 枚数_件数;
        source.takenHomonShuseiMaisu = 枚数_件数;
        source.takenHomonShuseiKensu = 枚数_件数;
        source.takenHomonTorikeshiMaisu = 枚数_件数;
        source.takenHomonTorikeshiKensu = 枚数_件数;
        source.takenTankiShinkiMaisu = 枚数_件数;
        source.takenTankiShinkiKensu = 枚数_件数;
        source.takenTankiShuseiMaisu = 枚数_件数;
        source.takenTankiShuseiKensu = 枚数_件数;
        source.takenTankiTorikeshiMaisu = 枚数_件数;
        source.takenTankiTorikeshiKensu = 枚数_件数;
        source.jikenHomonShinkiMaisu = get共通ポリシー金額1(item.get自県分_訪問_新規分_枚数());
        source.jikenHomonShinkiKensu = get共通ポリシー金額1(item.get自県分_訪問_新規分_件数());
        source.jikenHomonShuseiMaisu = get共通ポリシー金額1(item.get自県分_訪問_修正分_枚数());
        source.jikenHomonShuseiKensu = get共通ポリシー金額1(item.get自県分_訪問_修正分_件数());
        source.jikenHomonTorikeshiMaisu = get共通ポリシー金額1(item.get自県分_訪問_取消分_枚数());
        source.jikenHomonTorikeshiKensu = get共通ポリシー金額1(item.get自県分_訪問_取消分_件数());
        source.jikenTankiShinkiMaisu = get共通ポリシー金額1(item.get自県分_短期_新規分_枚数());
        source.jikenTankiShinkiKensu = get共通ポリシー金額1(item.get自県分_短期_新規分_件数());
        source.jikenTankiShuseiMaisu = get共通ポリシー金額1(item.get自県分_短期_修正分_枚数());
        source.jikenTankiShuseiKensu = get共通ポリシー金額1(item.get自県分_短期_修正分_件数());
        source.jikenTankiTorikeshiMaisu = get共通ポリシー金額1(item.get自県分_短期_取消分_枚数());
        source.jikenTankiTorikeshiKensu = get共通ポリシー金額1(item.get自県分_短期_取消分_件数());
        return source;
    }

    private RString パターン56(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
    
    private RString get共通ポリシー金額1(Decimal 金額) {
        if (null == 金額) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(金額, 0);
    }

}
