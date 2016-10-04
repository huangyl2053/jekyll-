/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511002;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.KoshinOshiraseHeaderEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511002.KoshinShinseiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更新申請のお知らせ通知書発行一覧表Editorです。
 *
 * @reamsid_L DBD-2030-040 donghj
 */
public class KoshinShinseiTsuchishoHakkoIchiranhyoEditor implements IKoshinShinseiTsuchishoHakkoIchiranhyoEditor {

    private final KoshinOshiraseHeaderEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity KoshinOshiraseHeaderEntity
     */
    public KoshinShinseiTsuchishoHakkoIchiranhyoEditor(KoshinOshiraseHeaderEntity entity) {
        this.entity = entity;
    }

    @Override
    public KoshinShinseiTsuchishoHakkoIchiranhyoReportSource edit(KoshinShinseiTsuchishoHakkoIchiranhyoReportSource source) {
        return edit項目(source);
    }

    private KoshinShinseiTsuchishoHakkoIchiranhyoReportSource edit項目(KoshinShinseiTsuchishoHakkoIchiranhyoReportSource source) {
        source.taishoKikan = entity.get抽出対象期間();
        source.cityCode = entity.get市町村コード();
        source.cityName = entity.get市町村名称();
        source.sort1 = entity.get並び順1();
        source.sort2 = entity.get並び順2();
        source.sort3 = entity.get並び順3();
        source.sort4 = entity.get並び順4();
        source.sort5 = entity.get並び順5();
        source.printTimeStamp = entity.get印刷時間();
        if (entity.getTsuchishoHakoEntity() != null) {
            source.listHakkoIchiranhyo_1 = new RString(entity.getTsuchishoHakoEntity().get連番());
            source.listHakkoIchiranhyo_2 = entity.getTsuchishoHakoEntity().get被保険者番号();
            source.listHakkoIchiranhyo_3 = entity.getTsuchishoHakoEntity().get被保険者氏名();
            source.listHakkoIchiranhyo_4 = entity.getTsuchishoHakoEntity().get要介護度();
            source.listHakkoIchiranhyo_5 = entity.getTsuchishoHakoEntity().get受給申請日();
            source.listHakkoIchiranhyo_6 = entity.getTsuchishoHakoEntity().get認定日();
            source.listHakkoIchiranhyo_7 = entity.getTsuchishoHakoEntity().get認定開始日();
            source.listHakkoIchiranhyo_8 = entity.getTsuchishoHakoEntity().get認定終了日();
            source.listHakkoIchiranhyo_9 = entity.getTsuchishoHakoEntity().get受給申請事由();
            source.listHakkoIchiranhyo_10 = entity.getTsuchishoHakoEntity().get申請区分_申請時();
            source.listHakkoIchiranhyo_11 = entity.getTsuchishoHakoEntity().get申請区分_法令();
            source.listHakkoIchiranhyo_12 = entity.getTsuchishoHakoEntity().get居宅支援事業者コード();
            source.listHakkoIchiranhyo_13 = entity.getTsuchishoHakoEntity().get居宅支援事業者名称();
            source.listHakkoIchiranhyo_14 = entity.getTsuchishoHakoEntity().get入所施設事業者コード();
            source.listHakkoIchiranhyo_15 = entity.getTsuchishoHakoEntity().get入所施設事業者名称();
        }

        return source;
    }

}
