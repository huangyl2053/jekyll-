/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.iinhoshushiharai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬支払通知書のHeadクラスです。
 *
 * @reamsid_L DBE-1980-030 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class Iinhoshushiharai {

    private RString 電子公印;
    private RString 発行日;
    private RString 認証者役職名;
    private RString 認証者役職名1;
    private RString 公印文字列;
    private RString 認証者役職名2;
    private RString 認証者氏名カナ;
    private RString 認証者氏名掛ける;
    private RString 公印省略;
    private RString 郵便番号;
    private RString 住所;
    private RString 審査機関;
    private RString 代表者名;
    private RString 名称付与;
    private RString バーコード;
    private RString その他;
    private RString ページ番号;
    private RString タイトル;
    private RString 通知文1;
    private RString 審査会委員氏名;
    private RString 報酬報償費;
    private RString 源泉所得税;
    private RString 差引支給額;
    private RString 費用弁償;
    private RString 合計;
    private RString 振込予定日;
    private RString 種別;
    private RString 番号;
    private RString 金融機関;
    private RString 名議人;
    private RString 対象期間;
    private RString 審査会出席回数;
    private RString 通知文2;
}
