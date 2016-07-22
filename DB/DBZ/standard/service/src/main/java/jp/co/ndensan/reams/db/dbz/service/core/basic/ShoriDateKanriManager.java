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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
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
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("処理枝番"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage("年度内連番"));

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
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(処理枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("処理枝番"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(年度内連番, UrSystemErrorMessages.値がnull.getReplacedMessage("年度内連番"));

        DbT7022ShoriDateKanriEntity entity = dac.selectBySomeKeysLimits(
                サブ業務コード,
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
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));

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
     * @param 処理名 ShoriName
     * @param 年度 Nendo
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get基準年月日(
            RString 処理名,
            FlexibleYear 年度) {
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage(処理名メッセージ.toString()));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));

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
}
