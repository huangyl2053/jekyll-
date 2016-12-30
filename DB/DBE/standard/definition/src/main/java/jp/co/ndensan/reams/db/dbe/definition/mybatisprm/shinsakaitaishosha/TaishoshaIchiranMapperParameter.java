/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaitaishosha;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会個人別状況照会対象一覧取得用のMyBatis用パラメータクラスです。
 *
 * n3502
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TaishoshaIchiranMapperParameter {

    private final RString 審査会開催番号;
    private final LasdecCode 市町村コード;

    private TaishoshaIchiranMapperParameter(RString 審査会開催番号, LasdecCode 市町村コード) {
        this.審査会開催番号 = 審査会開催番号;
        this.市町村コード = 市町村コード;
    }

    /**
     * 予定情報と結果情報のパラメータを生成します。
     *
     * @param 審査会開催番号 RString
     * @param 市町村コード LasdecCode
     * @return ShinsakaiTaishoshaMapperParameter
     */
    public static TaishoshaIchiranMapperParameter createSelectBy情報(RString 審査会開催番号, LasdecCode 市町村コード) {
        return new TaishoshaIchiranMapperParameter(審査会開催番号, 市町村コード);
    }
}
