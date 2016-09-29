/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.hanyolist;

import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.entity.report.hanyolist.HanyoListReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 汎用リストのEditorです。
 *
 * @reamsid_L DBZ-4570-020 jinge
 */
public class HanyoListEditor implements IHanyoListEditor {

    private final RString 表題;
    private final RString データ種別;
    private final RString 項目見出し;
    private final RString 項目内容;
    private final Association 地方公共団体;
    private final IOutputOrder outputOrder;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    /**
     * インスタンスを生成します。
     *
     * @param 表題 表題
     * @param データ種別 データ種別
     * @param 項目見出し 項目見出し
     * @param 項目内容 項目内容
     * @param 地方公共団体 地方公共団体
     * @param outputOrder outputOrder
     */
    protected HanyoListEditor(RString 表題, RString データ種別, RString 項目見出し,
            RString 項目内容, Association 地方公共団体, IOutputOrder outputOrder) {
        this.表題 = 表題;
        this.データ種別 = データ種別;
        this.項目見出し = 項目見出し;
        this.項目内容 = 項目内容;
        this.地方公共団体 = 地方公共団体;
        this.outputOrder = outputOrder;
    }

    /**
     * 汎用リストEditorです。
     *
     * @param source HanyoListReportSource
     * @return HanyoListReportSource
     */
    @Override
    public HanyoListReportSource edit(HanyoListReportSource source) {
        setHeader(source);
        set出力内容(source);
        return source;
    }

    private void setHeader(HanyoListReportSource source) {
        source.title = 表題;
        source.subtitle = データ種別;
        source.shichosoncode = 地方公共団体.getLasdecCode_().getColumnValue();
        source.shichosonmei = 地方公共団体.get市町村名();
        source.sakuseiymd = get印刷日時();
        Map<Integer, ISetSortItem> 改頁Map = ChohyoUtil.get改頁項目Map(outputOrder);
        if (改頁Map.get(INDEX_1) != null) {
            source.page1 = 改頁Map.get(INDEX_1).get項目名();
        }
        if (改頁Map.get(INDEX_2) != null) {
            source.page2 = 改頁Map.get(INDEX_2).get項目名();
        }
        if (改頁Map.get(INDEX_3) != null) {
            source.page3 = 改頁Map.get(INDEX_3).get項目名();
        }
        if (改頁Map.get(INDEX_4) != null) {
            source.page4 = 改頁Map.get(INDEX_4).get項目名();
        }
        if (改頁Map.get(INDEX_5) != null) {
            source.page5 = 改頁Map.get(INDEX_5).get項目名();
        }

        Map<Integer, ISetSortItem> 出力順Map = ChohyoUtil.get出力順項目Map(outputOrder);
        if (出力順Map.get(INDEX_1) != null) {
            source.sort1 = 出力順Map.get(INDEX_1).get項目名();
        }
        if (出力順Map.get(INDEX_2) != null) {
            source.sort2 = 出力順Map.get(INDEX_2).get項目名();
        }
        if (出力順Map.get(INDEX_3) != null) {
            source.sort3 = 出力順Map.get(INDEX_3).get項目名();
        }
        if (出力順Map.get(INDEX_4) != null) {
            source.sort4 = 出力順Map.get(INDEX_4).get項目名();
        }
        if (出力順Map.get(INDEX_5) != null) {
            source.sort5 = 出力順Map.get(INDEX_5).get項目名();
        }
    }

    private void set出力内容(HanyoListReportSource source) {
        source.listMeisaititle = 項目見出し;
        source.listMeisailist_1 = 項目内容;
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        return 年月日.concat(時分秒);
    }
}
