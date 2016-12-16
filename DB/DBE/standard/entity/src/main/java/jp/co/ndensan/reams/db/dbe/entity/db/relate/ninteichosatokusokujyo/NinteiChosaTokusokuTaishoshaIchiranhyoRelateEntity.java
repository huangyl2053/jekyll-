/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosatokusokujyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査督促対象者一覧表の取得のEntityクラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
@Getter
@Setter
public class NinteiChosaTokusokuTaishoshaIchiranhyoRelateEntity {

    private LasdecCode temp_市町村コード;
    private RString temp_市町村名称;
    private RString temp_保険者番号;
    private RString temp_被保険者番号;
    private AtenaKanaMeisho temp_被保険者氏名カナ;
    private AtenaMeisho temp_被保険者氏名;
    private FlexibleDate temp_申請日;
    private FlexibleDate temp_督促状発行日;
    private JigyoshaNo temp_事業者コード;
    private RString temp_事業者名称;
    private RString temp_調査員氏名;
    private RString temp_事業者住所;
    private TelNo temp_事業者電話番号;
    private int 行番号;
}
