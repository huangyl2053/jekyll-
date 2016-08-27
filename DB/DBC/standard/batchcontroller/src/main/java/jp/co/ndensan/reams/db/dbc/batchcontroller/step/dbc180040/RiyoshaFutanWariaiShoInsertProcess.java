/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaishohakko.FutanwariaishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.ShoriKekkaKakuninListCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaishohakko.RiyoshaFutanwariaishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaishohakko.RiyoshaFutanwariaishoTempEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 利用者負担割合証InsertのProcessクラスです。
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
public class RiyoshaFutanWariaiShoInsertProcess extends BatchProcessBase<RiyoshaFutanwariaishoTempEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaishohakko."
                    + "IFutanwariaishoHakkoMapper.select利用者負担割合証");
    private FutanwariaishoHakkoProcessParameter parameter;

    @BatchWriter
    private CsvWriter<ShoriKekkaKakuninListCSVEntity> shoriKekkaKakuninEucCsvWriter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter tableWriter;
    @BatchWriter
    BatchPermanentTableWriter shoKofuKaishuWriter;

    FileSpoolManager shoriKekkaKakuninListManager;
    private static final RString TABLE_NAME = new RString("RiyoshaFutanwariaishoTemp");
    private static final RString 確認内容 = new RString("資格喪失している、負担割合証を発行しませんでした。");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId SHORIKEKKA_EUC_ENTITY_ID = new EucEntityId(new RString("DBU900002"));
    private static final RString 交付証種類_003 = new RString("003");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_3 = new RString("3");
    private static final RString 定数_4 = new RString("4");
    private static final Code CODE = new Code("0003");
    private static final RString DATANAME = new RString("被保険者番号");
    private static final int NUM_ONE = 1;
    private static final int NUM_SEVEN = 7;
    private static final int NUM_THIRTY_ONE = 31;
    private static final RString 交付事由_01 = new RString("01");
    private static final RString 交付事由_02 = new RString("02");
    private static final RString 交付事由_03 = new RString("03");
    private static final RString 交付事由_04 = new RString("04");
    private static final RString 回収事由_00 = new RString("00");
    private RString shoriKekkaKakuninEucFilePath;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private final RString shoriKekkaKakuninListFileName = new RString("DBC900002_ShoriKekkaKakuninList.csv");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        shoKofuKaishuWriter = new BatchPermanentTableWriter(DbT7037ShoKofuKaishuEntity.class);
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, RiyoshaFutanwariaishoEntity.class);
        shoriKekkaKakuninListManager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, SHORIKEKKA_EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        shoriKekkaKakuninEucFilePath = Path.combinePath(shoriKekkaKakuninListManager.getEucOutputDirectry(),
                shoriKekkaKakuninListFileName);
        shoriKekkaKakuninEucCsvWriter = BatchWriters.csvWriter(ShoriKekkaKakuninListCSVEntity.class).
                filePath(shoriKekkaKakuninEucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(RiyoshaFutanwariaishoTempEntity entity) {
        if (entity.get被保台帳() != null && entity.get被保台帳().getShikakuSoshitsuYMD() == null) {
            RiyoshaFutanwariaishoEntity item = new RiyoshaFutanwariaishoEntity();
            item.setDbT3113RiyoshaFutanWariai_insertDantaiCd(entity.get利用者負担割合().getInsertDantaiCd());
            item.setDbT3113RiyoshaFutanWariai_isDeleted(entity.get利用者負担割合().getIsDeleted());
            item.setDbT3113RiyoshaFutanWariai_nendo(entity.get利用者負担割合().getNendo());
            item.setDbT3113RiyoshaFutanWariai_hihokenshaNo(entity.get利用者負担割合().getHihokenshaNo());
            item.setDbT3113RiyoshaFutanWariai_rirekiNo(entity.get利用者負担割合().getRirekiNo());
            item.setDbT3113RiyoshaFutanWariai_hakoFuyoFlag(entity.get利用者負担割合().getHakoFuyoFlag());
            item.setDbT3113RiyoshaFutanWariai_shokenFlag(entity.get利用者負担割合().getShokenFlag());
            item.setDbT3113RiyoshaFutanWariai_hanteiYMD(entity.get利用者負担割合().getHanteiYMD());
            item.setDbT3113RiyoshaFutanWariai_hanteiKubun(entity.get利用者負担割合().getHanteiKubun());
            item.setDbT3113RiyoshaFutanWariai_koseiJiyu(entity.get利用者負担割合().getKoseiJiyu());
            item.setDbT3113RiyoshaFutanWariai_hakoKubun(entity.get利用者負担割合().getHakoKubun());
            item.setDbT3113RiyoshaFutanWariai_hakoYMD(entity.get利用者負担割合().getHakoYMD());
            item.setDbT3113RiyoshaFutanWariai_kofuYMD(entity.get利用者負担割合().getKofuYMD());
            item.setDbT3113RiyoshaFutanWariai_logicalDeletedFlag(entity.get利用者負担割合().getLogicalDeletedFlag());
            item.setDbT1001HihokenshaDaicho_insertDantaiCd(entity.get被保台帳().getInsertDantaiCd());
            item.setDbT1001HihokenshaDaicho_insertTimestamp(entity.get被保台帳().getInsertTimestamp());
            item.setDbT1001HihokenshaDaicho_isDeleted(entity.get被保台帳().getIsDeleted());
            item.setDbT1001HihokenshaDaicho_lastUpdateTimestamp(entity.get被保台帳().getLastUpdateTimestamp());
            item.setDbT1001HihokenshaDaicho_hihokenshaNo(entity.get被保台帳().getHihokenshaNo());
            item.setDbT1001HihokenshaDaicho_idoYMD(entity.get被保台帳().getIdoYMD());
            item.setDbT1001HihokenshaDaicho_edaNo(entity.get被保台帳().getEdaNo());
            item.setDbT1001HihokenshaDaicho_idoJiyuCode(entity.get被保台帳().getIdoJiyuCode());
            item.setDbT1001HihokenshaDaicho_shichosonCode(entity.get被保台帳().getShichosonCode());
            item.setDbT1001HihokenshaDaicho_shikibetsuCode(entity.get被保台帳().getShikibetsuCode());
            item.setDbT1001HihokenshaDaicho_shikakuShutokuJiyuCode(entity.get被保台帳().getShikakuShutokuJiyuCode());
            item.setDbT1001HihokenshaDaicho_shikakuShutokuYMD(entity.get被保台帳().getShikakuShutokuYMD());
            item.setDbT1001HihokenshaDaicho_shikakuShutokuTodokedeYMD(entity.get被保台帳().getShikakuShutokuTodokedeYMD());
            item.setDbT1001HihokenshaDaicho_ichigoShikakuShutokuYMD(entity.get被保台帳().getIchigoShikakuShutokuYMD());
            item.setDbT1001HihokenshaDaicho_hihokennshaKubunCode(entity.get被保台帳().getHihokennshaKubunCode());
            item.setDbT1001HihokenshaDaicho_shikakuSoshitsuJiyuCode(entity.get被保台帳().getShikakuSoshitsuJiyuCode());
            item.setDbT1001HihokenshaDaicho_shikakuSoshitsuYMD(entity.get被保台帳().getShikakuSoshitsuYMD());
            item.setDbT1001HihokenshaDaicho_shikakuSoshitsuTodokedeYMD(entity.get被保台帳().getShikakuSoshitsuTodokedeYMD());
            item.setDbT1001HihokenshaDaicho_shikakuHenkoJiyuCode(entity.get被保台帳().getShikakuHenkoJiyuCode());
            item.setDbT1001HihokenshaDaicho_shikakuHenkoYMD(entity.get被保台帳().getShikakuHenkoYMD());
            item.setDbT1001HihokenshaDaicho_shikakuHenkoTodokedeYMD(entity.get被保台帳().getShikakuHenkoTodokedeYMD());
            item.setDbT1001HihokenshaDaicho_jushochitokureiTekiyoJiyuCode(entity.get被保台帳().getJushochitokureiTekiyoJiyuCode());
            item.setDbT1001HihokenshaDaicho_jushochitokureiTekiyoYMD(entity.get被保台帳().getJushochitokureiTekiyoYMD());
            item.setDbT1001HihokenshaDaicho_jushochitokureiTekiyoTodokedeYMD(entity.get被保台帳().getJushochitokureiTekiyoTodokedeYMD());
            item.setDbT1001HihokenshaDaicho_jushochitokureiKaijoJiyuCode(entity.get被保台帳().getJushochitokureiKaijoJiyuCode());
            item.setDbT1001HihokenshaDaicho_jushochitokureiKaijoYMD(entity.get被保台帳().getJushochitokureiKaijoYMD());
            item.setDbT1001HihokenshaDaicho_jushochitokureiKaijoTodokedeYMD(entity.get被保台帳().getJushochitokureiKaijoTodokedeYMD());
            item.setDbT1001HihokenshaDaicho_jushochiTokureiFlag(entity.get被保台帳().getJushochiTokureiFlag());
            item.setDbT1001HihokenshaDaicho_koikinaiJushochiTokureiFlag(entity.get被保台帳().getKoikinaiJushochiTokureiFlag());
            item.setDbT1001HihokenshaDaicho_koikinaiTokureiSochimotoShichosonCode(entity.get被保台帳().getKoikinaiTokureiSochimotoShichosonCode());
            item.setDbT1001HihokenshaDaicho_kyuShichosonCode(entity.get被保台帳().getKyuShichosonCode());
            item.setDbT1001HihokenshaDaicho_logicalDeletedFlag(entity.get被保台帳().getLogicalDeletedFlag());
            item.setKubun(entity.get事業対象者受給者区分());
            item.setFutanWariKikanTemp_nendo(entity.get負担割合期間().getNendo());
            item.setFutanWariKikanTemp_hihokenshaNo(entity.get負担割合期間().getHihokenshaNo());
            item.setFutanWariKikanTemp_futanWariaiKubun1(entity.get負担割合期間().getFutanWariaiKubun1());
            item.setFutanWariKikanTemp_yukoKaishiYMD1(entity.get負担割合期間().getYukoKaishiYMD1());
            item.setFutanWariKikanTemp_yukoShuryoYMD1(entity.get負担割合期間().getYukoShuryoYMD1());
            item.setFutanWariKikanTemp_shikakuKubun1(entity.get負担割合期間().getShikakuKubun1());
            item.setFutanWariKikanTemp_futanWariaiKubun2(entity.get負担割合期間().getFutanWariaiKubun2());
            item.setFutanWariKikanTemp_yukoKaishiYMD2(entity.get負担割合期間().getYukoKaishiYMD2());
            item.setFutanWariKikanTemp_yukoShuryoYMD2(entity.get負担割合期間().getYukoShuryoYMD2());
            item.setFutanWariKikanTemp_shikakuKubun2(entity.get負担割合期間().getShikakuKubun2());
            item.setShokisaiHihokenshaNo(entity.get証記載保険者番号());
            setTempType_宛名1(item, entity);
            setTempType_宛名2(item, entity);
            setTempType_宛先(item, entity);
            tableWriter.insert(item);
            insertShoKofuKaishu(entity);
        } else {
            if (entity.get被保台帳() != null) {
                ExpandedInformation expandedInformation
                        = new ExpandedInformation(CODE, DATANAME, entity.get被保台帳().getHihokenshaNo().getColumnValue());
                personalDataList.add(PersonalData.of(entity.get被保台帳().getShikibetsuCode(), expandedInformation));
                ShoriKekkaKakuninListCSVEntity shoriKekkaKakuninListCSVEntity = new ShoriKekkaKakuninListCSVEntity();
                shoriKekkaKakuninListCSVEntity.set被保険者番号(entity.get被保台帳().getHihokenshaNo().getColumnValue());
                shoriKekkaKakuninListCSVEntity.set確認内容(確認内容);
                shoriKekkaKakuninEucCsvWriter.writeLine(shoriKekkaKakuninListCSVEntity);
            }
        }
    }

    private void setTempType_宛名1(RiyoshaFutanwariaishoEntity item, RiyoshaFutanwariaishoTempEntity entity) {
        item.setShikibetsuTaisho_shikibetsuCode(entity.get宛名().getShikibetsuCode());
        item.setShikibetsuTaisho_genLasdecCode(entity.get宛名().getGenLasdecCode());
        item.setShikibetsuTaisho_kyuLasdecCode(entity.get宛名().getKyuLasdecCode());
        item.setShikibetsuTaisho_kyuLasdecCodeRenban(entity.get宛名().getKyuLasdecCodeRenban());
        item.setShikibetsuTaisho_gyomuCode(entity.get宛名().getGyomuCode());
        item.setShikibetsuTaisho_rirekiNo(entity.get宛名().getRirekiNo());
        item.setShikibetsuTaisho_currentFlag(entity.get宛名().getCurrentFlag());
        item.setShikibetsuTaisho_juminShubetsuCode(entity.get宛名().getJuminShubetsuCode());
        item.setShikibetsuTaisho_kojinNo(entity.get宛名().getKojinNo());
        item.setShikibetsuTaisho_hojinNo(entity.get宛名().getHojinNo());
        item.setShikibetsuTaisho_shoriYMD(entity.get宛名().getShoriYMD());
        item.setShikibetsuTaisho_idoJiyuCode(entity.get宛名().getIdoJiyuCode());
        item.setShikibetsuTaisho_idoYMD(entity.get宛名().getIdoYMD());
        item.setShikibetsuTaisho_todokedeJiyuCode(entity.get宛名().getTodokedeJiyuCode());
        item.setShikibetsuTaisho_todokedeYMD(entity.get宛名().getTodokedeYMD());
        item.setShikibetsuTaisho_idoRiyuCode(entity.get宛名().getIdoRiyuCode());
        item.setShikibetsuTaisho_meisho(entity.get宛名().getMeisho());
        item.setShikibetsuTaisho_kanaMeisho(entity.get宛名().getKanaMeisho());
        item.setShikibetsuTaisho_kannaiKangaiKubun(entity.get宛名().getKannaiKangaiKubun());
        item.setShikibetsuTaisho_yubinNo(entity.get宛名().getYubinNo());
        item.setShikibetsuTaisho_choikiCode(entity.get宛名().getChoikiCode());
        item.setShikibetsuTaisho_zenkokuJushoCode(entity.get宛名().getZenkokuJushoCode());
        item.setShikibetsuTaisho_jusho(entity.get宛名().getJusho());
        item.setShikibetsuTaisho_banchiCode1(entity.get宛名().getBanchiCode1());
        item.setShikibetsuTaisho_banchiCode2(entity.get宛名().getBanchiCode2());
        item.setShikibetsuTaisho_banchiCode3(entity.get宛名().getBanchiCode3());
        item.setShikibetsuTaisho_banchiCode4(entity.get宛名().getBanchiCode4());
        item.setShikibetsuTaisho_banchi(entity.get宛名().getBanchi());
        item.setShikibetsuTaisho_katagaki(entity.get宛名().getKatagaki());
        item.setShikibetsuTaisho_katagakiInjiFlag(entity.get宛名().getKatagakiInjiFlag());
        item.setShikibetsuTaisho_gyoseikuCode(entity.get宛名().getGyoseikuCode());
        item.setShikibetsuTaisho_gyoseikuName(entity.get宛名().getGyoseikuName());
        item.setShikibetsuTaisho_chikuCode1(entity.get宛名().getChikuCode1());
        item.setShikibetsuTaisho_chikuName1(entity.get宛名().getChikuName1());
        item.setShikibetsuTaisho_chikuCode2(entity.get宛名().getChikuCode2());
        item.setShikibetsuTaisho_chikuName2(entity.get宛名().getChikuName2());
        item.setShikibetsuTaisho_chikuCode3(entity.get宛名().getChikuCode3());
        item.setShikibetsuTaisho_chikuName3(entity.get宛名().getChikuName3());
        item.setShikibetsuTaisho_shogakkokuCode(entity.get宛名().getShogakkokuCode());
        item.setShikibetsuTaisho_shogakkokuName(entity.get宛名().getShogakkokuName());
        item.setShikibetsuTaisho_chugakkokuCode(entity.get宛名().getChugakkokuCode());
        item.setShikibetsuTaisho_chugakkokuName(entity.get宛名().getChugakkokuName());
        item.setShikibetsuTaisho_tohyokuCode(entity.get宛名().getTohyokuCode());
        item.setShikibetsuTaisho_tohyokuName(entity.get宛名().getTohyokuName());
        item.setShikibetsuTaisho_juminJotaiCode(entity.get宛名().getJuminJotaiCode());
        item.setShikibetsuTaisho_setaiCode(entity.get宛名().getSetaiCode());
        item.setShikibetsuTaisho_seinengappiYMD(entity.get宛名().getSeinengappiYMD());
        item.setShikibetsuTaisho_seinengappiFushoKubun(entity.get宛名().getSeinengappiFushoKubun());
        item.setShikibetsuTaisho_seibetsuCode(entity.get宛名().getSeibetsuCode());
        item.setShikibetsuTaisho_tsuzukigaraCode(entity.get宛名().getTsuzukigaraCode());
        item.setShikibetsuTaisho_tsuzukigara(entity.get宛名().getTsuzukigara());
        item.setShikibetsuTaisho_kazokuNo(entity.get宛名().getKazokuNo());
        item.setShikibetsuTaisho_juminhyoHyojijun(entity.get宛名().getJuminhyoHyojijun());
        item.setShikibetsuTaisho_kikaYMD(entity.get宛名().getKikaYMD());
        item.setShikibetsuTaisho_kanjiShimei(entity.get宛名().getKanjiShimei());
        item.setShikibetsuTaisho_kanaShimei(entity.get宛名().getKanaShimei());
        item.setShikibetsuTaisho_juminhyoCode(entity.get宛名().getJuminhyoCode());
        item.setShikibetsuTaisho_honsekiZenkokuJushoCode(entity.get宛名().getHonsekiZenkokuJushoCode());
        item.setShikibetsuTaisho_honsekiChoikiCode(entity.get宛名().getHonsekiChoikiCode());
        item.setShikibetsuTaisho_honsekiJusho(entity.get宛名().getHonsekiJusho());
        item.setShikibetsuTaisho_honsekiBanchi(entity.get宛名().getHonsekiBanchi());
        item.setShikibetsuTaisho_hittosha(entity.get宛名().getHittosha());
        item.setShikibetsuTaisho_gaikokujinShimei(entity.get宛名().getGaikokujinShimei());
        item.setShikibetsuTaisho_gaikokujinHeikimei(entity.get宛名().getGaikokujinHeikimei());
        item.setShikibetsuTaisho_gaikokujinKanaShimei(entity.get宛名().getGaikokujinKanaShimei());
        item.setShikibetsuTaisho_tsushomei(entity.get宛名().getTsushomei());
        item.setShikibetsuTaisho_shimeiRiyoKubun(entity.get宛名().getShimeiRiyoKubun());
        item.setShikibetsuTaisho_kanaTsushomei(entity.get宛名().getKanaTsushomei());
        item.setShikibetsuTaisho_katakanaHyoki(entity.get宛名().getKatakanaHyoki());
        item.setShikibetsuTaisho_kokusekiChiikiCode(entity.get宛名().getKokusekiChiikiCode());
        item.setShikibetsuTaisho_zairyuShikakuCode(entity.get宛名().getZairyuShikakuCode());
        item.setShikibetsuTaisho_zairyuKikanCode(entity.get宛名().getZairyuKikanCode());
        item.setShikibetsuTaisho_zairyuKikantoManryoYMD(entity.get宛名().getZairyuKikantoManryoYMD());
        item.setShikibetsuTaisho_zairyuCardtoNo(entity.get宛名().getZairyuCardtoNo());
        item.setShikibetsuTaisho_zairyuCardtoYukoYMD(entity.get宛名().getZairyuCardtoYukoYMD());
        item.setShikibetsuTaisho_dai30Jono45niKiteisuruKubun(entity.get宛名().getDai30Jono45niKiteisuruKubun());
        item.setShikibetsuTaisho_setainushiShikibetsuCode(entity.get宛名().getSetainushiShikibetsuCode());
        item.setShikibetsuTaisho_setainushiMei(entity.get宛名().getSetainushiMei());
        item.setShikibetsuTaisho_hojinKeitaiCode(entity.get宛名().getHojinKeitaiCode());
        item.setShikibetsuTaisho_hojinKeitaiMeisho(entity.get宛名().getHojinKeitaiMeisho());
        item.setShikibetsuTaisho_hojinKeitaiRyakusho(entity.get宛名().getHojinKeitaiRyakusho());
        item.setShikibetsuTaisho_hojinMeishoHenshuKubun(entity.get宛名().getHojinMeishoHenshuKubun());
        item.setShikibetsuTaisho_hojinKeitaiRyakushoKubun(entity.get宛名().getHojinKeitaiRyakushoKubun());
        item.setShikibetsuTaisho_hojinMeisho(entity.get宛名().getHojinMeisho());
        item.setShikibetsuTaisho_hojinKanaMeisho(entity.get宛名().getHojinKanaMeisho());
        item.setShikibetsuTaisho_hojinShitenMeisho(entity.get宛名().getHojinShitenMeisho());
        item.setShikibetsuTaisho_hojinShitenKanaMeisho(entity.get宛名().getHojinShitenKanaMeisho());
        item.setShikibetsuTaisho_daihyoshaShikibetsuCode(entity.get宛名().getDaihyoshaShikibetsuCode());
        item.setShikibetsuTaisho_daihyoshaJuminShubetsu(entity.get宛名().getDaihyoshaJuminShubetsu());
        item.setShikibetsuTaisho_daihyoshaShimei(entity.get宛名().getDaihyoshaShimei());
        item.setShikibetsuTaisho_daihyoshaKanaShimei(entity.get宛名().getDaihyoshaKanaShimei());
        item.setShikibetsuTaisho_daihyoshaNihonjinShimei(entity.get宛名().getDaihyoshaNihonjinShimei());
        item.setShikibetsuTaisho_daihyoshaNihonjinKanaShimei(entity.get宛名().getDaihyoshaNihonjinKanaShimei());
        item.setShikibetsuTaisho_daihyoshaGaikokujinShimei(entity.get宛名().getDaihyoshaGaikokujinShimei());
        item.setShikibetsuTaisho_daihyoshaGaikokujinHeikimei(entity.get宛名().getDaihyoshaGaikokujinHeikimei());
        item.setShikibetsuTaisho_daihyoshaGaikokujinKanaShimei(entity.get宛名().getDaihyoshaGaikokujinKanaShimei());
        item.setShikibetsuTaisho_daihyoshaTsushomei(entity.get宛名().getDaihyoshaTsushomei());
        item.setShikibetsuTaisho_daihyoshaShimeiRiyoKubun(entity.get宛名().getDaihyoshaShimeiRiyoKubun());
        item.setShikibetsuTaisho_daihyoshaKanaTsushomei(entity.get宛名().getDaihyoshaKanaTsushomei());
        item.setShikibetsuTaisho_daihyoshaKannaiKangaiKubun(entity.get宛名().getDaihyoshaKannaiKangaiKubun());
        item.setShikibetsuTaisho_daihyoshaYubinNo(entity.get宛名().getDaihyoshaYubinNo());
        item.setShikibetsuTaisho_daihyoshaChoikiCode(entity.get宛名().getDaihyoshaChoikiCode());
        item.setShikibetsuTaisho_daihyoshaZenkokuJushoCode(entity.get宛名().getDaihyoshaZenkokuJushoCode());
        item.setShikibetsuTaisho_daihyoshaJusho(entity.get宛名().getDaihyoshaJusho());
        item.setShikibetsuTaisho_daihyoshaBanchiCode1(entity.get宛名().getDaihyoshaBanchiCode1());
        item.setShikibetsuTaisho_daihyoshaBanchiCode2(entity.get宛名().getDaihyoshaBanchiCode2());
        item.setShikibetsuTaisho_daihyoshaBanchiCode3(entity.get宛名().getDaihyoshaBanchiCode3());
        item.setShikibetsuTaisho_daihyoshaBanchiCode4(entity.get宛名().getDaihyoshaBanchiCode4());
        item.setShikibetsuTaisho_daihyoshaBanchi(entity.get宛名().getDaihyoshaBanchi());
        item.setShikibetsuTaisho_daihyoshaKatagaki(entity.get宛名().getDaihyoshaKatagaki());
        item.setShikibetsuTaisho_ninkachiendantaiTorokuShikakuKubun(entity.get宛名().getNinkachiendantaiTorokuShikakuKubun());
        item.setShikibetsuTaisho_ninkachiendantaiNinkaYMD(entity.get宛名().getNinkachiendantaiNinkaYMD());

    }

    private void setTempType_宛名2(RiyoshaFutanwariaishoEntity item, RiyoshaFutanwariaishoTempEntity entity) {
        item.setShikibetsuTaisho_kojinHojinKBN(entity.get宛名().getKojinHojinKBN());
        item.setShikibetsuTaisho_kyoyushaMeisho(entity.get宛名().getKyoyushaMeisho());
        item.setShikibetsuTaisho_kyoyushaKanaMeisho(entity.get宛名().getKyoyushaKanaMeisho());
        item.setShikibetsuTaisho_torokuJiyuCode(entity.get宛名().getTorokuJiyuCode());
        item.setShikibetsuTaisho_torokuIdoYMD(entity.get宛名().getTorokuIdoYMD());
        item.setShikibetsuTaisho_torokuTodokedeYMD(entity.get宛名().getTorokuTodokedeYMD());
        item.setShikibetsuTaisho_juteiJiyuCode(entity.get宛名().getJuteiJiyuCode());
        item.setShikibetsuTaisho_juteiIdoYMD(entity.get宛名().getJuteiIdoYMD());
        item.setShikibetsuTaisho_juteiTodokedeYMD(entity.get宛名().getJuteiTodokedeYMD());
        item.setShikibetsuTaisho_shojoJiyuCode(entity.get宛名().getShojoJiyuCode());
        item.setShikibetsuTaisho_shojoIdoYMD(entity.get宛名().getShojoIdoYMD());
        item.setShikibetsuTaisho_shojoTodokedeYMD(entity.get宛名().getShojoTodokedeYMD());
        item.setShikibetsuTaisho_aimaiShojobiMongon(entity.get宛名().getAimaiShojobiMongon());
        item.setShikibetsuTaisho_jutonaiYubinNo(entity.get宛名().getJutonaiYubinNo());
        item.setShikibetsuTaisho_jutonaiChoikiCode(entity.get宛名().getJutonaiChoikiCode());
        item.setShikibetsuTaisho_jutonaiJusho(entity.get宛名().getJutonaiJusho());
        item.setShikibetsuTaisho_jutonaiBanchiCode1(entity.get宛名().getJutonaiBanchiCode1());
        item.setShikibetsuTaisho_jutonaiBanchiCode2(entity.get宛名().getJutonaiBanchiCode2());
        item.setShikibetsuTaisho_jutonaiBanchiCode3(entity.get宛名().getJutonaiBanchiCode3());
        item.setShikibetsuTaisho_jutonaiBanchiCode4(entity.get宛名().getJutonaiBanchiCode4());
        item.setShikibetsuTaisho_jutonaiBanchi(entity.get宛名().getJutonaiBanchi());
        item.setShikibetsuTaisho_jutonaiKatagaki(entity.get宛名().getJutonaiKatagaki());
        item.setShikibetsuTaisho_jutonaiKatagakiInjiFlag(entity.get宛名().getJutonaiKatagakiInjiFlag());
        item.setShikibetsuTaisho_tennyumaeYubinNo(entity.get宛名().getTennyumaeYubinNo());
        item.setShikibetsuTaisho_tennyumaeZenkokuJushoCode(entity.get宛名().getTennyumaeZenkokuJushoCode());
        item.setShikibetsuTaisho_tennyumaeJusho(entity.get宛名().getTennyumaeJusho());
        item.setShikibetsuTaisho_tennyumaeBanchi(entity.get宛名().getTennyumaeBanchi());
        item.setShikibetsuTaisho_tennyumaeKatagaki(entity.get宛名().getTennyumaeKatagaki());
        item.setShikibetsuTaisho_tennyumaeSetainushimei(entity.get宛名().getTennyumaeSetainushimei());
        item.setShikibetsuTaisho_tennyumaeKyusei(entity.get宛名().getTennyumaeKyusei());
        item.setShikibetsuTaisho_saishuJutochiYubinNo(entity.get宛名().getSaishuJutochiYubinNo());
        item.setShikibetsuTaisho_saishuJutochiZenkokuJushoCode(entity.get宛名().getSaishuJutochiZenkokuJushoCode());
        item.setShikibetsuTaisho_saishuJutochiJusho(entity.get宛名().getSaishuJutochiJusho());
        item.setShikibetsuTaisho_saishuJutochiBanchi(entity.get宛名().getSaishuJutochiBanchi());
        item.setShikibetsuTaisho_saishuJutochiKatagaki(entity.get宛名().getSaishuJutochiKatagaki());
        item.setShikibetsuTaisho_saishuJutochiSetainushimei(entity.get宛名().getSaishuJutochiSetainushimei());
        item.setShikibetsuTaisho_tenshutsuYoteiIdoYMD(entity.get宛名().getTenshutsuYoteiIdoYMD());
        item.setShikibetsuTaisho_tenshutsuYoteiYubinNo(entity.get宛名().getTenshutsuYoteiYubinNo());
        item.setShikibetsuTaisho_tenshutsuYoteiZenkokuJushoCode(entity.get宛名().getTenshutsuYoteiZenkokuJushoCode());
        item.setShikibetsuTaisho_tenshutsuYoteiJusho(entity.get宛名().getTenshutsuYoteiJusho());
        item.setShikibetsuTaisho_tenshutsuYoteiBanchi(entity.get宛名().getTenshutsuYoteiBanchi());
        item.setShikibetsuTaisho_tenshutsuYoteiKatagaki(entity.get宛名().getTenshutsuYoteiKatagaki());
        item.setShikibetsuTaisho_tenshutsuYoteiSetainushimei(entity.get宛名().getTenshutsuYoteiSetainushimei());
        item.setShikibetsuTaisho_tenshutsuKakuteiIdoYMD(entity.get宛名().getTenshutsuKakuteiIdoYMD());
        item.setShikibetsuTaisho_tenshutsuKakuteiTsuchiYMD(entity.get宛名().getTenshutsuKakuteiTsuchiYMD());
        item.setShikibetsuTaisho_tenshutsuKakuteiYubinNo(entity.get宛名().getTenshutsuKakuteiYubinNo());
        item.setShikibetsuTaisho_tenshutsuKakuteiZenkokuJushoCode(entity.get宛名().getTenshutsuKakuteiZenkokuJushoCode());
        item.setShikibetsuTaisho_tenshutsuKakuteiJusho(entity.get宛名().getTenshutsuKakuteiJusho());
        item.setShikibetsuTaisho_tenshutsuKakuteiBanchi(entity.get宛名().getTenshutsuKakuteiBanchi());
        item.setShikibetsuTaisho_tenshutsuKakuteiKatagaki(entity.get宛名().getTenshutsuKakuteiKatagaki());
        item.setShikibetsuTaisho_tenshutsuKakuteiSetainushimei(entity.get宛名().getTenshutsuKakuteiSetainushimei());
        item.setShikibetsuTaisho_juminhyoUtsushiHakkoSeigyoKubun(entity.get宛名().getJuminhyoUtsushiHakkoSeigyoKubun());
        item.setShikibetsuTaisho_renrakusaki1(entity.get宛名().getRenrakusaki1());
        item.setShikibetsuTaisho_kensakuRenrakusaki1(entity.get宛名().getKensakuRenrakusaki1());
        item.setShikibetsuTaisho_renrakusakiKubun1(entity.get宛名().getRenrakusakiKubun1());
        item.setShikibetsuTaisho_renrakusaki2(entity.get宛名().getRenrakusaki2());
        item.setShikibetsuTaisho_kensakuRenrakusaki2(entity.get宛名().getKensakuRenrakusaki2());
        item.setShikibetsuTaisho_renrakusakiKubun2(entity.get宛名().getRenrakusakiKubun2());
        item.setShikibetsuTaisho_renrakusaki3(entity.get宛名().getRenrakusaki3());
        item.setShikibetsuTaisho_kensakuRenrakusaki3(entity.get宛名().getKensakuRenrakusaki3());
        item.setShikibetsuTaisho_renrakusakiKubun3(entity.get宛名().getRenrakusakiKubun3());
        item.setShikibetsuTaisho_mailAddress(entity.get宛名().getMailAddress());
        item.setShikibetsuTaisho_biko(entity.get宛名().getBiko());
        item.setShikibetsuTaisho_kanaName(entity.get宛名().getKanaName());
        item.setShikibetsuTaisho_gaikokujinKanaName(entity.get宛名().getGaikokujinKanaName());
        item.setShikibetsuTaisho_kanaTsushoName(entity.get宛名().getKanaTsushoName());
        item.setShikibetsuTaisho_jutogaiKanriUpdateCount(entity.get宛名().getJutogaiKanriUpdateCount());
        item.setShikibetsuTaisho_jutogaiKanriTorokuNo(entity.get宛名().getJutogaiKanriTorokuNo());
        item.setShikibetsuTaisho_jutogaiKojinKihonUpdateCount(entity.get宛名().getJutogaiKojinKihonUpdateCount());
        item.setShikibetsuTaisho_jutogaiKojinKihonTorokuNo(entity.get宛名().getJutogaiKojinKihonTorokuNo());
        item.setShikibetsuTaisho_jutogaiNihonjinUpdateCount(entity.get宛名().getJutogaiNihonjinUpdateCount());
        item.setShikibetsuTaisho_jutogaiNihonjinTorokuNo(entity.get宛名().getJutogaiNihonjinTorokuNo());
        item.setShikibetsuTaisho_jutogaiGaikokujinUpdateCount(entity.get宛名().getJutogaiGaikokujinUpdateCount());
        item.setShikibetsuTaisho_jutogaiGaikokujinTorokuNo(entity.get宛名().getJutogaiGaikokujinTorokuNo());
        item.setShikibetsuTaisho_hojinUpdateCount(entity.get宛名().getHojinUpdateCount());
        item.setShikibetsuTaisho_hojinTorokuNo(entity.get宛名().getHojinTorokuNo());
        item.setShikibetsuTaisho_kyoyushaUpdateCount(entity.get宛名().getKyoyushaUpdateCount());
        item.setShikibetsuTaisho_kyoyushaTorokuNo(entity.get宛名().getKyoyushaTorokuNo());
        item.setShikibetsuTaisho_shimeiSearchTorokuNo(entity.get宛名().getShimeiSearchTorokuNo());
        item.setShikibetsuTaisho_yusenShimeiUpdateCount(entity.get宛名().getYusenShimeiUpdateCount());
        item.setShikibetsuTaisho_yusenShimeiTimestamp(entity.get宛名().getYusenShimeiTimestamp());
        item.setShikibetsuTaisho_jukiTorokuNo(entity.get宛名().getJukiTorokuNo());
    }

    private void setTempType_宛先(RiyoshaFutanwariaishoEntity item, RiyoshaFutanwariaishoTempEntity entity) {
        item.setAtesaki_shikibetsuCode(entity.get宛先().getShikibetsuCode());
        item.setAtesaki_atesakiShubetsu(entity.get宛先().getAtesakiShubetsu());
        item.setAtesaki_gyomubetsuPrimaryKey(entity.get宛先().getGyomubetsuPrimaryKey());
        item.setAtesaki_gyomuCode(entity.get宛先().getGyomuCode());
        item.setAtesaki_subGyomuCode(entity.get宛先().getSubGyomuCode());
        item.setAtesaki_gyomuGroupCode(entity.get宛先().getGyomuGroupCode());
        item.setAtesaki_gyomuGroupName(entity.get宛先().getGyomuGroupName());
        item.setAtesaki_subGyomuGroupCode(entity.get宛先().getSubGyomuGroupCode());
        item.setAtesaki_subGyomuGroupName(entity.get宛先().getSubGyomuGroupName());
        item.setAtesaki_kamokuCode(entity.get宛先().getKamokuCode());
        item.setAtesaki_gyomuKoyuKey(entity.get宛先().getGyomuKoyuKey());
        item.setAtesaki_kannaiKangaiKubun(entity.get宛先().getKannaiKangaiKubun());
        item.setAtesaki_zenkokuJushoCode(entity.get宛先().getZenkokuJushoCode());
        item.setAtesaki_choikiCode(entity.get宛先().getChoikiCode());
        item.setAtesaki_jusho(entity.get宛先().getJusho());
        item.setAtesaki_yubinNo(entity.get宛先().getYubinNo());
        item.setAtesaki_banchiCode1(entity.get宛先().getBanchiCode1());
        item.setAtesaki_banchiCode2(entity.get宛先().getBanchiCode2());
        item.setAtesaki_banchiCode3(entity.get宛先().getBanchiCode3());
        item.setAtesaki_banchiCode4(entity.get宛先().getBanchiCode4());
        item.setAtesaki_banchi(entity.get宛先().getBanchi());
        item.setAtesaki_katagakiInjiFlag(entity.get宛先().getKatagakiInjiFlag());
        item.setAtesaki_katagaki(entity.get宛先().getKatagaki());
        item.setAtesaki_gyoseikuCode(entity.get宛先().getGyoseikuCode());
        item.setAtesaki_gyoseiku(entity.get宛先().getGyoseiku());
        item.setAtesaki_chikuCode1(entity.get宛先().getChikuCode1());
        item.setAtesaki_chiku1(entity.get宛先().getChiku1());
        item.setAtesaki_chikuCode2(entity.get宛先().getChikuCode2());
        item.setAtesaki_chiku2(entity.get宛先().getChiku2());
        item.setAtesaki_chikuCode3(entity.get宛先().getChikuCode3());
        item.setAtesaki_chiku3(entity.get宛先().getChiku3());
        item.setAtesaki_juminShubetsuCode(entity.get宛先().getJuminShubetsuCode());
        item.setAtesaki_juminJotaiCode(entity.get宛先().getJuminJotaiCode());
        item.setAtesaki_kanjiShimei(entity.get宛先().getKanjiShimei());
        item.setAtesaki_kanaShimei(entity.get宛先().getKanaShimei());
        item.setAtesaki_gaikokujinShimei(entity.get宛先().getGaikokujinShimei());
        item.setAtesaki_gaikokujinHeikimei(entity.get宛先().getGaikokujinHeikimei());
        item.setAtesaki_gaikokujinKanaShimei(entity.get宛先().getGaikokujinKanaShimei());
        item.setAtesaki_tsushomei(entity.get宛先().getTsushomei());
        item.setAtesaki_kanaTsushomei(entity.get宛先().getKanaTsushomei());
        item.setAtesaki_shimeiRiyoKubun(entity.get宛先().getShimeiRiyoKubun());
        item.setAtesaki_kyoyushaMeisho(entity.get宛先().getKyoyushaMeisho());
        item.setAtesaki_kyoyushaKanaMeisho(entity.get宛先().getKyoyushaKanaMeisho());
        item.setAtesaki_hojinKeitaiCode(entity.get宛先().getHojinKeitaiCode());
        item.setAtesaki_hojinMeiHenshuKubun(entity.get宛先().getHojinMeiHenshuKubun());
        item.setAtesaki_hojinKeitaiRyakushoKubun(entity.get宛先().getHojinKeitaiRyakushoKubun());
        item.setAtesaki_hojinMeisho(entity.get宛先().getHojinMeisho());
        item.setAtesaki_hojinKanaMeisho(entity.get宛先().getHojinKanaMeisho());
        item.setAtesaki_hojinShitenMeisho(entity.get宛先().getHojinShitenMeisho());
        item.setAtesaki_hojinShitenKanaMeisho(entity.get宛先().getHojinShitenKanaMeisho());
        item.setAtesaki_sofusakiMeisho(entity.get宛先().getSofusakiMeisho());
        item.setAtesaki_sofusakiKanaMeisho(entity.get宛先().getSofusakiKanaMeisho());
        item.setAtesaki_renrakusaki1(entity.get宛先().getRenrakusaki1());
        item.setAtesaki_renrakusakiKubun1(entity.get宛先().getRenrakusakiKubun1());
        item.setAtesaki_renrakusaki2(entity.get宛先().getRenrakusaki2());
        item.setAtesaki_renrakusakiKubun2(entity.get宛先().getRenrakusakiKubun2());
        item.setAtesaki_renrakusaki3(entity.get宛先().getRenrakusaki3());
        item.setAtesaki_renrakusakiKubun3(entity.get宛先().getRenrakusakiKubun3());
        item.setAtesaki_mailAddress(entity.get宛先().getMailAddress());
        item.setAtesaki_dainoKankeiCode(entity.get宛先().getDainoKankeiCode());
        item.setAtesaki_biko(entity.get宛先().getBiko());
        item.setAtesaki_honninJuminShubetsuCode(entity.get宛先().getHonninJuminShubetsuCode());
        item.setAtesaki_honninJuminJotaiCode(entity.get宛先().getHonninJuminJotaiCode());
        item.setAtesaki_honninKanjiShimei(entity.get宛先().getHonninKanjiShimei());
        item.setAtesaki_honninKanaShimei(entity.get宛先().getHonninKanaShimei());
        item.setAtesaki_honninGaikokujinShimei(entity.get宛先().getHonninGaikokujinShimei());
        item.setAtesaki_honninGaikokujinHeikimei(entity.get宛先().getHonninGaikokujinHeikimei());
        item.setAtesaki_honninGaikokujinKanaShimei(entity.get宛先().getHonninGaikokujinKanaShimei());
        item.setAtesaki_honninTsushomei(entity.get宛先().getHonninTsushomei());
        item.setAtesaki_honninKanaTsushomei(entity.get宛先().getHonninKanaTsushomei());
        item.setAtesaki_honninShimeiRiyoKubun(entity.get宛先().getHonninShimeiRiyoKubun());
        item.setAtesaki_honninKyoyushaMeisho(entity.get宛先().getHonninKyoyushaMeisho());
        item.setAtesaki_honninKyoyushaKanaMeisho(entity.get宛先().getHonninKyoyushaKanaMeisho());
        item.setAtesaki_honninHojinKeitaiCode(entity.get宛先().getHonninHojinKeitaiCode());
        item.setAtesaki_honninHojinMeiHenshuKubun(entity.get宛先().getHonninHojinMeiHenshuKubun());
        item.setAtesaki_honninHojinKeitaiRyakushoKubun(entity.get宛先().getHonninHojinKeitaiRyakushoKubun());
        item.setAtesaki_honninHojinMeisho(entity.get宛先().getHonninHojinMeisho());
        item.setAtesaki_honninHojinKanaMeisho(entity.get宛先().getHonninHojinKanaMeisho());
        item.setAtesaki_honninHojinShitenMeisho(entity.get宛先().getHonninHojinShitenMeisho());
        item.setAtesaki_honninHojinShitenKanaMeisho(entity.get宛先().getHonninHojinShitenKanaMeisho());
        item.setAtesaki_honninDaihyoshaShikibetsuCode(entity.get宛先().getHonninDaihyoshaShikibetsuCode());
        item.setAtesaki_honninDaihyoshaJuminShubetsuCode(entity.get宛先().getHonninDaihyoshaJuminShubetsuCode());
        item.setAtesaki_honninDaihyoshaShimei(entity.get宛先().getHonninDaihyoshaShimei());
        item.setAtesaki_honninDaihyoshaKanaShimei(entity.get宛先().getHonninDaihyoshaKanaShimei());
        item.setAtesaki_honninDaihyoshaNihonjinShimei(entity.get宛先().getHonninDaihyoshaNihonjinShimei());
        item.setAtesaki_honninDaihyoshaNihonjinKanaShimei(entity.get宛先().getHonninDaihyoshaNihonjinKanaShimei());
        item.setAtesaki_honninDaihyoshaGaikokujinShimei(entity.get宛先().getHonninDaihyoshaGaikokujinShimei());
        item.setAtesaki_honninDaihyoshaGaikokujinHeikimei(entity.get宛先().getHonninDaihyoshaGaikokujinHeikimei());
        item.setAtesaki_honninDaihyoshaGaikokujinKanaShimei(entity.get宛先().getHonninDaihyoshaGaikokujinKanaShimei());
        item.setAtesaki_honninDaihyoshaTsushomei(entity.get宛先().getHonninDaihyoshaTsushomei());
        item.setAtesaki_honninDaihyoshaShimeiRiyoKubun(entity.get宛先().getHonninDaihyoshaShimeiRiyoKubun());
        item.setAtesaki_honninDaihyoshaKanaTsushomei(entity.get宛先().getHonninDaihyoshaKanaTsushomei());
        item.setAtesaki_setainushiShikibetsuCode(entity.get宛先().getSetainushiShikibetsuCode());
        item.setAtesaki_setainushiKannaiKangaiKubun(entity.get宛先().getSetainushiKannaiKangaiKubun());
        item.setAtesaki_setainushiZenkokuJushoCode(entity.get宛先().getSetainushiZenkokuJushoCode());
        item.setAtesaki_setainushiChoikiCode(entity.get宛先().getSetainushiChoikiCode());
        item.setAtesaki_setainushiJusho(entity.get宛先().getSetainushiJusho());
        item.setAtesaki_setainushiYubinNo(entity.get宛先().getSetainushiYubinNo());
        item.setAtesaki_setainushiBanchiCode1(entity.get宛先().getSetainushiBanchiCode1());
        item.setAtesaki_setainushiBanchiCode2(entity.get宛先().getSetainushiBanchiCode2());
        item.setAtesaki_setainushiBanchiCode3(entity.get宛先().getSetainushiBanchiCode3());
        item.setAtesaki_setainushiBanchiCode4(entity.get宛先().getSetainushiBanchiCode4());
        item.setAtesaki_setainushiBanchi(entity.get宛先().getSetainushiBanchi());
        item.setAtesaki_setainushiKatagakiInjiFlag(entity.get宛先().getSetainushiKatagakiInjiFlag());
        item.setAtesaki_setainushiKatagaki(entity.get宛先().getSetainushiKatagaki());
        item.setAtesaki_setainushiGyoseikuCode(entity.get宛先().getSetainushiGyoseikuCode());
        item.setAtesaki_setainushiGyoseikuName(entity.get宛先().getSetainushiGyoseikuName());
        item.setAtesaki_setainushiChikuCode1(entity.get宛先().getSetainushiChikuCode1());
        item.setAtesaki_setainushiChiku1(entity.get宛先().getSetainushiChiku1());
        item.setAtesaki_setainushiChikuCode2(entity.get宛先().getSetainushiChikuCode2());
        item.setAtesaki_setainushiChiku2(entity.get宛先().getSetainushiChiku2());
        item.setAtesaki_setainushiChikuCode3(entity.get宛先().getSetainushiChikuCode3());
        item.setAtesaki_setainushiChiku3(entity.get宛先().getSetainushiChiku3());
        item.setAtesaki_setainushiJuminShubetsuCode(entity.get宛先().getSetainushiJuminShubetsuCode());
        item.setAtesaki_setainushiJuminJotaiCode(entity.get宛先().getSetainushiJuminJotaiCode());
        item.setAtesaki_setainushiKanjiShimei(entity.get宛先().getSetainushiKanjiShimei());
        item.setAtesaki_setainushiKanaShimei(entity.get宛先().getSetainushiKanaShimei());
        item.setAtesaki_setainushiGaikokujinShimei(entity.get宛先().getSetainushiGaikokujinShimei());
        item.setAtesaki_setainushiGaikokujinHeikimei(entity.get宛先().getSetainushiGaikokujinHeikimei());
        item.setAtesaki_setainushiGaikokujinKanaShimei(entity.get宛先().getSetainushiGaikokujinKanaShimei());
        item.setAtesaki_setainushiTsushomei(entity.get宛先().getSetainushiTsushomei());
        item.setAtesaki_setainushiKanaTsushomei(entity.get宛先().getSetainushiKanaTsushomei());
        item.setAtesaki_setainushiShimeiRiyoKubun(entity.get宛先().getSetainushiShimeiRiyoKubun());
        item.setAtesaki_setainushiRenrakusaki1(entity.get宛先().getSetainushiRenrakusaki1());
        item.setAtesaki_setainushiRenrakusakiKubun1(entity.get宛先().getSetainushiRenrakusakiKubun1());
        item.setAtesaki_setainushiRenrakusaki2(entity.get宛先().getSetainushiRenrakusaki2());
        item.setAtesaki_setainushiRenrakusakiKubun2(entity.get宛先().getSetainushiRenrakusakiKubun2());
        item.setAtesaki_setainushiRenrakusaki3(entity.get宛先().getSetainushiRenrakusaki3());
        item.setAtesaki_setainushiRenrakusakiKubun3(entity.get宛先().getSetainushiRenrakusakiKubun3());
        item.setAtesaki_setainushiMailAddress(entity.get宛先().getSetainushiMailAddress());
        item.setAtesaki_dainoninShikibetsuCode(entity.get宛先().getDainoninShikibetsuCode());
        item.setAtesaki_honninSetaiCode(entity.get宛先().getHonninSetaiCode());
        item.setAtesaki_dainoninSetaiCode(entity.get宛先().getDainoninSetaiCode());
    }

    private void insertShoKofuKaishu(RiyoshaFutanwariaishoTempEntity entity) {
        DbT7037ShoKofuKaishuEntity item = new DbT7037ShoKofuKaishuEntity();
        if (entity.get被保台帳() == null) {
            return;
        }
        item.setHihokenshaNo(entity.get被保台帳().getHihokenshaNo());
        item.setKofuShoShurui(交付証種類_003);
        if (entity.get証交付回収() == null) {
            item.setRirekiNo(NUM_ONE);
        } else {
            item.setRirekiNo(entity.get証交付回収().getRirekiNo() + NUM_ONE);
        }
        item.setShichosonCode(entity.get被保台帳().getShichosonCode());
        item.setShikibetsuCode(entity.get被保台帳().getShikibetsuCode());
        item.setKofuYMD(new FlexibleDate(parameter.get交付年月日().toDateString()));
        item.setYukoKigenYMD(new FlexibleDate(parameter.get年度().getYearValue() + NUM_ONE, NUM_SEVEN, NUM_THIRTY_ONE));
        item.setKofuJiyu(get交付事由(entity));
        item.setKofuRiyu(CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.負担割合証交付事由.getCodeShubetsu(), new Code(get交付事由(entity))));
        item.setKaishuJiyu(回収事由_00);
        item.setTanpyoHakkoUmuFlag(false);
        item.setHakkoShoriTimestamp(new YMDHMS(parameter.getバッチ起動時処理日時()));
        item.setLogicalDeletedFlag(false);
        shoKofuKaishuWriter.insert(item);
    }

    private RString get交付事由(RiyoshaFutanwariaishoTempEntity entity) {
        RString 交付事由 = RString.EMPTY;
        if (定数_1.equals(entity.get利用者負担割合().getHanteiKubun())) {
            交付事由 = 交付事由_01;
        } else if (定数_2.equals(entity.get利用者負担割合().getHanteiKubun())) {
            交付事由 = 交付事由_02;
        } else if (定数_3.equals(entity.get利用者負担割合().getHanteiKubun())) {
            交付事由 = 交付事由_03;
        } else if (定数_4.equals(entity.get利用者負担割合().getHanteiKubun())) {
            交付事由 = 交付事由_04;
        }
        return 交付事由;
    }

    @Override
    protected void afterExecute() {
        shoriKekkaKakuninEucCsvWriter.close();
        shoriKekkaKakuninListManager.spool(shoriKekkaKakuninEucFilePath);
        AccessLogger.logReport(personalDataList);
    }
}
