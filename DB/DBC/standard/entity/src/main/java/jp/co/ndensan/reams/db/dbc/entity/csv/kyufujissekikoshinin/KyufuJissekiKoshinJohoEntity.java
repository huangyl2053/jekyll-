/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.entity.csv.kyufujissekikoshinin;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績更新結果情報取込のcsvEntity
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKoshinJohoEntity {
    
    private KyufuJissekiKoshinJohoControlCSVEntity controlCsvEntity;
    private List<KyufuJissekiKoshinJohoDataEntity> listDataEntity;
    
}
