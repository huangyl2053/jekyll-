/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120003.DataGrid1_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120003.ShotokuJohoChushutsuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.RendoKekkaLogShoriJotai;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.RendoKekkaLogShoriKubun;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.FileReader;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 画面設計_DBBGM51005_所得情報アップロード
 *
 * @reamsid_L DBB-1730-010 yangchenbing
 */
public class ShotokuJohoChushutsuHandler {

    private static final RString 当初 = new RString("DBBMN51005");
    private static final RString 異動 = new RString("DBBMN51007");
    private static final RString 当初所得引出 = new RString("当初所得引出");
    private static final RString 所得引出 = new RString("所得引出");
    private static final RString 事務広域 = new RString("111");
    private static final RString 所得引出方法_なし = new RString("0");
    private static final RString メッセージ_広域保険者 = new RString("広域保険者でないため、");
    private static final RString メッセージ_広域職員 = new RString("広域職員でないため、");
    private static final RString 当初_共有ファイル名 = new RString("DEC05F001_市町村ID.DAT");
    private static final RString 異動_共有ファイル名 = new RString("DEE01F001_市町村ID.DAT");
    private static final RString 定値_市町村ID = new RString("市町村ID");
    private static final RString RS00 = new RString("00");
    private static final RString 定値_DBBE = new RString("DBBE");
    private static final RString 定値_MESSAGE = new RString("指定されたファイルは、処理市町村のファイルと違っています。");
    private static final int NUM0 = 0;
    private static final int NUM5 = 5;
    private static final int NUM11 = 11;
    private static final int NUM19 = 19;
    private final ShotokuJohoChushutsuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShotokuJohoChushutsuDiv
     */
    public ShotokuJohoChushutsuHandler(ShotokuJohoChushutsuDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param div ShotokuJohoChushutsuDiv
     */
    public void initialize(ShotokuJohoChushutsuDiv div) {
        ShichosonSecurityJoho shichosonsecurityjoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (shichosonsecurityjoho == null || shichosonsecurityjoho.get導入形態コード() == null
                || !事務広域.equals(shichosonsecurityjoho.get導入形態コード().value())) {
            throw new ApplicationException(DbzErrorMessages.使用不可.getMessage().replace(メッセージ_広域保険者.toString()));
        }
        List<AuthorityItem> authorityItemList = ShichosonSecurityJoho.getShichosonShikibetsuId(ControlDataHolder.getUserId());
        if (authorityItemList == null || authorityItemList.isEmpty() || !RS00.equals(authorityItemList.get(NUM0).getItemId())) {
            throw new ApplicationException(DbzErrorMessages.使用不可.getMessage().replace(メッセージ_広域職員.toString()));
        }
        KoikiShichosonJohoFinder koikishichosonjohofinder = KoikiShichosonJohoFinder.createInstance();
        SearchResult<KoikiZenShichosonJoho> searchResult = koikishichosonjohofinder.getGenShichosonJoho();
        List<KoikiZenShichosonJoho> 構成市町村List = new ArrayList();
        if (searchResult != null && searchResult.records() != null && !searchResult.records().isEmpty()) {
            for (KoikiZenShichosonJoho entity : searchResult.records()) {
                if (所得引出方法_なし.equals(entity.get所得引出方法())) {
                    構成市町村List.add(entity);
                }
            }
        }
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        List<DataGrid1_Row> rowList = new ArrayList();
        RDate nowDate = RDate.getNowDate();
        if (当初.equals(ResponseHolder.getMenuID())) {
            RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, nowDate, SubGyomuCode.DBB介護賦課);
            div.getTxtShoriNendo().setValue(new RDate(調定年度.toString()));
            for (KoikiZenShichosonJoho master : 構成市町村List) {
                RString 処理枝番 = RS00.concat(master.get市町村識別ID());
                ShoriDateKanri shoridatekanri = manager.get基年月日(master.get市町村コード(), 当初所得引出, 処理枝番, new FlexibleYear(調定年度));
                set当初の基準日時(shoridatekanri, master, rowList);
            }
        } else if (異動.equals(ResponseHolder.getMenuID())) {
            RString 所得年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, nowDate, SubGyomuCode.DBB介護賦課);
            div.getTxtShoriNendo().setValue(new RDate(所得年度.toString()));
            for (KoikiZenShichosonJoho master : 構成市町村List) {
                RString 処理枝番 = RS00.concat(master.get市町村識別ID());
                ShoriDateKanri shoridatekanri = manager.get基年月日(master.get市町村コード(), 所得引出, 処理枝番, new FlexibleYear(所得年度));
                set異動の基準日時(shoridatekanri, master, rowList);
            }
        }
        div.getDataGrid1().setDataSource(rowList);
        div.getUploadPanel().setDisplayNone(true);
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param shoridatekanri ShoriDateKanri
     * @param master KoikiZenShichosonJoho
     * @param rowList List<DataGrid1_Row>
     */
    public void set当初の基準日時(ShoriDateKanri shoridatekanri, KoikiZenShichosonJoho master, List<DataGrid1_Row> rowList) {
        DataGrid1_Row newRow = new DataGrid1_Row();
        newRow.setTxtShichosonShokibetsuID(master.get市町村識別ID());
        if (master.get市町村コード() != null) {
            newRow.setTxtCityCode(master.get市町村コード().value());
        }
        newRow.setTxtCityName(master.get市町村名称());
        if (master.get証記載保険者番号() != null) {
            newRow.setTxtHokenshaNo(master.get証記載保険者番号().value());
        }
        if (shoridatekanri == null) {
            newRow.setTxtShoriState(RendoKekkaLogShoriJotai.正常終了.get名称());
            newRow.setSelectButtonState(DataGridButtonState.Disabled);
            newRow.setTxtSaishinShoriNitiji(RString.EMPTY);
            newRow.setTxtShoriKbn(RendoKekkaLogShoriKubun.可.getコード());
        } else if (shoridatekanri.get基準日時() == null || shoridatekanri.get基準日時().isEmpty()) {
            newRow.setTxtSaishinShoriNitiji(RString.EMPTY);
            List<UzT0885SharedFileEntryEntity> entryEntityList = SharedFile.searchSharedFile(
                    当初_共有ファイル名.replace(定値_市町村ID, master.get市町村識別ID()));
            if (entryEntityList == null || entryEntityList.isEmpty()) {
                newRow.setTxtShoriState(RendoKekkaLogShoriJotai.状態なし.get名称());
                newRow.setSelectButtonState(DataGridButtonState.Enabled);
                newRow.setTxtShoriKbn(RendoKekkaLogShoriKubun.可.getコード());
            } else {
                newRow.setTxtShoriState(RendoKekkaLogShoriJotai.正常終了.get名称());
                newRow.setSelectButtonState(DataGridButtonState.Disabled);
                newRow.setTxtShoriKbn(RendoKekkaLogShoriKubun.可.getコード());
            }
        } else if (shoridatekanri.get基準日時() != null && !shoridatekanri.get基準日時().isEmpty()) {
            newRow.setTxtShoriState(RendoKekkaLogShoriJotai.正常終了.get名称());
            newRow.setSelectButtonState(DataGridButtonState.Disabled);
            RString dateTemp = shoridatekanri.get基準日時().getDate().wareki().toDateString();
            RString timeTemp = new RString(shoridatekanri.get基準日時().getRDateTime().toString().substring(NUM11, NUM19));
            newRow.setTxtSaishinShoriNitiji(dateTemp.concat(RString.HALF_SPACE).concat(timeTemp));
            newRow.setTxtShoriKbn(RendoKekkaLogShoriKubun.不可.getコード());
        }
        rowList.add(newRow);
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param shoridatekanri ShoriDateKanri
     * @param master KoikiZenShichosonJoho
     * @param rowList List<DataGrid1_Row>
     */
    public void set異動の基準日時(ShoriDateKanri shoridatekanri, KoikiZenShichosonJoho master, List<DataGrid1_Row> rowList) {
        DataGrid1_Row newRow = new DataGrid1_Row();
        newRow.setTxtShichosonShokibetsuID(master.get市町村識別ID());
        if (master.get市町村コード() != null) {
            newRow.setTxtCityCode(master.get市町村コード().value());
        }
        newRow.setTxtCityName(master.get市町村名称());
        if (master.get証記載保険者番号() != null) {
            newRow.setTxtHokenshaNo(master.get証記載保険者番号().value());
        }
        if (shoridatekanri == null) {
            newRow.setTxtShoriState(RendoKekkaLogShoriJotai.正常終了.get名称());
            newRow.setSelectButtonState(DataGridButtonState.Disabled);
            newRow.setTxtSaishinShoriNitiji(RString.EMPTY);
            newRow.setTxtShoriKbn(RendoKekkaLogShoriKubun.可.getコード());
        } else {
            if (shoridatekanri.get基準日時() != null && !shoridatekanri.get基準日時().isEmpty()) {
                RString dateTemp = shoridatekanri.get基準日時().getDate().wareki().toDateString();
                RString timeTemp = new RString(shoridatekanri.get基準日時().getRDateTime().toString().substring(NUM11, NUM19));
                newRow.setTxtSaishinShoriNitiji(dateTemp.concat(RString.HALF_SPACE).concat(timeTemp));
            }
            newRow.setTxtShoriKbn(RendoKekkaLogShoriKubun.可.getコード());
            List<UzT0885SharedFileEntryEntity> entryEntityList = SharedFile.searchSharedFile(
                    異動_共有ファイル名.replace(定値_市町村ID, master.get市町村識別ID()));
            if (entryEntityList == null || entryEntityList.isEmpty()) {
                newRow.setTxtShoriState(RendoKekkaLogShoriJotai.状態なし.get名称());
                newRow.setSelectButtonState(DataGridButtonState.Enabled);
            } else {
                newRow.setTxtShoriState(RendoKekkaLogShoriJotai.正常終了.get名称());
                newRow.setSelectButtonState(DataGridButtonState.Disabled);
            }
        }
        rowList.add(newRow);
    }

    /**
     * upLoadメソッドです。
     *
     * @param files FileData[]
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public void upLoad(FileData[] files) {
        FilesystemName sharedFileName = null;
        RString 市町村コード = div.getDataGrid1().getSelectedItems().get(NUM0).getTxtCityCode();
        RString 市町村識別ID = div.getDataGrid1().getSelectedItems().get(NUM0).getTxtShichosonShokibetsuID();
        if (当初.equals(ResponseHolder.getMenuID()) && 市町村コード != null) {
            sharedFileName = new FilesystemName(当初_共有ファイル名.replace(定値_市町村ID, 市町村識別ID));
        } else if (異動.equals(ResponseHolder.getMenuID()) && 市町村コード != null) {
            sharedFileName = new FilesystemName(異動_共有ファイル名.replace(定値_市町村ID, 市町村識別ID));
        }
        if (sharedFileName != null) {
            SharedFileDescriptor sharedfiledescriptor = SharedFile.defineSharedFile(sharedFileName);
            FilesystemPath 絶対パス = new FilesystemPath(files[NUM0].getFilePath());
            SharedFile.copyToSharedFile(絶対パス, sharedFileName);
            RString filePath = files[NUM0].getFilePath();
            try (FileReader reader = new FileReader(filePath, Encode.UTF_8)) {
                RString record = reader.readLine();
                if (市町村コード == null || record == null || record.length() < NUM5
                        || record.substring(NUM0, NUM5).compareTo(市町村コード.substring(NUM0, NUM5)) != NUM0) {
                    SharedFile.deleteNewestEntry(sharedfiledescriptor);
                    throw new ApplicationException(new ErrorMessage(toCode(定値_DBBE.toString(), NUM0), 定値_MESSAGE.toString()));
                }
            }
            div.getDataGrid1().getClickedItem().setSelectButtonState(DataGridButtonState.Disabled);
            initialize(div);
        }
    }
}
