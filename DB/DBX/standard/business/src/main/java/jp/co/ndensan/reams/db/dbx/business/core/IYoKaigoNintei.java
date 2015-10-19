/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定のインタフェースです。
 *
 * @author N2806 太田 智之
 * @jpName 要介護認定インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public interface IYoKaigoNintei extends Serializable {

    /**
     * 要介護認定申請を返します。
     *
     * @return 要介護認定申請
     */
    IYoKaigoNinteiShinsei get要介護認定申請();

    /**
     * 要介護認定調査を返します。
     *
     * @return 要介護認定調査
     */
    IYoKaigoNinteiChosa get要介護認定調査();

    /**
     * 意見書を返します。
     *
     * @return 意見書
     */
    IIkensho get意見書();

    /**
     * 要介護認定一次判定を返します。
     *
     * @return 要介護認定一次判定
     */
    IYoKaigoNinteiIchijiHantei get要介護認定一次判定();

    /**
     * 介護認定審査会を返します。
     *
     * @return 介護認定審査会
     */
    IKaigoNinteiShinsaKai get介護認定審査会();

    /**
     * 要介護認定結果を返します。
     *
     * @return 要介護認定結果
     */
    IYoKaigoNinteiKekka get要介護認定結果();

    /**
     * 主治医医師識別コードを返します。
     *
     * @return 主治医医師識別コード
     */
    RString get主治医医師識別コード();

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    RString get主治医氏名();

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    RString get主治医医療機関コード();

    /**
     * 主治医医療機関名称を返します。
     *
     * @return 主治医医療機関名称
     */
    RString get主治医医療機関名称();
}
