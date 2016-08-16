/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1080001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001.GemmenGengakuTaishoGaiShaListProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.GemmenGengakuTaishoGaiShaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku.GemmenGengakuTaishoGaiShaListCsvEntity;
import jp.co.ndensan.reams.db.dbd.service.core.gemmenshinseishotaishohaaku.ZenNendoResearcher;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * DBDBZ12021_2_減免減額申請書発行用対象者把握（バッチ）のCSV出力クラスです。
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
public class GemmenGengakuTaishoGaiShaListCsvProcess extends BatchProcessBase<GemmenGengakuTaishoGaiShaEntity> {

    private static final RString MYBATIS_SELECT_ID_負担限度額認定 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenshinseishotaishohaaku.IGemmenGengakuTaishoGaiShaListCsvMapper.get減免減額更新申請対象外者一覧CSV情報_負担限度額認定");
    private static final RString MYBATIS_SELECT_ID_利用者負担額減額 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenshinseishotaishohaaku.IGemmenGengakuTaishoGaiShaListCsvMapper.get減免減額更新申請対象外者一覧CSV情報_利用者負担額減額");
    private static final RString MYBATIS_SELECT_ID_訪問介護利用者負担額減額 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenshinseishotaishohaaku.IGemmenGengakuTaishoGaiShaListCsvMapper.get減免減額更新申請対象外者一覧CSV情報_訪問介護利用者負担額減額");
    private static final RString MYBATIS_SELECT_ID_社会福祉法人等利用者負担軽減 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.gemmenshinseishotaishohaaku.IGemmenGengakuTaishoGaiShaListCsvMapper.get減免減額更新申請対象外者一覧CSV情報_社会福祉法人等利用者負担軽減");

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBD102001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private GemmenGengakuTaishoGaiShaListProcessParameter processParamter;
    private FileSpoolManager manager;
    private RString eucFilePath;

    @BatchWriter
    private EucCsvWriter<GemmenGengakuTaishoGaiShaListCsvEntity> csvWriter;

    private List<PersonalData> personalDataList;
    private FlexibleDate 終了日;
    private FlexibleDate 開始日;

    @Override
    protected void initialize() {
        終了日 = ZenNendoResearcher.createIntance(processParamter.get減免減額種類(), processParamter.get基準日()).get終了日();
        開始日 = ZenNendoResearcher.createIntance(processParamter.get減免減額種類(), processParamter.get基準日()).get開始日();
        personalDataList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.負担限度額認定)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_負担限度額認定, processParamter.GemmenGengakuTaishoGaiShaListMyBatisParameter(開始日, 終了日));
        } else if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.利用者負担額減額)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_利用者負担額減額, processParamter.GemmenGengakuTaishoGaiShaListMyBatisParameter(開始日, 終了日));
        } else if (processParamter.get減免減額種類().equals(GemmenGengakuShurui.訪問介護利用者負担額減額)) {
            return new BatchDbReader(MYBATIS_SELECT_ID_訪問介護利用者負担額減額, processParamter.GemmenGengakuTaishoGaiShaListMyBatisParameter(開始日, 終了日));
        } else {
            return new BatchDbReader(MYBATIS_SELECT_ID_社会福祉法人等利用者負担軽減, processParamter.GemmenGengakuTaishoGaiShaListMyBatisParameter(開始日, 終了日));
        }
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);

        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("GemmenGengakuTaishoGaiShaList.csv"));
        csvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(GemmenGengakuTaishoGaiShaEntity list) {
        GemmenGengakuTaishoGaiShaListCsvEntity csvEntity = new GemmenGengakuTaishoGaiShaListCsvEntity();
        if (list.get本人区分() != null && list.get本人区分().equals(HonninKubun.本人.getCode())) {
            setEucCsvEntity(csvEntity, list);
            csvWriter.writeLine(csvEntity);
            personalDataList.add(toPersonalData(list));
        }
    }

    @Override
    protected void afterExecute() {
        if (personalDataList.isEmpty()) {
            csvWriter.writeLine(setEmptyGemmenGengakuTaishoGaiShaListCsvEntity());
        }
        csvWriter.close();
        AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(eucFilePath, accessLogUUID);
    }

    private void setEucCsvEntity(GemmenGengakuTaishoGaiShaListCsvEntity csvEntity, GemmenGengakuTaishoGaiShaEntity list) {
        if (list.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(list.getPsmEntity());
            csvEntity.setカナ氏名(kojin.get名称().getKana().value());
            csvEntity.set氏名(kojin.get名称().getName().value());
            csvEntity.set年齢(kojin.get年齢算出().get年齢());
            csvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            csvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            csvEntity.set郵便番号(kojin.get住所().get郵便番号().value());
            csvEntity.set住所(kojin.get住所().get住所());
            csvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            csvEntity.set行政区(kojin.get行政区画().getGyoseiku().get名称());
        }
        csvEntity.set被保険者番号(list.get被保険者番号().value());
        csvEntity.set識別コード(list.get識別コード().value());
        csvEntity.set市町村コード(list.get市町村コード().value());
        csvEntity.set基準年月日(set年月日(list.get基準年月日()));
        csvEntity.set所得年度(list.get所得年度().toDateString());
        csvEntity.set証記載保険者番号(list.get証記載保険者番号().value());
        csvEntity.set世帯課税(list.get世帯課税区分());
        csvEntity.set利用者負担段階(list.get利用者負担段階());
        csvEntity.set決定区分(list.get決定区分());
        csvEntity.set減免申請日(set年月日(list.get減免申請日()));
        csvEntity.set減免決定日(set年月日(list.get減免決定日()));
        csvEntity.set減免適用日(set年月日(list.get減免適用日()));
        csvEntity.set減免有効期限(set年月日(list.get減免有効期限()));
        csvEntity.set老齢福祉年金受給区分(new RString(list.get老齢福祉年金受給区分().toString()));
        csvEntity.set生活保護受給区分(new RString(list.get生活保護受給区分().toString()));
        if (0 < list.get課税所得額().longValue() && list.get課税区分().equals(KazeiKubun.課税.get名称())) {
            csvEntity.set所得税区分(KazeiKubun.課税.get名称());
        } else {
            csvEntity.set所得税区分(KazeiKubun.非課税.get名称());
        }
        csvEntity.set課税区分(list.get課税区分());
        csvEntity.set入所施設コード(list.get入所施設コード());
        csvEntity.set入所施設名称(list.get入所施設名称());
        csvEntity.set要介護度(YokaigoJotaiKubunSupport.toValue(list.get厚労省IF識別コード(), list.get要介護認定状態区分コード()).getName());
        csvEntity.set旧措置(list.get旧措置());
        csvEntity.set要介護認定日(set年月日(list.get要介護認定日()));
        csvEntity.set認定開始日(set年月日(list.get認定開始日()));
        csvEntity.set認定終了日(set年月日(list.get認定終了日()));
    }

    private RString set年月日(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        } else {
            return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
        }
    }

    private PersonalData toPersonalData(GemmenGengakuTaishoGaiShaEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者番号().value());
        if (entity.getPsmEntity() == null) {
            return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
        }
        return PersonalData.of(entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
    }

    private GemmenGengakuTaishoGaiShaListCsvEntity setEmptyGemmenGengakuTaishoGaiShaListCsvEntity() {
        GemmenGengakuTaishoGaiShaListCsvEntity csvEntity = new GemmenGengakuTaishoGaiShaListCsvEntity();
        csvEntity.setカナ氏名(RString.EMPTY);
        csvEntity.set氏名(RString.EMPTY);
        csvEntity.set年齢(RString.EMPTY);
        csvEntity.set住民種別(RString.EMPTY);
        csvEntity.set住所コード(RString.EMPTY);
        csvEntity.set郵便番号(RString.EMPTY);
        csvEntity.set住所(RString.EMPTY);
        csvEntity.set行政区コード(RString.EMPTY);
        csvEntity.set行政区(RString.EMPTY);
        csvEntity.set被保険者番号(RString.EMPTY);
        csvEntity.set識別コード(RString.EMPTY);
        csvEntity.set市町村コード(RString.EMPTY);
        csvEntity.set基準年月日(RString.EMPTY);
        csvEntity.set所得年度(RString.EMPTY);
        csvEntity.set証記載保険者番号(RString.EMPTY);
        csvEntity.set世帯課税(RString.EMPTY);
        csvEntity.set利用者負担段階(RString.EMPTY);
        csvEntity.set決定区分(RString.EMPTY);
        csvEntity.set減免申請日(RString.EMPTY);
        csvEntity.set減免決定日(RString.EMPTY);
        csvEntity.set減免適用日(RString.EMPTY);
        csvEntity.set減免有効期限(RString.EMPTY);
        csvEntity.set老齢福祉年金受給区分(RString.EMPTY);
        csvEntity.set生活保護受給区分(RString.EMPTY);
        csvEntity.set所得税区分(RString.EMPTY);
        csvEntity.set課税区分(RString.EMPTY);
        csvEntity.set入所施設コード(RString.EMPTY);
        csvEntity.set入所施設名称(RString.EMPTY);
        csvEntity.set要介護度(RString.EMPTY);
        csvEntity.set旧措置(RString.EMPTY);
        csvEntity.set要介護認定日(RString.EMPTY);
        csvEntity.set認定開始日(RString.EMPTY);
        csvEntity.set認定終了日(RString.EMPTY);
        return csvEntity;
    }
}
