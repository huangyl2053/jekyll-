/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140020;

import jp.co.ndensan.reams.db.dbc.business.report.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran.JukyushaKyufujissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakyufujissekiichiran.JukyushaKyufuJissekiIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 受給者給付実績一覧表 のパラメータ
 *
 * @reamsid_L DBC-3070-030 dangjingjing
 */
public class TyouhyouSakuseiProcess extends BatchProcessBase<JukyushaKyufujissekiIchiranRelateEntity> {

    private static final ReportId ID = ReportIdDBC.DBC200002.getReportId();
    private static final RString SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekiichiran."
            + "IJukyushaKyufujissekiIchiranMapper.getSelectAll");
    private final JukyushaKyufuJissekiIchiranData chosahoshuseikyu = new JukyushaKyufuJissekiIchiranData();

    @BatchWriter
    private BatchReportWriter<JukyushaKyufuJissekiIchiranReportSource> batchReportWriter;
    private ReportSourceWriter<JukyushaKyufuJissekiIchiranReportSource> reportSourceWriter;
    private RString 導入団体コード;
    private RString 市町村名;
    private int index_tmp = 0;

    @Override
    protected void initialize() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value())
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(JukyushaKyufujissekiIchiranRelateEntity entity) {
        index_tmp++;
        chosahoshuseikyu.set作成日時(RDate.getNowDateTime());
        chosahoshuseikyu.set市町村コード(導入団体コード);
        chosahoshuseikyu.set市町村名(市町村名);
        chosahoshuseikyu.set被保険者番号(entity.get被保険者番号());
        chosahoshuseikyu.set被保険者氏名(entity.get被保険者氏名());
        chosahoshuseikyu.set要介護度(entity.get要介護状態区分名称());
        chosahoshuseikyu.setサービス提供年月(new FlexibleYearMonth(entity.getサービス提供年月()));
        chosahoshuseikyu.set公費負担者1(entity.get公費1_負担者番号());
        chosahoshuseikyu.set公費受給者1(entity.get公費1_受給者番号());
        chosahoshuseikyu.setサービス単位数_保険(entity.get後_保険_サービス単位数());
        chosahoshuseikyu.setサービス単位数_公費1(entity.get後_公費1_サービス単位数());
        chosahoshuseikyu.set請求額_保険(entity.get後_保険_請求額());
        chosahoshuseikyu.set請求額_公費1(entity.get後_公費1_請求額());
        chosahoshuseikyu.set負担額_利用者(entity.get後_保険_利用者負担額());
        chosahoshuseikyu.set負担額_公費本人1(entity.get後_公費1_本人負担額());
        chosahoshuseikyu.set緊急時施設療養請求合計額_保険(entity.get後_緊急時施設療養費請求額());
        chosahoshuseikyu.set緊急時施設療養請求合計額_公費1(entity.get後_公費1_緊急時施設療養費請求額());
        chosahoshuseikyu.set特定診療請求合計額_保険(entity.get後_保険_特定診療費請求額());
        chosahoshuseikyu.set特定診療請求合計額_公費1(entity.get後_公費1_特定入所者介護サービス費等請求額());
        chosahoshuseikyu.set特定入所者介護費等請求額_保険(entity.get後_公費1_特定入所者介護サービス費等請求額());
        chosahoshuseikyu.set特定入所者介護費等請求額_公費1(entity.get後_公費1_特定入所者介護サービス費等請求額());
        chosahoshuseikyu.set識別コード(entity.get識別コード());
        chosahoshuseikyu.set住所(entity.get住所());
        chosahoshuseikyu.set様式(entity.get様式());
        chosahoshuseikyu.set公費負担者2(entity.get公費2_負担者番号());
        chosahoshuseikyu.set公費受給者2(entity.get公費2_受給者番号());
        chosahoshuseikyu.setサービス単位数_公費2(entity.get後_公費2_サービス単位数());
        chosahoshuseikyu.set請求額_公費2(entity.get後_公費2_請求額());
        chosahoshuseikyu.set負担額_公費本人2(entity.get後_公費2_本人負担額());
        chosahoshuseikyu.set緊急時施設療養請求合計額_公費2(entity.get後_公費2_緊急時施設療養費請求額());
        chosahoshuseikyu.set特定診療請求合計額_公費2(entity.get後_公費2_特定入所者介護サービス費等請求額());
        chosahoshuseikyu.set特定入所者介護費等請求額_公費2(entity.get後_公費2_特定入所者介護サービス費等請求額());
        chosahoshuseikyu.set審査年月(new FlexibleYearMonth(entity.get審査年月()));
        chosahoshuseikyu.set世帯コード(entity.get世帯コード());
        chosahoshuseikyu.set事業者番号(entity.get事業所番号());
        chosahoshuseikyu.set事業者名称(entity.get事業者名称());
        chosahoshuseikyu.set実績区分(entity.get給付実績区分名称());
        chosahoshuseikyu.set公費負担者3(entity.get公費3_負担者番号());
        chosahoshuseikyu.set公費受給者3(entity.get公費3_受給者番号());
        chosahoshuseikyu.setサービス単位数_公費3(entity.get後_公費3_サービス単位数());
        chosahoshuseikyu.set請求額_公費3(entity.get後_公費2_請求額());
        chosahoshuseikyu.set負担額_公費本人3(entity.get後_公費3_本人負担額());
        chosahoshuseikyu.set緊急時施設療養請求合計額_公費3(entity.get後_公費3_緊急時施設療養費請求額());
        chosahoshuseikyu.set特定診療請求合計額_公費3(entity.get後_公費3_特定入所者介護サービス費等請求額());
        chosahoshuseikyu.set特定入所者介護費等請求額_公費3(entity.get後_公費3_特定入所者介護サービス費等請求額());
        JukyushaKyufuJissekiIchiranReport report = new JukyushaKyufuJissekiIchiranReport(chosahoshuseikyu);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        if (index_tmp == 0) {
            JukyushaKyufuJissekiIchiranData entity = new JukyushaKyufuJissekiIchiranData();
            entity.set被保険者氏名(new RString("該当データ無し"));
            JukyushaKyufuJissekiIchiranReport report = new JukyushaKyufuJissekiIchiranReport(entity);
            report.writeBy(reportSourceWriter);
        }
    }
}
