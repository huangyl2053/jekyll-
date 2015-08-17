/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import lombok.Value;

/**
 * 帳票制御共通コントロールの識別子です。
 */
@Value
public class ChohyoSeigyoKyotsuControlIdentifier implements Serializable {

    private final SubGyomuCode サブ業務コード;
    private final ReportId 帳票分類ID;

    /**
     * コンストラクタです。
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     */
    public ChohyoSeigyoKyotsuControlIdentifier(SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) {
        this.サブ業務コード = サブ業務コード;
        this.帳票分類ID = 帳票分類ID;
    }
}
