/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shoridatekanri;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.shoridatekanri.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 処理日付管理マスタを管理するクラスです。
 */
public class ShoriDateKanriManager {

    private final DbT7022ShoriDateKanriDac dac;

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
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get抽出調定日時(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            FlexibleYear 年度) {
        requireNonNull(サブ業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サブ業務コード"));
        requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage("処理名"));
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));

        DbT7022ShoriDateKanriEntity entity = dac.selectByKey(
                サブ業務コード,
                処理名,
                年度);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShoriDateKanri(entity);
    }

}
