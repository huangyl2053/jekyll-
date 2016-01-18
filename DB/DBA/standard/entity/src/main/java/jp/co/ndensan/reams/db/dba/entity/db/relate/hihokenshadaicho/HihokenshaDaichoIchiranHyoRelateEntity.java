/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 広住特適用情報のエンティティクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class HihokenshaDaichoIchiranHyoRelateEntity {

    private RDate 作成日付;
    private int ページ数;
    private LasdecCode 市町村ID;
    private RString 市町村名称;
    private RString 並び順;
    private RString 改頁;
    private HihokenshaNo 被保険者番号;
    private AtenaKanaMeisho 氏名カナ;
    private AtenaMeisho 氏名;
    private RString 性別;
    private RString 年齢;
    private RString 生年月日;
    private GyoseikuCode 行政区;
    private RString 住所;
    private YubinNo 郵便番号;
    private ShikibetsuCode 識別コード;
    private SetaiCode 世帯コード;
    private RString 状態区分;
    private RString 資格区分;
    private RString 生保;
    private RString 老福;
    private RString 備考;
    private int リストNO;

}
