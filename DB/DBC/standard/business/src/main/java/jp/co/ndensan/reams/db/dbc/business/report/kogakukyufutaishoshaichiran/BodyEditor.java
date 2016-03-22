/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;

/**
 * 高額介護サービス費給付対象者一覧表帳票BodyEditor
 */
public class BodyEditor implements IKogakuKyufuTaishoshaIchiranEditor {

    private final KogakuKyufuTaishoshaIchiranItem item;

    /**
     * コンストラクタです
     *
     * @param item KogakuKyufuTaishoshaIchiranItem
     */
    public BodyEditor(KogakuKyufuTaishoshaIchiranItem item) {
        this.item = item;
    }

    @Override
    public KogakuKyufuTaishoshaIchiranSource edit(KogakuKyufuTaishoshaIchiranSource source) {
        source.hokenshaNo = item.get保険者番号();
        source.hokenshaName = item.get保険者名称();
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
        source.listUpper_1 = item.get通知書番号();
        source.listUpper_2 = item.get被保険者番号();
        source.listUpper_3 = item.getサービス提供年月();
        source.listUpper_4 = item.get事業者番号();
        source.listUpper_5 = item.getサービス種類コード();
        source.listUpper_6 = item.getサービス費用合計額();
        source.listUpper_7 = item.get算定基準額();
        source.listUpper_8 = item.get高額支給額();
        source.listUpper_9 = item.get資格喪失日();
        source.listUpper_10 = item.get備考();
        source.listLower_1 = item.get被保険者氏名();
        source.listLower_2 = item.get事業者名();
        source.listLower_3 = item.getサービス種類名称();
        source.listLower_4 = item.get利用者負担額();
        source.listLower_5 = item.get支払済金額();
        return source;
    }

}
