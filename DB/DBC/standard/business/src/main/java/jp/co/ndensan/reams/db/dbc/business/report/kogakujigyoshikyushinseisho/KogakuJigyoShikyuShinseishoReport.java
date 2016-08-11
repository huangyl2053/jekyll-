/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseisho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護保険高額総合事業サービス費支給申請書の出力クラスです。
 *
 * @reamsid_L DBC-4770-080 jianglaisheng
 */
public class KogakuJigyoShikyuShinseishoReport extends Report<KogakuJigyoShikyuShinseishoSource> {

    private final KogakuJigyoShikyuShinseishoEntity target;

    /**
     * コンストラクタです。
     *
     * @param target target
     */
    public KogakuJigyoShikyuShinseishoReport(KogakuJigyoShikyuShinseishoEntity target) {
        this.target = target;
    }

    @Override
    protected void writeBy(ReportSourceWriter<KogakuJigyoShikyuShinseishoSource> writer) {
        System.out.print("");
    }

}
