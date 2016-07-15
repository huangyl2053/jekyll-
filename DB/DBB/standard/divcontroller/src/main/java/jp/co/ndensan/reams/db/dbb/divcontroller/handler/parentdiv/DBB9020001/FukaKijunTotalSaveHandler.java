/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HokenryoDankaiPattern;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.FukaKijunTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.dgHokenryoDankai_Row;
import jp.co.ndensan.reams.db.dbb.service.core.fukakijuntotal.FukaKijunTotalManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * システム管理（賦課基準）保存のハンドラクラスです。
 *
 * @reamsid_L DBB-1770-010 wangkanglei
 */
public class FukaKijunTotalSaveHandler {

    private final FukaKijunTotalDiv div;
    private static final FlexibleYear 平成27年 = new FlexibleYear("2015");
    private static final FlexibleYear 平成26年 = new FlexibleYear("2014");
    private static final FlexibleYear 平成24年 = new FlexibleYear("2012");
    private static final FlexibleYear 平成23年 = new FlexibleYear("2011");
    private static final FlexibleYear 平成21年 = new FlexibleYear("2009");
    private static final FlexibleYear 平成20年 = new FlexibleYear("2008");
    private static final FlexibleYear 平成18年 = new FlexibleYear("2006");
    private static final FlexibleYear 平成17年 = new FlexibleYear("2005");
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
    private static final int NUM_14 = 14;
    private static final int NUM_15 = 15;
    private static final int NUM_16 = 16;
    private static final int NUM_17 = 17;
    private static final int NUM_18 = 18;
    private static final int NUM_19 = 19;
    private static final int NUM_20 = 20;
    private static final int NUM_21 = 21;
    private static final RString STR_ZERO = new RString("0");
    private static final RString STR_ONE = new RString("1");
    private static final RString インデックス_01 = new RString("01");
    private static final RString インデックス_02 = new RString("02");
    private static final RString インデックス_03 = new RString("03");
    private static final RString インデックス_04 = new RString("04");
    private static final RString インデックス_05 = new RString("05");
    private static final RString インデックス_06 = new RString("06");
    private static final RString インデックス_07 = new RString("07");
    private static final RString インデックス_08 = new RString("08");
    private static final RString インデックス_09 = new RString("09");
    private static final RString インデックス_10 = new RString("10");
    private static final RString インデックス_11 = new RString("11");
    private static final RString インデックス_12 = new RString("12");
    private static final RString インデックス_13 = new RString("13");
    private static final RString インデックス_14 = new RString("14");
    private static final RString インデックス_15 = new RString("15");
    private static final RString インデックス_16 = new RString("16");
    private static final RString インデックス_17 = new RString("17");
    private static final RString インデックス_18 = new RString("18");
    private static final RString インデックス_19 = new RString("19");
    private static final RString インデックス_20 = new RString("20");
    private static final RString インデックス_21 = new RString("21");
    private static final RString インデックス_22 = new RString("22");
    private static final RString 第5段階KEY = new RString("第5段階");
    private static final RString 第6段階KEY = new RString("第6段階");
    private static final RString 第7段階KEY = new RString("第7段階");
    private static final RString 第8段階KEY = new RString("第8段階");
    private static final RString 第9段階KEY = new RString("第9段階");
    private static final RString 第10段階KEY = new RString("第10段階");
    private static final RString 第11段階KEY = new RString("第11段階");
    private static final RString 第12段階KEY = new RString("第12段階");
    private static final RString 第13段階KEY = new RString("第13段階");
    private static final RString 第14段階KEY = new RString("第14段階");
    private static final RString 第15段階KEY = new RString("第15段階");
    private static final RString 第16段階KEY = new RString("第16段階");
    private static final RString 第17段階KEY = new RString("第17段階");
    private static final RString 第18段階KEY = new RString("第18段階");
    private static final RString 第19段階KEY = new RString("第19段階");
    private static final RString 第20段階KEY = new RString("第20段階");
    private static final RString 段階_030 = new RString("030");
    private static final RString 段階_031 = new RString("031");
    private static final RString 段階_040 = new RString("040");
    private static final RString 段階_041 = new RString("041");
    private static final RString 段階_050 = new RString("050");
    private static final RString 段階_051 = new RString("051");
    private static final RString 段階_060 = new RString("060");
    private static final RString 段階_070 = new RString("070");
    private static final RString 段階_080 = new RString("080");
    private static final RString 段階_090 = new RString("090");
    private static final RString 段階_100 = new RString("100");
    private static final RString 段階_110 = new RString("110");
    private static final RString 段階_120 = new RString("120");
    private static final RString 段階_130 = new RString("130");
    private static final RString 段階_140 = new RString("140");
    private static final RString 段階_150 = new RString("150");
    private static final RString 段階_160 = new RString("160");
    private static final RString 段階_170 = new RString("170");
    private static final RString 段階_180 = new RString("180");
    private static final RString 段階_190 = new RString("190");
    private static final RString 段階_200 = new RString("200");
    private static final RString 変更理由KEY = new RString("を使用して更新");

    /**
     * コンストラクタです。
     *
     * @param div システム管理（賦課基準）の画面Div
     */
    public FukaKijunTotalSaveHandler(FukaKijunTotalDiv div) {
        this.div = div;
    }

    /**
     * 変更内容を取得のメソッドです。
     *
     * @param 保険料段階一覧 List
     * @param now システム日時
     * @return 保険料段階List
     */
    public List<HokenryoDankai> get変更内容(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        if (賦課年度.isBeforeOrEquals(平成17年)) {
            return get変更内容_平成17年(保険料段階一覧);
        } else if (平成18年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成20年)) {
            return get変更内容_平成18年から平成20年まで(保険料段階一覧, now);
        } else if (平成21年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成23年)) {
            return get変更内容_平成21年から平成23年まで(保険料段階一覧);
        } else if (平成24年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成26年)) {
            return get変更内容_平成24年から平成26年まで(保険料段階一覧);
        } else if (平成27年.isBeforeOrEquals(賦課年度)) {
            return get変更内容_平成27年(保険料段階一覧);
        }
        return new ArrayList<>();
    }

    /**
     * 変更内容を保存のメソッドです。
     *
     * @param 保険料段階一覧 List
     * @param now システム日時
     */
    public void 変更内容を保存(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        if (賦課年度.isBeforeOrEquals(平成17年)) {
            変更内容を保存_平成17年(保険料段階一覧, now);
            業務コンフィグへの保存_未申告(now);
            業務コンフィグへの保存_所得調査中(now);
            業務コンフィグへの保存_年額保険料(now);
        } else if (平成18年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成20年)) {
            変更内容を保存_平成18年から平成20年まで(保険料段階一覧, now);
            業務コンフィグへの保存_未申告(now);
            業務コンフィグへの保存_所得調査中(now);
            業務コンフィグへの保存_年額保険料(now);
        } else if (平成21年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成23年)) {
            変更内容を保存_平成21年から平成23年まで(保険料段階一覧, now);
            業務コンフィグへの保存_未申告(now);
            業務コンフィグへの保存_所得調査中(now);
            業務コンフィグへの保存_年額保険料(now);
        } else if (平成24年.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(平成26年)) {
            変更内容を保存_平成24年から平成26年まで(保険料段階一覧, now);
            業務コンフィグへの保存_未申告(now);
            業務コンフィグへの保存_所得調査中(now);
            if (賦課年度.equals(平成26年)) {
                業務コンフィグへの保存_課税取消(now);
            }
            業務コンフィグへの保存_年額保険料(now);
        } else if (平成27年.isBeforeOrEquals(賦課年度)) {
            変更内容を保存_平成27年(保険料段階一覧, now);
            業務コンフィグへの保存_未申告(now);
            業務コンフィグへの保存_所得調査中(now);
            業務コンフィグへの保存_課税取消(now);
            業務コンフィグへの保存_年額保険料(now);
        }
    }

    private List<HokenryoDankai> get変更内容_平成17年(List<HokenryoDankai> 保険料段階一覧) {
        List<HokenryoDankai> 保険料段階List = new ArrayList<>();
        Decimal 保険料率;
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            HokenryoDankai 段階Entity = null;
            RString インデックス = 保険料段階.get段階インデックス();
            if (インデックス_01.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai1Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            } else if (インデックス_02.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai2Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            } else if (インデックス_03.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            } else if (インデックス_04.equals(インデックス)) {
                保険料率 = get保険料率(インデックス);
                if (保険料率 != null) {
                    段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                }
            } else if (インデックス_05.equals(インデックス)) {
                保険料率 = get保険料率(インデックス);
                if (保険料率 != null) {
                    段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                }
            }
            if (段階Entity != null) {
                保険料段階List.add(段階Entity);
            }
        }
        return 保険料段階List;
    }

    private void 変更内容を保存_平成17年(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FukaKijunTotalManager.createInstance().save保険料段階(保険料段階一覧);
        List<dgHokenryoDankai_Row> rowList = div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai()
                .getDataSource();
        Decimal 基準所得金額;
        int 行目Flag = 0;
        for (dgHokenryoDankai_Row row : rowList) {
            行目Flag = 行目Flag + NUM_1;
            if (NUM_2 == 行目Flag) {
                基準所得金額 = row.getTxtKijunShotokuKingaku().getValue();
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額1,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            }
        }
    }

    private List<HokenryoDankai> get変更内容_平成18年から平成20年まで(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        List<HokenryoDankai> 保険料段階List = new ArrayList<>();
        Decimal 保険料率;
        FlexibleYear 激変緩和_開始年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.激変緩和_開始年度,
                now, SubGyomuCode.DBB介護賦課));
        FlexibleYear 激変緩和_終了年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.激変緩和_終了年度,
                now, SubGyomuCode.DBB介護賦課));
        FlexibleYear 賦課年度 = new FlexibleYear(div.getKonkaiShoriNaiyo().getDdlFukaNendo().getSelectedKey());
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            HokenryoDankai 段階Entity = null;
            RString インデックス = 保険料段階.get段階インデックス();
            if (インデックス_01.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai1Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            } else if (インデックス_02.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai2Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            } else if (インデックス_03.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            } else if (インデックス_07.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            }
            if (激変緩和_開始年度.isBeforeOrEquals(賦課年度) && 賦課年度.isBeforeOrEquals(激変緩和_終了年度)) {
                if (インデックス_04.equals(インデックス)) {
                    保険料率 = DataPassingConverter.deserialize(
                            div.getShotokuDankai().getShotokuDankaiTo2014().getHdnGekihenIndex04(), Decimal.class);
                    段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                } else if (インデックス_05.equals(インデックス)) {
                    保険料率 = DataPassingConverter.deserialize(
                            div.getShotokuDankai().getShotokuDankaiTo2014().getHdnGekihenIndex05(), Decimal.class);
                    段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                } else if (インデックス_06.equals(インデックス)) {
                    保険料率 = DataPassingConverter.deserialize(
                            div.getShotokuDankai().getShotokuDankaiTo2014().getHdnGekihenIndex06(), Decimal.class);
                    段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                } else if (インデックス_08.equals(インデックス)) {
                    保険料率 = DataPassingConverter.deserialize(
                            div.getShotokuDankai().getShotokuDankaiTo2014().getHdnGekihenIndex08(), Decimal.class);
                    段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                } else if (インデックス_09.equals(インデックス)) {
                    保険料率 = DataPassingConverter.deserialize(
                            div.getShotokuDankai().getShotokuDankaiTo2014().getHdnGekihenIndex09(), Decimal.class);
                    段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                } else if (インデックス_10.equals(インデックス)) {
                    保険料率 = DataPassingConverter.deserialize(
                            div.getShotokuDankai().getShotokuDankaiTo2014().getHdnGekihenIndex10(), Decimal.class);
                    段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                } else if (インデックス_11.equals(インデックス)) {
                    保険料率 = DataPassingConverter.deserialize(
                            div.getShotokuDankai().getShotokuDankaiTo2014().getHdnGekihenIndex11(), Decimal.class);
                    段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                }
            }
            if (インデックス_12.compareTo(インデックス) < NUM_1) {
                段階Entity = get変更保険料段階_平成18年から平成20年まで(保険料段階, インデックス);
            }
            if (段階Entity != null) {
                保険料段階List.add(段階Entity);
            }
        }
        return 保険料段階List;
    }

    private void 変更内容を保存_平成18年から平成20年まで(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FukaKijunTotalManager.createInstance().save保険料段階(保険料段階一覧);
        Decimal 基準所得金額 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtKijunShotokuKingakuDankai2().getValue();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準年金収入1,
                new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);

        List<dgHokenryoDankai_Row> rowList = div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai()
                .getDataSource();
        int 行目Flag = 0;
        for (dgHokenryoDankai_Row row : rowList) {
            行目Flag = 行目Flag + NUM_1;
            基準所得金額 = row.getTxtKijunShotokuKingaku().getValue();
            if (NUM_2 == 行目Flag) {
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額1,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
            } else if (NUM_3 == 行目Flag) {
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額2,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
            } else if (NUM_4 == 行目Flag) {
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額3,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
            } else if (NUM_5 == 行目Flag) {
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額4,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
            } else if (NUM_6 == 行目Flag) {
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額5,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
            }
        }
    }

    private HokenryoDankai get変更保険料段階_平成18年から平成20年まで(HokenryoDankai 保険料段階, RString 段階インデックス) {
        List<dgHokenryoDankai_Row> rowList = div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai()
                .getDataSource();
        Decimal 保険料率;
        for (dgHokenryoDankai_Row row : rowList) {
            保険料率 = row.getTxtHokenryoRitsu().getValue();
            RString 段階 = row.getDdlHokenryoDankai().getSelectedValue();
            if (保険料率 != null) {
                if (インデックス_12.equals(段階インデックス) && 第5段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                } else if (インデックス_13.equals(段階インデックス) && 第6段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                } else if (インデックス_14.equals(段階インデックス) && 第7段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                } else if (インデックス_15.equals(段階インデックス) && 第8段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                } else if (インデックス_16.equals(段階インデックス) && 第9段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                } else if (インデックス_17.equals(段階インデックス) && 第10段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
                }
            }
        }
        return null;
    }

    private List<HokenryoDankai> get変更内容_平成21年から平成23年まで(List<HokenryoDankai> 保険料段階一覧) {
        List<HokenryoDankai> 保険料段階List = new ArrayList<>();
        Decimal 保険料率;
        List<dgHokenryoDankai_Row> rowList = div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai()
                .getDataSource();
        RString パターン = div.getHdnPatan();
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            RString インデックス = 保険料段階.get段階インデックス();
            HokenryoDankai 段階Entity;
            if (インデックス_01.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai1Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            } else if (インデックス_02.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai2Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            } else if (インデックス_03.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            } else {
                段階Entity = get本人非課税_世帯課税段階(保険料段階, パターン, インデックス, rowList);
            }
            if (段階Entity != null) {
                保険料段階List.add(段階Entity);
            }
        }
        return 保険料段階List;
    }

    private void 変更内容を保存_平成21年から平成23年まで(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FukaKijunTotalManager.createInstance().save保険料段階(保険料段階一覧);
        Decimal 基準所得金額;
        Decimal 基準年金収入3 = null;
        List<dgHokenryoDankai_Row> rowList = div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai()
                .getDataSource();
        RString パターン = div.getHdnPatan();
        if (HokenryoDankaiPattern._2009_パターン1.getコード().equals(パターン)) {
            基準年金収入3 = Decimal.ZERO;
        } else if (HokenryoDankaiPattern._2009_パターン2.getコード().equals(パターン)) {
            基準年金収入3 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai4().getValue();
        } else if (HokenryoDankaiPattern._2009_パターン3.getコード().equals(パターン)) {
            基準年金収入3 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai4().getValue();
        }
        基準所得金額 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtKijunShotokuKingakuDankai2().getValue();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準年金収入1,
                new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
        if (基準年金収入3 != null) {
            BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準年金収入3,
                    new RString(基準年金収入3.toString()), get変更理由(), RString.EMPTY, now);
        }
        int 行目Flag = NUM_1;
        for (dgHokenryoDankai_Row row : rowList) {
            基準所得金額 = row.getTxtKijunShotokuKingaku().getValue();
            if (基準所得金額 != null) {
                業務コンフィグへの保存__平成21年から平成23年まで(行目Flag, now, 基準所得金額);
            }
            行目Flag = 行目Flag + NUM_1;
        }
    }

    private HokenryoDankai get本人非課税_世帯課税段階(HokenryoDankai 保険料段階,
            RString パターン,
            RString インデックス,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        if (HokenryoDankaiPattern._2009_パターン1.getコード().equals(パターン)) {
            if (インデックス_04.equals(インデックス) || インデックス_05.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai().getValue();
                return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
            } else if (インデックス_06.compareTo(インデックス) < NUM_1) {
                return get保険料段階_平成21年から平成23年まで(保険料段階, インデックス, rowList);
            }
        } else if (HokenryoDankaiPattern._2009_パターン2.getコード().equals(パターン)) {
            if (インデックス_04.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().getValue();
                return 保険料段階.createBuilderForEdit().set段階区分(段階_041).set保険料率(保険料率).build();
            } else if (インデックス_05.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai().getValue();
                return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
            } else if (インデックス_06.compareTo(インデックス) < NUM_1) {
                return get保険料段階_平成21年から平成23年まで(保険料段階, インデックス, rowList);
            }
        } else if (HokenryoDankaiPattern._2009_パターン3.getコード().equals(パターン)) {
            if (インデックス_04.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().getValue();
                return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
            } else if (インデックス_05.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai().getValue();
                return 保険料段階.createBuilderForEdit().set段階区分(段階_050).set保険料率(保険料率).build();
            } else if (インデックス_06.compareTo(インデックス) < NUM_1) {
                return get保険料段階_平成21年から平成23年_2009_パターン3(保険料段階, インデックス, rowList);
            }
        }
        return null;
    }

    private HokenryoDankai get保険料段階_平成21年から平成23年まで(HokenryoDankai 保険料段階,
            RString 段階インデックス,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        for (dgHokenryoDankai_Row row : rowList) {
            保険料率 = row.getTxtHokenryoRitsu().getValue();
            RString 段階 = row.getDdlHokenryoDankai().getSelectedValue();
            if (保険料率 != null) {
                if (インデックス_06.equals(段階インデックス) && 第5段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_050).set保険料率(保険料率).build();
                } else if (インデックス_07.equals(段階インデックス) && 第6段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_060).set保険料率(保険料率).build();
                } else if (インデックス_08.equals(段階インデックス) && 第7段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_070).set保険料率(保険料率).build();
                } else if (インデックス_09.equals(段階インデックス) && 第8段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_080).set保険料率(保険料率).build();
                } else if (インデックス_10.equals(段階インデックス) && 第9段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_090).set保険料率(保険料率).build();
                } else if (インデックス_11.equals(段階インデックス) && 第10段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_100).set保険料率(保険料率).build();
                }
            }
        }
        return null;
    }

    private HokenryoDankai get保険料段階_平成21年から平成23年_2009_パターン3(HokenryoDankai 保険料段階,
            RString 段階インデックス,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        for (dgHokenryoDankai_Row row : rowList) {
            保険料率 = row.getTxtHokenryoRitsu().getValue();
            RString 段階 = row.getDdlHokenryoDankai().getSelectedValue();
            if (保険料率 != null) {
                if (インデックス_06.equals(段階インデックス) && 第6段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_060).set保険料率(保険料率).build();
                } else if (インデックス_07.equals(段階インデックス) && 第7段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_070).set保険料率(保険料率).build();
                } else if (インデックス_08.equals(段階インデックス) && 第8段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_080).set保険料率(保険料率).build();
                } else if (インデックス_09.equals(段階インデックス) && 第9段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_090).set保険料率(保険料率).build();
                } else if (インデックス_10.equals(段階インデックス) && 第10段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_100).set保険料率(保険料率).build();
                } else if (インデックス_11.equals(段階インデックス) && 第11段階KEY.equals(段階)) {
                    return 保険料段階.createBuilderForEdit().set段階区分(段階_110).set保険料率(保険料率).build();
                }
            }
        }
        return null;
    }

    private void 業務コンフィグへの保存__平成21年から平成23年まで(int 行目Flag, RDate now, Decimal 基準所得金額) {
        switch (行目Flag) {
            case NUM_2:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額1,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_3:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額2,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_4:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額3,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_5:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額4,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_6:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額5,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_7:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額6,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_8:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額7,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_9:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額8,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_10:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額9,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_11:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額10,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_12:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額11,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_13:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額12,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_14:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額13,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_15:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額14,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_16:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額15,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            default:
                break;
        }
    }

    private List<HokenryoDankai> get変更内容_平成24年から平成26年まで(List<HokenryoDankai> 保険料段階一覧) {
        List<HokenryoDankai> 保険料段階List = new ArrayList<>();
        Decimal 保険料率;
        List<dgHokenryoDankai_Row> rowList = div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai()
                .getDataSource();
        RString パターン = div.getHdnPatan();
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            RString インデックス = 保険料段階.get段階インデックス();
            HokenryoDankai 段階Entity = null;
            if (インデックス_01.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai1Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            } else if (インデックス_02.equals(インデックス)) {
                保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai2Dankai().getValue();
                段階Entity = 保険料段階.createBuilderForEdit().set保険料率(保険料率).build();
            } else if (HokenryoDankaiPattern._2012_パターン1.getコード().equals(パターン)) {
                段階Entity = get保険料段階_2012_パターン1(インデックス, 保険料段階, rowList);
            } else if (HokenryoDankaiPattern._2012_パターン2.getコード().equals(パターン)) {
                段階Entity = get保険料段階_2012_パターン2(インデックス, 保険料段階, rowList);
            } else if (HokenryoDankaiPattern._2012_パターン3.getコード().equals(パターン)) {
                段階Entity = get保険料段階_2012_パターン3(インデックス, 保険料段階, rowList);
            } else if (HokenryoDankaiPattern._2012_パターン4.getコード().equals(パターン)) {
                段階Entity = get保険料段階_2012_パターン4(インデックス, 保険料段階, rowList);
            } else if (HokenryoDankaiPattern._2012_パターン5.getコード().equals(パターン)) {
                段階Entity = get保険料段階_2012_パターン5(インデックス, 保険料段階, rowList);
            } else if (HokenryoDankaiPattern._2012_パターン6.getコード().equals(パターン)) {
                段階Entity = get保険料段階_2012_パターン6(インデックス, 保険料段階, rowList);
            } else if (HokenryoDankaiPattern._2012_パターン7.getコード().equals(パターン)) {
                段階Entity = get保険料段階_2012_パターン7(インデックス, 保険料段階, rowList);
            } else if (HokenryoDankaiPattern._2012_パターン8.getコード().equals(パターン)) {
                段階Entity = get保険料段階_2012_パターン8(インデックス, 保険料段階, rowList);
            } else if (HokenryoDankaiPattern._2012_パターン9.getコード().equals(パターン)) {
                段階Entity = get保険料段階_2012_パターン9(インデックス, 保険料段階, rowList);
            }
            if (段階Entity != null) {
                保険料段階List.add(段階Entity);
            }
        }
        return 保険料段階List;
    }

    private void 変更内容を保存_平成24年から平成26年まで(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FukaKijunTotalManager.createInstance().save保険料段階(保険料段階一覧);
        Decimal 基準所得金額 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtKijunShotokuKingakuDankai2().getValue();
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準年金収入1,
                new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
        RString パターン = div.getHdnPatan();
        業務コンフィグへの保存_平成24年から平成26年まで(パターン, now);
        List<dgHokenryoDankai_Row> rowList = div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai()
                .getDataSource();
        int 行目Flag = NUM_1;
        for (dgHokenryoDankai_Row row : rowList) {
            基準所得金額 = row.getTxtKijunShotokuKingaku().getValue();
            if (基準所得金額 != null) {
                業務コンフィグへの保存__平成21年から平成23年まで(行目Flag, now, 基準所得金額);
            }
            行目Flag = 行目Flag + NUM_1;
        }
    }

    private HokenryoDankai get保険料段階_2012_パターン1(RString インデックス,
            HokenryoDankai 保険料段階,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        if (インデックス_03.equals(インデックス) || インデックス_04.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai()
                    .getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_030).set保険料率(保険料率).build();
        } else if (インデックス_05.equals(インデックス) || インデックス_06.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
        } else if (インデックス_07.compareTo(インデックス) < NUM_1) {
            return get保険料段階_平成24年から平成26年まで_第5段階(保険料段階, インデックス, rowList);
        }
        return null;
    }

    private HokenryoDankai get保険料段階_2012_パターン2(RString インデックス,
            HokenryoDankai 保険料段階,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        if (インデックス_03.equals(インデックス) || インデックス_04.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai()
                    .getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_030).set保険料率(保険料率).build();
        } else if (インデックス_05.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_041).set保険料率(保険料率).build();
        } else if (インデックス_06.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
        } else if (インデックス_07.compareTo(インデックス) < NUM_1) {
            return get保険料段階_平成24年から平成26年まで_第5段階(保険料段階, インデックス, rowList);
        }
        return null;
    }

    private HokenryoDankai get保険料段階_2012_パターン3(RString インデックス,
            HokenryoDankai 保険料段階,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        if (インデックス_03.equals(インデックス) || インデックス_04.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai()
                    .getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_030).set保険料率(保険料率).build();
        } else if (インデックス_05.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
        } else if (インデックス_06.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_050).set保険料率(保険料率).build();
        } else if (インデックス_07.compareTo(インデックス) < NUM_1) {
            return get保険料段階_平成24年から平成26年まで_第6段階(保険料段階, インデックス, rowList);
        }
        return null;
    }

    private HokenryoDankai get保険料段階_2012_パターン4(RString インデックス,
            HokenryoDankai 保険料段階,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        if (インデックス_03.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaisho()
                    .getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_031).set保険料率(保険料率).build();
        } else if (インデックス_04.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai()
                    .getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_030).set保険料率(保険料率).build();
        } else if (インデックス_05.equals(インデックス) || インデックス_06.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai()
                    .getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
        } else if (インデックス_07.compareTo(インデックス) < NUM_1) {
            return get保険料段階_平成24年から平成26年まで_第5段階(保険料段階, インデックス, rowList);
        }
        return null;
    }

    private HokenryoDankai get保険料段階_2012_パターン5(RString インデックス,
            HokenryoDankai 保険料段階,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        if (インデックス_03.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaisho().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_031).set保険料率(保険料率).build();
        } else if (インデックス_04.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_030).set保険料率(保険料率).build();
        } else if (インデックス_05.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_041).set保険料率(保険料率).build();
        } else if (インデックス_06.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
        } else if (インデックス_07.compareTo(インデックス) < NUM_1) {
            return get保険料段階_平成24年から平成26年まで_第5段階(保険料段階, インデックス, rowList);
        }
        return null;
    }

    private HokenryoDankai get保険料段階_2012_パターン6(RString インデックス,
            HokenryoDankai 保険料段階,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        if (インデックス_03.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaisho().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_031).set保険料率(保険料率).build();
        } else if (インデックス_04.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_030).set保険料率(保険料率).build();
        } else if (インデックス_05.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
        } else if (インデックス_06.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_050).set保険料率(保険料率).build();
        } else if (インデックス_07.compareTo(インデックス) < NUM_1) {
            return get保険料段階_平成24年から平成26年まで_第6段階(保険料段階, インデックス, rowList);
        }
        return null;
    }

    private HokenryoDankai get保険料段階_2012_パターン7(RString インデックス,
            HokenryoDankai 保険料段階,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        if (インデックス_03.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaisho().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_030).set保険料率(保険料率).build();
        } else if (インデックス_04.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
        } else if (インデックス_05.equals(インデックス) || インデックス_06.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_050).set保険料率(保険料率).build();
        } else if (インデックス_07.compareTo(インデックス) < NUM_1) {
            return get保険料段階_平成24年から平成26年まで_第6段階(保険料段階, インデックス, rowList);
        }
        return null;
    }

    private HokenryoDankai get保険料段階_2012_パターン8(RString インデックス,
            HokenryoDankai 保険料段階,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        if (インデックス_03.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaisho().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_030).set保険料率(保険料率).build();
        } else if (インデックス_04.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
        } else if (インデックス_05.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_051).set保険料率(保険料率).build();
        } else if (インデックス_06.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_050).set保険料率(保険料率).build();
        } else if (インデックス_07.compareTo(インデックス) < NUM_1) {
            return get保険料段階_平成24年から平成26年まで_第6段階(保険料段階, インデックス, rowList);
        }
        return null;
    }

    private HokenryoDankai get保険料段階_2012_パターン9(RString インデックス,
            HokenryoDankai 保険料段階,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        if (インデックス_03.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaisho().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_030).set保険料率(保険料率).build();
        } else if (インデックス_04.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai3DankaiKeigenTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_040).set保険料率(保険料率).build();
        } else if (インデックス_05.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaisho().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_050).set保険料率(保険料率).build();
        } else if (インデックス_06.equals(インデックス)) {
            保険料率 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxtHokenryoRitsuDai4DankaiTaishoGai().getValue();
            return 保険料段階.createBuilderForEdit().set段階区分(段階_060).set保険料率(保険料率).build();
        } else if (インデックス_07.compareTo(インデックス) < NUM_1) {
            return get保険料段階_平成24年から平成26年まで_第7段階(保険料段階, インデックス, rowList);
        }
        return null;
    }

    private HokenryoDankai get保険料段階_平成24年から平成26年まで_第5段階(HokenryoDankai 保険料段階,
            RString 段階インデックス,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        HokenryoDankai 保険料段階Entity = null;
        for (dgHokenryoDankai_Row row : rowList) {
            保険料率 = row.getTxtHokenryoRitsu().getValue();
            RString 段階 = row.getDdlHokenryoDankai().getSelectedValue();
            if (保険料率 == null) {
                continue;
            }
            if (インデックス_07.equals(段階インデックス) && 第5段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_050).set保険料率(保険料率).build();
                break;
            } else if (インデックス_08.equals(段階インデックス) && 第6段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_060).set保険料率(保険料率).build();
                break;
            } else if (インデックス_09.equals(段階インデックス) && 第7段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_070).set保険料率(保険料率).build();
                break;
            } else if (インデックス_10.equals(段階インデックス) && 第8段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_080).set保険料率(保険料率).build();
                break;
            } else if (インデックス_11.equals(段階インデックス) && 第9段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_090).set保険料率(保険料率).build();
                break;
            } else if (インデックス_12.equals(段階インデックス) && 第10段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_100).set保険料率(保険料率).build();
                break;
            } else if (インデックス_13.equals(段階インデックス) && 第11段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_110).set保険料率(保険料率).build();
                break;
            } else {
                保険料段階Entity = get保険料段階_第5段階(保険料段階, 段階インデックス, 保険料率, 段階);
                if (保険料段階Entity != null) {
                    break;
                }
            }
        }
        return 保険料段階Entity;
    }

    private HokenryoDankai get保険料段階_第5段階(HokenryoDankai 保険料段階,
            RString 段階インデックス,
            Decimal 保険料率,
            RString 段階) {
        if (インデックス_14.equals(段階インデックス) && 第12段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_120).set保険料率(保険料率).build();
        } else if (インデックス_15.equals(段階インデックス) && 第13段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_130).set保険料率(保険料率).build();
        } else if (インデックス_16.equals(段階インデックス) && 第14段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_140).set保険料率(保険料率).build();
        } else if (インデックス_17.equals(段階インデックス) && 第15段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_150).set保険料率(保険料率).build();
        } else if (インデックス_18.equals(段階インデックス) && 第16段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_160).set保険料率(保険料率).build();
        } else if (インデックス_19.equals(段階インデックス) && 第17段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_170).set保険料率(保険料率).build();
        } else if (インデックス_20.equals(段階インデックス) && 第18段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_180).set保険料率(保険料率).build();
        } else if (インデックス_21.equals(段階インデックス) && 第19段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_190).set保険料率(保険料率).build();
        } else if (インデックス_22.equals(段階インデックス) && 第20段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_200).set保険料率(保険料率).build();
        }
        return null;
    }

    private HokenryoDankai get保険料段階_平成24年から平成26年まで_第6段階(HokenryoDankai 保険料段階,
            RString 段階インデックス,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        HokenryoDankai 保険料段階Entity = null;
        for (dgHokenryoDankai_Row row : rowList) {
            保険料率 = row.getTxtHokenryoRitsu().getValue();
            RString 段階 = row.getDdlHokenryoDankai().getSelectedValue();
            if (保険料率 == null) {
                continue;
            }
            if (インデックス_07.equals(段階インデックス) && 第6段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_060).set保険料率(保険料率).build();
                break;
            } else if (インデックス_08.equals(段階インデックス) && 第7段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_070).set保険料率(保険料率).build();
                break;
            } else if (インデックス_09.equals(段階インデックス) && 第8段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_080).set保険料率(保険料率).build();
                break;
            } else if (インデックス_10.equals(段階インデックス) && 第9段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_090).set保険料率(保険料率).build();
                break;
            } else if (インデックス_11.equals(段階インデックス) && 第10段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_100).set保険料率(保険料率).build();
                break;
            } else if (インデックス_12.equals(段階インデックス) && 第11段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_110).set保険料率(保険料率).build();
                break;
            } else if (インデックス_13.equals(段階インデックス) && 第12段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_120).set保険料率(保険料率).build();
                break;
            } else {
                保険料段階Entity = get保険料段階_第6段階(保険料段階, 段階インデックス, 保険料率, 段階);
                if (保険料段階Entity != null) {
                    break;
                }
            }
        }
        return 保険料段階Entity;
    }

    private HokenryoDankai get保険料段階_第6段階(HokenryoDankai 保険料段階,
            RString 段階インデックス,
            Decimal 保険料率,
            RString 段階) {
        if (インデックス_14.equals(段階インデックス) && 第13段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_130).set保険料率(保険料率).build();
        } else if (インデックス_15.equals(段階インデックス) && 第14段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_140).set保険料率(保険料率).build();
        } else if (インデックス_16.equals(段階インデックス) && 第15段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_150).set保険料率(保険料率).build();
        } else if (インデックス_17.equals(段階インデックス) && 第16段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_160).set保険料率(保険料率).build();
        } else if (インデックス_18.equals(段階インデックス) && 第17段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_170).set保険料率(保険料率).build();
        } else if (インデックス_19.equals(段階インデックス) && 第18段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_180).set保険料率(保険料率).build();
        } else if (インデックス_20.equals(段階インデックス) && 第19段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_190).set保険料率(保険料率).build();
        } else if (インデックス_21.equals(段階インデックス) && 第20段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_200).set保険料率(保険料率).build();
        }
        return null;
    }

    private HokenryoDankai get保険料段階_平成24年から平成26年まで_第7段階(HokenryoDankai 保険料段階,
            RString 段階インデックス,
            List<dgHokenryoDankai_Row> rowList) {
        Decimal 保険料率;
        HokenryoDankai 保険料段階Entity = null;
        for (dgHokenryoDankai_Row row : rowList) {
            保険料率 = row.getTxtHokenryoRitsu().getValue();
            RString 段階 = row.getDdlHokenryoDankai().getSelectedValue();
            if (保険料率 == null) {
                continue;
            }
            if (インデックス_07.equals(段階インデックス) && 第7段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_070).set保険料率(保険料率).build();
                break;
            } else if (インデックス_08.equals(段階インデックス) && 第8段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_080).set保険料率(保険料率).build();
                break;
            } else if (インデックス_09.equals(段階インデックス) && 第9段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_090).set保険料率(保険料率).build();
                break;
            } else if (インデックス_10.equals(段階インデックス) && 第10段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_100).set保険料率(保険料率).build();
                break;
            } else if (インデックス_11.equals(段階インデックス) && 第11段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_110).set保険料率(保険料率).build();
                break;
            } else if (インデックス_12.equals(段階インデックス) && 第12段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_120).set保険料率(保険料率).build();
                break;
            } else if (インデックス_13.equals(段階インデックス) && 第13段階KEY.equals(段階)) {
                保険料段階Entity = 保険料段階.createBuilderForEdit().set段階区分(段階_130).set保険料率(保険料率).build();
                break;
            } else {
                保険料段階Entity = get保険料段階_第7段階(保険料段階, 段階インデックス, 保険料率, 段階);
                if (保険料段階Entity != null) {
                    break;
                }
            }
        }
        return 保険料段階Entity;
    }

    private HokenryoDankai get保険料段階_第7段階(HokenryoDankai 保険料段階,
            RString 段階インデックス,
            Decimal 保険料率,
            RString 段階) {
        if (インデックス_14.equals(段階インデックス) && 第14段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_140).set保険料率(保険料率).build();
        } else if (インデックス_15.equals(段階インデックス) && 第15段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_150).set保険料率(保険料率).build();
        } else if (インデックス_16.equals(段階インデックス) && 第16段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_160).set保険料率(保険料率).build();
        } else if (インデックス_17.equals(段階インデックス) && 第17段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_170).set保険料率(保険料率).build();
        } else if (インデックス_18.equals(段階インデックス) && 第18段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_180).set保険料率(保険料率).build();
        } else if (インデックス_19.equals(段階インデックス) && 第19段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_190).set保険料率(保険料率).build();
        } else if (インデックス_20.equals(段階インデックス) && 第20段階KEY.equals(段階)) {
            return 保険料段階.createBuilderForEdit().set段階区分(段階_200).set保険料率(保険料率).build();
        }
        return null;
    }

    private void 業務コンフィグへの保存_平成24年から平成26年まで(RString パターン, RDate now) {
        Decimal 基準年金収入2 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai3().getValue();
        Decimal 基準年金収入3 = div.getShotokuDankai().getShotokuDankaiTo2014().getTxKijunShotokuKingakuDankai4().getValue();
        if (HokenryoDankaiPattern._2012_パターン1.getコード().equals(パターン)) {
            業務コンフィグへの保存_基準年金収入(Decimal.ZERO, Decimal.ZERO, now);
        } else if (HokenryoDankaiPattern._2012_パターン2.getコード().equals(パターン)) {
            業務コンフィグへの保存_基準年金収入(Decimal.ZERO, 基準年金収入3, now);
        } else if (HokenryoDankaiPattern._2012_パターン3.getコード().equals(パターン)) {
            業務コンフィグへの保存_基準年金収入(Decimal.ZERO, 基準年金収入3, now);
        } else if (HokenryoDankaiPattern._2012_パターン4.getコード().equals(パターン)) {
            業務コンフィグへの保存_基準年金収入(基準年金収入2, Decimal.ZERO, now);
        } else if (HokenryoDankaiPattern._2012_パターン5.getコード().equals(パターン)) {
            業務コンフィグへの保存_基準年金収入(基準年金収入2, 基準年金収入3, now);
        } else if (HokenryoDankaiPattern._2012_パターン6.getコード().equals(パターン)) {
            業務コンフィグへの保存_基準年金収入(基準年金収入2, 基準年金収入3, now);
        } else if (HokenryoDankaiPattern._2012_パターン7.getコード().equals(パターン)) {
            業務コンフィグへの保存_基準年金収入(基準年金収入2, Decimal.ZERO, now);
        } else if (HokenryoDankaiPattern._2012_パターン8.getコード().equals(パターン)) {
            業務コンフィグへの保存_基準年金収入(基準年金収入2, 基準年金収入3, now);
        } else if (HokenryoDankaiPattern._2012_パターン9.getコード().equals(パターン)) {
            業務コンフィグへの保存_基準年金収入(基準年金収入2, 基準年金収入3, now);
        }
    }

    private void 業務コンフィグへの保存_基準年金収入(Decimal 基準年金収入2, Decimal 基準年金収入3, RDate now) {
        if (基準年金収入2 != null) {
            BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準年金収入2,
                    new RString(基準年金収入2.toString()), get変更理由(), RString.EMPTY, now);
        }
        if (基準年金収入3 != null) {
            BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準年金収入3,
                    new RString(基準年金収入3.toString()), get変更理由(), RString.EMPTY, now);
        }
    }

    private List<HokenryoDankai> get変更内容_平成27年(List<HokenryoDankai> 保険料段階一覧) {
        List<HokenryoDankai> 保険料段階List = new ArrayList<>();
        Decimal 保険料率;
        List<dgHokenryoDankai_Row> rowList = div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai()
                .getDataSource();
        Map<RString, HokenryoDankai> map = new HashMap<>();
        for (HokenryoDankai 保険料段階 : 保険料段階一覧) {
            map.put(保険料段階.get段階インデックス(), 保険料段階);
        }
        HokenryoDankai 保存を保険料段階;
        for (dgHokenryoDankai_Row row : rowList) {
            RString 順番 = row.getTxtHokenryoDankaiIndex().getValue();
            RString 段階区分 = row.getDdlHokenryoDankai().getSelectedKey();
            RString 特例表記 = row.getTxtTokureiHyoji().getValue();
            保険料率 = row.getTxtHokenryoRitsu().getValue();
            保存を保険料段階 = map.get(順番);
            if (特例表記 != null && !特例表記.isEmpty()) {
                段階区分 = 段階区分.substring(NUM_2, NUM_4).concat(STR_ONE);
            } else {
                段階区分 = 段階区分.substring(NUM_2, NUM_4).concat(STR_ZERO);
                特例表記 = RString.EMPTY;
            }
            保存を保険料段階 = 保存を保険料段階.createBuilderForEdit()
                    .set段階区分(段階区分)
                    .set保険料率(保険料率)
                    .set特例表記(特例表記).build();
            保険料段階List.add(保存を保険料段階);
        }
        return 保険料段階List;
    }

    private void 変更内容を保存_平成27年(List<HokenryoDankai> 保険料段階一覧, RDate now) {
        FukaKijunTotalManager.createInstance().save保険料段階(保険料段階一覧);
        Decimal 基準所得金額;
        List<dgHokenryoDankai_Row> rowList = div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai()
                .getDataSource();
        for (dgHokenryoDankai_Row row : rowList) {
            RString 順番 = row.getTxtHokenryoDankaiIndex().getValue();
            基準所得金額 = row.getTxtKijunShotokuKingaku().getValue();
            if (基準所得金額 != null) {
                業務コンフィグへの保存_平成27年(Integer.valueOf(順番.toString()), now, 基準所得金額);
            }
        }
    }

    private void 業務コンフィグへの保存_平成27年(int 行目Flag, RDate now, Decimal 基準所得金額) {
        switch (行目Flag) {
            case NUM_2:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準年金収入1,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_3:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準年金収入3,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_5:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準年金収入2,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_7:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額1,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_8:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額2,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_9:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額3,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_10:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額4,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_11:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額5,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_12:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額6,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_13:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額7,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_14:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額8,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_15:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額9,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_16:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額10,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_17:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額11,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_18:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額12,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_19:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額13,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_20:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額14,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            case NUM_21:
                BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_基準所得金額15,
                        new RString(基準所得金額.toString()), get変更理由(), RString.EMPTY, now);
                break;
            default:
                break;
        }
    }

    private Decimal get保険料率(RString 段階インデックス) {
        List<dgHokenryoDankai_Row> rowList = div.getShotokuDankai().getHokenryoDankaiFrom2015().getDgHokenryoDankai()
                .getDataSource();
        for (dgHokenryoDankai_Row row : rowList) {
            if (段階インデックス.equals(row.getTxtHokenryoDankaiIndex().getValue())) {
                return row.getTxtHokenryoRitsu().getValue();
            }
        }
        return null;
    }

    private void 業務コンフィグへの保存_未申告(RDate now) {
        RString 強制設定_未申告 = div.getHokenryoRitsuIgaiInfo().getMishinkoku()
                .getRadMishinkokuKyoseiSettei().getSelectedKey();
        RString 設定段階_未申告 = div.getHokenryoRitsuIgaiInfo().getMishinkoku()
                .getDdlMishinkokuKyoseiSettei().getSelectedKey();
        RString 課税区分の見直し方_未申告 = div.getHokenryoRitsuIgaiInfo().getMishinkoku()
                .getRadtMishinkokuKazeiKbn().getSelectedKey();

        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_未申告保険料段階使用,
                強制設定_未申告, get変更理由(), RString.EMPTY, now);
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_未申告保険料段階インデックス,
                設定段階_未申告, get変更理由(), RString.EMPTY, now);
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_未申告課税区分,
                課税区分の見直し方_未申告, get変更理由(), RString.EMPTY, now);
    }

    private void 業務コンフィグへの保存_所得調査中(RDate now) {
        RString 強制設定_所得調査中 = div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu()
                .getRadShotokuChosaChuKyoseiSettei().getSelectedKey();
        RString 設定段階_所得調査中 = div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu()
                .getDdlShotokuChosaChuKyoseiSettei().getSelectedKey();
        RString 課税区分の見直し方_所得調査中 = div.getHokenryoRitsuIgaiInfo().getShotokuChosaChu()
                .getRadShotokuChosaChuKazeiKbn().getSelectedKey();

        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_所得調査中保険料段階使用,
                強制設定_所得調査中, get変更理由(), RString.EMPTY, now);
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_所得調査中保険料段階インデックス,
                設定段階_所得調査中, get変更理由(), RString.EMPTY, now);
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_所得調査中課税区分,
                課税区分の見直し方_所得調査中, get変更理由(), RString.EMPTY, now);
    }

    private void 業務コンフィグへの保存_課税取消(RDate now) {
        RString 強制設定_課税取消 = div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi()
                .getRadKazeiTorikeshiKyoseiSettei().getSelectedKey();
        RString 設定段階_課税取消 = div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi()
                .getDdlKazeiTorikeshiKyoseiSettei().getSelectedKey();
        RString 課税区分の見直し方_課税取消 = div.getHokenryoRitsuIgaiInfo().getKazeiTorikeshi()
                .getRadKazeiTorikeshiKazeiKbn().getSelectedKey();

        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_課税取消保険料段階使用,
                強制設定_課税取消, get変更理由(), RString.EMPTY, now);
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_課税取消保険料段階インデックス,
                設定段階_課税取消, get変更理由(), RString.EMPTY, now);
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.賦課基準_課税取消課税区分,
                課税区分の見直し方_課税取消, get変更理由(), RString.EMPTY, now);
    }

    private void 業務コンフィグへの保存_年額保険料(RDate now) {
        RString 端数 = div.getHokenryoRitsuIgaiInfo().getNengakuHokenryo().getDdlHasu().getSelectedKey();
        RString 丸め方 = div.getHokenryoRitsuIgaiInfo().getNengakuHokenryo().getDdlMarumeKata().getSelectedKey();

        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.年額計算_端数調整単位_通常,
                端数, get変更理由(), RString.EMPTY, now);
        BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.年額計算_端数調整方法_通常,
                丸め方, get変更理由(), RString.EMPTY, now);
    }

    private RString get変更理由() {
        RStringBuilder 変更理由 = new RStringBuilder();
        変更理由.append(UrControlDataFactory.createInstance().getMenuID()).append(変更理由KEY);
        return 変更理由.toRString();
    }
}
