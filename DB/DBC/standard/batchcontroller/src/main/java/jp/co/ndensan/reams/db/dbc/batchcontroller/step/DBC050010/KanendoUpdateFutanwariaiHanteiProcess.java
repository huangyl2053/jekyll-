/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo.ChohyoSeigyoHanyoKomokuMei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_SaishoriShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShihraiHohoShitei;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_ShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.KanendoUpdateFutanwariaiHanteProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 処理日付管理マスタの更新処理クラスです。
 *
 * @reamsid_L DBC-2180-030 x_miaocl
 */
public class KanendoUpdateFutanwariaiHanteiProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010"
            + ".IKanendoUpdateFutanwariaiHanteiMapper.get処理日付管理マスタ更新");
    private static final RString MYBATIS_SELECT_ID_NASI = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010"
            + ".IKanendoUpdateFutanwariaiHanteiMapper.get処理日付管理マスタデータなし");
    private static final RString 連番 = new RString("0000");
    private static final RString 年度内連番 = new RString("0001");
    private static final FlexibleYear 年度 = new FlexibleYear("0000");

    private static final RString 処理区分_振込データ作成 = new RString("1");
    private static final RString 処理区分_振込指定日修正 = new RString("2");
    private static final RString 処理区分_明細一覧表作成 = new RString("3");

    private static final ReportId REPORTID = ReportIdDBC.DBC200101.getReportId();
    private static final RString 出力有無 = new RString("なし");
    private static final RString 処理対象 = new RString("【処理対象】");
    private static final RString 処理区分 = new RString("【処理区分】");
    private static final RString 振込指定日 = new RString("【振込指定日】");
    private static final RString 再処理 = new RString("【再処理】");
    private static final RString 誤_振込指定日 = new RString("【誤・振込指定日】");
    private static final RString 正_振込指定日 = new RString("【正・振込指定日】");
    private static final RString 支払方法 = new RString("【支払方法】");
    private static final RString 抽出期間_発行日 = new RString("【抽出期間】決定通知書発行日：");
    private static final RString 抽出期間_受取年月 = new RString("【抽出期間】決定者受取年月：");
    private static final RString 抽出対象 = new RString("【抽出対象】");
    private static final RString 対象作成日 = new RString("【対象作成日】");
    private static final RString 符号 = new RString("－");
    private static final RString 連携符号 = new RString("～");
    private static final RString 帳票タイトル = new RString("振込明細一覧表");
    private static final RString ZERO = new RString("0");

    private KanendoUpdateFutanwariaiHanteProcessParameter parameter;
    private static final int 検索件数_0 = 0;

    private int count = 0;

    @Override
    protected void initialize() {
    }

    @BatchWriter
    BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> dbWriter;

    @Override
    protected IBatchReader createReader() {
        if (!Furikomi_ShoriKubun.明細一覧表作成.equals(parameter.get処理区分())) {
            return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toKanendoUpdateFutanwariaiHanteMybatisParameter());
        }
        return new BatchDbReader(MYBATIS_SELECT_ID_NASI);
    }

    @Override
    protected void createWriter() {
        dbWriter = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        count++;
        entity.setTaishoKaishiYMD(parameter.get開始年月日());
        entity.setTaishoShuryoYMD(parameter.get終了年月日());
        entity.setTaishoKaishiTimestamp(new YMDHMS(RString.EMPTY));
        entity.setTaishoShuryoTimestamp(new YMDHMS(RString.EMPTY));
        dbWriter.update(entity);
    }

    @Override
    protected void afterExecute() {
        if (!Furikomi_ShoriKubun.明細一覧表作成.equals(parameter.get処理区分()) && 検索件数_0 == count) {

            DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(SubGyomuCode.DBC介護給付);
            entity.setShichosonCode(new LasdecCode("000000"));
            if (parameter.get処理名() != null) {
                entity.setShoriName(parameter.get処理名().get名称());
            }
            entity.setShoriEdaban(連番);
            entity.setNendo(年度);
            entity.setNendoNaiRenban(年度内連番);
            entity.setKijunYMD(FlexibleDate.EMPTY);
            entity.setKijunTimestamp(new YMDHMS(RString.EMPTY));
            entity.setTaishoKaishiYMD(parameter.get開始年月日());
            entity.setTaishoShuryoYMD(parameter.get終了年月日());
            entity.setTaishoKaishiTimestamp(new YMDHMS(RString.EMPTY));
            entity.setTaishoShuryoTimestamp(new YMDHMS(RString.EMPTY));
            dbWriter.insert(entity);
        }
        eucFileOutputJohoFactory();
    }

    private void eucFileOutputJohoFactory() {
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                REPORTID.value(),
                Association.getLasdecCode().value(),
                AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
                new RString(JobContextHolder.getJobId()),
                get設定値(),
                getPageCount(parameter.get帳票ページCount()),
                出力有無,
                RString.EMPTY,
                get出力条件表());

        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private RString getPageCount(RString 帳票ページCount) {
        if (RString.isNullOrEmpty(帳票ページCount)) {
            return ZERO;
        }
        return new RString(new Decimal(帳票ページCount.toString()).add(Decimal.ONE).toString());
    }

    private RString get設定値() {
        ChohyoSeigyoHanyo hanyoResult = null;

        if (Furikomi_ShihraiHohoShitei.口座.equals(parameter.get支払方法())) {
            hanyoResult = ChohyoSeigyoHanyoManager.createInstance()
                    .get帳票制御汎用(SubGyomuCode.DBC介護給付, REPORTID, FlexibleYear.MIN, ChohyoSeigyoHanyoKomokuMei.帳票タイトル_口座.get名称());
        } else {
            hanyoResult = ChohyoSeigyoHanyoManager.createInstance()
                    .get帳票制御汎用(SubGyomuCode.DBC介護給付, REPORTID, FlexibleYear.MIN, ChohyoSeigyoHanyoKomokuMei.帳票タイトル_窓口.get名称());
        }

        if (hanyoResult != null) {
            return hanyoResult.get設定値();
        } else {
            return 帳票タイトル;
        }
    }

    private List<RString> get出力条件表() {
        List<RString> list = new ArrayList<>();

        list.add(処理対象.concat(parameter.get処理対象().get名称()));
        list.add(処理区分.concat(parameter.get処理区分().get名称()));
        editバッチ出力条件_処理区分(list, parameter);
        editバッチ出力条件_決定通知書発行日(list, parameter);
        editバッチ出力条件_決定者受取年月(list, parameter);
        if (parameter.get抽出対象() != null) {
            list.add(抽出対象.concat(parameter.get抽出対象().get名称()));
        }
        if (parameter.get対象作成年月日() == null || parameter.get対象作成年月日().isEmpty()) {
            list.add(対象作成日.concat(符号));
        } else {
            list.add(対象作成日.concat(parameter.get対象作成年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.ZERO).toDateString()));
        }
        return list;
    }

    private void editバッチ出力条件_処理区分(List<RString> list, KanendoUpdateFutanwariaiHanteProcessParameter parameter) {

        if (処理区分_振込データ作成.equals(parameter.get処理区分().getコード())) {
            if (parameter.get振込指定年月日() != null) {
                RString 振込指定年月日Str = parameter.get振込指定年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE)
                        .fillType(FillType.ZERO).toDateString();
                list.add(振込指定日.concat(振込指定年月日Str));
            }

            if (parameter.is再処理フラグ()) {
                list.add(再処理.concat(Furikomi_SaishoriShitei.再処理.get名称()));
            } else {
                list.add(再処理.concat(符号));
            }
        } else if (処理区分_振込指定日修正.equals(parameter.get処理区分().getコード())) {
            if (parameter.get誤振込指定年月日() != null) {
                RString 誤振込指定年月日Str = parameter.get誤振込指定年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE)
                        .fillType(FillType.ZERO).toDateString();
                list.add(誤_振込指定日.concat(誤振込指定年月日Str));
            }
            if (parameter.get正振込指定年月日() != null) {
                RString 正振込指定年月日Str = parameter.get正振込指定年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE)
                        .fillType(FillType.ZERO).toDateString();
                list.add(正_振込指定日.concat(正振込指定年月日Str));
            }
        } else if (処理区分_明細一覧表作成.equals(parameter.get処理区分().getコード())) {
            list.add(支払方法.concat(parameter.get支払方法().get名称()));
        }
    }

    private void editバッチ出力条件_決定通知書発行日(List<RString> list, KanendoUpdateFutanwariaiHanteProcessParameter parameter) {
        if (parameter.get開始年月日() != null && !parameter.get開始年月日().isEmpty()
                && parameter.get終了年月日() != null && !parameter.get終了年月日().isEmpty()) {
            RString 開始年月日Str = parameter.get開始年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.ZERO).toDateString();
            RString 終了年月日Str = parameter.get終了年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.ZERO).toDateString();
            list.add(抽出期間_発行日.concat(開始年月日Str).concat(連携符号).concat(終了年月日Str));
        } else if ((parameter.get開始年月日() == null || parameter.get開始年月日().isEmpty())
                && parameter.get終了年月日() != null && !parameter.get終了年月日().isEmpty()) {
            RString 終了年月日Str = parameter.get終了年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.ZERO).toDateString();
            list.add(抽出期間_発行日.concat(連携符号).concat(終了年月日Str));
        } else {
            list.add(抽出期間_発行日.concat(符号));
        }
    }

    private void editバッチ出力条件_決定者受取年月(List<RString> list, KanendoUpdateFutanwariaiHanteProcessParameter parameter) {

        if (処理区分_振込データ作成.equals(parameter.get処理区分().getコード())
                || 処理区分_明細一覧表作成.equals(parameter.get処理区分().getコード())) {

            if (parameter.get開始受取年月() != null && !parameter.get開始受取年月().isEmpty()
                    && parameter.get終了受取年月() != null && !parameter.get終了受取年月().isEmpty()) {
                RString 開始受取年月Str = parameter.get開始受取年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE)
                        .fillType(FillType.ZERO).toDateString();

                RString 終了受取年月Str = parameter.get終了受取年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE)
                        .fillType(FillType.ZERO).toDateString();
                list.add(抽出期間_受取年月.concat(開始受取年月Str).concat(連携符号).concat(終了受取年月Str));
            } else if ((parameter.get開始受取年月() == null || parameter.get開始受取年月().isEmpty())
                    && parameter.get終了受取年月() != null && !parameter.get終了受取年月().isEmpty()) {
                RString 終了受取年月Str = parameter.get終了受取年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE)
                        .fillType(FillType.ZERO).toDateString();
                list.add(抽出期間_受取年月.concat(連携符号).concat(終了受取年月Str));
            } else {
                list.add(抽出期間_受取年月.concat(符号));
            }
        }
    }
}
