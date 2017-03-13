/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaigijiroku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiGijirokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaigijiroku.ShinsakaiGijirokuReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 介護認定審査会議事録Editorです。
 *
 * @reamsid_L DBE-0170-040 wangkun
 */
public class ShinsakaiGijirokuEditor implements IShinsakaiGijirokuEditor {

    private static final int 一時間 = 60;
    private final ShinsakaiGijirokuEntity item;
    private ShinsakaiKaisaiKekkaJohoEntity 審査会情報;
    private ShinsakaiKekkaJohoRelateEntity 審査会審査結果等;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HanteiKekkaIchiranEntity}
     */
    protected ShinsakaiGijirokuEditor(ShinsakaiGijirokuEntity item) {
        this.item = item;
        if (item != null) {
            審査会審査結果等 = item.get審査会審査結果等();
            審査会情報 = item.get審査会情報();
        }
    }

    @Override
    public ShinsakaiGijirokuReportSource edit(ShinsakaiGijirokuReportSource source) {
        RDateTime dateTime = RDateTime.now();
        RStringBuilder printTimeStamp = new RStringBuilder();
        printTimeStamp.append(dateTime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStamp.append(new RString("　"));
        printTimeStamp.append(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        RStringBuilder nendoBuilder = new RStringBuilder();
        nendoBuilder.append(審査会情報.getShinsakaiKaisaiYMD().getNendo().
                wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
        nendoBuilder.append("年度");
        source.nendo = nendoBuilder.toRString();
        source.title = new RString("介護認定審査会議事録");
        source.printTimeStamp = printTimeStamp.toRString();
        RStringBuilder builder = new RStringBuilder();
        builder.append("第");
        builder.append(審査会情報.getShinsakaiKaisaiNo());
        builder.append("回審査会");
        source.kaisaiCount = builder.toRString();
        source.kaisaiDate = 審査会情報.getShinsakaiKaisaiYMD().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RStringBuilder temp = new RStringBuilder();
        long temp時間 = new RTime(審査会情報.getShinsakaiKaishiTime()).minutesDuration(new RTime(審査会情報.getShinsakaiShuryoTime()));
        temp.append(temp時間 / 一時間);
        temp.append("時間");
        temp.append(temp時間 % 一時間);
        temp.append("分");
        source.kaisaiTime = temp.toRString();
        source.kaisaiKaijo = 審査会情報.getShinsakaiKaisaiBashoName();
        RStringBuilder date = new RStringBuilder();
        long 時間 = new RTime(審査会情報.getShinsakaiKaishiTime()).minutesDuration(new RTime(審査会情報.getShinsakaiShuryoTime()));
        date.append(時間 / 一時間);
        date.append("時間");
        date.append(時間 % 一時間);
        date.append("分");
        source.shinsakaiKaisaiTime = date.toRString();
        source.kensu = new RString(審査会審査結果等.get判定件数());
        source.nigoKensu = new RString(審査会審査結果等.get判定件数_2号被保険者数());
        source.zaitakuKensu = new RString(審査会審査結果等.get判定件数_在宅数());
        source.shisetsuKensu = new RString(審査会審査結果等.get判定件数_施設数());
        source.shinkiKensu = new RString(審査会審査結果等.get判定件数_の新規件数());
        source.kubunHenkoKensu = new RString(審査会審査結果等.get判定件数_の状態区分変更件数());
        source.koshinKensu = new RString(審査会審査結果等.get判定件数_の更新件数());
        source.listNijihanteibetsuCount_1 = new RString(審査会審査結果等.get二次判定_非該当());
        source.listNijihanteibetsuCount_2 = new RString(審査会審査結果等.get二次判定_要支１());
        source.listNijihanteibetsuCount_3 = new RString(審査会審査結果等.get二次判定_要支２());
        source.listNijihanteibetsuCount_4 = new RString(審査会審査結果等.get二次判定_要介護１());
        source.listNijihanteibetsuCount_5 = new RString(審査会審査結果等.get二次判定_要介護２());
        source.listNijihanteibetsuCount_6 = new RString(審査会審査結果等.get二次判定_要介護３());
        source.listNijihanteibetsuCount_7 = new RString(審査会審査結果等.get二次判定_要介護４());
        source.listNijihanteibetsuCount_8 = new RString(審査会審査結果等.get二次判定_要介護５());
        source.mihanteiCount = new RString(item.get未判定());
        source.mishinsaCount = new RString(item.get未審査());
        source.ichijihanteiHenkoCount = new RString(item.get一次判定を変更した件数());
        source.shinsakaiikenHenkoCount = new RString(item.get審査会意見を付した件数());
        source.sabisuShurui1 = RString.EMPTY;
        source.sabisuShurui2 = RString.EMPTY;
        source.yoteiCount = new RString(item.get審査会情報().getHanteiYoteiSu());
        return source;
    }
}
