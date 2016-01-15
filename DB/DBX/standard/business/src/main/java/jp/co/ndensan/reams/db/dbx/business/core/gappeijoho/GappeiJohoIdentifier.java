/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.gappeijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class GappeiJohoIdentifier implements Serializable {

    private static final long serialVersionUID = 4850187391260504741L;

    private final FlexibleDate 合併年月日;
    private final RString 地域番号;

    /**
     * コンストラクタです。
     *
     * @param 合併年月日 合併年月日
     * @param 地域番号 地域番号
     */
    public GappeiJohoIdentifier(FlexibleDate 合併年月日,
            RString 地域番号) {
        this.合併年月日 = 合併年月日;
        this.地域番号 = 地域番号;
    }
}
