/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 *
 * 資格の情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBB-0630-050 chengsanyuan
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihokenshaDaichoSearchCondition {

    private final HihokenshaNo hihokenshaNo;
    private final boolean usesHihokenshaNo;

    /**
     * コンストラクタです。
     *
     * @param hihokenshaNo HihokenshaNo
     * @param usesHihokenshaNo boolean
     */
    private HihokenshaDaichoSearchCondition(
            HihokenshaNo hihokenshaNo,
            boolean usesHihokenshaNo) {

        this.hihokenshaNo = hihokenshaNo;
        this.usesHihokenshaNo = usesHihokenshaNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param hihokenshaNo HihokenshaNo
     * @param usesHihokenshaNo boolean
     * @return 資格の情報検索パラメータ
     */
    public static HihokenshaDaichoSearchCondition createSelectByKeyParam(
            HihokenshaNo hihokenshaNo,
            boolean usesHihokenshaNo) {
        return new HihokenshaDaichoSearchCondition(hihokenshaNo, true);
    }

}
