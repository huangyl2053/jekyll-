/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.karisanteiidotsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 生活保護対象者の列挙型です。
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
public enum SeikatsuHogoTaishosha {

    /**
     * コード：0 表記：する
     */
    する("0", "する"),
    /**
     * コード：1 表記：しない
     */
    しない("1", "しない");

    private final RString コード;

    private final RString 表記;

    private SeikatsuHogoTaishosha(String コード, String 表記) {
        this.コード = new RString(コード);
        this.表記 = new RString(表記);
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
     * @return 表記
     */
    public RString get表記() {
        return this.表記;
    }

    /**
     * コードより、生活保護対象者を取得する。
     *
     * @param コード コード
     * @return 生活保護対象者
     */
    public SeikatsuHogoTaishosha toValue(RString コード) {
        for (SeikatsuHogoTaishosha 生活保護対象者 : SeikatsuHogoTaishosha.values()) {
            if (生活保護対象者.コード.equals(コード)) {
                return 生活保護対象者;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("生活保護対象者"));
    }
}
