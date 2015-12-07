/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 老齢福祉年金受給者の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class RoreiFukushiNenkinJukyushaIdentifier implements Serializable {

    private static final long serialVersionUID = 1722197994960155680L;
    private final ShikibetsuCode 識別コード;
    private final FlexibleDate 受給開始年月日;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 受給開始年月日 受給開始年月日
     */
    public RoreiFukushiNenkinJukyushaIdentifier(ShikibetsuCode 識別コード,
            FlexibleDate 受給開始年月日) {
        this.識別コード = 識別コード;
        this.受給開始年月日 = 受給開始年月日;
    }
}
