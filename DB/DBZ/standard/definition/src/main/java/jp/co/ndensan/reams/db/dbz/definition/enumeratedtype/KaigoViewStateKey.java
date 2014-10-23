/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護業務における、ViewStateにデータを渡すときに使用するキー名称の一覧です。<br/>
 * <pre>
 * 例：被保険者台帳ModelをViewStateに保存・ViewStateから取得したい場合
 * → KaigoViewStateKey.被保険者台帳.getKey() を使用する
 * </pre>
 *
 * @author n8178 城間篤人
 */
public enum KaigoViewStateKey {

    被保険者台帳("hihokenshaDaicho");
    private final RString key;

    private KaigoViewStateKey(String key) {
        this.key = new RString(key);
    }

    /**
     * ViewStateKeyが持つ、Keyを表す文字列を返します。
     *
     * @return Keyを表す文字列
     */
    public RString getKey() {
        return key;
    }
}
