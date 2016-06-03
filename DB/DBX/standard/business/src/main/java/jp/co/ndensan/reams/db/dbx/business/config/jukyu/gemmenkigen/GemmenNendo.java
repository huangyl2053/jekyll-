/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen;

import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * {@link INendo}の標準的な実装です。
 */
class GemmenNendo implements INendo {

    private final FlexibleYear 年度;
    private final FlexibleDate 開始日;
    private final FlexibleDate 終了日;
    private final GemmenGengakuShurui 減免減額種類;
    private INendo 前年度;
    private Range<FlexibleDate> 期間;

    /**
     * 指定の開始日、終了日を保持する年度を作成します。
     * 年度としての「年」には、開始日の「年」を使用します。
     *
     * @param 開始日 開始日
     * @param 終了日 終了日
     * @throws IllegalArgumentException 開始日＜終了日 の関係が成り立たない場合、または、非歴上日が指定された場合
     */
    protected GemmenNendo(FlexibleDate 開始日, FlexibleDate 終了日, GemmenGengakuShurui 減免減額種類) {
        if (終了日.isBefore(開始日)) {
            throw new IllegalArgumentException();
        }
        this.開始日 = 開始日;
        this.終了日 = 終了日;
        this.年度 = 開始日.getYear();
        this.減免減額種類 = 減免減額種類;
    }

    @Override
    public FlexibleYear getYear() {
        return this.年度;
    }

    @Override
    public FlexibleDate get開始日() {
        return this.開始日;
    }

    @Override
    public FlexibleDate get終了日() {
        return this.終了日;
    }

    @Override
    public boolean between(FlexibleDate 基準日) {
        if (基準日 == null || !基準日.isValid()) {
            return false;
        }
        if (this.期間 == null) {
            this.期間 = new Range<>(開始日, 終了日);
        }
        return this.期間.between(基準日);
    }

    @Override
    public INendo before() {
        if (this.前年度 == null) {
            this.前年度 = GemmenNendoResearcher
                    .createInstance(this.減免減額種類)
                    .find年度Contains(開始日.minusDay(1));
        }
        return this.前年度;
    }
}
