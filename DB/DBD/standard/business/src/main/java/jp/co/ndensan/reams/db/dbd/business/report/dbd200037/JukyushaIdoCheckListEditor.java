/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200037;

import java.util.Map;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.LowerEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.UpperEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200037.JukyushaIdoCheckListReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
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
 * 受給者台帳異動チェックリストのEditorです。
 *
 * @reamsid_L DBD-1770-040 donghj
 */
public class JukyushaIdoCheckListEditor implements IJukyushaIdoCheckListEditor {

    private final UpperEntity upperEntity;
    private final LowerEntity lowerEntity;
    private final IOutputOrder iOutputOrder;
    private final IOutputOrder breakoutputOrder;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final int LISTINDEX_5 = 5;

    /**
     * インスタンスを生成します。
     *
     * @param upperEntity {@link UpperEntity}
     * @param lowerEntity {@link LowerEntity}
     * @param iOutputOrder {@link IOutputOrder}
     * @param breakoutputOrder {@link IOutputOrder}
     */
    public JukyushaIdoCheckListEditor(UpperEntity upperEntity, LowerEntity lowerEntity,
            IOutputOrder iOutputOrder, IOutputOrder breakoutputOrder) {
        this.upperEntity = upperEntity;
        this.lowerEntity = lowerEntity;
        this.iOutputOrder = iOutputOrder;
        this.breakoutputOrder = breakoutputOrder;
    }

    /**
     * 受給者台帳異動チェックリストeditです。
     *
     * @param source JukyushaIdoCheckListReportSource
     * @return JukyushaIdoCheckListReportSource
     */
    @Override
    public JukyushaIdoCheckListReportSource edit(JukyushaIdoCheckListReportSource source) {
        return edit項目(source);
    }

    private JukyushaIdoCheckListReportSource edit項目(JukyushaIdoCheckListReportSource source) {
        editHead(source);
        editリスト一覧表上(source);
        edit出力順改頁(source);
        editリスト一覧表下(source);
        return source;
    }

    private void editHead(JukyushaIdoCheckListReportSource source) {
        source.printTimeStamp = get印刷日時();
    }

    private void editリスト一覧表上(JukyushaIdoCheckListReportSource source) {
        if (upperEntity != null) {
            source.hokenshaNo = upperEntity.get保険者番号() == null ? RString.EMPTY : upperEntity.get保険者番号().value();
            source.hokenshaName = upperEntity.get保険者名称();
            source.listUpper_1 = upperEntity.get被保険者番号() == null ? RString.EMPTY : upperEntity.get被保険者番号().value();
            source.listUpper_2 = upperEntity.get識別コード() == null ? RString.EMPTY : upperEntity.get識別コード().value();
            source.listUpper_3 = upperEntity.get住所() == null ? RString.EMPTY : upperEntity.get住所().value();
            source.listUpper_4 = upperEntity.getフリガナ() == null ? RString.EMPTY : upperEntity.getフリガナ().value();
            source.listUpper_5 = upperEntity.get生年月日() == null ? RString.EMPTY : new RString(upperEntity.get生年月日().toString());
            source.listUpper_6 = upperEntity.get異動区分();
            source.listUpper_7 = upperEntity.get処理種別();
            source.listUpper_8 = upperEntity.get受給申請日() == null ? RString.EMPTY : new RString(upperEntity.get受給申請日().toString());
            source.listUpper_9 = upperEntity.get認定日() == null ? RString.EMPTY : new RString(upperEntity.get認定日().toString());
            source.listUpper_10 = upperEntity.get認定有効開始日() == null ? RString.EMPTY : new RString(upperEntity.get認定有効開始日().toString());
            source.listUpper_11 = upperEntity.get喪失年月日() == null ? RString.EMPTY : new RString(upperEntity.get喪失年月日().toString());
            source.listUpper_12 = upperEntity.get異動事由();
            source.listUpper_13 = upperEntity.get有効無効();

        }
    }

    private void edit出力順改頁(JukyushaIdoCheckListReportSource source) {
        if (iOutputOrder != null) {
            setiOutputOrder(source);
        }
        if (breakoutputOrder != null) {
            setBreakIoutputOrder(source);
        }
    }

    private void editリスト一覧表下(JukyushaIdoCheckListReportSource source) {
        if (lowerEntity != null) {
            source.listLower_1 = lowerEntity.get住所コード() == null ? RString.EMPTY : lowerEntity.get住所コード().value();
            source.listLower_2 = lowerEntity.get行政区コード() == null ? RString.EMPTY : lowerEntity.get行政区コード().value();
            source.listLower_3 = lowerEntity.get行政区();
            source.listLower_4 = lowerEntity.get氏名() == null ? RString.EMPTY : lowerEntity.get氏名().value();
            source.listLower_5 = new RString(lowerEntity.get年齢());
            source.listLower_6 = lowerEntity.get受給申請事由();
            source.listLower_7 = lowerEntity.get要介護度();
            source.listLower_8 = lowerEntity.get認定有効終了日() == null ? RString.EMPTY : new RString(lowerEntity.get認定有効終了日().toString());
            source.listLower_9 = lowerEntity.get旧措置者();
            source.listLower_10 = lowerEntity.get処理内容();
            source.listLower_11 = lowerEntity.get備考();

        }
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

    private void setiOutputOrder(JukyushaIdoCheckListReportSource source) {

        Map<Integer, ISetSortItem> 出力順Map = ChohyoUtil.get出力順項目Map(iOutputOrder);
        if (出力順Map.get(LISTINDEX_1) != null) {
            source.shutsuryokujun1 = 出力順Map.get(LISTINDEX_1).get項目名();
        }
        if (出力順Map.get(LISTINDEX_2) != null) {
            source.shutsuryokujun2 = 出力順Map.get(LISTINDEX_2).get項目名();
        }
        if (出力順Map.get(LISTINDEX_3) != null) {
            source.shutsuryokujun3 = 出力順Map.get(LISTINDEX_3).get項目名();
        }
        if (出力順Map.get(LISTINDEX_4) != null) {
            source.shutsuryokujun4 = 出力順Map.get(LISTINDEX_4).get項目名();
        }
        if (出力順Map.get(LISTINDEX_5) != null) {
            source.shutsuryokujun5 = 出力順Map.get(LISTINDEX_5).get項目名();
        }
    }

    private void setBreakIoutputOrder(JukyushaIdoCheckListReportSource source) {

        Map<Integer, ISetSortItem> 改頁Map = ChohyoUtil.get改頁項目Map(breakoutputOrder);
        if (改頁Map.get(LISTINDEX_1) != null) {
            source.kaipage1 = 改頁Map.get(LISTINDEX_1).get項目名();
        }
        if (改頁Map.get(LISTINDEX_2) != null) {
            source.kaipage2 = 改頁Map.get(LISTINDEX_2).get項目名();
        }
        if (改頁Map.get(LISTINDEX_3) != null) {
            source.kaipage3 = 改頁Map.get(LISTINDEX_3).get項目名();
        }
        if (改頁Map.get(LISTINDEX_4) != null) {
            source.kaipage4 = 改頁Map.get(LISTINDEX_4).get項目名();
        }
        if (改頁Map.get(LISTINDEX_5) != null) {
            source.kaipage5 = 改頁Map.get(LISTINDEX_5).get項目名();
        }

    }

}
