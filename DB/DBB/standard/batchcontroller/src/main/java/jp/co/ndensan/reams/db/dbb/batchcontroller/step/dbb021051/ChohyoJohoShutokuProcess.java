/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB021051;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.dbb021051.DBB021051DataUtil;
import jp.co.ndensan.reams.db.dbb.business.report.dbb021051.DBB021051OutPutOrder;
import jp.co.ndensan.reams.db.dbb.business.report.dbb021051.DBZ100001AtenaSealEntity;
import jp.co.ndensan.reams.db.dbb.business.report.dbb021051.DBZ100001AtenaSealParameterEntity;
import jp.co.ndensan.reams.db.dbb.business.report.dbz100001.AtenaSealReport;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb021051.DBB021051ProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051.DBB021051TableJohoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.atenaseal.DBZ100001AtenaSealSource;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）のプロセスクラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
public class ChohyoJohoShutokuProcess extends BatchKeyBreakBase<DBB021051TableJohoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "dbb021051.IDBB021051Mapper.get宛名シール情報一時");
    private static final RString ORDERBY = new RString("order by");
    private static final int 最大宛先数 = 12;
    private static final int INT_5 = 5;
    private static final RString ERROR_出力順 = new RString("出力順");
    private static final RString ERROR_市町村コード = new RString("000000");
    private DBB021051ProcessParameter parameter;
    private DBB021051DataUtil dataUtil;
    private DBZ100001AtenaSealParameterEntity paramEntity;
    private List<DBZ100001AtenaSealEntity> entityList;
    private RString システム日付;
    private List<RString> 出力順項目List;
    private Association 地方公共団体情報;
    private RString 出力順;
    private IOutputOrder 出力順情報;
    @BatchWriter
    private IBatchReportWriterWithCheckList<DBZ100001AtenaSealSource> checkWriter;
    private ReportSourceWriter<DBZ100001AtenaSealSource> reportSourceWriter;

    @Override
    protected void initialize() {
        出力順項目List = new ArrayList<>();
        地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        dataUtil = new DBB021051DataUtil();
        entityList = new ArrayList<>();
        システム日付 = DateConverter.getDate4(RDate.getNowDate());
        出力順情報 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBZ介護共通,
                ReportIdDBZ.DBZ100001.getReportId(), Long.parseLong(parameter.get出力順ID().toString()));
        if (出力順情報 == null) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace(ERROR_出力順.toString()));
        }
        出力順 = MyBatisOrderByClauseCreator.create(DBB021051OutPutOrder.class, 出力順情報).replace(ORDERBY, RString.EMPTY);
        int i = 0;
        for (ISetSortItem setSortItem : 出力順情報.get設定項目リスト()) {
            if (i < INT_5) {
                出力順項目List.add(setSortItem.get項目名());
            }
            i++;
        }
        List<KoikiZenShichosonJoho> koikiZenShichosonJohoList
                = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records();
        KoikiZenShichosonJoho koikiZenShichosonJoho;
        if (koikiZenShichosonJohoList == null || koikiZenShichosonJohoList.isEmpty()) {
            koikiZenShichosonJoho = null;
        } else {
            koikiZenShichosonJoho = koikiZenShichosonJohoList.get(0);
        }
        dataUtil.intProcessParameter(koikiZenShichosonJoho, parameter);
    }

    @Override
    protected void createWriter() {
        CheckListLineItemSet pairs = CheckListLineItemSet.
                of(ChohyoJohoShutokuProcess.特定項目.class,
                        ChohyoJohoShutokuProcess.チェック項目.class);
//        TODO QA Redmine#100667
        ICheckListInfo info = CheckListInfoFactory.createInstance(SubGyomuCode.DBB介護賦課,
                地方公共団体情報.get地方公共団体コード(), 地方公共団体情報.get市町村名());
        this.checkWriter = BatchWriters
                .batchReportWriterWithCheckList(DBZ100001AtenaSealSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdDBZ.DBZ100001.getReportId())
                .build();
        this.reportSourceWriter = new ReportSourceWriter<>(this.checkWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter.toDBB021051MyBatisParameter(出力順));
    }

    @Override
    protected void usualProcess(DBB021051TableJohoTempEntity entity) {
        RString 市町村コード = entity.get市町村コード();
        RString 市町村名;
        市町村名 = ERROR_市町村コード.equals(市町村コード) ? RString.EMPTY
                : AssociationFinderFactory.createInstance().getAssociation(new LasdecCode(市町村コード)).get市町村名();
        if (getBefore() == null) {
            paramEntity = dataUtil.getChohyoParameterEntity(市町村コード, 市町村名, システム日付);
            paramEntity.setEntityList(entityList);
            entityList.add(dataUtil.getDBZ100001AtenaSealEntity(parameter, entity));
            return;
        }
        if (entityList.size() >= 最大宛先数) {
            new AtenaSealReport(paramEntity).writeBy(reportSourceWriter);
            paramEntity = dataUtil.getChohyoParameterEntity(市町村コード, 市町村名, システム日付);
            entityList.clear();
            paramEntity.setEntityList(entityList);
            entityList.add(dataUtil.getDBZ100001AtenaSealEntity(parameter, entity));
            return;
        }
        if (dataUtil.eqNonullRStr(市町村コード, getBefore().get市町村コード())) {
            entityList.add(dataUtil.getDBZ100001AtenaSealEntity(parameter, entity));
            return;
        }
        int 補足エンティティ数 = 最大宛先数 - this.entityList.size();
        for (int i = 0; i < 補足エンティティ数; i++) {
            this.entityList.add(new DBZ100001AtenaSealEntity());
        }
        new AtenaSealReport(paramEntity).writeBy(reportSourceWriter);
        paramEntity = dataUtil.getChohyoParameterEntity(市町村コード, 市町村名, システム日付);
        entityList.clear();
        paramEntity.setEntityList(entityList);
        entityList.add(dataUtil.getDBZ100001AtenaSealEntity(parameter, entity));
    }

    @Override
    protected void afterExecute() {
        if (!entityList.isEmpty()) {
            int 補足エンティティ数 = 最大宛先数 - this.entityList.size();
            for (int i = 0; i < 補足エンティティ数; i++) {
                this.entityList.add(new DBZ100001AtenaSealEntity());
            }
            new AtenaSealReport(paramEntity).writeBy(reportSourceWriter);
        }
        ReportOutputJokenhyoItem reportOutputJokenhyoItem
                = dataUtil.getReportOutputJokenhyoItem(地方公共団体情報.getLasdecCode_().value(), 地方公共団体情報.get市町村名(),
                        new RString(JobContextHolder.getJobId()), reportSourceWriter.pageCount().value(), 出力順項目List, parameter);
        OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem).print();
    }

    private enum 特定項目 implements ISpecificKey {

        key1("jushoText", "住所TXT1枚目"),
        key2("jushoText1", "住所TXT2枚目"),
        key3("jushoText2", "住所TXT3枚目"),
        key4("jushoText3", "住所TXT4枚目"),
        key5("jushoText4", "住所TXT5枚目"),
        key6("jushoText5", "住所TXT6枚目"),
        key7("jushoText6", "住所TXT7枚目"),
        key8("jushoText7", "住所TXT8枚目"),
        key9("jushoText8", "住所TXT9枚目"),
        key10("jushoText9", "住所TXT10枚目"),
        key11("jushoText10", "住所TXT11枚目"),
        key12("jushoText11", "住所TXT12枚目");

        private final RString itemName;
        private final RString printName;

        private 特定項目(String itemName, String printName) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }
    }

    private enum チェック項目 implements ICheckTarget {

        target1("jushoText", "住所TXT1枚目", CheckShubetsu.文字切れ),
        target2("jushoText1", "住所TXT2枚目", CheckShubetsu.文字切れ),
        target3("jushoText2", "住所TXT3枚目", CheckShubetsu.文字切れ),
        target4("jushoText3", "住所TXT4枚目", CheckShubetsu.文字切れ),
        target5("jushoText4", "住所TXT5枚目", CheckShubetsu.文字切れ),
        target6("jushoText5", "住所TXT6枚目", CheckShubetsu.文字切れ),
        target7("jushoText6", "住所TXT7枚目", CheckShubetsu.文字切れ),
        target8("jushoText7", "住所TXT8枚目", CheckShubetsu.文字切れ),
        target9("jushoText8", "住所TXT9枚目", CheckShubetsu.文字切れ),
        target10("jushoText9", "住所TXT10枚目", CheckShubetsu.文字切れ),
        target11("jushoText10", "住所TXT11枚目", CheckShubetsu.文字切れ),
        target12("jushoText11", "住所TXT12枚目", CheckShubetsu.文字切れ),
        target13("jushoText", "住所TXT1枚目", CheckShubetsu.仮登録外字),
        target14("jushoText1", "住所TXT2枚目", CheckShubetsu.仮登録外字),
        target15("jushoText2", "住所TXT3枚目", CheckShubetsu.仮登録外字),
        target16("jushoText3", "住所TXT4枚目", CheckShubetsu.仮登録外字),
        target17("jushoText4", "住所TXT5枚目", CheckShubetsu.仮登録外字),
        target18("jushoText5", "住所TXT6枚目", CheckShubetsu.仮登録外字),
        target19("jushoText6", "住所TXT7枚目", CheckShubetsu.仮登録外字),
        target20("jushoText7", "住所TXT8枚目", CheckShubetsu.仮登録外字),
        target21("jushoText8", "住所TXT9枚目", CheckShubetsu.仮登録外字),
        target22("jushoText9", "住所TXT10枚目", CheckShubetsu.仮登録外字),
        target23("jushoText10", "住所TXT11枚目", CheckShubetsu.仮登録外字),
        target24("jushoText11", "住所TXT12枚目", CheckShubetsu.仮登録外字);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目(String itemName, String printName, CheckShubetsu checkShubetsu) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
            this.checkShubetsu = checkShubetsu;
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }

        @Override
        public CheckShubetsu getCheckShubetsu() {
            return this.checkShubetsu;
        }
    }

    @Override
    protected void keyBreakProcess(DBB021051TableJohoTempEntity t) {
    }

}
