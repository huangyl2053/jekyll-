/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shogaishakojotaishoninteisho;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd4040011.ShogaishaKojoTaishoNinteishoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;

/**
 * 障がい者控除対象者認定画面のクラスです
 *
 * @reamsid_L DBD-3870-010 jinge
 */
public interface IShogaishaKojoTaishoNinteishoMapper {

    /**
     * 宛名情報の取得処理です。
     *
     * @param parameter parameter
     * @return 宛名情報
     */
    UaFt200FindShikibetsuTaishoEntity get宛名情報(ShogaishaKojoTaishoNinteishoParameter parameter);

    /**
     * 宛先情報の取得処理です。
     *
     * @param parameter parameter
     * @return 宛先情報
     */
    UaFt250FindAtesakiEntity get宛先情報(ShogaishaKojoTaishoNinteishoParameter parameter);

    /**
     * 受給者台帳情報の取得処理です。
     *
     * @param parameter parameter
     * @return 受給者台帳情報
     */
    DbT4001JukyushaDaichoEntity get受給者台帳情報(ShogaishaKojoTaishoNinteishoParameter parameter);
}
