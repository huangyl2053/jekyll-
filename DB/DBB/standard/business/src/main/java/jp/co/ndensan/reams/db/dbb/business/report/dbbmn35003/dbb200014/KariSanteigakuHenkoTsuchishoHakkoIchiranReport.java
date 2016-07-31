/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200014.KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 仮算定額変更通知書発行一覧表のReportです。
 *
 * @reamsid_L DBB-0820-060 xuyue
 */
public class KariSanteigakuHenkoTsuchishoHakkoIchiranReport extends Report<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> {

    private static final int 金融機関コード_START = 0;
    private static final int 金融機関コード_END = 4;
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private static final RString ハイフン = new RString("-");
    private final List<EditedKariSanteiTsuchiShoKyotsu> editedDataList;
    private final RString 出力順１;
    private final RString 出力順２;
    private final RString 出力順３;
    private final RString 出力順４;
    private final RString 出力順５;
    private final RDateTime 帳票作成日時;

    /**
     * コンストラクタです。
     *
     * @param editedDataList 編集後仮算定通知書共通情報entityのリスト
     * @param 出力順１ 出力順１
     * @param 出力順２ 出力順２
     * @param 出力順３ 出力順３
     * @param 出力順４ 出力順４
     * @param 出力順５ 出力順５
     * @param 帳票作成日時 帳票作成日時
     */
    public KariSanteigakuHenkoTsuchishoHakkoIchiranReport(List<EditedKariSanteiTsuchiShoKyotsu> editedDataList,
            RString 出力順１, RString 出力順２, RString 出力順３, RString 出力順４, RString 出力順５, RDateTime 帳票作成日時) {
        this.editedDataList = editedDataList != null ? editedDataList : new ArrayList<EditedKariSanteiTsuchiShoKyotsu>();
        this.出力順１ = 出力順１;
        this.出力順２ = 出力順２;
        this.出力順３ = 出力順３;
        this.出力順４ = 出力順４;
        this.出力順５ = 出力順５;
        this.帳票作成日時 = 帳票作成日時;
    }

    @Override
    public void writeBy(ReportSourceWriter<KariSanteigakuHenkoTsuchishoHakkoIchiranReportSource> reportSourceWriter) {
        int 連番 = 1;
        for (EditedKariSanteiTsuchiShoKyotsu editedData : editedDataList) {
            KariSanteigakuHenkoTsuchishoHakkoIchiranItem item = new KariSanteigakuHenkoTsuchishoHakkoIchiranItem();
            setHeader(editedData, item);
            setBody(editedData, item, 連番);
            IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor headerEditor = new KariSanteigakuHenkoTsuchishoHakkoIchiranHeaderEditor(item);
            IKariSanteigakuHenkoTsuchishoHakkoIchiranEditor hyojiBodyEditor = new KariSanteigakuHenkoTsuchishoHakkoIchiranBodyEditor(item);
            IKariSanteigakuHenkoTsuchishoHakkoIchiranBuilder builder
                    = new KariSanteigakuHenkoTsuchishoHakkoIchiranBuilderImpl(headerEditor, hyojiBodyEditor);
            reportSourceWriter.writeLine(builder);
            連番++;
        }
    }

    private void setHeader(EditedKariSanteiTsuchiShoKyotsu editedData, KariSanteigakuHenkoTsuchishoHakkoIchiranItem item) {
        RTime time = 帳票作成日時.getTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        RString printTimeStamp = 帳票作成日時.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString().concat(RString.FULL_SPACE).concat(timeFormat)
                .concat(RString.FULL_SPACE).concat(new RString("作成"));

        item.setPrintTimeStamp(printTimeStamp);
        item.setNendo(editedData.get調定年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString());
        item.setHokenshaNo(Association.getLasdecCode().getColumnValue());
        item.setHokenshaName(Association.getShichosonName());
        item.setShutsuryokujun1(出力順１);
        item.setShutsuryokujun2(出力順２);
        item.setShutsuryokujun3(出力順３);
        item.setShutsuryokujun4(出力順４);
        item.setShutsuryokujun5(出力順５);
        item.setHyojicodeName1(editedData.get表示コード１名());
        item.setHyojicodeName2(editedData.get表示コード２名());
        item.setHyojicodeName3(editedData.get表示コード３名());
    }

    private void setBody(EditedKariSanteiTsuchiShoKyotsu editedData, KariSanteigakuHenkoTsuchishoHakkoIchiranItem item, int 連番) {
        item.setListUpper_1(new RString(String.valueOf(連番)));
        if (editedData.get通知書番号() != null) {
            item.setListUpper_2(editedData.get通知書番号().getColumnValue());
        }
        if (editedData.get被保険者番号() != null) {
            item.setListUpper_3(editedData.get被保険者番号().getColumnValue());
        }
        if (editedData.get編集後個人() != null && editedData.get編集後個人().get世帯コード() != null) {
            item.setListUpper_4(editedData.get編集後個人().get世帯コード().getColumnValue());
        }

        item.setListUpper_5(editedData.get表示コード1());
        item.setListUpper_6(editedData.get表示コード２());
        item.setListUpper_7(editedData.get表示コード３());

        if (editedData.get更正前() != null) {
            item.setListUpper_8(new RString(ObjectUtil.defaultIfNull(editedData.get更正前().get更正前特徴期別金額合計(), Decimal.ZERO)
                    .add(ObjectUtil.defaultIfNull(editedData.get更正前().get更正前普徴期別金額合計(), Decimal.ZERO)).toString()));
            item.setListUpper_9(editedData.get更正前().get更正前徴収方法());
        }

        if (editedData.get更正後() != null && editedData.get更正後().get生保開始日() != null) {
            item.setListUpper_10(editedData.get更正後().get生保開始日());
        }
        if (editedData.get更正後() != null && editedData.get更正後().get生活保護扶助種類() != null) {
            item.setListUpper_11(CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系, URZCodeShubetsu.扶助種類コード.getCodeShubetsu(),
                    new Code(editedData.get更正後().get生活保護扶助種類()), new FlexibleDate(RDate.getNowDate().toDateString())));
        }

        if (editedData.get編集後宛先() != null) {
            if (editedData.get編集後宛先().get本人名称() != null && editedData.get編集後宛先().get本人名称().getName() != null) {
                item.setListLower_1(editedData.get編集後宛先().get本人名称().getName().getColumnValue());
            }
            item.setListLower_2(editedData.get編集後宛先().get郵便番号());
            item.setListLower_3(editedData.get編集後宛先().get編集後住所());
        }

        if (editedData.get更正後() != null) {
            item.setListLower_4(new RString(ObjectUtil.defaultIfNull(editedData.get更正後().get更正後特徴期別金額合計(), Decimal.ZERO)
                    .add(ObjectUtil.defaultIfNull(editedData.get更正後().get更正後普徴期別金額合計(), Decimal.ZERO)).toString()));
            item.setListLower_5(editedData.get更正後().get更正後徴収方法());
        }

        RStringBuilder 口座情報 = new RStringBuilder();
        EditedKoza 編集後口座 = editedData.get編集後口座();
        if (null != 編集後口座 && 編集後口座.isゆうちょ銀行()) {
            口座情報.append(編集後口座.get金融機関コードCombinedWith支店コード().substring(
                    金融機関コード_START, 金融機関コード_END));
            口座情報.append(RString.HALF_SPACE);
            口座情報.append(編集後口座.get口座番号Or通帳記号番号());
            口座情報.append(RString.HALF_SPACE);
            口座情報.append(編集後口座.get口座名義人漢字優先());
        } else if (null != 編集後口座 && !編集後口座.isゆうちょ銀行()) {
            口座情報.append(編集後口座.get金融機関コードCombinedWith支店コード());
            口座情報.append(RString.HALF_SPACE);
            口座情報.append(編集後口座.get口座種別略称());
            口座情報.append(ハイフン);
            口座情報.append(編集後口座.get口座番号Or通帳記号番号());
            口座情報.append(RString.HALF_SPACE);
            口座情報.append(編集後口座.get口座名義人漢字優先());
        }
        item.setListLower_6(口座情報.toRString());
    }
}
