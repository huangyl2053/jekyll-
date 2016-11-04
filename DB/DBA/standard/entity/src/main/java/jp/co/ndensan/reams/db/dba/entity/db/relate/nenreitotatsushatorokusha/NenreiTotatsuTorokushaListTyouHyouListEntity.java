/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushatorokusha;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年齢到達登録者リスト帳票用データリストEntity。
 *
 * @reamsid_L DBA-0570-020 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreiTotatsuTorokushaListTyouHyouListEntity {

    private RString 印刷日時;
    private RString 対象情報タイトル;
    private RString 市町村コード;
    private RString 市町村名;
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
    private RString 抽出期間From;
    private RString 抽出期間To;
    private RString 開始タイトル;
    private RString 終了タイトル;
    private RString 区分タイトル;
    private RString 異動情報タイトル1;
    private RString 異動情報タイトル2;
    private RString 異動情報タイトル3;
    private RString 開始年月日タイトル;
    private RString 終了年月日タイトル;
    private RString 異動情報タイトル4;
    private RString 異動情報タイトル5;
    private RString 異動情報タイトル6;
    private RString リスト上_世帯コード;
    private RString リスト上_被保険者カナ氏名;
    private RString リスト上_事由_左;
    private RString リスト上_異動年月日_左;
    private RString リスト上_届出年月日_左;
    private RString リスト上_開始年月日;
    private RString リスト上_事由_右;
    private RString リスト上_異動年月日_右;
    private RString リスト上_届出年月日_右;
    private RString リスト上_終了年月日;
    private RString リスト上_区分;
    private RString リスト上_異動情報1;
    private RString リスト上_異動情報2;
    private RString リスト上_異動情報3;
    private RString リスト_被保険者番号;
    private RString リスト下_識別コード;
    private RString リスト下_被保険者氏名;
    private RString リスト下_事由_左;
    private RString リスト下_異動年月日_左;
    private RString リスト下_届出年月日_左;
    private RString リスト下_開始年月日;
    private RString リスト下_事由_右;
    private RString リスト下_異動年月日_右;
    private RString リスト下_届出年月日_右;
    private RString リスト下_終了年月日;
    private RString リスト下_区分;
    private RString リスト下_異動情報4;
    private RString リスト下_異動情報5;
    private RString リスト下_異動情報6;
}
