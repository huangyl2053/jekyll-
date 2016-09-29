/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.koza.YokinShubetsuPattern;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給不支給決定者一覧表Entityラクラスです。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanShikyuKetteiTsuchiIchiran {

    private RString 支給不支給区分;
    private RString 出力順1;
    private RString 出力順2;
    private RString 出力順3;
    private RString 出力順4;
    private RString 出力順5;
    private RString 改頁1;
    private RString 改頁2;
    private RString 改頁3;
    private RString 改頁4;
    private RString 改頁5;
    private int 帳票通番;
    private HihokenshaNo 被保険者番号;
    private RString 被保険者氏名;
    private RString 住所;
    private RString 支給申請整理番号;
    private FlexibleYear 対象年度;
    private int 履歴番号;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private RString 支給区分コード;
    private Decimal 自己負担総額;
    private Decimal 支給額;
    private RString 支払方法区分;
    private RString 支払場所;
    private FlexibleDate 支払期間開始年月日;
    private FlexibleDate 支払期間終了年月日;
    private RString 支払期間開始時間;
    private RString 支払期間終了時間;
    private RString 金融機関名称;
    private RString 支店名称;
    private YokinShubetsuPattern 預金種別;
    private RString 口座番号;
    private AtenaKanaMeisho 口座名義人カナ;
    private ShikibetsuCode 識別コード;
    private HokenshaNo 証記載保険者番号;
    private LasdecCode 市町村コード;
    private AtenaKanaMeisho 氏名５０音カナ;
    private ChoikiCode 町域コード;
    private GyoseikuCode 行政区コード;
    private YubinNo 郵便番号;

}
