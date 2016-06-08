/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 介護サービス種類のインターフェースです。
 *
 * @author n9935 知念 広宰
 * @jpName 介護サービス種類インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護サービス
 * @mainClass
 * @reference
 */
public interface IKaigoServiceShurui extends Serializable {

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    ServiceShuruiCode getサービス種類コード();

    /**
     * 提供年月を返します。
     *
     * @return 提供年月
     */
    Range<FlexibleYearMonth> get提供年月();

    /**
     * サービス種類名称を返します。
     *
     * @return サービス種類名称
     */
    RString getサービス種類名称();

    /**
     * サービス種類名称略称を返します。
     *
     * @return サービス種類名称略称
     */
    RString getサービス種類名称略称();

    /**
     * サービス分類を返します。
     *
     * @return サービス分類
     */
    Code getサービス分類();

}
