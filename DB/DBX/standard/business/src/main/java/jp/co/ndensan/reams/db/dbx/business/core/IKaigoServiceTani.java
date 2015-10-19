/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuSanteiTani;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.TanisuShikibetsu;

/**
 * 介護サービス単位のインターフェースです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス単位インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public interface IKaigoServiceTani extends Serializable {

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    int get単位数();

    /**
     * 単位数識別を返します。
     *
     * @return 単位数識別
     */
    TanisuShikibetsu get単位数識別();

    /**
     * 単位数算定単位を返します。
     *
     * @return 単位数算定単位
     */
    TanisuSanteiTani get単位数算定単位();
}
