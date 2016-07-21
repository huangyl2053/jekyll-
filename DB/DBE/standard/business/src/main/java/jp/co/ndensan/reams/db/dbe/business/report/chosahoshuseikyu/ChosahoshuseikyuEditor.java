/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshuseikyu;

import jp.co.ndensan.reams.db.dbe.business.core.chosahoshuseikyu.Chosahoshuseikyu;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuseikyu.ChosahoshuseikyuReportSource;

/**
 * 認定調査報酬請求書のEditorです。
 *
 * @reamsid_L DBE-1980-043 suguangjun
 */
public class ChosahoshuseikyuEditor implements IChosahoshuseikyuEditor {

    private final Chosahoshuseikyu item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link Chosahoshuseikyu}
     */
    protected ChosahoshuseikyuEditor(Chosahoshuseikyu item) {
        this.item = item;
    }

    @Override
    public ChosahoshuseikyuReportSource edit(ChosahoshuseikyuReportSource source) {
        return editSource(source);
    }

    private ChosahoshuseikyuReportSource editSource(ChosahoshuseikyuReportSource source) {
        source.hakkoYMD = item.get発行年月日();
        source.chosaItakusakiYubimNo = item.get郵便番号();
        source.chosaItakusakiJusho = item.get住所();
        source.chosaItakusakiName = item.get調査機関();
        source.daihyoshaName = item.get代表者名();
        source.title = item.getタイトル();
        source.tsuchibun1 = item.get通知文1();
        source.taishoKikan = item.get対象期間();
        source.gokeiKingaku1 = item.get請求金額();
        source.sakuseiKensuKei = item.get作成件数合計();
        source.shokeiKingaku = item.get小計();
        source.shohizei = item.get消費税額();
        source.gokeiKingaku2 = item.get合計金額();
        source.tsuchibun2 = item.get通知文2();
        return source;
    }
}
