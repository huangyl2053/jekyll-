/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.shoridatekanri;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタの識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class ShoriDateKanriIdentifier implements Serializable {

    private final SubGyomuCode サブ業務コード;
    private final RString 処理名;
    private final FlexibleYear 年度;

    /**
     * コンストラクタです。
     *
     * @param サブ業務コード サブ業務コード
     * @param 処理名 処理名
     * @param 年度 年度
     */
    public ShoriDateKanriIdentifier(SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 年度) {
        this.サブ業務コード = サブ業務コード;
        this.処理名 = 処理名;
        this.年度 = 年度;
    }
}
