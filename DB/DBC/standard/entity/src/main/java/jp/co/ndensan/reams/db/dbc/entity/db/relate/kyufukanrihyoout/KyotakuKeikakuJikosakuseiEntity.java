/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;

/**
 * 居宅給付計画自己作成のEntity
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KyotakuKeikakuJikosakuseiEntity implements Serializable {

    private DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity 居宅給付計画自己作成短期入所利用日数entity;
    private List<KyotakuKeikakuJikosakuseiKanriTempEntity> 居宅給付計画自己作成管理entity;

}
