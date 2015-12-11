/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.HihokenshaDaichoSakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 *
 * @author soft863
 */
@lombok.Getter
@lombok.Setter
public class HihokenshaEntity {

    private FlexibleDate printDate;
    private RString page;
    private RString title;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private RString hihokenshaNoTitle;
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private KaigoJigyoshaNo jigyoshaNo;
    private AtenaMeisho jigyoshaMeisho;
    private RString iryoHokenShubetsuCode;
    private RString iryoHokenshaMeisho;
    private RString iryoHokenKigoNo;
    private RString orderNo;
    private List<DbT1001HihokenshaDaichoEntity> DbT1001HihokenshaDaichoEntityList;
    //生活保護受給者Entityリスト
    // TODO
    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> DbT7006RoreiFukushiNenkinJukyushaEntityList;
    private List<DbT7037ShoKofuKaishuEntity> DbT7037ShoKofuKaishuEntityList;
    //世帯一覧Entityリスト
    //TODO

}
