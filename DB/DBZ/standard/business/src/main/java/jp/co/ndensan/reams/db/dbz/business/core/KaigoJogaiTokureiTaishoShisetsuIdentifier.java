/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 介護除外住所地特例対象施設の識別子です。
 */
@Value
public class KaigoJogaiTokureiTaishoShisetsuIdentifier implements Serializable {

    private final RString 事業者種別;
    private final RString 事業者番号;
    private final FlexibleDate 有効開始年月日;

    /**
     * コンストラクタです。
     *
     * @param 事業者種別 事業者種別
     * @param 事業者番号 事業者番号
     * @param 有効開始年月日 有効開始年月日
     */
    public KaigoJogaiTokureiTaishoShisetsuIdentifier(RString 事業者種別,
            RString 事業者番号,
            FlexibleDate 有効開始年月日) {
        this.事業者種別 = 事業者種別;
        this.事業者番号 = 事業者番号;
        this.有効開始年月日 = 有効開始年月日;
    }

    /**
     * get事業者種別
     *
     * @return 事業者種別
     */
    public RString get事業者種別() {
        return 事業者種別;
    }

    /**
     * get事業者番号
     *
     * @return 事業者番号
     */
    public RString get事業者番号() {
        return 事業者番号;
    }

    /**
     * get有効開始年月日
     *
     * @return 有効開始年月日
     */
    public FlexibleDate get有効開始年月日() {
        return 有効開始年月日;
    }
}
