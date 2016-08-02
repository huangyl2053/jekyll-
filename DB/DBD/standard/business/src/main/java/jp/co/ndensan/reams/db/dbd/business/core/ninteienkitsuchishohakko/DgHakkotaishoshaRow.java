/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.ninteienkitsuchishohakko;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定延期通知発行 選択発行対象者一覧情報です。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DgHakkotaishoshaRow {

    private RString 申請書管理番号;
    private RDate 延期決定日;
    private RString 延期理由;
    private RDate 見込処理期間_開始;
    private RDate 見込処理期間_終了;
    private RDate 通知書発行日;

}
