/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.relate;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居宅給付計画届出を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class KyotakuKeikakuTodokedeMapperParameter {

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
    private final HihokenshaNo 主キー1;
    private final FlexibleYearMonth 主キー2;
    private Decimal 主キー3;

    private final boolean uses主キー1;
    private final boolean uses主キー2;

// TODO 用途に応じてアクセス修飾子を修正してください。
    /**
     * コンストラクタです。
     *
     * @param 主キー1 主キー1
     * @param 主キー2 主キー2
     * @param uses主キー1 uses主キー1
     * @param uses主キー2 uses主キー2
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KyotakuKeikakuTodokedeMapperParameter(
            @lombok.NonNull HihokenshaNo 主キー1,
            @lombok.NonNull FlexibleYearMonth 主キー2,
            boolean uses主キー1,
            boolean uses主キー2) {

        this.主キー1 = 主キー1;
        this.主キー2 = 主キー2;

        this.uses主キー1 = uses主キー1;
        this.uses主キー2 = uses主キー2;
    }

// TODO 用途に応じたパラメータ生成メソッドを追加、修正してください。
    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 主キー1 主キー1
     * @param 主キー2 主キー2
     * @return 身体手帳検索パラメータ
     */
    public static KyotakuKeikakuTodokedeMapperParameter createSelectByKeyParam(
            HihokenshaNo 主キー1,
            FlexibleYearMonth 主キー2) {
        return new KyotakuKeikakuTodokedeMapperParameter(主キー1, 主キー2, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 主キー1 主キー1
     * @return 身体手帳検索パラメータ
     */
    public static KyotakuKeikakuTodokedeMapperParameter createSelectListParam(
            HihokenshaNo 主キー1) {
        return new KyotakuKeikakuTodokedeMapperParameter(主キー1, FlexibleYearMonth.MIN, true, false);
    }
}
