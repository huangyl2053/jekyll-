/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7908KaigoDonyuKeitaiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護導入形態を管理するクラスです。
 */
public class KaigoDonyuKeitaiManager {

    private final DbT7908KaigoDonyuKeitaiDac dac;

    /**
     * コンストラクタです。
     */
    KaigoDonyuKeitaiManager() {
        dac = InstanceProvider.create(DbT7908KaigoDonyuKeitaiDac.class);
    }

    /**
     * インスタンスを生成します。
     *
     * @return {@link KaigoDonyuKeitaiManager}
     */
    public static KaigoDonyuKeitaiManager createInstance() {
        return InstanceProvider.create(KaigoDonyuKeitaiManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7908KaigoDonyuKeitaiDac}
     */
    KaigoDonyuKeitaiManager(DbT7908KaigoDonyuKeitaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護導入形態を返します。
     *
     * @param 業務分類 GyomuBunrui
     * @param 導入形態コード DonyuKeitaiCode
     * @return KaigoDonyuKeitai
     */
    @Transaction
    public KaigoDonyuKeitai get介護導入形態(
            GyomuBunrui 業務分類,
            DonyuKeitaiCode 導入形態コード) {
        requireNonNull(業務分類, UrSystemErrorMessages.値がnull.getReplacedMessage("業務分類"));
        requireNonNull(導入形態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("導入形態コード"));

        DbT7908KaigoDonyuKeitaiEntity entity = dac.selectByKey(
                業務分類.code(),
                new Code(導入形態コード.getCode()));
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoDonyuKeitai(entity);
    }

    /**
     * 指定の業務分類に該当する介護導入形態を全件返します。
     *
     * @param gyomuBunrui 業務分類
     * @return 指定の業務分類に該当する{@link KaigoDonyuKeitai}全件
     */
    public List<KaigoDonyuKeitai> get介護導入形態By業務分類(GyomuBunrui gyomuBunrui) {
        return toKaigoDonyuKeitaiList(this.dac.selectByGyomuBunrui(gyomuBunrui.code()));
    }

    private List<KaigoDonyuKeitai> toKaigoDonyuKeitaiList(List<DbT7908KaigoDonyuKeitaiEntity> entities) {
        List<KaigoDonyuKeitai> list = new ArrayList<>();
        for (DbT7908KaigoDonyuKeitaiEntity entity : entities) {
            entity.initializeMd5();
            list.add(new KaigoDonyuKeitai(entity));
        }
        return list;
    }

    /**
     * 介護導入形態を全件返します。
     *
     * @return List<KaigoDonyuKeitai>
     */
    @Transaction
    public List<KaigoDonyuKeitai> get介護導入形態一覧() {
        return toKaigoDonyuKeitaiList(dac.selectAll());
    }

    /**
     * 介護導入形態{@link KaigoDonyuKeitai}を保存します。
     *
     * @param 介護導入形態 {@link KaigoDonyuKeitai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護導入形態(KaigoDonyuKeitai 介護導入形態) {
        requireNonNull(介護導入形態, UrSystemErrorMessages.値がnull.getReplacedMessage("介護導入形態"));
        if (!介護導入形態.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護導入形態.toEntity());
    }
}
