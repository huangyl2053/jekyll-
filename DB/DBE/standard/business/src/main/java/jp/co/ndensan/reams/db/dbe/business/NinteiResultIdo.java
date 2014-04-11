/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiResultIdoJiyuKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 認定結果異動情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteiResultIdo {

    private final NinteiResultIdoJiyuKubun 認定結果異動事由区分;
    private final FlexibleDate 認定結果異動年月日;

    /**
     * インスタンスを生成します。
     *
     * @param 認定結果異動事由区分 認定結果異動事由区分
     * @param 認定結果異動年月日 認定結果異動年月日
     */
    public NinteiResultIdo(NinteiResultIdoJiyuKubun 認定結果異動事由区分, FlexibleDate 認定結果異動年月日) {
        this.認定結果異動事由区分 = 認定結果異動事由区分;
        this.認定結果異動年月日 = 認定結果異動年月日;
    }

    /**
     * 認定結果異動事由区分を返します。
     *
     * @return 認定結果異動事由区分
     */
    public NinteiResultIdoJiyuKubun get認定結果異動事由区分() {
        return 認定結果異動事由区分;
    }

    /**
     * 認定結果異動年月日を返します。
     *
     * @return 認定結果異動年月日
     */
    public FlexibleDate get認定結果異動年月日() {
        return 認定結果異動年月日;
    }
}
