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
public final class NinteichosahyoGaikyoChosaMybatisParameter {

    private final RString 市町村コード;
    private final RString 証記載保険者番号;
    private final RString 認定調査員コード;
    private final RString 検索年度月FROM;
    private final RString 検索年度月TO;
    private final boolean 検索年度月FROMフラグ;
    private final boolean 検索年度月TOフラグ;

    private NinteichosahyoGaikyoChosaMybatisParameter(
            RString 市町村コード,
            RString 証記載保険者番号,
            RString 認定調査員コード,
            RString 検索年度月FROM,
            RString 検索年度月TO,
            boolean 検索年度月FROMフラグ,
            boolean 検索年度月TOフラグ) {
        this.市町村コード = 市町村コード;
        this.証記載保険者番号 = 証記載保険者番号;
        this.認定調査員コード = 認定調査員コード;
        this.検索年度月FROM = 検索年度月FROM;
        this.検索年度月TO = 検索年度月TO;
        this.検索年度月FROMフラグ = 検索年度月FROMフラグ;
        this.検索年度月TOフラグ = 検索年度月TOフラグ;
    }

    /**
     * コンストラクタ作成
     *
     * @param 市町村コード RString
     * @param 証記載保険者番号 RString
     * @param 認定調査員コード RString
     * @param 検索年度月FROM RString
     * @param 検索年度月TO RString
     * @return NinteichosahyoGaikyoChosaMybatisParameter NinteichosahyoGaikyoChosaMybatisParameter
     */
    public static NinteichosahyoGaikyoChosaMybatisParameter createParam(
            RString 市町村コード,
            RString 証記載保険者番号,
            RString 認定調査員コード,
            RString 検索年度月FROM,
            RString 検索年度月TO
    ) {
        boolean 検索年度月FROMフラグ = false;
        boolean 検索年度月TOフラグ = false;
        if (!RString.isNullOrEmpty(検索年度月FROM)) {
            検索年度月FROMフラグ = true;
        }
        if (!RString.isNullOrEmpty(検索年度月TO)) {
            検索年度月TOフラグ = true;
        }
        return new NinteichosahyoGaikyoChosaMybatisParameter(
                市町村コード,
                証記載保険者番号,
                認定調査員コード,
                検索年度月FROM,
                検索年度月TO,
                検索年度月FROMフラグ,
                検索年度月TOフラグ);
    }
}
