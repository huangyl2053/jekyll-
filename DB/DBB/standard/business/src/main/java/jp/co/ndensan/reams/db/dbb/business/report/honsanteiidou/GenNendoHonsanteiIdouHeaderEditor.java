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
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定異動（現年度）結果一覧表帳票HeaderEditorクラスです
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouHeaderEditor implements IGenNendoHonsanteiIdouEditor {

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

    /**
     * インスタンスを生成します。
     *
     */
    protected GenNendoHonsanteiIdouHeaderEditor() {

    }

    @Override
    public GenNendoHonsanteiIdouSource edit(GenNendoHonsanteiIdouSource source) {
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        List<Kitsuki> 表記リスト = 期月リスト_普徴.toList();
        Kitsuki 最終法定納期 = 期月リスト_普徴.get最終法定納期();
        List<RString> 期の表記 = new ArrayList<>();
        for (Kitsuki 期 : 表記リスト) {
            if (期.get期AsInt() != 0 && 期.get期AsInt() <= 最終法定納期.get期AsInt()) {
                期の表記.add(期.get表記().asX期());
            } else {
                期の表記.add(RString.EMPTY);
            }
        }
        if (!期の表記.get(NUM_14).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_14);
            source.fuchoKi2 = 期の表記.get(NUM_13);
            source.fuchoKi3 = 期の表記.get(NUM_12);
            source.fuchoKi4 = 期の表記.get(NUM_11);
            source.fuchoKi5 = 期の表記.get(NUM_10);
            source.fuchoKi6 = 期の表記.get(NUM_9);
            source.fuchoKi7 = 期の表記.get(NUM_8);
            source.fuchoKi8 = 期の表記.get(NUM_7);
            source.fuchoKi9 = 期の表記.get(NUM_6);
            source.fuchoKi10 = 期の表記.get(NUM_5);
            source.fuchoKi11 = 期の表記.get(NUM_4);
            source.fuchoKi12 = 期の表記.get(NUM_3);
            source.fuchoKi13 = 期の表記.get(NUM_2);
            source.fuchoKi14 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_13).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_13);
            source.fuchoKi2 = 期の表記.get(NUM_12);
            source.fuchoKi3 = 期の表記.get(NUM_11);
            source.fuchoKi4 = 期の表記.get(NUM_10);
            source.fuchoKi5 = 期の表記.get(NUM_9);
            source.fuchoKi6 = 期の表記.get(NUM_8);
            source.fuchoKi7 = 期の表記.get(NUM_7);
            source.fuchoKi8 = 期の表記.get(NUM_6);
            source.fuchoKi9 = 期の表記.get(NUM_5);
            source.fuchoKi10 = 期の表記.get(NUM_4);
            source.fuchoKi11 = 期の表記.get(NUM_3);
            source.fuchoKi12 = 期の表記.get(NUM_2);
            source.fuchoKi13 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_12).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_12);
            source.fuchoKi2 = 期の表記.get(NUM_11);
            source.fuchoKi3 = 期の表記.get(NUM_10);
            source.fuchoKi4 = 期の表記.get(NUM_9);
            source.fuchoKi5 = 期の表記.get(NUM_8);
            source.fuchoKi6 = 期の表記.get(NUM_7);
            source.fuchoKi7 = 期の表記.get(NUM_6);
            source.fuchoKi8 = 期の表記.get(NUM_5);
            source.fuchoKi9 = 期の表記.get(NUM_4);
            source.fuchoKi10 = 期の表記.get(NUM_3);
            source.fuchoKi11 = 期の表記.get(NUM_2);
            source.fuchoKi12 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_11).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_11);
            source.fuchoKi2 = 期の表記.get(NUM_10);
            source.fuchoKi3 = 期の表記.get(NUM_9);
            source.fuchoKi4 = 期の表記.get(NUM_8);
            source.fuchoKi5 = 期の表記.get(NUM_7);
            source.fuchoKi6 = 期の表記.get(NUM_6);
            source.fuchoKi7 = 期の表記.get(NUM_5);
            source.fuchoKi8 = 期の表記.get(NUM_4);
            source.fuchoKi9 = 期の表記.get(NUM_3);
            source.fuchoKi10 = 期の表記.get(NUM_2);
            source.fuchoKi11 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_10).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_10);
            source.fuchoKi2 = 期の表記.get(NUM_9);
            source.fuchoKi3 = 期の表記.get(NUM_8);
            source.fuchoKi4 = 期の表記.get(NUM_7);
            source.fuchoKi5 = 期の表記.get(NUM_6);
            source.fuchoKi6 = 期の表記.get(NUM_5);
            source.fuchoKi7 = 期の表記.get(NUM_4);
            source.fuchoKi8 = 期の表記.get(NUM_3);
            source.fuchoKi9 = 期の表記.get(NUM_2);
            source.fuchoKi10 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_9).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_9);
            source.fuchoKi2 = 期の表記.get(NUM_8);
            source.fuchoKi3 = 期の表記.get(NUM_7);
            source.fuchoKi4 = 期の表記.get(NUM_6);
            source.fuchoKi5 = 期の表記.get(NUM_5);
            source.fuchoKi6 = 期の表記.get(NUM_4);
            source.fuchoKi7 = 期の表記.get(NUM_3);
            source.fuchoKi8 = 期の表記.get(NUM_2);
            source.fuchoKi9 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_8).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_8);
            source.fuchoKi2 = 期の表記.get(NUM_7);
            source.fuchoKi3 = 期の表記.get(NUM_6);
            source.fuchoKi4 = 期の表記.get(NUM_5);
            source.fuchoKi5 = 期の表記.get(NUM_4);
            source.fuchoKi6 = 期の表記.get(NUM_3);
            source.fuchoKi7 = 期の表記.get(NUM_2);
            source.fuchoKi8 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_7).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_7);
            source.fuchoKi2 = 期の表記.get(NUM_6);
            source.fuchoKi3 = 期の表記.get(NUM_5);
            source.fuchoKi4 = 期の表記.get(NUM_4);
            source.fuchoKi5 = 期の表記.get(NUM_3);
            source.fuchoKi6 = 期の表記.get(NUM_2);
            source.fuchoKi7 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_6).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_6);
            source.fuchoKi2 = 期の表記.get(NUM_5);
            source.fuchoKi3 = 期の表記.get(NUM_4);
            source.fuchoKi4 = 期の表記.get(NUM_3);
            source.fuchoKi5 = 期の表記.get(NUM_2);
            source.fuchoKi6 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_5).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_5);
            source.fuchoKi2 = 期の表記.get(NUM_4);
            source.fuchoKi3 = 期の表記.get(NUM_3);
            source.fuchoKi4 = 期の表記.get(NUM_2);
            source.fuchoKi5 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_4).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_4);
            source.fuchoKi2 = 期の表記.get(NUM_3);
            source.fuchoKi3 = 期の表記.get(NUM_2);
            source.fuchoKi4 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_3).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_3);
            source.fuchoKi2 = 期の表記.get(NUM_2);
            source.fuchoKi3 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_2).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_2);
            source.fuchoKi2 = 期の表記.get(NUM_1);
        } else if (!期の表記.get(NUM_1).isEmpty()) {
            source.fuchoKi1 = 期の表記.get(NUM_1);
        }
        return source;
    }
}
