/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo.kogakuservicehitaishoshaichiransokyubun;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicehitaishoshaichiransokyubun.KogakuServicehiTaishoshaIchiranSokyubunReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN41003_高額介護サービス費対象者一覧表（遡及分） Builderするクラスです。
 *
 * @reamsid_L DBC-5750-040 kanghongsong
 */
public class KogakuServicehiTaishoshaIchiranSokyubunBuilder implements IKogakuServicehiTaishoshaIchiranSokyubunBuilder {

   private final KogakuServicehiTaishoshaIchiranSokyubunEditor editor;

    /**
     * インスタンスを生成するメソッド。
     *
     * @param editor {@link KogakuServicehiTaishoshaIchiranSokyubunEditor}
     */
    public KogakuServicehiTaishoshaIchiranSokyubunBuilder(KogakuServicehiTaishoshaIchiranSokyubunEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドするメソッド。
     *
     * @return {@link KogakuServicehiTaishoshaIchiranSokyubunReportSource}
     */
    @Override
    public KogakuServicehiTaishoshaIchiranSokyubunReportSource build() {
        return ReportEditorJoiner.from(new KogakuServicehiTaishoshaIchiranSokyubunReportSource())
                .join(editor)
                .buildSource();
    }

}
