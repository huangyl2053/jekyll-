/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.renkeidatatorikomi;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請連携データ取込のパラメータクラスです。
 *
 * @reamsid_L DBE-1490-020 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShiseiDataParameter {

    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 認定申請日;
    private RString 申請種別コード;
}
