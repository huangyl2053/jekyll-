/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyooshirasetsuchishokigennashi;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyooshirasetsuchishoteshutsukigennashi.KogakuJigyoOshiraseTsuchishoKigenNashiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyooshirasetsuchishoteshutsukigennashi.KogakuJigyoOshiraseTsuchishoKigenNashiSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額総合事業サービス費給付お知らせ通知書（提出期限なし）Reportクラスです。
 *
 * @reamsid_L DBC-4770-110 wangxingpeng
 */
public class KogakuJigyoOshiraseTsuchishoKigenNashiReport extends Report<KogakuJigyoOshiraseTsuchishoKigenNashiSource> {

    private final KogakuJigyoOshiraseTsuchishoKigenNashiEntity entity;

    /**
     * コンストラクタです
     *
     * @param entity KogakuJigyoOshiraseTsuchishoKigenNashiEntity
     */
    public KogakuJigyoOshiraseTsuchishoKigenNashiReport(KogakuJigyoOshiraseTsuchishoKigenNashiEntity entity) {
        this.entity = entity;

    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuJigyoOshiraseTsuchishoKigenNashiSource> writer) {

        IKogakuJigyoOshiraseTsuchishoKigenNashiEditor editor = new KogakuJigyoOshiraseTsuchishoKigenNashiEditor(entity);

        IKogakuJigyoOshiraseTsuchishoKigenNashiBuilder builder = new KogakuJigyoOshiraseTsuchishoKigenNashiBuilder(editor);

        writer.writeLine(builder);

    }

}
