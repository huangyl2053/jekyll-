/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710080;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト(給付管理票)の受給者台帳のエンティティクラスです。
 *
 * @reamsid_L DBC-3096-020 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaDaichoKyufuKanriHyoEntity {

    private FlexibleYearMonth shinsaYM;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString kyufuKanrihyoShubetsuKubunCode;
    private RString kyufuKanrihyoMeisaiLineNo;
    private LasdecCode shichosonCode;
    private HihokenshaNo hihokenshaNo;
    private RString rirekiNo;
    private RString edaban;
    private Code jukyuShinseiJiyu;
    private boolean yoshienshaNinteiShinseiFlag;
    private FlexibleDate jukyuShinseiYMD;
    private Code yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private FlexibleDate ninteiYMD;
    private boolean kyuSochishaFlag;
    private Code minashiCode;
    private Code chokkinIdoJiyuCode;
    private RString no;
}
