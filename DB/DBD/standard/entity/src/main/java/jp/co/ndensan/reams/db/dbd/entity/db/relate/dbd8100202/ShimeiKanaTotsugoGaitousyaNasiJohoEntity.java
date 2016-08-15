/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 氏名カナ突合_該当者なし情報_登録SQL検索結果Entityクラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShimeiKanaTotsugoGaitousyaNasiJohoEntity {

    private RString DTレコード区分;
    private RString DT市町村コード;
    private RString DT年金保険者コード;
    private RString DT通知内容コード;
    private RString DT予備1;
    private RString DT制度コード;
    private RString DT作成年月日;
    private RString DT基礎年金番号;
    private RString DT年金コード;
    private RString DT予備2;
    private RString DT生年月日;
    private RString DT性別;
    private RString DTカナ氏名;
    private RString DTシフトコード1;
    private RString DT漢字氏名;
    private RString DTシフトコード2;
    private RString DT郵便番号;
    private RString DTカナ住所;
    private RString DTシフトコード3;
    private RString DT漢字住所;
    private RString DTシフトコード4;
    private RString DT対象年;
    private RString DT訂正表示;
    private RString DT各種区分;
    private RString DT処理結果;
    private RString DT予備3;
    private RString DT予備4;
    private RString DT金額1;
    private RString DT金額予備1;
    private RString DT金額予備2;
    private RString DT予備5;
    private RString DT共済年金証書記号番号;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private RString 世帯コード;
    private RString 宛名カナ氏名;
    private RString 宛名生年月日;
    private RString 宛名性別;
    private int 件数;
}
