/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB2110002;

import jp.co.ndensan.reams.db.dbb.business.core.tokuchoinfofdownloadinfo.TokuchoInfoFDownloadInfo;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002.DBB2110002StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110002.TokuchoInfoFDownloadDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2110002.TokuchoInfoFDownloadHandler;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;

/**
 * 画面設計_DBB2110002_特徴送付情報ダウンロードのクラスです。
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public class TokuchoInfoFDownload {

    private static final RString 単一 = new RString("単一");

    /**
     * 画面初期化のメソッドです。
     *
     * @param div TokuchoInfoFDownloadDiv
     * @return ResponseData
     */
    public ResponseData<TokuchoInfoFDownloadDiv> onLoad(TokuchoInfoFDownloadDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBB2110002StateName.単一状態);
    }

    /**
     * 「処理対象市町村」の切替のメソッドです。
     *
     * @param div TokuchoInfoFDownloadDiv
     * @return ResponseData
     */
    public ResponseData<TokuchoInfoFDownloadDiv> onClick_radShichosonSelect(TokuchoInfoFDownloadDiv div) {
        getHandler(div).処理対象市町村切替();
        return ResponseData.of(div).setState(DBB2110002StateName.単一状態);
    }

    /**
     * 「処理対象月」の切替のメソッドです。
     *
     * @param div TokuchoInfoFDownloadDiv
     * @return ResponseData
     */
    public ResponseData<TokuchoInfoFDownloadDiv> onClick_radTsukiSelect(TokuchoInfoFDownloadDiv div) {
        getHandler(div).処理対象月切替();
        return ResponseData.of(div).setState(DBB2110002StateName.広域状態);
    }

    /**
     * 処理対象市町村DropdownListのonChangeメソッドです。
     *
     * @param div TokuchoInfoFDownloadDiv
     * @return ResponseData
     */
    public ResponseData<TokuchoInfoFDownloadDiv> onChange_ddlShichosonSelect(TokuchoInfoFDownloadDiv div) {
        getHandler(div).処理対象市町村onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 処理対象月DropdownListのonChangeメソッドです。
     *
     * @param div TokuchoInfoFDownloadDiv
     * @return ResponseData
     */
    public ResponseData<TokuchoInfoFDownloadDiv> onChange_ddlTsuki(TokuchoInfoFDownloadDiv div) {
        getHandler(div).処理対象月onChange();
        return ResponseData.of(div).respond();
    }

    /**
     * 処理対象選択のonChangeメソッドです。
     *
     * @param div TokuchoInfoFDownloadDiv
     * @return ResponseData
     */
    public ResponseData<TokuchoInfoFDownloadDiv> onChange_dgkoikiShoriSelect(TokuchoInfoFDownloadDiv div) {
        getHandler(div).onChange_dgkoikiShoriSelect();
        return ResponseData.of(div).respond();
    }

    /**
     * 処理対象選択のonChangeメソッドです。
     *
     * @param div TokuchoInfoFDownloadDiv
     * @return ResponseData
     */
    public ResponseData<TokuchoInfoFDownloadDiv> onChange_dgTsukiShoriSelect(TokuchoInfoFDownloadDiv div) {
        getHandler(div).onChange_dgTsukiShoriSelect();
        return ResponseData.of(div).respond();
    }

    /**
     * ダウンロードのメソッドです。
     *
     * @param div TokuchoInfoFDownloadDiv
     * @param response IDownLoadServletResponse
     * @return ResponseData
     */
    public IDownLoadServletResponse onClick_DownLoad(TokuchoInfoFDownloadDiv div,
            IDownLoadServletResponse response) {
        TokuchoInfoFDownloadInfo fileInfo = getHandler(div).getダウンロードFile();
        FilesystemName shareFileName = new FilesystemName(fileInfo.getファイル名());
        SharedFileEntryDescriptor entry = new SharedFileEntryDescriptor(shareFileName, fileInfo.get作成日時());
        return SharedFileDirectAccessDownload.directAccessDownload(
                new SharedFileDirectAccessDescriptor(entry, fileInfo.getファイル名()), response);
    }

    private TokuchoInfoFDownloadHandler getHandler(TokuchoInfoFDownloadDiv div) {
        return new TokuchoInfoFDownloadHandler(div);
    }

}
