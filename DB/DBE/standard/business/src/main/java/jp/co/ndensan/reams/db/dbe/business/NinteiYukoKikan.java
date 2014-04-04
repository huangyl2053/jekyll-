/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 認定有効期間を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiYukoKikan {

    private final NinteiYukoKikanTsukisu 有効期間月数;
    private final FlexibleDate 有効開始年月日;
    private final FlexibleDate 有効終了年月日;

    /**
     * インスタンスを生成します。
     *
     * @param 有効期間月数 有効期間月数
     * @param 有効開始年月日 有効開始年月日
     * @param 有効終了年月日 有効終了年月日
     */
    public NinteiYukoKikan(
            NinteiYukoKikanTsukisu 有効期間月数,
            FlexibleDate 有効開始年月日,
            FlexibleDate 有効終了年月日) {
        if (有効期間月数 == null || (有効開始年月日 == null && 有効終了年月日 == null)) {
            throw new NullPointerException(Messages.E00001.replace("有効期間").getMessage());
        }
        this.有効期間月数 = 有効期間月数;
        this.有効開始年月日 = 有効開始年月日 == null && 有効終了年月日 != null ? 有効終了年月日.minusMonth(有効期間月数.value()) : 有効開始年月日;
        this.有効終了年月日 = 有効終了年月日 == null && 有効開始年月日 != null ? 有効開始年月日.plusMonth(有効期間月数.value()) : 有効終了年月日;
    }

    /**
     * 有効期間月数を返します。
     *
     * @return 有効期間月数
     */
    public NinteiYukoKikanTsukisu get有効期間月数() {
        return 有効期間月数;
    }

    /**
     * 有効期間を返します。
     *
     * @return 有効期間
     */
    public Range<FlexibleDate> get有効期間() {
        return new Range<>(有効開始年月日, 有効終了年月日);
    }
}
