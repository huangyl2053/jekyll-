/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5710002;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri.ImagekanriJoho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710002.ImagePanelDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710002.ImagePanelHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5710002.ImagePanelValidationHandler;
import jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteiimagesyutsuryoku.YokaigoninteiimageShutsuryokuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定イメージ情報出力のクラスです。
 *
 * @reamsid_L DBE-1670-011 wangxiaodong
 */
public class ImagePanel {

    private static final RString 書庫化ファイル名 = new RString("Image.zip");
    private static final RString 調査票 = new RString("1");
    private static final RString 調査票概況 = new RString("2");
    private static final RString 主治医意見書 = new RString("3");
    private static final RString その他資料 = new RString("4");
    private static final RString 拡張子 = new RString(".png");

    /**
     * 要介護認定イメージ情報出力画面をloadします。
     *
     * @param div 要介護認定イメージ情報出力画面
     * @return ResponseData
     */
    public ResponseData<ImagePanelDiv> onLoad(ImagePanelDiv div) {
        ResponseData<ImagePanelDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }

    /**
     * イメージファイルをdownLoadします。
     *
     * @param div 要介護認定イメージ情報出力画面
     * @return ResponseData
     */
    public ResponseData<ImagePanelDiv> onclick_btnDownLoadCheck(ImagePanelDiv div) {
        ImagekanriJoho イメージ情報 = ViewStateHolder.get(ViewStateKeys.イメージ情報, ImagekanriJoho.class);
        ReadOnlySharedFileEntryDescriptor ro_sfed = new ReadOnlySharedFileEntryDescriptor(
                new FilesystemName(イメージ情報.get証記載保険者番号().concat(イメージ情報.get被保険者番号())), イメージ情報.getイメージ共有ファイルID());
        YokaigoninteiimageShutsuryokuFinder finder = new YokaigoninteiimageShutsuryokuFinder(ro_sfed);
        ImagePanelHandler handler = new ImagePanelHandler();
        List<RString> 存在するファイル = existFileList(finder.getSharedFile(), ro_sfed);
        List<RString> 存在する調査票ファイル = finder.get存在したイメージファイル(handler.get調査票イメージ(), 存在するファイル);
        List<RString> 存在する調査票概況ファイル = finder.get存在したイメージファイル(handler.get調査票概況ファイル(), 存在するファイル);
        List<RString> 存在する主治医意見書ファイル = finder.get存在したイメージファイル(handler.get主治医意見書イメージ(), 存在するファイル);
        List<RString> 存在するその他資料ファイル = finder.get存在したイメージファイル(handler.getその他資料イメージ(), 存在するファイル);
        ValidationMessageControlPairs controlPairs = new ImagePanelValidationHandler(div)
                .do事前チェック(存在するファイル, 存在する調査票ファイル, 存在する調査票概況ファイル, 存在する主治医意見書ファイル, 存在するその他資料ファイル);
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * イメージファイルをdownLoadします。
     *
     * @param div 要介護認定イメージ情報出力画面
     * @param response IDownLoadServletResponse
     * @return ResponseData
     */
    public IDownLoadServletResponse onclick_btnDownLoad(ImagePanelDiv div, IDownLoadServletResponse response) {
        ImagekanriJoho イメージ情報 = ViewStateHolder.get(ViewStateKeys.イメージ情報, ImagekanriJoho.class);
        ReadOnlySharedFileEntryDescriptor ro_sfed = new ReadOnlySharedFileEntryDescriptor(
                new FilesystemName(イメージ情報.get証記載保険者番号().concat(イメージ情報.get被保険者番号())), イメージ情報.getイメージ共有ファイルID());
        RString zipPath = Path.combinePath(Path.getTmpDirectoryPath(), 書庫化ファイル名);
        File zipFile = new File(zipPath.toString());
        if (zipFile.exists()) {
            zipFile.delete();
        }
        ZipUtil.createFromFiles(zipPath, createDownloadFileList(div, ro_sfed));
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(書庫化ファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(zipPath), opts);
        return SharedFileDirectAccessDownload.directAccessDownload(
                new SharedFileDirectAccessDescriptor(entry, 書庫化ファイル名), response);
    }

    private List<RString> createDownloadFileList(ImagePanelDiv div, ReadOnlySharedFileEntryDescriptor ro_sfed) {
        YokaigoninteiimageShutsuryokuFinder finder = new YokaigoninteiimageShutsuryokuFinder(ro_sfed);
        ImagePanelHandler handler = new ImagePanelHandler();
        List<RString> 存在するファイル = existFileList(finder.getSharedFile(), ro_sfed);
        List<RString> 存在する調査票ファイル = finder.get存在したイメージファイル(handler.get調査票イメージ(), 存在するファイル);
        List<RString> 存在する調査票概況ファイル = finder.get存在したイメージファイル(handler.get調査票概況ファイル(), 存在するファイル);
        List<RString> 存在する主治医意見書ファイル = finder.get存在したイメージファイル(handler.get主治医意見書イメージ(), 存在するファイル);
        List<RString> 存在するその他資料ファイル = finder.get存在したイメージファイル(handler.getその他資料イメージ(), 存在するファイル);
        List<RString> fileList = new ArrayList<>();
        if (div.getChkImage().getSelectedKeys().contains(調査票) && !存在する調査票ファイル.isEmpty()) {
            fileList.addAll(存在する調査票ファイル);
        }
        if (div.getChkImage().getSelectedKeys().contains(調査票概況) && !存在する調査票概況ファイル.isEmpty()) {
            fileList.addAll(存在する調査票概況ファイル);
        }
        if (div.getChkImage().getSelectedKeys().contains(主治医意見書) && !存在する主治医意見書ファイル.isEmpty()) {
            fileList.addAll(存在する主治医意見書ファイル);
        }
        if (div.getChkImage().getSelectedKeys().contains(その他資料) && !存在するその他資料ファイル.isEmpty()) {
            fileList.addAll(存在するその他資料ファイル);
        }
        List<RString> result = new ArrayList<>();
        for (RString fileName : fileList) {
            result.add(ro_sfed.getDirectAccessPath().concat("\\IMG\\").concat(fileName).concat(拡張子));
        }
        return result.isEmpty() ? Collections.EMPTY_LIST : result;
    }

    private List<RString> existFileList(List<RString> fileList, ReadOnlySharedFileEntryDescriptor ro_sfed) {
        List<RString> result = new ArrayList<>();
        for (RString fileName : fileList) {
            File file = new File(ro_sfed.getDirectAccessPath().concat("\\IMG").concat(fileName).toString());
            if (file.exists()) {
                result.add(fileName);
            }
        }
        return result.isEmpty() ? Collections.EMPTY_LIST : result;
    }
}
