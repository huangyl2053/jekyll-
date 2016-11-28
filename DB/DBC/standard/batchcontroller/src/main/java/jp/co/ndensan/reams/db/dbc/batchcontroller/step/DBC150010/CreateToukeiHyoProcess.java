/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import jp.co.ndensan.reams.db.dbc.business.report.riyojokyotokeihyo.RiyoJokyoTokeihyoReport;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_EditPattern;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.RiyojokyoTokeihyo_KaisuShukeiPattern;
import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.TokeiServiceShurui;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010.RiyojokyoTokeihyoMeisaiListProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyotokeihyo.RiyoJokyoTokeihyoServiceShuruiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.riyojokyotokeihyo.RiyoJokyoTokeihyoShukeiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.riyojokyotokeihyo.RiyoJokyoTokeihyoReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListSakuseiService;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiService;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiShukeiService;
import jp.co.ndensan.reams.db.dbc.service.core.tokeihyoserviceshuruihenkan.TokeihyoServiceShuruiHenkan;
import jp.co.ndensan.reams.db.dbx.definition.core.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 統計表作成のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class CreateToukeiHyoProcess extends BatchKeyBreakBase<DbWT1513RiyoJokyoTokeihyoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select統計表出力対象データ");
    private static final RString なし = new RString("なし");
    private static final int 数字_7 = 7;
    private static final int 数字_6 = 6;
    private static final int 数字_1 = 1;
    private static final int 数字_0 = 0;
    private RiyojokyoTokeihyoMeisaiListProcessParameter parameter;
    @BatchWriter
    private BatchReportWriter<RiyoJokyoTokeihyoReportSource> 利用状況統計表ReportWriter;
    private ReportSourceWriter<RiyoJokyoTokeihyoReportSource> 利用状況統計表SourceWriter;
    Map<RString, Decimal> 利用実人員集計用MAP;
    DbT7051KoseiShichosonMasterEntity 保険者情報;
    RString y軸の添え字;
    RiyoJokyoTokeihyoMeisaiListSakuseiService service;
    Map<RString, RiyoJokyoTokeihyoShukeiKekkaEntity> 利用状況統計表集計結果Map;
    RiyoJokyoTokeihyoServiceShuruiShukeiEntity サービス種類集計;
    boolean 利用実人員登録フラグ;
    RString 被保険者番号;
    RString 制度改正施行年月;
    private boolean isData = false;

    @Override
    protected void initialize() {
        service = RiyoJokyoTokeihyoMeisaiListSakuseiService.createInstance();
        利用実人員集計用MAP = new HashMap<>();
        y軸の添え字 = RString.EMPTY;
        利用状況統計表集計結果Map = new TreeMap<>();
        保険者情報 = service.get保険者情報(parameter.get導入形態コード(), parameter.get市町村コード(), parameter.get旧市町村コード());
        被保険者番号 = RString.EMPTY;
        制度改正施行年月 = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_平成２１年０４月改正,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).substring(数字_0, 数字_6);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toCreateRiyojokyoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        利用状況統計表ReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC300005.getReportId().value(), SubGyomuCode.DBC介護給付).create();
        利用状況統計表SourceWriter = new ReportSourceWriter<>(利用状況統計表ReportWriter);
    }

    @Override
    protected void usualProcess(DbWT1513RiyoJokyoTokeihyoEntity entity) {

        TokeiServiceShurui 統計用サービス = TokeihyoServiceShuruiHenkan.creatInstance().getTokeiServiceShurui(entity.getServiceShuruiCode());
        if (!isData) {
            for (TokeiServiceShurui shurui : TokeiServiceShurui.values()) {
                RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = new RiyoJokyoTokeihyoShukeiKekkaEntity();
                List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = new ArrayList<>();
                for (int i = 0; i < 数字_7; i++) {
                    RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計Entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
                    集計Entity.setサービス種類コード(shurui.getコード());
                    リスト_サービス種類集計.add(集計Entity);
                }
                利用状況統計表集計結果Entity.setリスト_サービス種類集計(リスト_サービス種類集計);
                利用状況統計表集計結果Map.put(shurui.getコード(), 利用状況統計表集計結果Entity);
            }
        }
        if (!被保険者番号.equals(entity.getHihokenshaNo())) {
            利用実人員集計用MAP = new HashMap<>();
        }
        RStringBuilder keyBuilder = new RStringBuilder();
        keyBuilder.append(統計用サービス.getY軸());
        keyBuilder.append(entity.getServiceTeikyoYM());
        if (利用実人員集計用MAP.containsKey(keyBuilder.toRString())) {
            利用実人員登録フラグ = false;
        } else {

            利用実人員登録フラグ = true;
            利用実人員集計用MAP.put(keyBuilder.toRString(), Decimal.ONE);
        }
        RString 統計用サービス種類 = 統計用サービス.getコード();
        createService().get利用実人員(entity, 統計用サービス種類);
        get回数件数日数外泊数(entity, 統計用サービス種類);
        createService().get単位数(entity, 統計用サービス種類);
        createService().get費用総額(entity, 統計用サービス種類);
        createService().get介護給付費(entity, 統計用サービス種類);
        createService().get特定入所費(entity, 統計用サービス種類);
        createShukeiService().get社福軽減額(entity, 統計用サービス種類);
        createShukeiService().get特定入所者介護サービス(entity, 統計用サービス種類);
        createShukeiService().get社会福祉法人軽減額(entity, 統計用サービス種類);
        被保険者番号 = entity.getHihokenshaNo();
        isData = true;
    }

    @Override
    protected void afterExecute() {
        DbWT1513RiyoJokyoTokeihyoEntity before = getBefore();
        for (RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity : 利用状況統計表集計結果Map.values()) {
            利用状況統計表集計結果Entity.set作成日時(RDateTime.now());
            利用状況統計表集計結果Entity.set保険者番号(保険者情報.getShoKisaiHokenshaNo().value());
            利用状況統計表集計結果Entity.set保険者名(保険者情報.getShichosonMeisho());
            if (!RString.isNullOrEmpty(before.getShoriShichosonCode())) {
                利用状況統計表集計結果Entity.set処理市町村コード(new Code(before.getShoriShichosonCode()));
            }
            if (RString.isNullOrEmpty(before.getShoriShichosonName())) {
                利用状況統計表集計結果Entity.set処理市町村名(RString.EMPTY);
                利用状況統計表集計結果Entity.set旧市町村名(RString.EMPTY);
            } else {
                利用状況統計表集計結果Entity.set処理市町村名(before.getShoriShichosonName());
                利用状況統計表集計結果Entity.set旧市町村名(before.getShoriShichosonName());
            }
            利用状況統計表集計結果Entity.set旧市町村コード(before.getKyuShichosonCode());
            RiyoJokyoTokeihyoReport report = new RiyoJokyoTokeihyoReport(利用状況統計表集計結果Entity);
            report.writeBy(利用状況統計表SourceWriter);
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBC.DBC300005.getReportId().value(),
                Association.getLasdecCode().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBC.DBC300005.getReportName(),
                new RString(String.valueOf(利用状況統計表SourceWriter.pageCount().value())),
                なし,
                RString.EMPTY,
                service.getOutputJokenhyoParam(parameter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    @Override
    protected void keyBreakProcess(DbWT1513RiyoJokyoTokeihyoEntity current) {
        DbWT1513RiyoJokyoTokeihyoEntity before = getBefore();
        if (hasBreak(before, current)) {
            for (RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity : 利用状況統計表集計結果Map.values()) {
                利用状況統計表集計結果Entity.set作成日時(RDateTime.now());
                利用状況統計表集計結果Entity.set保険者名(保険者情報.getShichosonMeisho());
                利用状況統計表集計結果Entity.set保険者番号(保険者情報.getShoKisaiHokenshaNo().value());
                if (!RString.isNullOrEmpty(before.getShoriShichosonCode())) {
                    利用状況統計表集計結果Entity.set処理市町村コード(new Code(before.getShoriShichosonCode()));
                }
                if (RString.isNullOrEmpty(before.getShoriShichosonName())) {
                    利用状況統計表集計結果Entity.set処理市町村名(RString.EMPTY);
                    利用状況統計表集計結果Entity.set旧市町村名(RString.EMPTY);
                } else {
                    利用状況統計表集計結果Entity.set処理市町村名(before.getShoriShichosonName());
                    利用状況統計表集計結果Entity.set旧市町村名(before.getShoriShichosonName());
                }
                利用状況統計表集計結果Entity.set旧市町村コード(before.getKyuShichosonCode());
                RiyoJokyoTokeihyoReport report = new RiyoJokyoTokeihyoReport(利用状況統計表集計結果Entity);
                report.writeBy(利用状況統計表SourceWriter);
            }
            利用状況統計表集計結果Map = new HashMap<>();
            for (TokeiServiceShurui shurui : TokeiServiceShurui.values()) {
                RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = new RiyoJokyoTokeihyoShukeiKekkaEntity();
                List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = new ArrayList<>();
                for (int i = 0; i < 数字_7; i++) {
                    RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計Entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
                    集計Entity.setサービス種類コード(shurui.getコード());
                    リスト_サービス種類集計.add(集計Entity);
                }
                利用状況統計表集計結果Entity.setリスト_サービス種類集計(リスト_サービス種類集計);
                利用状況統計表集計結果Map.put(shurui.getコード(), 利用状況統計表集計結果Entity);
            }
        }
    }

    private boolean hasBreak(DbWT1513RiyoJokyoTokeihyoEntity before, DbWT1513RiyoJokyoTokeihyoEntity current) {
        // ブレイクかどうかを判定する。
        if (RString.isNullOrEmpty(before.getShoriShichosonCode())) {
            before.setShoriShichosonCode(RString.EMPTY);
        }
        if (RString.isNullOrEmpty(current.getShoriShichosonCode())) {
            current.setShoriShichosonCode(RString.EMPTY);
        }
        return !before.getShoriShichosonCode().equals(current.getShoriShichosonCode());
    }

    private Decimal get集計項目2(RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity,
            DbWT1513RiyoJokyoTokeihyoEntity entity) {

        RString 要介護状態区分コード = entity.getYoKaigoJotaiKubunCode();
        if (YoKaigoJotaiKubun.非該当.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2_1());
        } else if (YoKaigoJotaiKubun.要支援1.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2_2());
        } else if (YoKaigoJotaiKubun.要支援2.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2_3());
        } else if (YoKaigoJotaiKubun.要支援_経過的要介護.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2_4());
        } else if (YoKaigoJotaiKubun.要介護1.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2_5());
        } else if (YoKaigoJotaiKubun.要介護2.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2_6());
        } else if (YoKaigoJotaiKubun.要介護3.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2_7());
        } else if (YoKaigoJotaiKubun.要介護4.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2_8());
        } else if (YoKaigoJotaiKubun.要介護5.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2_9());
        } else {
            return Decimal.ZERO;
        }
    }

    private Decimal nullToZero(Decimal dec) {
        if (dec == null) {
            return Decimal.ZERO;
        }
        return dec;
    }

    private void get回数件数日数外泊数(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        if (!利用状況統計表集計結果Map.containsKey(統計用サービス種類)) {
            return;
        }
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> リスト_サービス種類集計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (リスト_サービス種類集計 == null) {
            リスト_サービス種類集計 = new ArrayList<>();
            for (int i = 0; i < 数字_7; i++) {
                リスト_サービス種類集計.add(new RiyoJokyoTokeihyoServiceShuruiShukeiEntity());
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(リスト_サービス種類集計);
        }
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = リスト_サービス種類集計.get(数字_1);
        集計項目Entity.setサービス種類コード(tokeihyo_EditPattern.getコード());
        if (YoKaigoJotaiKubun.非該当.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目2_1(entity, 統計用サービス種類);
        } else if (YoKaigoJotaiKubun.要支援1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目2_2(entity, 統計用サービス種類);
        } else if (YoKaigoJotaiKubun.要支援2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目2_3(entity, 統計用サービス種類);
        } else if (YoKaigoJotaiKubun.要支援_経過的要介護.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目2_4(entity, 統計用サービス種類);
        } else if (YoKaigoJotaiKubun.要介護1.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目2_5(entity, 統計用サービス種類);
        } else if (YoKaigoJotaiKubun.要介護2.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目2_6(entity, 統計用サービス種類);
        } else if (YoKaigoJotaiKubun.要介護3.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目2_7(entity, 統計用サービス種類);
        } else if (YoKaigoJotaiKubun.要介護4.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目2_8(entity, 統計用サービス種類);
        } else if (YoKaigoJotaiKubun.要介護5.getCode().equals(entity.getYoKaigoJotaiKubunCode())) {
            create集計項目2_9(entity, 統計用サービス種類);
        }
    }

    private void create集計項目2_1(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        RiyojokyoTokeihyo_KaisuShukeiPattern 回数集計パターン = tokeihyo_EditPattern.get回数集計パターン();
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = 利用状況統計表集計結果Entity.getリスト_サービス種類集計().get(数字_1);
        if (集計項目Entity == null) {
            集計項目Entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
        }
        if (回数集計パターン.is加算有無()) {
            集計項目Entity.set集計項目2_1(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
            集計項目Entity.set集計項目2_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
        }
        if (回数集計パターン.is内訳有無()) {
            集計項目Entity.set集計項目2内訳_1(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            集計項目Entity.set集計項目2内訳_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_1(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), true);
            }
        }
        if (回数集計パターン.is合計加算有無()) {
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_1(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), false);
            }
            if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
                createサービス計2_1(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), false);
            }
        }
    }

    private void createサービス計2_1(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 回数集計パターン, RString サービス種類, boolean is内訳) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> 施設サービス計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (施設サービス計 == null) {
            施設サービス計 = new ArrayList<>();
            for (int i = 0; i < 数字_7; i++) {
                施設サービス計.add(new RiyoJokyoTokeihyoServiceShuruiShukeiEntity());
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(施設サービス計);
        }
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 施設サービス計Entity = 施設サービス計.get(数字_1);
        if (is内訳) {
            施設サービス計Entity.set集計項目2内訳_1(get加算結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            施設サービス計Entity.set集計項目2内訳_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            return;
        }
        施設サービス計Entity.set集計項目2_1(get加算結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
        施設サービス計Entity.set集計項目2_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
    }

    private void create集計項目2_2(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        RiyojokyoTokeihyo_KaisuShukeiPattern 回数集計パターン = tokeihyo_EditPattern.get回数集計パターン();
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = 利用状況統計表集計結果Entity.getリスト_サービス種類集計().get(数字_1);
        if (集計項目Entity == null) {
            集計項目Entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
        }
        if (回数集計パターン.is加算有無()) {
            集計項目Entity.set集計項目2_2(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
            集計項目Entity.set集計項目2_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
        }
        if (回数集計パターン.is内訳有無()) {
            集計項目Entity.set集計項目2内訳_2(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            集計項目Entity.set集計項目2内訳_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_2(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), true);
            }
        }
        if (回数集計パターン.is合計加算有無()) {
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_2(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), false);
            }
            if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
                createサービス計2_2(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), false);
            }
        }
    }

    private void createサービス計2_2(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 回数集計パターン, RString サービス種類, boolean is内訳) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> 施設サービス計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (施設サービス計 == null) {

            施設サービス計 = new ArrayList<>();
            for (int i = 0; i < 数字_7; i++) {
                施設サービス計.add(new RiyoJokyoTokeihyoServiceShuruiShukeiEntity());
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(施設サービス計);
        }
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 施設サービス計Entity = 施設サービス計.get(数字_1);
        if (is内訳) {
            施設サービス計Entity.set集計項目2内訳_2(get加算結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            施設サービス計Entity.set集計項目2内訳_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            return;
        }
        施設サービス計Entity.set集計項目2_2(get加算結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
        施設サービス計Entity.set集計項目2_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
    }

    private void create集計項目2_3(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        RiyojokyoTokeihyo_KaisuShukeiPattern 回数集計パターン = tokeihyo_EditPattern.get回数集計パターン();
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = 利用状況統計表集計結果Entity.getリスト_サービス種類集計().get(数字_1);
        if (集計項目Entity == null) {
            集計項目Entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
        }
        if (回数集計パターン.is加算有無()) {
            集計項目Entity.set集計項目2_3(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
            集計項目Entity.set集計項目2_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
        }
        if (回数集計パターン.is内訳有無()) {
            集計項目Entity.set集計項目2内訳_3(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            集計項目Entity.set集計項目2内訳_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_2(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), true);
            }
        }
        if (回数集計パターン.is合計加算有無()) {
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_3(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), false);
            }
            if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
                createサービス計2_3(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), false);
            }
        }
    }

    private void createサービス計2_3(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 回数集計パターン, RString サービス種類, boolean is内訳) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> 施設サービス計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (施設サービス計 == null) {
            施設サービス計 = new ArrayList<>();
            for (int i = 0; i < 数字_7; i++) {
                施設サービス計.add(new RiyoJokyoTokeihyoServiceShuruiShukeiEntity());
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(施設サービス計);
        }
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 施設サービス計Entity = 施設サービス計.get(数字_1);
        if (is内訳) {
            施設サービス計Entity.set集計項目2内訳_3(get加算結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            施設サービス計Entity.set集計項目2内訳_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            return;
        }
        施設サービス計Entity.set集計項目2_3(get加算結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
        施設サービス計Entity.set集計項目2_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
    }

    private void create集計項目2_4(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        RiyojokyoTokeihyo_KaisuShukeiPattern 回数集計パターン = tokeihyo_EditPattern.get回数集計パターン();
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = 利用状況統計表集計結果Entity.getリスト_サービス種類集計().get(数字_1);
        if (集計項目Entity == null) {
            集計項目Entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
        }
        if (回数集計パターン.is加算有無()) {
            集計項目Entity.set集計項目2_4(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
            集計項目Entity.set集計項目2_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
        }
        if (回数集計パターン.is内訳有無()) {
            集計項目Entity.set集計項目2内訳_4(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            集計項目Entity.set集計項目2内訳_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_4(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), true);
            }
        }
        if (回数集計パターン.is合計加算有無()) {
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_4(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), false);
            }
            if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
                createサービス計2_4(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), false);
            }
        }
    }

    private void createサービス計2_4(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 回数集計パターン, RString サービス種類, boolean is内訳) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> 施設サービス計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (施設サービス計 == null) {
            施設サービス計 = new ArrayList<>();
            for (int i = 0; i < 数字_7; i++) {
                施設サービス計.add(new RiyoJokyoTokeihyoServiceShuruiShukeiEntity());
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(施設サービス計);
        }
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 施設サービス計Entity = 施設サービス計.get(数字_1);
        if (is内訳) {
            施設サービス計Entity.set集計項目2内訳_4(get加算結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            施設サービス計Entity.set集計項目2内訳_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            return;
        }
        施設サービス計Entity.set集計項目2_4(get加算結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
        施設サービス計Entity.set集計項目2_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
    }

    private void create集計項目2_5(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        RiyojokyoTokeihyo_KaisuShukeiPattern 回数集計パターン = tokeihyo_EditPattern.get回数集計パターン();
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = 利用状況統計表集計結果Entity.getリスト_サービス種類集計().get(数字_1);
        if (集計項目Entity == null) {
            集計項目Entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
        }
        if (回数集計パターン.is加算有無()) {
            集計項目Entity.set集計項目2_5(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
            集計項目Entity.set集計項目2_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
        }
        if (回数集計パターン.is内訳有無()) {
            集計項目Entity.set集計項目2内訳_5(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            集計項目Entity.set集計項目2内訳_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_5(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), true);
            }
        }
        if (回数集計パターン.is合計加算有無()) {
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_5(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), false);
            }
            if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
                createサービス計2_5(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), false);
            }
        }
    }

    private void createサービス計2_5(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 回数集計パターン, RString サービス種類, boolean is内訳) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> 施設サービス計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (施設サービス計 == null) {
            施設サービス計 = new ArrayList<>();
            for (int i = 0; i < 数字_7; i++) {
                施設サービス計.add(new RiyoJokyoTokeihyoServiceShuruiShukeiEntity());
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(施設サービス計);
        }
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 施設サービス計Entity = 施設サービス計.get(数字_1);
        if (is内訳) {
            施設サービス計Entity.set集計項目2内訳_5(get加算結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            施設サービス計Entity.set集計項目2内訳_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            return;
        }
        施設サービス計Entity.set集計項目2_5(get加算結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
        施設サービス計Entity.set集計項目2_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
    }

    private void create集計項目2_6(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        RiyojokyoTokeihyo_KaisuShukeiPattern 回数集計パターン = tokeihyo_EditPattern.get回数集計パターン();
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = 利用状況統計表集計結果Entity.getリスト_サービス種類集計().get(数字_1);
        if (集計項目Entity == null) {
            集計項目Entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
        }
        if (回数集計パターン.is加算有無()) {
            集計項目Entity.set集計項目2_6(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
            集計項目Entity.set集計項目2_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
        }
        if (回数集計パターン.is内訳有無()) {
            集計項目Entity.set集計項目2内訳_6(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            集計項目Entity.set集計項目2内訳_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_6(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), true);
            }
        }
        if (回数集計パターン.is合計加算有無()) {
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_6(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), false);
            }
            if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
                createサービス計2_6(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), false);
            }
        }
    }

    private void createサービス計2_6(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 回数集計パターン, RString サービス種類, boolean is内訳) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> 施設サービス計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (施設サービス計 == null) {
            施設サービス計 = new ArrayList<>(数字_7);
            for (int i = 0; i < 数字_7; i++) {
                施設サービス計.add(new RiyoJokyoTokeihyoServiceShuruiShukeiEntity());
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(施設サービス計);
        }
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 施設サービス計Entity = 施設サービス計.get(数字_1);
        if (is内訳) {
            施設サービス計Entity.set集計項目2内訳_6(get加算結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            施設サービス計Entity.set集計項目2内訳_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            return;
        }
        施設サービス計Entity.set集計項目2_6(get加算結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
        施設サービス計Entity.set集計項目2_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
    }

    private void create集計項目2_7(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        RiyojokyoTokeihyo_KaisuShukeiPattern 回数集計パターン = tokeihyo_EditPattern.get回数集計パターン();
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = 利用状況統計表集計結果Entity.getリスト_サービス種類集計().get(数字_1);
        if (集計項目Entity == null) {
            集計項目Entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
        }
        if (回数集計パターン.is加算有無()) {
            集計項目Entity.set集計項目2_7(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
            集計項目Entity.set集計項目2_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
        }
        if (回数集計パターン.is内訳有無()) {
            集計項目Entity.set集計項目2内訳_7(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            集計項目Entity.set集計項目2内訳_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_7(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), true);
            }
        }
        if (回数集計パターン.is合計加算有無()) {
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_7(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), false);
            }
            if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
                createサービス計2_7(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), false);
            }
        }
    }

    private void createサービス計2_7(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 回数集計パターン, RString サービス種類, boolean is内訳) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> 施設サービス計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (施設サービス計 == null) {
            施設サービス計 = new ArrayList<>();
            for (int i = 0; i < 数字_7; i++) {
                施設サービス計.add(new RiyoJokyoTokeihyoServiceShuruiShukeiEntity());
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(施設サービス計);
        }
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 施設サービス計Entity = 施設サービス計.get(数字_1);
        if (is内訳) {
            施設サービス計Entity.set集計項目2内訳_7(get加算結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            施設サービス計Entity.set集計項目2内訳_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            return;
        }
        施設サービス計Entity.set集計項目2_7(get加算結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
        施設サービス計Entity.set集計項目2_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
    }

    private void create集計項目2_8(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        RiyojokyoTokeihyo_KaisuShukeiPattern 回数集計パターン = tokeihyo_EditPattern.get回数集計パターン();
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = 利用状況統計表集計結果Entity.getリスト_サービス種類集計().get(数字_1);
        if (集計項目Entity == null) {
            集計項目Entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
        }
        if (回数集計パターン.is加算有無()) {
            集計項目Entity.set集計項目2_8(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
            集計項目Entity.set集計項目2_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
        }
        if (回数集計パターン.is内訳有無()) {
            集計項目Entity.set集計項目2内訳_8(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            集計項目Entity.set集計項目2内訳_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_8(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), true);
            }
        }
        if (回数集計パターン.is合計加算有無()) {
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_8(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), false);
            }
            if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
                createサービス計2_8(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), false);
            }
        }
    }

    private void createサービス計2_8(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 回数集計パターン, RString サービス種類, boolean is内訳) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> 施設サービス計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (施設サービス計 == null) {
            施設サービス計 = new ArrayList<>();
            for (int i = 0; i < 数字_7; i++) {
                施設サービス計.add(new RiyoJokyoTokeihyoServiceShuruiShukeiEntity());
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(施設サービス計);
        }
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 施設サービス計Entity = 施設サービス計.get(数字_1);
        if (is内訳) {
            施設サービス計Entity.set集計項目2内訳_8(get加算結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            施設サービス計Entity.set集計項目2内訳_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            return;
        }
        施設サービス計Entity.set集計項目2_8(get加算結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
        施設サービス計Entity.set集計項目2_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
    }

    private void create集計項目2_9(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 統計用サービス種類) {
        RiyojokyoTokeihyo_EditPattern tokeihyo_EditPattern = RiyojokyoTokeihyo_EditPattern.toValue(統計用サービス種類);
        RiyojokyoTokeihyo_KaisuShukeiPattern 回数集計パターン = tokeihyo_EditPattern.get回数集計パターン();
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(統計用サービス種類);
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity = 利用状況統計表集計結果Entity.getリスト_サービス種類集計().get(数字_1);
        if (集計項目Entity == null) {
            集計項目Entity = new RiyoJokyoTokeihyoServiceShuruiShukeiEntity();
        }
        if (回数集計パターン.is加算有無()) {
            集計項目Entity.set集計項目2_9(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
            集計項目Entity.set集計項目2_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), true, false));
        }
        if (回数集計パターン.is内訳有無()) {
            集計項目Entity.set集計項目2内訳_9(get加算結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            集計項目Entity.set集計項目2内訳_10(get加算合計結果(集計項目Entity, entity, 回数集計パターン.getコード(), false, true));
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_9(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), true);
            }
        }
        if (回数集計パターン.is合計加算有無()) {
            if (tokeihyo_EditPattern.is施設サービス計加算有無()) {
                createサービス計2_9(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.施設サービス計.getコード(), false);
            }
            if (tokeihyo_EditPattern.is地域サービス計加算有無()) {
                createサービス計2_9(entity, 回数集計パターン.getコード(), RiyojokyoTokeihyo_EditPattern.地域密着型施設サービス計.getコード(), false);
            }
        }
    }

    private void createサービス計2_9(DbWT1513RiyoJokyoTokeihyoEntity entity, RString 回数集計パターン, RString サービス種類, boolean is内訳) {
        RiyoJokyoTokeihyoShukeiKekkaEntity 利用状況統計表集計結果Entity = 利用状況統計表集計結果Map.get(サービス種類);
        List<RiyoJokyoTokeihyoServiceShuruiShukeiEntity> 施設サービス計 = 利用状況統計表集計結果Entity.getリスト_サービス種類集計();
        if (施設サービス計 == null) {
            施設サービス計 = new ArrayList<>();
            for (int i = 0; i < 数字_7; i++) {
                施設サービス計.add(new RiyoJokyoTokeihyoServiceShuruiShukeiEntity());
            }
            利用状況統計表集計結果Entity.setリスト_サービス種類集計(施設サービス計);
        }
        RiyoJokyoTokeihyoServiceShuruiShukeiEntity 施設サービス計Entity = 施設サービス計.get(数字_1);
        if (is内訳) {
            施設サービス計Entity.set集計項目2内訳_9(get加算結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            施設サービス計Entity.set集計項目2内訳_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, false, is内訳));
            return;
        }
        施設サービス計Entity.set集計項目2_9(get加算結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
        施設サービス計Entity.set集計項目2_10(get加算合計結果(施設サービス計Entity, entity, 回数集計パターン, true, is内訳));
    }

    private Decimal get加算結果(RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity,
            DbWT1513RiyoJokyoTokeihyoEntity entity, RString 回数集計パターン, boolean is加算対象1, boolean is内訳有無) {

        Decimal 加算結果1 = Decimal.ZERO;
        Decimal 加算結果2 = Decimal.ZERO;
        if (回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算あり.getコード())
                || 回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算あり.getコード())
                || 回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算なし.getコード())
                || 回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算なし.getコード())) {
            if (!is内訳有無) {
                加算結果1 = new Decimal(entity.getTankiNyushoJitsunissu().toString()).add(get集計項目2(集計項目Entity, entity));
                加算結果2 = new Decimal(entity.getGaihakuNissu().toString()).add(get集計項目2(集計項目Entity, entity));
            } else {
                加算結果1 = new Decimal(entity.getTankiNyushoJitsunissu().toString()).add(get集計項目2内訳(集計項目Entity, entity));
                加算結果2 = new Decimal(entity.getGaihakuNissu().toString()).add(get集計項目2内訳(集計項目Entity, entity));
            }
        } else if (回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算あり.getコード())
                || 回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算なし.getコード())) {
            if (!is内訳有無) {
                加算結果1 = new Decimal(entity.getNissuKaisu().toString()).add(get集計項目2(集計項目Entity, entity));
                加算結果2 = get集計項目2(集計項目Entity, entity);
            } else {
                加算結果1 = new Decimal(entity.getNissuKaisu().toString()).add(get集計項目2内訳(集計項目Entity, entity));
                加算結果2 = 集計項目Entity.get集計項目2内訳_1();
            }
        } else if (回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.居宅支援_内訳あり_合計加算なし.getコード())) {
            加算結果1 = get居宅支援加算結果(集計項目Entity, entity, true, is内訳有無);
            加算結果2 = get居宅支援加算結果(集計項目Entity, entity, false, is内訳有無);
        }
        if (is加算対象1) {
            return 加算結果1;
        } else {
            return 加算結果2;
        }
    }

    private Decimal get加算合計結果(RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity,
            DbWT1513RiyoJokyoTokeihyoEntity entity, RString 回数集計パターン, boolean is加算対象1, boolean is内訳有無) {

        Decimal 加算結果1 = Decimal.ZERO;
        Decimal 加算結果2 = Decimal.ZERO;
        if (回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算あり.getコード())
                || 回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算あり.getコード())
                || 回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算なし.getコード())
                || 回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算なし.getコード())) {
            if (!is内訳有無) {
                加算結果1 = new Decimal(entity.getTankiNyushoJitsunissu().toString()).add(nullToZero(集計項目Entity.get集計項目2_10()));
                加算結果2 = new Decimal(entity.getGaihakuNissu().toString()).add(nullToZero(集計項目Entity.get集計項目2_10()));
            } else {
                加算結果1 = new Decimal(entity.getTankiNyushoJitsunissu().toString()).add(nullToZero(集計項目Entity.get集計項目2内訳_10()));
                加算結果2 = new Decimal(entity.getGaihakuNissu().toString()).add(nullToZero(集計項目Entity.get集計項目2内訳_10()));
            }
        } else if (回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算あり.getコード())
                || 回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算なし.getコード())) {
            if (!is内訳有無) {
                加算結果1 = new Decimal(entity.getNissuKaisu().toString()).add(nullToZero(集計項目Entity.get集計項目2_10()));
                加算結果2 = 集計項目Entity.get集計項目2_10();
            } else {
                加算結果1 = new Decimal(entity.getNissuKaisu().toString()).add(nullToZero(集計項目Entity.get集計項目2内訳_10()));
                加算結果2 = 集計項目Entity.get集計項目2内訳_10();
            }
        } else if (回数集計パターン.equals(RiyojokyoTokeihyo_KaisuShukeiPattern.居宅支援_内訳あり_合計加算なし.getコード())) {
            加算結果1 = get加算対象(集計項目Entity, entity, is加算対象1, is内訳有無);
            加算結果2 = get加算対象(集計項目Entity, entity, is加算対象1, is内訳有無);
        }
        if (is加算対象1) {
            return 加算結果1;
        } else {
            return 加算結果2;
        }
    }

    private Decimal get集計項目2内訳(RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity,
            DbWT1513RiyoJokyoTokeihyoEntity entity) {

        RString 要介護状態区分コード = entity.getYoKaigoJotaiKubunCode();
        if (YoKaigoJotaiKubun.非該当.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2内訳_1());
        } else if (YoKaigoJotaiKubun.要支援1.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2内訳_2());
        } else if (YoKaigoJotaiKubun.要支援2.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2内訳_3());
        } else if (YoKaigoJotaiKubun.要支援_経過的要介護.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2内訳_4());
        } else if (YoKaigoJotaiKubun.要介護1.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2内訳_5());
        } else if (YoKaigoJotaiKubun.要介護2.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2内訳_6());
        } else if (YoKaigoJotaiKubun.要介護3.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2内訳_7());
        } else if (YoKaigoJotaiKubun.要介護4.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2内訳_8());
        } else if (YoKaigoJotaiKubun.要介護5.getCode().equals(要介護状態区分コード)) {
            return nullToZero(集計項目Entity.get集計項目2内訳_9());
        } else {
            return Decimal.ZERO;
        }
    }

    private Decimal get居宅支援加算結果(RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity,
            DbWT1513RiyoJokyoTokeihyoEntity entity, boolean is加算対象1, boolean is内訳有無) {

        Decimal 加算対象1;
        Decimal 加算対象2;
        DbWT1513RiyoJokyoTokeihyoEntity before = getBefore();
        if (before == null) {
            return Decimal.ZERO;
        }
        if (entity.getServiceTeikyoYM().compareTo(制度改正施行年月) < 0) {
            if (before.getHihokenshaNo().equals(entity.getHihokenshaNo())
                    && before.getServiceTeikyoYM().equals(entity.getServiceTeikyoYM())
                    && before.getServiceShuruiCode().equals(entity.getServiceShuruiCode())
                    && before.getJigyoshoNo().equals(entity.getJigyoshoNo())) {
                加算対象1 = new Decimal(entity.getNissuKaisu().toString());
                加算対象2 = Decimal.ZERO;
            } else {
                加算対象1 = new Decimal(entity.getNissuKaisu().toString());
                加算対象2 = Decimal.ONE;
            }
        } else {
            if (before.getHihokenshaNo().equals(entity.getHihokenshaNo())
                    && before.getServiceTeikyoYM().equals(entity.getServiceTeikyoYM())
                    && before.getServiceShuruiCode().equals(entity.getServiceShuruiCode())
                    && before.getJigyoshoNo().equals(entity.getJigyoshoNo())) {
                加算対象1 = Decimal.ZERO;
                加算対象2 = Decimal.ZERO;
            } else {
                加算対象1 = Decimal.ONE;
                加算対象2 = Decimal.ONE;
            }
        }
        if (is加算対象1) {
            if (is内訳有無) {
                return 加算対象1.add(get集計項目2内訳(集計項目Entity, entity));
            }
            return 加算対象1.add(get集計項目2(集計項目Entity, entity));
        } else {
            if (is内訳有無) {
                return 加算対象2.add(get集計項目2内訳(集計項目Entity, entity));
            }
            return 加算対象2.add(get集計項目2(集計項目Entity, entity));
        }
    }

    private Decimal get加算対象(RiyoJokyoTokeihyoServiceShuruiShukeiEntity 集計項目Entity,
            DbWT1513RiyoJokyoTokeihyoEntity entity, boolean is加算対象1, boolean is内訳有無) {
        Decimal 加算対象1;
        Decimal 加算対象2;
        DbWT1513RiyoJokyoTokeihyoEntity before = getBefore();
        if (entity.getServiceTeikyoYM().compareTo(制度改正施行年月) < 0) {
            if (before.getHihokenshaNo().equals(entity.getHihokenshaNo())
                    && before.getServiceTeikyoYM().equals(entity.getServiceTeikyoYM())
                    && before.getServiceShuruiCode().equals(entity.getServiceShuruiCode())
                    && before.getJigyoshoNo().equals(entity.getJigyoshoNo())) {
                加算対象1 = new Decimal(entity.getNissuKaisu().toString());
                加算対象2 = Decimal.ZERO;
            } else {
                加算対象1 = new Decimal(entity.getNissuKaisu().toString());
                加算対象2 = Decimal.ONE;
            }
        } else {
            if (before.getHihokenshaNo().equals(entity.getHihokenshaNo())
                    && before.getServiceTeikyoYM().equals(entity.getServiceTeikyoYM())
                    && before.getServiceShuruiCode().equals(entity.getServiceShuruiCode())
                    && before.getJigyoshoNo().equals(entity.getJigyoshoNo())) {
                加算対象1 = Decimal.ZERO;
                加算対象2 = Decimal.ZERO;
            } else {
                加算対象1 = Decimal.ONE;
                加算対象2 = Decimal.ONE;
            }
        }
        if (is加算対象1) {
            if (is内訳有無) {
                return 加算対象1.add(nullToZero(集計項目Entity.get集計項目2内訳_10()));
            }
            return 加算対象1.add(nullToZero(集計項目Entity.get集計項目2_10()));
        } else {
            if (is内訳有無) {
                return 加算対象2.add(nullToZero(集計項目Entity.get集計項目2内訳_10()));
            }
            return 加算対象2.add(nullToZero(集計項目Entity.get集計項目2_10()));
        }
    }

    private RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiService createService() {
        return new RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiService(利用状況統計表集計結果Map);
    }

    private RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiShukeiService createShukeiService() {
        return new RiyoJokyoTokeihyoMeisaiListTokeiHyoSakuseiShukeiService(利用状況統計表集計結果Map, 利用実人員登録フラグ);
    }
}
