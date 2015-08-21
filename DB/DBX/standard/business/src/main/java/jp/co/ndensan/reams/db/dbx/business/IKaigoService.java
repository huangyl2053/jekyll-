/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.io.Serializable;
import java.util.List;

/**
 * 介護サービスクラスのインターフェースです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービスインタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public interface IKaigoService extends Serializable {

    /**
     * 介護サービス種類を返します。
     *
     * @return 介護サービス種類
     */
    IKaigoServiceShurui get介護サービス種類();

    /**
     * 介護サービス内容のリストを返します。
     *
     * @return 介護サービス内容リスト
     */
    List<IKaigoServiceNaiyo> get介護サービス内容リスト();
}
