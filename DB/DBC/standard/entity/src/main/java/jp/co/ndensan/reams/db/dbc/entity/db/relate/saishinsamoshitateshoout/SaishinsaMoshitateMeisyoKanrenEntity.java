/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 名称取得の関連エンティティ。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaMoshitateMeisyoKanrenEntity {

    private DbWT1741SaishinsaMoshitateEntity 再審査申立;
    private DbT7056GappeiShichosonEntity 合併市町村;
    private DbT7051KoseiShichosonMasterEntity 構成市町村マスタ;
    private DbT7063KaigoJigyoshaShiteiServiceEntity サービス事業者;
    private DbT7060KaigoJigyoshaEntity 事業者;
    private DbT7130KaigoServiceShuruiEntity 介護サービス種類;
    private DbT7131KaigoServiceNaiyouEntity 介護サービス内容;
    private DbT7120TokuteiShinryoServiceCodeEntity 特定診療サービスコード;
    private DbT3062SaishinsaMoshitateEntity 再審査申立データ;

}
