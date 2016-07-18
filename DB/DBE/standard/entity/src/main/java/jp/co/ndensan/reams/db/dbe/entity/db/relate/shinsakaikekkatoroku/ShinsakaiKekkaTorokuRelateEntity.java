/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 介護認定審査会審査結果登録のヘッドエリア内容検索情報RelateEntityクラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiKekkaTorokuRelateEntity {

    private RString 開催番号;
    private RString 合議体名称;
    private int 介護認定審査会割当済み人数;
    private int 介護認定審査会実施人数;
    private RString 進捗状況;
    private RString 介護認定審査会開催場所名称;
    private Code 地区コード;
    private FlexibleDate 開催日;
    private RString 開催開始時間;
    private RString 開催終了時間;
    private boolean 合議体精神科医存在フラグ;

}
