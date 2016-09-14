/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteitsuchihakko;

import jp.co.ndensan.reams.db.dbc.entity.report.kogakushikyufushikyuketteitsuchihakkoichiran.KogakuShikyuFushikyuKetteiTsuchiHakkoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額介護サービス費支給（不支給）決定通知一覧表Builerクラスです。
 *
 * @reamsid_L DBC-2000-080 wangxingpeng
 *
 */
public class KogakuShikyuFushikyuKetteiTsuchiHakkoBuilder implements IKogakuShikyuFushikyuKetteiTsuchiHakkoBuilder {

    private final IKogakuShikyuFushikyuKetteiTsuchiHakkoEditor headerEditor;
    private final IKogakuShikyuFushikyuKetteiTsuchiHakkoEditor bodyEditor;

    public KogakuShikyuFushikyuKetteiTsuchiHakkoBuilder(IKogakuShikyuFushikyuKetteiTsuchiHakkoEditor headerEditor,
            IKogakuShikyuFushikyuKetteiTsuchiHakkoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
        this.headerEditor = headerEditor;
    }

    @Override
    public KogakuShikyuFushikyuKetteiTsuchiHakkoSource build() {
        return ReportEditorJoiner.from(new KogakuShikyuFushikyuKetteiTsuchiHakkoSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }

}
