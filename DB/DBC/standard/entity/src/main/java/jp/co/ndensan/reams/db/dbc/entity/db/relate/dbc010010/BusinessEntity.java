/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100029.JyuryoItakuKeiyakuKakuninShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100030.JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200013.JuryoIninShoninKakuninshoIchiranEntity;

/**
 * ビジネスEntityです。
 *
 * @reamsid_L DBC-1910-030 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BusinessEntity {

    private JyuryoItakuKeiyakuKakuninShoEntity 利用者向けEntity;
    private JyuryoItakuKeiyakuKakuninShoKeiyakuJigyoshayoEntity 事業者用Entity;
    private JuryoIninShoninKakuninshoIchiranEntity 一覧表Entity;

}
