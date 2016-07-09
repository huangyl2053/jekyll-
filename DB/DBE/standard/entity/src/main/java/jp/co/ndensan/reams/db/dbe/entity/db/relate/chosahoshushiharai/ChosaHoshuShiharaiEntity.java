/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahoshushiharai;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBE621003_認定調査報酬支払通知書のEntityです。
 *
 * @reamsid_L DBE-1980-041 xuyongchao
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaHoshuShiharaiEntity {

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
    private RString 調査機関;
    private RString 代表者名;
    private RString 名称付与;
    private RString バーコード;
    private RString その他;
    private RString ページ番号2;
    private RString 帳票タイトル;
    private RString 通知文1;
    private RString 対象期間;
    private RString 在宅新規件数;
    private RString 在宅新規単価税込;
    private RString 在宅新規合計;
    private RString 在宅再調査件数;
    private RString 在宅再調査単価税込;
    private RString 在宅再調査合計;
    private RString 施設新規件数;
    private RString 施設新規単価税込;
    private RString 施設新規合計;
    private RString 施設再調査件数;
    private RString 施設再調査単価税込;
    private RString 施設再調査合計;
    private RString その他の設定件数;
    private RString その他の単価税込;
    private RString その他の金額合計;
    private RString 合計金額;
    private RString 振込予定日;
    private RString 種別;
    private RString 番号;
    private RString 金融機関;
    private RString 名議人;
    private RString 通知文2;

}
