/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaisha.tekiyojogaisha;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 適用除外者を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TekiyoJogaishaMapperParameter {

    private final ShikibetsuCode 識別コード;
    private final FlexibleDate 異動日;
    private final RString 枝番;
    private final RString psmShikibetsuTaisho;
    private final FlexibleDate kaijoYMD;
    private final FlexibleDate tekiyoYMD;
    private final boolean 論理削除フラグ;
    private final boolean 解除日あり;
    private final boolean 解除日なし;
    private final boolean uses識別コード;
    private final boolean uses異動日;
    private final boolean uses枝番;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @param uses識別コード uses識別コード
     * @param uses異動日 uses異動日
     * @param uses枝番 uses枝番
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private TekiyoJogaishaMapperParameter(
            @lombok.NonNull ShikibetsuCode 識別コード,
            @lombok.NonNull FlexibleDate 異動日,
            @lombok.NonNull RString 枝番,
            boolean uses識別コード,
            boolean uses異動日,
            boolean uses枝番,
            FlexibleDate kaijoYMD,
            FlexibleDate tekiyoYMD,
            boolean 論理削除フラグ,
            boolean 解除日あり,
            boolean 解除日なし,
            RString psmShikibetsuTaisho) {
        this.識別コード = 識別コード;
        this.異動日 = 異動日;
        this.枝番 = 枝番;
        this.uses識別コード = uses識別コード;
        this.uses異動日 = uses異動日;
        this.uses枝番 = uses枝番;
        this.kaijoYMD = kaijoYMD;
        this.tekiyoYMD = tekiyoYMD;
        this.論理削除フラグ = 論理削除フラグ;
        this.解除日あり = 解除日あり;
        this.解除日なし = 解除日なし;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @return 適用除外者検索パラメータ
     */
    public static TekiyoJogaishaMapperParameter createSelectByKeyParam(
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) {
        return new TekiyoJogaishaMapperParameter(
                識別コード, 異動日, 枝番, true, true, true,
                FlexibleDate.MAX, FlexibleDate.MAX, true, true, true, RString.EMPTY);
    }

    /**
     * Max履歴番号検索用のパラメータを生成します。
     *
     * @param 識別コード 識別コード
     * @return 適用除外者を特定するためのパラメータ
     */
    public static TekiyoJogaishaMapperParameter createParam_getMax履歴番号(
            ShikibetsuCode 識別コード) {
        return new TekiyoJogaishaMapperParameter(
                識別コード, FlexibleDate.MAX, RString.EMPTY, true,
                true, true, FlexibleDate.MAX, FlexibleDate.MAX, true, true, true, RString.EMPTY);
    }

    /**
     * 宛名情報検索用のパラメータを生成します。
     *
     * @param 識別コード 識別コード
     * @param psmShikibetsuTaisho RString
     * @return 適用除外者を特定するためのパラメータ
     */
    public static TekiyoJogaishaMapperParameter createParam_get宛名情報(
            ShikibetsuCode 識別コード,
            RString psmShikibetsuTaisho) {
        return new TekiyoJogaishaMapperParameter(
                識別コード, FlexibleDate.MAX, RString.EMPTY, true,
                true, true, FlexibleDate.MAX, FlexibleDate.MAX, true, true, true, psmShikibetsuTaisho);
    }

    /**
     * 最大の枝番検索用のパラメータを生成します。
     *
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @return 適用除外者を特定するためのパラメータ
     */
    public static TekiyoJogaishaMapperParameter createParam_get最大の枝番(
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日) {
        return new TekiyoJogaishaMapperParameter(
                識別コード, 異動日, RString.EMPTY, true, true, true,
                FlexibleDate.MAX, FlexibleDate.MAX, true, true, true, RString.EMPTY);
    }

    /**
     * 適用除外者索用のパラメータを生成します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 論理削除フラグ boolean
     * @return 適用除外者を特定するためのパラメータ
     */
    public static TekiyoJogaishaMapperParameter createParam_get適用除外者(
            ShikibetsuCode 識別コード,
            boolean 論理削除フラグ) {
        return new TekiyoJogaishaMapperParameter(
                識別コード, FlexibleDate.MAX, RString.EMPTY, true, true, true,
                FlexibleDate.MAX, FlexibleDate.MAX, 論理削除フラグ, true, true, RString.EMPTY);
    }

    /**
     * 施設情検索用のパラメータを生成します。
     *
     * @param 識別コード 識別コード
     * @param kaijoYMD FlexibleDate
     * @param tekiyoYMD FlexibleDate
     * @return 適用除外者を特定するためのパラメータ
     */
    public static TekiyoJogaishaMapperParameter createParam_get施設情(
            ShikibetsuCode 識別コード,
            FlexibleDate kaijoYMD,
            FlexibleDate tekiyoYMD) {
        boolean 解除日あり = false;
        boolean 解除日なし = false;
        if (kaijoYMD == null || kaijoYMD.isEmpty()) {
            解除日あり = true;
        } else {
            解除日なし = true;
        }
        return new TekiyoJogaishaMapperParameter(識別コード, FlexibleDate.MAX,
                RString.EMPTY, true, true, true, kaijoYMD, tekiyoYMD, true, 解除日あり, 解除日なし, RString.EMPTY);
    }
}
