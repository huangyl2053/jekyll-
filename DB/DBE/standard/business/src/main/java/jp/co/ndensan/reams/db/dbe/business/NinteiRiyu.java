/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiResultIdoJiyu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定理由を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiRiyu {

    private final RString 一次判定結果変更理由;
    private final NinteiResultIdoJiyu 認定結果異動事由;
    private final FlexibleDate 認定結果異動年月日;
    private final RString 認定取消理由;
    private final FlexibleDate 認定取消年月日;
    private final RString 認定理由;

    /**
     * インスタンスを生成します。
     *
     * @param 一次判定結果変更理由 一次判定結果変更理由
     * @param 認定結果異動事由 認定結果異動事由
     * @param 認定結果異動年月日 認定結果異動年月日
     * @param 認定取消理由 認定取消理由
     * @param 認定取消年月日 認定取消年月日
     * @param 認定理由 認定理由
     */
    public NinteiRiyu(
            RString 一次判定結果変更理由,
            NinteiResultIdoJiyu 認定結果異動事由,
            FlexibleDate 認定結果異動年月日,
            RString 認定取消理由,
            FlexibleDate 認定取消年月日,
            RString 認定理由) {
        this.一次判定結果変更理由 = 一次判定結果変更理由;
        this.認定結果異動事由 = 認定結果異動事由;
        this.認定結果異動年月日 = 認定結果異動年月日;
        this.認定取消理由 = 認定取消理由;
        this.認定取消年月日 = 認定取消年月日;
        this.認定理由 = 認定理由;
    }

    /**
     * 一次判定結果変更理由を返します。
     *
     * @return 一次判定結果変更理由
     */
    public RString get一次判定結果変更理由() {
        return 一次判定結果変更理由;
    }

    /**
     * 認定結果異動事由を返します。
     *
     * @return 認定結果異動事由
     */
    public NinteiResultIdoJiyu get認定結果異動事由() {
        return 認定結果異動事由;
    }

    /**
     * 認定結果異動年月日を返します。
     *
     * @return 認定結果異動年月日
     */
    public FlexibleDate get認定結果異動年月日() {
        return 認定結果異動年月日;
    }

    /**
     * 認定取消理由を返します。
     *
     * @return 認定取消理由
     */
    public RString get認定取消理由() {
        return 認定取消理由;
    }

    /**
     * 認定取消年月日を返します。
     *
     * @return 認定取消年月日
     */
    public FlexibleDate get認定取消年月日() {
        return 認定取消年月日;
    }

    /**
     * 認定理由を返します。
     *
     * @return 認定理由
     */
    public RString get認定理由() {
        return 認定理由;
    }
}
