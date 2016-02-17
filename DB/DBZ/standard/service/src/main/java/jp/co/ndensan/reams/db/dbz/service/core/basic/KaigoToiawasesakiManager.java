/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.config.KaigoToiawasesakiConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7069KaigoToiawasesakiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護問合せ先を管理するクラスです。
 */
public class KaigoToiawasesakiManager {

    private final DbT7069KaigoToiawasesakiDac dac;
    private final KaigoToiawasesakiConfig config;

    /**
     * コンストラクタです。
     */
    public KaigoToiawasesakiManager() {
        dac = InstanceProvider.create(DbT7069KaigoToiawasesakiDac.class);
        config = new KaigoToiawasesakiConfig();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7069KaigoToiawasesakiDac}
     */
    KaigoToiawasesakiManager(DbT7069KaigoToiawasesakiDac dac) {
        this.dac = dac;
        config = new KaigoToiawasesakiConfig();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7069KaigoToiawasesakiDac}
     * @param config {@link KaigoToiawasesakiConfig}
     */
    KaigoToiawasesakiManager(DbT7069KaigoToiawasesakiDac dac, KaigoToiawasesakiConfig config) {
        this.dac = dac;
        this.config = config;
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param config {@link KaigoToiawasesakiConfig}
     */
    KaigoToiawasesakiManager(KaigoToiawasesakiConfig config) {
        this.dac = InstanceProvider.create(DbT7069KaigoToiawasesakiDac.class);
        this.config = config;
    }

    /**
     * 主キーに合致する介護問合せ先を返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票分類ID ChohyoBunruiID
     * @return KaigoToiawasesaki
     */
    @Transaction
    public KaigoToiawasesaki get介護問合せ先By主キー(
            SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));

        DbT7069KaigoToiawasesakiEntity entity = dac.selectByKey(
                サブ業務コード,
                帳票分類ID);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoToiawasesaki(entity);
    }

    /**
     * 介護共通問合せ先取得
     *
     * @return KaigoToiawasesaki
     */
    @Transaction
    public KaigoToiawasesaki get介護共通問合せ先() {

        DbT7069KaigoToiawasesakiEntity entity = dac.selectKaigoKyotsu();
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoToiawasesaki(entity);
    }

    /**
     * サブ業務共通問合せ先取得
     *
     * @param サブ業務コード SubGyomuCode
     * @return KaigoToiawasesaki
     */
    @Transaction
    public KaigoToiawasesaki getサブ業務共通問合せ先(
            SubGyomuCode サブ業務コード) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));

        DbT7069KaigoToiawasesakiEntity entity = dac.selectBySubGyomuCode(
                サブ業務コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoToiawasesaki(entity);
    }

    /**
     * 帳票問合せ先取得
     *
     * @param 帳票分類ID ReportId
     * @return KaigoToiawasesaki
     */
    @Transaction
    public KaigoToiawasesaki get帳票問合せ先(
            ReportId 帳票分類ID) {
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));

        DbT7069KaigoToiawasesakiEntity entity = dac.selectByChohyoBunruiID(
                帳票分類ID);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoToiawasesaki(entity);
    }

    /**
     * 介護問合せ先取得
     * <pre>
     * 引数で指定された帳票ID、サブ業務コードを元に問合せ先を取得する。
     * 指定された帳票IDに一致する問合せ先がある場合、帳票IDの問合せ先を取得する。
     * 指定された帳票IDに一致する問合せ先がない場合、業務コンフィグ（DBU．問合せ先_管理単位）で取得先を変更する。
     * 業務コンフィグ＝0（介護共通）の場合、介護共通の問合せ先を取得する。
     * 業務コンフィグ＝1（サブ業務単位）の場合、サブ業務共通の問合せ先を取得する。
     * </pre>
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票分類ID ReportId
     * @return KaigoToiawasesaki
     */
    @Transaction
    public KaigoToiawasesaki get介護問合せ先(
            SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));

        KaigoToiawasesaki result = get帳票問合せ先(帳票分類ID);
        if (result != null) {
            return result;
        }

        if (config.get問合せ先_管理単位().equals(new RString("0"))) {
            return get介護共通問合せ先();
        }
        return getサブ業務共通問合せ先(サブ業務コード);
    }

    /**
     * 介護問合せ先を全件返します。
     *
     * @return List<KaigoToiawasesaki>
     */
    @Transaction
    public List<KaigoToiawasesaki> get介護問合せ先一覧() {
        List<KaigoToiawasesaki> businessList = new ArrayList<>();

        for (DbT7069KaigoToiawasesakiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoToiawasesaki(entity));
        }

        return businessList;
    }

    /**
     * 介護問合せ先{@link KaigoToiawasesaki}を保存します。
     *
     * @param 介護問合せ先 {@link KaigoToiawasesaki}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護問合せ先(KaigoToiawasesaki 介護問合せ先) {
        requireNonNull(介護問合せ先, UrSystemErrorMessages.値がnull.getReplacedMessage("介護問合せ先"));
        if (!介護問合せ先.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護問合せ先.toEntity());
    }
}
