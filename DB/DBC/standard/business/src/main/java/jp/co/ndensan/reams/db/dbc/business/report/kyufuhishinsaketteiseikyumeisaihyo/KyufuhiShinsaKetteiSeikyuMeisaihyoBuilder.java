/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhishinsaketteiseikyumeisaihyo;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufuhishinsaketteiseikyumeisaihyo.KyufuhiShinsaKetteiSeikyuMeisaihyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護給付費等審査決定請求明細表のBuilderクラスです。
 *
 * @reamsid_L DBC-2500-030 jiangxiaolong
 */
public class KyufuhiShinsaKetteiSeikyuMeisaihyoBuilder implements IKyufuhiShinsaKetteiSeikyuMeisaihyoBuilder {

    private final IKyufuhiShinsaKetteiSeikyuMeisaihyoEditor headerEditor;
    private final IKyufuhiShinsaKetteiSeikyuMeisaihyoEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IKyufuhiShinsaKetteiSeikyuMeisaihyoEditor
     * @param bodyEditor IKyufuhiShinsaKetteiSeikyuMeisaihyoEditor
     */
    public KyufuhiShinsaKetteiSeikyuMeisaihyoBuilder(
            IKyufuhiShinsaKetteiSeikyuMeisaihyoEditor headerEditor,
            IKyufuhiShinsaKetteiSeikyuMeisaihyoEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KyufuhiShinsaKetteiSeikyuMeisaihyoSource build() {
        return ReportEditorJoiner.from(new KyufuhiShinsaKetteiSeikyuMeisaihyoSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
