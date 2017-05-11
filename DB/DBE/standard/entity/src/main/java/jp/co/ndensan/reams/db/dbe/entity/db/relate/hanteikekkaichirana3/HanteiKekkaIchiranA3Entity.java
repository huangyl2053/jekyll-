/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichirana3;

import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定判定結果一覧表Ａ３版のEntityです。
 *
 * @reamsid_L DBE-0180-030 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanteiKekkaIchiranA3Entity {

    private RString title;
    private RDateTime printTimeStamp;
    private int 介護認定審査会審査順;
    private RString 市町村名称;
    private RString 証記載保険者番号;
    private RString 被保険者氏名;
    private RString 被保険者番号;
    private RString 生年月日;
    private RString 性別;
    private RString 認定申請日;
    private RString 二次判定年月日;
    private RString 被保険者区分;
    private RString 認定申請区分_申請時;
    private RString 認定申請区分_法令;
    private RString tb_一次判定結果;
    private RString tb_一次判定結果_加算;
    private RString tb_二次判定要介護状態区分;
    private RString 一次判定結果;
    private RString 一次判定結果_加算;
    private RString 二次判定要介護状態区分;
    private RString 要介護状態像例コード;
    private RString 状態像内容;
    private RString tb_二次判定認定有効開始日;
    private RString tb_二次判定認定有効終了日;
    private int tb_二次判定認定有効期間;
    private RString 二次判定認定有効開始年月日;
    private RString 二次判定認定有効終了年月日;
    private int 二次判定認定有効期間;
    private RString 二号特定疾病コード;
    private RString 二号特定疾病内容;
    private RString 介護認定審査会意見;
    private int 合議体番号;
    private int 当前頁;
    private int 総頁;
    private int 項番;
    private RString 出力対象;
    private RString 審査会開催番号;
    private RString 厚労省IF識別コード;
    private RString tb_厚労省IF識別コード;
}
