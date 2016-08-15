/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbc.entity.db.report.source.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInSource;

/**
 * 総合事業費再審査決定通知書情報取込一覧表（保険者分）帳票Editor
 *
 * @reamsid_L DBC-4680-040 wangxue
 */
public class SogojigyohiSaishinsaKetteiHokenshaInEditor implements ISogojigyohiSaishinsaKetteiHokenshaInEditor {

    private final SogojigyohiSaishinsaKetteiHokenshaInItem item;

    /**
     * コンストラクタです。
     *
     * @param item SogojigyohiSaishinsaKetteiHokenshaInItem
     */
    public SogojigyohiSaishinsaKetteiHokenshaInEditor(SogojigyohiSaishinsaKetteiHokenshaInItem item) {
        this.item = item;
    }

    @Override
    public SogojigyohiSaishinsaKetteiHokenshaInSource edit(SogojigyohiSaishinsaKetteiHokenshaInSource source) {
        source.printTimeStamp = item.get印刷日時();
        source.torikomiYM = item.get取込年月();
        source.kokuhorenName = item.get国保連合会名();
        source.shinsakaiName = item.get審査委員会名();
        source.hokenshaNo = item.get保険者番号();
        source.hokenshaName = item.get保険者名();
        source.shoKisaiHokenshaNo = item.get証記載保険者番号();
        source.shoKisaiHokenshaName = item.get証記載保険者名();
        source.shutsuryokujun1 = item.get並び順１();
        source.shutsuryokujun2 = item.get並び順２();
        source.shutsuryokujun3 = item.get並び順３();
        source.shutsuryokujun4 = item.get並び順４();
        source.shutsuryokujun5 = item.get並び順５();
        source.kaipage1 = item.get改頁１();
        source.kaipage2 = item.get改頁２();
        source.kaipage3 = item.get改頁３();
        source.kaipage4 = item.get改頁４();
        source.kaipage5 = item.get改頁５();
        source.listUpper_1 = item.get通番();
        source.listUpper_2 = item.get取扱年月();
        source.listUpper_3 = item.get事業者番号();
        source.listUpper_4 = item.get事業者名();
        source.listUpper_5 = item.getサービス提供年月();
        source.listUpper_6 = item.getサービス種類コード();
        source.listUpper_7 = item.getサービス種類名();
        source.listUpper_8 = item.get当初請求単位数();
        source.listUpper_9 = item.get決定単位数();
        source.listUpper_10 = item.get保険者負担額();
        source.listLower_1 = item.get被保険者番号();
        source.listLower_2 = item.get被保険者氏名();
        source.listLower_3 = item.get申立事由コード();
        source.listLower_4 = item.get申立事由();
        source.listLower_5 = item.get原審単位数();
        source.listLower_6 = item.get調整単位数();
        source.ketteiTitle = item.get決定タイトル();
        source.ketteiKensuTitle = item.get決定件数タイトル();
        source.ketteiTanisuTitle = item.get決定単位数タイトル();
        source.ketteiFutangakuTitle = item.get決定負担額タイトル();
        source.choseiTitle = item.get調整タイトル();
        source.choseiKensuTitle = item.get調整件数タイトル();
        source.choseiTanisuTitle = item.get調整単位数タイトル();
        source.choseiFutangakuTitle = item.get調整負担額タイトル();
        source.sogojigyohiTitle = item.get総合事業費タイトル();
        source.sogojigyohiKetteiKensu = item.get総合事業費_決定_件数();
        source.sogojigyohiKetteiTanisu = item.get総合事業費_決定_単位数();
        source.sogojigyohiKetteiFutangaku = item.get総合事業費_決定_負担額();
        source.sogojigyohiChoseiKensu = item.get総合事業費_調整_件数();
        source.sogojigyohiChoseiTanisu = item.get総合事業費_調整_単位数();
        source.sogojigyohiChoseiFutangaku = item.get総合事業費_調整_負担額();
        return source;
    }

}
