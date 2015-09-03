/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.codeassigneditem;

import jp.co.ndensan.reams.db.dbx.definition.CodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格喪失事由を表すクラスです。
 *
 * @author N3327 三浦 凌
 * @jpName 資格喪失事由インタフェース
 * @bizDomain
 * @category CodeAssignedItem
 * @subCategory
 * @mainClass
 * @reference
 */
public class ShikakuSoshitsuJiyu extends CodeAssignedItem {

    /**
     * コンストラクタです。
     *
     * @param code コード
     * @param codeMeisho 名称
     * @param codeRyakusho 略称
     * @param option1 任意情報1
     * @param option2 任意情報2
     * @param option3 任意情報3
     */
    public ShikakuSoshitsuJiyu(Code code, RString codeMeisho, RString codeRyakusho, RString option1, RString option2, RString option3) {
        super(code, codeMeisho, codeRyakusho, option1, option2, option3);
    }

    /**
     * 任意情報を指定しないパターンのコンストラクタです。<br />
     * 任意情報の設定が不要な場合、こちらを使用してください。
     *
     * @param code コード
     * @param codeMeisho コード名称
     * @param codeRyakusho コード略称
     */
    public ShikakuSoshitsuJiyu(Code code, RString codeMeisho, RString codeRyakusho) {
        super(code, codeMeisho, codeRyakusho, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }
}
