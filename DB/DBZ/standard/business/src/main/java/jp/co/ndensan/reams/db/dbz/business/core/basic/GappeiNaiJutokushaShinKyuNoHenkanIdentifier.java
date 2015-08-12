/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併内住特者新旧番号変換テーブルの識別子です。
 */
@Value
public class GappeiNaiJutokushaShinKyuNoHenkanIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final RString 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public GappeiNaiJutokushaShinKyuNoHenkanIdentifier(ShikibetsuCode 識別コード,
            RString 履歴番号) {
        this.識別コード = 識別コード;
        this.履歴番号 = 履歴番号;
    }
}
