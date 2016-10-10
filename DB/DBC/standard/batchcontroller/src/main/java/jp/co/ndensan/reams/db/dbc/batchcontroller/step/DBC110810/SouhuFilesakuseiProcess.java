/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110810;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushatotsugoiraiout.JukyushaTotsugoIraiOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110810.ControlRecordCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110810.DataRecordCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110810.EndRecordCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc110810.IJukyushaTotsugoIraiOutCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110810.SouhuFilesakuseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.externalcharacter.BinaryCharacterConvertParameter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.BinaryCharacterConvertParameterBuilder;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterAttribute;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterConvertTable;
import jp.co.ndensan.reams.uz.uza.externalcharacter.ReamsUnicodeToBinaryConverter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.RecordConvertMaterial;
import jp.co.ndensan.reams.uz.uza.io.ByteWriter;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.FileReader;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 送付ファイル作成PROCESSクラスです
 *
 * @reamsid_L DBC-2750-030 xuyongchao
 */
public class SouhuFilesakuseiProcess extends BatchProcessBase<DbT3001JukyushaIdoRenrakuhyoEntity> {

    private static final RString KUBUN_1 = new RString("1");
    private static final RString KUBUN_2 = new RString("2");
    private static final RString KUBUN_3 = new RString("3");
    private static final RString KUBUN_4 = new RString("4");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("");
    private static final RString DOUBLE_QUOTATION = new RString("\"");
    private static final RString TABLE_処理結果リスト一時TBL = new RString("DbWT1002KokuhorenSakuseiError");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushatotsugoiraiout"
            + ".IJukyushaTotsugoIraiOutMapper.");
    private static final int 世代管理する = 1;
    private static final RString 国保連送付外字_変換区分_1 = new RString("1");
    private final RDate 基準日 = RDate.getNowDate();
    private static int index = 1;
    private static final RString 拡張子_TEMP = new RString("temp");
    private static final RString 拡張子 = new RString("\r\n");
    private RString myBatisSelsectId;
    private RString eucFilePath;
    private RString csvFileName;
    private boolean existingFlag;
    private JukyushaTotsugoIraiOutProcessParameter processParameter;
    private SouhuFilesakuseiEntity record1Entity;
    private SouhuFilesakuseiEntity record2Entity;
    private SouhuFilesakuseiEntity record3Entity;
    private RString kubun;
    List<DbT3001JukyushaIdoRenrakuhyoEntity> entityList;

    /**
     * 取得データフラグです。
     */
    public static final RString HAS_ERROR;

    static {
        HAS_ERROR = new RString("hasError");
    }

    private OutputParameter<Boolean> hasError;

    @Override
    protected void initialize() {
        existingFlag = false;
        hasError = new OutputParameter<>();
        hasError.setValue(false);
        entityList = new ArrayList<>();

        kubun = processParameter.getChuushutuKubun();
        if (KUBUN_1.equals(kubun)) {
            myBatisSelsectId = new RString(PATH + "get最新情報");
        } else if (KUBUN_2.equals(kubun)) {
            myBatisSelsectId = new RString(PATH + "get全情報");
        } else if (KUBUN_3.equals(kubun)) {
            myBatisSelsectId = new RString(PATH + "get一定期間内最新情報");
        } else if (KUBUN_4.equals(kubun)) {
            myBatisSelsectId = new RString(PATH + "get一定期間内全情報");
        }

        record1Entity = new SouhuFilesakuseiEntity();
        record2Entity = new SouhuFilesakuseiEntity();
        record3Entity = new SouhuFilesakuseiEntity();
        RString ninteiNengetu = RString.EMPTY;
        if (processParameter.getNinteiNengetu() != null && !processParameter.getNinteiNengetu().isEmpty()) {
            ninteiNengetu = new RString(processParameter.getNinteiNengetu().toString());
        }
        csvFileName = new RString("10_536" + DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBU介護統計報告)
                + ninteiNengetu + ".csv");
        RString spoolWorkPath = Directory.createTmpDirectory();
        eucFilePath = Path.combinePath(spoolWorkPath, csvFileName);
    }

    @BatchWriter
    private CsvWriter<IJukyushaTotsugoIraiOutCsvEntity> eucCsvWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(myBatisSelsectId, processParameter.toJukyushaTotsugoIraiOutMybatisParameter());
    }

    @Override
    protected void createWriter() {
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
        処理結果リスト一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_処理結果リスト一時TBL,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(DbT3001JukyushaIdoRenrakuhyoEntity entity) {
        existingFlag = true;
        entityList.add(entity);
    }

    @Override
    protected void afterExecute() {
        if (existingFlag) {
            record1Entity = getControl(record1Entity);
            getControlCSV出力();

            for (DbT3001JukyushaIdoRenrakuhyoEntity entity : entityList) {
                record2Entity = getData(entity, record2Entity);
                getDataCSV出力();
            }

            record3Entity = getEnd(record3Entity);
            getEndCSV出力();
            eucCsvWriter.close();
            do外字類似変換();
            SharedFileDescriptor sfd = new ReadOnlySharedFileDescriptor(new FilesystemName(csvFileName));
            sfd = SharedFile.defineSharedFile(sfd, 世代管理する, SharedFile.GROUP_ALL, null, true, null);
            CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
            SharedFile.copyToSharedFile(sfd, FilesystemPath.fromString(eucFilePath), opts);
        } else {
            処理結果リスト一時TBL.insert(getErrorEntity());
            hasError.setValue(!existingFlag);
        }
    }

    private SouhuFilesakuseiEntity getControl(
            SouhuFilesakuseiEntity record1Entity) {
        record1Entity.set種別(new RString("1"));
        record1Entity.set番号連番(new RString(index));
        record1Entity.set通番(new RString("000"));
        record1Entity.set件数(new RString(entityList.size()));
        record1Entity.setデータ種別(new RString("536"));
        record1Entity.set福祉事務所特定番号(new RString("00"));
        record1Entity.set保険者番号(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBU介護統計報告));
        record1Entity.set事業所番号(new RString("0000000000"));
        record1Entity.set都道府県番号(new RString("00"));
        record1Entity.set媒体区分(DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_受給突合Ｆ_媒体区分, 基準日, SubGyomuCode.DBC介護給付));
        record1Entity.set処理対象年月(new RString("000000"));
        record1Entity.setファイル管理番号(new RString("000001"));
        return record1Entity;
    }

    private SouhuFilesakuseiEntity getData(
            DbT3001JukyushaIdoRenrakuhyoEntity entity,
            SouhuFilesakuseiEntity record2Entity) {
        RString 有効年月 = RString.EMPTY;
        RString 有効期間開始年月日 = RString.EMPTY;
        RString 有効期間終了年月日 = RString.EMPTY;
        if (new RString("1").equals(kubun) || new RString("2").equals(kubun)) {
            有効年月 = new RString(new RString(processParameter.getNinteiNengetu().getYearValue()).toString()
                    + new RString(processParameter.getNinteiNengetu().getMonthValue()).toString()).trim();
        } else {
            有効期間終了年月日 = new RString(new RString(processParameter.getTaishouShuuryouNengetu().getYearValue()).toString()
                    + new RString(processParameter.getTaishouShuuryouNengetu().getMonthValue()).toString()).trim();
            有効期間開始年月日 = new RString(new RString(processParameter.getTaishouKaishiNengetu().getYearValue()).toString()
                    + new RString(processParameter.getTaishouKaishiNengetu().getMonthValue()).toString()).trim();
        }
        record2Entity.set種別(new RString("2"));
        record2Entity.set番号連番(new RString(++index));
        record2Entity.set交換情報識別番号(new RString("5361"));
        record2Entity.set突合区分(kubun.trim());
        record2Entity.set認定有効年月(有効年月);
        record2Entity.set突合開始年月(有効期間開始年月日);
        record2Entity.set突合終了年月(有効期間終了年月日);
        record2Entity.set異動年月日(new RString(entity.getIdoYMD().toString().trim()));
        record2Entity.set異動区分コード(entity.getIdoKubunCode().trim());
        record2Entity.set異動事由(entity.getJukyushaIdoJiyu().trim());
        record2Entity.set証記載保険者番号(entity.getShoKisaiHokenshaNo().value().trim());
        record2Entity.set被保険者番号(entity.getHiHokenshaNo().value().trim());
        record2Entity.set被保険者氏名カナ(DOUBLE_QUOTATION.concat(entity.getHiHokenshaNameKana().trim()).concat(DOUBLE_QUOTATION));
        record2Entity.set生年月日(new RString(entity.getUmareYMD().toString().trim()));
        record2Entity.set性別コード(entity.getSeibetsuCode().trim());
        record2Entity.set資格取得年月日(new RString(entity.getShikakuShutokuYMD().toString().trim()));
        record2Entity.set資格喪失年月日(change(entity.getShikakuSoshitsuYMD()));
        record2Entity.set老人保健市町村番号(trim(entity.getRojinHokenShichosonNo()));
        record2Entity.set老人保健受給者番号(trim(entity.getRojinHokenJukyushaNo()));
        record2Entity.set公費負担者番号(trim(entity.getKohiFutanshaNo()));
        record2Entity.set広域連合保険者番号(changeValue(entity.getKoikiRengoHokenshaNo()));
        record2Entity.set申請種別コード(trim(entity.getShinseiShubetsuCode()));
        record2Entity.set変更申請中区分コード(trim(entity.getHenkoShinseichuKubunCode()));
        record2Entity.set申請年月日(change(entity.getShinseiYMD()));
        record2Entity.setみなし要介護区分コード(trim(entity.getMinashiYokaigoJotaiKubunCode()));
        record2Entity.set要介護状態区分コード(trim(entity.getYokaigoJotaiKubunCode()));
        record2Entity.set認定有効期間開始年月日(change(entity.getNinteiYukoKikankaishiYMD()));
        record2Entity.set認定有効期間終了年月日(trim(entity.getNinteiYukoKikanShuryoYMD()));
        record2Entity.set居宅サービス計画作成区分コード(trim(entity.getKyotakuServiceSakuseiKubunCode()));
        record2Entity.set居宅介護支援事業所番号(trim(entity.getKyotakuKaigoShienJigyoshoNo()));
        record2Entity.set居宅サービス計画適用開始年月日(trim(entity.getKyotakuServiceTekiyoKaishiYMD()));
        record2Entity.set居宅サービス計画適用終了年月日(trim(entity.getKyotakuServiceTekiyoShuryoYMD()));
        record2Entity.set訪問支給限度基準額(new RString(entity.getHomonTsushoServiceShikyuGendoKijungaku()).trim());
        record2Entity.set訪問開始年月日(change(entity.getHomonTsushoServiceJogenKanriTekiyoKaishiYMD()));
        record2Entity.set訪問終了年月日(trim(entity.getHomonTsushoServiceJogenKanriTekiyoShuryoYMD()));
        record2Entity.set短期支給限度基準額(new RString(entity.getTankiNyushoServiceShikyuGendoKijungaku()).trim());
        record2Entity.set短期開始年月日(change(entity.getTankinyushoServiceJogenKanriTekiyoKaishiYMD()));
        record2Entity.set短期終了年月日(change(entity.getTankinyushoServiceJogenKanriTekiyoShuryoYMD()));
        record2Entity.set公費負担上限額減額の有無(entity.getKohiFutanJogenGengakuAriFlag());
        record2Entity.set償還払化開始年月日(trim(entity.getShokanbaraikaKaishiYMD()));
        record2Entity.set償還払化終了年月日(trim(entity.getShokanbaraikaShuryoYMD()));
        record2Entity.set給付率引下げ開始年月日(trim(entity.getKyufuritsuHikisageKaishiYMD()));
        record2Entity.set給付率引下げ終了年月日(trim(entity.getKyufuritsuHikisageShuryoYMD()));
        record2Entity.set減免申請中区分コード(trim(entity.getGemmenShinseichuKubunCode()));
        record2Entity.set利用者負担区分コード(trim(entity.getRiyoshaFutanKubunCode()));
        record2Entity.set給付率(entity.getKyufuritsu());
        record2Entity.set適用開始年月日(trim(entity.getTekiyoKaishiYMD()));
        record2Entity.set適用終了年月日(trim(entity.getTekiyoShuryoYMD()));
        record2Entity.set標準負担区分コード(trim(entity.getHyojunFutanKubunCode()));
        record2Entity.set負担額(entity.getFutangaku());
        record2Entity.set負担額適用開始年月日(trim(entity.getFutangakuTekiyoKaishiYMD()));
        record2Entity.set負担額適用終了年月日(trim(entity.getFutangakuTekiyoShuryoYMD()));
        record2Entity.set特定入所者認定申請中区分コード(trim(entity.getTokuteiNyushoshaNinteiShinseichuKubunCode()));
        record2Entity.set特定入所者介護サービス区分コード(trim(entity.getTokuteiNyushoshaKaigoServiceKubunCode()));
        record2Entity.set課税層の特例減額措置対象(entity.getKaizeisoTokureiGengakuSochiTaishoFlag());
        record2Entity.set食費負担限度額(trim(entity.getShokuhiFutanGendogaku()));
        record2Entity.set居住費個室負担限度額(trim(entity.getKyojuhiUnitGataKoshitsuFutanGendogaku()));
        record2Entity.set居住費準個室負担限度額(trim(entity.getKyojuhiUnitGataJunKoshitsuFutanGendogaku()));
        record2Entity.set居住費特養負担限度額(trim(entity.getKyojuhiJuraiGataKoshitsuTokuyoFutanGendogaku()));
        record2Entity.set居住費従来型個室負担限度額(trim(entity.getKyojuhiJuraiGataKoshitsuRokenRyoyoFutanGendogaku()));
        record2Entity.set居住費多床室負担限度額(trim(entity.getKyujuhiTashoshitsuFutanGendogaku()));
        record2Entity.set負担限度額適用開始年月日(trim(entity.getFutanGendogakuTekiyoKaishiYMD()));
        record2Entity.set負担限度額適用終了年月日(trim(entity.getFutanGendogakuTekiyoShuryoYMD()));
        record2Entity.set軽減率(trim(entity.getKeigenritsu()));
        record2Entity.set軽減率適用開始年月日(trim(entity.getKeigenritsuTekiyoKaishiYMD()));
        record2Entity.set軽減率適用終了年月日(trim(entity.getKeigenritsuTekiyoShuryoYMD()));
        record2Entity.set小規模多機能型居宅介護(entity.getShoTakinoKyotakuKaigoRiyozukiRiyoAriFlag());
        record2Entity.set保険者番号後期(trim(entity.getKokiKoureiIryoHokenshaNo()));
        record2Entity.set被保険者番号後期(trim(entity.getKokikoureiIryoHiHokenshaNo()));
        record2Entity.set保険者番号国保(trim(entity.getKokuhoHokenshaNo()));
        record2Entity.set被保険者番号国保(trim(entity.getKokuhoHiHokenshaNo()));
        record2Entity.set個人番号国保(trim(entity.getKokuhoKojinNo()));
        record2Entity.set二次予防事業区分コード(trim(entity.getNijiyoboJigyoKubunCode()));
        record2Entity.set二次予防事業開始年月日(change(entity.getNijiyoboJigyoYukoKikanKaishiYMD()));
        record2Entity.set二次予防事業終了年月日(change(entity.getNijiyoboJigyoYukoKikanShuryoYMD()));
        record2Entity.set住所地特例対象者区分コード(trim(entity.getJushochiTokureiTaishoshaKubunCode()));
        record2Entity.set施設所在保険者番号(trim(entity.getShisetsuShozaiHokenjaNo()));
        record2Entity.set住所地特例適用開始日(trim(entity.getJushochiTokureiTekiyoKaishiYMD()));
        record2Entity.set住所地特例適用終了日(trim(entity.getJushochiTokureiTekiyoShuryoYMD()));
        record2Entity.set居宅費新1負担限度額(trim(entity.getKyotakuhiShin1FutanGendogaku()));
        record2Entity.set居宅費新2負担限度額(trim(entity.getKyotakuhiShin2FutanGendogaku()));
        record2Entity.set居宅費新3負担限度額(trim(entity.getKyotakuhiShin3FutanGendogaku()));
        record2Entity.set二割負担適用開始年月日(trim(entity.getRiyosyaFutanWariaiYukoKaishiYMD()));
        record2Entity.set二割負担適用終了年月日(trim(entity.getRiyosyaFutanWariaiYukoShuryoYMD()));
        return record2Entity;

    }

    private RString change(FlexibleDate date) {
        if (null == date) {
            return RString.EMPTY;
        }
        return new RString(date.toString()).trim();
    }

    private RString changeValue(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        if (null == shoKisaiHokenshaNo) {
            return RString.EMPTY;
        }
        return shoKisaiHokenshaNo.value().trim();
    }

    private RString trim(RString rst) {
        if (null == rst) {
            return RString.EMPTY;
        }
        return rst.trim();
    }

    private SouhuFilesakuseiEntity getEnd(SouhuFilesakuseiEntity record3Entity) {
        record3Entity.set種別(new RString("3"));
        record3Entity.set番号連番(new RString(++index));
        return record3Entity;

    }

    private void getControlCSV出力() {
        eucCsvWriter.writeLine(
                new ControlRecordCsvEntity(record1Entity.get種別(),
                        record1Entity.get番号連番(),
                        record1Entity.get通番(),
                        record1Entity.get件数(),
                        record1Entity.getデータ種別(),
                        record1Entity.get福祉事務所特定番号(),
                        record1Entity.get保険者番号(),
                        record1Entity.get事業所番号(),
                        record1Entity.get都道府県番号(),
                        record1Entity.get媒体区分(),
                        record1Entity.get処理対象年月(),
                        record1Entity.getファイル管理番号()
                ));
    }

    private void getDataCSV出力() {
        eucCsvWriter.writeLine(
                new DataRecordCsvEntity(record2Entity.get種別(),
                        record2Entity.get番号連番(),
                        record2Entity.get交換情報識別番号(),
                        record2Entity.get突合区分(),
                        record2Entity.get認定有効年月(),
                        record2Entity.get突合開始年月(),
                        record2Entity.get突合終了年月(),
                        record2Entity.get異動年月日(),
                        record2Entity.get異動区分コード(),
                        record2Entity.get異動事由(),
                        record2Entity.get証記載保険者番号(),
                        record2Entity.get被保険者番号(),
                        record2Entity.get被保険者氏名カナ(),
                        record2Entity.get生年月日(),
                        record2Entity.get性別コード(),
                        record2Entity.get資格取得年月日(),
                        record2Entity.get資格喪失年月日(),
                        record2Entity.get老人保健市町村番号(),
                        record2Entity.get老人保健受給者番号(),
                        record2Entity.get公費負担者番号(),
                        record2Entity.get広域連合保険者番号(),
                        record2Entity.get申請種別コード(),
                        record2Entity.get変更申請中区分コード(),
                        record2Entity.get申請年月日(),
                        record2Entity.getみなし要介護区分コード(),
                        record2Entity.get要介護状態区分コード(),
                        record2Entity.get認定有効期間開始年月日(),
                        record2Entity.get認定有効期間終了年月日(),
                        record2Entity.get居宅サービス計画作成区分コード(),
                        record2Entity.get居宅介護支援事業所番号(),
                        record2Entity.get居宅サービス計画適用開始年月日(),
                        record2Entity.get居宅サービス計画適用終了年月日(),
                        record2Entity.get訪問支給限度基準額(),
                        record2Entity.get訪問開始年月日(),
                        record2Entity.get訪問終了年月日(),
                        record2Entity.get短期支給限度基準額(),
                        record2Entity.get短期開始年月日(),
                        record2Entity.get短期終了年月日(),
                        record2Entity.is公費負担上限額減額の有無(),
                        record2Entity.get償還払化開始年月日(),
                        record2Entity.get償還払化終了年月日(),
                        record2Entity.get給付率引下げ開始年月日(),
                        record2Entity.get給付率引下げ終了年月日(),
                        record2Entity.get減免申請中区分コード(),
                        record2Entity.get利用者負担区分コード(),
                        record2Entity.get給付率(),
                        record2Entity.get適用開始年月日(),
                        record2Entity.get適用終了年月日(),
                        record2Entity.get標準負担区分コード(),
                        record2Entity.get負担額(),
                        record2Entity.get負担額適用開始年月日(),
                        record2Entity.get負担額適用終了年月日(),
                        record2Entity.get特定入所者認定申請中区分コード(),
                        record2Entity.get特定入所者介護サービス区分コード(),
                        record2Entity.get課税層の特例減額措置対象(),
                        record2Entity.get食費負担限度額(),
                        record2Entity.get居住費個室負担限度額(),
                        record2Entity.get居住費準個室負担限度額(),
                        record2Entity.get居住費特養負担限度額(),
                        record2Entity.get居住費従来型個室負担限度額(),
                        record2Entity.get居住費多床室負担限度額(),
                        record2Entity.get負担限度額適用開始年月日(),
                        record2Entity.get負担限度額適用終了年月日(),
                        record2Entity.get軽減率(),
                        record2Entity.get軽減率適用開始年月日(),
                        record2Entity.get軽減率適用終了年月日(),
                        record2Entity.is小規模多機能型居宅介護(),
                        record2Entity.get保険者番号後期(),
                        record2Entity.get被保険者番号後期(),
                        record2Entity.get保険者番号国保(),
                        record2Entity.get被保険者番号国保(),
                        record2Entity.get個人番号国保(),
                        record2Entity.get二次予防事業区分コード(),
                        record2Entity.get二次予防事業開始年月日(),
                        record2Entity.get二次予防事業終了年月日(),
                        record2Entity.get住所地特例対象者区分コード(),
                        record2Entity.get施設所在保険者番号(),
                        record2Entity.get住所地特例適用開始日(),
                        record2Entity.get住所地特例適用終了日(),
                        record2Entity.get居宅費新1負担限度額(),
                        record2Entity.get居宅費新2負担限度額(),
                        record2Entity.get居宅費新3負担限度額(),
                        record2Entity.get二割負担適用開始年月日(),
                        record2Entity.get二割負担適用終了年月日()
                ));
    }

    private void getEndCSV出力() {
        eucCsvWriter.writeLine(
                new EndRecordCsvEntity(record3Entity.get種別(),
                        record3Entity.get番号連番()
                ));
    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity getErrorEntity() {
        DbWT1002KokuhorenSakuseiErrorTempEntity 処理結果 = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        処理結果.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード());
        処理結果.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
        処理結果.setHihokenshaNo(HihokenshaNo.EMPTY);
        処理結果.setKey1(RString.EMPTY);
        処理結果.setKey2(RString.EMPTY);
        処理結果.setKey3(RString.EMPTY);
        処理結果.setKey4(RString.EMPTY);
        処理結果.setKey4(RString.EMPTY);
        処理結果.setHihokenshaKanaShimei(RString.EMPTY);
        処理結果.setHihokenshaShimei(RString.EMPTY);
        処理結果.setBiko(RString.EMPTY);
        処理結果.setState(EntityDataState.Added);
        return 処理結果;
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

}
