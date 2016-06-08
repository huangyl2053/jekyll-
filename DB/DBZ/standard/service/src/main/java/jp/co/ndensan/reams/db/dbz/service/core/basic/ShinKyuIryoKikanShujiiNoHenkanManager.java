/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinKyuIryoKikanShujiiNoHenkan;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 新旧医療機関主治医番号変換テーブルを管理するクラスです。
 */
public class ShinKyuIryoKikanShujiiNoHenkanManager {

    private final DbT7030ShinKyuIryoKikanShujiiNoHenkanDac dac;

    /**
     * コンストラクタです。
     */
    public ShinKyuIryoKikanShujiiNoHenkanManager() {
        dac = InstanceProvider.create(DbT7030ShinKyuIryoKikanShujiiNoHenkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7030ShinKyuIryoKikanShujiiNoHenkanDac}
     */
    ShinKyuIryoKikanShujiiNoHenkanManager(DbT7030ShinKyuIryoKikanShujiiNoHenkanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する新旧医療機関主治医番号変換テーブルを返します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧医療機関番号 KyuIryoKikanNo
     * @param 旧主治医番号 KyuShujiiNo
     * @return ShinKyuIryoKikanShujiiNoHenkan
     */
    @Transaction
    public ShinKyuIryoKikanShujiiNoHenkan get新旧医療機関主治医番号変換テーブル(
            LasdecCode 市町村コード,
            RString 旧医療機関番号,
            RString 旧主治医番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧医療機関番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧医療機関番号"));
        requireNonNull(旧主治医番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧主治医番号"));

        DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity = dac.selectByKey(
                市町村コード,
                旧医療機関番号,
                旧主治医番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinKyuIryoKikanShujiiNoHenkan(entity);
    }

    /**
     * 新旧医療機関主治医番号変換テーブルを全件返します。
     *
     * @return List<ShinKyuIryoKikanShujiiNoHenkan>
     */
    @Transaction
    public List<ShinKyuIryoKikanShujiiNoHenkan> get新旧医療機関主治医番号変換テーブル一覧() {
        List<ShinKyuIryoKikanShujiiNoHenkan> businessList = new ArrayList<>();

        for (DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinKyuIryoKikanShujiiNoHenkan(entity));
        }

        return businessList;
    }

    /**
     * 新旧医療機関主治医番号変換テーブル{@link ShinKyuIryoKikanShujiiNoHenkan}を保存します。
     *
     * @param 新旧医療機関主治医番号変換テーブル {@link ShinKyuIryoKikanShujiiNoHenkan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save新旧医療機関主治医番号変換テーブル(ShinKyuIryoKikanShujiiNoHenkan 新旧医療機関主治医番号変換テーブル) {
        requireNonNull(新旧医療機関主治医番号変換テーブル, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧医療機関主治医番号変換テーブル"));
        if (!新旧医療機関主治医番号変換テーブル.hasChanged()) {
            return false;
        }
        return 1 == dac.save(新旧医療機関主治医番号変換テーブル.toEntity());
    }
}
