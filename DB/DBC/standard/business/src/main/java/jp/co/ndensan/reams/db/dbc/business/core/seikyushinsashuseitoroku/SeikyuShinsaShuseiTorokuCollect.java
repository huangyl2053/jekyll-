/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.seikyushinsashuseitoroku;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * 住宅改修理由書作成手数料請求情報修正登録のEntityクラスです。
 *
 * @reamsid_L DBC-2870-010 zhangruitao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikyuShinsaShuseiTorokuCollect implements Serializable {

    private List<SeikyuShinsaShuseiTorokuBusiness> 事業者情報List;
}
