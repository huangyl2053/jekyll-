/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RendoHoryuTokuteiJusho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7023RendoHoryuTokuteiJushoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連動保留特定住所マスタを管理するクラスです。
 */
public class RendoHoryuTokuteiJushoManager {

    private final DbT7023RendoHoryuTokuteiJushoDac dac;

    /**
     * コンストラクタです。
     */
    public RendoHoryuTokuteiJushoManager() {
        dac = InstanceProvider.create(DbT7023RendoHoryuTokuteiJushoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7023RendoHoryuTokuteiJushoDac}
     */
    RendoHoryuTokuteiJushoManager(DbT7023RendoHoryuTokuteiJushoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する連動保留特定住所マスタを返します。
     *
     * @param 管理番号 SubGyomuCode
     * @param 市町村コード ShichosonCode
     * @return RendoHoryuTokuteiJusho
     */
    @Transaction
    public RendoHoryuTokuteiJusho get連動保留特定住所マスタ(
            RString 管理番号,
            LasdecCode 市町村コード) {
        requireNonNull(管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("管理番号"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbT7023RendoHoryuTokuteiJushoEntity entity = dac.selectByKey(
                管理番号,
                市町村コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new RendoHoryuTokuteiJusho(entity);
    }

    /**
     * 連動保留特定住所マスタを全件返します。
     *
     * @return List<RendoHoryuTokuteiJusho>
     */
    @Transaction
    public List<RendoHoryuTokuteiJusho> get連動保留特定住所マスタ一覧() {
        List<RendoHoryuTokuteiJusho> businessList = new ArrayList<>();

        for (DbT7023RendoHoryuTokuteiJushoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new RendoHoryuTokuteiJusho(entity));
        }

        return businessList;
    }

    /**
     * 連動保留特定住所マスタ{@link RendoHoryuTokuteiJusho}を保存します。
     *
     * @param 連動保留特定住所マスタ {@link RendoHoryuTokuteiJusho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save連動保留特定住所マスタ(RendoHoryuTokuteiJusho 連動保留特定住所マスタ) {
        requireNonNull(連動保留特定住所マスタ, UrSystemErrorMessages.値がnull.getReplacedMessage("連動保留特定住所マスタ"));
        if (!連動保留特定住所マスタ.hasChanged()) {
            return false;
        }
        return 1 == dac.save(連動保留特定住所マスタ.toEntity());
    }
}
