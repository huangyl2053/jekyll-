/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyokaisogaitosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 境界層該当者一覧情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyokaisoGaitoshaParameter {

    private final HihokenshaNo 被保険者番号;

    /**
     * コンストラクタ
     *
     * @param 被保険者番号 被保険者番号
     * * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KyokaisoGaitoshaParameter(
            @lombok.NonNull HihokenshaNo 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * 被保険者番号検索用のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 境界層該当者一覧情報検索パラメータ
     */
    public static KyokaisoGaitoshaParameter createParamFor被保険者番号(HihokenshaNo 被保険者番号) {
        return new KyokaisoGaitoshaParameter(被保険者番号);
    }
}
