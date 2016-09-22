/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120130;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H1KogakuGassanaJikofutangakuTempEntity;

/**
 * 高額合算自己負担額証明書情報取込ののマスタ登録です。
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJSaiSyoriJyunbiEntity {

    private DbT3070KogakuGassanJikoFutanGakuEntity 高額合算自己負担額entity;

    private DbWT37H1KogakuGassanaJikofutangakuTempEntity 高額合算自己負担額一時entity;
}
