/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd492001.RendingJieguoLianxieProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ErrorRecord;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.OutFile;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.OutFilekekka;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ShinchokuNoTorikomiRisutoFairuCSVEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.TorikomiErarisutofairuCSVEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.FairudetaIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.JinbunoQurirumirisutofairuYishiteburuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.YokaigoninteiIntafesumasutaEntity;
import jp.co.ndensan.reams.db.dbd.service.core.dbd492001.NinteiKekkaRenkeiDataTorikomiManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.EucFileOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 出力ファイルリストを作成_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class ShutsuryokuFairuRisutooSakuseiProcess extends BatchProcessBase<OutFile> {

    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    private final RString 進捗の取込みリストファイル = new RString("進捗の取込みリストファイル");
    private final RString 進捗の取込みエラーリストファイル = new RString("進捗の取込みエラーリストファイル");
    private final RString 結果の取込みリストファイル = new RString("結果の取込みリストファイル");
    private final RString 結果の取込みエラーリストファイル = new RString("結果の取込みエラーリストファイル");
    private final RString 英数字_進捗の取込みリストファイル = new RString("SinchokuNoTorikomiList.CSV");
    private final RString 英数字_進捗の取込みエラーリストファイル = new RString("SinchokuNoTorikomiErrList.CSV");
    private final RString 英数字_結果の取込みリストファイル = new RString("KekkaNoTorikomiList.CSV");
    private final RString 英数字_結果の取込みエラーリストファイル = new RString("KekkaNoTorikomiErrList.CSV");

    private List<PersonalData> personalDataList;
    private FileSpoolManager manager;

    private static final RString 一時デーブル_日次進捗 = new RString("日次進捗");
    private static final RString 一時デーブル_認定結果 = new RString("認定結果");

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "yokaigoninteikekkarenkeidetatorikomi.IShutsuryokuFairuRisutooSakuseiMapper.get出力ファイルリスト");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter_1;
    private BatchEntityCreatedTempTableWriter tmpTableWriter_2;
    private BatchEntityCreatedTempTableWriter tmpTableWriter_3;

    private CsvWriter<ShinchokuNoTorikomiRisutoFairuCSVEntity> eucCsvWriter_1;
    private CsvWriter<TorikomiErarisutofairuCSVEntity> eucCsvWriter_2;

    private RendingJieguoLianxieProcessParameter processParameter;

    private RString eucFilePath_1;
    private RString eucFilePath_2;

    private RString eucFilePath;

    private Association association;

    private YMDHMS systemTime;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        systemTime = YMDHMS.now();
    }

    @Override
    protected void createWriter() {
        tmpTableWriter_1 = BatchEntityCreatedTempTableWriterBuilders.createBuilder(JinbunoQurirumirisutofairuYishiteburuEntity.class)
                .tempTableName(JinbunoQurirumirisutofairuYishiteburuEntity.TABLE_NAME)
                .build();
//        tmpTableWriter_2 = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ErarisutofairuIchijiTeburuEntity.class)
//                .tempTableName(ErarisutofairuIchijiTeburuEntity.TABLE_NAME)
//                .build();
        tmpTableWriter_3 = BatchEntityCreatedTempTableWriterBuilders.createBuilder(YokaigoninteiIntafesumasutaEntity.class)
                .tempTableName(YokaigoninteiIntafesumasutaEntity.TABLE_NAME)
                .build();

        if (一時デーブル_日次進捗.equals(processParameter.get取込みデータ区分())) {
            eucFilePath_1 = Path.combinePath(new RString("SinchokuNoTorikomiList.CSV"));
            eucFilePath_2 = Path.combinePath(new RString("SinchokuNoTorikomiErrList.CSV"));
        } else if (一時デーブル_認定結果.equals(processParameter.get取込みデータ区分())) {
            eucFilePath_1 = Path.combinePath(new RString("KekkaNoTorikomiList.CSV"));
            eucFilePath_2 = Path.combinePath(new RString("KekkaNoTorikomiErrList.CSV"));
        }
        eucCsvWriter_1 = new CsvWriter.InstanceBuilder(eucFilePath_1).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                build();
        eucCsvWriter_2 = new CsvWriter.InstanceBuilder(eucFilePath_2).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                build();
    }

    @Override
    protected void process(OutFile outFile) {
        ファイル出力用データの編集(outFile);
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(eucFilePath, log);
    }

    private void ファイル出力用データの編集(OutFile t) {
        ErrorRecord error = new ErrorRecord();
        FairudetaIchijiTeburuEntity fairudetaEntity = new FairudetaIchijiTeburuEntity();
        OutFilekekka out = new OutFilekekka();
        if (一時デーブル_日次進捗.equals(processParameter.get取込みデータ区分())) {
            NinteiKekkaRenkeiDataTorikomiManager.createInstance().項目設定(t, out);
            JinbunoQurirumirisutofairuYishiteburuEntity jinbunoEntity = create出力ファイルのデータ編集(out);
            tmpTableWriter_1.insert(jinbunoEntity);
//            ErarisutofairuIchijiTeburuEntity erarEntity = createエラーリストファイルデータの編集(error);
//            tmpTableWriter_2.insert(erarEntity);
            YokaigoninteiIntafesumasutaEntity yoKaigonEntity = create要介護認定インターフェースマスタル(fairudetaEntity);
            tmpTableWriter_3.insert(yoKaigonEntity);

            ShinchokuNoTorikomiRisutoFairuCSVEntity csventity = new ShinchokuNoTorikomiRisutoFairuCSVEntity();
            ファイル出力進捗の取込みリストファイル(csventity, jinbunoEntity);
            eucCsvWriter_1.writeLine(csventity);
            TorikomiErarisutofairuCSVEntity csvEntity = new TorikomiErarisutofairuCSVEntity();
//            ファイル出力進捗の取込みエラーリストファイル(csvEntity, erarEntity);
            eucCsvWriter_2.writeLine(csvEntity);
        } else if (一時デーブル_認定結果.equals(processParameter.get取込みデータ区分())) {
            NinteiKekkaRenkeiDataTorikomiManager.createInstance().項目設定(t, out);
            JinbunoQurirumirisutofairuYishiteburuEntity jinbunoEntity = create出力ファイルのデータ編集(out);
            tmpTableWriter_1.insert(jinbunoEntity);
//            ErarisutofairuIchijiTeburuEntity erarEntity = createエラーリストファイルデータの編集(error);
//            tmpTableWriter_2.insert(erarEntity);
            YokaigoninteiIntafesumasutaEntity yoKaigonEntity = create要介護認定インターフェースマスタル(fairudetaEntity);
            tmpTableWriter_3.insert(yoKaigonEntity);

            ShinchokuNoTorikomiRisutoFairuCSVEntity csventity = new ShinchokuNoTorikomiRisutoFairuCSVEntity();
            ファイル出力進捗の取込みリストファイル(csventity, jinbunoEntity);
            eucCsvWriter_1.writeLine(csventity);
            TorikomiErarisutofairuCSVEntity csvEntity = new TorikomiErarisutofairuCSVEntity();
//            ファイル出力進捗の取込みエラーリストファイル(csvEntity, erarEntity);
            eucCsvWriter_2.writeLine(csvEntity);
            personalDataList.add(toPersonalData(t));
        }
    }

    private JinbunoQurirumirisutofairuYishiteburuEntity create出力ファイルのデータ編集(OutFilekekka kekka) {
        JinbunoQurirumirisutofairuYishiteburuEntity entity = new JinbunoQurirumirisutofairuYishiteburuEntity();
        entity.setShikibetsukodo(kekka.get識別コード());
        entity.setShikibetsukodo_meisho(kekka.get識別コード名称());
        entity.setHokenshabango(kekka.get保険者番号());
        entity.setHihokenjabango(kekka.get被保険者番号());
        entity.setNinteishinseibi(kekka.get認定申請日());
        entity.setEdaban(kekka.get枝番());
        entity.setShinseikubunhorei(kekka.get申請区分_法令_コード());
        entity.setShinseikubunhorei_meisho(kekka.get申請区分_法令_コード名称());
        entity.setShinseikubunshinseiji(kekka.get申請区分_申請時_コード());
        entity.setShinseikubunshinseiji_meisho(kekka.get申請区分_申請時_コード名称());
        entity.setTorisakubunkodo(kekka.get取下区分コード());
        entity.setTorisakubunkodo_meisho(kekka.get取下区分コード名称());
        entity.setHihokenjakubun(kekka.get被保険者区分コード());
        entity.setHihokenjakubun_meisho(kekka.get被保険者区分コード名称());
        entity.setShinseidaikokubun(kekka.get申請代行区分コード());
        entity.setShinseidaikokubun_meisho(kekka.get申請代行区分コード名称());
        entity.setSeinengappi(kekka.get生年月日());
        entity.setNenrei(kekka.get年齢());
        entity.setSeibetsukodo(kekka.get性別コード());
        entity.setSeibetsukodo_meisho(kekka.get性別コード名称());
        entity.setHihokenjakanashimei(kekka.get被保険者ｶﾅ氏名());
        entity.setHihokenjakanjishimei(kekka.get被保険者漢字氏名());
        entity.setYubenbango(kekka.get郵便番号());
        entity.setJusho(kekka.get住所());
        entity.setTenwabango(kekka.get電話番号());
        entity.setByoinshisetsutonomeisho(kekka.get病院施設等の名称());
        entity.setByoinshisetsutonoshozaichi(kekka.get病院施設等の所在地());
        entity.setZenkainoninteishinsakaikekka(kekka.get前回の認定審査会結果());
        entity.setZenkainoninteishinsakaikekka_meisho(kekka.get前回の認定審査会結果名称());
        entity.setZenkainoninteiyukokigenkaishi(kekka.get前回の認定有効期間_開始());
        entity.setZenkainoninteiyukokigenshuryo(kekka.get前回の認定有効期間_終了());
        entity.setShujiiiryokikanbango(kekka.get主治医医療機関番号());
        entity.setShujiibango(kekka.get主治医番号());
        entity.setLkenshoiraibi(kekka.get意見書依頼日());
        entity.setLkenshonyushubi(kekka.get意見書入手日());
        entity.setLkensho_tankikioku(kekka.get意見書_短期記憶());
        entity.setLkensho_ninchinoryoku(kekka.get意見書_認知能力());
        entity.setLkensho_dentatsunoryoku(kekka.get意見書_伝達能力());
        entity.setLkensho_shokujikoi(kekka.get意見書_食事行為());
        entity.setLkensho_ninshishokoreishajiritsudo(kekka.get意見書_認知症高齢者の日常生活自立度());
        entity.setChosairaibi(kekka.get調査依頼日());
        entity.setChosajisshibi(kekka.get調査実施日());
        entity.setShiteikyotakukaigoshienjigyoshatobango(kekka.get指定居宅介護支援事業者等番号());
        entity.setLtakukubun(kekka.get委託区分());
        entity.setLtakukubun_meisho(kekka.get委託区分名称());
        entity.setNinteichosainbango(kekka.get認定調査員番号());
        entity.setNinteichosainshikakukodo(kekka.get認定調査員資格コード());
        entity.setNinteichosainshikakukodo_meisho(kekka.get認定調査員資格コード名称());
        entity.setLchijihanteibi(kekka.get一次判定日());
        entity.setLchijihanteikekka(kekka.get一次判定結果());
        entity.setLchijihanteikekka_meisho(kekka.get一次判定結果名称());
        entity.setLchijihanteikekka_ninshishokasan(kekka.get一次判定結果_認知症加算());
        entity.setLchijihanteikekka_ninshishokasan_meisho(kekka.get一次判定結果_認知症加算_名称());
        entity.setNinteishinsakaishiryosakuseibi(kekka.get認定審査会資料作成日());
        entity.setNinteishinsakaiyoteibi(kekka.get認定審査会予定日());
        entity.setGogitaibango(kekka.get合議体番号());
        entity.setShinsakaishiryobango(kekka.get審査会資料番号());
        entity.setNijihanteibi(kekka.get二次判定日());
        entity.setNijihanteikekka(kekka.get二次判定結果());
        entity.setNijihanteikekka_meisho(kekka.get二次判定結果名称());
        entity.setNinteiyukokigen_kaishi(kekka.get認定有効期間_開始());
        entity.setNinteiyukokigen_shuryo(kekka.get認定有効期間_終了());
        entity.setTokuteishippeikodo(kekka.get特定疾病コード());
        entity.setTokuteishippeikodo_meisho(kekka.get特定疾病コード名称());
        entity.setYokaigo1nobaainojotaizo(kekka.get要介護1の場合の状態像());
        entity.setYokaigo1nobaainojotaizo_meisho(kekka.get要介護1の場合の状態像名称());
        entity.setGenzainosabisukubunkodo(kekka.get現在のサービス区分コード());
        entity.setGenzainosabisukubunkodo_meisho(kekka.get現在のサービス区分コード名称());
        entity.setGenzainojokyo(kekka.get現在の状況());
        entity.setGenzainojokyo_meisho(kekka.get現在の状況名称());
        return entity;
    }

//    private ErarisutofairuIchijiTeburuEntity createエラーリストファイルデータの編集(ErrorRecord error) {
//        ErarisutofairuIchijiTeburuEntity entity = new ErarisutofairuIchijiTeburuEntity();
//        entity.setShikibetsukodo(error.getShikibetsukodo());
//        entity.setHokenshabango(error.getHokenshabango());
//        entity.setHihokenjabango(error.getHihokenjabango());
//        entity.setNinteishinseibi(error.getNinteishinseibi());
//        entity.setEdaban(error.getEdaban());
//        entity.setShinseikubunhorei(error.getShinseikubunhorei());
//        entity.setShinseikubunshinseiji(error.getShinseikubunshinseiji());
//        entity.setTorisakubunkodo(error.getTorisakubunkodo());
//        entity.setHihokenjakubun(error.getHihokenjakubun());
//        entity.setShinseidaikokubun(error.getShinseidaikokubun());
//        entity.setSeinengappi(error.getSeinengappi());
//        entity.setNenrei(error.getNenrei());
//        entity.setSeibetsukodo(error.getSeibetsukodo());
//        entity.setHihokenjakanashimei(error.getHihokenjakanashimei());
//        entity.setHihokenjakanjishimei(error.getHihokenjakanjishimei());
//        entity.setYubenbango(error.getYubenbango());
//        entity.setJusho(error.getJusho());
//        entity.setTenwabango(error.getTenwabango());
//        entity.setByoinshisetsutonomeisho(error.getByoinshisetsutonomeisho());
//        entity.setByoinshisetsutonoshozaichi(error.getByoinshisetsutonoshozaichi());
//        entity.setEramesseji(error.getEramesseji());
//        return entity;
//    }
    private void ファイル出力進捗の取込みリストファイル(ShinchokuNoTorikomiRisutoFairuCSVEntity csventity, JinbunoQurirumirisutofairuYishiteburuEntity entity) {
        csventity.set識別コード(entity.getShikibetsukodo());
        csventity.set識別コード名称(entity.getShikibetsukodo_meisho());
        csventity.set保険者番号(entity.getHokenshabango());
        csventity.set被保険者番号(entity.getHihokenjabango());
        csventity.set認定申請日(new RString(entity.getNinteishinseibi().toString()));
        csventity.set枝番(entity.getEdaban());
        csventity.set申請区分_法令_コード(entity.getShinseikubunhorei());
        csventity.set申請区分_法令_コード名称(entity.getShinseikubunhorei_meisho());
        csventity.set申請区分_申請時_コード(entity.getShinseikubunshinseiji());
        csventity.set申請区分_申請時_コード名称(entity.getShinseikubunshinseiji_meisho());
        csventity.set取下区分コード(entity.getTorisakubunkodo());
        csventity.set取下区分コード名称(entity.getTorisakubunkodo_meisho());
        csventity.set被保険者区分コード(entity.getHihokenjakubun());
        csventity.set被保険者区分コード名称(entity.getHihokenjakubun_meisho());
        csventity.set申請代行区分コード(entity.getShinseidaikokubun());
        csventity.set申請代行区分コード名称(entity.getShinseidaikokubun_meisho());
        csventity.set生年月日(new RString(entity.getSeinengappi().toString()));
        csventity.set年齢(entity.getNenrei());
        csventity.set性別コード(entity.getSeibetsukodo());
        csventity.set性別コード名称(entity.getSeibetsukodo_meisho());
        csventity.set被保険者ｶﾅ氏名(entity.getHihokenjakanashimei());
        csventity.set被保険者漢字氏名(entity.getHihokenjakanjishimei());
        csventity.set郵便番号(entity.getYubenbango().value());
        csventity.set住所(entity.getJusho());
        csventity.set電話番号(entity.getTenwabango().value());
        csventity.set病院施設等の名称(entity.getByoinshisetsutonomeisho());
        csventity.set病院施設等の所在地(entity.getByoinshisetsutonoshozaichi());
        csventity.set前回の認定審査会結果(entity.getZenkainoninteishinsakaikekka());
        csventity.set前回の認定審査会結果名称(entity.getZenkainoninteishinsakaikekka_meisho());
        csventity.set前回の認定有効期間_開始(new RString(entity.getZenkainoninteiyukokigenkaishi().toString()));
        csventity.set前回の認定有効期間_終了(new RString(entity.getZenkainoninteiyukokigenshuryo().toString()));
        csventity.set主治医医療機関番号(entity.getShujiiiryokikanbango());
        csventity.set主治医番号(entity.getShujiibango());
        csventity.set意見書依頼日(new RString(entity.getLkenshoiraibi().toString()));
        csventity.set意見書入手日(new RString(entity.getLkenshonyushubi().toString()));
        csventity.set意見書_短期記憶(entity.getLkensho_tankikioku());
        csventity.set意見書_認知能力(entity.getLkensho_ninchinoryoku());
        csventity.set意見書_伝達能力(entity.getLkensho_dentatsunoryoku());
        csventity.set意見書_食事行為(entity.getLkensho_shokujikoi());
        csventity.set意見書_認知症高齢者の日常生活自立度(entity.getLkensho_ninshishokoreishajiritsudo());
        csventity.set調査依頼日(new RString(entity.getChosairaibi().toString()));
        csventity.set調査実施日(new RString(entity.getChosajisshibi().toString()));
        csventity.set指定居宅介護支援事業者等番号(entity.getShiteikyotakukaigoshienjigyoshatobango());
        csventity.set委託区分(entity.getLtakukubun());
        csventity.set委託区分名称(entity.getLtakukubun_meisho());
        csventity.set認定調査員番号(entity.getNinteichosainbango());
        csventity.set認定調査員資格コード(entity.getNinteichosainshikakukodo());
        csventity.set認定調査員資格コード名称(entity.getNinteichosainshikakukodo_meisho());
        csventity.set一次判定日(new RString(entity.getLchijihanteibi().toString()));
        csventity.set一次判定結果(entity.getLchijihanteikekka());
        csventity.set一次判定結果名称(entity.getLchijihanteikekka_meisho());
        csventity.set一次判定結果_認知症加算(entity.getLchijihanteikekka_ninshishokasan());
        csventity.set一次判定結果_認知症加算_名称(entity.getLchijihanteikekka_ninshishokasan_meisho());
        csventity.set認定審査会資料作成日(new RString(entity.getNinteishinsakaishiryosakuseibi().toString()));
        csventity.set認定審査会予定日(new RString(entity.getNinteishinsakaiyoteibi().toString()));
        csventity.set合議体番号(entity.getGogitaibango());
        csventity.set審査会資料番号(entity.getShinsakaishiryobango());
        csventity.set二次判定日(new RString(entity.getNijihanteibi().toString()));
        csventity.set二次判定結果(entity.getNijihanteikekka());
        csventity.set二次判定結果名称(entity.getNijihanteikekka_meisho());
        csventity.set認定有効期間_開始(new RString(entity.getNinteiyukokigen_kaishi().toString()));
        csventity.set認定有効期間_終了(new RString(entity.getNinteiyukokigen_shuryo().toString()));
        csventity.set特定疾病コード(entity.getTokuteishippeikodo());
        csventity.set特定疾病コード名称(entity.getTokuteishippeikodo_meisho());
        csventity.set要介護１の場合の状態像(entity.getYokaigo1nobaainojotaizo());
        csventity.set要介護１の場合の状態像名称(entity.getYokaigo1nobaainojotaizo_meisho());
        csventity.set現在のサービス区分コード(entity.getGenzainosabisukubunkodo());
        csventity.set現在のサービス区分コード名称(entity.getGenzainosabisukubunkodo_meisho());
        csventity.set現在の状況(entity.getGenzainojokyo());
        csventity.set現在の状況名称(entity.getGenzainojokyo_meisho());

    }

//    private void ファイル出力進捗の取込みエラーリストファイル(TorikomiErarisutofairuCSVEntity csventity, ErarisutofairuIchijiTeburuEntity entity) {
//        csventity.set識別コード(entity.getShikibetsukodo().value());
//        csventity.set保険者番号(entity.getHokenshabango());
//        csventity.set被保険者番号(entity.getHihokenjabango());
//        csventity.set認定申請日(new RString(entity.getNinteishinseibi().toString()));
//        csventity.set枝番(entity.getEdaban());
//        csventity.set申請区分_法令_コード(entity.getShinseikubunhorei().value());
//        csventity.set申請区分_申請時_コード(entity.getShinseikubunshinseiji().value());
//        csventity.set取下区分コード(entity.getTorisakubunkodo().value());
//        csventity.set被保険者区分コード(entity.getHihokenjakubun().value());
//        csventity.set申請代行区分コード(entity.getShinseidaikokubun().value());
//        csventity.set生年月日(new RString(entity.getSeinengappi().toString()));
//        csventity.set年齢(new RString(entity.getNenrei()));
//        csventity.set性別コード(entity.getSeibetsukodo().value());
//        csventity.set被保険者ｶﾅ氏名(entity.getHihokenjakanashimei().value());
//        csventity.set被保険者漢字氏名(entity.getHihokenjakanjishimei().value());
//        csventity.set郵便番号(entity.getYubenbango().value());
//        csventity.set住所(entity.getJusho().value());
//        csventity.set電話番号(entity.getTenwabango().value());
//        csventity.set病院施設等の名称(entity.getByoinshisetsutonomeisho());
//        csventity.set病院施設等の所在地(entity.getByoinshisetsutonoshozaichi());
//        csventity.setエラーメッセージ(entity.getEramesseji());
//    }
    @Override
    protected void afterExecute() {
        eucCsvWriter_1.close();
        eucCsvWriter_2.close();
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString eUCエンティティID = new RString("-");
        RString 出力件数_1 = new RString(String.valueOf(eucCsvWriter_1.getCount()));
        RString 出力件数_2 = new RString(String.valueOf(eucCsvWriter_2.getCount()));
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(processParameter.get保険者());

        if (一時デーブル_日次進捗.equals(processParameter.get取込みデータ区分())) {
            EucFileOutputJokenhyoItem item_1 = new EucFileOutputJokenhyoItem(
                    進捗の取込みリストファイル,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    英数字_進捗の取込みリストファイル,
                    eUCエンティティID,
                    出力件数_1,
                    出力条件);
            EucFileOutputJokenhyoFactory.createInstance(item_1).print();
            EucFileOutputJokenhyoItem item_2 = new EucFileOutputJokenhyoItem(
                    進捗の取込みエラーリストファイル,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    英数字_進捗の取込みエラーリストファイル,
                    eUCエンティティID,
                    出力件数_1,
                    出力条件);
            EucFileOutputJokenhyoFactory.createInstance(item_2).print();
        } else if (一時デーブル_認定結果.equals(processParameter.get取込みデータ区分())) {
            EucFileOutputJokenhyoItem item_1 = new EucFileOutputJokenhyoItem(
                    結果の取込みリストファイル,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    英数字_結果の取込みリストファイル,
                    eUCエンティティID,
                    出力件数_2,
                    出力条件);

            EucFileOutputJokenhyoFactory.createInstance(item_1).print();
            EucFileOutputJokenhyoItem item_2 = new EucFileOutputJokenhyoItem(
                    結果の取込みエラーリストファイル,
                    導入団体コード,
                    市町村名,
                    ジョブ番号,
                    英数字_結果の取込みエラーリストファイル,
                    eUCエンティティID,
                    出力件数_2,
                    出力条件);

            EucFileOutputJokenhyoFactory.createInstance(item_2).print();
        }

    }

    private YokaigoninteiIntafesumasutaEntity create要介護認定インターフェースマスタル(FairudetaIchijiTeburuEntity f) {
        YokaigoninteiIntafesumasutaEntity entity = new YokaigoninteiIntafesumasutaEntity();
        entity.setHihokenjabango(f.getHihokenjabango());
        entity.setRirekibango(new RString("0000"));
        entity.setTorikominichiji(systemTime.toDateString());
        entity.setTorikomikubun(new RString("0"));
        entity.setShinseishubetsukodo(f.getShinseikubunshinseiji());
        entity.setTorisakubunkodo(f.getTorisakubunkodo());
        entity.setNinteiYMD(f.getNinteishinseibi());
        entity.setIryokikankodo(f.getShujiiiryokikanbango());
        entity.setShujiikodo(f.getShujiibango());
        entity.setIkenshoiraiYMD(f.getLkenshoiraibi());
        entity.setIkenshotoriyoseYMD(f.getLkenshonyushubi());
        entity.setChosaitakuYMD(f.getChosairaibi());
        entity.setChosashuryoYMD(f.getChosajisshibi());
        entity.setChosaitakusakikodo(f.getLtakukubun());
        entity.setChosainkodo(f.getNinteichosainbango());
        entity.setIchijihanteibi(f.getLchijihanteibi());
        entity.setIchijihanteikekka(f.getLchijihanteikekka());
        entity.setIchijihanteikekka_omomi(null);
        entity.setShinsakaishiryosakuseinengappi(f.getNinteishinsakaishiryosakuseibi());
        entity.setShinsakaiyoteinengappi(f.getNinteishinsakaiyoteibi());
        entity.setGogitaibango(f.getGogitaibango());
        entity.setNijihanteibi(f.getNijihanteibi());
        entity.setNijihanteikekka(f.getNijihanteikekka());
        entity.setNinteiYukoKikanKaishiYMD(f.getNinteiyukokigen_kaishi());
        entity.setNinteiYukoKikanShuryoYMD(f.getNinteiyukokigen_shuryo());
        entity.setSabisuhenkoriyukodo(f.getGenzainosabisukubunkodo());
        entity.setTokuteishippeikodo(f.getTokuteishippeikodo());
        entity.setShogaikoreishajiritsudo(f.getShajiritsudo());
        entity.setNinshishokoreishajiritsudo(f.getNinshishokoreishajiritsudo());
        entity.setShinsakaiiken(f.getNinteishinsakaiikento());
        entity.setHanbango(f.getShikibetsukodo());
        entity.setIchijihanteinaiyo(f.getYokaigoninteitokijunjikan().concat(new RString("～").concat(f.getNinchikinokyufukubun())));
        entity.setIchijihanteinaiyo2(RString.EMPTY);
        entity.setZenkaitorikominichiji(RString.EMPTY);
        entity.setKeshigomufuragu(RString.EMPTY);
        entity.setKeshigomunichiji(RString.EMPTY);
        entity.setYobikomoku1(RString.EMPTY);
        entity.setYobikomoku2(RString.EMPTY);
        entity.setYobikomoku3(RString.EMPTY);
        entity.setYobikomoku4(RString.EMPTY);
        entity.setYobikomoku5(RString.EMPTY);
        entity.setYobikubun1(RString.EMPTY);
        entity.setYobikubun2(RString.EMPTY);
        entity.setYobikubun3(RString.EMPTY);
        entity.setYobikubun4(RString.EMPTY);
        entity.setYobikubun5(RString.EMPTY);
        entity.setRizabu(RString.EMPTY);
        return entity;
    }

    private PersonalData toPersonalData(OutFile entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0001")), new RString("申請書管理番号"),
                entity.get被保険者番号());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }
}
