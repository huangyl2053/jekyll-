/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaatenaayouhou;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名取得PSM取得Entityクラスです。
 *
 * @reamsid_L DBC-4350-110 chenhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaAtenaJyouhouEntity {

    private FlexibleDate 生年月日;
    private RString 性別コード;
    private RString カナ名称;

}
