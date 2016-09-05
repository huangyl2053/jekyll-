/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchoinfoshoridatekanri;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.tokuchoinfofdownloadinfo.TokuchoInfoFDownloadInfo;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoinfoshoridate.TokuchoInfoShoriDateParameter;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoinfoshoridate.ITokuchoInfoShoriDateMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
    private static final RString FILTER = new RString("Z1A_TEST_03.DTA");
    private static final RString Z1A = new RString("Z1A");
    private static final RString Z12 = new RString("Z12");
    private static final RString 特別徴収異動情報 = new RString("特別徴収異動情報");
    private static final RString 特別徴収依頼情報 = new RString("特別徴収依頼情報");

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
     *
     * @return ShoriDateKanri
     *
     */
    public ShoriDateKanri get市町村処理日付(FlexibleYear 調定年度, RString 処理枝番) {
        DbT7022ShoriDateKanriEntity entity = dbt7022Dac.get特徴市町村処理日付(調定年度, 処理枝番);
        if (entity != null) {
            return new ShoriDateKanri(entity);
        }
        return null;
    }

    /**
     * 特徴月処理日付のデータの取得のメソッドです。
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
        List<DbT7022ShoriDateKanriEntity> 広域職員処理日付List = mapper.get広域職員の処理日付取得(param);
        if (広域職員処理日付List == null || 広域職員処理日付List.isEmpty()) {
            return null;
        }
        return new ShoriDateKanri(広域職員処理日付List.get(0));
    }

    /**
     * ダウンロード情報Entityリスト作成のメソッドです。
     *
     * @return List<TokuchoInfoFDownloadInfo>
     *
     */
    public List<TokuchoInfoFDownloadInfo> getファイル対象() {
        List<TokuchoInfoFDownloadInfo> ファイル対象List = new ArrayList<>();
        //TODO QA
        List<UzT0885SharedFileEntryEntity> entityList = SharedFile.searchSharedFile(FILTER);
        for (UzT0885SharedFileEntryEntity ファイル対象 : entityList) {
            RString ファイル名 = ファイル対象.getLocalFileName();
            if (!ファイル名.startsWith(Z1A) && !ファイル名.startsWith(Z12)) {
                continue;
            }
            TokuchoInfoFDownloadInfo entity = new TokuchoInfoFDownloadInfo();
            entity.setファイル名(ファイル名);
            if (ファイル名.startsWith(Z1A)) {
                entity.set情報名(特別徴収異動情報);
            } else {
                entity.set情報名(特別徴収依頼情報);
            }
            entity.set作成日時(ファイル対象.getSharedFileId());
            ファイル対象List.add(entity);
        }
        return ファイル対象List;
    }
}
