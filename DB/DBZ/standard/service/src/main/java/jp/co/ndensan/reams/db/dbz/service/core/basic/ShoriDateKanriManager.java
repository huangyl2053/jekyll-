/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 処理日付管理マスタを管理するクラスです。
 *
 * @reamsid_L DBZ-9999-022 cuilin
 */
public class ShoriDateKanriManager {

    private final DbT7022ShoriDateKanriDac dac;
    private static final RString 処理名メッセージ = new RString("処理名");
    private static final RString 年度メッセージ = new RString("年度");
    private static final RString 市町村コードメッセージ = new RString("市町村コード");
    private static final RString 処理枝番メッセージ = new RString("処理枝番");
    private static final RString 年度内連番メッセージ = new RString("年度内連番");
    private static final RString サブ業務コードメッセージ = new RString("サブ業務コード");
    private static final RString 開始時分秒 = new RString("000000");
    private static final RString 終了時分秒 = new RString("235959");

    /**
     * コンストラクタです。
     */
    public ShoriDateKanriManager() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7022ShoriDateKanriDac}
     */
    ShoriDateKanriManager(DbT7022ShoriDateKanriDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する処理日付管理マスタを返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 年度 Nendo
     * @param 年度内連番 NendoNaiRenban
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get処理日付管理(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 年度,
            RString 年度内連番) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));

        DbT7022ShoriDateKanriEntity entity = dac.selectBySomeKeys(
                サブ業務コード,
                処理名,
                年度,
                年度内連番);
        if (entity == null) {
            return null;
        }

        entity.initializeMd5();
        return new ShoriDateKanri(entity);
    }

    /**
     * 主キーに合致する処理日付管理マスタを返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード ShichosonCode
     * @param 処理名 ShoriName
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get処理日付管理マスタ(
            SubGyomuCode サブ業務コード,
            LasdecCode 市町村コード,
            RString 処理名) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));

        DbT7022ShoriDateKanriEntity entity = dac.select(
                サブ業務コード,
                市町村コード,
                処理名);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShoriDateKanri(entity);
    }

    /**
     * 主キーに合致する処理日付管理マスタを返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード ShichosonCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get処理日付管理マスタ(
            SubGyomuCode サブ業務コード,
            LasdecCode 市町村コード,
            RString 処理名,
            RString 処理枝番) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));

        DbT7022ShoriDateKanriEntity entity = dac.select(
                サブ業務コード,
                市町村コード,
                処理名,
                処理枝番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShoriDateKanri(entity);
    }

    /**
     * 主キーに合致する処理日付管理マスタを返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード ShichosonCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @param 年度 Nendo
     * @param 年度内連番 NendoNaiRenban
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get処理日付管理マスタ(
            SubGyomuCode サブ業務コード,
            LasdecCode 市町村コード,
            RString 処理名,
            RString 処理枝番,
            FlexibleYear 年度,
            RString 年度内連番) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));

        DbT7022ShoriDateKanriEntity entity = dac.selectByKey(
                サブ業務コード,
                市町村コード,
                処理名,
                処理枝番,
                年度,
                年度内連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShoriDateKanri(entity);
    }

    /**
     * 主キーに合致する処理日付管理マスタを返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @param 年度 Nendo
     * @param 年度内連番 NendoNaiRenban
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get処理日付管理マスタ(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            FlexibleYear 年度,
            RString 年度内連番) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));

        List<DbT7022ShoriDateKanriEntity> entityList = dac.selectBySomeKeys(
                サブ業務コード,
                処理名,
                処理枝番,
                年度,
                年度内連番);
        if (entityList.isEmpty()) {
            return null;
        }

        entityList.get(0).initializeMd5();
        return new ShoriDateKanri(entityList.get(0));
    }

    /**
     * 処理日付管理マスタを全件返します。
     *
     * @return List<ShoriDateKanri>
     */
    @Transaction
    public List<ShoriDateKanri> get処理日付管理マスタ一覧() {
        List<ShoriDateKanri> businessList = new ArrayList<>();

        for (DbT7022ShoriDateKanriEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShoriDateKanri(entity));
        }

        return businessList;
    }

    /**
     * 処理日付管理マスタ{@link ShoriDateKanri}を保存します。
     *
     * @param 処理日付管理マスタ {@link ShoriDateKanri}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save処理日付管理マスタ(ShoriDateKanri 処理日付管理マスタ) {
        requireNonNull(処理日付管理マスタ, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日付管理マスタ"));
        // TODO
//        if (!処理日付管理マスタ.hasChanged()) {
//            return false;
//        }
        return 1 == dac.save(処理日付管理マスタ.toEntity());
    }

    /**
     * 処理日付管理リスト{@link List<ShoriDateKanri>}を保存します。
     *
     * @param 処理日付管理登録リスト {@link List<ShoriDateKanri>}
     * @param 処理日付管理削除リスト {@link List<ShoriDateKanri>}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save処理日付管理リスト(List<ShoriDateKanri> 処理日付管理登録リスト,
            List<ShoriDateKanri> 処理日付管理削除リスト) {
        requireNonNull(処理日付管理登録リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日付管理登録リスト"));

        for (ShoriDateKanri 処理日付管理マスタ : 処理日付管理削除リスト) {
            DbT7022ShoriDateKanriEntity entity = 処理日付管理マスタ.toEntity();
            entity.setState(EntityDataState.Deleted);
            if (1 != dac.save(entity)) {
                return false;
            }
        }

        for (ShoriDateKanri 処理日付管理マスタ : 処理日付管理登録リスト) {
            DbT7022ShoriDateKanriEntity entity = 処理日付管理マスタ.toEntity();
            entity.setState(EntityDataState.Added);
            if (1 != dac.save(処理日付管理マスタ.toEntity())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 処理日付管理マスタを返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 年度 Nendo
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get抽出調定日時(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 年度) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));

        DbT7022ShoriDateKanriEntity entity = dac.selectChoteiNiji(
                サブ業務コード,
                処理名,
                年度);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShoriDateKanri(entity);
    }

    /**
     * 処理日付管理マスタを返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get抽出サブ業務コード(SubGyomuCode サブ業務コード) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));

        DbT7022ShoriDateKanriEntity entity = dac.selectSubGyomuCode(サブ業務コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShoriDateKanri(entity);
    }

    /**
     * 処理日付管理マスタを返します。
     *
     * @param 処理名 ShoriName
     * @param 年度 Nendo
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get基準年月日(
            RString 処理名,
            FlexibleYear 年度) {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));

        DbT7022ShoriDateKanriEntity entity = dac.selectKijunYMD(
                処理名,
                年度);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShoriDateKanri(entity);
    }

    /**
     * 処理日付管理マスタを返します。
     *
     * @param 市町村コード LasdecCode
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @param 年度 FlexibleYear
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get基年月日(LasdecCode 市町村コード,
            RString 処理名, RString 処理枝番, FlexibleYear 年度) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));

        DbT7022ShoriDateKanriEntity entity = dac.select基準日時ByKey(市町村コード, 処理名, 処理枝番, 年度);
        if (entity == null) {
            return null;
        }
        return new ShoriDateKanri(entity);
    }

    /**
     * 処理日付管理マスタを更新します。
     *
     * @param 処理名 RString
     * @param 年度内連番 RString
     * @param 年度 FlexibleYear
     * @param 基準日時 YMDHMS
     */
    @Transaction
    public void update基準日時(RString 処理名, RString 年度内連番, FlexibleYear 年度, YMDHMS 基準日時) {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage(年度内連番メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        List<DbT7022ShoriDateKanriEntity> entitylist = dac.select基準日時toupdate(処理名, 年度内連番, 年度);
        for (DbT7022ShoriDateKanriEntity entity : entitylist) {
            entity.setKijunTimestamp(基準日時);
            entity.setState(EntityDataState.Modified);
            dac.save(entity);
        }
    }

    /**
     * 処理日付管理マスタを返します。
     *
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get抽出期間() {

        DbT7022ShoriDateKanriEntity entity = dac.select抽出期間();
        if (entity == null) {
            return null;
        }
        return new ShoriDateKanri(entity);
    }

    /**
     * 処理日付管理マスタから直近の年次負担割合判定処理のデータを取得する。
     *
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri select直近の年次負担割合判定() {
        DbT7022ShoriDateKanriEntity entity = dac.select直近の年次負担割合判定();
        if (entity == null) {
            return null;
        }
        return new ShoriDateKanri(entity);
    }

    /**
     * 当初発行チェックの判定処理のデータを取得する。
     *
     * @param 年度 FlexibleYear
     * @param 処理枝番 RString
     * @return ShoriDateKanris
     */
    @Transaction
    public ShoriDateKanri select当初発行チェック(FlexibleYear 年度, RString 処理枝番) {
        DbT7022ShoriDateKanriEntity entity = dac.select当初発行チェック(年度, 処理枝番);
        if (entity == null) {
            return null;
        }
        return new ShoriDateKanri(entity);
    }

    /**
     * 処理日付管理マスタから、過去集計情報を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理枝番 ShoriEdaban
     * @return ShoriDateKanri
     */
    @Transaction
    public SearchResult<ShoriDateKanri> get処理日付管理マスタ(
            SubGyomuCode サブ業務コード,
            List<RString> 処理名,
            List<RString> 処理枝番) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        List<ShoriDateKanri> shoriDateKanriList = new ArrayList<>();
        List<DbT7022ShoriDateKanriEntity> entityList = dac.get処理日付管理マスタ(
                サブ業務コード,
                処理名,
                処理枝番);
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            entity.initializeMd5();
            shoriDateKanriList.add(new ShoriDateKanri(entity));
        }
        return SearchResult.of(shoriDateKanriList, 0, false);
    }

    /**
     * 処理日付管理マスタを更新します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード LasdecCode
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @param 開始日 FlexibleDate
     * @param 終了日 FlexibleDate
     */
    @Transaction
    public void update対象開始日時AND対象終了日時(SubGyomuCode サブ業務コード, LasdecCode 市町村コード, RString 処理名, RString 処理枝番,
            FlexibleDate 開始日, FlexibleDate 終了日) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage(処理枝番メッセージ.toString()));
        List<DbT7022ShoriDateKanriEntity> entitylist = dac.select対象開始日時toupdate(サブ業務コード, 市町村コード, 処理名, 処理枝番);
        for (DbT7022ShoriDateKanriEntity entity : entitylist) {
            if (開始日 != null) {
                entity.setTaishoKaishiTimestamp(new YMDHMS(開始日.toString().concat(開始時分秒.toString())));
            }
            if (終了日 != null) {
                entity.setTaishoShuryoTimestamp(new YMDHMS(終了日.toString().concat(終了時分秒.toString())));
            }
            entity.setState(EntityDataState.Modified);
            dac.save(entity);
        }
    }

    /**
     * 処理日付管理マスタから、処理名より、前回対象年月日期間のデータを取得する。
     *
     * @param 処理名 RString
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get前回対象年月日期間(RString 処理名) {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        DbT7022ShoriDateKanriEntity entity = dac.select前回対象年月日期間(処理名);
        if (entity == null) {
            return null;
        }
        return new ShoriDateKanri(entity);
    }

    /**
     * 処理日付管理マスタから、非課税年金対象者情報取込情報を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理年度 FlexibleYear
     * @return SearchResult<ShoriDateKanri>
     */
    @Transaction
    public SearchResult<ShoriDateKanri> get非課税年金対象者情報for単一(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 処理年度) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        List<ShoriDateKanri> shoriDateKanriList = new ArrayList<>();
        List<DbT7022ShoriDateKanriEntity> entityList = dac.select処理状況_普徴仮算定賦課(
                処理年度,
                処理名,
                サブ業務コード);
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            entity.initializeMd5();
            shoriDateKanriList.add(new ShoriDateKanri(entity));
        }
        return SearchResult.of(shoriDateKanriList, 0, false);
    }

    /**
     * 処理日付管理マスタから、非課税年金対象者情報取込情報を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理年度 FlexibleYear
     * @param 処理枝番 RString
     * @return SearchResult<ShoriDateKanri>
     */
    @Transaction
    public SearchResult<ShoriDateKanri> get非課税年金対象者情報for広域(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 処理年度,
            RString 処理枝番) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        List<ShoriDateKanri> shoriDateKanriList = new ArrayList<>();
        List<DbT7022ShoriDateKanriEntity> entityList = dac.select非課税年金対象者情報for広域(
                サブ業務コード,
                処理名,
                処理枝番,
                処理年度);
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            entity.initializeMd5();
            shoriDateKanriList.add(new ShoriDateKanri(entity));
        }
        return SearchResult.of(shoriDateKanriList, 0, false);
    }

    /**
     * 処理日付管理マスタから、非課税年金対象者情報取込情報を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理年度 FlexibleYear
     * @param 年度内連番 RString
     * @return SearchResult<ShoriDateKanri>
     */
    @Transaction
    public SearchResult<ShoriDateKanri> get非課税年金対象者情報for月DDL(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 処理年度,
            RString 年度内連番) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage("年度内連番"));
        List<ShoriDateKanri> shoriDateKanriList = new ArrayList<>();
        List<DbT7022ShoriDateKanriEntity> entityList = dac.selectFor依頼金額計算基準日取得(
                サブ業務コード,
                処理名,
                処理年度,
                年度内連番);
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            entity.initializeMd5();
            shoriDateKanriList.add(new ShoriDateKanri(entity));
        }
        return SearchResult.of(shoriDateKanriList, 0, false);
    }

    /**
     * 処理日付管理マスタから、非課税年金対象者情報取込情報を取得します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 処理年度 FlexibleYear
     * @param 市町村コード LasdecCode
     * @param 年度内連番 RString
     * @return SearchResult<ShoriDateKanri>
     */
    @Transaction
    public SearchResult<ShoriDateKanri> get非課税年金対象者情報forチェック(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 処理年度,
            LasdecCode 市町村コード,
            RString 年度内連番) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage("年度内連番"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        List<ShoriDateKanri> shoriDateKanriList = new ArrayList<>();
        List<DbT7022ShoriDateKanriEntity> entityList = dac.select非課税年金対象者情報forチェック(
                サブ業務コード,
                処理名,
                年度内連番,
                処理年度,
                市町村コード);
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            entity.initializeMd5();
            shoriDateKanriList.add(new ShoriDateKanri(entity));
        }
        return SearchResult.of(shoriDateKanriList, 0, false);
    }

    /**
     * 処理日付管理マスタを返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 処理名 ShoriName
     * @param 年度 Nendo
     * @param 市町村コード ShichosonCode
     * @return List<ShoriDateKanri>
     */
    @Transaction
    public List<ShoriDateKanri> get処理日付管理マスタ(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 年度,
            LasdecCode 市町村コード) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(サブ業務コードメッセージ.toString()));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage(年度メッセージ.toString()));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードメッセージ.toString()));

        List<ShoriDateKanri> result = new ArrayList<>();
        List<DbT7022ShoriDateKanriEntity> entityList = dac.selectBySomeColumns(サブ業務コード, 処理名, 年度, 市町村コード);
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            entity.initializeMd5();
            result.add(new ShoriDateKanri(entity));
        }

        return result;
    }
}
