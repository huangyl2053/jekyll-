/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 出力帳票一覧用のパラメータです。
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KarisanteiBatchEntity implements Serializable {

    private ReportId 帳票分類ID;
    private ReportId 帳票ID;
    private RString 出力順ID;

    /**
     * コンストラクタです。
     */
    public KarisanteiBatchEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param 帳票分類ID ReportId
     * @param 帳票ID ReportId
     * @param 出力順ID RString
     */
    public KarisanteiBatchEntity(ReportId 帳票分類ID, ReportId 帳票ID, RString 出力順ID) {
        this.帳票分類ID = 帳票分類ID;
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
    }
}
