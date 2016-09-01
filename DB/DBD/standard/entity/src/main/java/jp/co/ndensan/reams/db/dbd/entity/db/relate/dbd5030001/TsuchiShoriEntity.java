/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5030001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・通知書発行Entityクラスです。
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsuchiShoriEntity {

    private RString 証記載保険者番号;
    private RString 市町村名称;
    private RString 被保険者番号;
    private AtenaMeisho 被保険者氏名;
    private FlexibleDate 認定申請年月日;
    private Code 認定申請区分申請時コード;
    private Code 認定申請区分法令コード;
    private ShinseishoKanriNo 申請書管理番号;
    private FlexibleDate 通知完了年月日;
    private FlexibleDate 認定結果通知書発行年月日;
    private FlexibleDate 区分変更通知書発行年月日;
    private FlexibleDate サービス変更通知書発行年月日;
    private FlexibleDate 認定却下通知書発行年月日;
    private FlexibleDate 認定取消通知書発行年月日;
}
