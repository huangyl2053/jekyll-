/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaionseijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会音声情報の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShinsakaiOnseiJohoIdentifier implements Serializable {

    private static final long serialVersionUID = -313561512814007941L;
    private final RString 介護認定審査会開催番号;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 連番 連番
     */
    public ShinsakaiOnseiJohoIdentifier(RString 介護認定審査会開催番号,
            int 連番) {
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
        this.連番 = 連番;
    }
}
