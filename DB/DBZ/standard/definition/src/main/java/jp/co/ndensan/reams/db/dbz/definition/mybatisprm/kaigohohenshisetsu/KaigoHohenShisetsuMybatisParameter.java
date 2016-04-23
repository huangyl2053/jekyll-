/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.kaigohohenshisetsu;

import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 施設情報の検索条件。
 *
 * @reamsid_L DBA-0360-050 wangkun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KaigoHohenShisetsuMybatisParameter {

    private final RString 入所施設種類_介護保険施設 = ShisetsuType.介護保険施設.getコード();
    private final RString 入所施設種類_住所地特例対象施設 = ShisetsuType.住所地特例対象施設.getコード();
    private final RString 入所施設種類_適用除外施設 = ShisetsuType.適用除外施設.getコード();
    private final RString 事業者種別_住所地特例対象施設 = JigyosyaType.住所地特例対象施設.getコード();
    private final RString 事業者種別_適用除外施設 = JigyosyaType.適用除外施設.getコード();
    private final ShikibetsuCode shikibetsuCode;
    private final RString 台帳種別;
    private boolean 被保険者台帳_他住所地特例者台帳の時_フラグ = false;
    private boolean 適用除外者台帳の時_フラグ = false;

    /**
     * コンストラクタです。
     *
     * @param shikibetsuCode 識別コード
     * @param 台帳種別 台帳種別
     */
    public KaigoHohenShisetsuMybatisParameter(ShikibetsuCode shikibetsuCode, RString 台帳種別) {
        if (new RString("1").equals(台帳種別)) {
            被保険者台帳_他住所地特例者台帳の時_フラグ = true;
        }
        if (new RString("2").equals(台帳種別)) {
            被保険者台帳_他住所地特例者台帳の時_フラグ = true;
        }
        if (new RString("3").equals(台帳種別)) {
            適用除外者台帳の時_フラグ = true;
        }
        this.shikibetsuCode = shikibetsuCode;
        this.台帳種別 = 台帳種別;
    }
}
