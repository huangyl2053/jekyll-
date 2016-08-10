/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmenshinseishotaishohaaku;

import jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen.GemmenNendoResearcher;
import jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen.INendo;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 前年度情報を取得クラスです。
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
public class ZenNendoResearcher {

    private final GemmenGengakuShurui 減免減額種類;
    private final FlexibleDate 基準日;

    protected ZenNendoResearcher(GemmenGengakuShurui 減免減額種類, FlexibleDate 基準日) {
        this.減免減額種類 = 減免減額種類;
        this.基準日 = 基準日;
    }

    public static ZenNendoResearcher createIntance(GemmenGengakuShurui 減免減額種類, FlexibleDate 基準日) {
        return new ZenNendoResearcher(減免減額種類, 基準日);
    }

    private GemmenNendoResearcher getGemmenNendoResearcher(GemmenGengakuShurui 減免減額種類) {
        return GemmenNendoResearcher.createInstance(減免減額種類);
    }

    private INendo get年度情報() {
        return GemmenNendoResearcher.createInstance(減免減額種類).find年度Contains(基準日);
    }

    public INendo get前年度の情報() {
        return get年度情報().before();
    }

    public FlexibleDate get開始日() {
        return get年度情報().before().get開始日();
    }

    public FlexibleDate get終了日() {
        return get年度情報().before().get終了日();
    }
}
