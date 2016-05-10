/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 不均一納期管理の識別子です。
 *
 * @reamsid_L DBB-9999-012 cuilin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class FukinitsuNokiKanriIdentifier implements Serializable {

    private final FlexibleYear 調定年度;
    private final LasdecCode 市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 市町村コード 市町村コード
     */
    public FukinitsuNokiKanriIdentifier(FlexibleYear 調定年度,
            LasdecCode 市町村コード) {
        this.調定年度 = 調定年度;
        this.市町村コード = 市町村コード;
    }
}
