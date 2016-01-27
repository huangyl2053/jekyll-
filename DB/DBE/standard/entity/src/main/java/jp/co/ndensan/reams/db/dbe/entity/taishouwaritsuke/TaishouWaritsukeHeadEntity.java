/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.taishouwaritsuke;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会対象者割付ヘッドエリア
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishouWaritsukeHeadEntity {

    private RString 審査会名称;
    private RString 合議体名称;
    private int 予定定員;
    private int 割付人数;
    private Code 進捗状況;
    private RString 介護認定審査会開催場所名称;
    private Code 地区コード;
    private FlexibleDate 開催予定日;
    private RString 予定開始時間;
    private RString 予定終了時間;
    private boolean 合議体精神科医存在フラグ;
}
