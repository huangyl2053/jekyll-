/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahoshujissekijoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査委託料入力パラメタクラスです。
 *
 * @reamsid_L DBE-1970-010 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class NinteiChosaHoshuTankaMybatisParamter {

    private final RString 申請書管理番号;
    private final int 認定調査依頼履歴番号;
    private final RString イメージ区分;
    private final RString 認定調査実施日;

    private NinteiChosaHoshuTankaMybatisParamter(
            RString 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString イメージ区分,
            RString 認定調査実施日
    ) {
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.イメージ区分 = イメージ区分;
        this.認定調査実施日 = 認定調査実施日;
    }

    /**
     * コンストラクタ作成
     *
     * @param 申請書管理番号 RString
     * @param 認定調査依頼履歴番号 RString
     * @param イメージ区分 RString
     * @param 認定調査実施日 RString
     * @return NinteiChosaHoshuTankaMybatisParamter NinteiChosaHoshuTankaMybatisParamter
     */
    public static NinteiChosaHoshuTankaMybatisParamter createParam(
            RString 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString イメージ区分,
            RString 認定調査実施日) {

        return new NinteiChosaHoshuTankaMybatisParamter(
                申請書管理番号,
                認定調査依頼履歴番号,
                イメージ区分,
                認定調査実施日
        );
    }
}
