/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RankJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2011RankJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ランク情報を管理するクラスです。
 */
public class RankJohoManager {

    private final DbT2011RankJohoDac dac;

    /**
     * コンストラクタです。
     */
    public RankJohoManager() {
        dac = InstanceProvider.create(DbT2011RankJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2011RankJohoDac}
     */
    RankJohoManager(DbT2011RankJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致するランク情報を返します。
     *
     * @param 賦課年度 FukaNendo
     * @param ランク区分 RankKubun
     * @return RankJoho
     */
    @Transaction
    public RankJoho getランク情報(
            FlexibleYear 賦課年度,
            RankKubun ランク区分) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));

        DbT2011RankJohoEntity entity = dac.selectByKey(
                賦課年度,
                ランク区分);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new RankJoho(entity);
    }

    /**
     * ランク情報を全件返します。
     *
     * @return List<RankJoho>
     */
    @Transaction
    public List<RankJoho> getランク情報一覧() {
        List<RankJoho> businessList = new ArrayList<>();

        for (DbT2011RankJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new RankJoho(entity));
        }

        return businessList;
    }

    /**
     * ランク情報{@link RankJoho}を保存します。
     *
     * @param ランク情報 {@link RankJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveランク情報(RankJoho ランク情報) {
        requireNonNull(ランク情報, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク情報"));
        if (!ランク情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(ランク情報.toEntity());
    }
}
