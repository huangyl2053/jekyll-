/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic.shikakutokuso;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakutoku.shikakutokuso.ServiceShikakuRelateEntity;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.shikakutokuso.ShikakuTokusoParameter;

/**
 *
 * 資格得喪履歴のMapperクラスです。
 */
public interface IShikakuTokusoMapper {

    /**
     * 資格情報一覧ガイドにＤＢから検索するデータが表示する。
     *
     * @param params params
     * @return ServiceShikakuRelateEntity
     */
    List<ServiceShikakuRelateEntity> getShikakuJoho(ShikakuTokusoParameter params);

}
