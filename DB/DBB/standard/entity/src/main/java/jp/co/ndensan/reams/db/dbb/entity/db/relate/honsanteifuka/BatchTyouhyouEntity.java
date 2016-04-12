/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteifuka;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ出力帳票一覧Entityクラスです。
 *
 * @reamsid_L DBB-0780-030 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BatchTyouhyouEntity implements Serializable {

    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private RString 出力順ID;

    /**
     * コンストラクタです。
     *
     * @param 帳票分類ID 帳票分類ID
     * @param 帳票ID 帳票ID
     * @param 出力順ID 出力順ID
     */
    public BatchTyouhyouEntity(ReportId 帳票分類ID,
            ReportId 帳票ID,
            RString 出力順ID) {
        this.帳票分類ID = 帳票分類ID;
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
    }

}
