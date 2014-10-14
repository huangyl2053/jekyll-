/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.Minashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaichoEntity;

/**
 * {@link Minashi2GoshaDaicho}と{@link DbT1012Minashi2GoshaDaichoEntity}のマッピングクラスです。
 *
 * @author n8211 田辺 紘一
 */
public final class Minashi2GoshaDaichoMapper {

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

        if (entity == null) {
            return null;
        }

        return new Minashi2GoshaDaicho(
                entity.getShichosonCode(),
                entity.getShikibetsuCode(),
                entity.getHihokenshaNo(),
                entity.getShoriTimestamp(),
                new HihokenshaKubun(entity.getHihokenshaKubunCode(), entity.getHihokenshaKubunCodeMeisho()),
                entity.getMinashi2GoshaTorokuYMD(),
                entity.getMinashi2GoshaKaijoYMD(),
                entity.getFukushiHihokenshaNo());
    }

    /**
     * みなし2号者台帳をみなし2号者台帳Entityに変換します。
     *
     * @param minashi2GoshaDaicho Minashi2GoshaDaicho
     * @return DbT1012Minashi2GoshaDaichoEntity
     */
    public static DbT1012Minashi2GoshaDaichoEntity toDbT1012Minashi2GoshaDaichoEntity(Minashi2GoshaDaicho minashi2GoshaDaicho) {

        if (minashi2GoshaDaicho == null) {
            return null;
        }

        DbT1012Minashi2GoshaDaichoEntity entity = new DbT1012Minashi2GoshaDaichoEntity();
        entity.setShichosonCode(minashi2GoshaDaicho.get市町村コード());
        entity.setShikibetsuCode(minashi2GoshaDaicho.get識別コード());
        entity.setHihokenshaNo(minashi2GoshaDaicho.get被保険者番号());
        entity.setShoriTimestamp(minashi2GoshaDaicho.get処理日時());
        entity.setHihokenshaKubunCode(minashi2GoshaDaicho.get被保険者区分().getCode());
        entity.setMinashi2GoshaTorokuYMD(minashi2GoshaDaicho.getみなし2号登録年月日());
        entity.setMinashi2GoshaKaijoYMD(minashi2GoshaDaicho.getみなし2号解除年月日());
        entity.setFukushiHihokenshaNo(minashi2GoshaDaicho.get福祉被保険者番号());
        return entity;
    }

}
