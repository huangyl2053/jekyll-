/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 「認定調査結果登録1」の画面情報クラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinnteiChousaKekkaTouroku1RelateJoho {

    private RString 調査区分;
    private RString 現在の概況調査場所;
    private RString 現在のサービス区分;
    private RString temp_認定調査回数;
    private ShinseishoKanriNo temp_申請書管理番号;
    private int temp_認定調査履歴番号;
    private RString temp_厚労省IF識別コード;
    private RString 調査場所;
    private RString 住宅改修;
    private RString 市町村特別給付TXT;
    private RString 介護保険給付以外の在宅サービスTXT;
    private List<NinnteiChousaKekkaTouroku1RowJoho> firstHalf;
    private List<NinnteiChousaKekkaTouroku1RowJoho> secondHalf;
    private List<NinnteiChousaKekkaTouroku1RowJoho> shisetsuList;
    private List<Integer> 介護給付サービス連番List;
    private List<Integer> 予防給付サービス連番List;
    private List<Integer> 施設利用連番List;

    private ArrayList<KihonChosaInput> 第1群List;
    private ArrayList<KihonChosaInput> 第2群List;
    private ArrayList<KihonChosaInput> 第3群List;
    private ArrayList<KihonChosaInput> 第4群List;
    private ArrayList<KihonChosaInput> 第5群List;
    private ArrayList<KihonChosaInput> 第6群List;
    private ArrayList<KihonChosaInput> 第7群List;

    private Code 認定調査依頼区分コード;
    private int 認定調査回数;
    private FlexibleDate 認定調査実施年月日;
    private FlexibleDate 認定調査受領年月日;
    private Code 認定調査区分コード;
    private JigyoshaNo 認定調査委託先コード;
    private RString 認定調査員コード;
    private Code 認定調査実施場所コード;
    private RString 認定調査実施場所名称;
    private Code 認定調査_サービス区分コード;
    private RString 利用施設名;
    private AtenaJusho 利用施設住所;
    private TelNo 利用施設電話番号;
    private YubinNo 利用施設郵便番号;
    private RString 特記;
    private FlexibleDate 認定調査特記事項受付年月日;
    private FlexibleDate 認定調査特記事項受領年月日;
}
