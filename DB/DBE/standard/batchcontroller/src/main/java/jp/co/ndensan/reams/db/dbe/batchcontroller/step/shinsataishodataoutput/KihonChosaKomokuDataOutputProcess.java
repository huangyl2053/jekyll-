/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsaTaishoDataOutPutProcessParammeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.KihonChosaKomokuDataEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.KihonChosaKomokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping02A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping06A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護認定審査会情報のCSV出力処理クラスです。
 */
public class KihonChosaKomokuDataOutputProcess extends BatchProcessBase<KihonChosaKomokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput.IShinsaTaishoDataOutPutMapper."
            + "get基本調査項目データ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE518004");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private ShinsaTaishoDataOutPutProcessParammeter processParamter;
    private RString eucFilePath;
    @BatchWriter
    private CsvWriter<KihonChosaKomokuDataEucCsvEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        eucFilePath = Path.combinePath(processParamter.getTempPath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID.toRString()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShinsaTaishoDataOutMybatisParameter());
    }

    @Override
    protected void createWriter() {
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.SJIS).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void process(KihonChosaKomokuDataRelateEntity entity) {
        eucCsvWriter.writeLine(createCsvEntity(entity));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
    }

    private KihonChosaKomokuDataEucCsvEntity createCsvEntity(KihonChosaKomokuDataRelateEntity entity) {
        KihonChosaKomokuDataEucCsvEntity csvEntity = new KihonChosaKomokuDataEucCsvEntity();

        csvEntity.set証記載保険者番号(entity.get証記載保険者番号());
        csvEntity.set被保険者番号(entity.get被保険者番号());
        csvEntity.set認定申請年月日(entity.get認定申請年月日());
        csvEntity.set連番(entity.get連番());

        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(entity.get厚労省IF識別コード())) {
            for (NinteichosaKomokuMapping02A value : NinteichosaKomokuMapping02A.values()) {
                if (value.getコード().toString().equals(entity.get連番().toString())) {
                    csvEntity.set表示番号(value.get表示番号());
                    csvEntity.set調査項目文言(value.get名称());
                    csvEntity.setパターンNo(new Decimal(value.getパターンNo().toString()));
                    csvEntity.set回答コード(entity.get調査項目());
                    break;
                }
            }
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(entity.get厚労省IF識別コード())) {
            for (NinteichosaKomokuMapping06A value : NinteichosaKomokuMapping06A.values()) {
                if (value.getコード().toString().equals(entity.get連番().toString())) {
                    csvEntity.set表示番号(value.get表示番号());
                    csvEntity.set調査項目文言(value.get名称());
                    csvEntity.setパターンNo(new Decimal(value.getパターンNo().toString()));
                    csvEntity.set回答コード(entity.get調査項目());
                    break;
                }
            }
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(entity.get厚労省IF識別コード())) {
            for (NinteichosaKomokuMapping09A value : NinteichosaKomokuMapping09A.values()) {
                if (value.getコード().toString().equals(entity.get連番().toString())) {
                    csvEntity.set表示番号(value.get表示番号());
                    csvEntity.set調査項目文言(value.get名称());
                    csvEntity.setパターンNo(new Decimal(value.getパターンNo().toString()));
                    csvEntity.set回答コード(entity.get調査項目());
                    break;
                }
            }
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(entity.get厚労省IF識別コード())) {
            for (NinteichosaKomokuMapping09B value : NinteichosaKomokuMapping09B.values()) {
                if (value.getコード().toString().equals(entity.get連番().toString())) {
                    csvEntity.set表示番号(value.getUSB_表示番号());
                    csvEntity.set調査項目文言(value.get名称());
                    csvEntity.setパターンNo(new Decimal(value.getパターンNo().toString()));
                    csvEntity.set回答コード(entity.get調査項目());
                    break;
                }
            }
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(entity.get厚労省IF識別コード())) {
            for (NinteichosaKomokuMapping99A value : NinteichosaKomokuMapping99A.values()) {
                if (value.getコード().toString().equals(entity.get連番().toString())) {
                    csvEntity.set表示番号(value.get表示番号());
                    csvEntity.set調査項目文言(value.get名称());
                    csvEntity.setパターンNo(new Decimal(value.getパターンNo().toString()));
                    csvEntity.set回答コード(entity.get調査項目());
                    break;
                }
            }
        }
        return csvEntity;
    }
}
