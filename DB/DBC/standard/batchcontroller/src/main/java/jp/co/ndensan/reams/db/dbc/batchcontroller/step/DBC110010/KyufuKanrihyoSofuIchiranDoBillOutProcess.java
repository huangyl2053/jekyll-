/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeikakujikosakuseikanri.KyotakuKeikakuJikosakuseiKanriResult;
import jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyosofuichiran.KyufuKanrihyoSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyotakuServiceKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufukanrihyoout.KyufukanrihyoOutMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout.KyufukanrihyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyufuKanrihyoSofuIchirancsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyufukanrihyoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyosofuichiran.KyufuKanrihyoSofuIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyosofuichiran.KyufuKanrihyoSofuIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付管理票送付一覧表の帳票出力Processクラスです
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class KyufuKanrihyoSofuIchiranDoBillOutProcess extends BatchKeyBreakBase<KyufukanrihyoOutDoBillOutEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010.IKyufukanrihyoOutMapper."
                    + "get帳票出力対象データ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200009");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString コンマ = new RString(",");
    private final Code code = new Code("0003");
    private final RString 漢字_被保険者番号 = new RString("被保険者番号");
    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");
    private static final RString 出力ファイル名
            = new RString("DBC200009_KyufuKanrihyoSofuIchiran.csv");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 固定改頁 = new RString("hokenshaNo");
    private static final int 固定15 = 15;
    private FileSpoolManager manager;
    private KyufukanrihyoOutProcessParameter parameter;
    private List<RString> pageBreakKeys;
    private List<RString> 改頁リスト;
    private Map<RString, RString> 出力順Map;
    private Set<ShikibetsuCode> 識別コードset;
    private RString eucFilePath;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private int 帳票通番カウンター = 0;
    private Decimal 明細合計単位数 = Decimal.ZERO;
    private int 明細行数カウンター = 0;
    private RString 保険者番号 = RString.EMPTY;
    private RString 利用年月 = RString.EMPTY;
    private RString 被保険者番号 = RString.EMPTY;
    private RString 居宅サービス区分 = RString.EMPTY;
    private Decimal 合計件数_新規 = Decimal.ZERO;
    private Decimal 合計件数_修正 = Decimal.ZERO;
    private Decimal 合計件数_取消 = Decimal.ZERO;
    private Decimal 合計件数_新規1 = Decimal.ZERO;
    private Decimal 合計件数_修正2 = Decimal.ZERO;
    private Decimal 合計件数_取消3 = Decimal.ZERO;
    private static final RString 認定有効期間_編集区分_3 = new RString("3");
    private static final RString 作成 = new RString("作成");
    private int ヘッダー項目は1行目 = 0;
    private static final RString 備考 = new RString("限度基準額超過");
    private static final RString 認定有効期間_編集区分_1 = new RString("1");
    private static final RString 認定有効期間_編集区分_2 = new RString("2");
    private KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity;
    private RString keyRString;
    private HihokenshaTempEntity 被保険者一時Entity;
    private KyufuKanrihyoSofuIchiranEntity kyufuKanrihyoSofuIchiranEntity;
    private KyufuKanrihyoSofuIchirancsvEntity kyufuKanrihyoSofuIchirancsvEntity;
    private KyufukanrihyoOutDoBillOutEntity kyufukanrihyoOutDoBillOutEntity;
    private ShutsuryokujunRelateEntity entity;
    @BatchWriter
    private BatchReportWriter<KyufuKanrihyoSofuIchiranReportSource> batchReportWriter;
    private ReportSourceWriter<KyufuKanrihyoSofuIchiranReportSource> reportSourceWriter;
    private CsvWriter<KyufuKanrihyoSofuIchirancsvEntity> kyufuKanrihyoSofuIchirancsvWriter;

    @Override
    protected void initialize() {
        kyufuKanrihyoSofuIchiranEntity = new KyufuKanrihyoSofuIchiranEntity();
        kyufuKanrihyoSofuIchirancsvEntity = new KyufuKanrihyoSofuIchirancsvEntity();
        kyufukanrihyoOutDoBillOutEntity = new KyufukanrihyoOutDoBillOutEntity();
        entity = ReportUtil.get出力順情報(KyotakuKeikakuJikosakuseiKanriResult.KyufuKanrihyoSofuEnum.class,
                SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200009.getReportId(), Long.parseLong(parameter.get出力順ID().toString()));
        if (RString.isNullOrEmpty(entity.get出力順OrderBy())) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        出力順Map = new HashMap<>();
        出力順Map.put(KEY_並び順の２件目, entity.get出力順1());
        出力順Map.put(KEY_並び順の３件目, entity.get出力順2());
        出力順Map.put(KEY_並び順の４件目, entity.get出力順3());
        出力順Map.put(KEY_並び順の５件目, entity.get出力順4());
        出力順Map.put(KEY_並び順の６件目, entity.get出力順5());
        改頁リスト = new ArrayList();
        改頁リスト.add(entity.get改頁項目1());
        改頁リスト.add(entity.get改頁項目2());
        改頁リスト.add(entity.get改頁項目3());
        改頁リスト.add(entity.get改頁項目4());
        改頁リスト.add(entity.get改頁項目5());

        pageBreakKeys = new ArrayList<>();
        List<RString> 固定改頁List = entity.getPageBreakKeys();
        pageBreakKeys.add(固定改頁);
        pageBreakKeys.addAll(固定改頁List);
        識別コードset = new HashSet();
    }

    @Override
    protected IBatchReader createReader() {
        KyufukanrihyoOutMybatisParameter kyufukanrihyoOutMybatisParameter = parameter.toKyufukanrihyoOutMybatisParameter(entity.get出力順OrderBy(),
                RString.EMPTY,
                RString.EMPTY);
        return new BatchDbReader(MYBATIS_SELECT_ID, kyufukanrihyoOutMybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200009.getReportId().value()).addBreak(new BreakerCatalog<KyufuKanrihyoSofuIchiranReportSource>()
                        .simpleLayoutBreaker(pageBreakKeys)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        kyufuKanrihyoSofuIchirancsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();

    }

    @Override
    protected void keyBreakProcess(KyufukanrihyoOutDoBillOutEntity entity) {
    }

    @Override
    protected void usualProcess(KyufukanrihyoOutDoBillOutEntity entity) {
        自己作成管理一時Entity = entity.get自己作成管理一時Entity();
        被保険者一時Entity = entity.get被保険者一時Entity();
        if (ヘッダー項目は1行目 == 0) {
            keyRString = getKyufukanrihyoOutDoBillOutEntity値(entity);
            ヘッダー項目は1行目++;
            明細行数カウンター++;
            帳票通番カウンター++;
            明細行数カウンター++;
            保険者番号 = 自己作成管理一時Entity.getHokenshaNo();
            利用年月 = new RString(自己作成管理一時Entity.getRiyoYM().toString());
            被保険者番号 = 自己作成管理一時Entity.getHihokenshaNo().getColumnValue();
            居宅サービス区分 = 自己作成管理一時Entity.getKyotakuServiceKubun();
            明細合計単位数 = 明細合計単位数.multiply(自己作成管理一時Entity.getKyufuKeikakuTaniSu());
            editKyufuKanrihyoSofuIchiranEntity1(自己作成管理一時Entity);
            kyufuKanrihyoSofuIchiranEntity = editKyufuKanrihyoSofuIchiranEntity(自己作成管理一時Entity, 被保険者一時Entity, 帳票通番カウンター, 明細合計単位数);
            kyufuKanrihyoSofuIchirancsvEntity = csv明細作成(自己作成管理一時Entity, 被保険者一時Entity);
            kyufukanrihyoOutDoBillOutEntity.set自己作成管理一時Entity(自己作成管理一時Entity);
            kyufukanrihyoOutDoBillOutEntity.set被保険者一時Entity(被保険者一時Entity);
        } else {
            if (!keyRString.equals(getKyufukanrihyoOutDoBillOutEntity値(entity))) {
                合計件数_新規1 = Decimal.ZERO;
                合計件数_修正2 = Decimal.ZERO;
                合計件数_取消3 = Decimal.ZERO;
            }
            if (!(保険者番号.equals(自己作成管理一時Entity.getHokenshaNo()) && 利用年月.equals(new RString(自己作成管理一時Entity.getRiyoYM().toString()))
                    && 被保険者番号.equals(自己作成管理一時Entity.getHihokenshaNo().getColumnValue())
                    && 居宅サービス区分.equals(自己作成管理一時Entity.getKyotakuServiceKubun()))) {
                KyufuKanrihyoSofuIchiranReport report = new KyufuKanrihyoSofuIchiranReport(kyufuKanrihyoSofuIchiranEntity,
                        出力順Map,
                        改頁リスト);
                report.writeBy(reportSourceWriter);
                kyufuKanrihyoSofuIchirancsvWriter.writeLine(kyufuKanrihyoSofuIchirancsvEntity);
                アクセスログ対象追加(kyufukanrihyoOutDoBillOutEntity);
                kyufukanrihyoOutDoBillOutEntity.set自己作成管理一時Entity(自己作成管理一時Entity);
                kyufukanrihyoOutDoBillOutEntity.set被保険者一時Entity(被保険者一時Entity);
                kyufuKanrihyoSofuIchirancsvEntity = csv明細作成(自己作成管理一時Entity, 被保険者一時Entity);
                editKyufuKanrihyoSofuIchiranEntity1(自己作成管理一時Entity);
                kyufuKanrihyoSofuIchiranEntity = editKyufuKanrihyoSofuIchiranEntity(自己作成管理一時Entity, 被保険者一時Entity, 帳票通番カウンター, 明細合計単位数);
                保険者番号 = 自己作成管理一時Entity.getHokenshaNo();
                利用年月 = new RString(自己作成管理一時Entity.getRiyoYM().toString());
                被保険者番号 = 自己作成管理一時Entity.getHihokenshaNo().getColumnValue();
                居宅サービス区分 = 自己作成管理一時Entity.getKyotakuServiceKubun();
                帳票通番カウンター = 0;
                明細行数カウンター = 0;
                明細合計単位数 = Decimal.ZERO;
                明細合計単位数 = 明細合計単位数.multiply(自己作成管理一時Entity.getKyufuKeikakuTaniSu());
            } else {
                get明細行数カウンター(自己作成管理一時Entity);
                kyufuKanrihyoSofuIchiranEntity = editKyufuKanrihyoSofuIchiranEntity(自己作成管理一時Entity, 被保険者一時Entity, 帳票通番カウンター, 明細合計単位数);
            }
        }

    }

    private void get明細行数カウンター(KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity) {
        if (明細行数カウンター < 固定15) {
            明細行数カウンター++;
            明細合計単位数 = 明細合計単位数.multiply(自己作成管理一時Entity.getKyufuKeikakuTaniSu());

        } else if (明細行数カウンター == 固定15) {
            明細行数カウンター = 1;
            帳票通番カウンター++;
            明細合計単位数 = 明細合計単位数.multiply(自己作成管理一時Entity.getKyufuKeikakuTaniSu());

        }
    }

    @Override
    protected void afterExecute() {
        KyufuKanrihyoSofuIchiranReport report = new KyufuKanrihyoSofuIchiranReport(kyufuKanrihyoSofuIchiranEntity,
                出力順Map,
                改頁リスト);
        report.writeBy(reportSourceWriter);
        kyufuKanrihyoSofuIchirancsvWriter.writeLine(kyufuKanrihyoSofuIchirancsvEntity);
        アクセスログ対象追加(kyufukanrihyoOutDoBillOutEntity);
        kyufuKanrihyoSofuIchirancsvWriter.writeLine(集計項目csv明細作成());
        kyufuKanrihyoSofuIchirancsvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        } else {
            manager.spool(eucFilePath);
        }
    }

    private KyufuKanrihyoSofuIchiranEntity editKyufuKanrihyoSofuIchiranEntity(KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity,
            HihokenshaTempEntity 被保険者一時Entity, int 帳票通番カウンター, Decimal 明細合計単位数) {
        KyufuKanrihyoSofuIchiranEntity 給付管理票送付一覧表entity = new KyufuKanrihyoSofuIchiranEntity();
        給付管理票送付一覧表entity.setChoikiCode(getRString(被保険者一時Entity.getChoikiCode()));
        給付管理票送付一覧表entity.setGyoseikuCode(getRString(被保険者一時Entity.getGyoseikuCode()));
        if (!自己作成管理一時Entity.getHihokenshaNo().isEmpty() && 自己作成管理一時Entity.getHihokenshaNo() != null) {
            給付管理票送付一覧表entity.setHihokenshaNo(getRString(自己作成管理一時Entity.getHihokenshaNo().value()));
        }
        給付管理票送付一覧表entity.setRiyoYM(getRString(自己作成管理一時Entity.getRiyoYM().toDateString()));
        給付管理票送付一覧表entity.setShichosonCode(getRString(被保険者一時Entity.getShichosonCode()));
        給付管理票送付一覧表entity.setShimei50onKana(getRString(被保険者一時Entity.getShimei50onKana()));
        給付管理票送付一覧表entity.setYokaigoJotaiKubunCode(getRString(自己作成管理一時Entity.getYokaigoJotaiKubunCode()));
        給付管理票送付一覧表entity.setYubinNo(getRString(被保険者一時Entity.getYubinNo()));
        給付管理票送付一覧表entity.set作成日時(RDateTime.now());
        給付管理票送付一覧表entity.set処理年月(parameter.get処理年月());
        給付管理票送付一覧表entity.set保険者名(getRString(自己作成管理一時Entity.getHokenshaName()));
        給付管理票送付一覧表entity.set保険者番号(getRString(自己作成管理一時Entity.getHokenshaNo()));
        給付管理票送付一覧表entity.set備考_証記載保険者番号(getRString(被保険者一時Entity.getExShoHokenshaNo()));
        給付管理票送付一覧表entity.set備考タイトル(RString.EMPTY);
        給付管理票送付一覧表entity.set利用年月(new FlexibleYearMonth(getRString(自己作成管理一時Entity.getRiyoYM().toDateString()).toString()));
        if (認定有効期間_編集区分_1.equals(自己作成管理一時Entity.getKoshinKubun())) {
            給付管理票送付一覧表entity.set合計件数_修正(合計件数_修正);
            給付管理票送付一覧表entity.set合計件数_取消(合計件数_取消);
            給付管理票送付一覧表entity.set合計件数_新規(合計件数_新規);
        }
        if (認定有効期間_編集区分_2.equals(自己作成管理一時Entity.getKoshinKubun())) {
            給付管理票送付一覧表entity.set合計件数_修正(合計件数_修正);
            給付管理票送付一覧表entity.set合計件数_取消(合計件数_取消);
            給付管理票送付一覧表entity.set合計件数_新規(合計件数_新規);
        }
        if (認定有効期間_編集区分_3.equals(自己作成管理一時Entity.getKoshinKubun())) {
            給付管理票送付一覧表entity.set合計件数_修正(合計件数_修正);
            給付管理票送付一覧表entity.set合計件数_取消(合計件数_取消);
            給付管理票送付一覧表entity.set合計件数_新規(合計件数_新規);
        }
        給付管理票送付一覧表entity.set基準該当サービス単位_日数(RString.EMPTY);
        給付管理票送付一覧表entity.set宛名名称(getRString(被保険者一時Entity.getMeisho()));
        給付管理票送付一覧表entity.set居宅サービス区分(自己作成管理一時Entity.getKyotakuServiceKubun());
        給付管理票送付一覧表entity.set帳票通番カウンター(getRString(new RString(String.valueOf(帳票通番カウンター))));
        給付管理票送付一覧表entity.set指定サービス単位_日数(RString.EMPTY);
        給付管理票送付一覧表entity.set支給限度有効終了年月(new FlexibleYearMonth(getRString(自己作成管理一時Entity.getShikyuGendoShuryoYM().toDateString())));
        給付管理票送付一覧表entity.set明細合計単位数(明細合計単位数);
        給付管理票送付一覧表entity.set更新区分(自己作成管理一時Entity.getKoshinKubun());
        給付管理票送付一覧表entity.set表示用支給限度単位数(自己作成管理一時Entity.getHyojiShikyuGendoTanisu());
        給付管理票送付一覧表entity.set表示用要介護状態区分コード(getRString(自己作成管理一時Entity.getYokaigoJotaiKubunCode()));
        給付管理票送付一覧表entity.set被保険者番号(getRString(自己作成管理一時Entity.getHihokenshaNo().getColumnValue()));
        edit限度額管理開始年月日(自己作成管理一時Entity,
                被保険者一時Entity, 給付管理票送付一覧表entity);
        return 給付管理票送付一覧表entity;

    }

    private void editKyufuKanrihyoSofuIchiranEntity1(KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity) {

        if (認定有効期間_編集区分_1.equals(自己作成管理一時Entity.getKoshinKubun())) {
            合計件数_新規1 = 合計件数_新規1.add(1);
            合計件数_新規 = 合計件数_新規.add(1);
        }
        if (認定有効期間_編集区分_2.equals(自己作成管理一時Entity.getKoshinKubun())) {
            合計件数_修正2 = 合計件数_修正2.add(1);
            合計件数_修正 = 合計件数_修正.add(1);
        }
        if (認定有効期間_編集区分_3.equals(自己作成管理一時Entity.getKoshinKubun())) {
            合計件数_取消3 = 合計件数_取消3.add(1);
            合計件数_取消 = 合計件数_取消.add(1);
        }
    }

    private KyufuKanrihyoSofuIchirancsvEntity 集計項目csv明細作成() {
        KyufuKanrihyoSofuIchirancsvEntity 集計項目entity = new KyufuKanrihyoSofuIchirancsvEntity();
        集計項目entity.set保険者番号(保険者番号);
        集計項目entity.set合計件数_新規(new RString(合計件数_新規1.toString()));
        集計項目entity.set合計件数_修正(new RString(合計件数_修正2.toString()));
        集計項目entity.set合計件数_取消(new RString(合計件数_取消3.toString()));
        return 集計項目entity;
    }

    private KyufuKanrihyoSofuIchirancsvEntity csv明細作成(KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity,
            HihokenshaTempEntity 被保険者一時Entity) {
        KyufuKanrihyoSofuIchirancsvEntity output = new KyufuKanrihyoSofuIchirancsvEntity();
        if (ヘッダー項目は1行目 == 1) {
            output.set提出年月(parameter.get処理年月().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            RString 作成日 = RDateTime.now().getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 作成時 = RDateTime.now().getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(作成);
            output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
        } else {
            output.set提出年月(RString.EMPTY);
            output.set作成日時(RString.EMPTY);
        }
        output.set保険者番号(自己作成管理一時Entity.getHokenshaNo());
        output.set保険者名(自己作成管理一時Entity.getHokenshaName());
        output.set対象年月(doパターン54(自己作成管理一時Entity.getRiyoYM()));
        output.set被保険者番号(自己作成管理一時Entity.getHihokenshaNo().getColumnValue());
        output.set被保険者氏名(被保険者一時Entity.getMeisho());
        output.set帳票通番(new RString(帳票通番カウンター));
        if (!RString.isNullOrEmpty(自己作成管理一時Entity.getKyotakuServiceKubun())) {
            output.set居宅サービス区分(KyotakuServiceKubun.toValue(自己作成管理一時Entity.getKyotakuServiceKubun()).get名称());
        }
        if (!RString.isNullOrEmpty(自己作成管理一時Entity.getKoshinKubun())) {
            output.set更新区分(KyufukanrihyoSakuseiKubun.toValue(自己作成管理一時Entity.getKoshinKubun()).get名称());
        }
        if (!自己作成管理一時Entity.getRiyoYM().isEmpty() && !RString.isNullOrEmpty(自己作成管理一時Entity.getYokaigoJotaiKubunCode())) {
            output.set要介護状態区分(YokaigoJotaiKubunSupport.toValue(自己作成管理一時Entity.getRiyoYM(), 自己作成管理一時Entity.getYokaigoJotaiKubunCode()).getName());
        }
        output.set区分支給限度基準額(toRString(自己作成管理一時Entity.getKubunGendoNaiTaniSuNissu()));
        edit限度額管理開始年月日1(自己作成管理一時Entity,
                被保険者一時Entity, output);
        output.set限度額管理終了年月(doパターン54(自己作成管理一時Entity.getShikyuGendoShuryoYM()));
        output.set指定サービス単位_日数(RString.EMPTY);
        output.set基準該当サービス単位_日数(RString.EMPTY);
        output.set合計単位(new RString(明細合計単位数.toString()));
        if (自己作成管理一時Entity.getHyojiShikyuGendoTanisu().compareTo(明細合計単位数) < 0) {
            output.set備考(備考);
        } else {
            output.set備考(RString.EMPTY);
        }
        output.set備考証記載保険者番号(被保険者一時Entity.getExShoHokenshaNo());
        ヘッダー項目は1行目++;
        return output;
    }

    private void edit限度額管理開始年月日(KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity,
            HihokenshaTempEntity 被保険者一時Entity, KyufuKanrihyoSofuIchiranEntity 給付管理票送付一覧表entity) {
        FlexibleYearMonth 支給限度有効開始年月 = 自己作成管理一時Entity.getShikyuGendoKaishiYM();
        FlexibleYearMonth 支給限度有効終了年月 = 自己作成管理一時Entity.getShikyuGendoShuryoYM();
        FlexibleYearMonth 市町村加入年月日 = getFlexibleYearMonth(被保険者一時Entity.getShichosonKanyuYmd());
        FlexibleYearMonth 市町村脱退年月日 = getFlexibleYearMonth(被保険者一時Entity.getShichosonDattaiYmd());

        if (認定有効期間_編集区分_1.equals(DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_認定有効期間_編集区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            給付管理票送付一覧表entity.set限度額管理開始年月日(支給限度有効開始年月);
        } else if (認定有効期間_編集区分_2.equals(DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_認定有効期間_編集区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            if (!支給限度有効終了年月.isEmpty() && !市町村加入年月日.isEmpty() && !支給限度有効開始年月.isEmpty() && !市町村加入年月日.isEmpty()
                    && 支給限度有効開始年月.isBefore(市町村加入年月日) && 市町村加入年月日.isBeforeOrEquals(支給限度有効終了年月)
                    && 市町村脱退年月日.isEmpty()) {
                給付管理票送付一覧表entity.set限度額管理開始年月日(市町村加入年月日);
            } else if (!支給限度有効終了年月.isEmpty() && !市町村加入年月日.isEmpty() && !支給限度有効開始年月.isEmpty() && !市町村加入年月日.isEmpty()
                    && 支給限度有効開始年月.isBefore(市町村加入年月日) && 市町村加入年月日.isBeforeOrEquals(支給限度有効終了年月)
                    && !市町村脱退年月日.isEmpty() && 支給限度有効終了年月.isBeforeOrEquals(市町村脱退年月日)) {
                給付管理票送付一覧表entity.set限度額管理開始年月日(市町村加入年月日);
            } else {
                給付管理票送付一覧表entity.set限度額管理開始年月日(支給限度有効開始年月);
            }
        }
    }

    private void edit限度額管理開始年月日1(KyotakuKeikakuJikosakuseiKanriTempEntity 自己作成管理一時Entity,
            HihokenshaTempEntity 被保険者一時Entity, KyufuKanrihyoSofuIchirancsvEntity output) {
        FlexibleYearMonth 支給限度有効開始年月 = 自己作成管理一時Entity.getShikyuGendoKaishiYM();
        FlexibleYearMonth 支給限度有効終了年月 = 自己作成管理一時Entity.getShikyuGendoShuryoYM();
        FlexibleYearMonth 市町村加入年月日 = getFlexibleYearMonth(被保険者一時Entity.getShichosonKanyuYmd());
        FlexibleYearMonth 市町村脱退年月日 = getFlexibleYearMonth(被保険者一時Entity.getShichosonDattaiYmd());

        if (認定有効期間_編集区分_1.equals(DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_認定有効期間_編集区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            output.set限度額管理開始年月(doパターン54(支給限度有効開始年月));
        } else if (認定有効期間_編集区分_2.equals(DbBusinessConfig.get(ConfigNameDBU.保険者発足情報_認定有効期間_編集区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
            if (!支給限度有効終了年月.isEmpty() && !市町村加入年月日.isEmpty() && !支給限度有効開始年月.isEmpty() && !市町村加入年月日.isEmpty()
                    && 支給限度有効開始年月.isBefore(市町村加入年月日) && 市町村加入年月日.isBeforeOrEquals(支給限度有効終了年月)
                    && 市町村脱退年月日.isEmpty()) {
                output.set限度額管理開始年月(doパターン54(市町村加入年月日));
            } else if (!市町村加入年月日.isEmpty() && !支給限度有効開始年月.isEmpty() && !支給限度有効終了年月.isEmpty()
                    && 支給限度有効開始年月.isBefore(市町村加入年月日) && 市町村加入年月日.isBeforeOrEquals(支給限度有効終了年月)
                    && !市町村脱退年月日.isEmpty() && 支給限度有効終了年月.isBeforeOrEquals(市町村脱退年月日)) {
                output.set限度額管理開始年月(doパターン54(市町村加入年月日));
            } else {
                output.set限度額管理開始年月(doパターン54(支給限度有効開始年月));
            }
        }
    }

    private void アクセスログ対象追加(KyufukanrihyoOutDoBillOutEntity entity) {

        if (null == entity.get被保険者一時Entity().getShikibetsuCode() || entity.get被保険者一時Entity().getShikibetsuCode().isEmpty()) {
            return;
        }
        if (識別コードset.contains(entity.get被保険者一時Entity().getShikibetsuCode())) {
            return;
        }
        識別コードset.add(entity.get被保険者一時Entity().getShikibetsuCode());
        PersonalData personalData = getPersonalData(entity);
        personalDataList.add(personalData);
    }

    private RString getRString(RString rs) {
        if (RString.isNullOrEmpty(rs)) {
            return RString.EMPTY;
        }
        return rs;
    }

    private RString getKyufukanrihyoOutDoBillOutEntity値(KyufukanrihyoOutDoBillOutEntity entity) {
        RStringBuilder rb = new RStringBuilder();
        for (RString rString : pageBreakKeys) {
            RString 集計項目 = RString.EMPTY;
            if (entity == null) {
                return 集計項目;
            }
            Class clazz = entity.getClass();
            try {
                Method getMethod = clazz.getDeclaredMethod(toUpperCaseFirstOne(rString).toString().trim());
                if (RString.class.equals(getMethod.getReturnType())) {
                    集計項目 = new RString(getMethod.invoke(entity).toString());
                } else if (HihokenshaNo.class.equals(getMethod.getReturnType())) {
                    集計項目 = new HihokenshaNo(getMethod.invoke(entity).toString()).value();
                }
                rb.append(集計項目);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
                Logger.getLogger(KyufuKanrihyoSofuIchiranDoBillOutProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return rb.toRString();
    }

    private RString toUpperCaseFirstOne(RString s) {
        if (Character.isUpperCase(s.toString().charAt(0))) {
            return s;
        } else {
            return new RString((new StringBuilder()).append("get").
                    append(Character.toUpperCase(s.toString().charAt(0))).append(s.substring(1)).toString());
        }
    }

    private PersonalData getPersonalData(KyufukanrihyoOutDoBillOutEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(code, 漢字_被保険者番号,
                entity.get自己作成管理一時Entity().getHihokenshaNo().getColumnValue());
        return PersonalData.of(entity.get被保険者一時Entity().getShikibetsuCode(), expandedInformations);
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月 || 年月.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString toRString(Decimal 金額) {
        if (金額 != null) {
            return DecimalFormatter.toRString(金額, 0);
        }
        return RString.EMPTY;
    }

    private FlexibleYearMonth getFlexibleYearMonth(FlexibleDate fb) {
        if (fb.isEmpty()) {
            return FlexibleYearMonth.EMPTY;
        }
        return fb.getYearMonth();
    }
}
