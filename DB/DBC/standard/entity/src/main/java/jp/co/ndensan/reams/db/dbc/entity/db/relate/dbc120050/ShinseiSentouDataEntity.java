/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120050;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin.KyufuJissekiKoshinJohoCsvRecordKensuEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績更新結果情報取込の申請情報DataEntity
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseiSentouDataEntity {

    private KyufuJissekiKoshinJohoCsvRecordKensuEntity recordNumber;
    private ShinseiSentouCsvEntity sentouCsvEntity;
    private List<ShinseiJouhouCsvEntity> listCsvShinseiJouhouCsvEntity;

}
