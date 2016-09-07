/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA800010_;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.aa.aax.business.core.ido.IIdoData;
import jp.co.ndensan.reams.aa.aax.service.managers.JukiIdoFlowParameterFinderFactory;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.juminidorendoshikakutoroku.JuminIdoRendoShikakuTorokuMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.euc.juminidorendoshikakutoroku.FuseigoListCsvEntity;
import jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakutoroku.JuminIdoRendoShikakuToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 住民異動連動資格登録のProcess処理クラスです。
 *
 * @reamsid_L DBA-1410-010 yaodongsheng
 */
public class JuminIdoRendoShikakuTorokuProcess extends BatchProcessBase<UaFt200FindShikibetsuTaishoEntity> {

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString FILENAME = new RString("fuseigoList.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBA800001");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.juminidorendoshikakutoroku."
            + "IJuminIdoRendoShikakuTorokuMapper.getShikibetsuTaishoPsm");
    private IIdoData idoData;
    private FileSpoolManager manager;
    private RString filePath;
    @BatchWriter
    private CsvWriter<FuseigoListCsvEntity> csvWriter;

    @Override
    protected void initialize() {
        idoData = JukiIdoFlowParameterFinderFactory.createInstance().find異動情報();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<ShikibetsuCode> 識別コードリスト = new ArrayList<>();
        if (idoData != null) {
            for (SetaiCode setaiCode : idoData.get世帯コードs()) {
                識別コードリスト.addAll(idoData.get異動世帯情報().get(setaiCode).get識別コードs());
            }
        }
        key.set識別コードリスト(識別コードリスト);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        JuminIdoRendoShikakuTorokuMybatisParameter mybatisParameter = new JuminIdoRendoShikakuTorokuMybatisParameter();
        mybatisParameter.setPsmShikibetsuTaisho(psmShikibetsuTaisho);
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        filePath = Path.combinePath(manager.getEucOutputDirectry(), FILENAME);
        csvWriter = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(getEncode()).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build();
    }

    @Override
    protected void process(UaFt200FindShikibetsuTaishoEntity entity) {
        new JuminIdoRendoShikakuToroku().juminIdoRendoKyotsu(entity, csvWriter);
    }

    @Override
    protected void afterExecute() {
        manager.spool(filePath);
    }

    private Encode getEncode() {
        RString sakiEncodeKeitai = DbBusinessConfig.get(ConfigNameDBU.EUC共通_文字コード, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        Encode encode = Encode.UTF_8withBOM;
        if (new RString("1").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_8withBOM;
        } else if (new RString("2").equals(sakiEncodeKeitai)) {
            encode = Encode.SJIS;
        } else if (new RString("3").equals(sakiEncodeKeitai)) {
            encode = Encode.SJIS;
        }
        return encode;
    }
}
