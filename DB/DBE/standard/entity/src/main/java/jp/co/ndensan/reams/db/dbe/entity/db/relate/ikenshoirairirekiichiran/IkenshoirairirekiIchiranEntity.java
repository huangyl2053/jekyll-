/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成依頼(手動)_主治医意見書依頼該当者履歴一覧のクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoirairirekiIchiranEntity {

    private RString chokkinKubun;
    private HihokenshaNo hihokenshaNo;
    private AtenaKanaMeisho hihokenshaKana;
    private AtenaKanaMeisho hihokenshaName;
    private AtenaJusho jusho;
    private RString iryoKikanMeisho;
    private RString shujiiName;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code ikenshoSakuseiKaisuKubun;
}
