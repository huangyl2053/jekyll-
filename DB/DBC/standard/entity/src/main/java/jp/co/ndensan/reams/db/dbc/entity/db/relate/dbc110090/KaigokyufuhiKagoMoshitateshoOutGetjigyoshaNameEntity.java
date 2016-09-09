/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 保険者番号取込Entityクラスです
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigokyufuhiKagoMoshitateshoOutGetjigyoshaNameEntity {

    private DbWT1731KagoMoshitateTempEntity dbWT1731Entity;
    private DbT7060KaigoJigyoshaEntity dbT7060Entity;

}
