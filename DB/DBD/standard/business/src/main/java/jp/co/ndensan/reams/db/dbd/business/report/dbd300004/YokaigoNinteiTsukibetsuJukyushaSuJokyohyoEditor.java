/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300004;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijisshijokyohyo.YokaigoNinteiJisshiJokyohyoReportEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300004.YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 要介護認定月別受給者数状況表（統計表）Editorです。
 *
 * @reamsid_L DBD-1771-034 b_liuyang2
 */
public class YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEditor implements IYokaigoNinteiTsukibetsuJukyushaSuJokyohyoEditor {

    private final FlexibleDate 基準日;
    private final RString 年齢;
    private final RString 地区;
    private final RString 集計単位;
    private final FlexibleYear 年度;
    private final List<YokaigoNinteiJisshiJokyohyoReportEntity> 受給状況Entityリスト;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param 基準日 FlexibleDate
     * @param 年齢 RString
     * @param 地区 RString
     * @param 集計単位 Code
     * @param 年度 FlexibleYear
     * @param 受給状況Entityリスト List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param index int
     */
    public YokaigoNinteiTsukibetsuJukyushaSuJokyohyoEditor(FlexibleDate 基準日, RString 年齢, RString 地区, RString 集計単位,
            FlexibleYear 年度, List<YokaigoNinteiJisshiJokyohyoReportEntity> 受給状況Entityリスト, int index) {
        this.基準日 = 基準日;
        this.年齢 = 年齢;
        this.地区 = 地区;
        this.集計単位 = 集計単位;
        this.年度 = 年度;
        this.受給状況Entityリスト = 受給状況Entityリスト;
        this.index = index;
    }

    @Override
    public YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource edit(YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource source) {
        setYokaigoNinteiTsukibetsuJukyushaSuJokyohyo(source);
        return source;
    }

    private void setYokaigoNinteiTsukibetsuJukyushaSuJokyohyo(YokaigoNinteiTsukibetsuJukyushaSuJokyohyoReportSource source) {
        source.kijunbi = this.基準日.wareki().toDateString();
        source.nenrei = this.年齢;
        source.chiku = this.地区;
        source.shukeiTani = this.集計単位;
        source.printTimeStamp = get印刷日時();
        source.title_a1 = RString.EMPTY;
        source.title_a2 = RString.EMPTY;
        source.title_b1 = new RString("介護保険");
        source.title_b2 = new RString("要介護認定月別受給者数状況表");
        source.nendo = this.年度.toDateString();
        if (null != 受給状況Entityリスト && !受給状況Entityリスト.isEmpty()) {
            source.shichosonName = 受給状況Entityリスト.get(index).get市町村名();
            source.hokenshaNo = 受給状況Entityリスト.get(index).get市町村番号();
            source.hokenshaName = 受給状況Entityリスト.get(index).get市町村名();
            YokaigoNinteiJisshiJokyohyoReportEntity 受給状況Entity = 受給状況Entityリスト.get(index);
            source.list_1 = 受給状況Entity.get集計項目();
            source.list_2 = 受給状況Entity.get四月の合計();
            source.list_3 = 受給状況Entity.get五月の合計();
            source.list_4 = 受給状況Entity.get六月の合計();
            source.list_5 = 受給状況Entity.get七月の合計();
            source.list_6 = 受給状況Entity.get八月の合計();
            source.list_7 = 受給状況Entity.get九月の合計();
            source.list_8 = 受給状況Entity.get十月の合計();
            source.list_9 = 受給状況Entity.get十一月の合計();
            source.list_10 = 受給状況Entity.get十二月の合計();
            source.list_11 = 受給状況Entity.get一月の合計();
            source.list_12 = 受給状況Entity.get二月の合計();
            source.list_13 = 受給状況Entity.get三月の合計();
            source.list_14 = 受給状況Entity.get年度合計();
        }

        source.reportID = new RString("DBD300004");
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        return 年月日.concat(時分秒);
    }
}
