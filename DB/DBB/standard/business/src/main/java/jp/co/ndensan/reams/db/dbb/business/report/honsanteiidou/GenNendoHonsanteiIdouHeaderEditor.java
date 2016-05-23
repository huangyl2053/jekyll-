/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.source.gennendohonsanteiidou.GenNendoHonsanteiIdouSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 本算定異動（現年度）結果一覧表帳票HeaderEditorクラスです
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouHeaderEditor implements IGenNendoHonsanteiIdouEditor {

    private final GenendoIdouKekkaIchiranInputEntity inputEntity;

    private static final int NUM_1 = 0;
    private static final int NUM_2 = 1;
    private static final int NUM_3 = 2;
    private static final int NUM_4 = 3;
    private static final int NUM_5 = 4;
    private static final int NUM_6 = 5;
    private static final int NUM_7 = 6;
    private static final int NUM_8 = 7;
    private static final int NUM_9 = 8;
    private static final int NUM_10 = 9;
    private static final int NUM_11 = 10;
    private static final int NUM_12 = 11;
    private static final int NUM_13 = 12;
    private static final int NUM_14 = 13;
    private static final RString SAKUSEI = new RString("作成");

    /**
     * インスタンスを生成します。
     *
     * @param inputEntity {@link GenendoIdouKekkaIchiranInputEntity}
     */
    protected GenNendoHonsanteiIdouHeaderEditor(GenendoIdouKekkaIchiranInputEntity inputEntity) {
        this.inputEntity = inputEntity;
    }

    @Override
    public GenNendoHonsanteiIdouSource edit(GenNendoHonsanteiIdouSource source) {
        source.printTimeStamp = inputEntity.get調定日時().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()
                .concat(" " + inputEntity.get調定日時().getRDateTime().getTime()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒) + " " + SAKUSEI);
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        List<Kitsuki> 表記リスト = 期月リスト_普徴.toList();
        Kitsuki 最終法定納期 = 期月リスト_普徴.get最終法定納期();
        List<RString> 期の表記 = new ArrayList<>();
        for (Kitsuki 期 : 表記リスト) {
            if (期.get期AsInt() <= 最終法定納期.get期AsInt()) {
                期の表記.add(期.get表記().asX期());
            } else {
                期の表記.add(RString.EMPTY);
            }
        }
        source.fuchoKi1 = 期の表記.get(NUM_1);
        source.fuchoKi2 = 期の表記.get(NUM_2);
        source.fuchoKi3 = 期の表記.get(NUM_3);
        source.fuchoKi4 = 期の表記.get(NUM_4);
        source.fuchoKi5 = 期の表記.get(NUM_5);
        source.fuchoKi6 = 期の表記.get(NUM_6);
        source.fuchoKi7 = 期の表記.get(NUM_7);
        source.fuchoKi8 = 期の表記.get(NUM_8);
        source.fuchoKi9 = 期の表記.get(NUM_9);
        source.fuchoKi10 = 期の表記.get(NUM_10);
        source.fuchoKi11 = 期の表記.get(NUM_11);
        source.fuchoKi12 = 期の表記.get(NUM_12);
        source.fuchoKi13 = 期の表記.get(NUM_13);
        source.fuchoKi14 = 期の表記.get(NUM_14);
        return source;
    }
}
