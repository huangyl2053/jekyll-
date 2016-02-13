/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護サービスコードのインターフェースです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービスコードインタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public interface IKaigoServiceCode extends Serializable {

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    ServiceShuruiCode getサービス種類コード();

    /**
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    RString getサービス項目コード();

    /**
     * サービスコードを返します。<br />
     * サービスコード(サービス種類コード2桁 + サービス項目コード4桁)
     *
     * @return サービスコード
     */
    RString getサービスコード();
}
