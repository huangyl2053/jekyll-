/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.hokenryodankai;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ランク情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class RankJohoMapperParameter {

    private final FlexibleYear 賦課年度;
    private final RString ランク区分;

    private final boolean uses賦課年度;
    private final boolean usesランク区分;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 賦課年度
     * @param ランク区分 ランク区分
     * @param uses賦課年度 uses賦課年度
     * @param uses賦課年度 uses賦課年度
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private RankJohoMapperParameter(
            @lombok.NonNull FlexibleYear 賦課年度,
            @lombok.NonNull RString ランク区分,
            boolean uses賦課年度,
            boolean usesランク区分) {

        this.賦課年度 = 賦課年度;
        this.ランク区分 = ランク区分;

        this.uses賦課年度 = uses賦課年度;
        this.usesランク区分 = usesランク区分;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 賦課年度 賦課年度
     * @param ランク区分 ランク区分
     * @return 身体手帳検索パラメータ
     */
    public static RankJohoMapperParameter createSelectByKeyParam(
            FlexibleYear 賦課年度,
            RString ランク区分) {
        return new RankJohoMapperParameter(賦課年度, ランク区分, true, true);
    }
}
