/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.otheraddressledger;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例者台帳のエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OtherAddressLedgerEntity {

    private RString 印刷日時;
    private int ページ目;
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private FlexibleDate 生年月日;
    private RString 性別;
    private SetaiCode 世帯コード;
    private RString 識別コード;
    private AtenaKanaMeisho 氏名カナ;
    private RString 地区タイトル1;
    private ChikuCode 地区コード1;
    private AtenaMeisho 氏名;
    private RString 状態;
    private RString 電話番号タイトル;
    private RString 地区タイトル2;
    private ChikuCode 地区コード2;
    private RString 住所1;
    private RString 電話番号１;
    private RString 住所タイトル1;
    private RString 電話番号２;
    private RString 地区タイトル3;
    private ChikuCode 地区コード3;
    private RString 行政区タイトル;
    private ZenkokuJushoCode 住所コード;
    private GyoseikuCode 行政区コード;
    private ZenkokuJushoCode 前住所コード;
    private RString 住所2;
    private FlexibleDate 転入年月日;
    private RString 住所タイトル2;
    private FlexibleDate 転出年月日;
    private RString NO;
    private FillTypeFormatted 適用年月日;
    private FillTypeFormatted 適用届出年月日;
    private RString 他市町村住所地特例適用事由コード;
    private RString 他市町村住所地特例適用事由名称;
    private FillTypeFormatted 解除年月日;
    private FillTypeFormatted 解除届出年月日;
    private RString 他市町村住所地特例解除事由コード;
    private RString 他市町村住所地特例解除事由名称;
    private FillTypeFormatted 入所年月日;
    private FillTypeFormatted 退所年月日;
    private AtenaMeisho 事業者名称;
    private RString 事業者住所;
    private TelNo 電話番号;
    private YubinNo 郵便番号;
    private RString 保険者名称;
    private HihokenshaNo 他被保番号;

}
