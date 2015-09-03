/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 賦課エラー一覧の識別子です。
 */
@Value
public class FukaErrorListIdentifier implements Serializable {

    private final SubGyomuCode サブ業務コード;
    private final RString 内部帳票ID;
    private final FlexibleYear 賦課年度;
    private final TsuchishoNo 通知書番号;

    /**
     * コンストラクタです。
     *
     * @param サブ業務コード サブ業務コード
     * @param 内部帳票ID 内部帳票ID
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     */
    public FukaErrorListIdentifier(SubGyomuCode サブ業務コード,
            RString 内部帳票ID,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {
        this.サブ業務コード = サブ業務コード;
        this.内部帳票ID = 内部帳票ID;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
    }
}
