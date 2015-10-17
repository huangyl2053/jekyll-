/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 帳票制御共通を管理するクラスです。
 */
public class ChohyoSeigyoKyotsuManager {

    private final DbT7065ChohyoSeigyoKyotsuDac dac;

    /**
     * コンストラクタです。
     */
    public ChohyoSeigyoKyotsuManager() {
        dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7065ChohyoSeigyoKyotsuDac}
     */
    ChohyoSeigyoKyotsuManager(DbT7065ChohyoSeigyoKyotsuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する帳票制御共通を返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票分類ID ChohyoBunruiID
     * @return ChohyoSeigyoKyotsu
     */
    @Transaction
    public ChohyoSeigyoKyotsu get帳票制御共通(
            SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));

        DbT7065ChohyoSeigyoKyotsuEntity entity = dac.selectByKey(
                サブ業務コード,
                帳票分類ID);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChohyoSeigyoKyotsu(entity);
    }

    /**
     * 帳票制御共通を全件返します。
     *
     * @return List<ChohyoSeigyoKyotsu>
     */
    @Transaction
    public List<ChohyoSeigyoKyotsu> get帳票制御共通一覧() {
        List<ChohyoSeigyoKyotsu> businessList = new ArrayList<>();

        for (DbT7065ChohyoSeigyoKyotsuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChohyoSeigyoKyotsu(entity));
        }

        return businessList;
    }

    /**
     * 帳票制御共通{@link ChohyoSeigyoKyotsu}を保存します。
     *
     * @param 帳票制御共通 {@link ChohyoSeigyoKyotsu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save帳票制御共通(ChohyoSeigyoKyotsu 帳票制御共通) {
        requireNonNull(帳票制御共通, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通"));
        if (!帳票制御共通.hasChanged()) {
            return false;
        }
        return 1 == dac.save(帳票制御共通.toEntity());
    }
}
