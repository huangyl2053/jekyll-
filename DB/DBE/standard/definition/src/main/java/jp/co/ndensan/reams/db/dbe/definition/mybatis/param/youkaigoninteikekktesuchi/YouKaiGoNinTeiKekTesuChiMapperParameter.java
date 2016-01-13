/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.youkaigoninteikekktesuchi;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class YouKaiGoNinTeiKekTesuChiMapperParameter {

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
    private YouKaiGoNinTeiKekTesuChiMapperParameter(
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

}
