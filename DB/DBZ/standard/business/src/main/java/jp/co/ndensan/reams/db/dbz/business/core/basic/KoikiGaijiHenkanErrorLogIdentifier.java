/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域外字変換エラーログの識別子です。
 */
@Value
public class KoikiGaijiHenkanErrorLogIdentifier implements Serializable {

    private final RString 処理番号;
    private final RString 連番;
    private final RString エラー表示連番;

    /**
     * コンストラクタです。
     *
     * @param 処理番号 処理番号
     * @param 連番 連番
     * @param エラー表示連番 エラー表示連番
     */
    public KoikiGaijiHenkanErrorLogIdentifier(RString 処理番号,
            RString 連番,
            RString エラー表示連番) {
        this.処理番号 = 処理番号;
        this.連番 = 連番;
        this.エラー表示連番 = エラー表示連番;
    }
}
