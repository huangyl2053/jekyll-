/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会審査結果登録の対象者一覧内容検索情報RelateEntityクラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiKekkaTorokuIChiRanRelateEntity {

    private int 介護認定審査会審査順;
    private RString 証記載保険者番号;
    private RString 市町村名称;
    private RString 被保険者番号;
    private AtenaMeisho 被保険者氏名;
    private RString 被保険者区分コード;
    private Code 申請区分_申請時_コード;
    private Code 申請区分_法令_コード;
    private FlexibleDate 認定申請年月日;
    private Code 取下区分コード;
    private FlexibleDate 生年月日;
    private FlexibleDate 前回認定有効期間_終了;
    private Code 前回一次判定;
    private Code 要介護認定一次判定結果コード;
    private Code 二次判定要介護状態区分コード;
    private Code 前回二次判定要介護状態区分コード;
    private Code 判定結果コード;
    private FlexibleDate 二次判定年月日;
    private Code コード_２号特定疾病コード;
    private Code 要介護状態像例コード;
    private FlexibleDate 二次判定認定有効開始年月日;
    private FlexibleDate 二次判定認定有効終了年月日;
    private int 二次判定認定有効期間;
    private RString 審査会メモ;
    private RString 介護認定審査会意見;
    private RString 一次判定結果変更理由;
    private RString 審査会意見種類;
    private ShinseishoKanriNo 申請書管理番号;
    private Code 厚労省IF識別コード;
}
