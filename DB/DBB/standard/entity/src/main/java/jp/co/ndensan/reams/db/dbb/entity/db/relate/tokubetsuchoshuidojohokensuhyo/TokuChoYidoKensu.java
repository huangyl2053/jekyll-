/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuidojohokensuhyo;

import jp.co.ndensan.reams.ue.uex.definition.core.NenkinHokenshaCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBPR82001_4_特別徴収異動情報件数表Entity
 *
 * @reamsid_L DBB-1840-090 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuChoYidoKensu {

    private NenkinHokenshaCode 特別徴収義務者コードLeft;
    private NenkinHokenshaCode 特別徴収義務者コードRight;
    private LasdecCode 構成市町村コード;
    private int 資格件数Left;
    private int 資格件数Right;
    private int 件数Left;
    private int 件数Right;
    private int 仮徴収額変更件数Left;
    private int 仮徴収額変更件数Right;
    private int 住所地特例件数Left;
    private int 住所地特例件数Right;
    private int 追加依頼件数Left;
    private int 追加依頼件数Right;
    private RString 年金保険者名称;
    private RString 市町村名称;

}
