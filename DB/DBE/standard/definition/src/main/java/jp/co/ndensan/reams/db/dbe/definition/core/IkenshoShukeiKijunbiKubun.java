/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書集計基準日区分を表す列挙型です。
 */
public enum IkenshoShukeiKijunbiKubun {

    /**
     * 依頼日を表します。
     */
    依頼日("1", "意見書依頼日"),
    /**
     * 記入日を表します。
     */
    記入日("2", "意見書記入日"),
    /**
     * 入手日を表します。
     */
    入手日("3", "意見書入手日");

    private final RString kubun;
    private final RString title;

    /**
     * コンストラクタです。
     *
     * @param kubun kubun
     */
    private IkenshoShukeiKijunbiKubun(String kubun, String title) {
        this.kubun = new RString(kubun);
        this.title = new RString(title);
    }

    /**
     * 区分の値を返します。
     *
     * @return 区分
     */
    public RString getKubun() {
        return kubun;
    }

    public RString getTitle() {
        return title;
    }

    /**
     * 引数の値と一致する意見書集計基準日区分を返します。
     *
     * @param kubun kubun
     * @return 意見書集計基準日区分
     * @throws IllegalArgumentException 一致する区分がない場合
     */
    public static IkenshoShukeiKijunbiKubun toValue(RString kubun) throws IllegalArgumentException {
        for (IkenshoShukeiKijunbiKubun value : values()) {
            if (value.getKubun().equals(kubun)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書集計基準日区分"));

    }

}
