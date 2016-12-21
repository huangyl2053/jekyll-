/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiiiryokikanjoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 主治医医療機関情報の識別子です。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShujiiIryoKikanJohoIdentifier implements Serializable {

    private final LasdecCode 市町村コード;
    private final ShujiiIryokikanCode 主治医医療機関コード;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     */
    public ShujiiIryoKikanJohoIdentifier(LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード) {
        this.市町村コード = 市町村コード;
        this.主治医医療機関コード = 主治医医療機関コード;
    }
}
