/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.db.dbz.definition.core.daichokubun.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険特定負担限度額申請書の検索のパラメータクラスです。
 *
 * @reamsid_L DBA-0540-160 houtianpeng
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuteifutanMybatisParam {

    private final RString 種別;
    private final RString コード;

    private TokuteifutanMybatisParam(RString 種別, RString コード) {
        this.種別 = 種別;
        this.コード = コード;
    }

    /**
     * 施設情報パラメータの作成します。
     *
     * @param 識別コード 識別コード
     * @return 介護保険特定負担限度額申請書の検索のパラメータ
     */
    public static TokuteifutanMybatisParam create施設情報パラメータ(RString 識別コード) {
        return new TokuteifutanMybatisParam(DaichoType.被保険者.getコード(), 識別コード);
    }

    /**
     * 介護事業者パラメータの作成します。
     *
     * @param 入所施設コード 識別コード
     * @return 介護保険特定負担限度額申請書の検索のパラメータ
     */
    public static TokuteifutanMybatisParam create介護事業者パラメータ(RString 入所施設コード) {
        return new TokuteifutanMybatisParam(RString.EMPTY, 入所施設コード);
    }

    /**
     * 介護除外住所地特例対象施設パラメータの作成します。
     *
     * @param 入所施設コード 識別コード
     * @return 介護保険特定負担限度額申請書の検索のパラメータ
     */
    public static TokuteifutanMybatisParam create介護除外住所地特例対象施設パラメータ(RString 入所施設コード) {
        return new TokuteifutanMybatisParam(JigyosyaType.住所地特例対象施設.getコード(), 入所施設コード);
    }

}
