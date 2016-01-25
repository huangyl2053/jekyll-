/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.tajushochitokureisyakanri;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他住所地特例者管理のMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaJushochiTokureisyaKanriParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final RString psmShikibetsuTaisho;
    private final RString juushotiTokureiMono;
    private final JigyoshaNo nyushoShisetsuCode;
    private final RString juushotiTokureitaishouShisetu;

    /**
     * コンストラクタです。
     *
     * @param shikibetsuCode 識別コード
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private TaJushochiTokureisyaKanriParameter(
            @lombok.NonNull ShikibetsuCode shikibetsuCode,
            RString psmShikibetsuTaisho,
            RString juushotiTokureiMono,
            JigyoshaNo nyushoShisetsuCode,
            RString juushotiTokureitaishouShisetu) {
        this.shikibetsuCode = shikibetsuCode;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.juushotiTokureiMono = juushotiTokureiMono;
        this.nyushoShisetsuCode = nyushoShisetsuCode;
        this.juushotiTokureitaishouShisetu = juushotiTokureitaishouShisetu;
    }

    /**
     * 識別コード検索用のパラメータを生成します。
     *
     * @param shikibetsuCode 識別コード
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param juushotiTokureiMono 他市町村住所地特例者
     * @param nyushoShisetsuCode 入所施設コード
     * @param juushotiTokureitaishouShisetu 事業者種別
     * @return 他住所地特例者管理パラメータ
     */
    public static TaJushochiTokureisyaKanriParameter createParamBy他住所地特例者管理(
            ShikibetsuCode shikibetsuCode,
            RString psmShikibetsuTaisho,
            RString juushotiTokureiMono,
            JigyoshaNo nyushoShisetsuCode,
            RString juushotiTokureitaishouShisetu) {
        return new TaJushochiTokureisyaKanriParameter(shikibetsuCode, psmShikibetsuTaisho, juushotiTokureiMono, nyushoShisetsuCode, juushotiTokureitaishouShisetu);
    }
}
