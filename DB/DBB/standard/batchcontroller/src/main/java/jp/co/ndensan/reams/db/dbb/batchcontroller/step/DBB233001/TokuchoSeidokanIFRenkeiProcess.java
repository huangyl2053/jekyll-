/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB233001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb233001.TokuchouSeidoKanIFRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokuchouSeidoKanIFRenkeiDTAEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb233001.TokuchouSeidoKanIFRenkeiEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosofujohorenkei.ITokuchoSofuJohoRenkeiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.fld.FldWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB233001_特徴制度間Ｉ／Ｆ連携 作成です。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
public class TokuchoSeidokanIFRenkeiProcess extends BatchProcessBase<TokuchouSeidoKanIFRenkeiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.dbb233001.ITokuchouSeidoKanIFRenkeiMapper.select連携ファイル用");

    private static final RString DTA_NAME_PREFIX = new RString("Z99_550_");
    private static final RString DTA_NAME_SUFFIX = new RString(".DTA");
    private TokuchouSeidoKanIFRenkeiProcessParameter parameter;
    private List<DbT7051KoseiShichosonMasterEntity> 広域市町村情報;
    private List<RString> ファイル出力path;
    private List<RString> ファイル入力path;
    private Map<RString, FldWriter<TokuchouSeidoKanIFRenkeiDTAEntity>> map;
    private Map<RString, RString> 情報map;
    private static final RString レコード区分_2 = new RString("2");
    private static final RString 通知内容コード_00 = new RString("00");
    private static final RString 特別徴収制度コード_0 = new RString("0");
    private static final RString 金額1_2 = new RString("00000000000");
    private static final RString COPY = new RString("copy");
    /**
     * outputPathです。
     */
    public static final RString PARAMETER_OUT_OUTPUTPATH;
    /**
     * inputPathです。
     */
    public static final RString PARAMETER_IN_INPUTPATH;

    static {
        PARAMETER_OUT_OUTPUTPATH = new RString("outputPath");
        PARAMETER_IN_INPUTPATH = new RString("inputPath");
    }

    private OutputParameter<List<RString>> outputPath;
    private OutputParameter<List<RString>> inputPath;
    @BatchWriter
    private FldWriter<TokuchouSeidoKanIFRenkeiDTAEntity> writer;

    @Override
    protected void initialize() {
        ファイル出力path = new ArrayList<>();
        ファイル入力path = new ArrayList<>();
        outputPath = new OutputParameter<>();
        inputPath = new OutputParameter<>();
        map = new HashMap<>();
        情報map = new HashMap<>();
        広域市町村情報 = getMapper(ITokuchoSofuJohoRenkeiMapper.class).select広域市町村情報();

        if (!広域市町村情報.isEmpty()) {
            for (DbT7051KoseiShichosonMasterEntity 情報 : 広域市町村情報) {
                parameter.get市町村コードリスト().add(情報.getShichosonCode().value());
            }
        }
        parameter.set処理年度(new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString()));

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID,
                parameter.toTokuchouSeidoKanIFRenkeiMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        for (DbT7051KoseiShichosonMasterEntity 情報 : 広域市町村情報) {
            RString ファイル名 = DTA_NAME_PREFIX.concat(情報.getShichosonShokibetsuID()).concat(DTA_NAME_SUFFIX);
            RString dtaFilePath_output = Path.combinePath(Path.getTmpDirectoryPath(), ファイル名);
            RString dtaFilePath_input = Path.combinePath(Path.getTmpDirectoryPath(), COPY.concat(ファイル名));
            writer = new FldWriter.InstanceBuilder(dtaFilePath_input)
                    .setNewLine(NewLine.LF)
                    .setEncodeUtf8(false).build();
            情報map.put(情報.getShichosonCode().value(), ファイル名);
            map.put(情報.getShichosonCode().value(), writer);
            ファイル出力path.add(dtaFilePath_output);
            ファイル入力path.add(dtaFilePath_input);
        }
    }

    @Override
    protected void process(TokuchouSeidoKanIFRenkeiEntity entity) {
        map.get(entity.getDt市町村コード()).writeLine(getDtaEntity(entity));
    }

    @Override
    protected void afterExecute() {
        outputPath.setValue(ファイル出力path);
        inputPath.setValue(ファイル入力path);
    }

    private TokuchouSeidoKanIFRenkeiDTAEntity getDtaEntity(TokuchouSeidoKanIFRenkeiEntity t) {
        TokuchouSeidoKanIFRenkeiDTAEntity dTAEntity = new TokuchouSeidoKanIFRenkeiDTAEntity();
        dTAEntity.setレコード区分(レコード区分_2);
        dTAEntity.set市町村コード(t.getDt市町村コード());
        dTAEntity.set特別徴収義務者コード(t.getDt特別徴収義務者コード().toRString());
        dTAEntity.set通知内容コード(通知内容コード_00);
        dTAEntity.set予備1(RString.EMPTY);
        dTAEntity.set特別徴収制度コード(特別徴収制度コード_0);
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
        dTAEntity.set金額1(金額1_2);
        dTAEntity.set金額2(金額1_2);
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
}
