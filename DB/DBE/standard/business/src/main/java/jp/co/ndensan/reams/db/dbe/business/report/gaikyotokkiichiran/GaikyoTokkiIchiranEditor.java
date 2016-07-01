/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkiichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkiichiran.GaikyoTokkiIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkiichiran.GaikyoTokkiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 事務局用概況特記一覧表のEditorクラスです。
 *
 * @reamsid_L DBE-0150-030 lishengli
 */
public class GaikyoTokkiIchiranEditor implements IGaikyoTokkiIchiranEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private static final int INT_4 = 4;
    private final GaikyoTokkiIchiranEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item 事務局用概況特記一覧表
     */
    protected GaikyoTokkiIchiranEditor(GaikyoTokkiIchiranEntity item) {
        this.item = item;
    }

    /**
     * 事務局用概況特記一覧表Editorです。
     *
     * @param source 要介護認定業務進捗状況一覧表Source
     * @return 要介護認定業務進捗状況一覧表Source
     */
    @Override
    public GaikyoTokkiIchiranReportSource edit(GaikyoTokkiIchiranReportSource source) {
        return editHeader(source);
    }

    private GaikyoTokkiIchiranReportSource editHeader(GaikyoTokkiIchiranReportSource source) {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(DATE_作成);
        source.printTimeStamp = printTimeStampSb.toRString();
        source.shinsakaiNo = get審査会番号(item.get審査会番号());
        source.nendo = get年度(item.get審査会番号());
        source.title = new RString("認定情報<概況特記一覧>");
        source.listNo_1 = item.getNo();
        source.gaikyoTokkiText1 = item.get概況特記テキスト１();
        source.gaikyoTokkiText2 = item.get概況特記テキスト２();
        source.gaikyoTokkiText3 = item.get概況特記テキスト３();
        source.gaikyoTokkiText4 = item.get概況特記テキスト４();
        source.gaikyoTokkiText5 = item.get概況特記テキスト５();
        source.gaikyoTokkiText6 = item.get概況特記テキスト６();
        source.gaikyoTokkiText7 = item.get概況特記テキスト７();
        source.gaikyoTokkiText8 = item.get概況特記テキスト８();
        source.gaikyoTokkiText9 = item.get概況特記テキスト９();
        source.gaikyoTokkiText10 = item.get概況特記テキスト１０();
        source.imgGaikyoTokki1 = item.get概況特記イメージ１();
        source.imgGaikyoTokki2 = item.get概況特記イメージ２();
        source.imgGaikyoTokki3 = item.get概況特記イメージ３();
        source.imgGaikyoTokki4 = item.get概況特記イメージ４();
        source.imgGaikyoTokki5 = item.get概況特記イメージ５();
        source.imgGaikyoTokki6 = item.get概況特記イメージ６();
        source.imgGaikyoTokki7 = item.get概況特記イメージ７();
        source.imgGaikyoTokki8 = item.get概況特記イメージ８();
        source.imgGaikyoTokki9 = item.get概況特記イメージ９();
        source.imgGaikyoTokki10 = item.get概況特記イメージ１０();
        return source;
    }

    private RString get年度(RString 審査会番号) {
        if (!RString.isNullOrEmpty(審査会番号)) {
            return new FlexibleYear(審査会番号.substring(0, INT_4)).wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get審査会番号(RString 審査会番号) {
        if (!RString.isNullOrEmpty(審査会番号)) {
            return new RString(Integer.valueOf(審査会番号.substring(審査会番号.length() - INT_4).toString()));
        }
        return RString.EMPTY;
    }
}
