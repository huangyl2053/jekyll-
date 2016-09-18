/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuidojohokensuhyo;

import jp.co.ndensan.reams.ue.uex.definition.core.NenkinHokenshaCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 帳票設計_DBBPR82001_4_特別徴収異動情報件数表Entity
 *
 * @reamsid_L DBB-1840-090 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuChoYidoKensu {

    private NenkinHokenshaCode 特別徴収義務者コード;
    private LasdecCode 構成市町村コード;
    private int 資格件数;
    private int 件数;
    private int 仮徴収額変更件数;
    private int 住所地特例件数;
    private int 追加依頼件数;

}
