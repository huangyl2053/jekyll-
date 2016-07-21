/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fukaerror;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorList;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2010FukaErrorListDac;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ur.urz.business.core.internalreportoutput.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課エラー一覧を管理するクラスです。
 *
 * @reamsid_L DBB-0720-020 zuotao
 */
public class FukaErrorListService {

    private final DbT2010FukaErrorListDac 賦課エラー一覧dac;
    private final DbT7022ShoriDateKanriDac 処理日付管理dac;
    private static final RString 特徴仮算定賦課 = new RString("特徴仮算定賦課");
    private static final RString 普徴仮算定賦課 = new RString("普徴仮算定賦課");
    private static final RString 仮算定異動賦課 = new RString("仮算定異動賦課");
    private static final RString 特徴平準化計算_8月分 = new RString("特徴平準化計算_8月分");
    private static final RString 本算定賦課 = new RString("本算定賦課");
    private static final RString 異動賦課 = new RString("異動賦課");
    private static final RString 過年度賦課 = new RString("過年度賦課");

    /**
     * コンストラクタです。
     */
    FukaErrorListService() {
        this.賦課エラー一覧dac = InstanceProvider.create(DbT2010FukaErrorListDac.class);
        this.処理日付管理dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 賦課エラー一覧dac 賦課エラー一覧dac
     * @param 処理日付管理dac 処理日付管理dac
     */
    FukaErrorListService(DbT2010FukaErrorListDac 賦課エラー一覧dac, DbT7022ShoriDateKanriDac 処理日付管理dac) {
        this.賦課エラー一覧dac = 賦課エラー一覧dac;
        this.処理日付管理dac = 処理日付管理dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaErrorListService}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FukaErrorListService}のインスタンス
     */
    public static FukaErrorListService createInstance() {
        return InstanceProvider.create(FukaErrorListService.class);
    }

    /**
     * リスト作成日時を取得します。
     *
     * @param batchID バッチID
     * @return リスト作成日時
     */
    @Transaction
    public SearchResult<FukaErrorList> getCreationDateTimeList(RString batchID) {
        List<DbT2010FukaErrorListEntity> 作成日時リスト = 賦課エラー一覧dac.select作成日時(batchID);
        if (作成日時リスト.isEmpty()) {
            return SearchResult.of(Collections.<FukaErrorList>emptyList(), 0, false);
        }
        List<FukaErrorList> 賦課エラー情報 = new ArrayList<>();
        for (DbT2010FukaErrorListEntity entity : 作成日時リスト) {
            賦課エラー情報.add(new FukaErrorList(entity));
        }
        return SearchResult.of(賦課エラー情報, 0, false);
    }

    /**
     * 賦課エラーの情報を取得します。
     *
     * @param リスト作成日時 リスト作成日時
     * @return 賦課エラーの情報リスト
     */
    @Transaction
    public SearchResult<FukaErrorList> getFukaErrorList(RDateTime リスト作成日時) {
        List<DbT2010FukaErrorListEntity> 賦課エラー情報リスト = 賦課エラー一覧dac.select賦課エラー情報リスト(リスト作成日時);
        if (賦課エラー情報リスト.isEmpty()) {
            return SearchResult.of(Collections.<FukaErrorList>emptyList(), 0, false);
        }
        List<FukaErrorList> 賦課エラー情報 = new ArrayList<>();
        for (DbT2010FukaErrorListEntity entity : 賦課エラー情報リスト) {
            賦課エラー情報.add(new FukaErrorList(entity));
        }
        return SearchResult.of(賦課エラー情報, 0, false);
    }

    /**
     * 賦課エラーデータの状況を「処理済み」として更新します。
     *
     * @param 賦課エラー情報 賦課エラー情報
     */
    @Transaction
    public void saveAs処理済み(FukaErrorList 賦課エラー情報) {
        DbT2010FukaErrorListEntity entity = 賦課エラー情報.toEntity();
        entity.setShoriKubunCode(InternalReportShoriKubun.処理済.getCode());
        entity.setState(EntityDataState.Modified);
        賦課エラー一覧dac.save(entity);
    }

    /**
     * 賦課エラーデータの状況を「処理済み」として更新します。
     *
     * @return 賦課エラーの情報リスト
     */
    @Transaction
    public RString getFukaBatchID() {
        FlexibleYear 年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        List<RString> 処理名 = new ArrayList<>();
        処理名.add(特徴仮算定賦課);
        処理名.add(普徴仮算定賦課);
        処理名.add(仮算定異動賦課);
        処理名.add(特徴平準化計算_8月分);
        処理名.add(本算定賦課);
        処理名.add(異動賦課);
        処理名.add(過年度賦課);
        DbT7022ShoriDateKanriEntity entity = 処理日付管理dac.get処理名(年度, 処理名);
        if (entity != null) {
            if (特徴仮算定賦課.equals(entity.getShoriName())) {
                return new RString("DBB011001_TokuchoKarisanteiFuka");
            }
            if (普徴仮算定賦課.equals(entity.getShoriName())) {
                return new RString("DBB014001_FuchoKarisanteiFuka");
            }
            if (仮算定異動賦課.equals(entity.getShoriName())) {
                return new RString("DBB015001_KarisanteiIdoFuka");
            }
            if (特徴平準化計算_8月分.equals(entity.getShoriName())) {
                return new RString("DBB013001_TokuchoHeinjunka8Gatsu");
            }
            if (本算定賦課.equals(entity.getShoriName())) {
                return new RString("DBB031001_HonsanteiFuka");
            }
            if (異動賦課.equals(entity.getShoriName())) {
                return new RString("DBB051001_GennendoIdoFuka");
            }
            if (過年度賦課.equals(entity.getShoriName())) {
                return new RString("DBB055001_KanendoIdoFuka");
            }
        }
        return RString.EMPTY;
    }
}
