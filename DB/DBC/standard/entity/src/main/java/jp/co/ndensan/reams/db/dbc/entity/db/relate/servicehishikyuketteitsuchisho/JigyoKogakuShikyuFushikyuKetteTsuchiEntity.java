/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業高額支給不支給決定通知一覧表帳票用エンティティクラスです。
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoKogakuShikyuFushikyuKetteTsuchiEntity implements Serializable {

    private RString テスト出力フラグ;
    private RString 帳票タイトル;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 並び順１;
    private RString 並び順２;
    private RString 並び順３;
    private RString 並び順４;
    private RString 並び順５;
    private RString 改頁１;
    private RString 改頁２;
    private RString 改頁３;
    private RString 改頁４;
    private RString 改頁５;
    private RString 作成日時;
    private RString 決定通知No;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 住所;
    private RString 郵便番号;
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
