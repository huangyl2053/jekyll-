/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaijoho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 合議体情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class GogitaiJohoMapperParameter {

    private final int gogitaiNo;
    private final FlexibleDate gogitaiYukoKikanKaishiYMD;

    private final boolean usesGogitaiNo;
    private final boolean usesGogitaiYukoKikanKaishiYMD;

    /**
     * コンストラクタです。
     *
     * @param gogitaiNo int
     * @param gogitaiYukoKikanKaishiYMD FlexibleDate
     * @param uses主キー1 boolean
     * @param uses主キー2 boolean
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private GogitaiJohoMapperParameter(
            int gogitaiNo,
            @lombok.NonNull FlexibleDate gogitaiYukoKikanKaishiYMD,
            boolean usesGogitaiNo,
            boolean usesGogitaiYukoKikanKaishiYMD) {

        this.gogitaiNo = gogitaiNo;
        this.gogitaiYukoKikanKaishiYMD = gogitaiYukoKikanKaishiYMD;

        this.usesGogitaiNo = usesGogitaiNo;
        this.usesGogitaiYukoKikanKaishiYMD = usesGogitaiYukoKikanKaishiYMD;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param gogitaiNo int
     * @param gogitaiYukoKikanKaishiYMD FlexibleDate
     * @return 身体手帳検索パラメータ
     */
    public static GogitaiJohoMapperParameter createSelectByKeyParam(
            int gogitaiNo,
            FlexibleDate gogitaiYukoKikanKaishiYMD) {
        return new GogitaiJohoMapperParameter(gogitaiNo, gogitaiYukoKikanKaishiYMD, true, true);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param gogitaiNo int
     * @return 身体手帳検索パラメータ
     */
    public static GogitaiJohoMapperParameter createSelectListParam(
            int gogitaiNo) {
        return new GogitaiJohoMapperParameter(gogitaiNo, FlexibleDate.EMPTY, true, false);
    }
}
