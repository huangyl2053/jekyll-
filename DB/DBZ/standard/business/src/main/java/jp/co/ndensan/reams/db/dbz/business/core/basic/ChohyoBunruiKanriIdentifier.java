/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * 帳票分類管理の識別子です。
 */
@Value
public class ChohyoBunruiKanriIdentifier implements Serializable {

    private final SubGyomuCode サブ業務コード;
    private final ReportId 帳票ID;

    /**
     * コンストラクタです。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票ID 帳票ID
     */
    public ChohyoBunruiKanriIdentifier(SubGyomuCode サブ業務コード,
            ReportId 帳票ID) {
        this.サブ業務コード = サブ業務コード;
        this.帳票ID = 帳票ID;
    }
}
