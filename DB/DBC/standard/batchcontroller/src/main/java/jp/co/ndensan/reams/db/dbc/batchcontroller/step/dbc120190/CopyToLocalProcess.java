/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120190;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.IcchiJoken;
import static jp.co.ndensan.reams.db.dbc.definition.core.IcchiJoken.前方一致;
import static jp.co.ndensan.reams.db.dbc.definition.core.IcchiJoken.完全一致;
import static jp.co.ndensan.reams.db.dbc.definition.core.IcchiJoken.後方一致;
import static jp.co.ndensan.reams.db.dbc.definition.core.IcchiJoken.部分一致;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class CopyToLocalProcess extends SimpleBatchProcessBase {

    /**
     * filePath
     */
    public static final RString PARAMETER_IN_FILEPATH;
    /**
     * sharedName
     */
    public static final RString PARAMETER_IN_SHAREDNAME;
    /**
     * icchiJoken
     */
    public static final RString PARAMETER_IN_ICCHIJOKEN;
    /**
     * filePathList
     */
    public static final RString PARAMETER_OUT_FILEPATHLIST;

    static {
        PARAMETER_IN_FILEPATH = new RString("filePath");
        PARAMETER_IN_SHAREDNAME = new RString("sharedName");
        PARAMETER_IN_ICCHIJOKEN = new RString("icchiJoken");
        PARAMETER_OUT_FILEPATHLIST = new RString("filePathList");
    }

    /**
     * 拡張子CSV
     */
    private final RString 拡張子CSV = new RString("csv");
    private static final int NUMBER3 = 3;

    //パラメータ受取変数
    InputParameter<RString> filePath;
    InputParameter<RString> sharedName;
    InputParameter<IcchiJoken> icchiJoken;

    //パラメータ引渡変数
    OutputParameter<HashMap<RString, RString>> filePathList;

    @Override
    protected void process() {

        List<UzT0885SharedFileEntryEntity> sharedFiles = SharedFile.searchSharedFile(getSharedFileNameJoken(sharedName.getValue()));

        HashMap<RString, RString> fileList = new HashMap<>();

        RString maeSharedName = RString.EMPTY;
        RString atoSharedName;
        for (UzT0885SharedFileEntryEntity sharedfile : sharedFiles) {
            atoSharedName = sharedfile.getSharedFileName();
            if (atoSharedName.compareTo(maeSharedName) != 0) {
                SharedFile.copyToLocal(FilesystemName.fromString(atoSharedName), FilesystemPath.fromString(filePath.getValue()));
                fileList.put(sharedfile.getSharedFileName(),
                        getFileFullPath(filePath.getValue().concat(sharedfile.getLocalFileName()), atoSharedName));
                maeSharedName = atoSharedName;
            }

        }

        filePathList = new OutputParameter<>();
        filePathList.setValue(fileList);

    }

    private RString getFileFullPath(RString checkFilePath, RString checkSharedName) {

        // TODO ファイル指定で共有ファイルに指定できればいいのだが、現状でフォルダ指定でしか出来ないため、その考慮
        if (checkSharedName.substringReturnAsPossible(checkFilePath.length() - NUMBER3, checkFilePath.length()).equalsIgnoreCase(拡張子CSV)) {
            return checkFilePath.concat(checkSharedName);
        } else {
            return checkFilePath.concat(new File(checkFilePath.toString()).list(getFileExtensionFilter(".csv"))[0]);
        }

    }

    private FilenameFilter getFileExtensionFilter(String extension) {
        final RString extension_ = new RString(extension);
        return new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                boolean ret = name.endsWith(extension_.toString());
                return ret;
            }
        };
    }

    private RString getSharedFileNameJoken(RString sharedFileName) {

        if (sharedFileName == null || sharedFileName.isEmpty()) {
            return RString.EMPTY;
        }

        RStringBuilder rsb = new RStringBuilder();

        switch (icchiJoken.getValue()) {
            case 前方一致:
                rsb.append(sharedFileName);
                rsb.append("%");
                break;
            case 後方一致:
                rsb.append("%");
                rsb.append(sharedFileName);
                break;
            case 部分一致:
                rsb.append("%");
                rsb.append(sharedFileName);
                rsb.append("%");
                break;
            case 完全一致:
            default:
                rsb.append(sharedFileName);
        }

        return rsb.toRString();
    }

}
