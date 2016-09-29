/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170020;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc170020.KaigoSabisuNaiyoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc170020.TorikomiDataTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 介護サービス内容取込結果CSV作成。
 *
 * @reamsid_L DBC-3400-030 liuyl
 */
public class KaigoSabisuNaiyoCSVSakusei extends BatchProcessBase<TorikomiDataTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc170020."
            + "IKaigoSabisuNaiyoCSVSakuseiMapper.select介護サービス内容取込結果");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC900003"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private FileSpoolManager manager;
    private RString eucFilePath;

    @BatchWriter
    private CsvWriter<KaigoSabisuNaiyoCsvEntity> csvWriter;

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("KaigoSabisuNaiyoTorikomiKekka.csv"));
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEncode(Encode.UTF_8withBOM).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(TorikomiDataTempEntity entity) {
        csvWriter.writeLine(createCsvEntity(entity));
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        manager.spool(eucFilePath);
    }

    private KaigoSabisuNaiyoCsvEntity createCsvEntity(TorikomiDataTempEntity entity) {
        KaigoSabisuNaiyoCsvEntity csvEntity = new KaigoSabisuNaiyoCsvEntity();
        csvEntity.setサービス種類コード(entity.getServiceShuruiCd().value());
        csvEntity.setサービス項目コード(entity.getServiceKoumokuCd());
        csvEntity.set提供開始年月(entity.getTeikyoKaishiYM().toDateString());
        csvEntity.set履歴番号(new RString(entity.getRirekiNo().toString()));
        csvEntity.set提供終了年月(entity.getTeikyoShuryoYM().toDateString());
        csvEntity.setサービス名称(entity.getServiceName());
        csvEntity.setサービス略称(entity.getServiceNameRyaku());
        csvEntity.set単位数(new RString(entity.getTaniSu()));
        csvEntity.set単位数識別(entity.getTanisuShikibetsuCode().value());
        csvEntity.set単位数算定単位(entity.getTanisuSanteiTaniCode().value());
        csvEntity.set異動事由(entity.getIdouJiyuCode().value());
        csvEntity.set限度額対象外フラグ(entity.getGendogakuTaishogaiFlag());
        csvEntity.set外部サービス利用型区分(entity.getGaibuServiceRiyoKataKubun());
        csvEntity.set特別地域加算フラグ(entity.getTokubetsuChiikiKasanFlag());
        csvEntity.set利用者負担定率_定額区分(entity.getRiyosyaFutanTeiritsuTeigakuKubun());
        csvEntity.set更新有無フラグ(entity.getKoshinUmuFoag());
        csvEntity.set元点数(entity.getMotoTensu());
        csvEntity.set元限度額対象外フラグ(entity.getMotoGendogakuTaishogaiFlag());
        csvEntity.set元単位数識別コード(entity.getMotoTaniShikibetsuCd());
        csvEntity.set利用者負担額(entity.getRiyoshaFutanGaku());
        csvEntity.set給付率(entity.getKyufuRitsu());
        csvEntity.set二次予防事業対象者実施区分_非該当(entity.getNijiyoboJigyoTaishaJishiKubunHigaito());
        csvEntity.set要支援１受給者実施区分(entity.getYoshien1JukyushaJishiKubun());
        csvEntity.set要支援２受給者実施区分(entity.getYoshien2JukyushaJishiKubun());
        csvEntity.set対象事業者実施区分(entity.getTaishoJigyoJishiKubun());
        csvEntity.set総合事業サービス区分(entity.getSogoJigyoServiceKubun());
        csvEntity.set制限日数回数(entity.getSeigenNissuKaisu());
        csvEntity.set算定回数制限期間区分(entity.getSanteiKaisuSeigenKikanKubun());
        return csvEntity;
    }
}
