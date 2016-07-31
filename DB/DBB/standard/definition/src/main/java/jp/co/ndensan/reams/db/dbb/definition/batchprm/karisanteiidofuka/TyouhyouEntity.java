/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.karisanteiidofuka;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * Entityクラスです。
 *
 * @reamsid_L DBB-0890-020 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TyouhyouEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private RString 出力順ID;

    /**
     * コンストラクタです。
     */
    public TyouhyouEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param 出力順ID ReportId
     * @param 帳票ID RString
     * @param 帳票分類ID RString
     */
    public TyouhyouEntity(ReportId 帳票分類ID, ReportId 帳票ID, RString 出力順ID) {
        this.帳票分類ID = 帳票分類ID;
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
    }
}
