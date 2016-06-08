/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryorank;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 保険料ランクの識別子です。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class HokenryoRankIdentifier implements Serializable {

    private final FlexibleYear 賦課年度;
    private final LasdecCode 市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     */
    public HokenryoRankIdentifier(FlexibleYear 賦課年度,
            LasdecCode 市町村コード) {
        this.賦課年度 = 賦課年度;
        this.市町村コード = 市町村コード;
    }
    private static final long serialVersionUID = -4466727381652492714L;
}
