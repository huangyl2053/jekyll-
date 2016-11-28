/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC3510011;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.hokenshajohosoufu.HokenshaJoHoData;
import jp.co.ndensan.reams.db.dbc.business.core.hokenshajohosoufu.HokenshaJoHoList;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.soufujouhou.hokenshajohosoufu.HokenshaJoHoParamter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011.DBC3510011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011.DBC3510011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011.dgSofuDataIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3510011.DBC3510011MainHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3510011.DBC3510011MainValidationHandler;
import jp.co.ndensan.reams.db.dbc.service.core.hokenshajohosoufu.HokenshaJoHoFindler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFileDirectAccessDownload;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.IDownLoadServletResponse;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 保険者情報送付のコントローラクラスです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
public class DBC3510011Main {

    private static final int 先頭7桁 = 7;
    private static final int 先頭6桁 = 6;
    private static final int 世代管理する = 3;
    private static final RString 処理フラグ = new RString("済");
    private static final RString 処理状態 = new RString("処理済");
    private RString 共有ファイル名;
    private int 媒体数;
    private UzT0885SharedFileEntryEntity 共有ファイルエントリ情報;

    /**
     * 画面初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<DBC3510011MainDiv>
     */
    public ResponseData<DBC3510011MainDiv> onLoad(DBC3510011MainDiv div) {
        List<UzT0885SharedFileEntryEntity> entityList = SharedFile.searchSharedFile(new RString("10_%"));
        List<HokenshaJoHoList> 送付情報List = set送付情報(entityList);
        getHandler(div).set送付情報リスト(送付情報List);
        return ResponseData.of(div).setState(DBC3510011StateName.初期表示);
    }

    /**
     * 送付情報一覧の「選択」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<DBC3510011MainDiv>
     */
    public ResponseData<DBC3510011MainDiv> onClick_Sentaku(DBC3510011MainDiv div) {
        getHandler(div).set送付データ一覧();
        return ResponseData.of(div).setState(DBC3510011StateName.媒体作成);
    }

    /**
     * 「ダウンロード」ボタンを押した後、入力チェックを行う。
     *
     * @param div DBC3510011MainDiv
     * @return ResponseData
     */
    public ResponseData<DBC3510011MainDiv> onClick_check(DBC3510011MainDiv div) {
        ValidationMessageControlPairs pairsCheck = getValidationHandler(div).validateCheck();
        if (pairsCheck.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairsCheck).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「ダウンロード」ボタンを押します。
     *
     * @param div 画面情報
     * @param response IDownLoadServletResponse
     * @return IDownLoadServletResponse
     */
    public IDownLoadServletResponse onClick_BtnDownload(DBC3510011MainDiv div,
            IDownLoadServletResponse response) {
        RString schemaName = div.getDgSofuDataIchiran().getClickedItem().getFileName();

        Timestamp tp = Timestamp.valueOf(div.getDgSofuDataIchiran().getClickedItem().getFileId().replace("T", " ").toString());
        RDateTime schemaID = RDateTime.parse(tp);
        HokenshaJoHoData entity = HokenshaJoHoFindler.createInstance()
                .get共有ファイルエントリ情報(HokenshaJoHoParamter.createParam(schemaName, new RString(schemaID.toString())));
        ReadOnlySharedFileEntryDescriptor deleteEntity = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(schemaName),
                entity.getFileID());

        RString tmpPath = Directory.createTmpDirectory();
        FilesystemPath filesystemPath = new FilesystemPath(tmpPath);
        ReadOnlySharedFileEntryDescriptor entitydesc = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(schemaName),
                schemaID);
        FilesystemPath 保存先フォルダのパス = SharedFile.copyToLocal(entitydesc, filesystemPath);
        SharedFile.deleteEntry(deleteEntity);
        SharedFileDescriptor des = new ReadOnlySharedFileDescriptor(new FilesystemName(entity.getFileName()));
        des = SharedFile.defineSharedFile(des, 世代管理する, SharedFile.GROUP_ALL, null, false, null);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(des, 保存先フォルダのパス, opts);

        return SharedFileDirectAccessDownload.directAccessDownload(entry, schemaName, response);
    }

    /**
     * 「ダウンロード」ボタンを押し後ます。
     *
     * @param div 画面情報
     * @return IDownLoadServletResponse
     */
    public ResponseData<DBC3510011MainDiv> onClick_BtnDownloadFinish(DBC3510011MainDiv div) {
        div.getDgSofuDataIchiran().getClickedItem().setShoriFlag(処理フラグ);
        return ResponseData.of(div).setState(DBC3510011StateName.媒体作成);
    }

    /**
     * 戻るボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<DBC3510011MainDiv>
     */
    public ResponseData<DBC3510011MainDiv> onClick_Modoru(DBC3510011MainDiv div) {
        boolean 処理フラグ_済 = true;
        for (dgSofuDataIchiran_Row row : div.getDgSofuDataIchiran().getDataSource()) {
            if (!処理フラグ.equals(row.getShoriFlag())) {
                処理フラグ_済 = false;
            }
        }
        if (処理フラグ_済) {
            div.getHokenshaSofuList().getDgSofuJohoIchiran().getActiveRow().setJotai(処理状態);
            div.getHokenshaSofuList().getDgSofuJohoIchiran().getActiveRow().setSelectButtonState(DataGridButtonState.Disabled);
            div.getHokenshaSofuList().getDgSofuJohoIchiran().getActiveRow().setSelectable(false);
        }
        return ResponseData.of(div).setState(DBC3510011StateName.初期表示);
    }

    private List<HokenshaJoHoList> set送付情報(List<UzT0885SharedFileEntryEntity> entityList) {
        if (entityList.isEmpty()) {
            throw new ApplicationException(
                    UrErrorMessages.該当データなし.getMessage());
        }
        List<HokenshaJoHoList> 保険者情報リスト = new ArrayList<>();
        媒体数 = 0;
        List<RString> 共有ファイルエントリ情報List = new ArrayList<>();
        List<RString> 共有ファイルID = new ArrayList<>();
        for (UzT0885SharedFileEntryEntity entity : entityList) {
            if (媒体数 > 0
                    && !get先頭7桁(共有ファイル名, entity).equals(get先頭7桁(entity.getSharedFileName(), entity))) {
                HokenshaJoHoList 保険者情報 = new HokenshaJoHoList();
                保険者情報.setファイル名の先頭6桁(get先頭7桁(共有ファイル名, entity));
                保険者情報.set共有ファイル名(共有ファイルエントリ情報List);
                保険者情報.set共有ファイルID(共有ファイルID);
                保険者情報リスト.add(保険者情報);
                共有ファイルエントリ情報List = new ArrayList<>();
                共有ファイルID = new ArrayList<>();
            }
            媒体数++;
            共有ファイル名 = entity.getSharedFileName();
            共有ファイルエントリ情報 = entity;
            共有ファイルエントリ情報List.add(共有ファイルエントリ情報.getSharedFileName());
            共有ファイルID.add(new RString(共有ファイルエントリ情報.getSharedFileId().toString()));

            if (媒体数 == entityList.size()) {
                HokenshaJoHoList 保険者情報 = new HokenshaJoHoList();
                保険者情報.setファイル名の先頭6桁(get先頭7桁(共有ファイル名, entity));
                保険者情報.set共有ファイル名(共有ファイルエントリ情報List);
                保険者情報.set共有ファイルID(共有ファイルID);
                保険者情報リスト.add(保険者情報);
            }
        }
        return 保険者情報リスト;
    }

    private RString get先頭7桁(RString ファイル名, UzT0885SharedFileEntryEntity entity) {
        if (!RString.isNullOrEmpty(DbBusinessConfig.get(ConfigNameDBC.国保連高額合算運用_後期国保個別処理開始年月, RDate.getNowDate()))
                && new RString("37K").equals(entity.getSharedFileName().substring(世代管理する, 先頭6桁))) {
            return ファイル名.substring(0, 先頭7桁);
        } else {
            return ファイル名.substring(0, 先頭6桁);
        }

    }

    private DBC3510011MainHandler getHandler(DBC3510011MainDiv div) {
        return new DBC3510011MainHandler(div);
    }

    private DBC3510011MainValidationHandler getValidationHandler(DBC3510011MainDiv div) {
        return new DBC3510011MainValidationHandler(div);
    }
}
