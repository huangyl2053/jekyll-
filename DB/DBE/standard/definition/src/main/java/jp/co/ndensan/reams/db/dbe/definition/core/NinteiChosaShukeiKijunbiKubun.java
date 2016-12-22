/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査集計基準日を表す列挙型です。
 */
public enum NinteiChosaShukeiKijunbiKubun {

    /**
     * 依頼日を表します。
     */
    依頼日("1", "調査依頼日"),
    /**
     * 実施日を表します。
     */
    実施日("2", "調査実施日"),
    /**
     * 入手日を表します。
     */
    入手日("3", "調査入手日");

    private final RString kubun;
    private final RString title;

    /**
     * コンストラクタです。
     *
     * @param kubun kubun
     * @param title title
     */
    private NinteiChosaShukeiKijunbiKubun(String kubun, String title) {
        this.kubun = new RString(kubun);
        this.title = new RString(title);
    }

    /**
     * 区分を返します。
     *
     * @return 区分
     */
    public RString getKubun() {
        return kubun;
    }

    /**
     * タイトルを返します。
     *
     * @return タイトル
     */
    public RString getTitle() {
        return title;
    }

    /**
     * 引数と一致する認定調査集計基準日区分を返します。
     *
     * @param kubun kubun
     * @return 認定調査集計基準日区分
     */
    public static NinteiChosaShukeiKijunbiKubun toValue(RString kubun) {
        for (NinteiChosaShukeiKijunbiKubun value : values()) {
            if (value.getKubun().equals(kubun)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査集計基準日区分"));
    }

}
