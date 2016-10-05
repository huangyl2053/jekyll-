/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassan;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangaku.DbWT37K1KogakuGassanJikoFutanGakuTempEntity;

/**
 * 高額合算補正済自己負担額情報作成のバッチ出力対象データです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyuturyokuEntity implements Serializable {

    private DbWT37K1KogakuGassanJikoFutanGakuTempEntity 高額合算自己負担額一時Entity;
    private DbWT1001HihokenshaTempEntity 被保険者一時Entity;
    private DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 高額合算自己負担額明細;
}
