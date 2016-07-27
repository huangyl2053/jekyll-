/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.YokaigoNinteiJisshiJokyohyo.YokaigoNinteiJisshiJokyohyoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300003.YokaigoNinteiJisshiJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 要介護認定実施状況表（統計表）Editorです。
 *
 * @reamsid_L DBD-1771-030 b_liuyang2
 */
public class YokaigoNinteiJisshiJokyohyoEditor implements IYokaigoNinteiJisshiJokyohyoEditor {

    private final FlexibleDate 基準日;
    private final RString 年齢;
    private final RString 地区;
    private final Code 集計単位;
    private final List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist1;
    private final List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist2;
    private final List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist3;
    private final List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist4;
    private final List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリスト;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param 基準日 FlexibleDate
     * @param 年齢 RString
     * @param 地区 RString
     * @param 集計単位 Code
     * @param 実施状況Entityリスト List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param 実施状況Entityリストlist1 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param 実施状況Entityリストlist2 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param 実施状況Entityリストlist3 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param 実施状況Entityリストlist4 List<YokaigoNinteiJisshiJokyohyoEntity>
     * @param index int
     */
    public YokaigoNinteiJisshiJokyohyoEditor(FlexibleDate 基準日, RString 年齢, RString 地区,
            Code 集計単位, List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリスト,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist1,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist2,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist3,
            List<YokaigoNinteiJisshiJokyohyoEntity> 実施状況Entityリストlist4, int index) {
        this.基準日 = 基準日;
        this.年齢 = 年齢;
        this.地区 = 地区;
        this.集計単位 = 集計単位;
        this.実施状況Entityリスト = 実施状況Entityリスト;
        this.実施状況Entityリストlist1 = 実施状況Entityリストlist1;
        this.実施状況Entityリストlist2 = 実施状況Entityリストlist2;
        this.実施状況Entityリストlist3 = 実施状況Entityリストlist3;
        this.実施状況Entityリストlist4 = 実施状況Entityリストlist4;
        this.index = index;
    }

    @Override
    public YokaigoNinteiJisshiJokyohyoReportSource edit(YokaigoNinteiJisshiJokyohyoReportSource source) {
        setYokaigoNinteiJisshiJokyohyo(source);
        return source;
    }

    private void setYokaigoNinteiJisshiJokyohyo(YokaigoNinteiJisshiJokyohyoReportSource source) {
        source.kijunbi = this.基準日.wareki().toDateString();
        source.nenrei = this.年齢;
        source.chiku = this.地区;
        source.shukeiTani = this.集計単位.getColumnValue();
        source.printTimeStamp = get印刷日時();
        source.label48 = new RString("介護保険");
        source.label18 = new RString("要介護認定実施状況表");
        source.shichosonName = 実施状況Entityリスト.get(index).get市町村名();
        source.hokenshaNo = 実施状況Entityリスト.get(index).get市町村番号();
        source.hokenshaName = 実施状況Entityリスト.get(index).get市町村名();
        source.nendo = 実施状況Entityリスト.get(index).get対象年度().toDateString();

        YokaigoNinteiJisshiJokyohyoEntity list1 = 実施状況Entityリストlist1.get(index);
        if (null != list1) {
            source.list1_1 = list1.get集計項目();
            source.list1_2 = list1.get四月の合計();
            source.list1_3 = list1.get五月の合計();
            source.list1_4 = list1.get六月の合計();
            source.list1_5 = list1.get七月の合計();
            source.list1_6 = list1.get八月の合計();
            source.list1_7 = list1.get九月の合計();
            source.list1_8 = list1.get十月の合計();
            source.list1_9 = list1.get十一月の合計();
            source.list1_10 = list1.get十二月の合計();
            source.list1_11 = list1.get一月の合計();
            source.list1_12 = list1.get二月の合計();
            source.list1_13 = list1.get三月の合計();
            source.list1_14 = list1.get年度合計();
        }
        YokaigoNinteiJisshiJokyohyoEntity list2 = 実施状況Entityリストlist2.get(index);
        if (null != list2) {
            source.list2_1 = list2.get集計項目();
            source.list2_2 = list2.get四月の合計();
            source.list2_3 = list2.get五月の合計();
            source.list2_4 = list2.get六月の合計();
            source.list2_5 = list2.get七月の合計();
            source.list2_6 = list2.get八月の合計();
            source.list2_7 = list2.get九月の合計();
            source.list2_8 = list2.get十月の合計();
            source.list2_9 = list2.get十一月の合計();
            source.list2_10 = list2.get十二月の合計();
            source.list2_11 = list2.get一月の合計();
            source.list2_12 = list2.get二月の合計();
            source.list2_13 = list2.get三月の合計();
            source.list2_14 = list2.get年度合計();
        }
        YokaigoNinteiJisshiJokyohyoEntity list3 = 実施状況Entityリストlist3.get(index);
        if (null != list3) {
            source.list3_1 = list3.get集計項目();
            source.list3_2 = list3.get四月の合計();
            source.list3_3 = list3.get五月の合計();
            source.list3_4 = list3.get六月の合計();
            source.list3_5 = list3.get七月の合計();
            source.list3_6 = list3.get八月の合計();
            source.list3_7 = list3.get九月の合計();
            source.list3_8 = list3.get十月の合計();
            source.list3_9 = list3.get十一月の合計();
            source.list3_10 = list3.get十二月の合計();
            source.list3_11 = list3.get一月の合計();
            source.list3_12 = list3.get二月の合計();
            source.list3_13 = list3.get三月の合計();
            source.list3_14 = list3.get年度合計();
        }
        YokaigoNinteiJisshiJokyohyoEntity list4 = 実施状況Entityリストlist4.get(index);
        if (null != list4) {
            source.list4_1 = list4.get集計項目();
            source.list4_2 = list4.get四月の合計();
            source.list4_3 = list4.get五月の合計();
            source.list4_4 = list4.get六月の合計();
            source.list4_5 = list4.get七月の合計();
            source.list4_6 = list4.get八月の合計();
            source.list4_7 = list4.get九月の合計();
            source.list4_8 = list4.get十月の合計();
            source.list4_9 = list4.get十一月の合計();
            source.list4_10 = list4.get十二月の合計();
            source.list4_11 = list4.get一月の合計();
            source.list4_12 = list4.get二月の合計();
            source.list4_13 = list4.get三月の合計();
            source.list4_14 = list4.get年度合計();
        }

        source.reportID = new RString("DBD300003");
        source.label17 = new RString("単位：人");

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
