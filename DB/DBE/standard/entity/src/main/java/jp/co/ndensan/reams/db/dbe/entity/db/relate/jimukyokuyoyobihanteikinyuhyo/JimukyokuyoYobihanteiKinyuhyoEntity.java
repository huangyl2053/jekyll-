/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.jimukyokuyoyobihanteikinyuhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局用予備判定記入表Entityクラスです。
 *
 * @reamsid_L DBE-0150-100 wangrenze
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JimukyokuyoYobihanteiKinyuhyoEntity {

    private RString 作成年月日;
    private RString 頁番号;
    private RString 審査会開催番号;
    private RString 開催年月日;
    private RString 開催時;
    private RString 開催分;
    private RString 合議体名称;
    private RString 予備判定一覧;
    private RString no;
    private RString 保険者;
    private RString 申請区分;
    private RString 被保険者番号;
    private RString 氏名;
    private RString 性別;
    private RString 年齢;
    private RString 前回二次判定;
    private RString 前回認定有効期間;
    private RString 一次判定;
    private RString 二次判定;
    private RString 状態像;
    private RString 認定有効期間;
    private RString 特定疾病コード;
    private RString 特定疾病名称;
    private RString 一次判定警告コード;
    private RString 審査会意見等;

}
