/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyufushikyuketteishaichiran.KogakuShikyuFushikyuKetteishaIchiranSource;

/**
 * 高額サービス費支給（不支給）決定者一覧表帳票BodyEditor
 */
public class BodyEditor implements IKogakuShikyuFushikyuKetteishaIchiranEditor {

    private static final int 文字15 = 15;
    private final KogakuShikyuFushikyuKetteishaIchiranItem item;

    /**
     * コンストラクタです
     *
     * @param item KogakuShikyuFushikyuKetteishaIchiranItem
     */
    public BodyEditor(KogakuShikyuFushikyuKetteishaIchiranItem item) {
        this.item = item;
    }

    @Override
    public KogakuShikyuFushikyuKetteishaIchiranSource edit(KogakuShikyuFushikyuKetteishaIchiranSource source) {
        source.hokenshaNo = item.get保険者番号();
        source.hokenshaName = item.get保険者名称();
        source.shutsuryokujun1 = item.get出力順１();
        source.shutsuryokujun2 = item.get出力順２();
        source.shutsuryokujun3 = item.get出力順３();
        source.shutsuryokujun4 = item.get出力順４();
        source.shutsuryokujun5 = item.get出力順５();
        source.kaipage1 = item.get改頁１();
        source.kaipage2 = item.get改頁２();
        source.kaipage3 = item.get改頁３();
        source.kaipage4 = item.get改頁４();
        source.kaipage5 = item.get改頁５();
        source.listUpper_1 = item.get通知書番号();
        source.listUpper_2 = item.get氏名カナ();
        source.listUpper_3 = item.getサービス提供年月();
        source.listUpper_4 = item.get支払可否();
        source.listUpper_5 = item.get利用者負担額();
        source.listUpper_6 = item.get喪失事由();
        source.listUpper_7 = item.get住所コード();
        source.listUpper_8 = item.get郵便番号();
        source.listUpper_9 = item.get住所();
        if (item.get住所() != null && item.get住所().length() > 文字15) {
            source.listLower_8 = item.get住所().substring(文字15);
        }
        source.listUpper_10 = item.get行政区();
        source.listLower_1 = item.get被保険者番号();
        source.listLower_2 = item.get氏名();
        source.listLower_3 = item.get決定年月();
        source.listLower_4 = item.get支払方法();
        source.listLower_5 = item.get決定支給額();
        source.listLower_6 = item.get喪失年月日();
        source.listLower_7 = item.get行政区コード();
        source.listLower_9 = item.get備考();
        return source;
    }
}
