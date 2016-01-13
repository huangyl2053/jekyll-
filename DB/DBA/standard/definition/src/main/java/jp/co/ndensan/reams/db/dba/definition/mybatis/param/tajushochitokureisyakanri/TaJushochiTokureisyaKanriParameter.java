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
     * @param psmShikibetsuTaisho 他市町村住所地特例者
     * @param nyushoShisetsuCode 入所施設コード
     * @param juushotiTokureitaishouShisetu 住所地特例対象施設
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

//    /**
//     * 識別コード検索用のパラメータを生成します。
//     *
//     * @param shikibetsuCode 識別コード
//     * @param psmShikibetsuTaisho psmShikibetsuTaisho
//     * @param psmShikibetsuTaisho 他市町村住所地特例者
//     * @param nyushoShisetsuCode 入所施設コード
//     * @param juushotiTokureitaishouShisetu 住所地特例対象施設
//     * @return 他住所地特例者管理パラメータ
//     */
//    public static TaJushochiTokureisyaKanriParameter createParamFor識別コード(
//            ShikibetsuCode shikibetsuCode,
//            RString psmShikibetsuTaisho,
//            RString juushotiTokureiMono,
//            JigyoshaNo nyushoShisetsuCode,
//            RString juushotiTokureitaishouShisetu) {
//        return new TaJushochiTokureisyaKanriParameter(shikibetsuCode, psmShikibetsuTaisho, RString.EMPTY, JigyoshaNo.EMPTY, RString.EMPTY);
//    }
//
//    /**
//     * 他市町村住所地特例情報取得のパラメータを生成します。
//     *
//     * @param shikibetsuCode 識別コード
//     * @param psmShikibetsuTaisho psmShikibetsuTaisho
//     * @param psmShikibetsuTaisho 他市町村住所地特例者
//     * @param nyushoShisetsuCode 入所施設コード
//     * @param juushotiTokureitaishouShisetu 住所地特例対象施設
//     * @return 他住所地特例者管理パラメータ
//     */
//    public static TaJushochiTokureisyaKanriParameter createParamBy他市町村住所地特例(
//            ShikibetsuCode shikibetsuCode,
//            RString psmShikibetsuTaisho,
//            RString juushotiTokureiMono,
//            JigyoshaNo nyushoShisetsuCode,
//            RString juushotiTokureitaishouShisetu) {
//        return new TaJushochiTokureisyaKanriParameter(shikibetsuCode, RString.EMPTY, RString.EMPTY, JigyoshaNo.EMPTY, RString.EMPTY);
//    }
//
//    /**
//     * 事業者名称取得のパラメータを生成します。
//     *
//     * @param shikibetsuCode 識別コード
//     * @param psmShikibetsuTaisho psmShikibetsuTaisho
//     * @param psmShikibetsuTaisho 他市町村住所地特例者
//     * @param nyushoShisetsuCode 入所施設コード
//     * @param juushotiTokureitaishouShisetu 住所地特例対象施設
//     * @return 他住所地特例者管理パラメータ
//     */
//    public static TaJushochiTokureisyaKanriParameter createParamBy事業者名称取得FOR介護保険施設(
//            ShikibetsuCode shikibetsuCode,
//            RString psmShikibetsuTaisho,
//            RString juushotiTokureiMono,
//            JigyoshaNo nyushoShisetsuCode,
//            RString juushotiTokureitaishouShisetu) {
//        return new TaJushochiTokureisyaKanriParameter(ShikibetsuCode.EMPTY, RString.EMPTY, RString.EMPTY, nyushoShisetsuCode, RString.EMPTY);
//    }
//
//    /**
//     * 事業者名称取得のパラメータを生成します。
//     *
//     * @param shikibetsuCode 識別コード
//     * @param psmShikibetsuTaisho psmShikibetsuTaisho
//     * @param psmShikibetsuTaisho 他市町村住所地特例者
//     * @param nyushoShisetsuCode 入所施設コード
//     * @param juushotiTokureitaishouShisetu 住所地特例対象施設
//     * @return 他住所地特例者管理パラメータ
//     */
//    public static TaJushochiTokureisyaKanriParameter createParamBy事業者名称取得FOR住所地特例対象施設(
//            ShikibetsuCode shikibetsuCode,
//            RString psmShikibetsuTaisho,
//            RString juushotiTokureiMono,
//            JigyoshaNo nyushoShisetsuCode,
//            RString juushotiTokureitaishouShisetu) {
//        return new TaJushochiTokureisyaKanriParameter(ShikibetsuCode.EMPTY, RString.EMPTY, RString.EMPTY, nyushoShisetsuCode, juushotiTokureitaishouShisetu);
//    }
}
