/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.hanyolist;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;

/**
 * ビジネス設計_DBZMNnnnnn_汎用リスト一時テーブル名のパラメター
 *
 * @reamsid_L DBZ-4570-010 jinge
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class HanyoLisyInvertedParameter {

    private final ReportId 帳票ID;

    public HanyoLisyInvertedParameter(ReportId 帳票ID) {
        this.帳票ID = 帳票ID;
    }
}
