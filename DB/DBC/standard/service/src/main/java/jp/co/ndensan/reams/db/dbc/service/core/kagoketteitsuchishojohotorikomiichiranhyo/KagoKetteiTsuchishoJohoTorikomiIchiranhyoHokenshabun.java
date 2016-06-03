/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kagoketteitsuchishojohotorikomiichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain.KagoKetteiHokenshaInEntity;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
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
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 過誤決定通知書情報取込一覧表（保険者分）帳票用データ作成です
 *
 * @reamsid_L DBC-0980-310 xupeng
 */
public class KagoKetteiTsuchishoJohoTorikomiIchiranhyoHokenshabun {

    private static final RString PAGECOUNT_1 = new RString("1");
    private static final RString DATA_NASHI = new RString("該当データなし");
    private static final RString TITLE_SHOHOKENSHANAME = new RString("証記載保険者名：");
    private static final RString TITLE_SHOHOKENSHANO = new RString("証記載保険者番号：");
    private static final RString TITLE_KENSU = new RString("件数");
    private static final RString TITLE_TANISU = new RString("単位数");
    private static final RString TITLE_FUTANGAKU = new RString("保険者負担額");
    private static final RString TITLE_KYUFUHI = new RString("介護給付費");
    private static final RString TITLE_SERVICEHI = new RString("高額介護サービス費");
    private static final RString TITLE_SHOKUJIHI = new RString("特定入所者介護等費");
    private static final RString STRING_BUN = new RString("分");
    private static final RString STRING_SAKUSEI = new RString("　作成");
    private static final int ZERO = 0;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private RString 並び順の1件目;
    private RString 並び順の2件目;
    private RString 並び順の3件目;
    private RString 並び順の4件目;
    private RString 並び順の5件目;
    private RString 改頁の1件目;
    private RString 改頁の2件目;
    private RString 改頁の3件目;
    private RString 改頁の4件目;
    private RString 改頁の5件目;
    private RString 処理年月分;

    /**
     * バッチで作成した帳票Entityリストより、過誤決定通知書情報取込一覧表（保険者分）帳票データを作成する
     *
     * @param 処理年月 処理年月
     * @param 並び順1 並び順1
     * @param 並び順2 並び順2
     * @param 並び順3 並び順3
     * @param 並び順4 並び順4
     * @param 並び順5 並び順5
     * @param 改頁 改頁
     * @param 過誤決定通知書情報取込一覧表リスト 過誤決定通知書情報取込一覧表リスト
     * @return List<KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem> 過誤決定通知書情報取込一覧表（保険者分）帳票出力用リスト
     */
    public List<KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem> createKagoKetteiTsuchishoTorikomiIchiranhyoHokenshabunData(
            FlexibleYearMonth 処理年月,
            RString 並び順1,
            RString 並び順2,
            RString 並び順3,
            RString 並び順4,
            RString 並び順5,
            List<RString> 改頁,
            List<KagoKetteiHokenshaInEntity> 過誤決定通知書情報取込一覧表リスト) {
        List<KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem> list = new ArrayList<>();
        this.並び順の1件目 = 並び順1;
        this.並び順の2件目 = 並び順2;
        this.並び順の3件目 = 並び順3;
        this.並び順の4件目 = 並び順4;
        this.並び順の5件目 = 並び順5;
        this.改頁の1件目 = 改頁.size() <= INDEX_0 ? RString.EMPTY : 改頁.get(INDEX_0);
        this.改頁の2件目 = 改頁.size() <= INDEX_1 ? RString.EMPTY : 改頁.get(INDEX_1);
        this.改頁の3件目 = 改頁.size() <= INDEX_2 ? RString.EMPTY : 改頁.get(INDEX_2);
        this.改頁の4件目 = 改頁.size() <= INDEX_3 ? RString.EMPTY : 改頁.get(INDEX_3);
        this.改頁の5件目 = 改頁.size() <= INDEX_4 ? RString.EMPTY : 改頁.get(INDEX_4);
        処理年月分表示作成(処理年月);
        if (null != 過誤決定通知書情報取込一覧表リスト && !過誤決定通知書情報取込一覧表リスト.isEmpty()) {
            int no = 1;
            for (KagoKetteiHokenshaInEntity entity : 過誤決定通知書情報取込一覧表リスト) {
                list.add(createItem(entity, no));
                no++;
            }
        } else {
            KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem item = new KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem();
            item.setTorikomiYM(処理年月分);
            item.setShutsuryokujun1(並び順の1件目);
            item.setShutsuryokujun2(並び順の2件目);
            item.setShutsuryokujun3(並び順の3件目);
            item.setShutsuryokujun4(並び順の4件目);
            item.setShutsuryokujun5(並び順の5件目);
            item.setKaipage1(改頁の1件目);
            item.setKaipage2(改頁の2件目);
            item.setKaipage3(改頁の3件目);
            item.setKaipage4(改頁の4件目);
            item.setKaipage5(改頁の5件目);
            item.setPrintTimeStamp(作成日時表示作成());
            item.setListUpper_5(DATA_NASHI);
            item.setPageCount(PAGECOUNT_1);
            item.setShoHokenshaNameTitle(TITLE_SHOHOKENSHANAME);
            item.setShoHokenshaNoTitle(TITLE_SHOHOKENSHANO);
            SearchResult<KoikiZenShichosonJoho> result = KoikiShichosonJohoFinder.createInstance().
                    koseiShichosonJoho();
            item.setHokenshaName(result.records().get(ZERO).get市町村名称());
            item.setHokenshaNo(result.records().get(ZERO).get証記載保険者番号().value());
            list.add(item);
        }

        return list;
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

    private RString 作成日時表示作成() {
        RStringBuilder builder = new RStringBuilder();
        RDateTime now = RDateTime.now();
        builder.append(now.getDate().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.ZERO)
                .toDateString());
        builder.append(RString.HALF_SPACE);
        builder.append(now.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        return builder.append(STRING_SAKUSEI).toRString();
    }

    private KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem createItem(
            KagoKetteiHokenshaInEntity entity, int no) {
        KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem item = new KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem();
        item.setTorikomiYM(処理年月分);
        item.setShoHokenshaNo(entity.get証記載保険者番号().value());
        item.setShoHokenshaName(entity.get証記載保険者名());
        item.setShutsuryokujun1(並び順の1件目);
        item.setShutsuryokujun2(並び順の2件目);
        item.setShutsuryokujun3(並び順の3件目);
        item.setShutsuryokujun4(並び順の4件目);
        item.setShutsuryokujun5(並び順の5件目);
        item.setKaipage1(改頁の1件目);
        item.setKaipage2(改頁の2件目);
        item.setKaipage3(改頁の3件目);
        item.setKaipage4(改頁の4件目);
        item.setKaipage5(改頁の5件目);
        item.setPrintTimeStamp(作成日時表示作成());
        item.setListUpper_2(entity.get取扱年月().wareki().separator(Separator.PERIOD).
                fillType(FillType.BLANK).toDateString());
        item.setListUpper_3(entity.get事業所番号().value());
        item.setListLower_1(entity.get事業所名());
        item.setListUpper_4(entity.get被保険者番号().value());
        item.setListUpper_5(entity.get被保険者氏名());
        item.setListUpper_6(entity.getサービス提供年月().wareki().separator(Separator.PERIOD).
                fillType(FillType.BLANK).toDateString());
        item.setListUpper_7(entity.getサービス種類コード().value());
        item.setListLower_2(entity.getサービス種類名());
        item.setListUpper_8(entity.get過誤申立事由コード().value());
        item.setListLower_3(entity.get過誤申立事由());
        item.setListUpper_9(DecimalFormatter.toコンマ区切りRString(entity.get単位数(), 0));
        item.setListLower_4(DecimalFormatter.toコンマ区切りRString(entity.get保険者負担額(), 0));
        item.setKensuTitle(TITLE_KENSU);
        item.setTanisuTitle(TITLE_TANISU);
        item.setFutanGakuTitle(TITLE_FUTANGAKU);
        item.setKyufuhiTitle(TITLE_KYUFUHI);
        item.setServicehiTitle(TITLE_SERVICEHI);
        item.setShokujihiTitle(TITLE_SHOKUJIHI);
        item.setKensu1(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get介護給付費の件数()), 0));
        item.setTanisu1(DecimalFormatter.toコンマ区切りRString(entity.get介護給付費の単位数(), 0));
        item.setFutanGaku1(DecimalFormatter.toコンマ区切りRString(entity.get介護給付費の保険者負担額(), 0));
        item.setKensu2(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get高額介護サービス費の件数()), 0));
        item.setTanisu2(DecimalFormatter.toコンマ区切りRString(entity.get高額介護サービス費の単位数(), 0));
        item.setFutanGaku2(DecimalFormatter.toコンマ区切りRString(entity.get高額介護サービス費の保険者負担額(), 0));
        item.setKensu3(DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get特定入所者介護サービス費等の件数()), 0));
        item.setTanisu3(DecimalFormatter.toコンマ区切りRString(entity.get特定入所者介護サービス費等の単位数(), 0));
        item.setFutanGaku3(DecimalFormatter.toコンマ区切りRString(entity.get特定入所者介護サービス費等の保険者負担額(), 0));
        item.setShoHokenshaNameTitle(TITLE_SHOHOKENSHANAME);
        item.setShoHokenshaNoTitle(TITLE_SHOHOKENSHANO);
        SearchResult<KoikiZenShichosonJoho> result = KoikiShichosonJohoFinder.createInstance().
                koseiShichosonJoho();
        item.setHokenshaName(result.records().get(ZERO).get市町村名称());
        item.setHokenshaNo(result.records().get(ZERO).get証記載保険者番号().value());
        item.setListUpper_1(new RString(String.valueOf(no)));
        return item;
    }
}
