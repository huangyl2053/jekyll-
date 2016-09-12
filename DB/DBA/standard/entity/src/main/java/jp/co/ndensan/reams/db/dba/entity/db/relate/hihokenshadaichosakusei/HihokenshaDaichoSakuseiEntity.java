/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokenshadaichosakusei.SeikatsuHogoJukyushaDivisionEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳のエンティティクラスです。
 *
 * @reamsid_L DBA-0500-010 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDaichoSakuseiEntity {

    private RString printDate;
    private RString page;
    private RString title;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private RString hihokenshaNoTitle;
    private HihokenshaNo hihokenshaNo;
    private AtenaKanaMeisho kanaMeisho;
    private RString seinengappiYMD;
    private RString seibetsuCode;
    private SetaiCode setaiCode;
    private ShikibetsuCode shikibetsuCode;
    private AtenaMeisho meisho;
    private RString state;
    private RString chikucodeTitle1;
    private ChikuCode chikuCode1;
    private RString chikucodeTitle2;
    private ChikuCode chikuCode2;
    private RString chikucodeTitle3;
    private ChikuCode chikuCode3;
    private RString telephoneNoTitle;
    private RString telephoneNo1;
    private RString telephoneNo2;
    private RString jushoTitle;
    private RString jusho;
    private RString zenkokuJushoCode;
    private RString gyoseikuTitle;
    private GyoseikuCode gyoseikuCode;
    private RString jigyoshaNo;
    private AtenaMeisho jigyoshaMeisho;
    private RString iryoHokenShubetsu;
    private RString iryoHokenshaMeisho;
    private RString iryoHokenKigoNo;
    private RString orderNo;
    private RString sochiHokensha;
    private RString kyuHokensha;
    private HihokenshaDaichoDivisionEntity 資格異動情報Entity;
    private SeikatsuHogoJukyushaDivisionEntity 生活保護情報Entity;
    private RoreiFukushiNenkinJukyushaDivisionEntity 老齢福祉情報Entity;
    private ShoKofuKaishuDivisionSumEntity 被保険者証発行履歴情報１;
    private ShoKofuKaishuDivisionSumEntity 被保険者証発行履歴情報２;
    private RString setaiName1;
    private RString setaiName2;
    private RString setaiName3;
    private RString setaiName4;
    private RString setaiName5;
    private SetaiLeftEntity 世帯左情報;
    private SetaiRightEntity 世帯右情報;
}
