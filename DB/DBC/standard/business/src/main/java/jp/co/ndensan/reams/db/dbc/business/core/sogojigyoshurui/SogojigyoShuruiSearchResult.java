/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.sogojigyoshurui;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業種類支給限度額情報の取得結果です。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyoShuruiSearchResult implements Serializable {

    private SogoJigyoShuruiShikyuGendoGaku 要支援1;
    private SogoJigyoShuruiShikyuGendoGaku 要支援2;
    private SogoJigyoShuruiShikyuGendoGaku 二次予防;
    private RString サービス種類名称;

    /**
     * コンストラクタです。
     *
     * @param 要支援1 SogoJigyoShuruiShikyuGendoGaku
     * @param 要支援2 SogoJigyoShuruiShikyuGendoGaku
     * @param 二次予防 SogoJigyoShuruiShikyuGendoGaku
     * @param サービス種類名称 RString
     */
    public SogojigyoShuruiSearchResult(SogoJigyoShuruiShikyuGendoGaku 要支援1,
            SogoJigyoShuruiShikyuGendoGaku 要支援2,
            SogoJigyoShuruiShikyuGendoGaku 二次予防,
            RString サービス種類名称) {
        this.要支援1 = 要支援1;
        this.要支援2 = 要支援2;
        this.二次予防 = 二次予防;
        this.サービス種類名称 = サービス種類名称;
    }
}
