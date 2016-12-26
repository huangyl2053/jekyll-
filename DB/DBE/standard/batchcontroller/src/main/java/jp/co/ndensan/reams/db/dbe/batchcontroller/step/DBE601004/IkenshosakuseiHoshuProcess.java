/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601004;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshohoshushokai.IkenHoshuIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenshoHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成報酬一覧表のプロセス処理の帳票出力のプロセスクラスです。
 *
 * @reamsid_L DBE-1930-020 chenxiangyu
 */
public abstract class IkenshosakuseiHoshuProcess extends BatchProcessBase<IkenshoHoshuShokaiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshohoshushokai.IIkenshoHoshuShokaiRelateMapper.select合計額リスト");
    protected static final ReportId REPORT_ID = ReportIdDBE.DBE601004.getReportId();
    protected static final RString REPORT_NAME = ReportIdDBE.DBE601004.getReportName();
    protected static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE605001"));
    protected static final RString CSV_NAME_EN = new RString("主治医意見書作成料一覧表.csv");
    protected static final RString CSV_NAME_JP = new RString("主治医意見書作成料一覧表CSV");
    protected static final RString なし = new RString("なし");
    protected IkenHoshuIchiranProcessParameter paramter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toMybitisParamter());
    }

    @Override
    protected void process(IkenshoHoshuShokaiRelateEntity relateEntity) {
        output(relateEntity);
    }
    
    protected abstract void output(IkenshoHoshuShokaiRelateEntity relateEntity);

    protected static RString dateFormat(FlexibleDate date) {
        if (date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }
}
