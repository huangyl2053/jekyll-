/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;

/**
 * DBCMNF1001-371_高額合算支給申請書情報作成のバッチ出力対象データです。
 *
 * @reamsid_L DBC-2630-030 sunqingzhu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanShikyushinseishoOutFileEntity implements Serializable {

    private DbWT3711KogakuGassanShinseishoTempEntity 高額合算申請書一時Entity;
    private DbWT1001HihokenshaTempEntity 被保険者一時Entity;
}
