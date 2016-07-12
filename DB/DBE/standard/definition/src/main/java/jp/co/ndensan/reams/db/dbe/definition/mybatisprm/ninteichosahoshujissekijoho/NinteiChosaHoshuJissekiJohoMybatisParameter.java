/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahoshujissekijoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 認定調査委託料入力パラメタクラスです。
 *
 * @reamsid_L DBE-1970-010 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class NinteiChosaHoshuJissekiJohoMybatisParameter {

    private final boolean 市町村コードフラグ;
    private final RString 市町村コード;
    private final boolean 調査員氏名フラグ;
    private final boolean 前方一致フラグ;
    private final boolean 完全一致フラグ;
    private final boolean 部分一致フラグ;
    private final boolean 後方一致フラグ;
    private final boolean usesSaidaiHyojiKensu;
    private final Decimal saidaiHyojiKensu;
    private final RString 調査員氏名;
    private final RString 一致;

    private NinteiChosaHoshuJissekiJohoMybatisParameter(
            boolean 市町村コードフラグ,
            RString 市町村コード,
            boolean usesSaidaiHyojiKensu,
            Decimal saidaiHyojiKensu,
            RString 調査員氏名,
            RString 一致,
            boolean 調査員氏名フラグ,
            boolean 前方一致フラグ,
            boolean 完全一致フラグ,
            boolean 部分一致フラグ,
            boolean 後方一致フラグ) {
        this.市町村コード = 市町村コード;
        this.市町村コードフラグ = 市町村コードフラグ;
        this.調査員氏名フラグ = 調査員氏名フラグ;
        this.前方一致フラグ = 前方一致フラグ;
        this.後方一致フラグ = 後方一致フラグ;
        this.部分一致フラグ = 部分一致フラグ;
        this.完全一致フラグ = 完全一致フラグ;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.調査員氏名 = 調査員氏名;
        this.一致 = 一致;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
    }

    /**
     * コンストラクタ作成
     *
     * @param 市町村コード RString
     * @param saidaiHyojiKensu RString
     * @param 調査員氏名 RString
     * @param 一致 RString
     * @return NinteiChosaHoshuJissekiJohoMybatisParameter NinteiChosaHoshuJissekiJohoMybatisParameter
     */
    public static NinteiChosaHoshuJissekiJohoMybatisParameter createParam(
            RString 市町村コード,
            Decimal saidaiHyojiKensu,
            RString 調査員氏名,
            RString 一致
    ) {
        boolean 市町村コードフラグ = false;
        boolean 調査員氏名フラグ = false;
        boolean usesSaidaiHyojiKensu = false;
        if (!RString.isNullOrEmpty(市町村コード)) {
            市町村コードフラグ = true;
        }
        if (!RString.isNullOrEmpty(調査員氏名)) {
            調査員氏名フラグ = true;
        }
        if (saidaiHyojiKensu != null) {
            usesSaidaiHyojiKensu = true;
        }
        return new NinteiChosaHoshuJissekiJohoMybatisParameter(
                市町村コードフラグ,
                市町村コード,
                usesSaidaiHyojiKensu,
                saidaiHyojiKensu,
                調査員氏名,
                一致,
                調査員氏名フラグ,
                itti(一致, new RString("key0")),
                itti(一致, new RString("key1")),
                itti(一致, new RString("key2")),
                itti(一致, new RString("key3")));
    }

    private static boolean itti(RString 一致, RString key) {
        return 一致.equals(key);
    }
}
