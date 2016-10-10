/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.shorikekkakakuninlist.ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 処理確認リストのヘーダEditorです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
public class ShoriKekkaKakuninListEditor implements IShoriKekkaKakuninListEditor {

    private final ShoriKekkaKakuninListEntity entity;
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link ShoriKekkaKakuninListEntity}
     */
    protected ShoriKekkaKakuninListEditor(ShoriKekkaKakuninListEntity entity) {
        this.entity = entity;
    }

    /**
     * 処理確認リストのヘーダのedit
     *
     * @param source ShoriKekkaKakuninListReportSource
     * @return ShoriKekkaKakuninListReportSource
     */
    @Override
    public ShoriKekkaKakuninListReportSource edit(ShoriKekkaKakuninListReportSource source) {
        return editHeader(source);
    }

    private ShoriKekkaKakuninListReportSource editHeader(ShoriKekkaKakuninListReportSource source) {
        source.printTimeStamp = set処理日時();
        source.shichosonCode = entity.get保険者番号();
        source.shichosonName = entity.get保険者名();
        source.keyKomoku1 = entity.get項目コード1();
        source.keyKomoku2 = entity.get項目コード2();
        source.keyKomoku3 = entity.get項目コード3();
        source.keyKomoku4 = entity.get項目コード4();
        source.listUpper_1 = entity.getプログラムID();
        source.listUpper_2 = entity.get項目値1();
        source.listUpper_3 = entity.get項目値2();
        source.listUpper_4 = entity.get項目値3();
        source.listUpper_5 = entity.get項目値4();
        source.listUpper_7 = entity.get内容1();
        source.listLower_1 = entity.get処理名称();
        source.listLower_2 = entity.get内容2();
        return source;
    }

    private RString set処理日時() {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(entity.get作成日時().getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", entity.get作成日時().getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", entity.get作成日時().getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", entity.get作成日時().getSecond()));
        printTimeStampSb.append(DATE_秒);
        return printTimeStampSb.toRString();
    }
}
