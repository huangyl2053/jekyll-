/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinKyuTekiyoJogaiShisetsuNoHenkan;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 新旧適用除外施設番号変換テーブルを管理するクラスです。
 */
public class ShinKyuTekiyoJogaiShisetsuNoHenkanManager {

    private final DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanDac dac;

    /**
     * コンストラクタです。
     */
    public ShinKyuTekiyoJogaiShisetsuNoHenkanManager() {
        dac = InstanceProvider.create(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanDac}
     */
    ShinKyuTekiyoJogaiShisetsuNoHenkanManager(DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する新旧適用除外施設番号変換テーブルを返します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧適用除外施設番号 KyuTekiyoJogaiShisetsuNo
     * @return ShinKyuTekiyoJogaiShisetsuNoHenkan
     */
    @Transaction
    public ShinKyuTekiyoJogaiShisetsuNoHenkan get新旧適用除外施設番号変換テーブル(
            LasdecCode 市町村コード,
            RString 旧適用除外施設番号) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧適用除外施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧適用除外施設番号"));

        DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity = dac.selectByKey(
                市町村コード,
                旧適用除外施設番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinKyuTekiyoJogaiShisetsuNoHenkan(entity);
    }

    /**
     * 新旧適用除外施設番号変換テーブルを全件返します。
     *
     * @return List<ShinKyuTekiyoJogaiShisetsuNoHenkan>
     */
    @Transaction
    public List<ShinKyuTekiyoJogaiShisetsuNoHenkan> get新旧適用除外施設番号変換テーブル一覧() {
        List<ShinKyuTekiyoJogaiShisetsuNoHenkan> businessList = new ArrayList<>();

        for (DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinKyuTekiyoJogaiShisetsuNoHenkan(entity));
        }

        return businessList;
    }

    /**
     * 新旧適用除外施設番号変換テーブル{@link ShinKyuTekiyoJogaiShisetsuNoHenkan}を保存します。
     *
     * @param 新旧適用除外施設番号変換テーブル {@link ShinKyuTekiyoJogaiShisetsuNoHenkan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save新旧適用除外施設番号変換テーブル(ShinKyuTekiyoJogaiShisetsuNoHenkan 新旧適用除外施設番号変換テーブル) {
        requireNonNull(新旧適用除外施設番号変換テーブル, UrSystemErrorMessages.値がnull.getReplacedMessage("新旧適用除外施設番号変換テーブル"));
        if (!新旧適用除外施設番号変換テーブル.hasChanged()) {
            return false;
        }
        return 1 == dac.save(新旧適用除外施設番号変換テーブル.toEntity());
    }
}
