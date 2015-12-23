/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaishadaichojoho;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 適用除外施設情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TekiyoJogaiShisetuJyohoParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private TekiyoJogaiShisetuJyohoParameter(
            @lombok.NonNull ShikibetsuCode 識別コード,
            RString psmShikibetsuTaisho
    ) {
        this.shikibetsuCode = 識別コード;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 識別コード検索用のパラメータを生成します。
     *
     * @param 識別コード 識別コード
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @return 適用除外者検索パラメータ
     */
    public static TekiyoJogaiShisetuJyohoParameter createParamFor識別コード(
            ShikibetsuCode 識別コード,
            RString psmShikibetsuTaisho
    ) {
        return new TekiyoJogaiShisetuJyohoParameter(識別コード, psmShikibetsuTaisho);
    }
}
