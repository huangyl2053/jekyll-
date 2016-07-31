/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshuruishikyugendogaku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7118SogoJigyoShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業種類情報Entityです。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyoShuruiEntity {

    private DbT7118SogoJigyoShuruiShikyuGendoGakuEntity 総合事業種類情報;
    private RString サービス種類名称;
}
