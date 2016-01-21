/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;

/**
 * サービス提供証明書のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoJigyoshaReturnEntity implements Cloneable, Serializable {

    private DbT7060KaigoJigyoshaEntity entity;
}
