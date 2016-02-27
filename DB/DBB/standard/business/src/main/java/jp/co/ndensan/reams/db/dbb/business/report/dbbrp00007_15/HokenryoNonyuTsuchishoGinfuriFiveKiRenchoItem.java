/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_15;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import lombok.Getter;

/**
 *
 * 保険料納入通知書（本算定過年度）【銀振タイプ】
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenryoNonyuTsuchishoGinfuriFiveKiRenchoItem {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;

    /**
     * インスタンスを生成します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     */
    public HokenryoNonyuTsuchishoGinfuriFiveKiRenchoItem(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        this.本算定納入通知書情報 = 本算定納入通知書情報;
    }

}
