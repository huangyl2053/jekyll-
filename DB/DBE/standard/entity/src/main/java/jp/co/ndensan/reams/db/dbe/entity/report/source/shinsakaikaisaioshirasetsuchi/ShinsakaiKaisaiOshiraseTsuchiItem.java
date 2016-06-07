/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会開催のお知らせのITEMです。
 *
 * @reamsid_L DBE-0150-110 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.Unusedprivate finalField")
public class ShinsakaiKaisaiOshiraseTsuchiItem {

    private RString 文書番号;
    private RString 発行日;
    private RString 宛名郵便番号;
    private RString 宛名住所;
    private RString 宛名機関名;
    private RString 宛名氏名;
    private RString 宛名名称付与;
    private RString 宛先;
    private RString 帳票名;
    private RString 電子公印;
    private RString 電子公印文字列;
    private RString 電子公印省略;
    private RString カスタマーバーコード;
    private RString ページ番号;
    private RString 認証者氏名公印掛けない;
    private RString 認証者氏名公印掛ける;
    private RString 認証者役職名;
    private RString 認証者役職名1行目;
    private RString 認証者役職名2行目;
    private RString 通知文1;
    private RString 通知文2;
    private RString 開催日時;
    private RString 開催会場;
    private RString 合議体;
    private RString 開催番号;
    private RString 開催日;
    private RString 開催時刻;
    private RString 合議体番号;
    private RString 会場;
    private RString 住所;
    private RString 電話番号;
    private RString 通知文3;
}
