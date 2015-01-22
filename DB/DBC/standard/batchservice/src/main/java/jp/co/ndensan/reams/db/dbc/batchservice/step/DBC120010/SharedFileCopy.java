/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.IcchiJoken;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 *
 * @author N2810 久保 里史
 */
public class SharedFileCopy extends SimpleBatchProcessBase {

    //パラメータ名
    public static final RString PARAMETER_IN_FILEPATH = new RString("filePath");
    public static final RString PARAMETER_IN_SHAREDNAME = new RString("sharedName");
    public static final RString PARAMETER_IN_ICCHIJOKEN = new RString("icchiJoken");
    public static final RString PARAMETER_OUT_FILEPATHLIST = new RString("filePathList");

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
            if (atoSharedName.compareTo(maeSharedName) == 0) {
            } else {
                SharedFile.copyToLocal(FilesystemName.fromString(atoSharedName), FilesystemPath.fromString(filePath.getValue()));
                fileList.put(sharedfile.getSharedFileName(), filePath.getValue().concat(atoSharedName));
                maeSharedName = atoSharedName;
            }
        }

        filePathList.setValue(fileList);

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
