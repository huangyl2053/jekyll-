/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.shichosonsecurityjoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 構成市町村情報のクラスです。
 */
@Getter
@Setter
public class KoseiShichosonJoho {

    private RString 市町村識別ID;
    private LasdecCode 市町村コード;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 国保連広域内市町村番号;
    private RString 市町村名称;
    private RString 都道府県名称;
    private RString 郡名称;
    private YubinNo 郵便番号;
    private AtenaJusho 住所;
    private TelNo 電話番号;
    private RString 最優先地区コード;
    private RString 帳票用都道府県名称表示有無;
    private RString 帳票用郡名称表示有無;
    private RString 帳票用市町村名称表示有無;
    private RString 帳票用住所編集方法;
    private RString 帳票用方書表示有無;
    private RString gaikokujinHyojiHouhou;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号体系;
    private RString 特徴分配集約;
    private FlexibleDate 移行日;
    private FlexibleDate 加入日;
    private FlexibleDate 離脱日;
    private RString 合併旧市町村区分;
    private RString 合併旧市町村表示有無;
    private RString 合併情報地域番号;
    private ShoKisaiHokenshaNo 運用保険者番号;
    private FlexibleDate 運用開始日;
    private FlexibleDate 運用終了日;
    private RString 運用形態区分;

}
