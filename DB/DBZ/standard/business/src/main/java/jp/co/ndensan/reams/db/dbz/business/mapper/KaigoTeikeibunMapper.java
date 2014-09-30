/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.mapper;

import jp.co.ndensan.reams.db.dbz.business.KaigoTeikeibun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJohoEntity;

/**
 * 定型文ビジネスクラスとエンティティの変換を行うクラスです。
 *
 * @author n9606 漢那 憲作
 */
public class KaigoTeikeibunMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private KaigoTeikeibunMapper() {
    }

    /**
     * 定型文エンティティから定型文情報への対応付けを行います。
     *
     * @param entity 定型文Entity
     * @return 定型文データ
     */
    public static KaigoTeikeibun toKaigoTeikeibun(
            DbT7103TeikeibunJohoEntity entity) throws NullPointerException {

        if (entity == null) {
            return null;
        }

        return new KaigoTeikeibun(
                entity.getTeikeiKubun(),
                entity.getShubetsu(),
                entity.getTeikeibunCd(),
                entity.getTeikeibunNaiyo()
        );
    }

    /**
     * 定型文情報を定型文エンティティに変換します。
     *
     * @param teikeibunJoho 定型文データ
     * @return 定型文情報エンティティ
     */
    public static DbT7103TeikeibunJohoEntity toKaigoTeikeibunEntity(KaigoTeikeibun teikeibunJoho) {

        if (teikeibunJoho == null) {
            return null;
        }

        DbT7103TeikeibunJohoEntity entity = new DbT7103TeikeibunJohoEntity();

        entity.setTeikeiKubun(teikeibunJoho.get区分());
        entity.setShubetsu(teikeibunJoho.get種別());
        entity.setTeikeibunCd(teikeibunJoho.getコード());
        entity.setTeikeibunNaiyo(teikeibunJoho.get内容());

        return entity;
    }
}
