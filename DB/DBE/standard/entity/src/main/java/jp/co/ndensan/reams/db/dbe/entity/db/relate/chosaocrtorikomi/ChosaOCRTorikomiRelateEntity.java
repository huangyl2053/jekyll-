/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chosaocrtorikomi;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会審査結果登録（OCR)のEntityです。
 *
 * @reamsid_L DBE-1560-010 suguangjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaOCRTorikomiRelateEntity {

    private RString 審査会名称;
    private RString 合議体名称;
    private int 介護認定審査会割当済み人数;
    private int 介護認定審査会実施人数;
    private Code 介護認定審査会進捗状況;
    private RString 介護認定審査会開催場所名称;
    private Code 介護認定審査会開催地区コード;
    private FlexibleDate 介護認定審査会開催年月日;
    private RString 介護認定審査会開始時刻;
    private RString 介護認定審査会終了時刻;
    private int no;
    private RString 保険者;
    private ShinseishoKanriNo 申請書管理番号;
    private Code 厚労省IF識別コード;
    private FlexibleDate 認定申請年月日;
    private Code 認定申請区分申請時コード;
    private AtenaMeisho 被保険者氏名;
    private RString 被保険者番号;
    private RString 証記載保険者番号;
    private Code 要介護認定一次判定結果コード;
    private Code 二次判定要介護状態区分コード;
    private FlexibleDate 二次判定年月日;
    private FlexibleDate 二次判定認定有効終了年月日;
    private int 合議体番号;
    private RString 介護認定審査会開催予定場所コード;
    private RDateTime イメージ共有ファイルID;
}
