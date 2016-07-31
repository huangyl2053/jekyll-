/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshiharaiuchiwake;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBE622004_主治医意見書作成料支払内訳確認書のEntityです。
 *
 * @reamsid_L DBE-1980-047 xuyongchao
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenShiharaiuchiwakeEntity {

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
    private RString 医療機関;
    private RString 代表者名;
    private RString 名称付与;
    private RString バーコード;
    private RString その他;
    private RString ページ番号2;
    private RString 帳票タイトル;
    private RString 通知文1;
    private RString 合計金額;
    private RString 対象期間;
    private RString 件数;
    private RString 振込予定日;
    private RString 金融機関;
    private RString 支店;
    private RString 口座名義人;
    private RString 口座種別;
    private RString 口座番号;
    private RString 明細番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 内訳住所;
    private RString 金額;
    private RString 通知文2;
    private RString 医療機関コード;
    private int count;
    private int layoutBreakItem;
}
