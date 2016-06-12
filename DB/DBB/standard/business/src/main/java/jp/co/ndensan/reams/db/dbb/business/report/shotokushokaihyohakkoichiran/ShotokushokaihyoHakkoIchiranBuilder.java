/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBPR51001_所得照会票発行一覧表のBuilder
 *
 * @reamsid_L DBB-1720-060 lijunjun
 */
public class ShotokushokaihyoHakkoIchiranBuilder implements IShotokushokaihyoHakkoIchiranBuilder {

    private final IShotokushokaihyoHakkoIchiranEditor eidtor;

    /**
     * コンストラクタです
     *
     * @param eidtor IShotokushokaihyoHakkoIchiranEditor
     */
    public ShotokushokaihyoHakkoIchiranBuilder(IShotokushokaihyoHakkoIchiranEditor eidtor) {
        this.eidtor = eidtor;
    }

    @Override
    public ShotokushokaihyoHakkoIchiranSource build() {
        return ReportEditorJoiner.from(new ShotokushokaihyoHakkoIchiranSource())
                .join(eidtor).buildSource();
    }

}
