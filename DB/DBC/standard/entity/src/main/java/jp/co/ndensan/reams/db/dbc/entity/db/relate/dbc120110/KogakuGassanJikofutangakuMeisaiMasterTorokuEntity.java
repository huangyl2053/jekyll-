/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120110;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.DbWT37H2KogakuGassanaJikofutangakuMeisaiCsvEntity;

/**
 * 37J_高額合算自己負担額確認情報取込の明細マスタ登録エンティティです。
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJikofutangakuMeisaiMasterTorokuEntity {

    private DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity 高額合算自己負担額明細entity;

    private DbWT37H2KogakuGassanaJikofutangakuMeisaiCsvEntity 高額合算自己負担額一時明細entity;
}
