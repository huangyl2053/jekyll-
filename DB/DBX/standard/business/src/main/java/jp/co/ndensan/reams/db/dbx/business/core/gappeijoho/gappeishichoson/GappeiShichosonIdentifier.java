/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeishichoson;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併市町村の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class GappeiShichosonIdentifier implements Serializable {

    private static final long serialVersionUID = -8096763861099854452L;

    private final FlexibleDate 合併年月日;
    private final RString 地域番号;
    private final LasdecCode 旧市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 合併年月日 合併年月日
     * @param 地域番号 地域番号
     * @param 旧市町村コード 旧市町村コード
     */
    public GappeiShichosonIdentifier(FlexibleDate 合併年月日,
            RString 地域番号,
            LasdecCode 旧市町村コード) {
        this.合併年月日 = 合併年月日;
        this.地域番号 = 地域番号;
        this.旧市町村コード = 旧市町村コード;
    }
}
