/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.kaigoninteiatenainfo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定宛名情報のMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class KaigoNinteiAtenaInfoParameter {

    private final boolean 識別コードフラグ;
    private final RString 識別コード;
    private final boolean 申請書管理番号フラグ;
    private final RString 申請書管理番号;
    private final RString psmShikibetsuTaisho;

    private KaigoNinteiAtenaInfoParameter(boolean 識別コードフラグ,
            RString 識別コード,
            boolean 申請書管理番号フラグ,
            RString 申請書管理番号,
            RString psmShikibetsuTaisho) {
        this.識別コードフラグ = 識別コードフラグ;
        this.識別コード = 識別コード;
        this.申請書管理番号フラグ = 申請書管理番号フラグ;
        this.申請書管理番号 = 申請書管理番号;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 介護認定宛名情報のパラメータを生成します。
     *
     * @param 識別コード RString
     * @param 申請書管理番号 RString
     * @param psmShikibetsuTaisho RString
     * @return 介護認定宛名情報パラメータ
     */
    public static KaigoNinteiAtenaInfoParameter createSelectByKeyParam(
            RString 識別コード,
            RString 申請書管理番号,
            RString psmShikibetsuTaisho) {
        boolean 識別コードフラグ = false;
        boolean 申請書管理番号フラグ = false;
        if (!RString.isNullOrEmpty(識別コード)) {
            識別コードフラグ = true;
        }
        if (!RString.isNullOrEmpty(申請書管理番号)) {
            申請書管理番号フラグ = true;
        }

        return new KaigoNinteiAtenaInfoParameter(識別コードフラグ,
                識別コード,
                申請書管理番号フラグ,
                申請書管理番号,
                psmShikibetsuTaisho);
    }
}
