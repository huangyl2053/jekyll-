/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.gaikyotokkiichiran;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuGaikyouTokkiBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.gaikyotokkiichiran.GaikyoTokkiIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private static final RString テキスト = new RString("1");
    private static final int INT_4 = 4;
    private final JimuGaikyouTokkiBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business 事務局用概況特記一覧表
     */
    protected GaikyoTokkiIchiranEditor(JimuGaikyouTokkiBusiness business) {
        this.business = business;
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
        source.shinsakaiNo = get審査会番号(business.get審査会番号());
        source.nendo = get年度(business.get審査会番号());
        source.title = new RString("認定情報<概況特記一覧>");
        source.listNo_1 = business.getNo();
        if (テキスト.equals(DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            source.gaikyoTokkiText1 = business.get概況特記テキスト１();
            source.gaikyoTokkiText2 = business.get概況特記テキスト２();
            source.gaikyoTokkiText3 = business.get概況特記テキスト３();
            source.gaikyoTokkiText4 = business.get概況特記テキスト４();
            source.gaikyoTokkiText5 = business.get概況特記テキスト５();
            source.gaikyoTokkiText6 = business.get概況特記テキスト６();
            source.gaikyoTokkiText7 = business.get概況特記テキスト７();
            source.gaikyoTokkiText8 = business.get概況特記テキスト８();
            source.gaikyoTokkiText9 = business.get概況特記テキスト９();
            source.gaikyoTokkiText10 = business.get概況特記テキスト１０();
        } else {
            source.imgGaikyoTokki1 = business.get概況特記イメージ１();
            source.imgGaikyoTokki2 = business.get概況特記イメージ２();
            source.imgGaikyoTokki3 = business.get概況特記イメージ３();
            source.imgGaikyoTokki4 = business.get概況特記イメージ４();
            source.imgGaikyoTokki5 = business.get概況特記イメージ５();
            source.imgGaikyoTokki6 = business.get概況特記イメージ６();
            source.imgGaikyoTokki7 = business.get概況特記イメージ７();
            source.imgGaikyoTokki8 = business.get概況特記イメージ８();
            source.imgGaikyoTokki9 = business.get概況特記イメージ９();
            source.imgGaikyoTokki10 = business.get概況特記イメージ１０();
        }
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
