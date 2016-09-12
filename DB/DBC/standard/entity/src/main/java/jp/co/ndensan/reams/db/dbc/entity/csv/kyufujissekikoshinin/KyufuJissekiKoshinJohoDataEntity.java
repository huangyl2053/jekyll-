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
 * 給付実績更新結果情報取込の申請情報DataEntity
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiKoshinJohoDataEntity {
    
    private KyufuJissekiKoshinJohoCsvRecordKensuEntity recordNumber;
    private KyufuJissekiKoshinJohoCsvKihonMeisaiOneEntity kihonMeisaiOneEntity;
    private KyufuJissekiKoshinJohoCsvKihonMeisaiTwoEntity kihonMeisaiTwoEntity;
    private KyufuJissekiKoshinJohoCsvKougakuKaigoMeisaiEntity kougakuKaigoMeisaiEntity;
    private List<KyufuJissekiKoshinJohoCsvTaisyogaiMeisaiEntity> listCsvTaisyogaiMeisaiEntity;
    
}
