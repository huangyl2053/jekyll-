/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshushiharai;

import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBE621002_主治医意見書作成報酬支払通知書のEntityです。
 *
 * @reamsid_L DBE-1980-040 xuyongchao
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiHoshuShiharaiEntity {

    private RString 電子公印;
    private RString 発行日;
    private RString 認証者役職名;
    private RString 認証者役職名1;
    private RString 公印文字列;
    private RString 認証者役職名2;
    private RString 認証者氏名カナ;
    private RString 認証者氏名掛ける;
    private RString 公印省略;
    private RString 主治医医療機関コード;
    private YubinNo 郵便番号;
    private RString 住所;
    private RString 医療機関;
    private RString 代表者名;
    private RString 名称付与;
    private RString バーコード;
    private RString その他;
    private RString 対象期間;
    private RString 在宅新規件数;
    private RString 在宅新規単価税込;
    private RString 在宅新規合計;
    private RString 在宅継続件数;
    private RString 在宅継続単価税込;
    private RString 在宅継続合計;
    private RString 施設新規件数;
    private RString 施設新規単価税込;
    private RString 施設新規合計;
    private RString 施設継続件数;
    private RString 施設継続単価税込;
    private RString 施設継続合計;
    private RString 検診料等の件数;
    private RString 検診料等の単価税込;
    private RString 検診料等の金額;
    private RString 合計金額;
    private RDateTime 振込予定日;
    private RString 種別;
    private RString 番号;
    private RString 金融機関;
    private RString 名議人;
    private RString イメージファイルパス;
    private RString ページ番号;
    private RString 通知文1;
    private RString 通知文2;
}
