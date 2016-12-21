/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkajohoichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichiran.HanteiKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkajohoichiran.HanteiKekkaIchiranA4ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 要介護認定判定結果一覧Editorです。
 *
 * @reamsid_L DBE-0170-020 wangkun
 */
public class HanteiKekkaIchiranEditor implements IHanteiKekkaIchiranEditor {

    private final HanteiKekkaIchiranEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HanteiKekkaIchiranEntity}
     */
    protected HanteiKekkaIchiranEditor(HanteiKekkaIchiranEntity item) {
        this.item = item;
    }

    @Override
    public HanteiKekkaIchiranA4ReportSource edit(HanteiKekkaIchiranA4ReportSource source) {
        RDateTime dateTime = RDateTime.now();
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(dateTime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        hakkoYMD.append(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        source.title = item.getTitle();
        source.taishoHokenshaName = item.get出力対象();
        source.hakkoYMD = hakkoYMD.toRString();
        source.listNo_1 = new RString(item.getNo());
        source.listNo_2 = new RString(item.get介護認定審査会審査順());
        source.listNo_3 = item.get認定申請区分_申請時();
        source.listNo_4 = item.get認定申請区分_法令();
        source.listNo_5 = new RDate(item.get認定申請日().toString()).wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).
                fillType(FillType.BLANK).toDateString();
        source.listNo_6 = new RDate(item.get二次判定年月日().toString()).wareki().eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).
                fillType(FillType.BLANK).toDateString();
        source.listHokenshaName_1 = item.get市町村名称();
        source.listHokenshaNo_1 = item.get証記載保険者番号();
        source.listHihokenshaNo_1 = item.get被保険者番号();
        source.listHihokenshaNo_2 = item.get被保険者氏名();
        source.listHihokenshaNo_3 = item.getTb_一次判定結果();
        source.listHihokenshaNo_4 = item.getTb_二次判定要介護状態区分();
        source.listHihokenshaNo_5 = item.get一次判定結果();
        source.listHihokenshaNo_6 = item.get二次判定要介護状態区分();
        source.listHihokenshaNo_7 = item.get要介護状態像例コード();

        RStringBuilder tempTokuteishippei_1 = new RStringBuilder(String.valueOf(item.get二次判定認定有効期間()));
        tempTokuteishippei_1
                .append("ヵ月");
        RStringBuilder tempTokuteishippei_2 = new RStringBuilder(new RDate(item.get二次判定認定有効開始年月日().toString()).wareki()
                .eraType(EraType.KANJI_RYAKU).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).
                fillType(FillType.BLANK).toDateString());
        tempTokuteishippei_2.append("～")
                .append(new RDate(item.get二次判定認定有効終了年月日().toString()).wareki().eraType(EraType.KANJI_RYAKU).
                        firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).
                        fillType(FillType.BLANK).toDateString());
        source.listYukokikan_1 = tempTokuteishippei_1.toRString();
        source.listYukokikan_2 = item.get二号特定疾病コード();
        source.listTokuteishippei_1 = tempTokuteishippei_2.toRString();
        source.listTokuteishippei_2 = item.get二号特定疾病内容();
        source.listShinsakaiiken_1 = item.get介護認定審査会意見();
        return source;
    }
}
