/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sabisunaiyoutouruku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * サービス内容登録MyBatisParameterのクラスです。
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SabisuNaiyouTourukuMyBatisParameter {

    private final RString サービス種類コード;
    private final RString サービス項目コード;

    /**
     * コンストラクタです
     *
     * @param サービス種類コード RString
     * @param サービス項目コード RString
     */
    public SabisuNaiyouTourukuMyBatisParameter(
            RString サービス種類コード,
            RString サービス項目コード) {
        this.サービス種類コード = サービス種類コード;
        this.サービス項目コード = サービス項目コード;
    }
}
