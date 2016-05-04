/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import lombok.NonNull;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表Report
 *
 * @reamsid_L DBB-0790-060 surun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport extends
        Report<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> {

    private static final RString SAKUSEI = new RString("作成");
    private static final RString タイトル = new RString("介護保険　　特別徴収開始通知書（仮徴収）発行一覧表");
    private static final RString NENDO = new RString("年度");
    private static final RString 徴収額タイトル = new RString("仮徴収額");
    private static final RString 仮徴収月4月 = new RString("4月");
    private static final RString 仮徴収月6月 = new RString("6月");
    private static final RString 仮徴収月8月 = new RString("8月");

    private final List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報entityList;
    // TODO  改頁１～改頁５
    private final RString 改頁;
    // TODO 出力順１～出力順５
    private final RString 出力順;
    private final FlexibleYear 調定年度;
    private final YMDHMS 帳票作成日時;
    private final List<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranItem> targets;

    /**
     * コンストラクタです
     *
     * @param 編集後仮算定通知書共通情報entityList List<EditedKariSanteiTsuchiShoKyotsu>
     * @param 改頁 RString
     * @param 出力順 RString
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     */
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport(
            List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報entityList,
            RString 改頁,
            RString 出力順,
            FlexibleYear 調定年度,
            YMDHMS 帳票作成日時) {
        this.編集後仮算定通知書共通情報entityList = 編集後仮算定通知書共通情報entityList;
        this.改頁 = 改頁;
        this.出力順 = 出力順;
        this.調定年度 = 調定年度;
        this.帳票作成日時 = 帳票作成日時;
        this.targets = new ArrayList<>();
    }

    /**
     * createFormメソッド
     *
     * @param 編集後仮算定通知書共通情報entityList List<EditedKariSanteiTsuchiShoKyotsu>
     * @param 改頁 RString
     * @param 出力順 RString
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     * @return TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport
     */
    public static TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport createForm(
            @NonNull List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報entityList,
            @NonNull RString 改頁,
            @NonNull RString 出力順,
            @NonNull FlexibleYear 調定年度,
            @NonNull YMDHMS 帳票作成日時) {
        return new TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport(編集後仮算定通知書共通情報entityList, 改頁, 出力順, 調定年度, 帳票作成日時);
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> writer) {
        setItems();
        for (TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranItem target : targets) {
            ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor editor = new TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor(target);
            ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranBuilder builder
                    = new TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranBuilder(editor);
            writer.writeLine(builder);
        }
    }

    /**
     * setItemsメソッド
     */
    private void setItems() {
        Integer 連番 = 0;
        for (EditedKariSanteiTsuchiShoKyotsu entity : 編集後仮算定通知書共通情報entityList) {
            連番 = 連番 + 1;
            TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranItem item = new TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranItem();
            RString 帳票作成日 = 帳票作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 帳票作成時 = 帳票作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            item.set作成日時(帳票作成日.concat(" " + 帳票作成時 + " " + SAKUSEI));
            item.setタイトル(タイトル);
            item.set年度(調定年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                    .fillType(FillType.BLANK).toDateString().concat(NENDO));
//            Association association = AssociationFinderFactory.createInstance().getAssociation();
//            item.set市町村コード(association.get地方公共団体コード().value());
//            item.set市町村名称(association.get市町村名());
            // TODO 並び順１
            //item.setShutsuryokujun1();
            // TODO 並び順2
            //item.setShutsuryokujun2();
            // TODO 並び順3
            //item.setShutsuryokujun3();
            // TODO 並び順4
            //item.setShutsuryokujun4();
            // TODO 並び順5
            //item.setShutsuryokujun5();
            // TODO 改頁１
            //item.setKaipage1();
            // TODO 改頁2
            //item.setKaipage2();
            // TODO 改頁3
            //item.setKaipage3();
            // TODO 改頁4
            //item.setKaipage4();
            // TODO 改頁5
            //item.setKaipage5();
            item.set徴収額タイトル(徴収額タイトル);
            item.set連番(new RString(連番.toString()));
            item.set郵便番号(entity.get編集後宛先().get郵便番号());
            item.set住所(entity.get編集後宛先().get編集後住所());
            item.set行政区(entity.get編集後宛先().get宛先行政区());
            item.set生年月日(entity.get編集後個人().get生年月日());
            item.set性別(entity.get編集後個人().get性別());
            item.set世帯主名(entity.get編集後個人().get世帯主名().value());
            item.set通知書番号(entity.get通知書番号().value());
            item.set世帯コード(entity.get編集後個人().get世帯コード().value());
            item.set被保険者氏名(entity.get編集後個人().get名称().getName().value());
            item.set特別徴収義務者(entity.get更正後().get更正後特別徴収義務者());
            item.set特別徴対象年金(entity.get更正後().get更正後特別徴収対象年金());
            item.set仮徴収月4月(仮徴収月4月);
            item.set仮徴収額4月(DecimalFormatter.toコンマ区切りRString(entity.get更正後().get更正後特徴期別金額01(), 0));
            item.set仮徴収月6月(仮徴収月6月);
            item.set仮徴収額6月(DecimalFormatter.toコンマ区切りRString(entity.get更正後().get更正後特徴期別金額02(), 0));
            item.set仮徴収月8月(仮徴収月8月);
            item.set仮徴収額8月(DecimalFormatter.toコンマ区切りRString(entity.get更正後().get更正後特徴期別金額03(), 0));
            targets.add(item);
        }
    }
}
