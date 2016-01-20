/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.shinsakaiKaisaiKekka;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定審査会開催結果登録のヘッドエリア内容Entity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiKaisaiYoteiJohoEntity {

    private RString 審査会名称;
    private int 合議体番号;
    private RString 合議体名称;
    private int 予定人数;
    private int 実施人数;
    private RString 介護認定審査会開催場所名称;
    private FlexibleDate 開催予定日;
    private RString 予定開始時間;
    private RString 予定終了時間;
    private FlexibleDate 開催日;
    private RString 開催開始時間;
    private RString 開催終了時間;
    private int 所要時間;
    private RString 開催会場;

}
