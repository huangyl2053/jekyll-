/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyosokatsuhyo.KyufuKanrihyoSokatsuhyoReport;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.JigyoshoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenSofuKokanJohoShikibetsuBango;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.RecordShubetsu;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenSofu;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout.KyufukanrihyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110010.KyufukanrihyoOutSofuFairucontrolcsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110010.KyufukanrihyoOutSofuFairuendcsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110010.KyufukanrihyoOutSofuFairulistcsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyufukanrihyoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.SofuFileSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyosokatsuhyo.KyufuKanrihyoSokatsuhyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufukanrihyosokatsuhyo.KyufuKanrihyoSokatsuhyoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.externalcharacter.BinaryCharacterConvertParameter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.BinaryCharacterConvertParameterBuilder;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterAttribute;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterConvertTable;
import jp.co.ndensan.reams.uz.uza.externalcharacter.ReamsUnicodeToBinaryConverter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.RecordConvertMaterial;
import jp.co.ndensan.reams.uz.uza.io.ByteWriter;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.FileReader;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 給付管理票総括票作成の帳票出力Processクラスです
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class KyufuKanrihyoSokatsuhyoDoBillOutProcess extends BatchKeyBreakBase<KyufukanrihyoOutDoBillOutEntity> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010.IKyufukanrihyoOutMapper."
                    + "get帳票出力対象データ");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(KyufuKanrihyoSokatsuhyoReportSource.ReportSourceFields.hokenshaNo.name())
    ));
    /**
     * 総出力件数カウンターです。
     */
    public static final RString PARAMETER_OUT_OUTPUTCOUNT;
    /**
     * エントリ情報Listです。
     */
    public static final RString PARAMETER_OUT_OUTPUTENTRY;
    private SofuFileSakuseiEntity sofuFileSakuseiEntity;

    static {
        PARAMETER_OUT_OUTPUTCOUNT = new RString("outputCount");
        PARAMETER_OUT_OUTPUTENTRY = new RString("outputEntry");
    }

    private OutputParameter<Integer> outputCount;
    private OutputParameter<List> outputEntry;
    private KyufukanrihyoOutProcessParameter parameter;
    @BatchWriter
    private BatchReportWriter<KyufuKanrihyoSokatsuhyoReportSource> batchReportWriter;
    private ReportSourceWriter<KyufuKanrihyoSokatsuhyoReportSource> reportSourceWriter;
    private Decimal 総括票件数_短期新規 = Decimal.ZERO;
    private Decimal 総括票件数_短期修正 = Decimal.ZERO;
    private Decimal 総括票件数_短期取消 = Decimal.ZERO;
    private Decimal 総括票件数_訪問_居宅新規 = Decimal.ZERO;
    private Decimal 総括票件数_訪問_居宅修正 = Decimal.ZERO;
    private Decimal 総括票件数_訪問_居宅取消 = Decimal.ZERO;
    private Decimal 総括票枚数_短期新規 = Decimal.ZERO;
    private Decimal 総括票枚数_短期修正 = Decimal.ZERO;
    private Decimal 総括票枚数_短期取消 = Decimal.ZERO;
    private Decimal 総括票枚数_訪問_居宅新規 = Decimal.ZERO;
    private Decimal 総括票枚数_訪問_居宅修正 = Decimal.ZERO;
    private Decimal 総括票枚数_訪問_居宅取消 = Decimal.ZERO;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("");
    private RString eucFilePath;
    private RString csvFileName;
    private int 明細行数カウンター = 0;
    private static final RString 拡張子_TEMP = new RString("temp");
    private static final RString 国保連送付外字_変換区分_1 = new RString("1");
    private static final RString 拡張子 = new RString("\r\n");
    private static final RString 合計給付管理票明細行番号 = new RString("99");
    private static final RString ファイル名_前 = new RString("10_821");
    private static final RString ファイル名_後 = new RString(".csv");
    private RString 給付管理票送付用_保険者番号1 = RString.EMPTY;
    private static final int 固定15 = 15;
    private static final RString 事業所番号 = new RString("0");
    private RString 保険者番号1 = RString.EMPTY;
    private List<SofuFileSakuseiEntity> 送付ファイル用EntityList;
    private List<KyufukanrihyoOutDoBillOutEntity> 給付管理票送付用EntityList;
    private int レコード件数カウンター = 0;
    private int 総出力件数 = 0;
    private List<SharedFileDescriptor> 送付ファイルエントリ情報;
    private static final RString RSTRING_0 = new RString("0");
    private static final RString 認定有効期間_編集区分_1 = new RString("1");
    private static final RString 認定有効期間_編集区分_2 = new RString("2");

    private static final int INT_2 = 2;
    private static final int INT_3 = 3;

    private CsvWriter eucCsvWriter;
    private int 合計レコード_件数カウンター = 0;
    private int 明細レコード_件数カウンター = 0;
    private int 給付管理票キー項目_明細行数カウンター = 0;
    private RString 保険者番号 = RString.EMPTY;
    private RString 利用年月 = RString.EMPTY;
    private RString 被保険者番号 = RString.EMPTY;
    private RString 居宅サービス区分 = RString.EMPTY;
    private int ヘッダー項目は1行目 = 0;
    private KyufuKanrihyoSokatsuhyoEntity kyufuKanrihyoSokatsuhyoEntity;

    @Override

    protected void initialize() {
        kyufuKanrihyoSokatsuhyoEntity = new KyufuKanrihyoSokatsuhyoEntity();
        outputCount = new OutputParameter();
        outputEntry = new OutputParameter();
        送付ファイルエントリ情報 = new ArrayList<>();
        送付ファイル用EntityList = new ArrayList<>();
        給付管理票送付用EntityList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter.toKyufukanrihyoOutMybatisParameter(RString.EMPTY, RString.EMPTY, RString.EMPTY));
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC300001.getReportId().value())
                .addBreak(new BreakerCatalog<KyufuKanrihyoSokatsuhyoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(KyufukanrihyoOutDoBillOutEntity currentEntity) {

    }

    @Override
    protected void usualProcess(KyufukanrihyoOutDoBillOutEntity currentEntity) {
        boolean flag = true;
        KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity = currentEntity.get自己作成管理一時Entity();
        if (ヘッダー項目は1行目 == 0) {
            合計レコード_件数カウンター++;
            ヘッダー項目は1行目++;
            給付管理票キー項目_明細行数カウンター++;
            明細行数カウンター++;
            保険者番号 = 自己作成管理一時Entity.getHokenshaNo();
            保険者番号1 = 自己作成管理一時Entity.getHokenshaNo();
            利用年月 = new RString(自己作成管理一時Entity.getRiyoYM().toString());
            被保険者番号 = 自己作成管理一時Entity.getHihokenshaNo().getColumnValue();
            居宅サービス区分 = 自己作成管理一時Entity.getKyotakuServiceKubun();
            editKyufuKanrihyoSokatsuhyoEntity(currentEntity, flag);
            kyufuKanrihyoSokatsuhyoEntity = edit給付管理票総括票entity();
            給付管理票送付用EntityList.add(currentEntity);
            sofuFileSakuseiEntity = new SofuFileSakuseiEntity();
            レコード件数カウンター = 合計レコード_件数カウンター + 明細レコード_件数カウンター;
            sofuFileSakuseiEntity.setレコード件数カウンター(レコード件数カウンター);
            sofuFileSakuseiEntity.set保険者番号(保険者番号1);
            sofuFileSakuseiEntity.set給付管理票送付用EntityList(給付管理票送付用EntityList);
            送付ファイル用EntityList.add(sofuFileSakuseiEntity);
        } else {

            if (!(保険者番号.equals(自己作成管理一時Entity.getHokenshaNo()) && 利用年月.equals(new RString(自己作成管理一時Entity.getRiyoYM().toString()))
                    && 被保険者番号.equals(自己作成管理一時Entity.getHihokenshaNo().getColumnValue())
                    && 居宅サービス区分.equals(自己作成管理一時Entity.getKyotakuServiceKubun()))) {
                合計レコード_件数カウンター++;
                給付管理票キー項目_明細行数カウンター++;
                保険者番号 = 自己作成管理一時Entity.getHokenshaNo();
                利用年月 = new RString(自己作成管理一時Entity.getRiyoYM().toString());
                被保険者番号 = 自己作成管理一時Entity.getHihokenshaNo().getColumnValue();
                居宅サービス区分 = 自己作成管理一時Entity.getKyotakuServiceKubun();
            } else {
                get給付管理票キー項目_明細行数カウンター(自己作成管理一時Entity);
            }
            if (!保険者番号1.equals(自己作成管理一時Entity.getHokenshaNo())) {
                KyufuKanrihyoSokatsuhyoReport report = new KyufuKanrihyoSokatsuhyoReport(kyufuKanrihyoSokatsuhyoEntity);
                report.writeBy(reportSourceWriter);
                総括票件数_短期新規 = Decimal.ZERO;
                総括票件数_短期修正 = Decimal.ZERO;
                総括票件数_短期取消 = Decimal.ZERO;
                総括票件数_訪問_居宅新規 = Decimal.ZERO;
                総括票件数_訪問_居宅修正 = Decimal.ZERO;
                総括票件数_訪問_居宅取消 = Decimal.ZERO;
                総括票枚数_短期新規 = Decimal.ZERO;
                総括票枚数_短期修正 = Decimal.ZERO;
                総括票枚数_短期取消 = Decimal.ZERO;
                総括票枚数_訪問_居宅新規 = Decimal.ZERO;
                総括票枚数_訪問_居宅修正 = Decimal.ZERO;
                総括票枚数_訪問_居宅取消 = Decimal.ZERO;
                明細行数カウンター++;
                保険者番号1 = 自己作成管理一時Entity.getHokenshaNo();
                給付管理票送付用EntityList = new ArrayList<>();
                給付管理票送付用EntityList.add(currentEntity);
                editKyufuKanrihyoSokatsuhyoEntity(currentEntity, flag);
                kyufuKanrihyoSokatsuhyoEntity = edit給付管理票総括票entity();
                sofuFileSakuseiEntity = new SofuFileSakuseiEntity();
                レコード件数カウンター = 合計レコード_件数カウンター + 明細レコード_件数カウンター;
                sofuFileSakuseiEntity.setレコード件数カウンター(レコード件数カウンター);
                sofuFileSakuseiEntity.set保険者番号(保険者番号1);
                sofuFileSakuseiEntity.set給付管理票送付用EntityList(給付管理票送付用EntityList);
                送付ファイル用EntityList.add(sofuFileSakuseiEntity);
                レコード件数カウンター = 0;
                保険者番号1 = 自己作成管理一時Entity.getHokenshaNo();

            } else {
                get明細行数カウンター(自己作成管理一時Entity, currentEntity, flag);
            }
        }
    }

    private void get明細行数カウンター(KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity, KyufukanrihyoOutDoBillOutEntity currentEntity, boolean flag) {
        保険者番号1 = 自己作成管理一時Entity.getHokenshaNo();
        if (明細行数カウンター < 固定15) {
            明細行数カウンター++;
        } else if (明細行数カウンター == 固定15) {
            flag = false;
            editKyufuKanrihyoSokatsuhyoEntity(currentEntity, flag);
            給付管理票送付用EntityList.add(currentEntity);
            明細レコード_件数カウンター++;
            明細行数カウンター = 1;
        }
    }

    private void get給付管理票キー項目_明細行数カウンター(KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity) {
        保険者番号 = 自己作成管理一時Entity.getHokenshaNo();
        利用年月 = new RString(自己作成管理一時Entity.getRiyoYM().toString());
        被保険者番号 = 自己作成管理一時Entity.getHihokenshaNo().getColumnValue();
        居宅サービス区分 = 自己作成管理一時Entity.getKyotakuServiceKubun();
        if (給付管理票キー項目_明細行数カウンター < 固定15) {
            給付管理票キー項目_明細行数カウンター++;
        } else if (給付管理票キー項目_明細行数カウンター == 固定15) {
            給付管理票キー項目_明細行数カウンター = 1;
        }
    }

    private KyufuKanrihyoSokatsuhyoEntity edit給付管理票総括票entity() {
        KyufuKanrihyoSokatsuhyoEntity 給付管理票総括票entity = new KyufuKanrihyoSokatsuhyoEntity();
        給付管理票総括票entity.set処理年月(parameter.get処理年月());
        給付管理票総括票entity.set自県分_短期_修正分_件数(総括票件数_短期修正);
        給付管理票総括票entity.set自県分_短期_修正分_枚数(総括票枚数_短期修正);
        給付管理票総括票entity.set自県分_短期_取消分_件数(総括票件数_短期取消);
        給付管理票総括票entity.set自県分_短期_取消分_枚数(総括票枚数_短期取消);
        給付管理票総括票entity.set自県分_短期_新規分_件数(総括票件数_短期新規);
        給付管理票総括票entity.set自県分_短期_新規分_枚数(総括票枚数_短期新規);
        給付管理票総括票entity.set自県分_訪問_修正分_件数(総括票件数_訪問_居宅修正);
        給付管理票総括票entity.set自県分_訪問_修正分_枚数(総括票枚数_訪問_居宅修正);
        給付管理票総括票entity.set自県分_訪問_取消分_件数(総括票件数_訪問_居宅取消);
        給付管理票総括票entity.set自県分_訪問_取消分_枚数(総括票枚数_訪問_居宅取消);
        給付管理票総括票entity.set自県分_訪問_新規分_件数(総括票件数_訪問_居宅新規);
        給付管理票総括票entity.set自県分_訪問_新規分_枚数(総括票枚数_訪問_居宅新規);
        給付管理票総括票entity.set保険者番号(保険者番号);

        return 給付管理票総括票entity;
    }

    private void editKyufuKanrihyoSokatsuhyoEntity(
            KyufukanrihyoOutDoBillOutEntity currentEntity, boolean flag) {
        KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity = currentEntity.get自己作成管理一時Entity();
        RString 更新区分 = 自己作成管理一時Entity.getKoshinKubun();
        RString 居宅サービス区分 = 自己作成管理一時Entity.getKyotakuServiceKubun();
        if (KyufukanrihyoSakuseiKubun.新規.getコード().equals(更新区分)) {
            if (KyotakuServiceKubun.短期入所.getコード().equals(居宅サービス区分)) {
                get総括票件数_短期新規(flag);
                総括票枚数_短期新規 = 総括票枚数_短期新規.add(1);
            } else {
                get総括票件数_訪問_居宅新規(flag);
                総括票枚数_訪問_居宅新規 = 総括票枚数_訪問_居宅新規.add(1);
            }
        } else if (KyufukanrihyoSakuseiKubun.変更.getコード().equals(更新区分)) {
            if (KyotakuServiceKubun.短期入所.getコード().equals(居宅サービス区分)) {
                get総括票件数_短期修正(flag);
                総括票枚数_短期修正 = 総括票枚数_短期修正.add(1);
            } else {
                get総括票件数_訪問_居宅修正(flag);
                総括票枚数_訪問_居宅修正 = 総括票枚数_訪問_居宅修正.add(1);

            }
        } else if (KyufukanrihyoSakuseiKubun.取消.getコード().equals(更新区分)) {
            if (KyotakuServiceKubun.短期入所.getコード().equals(居宅サービス区分)) {
                get総括票件数_短期取消(flag);
                総括票枚数_短期取消 = 総括票枚数_短期取消.add(1);

            } else {
                get総括票件数_訪問_居宅取消(flag);
                総括票枚数_訪問_居宅取消 = 総括票枚数_訪問_居宅取消.add(1);
            }
        }

    }

    private void get総括票件数_短期新規(boolean flag) {
        if (flag) {
            総括票件数_短期新規 = 総括票件数_短期新規.add(1);
        }
    }

    private void get総括票件数_訪問_居宅新規(boolean flag) {
        if (flag) {
            総括票件数_訪問_居宅新規 = 総括票件数_訪問_居宅新規.add(1);
        }
    }

    private void get総括票件数_短期修正(boolean flag) {
        if (flag) {
            総括票件数_短期修正 = 総括票件数_短期修正.add(1);
        }
    }

    private void get総括票件数_訪問_居宅修正(boolean flag) {
        if (flag) {
            総括票件数_訪問_居宅修正 = 総括票件数_訪問_居宅修正.add(1);
        }
    }

    private void get総括票件数_短期取消(boolean flag) {
        if (flag) {
            総括票件数_短期取消 = 総括票件数_短期取消.add(1);
        }
    }

    private void get総括票件数_訪問_居宅取消(boolean flag) {
        if (flag) {
            総括票件数_訪問_居宅取消 = 総括票件数_訪問_居宅取消.add(1);
        }
    }

    @Override
    protected void afterExecute() {
        if (0 < ヘッダー項目は1行目) {
            KyufuKanrihyoSokatsuhyoReport report = new KyufuKanrihyoSokatsuhyoReport(kyufuKanrihyoSokatsuhyoEntity);
            report.writeBy(reportSourceWriter);
        }
        for (int i = 0; i < 送付ファイル用EntityList.size(); i++) {
            int 出力件数 = 0;
            int レコード番号カウンター = 0;
            Decimal 明細合計単位数 = Decimal.ZERO;
            int 給付管理票送付用_明細行数カウンター = 0;
            SofuFileSakuseiEntity sofuFileSakuseiEntity = 送付ファイル用EntityList.get(i);
            List<KyufukanrihyoOutDoBillOutEntity> 給付管理票送付用 = sofuFileSakuseiEntity.get給付管理票送付用EntityList();
            RString spoolWorkPath = Path.getTmpDirectoryPath();
            csvFileName = ファイル名_前.concat(sofuFileSakuseiEntity.get保険者番号()).
                    concat(parameter.get処理年月().toDateString()).concat(拡張子_TEMP).concat(ファイル名_後);
            eucFilePath = Path.combinePath(spoolWorkPath, csvFileName);
            eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
            KyufukanrihyoOutSofuFairucontrolcsvEntity controlEntity = getControlEntity(レコード番号カウンター, sofuFileSakuseiEntity);
            eucCsvWriter.writeLine(controlEntity);
            if (0 < 給付管理票送付用.size()) {
                RString 給付管理票送付用_保険者番号 = 給付管理票送付用.get(0).get自己作成管理一時Entity().getHokenshaNo();
                RString 給付管理票送付用_利用年月 = new RString(給付管理票送付用.get(0).get自己作成管理一時Entity().getRiyoYM().toString());
                RString 給付管理票送付用_被保険者番号 = 給付管理票送付用.get(0).get自己作成管理一時Entity().getHihokenshaNo().getColumnValue();
                RString 給付管理票送付用_居宅サービス区分 = new RString(給付管理票送付用.get(0).get自己作成管理一時Entity().getKyufuKeikakuTaniSu().toString());
                for (int j = 0; j < 給付管理票送付用.size(); j++) {
                    総出力件数++;
                    出力件数++;
                    KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity = 給付管理票送付用.get(j).get自己作成管理一時Entity();
                    HihokenshaTempEntity 被保険者一時Entity = 給付管理票送付用.get(j).get被保険者一時Entity();
                    KyufukanrihyoOutSofuFairulistcsvEntity listcsvEntity = getlistcsvEntity(給付管理票送付用_明細行数カウンター,
                            被保険者一時Entity, レコード番号カウンター, 自己作成管理一時Entity);
                    eucCsvWriter.writeLine(listcsvEntity);
                    if (!(給付管理票送付用_保険者番号.equals(自己作成管理一時Entity.getHokenshaNo())
                            && 給付管理票送付用_利用年月.equals(new RString(自己作成管理一時Entity.getRiyoYM().toString()))
                            && 給付管理票送付用_被保険者番号.equals(自己作成管理一時Entity.getHihokenshaNo().getColumnValue())
                            && 給付管理票送付用_居宅サービス区分.equals(自己作成管理一時Entity.getKyotakuServiceKubun()))) {
                        給付管理票送付用_保険者番号 = 自己作成管理一時Entity.getHokenshaNo();
                        給付管理票送付用_利用年月 = new RString(自己作成管理一時Entity.getRiyoYM().toString());
                        給付管理票送付用_被保険者番号 = 自己作成管理一時Entity.getHihokenshaNo().getColumnValue();
                        給付管理票送付用_居宅サービス区分 = new RString(自己作成管理一時Entity.getKyufuKeikakuTaniSu().toString());
                        KyufukanrihyoOutSofuFairulistcsvEntity 合計レコード = get合計レコード(明細合計単位数, レコード番号カウンター, 自己作成管理一時Entity, 被保険者一時Entity);
                        eucCsvWriter.writeLine(合計レコード);
                        レコード番号カウンター = 0;
                        給付管理票送付用_明細行数カウンター = 0;
                        明細合計単位数 = Decimal.ZERO;
                    }
                    レコード番号カウンター++;
                    給付管理票送付用_明細行数カウンター++;
                    明細合計単位数 = 明細合計単位数.multiply(自己作成管理一時Entity.getKyufuKeikakuTaniSu());
                }
                KyufukanrihyoOutSofuFairuendcsvEntity endEntity = getEndEntity(出力件数);
                eucCsvWriter.writeLine(endEntity);
                eucCsvWriter.close();
                do外字類似変換();
                SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険,
                        FilesystemName.fromString(csvFileName.replace(拡張子_TEMP, RString.EMPTY)));
                sfd = SharedFile.defineSharedFile(sfd, 1, SharedFile.GROUP_ALL, null, true, null);
                CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
                SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(eucFilePath.replace(拡張子_TEMP, RString.EMPTY)), opts);
                送付ファイルエントリ情報.add(sfd);
            }
            outputCount.setValue(総出力件数);
            outputEntry.setValue(送付ファイルエントリ情報);
        }
    }

    private KyufukanrihyoOutSofuFairuendcsvEntity getEndEntity(int レコード番号カウンター) {
        KyufukanrihyoOutSofuFairuendcsvEntity endEntity = new KyufukanrihyoOutSofuFairuendcsvEntity();
        endEntity.setレコード種別(RecordShubetsu.エンドレコード.getコード());
        endEntity.setレコード番号_連番(new RString(レコード番号カウンター));
        return endEntity;
    }

    private KyufukanrihyoOutSofuFairulistcsvEntity get合計レコード(Decimal 明細合計単位数, int レコード番号カウンター,
            KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity, HihokenshaTempEntity 被保険者一時Entity) {
        KyufukanrihyoOutSofuFairulistcsvEntity 合計レコード = new KyufukanrihyoOutSofuFairulistcsvEntity();
        合計レコード.setレコード種別(RecordShubetsu.データレコード.getコード());
        合計レコード.setレコード番号_連番(new RString(レコード番号カウンター));
        合計レコード.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.給付管理票情報.getコード());
        合計レコード.set対象年月(trimRString(new RString(自己作成管理一時Entity.getRiyoYM().toString())));
        合計レコード.set証記載保険者番号(trimRString(被保険者一時Entity.getExShoHokenshaNo()));
        合計レコード.set事業所番号(事業所番号);
        合計レコード.set給付管理票情報作成区分コード(trimRString(自己作成管理一時Entity.getKoshinKubun()));
        合計レコード.set給付管理票作成年月日(trimRString(new RString(自己作成管理一時Entity.getKoshinYMD().toString())));
        合計レコード.set給付管理票種別区分コード(trimRString(自己作成管理一時Entity.getKyotakuServiceKubun()));
        合計レコード.set給付管理票明細行番号(合計給付管理票明細行番号);
        合計レコード.set被保険者番号(trimRString(被保険者一時Entity.getSofuHihokenshaNo()));
        合計レコード.set被保険者生年月日(trimRString(new RString(被保険者一時Entity.getSeinenYmd().toString())));
        合計レコード.set性別コード(trimRString(被保険者一時Entity.getSeibetsuCode()));
        合計レコード.set要介護状態区分コード(trimRString(自己作成管理一時Entity.getYokaigoJotaiKubunCode()));
        edit限度額管理開始年月日(自己作成管理一時Entity, 被保険者一時Entity, 合計レコード);
        if (自己作成管理一時Entity.getTankiShikyuGendoShuryoYM() != null) {
            合計レコード.set限度額適用期間_終了(trimRString(new RString(自己作成管理一時Entity.getTankiShikyuGendoShuryoYM().toString())));
        }
        合計レコード.set居宅_介護予防_総合事業支給限度額(RString.EMPTY);
        合計レコード.set居宅サービス計画作成区分コード(JukyushaIF_KeikakuSakuseiKubunCode.自己作成.getコード());
        合計レコード.set事業所番号_サービス事業所(RString.EMPTY);
        合計レコード.set指定_基準該当_地域密着型サービス_総合事業識別コード(RString.EMPTY);
        合計レコード.setサービス種類コード(RString.EMPTY);
        合計レコード.set給付計画単位数_日数(RString.EMPTY);
        合計レコード.set限度額管理期間における前月までの給付計画日数(RString.EMPTY);
        合計レコード.set指定サービス分小計(RString.EMPTY);
        合計レコード.set基準該当サービス分小計(RString.EMPTY);
        合計レコード.set給付計画合計単位数_日数(new RString(明細合計単位数.toString()));
        合計レコード.set担当介護支援専門員番号(RString.EMPTY);
        合計レコード.set委託先の居宅介護支援事業所番号(RString.EMPTY);
        合計レコード.set委託先の担当介護支援専門員番号(RString.EMPTY);
        return 合計レコード;
    }

    private KyufukanrihyoOutSofuFairulistcsvEntity getlistcsvEntity(int 給付管理票送付用_明細行数カウンター, HihokenshaTempEntity 被保険者一時Entity,
            int レコード番号カウンター, KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity) {
        KyufukanrihyoOutSofuFairulistcsvEntity meisaiEntity = new KyufukanrihyoOutSofuFairulistcsvEntity();
        meisaiEntity.setレコード種別(RecordShubetsu.データレコード.getコード());
        meisaiEntity.setレコード番号_連番(new RString(レコード番号カウンター));
        meisaiEntity.set交換情報識別番号(KokuhorenSofuKokanJohoShikibetsuBango.給付管理票情報.getコード());
        meisaiEntity.set対象年月(trimRString(new RString(自己作成管理一時Entity.getRiyoYM().toString())));
        meisaiEntity.set証記載保険者番号(trimRString(被保険者一時Entity.getExShoHokenshaNo()));
        meisaiEntity.set事業所番号(事業所番号);
        meisaiEntity.set給付管理票情報作成区分コード(trimRString(自己作成管理一時Entity.getKoshinKubun()));
        meisaiEntity.set給付管理票作成年月日(trimRString(new RString(自己作成管理一時Entity.getKoshinYMD().toString())));
        meisaiEntity.set給付管理票種別区分コード(trimRString(自己作成管理一時Entity.getKyotakuServiceKubun()));
        meisaiEntity.set給付管理票明細行番号(new RString(給付管理票送付用_明細行数カウンター));
        meisaiEntity.set被保険者番号(trimRString(被保険者一時Entity.getSofuHihokenshaNo()));
        meisaiEntity.set被保険者生年月日(trimRString(new RString(被保険者一時Entity.getSeinenYmd().toString())));
        meisaiEntity.set性別コード(trimRString(被保険者一時Entity.getSeibetsuCode()));
        meisaiEntity.set要介護状態区分コード(trimRString(自己作成管理一時Entity.getYokaigoJotaiKubunCode()));
        edit限度額管理開始年月日(自己作成管理一時Entity, 被保険者一時Entity, meisaiEntity);
        if (自己作成管理一時Entity.getTankiShikyuGendoShuryoYM() != null) {
            meisaiEntity.set限度額適用期間_終了(trimRString(new RString(自己作成管理一時Entity.getTankiShikyuGendoShuryoYM().toString())));
        }
        meisaiEntity.set居宅_介護予防_総合事業支給限度額(RString.EMPTY);
        meisaiEntity.set居宅サービス計画作成区分コード(JukyushaIF_KeikakuSakuseiKubunCode.自己作成.getコード());
        meisaiEntity.set事業所番号_サービス事業所(trimRString(自己作成管理一時Entity.getServiceTeikyoJigyoshaNo()));
        if (!RString.isNullOrEmpty(自己作成管理一時Entity.getServiceTeikyoJigyoshaNo())) {
            if (JigyoshoKubun.指定事業所.getコード().equals(自己作成管理一時Entity.getServiceTeikyoJigyoshaNo().substring(INT_2, INT_3))
                    || JigyoshoKubun.基準該当事業所.getコード().equals(自己作成管理一時Entity.getServiceTeikyoJigyoshaNo().substring(INT_2, INT_3))
                    || JigyoshoKubun.地域密着型サービス事業所.getコード().equals(自己作成管理一時Entity.getServiceTeikyoJigyoshaNo().substring(INT_2, INT_3))
                    || JigyoshoKubun.介護予防日常生活支援総合事業事業所.getコード().equals(自己作成管理一時Entity.getServiceTeikyoJigyoshaNo().substring(INT_2, INT_3))) {
                meisaiEntity.set指定_基準該当_地域密着型サービス_総合事業識別コード(JigyoshoKubun.toValue(
                        自己作成管理一時Entity.getServiceTeikyoJigyoshaNo().substring(INT_2, INT_3)).get国保連送付コード());
            } else {
                meisaiEntity.set指定_基準該当_地域密着型サービス_総合事業識別コード(JigyoshoKubun.指定事業所.get国保連送付コード());
            }

        }
        meisaiEntity.setサービス種類コード(trimRString(自己作成管理一時Entity.getServiceShuruiCode()));
        meisaiEntity.set給付計画単位数_日数(new RString(自己作成管理一時Entity.getKyufuKeikakuTaniSu().toString()));
        meisaiEntity.set限度額管理期間における前月までの給付計画日数(給付管理票送付用_保険者番号1);
        meisaiEntity.set指定サービス分小計(RString.EMPTY);
        meisaiEntity.set基準該当サービス分小計(RString.EMPTY);
        meisaiEntity.set給付計画合計単位数_日数(RString.EMPTY);
        meisaiEntity.set担当介護支援専門員番号(RString.EMPTY);
        meisaiEntity.set委託先の居宅介護支援事業所番号(RString.EMPTY);
        meisaiEntity.set委託先の担当介護支援専門員番号(RString.EMPTY);
        return meisaiEntity;

    }

    private KyufukanrihyoOutSofuFairucontrolcsvEntity getControlEntity(int レコード番号カウンター, SofuFileSakuseiEntity sofuFileSakuseiEntity) {
        KyufukanrihyoOutSofuFairucontrolcsvEntity controlEntity = new KyufukanrihyoOutSofuFairucontrolcsvEntity();
        controlEntity.setレコード種別(RecordShubetsu.コントロールレコード.getコード());
        controlEntity.setレコード番号_連番(new RString(レコード番号カウンター));
        controlEntity.setボリュ_ム通番(RSTRING_0);
        controlEntity.setレコード件数(new RString(sofuFileSakuseiEntity.getレコード件数カウンター()));
        controlEntity.setデータ種別(ConfigKeysKokuhorenSofu.給付管理票.getコード());
        controlEntity.set福祉事務所特定番号(RSTRING_0);
        controlEntity.set保険者番号(trimRString(sofuFileSakuseiEntity.get保険者番号()));
        controlEntity.set事業所番号(RSTRING_0);
        controlEntity.set都道府県番号(RSTRING_0);
        controlEntity.set媒体区分(DbBusinessConfig
                .get(ConfigNameDBC.国保連送付媒体_給付管理票Ｆ_媒体区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付));
        controlEntity.set処理対象年月(parameter.get処理年月().seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString());
        controlEntity.setファイル管理番号(RSTRING_0);
        return controlEntity;
    }

    private RString trimRString(RString str) {
        return str == null || str.isEmpty() ? RString.EMPTY : str.trim();
    }

    private void do外字類似変換() {
        try (FileReader reader = new FileReader(eucFilePath, Encode.UTF_8withBOM);
                ByteWriter writer = new ByteWriter(eucFilePath.replace(拡張子_TEMP, RString.EMPTY))) {
            for (RString record = reader.readLine(); record != null; record = reader.readLine()) {
                BinaryCharacterConvertParameter convertParameter = new BinaryCharacterConvertParameterBuilder(
                        new RecordConvertMaterial(getCharacterConvertTable(), CharacterAttribute.混在))
                        .enabledConvertError(true)
                        .build();
                ReamsUnicodeToBinaryConverter converter = new ReamsUnicodeToBinaryConverter(convertParameter);
                writer.write(converter.convert(record.concat(拡張子)));
            }
            writer.close();
            reader.close();
        }
        deleteEmptyFile(eucFilePath);
    }

    private void deleteEmptyFile(RString filePath) {
        if (RString.isNullOrEmpty(filePath)) {
            return;
        }
        File file = new File(filePath.toString());
        if (file.exists()) {
            file.getAbsoluteFile().deleteOnExit();
        }
    }

    private static CharacterConvertTable getCharacterConvertTable() {
        RString 国保連送付外字_変換区分 = DbBusinessConfig.get(ConfigNameDBC.国保連送付外字_変換区分, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (!国保連送付外字_変換区分_1.equals(国保連送付外字_変換区分)) {
            return CharacterConvertTable.Sjis;
        } else {
            return CharacterConvertTable.SjisRuiji;
        }
    }

    private void edit限度額管理開始年月日(KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity,
            HihokenshaTempEntity 被保険者一時Entity, KyufukanrihyoOutSofuFairulistcsvEntity meisaiEntity) {
        FlexibleYearMonth 支給限度有効開始年月 = 自己作成管理一時Entity.getShikyuGendoKaishiYM();
        FlexibleYearMonth 支給限度有効終了年月 = 自己作成管理一時Entity.getShikyuGendoShuryoYM();
        FlexibleYearMonth 市町村加入年月日 = getFlexibleYearMonth(被保険者一時Entity.getShichosonKanyuYmd());
        FlexibleYearMonth 市町村脱退年月日 = getFlexibleYearMonth(被保険者一時Entity.getShichosonDattaiYmd());

        if (認定有効期間_編集区分_1.equals(DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_認定有効期間_編集区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            meisaiEntity.set限度額適用期間_開始(trimRString(doパターン54(支給限度有効開始年月)));
        } else if (認定有効期間_編集区分_2.equals(DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_認定有効期間_編集区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            if (!支給限度有効終了年月.isEmpty() && !市町村加入年月日.isEmpty() && !支給限度有効開始年月.isEmpty() && !市町村加入年月日.isEmpty()
                    && 支給限度有効開始年月.isBefore(市町村加入年月日) && 市町村加入年月日.isBeforeOrEquals(支給限度有効終了年月)
                    && 市町村脱退年月日.isEmpty()) {
                meisaiEntity.set限度額適用期間_開始(trimRString(doパターン54(市町村加入年月日)));
            } else if (!市町村加入年月日.isEmpty() && !支給限度有効開始年月.isEmpty() && !支給限度有効終了年月.isEmpty()
                    && 支給限度有効開始年月.isBefore(市町村加入年月日) && 市町村加入年月日.isBeforeOrEquals(支給限度有効終了年月)
                    && !市町村脱退年月日.isEmpty() && 支給限度有効終了年月.isBeforeOrEquals(市町村脱退年月日)) {
                meisaiEntity.set限度額適用期間_開始(trimRString(doパターン54(市町村加入年月日)));
            } else {
                meisaiEntity.set限度額適用期間_開始(trimRString(doパターン54(支給限度有効開始年月)));
            }
        }
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月 || 年月.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private FlexibleYearMonth getFlexibleYearMonth(FlexibleDate fb) {
        if (fb.isEmpty()) {
            return FlexibleYearMonth.EMPTY;
        }
        return fb.getYearMonth();
    }
}
