/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc170020.KaigoServiceNaiyouCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170020.TorikomiDataTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchCsvReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 「取込データ一時作成」の処理です。
 *
 * @reamsid_L DBC-3400-030 xuyue
 */
public class TorikomiDataIchijiSakusei extends BatchProcessBase<KaigoServiceNaiyouCsvEntity> {

    private static final int NUM_6 = 6;
    private static final RString CSVファイル名 = new RString("KM999999_COMMON.csv");
    private static final RString TABLE_NAME = new RString("DbT7131KaigoServiceNaiyouTemp");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 取込データ一時tableWriter;
    private RString csvFilePath;
    private KaigoServiceNaiyouCsvEntity 前レコード;
    private KaigoServiceNaiyouCsvEntity 後レコード;
    private static final RString 異動事由コード_010 = new RString("010");
    private static final RString サービス種類コード_33 = new RString("33");
    private static final RString サービス種類コード_35 = new RString("35");
    private static final RString 適用開始年月日200604 = new RString("200604");
    private static final RString ゼロ = new RString("0");
    private static final RString いち = new RString("1");

    @Override
    protected void initialize() {
        csvFilePath = RString.EMPTY;
    }

    @Override
    protected IBatchReader createReader() {
        List<UzT0885SharedFileEntryEntity> sharedFiles = SharedFile.searchSharedFile(CSVファイル名);
        if (sharedFiles == null || sharedFiles.isEmpty()) {
            throw new BatchInterruptedException(DbzErrorMessages.アップロードファイル無し.getMessage().toString());
        }

        RString maeSharedName = RString.EMPTY;
        RString atoSharedName = RString.EMPTY;
        for (UzT0885SharedFileEntryEntity sharedfile : sharedFiles) {
            atoSharedName = sharedfile.getLocalFileName();
            if (atoSharedName.compareTo(maeSharedName) != 0) {
                SharedFile.copyToLocal(FilesystemName.fromString(CSVファイル名), FilesystemPath.fromString(Path.getTmpDirectoryPath()));
                break;
            }
        }
        csvFilePath = Path.combinePath(Path.getTmpDirectoryPath(), atoSharedName);
        CsvReader<KaigoServiceNaiyouCsvEntity> csvReader = createCsvReader();
        return new BatchCsvReader(csvReader);
    }

    @Override
    protected void createWriter() {
        取込データ一時tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, TorikomiDataTempEntity.class);
    }

    @Override
    protected void process(KaigoServiceNaiyouCsvEntity entity) {
        TorikomiDataTempEntity tblEntity = new TorikomiDataTempEntity();
        FlexibleYearMonth 適用開始年月日;

        if (前レコード == null) {
            適用開始年月日 = new FlexibleYearMonth(entity.get適用開始年月日().substring(0, NUM_6));
            取込データ一時作成(tblEntity, 適用開始年月日, entity);
            取込データ一時tableWriter.insert(tblEntity);
            return;
        } else {
            後レコード = entity;
        }
        if (前レコード.getサービス種類コード().equals(後レコード.getサービス種類コード())
                && 前レコード.getサービス項目コード().equals(後レコード.getサービス項目コード())
                && 前レコード.get適用終了年月日().substring(0, NUM_6).equals(後レコード.get適用開始年月日().substring(0, NUM_6))) {
            適用開始年月日 = new FlexibleYearMonth(後レコード.get適用開始年月日().substring(0, NUM_6)).plusMonth(1);
        } else {
            適用開始年月日 = new FlexibleYearMonth(後レコード.get適用開始年月日().substring(0, NUM_6));
        }

        取込データ一時作成(tblEntity, 適用開始年月日, 後レコード);
        取込データ一時tableWriter.insert(tblEntity);
        前レコード = 後レコード;
    }

    private CsvReader<KaigoServiceNaiyouCsvEntity> createCsvReader() {
        return new CsvReader.InstanceBuilder(csvFilePath, KaigoServiceNaiyouCsvEntity.class)
                .setDelimiter(new RString(",")).setEnclosure(new RString("\""))
                .hasHeader(false).setEncode(Encode.SJIS).setNewLine(NewLine.CRLF).build();
    }

    private void 取込データ一時作成(TorikomiDataTempEntity tblEntity, FlexibleYearMonth 適用開始年月日, KaigoServiceNaiyouCsvEntity csvEntity) {
        tblEntity.setServiceShuruiCd(new ServiceShuruiCode(csvEntity.getサービス種類コード()));
        tblEntity.setServiceKoumokuCd(csvEntity.getサービス項目コード());
        tblEntity.setTeikyoKaishiYM(適用開始年月日);
        tblEntity.setRirekiNo(new Decimal(csvEntity.get履歴番号().toString()));
        tblEntity.setTeikyoShuryoYM(new FlexibleYearMonth(csvEntity.get適用終了年月日().substring(0, NUM_6)));
        tblEntity.setServiceName(csvEntity.getサービス略称());
        tblEntity.setServiceNameRyaku(csvEntity.getサービス略称());
        if (!RString.isNullOrEmpty(csvEntity.get単位数_合成単位数())) {
            tblEntity.setTaniSu(Integer.parseInt(csvEntity.get単位数_合成単位数().toString()));
        }
        tblEntity.setTanisuShikibetsuCode(new Code(csvEntity.get単位数識別()));
        tblEntity.setTanisuSanteiTaniCode(new Code(csvEntity.get算定単位()));
        tblEntity.setIdouJiyuCode(new Code(異動事由コード_010));
        if (csvEntity.get支給限度額対象区分() != null && !csvEntity.get支給限度額対象区分().isEmpty()) {
            tblEntity.setGendogakuTaishogaiFlag(いち);
        } else {
            tblEntity.setGendogakuTaishogaiFlag(ゼロ);
        }
        if ((サービス種類コード_33.equals(csvEntity.getサービス種類コード()) || サービス種類コード_35.equals(csvEntity.getサービス種類コード()))
                && csvEntity.get適用開始年月日().substring(0, NUM_6).compareTo(適用開始年月日200604) >= 0) {
            tblEntity.setGaibuServiceRiyoKataKubun(csvEntity.get人員配置区分());
        } else {
            tblEntity.setGaibuServiceRiyoKataKubun(ゼロ);
        }
        if (csvEntity.get特別地域加算() != null && !csvEntity.get特別地域加算().isEmpty()) {
            tblEntity.setTokubetsuChiikiKasanFlag(いち);
        } else {
            tblEntity.setTokubetsuChiikiKasanFlag(ゼロ);
        }
        tblEntity.setRiyosyaFutanTeiritsuTeigakuKubun(ゼロ);
        tblEntity.setKoshinUmuFoag(ゼロ);
        tblEntity.setMotoTensu(csvEntity.get単位数_合成単位数());
        if (csvEntity.get支給限度額対象区分() != null && !csvEntity.get支給限度額対象区分().isEmpty()) {
            tblEntity.setMotoGendogakuTaishogaiFlag(いち);
        } else {
            tblEntity.setMotoGendogakuTaishogaiFlag(ゼロ);
        }
        tblEntity.setMotoTaniShikibetsuCd(csvEntity.get単位数識別());
        tblEntity.setRiyoshaFutanGaku(ゼロ);
        tblEntity.setKyufuRitsu(ゼロ);
        tblEntity.setNijiyoboJigyoTaishaJishiKubunHigaito(ゼロ);
        tblEntity.setYoshien1JukyushaJishiKubun(ゼロ);
        tblEntity.setYoshien2JukyushaJishiKubun(ゼロ);
        tblEntity.setTaishoJigyoJishiKubun(ゼロ);
        tblEntity.setSogoJigyoServiceKubun(ゼロ);
        tblEntity.setSeigenNissuKaisu(RString.EMPTY);
        tblEntity.setSanteiKaisuSeigenKikanKubun(RString.EMPTY);
    }

}
