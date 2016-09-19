/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyokogakushikyufushikyukettetsuchiich;

import jp.co.ndensan.reams.db.dbc.entity.report.jigyokogakushikyufushikyukettetsuchiichiran.JigyoKogakuShikyuFushikyuKetteTsuchiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 事業高額支給不支給決定通知一覧表Buidlerクラスです。
 *
 * @reamsid_L DBC-2000-110 wangxingpeng
 *
 */
public class JigyoKogakuShikyuFushikyuKetteTsuchiBuidler
        implements IJigyoKogakuShikyuFushikyuKetteTsuchiBuilder {

    private final IJigyoKogakuShikyuFushikyuKetteTsuchiEditor headerEditor;
    private final IJigyoKogakuShikyuFushikyuKetteTsuchiEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IJigyoKogakuShikyuFushikyuKetteTsuchiEditor
     * @param bodyEditor IJigyoKogakuShikyuFushikyuKetteTsuchiEditor
     */
    public JigyoKogakuShikyuFushikyuKetteTsuchiBuidler(IJigyoKogakuShikyuFushikyuKetteTsuchiEditor headerEditor,
            IJigyoKogakuShikyuFushikyuKetteTsuchiEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
        this.headerEditor = headerEditor;
    }

    @Override
    public JigyoKogakuShikyuFushikyuKetteTsuchiSource build() {
        return ReportEditorJoiner.from(new JigyoKogakuShikyuFushikyuKetteTsuchiSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
