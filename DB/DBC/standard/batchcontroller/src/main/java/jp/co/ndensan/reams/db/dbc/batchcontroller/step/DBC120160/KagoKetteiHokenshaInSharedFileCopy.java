/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120160;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 国保連から来たファイルのデータの取得処理
 */
public class KagoKetteiHokenshaInSharedFileCopy extends SimpleBatchProcessBase {

    /**
     * PARAMETER_IN_FILEPATH
     */
    public static final RString PARAMETER_IN_FILEPATH;
    /**
     * PARAMETER_IN_SHAREDNAME
     */
    public static final RString PARAMETER_IN_SHAREDNAME;
    /**
     * PARAMETER_OUT_FILEPATHLIST
     */
    public static final RString PARAMETER_OUT_FILEPATHLIST;

    static {
        PARAMETER_IN_FILEPATH = new RString("filePath");
        PARAMETER_IN_SHAREDNAME = new RString("sharedName");
        PARAMETER_OUT_FILEPATHLIST = new RString("filePathList");
    }
    private static final int INDEX_THREE = 3;

    private InputParameter<RString> filePath;
    private InputParameter<RString> sharedName;

    private OutputParameter<HashMap<RString, RString>> filePathList;

    private final RString 拡張子CSV = new RString("csv");

    /**
     * process
     */
    @Override
    protected void process() {
        List<UzT0885SharedFileEntryEntity> sharedFiles = SharedFile.searchSharedFile(
                getSharedFileName(sharedName.getValue()));

        if (sharedFiles.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.指定ファイルが存在しない.getMessage().
                    replace(sharedName.getValue().toString()));
        }

        HashMap<RString, RString> fileList = new HashMap<>();

        for (UzT0885SharedFileEntryEntity sharedfile : sharedFiles) {
            SharedFile.copyToLocal(FilesystemName.fromString(sharedfile.getSharedFileName()),
                    FilesystemPath.fromString(filePath.getValue()));
            fileList.put(sharedfile.getSharedFileName(), getFileFullPath(filePath.getValue().
                    concat(sharedfile.getLocalFileName()), sharedfile.getSharedFileName()));
        }

        filePathList = new OutputParameter<>();
        filePathList.setValue(fileList);
    }

    private RString getFileFullPath(RString checkFilePath, RString checkSharedName) {
        if (checkSharedName.substringReturnAsPossible(checkFilePath.length() - INDEX_THREE, checkFilePath.length()).equalsIgnoreCase(拡張子CSV)) {
            return checkFilePath.concat(checkSharedName);
        } else {
            return checkFilePath.concat(new File(checkFilePath.toString()).
                    list(getFileExtensionFilter(new RString(".csv")))[0]);
        }

    }

    private FilenameFilter getFileExtensionFilter(RString extension) {
        final RString extension2 = extension;
        return new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                boolean ret = name.endsWith(extension2.toString());
                return ret;
            }
        };
    }

    private RString getSharedFileName(RString sharedFileName) {
        if (sharedFileName == null || sharedFileName.isEmpty()) {
            return RString.EMPTY;
        }

        RStringBuilder rsb = new RStringBuilder();
        rsb.append(sharedFileName);
        rsb.append("%");
        return rsb.toRString();
    }
}
