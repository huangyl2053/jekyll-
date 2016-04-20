package jp.co.ndensan.reams.db.dba.definition.mybatisprm.kyokaisogaitosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 境界層該当者を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyokaisoGaitoshaMapperParameter {

    private final HihokenshaNo 被保険者番号;
    private final int 履歴番号;
    private final int リンク番号;

    private final boolean uses被保険者番号;
    private final boolean uses履歴番号;
    private final boolean usesリンク番号;

    private KyokaisoGaitoshaMapperParameter(
            @lombok.NonNull HihokenshaNo 被保険者番号,
            @lombok.NonNull int 履歴番号,
            @lombok.NonNull int リンク番号,
            boolean uses被保険者番号,
            boolean uses履歴番号,
            boolean usesリンク番号) {

        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;
        this.リンク番号 = リンク番号;

        this.uses被保険者番号 = uses被保険者番号;
        this.uses履歴番号 = uses履歴番号;
        this.usesリンク番号 = usesリンク番号;
    }

// TODO 用途に応じたパラメータ生成メソッドを追加、修正してください。
    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 int
     * @param リンク番号 int
     * @return KyokaisoGaitoshaMapperParameter
     */
    public static KyokaisoGaitoshaMapperParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号,
            int 履歴番号,
            int リンク番号) {
        return new KyokaisoGaitoshaMapperParameter(被保険者番号, 履歴番号, リンク番号, true, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param リンク番号 int
     * @return KyokaisoGaitoshaMapperParameter
     */
    public static KyokaisoGaitoshaMapperParameter createSelectListParam(
            HihokenshaNo 被保険者番号,
            int リンク番号) {
        return new KyokaisoGaitoshaMapperParameter(被保険者番号, 0, リンク番号, true, false, true);
    }
}
