/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsuControl;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7066ChohyoSeigyoKyotsuControlDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 帳票制御共通コントロールを管理するクラスです。
 */
public class ChohyoSeigyoKyotsuControlManager {

    private final DbT7066ChohyoSeigyoKyotsuControlDac dac;

    /**
     * コンストラクタです。
     */
    public ChohyoSeigyoKyotsuControlManager() {
        dac = InstanceProvider.create(DbT7066ChohyoSeigyoKyotsuControlDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7066ChohyoSeigyoKyotsuControlDac}
     */
    ChohyoSeigyoKyotsuControlManager(DbT7066ChohyoSeigyoKyotsuControlDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する帳票制御共通コントロールを返します。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 帳票分類ID ChohyoBunruiID
     * @return ChohyoSeigyoKyotsuControl
     */
    @Transaction
    public ChohyoSeigyoKyotsuControl get帳票制御共通コントロール(
            SubGyomuCode サブ業務コード,
            ReportId 帳票分類ID) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));

        DbT7066ChohyoSeigyoKyotsuControlEntity entity = dac.selectByKey(
                サブ業務コード,
                帳票分類ID);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChohyoSeigyoKyotsuControl(entity);
    }

    /**
     * 帳票制御共通コントロールを全件返します。
     *
     * @return List<ChohyoSeigyoKyotsuControl>
     */
    @Transaction
    public List<ChohyoSeigyoKyotsuControl> get帳票制御共通コントロール一覧() {
        List<ChohyoSeigyoKyotsuControl> businessList = new ArrayList<>();

        for (DbT7066ChohyoSeigyoKyotsuControlEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChohyoSeigyoKyotsuControl(entity));
        }

        return businessList;
    }

    /**
     * 帳票制御共通コントロール{@link ChohyoSeigyoKyotsuControl}を保存します。
     *
     * @param 帳票制御共通コントロール {@link ChohyoSeigyoKyotsuControl}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save帳票制御共通コントロール(ChohyoSeigyoKyotsuControl 帳票制御共通コントロール) {
        requireNonNull(帳票制御共通コントロール, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通コントロール"));
        if (!帳票制御共通コントロール.hasChanged()) {
            return false;
        }
        return 1 == dac.save(帳票制御共通コントロール.toEntity());
    }
}
