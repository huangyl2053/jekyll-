/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD301010;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbd.batchcontroller.flow.DBD301010_HikazeiNenkinTaishoshaJohoTorikomi;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100201.FileReaderProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル取込process処理クラスです.
 *
 * @reamsid_L DBD-4910-030 x_youyj
 */
public class FileReaderProcess extends SimpleBatchProcessBase {

    private FileReaderProcessParameter parameter;
    private static final RString 月次 = new RString("1");
    private static final RString 年次 = new RString("0");
    private RString ファイル名;
    private static final RString Z5100000 = new RString("Z5100000_");
    private static final RString Z5200000 = new RString("Z5200000_");
    private static final RString アンダーライン = new RString("_");
    private static final RString 拡張子 = new RString(".DTA");
    private List<UzT0885SharedFileEntryEntity> dataList;
    private OutputParameter<List<UzT0885SharedFileEntryEntity>> entryList;
    /**
     * 引数出力
     */
    public static final RString PARAMETER_OUT_COUNT;

    static {
        PARAMETER_OUT_COUNT = new RString("entryList");
    }

    @Override
    protected void beforeExecute() {
        entryList = new OutputParameter<>();
        dataList = new ArrayList<>();
    }

    @Override
    protected void process() {
        if (!parameter.get構成市町村コードリスト().isEmpty()) {
            for (RString 市町村コード : parameter.get構成市町村コードリスト()) {
                if (月次.equals(parameter.get処理区分())) {
                    ファイル名 = Z5200000.concat(parameter.get処理年度().toDateString())
                            .concat(parameter.get処理区分()).concat(parameter.get対象月())
                            .concat(アンダーライン).concat(市町村コード).concat(拡張子);
                    getFileData(ファイル名);
                } else if (年次.equals(parameter.get処理区分())) {
                    ファイル名 = Z5100000.concat(parameter.get処理年度().toDateString())
                            .concat(parameter.get処理区分()).concat(parameter.get対象月())
                            .concat(アンダーライン).concat(市町村コード).concat(拡張子);
                    getFileData(ファイル名);
                }
            }
        } else {
            if (月次.equals(parameter.get処理区分())) {
                ファイル名 = Z5200000.concat(parameter.get処理年度().toDateString())
                        .concat(parameter.get処理区分()).concat(parameter.get対象月()).concat(拡張子);
                getFileData(ファイル名);
            } else if (年次.equals(parameter.get処理区分())) {
                ファイル名 = Z5100000.concat(parameter.get処理年度().toDateString())
                        .concat(parameter.get処理区分()).concat(parameter.get対象月()).concat(拡張子);
                getFileData(ファイル名);
            }
        }
        if (dataList == null || dataList.size() <= 0) {
            throw new ApplicationException(DbdErrorMessages.アップロードファイル無し.getMessage());
        }
    }

    @Override
    protected void afterExecute() {
        entryList.setValue(dataList);
    }

    private List<UzT0885SharedFileEntryEntity> getFileData(RString ファイル名) {
        List<UzT0885SharedFileEntryEntity> fileList = null;
        try {
            fileList = SharedFile.searchSharedFile(ファイル名);
        } catch (Exception e) {
            Logger.getLogger(DBD301010_HikazeiNenkinTaishoshaJohoTorikomi.class.getName()).log(Level.SEVERE, null, e);
        }
        if (!fileList.isEmpty()) {
            dataList.addAll(fileList);
        }
        return dataList;
    }

}
