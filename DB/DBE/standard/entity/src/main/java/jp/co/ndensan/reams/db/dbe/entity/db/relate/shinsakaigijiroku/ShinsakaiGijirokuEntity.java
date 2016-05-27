/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 介護認定審査会議事録Entityクラスです。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShinsakaiGijirokuEntity {

    private RDateTime 作成年月日;
    private ShinsakaiKekkaJohoRelateEntity 審査会審査結果等;
    private ShinsakaiKaisaiKekkaJohoEntity 審査会情報;
    private List<IinJohoRelateEntity> 委員情報;
    private int 未判定;
    private int 未審査;
    private int 一次判定を変更した件数;
    private int 審査会意見を付した件数;
}
