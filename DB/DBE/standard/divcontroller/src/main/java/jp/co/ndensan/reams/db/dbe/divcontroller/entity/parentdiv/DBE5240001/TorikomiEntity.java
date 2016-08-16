/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会審査結果登録（OCR)CSVファイルの項目のクラスです。
 *
 * @reamsid_L DBE-1560-010 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorikomiEntity implements Serializable {

    private static final long serialVersionUID = 5345660945759531003L;

    private int 項目数;
    private RString OK_NG;
    private RString ID1;
    private RString 審査会開催番号;
    private RString 審査会開催日;
    private RString 開催開始時間;
    private RString 開催終了時間;
    private RString 実施人数;
    private RString 審査員コード1;
    private RString 審査員1出席状況;
    private RString 審査員1審査員長フラグ;
    private RString 審査員コード2;
    private RString 審査員2出席状況;
    private RString 審査員2審査員長フラグ;
    private RString 審査員コード3;
    private RString 審査員3出席状況;
    private RString 審査員3審査員長フラグ;
    private RString 審査員コード4;
    private RString 審査員4出席状況;
    private RString 審査員4審査員長フラグ;
    private RString 審査員コード5;
    private RString 審査員5出席状況;
    private RString 審査員5審査員長フラグ;
    private RString 審査員コード6;
    private RString 審査員6出席状況;
    private RString 審査員6審査員長フラグ;
    private RString 審査員コード7;
    private RString 審査員7出席状況;
    private RString 審査員7審査員長フラグ;
    private RString 審査員コード8;
    private RString 審査員8出席状況;
    private RString 審査員8審査員長フラグ;
    private RString ID2;
    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 非該当;
    private RString 要支援1;
    private RString 要支援2;
    private RString 要介護1;
    private RString 要介護2;
    private RString 要介護3;
    private RString 要介護4;
    private RString 要介護5;
    private RString 状態像1;
    private RString 状態像2;
    private RString 再調査;
    private RString 取下げ;
    private RString 認定有効期間;
    private FlexibleDate 申請日;
    private Code 申請区分;
    private AtenaMeisho 被保険者氏名;
    private Code 一次判定結果;
    private RDateTime イメージ共有ファイルID;

    private int no;
    private RString 保険者;
    private ShinseishoKanriNo 申請書管理番号;
    private Code 厚労省IF識別コード;
    private RString dbt5101_被保険者番号;
    private RString 証記載保険者番号;
    private Code 二次判定要介護状態区分コード;
    private FlexibleDate 二次判定年月日;
    private FlexibleDate 二次判定認定有効終了年月日;
    private int 合議体番号;
    private RString 介護認定審査会開催予定場所コード;
}
