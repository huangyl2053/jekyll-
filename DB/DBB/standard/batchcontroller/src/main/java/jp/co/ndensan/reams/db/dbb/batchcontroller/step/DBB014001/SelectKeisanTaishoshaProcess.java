/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014001.FuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.FuchoKarisanteiFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka.FuchoKarisanteiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収同定一覧情報のクラスです。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
public class SelectKeisanTaishoshaProcess extends BatchKeyBreakBase<FuchoKarisanteiFukaEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuchokarisanteifuka."
                    + "IFuchoKarisanteiFukaMapper.get特別徴収同定一覧情報");
    private static final RString TABLE_NAME = new RString("FuchoKarisanteiTemp");
    private static final RString BATCH_ID = new RString("DBBBT34001");
    private static final Code エラーコード_08 = new Code("08");
    private static final RString 定数_0000 = new RString("0000");
    private static final RString 枝番号_01 = new RString("01");
    private static final int NUM_1 = 1;
    private static final int NUM_4 = 4;
    private static final int NUM_14 = 14;
    private FuchoKarisanteiFukaProcessParameter parameter;
    private FlexibleDate 賦課年度開始日;
    private int 資格件数;

    @BatchWriter
    IBatchTableWriter tempTableWriter;

    @BatchWriter
    BatchPermanentTableWriter tableWriter;

    @Override
    protected void initialize() {
        賦課年度開始日 = new FlexibleDate(parameter.get賦課年度().getYearValue(), NUM_4, NUM_1);
        資格件数 = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tempTableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, FuchoKarisanteiTempEntity.class);
        tableWriter = new BatchPermanentTableWriter(DbT2010FukaErrorListEntity.class);
    }

    @Override
    protected void keyBreakProcess(FuchoKarisanteiFukaEntity entity) {
    }

    @Override
    protected void usualProcess(FuchoKarisanteiFukaEntity entity) {
        if (entity.get資格() == null && entity.get賦課() != null) {
            DbT2010FukaErrorListEntity item = get賦課エラー一覧(entity);
            tableWriter.insert(item);
        } else if (entity.get資格() != null && entity.get賦課() == null) {
            FuchoKarisanteiTempEntity item = get普徴仮算定抽出Temp(entity.get資格());
            item.setChoteiNendo(parameter.get調定年度());
            item.setFukaNendo(parameter.get賦課年度());
            item.setTsuchishoNo(new TsuchishoNo(定数_0000.concat(entity.get資格().getHihokenshaNo().
                    getColumnValue()).concat(枝番号_01)));
            item.setFukaYMD(get賦課期日(entity));
            tempTableWriter.insert(item);
        } else {
            if (getBefore() != null && (getBefore().get資格() == null
                    || !getBefore().get資格().getHihokenshaNo().equals(entity.get資格().getHihokenshaNo()))) {
                資格件数 = 0;
            }
            FuchoKarisanteiTempEntity item = get普徴仮算定抽出Temp(entity.get資格());
            資格件数++;
            if (資格件数 == NUM_1) {
                item.setChoteiNendo(entity.get賦課().getChoteiNendo());
                item.setFukaNendo(entity.get賦課().getFukaNendo());
                item.setTsuchishoNo(entity.get賦課().getTsuchishoNo());
            } else {
                item.setChoteiNendo(parameter.get調定年度());
                item.setFukaNendo(parameter.get賦課年度());
                item.setTsuchishoNo(new TsuchishoNo(entity.get賦課().getTsuchishoNo().getColumnValue().substring(0, NUM_14).
                        concat(entity.get賦課().getTsuchishoNo().getColumnValue().substring(NUM_14))));
            }
            item.setFukaYMD(get賦課期日(entity));
            tempTableWriter.insert(item);
        }
    }

    @Override
    protected void afterExecute() {

    }

    private FlexibleDate get賦課期日(FuchoKarisanteiFukaEntity entity) {
        if (parameter.getバッチ起動日時().getDate().isBefore(new RDate(賦課年度開始日.toString()))) {
            return 賦課年度開始日;
        }
        FlexibleDate temp = entity.get資格().getIchigoShikakuShutokuYMD();
        if (temp != null && temp.isBefore(賦課年度開始日)) {
            return 賦課年度開始日;
        } else {
            return temp;
        }
    }

    private DbT2010FukaErrorListEntity get賦課エラー一覧(FuchoKarisanteiFukaEntity entity) {
        DbT2010FukaErrorListEntity item = new DbT2010FukaErrorListEntity();
        item.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        item.setInternalReportId(ReportIdDBB.DBB200006.getReportId().getColumnValue());
        item.setInternalReportCreationDateTime(RDateTime.MAX);
        item.setFukaNendo(parameter.get賦課年度());
        item.setTsuchishoNo(entity.get賦課().getTsuchishoNo());
        item.setBatchId(BATCH_ID);
        item.setBatchStartingDateTime(parameter.getバッチ起動日時());
        item.setErrorCode(エラーコード_08);
        item.setHihokenshaNo(entity.get賦課().getHihokenshaNo());
        item.setShikibetsuCode(entity.get賦課().getShikibetsuCode());
        item.setShikakuShutokuYMD(entity.get賦課().getShikakuShutokuYMD());
        item.setShikakuShutokuJiyu(entity.get賦課().getShikakuShutokuJiyu());
        item.setShikakuSoshitsuYMD(entity.get賦課().getShikakuSoshitsuYMD());
        item.setShikakuSoshitsuJiyu(entity.get賦課().getShikakuSoshitsuJiyu());
        return item;
    }

    private FuchoKarisanteiTempEntity get普徴仮算定抽出Temp(DbT1001HihokenshaDaichoEntity 資格) {
        FuchoKarisanteiTempEntity item = new FuchoKarisanteiTempEntity();
        item.setHihokenshaNo(資格.getHihokenshaNo());
        item.setIdoYMD(資格.getIdoYMD());
        item.setEdaNo(資格.getEdaNo());
        item.setIdoJiyuCode(資格.getIdoJiyuCode());
        item.setShichosonCode(資格.getShichosonCode());
        item.setShikibetsuCode(資格.getShikibetsuCode());
        item.setShikakuShutokuJiyuCode(資格.getShikakuShutokuJiyuCode());
        item.setShikakuShutokuYMD(資格.getShikakuShutokuYMD());
        item.setShikakuShutokuTodokedeYMD(資格.getShikakuShutokuTodokedeYMD());
        item.setIchigoShikakuShutokuYMD(資格.getIchigoShikakuShutokuYMD());
        item.setHihokennshaKubunCode(資格.getHihokennshaKubunCode());
        item.setShikakuSoshitsuJiyuCode(資格.getShikakuSoshitsuJiyuCode());
        item.setShikakuSoshitsuYMD(資格.getShikakuSoshitsuYMD());
        item.setShikakuSoshitsuTodokedeYMD(資格.getShikakuSoshitsuTodokedeYMD());
        item.setShikakuHenkoJiyuCode(資格.getShikakuHenkoJiyuCode());
        item.setShikakuHenkoYMD(資格.getShikakuHenkoYMD());
        item.setShikakuHenkoTodokedeYMD(資格.getShikakuHenkoTodokedeYMD());
        item.setJushochitokureiTekiyoJiyuCode(資格.getJushochitokureiTekiyoJiyuCode());
        item.setJushochitokureiTekiyoYMD(資格.getJushochitokureiTekiyoYMD());
        item.setJushochitokureiTekiyoTodokedeYMD(資格.getJushochitokureiTekiyoTodokedeYMD());
        item.setJushochitokureiKaijoJiyuCode(資格.getJushochitokureiKaijoJiyuCode());
        item.setJushochitokureiKaijoYMD(資格.getJushochitokureiKaijoYMD());
        item.setJushochitokureiKaijoTodokedeYMD(資格.getJushochitokureiKaijoTodokedeYMD());
        item.setJushochiTokureiFlag(資格.getJushochiTokureiFlag());
        item.setKoikinaiJushochiTokureiFlag(資格.getKoikinaiJushochiTokureiFlag());
        item.setKoikinaiTokureiSochimotoShichosonCode(資格.getKoikinaiTokureiSochimotoShichosonCode());
        item.setKyuShichosonCode(資格.getKyuShichosonCode());
        item.setLogicalDeletedFlag(資格.getLogicalDeletedFlag());
        return item;
    }
}
