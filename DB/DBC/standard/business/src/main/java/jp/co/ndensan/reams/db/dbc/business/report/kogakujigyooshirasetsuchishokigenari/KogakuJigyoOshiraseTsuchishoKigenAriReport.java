/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyooshirasetsuchishokigenari;

import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyooshirasetsuchishokigenari.KogakuJigyoOshiraseTsuchishoKigenAriSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyooshirasetsuchishokigenari.KogakuJigyoOshiraseTsuchishopaParameterEntity;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額総合事業サービス費給付お知らせ通知書（提出期限あり）Reportクラスです。
 *
 * @reamsid_L DBC-4770-100 wangxingpeng
 */
public class KogakuJigyoOshiraseTsuchishoKigenAriReport extends Report<KogakuJigyoOshiraseTsuchishoKigenAriSource> {

    private final KogakuJigyoOshiraseTsuchishopaParameterEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakuJigyoOshiraseTsuchishopaParameterEntity
     */
    public KogakuJigyoOshiraseTsuchishoKigenAriReport(KogakuJigyoOshiraseTsuchishopaParameterEntity entity) {
        this.entity = entity;

    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuJigyoOshiraseTsuchishoKigenAriSource> writer) {

        IKogakuJigyoOshiraseTsuchishoKigenAriEditor editor = new KogakuJigyoOshiraseTsuchishoKigenAriEditor(entity);

        IKogakuJigyoOshiraseTsuchishoKigenAriBuilder builder = new KogakuJigyoOshiraseTsuchishoKigenAriBuilder(editor);

        writer.writeLine(builder);

    }

}
