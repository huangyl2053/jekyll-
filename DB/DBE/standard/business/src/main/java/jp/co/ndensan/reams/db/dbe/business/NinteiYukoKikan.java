/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static java.util.Objects.requireNonNull;

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
     * インスタンスを生成します。<br />
     * 有効終了年月日を指定しない場合に使用します。この場合、有効終了年月日には有効開始年月日に有効期間月数を足した年月日が設定されます。
     *
     * @param 有効開始年月日 有効開始年月日
     * @param 有効期間月数 有効期間月数
     */
    public NinteiYukoKikan(FlexibleDate 有効開始年月日, NinteiYukoKikanTsukisu 有効期間月数) {
        this(有効開始年月日, 有効期間月数, isNull(有効期間月数) || isNull(有効開始年月日) ? null : 有効開始年月日.plusMonth(有効期間月数.value()));
    }

    /**
     * インスタンスを生成します。<br />
     * 有効開始年月日、有効期間月数、有効終了年月日を全て指定する場合に使用します
     *
     * @param 有効開始年月日 有効開始年月日
     * @param 有効期間月数 有効期間月数
     * @param 有効終了年月日 有効終了年月日
     */
    public NinteiYukoKikan(FlexibleDate 有効開始年月日, NinteiYukoKikanTsukisu 有効期間月数, FlexibleDate 有効終了年月日) {
        this.有効開始年月日 = requireNonNull(有効開始年月日, Messages.E00001.replace("有効開始年月日").getMessage());
        this.有効期間月数 = requireNonNull(有効期間月数, Messages.E00001.replace("有効期間月数").getMessage());
        this.有効終了年月日 = requireNonNull(有効終了年月日, Messages.E00001.replace("有効終了年月日").getMessage());
    }

    /**
     * インスタンスを生成します。<br />
     * 有効開始年月日を指定しない場合に使用します。この場合、有効開始年月日には有効終了年月日から有効期間月数を引いた年月日が設定されます。
     *
     * @param 有効期間月数 有効期間月数
     * @param 有効終了年月日 有効終了年月日
     */
    public NinteiYukoKikan(NinteiYukoKikanTsukisu 有効期間月数, FlexibleDate 有効終了年月日) {
        this(isNull(有効期間月数) || isNull(有効終了年月日) ? null : 有効終了年月日.minusMonth(有効期間月数.value()), 有効期間月数, 有効終了年月日);
    }

    private static boolean isNull(Object object) {
        return object == null;
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
