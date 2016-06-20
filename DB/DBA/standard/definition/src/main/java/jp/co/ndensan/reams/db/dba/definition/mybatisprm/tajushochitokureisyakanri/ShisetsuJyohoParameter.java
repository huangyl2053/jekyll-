/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.tajushochitokureisyakanri;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設情報のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBA-0380-040 duanzhanli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShisetsuJyohoParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final FlexibleDate idoYMD;
    private final RString edaNo;
    private final JigyoshaNo nyushoShisetsuCode;
    private final RString juushotiTokureitaishouShisetu;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param shikibetsuCode 識別コード
     * @param idoYMD idoYMD
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShisetsuJyohoParameter(
            @lombok.NonNull ShikibetsuCode shikibetsuCode,
            FlexibleDate idoYMD,
            RString edaNo,
            JigyoshaNo nyushoShisetsuCode,
            RString juushotiTokureitaishouShisetu,
            RString psmShikibetsuTaisho) {
        this.shikibetsuCode = shikibetsuCode;
        this.idoYMD = idoYMD;
        this.edaNo = edaNo;
        this.nyushoShisetsuCode = nyushoShisetsuCode;
        this.juushotiTokureitaishouShisetu = juushotiTokureitaishouShisetu;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 識別コード検索用のパラメータを生成します。
     *
     * @param shikibetsuCode 識別コード
     * @param idoYMD 異動日
     * @param edaNo 枝番
     * @param nyushoShisetsuCode 入所施設コード
     * @param juushotiTokureitaishouShisetu 事業者種別
     * @param psmShikibetsuTaisho 台帳種別
     * @return 他住所地特例者管理パラメータ
     */
    public static ShisetsuJyohoParameter createParam_TaJushochi(
            ShikibetsuCode shikibetsuCode,
            FlexibleDate idoYMD,
            RString edaNo,
            JigyoshaNo nyushoShisetsuCode,
            RString juushotiTokureitaishouShisetu,
            RString psmShikibetsuTaisho) {
        return new ShisetsuJyohoParameter(
                shikibetsuCode,
                idoYMD,
                edaNo,
                nyushoShisetsuCode,
                juushotiTokureitaishouShisetu,
                psmShikibetsuTaisho);
    }
}
