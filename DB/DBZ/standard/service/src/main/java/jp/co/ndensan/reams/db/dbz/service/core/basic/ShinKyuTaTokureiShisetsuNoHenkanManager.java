/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinKyuTaTokureiShisetsuNoHenkan;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkanDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 新旧他特例施設番号変換テーブルを管理するクラスです。
 */
public class ShinKyuTaTokureiShisetsuNoHenkanManager {

    private final DbT7032ShinKyuTaTokureiShisetsuNoHenkanDac dac;

    /**
     * コンストラクタです。
     */
    public ShinKyuTaTokureiShisetsuNoHenkanManager() {
        dac = InstanceProvider.create(DbT7032ShinKyuTaTokureiShisetsuNoHenkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7032ShinKyuTaTokureiShisetsuNoHenkanDac}
     */
    ShinKyuTaTokureiShisetsuNoHenkanManager(DbT7032ShinKyuTaTokureiShisetsuNoHenkanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する新旧他特例施設番号変換テーブルを返します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧他特例施設番号 KyuTaTokureiShisetsuNo
     * @return ShinKyuTaTokureiShisetsuNoHenkan
     */
    @Transaction
    public ShinKyuTaTokureiShisetsuNoHenkan get新旧他特例施設番号変換テーブル(
            LasdecCode 市町村コード,
            RString 旧他特例施設番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧他特例施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧他特例施設番号"));

        DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity = dac.selectByKey(
                市町村コード,
                旧他特例施設番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinKyuTaTokureiShisetsuNoHenkan(entity);
    }

    /**
     * 新旧他特例施設番号変換テーブルを全件返します。
     *
     * @return List<ShinKyuTaTokureiShisetsuNoHenkan>
     */
    @Transaction
    public List<ShinKyuTaTokureiShisetsuNoHenkan> get新旧他特例施設番号変換テーブル一覧() {
        List<ShinKyuTaTokureiShisetsuNoHenkan> businessList = new ArrayList<>();

        for (DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinKyuTaTokureiShisetsuNoHenkan(entity));
        }

        return businessList;
    }

    /**
     * 新旧他特例施設番号変換テーブル{@link ShinKyuTaTokureiShisetsuNoHenkan}を保存します。
     *
     * @param 新旧他特例施設番号変換テーブル {@link ShinKyuTaTokureiShisetsuNoHenkan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save新旧他特例施設番号変換テーブル(ShinKyuTaTokureiShisetsuNoHenkan 新旧他特例施設番号変換テーブル) {
        requireNonNull(新旧他特例施設番号変換テーブル, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧他特例施設番号変換テーブル"));
        if (!新旧他特例施設番号変換テーブル.hasChanged()) {
            return false;
        }
        return 1 == dac.save(新旧他特例施設番号変換テーブル.toEntity());
    }
}
