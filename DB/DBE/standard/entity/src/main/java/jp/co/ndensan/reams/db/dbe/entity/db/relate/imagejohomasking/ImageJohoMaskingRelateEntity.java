/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.imagejohomasking;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ情報マスキングRelateEntityクラスです。
 *
 * @reamsid_L DBE-1620-010 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImageJohoMaskingRelateEntity {

    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private AtenaMeisho 被保険者氏名;
    private FlexibleDate 認定申請年月日;
    private Code 認定申請区分_申請時コード;
    private FlexibleDate 介護認定審査会開催予定年月日;
    private FlexibleDate 主治医意見書受領年月日;
    private FlexibleDate 認定調査受領年月日;
    private FlexibleDate 要介護認定一次判定年月日;
    private int 認定調査依頼履歴番号;
    private int 主治医意見書作成依頼履歴番号;
    private ShinseishoKanriNo 申請書管理番号;
    private LasdecCode 市町村コード;
    private RString 認定調査特記事項番号;
    private int 認定調査特記事項連番;
    private Code 帳票ID;
    private int 取込みページ番号;
    private int 認定申請年;
    private RDateTime イメージ共有ファイルID;
    private RString マスク区分;
    private RString イメージ区分;
    private RString 特記事項;
}
