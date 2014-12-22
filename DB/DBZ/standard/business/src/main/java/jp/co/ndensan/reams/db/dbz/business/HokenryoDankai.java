/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.model.HokenryoDankaiModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static java.util.Objects.requireNonNull;

/**
 * 保険料段階を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class HokenryoDankai {

    private final HokenryoDankaiModel 保険料段階;
    private final Range<FlexibleYear> 激変緩和期間;

    private static final RString 基本表記 = new RString("第%1$d段階");
    private static final RString 改正前表記 = new RString("(改正前%1$d)");
    private static final RString 対象外表記 = new RString("-");

    /**
     * コンストラクタです。
     *
     * @param 保険料段階 保険料段階
     * @throws NullPointerException 引数がnullの場合
     */
    public HokenryoDankai(HokenryoDankaiModel 保険料段階) throws NullPointerException {
        this.保険料段階 = requireNonNull(保険料段階, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階"));
        this.激変緩和期間 = new FukaKeisanConfig().get激変緩和期間();
    }

    /**
     * コンストラクタです。
     *
     * @param 保険料段階 保険料段階
     * @param 賦課計算Config 賦課計算Config
     * @throws NullPointerException 引数がnullの場合
     */
    public HokenryoDankai(HokenryoDankaiModel 保険料段階, FukaKeisanConfig 賦課計算Config) throws NullPointerException {
        this.保険料段階 = requireNonNull(保険料段階, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料段階"));
        requireNonNull(賦課計算Config, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課計算Config"));
        this.激変緩和期間 = 賦課計算Config.get激変緩和期間();
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return 保険料段階.get賦課年度();
    }

    /**
     * 段階インデックスを返します。
     *
     * @return 段階インデックス
     */
    public RString get段階インデックス() {
        return 保険料段階.get段階インデックス();
    }

    /**
     * ランク区分を返します。
     *
     * @return ランク区分
     */
    public RString getランク区分() {
        return 保険料段階.getランク区分();
    }

    /**
     * 段階区分を返します。
     *
     * @return 段階区分
     */
    public RString get段階区分() {
        return 保険料段階.get段階区分();
    }

    /**
     * 保険料率を返します。
     *
     * @return 保険料率
     */
    public Decimal get保険料率() {
        return 保険料段階.get保険料率();
    }

    /**
     * 特例表記を返します。
     *
     * @return 特例表記
     */
    public RString get特例表記() {
        return 保険料段階.get特例表記();
    }

    /**
     * 表示用の保険料段階を編集して返します。
     *
     * @return 表示用の保険料段階
     */
    public RString edit表示用保険料段階() {

        RString 段階区分 = 保険料段階.get段階区分();
        int stage = Integer.parseInt(段階区分.substring(0, 2).toString());
        int suffix = Integer.parseInt(段階区分.substring(2).toString());

        RString 表示用 = !is対象外表記(stage) ? get基本表記(stage) : 対象外表記;
        表示用 = is改正前表記(保険料段階.get賦課年度(), suffix) ? add改正前表記(表示用, suffix) : 表示用;
        表示用 = add特例表記(表示用);

        return 表示用;
    }

    private boolean is対象外表記(int stage) {
        return stage == 0;
    }

    private RString get基本表記(int stage) {
        return new RString(String.format(基本表記.toString(), stage));
    }

    private boolean is改正前表記(FlexibleYear 賦課年度, int suffix) {
        return 激変緩和期間.between(賦課年度) && suffix != 0;
    }

    private RString add改正前表記(RString 表記, int suffix) {
        return new RStringBuilder(表記).append(String.format(改正前表記.toString(), suffix)).toRString();
    }

    private RString add特例表記(RString 表記) {
        return new RStringBuilder(表記).append(保険料段階.get特例表記()).toRString();
    }
}
