/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gensenchoshudatasakusei;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 源泉徴収データ作成のRelateEntityクラスです。
 *
 * @reamsid_L DBE-2000-010 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GensenChoshuRelateEntity {

    private RString 介護認定審査会委員コード;
    private AtenaMeisho 介護認定審査会委員名;
    private Code 介護認定審査員資格コード;
    private RString 事業者名称;
    private RString 認定調査員コード;
    private RString 医療機関名称;
    private RString 主治医コード;
    private RString 機関名称;
    private RString その他機関コード;
    private YubinNo 郵便番号;
    private AtenaJusho 住所;
    private TelNo 電話番号;
    private TelNo 番号_FAX;
    private FlexibleDate 生年月日;
    private int 認定審査会報酬合計;
    private int その他随時報酬合計;
    private int 認定審査交通費等合計;
    private int 源泉徴収額;
    private int 合計;
}
