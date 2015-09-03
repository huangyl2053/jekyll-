/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.view;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 他市町村住所地特例者台帳管理Aliveの識別子です。
 */
@Value
public class KaigoJogaiTokureiTaishoShisetsuAliveIdentifier implements Serializable {

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
    public KaigoJogaiTokureiTaishoShisetsuAliveIdentifier(RString 事業者種別,
            RString 事業者番号,
            FlexibleDate 有効開始年月日) {
        this.事業者種別 = 事業者種別;
        this.事業者番号 = 事業者番号;
        this.有効開始年月日 = 有効開始年月日;
    }
}
