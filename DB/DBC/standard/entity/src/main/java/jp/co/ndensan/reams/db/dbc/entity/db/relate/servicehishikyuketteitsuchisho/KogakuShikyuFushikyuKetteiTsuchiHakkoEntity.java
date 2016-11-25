/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費支給（不支給）決定通知一覧表帳票用エンティティクラスです。
 *
 * @reamsid_L DBC-2000-080 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuShikyuFushikyuKetteiTsuchiHakkoEntity {

    private RString テスト印刷;
    private RString 作成日時;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 並び順1;
    private RString 並び順2;
    private RString 並び順3;
    private RString 並び順4;
    private RString 並び順5;
    private RString 改頁1;
    private RString 改頁2;
    private RString 改頁3;
    private RString 改頁4;
    private RString 改頁5;
    private RString 決定通知No;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 郵便番号;
    private RString 住所;
    private RString 提供年月;
    private RString 要介護度;
    private RString 認定開始日;
    private RString 認定終了日;
    private RString 受付年月日;
    private RString 決定年月日;
    private Decimal 本人支払額;
    private Decimal 支給額;
    private RString 支給_不支給_決定区分;
    private RString 資格喪失日;
    private RString 喪失事由;
    private RString 自動償還;
    private int 支給総件数;
    private Decimal 本人支給額合計;
    private Decimal 支給額給額合計;
    private RString 町域コード;
    private RString 行政区コード;
    private RString 氏名５０音カナ;
    private RString 証記載保険者番号;
    private RString 資格状態区分;
    private RString 連番;
}
