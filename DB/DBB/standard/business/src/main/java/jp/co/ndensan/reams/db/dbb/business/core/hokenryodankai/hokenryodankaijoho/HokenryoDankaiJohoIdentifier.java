/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryodankaijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料ランクの情報の識別子です。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class HokenryoDankaiJohoIdentifier implements Serializable {

    private final FlexibleYear 賦課年度;
    private final RString 段階インデックス;
    private final RString ランク区分;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 賦課年度
     * @param 段階インデックス 段階インデックス
     * @param ランク区分 ランク区分
     */
    public HokenryoDankaiJohoIdentifier(FlexibleYear 賦課年度,
            RString 段階インデックス,
            RString ランク区分) {
        this.賦課年度 = 賦課年度;
        this.段階インデックス = 段階インデックス;
        this.ランク区分 = ランク区分;
    }
    private static final long serialVersionUID = -2531131049722052123L;
}
