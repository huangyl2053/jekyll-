/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者のエンティティクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaEntity {

    private RString printDate;
    private RString page;
    private RString title;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private RString hihokenshaNoTitle;
    private HihokenshaNo hihokenshaNo;
    private AtenaKanaMeisho kanaMeisho;
    private FlexibleDate seinengappiYMD;
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
    private AtenaJusho jusho;
    private ZenkokuJushoCode zenkokuJushoCode;
    private RString gyoseikuTitle;
    private GyoseikuCode gyoseikuCode;
    private RString jigyoshaNo;
    private AtenaMeisho jigyoshaMeisho;
    private RString iryoHokenShubetsu;
    private RString iryoHokenshaMeisho;
    private RString iryoHokenKigoNo;
    private RString orderNo;
    private List<DbT1001HihokenshaDaichoEntity> dbT1001HihokenshaDaichoEntityList;
    private List<ShisetsuNyutaishoEntity> shisetsuNyutaishoEntityList;
    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> dbT7006RoreiFukushiNenkinJukyushaEntityList;
    private List<DbT7037ShoKofuKaishuEntity> dbT7037ShoKofuKaishuEntityList;
    // TODO 蘇広俊 世帯情報取得方針不明、QA170提出中
}
