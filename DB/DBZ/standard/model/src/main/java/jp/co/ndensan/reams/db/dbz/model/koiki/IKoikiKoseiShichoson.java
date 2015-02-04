/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.koiki;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域構成市町村のインターフェースです。<br/>
 * （※別チケットで対応）
 */
public interface IKoikiKoseiShichoson {

    RString get市町村識別ID();

    LasdecCode get市町村コード();

    ShoKisaiHokenshaNo get証記載保険者番号();

    RString get市町村名称();

    FlexibleDate get加入日();

    FlexibleDate get離脱日();

    RString get合併旧市町村区分();

    RString get合併旧市町村表示有無();

    RString get合併情報地域番号();
}
