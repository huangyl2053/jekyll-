/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300005;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd583001.ToukeiNinzuEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd300005.NenreiKaikyubetsuYokaigodoJokyoReportSource;
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
 * 年齢階級別要介護度状況（統計表）Editorです。
 *
 * @reamsid_L DBD-1790-040 donghj
 */
public class NenreiKaikyubetsuYokaigodoJokyoEditor implements INenreiKaikyubetsuYokaigodoJokyoEditor {

    private final RString 市町村番号;
    private final RString 市町村名;
    private final RString 基準日;
    private final RString 地区;
    private final List<ToukeiNinzuEntity> 統計人数Entityリスト;
    private final int index;
    private static final int INDEX16 = 16;
    private static final int INDEX31 = 31;

    /**
     * インスタンスを生成します。
     *
     * @param 市町村番号 RString
     * @param 市町村名 RString
     * @param 基準日 RString
     * @param 地区 RString
     * @param 統計人数Entityリスト List<ToukeiNinzuEntity>
     * @param index int
     */
    public NenreiKaikyubetsuYokaigodoJokyoEditor(RString 市町村番号, RString 市町村名, RString 基準日, RString 地区,
            List<ToukeiNinzuEntity> 統計人数Entityリスト, int index) {
        this.市町村番号 = 市町村番号;
        this.市町村名 = 市町村名;
        this.基準日 = 基準日;
        this.地区 = 地区;
        this.統計人数Entityリスト = 統計人数Entityリスト;
        this.index = index;
    }

    @Override
    public NenreiKaikyubetsuYokaigodoJokyoReportSource edit(NenreiKaikyubetsuYokaigodoJokyoReportSource source) {
        return edit項目(source);
    }

    private NenreiKaikyubetsuYokaigodoJokyoReportSource edit項目(NenreiKaikyubetsuYokaigodoJokyoReportSource source) {
        source.kijunbi = 基準日;
        source.chiku = 地区;
        source.printTimeStamp = get印刷日時();
        source.shichosonName = 市町村名;
        source.hokenshaNo = 市町村番号;
        source.hokenshaName = 市町村名;
        source.list3_1 = new RString(統計人数Entityリスト.get(index).get自立人数().intValue());
        source.list3_2 = new RString(統計人数Entityリスト.get(index).get経過介護人数().intValue());
        source.list3_3 = new RString(統計人数Entityリスト.get(index).get要支援1人数().intValue());
        source.list3_4 = new RString(統計人数Entityリスト.get(index).get要支援2人数().intValue());
        source.list3_5 = new RString(統計人数Entityリスト.get(index).get要介護1人数().intValue());
        source.list3_6 = new RString(統計人数Entityリスト.get(index).get要介護2人数().intValue());
        source.list3_7 = new RString(統計人数Entityリスト.get(index).get要介護3人数().intValue());
        source.list3_8 = new RString(統計人数Entityリスト.get(index).get要介護4人数().intValue());
        source.list3_9 = new RString(統計人数Entityリスト.get(index).get要介護5人数().intValue());
        source.list3_10 = new RString(統計人数Entityリスト.get(index).get合計().intValue());
        edit区分リスト(source);
        return source;
    }

    private void edit区分リスト(NenreiKaikyubetsuYokaigodoJokyoReportSource source) {
        List<RString> 区分リスト1 = new ArrayList<>();
        List<RString> 区分リスト2 = new ArrayList<>();
        set区分リスト(区分リスト1, 区分リスト2);
        source.list1_1 = 区分リスト1.get(index / 2);
        source.list2_1 = 区分リスト2.get(index / 2);
    }

    private RString get印刷日時() {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        RString 時分秒 = datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(時分秒);
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        return systemDateTime.toRString();
    }

    private void set区分リスト(List<RString> 区分リスト1, List<RString> 区分リスト2) {
        for (int index1 = 0; index1 <= INDEX31; index1++) {
            if (index1 < INDEX16) {
                区分リスト1.add(new RString("人数"));
                区分リスト2.add(new RString("旧措置"));
            } else {
                区分リスト1.add(new RString("男"));
                区分リスト2.add(new RString("女"));
            }
        }
    }

}
