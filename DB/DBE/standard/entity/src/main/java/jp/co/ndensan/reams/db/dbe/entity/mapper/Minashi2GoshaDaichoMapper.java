/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.IMinashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbe.business.Minashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaichoEntity;

/**
 * {@link Minashi2GoshaDaicho}と{@link DbT1012Minashi2GoshaDaichoEntity}のマッピングクラスです。
 *
 * @author n8211 田辺 紘一
 */
public final class Minashi2GoshaDaichoMapper {

// TODO 田辺 紘一 〆日に間に合わず 2014/07/24

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private Minashi2GoshaDaichoMapper() {
    }

    /**
     * みなし2号者台帳Entityをみなし2号者台帳に変換します。
     *
     * @param entity DbT1012Minashi2GoshaDaichoEntity
     * @return Minashi2GoshaDaicho
     */
    public static Minashi2GoshaDaicho toMinashi2GoshaDaicho(DbT1012Minashi2GoshaDaichoEntity entity) {
        return new Minashi2GoshaDaicho(
                entity.getShichosonCode(),
                entity.getShikibetsuCode(),
                entity.getHihokenshaNo(),
                entity.getRirekiNo(),
                entity.getHihokenshaKubunCode(),
                entity.getMinashi2GoshaTorokuYMD(),
                entity.getMinashi2GoshaKaijoYMD()) {
                };
    }

    /**
     * みなし2号者台帳をみなし2号者台帳Entityに変換します。
     *
     * @param minashi2GoshaDaicho Minashi2GoshaDaicho
     * @return DbT1012Minashi2GoshaDaichoEntity
     */
    public static DbT1012Minashi2GoshaDaichoEntity toDbT1012Minashi2GoshaDaichoEntity(Minashi2GoshaDaicho minashi2GoshaDaicho) {
        DbT1012Minashi2GoshaDaichoEntity entity = new DbT1012Minashi2GoshaDaichoEntity();
        entity.setShichosonCode(minashi2GoshaDaicho.get市町村コード());
        entity.setShikibetsuCode(minashi2GoshaDaicho.get識別コード());
        entity.setHihokenshaNo(minashi2GoshaDaicho.get被保険者番号());
        entity.setRirekiNo(minashi2GoshaDaicho.get履歴番号());
        entity.setHihokenshaKubunCode(minashi2GoshaDaicho.get被保険者区分コード());
        entity.setMinashi2GoshaTorokuYMD(minashi2GoshaDaicho.getみなし2号登録年月日());
        entity.setMinashi2GoshaKaijoYMD(minashi2GoshaDaicho.getみなし2号解除年月日());
        return entity;
    }

}
