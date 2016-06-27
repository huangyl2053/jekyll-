/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo;

import lombok.Getter;

/**
 * 広域内住所地特例者一覧表のITEMです。
 *
 * @reamsid_L DBU-1140-060 linghuhang
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiJushochitokureishaIchiranhyoItem {

    private final KoikinaiJushochitokureishaIchiranhyoHead headItem;
    private final KoikinaiJushochitokureishaIchiranhyoBody bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 広域内住所地特例者一覧表
     * @param bodyItem 広域内住所地特例者一覧表
     */
    public KoikinaiJushochitokureishaIchiranhyoItem(
            KoikinaiJushochitokureishaIchiranhyoHead headItem,
            KoikinaiJushochitokureishaIchiranhyoBody bodyItem) {
        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}
