/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoikiShichosonCodeHenkanPattern;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPatternEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7024KoikiShichosonCodeHenkanPatternDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 広域市町村管理コード変換パターンを管理するクラスです。
 */
public class KoikiShichosonCodeHenkanPatternManager {

    private final DbT7024KoikiShichosonCodeHenkanPatternDac dac;

    /**
     * コンストラクタです。
     */
    public KoikiShichosonCodeHenkanPatternManager() {
        dac = InstanceProvider.create(DbT7024KoikiShichosonCodeHenkanPatternDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7024KoikiShichosonCodeHenkanPatternDac}
     */
    KoikiShichosonCodeHenkanPatternManager(DbT7024KoikiShichosonCodeHenkanPatternDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する広域市町村管理コード変換パターンを返します。
     *
     * @param 広域内市町村番号 KoikiShichosonNo
     * @param 市町村コード ShichosonCode
     * @param コード区分 CodeKubun
     * @return KoikiShichosonCodeHenkanPattern
     */
    @Transaction
    public KoikiShichosonCodeHenkanPattern get広域市町村管理コード変換パターン(
            RString 広域内市町村番号,
            LasdecCode 市町村コード,
            RString コード区分) {
        requireNonNull(広域内市町村番号, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内市町村番号"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));

        DbT7024KoikiShichosonCodeHenkanPatternEntity entity = dac.selectByKey(
                広域内市町村番号,
                市町村コード,
                コード区分);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KoikiShichosonCodeHenkanPattern(entity);
    }

    /**
     * 広域市町村管理コード変換パターンを全件返します。
     *
     * @return List<KoikiShichosonCodeHenkanPattern>
     */
    @Transaction
    public List<KoikiShichosonCodeHenkanPattern> get広域市町村管理コード変換パターン一覧() {
        List<KoikiShichosonCodeHenkanPattern> businessList = new ArrayList<>();

        for (DbT7024KoikiShichosonCodeHenkanPatternEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KoikiShichosonCodeHenkanPattern(entity));
        }

        return businessList;
    }

    /**
     * 広域市町村管理コード変換パターン{@link KoikiShichosonCodeHenkanPattern}を保存します。
     *
     * @param 広域市町村管理コード変換パターン {@link KoikiShichosonCodeHenkanPattern}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save広域市町村管理コード変換パターン(KoikiShichosonCodeHenkanPattern 広域市町村管理コード変換パターン) {
        requireNonNull(広域市町村管理コード変換パターン, UrSystemErrorMessages.値がnull.getReplacedMessage("広域市町村管理コード変換パターン"));
        if (!広域市町村管理コード変換パターン.hasChanged()) {
            return false;
        }
        return 1 == dac.save(広域市町村管理コード変換パターン.toEntity());
    }
}
