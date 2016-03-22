/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kagoketteikohifutanshain;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain.KagoKetteiKohifutanshaInItem;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoKetteiKohifutanshaInEntity;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 過誤決定通知書情報取込一覧表（公費負担者分）帳票データ作成です。
 */
public class KagoKetteiTsuchishoJohoTorikomiIchiranhyoKouhiFutanshabun {

    private static final RString PAGECOUNT_1 = new RString("1");
    private static final RString DATA_NASHI = new RString("該当データなし");
    private static final RString TITLE_KENSU = new RString("件数");
    private static final RString TITLE_TANISU = new RString("単位数");
    private static final RString TITLE_FUTANGAKU = new RString("公費負担額");
    private static final RString TITLE_KYUFUHI = new RString("介護給付費");
    private static final RString TITLE_SERVICEHI = new RString("高額介護サービス費");
    private static final RString TITLE_SHOKUJIHI = new RString("特定入所者介護等費");
    private static final RString STRING_BUN = new RString("分");
    private static final RString STRING_SAKUSEI = new RString("作成");

    private RString 印刷日時;
    private RString 処理年月分;

    /**
     * バッチで作成した帳票Entityリストより、過誤決定通知書情報取込一覧表（公費負担者分）帳票データを作成する
     *
     * @param 処理年月 処理年月
     * @param 並び順の１件目 並び順の１件目
     * @param 並び順の２件目 並び順の２件目
     * @param 並び順の３件目 並び順の３件目
     * @param 並び順の４件目 並び順の４件目
     * @param 並び順の５件目 並び順の５件目
     * @param 改頁 改頁
     * @param 過誤決定通知書情報取込一覧表リスト 過誤決定通知書情報取込一覧表リスト
     * @return List<KagoKetteiKohifutanshaInItem> 過誤決定通知書情報取込一覧表（公費負担者分）帳票出力用リスト
     */
    public List<KagoKetteiKohifutanshaInItem> createKagoKetteiTsuchishoJohoTorikomiIchiranhyoKouhiFutanshabun(
            FlexibleYearMonth 処理年月,
            RString 並び順の１件目,
            RString 並び順の２件目,
            RString 並び順の３件目,
            RString 並び順の４件目,
            RString 並び順の５件目,
            RString 改頁,
            List<KagoKetteiKohifutanshaInEntity> 過誤決定通知書情報取込一覧表リスト) {
        List<KagoKetteiKohifutanshaInItem> itemList = new ArrayList<>();
        印刷日時表示作成();
        処理年月分表示作成(処理年月);
        if (null == 過誤決定通知書情報取込一覧表リスト || 過誤決定通知書情報取込一覧表リスト.isEmpty()) {
            KagoKetteiKohifutanshaInItem item = new KagoKetteiKohifutanshaInItem(
                    印刷日時, PAGECOUNT_1, 処理年月分, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, DATA_NASHI, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY);
            itemList.add(item);
        } else {
            int no = 1;
            for (KagoKetteiKohifutanshaInEntity entity : 過誤決定通知書情報取込一覧表リスト) {
                itemList.add(createItem(entity, no,
                        並び順の１件目, 並び順の２件目, 並び順の３件目, 並び順の４件目, 並び順の５件目, 改頁));
                no++;
            }
        }
        return itemList;
    }

    private void 処理年月分表示作成(FlexibleYearMonth 処理年月) {
        if (null == 処理年月) {
            処理年月分 = STRING_BUN;
            return;
        }
        RStringBuilder builder = new RStringBuilder();
        builder.append(
                処理年月.wareki()
                .eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString());
        builder.append(RString.HALF_SPACE);
        処理年月分 = builder.append(STRING_BUN).toRString();
    }

    private void 印刷日時表示作成() {
        RStringBuilder builder = new RStringBuilder();
        RDateTime now = RDateTime.now();
        builder.append(now.getDate().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString());
        builder.append(RString.HALF_SPACE);
        builder.append(now.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        印刷日時 = builder.append(RString.FULL_SPACE).append(STRING_SAKUSEI).toRString();
    }

    private KagoKetteiKohifutanshaInItem createItem(KagoKetteiKohifutanshaInEntity entity, int no,
            RString 並び順の１件目, RString 並び順の２件目, RString 並び順の３件目, RString 並び順の４件目,
            RString 並び順の５件目, RString 改頁) {
        RString strNO = new RString(String.valueOf(no));
        return new KagoKetteiKohifutanshaInItem(
                印刷日時, entity.get頁(), 処理年月分, entity.get公費負担者番号(), entity.get公費負担者名(),
                null == 並び順の１件目 ? RString.EMPTY : 並び順の１件目,
                null == 並び順の２件目 ? RString.EMPTY : 並び順の２件目,
                null == 並び順の３件目 ? RString.EMPTY : 並び順の３件目,
                null == 並び順の４件目 ? RString.EMPTY : 並び順の４件目,
                null == 並び順の５件目 ? RString.EMPTY : 並び順の５件目,
                null == 改頁 ? RString.EMPTY : 改頁,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                strNO, entity.get取扱年月().wareki().
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString(),
                entity.get事業所番号().value(), entity.get事業所名(), entity.get公費受給者番号(),
                entity.get被保険者番号().value(),
                entity.get公費受給者氏名(), entity.getサービス提供年月().wareki().
                separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString(),
                entity.getサービス種類コード().value(), entity.getサービス種類名(), entity.get過誤申立事由コード().value(),
                entity.get過誤申立事由(), DecimalFormatter.toコンマ区切りRString(entity.get単位数(), 0),
                DecimalFormatter.toコンマ区切りRString(entity.get公費負担額(), 0),
                TITLE_KENSU, TITLE_TANISU, TITLE_FUTANGAKU, TITLE_KYUFUHI, TITLE_SERVICEHI, TITLE_SHOKUJIHI,
                DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get介護給付費の件数()), 0),
                DecimalFormatter.toコンマ区切りRString(entity.get介護給付費の単位数(), 0),
                DecimalFormatter.toコンマ区切りRString(entity.get介護給付費の公費負担額(), 0),
                DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get高額介護サービス費の件数()), 0),
                DecimalFormatter.toコンマ区切りRString(entity.get高額介護サービス費の単位数(), 0),
                DecimalFormatter.toコンマ区切りRString(entity.get高額介護サービス費の公費負担額(), 0),
                DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get特定入所者介護サービス費等の件数()), 0),
                DecimalFormatter.toコンマ区切りRString(entity.get特定入所者介護サービス費等の単位数(), 0),
                DecimalFormatter.toコンマ区切りRString(entity.get特定入所者介護サービス費等の公費負担額(), 0));
    }
}
