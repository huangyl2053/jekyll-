/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.karisanteiidotsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力方式の列挙型です。
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
public enum ShutsuryokuHoshiki {

    /**
     * コード:0 名称:別々に出力
     */
    別々に出力("0", "別々に出力"),
    /**
     * コード:1 名称:全件出力
     */
    全件出力("1", "全件出力");

    private final RString 名称;
    private final RString コード;

    private ShutsuryokuHoshiki(String コード, String 名称) {
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
     * コードより、出力方式を取得する。
     *
     * @param コード コード
     * @return 出力方式
     */
    public ShutsuryokuHoshiki toValue(RString コード) {
        for (ShutsuryokuHoshiki 出力方式 : ShutsuryokuHoshiki.values()) {
            if (出力方式.コード.equals(コード)) {
                return 出力方式;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("出力方式"));
    }
}
