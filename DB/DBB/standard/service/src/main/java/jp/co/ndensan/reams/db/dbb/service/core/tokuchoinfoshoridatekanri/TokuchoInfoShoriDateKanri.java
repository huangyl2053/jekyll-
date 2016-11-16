/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchoinfoshoridatekanri;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchoinfofdownloadinfo.TokuchoInfoFDownloadInfo;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoinfoshoridate.TokuchoInfoShoriDateParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoinfofdownloadinfo.TokuchoInfoDTAEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoinfoshoridate.ITokuchoInfoShoriDateMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.fld.FldReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBB2110002_特徴送付情報ダウンロードのクラスです。
 *
 * @reamsid_L DBB-4240-010 chenhui
 */
public class TokuchoInfoShoriDateKanri {

    private final DbT7022ShoriDateKanriDac dbt7022Dac;
    private final MapperProvider mapperProvider;
    private static final RString FILTER_Z1A = new RString("Z1A%.DTA");
    private static final RString FILTER_Z12 = new RString("Z12%.DTA");
    private static final RString FILTER_Z1A_市町村 = new RString("Z1A%_市町村.DTA");
    private static final RString FILTER_Z12_市町村 = new RString("Z12%_市町村.DTA");
    private static final RString 市町村 = new RString("市町村");
    private static final RString Z1A = new RString("Z1A");
    private static final RString COM1 = new RString(":");
    private static final RString COM2 = new RString("-");
    private static final RString 特別徴収異動情報 = new RString("特別徴収異動情報");
    private static final RString 特別徴収依頼情報 = new RString("特別徴収依頼情報");
    private static final int INDEX_4 = 4;
    private static final int INDEX_6 = 6;

    /**
     * コンストラクタです。
     */
    TokuchoInfoShoriDateKanri() {
        this.dbt7022Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * にて生成した{@link TokuchoInfoShoriDateKanri}のインスタンスを返します。
     *
     * @return NoufuhitaiDataSakusei
     */
    public static TokuchoInfoShoriDateKanri createInstance() {
        return InstanceProvider.create(TokuchoInfoShoriDateKanri.class);
    }

    /**
     * 単一処理日付のデータの取得のメソッドです。
     *
     * @param 処理名 RString
     * @param 年度内連番 RString
     * @param 調定年度 FlexibleYear
     *
     * @return ShoriDateKanri
     *
     */
    public ShoriDateKanri get単一処理日付(RString 処理名, FlexibleYear 調定年度, RString 年度内連番) {
        DbT7022ShoriDateKanriEntity entity = dbt7022Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課, 処理名, 調定年度, 年度内連番);
        if (entity != null) {
            return new ShoriDateKanri(entity);
        }
        return null;
    }

    /**
     * 市町村処理日付のデータの取得のメソッドです。
     *
     * @param 処理枝番 RString
     * @param 調定年度 FlexibleYear
     * @param 処理名List List<RString>
     *
     * @return ShoriDateKanri
     *
     */
    public ShoriDateKanri get市町村処理日付(FlexibleYear 調定年度, RString 処理枝番, List<RString> 処理名List) {
        DbT7022ShoriDateKanriEntity entity = dbt7022Dac.get市町村処理日付(調定年度, 処理枝番, 処理名List);
        if (entity != null) {
            return new ShoriDateKanri(entity);
        }
        return null;
    }

    /**
     * 月処理日付のデータの取得のメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 処理名 RString
     * @param 年度連番 RString
     * @param 処理枝番 RString
     *
     * @return ShoriDateKanri
     *
     */
    public ShoriDateKanri get月処理日付(FlexibleYear 調定年度, RString 処理名, RString 年度連番, RString 処理枝番) {
        DbT7022ShoriDateKanriEntity entity = dbt7022Dac.select特徴月処理日付(調定年度, 処理名, 年度連番, 処理枝番);
        if (entity != null) {
            return new ShoriDateKanri(entity);
        }
        return null;
    }

    /**
     * 広域職員処理日付のデータの取得のメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 処理名 RString
     * @param 年度連番 RString
     * @param 市町村識別IDList List<RString>
     *
     * @return ShoriDateKanri
     *
     */
    public ShoriDateKanri get広域職員処理日付(FlexibleYear 調定年度, RString 処理名, RString 年度連番, List<RString> 市町村識別IDList) {
        ITokuchoInfoShoriDateMapper mapper = mapperProvider.create(ITokuchoInfoShoriDateMapper.class);
        TokuchoInfoShoriDateParameter param = new TokuchoInfoShoriDateParameter();
        param.set処理名(処理名);
        param.set市町村識別IDList(市町村識別IDList);
        param.set調定年度(調定年度);
        param.set年度内連番(年度連番);
        List<DbT7022ShoriDateKanriEntity> 広域職員処理日付List = mapper.get広域職員の処理日付取得(param);
        if (広域職員処理日付List == null || 広域職員処理日付List.isEmpty()) {
            return null;
        }
        return new ShoriDateKanri(広域職員処理日付List.get(0));
    }

    /**
     * 広域月処理日付のデータの取得のメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 処理名 RString
     * @param 年度連番 RString
     * @param 市町村識別IDList List<RString>
     *
     * @return ShoriDateKanri
     *
     */
    public List<ShoriDateKanri> get広域月処理日付(FlexibleYear 調定年度, RString 処理名, RString 年度連番, List<RString> 市町村識別IDList) {
        ITokuchoInfoShoriDateMapper mapper = mapperProvider.create(ITokuchoInfoShoriDateMapper.class);
        TokuchoInfoShoriDateParameter param = new TokuchoInfoShoriDateParameter();
        param.set処理名(処理名);
        param.set調定年度(調定年度);
        param.set年度内連番(年度連番);
        param.set市町村識別IDList(市町村識別IDList);
        List<DbT7022ShoriDateKanriEntity> 広域職員処理日付List = mapper.get広域月処理日付(param);
        if (広域職員処理日付List == null || 広域職員処理日付List.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShoriDateKanri> 処理日付List = new ArrayList<>();
        for (DbT7022ShoriDateKanriEntity entity : 広域職員処理日付List) {
            処理日付List.add(new ShoriDateKanri(entity));
        }
        return 処理日付List;
    }

    /**
     * 広域5月と9月処理日付のデータの取得のメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 処理名 RString
     * @param 年度連番 RString
     * @param 市町村識別IDList List<RString>
     *
     * @return List<ShoriDateKanri>
     *
     */
    public List<ShoriDateKanri> get広域5月と9月処理日付(FlexibleYear 調定年度, RString 処理名, RString 年度連番, List<RString> 市町村識別IDList) {
        ITokuchoInfoShoriDateMapper mapper = mapperProvider.create(ITokuchoInfoShoriDateMapper.class);
        TokuchoInfoShoriDateParameter param = new TokuchoInfoShoriDateParameter();
        param.set処理名(処理名);
        param.set市町村識別IDList(市町村識別IDList);
        param.set調定年度(調定年度);
        param.set年度内連番(年度連番);
        List<DbT7022ShoriDateKanriEntity> 広域職員処理日付List = mapper.get広域5月と9月処理日付(param);
        if (広域職員処理日付List == null || 広域職員処理日付List.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShoriDateKanri> 処理日付List = new ArrayList<>();
        for (DbT7022ShoriDateKanriEntity entity : 広域職員処理日付List) {
            処理日付List.add(new ShoriDateKanri(entity));
        }
        return 処理日付List;
    }

    /**
     * 月構成市町村処理日付のデータの取得のメソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 処理枝番 RString
     * @param 年度内連番 RString
     * @param 処理名List List<RString>
     * @return ShoriDateKanri
     *
     */
    public ShoriDateKanri get月構成市町村処理日付(FlexibleYear 調定年度, RString 処理枝番, RString 年度内連番, List<RString> 処理名List) {
        DbT7022ShoriDateKanriEntity entity = dbt7022Dac.get月構成市町村処理日付(調定年度, 処理枝番, 年度内連番, 処理名List);
        if (entity != null) {
            return new ShoriDateKanri(entity);
        }
        return null;
    }

    /**
     * ダウンロード情報Entityリスト作成のメソッドです。
     *
     * @param 市町村識別ID RString
     * @return List<TokuchoInfoFDownloadInfo>
     *
     */
    public List<TokuchoInfoFDownloadInfo> getファイル対象By市町村(RString 市町村識別ID) {
        List<TokuchoInfoFDownloadInfo> ファイル対象List = new ArrayList<>();
        RString 市町村_Z1A_Key = FILTER_Z1A_市町村.replace(市町村, 市町村識別ID);
        RString 市町村_Z12_Key = FILTER_Z12_市町村.replace(市町村, 市町村識別ID);
        List<UzT0885SharedFileEntryEntity> 市町村Z1AList = SharedFile.searchSharedFile(市町村_Z1A_Key);
        if (市町村Z1AList != null && !市町村Z1AList.isEmpty()) {
            ファイル対象List.addAll(changeToTokuchoInfoFDownloadInfo(市町村Z1AList));
        }
        List<UzT0885SharedFileEntryEntity> 市町村Z12List = SharedFile.searchSharedFile(市町村_Z12_Key);
        if (市町村Z12List != null && !市町村Z12List.isEmpty()) {
            ファイル対象List.addAll(changeToTokuchoInfoFDownloadInfo(市町村Z12List));
        }
        return ファイル対象List;
    }

    /**
     * ダウンロード情報Entityリスト作成のメソッドです。
     *
     * @return List<TokuchoInfoFDownloadInfo>
     *
     */
    public List<TokuchoInfoFDownloadInfo> getファイル対象() {
        List<TokuchoInfoFDownloadInfo> ファイル対象List = new ArrayList<>();
        List<UzT0885SharedFileEntryEntity> 単一Z1AList = SharedFile.searchSharedFile(FILTER_Z1A);
        if (単一Z1AList != null && !単一Z1AList.isEmpty()) {
            ファイル対象List.addAll(changeToTokuchoInfoFDownloadInfo(単一Z1AList));
        }
        List<UzT0885SharedFileEntryEntity> 単一Z12List = SharedFile.searchSharedFile(FILTER_Z12);
        if (単一Z12List != null && !単一Z12List.isEmpty()) {
            ファイル対象List.addAll(changeToTokuchoInfoFDownloadInfo(単一Z12List));
        }
        return ファイル対象List;
    }

    private List<TokuchoInfoFDownloadInfo> changeToTokuchoInfoFDownloadInfo(
            List<UzT0885SharedFileEntryEntity> entityList) {
        List<TokuchoInfoFDownloadInfo> ファイル対象List = new ArrayList<>();
        RString path = Path.combinePath(Path.getTmpDirectoryPath(),
                new RString(RDate.getNowDateTime().toString()).replace(COM1, RString.EMPTY).replace(COM2, RString.EMPTY));
        for (UzT0885SharedFileEntryEntity ファイル対象 : entityList) {
            RString ファイル名 = ファイル対象.getSharedFileName();
            TokuchoInfoFDownloadInfo entity = new TokuchoInfoFDownloadInfo();
            entity.setファイル名(ファイル名);
            if (ファイル名.startsWith(Z1A)) {
                entity.set情報名(特別徴収異動情報);
            } else {
                entity.set情報名(特別徴収依頼情報);
            }
            entity.set作成日時(ファイル対象.getSharedFileId());
            FilesystemPath tempPath = get共有ファイル(
                    FilesystemPath.fromString(path), ファイル対象);
            if (tempPath == null) {
                entity.setファイル存在(false);
            } else {
                entity.setファイル存在(true);
            }
            ファイル対象List.add(entity);
        }
        return ファイル対象List;
    }

    /**
     * ダウンロード情報Entityリスト作成のメソッドです。
     *
     * @param sharedFileName RString
     * @param dateTime RString
     * @return RDateTime
     *
     */
    public RDateTime getダウンロードDateTime(RString sharedFileName, RString dateTime) {
        List<UzT0885SharedFileEntryEntity> fileList = SharedFile.searchSharedFile(sharedFileName);
        for (UzT0885SharedFileEntryEntity entity : fileList) {
            if (dateTime.equals(new RString(entity.getSharedFileId().toString()))) {
                return entity.getSharedFileId();
            }
        }
        return null;
    }

    /**
     * 状況取得のメソッドです。
     *
     * @return List<RString>
     *
     */
    public List<RString> get状況済月() {
        List<RString> 状況済月 = new ArrayList<>();
        List<UzT0885SharedFileEntryEntity> sharedFiles = SharedFile.searchSharedFile(FILTER_Z1A);
        for (UzT0885SharedFileEntryEntity uzT0885SharedFileEntryEntity : sharedFiles) {
            FilesystemPath tempPath = get共有ファイル(
                    FilesystemPath.fromString(Path.getTmpDirectoryPath()), uzT0885SharedFileEntryEntity);
            if (tempPath == null) {
                continue;
            }
            RString localFilePath = tempPath.toRString().concat(uzT0885SharedFileEntryEntity.getLocalFileName());
            TokuchoInfoDTAEntity tokuchoInfoDTAEntity;
            try (FldReader<TokuchoInfoDTAEntity> reader = new FldReader.InstanceBuilder(localFilePath, TokuchoInfoDTAEntity.class)
                    .setEncodeShiftJis()
                    .setNewLine(NewLine.CRLF)
                    .build()) {
                tokuchoInfoDTAEntity = reader.readLine();
                reader.close();
            }
            RString 作成年月日 = tokuchoInfoDTAEntity.getCreateDate();
            状況済月.add(作成年月日.substring(INDEX_4, INDEX_6));
        }
        return 状況済月;
    }

    private FilesystemPath get共有ファイル(FilesystemPath local複写先フォルダパス, UzT0885SharedFileEntryEntity entity) {
        FilesystemPath copiedPath;
        try {
            ReadOnlySharedFileEntryDescriptor ro_entry = ReadOnlySharedFileEntryDescriptor.fromEntity(entity);
            copiedPath = SharedFile.copyToLocal(ro_entry, local複写先フォルダパス);
        } catch (Exception ex) {
            Logger.getLogger(TokuchoInfoShoriDateKanri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return copiedPath;
    }
}
