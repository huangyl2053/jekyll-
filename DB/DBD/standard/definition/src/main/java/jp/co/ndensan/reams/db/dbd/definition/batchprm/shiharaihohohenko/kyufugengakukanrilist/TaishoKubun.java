/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.shiharaihohohenko.kyufugengakukanrilist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象区分(給付減額管理リスト)の列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum TaishoKubun {

    /**
     * コード：1 名称：全登録者
     */
    全登録者("1", "全登録者"),
    /**
     * コード：1 名称：全登録者以外
     */
    全登録者以外("1", "全登録者以外");

    private final RString コード;
    private final RString 名称;

    private TaishoKubun(String コード, String 名称) {
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
     * コードより、対象区分(給付減額管理リスト)を取得する。
     *
     * @param コード コード
     * @return 対象区分(給付減額管理リスト)
     */
    public TaishoKubun toValue(RString コード) {
        for (TaishoKubun 対象区分 : TaishoKubun.values()) {
            if (対象区分.コード.equals(コード)) {
                return 対象区分;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対象区分(給付減額管理リスト)"));
    }
}
