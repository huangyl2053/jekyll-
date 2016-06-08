/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連動パターンの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class RendoPatternIdentifier implements Serializable {

    private final LasdecCode 送信元市町村コード;
    private final LasdecCode 送信先市町村コード;
    private final RString 種別;
    private final FlexibleDate 有効開始年月日;
    private final FlexibleDate 有効終了年月日;

    /**
     * コンストラクタです。
     *
     * @param 送信元市町村コード 送信元市町村コード
     * @param 送信先市町村コード 送信先市町村コード
     * @param 種別 種別
     * @param 有効開始年月日 有効開始年月日
     * @param 有効終了年月日 有効終了年月日
     */
    public RendoPatternIdentifier(LasdecCode 送信元市町村コード,
            LasdecCode 送信先市町村コード,
            RString 種別,
            FlexibleDate 有効開始年月日,
            FlexibleDate 有効終了年月日) {
        this.送信元市町村コード = 送信元市町村コード;
        this.送信先市町村コード = 送信先市町村コード;
        this.種別 = 種別;
        this.有効開始年月日 = 有効開始年月日;
        this.有効終了年月日 = 有効終了年月日;
    }
}
