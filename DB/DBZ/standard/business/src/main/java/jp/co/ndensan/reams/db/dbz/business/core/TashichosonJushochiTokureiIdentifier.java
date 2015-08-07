/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import lombok.Value;

/**
 * 他市町村住所地特例の識別子です。
 */
@Value
public class TashichosonJushochiTokureiIdentifier implements Serializable {

    private final ShikibetsuCode 識別コード;
    private final FlexibleDate 異動日;
    private final RString 枝番;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @param 枝番 枝番
     */
    public TashichosonJushochiTokureiIdentifier(ShikibetsuCode 識別コード,
FlexibleDate 異動日,
RString 枝番) {
        this.識別コード = 識別コード;
        this.異動日 = 異動日;
        this.枝番 = 枝番;
    }
}
