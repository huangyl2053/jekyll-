/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteichosaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請者Relateクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class NinteichosaRelate {

    private final NinteichosaRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity NinteichosaRelateEntity
     */
    public NinteichosaRelate(NinteichosaRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 特記事項番号を返します。
     *
     * @return 特記事項番号
     */
    public RString get特記事項番号() {
        return entity.get特記事項番号();
    }

    /**
     * 特記事項連番を返します。
     *
     * @return 特記事項連番
     */
    public RString get特記事項連番() {
        return entity.get特記事項連番();
    }

    /**
     * 特記事項区分を返します。
     *
     * @return 特記事項区分
     */
    public RString get特記事項区分() {
        return entity.get特記事項区分();
    }

    /**
     * 特記事項を返します。
     *
     * @return 特記事項
     */
    public RString get特記事項() {
        return entity.get特記事項();
    }

    /**
     * イメージIDを返します。
     *
     * @return イメージID
     */
    public RDateTime getイメージID() {
        return entity.getイメージID();
    }
}
