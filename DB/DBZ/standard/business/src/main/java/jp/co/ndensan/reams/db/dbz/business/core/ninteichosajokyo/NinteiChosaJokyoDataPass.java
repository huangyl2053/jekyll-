/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データパッシング用認定調査状況のBusinessクラスです
 *
 * @reamsid_L DBZ-1330-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaJokyoDataPass implements Serializable {

    private static final long serialVersionUID = -5218551860330526483L;
    private RString 認定調査員コード;
    private RString 調査員氏名;
    private RString 認定調査委託先コード;
    private RString 事業者名称;
    private YubinNo 認定郵便番号;
    private RString 認定住所;
    private TelNo 認定電話番号;
    private FlexibleDate 認定調査依頼年月日;
    private FlexibleDate 認定調査予定年月日;
    private FlexibleDate 認定調査実施年月日;
    private RString 調査委託区分;
    private AtenaMeisho 訪問調査先名称;
    private YubinNo 訪問調査先郵便番号;
    private AtenaJusho 訪問調査先住所;
    private TelNo 訪問調査先電話番号;
    private RString 主治医コード;
    private RString 主治医氏名;
    private RString 主治医医療機関コード;
    private RString 医療機関名称;
    private YubinNo 主治医郵便番号;
    private RString 主治医住所;
    private TelNo 主治医電話番号;
    private FlexibleDate 主治医意見書作成依頼年月日;
    private FlexibleDate 主治医意見書登録予定年月日;
    private FlexibleDate 主治医意見書記入年月日;
    private boolean 指定医フラグ;
    private Code 要介護認定一次判定結果コード;
    private FlexibleDate 要介護認定一次判定年月日;
    private Code 要介護認定一次判定結果コード_認知症加算;
    private RDate 介護認定審査会資料作成年月日;
    private RDate 認定審査会予定年月日;
    private RDate 二次判定年月日;
    private Code 二次判定要介護状態区分コード;
    private int 二次判定認定有効期間;
    private FlexibleDate 二次判定認定有効開始年月日;
    private FlexibleDate 二次判定認定有効終了年月日;
    private RDate 延期通知発行年月日;
    private int 延期通知発行回数;
    private ShinseishoKanriNo 申請書管理番号;
    private LasdecCode 市町村コード;
    private Code 厚労省IF識別コード;
}
