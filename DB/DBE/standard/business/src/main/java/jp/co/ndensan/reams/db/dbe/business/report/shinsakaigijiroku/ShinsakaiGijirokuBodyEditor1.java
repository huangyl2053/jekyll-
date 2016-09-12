/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaigijiroku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.SanGyoumeYonJyoIchiRanEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaigijiroku.ShinsakaiGijirokuReportSource;

/**
 * 介護認定審査会議事録Editorです。
 *
 * @reamsid_L DBE-0170-040 wangkun
 */
public class ShinsakaiGijirokuBodyEditor1 implements IShinsakaiGijirokuEditor {

    private final SanGyoumeYonJyoIchiRanEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HanteiKekkaIchiranEntity}
     */
    protected ShinsakaiGijirokuBodyEditor1(SanGyoumeYonJyoIchiRanEntity item) {
        this.item = item;
    }

    @Override
    public ShinsakaiGijirokuReportSource edit(ShinsakaiGijirokuReportSource source) {
        if (item != null) {
            source.listShinseishubetsuCount_1 = item.get一行目();
            source.listShinseishubetsuCount_2 = item.get二行目();
            source.listShinseishubetsuCount_3 = item.get三行目();
            source.listShinseishubetsuCount_4 = item.get四行目();
        }
        return source;
    }
}
