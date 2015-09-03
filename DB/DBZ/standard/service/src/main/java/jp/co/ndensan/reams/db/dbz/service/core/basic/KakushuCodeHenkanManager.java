/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KakushuCodeHenkan;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7027KakushuCodeHenkanDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 各種コード変換テーブルを管理するクラスです。
 */
public class KakushuCodeHenkanManager {

    private final DbT7027KakushuCodeHenkanDac dac;

    /**
     * コンストラクタです。
     */
    public KakushuCodeHenkanManager() {
        dac = InstanceProvider.create(DbT7027KakushuCodeHenkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7027KakushuCodeHenkanDac}
     */
    KakushuCodeHenkanManager(DbT7027KakushuCodeHenkanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する各種コード変換テーブルを返します。
     *
     * @param 市町村コード ShichosonCode
     * @param コード区分 CodeKubun
     * @param 外部コード GaibuCode
     * @return KakushuCodeHenkan
     */
    @Transaction
    public KakushuCodeHenkan get各種コード変換テーブル(
            LasdecCode 市町村コード,
            RString コード区分,
            RString 外部コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));
        requireNonNull(外部コード, UrSystemErrorMessages.値がnull.getReplacedMessage("外部コード"));

        DbT7027KakushuCodeHenkanEntity entity = dac.selectByKey(
                市町村コード,
                コード区分,
                外部コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KakushuCodeHenkan(entity);
    }

    /**
     * 各種コード変換テーブルを全件返します。
     *
     * @return List<KakushuCodeHenkan>
     */
    @Transaction
    public List<KakushuCodeHenkan> get各種コード変換テーブル一覧() {
        List<KakushuCodeHenkan> businessList = new ArrayList<>();

        for (DbT7027KakushuCodeHenkanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KakushuCodeHenkan(entity));
        }

        return businessList;
    }

    /**
     * 各種コード変換テーブル{@link KakushuCodeHenkan}を保存します。
     *
     * @param 各種コード変換テーブル {@link KakushuCodeHenkan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save各種コード変換テーブル(KakushuCodeHenkan 各種コード変換テーブル) {
        requireNonNull(各種コード変換テーブル, UrSystemErrorMessages.値がnull.getReplacedMessage("各種コード変換テーブル"));
        if (!各種コード変換テーブル.hasChanged()) {
            return false;
        }
        return 1 == dac.save(各種コード変換テーブル.toEntity());
    }
}
