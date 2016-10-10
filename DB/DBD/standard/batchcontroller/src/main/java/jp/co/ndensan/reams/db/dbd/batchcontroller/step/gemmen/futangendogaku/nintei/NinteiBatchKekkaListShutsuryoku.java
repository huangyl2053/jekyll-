/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.futangendogaku.nintei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.futangendogaku.FutanGendogakuOrderKey;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200005.FutanGendogakuNinteiKakuninIchiranReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200019.FutangakuNinteiHakkoIchiranOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.HaigushaKazeiKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006.NinteiBatchKekkaListShutsuryokuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogaku.ikkatsunintei.FutanGengaokuNintteiKakuninListCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogaku.ikkatsunintei.FutanGengaokuNintteiKakuninListEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200005.FutanGendogakuNinteiKakuninIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 負担限度額認定申請一括承認（バッチ）_結果一覧出力のprocess処理クラスです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
public class NinteiBatchKekkaListShutsuryoku extends BatchKeyBreakBase<FutanGengaokuNintteiKakuninListEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogaku."
                    + "INinteiBatchKekkaListShutsuryokuMapper.get結果一覧データ");
    private NinteiBatchKekkaListShutsuryokuProcessParameter parameter;
    private RString 出力順;
    private Association 導入団体;
    @BatchWriter
    private BatchReportWriter<FutanGendogakuNinteiKakuninIchiranReportSource> batchReportWriter;
    private ReportSourceWriter<FutanGendogakuNinteiKakuninIchiranReportSource> reportSourceWriter;
    private CsvWriter<FutanGengaokuNintteiKakuninListCsvEntity> csvWriter;
    private RString csvFilePath;
    private RString fileName;
    private IOutputOrder outputOrder;
    private static final int NUM5 = 5;
    private static final int NUM8 = 8;
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_2 = 2;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;
    private RString orderBy = null;
    private static final RString 作成年度 = new RString("【作成年度】");
    private static final RString 認定期間_開始日 = new RString("【認定期間_開始日】");
    private static final RString 認定期間_終了日 = new RString("【認定期間_終了日】");
    private static final RString 決定日 = new RString("【決定日】");
    private static final RString 申請日開始 = new RString("【申請日開始】");
    private static final RString 申請日終了 = new RString("【申請日終了】");
    private static final RString 非課税時_承認しないフラグ = new RString("【非課税時_承認しないフラグ】");
    private static final RString 非課税時_承認しない理由 = new RString("【非課税時_承認しない理由】");
    private static final RString 配偶者課税時_承認しないフラグ = new RString("【配偶者課税時_承認しないフラグ】");
    private static final RString 配偶者課税時_承認しない理由 = new RString("【配偶者課税時_承認しない理由】");
    private static final RString 預貯金等超過時_承認しないフラグ = new RString("【預貯金等超過時_承認しないフラグ】");
    private static final RString 預貯金等超過時_理由 = new RString("【預貯金等超過時_理由】");
    private static final RString テスト処理 = new RString("【テスト処理】");
    private static final RString 確認リスト出力 = new RString("【確認リスト出力】");
    private static final RString 発行日 = new RString("【発行日】");
    private static final RString 改頁出力順ID = new RString("【改頁出力順ID】");
    private static final RString 帳票分類ID = new RString("【帳票分類ID】");
    private static final RString 帳票ID = new RString("【帳票ID】");
    private static final RString 帳票作成日時 = new RString("【帳票作成日時】");
    private static final RString 負担限度額認定申請承認一括 = new RString("【負担限度額認定申請承認一括】");
    private static final RString TRUE = new RString("TRUE");
    private static final RString FALSE = new RString("FALSE");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSV_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CSVファイル名 = new RString("負担限度額認定（一括）確認リスト.csv");
    private static final RString CSVタイトル = new RString("負担限度額認定（一括）確認リスト");
    private static final RString 申請理由区分_世帯非課税８０万以下 = new RString("01");
    private static final RString 申請理由区分_世帯非課税８０万超 = new RString("02");
    private static final RString 申請理由区分_生保 = new RString("03");
    private static final RString 申請理由区分_世帯非課税 = new RString("04");
    private static final RString 申請理由区分_老齢 = new RString("05");
    private static final RString 申請理由区分_特例減額措置 = new RString("06");
    private static final RString 申請負担段階_1 = new RString("第１段階");
    private static final RString 申請負担段階_2 = new RString("第２段階");
    private static final RString 申請負担段階_3 = new RString("第３段階");
    private static final RString 申請負担段階_特例減額措置 = new RString("課税第３");
    private static final RString 申請負担段階_その他 = new RString("その他");
    private static final RString 星 = new RString("*");
    private static final RString 申 = new RString("申");
    private static final RString 認 = new RString("認");
    private static final RString 住所地特例フラグ_1 = new RString("1");
    private static final RString 決定区分_承認 = new RString("承認");
    private static final RString 決定区分_却下 = new RString("却下");
    private static final RString 該当 = new RString("該当");
    private static final RString 非該当 = new RString("非該当");

    @Override
    protected void initialize() {
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給, new ReportId(parameter.get帳票ID()),
                UrControlDataFactory.createInstance().getLoginInfo().getUserId(), Long.valueOf(parameter.get改頁出力順ID().toString()));
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(FutangakuNinteiHakkoIchiranOrderKey.class, outputOrder);
        } else {
            出力順 = RString.EMPTY;
        }
        導入団体 = AssociationFinderFactory.createInstance().getAssociation();
        if (null != outputOrder) {
            orderBy = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(FutanGendogakuOrderKey.class,
                    outputOrder).substring(NUM8), NUM5);
        }
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder build
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        build.setデータ取得区分(DataShutokuKubun.直近レコード);
        //基準年月日 <-パラメータの基準日
        IShikibetsuTaishoPSMSearchKey key = build.build();
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toNinteiBatchKekkaListShutsuryokuMybatisParameter(key, 出力順));
    }

    @Override
    protected void createWriter() {
        List<RString> pageBreakKeys = new ArrayList<>();
        set改頁Key(outputOrder, pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID())
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        csvFilePath = Path.getTmpDirectoryPath();
        fileName = fileName = Path.combinePath(csvFilePath, CSVファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(fileName)
                .alwaysWriteHeader(FutanGengaokuNintteiKakuninListCsvEntity.class)
                .setEncode(Encode.SJIS)
                .setDelimiter(CSV_WRITER_DELIMITER)
                .setEnclosure(CSV_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void keyBreakProcess(FutanGengaokuNintteiKakuninListEntity current) {

    }

    @Override
    protected void usualProcess(FutanGengaokuNintteiKakuninListEntity entity) {
        FutanGengaokuNintteiKakuninListCsvEntity csvEntity = new FutanGengaokuNintteiKakuninListCsvEntity();
        setCsvEntity(csvEntity, entity);
        今回と前回情報設定(csvEntity, entity);
        csvWriter.writeLine(csvEntity);
        FutanGendogakuNinteiKakuninIchiranReport report
                = new FutanGendogakuNinteiKakuninIchiranReport(entity, 導入団体, outputOrder, parameter.getバッチ処理日時().getRDateTime());
        report.writeBy(reportSourceWriter);
    }

    private void setCsvEntity(FutanGengaokuNintteiKakuninListCsvEntity csvEntity,
            FutanGengaokuNintteiKakuninListEntity entity) {
        csvEntity.setタイトル(CSVタイトル);
        csvEntity.set印刷年月日時分秒(RDate.getNowDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString()
                .concat(RString.FULL_SPACE)
                .concat(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒)));
        csvEntity.set被保険者番号(entity.get被保険者番号().value());
        if (entity.getAtesakiEntity() != null) {
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.getAtesakiEntity());
            if (null != 宛名.get名称()) {
                csvEntity.set氏名(宛名.get名称().getName().value());
            }
        }
        if (entity.get資格取得日() != null && !entity.get資格取得日().isEmpty()) {
            csvEntity.set資格取得日(entity.get資格取得日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        if (entity.get資格喪失日() != null && !entity.get資格喪失日().isEmpty()) {
            csvEntity.set資格喪失日(entity.get資格喪失日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        if (entity.get認定開始日() != null && !entity.get認定開始日().isEmpty()) {
            csvEntity.set認定開始日(entity.get認定開始日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        if (entity.get認定終了日() != null && !entity.get認定終了日().isEmpty()) {
            csvEntity.set認定終了日(entity.get認定終了日().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        if (entity.get厚労省IF識別コード() != null && entity.get要介護状態区分コード() != null) {
            IYokaigoJotaiKubun iYokaigoJotaiKubun = YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.toValue(entity.get厚労省IF識別コード()), entity.get要介護状態区分コード());
            csvEntity.set要介護度(iYokaigoJotaiKubun.getName());
        }
        if (申請理由区分_世帯非課税８０万以下.equals(entity.get今回認定結果().getShinseiRiyuKubun())) {
            csvEntity.set申請負担段階(申請負担段階_2);
        } else if (申請理由区分_世帯非課税８０万超.equals(entity.get今回認定結果().getShinseiRiyuKubun())) {
            csvEntity.set申請負担段階(申請負担段階_3);
        } else if (申請理由区分_生保.equals(entity.get今回認定結果().getShinseiRiyuKubun())) {
            csvEntity.set申請負担段階(申請負担段階_1);
        } else if (申請理由区分_世帯非課税.equals(entity.get今回認定結果().getShinseiRiyuKubun())) {
            csvEntity.set申請負担段階(RString.EMPTY);
        } else if (申請理由区分_老齢.equals(entity.get今回認定結果().getShinseiRiyuKubun())) {
            csvEntity.set申請負担段階(申請負担段階_1);
        } else if (申請理由区分_特例減額措置.equals(entity.get今回認定結果().getShinseiRiyuKubun())) {
            csvEntity.set申請負担段階(申請負担段階_特例減額措置);
        } else {
            csvEntity.set申請負担段階(申請負担段階_その他);
        }
        if (entity.is旧措置()) {
            csvEntity.set旧措置(星);
        } else {
            csvEntity.set旧措置(RString.EMPTY);
        }
        if (Boolean.valueOf(entity.get利用軽減().toString())) {
            csvEntity.set利(申);
        } else if (entity.get利用軽減().isEmpty()) {
            csvEntity.set利(RString.EMPTY);
        } else {
            csvEntity.set利(認);
        }
        if (Boolean.valueOf(entity.get社福軽減().toString())) {
            csvEntity.set社(申);
        } else if (entity.get社福軽減().isEmpty()) {
            csvEntity.set社(RString.EMPTY);
        } else {
            csvEntity.set社(認);
        }
        if (Boolean.valueOf(entity.get訪問減額().toString())) {
            csvEntity.set対(申);
        } else if (entity.get訪問減額().isEmpty()) {
            csvEntity.set対(RString.EMPTY);
        } else {
            csvEntity.set対(認);
        }
        if (Boolean.valueOf(entity.get特地減免().toString())) {
            csvEntity.set地(申);
        } else if (entity.get特地減免().isEmpty()) {
            csvEntity.set地(RString.EMPTY);
        } else {
            csvEntity.set地(認);
        }
        if (entity.is生活保護受給者()) {
            csvEntity.set生保(星);
        } else {
            csvEntity.set生保(RString.EMPTY);
        }
        if (entity.is老齢福祉年金受給者()) {
            csvEntity.set老齡(星);
        } else {
            csvEntity.set老齡(RString.EMPTY);
        }
        csvEntity.set合計所得_含年金収入(DecimalFormatter.toRString(nullToZero(entity.get合計所得金額()), 0));
        csvEntity.set空白(RString.EMPTY);
        RString 世帯課税 = entity.get世帯課税区分();
        RString 世帯課税名称 = RString.EMPTY;
        if (null != 世帯課税 && !世帯課税.isEmpty()) {
            世帯課税名称 = SetaiKazeiKubun.toValue(世帯課税).get名称();
        }
        csvEntity.set世帯課税(世帯課税名称);
        if (entity.get今回認定結果().getHaigushaUmuFlag()) {
            csvEntity.set配偶者有無(星);
        } else {
            csvEntity.set配偶者有無(RString.EMPTY);
        }
        if (entity.get今回認定結果().getHaigushaShikibetsuCd() != null) {
            csvEntity.set配偶者識別コード(entity.get今回認定結果().getHaigushaShikibetsuCd().value());
        }
        if (entity.get今回認定結果().getHaigushaShimei() != null) {
            csvEntity.set配偶者氏名(entity.get今回認定結果().getHaigushaShimei().value());
        }
        RString 配偶者課税区分 = entity.get今回認定結果().getHaigushaKazeiKubun();
        RString 配偶者課税区分名称 = RString.EMPTY;
        if (null != 配偶者課税区分 && !配偶者課税区分.isEmpty()) {
            配偶者課税区分名称 = HaigushaKazeiKubun.toValue(配偶者課税区分).get名称();
        }
        csvEntity.set配偶者課税区分(配偶者課税区分名称);
        csvEntity.set預貯金額(DecimalFormatter.toRString(nullToZero(entity.get今回認定結果().getYochokinGaku()), 0));
        csvEntity.set有価証券評価概算額(DecimalFormatter.toRString(nullToZero(entity.get今回認定結果().getYukashoukenGaisangaku()), 0));
        csvEntity.setその他金額(DecimalFormatter.toRString(nullToZero(entity.get今回認定結果().getSonotaKingaku()), 0));
        csvEntity.set預貯金等合計(DecimalFormatter.toRString(nullToZero(entity.get今回認定結果().getYochokinGaku())
                .add(nullToZero(entity.get今回認定結果().getYukashoukenGaisangaku()))
                .add(nullToZero(entity.get今回認定結果().getSonotaKingaku())), 0));
        if (entity.getAtesakiEntity() != null && entity.getAtesakiEntity().getTorokuIdoYMD() != null
                && !entity.getAtesakiEntity().getTorokuIdoYMD().isEmpty()) {
            csvEntity.set住民となった日(entity.getAtesakiEntity().getTorokuIdoYMD()
                    .seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        if (住所地特例フラグ_1.equals(entity.get住所地特例フラグ())) {
            csvEntity.set住所地特例該当(星);
        } else {
            csvEntity.set住所地特例該当(RString.EMPTY);
        }
        csvEntity.set非課税年金有(RString.EMPTY);
        if (entity.get今回認定結果().getIzokuNenkinJukyuFlag() || entity.get今回認定結果().getShogaiNenkinJukyuFlag()) {
            csvEntity.set非課税年金自己申告有(星);
        } else {
            csvEntity.set非課税年金自己申告有(RString.EMPTY);
        }
        csvEntity.set激変緩和(RString.EMPTY);

    }

    private void 今回と前回情報設定(FutanGengaokuNintteiKakuninListCsvEntity csvEntity,
            FutanGengaokuNintteiKakuninListEntity entity) {
        if (entity.get今回認定結果().getShinseiYMD() != null && !entity.get今回認定結果().getShinseiYMD().isEmpty()) {
            csvEntity.set今回_申請年月日(entity.get今回認定結果().getShinseiYMD().seireki().toDateString());
        }
        if (entity.get今回認定結果().getKetteiYMD() != null && !entity.get今回認定結果().getKetteiYMD().isEmpty()) {
            csvEntity.set今回_決定年月日(entity.get今回認定結果().getKetteiYMD().seireki().toDateString());
        }
        if (KetteiKubun.承認する.getコード().endsWith(entity.get今回認定結果().getKetteiKubun())) {
            csvEntity.set今回_決定区分(決定区分_承認);
        } else if (KetteiKubun.承認しない.getコード().endsWith(entity.get今回認定結果().getKetteiKubun())) {
            csvEntity.set今回_決定区分(決定区分_却下);
        } else {
            csvEntity.set今回_決定区分(RString.EMPTY);
        }
        if (entity.get今回認定結果().getTekiyoKaishiYMD() != null && !entity.get今回認定結果().getTekiyoKaishiYMD().isEmpty()) {
            csvEntity.set今回_適用日(entity.get今回認定結果().getTekiyoKaishiYMD().seireki().toDateString());
        }
        if (entity.get今回認定結果().getTekiyoShuryoYMD() != null && !entity.get今回認定結果().getTekiyoShuryoYMD().isEmpty()) {
            csvEntity.set今回_有効期限(entity.get今回認定結果().getTekiyoShuryoYMD().seireki().toDateString());
        }
        csvEntity.set今回_旧措置(entity.get今回認定結果().getKyusochishaKubun());
        if (entity.get前回認定結果() != null
                && !entity.get今回認定結果().getRiyoshaFutanDankai().equals(entity.get前回認定結果().getRiyoshaFutanDankai())) {
            csvEntity.set今回_前回との比較(星);
        } else {
            csvEntity.set今回_前回との比較(RString.EMPTY);
        }
        csvEntity.set今回_負担段階(entity.get今回認定結果().getRiyoshaFutanDankai());
        csvEntity.set今回_食費負担額(DecimalFormatter.toRString(nullToZero(entity.get今回認定結果().getShokuhiFutanGendogaku()), 0));
        csvEntity.set今回_ユニット個(DecimalFormatter.toRString(nullToZero(entity.get今回認定結果().getUnitTypeKoshitsu()), 0));
        csvEntity.set今回_ユニット準(DecimalFormatter.toRString(nullToZero(entity.get今回認定結果().getUnitTypeJunKoshitsu()), 0));
        csvEntity.set今回_従来型特養(DecimalFormatter.toRString(nullToZero(entity.get今回認定結果().getJuraiTypeKoshitsu_Tokuyo()), 0));
        csvEntity.set今回_従来型老健(DecimalFormatter.toRString(nullToZero(entity.get今回認定結果().getJuraiTypeKoshitsu_Roken_Ryoyo()), 0));
        csvEntity.set今回_多床室(DecimalFormatter.toRString(nullToZero(entity.get今回認定結果().getTashoshitsu()), 0));
        if (RiyoshaFutanDankai.第三段階.getコード().equals(entity.get今回認定結果().getRiyoshaFutanDankai())) {
            csvEntity.set今回_特例減額(該当);
        } else {
            csvEntity.set今回_特例減額(非該当);
        }
        if (entity.get前回認定結果() != null) {

            if (entity.get前回認定結果().getShinseiYMD() != null && !entity.get前回認定結果().getShinseiYMD().isEmpty()) {
                csvEntity.set前回_申請年月日(entity.get前回認定結果().getShinseiYMD().seireki().toDateString());
            }
            if (entity.get前回認定結果().getKetteiYMD() != null && !entity.get前回認定結果().getKetteiYMD().isEmpty()) {
                csvEntity.set前回_決定年月日(entity.get前回認定結果().getKetteiYMD().seireki().toDateString());
            }
            if (KetteiKubun.承認する.getコード().endsWith(entity.get前回認定結果().getKetteiKubun())) {
                csvEntity.set前回_決定区分(決定区分_承認);
            } else if (KetteiKubun.承認しない.getコード().endsWith(entity.get前回認定結果().getKetteiKubun())) {
                csvEntity.set前回_決定区分(決定区分_却下);
            } else {
                csvEntity.set前回_決定区分(RString.EMPTY);
            }
            if (entity.get前回認定結果().getTekiyoKaishiYMD() != null && !entity.get前回認定結果().getTekiyoKaishiYMD().isEmpty()) {
                csvEntity.set前回_適用日(entity.get前回認定結果().getTekiyoKaishiYMD().seireki().toDateString());
            }
            if (entity.get前回認定結果().getTekiyoShuryoYMD() != null && !entity.get前回認定結果().getTekiyoShuryoYMD().isEmpty()) {
                csvEntity.set前回_有効期限(entity.get前回認定結果().getTekiyoShuryoYMD().seireki().toDateString());
            }
            csvEntity.set前回_旧措置(entity.get前回認定結果().getKyusochishaKubun());
            csvEntity.set前回_負担段階(entity.get前回認定結果().getRiyoshaFutanDankai());
            csvEntity.set前回_食費負担額(DecimalFormatter.toRString(nullToZero(entity.get前回認定結果().getShokuhiFutanGendogaku()), 0));
            csvEntity.set前回_ユニット個(DecimalFormatter.toRString(nullToZero(entity.get前回認定結果().getUnitTypeKoshitsu()), 0));
            csvEntity.set前回_ユニット準(DecimalFormatter.toRString(nullToZero(entity.get前回認定結果().getUnitTypeJunKoshitsu()), 0));
            csvEntity.set前回_従来型特養(DecimalFormatter.toRString(nullToZero(entity.get前回認定結果().getJuraiTypeKoshitsu_Tokuyo()), 0));
            csvEntity.set前回_従来型老健(DecimalFormatter.toRString(nullToZero(entity.get前回認定結果().getJuraiTypeKoshitsu_Roken_Ryoyo()), 0));
            csvEntity.set前回_多床室(DecimalFormatter.toRString(nullToZero(entity.get前回認定結果().getTashoshitsu()), 0));
            if (RiyoshaFutanDankai.第三段階.getコード().equals(entity.get前回認定結果().getRiyoshaFutanDankai())) {
                csvEntity.set前回_特例減額(該当);
            } else {
                csvEntity.set前回_特例減額(非該当);
            }
        }
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        outputJokenhyoFactory();
    }

    private void set改頁Key(IOutputOrder outputOrder, List<RString> pageBreakKeys) {
        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;
        if (outputOrder != null) {
            List<ISetSortItem> list = outputOrder.get設定項目リスト();
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list.size() > NO_0 && list.get(NO_0).is改頁項目()) {
                改頁１ = to帳票物理名(list.get(0).get項目ID());
            }
            if (list.size() > NO_1 && list.get(NO_1).is改頁項目()) {
                改頁２ = to帳票物理名(list.get(NO_1).get項目ID());
            }
            if (list.size() > NO_2 && list.get(NO_2).is改頁項目()) {
                改頁３ = to帳票物理名(list.get(NO_2).get項目ID());
            }
            if (list.size() > NO_3 && list.get(NO_3).is改頁項目()) {
                改頁４ = to帳票物理名(list.get(NO_3).get項目ID());
            }
            if (list.size() > NO_4 && list.get(NO_4).is改頁項目()) {
                改頁５ = to帳票物理名(list.get(NO_4).get項目ID());
            }

            if (!改頁１.isEmpty()) {
                pageBreakKeys.add(改頁１);
            }
            if (!改頁２.isEmpty()) {
                pageBreakKeys.add(改頁２);
            }
            if (!改頁３.isEmpty()) {
                pageBreakKeys.add(改頁３);
            }
            if (!改頁４.isEmpty()) {
                pageBreakKeys.add(改頁４);
            }
            if (!改頁５.isEmpty()) {
                pageBreakKeys.add(改頁５);
            }
        }
    }

    private RString to帳票物理名(RString 項目ID) {

        RString 帳票物理名 = RString.EMPTY;
        if (FutanGendogakuOrderKey.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("hokenshaNo");
        } else if (FutanGendogakuOrderKey.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("list1_1");
        }
        return 帳票物理名;
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBD.DBD200005.getReportId().getColumnValue(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD200005.getReportName(),
                new RString(batchReportWriter.getPageCount()),
                new RString("あり"),
                new RString("DBD200005_FutanGendogakuNinteiKakuninIchiran.rse"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(作成年度.concat(parameter.get作成年度().wareki().toDateString()));
        出力条件.add(認定期間_開始日.concat(parameter.get認定期間_開始日().wareki().toDateString()));
        出力条件.add(認定期間_終了日.concat(parameter.get認定期間_終了日().wareki().toDateString()));
        出力条件.add(決定日.concat(parameter.get決定日().wareki().toDateString()));
        出力条件.add(申請日開始.concat(parameter.get申請日開始().wareki().toDateString()));
        出力条件.add(申請日終了.concat(parameter.get申請日終了().wareki().toDateString()));
        if (parameter.is非課税時_承認しないフラグ()) {
            出力条件.add(非課税時_承認しないフラグ.concat(TRUE));
        } else {
            出力条件.add(非課税時_承認しないフラグ.concat(FALSE));
        }
        出力条件.add(非課税時_承認しない理由.concat(parameter.get非課税時_承認しない理由()));
        if (parameter.is配偶者課税時_承認しないフラグ()) {
            出力条件.add(配偶者課税時_承認しないフラグ.concat(TRUE));
        } else {
            出力条件.add(配偶者課税時_承認しないフラグ.concat(FALSE));
        }
        出力条件.add(配偶者課税時_承認しない理由.concat(parameter.get配偶者課税時_承認しない理由()));
        if (parameter.is預貯金等超過時_承認しないフラグ()) {
            出力条件.add(預貯金等超過時_承認しないフラグ.concat(TRUE));
        } else {
            出力条件.add(預貯金等超過時_承認しないフラグ.concat(FALSE));
        }
        出力条件.add(預貯金等超過時_理由.concat(parameter.get預貯金等超過時_理由()));
        if (parameter.isテスト処理()) {
            出力条件.add(テスト処理.concat(TRUE));
        } else {
            出力条件.add(テスト処理.concat(FALSE));
        }
        if (parameter.is確認リスト出力()) {
            出力条件.add(確認リスト出力.concat(TRUE));
        } else {
            出力条件.add(確認リスト出力.concat(FALSE));
        }
        出力条件.add(発行日.concat(parameter.get発行日().wareki().toDateString()));
        出力条件.add(改頁出力順ID.concat(parameter.get改頁出力順ID()));
        出力条件.add(帳票ID.concat(parameter.get帳票ID()));
        出力条件.add(負担限度額認定申請承認一括.concat(出力順));
        return 出力条件;
    }

    private Decimal nullToZero(Decimal 金額) {
        return 金額 == null ? Decimal.ZERO : 金額;
    }
}
