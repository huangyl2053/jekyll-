/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoServiceShurui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス種類を管理するクラスです。
 */
public class KaigoServiceShuruiManager {

    private final DbT7130KaigoServiceShuruiDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoServiceShuruiManager() {
        dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7130KaigoServiceShuruiDac}
     */
    KaigoServiceShuruiManager(DbT7130KaigoServiceShuruiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護サービス種類を返します。
     *
     * @param サービス種類コード ServiceShuruiCd
     * @param 提供開始年月 TeikyoKaishiYM
     * @return KaigoServiceShurui
     */
    @Transaction
    public KaigoServiceShurui get介護サービス種類(
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 提供開始年月) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));

        DbT7130KaigoServiceShuruiEntity entity = dac.selectByKey(
                サービス種類コード,
                提供開始年月);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoServiceShurui(entity);
    }

    /**
     * 介護サービス種類を全件返します。
     *
     * @return List<KaigoServiceShurui>
     */
    @Transaction
    public List<KaigoServiceShurui> get介護サービス種類一覧() {
        List<KaigoServiceShurui> businessList = new ArrayList<>();

        for (DbT7130KaigoServiceShuruiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoServiceShurui(entity));
        }

        return businessList;
    }

    /**
     * 介護サービス種類{@link KaigoServiceShurui}を保存します。
     *
     * @param 介護サービス種類 {@link KaigoServiceShurui}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護サービス種類(KaigoServiceShurui 介護サービス種類) {
        requireNonNull(介護サービス種類, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類"));
        if (!介護サービス種類.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護サービス種類.toEntity());
    }
}
