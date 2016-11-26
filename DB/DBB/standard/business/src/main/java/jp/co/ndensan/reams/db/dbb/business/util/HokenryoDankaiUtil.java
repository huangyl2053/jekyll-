/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.util;

import jp.co.ndensan.reams.db.dbx.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 保険料段階のユーティリティクラスです。
 */
public final class HokenryoDankaiUtil {

    private static final RString 基本表記 = new RString("第%1$d段階");
    private static final RString 基本表記2 = new RString("%1$d段階");
    private static final RString 改正前表記 = new RString("(改正前%1$d)");
    private static final RString 対象外表記 = new RString("-");

    private HokenryoDankaiUtil() {

    }

    /**
     * 表示用の保険料段階を編集して返します。
     *
     * @param hokenryoDankai 保険料段階
     * @return 表示用の保険料段階
     */
    public static RString edit表示用保険料段階(HokenryoDankai hokenryoDankai) {

        if (hokenryoDankai == null) {
            return RString.EMPTY;
        }

        DbT2013HokenryoDankaiEntity entity = hokenryoDankai.toEntity();

        RString 段階区分 = entity.getDankaiKubun();
        int stage = Integer.parseInt(段階区分.substring(0, 2).toString());
        int suffix = Integer.parseInt(段階区分.substring(2).toString());

        RString 表示用 = !is対象外表記(stage) ? get基本表記(stage) : 対象外表記;
        表示用 = is改正前表記(entity.getFukaNendo(), suffix) ? add改正前表記(表示用, suffix) : 表示用;
        表示用 = add特例表記(表示用, entity);

        return 表示用;
    }

    /**
     * 表示用の保険料段階を編集して返します。<br />
     * 文言は"%1$d段階"のフォーマットで返します。
     *
     * @param hokenryoDankai 保険料段階
     * @return 表示用の保険料段階
     */
    public static RString edit表示用保険料段階第無し(HokenryoDankai hokenryoDankai) {

        DbT2013HokenryoDankaiEntity entity = hokenryoDankai.toEntity();

        RString 段階区分 = entity.getDankaiKubun();
        int stage = Integer.parseInt(段階区分.substring(0, 2).toString());
        int suffix = Integer.parseInt(段階区分.substring(2).toString());

        RString 表示用 = !is対象外表記(stage) ? get基本表記2(stage) : 対象外表記;
        表示用 = is改正前表記(entity.getFukaNendo(), suffix) ? add改正前表記(表示用, suffix) : 表示用;
        表示用 = add特例表記(表示用, entity);

        return 表示用;
    }

    private static boolean is対象外表記(int stage) {
        return stage == 0;
    }

    private static RString get基本表記(int stage) {
        return new RString(String.format(基本表記.toString(), stage));
    }

    private static RString get基本表記2(int stage) {
        return new RString(String.format(基本表記2.toString(), stage));
    }

    private static boolean is改正前表記(FlexibleYear 賦課年度, int suffix) {
        Range<FlexibleYear> 激変緩和期間 = new FukaKeisanConfig().get激変緩和期間();
        return 激変緩和期間.between(賦課年度) && suffix != 0;
    }

    private static RString add改正前表記(RString 表記, int suffix) {
        return new RStringBuilder(表記).append(String.format(改正前表記.toString(), suffix)).toRString();
    }

    private static RString add特例表記(RString 表記, DbT2013HokenryoDankaiEntity entity) {
        return new RStringBuilder(表記).append(entity.getTokureiHyoki()).toRString();
    }

}
