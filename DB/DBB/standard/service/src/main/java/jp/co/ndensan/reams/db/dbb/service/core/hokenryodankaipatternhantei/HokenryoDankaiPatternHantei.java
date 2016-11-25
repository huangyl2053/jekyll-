/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.hokenryodankaipatternhantei;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.HokenryoDankaiPattern;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBHokenryoDankaiPatternHantei_保険料段階パターン判定
 *
 * @reamsid_L DBB-1770-030 yangchenbing
 */
public class HokenryoDankaiPatternHantei {

    private static final int 賦課年度_2005 = 2005;
    private static final int 賦課年度_2006 = 2006;
    private static final int 賦課年度_2008 = 2008;
    private static final int 賦課年度_2009 = 2009;
    private static final int 賦課年度_2011 = 2011;
    private static final int 賦課年度_2012 = 2012;
    private static final int 賦課年度_2014 = 2014;
    private static final RString 定値_03 = new RString("03");
    private static final RString 定値_04 = new RString("04");
    private static final RString 定値_05 = new RString("05");
    private static final RString 定値_06 = new RString("06");
    private static final RString 定値_030 = new RString("030");
    private static final RString 定値_031 = new RString("031");
    private static final RString 定値_040 = new RString("040");
    private static final RString 定値_041 = new RString("041");
    private static final RString 定値_050 = new RString("050");
    private static final RString 定値_051 = new RString("051");
    private static final RString 定値_060 = new RString("060");

    /**
     * 賦課年度・保険料段階リストを元に、保険料段階のパターンを判定して返します。
     *
     * @param 賦課年度 FlexibleYear
     * @param entities List<HokenryoDankai>
     * @return HokenryoDankaiPattern
     */
    public HokenryoDankaiPattern decideHokenryoDankaiPattern(FlexibleYear 賦課年度, List<HokenryoDankai> entities) {
        if (賦課年度.getYearValue() <= 賦課年度_2005) {
            return HokenryoDankaiPattern.パターン無し;
        } else if (賦課年度.getYearValue() >= 賦課年度_2006 && 賦課年度.getYearValue() <= 賦課年度_2008) {
            return HokenryoDankaiPattern.パターン無し;
        } else if (賦課年度.getYearValue() >= 賦課年度_2009 && 賦課年度.getYearValue() <= 賦課年度_2011) {
            return get2009_2011_パターン判定処理(entities);
        } else if (賦課年度.getYearValue() >= 賦課年度_2012 && 賦課年度.getYearValue() <= 賦課年度_2014) {
            return get2012_2014_パターン判定処理(entities);
        } else {
            return HokenryoDankaiPattern.パターン無し;
        }
    }

    private HokenryoDankaiPattern get2009_2011_パターン判定処理(List<HokenryoDankai> entitylist) {
        if (パターン判定処理(entitylist, 定値_04, 定値_040)) {
            if (パターン判定処理(entitylist, 定値_05, 定値_040)) {
                return HokenryoDankaiPattern._2009_パターン1;
            } else if (パターン判定処理(entitylist, 定値_05, 定値_050)) {
                return HokenryoDankaiPattern._2009_パターン3;
            }
        } else if (パターン判定処理(entitylist, 定値_04, 定値_041) && パターン判定処理(entitylist, 定値_05, 定値_040)) {
            return HokenryoDankaiPattern._2009_パターン2;
        }
        return HokenryoDankaiPattern.パターン無し;
    }

    private HokenryoDankaiPattern get2012_2014_パターン判定処理(List<HokenryoDankai> entitylist) {
        if (パターン判定処理(entitylist, 定値_03, 定値_030)) {
            return get段階区分の判定03030判定処理(entitylist);
        } else if (パターン判定処理(entitylist, 定値_03, 定値_031)) {
            if (パターン判定処理(entitylist, 定値_04, 定値_030) && パターン判定処理(entitylist, 定値_05, 定値_040)
                    && パターン判定処理(entitylist, 定値_06, 定値_040)) {
                return HokenryoDankaiPattern._2012_パターン4;
            } else if (パターン判定処理(entitylist, 定値_04, 定値_030) && パターン判定処理(entitylist, 定値_05, 定値_041)
                    && パターン判定処理(entitylist, 定値_06, 定値_040)) {
                return HokenryoDankaiPattern._2012_パターン5;
            } else if (パターン判定処理(entitylist, 定値_04, 定値_030) && パターン判定処理(entitylist, 定値_05, 定値_040)
                    && パターン判定処理(entitylist, 定値_06, 定値_050)) {
                return HokenryoDankaiPattern._2012_パターン6;
            }
        }
        return HokenryoDankaiPattern.パターン無し;
    }

    private HokenryoDankaiPattern get段階区分の判定03030判定処理(List<HokenryoDankai> entitylist) {
        if (パターン判定処理(entitylist, 定値_04, 定値_030) && パターン判定処理(entitylist, 定値_05, 定値_040)
                && パターン判定処理(entitylist, 定値_06, 定値_040)) {
            return HokenryoDankaiPattern._2012_パターン1;
        } else if (パターン判定処理(entitylist, 定値_04, 定値_030) && パターン判定処理(entitylist, 定値_05, 定値_041)
                && パターン判定処理(entitylist, 定値_06, 定値_040)) {
            return HokenryoDankaiPattern._2012_パターン2;
        } else if (パターン判定処理(entitylist, 定値_04, 定値_030) && パターン判定処理(entitylist, 定値_05, 定値_040)
                && パターン判定処理(entitylist, 定値_06, 定値_050)) {
            return HokenryoDankaiPattern._2012_パターン3;
        } else if (パターン判定処理(entitylist, 定値_04, 定値_040) && パターン判定処理(entitylist, 定値_05, 定値_050)
                && パターン判定処理(entitylist, 定値_06, 定値_050)) {
            return HokenryoDankaiPattern._2012_パターン7;
        } else if (パターン判定処理(entitylist, 定値_04, 定値_040) && パターン判定処理(entitylist, 定値_05, 定値_051)
                && パターン判定処理(entitylist, 定値_06, 定値_050)) {
            return HokenryoDankaiPattern._2012_パターン8;
        } else if (パターン判定処理(entitylist, 定値_04, 定値_040) && パターン判定処理(entitylist, 定値_05, 定値_050)
                && パターン判定処理(entitylist, 定値_06, 定値_060)) {
            return HokenryoDankaiPattern._2012_パターン9;
        }
        return HokenryoDankaiPattern.パターン無し;
    }

    private boolean パターン判定処理(List<HokenryoDankai> entitylist, RString インデックス, RString 段階区分の判定) {
        for (HokenryoDankai entity : entitylist) {
            if (インデックス.equals(entity.get段階インデックス()) && 段階区分の判定.equals(entity.get段階区分())) {
                return true;
            }
        }
        return false;
    }
}
