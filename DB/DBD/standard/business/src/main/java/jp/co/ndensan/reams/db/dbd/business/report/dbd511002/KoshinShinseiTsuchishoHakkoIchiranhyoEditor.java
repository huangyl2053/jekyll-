/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.TongzhiShufaxingEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511002.KoshinShinseiTsuchishoHakkoIchiranhyoReportSource;

/**
 * 更新申請のお知らせ通知書発行一覧表Editorです。
 *
 * @reamsid_L DBD-2030-040 donghj
 */
public class KoshinShinseiTsuchishoHakkoIchiranhyoEditor implements IKoshinShinseiTsuchishoHakkoIchiranhyoEditor {

    private final TongzhiShufaxingEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity TongzhiShufaxingEntity
     */
    public KoshinShinseiTsuchishoHakkoIchiranhyoEditor(TongzhiShufaxingEntity entity) {
        this.entity = entity;
    }

    @Override
    public KoshinShinseiTsuchishoHakkoIchiranhyoReportSource edit(KoshinShinseiTsuchishoHakkoIchiranhyoReportSource source) {
        return edit項目(source);
    }

    private KoshinShinseiTsuchishoHakkoIchiranhyoReportSource edit項目(KoshinShinseiTsuchishoHakkoIchiranhyoReportSource source) {

        return source;
    }

}
