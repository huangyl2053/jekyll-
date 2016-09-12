/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴対象者同定（一括）（バッチ）のビジネス全件エンティティです。
 *
 * @reamsid_L DBB-1850-050 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoTaishoshaDoteiCombineEntity {

    private int id;
    private DbV1001HihokenshaDaichoEntity hihokensha;
    private DbV1002TekiyoJogaishaEntity jogaisha;
    private DbV1003TashichosonJushochiTokureiEntity tokurei;
    private DbV2001ChoshuHohoEntity choshuhoho;
    private DoteiIchijiEntity doteitemp;
}
