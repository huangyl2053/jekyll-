/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護事業者TBLと識別番号管理TBLと給付実績一時TBL結びついたエンティティ。
 *
 * @reamsid_L DBC-2470-010 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoshaMeisyoAndShikibetsuNoKanrenEntity {
    
    private DbWT1111KyufuJissekiEntity 給付実績;
    private List<DbT7060KaigoJigyoshaEntity> 介護事業者List;
    private DbT3118ShikibetsuNoKanriEntity 識別番号;
}
