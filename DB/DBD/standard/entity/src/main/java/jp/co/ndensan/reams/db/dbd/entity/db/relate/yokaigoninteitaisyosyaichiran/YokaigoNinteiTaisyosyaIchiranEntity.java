/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteitaisyosyaichiran;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 要介護認定インターフェース情報Entityです。
 *
 * @reamsid_L DBD-1531-010 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiTaisyosyaIchiranEntity {

    private DbT4003YokaigoNinteiInterfaceEntity 要介護認定インターフェース情報Entity;

    private AtenaMeisho 被保険者氏名;
    private Code 取下区分コード;
    private Code 認定申請区分申請時コード;
    private Code 認定申請区分法令コード;
    private FlexibleDate 認定申請年月日;

    private ShinseishoKanriNo 受給者申請書管理番号;
    private HihokenshaNo 受給者被保険者番号;

    private FlexibleDate 二次判定年月日;
    private Code 二次判定要介護状態区分コード;
    private FlexibleDate 二次判定認定有効開始年月日;
    private FlexibleDate 二次判定認定有効終了年月日;

    private FlexibleDate 要介護認定一次判定年月日;
    private Code 要介護認定一次判定結果コード認知症加算;
    private YMDHMS 取込日時2;

}
