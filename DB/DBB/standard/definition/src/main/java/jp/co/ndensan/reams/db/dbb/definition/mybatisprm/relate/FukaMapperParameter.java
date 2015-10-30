/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 介護賦課を特定するためのMyBatis用パラメータクラスです。
 */
public final class FukaMapperParameter {

// TODO 主キー型、主キー名を適切に置換してください。
// TODO 主キーの数が足りない場合、処理を追加してください。
    private final FlexibleYear 主キー1;
    private final FlexibleYear 主キー2;
//    private final TsuchishoNo 主キー3;
//    private final Decimal 主キー4;

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
    private FukaMapperParameter(
            @lombok.NonNull FlexibleYear 主キー1,
            @lombok.NonNull FlexibleYear 主キー2,
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
    public static FukaMapperParameter createSelectByKeyParam(
            FlexibleYear 主キー1,
            FlexibleYear 主キー2) {
        return new FukaMapperParameter(主キー1, 主キー2, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param 主キー1 主キー1
     * @return 身体手帳検索パラメータ
     */
    public static FukaMapperParameter createSelectListParam(
            FlexibleYear 主キー1) {
        return new FukaMapperParameter(主キー1, FlexibleYear.EMPTY, true, false);
    }

    public FlexibleYear get主キー1() {
        return 主キー1;
    }

    public FlexibleYear get主キー2() {
        return 主キー2;
    }

    public boolean isUses主キー1() {
        return uses主キー1;
    }

    public boolean isUses主キー2() {
        return uses主キー2;
    }
}
