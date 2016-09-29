/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb233001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb233001.TokuchouSeidoKanIFRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb233001.TokuchouSeidoKanIFRenkeiEntity;
import jp.co.ndensan.reams.db.dbb.entity.dta.dbb233001.TokuchouSeidoKanIFRenkeiDTAEntity;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.fld.FldWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB233001_特徴制度間Ｉ／Ｆ連携 作成です。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
public class CreateRenkeiFileProcess extends BatchProcessBase<TokuchouSeidoKanIFRenkeiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.dbb233001.ITokuchouSeidoKanIFRenkeiMapper.select連携ファイル用");

    private static final RString DTA_NAME_PREFIX = new RString("Z99_550_");
    private static final RString DTA_NAME_SUFFIX = new RString(".DTA");
    private TokuchouSeidoKanIFRenkeiProcessParameter parameter;
    private List<KoseiShichoson> 広域市町村情報;
    private List<RString> ファイル出力List;
    private Map map;
    private Map 情報map;
//    private FileSpoolManager manager;
    @BatchWriter
    private FldWriter<TokuchouSeidoKanIFRenkeiDTAEntity> writer;

    @Override
    protected void initialize() {
        ファイル出力List = new ArrayList<>();
        map = new HashMap<>();
        情報map = new HashMap<>();
        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        広域市町村情報 = finder.getKoseiShichosonList().records();
        for (KoseiShichoson 情報 : 広域市町村情報) {
            parameter.get市町村コードリスト().add(情報.get市町村コード().value());
        }
//        parameter.set処理年度(new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
//                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID,
                parameter.toTokuchouSeidoKanIFRenkeiMyBatisParameter());
    }

    @Override
    protected void createWriter() {
//        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, RString.EMPTY, UzUDE0831EucAccesslogFileType.Other);
//        RString spoolWorkPath = manager.getSharedFileName();
        for (KoseiShichoson 情報 : 広域市町村情報) {
//            dtaFilePath = Path.combinePath(spoolWorkPath);
            RString ファイル名 = DTA_NAME_PREFIX.concat(情報.get市町村識別ID()).concat(DTA_NAME_SUFFIX);
            writer = new FldWriter.InstanceBuilder(ファイル名)
                    .setNewLine(NewLine.CRLF)
                    .setEncodeJIS().build();
            情報map.put(情報.get市町村コード().value(), ファイル名);
            map.put(情報.get市町村コード().value(), writer);
        }
    }

    @Override
    protected void process(TokuchouSeidoKanIFRenkeiEntity entity) {
        for (Object key : map.keySet()) {

            if (entity.getDt市町村コード().equals(key)) {
                ファイル出力List.add((RString) 情報map.get(key));
                FldWriter<TokuchouSeidoKanIFRenkeiDTAEntity> fileWriter = (FldWriter<TokuchouSeidoKanIFRenkeiDTAEntity>) map.get(key);
                fileWriter.writeLine(getDtaEntity(entity));
            }
        }
        ファイル出力List = removeDuplicate(ファイル出力List);
    }

    @Override
    protected void afterExecute() {
//        AccessLogger.log(AccessLogType.照会, PersonalData.of(ShikibetsuCode.EMPTY));
        for (RString fileName : ファイル出力List) {
            FilesystemName sharedFileName = new FilesystemName(fileName);
            SharedFile.defineSharedFile(sharedFileName);
            FilesystemPath 絶対パス = new FilesystemPath(Path.getTmpDirectoryPath());
            SharedFile.copyToSharedFile(絶対パス, sharedFileName);
        }
    }

    private TokuchouSeidoKanIFRenkeiDTAEntity getDtaEntity(TokuchouSeidoKanIFRenkeiEntity t) {
        TokuchouSeidoKanIFRenkeiDTAEntity dTAEntity = new TokuchouSeidoKanIFRenkeiDTAEntity();
        dTAEntity.setレコード区分(new RString("2"));
        dTAEntity.set市町村コード(t.getDt市町村コード());
        dTAEntity.set特別徴収義務者コード(t.getDt特別徴収義務者コード().toRString());
        dTAEntity.set通知内容コード(new RString("00"));
        dTAEntity.set予備1(RString.EMPTY);
        dTAEntity.set特別徴収制度コード(new RString("0"));
        dTAEntity.set作成年月日(t.getDt作成年月日());
        dTAEntity.set基礎年金番号(t.getDt基礎年金番号());
        dTAEntity.set年金コード(t.getDt年金コード());
        dTAEntity.set予備2(RString.EMPTY);
        dTAEntity.set生年月日(t.getDt生年月日());
        dTAEntity.set性別(t.getDt性別());
        dTAEntity.setカナ氏名(t.getDtカナ氏名());
        dTAEntity.set氏名1_シフトコード(t.getDtシフトコード1());
        dTAEntity.set漢字氏名(t.getDt漢字氏名());
        dTAEntity.set氏名2_シフトコード(t.getDtシフトコード2());
        dTAEntity.set郵便番号(t.getDt郵便番号());
        dTAEntity.setカナ住所(t.getDtカナ住民());
        dTAEntity.set住所3_シフトコード(t.getDtシフトコード3());
        dTAEntity.set漢字住所(t.getDt漢字住所());
        dTAEntity.set住所4_シフトコード(t.getDtシフトコード4());
        dTAEntity.set各種区分(t.getDt各種区分());
        dTAEntity.set処理結果コード(t.getDt処理結果());
        dTAEntity.set後期移管コード(t.getDt後期移管コード());
        dTAEntity.set各種年月日(t.getDt各種年月日());
        dTAEntity.set金額1(new RString("00000000000"));
        dTAEntity.set金額2(new RString("00000000000"));
        dTAEntity.set金額3(t.getDt各種金額欄3());
        dTAEntity.set予備3(RString.EMPTY);
        dTAEntity.set共済年金証書記号番号(t.getDt共済年金証記号番号());
        dTAEntity.set介護被保険者番号(t.get介護保険被保険者番号());
        dTAEntity.set個人コード区分(t.get個人コード区分());
        dTAEntity.set個人コード(t.get個人コード());
        dTAEntity.set介護住所地特例(t.get介護保険住所地特例区分());
        dTAEntity.set介護捕捉年月日(t.get捕捉年月日());
        dTAEntity.set介護待機フラグ(t.get待機フラグ());
        dTAEntity.set予備4(RString.EMPTY);

        return dTAEntity;
    }

    private List<RString> removeDuplicate(List<RString> list) {
        HashSet s = new HashSet(list);
        list.clear();
        list.addAll(s);
        return list;
    }
}
