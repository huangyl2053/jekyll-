/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jyukyusyajoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 総合照会_受給者情報パラメータを作成します。
 *
 * @reamsid_L DBU-4100-030 xuyannan
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SogoSyokaiMybatisParameter {

    private final RString 被保険者番号;
    private final RString 申請状況区分;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 申請状況区分 申請状況区分
     */
    private SogoSyokaiMybatisParameter(
            RString 被保険者番号,
            RString 申請状況区分) {

        this.被保険者番号 = 被保険者番号;
        this.申請状況区分 = 申請状況区分;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 申請状況区分 申請状況区分
     * @return 検索用のパラメータ
     */
    public static SogoSyokaiMybatisParameter createParam(
            RString 被保険者番号,
            RString 申請状況区分) {
        return new SogoSyokaiMybatisParameter(被保険者番号, 申請状況区分);
    }
}
