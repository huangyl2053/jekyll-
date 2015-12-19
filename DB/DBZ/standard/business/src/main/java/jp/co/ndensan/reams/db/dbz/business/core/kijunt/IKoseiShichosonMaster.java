/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kijunt;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * リスト(市町村情報)の取得します
 *
 */
public interface IKoseiShichosonMaster {

    RString get市町村識別ID();

    LasdecCode get市町村コード();

    ShoKisaiHokenshaNo get証記載保険者番号();

    RString get国保連広域内市町村番号();

    RString get市町村名称();

    RString get都道府県名称();

    RString get郡名称();

    YubinNo get郵便番号();

    AtenaJusho get住所();

    TelNo get電話番号();

    RString get最優先地区コード();

    RString get帳票用都道府県名称表示有無();

    RString get帳票用郡名称表示有無();

    RString get帳票用市町村名称表示有無();

    RString get帳票用住所編集方法();

    RString get帳票用方書表示有無();

    RString get老人保健市町村番号();

    RString get老人保健受給者番号体系();

    RString get特徴分配集約();

    FlexibleDate get移行日();

    FlexibleDate get加入日();

    FlexibleDate get離脱日();

    RString get合併旧市町村区分();

    RString get合併旧市町村表示有無();

    RString get合併情報地域番号();

    ShoKisaiHokenshaNo get運用保険者番号();

    FlexibleDate get運用開始日();

    FlexibleDate get運用終了日();

    RString get運用形態区分();

}
