/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * イメージ取込み（規定・規定外）の検索用パラメータクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ImageinputMapperParamter {

    private final RString 証記載保険者番号;
    private final RString 被保険者番号;
    private final RString 認定申請日;

    private ImageinputMapperParamter(RString 証記載保険者番号,
            RString 被保険者番号,
            RString 認定申請日) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.認定申請日 = 認定申請日;
    }

    /**
     * イメージ取込み（規定・規定外）の検索用パラメータを作成します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 認定申請日 認定申請日
     * @return イメージ取込み（規定・規定外）の検索用パラメータ
     */
    public static ImageinputMapperParamter createParamter(RString 証記載保険者番号,
            RString 被保険者番号,
            RString 認定申請日) {
        return new ImageinputMapperParamter(証記載保険者番号, 被保険者番号, 認定申請日);
    }

}
