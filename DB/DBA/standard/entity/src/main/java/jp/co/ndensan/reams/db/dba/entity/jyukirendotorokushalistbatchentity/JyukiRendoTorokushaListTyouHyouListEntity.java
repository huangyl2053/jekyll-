/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.jyukirendotorokushalistbatchentity;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住基連動登録者リスト帳票用データリストEntity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyukiRendoTorokushaListTyouHyouListEntity {

    private RString 印刷日時;
    private int ページ数;
    private RString 帳票タイトル;
    private RString 対象情報タイトル;
    private LasdecCode 市町村コード;
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
    private SetaiCode リスト上_世帯コード;
    private AtenaKanaMeisho リスト上_被保険者カナ氏名;
    private RString リスト上_事由;
    private RString リスト上_異動年月日;
    private RString リスト上_届出年月日;
    private RString リスト上_開始年月日;
    // TODO QA407
    private RString リスト上_事由_2;
    private RString リスト上_異動年月日_2;
    private RString リスト上_届出年月日_2;
    private RString リスト上_終了年月日;
    private RString リスト上_区分;
    private RString リスト上_異動情報1;
    private RString リスト上_異動情報2;
    private RString リスト上_異動情報3;
    private HihokenshaNo リスト_被保険者番号;
    private ShikibetsuCode リスト下_識別コード;
    private AtenaMeisho リスト下_被保険者氏名;
    private RString リスト下_事由;
    private RString リスト下_異動年月日;
    private RString リスト下_届出年月日;
    private RString リスト下_開始年月日;
    // TODO QA407
    private RString リスト下_事由_2;
    private RString リスト下_異動年月日_2;
    private RString リスト下_届出年月日_2;
    private RString リスト下_終了年月日;
    private RString リスト下_区分;
    private RString リスト下_異動情報4;
    private RString リスト下_異動情報5;
    private RString リスト下_異動情報6;

}
