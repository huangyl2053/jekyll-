/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc010020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100031.KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200013.JuryoIninShoninKakuninshoIchiranEntity;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成サービス用entityクラスです。
 *
 * @reamsid_L DBC-1970-060 zhouchuanlin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceEntity {

    private KogakuServiceHiJyuryoItakuKeiyakuKakuninShoEntity 介護保険高額Entity;
    private JuryoIninShoninKakuninshoIchiranEntity 一覧表Entity;
}
