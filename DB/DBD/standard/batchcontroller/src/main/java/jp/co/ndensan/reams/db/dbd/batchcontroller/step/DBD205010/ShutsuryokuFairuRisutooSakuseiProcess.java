/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD205010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.DBD205010.RendingJieguoLianxieProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.ErrorRecord;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.OutFile;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.OutFilekekka;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.ShinchokuNoTorikomiRisutoFairuCSVEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.TorikomiErarisutofairuCSVEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.ichijiteburu.ErarisutofairuIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.ichijiteburu.FairudetaIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.ichijiteburu.JinbunoQurirumirisutofairuYishiteburuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD205010.ichijiteburu.YokaigoninteiIntafesumasutaEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.GenzainoJokyoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
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
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 出力ファイルリストを作成_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class ShutsuryokuFairuRisutooSakuseiProcess extends BatchProcessBase<OutFile> {

    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private final RString EMPTY = new RString("");
    private final RString K02A = new RString("02A");
    private final RString K99A = new RString("99A");
    private final RString K06A = new RString("06A");
    private final RString K09A = new RString("09A");
    private final RString K09B = new RString("09B");
    private final RString ONE = new RString("1");
    private final RString ZEROONE = new RString("01");
    private final RString TWO = new RString("2");
    private final RString ZEROTWO = new RString("02");
    private final RString THREE = new RString("3");
    private final RString ZEROTHREE = new RString("03");
    private final RString FOUR = new RString("4");
    private final RString ZEROFOUR = new RString("04");
    private final RString FIVE = new RString("5");
    private final RString ZEROFIVE = new RString("05");
    private final RString SIX = new RString("6");
    private final RString ZEROSIX = new RString("06");
    private final RString SEVEN = new RString("7");
    private final RString ZEROSEVEN = new RString("07");
    private final RString EIGHT = new RString("8");
    private final RString ZEROEIGHT = new RString("08");
    private final RString NINE = new RString("9");
    private final RString ZERONINE = new RString("09");
    private final RString TEN = new RString("10");
    private final RString ELEVEN = new RString("11");
    private final RString TWELVE = new RString("12");
    private final RString THIRTEEN = new RString("13");
    private final RString FOURTEEN = new RString("14");
    private final RString FIVETEEN = new RString("15");
    private final RString SIXTEEN = new RString("16");
    private final RString NINETEEN = new RString("19");
    private final RString TWENTYONE = new RString("21");
    private final RString TWENTYTWO = new RString("22");
    private final RString TWENTYTHREE = new RString("23");
    private final RString TWENTYFOUR = new RString("24");
    private final RString TWENTYFIVE = new RString("25");
    private final RString NINETY_NINE = new RString("99");

    private final RString A = new RString("A");
    private final RString B = new RString("B");

    private List<PersonalData> personalDataList;

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
        tmpTableWriter_2 = BatchEntityCreatedTempTableWriterBuilders.createBuilder(ErarisutofairuIchijiTeburuEntity.class)
                .tempTableName(ErarisutofairuIchijiTeburuEntity.TABLE_NAME)
                .build();
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

    }

    private void ファイル出力用データの編集(OutFile t) {
        ErrorRecord error = new ErrorRecord();
        OutFilekekka kekka = new OutFilekekka();
        FairudetaIchijiTeburuEntity fairudetaEntity = new FairudetaIchijiTeburuEntity();

        if (一時デーブル_日次進捗.equals(processParameter.get取込みデータ区分())) {
            JinbunoQurirumirisutofairuYishiteburuEntity jinbunoEntity = create出力ファイルのデータ編集(出力ファイルのデータ編集(t));
            tmpTableWriter_1.insert(jinbunoEntity);
            ErarisutofairuIchijiTeburuEntity erarEntity = createエラーリストファイルデータの編集(error);
            tmpTableWriter_2.insert(erarEntity);
            YokaigoninteiIntafesumasutaEntity yoKaigonEntity = create要介護認定インターフェースマスタル(fairudetaEntity);
            tmpTableWriter_3.insert(yoKaigonEntity);

            ShinchokuNoTorikomiRisutoFairuCSVEntity csventity = new ShinchokuNoTorikomiRisutoFairuCSVEntity();
            ファイル出力進捗の取込みリストファイル(csventity, jinbunoEntity);
            eucCsvWriter_1.writeLine(csventity);
            TorikomiErarisutofairuCSVEntity csvEntity = new TorikomiErarisutofairuCSVEntity();
            ファイル出力進捗の取込みエラーリストファイル(csvEntity, erarEntity);
            eucCsvWriter_2.writeLine(csvEntity);
        } else if (一時デーブル_認定結果.equals(processParameter.get取込みデータ区分())) {
            JinbunoQurirumirisutofairuYishiteburuEntity jinbunoEntity = create出力ファイルのデータ編集(出力ファイルのデータ編集(t));
            tmpTableWriter_1.insert(jinbunoEntity);
            ErarisutofairuIchijiTeburuEntity erarEntity = createエラーリストファイルデータの編集(error);
            tmpTableWriter_2.insert(erarEntity);
            YokaigoninteiIntafesumasutaEntity yoKaigonEntity = create要介護認定インターフェースマスタル(fairudetaEntity);
            tmpTableWriter_3.insert(yoKaigonEntity);

            ShinchokuNoTorikomiRisutoFairuCSVEntity csventity = new ShinchokuNoTorikomiRisutoFairuCSVEntity();
            ファイル出力進捗の取込みリストファイル(csventity, jinbunoEntity);
            eucCsvWriter_1.writeLine(csventity);
            TorikomiErarisutofairuCSVEntity csvEntity = new TorikomiErarisutofairuCSVEntity();
            ファイル出力進捗の取込みエラーリストファイル(csvEntity, erarEntity);
            eucCsvWriter_2.writeLine(csvEntity);
            personalDataList.add(toPersonalData(t));
        }
    }

    private OutFilekekka 出力ファイルのデータ編集(OutFile t) {
        OutFilekekka out = new OutFilekekka();
        out.set識別コード(t.get識別コード());
        if (K02A.equals(t.get識別コード())) {
            out.set識別コード名称(KoroshoInterfaceShikibetsuCode.V02A.getCode());
        } else if (K99A.equals(t.get識別コード())) {
            out.set識別コード名称(KoroshoInterfaceShikibetsuCode.V99A.getCode());
        } else if (K06A.equals(t.get識別コード())) {
            out.set識別コード名称(KoroshoInterfaceShikibetsuCode.V06A.getCode());
        } else if (K09A.equals(t.get識別コード())) {
            out.set識別コード名称(KoroshoInterfaceShikibetsuCode.V09A.getCode());
        } else if (K09B.equals(t.get識別コード())) {
            out.set識別コード名称(KoroshoInterfaceShikibetsuCode.V09B.getCode());
        }
        out.set保険者番号(t.get保険者番号());
        out.set被保険者番号(t.get被保険者番号());
        out.set認定申請日(t.get認定申請日());
        out.set枝番(t.get枝番());
        if (K09B.equals(t.get識別コード())) {
            out.set申請区分_法令_コード(t.get申請区分_法令_コード());
            if (ONE.equals(t.get申請区分_法令_コード())) {
                out.set申請区分_法令_コード名称(NinteiShinseiHoreiCode.新規申請.get名称());
            } else if (TWO.equals(t.get申請区分_法令_コード())) {
                out.set申請区分_法令_コード名称(NinteiShinseiHoreiCode.更新申請.get名称());
            } else if (THREE.equals(t.get申請区分_法令_コード())) {
                out.set申請区分_法令_コード名称(NinteiShinseiHoreiCode.区分変更申請.get名称());
            } else if (FOUR.equals(t.get申請区分_法令_コード())) {
                out.set申請区分_法令_コード名称(NinteiShinseiHoreiCode.職権.get名称());
            }
        } else {
            out.set申請区分_法令_コード(EMPTY);
            out.set申請区分_法令_コード名称(EMPTY);
        }
        out.set申請区分_申請時_コード(t.get申請区分_申請時_コード());
        if (ONE.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.新規申請.get名称());
        } else if (TWO.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.更新申請.get名称());
        } else if (THREE.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.区分変更申請.get名称());
        } else if (FOUR.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.職権.get名称());
        } else if (FIVE.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.転入申請.get名称());
        } else if (SIX.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.資格喪失_死亡.get名称());
        } else if (A.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.新規申請_事前.get名称());
        } else if (B.equals(t.get申請区分_申請時_コード())) {
            out.set申請区分_申請時_コード名称(NinteiShinseiShinseijiKubunCode.更新申請_事前.get名称());
        }
        out.set取下区分コード(t.get取下区分コード());
        if (ONE.equals(t.get取下区分コード())) {
            out.set取下区分コード名称(TorisageKubunCode.認定申請有効.get名称());
        } else if (TWO.equals(t.get取下区分コード())) {
            out.set取下区分コード名称(TorisageKubunCode.却下.get名称());
        } else if (THREE.equals(t.get取下区分コード())) {
            out.set取下区分コード名称(TorisageKubunCode.取り下げ.get名称());
        } else if (FOUR.equals(t.get取下区分コード())) {
            out.set取下区分コード名称(TorisageKubunCode.区分変更却下.get名称());
        }
        out.set被保険者区分コード(t.get被保険者区分コード());
        if (ONE.equals(t.get被保険者区分コード())) {
            out.set被保険者区分コード名称(HihokenshaKubunCode.第１号被保険者.get名称());
        } else if (TWO.equals(t.get被保険者区分コード())) {
            out.set被保険者区分コード名称(HihokenshaKubunCode.第２号被保険者.get名称());
        } else if (EIGHT.equals(t.get被保険者区分コード())) {
            out.set被保険者区分コード名称(HihokenshaKubunCode.生活保護.get名称());
        } else if (NINE.equals(t.get被保険者区分コード())) {
            out.set被保険者区分コード名称(HihokenshaKubunCode.その他.get名称());
        }
        out.set申請代行区分コード(t.get申請代行区分コード());
        if (ONE.equals(t.get申請代行区分コード())) {
            out.set申請代行区分コード名称(ShinseiTodokedeDaikoKubunCode.本人.get名称());
        } else if (TWO.equals(t.get申請代行区分コード())) {
            out.set申請代行区分コード名称(ShinseiTodokedeDaikoKubunCode.家族.get名称());
        } else if (THREE.equals(t.get申請代行区分コード())) {
            out.set申請代行区分コード名称(ShinseiTodokedeDaikoKubunCode.委任.get名称());
        } else if (FOUR.equals(t.get申請代行区分コード())) {
            out.set申請代行区分コード名称(ShinseiTodokedeDaikoKubunCode.代行.get名称());
        } else if (NINE.equals(t.get申請代行区分コード())) {
            out.set申請代行区分コード名称(ShinseiTodokedeDaikoKubunCode.その他.get名称());
        }
        out.set生年月日(t.get生年月日());
        out.set年齢(t.get年齢());
        out.set性別コード(t.get性別コード());
        if (ONE.equals(t.get性別コード())) {
            out.set性別コード名称(Seibetsu.男.get名称());
        } else if (TWO.equals(t.get性別コード())) {
            out.set性別コード名称(Seibetsu.女.get名称());
        }
        out.set被保険者ｶﾅ氏名(t.get被保険者ｶﾅ氏名());
        out.set被保険者漢字氏名(t.get被保険者漢字氏名());
        out.set郵便番号(t.get郵便番号());
        out.set住所(t.get住所());
        out.set電話番号(t.get電話番号());
        out.set病院施設等の名称(t.get病院施設等の名称());
        out.set病院施設等の所在地(t.get病院施設等の所在地());
        out.set前回の認定審査会結果(t.get前回の認定審査会結果());
        if (K99A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.非該当.get名称());
            } else if (ZERONINE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.みなし非該当.get名称());
            } else if (ELEVEN.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.経過的要介護.get名称());
            } else if (NINETEEN.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.みなし要支援.get名称());
            } else if (TWENTYONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode99.要介護5.get名称());
            }
        } else if (K02A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.非該当.get名称());
            } else if (ELEVEN.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要支援.get名称());
            } else if (TWENTYONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode02.要介護5.get名称());
            }
        } else if (K06A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.非該当.get名称());
            } else if (ELEVEN.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.経過的要介護.get名称());
            } else if (TWENTYONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode06.要介護5.get名称());
            }
        } else if (K09A.equals(t.get識別コード()) || K09B.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.非該当.get名称());
            } else if (TWELVE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要支援1.get名称());
            } else if (THIRTEEN.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要支援2.get名称());
            } else if (TWENTYONE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get前回の認定審査会結果())) {
                out.set前回の認定審査会結果名称(IchijiHanteiKekkaCode09.要介護5.get名称());
            }
        }
        out.set前回の認定有効期間_開始(t.get前回の認定有効期間_開始());
        out.set前回の認定有効期間_終了(t.get前回の認定有効期間_終了());
        out.set主治医医療機関番号(t.get主治医医療機関番号());
        out.set主治医番号(t.get主治医番号());
        out.set意見書依頼日(t.get意見書依頼日());
        out.set意見書入手日(t.get意見書入手日());
        out.set意見書_短期記憶(t.get意見書_短期記憶());
        out.set意見書_認知能力(t.get意見書_認知能力());
        out.set意見書_伝達能力(t.get意見書_伝達能力());
        out.set意見書_食事行為(t.get意見書_食事行為());
        out.set意見書_認知症高齢者の日常生活自立度(t.get意見書_認知症高齢者の日常生活自立度());
        out.set調査依頼日(t.get調査依頼日());
        out.set調査実施日(t.get調査実施日());
        out.set指定居宅介護支援事業者等番号(t.get指定居宅介護支援事業者等番号());
        out.set委託区分(t.get委託区分());
        if (ONE.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.保険者_市町村等.get名称());
        } else if (TWO.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.指定市町村事務受託法人.get名称());
        } else if (THREE.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.指定居宅介護支援事業者.get名称());
        } else if (FOUR.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.介護保険施設.get名称());
        } else if (FIVE.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.介護支援専門員.get名称());
        } else if (SIX.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.他市町村.get名称());
        } else if (NINE.equals(t.get委託区分())) {
            out.set委託区分名称(ChosaItakuKubunCode.その他.get名称());
        }
        out.set認定調査員番号(t.get認定調査員番号());
        out.set認定調査員資格コード(t.get認定調査員資格コード());
        if (ZEROONE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.医師.get名称());
        } else if (ZEROTWO.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.歯科医師.get名称());
        } else if (ZEROTHREE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.薬剤師.get名称());
        } else if (ZEROFOUR.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.保健師.get名称());
        } else if (ZEROFIVE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.助産師.get名称());
        } else if (ZEROSIX.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku._准_看護師.get名称());
        } else if (ZEROSEVEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.理学療法士.get名称());
        } else if (ZEROEIGHT.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.作業療法士.get名称());
        } else if (ZERONINE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.社会福祉士.get名称());
        } else if (TEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.介護福祉士.get名称());
        } else if (ELEVEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.ソーシャルワーカー.get名称());
        } else if (TWELVE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.福祉事務所現業員等.get名称());
        } else if (THIRTEEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.ホームヘルパー.get名称());
        } else if (FOURTEEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.介護職員.get名称());
        } else if (FIVETEEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.その他福祉関係者.get名称());
        } else if (SIXTEEN.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.行政関係者.get名称());
        } else if (NINETY_NINE.equals(t.get認定調査員資格コード())) {
            out.set認定調査員資格コード名称(Sikaku.その他.get名称());
        }
        out.set一次判定日(t.get一次判定日());
        out.set一次判定結果(t.get一次判定結果());
        if (K99A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.非該当.get名称());
            } else if (ZERONINE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.みなし非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.経過的要介護.get名称());
            } else if (NINETEEN.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.みなし要支援.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode99.要介護5.get名称());
            }
        } else if (K02A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要支援.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode02.要介護5.get名称());
            }
        } else if (K06A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.経過的要介護.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode06.要介護5.get名称());
            }
        } else if (K09A.equals(t.get識別コード()) || K09B.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.非該当.get名称());
            } else if (TWELVE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要支援1.get名称());
            } else if (THIRTEEN.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要支援2.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果())) {
                out.set一次判定結果名称(IchijiHanteiKekkaCode09.要介護5.get名称());
            }
        }
        out.set一次判定結果_認知症加算(t.get一次判定結果_認知症加算());
        if (K99A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.非該当.get名称());
            } else if (ZERONINE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.みなし非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.経過的要介護.get名称());
            } else if (NINETEEN.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.みなし要支援.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode99.要介護5.get名称());
            }
        } else if (K02A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要支援.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode02.要介護5.get名称());
            }
        } else if (K06A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.非該当.get名称());
            } else if (ELEVEN.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.経過的要介護.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode06.要介護5.get名称());
            }
        } else if (K09A.equals(t.get識別コード()) || K09B.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.非該当.get名称());
            } else if (TWELVE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要支援1.get名称());
            } else if (THIRTEEN.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要支援2.get名称());
            } else if (TWENTYONE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get一次判定結果_認知症加算())) {
                out.set一次判定結果_認知症加算_名称(IchijiHanteiKekkaCode09.要介護5.get名称());
            }
        }
        out.set認定審査会資料作成日(t.get認定審査会資料作成日());
        out.set認定審査会予定日(t.get認定審査会予定日());
        out.set合議体番号(t.get合議体番号());
        out.set審査会資料番号(t.get審査会資料番号());
        out.set二次判定日(t.get二次判定日());
        out.set二次判定結果(t.get二次判定結果());
        if (K99A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.非該当.get名称());
            } else if (ZERONINE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.みなし非該当.get名称());
            } else if (ELEVEN.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.経過的要介護.get名称());
            } else if (NINETEEN.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.みなし要支援.get名称());
            } else if (TWENTYONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode99.要介護5.get名称());
            }
        } else if (K02A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.非該当.get名称());
            } else if (ELEVEN.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要支援.get名称());
            } else if (TWENTYONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode02.要介護5.get名称());
            }
        } else if (K06A.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.非該当.get名称());
            } else if (ELEVEN.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.経過的要介護.get名称());
            } else if (TWENTYONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode06.要介護5.get名称());
            }
        } else if (K09A.equals(t.get識別コード()) || K09B.equals(t.get識別コード())) {
            if (ZEROONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.非該当.get名称());
            } else if (TWELVE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要支援1.get名称());
            } else if (THIRTEEN.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要支援2.get名称());
            } else if (TWENTYONE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要介護1.get名称());
            } else if (TWENTYTWO.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要介護2.get名称());
            } else if (TWENTYTHREE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要介護3.get名称());
            } else if (TWENTYFOUR.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要介護4.get名称());
            } else if (TWENTYFIVE.equals(t.get二次判定結果())) {
                out.set二次判定結果名称(IchijiHanteiKekkaCode09.要介護5.get名称());
            }
        }
        out.set認定有効期間_開始(t.get認定有効期間_開始());
        out.set認定有効期間_終了(t.get認定有効期間_終了());
        out.set特定疾病コード(t.get特定疾病コード());
        if (ZEROONE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.筋萎縮性側索硬化症.get名称());
        } else if (ZEROTWO.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.後縦靭帯骨化症.get名称());
        } else if (ZEROTHREE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.骨折を伴う骨粗鬆症.get名称());
        } else if (ZEROFOUR.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.多系統萎縮症.get名称());
        } else if (ZEROFIVE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.初老期における認知症.get名称());
        } else if (ZEROSIX.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.脊髄小脳変性症.get名称());
        } else if (ZEROSEVEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.脊柱管狭窄症.get名称());
        } else if (ZEROEIGHT.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.早老症.get名称());
        } else if (ZERONINE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症.get名称());
        } else if (TEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.脳血管疾患.get名称());
        } else if (ELEVEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.パーキンソン病関連疾患.get名称());
        } else if (TWELVE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.閉塞性動脈硬化症.get名称());
        } else if (THIRTEEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.関節リウマチ.get名称());
        } else if (FOURTEEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.慢性閉塞性肺疾患.get名称());
        } else if (FIVETEEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.両側の膝関節又は股関節に著しい変形を伴う変形性関節症.get名称());
        } else if (SIXTEEN.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.がん_末期.get名称());
        } else if (NINETY_NINE.equals(t.get特定疾病コード())) {
            out.set特定疾病コード名称(TokuteiShippei.特定疾病以外.get名称());
        }
        out.set要介護1の場合の状態像(t.get要介護1の場合の状態像());
        if (ZEROONE.equals(t.get要介護1の場合の状態像())) {
            out.set要介護1の場合の状態像名称(YokaigoJotaizoReiCode.認知機能の低下等.get名称());
        } else if (ZEROTWO.equals(t.get要介護1の場合の状態像())) {
            out.set要介護1の場合の状態像名称(YokaigoJotaizoReiCode.不安定な状態.get名称());
        } else if (NINETY_NINE.equals(t.get要介護1の場合の状態像())) {
            out.set要介護1の場合の状態像名称(YokaigoJotaizoReiCode.その他.get名称());
        }
        out.set現在のサービス区分コード(t.get現在のサービス区分コード());
        if (ONE.equals(t.get現在のサービス区分コード())) {
            out.set現在のサービス区分コード名称(ServiceKubunCode.予防給付サービス.get名称());
        } else if (TWO.equals(t.get現在のサービス区分コード())) {
            out.set現在のサービス区分コード名称(ServiceKubunCode.介護給付サービス.get名称());
        } else if (NINE.equals(t.get現在のサービス区分コード())) {
            out.set現在のサービス区分コード名称(ServiceKubunCode.なし.get名称());
        }
        out.set現在の状況(t.get現在の状況());
        if (ONE.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.居宅_施設利用なし.get名称());
        } else if (TWO.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.指定介護老人福祉施設.get名称());
        } else if (THREE.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.介護老人保健施設.get名称());
        } else if (FOUR.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.指定介護療養型医療施設.get名称());
        } else if (FIVE.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.認知症対応型共同生活介護適用施設_グループホーム.get名称());
        } else if (SIX.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.特定施設入居者生活介護適用施設_ケアハウス等.get名称());
        } else if (SEVEN.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.医療機関_医療保険適用療養病床.get名称());
        } else if (EIGHT.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.医療機関_療養病棟以外.get名称());
        } else if (NINE.equals(t.get現在の状況())) {
            out.set現在の状況名称(GenzainoJokyoCode.その他の施設.get名称());
        }
        return out;
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

    private ErarisutofairuIchijiTeburuEntity createエラーリストファイルデータの編集(ErrorRecord error) {
        ErarisutofairuIchijiTeburuEntity entity = new ErarisutofairuIchijiTeburuEntity();
        entity.setShikibetsukodo(error.getShikibetsukodo());
        entity.setHokenshabango(error.getHokenshabango());
        entity.setHihokenjabango(error.getHihokenjabango());
        entity.setNinteishinseibi(error.getNinteishinseibi());
        entity.setEdaban(error.getEdaban());
        entity.setShinseikubunhorei(error.getShinseikubunhorei());
        entity.setShinseikubunshinseiji(error.getShinseikubunshinseiji());
        entity.setTorisakubunkodo(error.getTorisakubunkodo());
        entity.setHihokenjakubun(error.getHihokenjakubun());
        entity.setShinseidaikokubun(error.getShinseidaikokubun());
        entity.setSeinengappi(error.getSeinengappi());
        entity.setNenrei(error.getNenrei());
        entity.setSeibetsukodo(error.getSeibetsukodo());
        entity.setHihokenjakanashimei(error.getHihokenjakanashimei());
        entity.setHihokenjakanjishimei(error.getHihokenjakanjishimei());
        entity.setYubenbango(error.getYubenbango());
        entity.setJusho(error.getJusho());
        entity.setTenwabango(error.getTenwabango());
        entity.setByoinshisetsutonomeisho(error.getByoinshisetsutonomeisho());
        entity.setByoinshisetsutonoshozaichi(error.getByoinshisetsutonoshozaichi());
        entity.setEramesseji(error.getEramesseji());
        return entity;
    }

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

    private void ファイル出力進捗の取込みエラーリストファイル(TorikomiErarisutofairuCSVEntity csventity, ErarisutofairuIchijiTeburuEntity entity) {
        csventity.set識別コード(entity.getShikibetsukodo().value());
        csventity.set保険者番号(entity.getHokenshabango());
        csventity.set被保険者番号(entity.getHihokenjabango());
        csventity.set認定申請日(new RString(entity.getNinteishinseibi().toString()));
        csventity.set枝番(entity.getEdaban());
        csventity.set申請区分_法令_コード(entity.getShinseikubunhorei().value());
        csventity.set申請区分_申請時_コード(entity.getShinseikubunshinseiji().value());
        csventity.set取下区分コード(entity.getTorisakubunkodo().value());
        csventity.set被保険者区分コード(entity.getHihokenjakubun().value());
        csventity.set申請代行区分コード(entity.getShinseidaikokubun().value());
        csventity.set生年月日(new RString(entity.getSeinengappi().toString()));
        csventity.set年齢(new RString(entity.getNenrei()));
        csventity.set性別コード(entity.getSeibetsukodo().value());
        csventity.set被保険者ｶﾅ氏名(entity.getHihokenjakanashimei().value());
        csventity.set被保険者漢字氏名(entity.getHihokenjakanjishimei().value());
        csventity.set郵便番号(entity.getYubenbango().value());
        csventity.set住所(entity.getJusho().value());
        csventity.set電話番号(entity.getTenwabango().value());
        csventity.set病院施設等の名称(entity.getByoinshisetsutonomeisho());
        csventity.set病院施設等の所在地(entity.getByoinshisetsutonoshozaichi());
        csventity.setエラーメッセージ(entity.getEramesseji());
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter_1.close();
        eucCsvWriter_2.close();
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        RString ファイル名_日本語 = new RString("");
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString ファイル名_英数字 = new RString("");
        RString EUCエンティティID = new RString("-");
        RString 出力件数 = new RString(String.valueOf(eucCsvWriter_1.getCount()));
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(processParameter.get保険者());

        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                ファイル名_日本語,
                導入団体コード,
                市町村名,
                ジョブ番号,
                ファイル名_英数字,
                EUCエンティティID,
                出力件数,
                出力条件);
        EucFileOutputJokenhyoFactory.createInstance(item).print();
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
