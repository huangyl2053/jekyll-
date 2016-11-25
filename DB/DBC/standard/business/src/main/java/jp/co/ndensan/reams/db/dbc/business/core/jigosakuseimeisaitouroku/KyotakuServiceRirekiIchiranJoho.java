/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku;

import java.io.Serializable;
import java.util.List;

/**
 * 居宅サービス履歴一覧情報クラスです。
 *
 * @reamsid_L DBC-1930-010 xuchangyong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyotakuServiceRirekiIchiranJoho implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    private List<KyotakuServiceRirekiIchiranEntityResult> rirekiIchiran;

    /**
     * コンストラクタです。
     *
     * @param 居宅サービス履歴一覧 居宅サービス履歴一覧
     */
    public KyotakuServiceRirekiIchiranJoho(List<KyotakuServiceRirekiIchiranEntityResult> 居宅サービス履歴一覧) {
        this.rirekiIchiran = 居宅サービス履歴一覧;
    }
}
