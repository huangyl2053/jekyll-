/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査スケジュール表(時間管理)ボディEditorです。
 *
 * @reamsid_L DBE-0020-100 lishengli
 */
class ChosaSchedulehyoJikankanriBodyEditor implements IChosaSchedulehyoJikankanriEditor {

    private final ChosaSchedulehyoJikankanriBodyItem item;
    private static final RString HAKU時 = new RString("08:00");
    private static final RString HAKU時半ごろ = new RString("08:30");
    private static final RString KYU時 = new RString("09:00");
    private static final RString KYU時半ごろ = new RString("09:30");
    private static final RString JYU時 = new RString("10:00");
    private static final RString JYU時半ごろ = new RString("10:30");
    private static final RString JYUITI時 = new RString("11:00");
    private static final RString JYUITI時半ごろ = new RString("11:30");
    private static final RString JYUNI時 = new RString("12:00");
    private static final RString JYUNI時半ごろ = new RString("12:30");
    private static final RString JYUSAN時 = new RString("13:00");
    private static final RString JYUSAN時半ごろ = new RString("13:30");
    private static final RString JYUYON時 = new RString("14:00");
    private static final RString JYUYON時半ごろ = new RString("14:30");
    private static final RString JYUGO時 = new RString("15:00");
    private static final RString JYUGO時半ごろ = new RString("15:30");
    private static final RString JYUROKU時 = new RString("16:00");
    private static final RString JYUROKU時半ごろ = new RString("16:30");
    private static final RString JYUNANA時 = new RString("17:00");
    private static final RString JYUNANA時半ごろ = new RString("17:30");
    private static final RString JYUHAKU時 = new RString("18:00");
    private static final RString JYUHAKU時半ごろ = new RString("18:30");
    private static final RString JYUKYU時 = new RString("19:00");
    private static final RString JYUKYU時半ごろ = new RString("19:30");
    private static final RString NIJYU時 = new RString("20:00");
    private static final RString NIJYU時半ごろ = new RString("20:30");
    private static final RString NIJYUITI時 = new RString("21:00");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaSchedulehyoJikankanriBodyItem}
     */
    protected ChosaSchedulehyoJikankanriBodyEditor(ChosaSchedulehyoJikankanriBodyItem item) {
        this.item = item;
    }

    /**
     * 認定調査スケジュール表(時間管理)ボディのEdit。
     *
     * @param source 認定調査スケジュール表(時間管理)Sourceクラス
     * @return ChosaSchedulehyoJikankanriReportSource
     */
    @Override
    public ChosaSchedulehyoJikankanriReportSource edit(ChosaSchedulehyoJikankanriReportSource source) {
        return editBody(source);
    }

    private ChosaSchedulehyoJikankanriReportSource editBody(ChosaSchedulehyoJikankanriReportSource source) {
        source.listChosaSukejuru2_1 = new RString(String.valueOf(item.getNo()));
        source.listChosaSukejuru2_2 = item.getTyousayinnNo();
        source.listChosaSukejuru2_3 = item.getHihokennsyaNo();
        source.listChosaSukejuru2_4 = item.getRennrakusaki1();
        source.listChosaSukejuru3_1 = item.getTyousayinnName();
        source.listChosaSukejuru3_2 = item.getHihokennsyaName();
        source.listChosaSukejuru3_3 = item.getRennrakusaki2();
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(HAKU時) <= 0
                && HAKU時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_1 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(HAKU時半ごろ) <= 0
                && KYU時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_2 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(KYU時) <= 0
                && KYU時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_3 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(KYU時半ごろ) <= 0
                && JYU時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_4 = item.getYoyakuJokyo();
        }
        setReportSource5_9(source);
        setReportSource10_14(source);
        setReportSource15_19(source);
        setReportSource20_24(source);
        setReportSource25_26(source);
        return source;
    }

    private void setReportSource5_9(ChosaSchedulehyoJikankanriReportSource source) {
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYU時) <= 0
                && JYU時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_5 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYU時半ごろ) <= 0
                && JYUITI時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_6 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUITI時) <= 0
                && JYUITI時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_7 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUITI時半ごろ) <= 0
                && JYUNI時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_8 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUNI時) <= 0
                && JYUNI時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_9 = item.getYoyakuJokyo();
        }
    }

    private void setReportSource10_14(ChosaSchedulehyoJikankanriReportSource source) {
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUNI時半ごろ) <= 0
                && JYUSAN時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_10 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUSAN時) <= 0
                && JYUSAN時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_11 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUSAN時半ごろ) <= 0
                && JYUYON時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_12 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUYON時) <= 0
                && JYUYON時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_13 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUYON時半ごろ) <= 0
                && JYUGO時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_14 = item.getYoyakuJokyo();
        }

    }

    private void setReportSource15_19(ChosaSchedulehyoJikankanriReportSource source) {
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUGO時) <= 0
                && JYUGO時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_15 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUGO時半ごろ) <= 0
                && JYUROKU時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_16 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUROKU時) <= 0
                && JYUROKU時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_17 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUROKU時半ごろ) <= 0
                && JYUNANA時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_18 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUNANA時) <= 0
                && JYUNANA時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_19 = item.getYoyakuJokyo();
        }

    }

    private void setReportSource20_24(ChosaSchedulehyoJikankanriReportSource source) {
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUNANA時半ごろ) <= 0
                && JYUHAKU時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_20 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUHAKU時) <= 0
                && JYUHAKU時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_21 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUHAKU時半ごろ) <= 0
                && JYUKYU時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_22 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUKYU時) <= 0
                && JYUKYU時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_23 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(JYUKYU時半ごろ) <= 0
                && NIJYU時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_24 = item.getYoyakuJokyo();
        }
    }

    private void setReportSource25_26(ChosaSchedulehyoJikankanriReportSource source) {
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(NIJYU時) <= 0
                && NIJYU時半ごろ.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_25 = item.getYoyakuJokyo();
        }
        if (item.getNinteiChosaYoteiKaishiTime().compareTo(NIJYU時半ごろ) <= 0
                && NIJYUITI時.compareTo(item.getNinteiChosaYoteiShuryoTime()) <= 0) {
            source.listChosaSukejuru1_26 = item.getYoyakuJokyo();
        }
    }
}
