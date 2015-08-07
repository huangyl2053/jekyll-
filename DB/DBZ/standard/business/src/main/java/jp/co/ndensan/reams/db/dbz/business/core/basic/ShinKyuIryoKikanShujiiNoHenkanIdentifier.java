/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新旧医療機関主治医番号変換テーブルの識別子です。
 */
@Value
public class ShinKyuIryoKikanShujiiNoHenkanIdentifier implements Serializable {

    private final LasdecCode 市町村コード;
    private final RString 旧医療機関番号;
    private final RString 旧主治医番号;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 旧医療機関番号 旧医療機関番号
     * @param 旧主治医番号 旧主治医番号
     */
    public ShinKyuIryoKikanShujiiNoHenkanIdentifier(LasdecCode 市町村コード,
            RString 旧医療機関番号,
            RString 旧主治医番号) {
        this.市町村コード = 市町村コード;
        this.旧医療機関番号 = 旧医療機関番号;
        this.旧主治医番号 = 旧主治医番号;
    }
}
