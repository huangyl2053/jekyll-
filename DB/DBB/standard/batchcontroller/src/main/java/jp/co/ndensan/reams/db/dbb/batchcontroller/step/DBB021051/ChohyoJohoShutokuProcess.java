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
                ReportIdDBZ.DBZ100001.getReportId(), parameter.get出力順ID());
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
        ICheckListInfo info = CheckListInfoFactory.createInstance(SubGyomuCode.DBZ介護共通,
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

        key1("chkShikibetsuCode", "識別コード1枚目"),
        key2("chkShikibetsuCode1", "識別コード2枚目"),
        key3("chkShikibetsuCode2", "識別コード3枚目"),
        key4("chkShikibetsuCode3", "識別コード4枚目"),
        key5("chkShikibetsuCode4", "識別コード5枚目"),
        key6("chkShikibetsuCode5", "識別コード6枚目"),
        key7("chkShikibetsuCode6", "識別コード7枚目"),
        key8("chkShikibetsuCode7", "識別コード8枚目"),
        key9("chkShikibetsuCode8", "識別コード9枚目"),
        key10("chkShikibetsuCode9", "識別コード10枚目"),
        key11("chkShikibetsuCode10", "識別コード11枚目"),
        key12("chkShikibetsuCode11", "識別コード12枚目");

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

        target1("chkJusho", "住所1枚目", CheckShubetsu.仮登録外字),
        target2("chkJusho1", "住所2枚目", CheckShubetsu.仮登録外字),
        target3("chkJusho2", "住所3枚目", CheckShubetsu.仮登録外字),
        target4("chkJusho3", "住所4枚目", CheckShubetsu.仮登録外字),
        target5("chkJusho4", "住所5枚目", CheckShubetsu.仮登録外字),
        target6("chkJusho5", "住所6枚目", CheckShubetsu.仮登録外字),
        target7("chkJusho6", "住所7枚目", CheckShubetsu.仮登録外字),
        target8("chkJusho7", "住所8枚目", CheckShubetsu.仮登録外字),
        target9("chkJusho8", "住所9枚目", CheckShubetsu.仮登録外字),
        target10("chkJusho9", "住所10枚目", CheckShubetsu.仮登録外字),
        target11("chkJusho10", "住所11枚目", CheckShubetsu.仮登録外字),
        target12("chkJusho11", "住所12枚目", CheckShubetsu.仮登録外字),
        target13("chkShimei", "氏名1枚目", CheckShubetsu.仮登録外字),
        target14("chkShimei1", "氏名2枚目", CheckShubetsu.仮登録外字),
        target15("chkShimei2", "氏名3枚目", CheckShubetsu.仮登録外字),
        target16("chkShimei3", "氏名4枚目", CheckShubetsu.仮登録外字),
        target17("chkShimei4", "氏名5枚目", CheckShubetsu.仮登録外字),
        target18("chkShimei5", "氏名6枚目", CheckShubetsu.仮登録外字),
        target19("chkShimei6", "氏名7枚目", CheckShubetsu.仮登録外字),
        target20("chkShimei7", "氏名8枚目", CheckShubetsu.仮登録外字),
        target21("chkShimei8", "氏名9枚目", CheckShubetsu.仮登録外字),
        target22("chkShimei9", "氏名10枚目", CheckShubetsu.仮登録外字),
        target23("chkShimei10", "氏名11枚目", CheckShubetsu.仮登録外字),
        target24("chkShimei11", "氏名12枚目", CheckShubetsu.仮登録外字),
        target25("chkKatagaki", "方書1枚目", CheckShubetsu.仮登録外字),
        target26("chkKatagaki1", "方書2枚目", CheckShubetsu.仮登録外字),
        target27("chkKatagaki2", "方書3枚目", CheckShubetsu.仮登録外字),
        target28("chkKatagaki3", "方書4枚目", CheckShubetsu.仮登録外字),
        target29("chkKatagaki4", "方書5枚目", CheckShubetsu.仮登録外字),
        target30("chkKatagaki5", "方書6枚目", CheckShubetsu.仮登録外字),
        target31("chkKatagaki6", "方書7枚目", CheckShubetsu.仮登録外字),
        target32("chkKatagaki7", "方書8枚目", CheckShubetsu.仮登録外字),
        target33("chkKatagaki8", "方書9枚目", CheckShubetsu.仮登録外字),
        target34("chkKatagaki9", "方書10枚目", CheckShubetsu.仮登録外字),
        target35("chkKatagaki10", "方書11枚目", CheckShubetsu.仮登録外字),
        target36("chkKatagaki11", "方書12枚目", CheckShubetsu.仮登録外字),
        target37("samabunShimei1", "様分氏名1枚目", CheckShubetsu.仮登録外字),
        target38("samabunShimei3", "様分氏名2枚目", CheckShubetsu.仮登録外字),
        target39("samabunShimei5", "様分氏名3枚目", CheckShubetsu.仮登録外字),
        target40("samabunShimei7", "様分氏名4枚目", CheckShubetsu.仮登録外字),
        target41("samabunShimei9", "様分氏名5枚目", CheckShubetsu.仮登録外字),
        target42("samabunShimei11", "様分氏名6枚目", CheckShubetsu.仮登録外字),
        target43("samabunShimei13", "様分氏名7枚目", CheckShubetsu.仮登録外字),
        target44("samabunShimei15", "様分氏名8枚目", CheckShubetsu.仮登録外字),
        target45("samabunShimei17", "様分氏名9枚目", CheckShubetsu.仮登録外字),
        target46("samabunShimei19", "様分氏名10枚目", CheckShubetsu.仮登録外字),
        target47("samabunShimei21", "様分氏名11枚目", CheckShubetsu.仮登録外字),
        target48("samabunShimei23", "様分氏名12枚目", CheckShubetsu.仮登録外字);
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
