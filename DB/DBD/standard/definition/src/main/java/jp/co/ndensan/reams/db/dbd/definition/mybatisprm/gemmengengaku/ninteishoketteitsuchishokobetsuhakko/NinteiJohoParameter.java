/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.ninteishoketteitsuchishokobetsuhakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定情報を取得するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3540-030 wangchao
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiJohoParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString 減免減額種類;
    private final int 履歴番号;

    private NinteiJohoParameter(HihokenshaNo 被保険者番号, RString 減免減額種類, int 履歴番号) {
        this.被保険者番号 = 被保険者番号;
        this.減免減額種類 = 減免減額種類;
        this.履歴番号 = 履歴番号;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類 減免減額種類
     * @param 履歴番号 履歴番号
     * @return キー検索用のパラメータ
     */
    public static NinteiJohoParameter createParameter(HihokenshaNo 被保険者番号, RString 減免減額種類, int 履歴番号) {
        return new NinteiJohoParameter(被保険者番号, 減免減額種類, 履歴番号);
    }
}
