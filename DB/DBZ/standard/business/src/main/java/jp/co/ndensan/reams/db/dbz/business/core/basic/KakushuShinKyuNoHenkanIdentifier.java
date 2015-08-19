/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種新旧番号変換テーブルの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class KakushuShinKyuNoHenkanIdentifier implements Serializable {

    private final HihokenshaNo 被保険者番号;
    private final RString 番号区分;
    private final RString 旧番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 番号区分 番号区分
     * @param 旧番号 旧番号
     */
    public KakushuShinKyuNoHenkanIdentifier(HihokenshaNo 被保険者番号,
            RString 番号区分,
            RString 旧番号) {
        this.被保険者番号 = 被保険者番号;
        this.番号区分 = 番号区分;
        this.旧番号 = 旧番号;
    }
}
