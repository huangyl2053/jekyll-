/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.karisanteiidotsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票タイプの列挙型です。
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
public enum TyohyoType {

    /**
     * コード:1 名称:期毎タイプ
     */
    期毎タイプ("1", "期毎タイプ"),
    /**
     * コード:2 名称:タイプ2
     */
    タイプ2("2", "タイプ2"),
    /**
     * コード:3 名称:タイプ3
     */
    タイプ3("3", "タイプ3"),
    /**
     * コード:4 名称:銀振型4期タイプ
     */
    銀振型4期タイプ("4", "銀振型4期タイプ"),
    /**
     * コード:5 名称:ブックタイプ
     */
    ブックタイプ("5", "ブックタイプ"),
    /**
     * コード:6 名称:コンビニ収納タイプ
     */
    コンビニ収納タイプ("6", "コンビニ収納タイプ");

    private final RString コード;
    private final RString 名称;

    private TyohyoType(String コード, String 名称) {
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
     * コードより、帳票タイプを取得する。
     *
     * @param コード コード
     * @return 帳票タイプ
     */
    public TyohyoType toValue(RString コード) {
        for (TyohyoType 帳票タイプ : TyohyoType.values()) {
            if (帳票タイプ.コード.equals(コード)) {
                return 帳票タイプ;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("帳票タイプ"));
    }
}
