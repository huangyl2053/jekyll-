/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表 KanendoIdouKekkaIchiranHeaderEditorです。
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class KanendoIdouKekkaIchiranHeaderEditor implements IKanendoIdouKekkaIchiranEditor {

    private final KanendoIdouKekkaIchiranInputEntity inputEntity;

    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final int NUM_7 = 7;
    private static final int NUM_8 = 8;
    private static final int NUM_9 = 9;
    private static final int NUM_10 = 10;
    private static final int NUM_11 = 11;
    private static final int NUM_12 = 12;
    private static final int NUM_13 = 13;
    private static final RString SAKUSEI = new RString("作成");

    /**
     * インスタンスを生成します。
     *
     * @param inputEntity {@link KanendoIdouKekkaIchiranInputEntity}
     */
    protected KanendoIdouKekkaIchiranHeaderEditor(KanendoIdouKekkaIchiranInputEntity inputEntity) {
        this.inputEntity = inputEntity;
    }

    @Override
    public KanendoIdouKekkaIchiranSource edit(KanendoIdouKekkaIchiranSource source) {
        RString date = inputEntity.get調定日時().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString time = inputEntity.get調定日時().getRDateTime().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = date.concat(RString.HALF_SPACE).concat(time);
        KanendoKiUtil 月期対応取得_普徴 = new KanendoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        List<Kitsuki> 表記リスト = 期月リスト_普徴.toList();
        List<RString> 期の表記 = new ArrayList<>();
        for (Kitsuki 期 : 表記リスト) {
            期の表記.add(期.get表記().asX期());
        }
        Collections.reverse(期の表記);
        source.listFuchoKi_1 = 期の表記.get(NUM_0);
        source.listFuchoKi_2 = 期の表記.get(NUM_1);
        source.listFuchoKi_3 = 期の表記.get(NUM_2);
        source.listFuchoKi_4 = 期の表記.get(NUM_3);
        source.listFuchoKi_5 = 期の表記.get(NUM_4);
        source.listFuchoKi_6 = 期の表記.get(NUM_5);
        source.listFuchoKi_7 = 期の表記.get(NUM_6);
        source.listFuchoKi_8 = 期の表記.get(NUM_7);
        source.listFuchoKi_9 = 期の表記.get(NUM_8);
        source.listFuchoKi_10 = 期の表記.get(NUM_9);
        source.listFuchoKi_11 = 期の表記.get(NUM_10);
        source.listFuchoKi_12 = 期の表記.get(NUM_11);
        source.listFuchoKi_13 = 期の表記.get(NUM_12);
        source.listFuchoKi_14 = 期の表記.get(NUM_13);
        return source;
    }

}
