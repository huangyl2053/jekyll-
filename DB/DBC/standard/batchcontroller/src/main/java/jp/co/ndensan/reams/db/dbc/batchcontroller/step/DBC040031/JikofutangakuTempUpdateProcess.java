/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040031;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ErrorListType;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc040031.TyukonShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040031.KogakugassanJikofutangakuInfoHoseiSubEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040031.IKogakugassanJikofutangakuInfoHoseiSubMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 高額支給額集計処理データ更新プロセスです。
 *
 * @reamsid_L DBC-2320-050 yuanzhenxia
 */
public class JikofutangakuTempUpdateProcess extends BatchKeyBreakBase<KogakugassanJikofutangakuInfoHoseiSubEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040031.IKogakugassanJikofutangakuInfoHoseiSubMapper"
            + ".get高額支給額集計データ");
    private static final RString 自己負担額データTEMP = new RString("KogakugassanJikofutangakuInfoHoseiTemp");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB300019"));
    private static final RString 処理名 = new RString("高額合算自己負担額情報一括補正（サブ処理）");
    private static final RString ファイル出力 = new RString("DBU900002_ShoriKekkaKakuninList.csv");
    private static final RString 当年4月 = new RString("004");
    private static final RString 当年5月 = new RString("005");
    private static final RString 当年6月 = new RString("006");
    private static final RString 当年7月 = new RString("007");
    private static final RString 当年8月 = new RString("008");
    private static final RString 当年9月 = new RString("009");
    private static final RString 当年10月 = new RString("010");
    private static final RString 当年11月 = new RString("011");
    private static final RString 当年12月 = new RString("012");
    private static final RString 翌年1月 = new RString("101");
    private static final RString 翌年2月 = new RString("102");
    private static final RString 翌年3月 = new RString("103");
    private static final RString 翌年4月 = new RString("104");
    private static final RString 翌年5月 = new RString("105");
    private static final RString 翌年6月 = new RString("106");
    private static final RString 翌年7月 = new RString("107");
    private static final RString 合計 = new RString("合計");
    private static final RString STRING_ONE = new RString("1");
    private static final RString STRING_TWO = new RString("2");
    private static final int INT_ZERO = 0;
    private Map<RString, Decimal> 高額支給額;
    private Map<RString, HihokenshaNo> 被保険者番号Map;
    private Map<HihokenshaNo, Map> 被保険者番号_高額支給額;
    private KogakugassanJikofutangakuInfoHoseiSubEntity 高額支給額Entity;
    private Decimal 当年04月高額支給額;
    private Decimal 当年05月高額支給額;
    private Decimal 当年06月高額支給額;
    private Decimal 当年07月高額支給額;
    private Decimal 当年08月高額支給額;
    private Decimal 当年09月高額支給額;
    private Decimal 当年010月高額支給額;
    private Decimal 当年011月高額支給額;
    private Decimal 当年012月高額支給額;
    private Decimal 翌年01月高額支給額;
    private Decimal 翌年02月高額支給額;
    private Decimal 翌年03月高額支給額;
    private Decimal 翌年04月高額支給額;
    private Decimal 翌年05月高額支給額;
    private Decimal 翌年06月高額支給額;
    private Decimal 翌年07月高額支給額;
    private List<HihokenshaNo> 被保険者番号List;
    private boolean 処理結果確認リスト中間ファイルFLAG;
    private int count = 0;
    private FileSpoolManager manager;
    @BatchWriter
    private IBatchTableWriter tempDbWriter;
    @BatchWriter
    private CsvWriter<TyukonShoriKekkaKakuninListEntity> csvWriter;

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(自己負担額データTEMP, KogakugassanJikofutangakuInfoHoseiTempEntity.class);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, ファイル出力);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void initialize() {
        高額支給額 = new HashMap<>();
        被保険者番号Map = new HashMap<>();
        被保険者番号List = new ArrayList<>();
        被保険者番号_高額支給額 = new HashMap<>();
        処理結果確認リスト中間ファイルFLAG = false;
        initialize月高額支給額();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void keyBreakProcess(KogakugassanJikofutangakuInfoHoseiSubEntity entity) {
    }

    @Override
    protected void usualProcess(KogakugassanJikofutangakuInfoHoseiSubEntity entity) {
        高額支給額Entity = entity;
        被保険者番号List.add(entity.get被保険者番号());
        if (getBefore() != null) {
            if (getBefore().get被保険者番号().equals(entity.get被保険者番号())) {
                当年04月高額支給額 = edit高額支給額(entity, 当年4月, 当年04月高額支給額);
                当年05月高額支給額 = edit高額支給額(entity, 当年5月, 当年05月高額支給額);
                当年06月高額支給額 = edit高額支給額(entity, 当年6月, 当年06月高額支給額);
                当年07月高額支給額 = edit高額支給額(entity, 当年7月, 当年07月高額支給額);
                当年08月高額支給額 = edit高額支給額(entity, 当年8月, 当年08月高額支給額);
                当年09月高額支給額 = edit高額支給額(entity, 当年9月, 当年09月高額支給額);
                当年010月高額支給額 = edit高額支給額(entity, 当年10月, 当年010月高額支給額);
                当年011月高額支給額 = edit高額支給額(entity, 当年11月, 当年011月高額支給額);
                当年012月高額支給額 = edit高額支給額(entity, 当年12月, 当年012月高額支給額);
                翌年01月高額支給額 = edit高額支給額(entity, 翌年1月, 翌年01月高額支給額);
                翌年02月高額支給額 = edit高額支給額(entity, 翌年2月, 翌年02月高額支給額);
                翌年03月高額支給額 = edit高額支給額(entity, 翌年3月, 翌年03月高額支給額);
                翌年04月高額支給額 = edit高額支給額(entity, 翌年4月, 翌年04月高額支給額);
                翌年05月高額支給額 = edit高額支給額(entity, 翌年5月, 翌年05月高額支給額);
                翌年06月高額支給額 = edit高額支給額(entity, 翌年6月, 翌年06月高額支給額);
                翌年07月高額支給額 = edit高額支給額(entity, 翌年7月, 翌年07月高額支給額);
            } else {
                count++;
                Decimal 高額支給額合計
                        = 当年04月高額支給額
                        .add(当年05月高額支給額)
                        .add(当年06月高額支給額)
                        .add(当年07月高額支給額)
                        .add(当年08月高額支給額)
                        .add(当年09月高額支給額)
                        .add(当年010月高額支給額)
                        .add(当年011月高額支給額)
                        .add(当年012月高額支給額)
                        .add(翌年01月高額支給額)
                        .add(翌年02月高額支給額)
                        .add(翌年03月高額支給額)
                        .add(翌年04月高額支給額)
                        .add(翌年05月高額支給額)
                        .add(翌年06月高額支給額)
                        .add(翌年07月高額支給額);
                処理結果確認リスト中間ファイルを出力(getBefore());
                高額支給額.put(当年4月, 当年04月高額支給額);
                高額支給額.put(当年5月, 当年05月高額支給額);
                高額支給額.put(当年6月, 当年06月高額支給額);
                高額支給額.put(当年7月, 当年07月高額支給額);
                高額支給額.put(当年8月, 当年08月高額支給額);
                高額支給額.put(当年9月, 当年09月高額支給額);
                高額支給額.put(当年10月, 当年010月高額支給額);
                高額支給額.put(当年11月, 当年011月高額支給額);
                高額支給額.put(当年12月, 当年012月高額支給額);
                高額支給額.put(翌年1月, 翌年01月高額支給額);
                高額支給額.put(翌年2月, 翌年02月高額支給額);
                高額支給額.put(翌年3月, 翌年03月高額支給額);
                高額支給額.put(翌年4月, 翌年04月高額支給額);
                高額支給額.put(翌年5月, 翌年05月高額支給額);
                高額支給額.put(翌年6月, 翌年06月高額支給額);
                高額支給額.put(翌年7月, 翌年07月高額支給額);
                高額支給額.put(合計, 高額支給額合計);
                被保険者番号_高額支給額.put(getBefore().get被保険者番号(), 高額支給額);
                initialize月高額支給額();
                当年04月高額支給額 = edit高額支給額(entity, 当年4月, 当年04月高額支給額);
                当年05月高額支給額 = edit高額支給額(entity, 当年5月, 当年05月高額支給額);
                当年06月高額支給額 = edit高額支給額(entity, 当年6月, 当年06月高額支給額);
                当年07月高額支給額 = edit高額支給額(entity, 当年7月, 当年07月高額支給額);
                当年08月高額支給額 = edit高額支給額(entity, 当年8月, 当年08月高額支給額);
                当年09月高額支給額 = edit高額支給額(entity, 当年9月, 当年09月高額支給額);
                当年010月高額支給額 = edit高額支給額(entity, 当年10月, 当年010月高額支給額);
                当年011月高額支給額 = edit高額支給額(entity, 当年11月, 当年011月高額支給額);
                当年012月高額支給額 = edit高額支給額(entity, 当年12月, 当年012月高額支給額);
                翌年01月高額支給額 = edit高額支給額(entity, 翌年1月, 翌年01月高額支給額);
                翌年02月高額支給額 = edit高額支給額(entity, 翌年2月, 翌年02月高額支給額);
                翌年03月高額支給額 = edit高額支給額(entity, 翌年3月, 翌年03月高額支給額);
                翌年04月高額支給額 = edit高額支給額(entity, 翌年4月, 翌年04月高額支給額);
                翌年05月高額支給額 = edit高額支給額(entity, 翌年5月, 翌年05月高額支給額);
                翌年06月高額支給額 = edit高額支給額(entity, 翌年6月, 翌年06月高額支給額);
                翌年07月高額支給額 = edit高額支給額(entity, 翌年7月, 翌年07月高額支給額);
            }
        } else {
            当年04月高額支給額 = edit高額支給額(entity, 当年4月, 当年04月高額支給額);
            当年05月高額支給額 = edit高額支給額(entity, 当年5月, 当年05月高額支給額);
            当年06月高額支給額 = edit高額支給額(entity, 当年6月, 当年06月高額支給額);
            当年07月高額支給額 = edit高額支給額(entity, 当年7月, 当年07月高額支給額);
            当年08月高額支給額 = edit高額支給額(entity, 当年8月, 当年08月高額支給額);
            当年09月高額支給額 = edit高額支給額(entity, 当年9月, 当年09月高額支給額);
            当年010月高額支給額 = edit高額支給額(entity, 当年10月, 当年010月高額支給額);
            当年011月高額支給額 = edit高額支給額(entity, 当年11月, 当年011月高額支給額);
            当年012月高額支給額 = edit高額支給額(entity, 当年12月, 当年012月高額支給額);
            翌年01月高額支給額 = edit高額支給額(entity, 翌年1月, 翌年01月高額支給額);
            翌年02月高額支給額 = edit高額支給額(entity, 翌年2月, 翌年02月高額支給額);
            翌年03月高額支給額 = edit高額支給額(entity, 翌年3月, 翌年03月高額支給額);
            翌年04月高額支給額 = edit高額支給額(entity, 翌年4月, 翌年04月高額支給額);
            翌年05月高額支給額 = edit高額支給額(entity, 翌年5月, 翌年05月高額支給額);
            翌年06月高額支給額 = edit高額支給額(entity, 翌年6月, 翌年06月高額支給額);
            翌年07月高額支給額 = edit高額支給額(entity, 翌年7月, 翌年07月高額支給額);
        }
    }

    @Override
    protected void afterExecute() {
        count++;
        if (高額支給額Entity != null) {
            Decimal 高額支給額合計
                    = 当年04月高額支給額
                    .add(当年05月高額支給額)
                    .add(当年06月高額支給額)
                    .add(当年07月高額支給額)
                    .add(当年08月高額支給額)
                    .add(当年09月高額支給額)
                    .add(当年010月高額支給額)
                    .add(当年011月高額支給額)
                    .add(当年012月高額支給額)
                    .add(翌年01月高額支給額)
                    .add(翌年02月高額支給額)
                    .add(翌年03月高額支給額)
                    .add(翌年04月高額支給額)
                    .add(翌年05月高額支給額)
                    .add(翌年06月高額支給額)
                    .add(翌年07月高額支給額);
            処理結果確認リスト中間ファイルを出力(高額支給額Entity);
            高額支給額.put(当年4月, 当年04月高額支給額);
            高額支給額.put(当年5月, 当年05月高額支給額);
            高額支給額.put(当年6月, 当年06月高額支給額);
            高額支給額.put(当年7月, 当年07月高額支給額);
            高額支給額.put(当年8月, 当年08月高額支給額);
            高額支給額.put(当年9月, 当年09月高額支給額);
            高額支給額.put(当年10月, 当年010月高額支給額);
            高額支給額.put(当年11月, 当年011月高額支給額);
            高額支給額.put(当年12月, 当年012月高額支給額);
            高額支給額.put(翌年1月, 翌年01月高額支給額);
            高額支給額.put(翌年2月, 翌年02月高額支給額);
            高額支給額.put(翌年3月, 翌年03月高額支給額);
            高額支給額.put(翌年4月, 翌年04月高額支給額);
            高額支給額.put(翌年5月, 翌年05月高額支給額);
            高額支給額.put(翌年6月, 翌年06月高額支給額);
            高額支給額.put(翌年7月, 翌年07月高額支給額);
            高額支給額.put(合計, 高額支給額合計);
            被保険者番号_高額支給額.put(高額支給額Entity.get被保険者番号(), 高額支給額);
        }
        List<KogakugassanJikofutangakuInfoHoseiTempEntity> 自己負担額データList
                = getMapper(IKogakugassanJikofutangakuInfoHoseiSubMapper.class).select自己負担額データ();
        for (KogakugassanJikofutangakuInfoHoseiTempEntity entity : 自己負担額データList) {
            Map<RString, Decimal> 支給額 = 被保険者番号_高額支給額.get(entity.getHihokenshaNo());
            entity.setTounen_04_sumi_under_70KogakuShikyuGaku(支給額.get(当年4月));
            entity.setTounen_05_sumi_under_70KogakuShikyuGaku(支給額.get(当年5月));
            entity.setTounen_06_sumi_under_70KogakuShikyuGaku(支給額.get(当年6月));
            entity.setTounen_07_sumi_under_70KogakuShikyuGaku(支給額.get(当年7月));
            entity.setTounen_08_sumi_under_70KogakuShikyuGaku(支給額.get(当年8月));
            entity.setTounen_09_sumi_under_70KogakuShikyuGaku(支給額.get(当年9月));
            entity.setTounen_10_sumi_under_70KogakuShikyuGaku(支給額.get(当年10月));
            entity.setTounen_11_sumi_under_70KogakuShikyuGaku(支給額.get(当年11月));
            entity.setTounen_12_sumi_under_70KogakuShikyuGaku(支給額.get(当年12月));
            entity.setYokunen_01_sumi_under_70KogakuShikyuGaku(支給額.get(翌年1月));
            entity.setYokunen_02_sumi_under_70KogakuShikyuGaku(支給額.get(翌年2月));
            entity.setYokunen_03_sumi_under_70KogakuShikyuGaku(支給額.get(翌年3月));
            entity.setYokunen_04_sumi_under_70KogakuShikyuGaku(支給額.get(翌年4月));
            entity.setYokunen_05_sumi_under_70KogakuShikyuGaku(支給額.get(翌年5月));
            entity.setYokunen_06_sumi_under_70KogakuShikyuGaku(支給額.get(翌年6月));
            entity.setYokunen_07_sumi_under_70KogakuShikyuGaku(支給額.get(翌年7月));
            entity.setSumi_Gokei_Under70KogakuShikyuGaku(支給額.get(合計));
            entity.setBatchHoseiJissiYMD(FlexibleDate.getNowDate());
            // 一覧表用区分 一覧表用区分2 QA No.1700
            tempDbWriter.update(entity);
        }
    }

    private void 処理結果確認リスト中間ファイルを出力(KogakugassanJikofutangakuInfoHoseiSubEntity entity) {
        if (当年04月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            当年04月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (当年05月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            当年05月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (当年06月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            当年06月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (当年07月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            当年07月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (当年08月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            当年08月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (当年09月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            当年09月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (当年010月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            当年010月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (当年011月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            当年011月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (当年012月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            当年012月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (翌年01月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            翌年01月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (翌年02月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            翌年02月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (翌年03月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            翌年03月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (翌年04月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            翌年04月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (翌年05月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            翌年05月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (翌年06月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            翌年06月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (翌年07月高額支給額.compareTo(Decimal.ZERO) < INT_ZERO) {
            翌年07月高額支給額 = Decimal.ZERO;
            処理結果確認リスト中間ファイルFLAG = true;
        }
        if (処理結果確認リスト中間ファイルFLAG) {
            RString 作成日時 = RString.EMPTY;
            if (count == 1) {
                作成日時 = getDate12Time142(RDateTime.now());
            }
            csvWriter.writeLine(new TyukonShoriKekkaKakuninListEntity(
                    作成日時,
                    処理名,
                    entity.get中間DB証記載保険者番号().value(),
                    entity.get被保険者番号().value(),
                    RString.EMPTY,
                    RString.EMPTY,
                    entity.get被保険者番号().value(),
                    entity.get中間DB対象年度().toDateString(),
                    KaigoGassan_ErrorListType.リストタイプ2.get表示名称()
            ));
            処理結果確認リスト中間ファイルFLAG = false;
        }
    }

    private RString getDate12Time142(RDateTime dt) {
        if (dt == null || dt.getDate() == null || dt.getTime() == null) {
            return RString.EMPTY;
        }
        return getDate12(dt.getDate()).concat(RString.HALF_SPACE).concat(getTime142(dt.getTime()));
    }

    private RString getDate12(RDate date) {
        if (date != null) {
            return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString getTime142(RTime time) {
        if (time == null) {
            return RString.EMPTY;
        }
        return time.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
    }

    private void initialize月高額支給額() {
        当年04月高額支給額 = Decimal.ZERO;
        当年05月高額支給額 = Decimal.ZERO;
        当年06月高額支給額 = Decimal.ZERO;
        当年07月高額支給額 = Decimal.ZERO;
        当年08月高額支給額 = Decimal.ZERO;
        当年09月高額支給額 = Decimal.ZERO;
        当年010月高額支給額 = Decimal.ZERO;
        当年011月高額支給額 = Decimal.ZERO;
        当年012月高額支給額 = Decimal.ZERO;
        翌年01月高額支給額 = Decimal.ZERO;
        翌年02月高額支給額 = Decimal.ZERO;
        翌年03月高額支給額 = Decimal.ZERO;
        翌年04月高額支給額 = Decimal.ZERO;
        翌年05月高額支給額 = Decimal.ZERO;
        翌年06月高額支給額 = Decimal.ZERO;
        翌年07月高額支給額 = Decimal.ZERO;

    }

    private Decimal edit高額支給額(KogakugassanJikofutangakuInfoHoseiSubEntity entity, RString 月, Decimal 高額支給額) {
        Decimal 合計支給額 = Decimal.ZERO;
        if (Integer.parseInt(月.toString()) == entity.getサービス提供年月().getMonthValue()) {
            if (RString.isNullOrEmpty(entity.get審査支払区分())) {
                合計支給額 = 高額支給額.add(entity.get合計高額支給額());
            } else if ((STRING_ONE.equals(entity.get審査支払区分()) && RString.isNullOrEmpty(entity.get決定支給区分コード())
                    && STRING_ONE.equals(entity.get結果支給区分コード())) || (STRING_TWO.equals(entity.get審査支払区分())
                    && STRING_ONE.equals(entity.get結果支給区分コード()))) {
                合計支給額 = 高額支給額.add(entity.get支給金額());
            } else if (STRING_ONE.equals(entity.get審査支払区分()) && STRING_ONE.equals(entity.get決定支給区分コード())) {
                合計支給額 = 高額支給額.add(entity.get決定高額支給額());
            }
        }
        被保険者番号Map.put(月, entity.get被保険者番号());
        return 合計支給額;
    }

}
