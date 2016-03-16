/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteikohifutanshain.KagoKetteiKohifutanshaInSource;

/**
 *
 * 誤決定通知書情報取込一覧表（公費負担者分）帳票BodyEditor
 */
public class BodyEditor implements IKagoKetteiKohifutanshaInEditor {

    private final KagoKetteiKohifutanshaInItem item;

    /**
     * コンストラクタです
     *
     * @param item KagoKetteiKohifutanshaInItem
     */
    public BodyEditor(KagoKetteiKohifutanshaInItem item) {
        this.item = item;
    }

    @Override
    public KagoKetteiKohifutanshaInSource edit(KagoKetteiKohifutanshaInSource source) {
        source.kohiFutanshaName = item.get公費負担者名();
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
        source.listUpper_1 = item.getNo();
        source.listUpper_2 = item.get取り扱い年月();
        source.listUpper_3 = item.get事業者番号();
        source.listUpper_4 = item.get公費受給者番号();
        source.listUpper_5 = item.get公費受給者名();
        source.listUpper_6 = item.getサービ提供年月();
        source.listUpper_7 = item.getサービス種類コード();
        source.listUpper_8 = item.get申立事由コード();
        source.listUpper_9 = item.get単位数();
        source.listLower_1 = item.get事業者名();
        source.listLower_2 = item.get被保険者番号();
        source.listLower_3 = item.getサービス種類名();
        source.listLower_4 = item.get申立事由();
        source.listLower_5 = item.get公費負担額();
        source.kensuTitle = item.get件数タイトル();
        source.tanisuTitle = item.get単位数タイトル();
        source.futanGakuTitle = item.get負担額タイトル();
        source.kyufuhiTitle = item.get給付費タイトル();
        source.servicehiTitle = item.getサービス費タイトル();
        source.shokujihiTitle = item.get食事費タイトル();
        source.kensuGokei1 = item.get介護給付費の件数();
        source.tanisuGokei1 = item.get介護給付費の単位数();
        source.futanGakuGokei1 = item.get介護給付費の公費負担額();
        source.kensuGokei2 = item.get高額介護サービス費の件数();
        source.tanisuGokei2 = item.get高額介護サービス費の単位数();
        source.futanGakuGokei2 = item.get高額介護サービス費の公費負担額();
        source.kensuGokei3 = item.get特定入所者介護サービス費等の件数();
        source.tanisuGokei3 = item.get特定入所者介護サービス費等の単位数();
        source.futanGakuGokei3 = item.get特定入所者介護サービス費等の公費負担額();
        return source;
    }
}
