/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogofujoshurui;

import java.io.Serializable;
import jp.co.ndensan.reams.ur.urz.definition.core.code.FujoShuruiCodeValue;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 生活保護扶助種類の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class SeikatsuHogoFujoShuruiIdentifier implements Serializable {

    private static final long serialVersionUID = -6525061749131877263L;
    private final ShikibetsuCode 識別コード;
    private final GyomuCode 業務コード;
    private final FlexibleDate 受給開始日;
    private final FujoShuruiCodeValue 扶助種類コード;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 業務コード 業務コード
     * @param 受給開始日 受給開始日
     * @param 扶助種類コード 扶助種類コード
     */
    public SeikatsuHogoFujoShuruiIdentifier(ShikibetsuCode 識別コード,
            GyomuCode 業務コード,
            FlexibleDate 受給開始日,
            FujoShuruiCodeValue 扶助種類コード) {
        this.識別コード = 識別コード;
        this.業務コード = 業務コード;
        this.受給開始日 = 受給開始日;
        this.扶助種類コード = 扶助種類コード;
    }
}
