/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogoteishikikan;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 生活保護停止期間の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class SeikatsuHogoTeishikikanIdentifier implements Serializable {

    private static final long serialVersionUID = -1194165556363481005L;
    private final ShikibetsuCode 識別コード;
    private final GyomuCode 業務コード;
    private final FlexibleDate 受給開始日;
    private final FlexibleDate 受給停止開始日;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 業務コード 業務コード
     * @param 受給開始日 受給開始日
     * @param 受給停止開始日 受給停止開始日
     */
    public SeikatsuHogoTeishikikanIdentifier(ShikibetsuCode 識別コード,
            GyomuCode 業務コード,
            FlexibleDate 受給開始日,
            FlexibleDate 受給停止開始日) {
        this.識別コード = 識別コード;
        this.業務コード = 業務コード;
        this.受給開始日 = 受給開始日;
        this.受給停止開始日 = 受給停止開始日;
    }
}
