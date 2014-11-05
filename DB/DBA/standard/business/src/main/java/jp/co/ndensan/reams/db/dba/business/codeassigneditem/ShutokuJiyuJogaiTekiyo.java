/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.codeassigneditem;

import jp.co.ndensan.reams.ur.urz.business.CodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 取得事由（除外適用）のコードマスタ情報を表すクラスです。
 *
 * @author N9606 漢那 憲作
 */
public class ShutokuJiyuJogaiTekiyo extends CodeAssignedItem {

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
    public ShutokuJiyuJogaiTekiyo(Code code, RString codeMeisho, RString codeRyakusho, RString option1, RString option2, RString option3) {
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
    public ShutokuJiyuJogaiTekiyo(Code code, RString codeMeisho, RString codeRyakusho) {
        super(code, codeMeisho, codeRyakusho, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }
}
