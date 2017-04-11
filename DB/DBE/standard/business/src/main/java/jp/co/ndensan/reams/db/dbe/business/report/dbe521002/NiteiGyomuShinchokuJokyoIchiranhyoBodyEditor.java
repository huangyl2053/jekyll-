/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe521002;

import jp.co.ndensan.reams.db.dbe.definition.core.util.accesslog.ExpandedInformations;
import jp.co.ndensan.reams.db.dbe.entity.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護認定業務進捗状況一覧表ボディEditorです。
 *
 * @reamsid_L DBE-0210-020 dongyabin
 */
public class NiteiGyomuShinchokuJokyoIchiranhyoBodyEditor implements INiteiGyomuShinchokuJokyoIchiranhyoEditor {

    private final NiteiGyomuShinchokuJokyoIchiranhyoBodyItem item;
    private final int no;

    /**
     * インスタンスを生成します。
     *
     * @param item 要介護認定業務進捗状況一覧表リスト一覧表情報
     * @param no NO
     */
    public NiteiGyomuShinchokuJokyoIchiranhyoBodyEditor(NiteiGyomuShinchokuJokyoIchiranhyoBodyItem item, int no) {
        this.item = item;
        this.no = no + 1;
    }

    /**
     * 要介護認定業務進捗状況一覧表ボディEditorです。
     *
     * @param source 要介護認定業務進捗状況一覧表Source
     * @return 要介護認定業務進捗状況一覧表Source
     */
    @Override
    public NiteiGyomuShinchokuJokyoIchiranhyoReportSource edit(NiteiGyomuShinchokuJokyoIchiranhyoReportSource source) {
        return bodyEdit(source);
    }

    private NiteiGyomuShinchokuJokyoIchiranhyoReportSource bodyEdit(NiteiGyomuShinchokuJokyoIchiranhyoReportSource source) {
        source.shikibetuCode = new ShikibetsuCode(item.getShoKisaiHokenshaNo().substring(0, 5).concat(item.getListIchiranhyo2_3()));
        source.shinseishoKanriNo = ExpandedInformations.fromValue(item.getShinseishoKanriNo())[0];
        source.listIchiranhyo1_1 = new RString(String.valueOf(no));
        source.listIchiranhyo1_2 = item.getListIchiranhyo1_2();
        source.listIchiranhyo1_3 = item.getListIchiranhyo1_3();
        source.listIchiranhyo1_4 = item.getListIchiranhyo1_4();
        source.listIchiranhyo1_5 = item.getListIchiranhyo1_5();
        source.listIchiranhyo1_6 = item.getListIchiranhyo1_6();
        source.listIchiranhyo1_7 = item.getListIchiranhyo1_7();
        source.listIchiranhyo1_8 = item.getListIchiranhyo1_8();
        source.listIchiranhyo1_9 = item.getListIchiranhyo1_9();
        source.listIchiranhyo1_10 = item.getListIchiranhyo1_10().isEmpty() ? RString.EMPTY : new FlexibleDate(item.
                getListIchiranhyo1_10()).wareki().separator(Separator.PERIOD).
                fillType(FillType.ZERO).toDateString();
        source.listHihokenshaName_1 = item.getListHihokenshaName_1();
        source.listHihokenshaJusho_1 = item.getListHihokenshaJusho_1();
        source.listIchiranhyo2_1 = item.getListIchiranhyo2_1().isEmpty() ? RString.EMPTY : new FlexibleDate(item.
                getListIchiranhyo2_1()).wareki().separator(Separator.PERIOD).
                fillType(FillType.ZERO).toDateString();
        source.listIchiranhyo2_2 = item.getListIchiranhyo2_2();
        source.listIchiranhyo2_3 = item.getListIchiranhyo2_3();
        source.listChosaItakusakiName_1 = item.getListChosaItakusakiName_1();
        source.listChosainName_1 = item.getListChosainName_1();
        source.listIryokikanName_1 = item.getListIryokikanName_1();
        source.listIshiName_1 = item.getListIshiName_1();
        source.listShinsaYoteiYMD_1 = item.getListShinsaYoteiYMD_1().isEmpty() ? RString.EMPTY : new FlexibleDate(item.
                getListShinsaYoteiYMD_1()).wareki().separator(Separator.PERIOD).
                fillType(FillType.ZERO).toDateString();
        return source;
    }

}
