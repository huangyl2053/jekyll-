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
    private final boolean shinsakaiKaisaiBashoJokyo;
    private final boolean isNowYukoGogitai;

    /**
     * コンストラクタです。
     *
     * @param gogitaiNo int
     * @param gogitaiYukoKikanKaishiYMD FlexibleDate
     * @param uses主キー1 boolean
     * @param uses主キー2 boolean
     * @param shinsakaiKaisaiBashoJokyo boolean
     * @param isNowYukoGogitai boolean
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private GogitaiJohoMapperParameter(
            int gogitaiNo,
            @lombok.NonNull FlexibleDate gogitaiYukoKikanKaishiYMD,
            boolean usesGogitaiNo,
            boolean usesGogitaiYukoKikanKaishiYMD,
            boolean shinsakaiKaisaiBashoJokyo,
            boolean isNowYukoGogitai) {

        this.gogitaiNo = gogitaiNo;
        this.gogitaiYukoKikanKaishiYMD = gogitaiYukoKikanKaishiYMD;

        this.usesGogitaiNo = usesGogitaiNo;
        this.usesGogitaiYukoKikanKaishiYMD = usesGogitaiYukoKikanKaishiYMD;
        this.shinsakaiKaisaiBashoJokyo = shinsakaiKaisaiBashoJokyo;
        this.isNowYukoGogitai = isNowYukoGogitai;
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
        return new GogitaiJohoMapperParameter(gogitaiNo, gogitaiYukoKikanKaishiYMD, true, true, true, false);
    }

    /**
     * 一覧検索用のパラメータを生成します。
     *
     * @param gogitaiNo int
     * @return 身体手帳検索パラメータ
     */
    public static GogitaiJohoMapperParameter createSelectListParam(
            int gogitaiNo) {
        return new GogitaiJohoMapperParameter(gogitaiNo, FlexibleDate.EMPTY, true, false, true, false);
    }

    /**
     * 開催場所検索用のパラメータを生成します。
     *
     * @param 審査会開催場所状況 審査会開催場所状況
     * @return 身体手帳検索パラメータ
     */
    public static GogitaiJohoMapperParameter createSelectBy審査会開催場所状況(boolean 審査会開催場所状況) {
        return new GogitaiJohoMapperParameter(0, FlexibleDate.EMPTY, true, false, 審査会開催場所状況, false);
    }

    /**
     * 合議体情報作成のパラメータを生成します。
     *
     * @param 現在有効な合議体のみ 現在有効な合議体のみ
     * @return 合議体情報作成パラメータ
     */
    public static GogitaiJohoMapperParameter createSelectBy合議体情報作成(boolean 現在有効な合議体のみ) {
        return new GogitaiJohoMapperParameter(0, FlexibleDate.getNowDate(), false, false, false, 現在有効な合議体のみ);
    }
}
