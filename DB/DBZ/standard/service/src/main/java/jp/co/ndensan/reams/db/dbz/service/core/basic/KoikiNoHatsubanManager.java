/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoikiNoHatsuban;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7025KoikiNoHatsubanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7025KoikiNoHatsubanDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 広域番号発番テーブルを管理するクラスです。
 */
public class KoikiNoHatsubanManager {

    private final DbT7025KoikiNoHatsubanDac dac;

    /**
     * コンストラクタです。
     */
    public KoikiNoHatsubanManager() {
        dac = InstanceProvider.create(DbT7025KoikiNoHatsubanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7025KoikiNoHatsubanDac}
     */
    KoikiNoHatsubanManager(DbT7025KoikiNoHatsubanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する広域番号発番テーブルを返します。
     *
     * @param 市町村コード ShichosonCode
     * @param コード区分 CodeKubun
     * @return KoikiNoHatsuban
     */
    @Transaction
    public KoikiNoHatsuban get広域番号発番テーブル(
            LasdecCode 市町村コード,
            RString コード区分) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));

        DbT7025KoikiNoHatsubanEntity entity = dac.selectByKey(
                市町村コード,
                コード区分);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KoikiNoHatsuban(entity);
    }

    /**
     * 広域番号発番テーブルを全件返します。
     *
     * @return List<KoikiNoHatsuban>
     */
    @Transaction
    public List<KoikiNoHatsuban> get広域番号発番テーブル一覧() {
        List<KoikiNoHatsuban> businessList = new ArrayList<>();

        for (DbT7025KoikiNoHatsubanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KoikiNoHatsuban(entity));
        }

        return businessList;
    }

    /**
     * 広域番号発番テーブル{@link KoikiNoHatsuban}を保存します。
     *
     * @param 広域番号発番テーブル {@link KoikiNoHatsuban}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save広域番号発番テーブル(KoikiNoHatsuban 広域番号発番テーブル) {
        requireNonNull(広域番号発番テーブル, UrSystemErrorMessages.値がnull.getReplacedMessage("広域番号発番テーブル"));
        if (!広域番号発番テーブル.hasChanged()) {
            return false;
        }
        return 1 == dac.save(広域番号発番テーブル.toEntity());
    }
}
