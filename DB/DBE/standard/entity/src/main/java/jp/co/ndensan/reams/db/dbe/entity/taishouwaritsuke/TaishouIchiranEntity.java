/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.taishouwaritsuke;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会対象者割付対象者一覧エリア
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishouIchiranEntity {

    private int 介護認定審査会審査順;
    private boolean 介護認定審査会審査順確定フラグ;
    private Code 介護認定審査会優先振分区分コード;
    private RString 被保険者番号;
    private AtenaKanaMeisho 被保険者氏名;
    private Code 性別;
    private RString 被保険者区分コード;
    private Code 認定申請区分_申請時コード;
    private FlexibleDate 認定申請年月日;
    private FlexibleDate 前回認定有効期間_開始;
    private FlexibleDate 前回認定有効期間_終了;
    private FlexibleDate 要介護認定一次判定年月日;
    private FlexibleDate マスキング完了年月日;
    private RString 市町村名称;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private Code 調査票_障害高齢者の日常生活自立度コード;
    private Code 調査票_認知症高齢者の日常生活自立度コード;
    private Code 意見書_障害高齢者の日常生活自立度コード;
    private Code 意見書_認知症高齢者の日常生活自立度コード;
    private RString 入所施設;
    private RString 事業者名称;
    private RString 調査員氏名;
    private int 再調査依頼回数;
    private RString 医療機関名称;
    private AtenaMeisho 主治医氏名;
    private ShinseishoKanriNo 申請書管理番号;

}
