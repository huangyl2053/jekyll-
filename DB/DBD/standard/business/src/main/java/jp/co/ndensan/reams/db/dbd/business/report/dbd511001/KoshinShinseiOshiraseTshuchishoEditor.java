/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.RenZhengzheEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511001.KoshinShinseiOshiraseTshuchishoReportSource;

/**
 * 認定更新お知らせ通知書Editorです。
 *
 * @reamsid_L DBD-2030-030 donghj
 */
public class KoshinShinseiOshiraseTshuchishoEditor implements IKoshinShinseiOshiraseTshuchishoEditor {

    private final List<RenZhengzheEntity> 認定更新お知らせ通知書Entityリスト;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param 認定更新お知らせ通知書Entityリスト List<RenZhengzheEntity>
     * @param index int
     */
    public KoshinShinseiOshiraseTshuchishoEditor(List<RenZhengzheEntity> 認定更新お知らせ通知書Entityリスト, int index) {
        this.認定更新お知らせ通知書Entityリスト = 認定更新お知らせ通知書Entityリスト;
        this.index = index;
    }

    @Override
    public KoshinShinseiOshiraseTshuchishoReportSource edit(KoshinShinseiOshiraseTshuchishoReportSource source) {
        return edit項目(source);
    }

    private KoshinShinseiOshiraseTshuchishoReportSource edit項目(KoshinShinseiOshiraseTshuchishoReportSource source) {
        return source;
    }

}
