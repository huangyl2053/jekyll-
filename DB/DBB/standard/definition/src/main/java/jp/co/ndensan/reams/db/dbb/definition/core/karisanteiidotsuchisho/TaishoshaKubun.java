/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.karisanteiidotsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者区分の列挙型です。
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
public enum TaishoshaKubun {

    /**
     * コード：0 名称：すべて選択
     */
    すべて選択("0", "すべて選択"),
    /**
     * コード：1 名称：現金納付者
     */
    現金納付者("1", "現金納付者"),
    /**
     * コード：2 名称：口座振替者
     */
    口座振替者("2", "口座振替者");

    private final RString コード;
    private final RString 名称;

    private TaishoshaKubun(String コード, String 名称) {
        this.コード = new RString(コード);
        this.名称 = new RString(名称);
    }

    /**
     * コードを取得する。
     *
     * @return コード
     */
    public RString getコード() {
        return this.コード;
    }

    /**
     * 名称を取得する。
     *
     * @return 名称
     */
    public RString get名称() {
        return this.名称;
    }

    /**
     * コードより、対象者区分を取得する。
     *
     * @param コード コード
     * @return 対象者区分
     */
    public TaishoshaKubun toValue(RString コード) {
        for (TaishoshaKubun 対象者区分 : TaishoshaKubun.values()) {
            if (対象者区分.コード.equals(コード)) {
                return 対象者区分;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対象者区分"));
    }
}
