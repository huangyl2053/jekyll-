/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定申請者を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class YokaigoBatchMybitisParamter implements IMyBatisParameter {

    private final RString 申請書管理番号;
    private final RString 特記事項_フラグ;
    private final RString 原本マスク区分;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private YokaigoBatchMybitisParamter(RString 申請書管理番号, RString 特記事項_フラグ, RString 原本マスク区分) {
        this.申請書管理番号 = 申請書管理番号;
        this.特記事項_フラグ = 特記事項_フラグ;
        this.原本マスク区分 = 原本マスク区分;
    }

    /**
     * @param 申請書管理番号 申請書管理番号
     * @param 特記事項_フラグ 特記事項_フラグ
     * @return HanteiKekkaJohoShutsuryokuMybitisParamter
     */
    public static YokaigoBatchMybitisParamter createParam(RString 申請書管理番号, RString 特記事項_フラグ) {
        RString 原本マスク区分 = GenponMaskKubun.原本.getコード();
        if (特記事項_フラグ.equals(new RString("1"))) {
            原本マスク区分 = GenponMaskKubun.マスク.getコード();
        }
        return new YokaigoBatchMybitisParamter(申請書管理番号, 特記事項_フラグ, 原本マスク区分);
    }
}
