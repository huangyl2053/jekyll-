/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180060;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kenkoukaruterenkeidata.KenkouKaruteRenkeiDataMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata.KenkouKaruteRenkeiDATEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata.KenkouKaruteRenkeiDataEditEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata.KenkouKaruteRenkeiDataEntity;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.fld.FldWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 * 健康かるて連携データ作成のProcessクラスです。
 *
 * @reamsid_L DBC-5020-030 wangxiaodong
 */
public class KenkouKaruteRenkeiDataProcess extends BatchProcessBase<KenkouKaruteRenkeiDataEntity> {

    private static final RString SELECT_KENKOUKARUTERENKEIDATA = new RString("jp.co.ndensan.reams.db.dbc."
            + "persistence.db.mapper.relate.kenkoukaruterenkeidata.IKenkouKaruteRenkeiDataMapper.createKenkouKaruteRenkeiData");
    private static final RString FILENAME = new RString("HCSETF8.DAT");
    private static final RString DAT_WRITER_DELIMITER = new RString("-");
    private KenkouKaruteRenkeiDataMybatisParameter mybitisParamter;
    private RString eucFilePath;
    private boolean isデータあり;

    @BatchWriter
    private FldWriter<KenkouKaruteRenkeiDATEntity> fldWriter;

    @Override
    protected void initialize() {
        isデータあり = false;
        mybitisParamter = new KenkouKaruteRenkeiDataMybatisParameter();
        mybitisParamter.setPsmShikibetsuTaisho(getMybitisParamter());
        eucFilePath = Path.combinePath(Path.getTmpDirectoryPath(), FILENAME);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_KENKOUKARUTERENKEIDATA, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        fldWriter = new FldWriter.InstanceBuilder(eucFilePath)
                .setEncodeUtf8(true)
                .setDelimiter(DAT_WRITER_DELIMITER)
                .setNewLine(NewLine.CRLF).build();
    }

    @Override
    protected void process(KenkouKaruteRenkeiDataEntity entity) {
        isデータあり = true;
        fldWriter.writeLine(new KenkouKaruteRenkeiDataEditEntity(entity).getWriteLine内容());
        AccessLogger.log(AccessLogType.照会, toPersonalData(entity.get識別コード(), entity.get被保険者番号()));
    }

    private RString getMybitisParamter() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先))
                .setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住民);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        key.set住民状態(juminJotaiList);
        key.set住民種別(juminShubetsuList);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            FilesystemName ファイル名称 = new FilesystemName(FILENAME);
            SharedFileDescriptor sfd = new ReadOnlySharedFileDescriptor(ファイル名称);
            SharedFile.defineSharedFile(sfd);
            SharedFile.copyToSharedFile(new FilesystemPath(eucFilePath), ファイル名称);
        }
    }

    private PersonalData toPersonalData(RString 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号);
        return PersonalData.of(new ShikibetsuCode(識別コード), expandedInfo);
    }
}
