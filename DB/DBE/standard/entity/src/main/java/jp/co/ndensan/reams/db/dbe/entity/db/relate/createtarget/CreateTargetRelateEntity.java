/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.createtarget;

import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * センター送信データ出力のEntityです。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CreateTargetRelateEntity {

    private RString 証記載保険者番号;
    private RString 市町村名称;
    private RString 被保険者番号;
    private AtenaMeisho 被保険者氏名;
    private AtenaKanaMeisho 被保険者氏名カナ;
    private Code 性別;
    private FlexibleDate 生年月日;
    private FlexibleDate 認定申請年月日;
    private Code 認定申請区分_申請時コード;
    private Code 認定申請区分_法令コード;
    private RString 申請書管理番号;
    private Code 厚労省IF識別コード;
    private FlexibleDate 送信年月日;
    private RString 状態区分コード;
    private int 認定有効期間;
    private FlexibleDate 認定有効開始年月日;
    private FlexibleDate 認定有効終了年月日;
    private int 連番;
    private RString 項目;
}
