/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;

/**
 * サービス提供証明書のオブジェクトクラスです。
 *
 * @reamsid_L DBC-1010-180 panhe
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoJigyoshaReturnEntity implements Serializable {

    private DbT7060KaigoJigyoshaEntity entity;
}
