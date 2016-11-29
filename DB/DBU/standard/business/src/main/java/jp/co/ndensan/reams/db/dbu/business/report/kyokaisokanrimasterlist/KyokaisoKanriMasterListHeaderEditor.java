/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoKanriMasterListChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;

/**
 * 境界層管理マスタリストヘッダEditorです。
 *
 * @reamsid_L DBU-1050-060 linghuhang
 */
class KyokaisoKanriMasterListHeaderEditor implements IKyokaisoKanriMasterListEditor {

    private final KyokaisoKanriMasterListChohyoDataSakuseiEntity headItem;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KyokaisoKanriMasterListItem}
     */
    protected KyokaisoKanriMasterListHeaderEditor(KyokaisoKanriMasterListChohyoDataSakuseiEntity headItem) {
        this.headItem = headItem;
    }

    @Override
    public KyokaisoKanriMasterListReportSource edit(KyokaisoKanriMasterListReportSource source) {
        return editHeader(source);
    }

    private KyokaisoKanriMasterListReportSource editHeader(KyokaisoKanriMasterListReportSource source) {

        source.printTimeStamp = headItem.get印刷日時();
        source.shichosonCode = headItem.get市町村コード();
        source.shichosonName = headItem.get市町村名();
        source.shutsuryokujun1 = headItem.get並び順1();
        source.shutsuryokujun2 = headItem.get並び順2();
        source.shutsuryokujun3 = headItem.get並び順3();
        source.shutsuryokujun4 = headItem.get並び順4();
        source.shutsuryokujun5 = headItem.get並び順5();
        source.kaipage1 = headItem.get改頁1();
        source.kaipage2 = headItem.get改頁2();
        source.kaipage3 = headItem.get改頁3();
        source.kaipage4 = headItem.get改頁4();
        source.kaipage5 = headItem.get改頁5();
        source.listUpper_1 = headItem.get被保険者番号();
        source.listUpper_2 = headItem.getカナ氏名();
        source.listUpper_3 = headItem.get性別();
        source.listUpper_4 = headItem.get種別();
        source.listUpper_5 = headItem.get状態();
        source.listUpper_6 = headItem.get生年月日();
        source.listUpper_7 = headItem.get該当開始日();
        source.listUpper_8 = headItem.get給付額減額解除();
        source.listUpper_9 = headItem.get居住費軽減後居室種類();
        source.listLower_1 = headItem.get識別コード();
        source.listLower_2 = headItem.get氏名();
        source.listLower_3 = headItem.get世帯コード();
        source.listLower_4 = headItem.get該当申請日();
        source.listLower_5 = headItem.get該当終了日();
        source.listLower_6 = headItem.get標準負担減額後負担額();
        source.listLower_7 = headItem.get居住費軽減後負担額();
        source.listLower_8 = headItem.get食費軽減後負担額();
        source.listLower_9 = headItem.get高額ｻｰﾋﾞｽ費減額後上限額();
        source.listLower_10 = headItem.get保険料納付減額後保険料段階();
        source.choikiCode = headItem.get町域コード();
        source.sqlshichosonCode = headItem.get改頁市町村コード();
        return source;
    }
}
