/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;

/**
 * 高額合算支給申請書情報作成の送付ファイル作成用Entityです。
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShinseishoSofuFileEntity implements Serializable {

    private DbWT3711KogakuGassanShinseishoTempEntity 高額合算申請書一時;
    private DbWT1001HihokenshaTempEntity 被保険者一時;
    private DbT3069KogakuGassanShinseishoKanyurekiEntity 高額合算申請書加入歴;
    private TokuteiKozaRelateEntity 口座;

}
